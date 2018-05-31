package dev.ep2.battleship.states;

import dev.ep2.battleship.states.State;

public class StateManager {

	private static State currentState = null;
	
	public static void setState(State state) {
		
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public static String getStateID() {
		return currentState.getID();
	}
	
	
}
