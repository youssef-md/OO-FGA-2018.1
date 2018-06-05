package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.helpers.FileHelper;
import dev.ep2.battleship.helpers.HitBoxHelper;
import dev.ep2.battleship.states.MenuView;
import dev.ep2.battleship.targets.Target;

public class Board {

	public final int BOARD_RESOLUTION = 840,  BORDER = 300;
	private final int SINGLE_SHOT_PRICE = 50, RADAR_PRICE = 150, SHOT_IN_AREA_PRICE = 400, AIRSTRIKE_PRICE = 600;
	private int numberOfTargetX, numberOfTargetY, targetWidth, targetHeight, targetShotX, targetShotY;
	private boolean isClickOnBoard, isStrategySelected = false, isPopUpVisible, isThereAShip = false, isPointAvailable = true, isAirStrike, isAirVerticalHover, isAirVertical, isAirHorizontalHover, isAirHorizontal;
	private String alertMessage, selectedStrategy;
	private Handler handler;
	private HitBoxHelper hitbox;
	private MessagePopUp messagePopUp;
	
	private int[][] board;
	private char[][] ships;
	private boolean[][] hover;
	private boolean[][] shots;
	private boolean[][] radar;
	
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
		if(isAirStrike)
			checkWhatIsTheAirStrikeDirection();
		isClickOnBoard = hitbox.clickHitBox(300, 1140, 0, 840);
		checkIfTheClickIsOutOfBoard();
		checkIfThereIsPointAvailable();
		checkIfTheUserCanShoot();
		checkIfItIsAValidShot();
		
		
		
