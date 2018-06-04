package dev.ep2.battleship.helpers;

import dev.ep2.battleship.Handler;

public class HitBoxHelper {

	private Handler handler;
	
	public HitBoxHelper(Handler handler) {
		
		this.handler = handler;
	}
	
	public boolean hoverHitBox(int x1, int x2, int y1, int y2) {
		
		if(handler.getMouseManager().getMouseX() > x1 && handler.getMouseManager().getMouseX() < x2) {
			if(handler.getMouseManager().getMouseY() > y1 && handler.getMouseManager().getMouseY() < y2) {
				
				return true;	
			}
		}
		
		return false;
	}
	
	public boolean clickHitBox(int x1, int x2, int y1, int y2) {
		
		if(hoverHitBox(x1, x2, y1, y2) && handler.getMouseManager().isLeftPressed())
			return true;
		
		return false;
	}
	
}
