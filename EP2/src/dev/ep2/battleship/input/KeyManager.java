package dev.ep2.battleship.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean Q, W, E, R;
	
	public KeyManager() {
		
		keys = new boolean[256]; // array for checking if a key is pressed or not by comparing to its keyCode
	}
	
	public void tick() { // updating the keys every frame
		
		Q = keys[KeyEvent.VK_Q];
		W = keys[KeyEvent.VK_W];
		E = keys[KeyEvent.VK_E];
		R = keys[KeyEvent.VK_R];
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		
		keys[event.getKeyCode()] = true;
		System.out.println(event.getKeyChar() + " pressed");
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
		keys[event.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
		
	}

}
