package dev.ep2.battleship.targets;

import dev.ep2.battleship.gfx.Assets;

public class HitTarget extends Target {

	public HitTarget(int ID) {
		
		super(Assets.hit_target, ID);
	}

	@Override
	public boolean isClickable() {
		
		return false;
	}
}