		//System.out.println("MouseX = " + handler.getMouseManager().getMouseX() + " MouseY = " + handler.getMouseManager().getMouseY());
		//System.out.println("popUp: " + isPopUpVisible +" ["+ selectedStrategy + "] : " + isStrategySelected + " avail: " + isPointAvailable + " board click: " + isClickOnBoard);
							
	}
	
	public void render(Graphics g) {
			
		renderTheBoard(g);
		if(isPopUpVisible) 
			isPopUpVisible = messagePopUp.makeWarningVisible(alertMessage, g);
		
		if(isThereAShip)
			isThereAShip = messagePopUp.makeWarningVisible(alertMessage, g);

		if(isAirStrike)
			renderAirStrikeOption(g);
	}
	
	
	private void renderTheBoard(Graphics g) {
		
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {

				getTarget(x, y).render(g, x * targetWidth + BORDER, y * targetHeight, targetWidth, targetHeight);
				hoverGameplayHelper(x, y);
			}
		}
	}
	
	private void renderAirStrikeOption(Graphics g) {
		
		g.drawImage(Assets.filter, 0, 0, 1140, 840, null);
		
		if(!isAirVerticalHover)
			g.drawImage(Assets.btn_airstrike_vertical, 370, 320, 200, 200, null);
		else
			g.drawImage(Assets.btn_airstrike_vertical_pressed, 370, 320, 200, 200, null);
		
		if(!isAirHorizontalHover)
			g.drawImage(Assets.btn_airstrike_horizontal, 610, 320, 200, 200, null);
		else
			g.drawImage(Assets.btn_airstrike_horizontal_pressed, 610, 320, 200, 200, null);
		
		
	}
	
	private void hoverGameplayHelper(int x, int y) {
		
		
		if(selectedStrategy == "single_shot")  
			hoverForSingleShot(x, y);
		else if(selectedStrategy == "radar")
			hoverFor2x2Area(x, y);
		else if(selectedStrategy == "shot_in_area")
			hoverFor2x2Area(x, y);
		else if(selectedStrategy == "air_horz")
			hoverForAirStrikeHorz(x, y);
		else if(selectedStrategy == "air_vert")
			hoverForAirStrikeVert(x, y);
	}
	
  	private void loadAndSetTheBoard(String path) {
		
		String file = FileHelper.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); 
		
		numberOfTargetX = FileHelper.parseInt(tokens[0]);
		numberOfTargetY = FileHelper.parseInt(tokens[1]);
		
		board = new int[numberOfTargetX][numberOfTargetY];
		ships = new char[numberOfTargetX][numberOfTargetY];
		hover = new boolean[numberOfTargetX][numberOfTargetY];
		shots = new boolean[numberOfTargetX][numberOfTargetY];
		radar = new boolean[numberOfTargetX][numberOfTargetY];

		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				
				ships[x][y] = tokens[y + 2].charAt(x);
				board[x][y] = 0; // start the game with only blue targets
			}
		}
	}
  	
	
	public Target getTarget(int x, int y) {
		
			
		if(hover[x][y] == true)
			board[x][y] = 2;
		else
			board[x][y] = 0;

		if(shots[x][y] == true && ships[x][y] == '0')
			board[x][y] = 1;
		if(shots[x][y] == true && ships[x][y] != '0') 
			board[x][y] = 3;
		
		

		
		Target target = Target.targets[board[x][y]]; //getting the respective Target based on the ID
		
		if(target == null)
			return Target.waveTarget;
	
		return target;
	}

	
	private void setShot(int x, int y) {
		
		//System.out.println("single shot: " +LeftPanel.isSingleShotPressed + " radar: " + LeftPanel.isRadarPressed + " area: " + LeftPanel.isShotInArea + " airstrike: " + LeftPanel.isAirstrikePressed);
		
		
		if(isStrategySelected) {
			
			targetShotX = (x - BORDER) / targetWidth;
			targetShotY = y / targetHeight;
			
			if(selectedStrategy == "single_shot") 
				shots[targetShotX][targetShotY] = true;	
			if(selectedStrategy == "radar") 
				RadarStrategy();
			if(selectedStrategy == "shot_in_area") 
				matrixSweep(shots, numberOfTargetY, numberOfTargetX, targetShotX, targetShotY, true);
			if(selectedStrategy == "air_horz")
				AirStrikeHorizontalStrategy();
			
		}
		isStrategySelected = false;
		isClickOnBoard = false;
	}
	
	private void AirStrikeHorizontalStrategy() {
		
		System.out.println("x: " + targetShotX + " y: " + targetShotY);
		for(int i = 0; i < numberOfTargetX; i++) 
			shots[i][targetShotY] = true;
		
	}

	private void RadarStrategy() {
		matrixSweep(radar, numberOfTargetY, numberOfTargetX, targetShotX, targetShotY, true);
		
		for(int j = 0; j < numberOfTargetY; j++) {
			for(int i = 0; i < numberOfTargetX; i++) {	
				if(radar[i][j] && ships[i][j] != '0') {
					isThereAShip = true;
					alertMessage = "there is a ship in this area";
				}
				radar[i][j] = false;
			}
		}
	}
	
	
	private void hoverForSingleShot(int x, int y) {
		
		if(hitbox.hoverHitBox((BORDER + (x * targetWidth)), (BORDER + ((x + 1) * targetWidth)), (targetHeight * y), (targetHeight * (y + 1)))) 
			hover[x][y] = true;
		else 
			hover[x][y] = false;
	}
	
	private void hoverFor2x2Area(int x, int y) {
		
		if(hitbox.hoverHitBox((BORDER + (x * targetWidth)), (BORDER + ((x + 1) * targetWidth)), (targetHeight * y), (targetHeight * (y + 1)))) 
			matrixSweep(hover,numberOfTargetY, numberOfTargetX, x, y, true);	
		else 
			hover[x][y] = false;
		
	}
		
	private void hoverForAirStrikeHorz(int x, int y) {
		if(hitbox.hoverHitBox((BORDER + (x * targetWidth)), (BORDER + ((x + 1) * targetWidth)), (targetHeight * y), (targetHeight * (y + 1)))) 
			for(int i = 0; i < numberOfTargetX; i++) 
				hover[i][y] = true;
		else
			hover[x][y] = false;
	}
	
	private void hoverForAirStrikeVert(int x, int y) {
		if(hitbox.hoverHitBox((BORDER + (x * targetWidth)), (BORDER + ((x + 1) * targetWidth)), (targetHeight * y), (targetHeight * (y + 1)))) 
			for(int i = 0; i < numberOfTargetY; i++) 
				hover[x][i] = true;
		else
			hover[x][y] = false;
	}
	
	private void matrixSweep(boolean[][] matrix, int width, int height, int x, int y, boolean value) {
		
		if((y + 1 < width) && !(x == height - 1)) {
			matrix[x][y] = value;
			matrix[x][y + 1] = value;
			matrix[x + 1][y] = value;
			matrix[x + 1][y + 1] = value;
				
		}else if((y == width - 1) && !(x == height - 1)) {
			matrix[x][y] = value;
			matrix[x + 1][y] = value;
			matrix[x][y - 1] = value;
			matrix[x + 1][y - 1] = value;
			
		}else if((x == height - 1) && !(y == width - 1)) {
			matrix[x][y] = value;
			matrix[x - 1][y] = value;
			matrix[x][y + 1] = value;
			matrix[x - 1][y + 1] = value;
			
		}else if((x == height - 1) && (y == width - 1)) {
			matrix[x][y] = value;
			matrix[x - 1][y] = value;
			matrix[x][y - 1] = value;
			matrix[x - 1][y - 1] = value;
		}
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
		
		if(selectedStrategy == "air_horz")
			if((handler.getPlayer().getPoints()) < AIRSTRIKE_PRICE) 
				isPointAvailable = false;
		
		if(selectedStrategy == "air_vert")
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
		if(LeftPanel.isAirstrikePressed) {
			isAirStrike = true;		
		}
	}
	
	private void checkWhatIsTheAirStrikeDirection() {
		
		isAirVerticalHover = hitbox.hoverHitBox(370, 568, 322, 518);
		isAirVertical = hitbox.clickHitBox(370, 568, 322, 518);
		isAirHorizontalHover = hitbox.hoverHitBox(612, 808, 322, 518);
		isAirHorizontal = hitbox.clickHitBox(612, 808, 322, 518);
		
		if(isAirVertical)
			selectedStrategy = "air_vert";
		if(isAirHorizontal)
			selectedStrategy = "air_horz";
		
		if(isAirVertical || isAirHorizontal) {
			isAirStrike = false;
			isStrategySelected = false;
		}
		
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