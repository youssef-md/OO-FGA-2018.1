package dev.ep2.battleship;

import dev.ep2.battleship.states.State;
import dev.ep2.battleship.states.StateManager;

public class Route {

	private StateManager stateManager;
		
	public Route(Handler handler) {
		
		stateManager = new StateManager();
		stateManager.setState(handler.getMenuView()); // Saving the runtime current state
	}
		
	public void setView(State currentState) {
		
		stateManager.setState(currentState);
	}
	
	public boolean isThereAView() {
		
		if(stateManager.getState() != null) 
			return true;
	
		return false;
	}
	
	public State getView() {
		
		return stateManager.getState(); // (state) = (GameState/MenuState) due to abstract class
	}
	
	public String getRouteID() {
		
		return stateManager.getStateID();
	}
}
