package dev.ep2.battleship.entities;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;

public abstract class Entity {

	protected Handler handler;
	protected float x,y; // float for smooth movement
	
	public Entity(Handler handler, int x, int y) {
		
		this.handler = handler;
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
