package dev.ep2.battleship;

import dev.ep2.battleship.display.Display;

public class Game implements Runnable {

	public int width, height;
	public String title;
	private boolean running = false;
	
	private Display display;
	private Thread thread;
	
	
	
	public Game(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
	}

	
	private void init() {
		
		display = new Display(title, width, height);
	}
	
	private void update() {
		
	}
	
	private void render() {
		
	}

	@Override
	public void run() {
	
		init(); 
		
		while(running) { // game loop
			
			update();
			render();
		}
		
		stop();
	}
	
	public synchronized void start() {
		
		if(!running) {
			
			running = true;
			thread = new Thread(this); // running Game class(this) as a Thread
			thread.start(); // calling run()
		}			
	}
	
	public synchronized void stop() {
		
		if(running) {
			
			running = false;
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
	}
	
}
