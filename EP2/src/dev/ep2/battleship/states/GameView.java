package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Game;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.states.components.Board;

public class GameView extends State{

	private Player player;
	private Board board;
	private Assets assets;
	private final String ID = "GameView"; 
		
	public GameView(Game game) {
		
		super(game);	
		
		player = new Player(game, 30, 150); //(x,y) para posicionar o hp do player
		board = new Board("res/boards/board_1.txt");
		assets = new Assets();
	}
	
	
	@Override
	public void tick() {
		  
		board.tick();
		player.tick();		
	}

	@Override	
	public void render(Graphics g) {
		
		//render wave animation
		
		g.drawImage(assets.getIconWaveAnimation(), 300, 0, 840, 840, null);

		board.render(g);
		
		
	}

	@Override
	public String getID() {
		
		return ID;
	}
	
	

	
}
