package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class Board {


	private int numberOfTargetX = 10;
	private int numberOfTargetY = 10;
	private final int boardResolution = 840;
	
	private int animationCounterDirection = 0;
	private int animationCounter = 0;
	
	public Board() {
		

	}
	
	public void tick() {
		
		
	}
	
	public void render(Graphics g) {
	
	
		
		if(animationCounterDirection == 0) {
			if (animationCounter < 20) {
				animationCounter++;
			}
			else {
				animationCounterDirection = 1;
			}
		}
		else {
			if (animationCounter > 0) {
				animationCounter--;
			}
			else {
				animationCounterDirection = 0;
			}
		}

		
		//g.drawImage(Assets.wave[animationCounter], 400, 0, null);

		
		int targetSizeX = boardResolution / numberOfTargetX;
		int targetSizeY = boardResolution / numberOfTargetY;
				
		for(int i = 0; i < numberOfTargetX; i++) {
			for(int j = 0; j < numberOfTargetY; j++) {
				g.drawImage(Assets.target, i * targetSizeX + 300 , j * targetSizeY , targetSizeX, targetSizeY, null);
			}
		}
		
	
		//System.out.println("Board");
	}
	
}
