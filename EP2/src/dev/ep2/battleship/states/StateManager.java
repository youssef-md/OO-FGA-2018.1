package dev.ep2.battleship.states;

import dev.ep2.battleship.states.State;

public class StateManager {

	private static State currentState = null;
	
	public void setState(State state) {
		
		currentState = state;
	}
	
	public State getState() {
		return currentState;
	}
	
	public String getStateID() {
		return currentState.getID();
	}
	
	
}
