package dev.ep2.battleship.entities.creatures;

import dev.ep2.battleship.entities.Entity;

public abstract class Creature extends Entity{

	protected int health;
	
	public Creature(float x, float y) {
		
		super(x, y); // passing to the Entity's constructor
		health = 100;
	}
	
	
}
