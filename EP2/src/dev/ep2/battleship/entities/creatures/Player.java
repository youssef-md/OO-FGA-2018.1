package dev.ep2.battleship.entities.creatures;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;

public class Player extends Creature{

	private Handler handler;
	private String name;
	private int points = 1000;
	public static char sex = 'x';
	public static boolean isQPressed, isWPressed, isEPressed, isRPressed;
	
	public Player(Handler handler, int x, int y) {
		
		super(handler, x, y);
		this.handler = handler;

		health = Creature.DEFAULT_HEALTH;
	}

	public void tick() {
		
		isQPressed = isWPressed = isEPressed = isRPressed = false;
		
		if(handler.getKeyManager().Q) 
			isQPressed = true;
		
		if(handler.getKeyManager().W) 
			isWPressed = true;
		
		if(handler.getKeyManager().E) 
			isEPressed = true;		
		
		if(handler.getKeyManager().R)
			isRPressed = true;
		
	}

	public void render(Graphics g) {
		
	}	
	
	public int getPoints() {
		
		return points;
	}

	public void setPoints(int points) {
		
		this.points = points;
	}
	
	public String getPointsToString() {
		
		return Integer.toString(points);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
