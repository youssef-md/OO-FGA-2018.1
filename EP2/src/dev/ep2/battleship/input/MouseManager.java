package dev.ep2.battleship.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.ep2.battleship.Route;
import dev.ep2.battleship.states.GameView;
import dev.ep2.battleship.states.components.Board;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
		
	public MouseManager() {}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
			
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	public void setLeftPressed(boolean leftPressed) { this.leftPressed = leftPressed; }
	
	public boolean isLeftPressed() { return leftPressed; }

	public boolean isRightPressed() { return rightPressed; }

	public int getMouseX() { return mouseX; }
	
	public int getMouseY() { return mouseY; }
	
	@Override
	public void mouseDragged(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}
