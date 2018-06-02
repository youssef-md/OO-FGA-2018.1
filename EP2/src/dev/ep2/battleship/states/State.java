package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;

public abstract class State {
	
	protected Handler handler;
	
	public State(Handler handler) {
		
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract String getID();

}
