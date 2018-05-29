package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.targets.Target;

public class Board {

	private final int boardResolution = 840;

	private int numberOfTargetX = 10; // ler do arquivo
	private int numberOfTargetY = 10; // ler do arquivo
		
	
	public Board() {
		
		// Board checking if there is ships and stuff
	}
	
	public void tick() {
		
		
	}
	
	public void render(Graphics g) {
		
		
		int targetWidth = boardResolution / numberOfTargetX; 
		int targetHeight = boardResolution / numberOfTargetY;
		
		for(int i = 0; i < numberOfTargetX; i++) {
			for(int j = 0; j < numberOfTargetY; j++) {
				
				//verificar se o target é clicável, se sim verificar se acertou o barco ou já derrubou-o
				Target.targets[0].render(g, i * targetWidth + 300, j * targetHeight, targetWidth, targetHeight);
			}
		}
		
	}
	
}
