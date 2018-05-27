package dev.ep2.battleship.states.components;

import java.awt.Canvas;
import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class Board {


	private final int WIDTH = 12;
	private final int HEIGHT = 12;
	
	
	public Board() {
		
		
	}
	
	public void render(Graphics g) {
	
		
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				g.drawImage(Assets.water_block, i * 80 + 16, j * 80 + 16, null);
			}
		}
		
	
		System.out.println("Board");
	}
	
	
}
