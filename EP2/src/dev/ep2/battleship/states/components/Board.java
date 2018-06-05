package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.helpers.FileHelper;
import dev.ep2.battleship.helpers.HitBoxHelper;
import dev.ep2.battleship.states.MenuView;
import dev.ep2.battleship.targets.Target;

public class Board {

	public final int BOARD_RESOLUTION = 840;
	public final int BORDER = 300;

	private int numberOfTargetX, numberOfTargetY, targetWidth, targetHeight, targetShotX, targetShotY, selectedStrategy;
	private boolean isClickOnBoard, isStrategySelected, isPopUpVisible;
	private Handler handler;
	private HitBoxHelper hitbox;
	private MessagePopUp messagePopUp;
	private String alertMessage;
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
		
		//variaveis para verificar se é clicavel, e para definir qual bloco renderizar	
		
		if(LeftPanel.isSingleShotPressed || LeftPanel.isRadarPressed || LeftPanel.isShotInAreaPressed || LeftPanel.isAirstrikePressed) 
			isStrategySelected = true;
		
		gettingTheSelectedStrategy();
		
		System.out.print("selected strat = " + selectedStrategy);
		
		isClickOnBoard = hitbox.clickHitBox(300, 1140, 0, 840);
				
		if(isClickOnBoard && isStrategySelected) {
			setShot(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
			debitPoints(selectedStrategy);
		}
			
		//usar o Enter ao invés de clicar em Ok

		if(isStrategySelected && (hitbox.clickHitBox(0, 300, 0, 840) || hitbox.clickHitBox(1140, 1440, 0, 840))) {
			isPopUpVisible = true;
			alertMessage = "click on the board";
			//não desconta dinheiro!
		}
					
		System.out.println("strat: " + isStrategySelected + " onBoard: " + isClickOnBoard + " popup: " + isPopUpVisible);
		
			
	

			
	
		//hover e pressed do btnok tem que ser static lembrar
						
	}
	
	public void render(Graphics g) {
		
		
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				
				getTarget(x, y).render(g, x * targetWidth + BORDER, y * targetHeight, targetWidth, targetHeight);
			}
		}
		
		if(isPopUpVisible)
			isPopUpVisible = messagePopUp.makeWarningVisible(alertMessage, g);
		
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
		//isClickOnBoard = false;
	}
	
	private void debitPoints(int selectedStrategy) {
		
		if(selectedStrategy == 1)
			handler.getPlayer().setPoints(handler.getPlayer().getPoints() - 50); 
		if(selectedStrategy == 2)
			handler.getPlayer().setPoints(handler.getPlayer().getPoints() - 150); 
		if(selectedStrategy == 3)
			handler.getPlayer().setPoints(handler.getPlayer().getPoints() - 350); 
		if(selectedStrategy == 4)
			handler.getPlayer().setPoints(handler.getPlayer().getPoints() - 600); 
		
	}

	
	private void gettingTheSelectedStrategy() {
		
		if(LeftPanel.isSingleShotPressed)
			selectedStrategy = 1;
		if(LeftPanel.isRadarPressed)
			selectedStrategy = 2;
		if(LeftPanel.isShotInAreaPressed)
			selectedStrategy = 3;
		if(LeftPanel.isAirstrikePressed)
			selectedStrategy = 4;
	}
	
}
