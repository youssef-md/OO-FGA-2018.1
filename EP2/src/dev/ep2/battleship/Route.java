package dev.ep2.battleship;

import java.awt.Graphics;

import dev.ep2.battleship.states.GameView;
import dev.ep2.battleship.states.MenuView;
import dev.ep2.battleship.states.State;
import dev.ep2.battleship.states.StateManager;

public class Route {

	private State gameView;
	private State menuView;
	
	public Route(Game game) {
		
		gameView = new GameView(game); // GameState extends abstract State .: (state) = (GameState)
		menuView = new MenuView(game);
				
		StateManager.setState(menuView); // Saving the runtime current state
	}
		
	
	public boolean isThereAView() {
		
		if(StateManager.getState() != null) {
			return true;
		}
		
		return false;
	}
	
	public State getView() {
		
		return StateManager.getState(); // (state) = (GameState/MenuState) due to abstract class
	}
	
	public static String getRouteID() {
		
		return StateManager.getStateID();
	}
}
