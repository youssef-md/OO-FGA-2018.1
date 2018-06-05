package dev.ep2.battleship;

import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.input.KeyManager;
import dev.ep2.battleship.input.MouseManager;
import dev.ep2.battleship.states.GameView;
import dev.ep2.battleship.states.MenuView;
import dev.ep2.battleship.states.State;

public class Handler {

	private Game game;
	private Route route;
	private GameView gameView;
	private MenuView menuView;
	private Player player;
	
	public Handler(Game game) {
		
		this.game = game;
		route = new Route(this);
		menuView = new MenuView(this);
	}
	
	public void setGameView(String boardPath) {
		
		gameView = new GameView(this, boardPath);
	}
	
	public void setPlayer(Player player) {
		
		this.player = player;
	}
	
	public Player getPlayer() {
		
		return player;
	}
	
	public Route getRoute() {
		
		return route;
	}
	
	public State getMenuView() {
		
		return menuView;
	}
	
	public State getGameView() {
		
		return gameView;
	}
	
	public MouseManager getMouseManager() {
		
		return game.getMouseManager();
	}
	
	public KeyManager getKeyManager() {
		
		return game.getKeyManager();
	}
	
	public int getAppWidth() {
		
		return game.getAppWidth();
	}
	
	public int getAppHeight() {
		
		return game.getAppHeight();
	}
	
	public void setGame(Game game) {
		
		this.game = game;
	}
	
	public Game getGame() {
		
		return game;
	}
}
