package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.helpers.FileHelper;
import dev.ep2.battleship.targets.Target;

public class Board {

	public final int BOARD_RESOLUTION = 840;
	public final int BORDER = 300;

	private int numberOfTargetX; // ler do arquivo
	private int numberOfTargetY; // ler do arquivo
	public int targetWidth;
	public int targetHeight;
	
	
	private int[][] board;
		
	
	public Board(String path) {
		
		loadBoard(path);
	}
	
	public void tick() {
		
		//variaveis para verificar se é clicavel, e para definir qual bloco renderizar	
	}
	
	public void render(Graphics g) {
		
		targetWidth = BOARD_RESOLUTION / numberOfTargetX; // Responsiveness for the targets based on the given
		targetHeight = BOARD_RESOLUTION / numberOfTargetY; // dimension 
		
			
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				
				getTarget(x, y).render(g, x * targetWidth + BORDER, y * targetHeight, targetWidth, targetHeight);
			}
		}
		
		
	}
	
		
	
	private void loadBoard(String path) {
		
		FileHelper helper = new FileHelper("res/boards/board_1.txt");
		
		String[] tokens = helper.getnumberOfTargetXandY().split("\\s+");
		numberOfTargetX = FileHelper.parseInt(tokens[0]);
		numberOfTargetY = FileHelper.parseInt(tokens[1]);
		
		board = new int[numberOfTargetX][numberOfTargetY];
		
		
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				 
				board[x][y] = 1;
				//board[x][y] = FileHelper.parseInt(tokens[(x + y * numberOfTargetX) + 6]);
			}
		}
		 
		
	}
	
	public Target getTarget(int x, int y) {
		
		Target target = Target.targets[board[x][y]]; //getting the respective Target based on the ID
		
		if(target == null)
			return Target.userTurnTarget;
		
		return target;
	}

	
}
