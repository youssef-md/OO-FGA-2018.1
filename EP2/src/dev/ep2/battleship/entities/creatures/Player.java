package dev.ep2.battleship.entities.creatures;

import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class Player extends Creature{

	public Player(float x, float y) {
		
		super(x, y);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.p2, (int) x, (int) y, null);
	}	

}
