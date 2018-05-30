package dev.ep2.battleship.states.components;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.helpers.FileHelper;
import dev.ep2.battleship.targets.Target;

public class Board {

	private final int boardResolution = 840;

	private int numberOfTargetX; // ler do arquivo
	private int numberOfTargetY; // ler do arquivo
	
	private int[][] board;
		
	
	public Board(String path) {
		
		loadBoard(path);
	}
	
	public void tick() {
		
		//variaveis para verificar se é clicavel, e para definir qual bloco renderizar	
	}
	
	public void render(Graphics g) {
		
		int targetWidth = boardResolution / numberOfTargetX; // Responsiveness for the targets based on the given
		int targetHeight = boardResolution / numberOfTargetY; // dimension 
		
			
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				
				getTarget(x, y).render(g, x * targetWidth + 300, y * targetHeight, targetWidth, targetHeight);
			}
		}
		
		
	}
	
	public Target getTarget(int x, int y) {
		
		Target target = Target.targets[board[x][y]]; //getting the respective Target based on the ID
		
		if(target == null)
			return Target.userTurnTarget;
		
		return target;
	}
	
	
	private void loadBoard(String path) {
		
		FileHelper helper = new FileHelper("res/boards/board_1.txt");
		
		String[] tokens = helper.getnumberOfTargetXandY().split("\\s+");
		numberOfTargetX = FileHelper.parseInt(tokens[0]);
		numberOfTargetY = FileHelper.parseInt(tokens[1]);
		
		board = new int[numberOfTargetX][numberOfTargetY];
		
		
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				 
				board[x][y] = 0;
				//board[x][y] = FileHelper.parseInt(tokens[(x + y * numberOfTargetX) + 6]);
			}
		}
		 
		
	}
	
}
