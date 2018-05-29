package dev.ep2.battleship.entities.creatures;

import java.awt.Graphics;

import dev.ep2.battleship.Game;
import dev.ep2.battleship.gfx.Assets;

public class Player extends Creature{

	private Game game;
	private int health;
	
	public Player(Game game, int health, float x, float y) {
		
		super(x, y);
		this.health = health;
		this.game = game;
	}

	public void tick() {
		
		if(game.getKeyManager().Q) {
			System.out.println("Atacar uma posição do tabuleiro");
		}
		
		if(game.getKeyManager().W) { 
			System.out.println("Descobrir se há uma embarcação inimiga em uma área 2x2 do tabuleiro;");
		}
		
		if(game.getKeyManager().E) {
			System.out.println("Atacar uma área 2x2 do tabuleiro");
		}
		
		if(game.getKeyManager().R) { 
			System.out.println("Atacar uma linha/coluna completa do tabuleiro");
		}
	}

	public void render(Graphics g) {
		
		//g.drawImage(Assets.p2, (int) x, (int) y, null);
		//desenhar o hp e as estratégias
	}	

}
