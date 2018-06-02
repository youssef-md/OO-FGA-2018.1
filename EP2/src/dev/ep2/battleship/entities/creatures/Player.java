package dev.ep2.battleship.entities.creatures;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;

public class Player extends Creature{

	private Handler handler;
	
	public Player(Handler handler, int x, int y) {
		
		super(handler, x, y);
		this.handler = handler;

		health = Creature.DEFAULT_HEALTH;
	}

	public void tick() {
		
		if(handler.getKeyManager().Q) {
			System.out.println("Atacar uma posição do tabuleiro");
		}
		
		if(handler.getKeyManager().W) { 
			System.out.println("Descobrir se há uma embarcação inimiga em uma área 2x2 do tabuleiro;");
		}
		
		if(handler.getKeyManager().E) {
			System.out.println("Atacar uma área 2x2 do tabuleiro");
		}
		
		if(handler.getKeyManager().R) { 
			System.out.println("Atacar uma linha/coluna completa do tabuleiro");
		}
	}

	public void render(Graphics g) {
		
		//desenhar o hp e as estratégias
	}	

}
