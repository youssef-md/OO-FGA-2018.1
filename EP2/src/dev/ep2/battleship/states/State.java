package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Game;

public abstract class State {
	
	protected Game game;
	
	public State(Game game) {
		
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
