package dev.ep2.battleship;

import dev.ep2.battleship.display.Display;

public class Game implements Runnable {

	public int width, height;
	
	private Display display;
	private Thread thread;
	
	
	
	
	
	public Game(String title, int width, int height) {
		
		this.width = width;
		this.height = height;
		
		display = new Display(title, width, height);
	}


	@Override
	public void run() {
	
		
	}
	
	public synchronized void start() {
		
		thread = new Thread(this); // running Game class(this) as a Thread
		thread.start(); // calling run()
	}
	
	public synchronized void stop() {
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
