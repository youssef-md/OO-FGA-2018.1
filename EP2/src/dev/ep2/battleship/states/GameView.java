package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Game;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.states.components.Board;

public class GameView extends State{

	private Player player;
	private Board board;
	
	
	public GameView(Game game, Graphics g) {
		
		super(game);	
		
		player = new Player(game, 100);
		board = new Board();
	}
	
	
	public void init(Graphics g) {

	}
	
	@Override
	public void tick() {
		
		board.tick();
		player.tick();
				
	}

	@Override
	public void render(Graphics g) {
		
					
		board.render(g);
		
	}

	
}
