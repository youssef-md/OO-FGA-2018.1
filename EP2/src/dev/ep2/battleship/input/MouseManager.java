package dev.ep2.battleship.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dev.ep2.battleship.Route;
import dev.ep2.battleship.states.GameView;
import dev.ep2.battleship.states.components.Board;

public class MouseManager implements MouseListener {

	//private GameView gameView;
	
	private int boardPositionX, boardPositionY;
	
	
	public MouseManager() {
		
		
	}
	
	private void tickMenuView(int mx, int my) {
		
		System.out.println("X: " + mx + " Y: " + my);
	}
	
	private void tickGameView(int mx, int my) {
		
		 

		
		int boardPositionX = mx / (Board.targetWidth + Board.BORDER);
		int boardPositionY = mx / Board.targetHeight;

	}


	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();		
		
		if(Route.getRouteID() == "MenuView") {
			
			tickMenuView(mx, my);
			
		} else if(Route.getRouteID() == "GameView") {
			
			tickGameView(mx, my);
		}
				
	}

	
	
}
