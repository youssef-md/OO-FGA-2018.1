package dev.ep2.battleship.targets;

import dev.ep2.battleship.gfx.Assets;

public class SinkTarget extends Target {
	
	public SinkTarget(int ID) {
		
		super(Assets.sink_target, ID);
	}
	
	@Override
	public boolean isClickable() {
		
		return false;
	}

}
