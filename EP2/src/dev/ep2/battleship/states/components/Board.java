package dev.ep2.battleship.states.components;

import java.awt.Canvas;
import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class Board extends Canvas {


	private final int ROW = 25;
	private final int COLUMN = 13;
	
	public Board() {
		
	}
	
	public void paint(Graphics g) {
	
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COLUMN; j++) {
				g.drawImage(Assets.wave, i * Assets.getWaveSize(), j * Assets.getWaveSize(), null);
			}
		}
		
		System.out.println("Board");
	}
	
}
