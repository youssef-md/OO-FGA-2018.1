package dev.ep2.battleship.entities.creatures;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.Entity;

public abstract class Creature extends Entity{

	public final static int DEFAULT_HEALTH = 100;
	protected int health;
		
	public Creature(Handler handler, int x, int y) {
		
		super(handler, x, y); // passing to the Entity's constructor
		health = 100;
	}
	
	
}
