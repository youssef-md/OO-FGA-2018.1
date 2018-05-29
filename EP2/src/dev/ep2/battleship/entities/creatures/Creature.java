package dev.ep2.battleship.entities.creatures;

import dev.ep2.battleship.entities.Entity;

public abstract class Creature extends Entity{

	public final static int DEFAULT_HEALTH = 100;
	protected int health;
		
	public Creature(int x, int y) {
		
		super(x, y); // passing to the Entity's constructor
		health = 100;
	}
	
	
}
