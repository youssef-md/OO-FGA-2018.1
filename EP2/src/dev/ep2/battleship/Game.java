package dev.ep2.battleship;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.ep2.battleship.display.Display;

public class Game implements Runnable {

	public int width, height;
	public String title;
	private boolean running = false;
	
	private Display display;
	private Thread thread;
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	
	
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

		// preventing flickering to the screen with buffers
		this.bufferStrategy = this.display.getCanvas().getBufferStrategy(); 
		
		if(this.bufferStrategy == null) {
			this.display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		this.graphics = this.bufferStrategy.getDrawGraphics();
		
		//drawing
		this.graphics.fillRect(0, 0, this.width, this.height);
		
		this.bufferStrategy.show();
		this.bufferStrategy.dispose();
	}


	@Override
	public void run() {
	
		init(); 
		
		while(this.running) { // game loop
			
			update();
			render();
		}
		
		stop();
	}
	
	public synchronized void start() {
		
		if(!this.running) {
			
			this.running = true;
			this.thread = new Thread(this); // running Game class(this) as a Thread
			this.thread.start(); // calling run()
		}			
	}
	
	public synchronized void stop() {
		
		if(this.running) {
			
			this.running = false;
			
			try {
				this.thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	
	


	
}
