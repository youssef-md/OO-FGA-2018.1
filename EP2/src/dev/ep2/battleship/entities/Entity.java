package dev.ep2.battleship.entities;

import java.awt.Graphics;

public abstract class Entity {

	protected float x,y; // float for smooth movement
	
	public Entity(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
