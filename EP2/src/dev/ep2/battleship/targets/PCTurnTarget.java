package dev.ep2.battleship.targets;

import dev.ep2.battleship.gfx.Assets;

public class PCTurnTarget extends Target {

	public PCTurnTarget(int ID) {

		super(Assets.pc_turn_target, ID);
	}

	
	@Override
	public boolean isClickable() {
		
		return false;
	}
 
}
