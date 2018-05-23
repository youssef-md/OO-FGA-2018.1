package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class GameState extends State{

	public GameState() {
		
		
	}
	
	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.p1, 0, 0, null);
	}

	
}
