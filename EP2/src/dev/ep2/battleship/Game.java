package dev.ep2.battleship;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.ep2.battleship.display.Display;
import dev.ep2.battleship.gfx.ImageLoader;

public class Game implements Runnable {
	
	private Display display;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;

	public int width, height;
	public String title;
	private boolean running = false;
	
	public Game(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
	}

	
	private void init() {
		
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/img/s2-checked.png");
	}
	
	private void tick() {
		
	}
	
	private void render() {

		// preventing flickering to the screen with buffers
		bs = display.getCanvas().getBufferStrategy(); 
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height); //clear screen
		
		g.drawImage(testImage, 20, 20, null);
		
		bs.show();
		g.dispose();
	}


	@Override
	public void run() {
	
		init(); 
		
		while(this.running) { // game loop
			
			tick();
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
