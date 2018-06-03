package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.helpers.FileHelper;
import dev.ep2.battleship.targets.Target;

public class Board {

	public final int BOARD_RESOLUTION = 840;
	public final int BORDER = 300;

	private int width, height; 
	private int targetWidth, targetHeight;
	private int targetShotX, targetShotY;
	private boolean validShot = false;
	
	private Handler handler;
	private int[][] board;
	private int[][] ships;
	
	public Board(String path, Handler handler) {
		
		this.handler = handler;
		loadAndSetTheBoard(path);
	}
	
	public void tick() {
		
		//variaveis para verificar se é clicavel, e para definir qual bloco renderizar	
	
		if(handler.getMouseManager().isLeftPressed()) {
			if(handler.getMouseManager().getMouseX() > 300 && handler.getMouseManager().getMouseX() < 1140) {
				if(handler.getMouseManager().getMouseY() > 0 && handler.getMouseManager().getMouseY() < 840) {
					
					validShot = true;
					setShot(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
				}
			}
		}
	
	}
	
	public void render(Graphics g) {
		
		// Responsiveness for the targets based on the given dimension 
		targetWidth = BOARD_RESOLUTION / width; 
		targetHeight = BOARD_RESOLUTION / height; 
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				
				if(validShot) {
					
				}
				getTarget(x, y).render(g, x * targetWidth + BORDER, y * targetHeight, targetWidth, targetHeight);
			}
		}
		
		
	}
	
		
	
	private void loadAndSetTheBoard(String path) {
		
		String file = FileHelper.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); 
		
		width = FileHelper.parseInt(tokens[0]);
		height = FileHelper.parseInt(tokens[1]);
		
		board = new int[width][height];
		ships = new int[width][height];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				
				ships[x][y] = FileHelper.parseInt(tokens[y + 2].charAt(x));
				board[x][y] = 0; // start the game with only blue targets
			}
		}
	}
	
	public Target getTarget(int x, int y) {
		
		if(ships[x][y] != 0)
			 return Target.targets[1];
		
		Target target = Target.targets[board[x][y]]; //getting the respective Target based on the ID

		if(target == null)
			return Target.userTurnTarget;
		
		return target;
	}
	
	private void setShot(int x, int y) {
		
		targetShotX = (x - BORDER) / targetWidth;
		targetShotY = y / targetHeight;
		
		System.out.println("x: " + targetShotX + " y: " + targetShotY);
	}
	
}
