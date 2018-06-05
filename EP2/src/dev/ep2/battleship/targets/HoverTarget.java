package dev.ep2.battleship.targets;

import dev.ep2.battleship.gfx.Assets;

public class HoverTarget extends Target {

	public HoverTarget(int ID) {

		super(Assets.hover_target, ID);
	}

	
	@Override
	public boolean isClickable() {
		
		return false;
	}
 
}
