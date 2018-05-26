package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Game;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.states.components.Board;

public class GameState extends State{

	private Player player;
	private Board board;
	private Graphics g;
	
	public GameState(Game game, Graphics g) {
		
		super(game);
		
		this.g = g;
		
		player = new Player(game, 100);
		board = new Board();
	}
	
	
	@Override
	public void tick() {
	
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		
		//animation waves
		g.drawImage(Assets.wave, 0, 0, null);
		//animation waves
		
		board.render(g);
	}

	
}
