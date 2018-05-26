package dev.ep2.battleship;

import java.awt.Graphics;

import dev.ep2.battleship.states.GameState;
import dev.ep2.battleship.states.MenuState;
import dev.ep2.battleship.states.State;
import dev.ep2.battleship.states.StateManager;

public class Route {

	private State gameState;
	private State menuState;
	
	public Route(Game game, Graphics g) {
		
		gameState = new GameState(game, g); // GameState extends abstract State .: (state) = (GameState)
		menuState = new MenuState(game);
				
		StateManager.setState(gameState); // Saving the runtime current state
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
}
