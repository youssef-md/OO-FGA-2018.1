package dev.ep2.battleship.entities.creatures;

import java.awt.Graphics;

import dev.ep2.battleship.Game;
import dev.ep2.battleship.gfx.Assets;

public class Player extends Creature{

	private Game game;
	
	public Player(Game game, float x, float y) {
		
		super(x, y);
		this.game = game;
	}

	@Override
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

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.p2, (int) x, (int) y, null);
	}	

}
