package com.battleship.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 800, HEIGHT = 800;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Battleship", this);
	}
	
	
	public synchronized void start() {
		
	}
	
	@Override
	public void run() {
				
	}
	
	
	public static void main(String args[]) {
		
		new Game();
	}




	

}
