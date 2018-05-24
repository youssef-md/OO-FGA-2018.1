package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Game;
import dev.ep2.battleship.entities.creatures.Player;

public class GameState extends State{

	private Player player;
	
	public GameState(Game game) {
		
		super(game);
		player = new Player(game, 250, 250);
	}
	
	
	@Override
	public void tick() {
	
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		
		player.render(g);
	}

	
}
