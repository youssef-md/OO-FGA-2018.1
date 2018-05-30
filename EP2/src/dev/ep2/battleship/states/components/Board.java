package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.targets.Target;

public class Board {

	private final int boardResolution = 840;

	private int numberOfTargetX = 10; // ler do arquivo
	private int numberOfTargetY = 10; // ler do arquivo
	
	private int[][] board;
		
	
	public Board(String path) {
		
		loadBoard(path);
	}
	
	public void tick() {
		
		//variaveis para verificar se é clicavel, e para definir qual bloco renderizar	
	}
	
	public void render(Graphics g) {
		
		
		int targetWidth = boardResolution / numberOfTargetX; 
		int targetHeight = boardResolution / numberOfTargetY;
		
				
		for(int y = 0; y < numberOfTargetY; y++) {
			for(int x = 0; x < numberOfTargetX; x++) {
				
				getTarget(x, y).render(g, x * targetWidth + 300, y * targetHeight, targetWidth, targetHeight);
			}
		}
		
	}
	
	public Target getTarget(int x, int y) {
		
		Target target = Target.targets[board[x][y]];
		
		if(target == null)
			return Target.userTurnTarget;
		
		return target;
	}
	
	
	private void loadBoard(String path) {
		
		board = new int[numberOfTargetX][numberOfTargetY];
		
		for(int x = 0; x < numberOfTargetX; x++) {
			for(int y = 0; y < numberOfTargetY; y++) {
				board[x][y] = 0;
			}
		}
	}
	
}
