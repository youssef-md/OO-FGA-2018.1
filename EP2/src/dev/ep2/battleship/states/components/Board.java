package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class Board {


	private int numberOfTargetX = 5;
	private int numberOfTargetY = 5;
	private final int boardResolution = 840;
	
	
	public Board() {
		
		// Board checking if there is ships and stuff
	}
	
	public void tick() {
		
		
	}
	
	public void render(Graphics g) {
		
		int targetSizeX = boardResolution / numberOfTargetX;
		int targetSizeY = boardResolution / numberOfTargetY;
				
		for(int i = 0; i < numberOfTargetX; i++) {
			for(int j = 0; j < numberOfTargetY; j++) {
				
				g.drawImage(Assets.target, i * targetSizeX + 300 , j * targetSizeY , targetSizeX, targetSizeY, null);
			}
		}
		
	}
	
}
