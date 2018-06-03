package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.states.components.Board;

public class GameView extends State{

	private Player player;
	private Board board;
	private Assets assets;
	private final String ID = "GameView"; 
		
	public GameView(Handler handler, String boardPath) {
		
		super(handler);	
		handler.getMouseManager().setLeftPressed(false);
		assets = new Assets();
		player = new Player(handler, 30, 150); //(x,y) para posicionar o hp do player
		board = new Board(boardPath, handler);
	}
	

	
	@Override
	public void tick() {
		
		board.tick();  
		player.tick();		
		
		//System.out.println("x: " + handler.getMouseManager().getMouseX() + " y: " + handler.getMouseManager().getMouseY());
	}

	@Override	
	public void render(Graphics g) {
		
		//render wave animation
		
		g.drawImage(assets.getIconWaveAnimation(), board.BORDER, 0, board.BOARD_RESOLUTION, board.BOARD_RESOLUTION, null);
		g.drawImage(Assets.filter, board.BORDER, 0, board.BOARD_RESOLUTION, board.BOARD_RESOLUTION, null);

		board.render(g);
	}

	@Override
	public String getID() {
		
		return ID;
	}
	
	
	
	

	
}
