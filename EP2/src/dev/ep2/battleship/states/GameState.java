package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class GameState extends State{

	public GameState() {
		
		
	}
	
	int x = 0;
	@Override
	public void tick() {
		x++;
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.p1, x, 0, null);
	}

	
}
