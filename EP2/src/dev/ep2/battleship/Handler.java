package dev.ep2.battleship;

import dev.ep2.battleship.input.KeyManager;
import dev.ep2.battleship.input.MouseManager;

public class Handler {

	private Game game;
	
	
	public Handler(Game game) {
		
		this.game = game;
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
}
