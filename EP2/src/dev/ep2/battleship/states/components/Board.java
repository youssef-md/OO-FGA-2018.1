package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.helpers.FileHelper;
import dev.ep2.battleship.helpers.HitBoxHelper;
import dev.ep2.battleship.states.MenuView;
import dev.ep2.battleship.targets.Target;

public class Board {

	public final int BOARD_RESOLUTION = 840,  BORDER = 300;
	private final int SINGLE_SHOT_PRICE = 50, RADAR_PRICE = 150, SHOT_IN_AREA_PRICE = 400, AIRSTRIKE_PRICE = 600;
	private int numberOfTargetX, numberOfTargetY, targetWidth, targetHeight, targetShotX, targetShotY;
	private boolean isClickOnBoard, isStrategySelected = false, isPopUpVisible, isPointAvailable = true;
	private String alertMessage, selectedStrategy;
	private Handler handler;
	private HitBoxHelper hitbox;
	private MessagePopUp messagePopUp;
	
	private int[][] board;
	private int[][] ships;
	
	public Board(String path, Handler handler) {
		
		this.handler = handler;
		hitbox = new HitBoxHelper(handler);
		messagePopUp = new MessagePopUp(handler);
		loadAndSetTheBoard(path);
		targetWidth = BOARD_RESOLUTION / numberOfTargetX; // Responsiveness for the targets based on the given dimension 
		targetHeight = BOARD_RESOLUTION / numberOfTargetY; 

	}
	
	public void tick() {
		
		//System.out.println("points avail: " + isPointAvailable);
		
		checkIfUserSelectedAStrategy();
		gettingTheSelectedStrategy();
		isClickOnBoard = hitbox.clickHitBox(300, 1140, 0, 840);
		checkIfTheClickIsOutOfBoard();
		checkIfThereIsPointAvailable();
		checkIfTheUserCanShoot();
		checkIfItIsAValidShot();
		
		//System.out.println("popUp: " + isPopUpVisible +" ["+ selectedStrategy + "] : " + isStrategySelected + " avail: " + isPointAvailable + " board click: " + isClickOnBoard);
							
	}
	
	public void render(Graphics g) {
		
		renderTheBoard(g);
		if(isPopUpVisible) 
			isPopUpVisible = messagePopUp.makeWarningVisible(alertMessage, g);
	}
	
	
	private void renderTheBoard(Graphics g) {
		
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				
				getTarget(x, y).render(g, x * targetWidth + BORDER, y * targetHeight, targetWidth, targetHeight);
			}
		}
	}
	
 	private void loadAndSetTheBoard(String path) {
		
		String file = FileHelper.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); 
		
		numberOfTargetX = FileHelper.parseInt(tokens[0]);
		numberOfTargetY = FileHelper.parseInt(tokens[1]);
		
		board = new int[numberOfTargetX][numberOfTargetY];
		ships = new int[numberOfTargetX][numberOfTargetY];
		
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				
				ships[x][y] = FileHelper.parseInt(tokens[y + 2].charAt(x));
				board[x][y] = 0; // start the game with only blue targets
			}
		}
	}
	
	public Target getTarget(int x, int y) {
		
		 // passar o retorno mais pra baixo para que seja possível modificar a cor dos barcos
		
		Target target = Target.targets[board[x][y]]; //getting the respective Target based on the ID

		if(target == null)
			return Target.userTurnTarget;
		
		if(ships[x][y] != 0) 
			 return Target.targets[1];
		
		return target;
	}
	
	private void setShot(int x, int y) {
		
		//System.out.println("single shot: " +LeftPanel.isSingleShotPressed + " radar: " + LeftPanel.isRadarPressed + " area: " + LeftPanel.isShotInArea + " airstrike: " + LeftPanel.isAirstrikePressed);
		
		if(isStrategySelected) {
			targetShotX = (x - BORDER) / targetWidth;
			targetShotY = y / targetHeight;
			board[targetShotX][targetShotY] = 2;	
		}
		
		isStrategySelected = false;
		isClickOnBoard = false;
	}

	private void checkIfTheUserCanShoot() {
		
		if(isClickOnBoard && isStrategySelected && !isPointAvailable) {
			isPopUpVisible = true;
			alertMessage = "not enough points to buy this strategy";
			selectedStrategy = "";
			isStrategySelected = false;
			isPointAvailable = true;
		}
	}
	
	private void checkIfItIsAValidShot() {
		
		if(isClickOnBoard && isStrategySelected && isPointAvailable) {
			setShot(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
			debitPoints(selectedStrategy);
			selectedStrategy = "";
		}
	}
	
	private void debitPoints(String selectedStrategy) {
		
		if(selectedStrategy == "single_shot")
			handler.getPlayer().setPoints(handler.getPlayer().getPoints() - SINGLE_SHOT_PRICE); 
		if(selectedStrategy == "radar")
			handler.getPlayer().setPoints(handler.getPlayer().getPoints() - RADAR_PRICE); 
		if(selectedStrategy == "shot_in_area")
			handler.getPlayer().setPoints(handler.getPlayer().getPoints() - SHOT_IN_AREA_PRICE); 
		if(selectedStrategy == "airstrike")
			handler.getPlayer().setPoints(handler.getPlayer().getPoints() - AIRSTRIKE_PRICE); 
		
	}

	private void checkIfThereIsPointAvailable() {
		
		if(selectedStrategy == "single_shot")
			if((handler.getPlayer().getPoints()) < SINGLE_SHOT_PRICE) 
				isPointAvailable = false;
				
		if(selectedStrategy == "radar")
			if((handler.getPlayer().getPoints()) < RADAR_PRICE)
				isPointAvailable = false;
		
		if(selectedStrategy == "shot_in_area")
			if((handler.getPlayer().getPoints()) < SHOT_IN_AREA_PRICE)
				isPointAvailable = false;
		
		if(selectedStrategy == "airstrike")
			if((handler.getPlayer().getPoints()) < AIRSTRIKE_PRICE) 
				isPointAvailable = false;
		
	}
	
	private void gettingTheSelectedStrategy() {
		
		if(LeftPanel.isSingleShotPressed)
			selectedStrategy = "single_shot";
		if(LeftPanel.isRadarPressed)
			selectedStrategy = "radar";
		if(LeftPanel.isShotInAreaPressed)
			selectedStrategy = "shot_in_area";
		if(LeftPanel.isAirstrikePressed)
			selectedStrategy = "airstrike";
	}
	
	private void checkIfTheClickIsOutOfBoard() {
		
		if(isStrategySelected && (hitbox.clickHitBox(0, 300, 0, 840) || hitbox.clickHitBox(1140, 1440, 0, 840))) {
			isPopUpVisible = true;
			alertMessage = "click on the board";
			selectedStrategy = "";
			isStrategySelected = false;
		}
	}

	private void checkIfUserSelectedAStrategy() {
		
		if(LeftPanel.isSingleShotPressed || LeftPanel.isRadarPressed || LeftPanel.isShotInAreaPressed || LeftPanel.isAirstrikePressed) 
			isStrategySelected = true;
		
	}
}
