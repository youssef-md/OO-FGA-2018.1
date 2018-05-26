package dev.ep2.battleship.states.components;

import java.awt.Canvas;
import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class Board {


	private final int ROW = 18;
	private final int COLUMN = 9;
	
	
	public Board() {
		
		
	}
	
	public void render(Graphics g) {
	
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				g.drawRect(i * 80, j * 80, 80, 80);
			}
		}
		
		System.out.println("Board");
	}
	
	
}
