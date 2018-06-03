package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.helpers.FileHelper;
import dev.ep2.battleship.targets.Target;

public class Board {

	public final int BOARD_RESOLUTION = 840;
	public final int BORDER = 300;

	private int width; 
	private int height; 
	public int targetWidth;
	public int targetHeight;
	
	
	private int[][] board;
	private int[][] ships;
	
	public Board(String path) {
		
		loadBoard(path);
	}
	
	public void tick() {
		
		//variaveis para verificar se é clicavel, e para definir qual bloco renderizar	
	}
	
	public void render(Graphics g) {
		
		targetWidth = BOARD_RESOLUTION / width; // Responsiveness for the targets based on the given
		targetHeight = BOARD_RESOLUTION / height; // dimension 
		
			
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				
				getTarget(x, y).render(g, x * targetWidth + BORDER, y * targetHeight, targetWidth, targetHeight);
			}
		}
		
		
	}
	
		
	
	private void loadBoard(String path) {
		
		String file = FileHelper.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); 
		
		width = FileHelper.parseInt(tokens[0]);
		height = FileHelper.parseInt(tokens[1]);
		
		System.out.println("Width = " + width + " Height = " + height);
		
		board = new int[width][height];
		ships = new int[width][height];
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				
				System.out.print("("+ y + "," + x + ") = " + tokens[y + 2].charAt(x) + "  ");
				ships[x][y] = FileHelper.parseInt(tokens[y + 2].charAt(x));
				board[x][y] = 0; // start the game with only blue targets
			}
			System.out.println("");
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

	
}
