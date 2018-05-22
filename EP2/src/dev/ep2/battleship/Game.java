package dev.ep2.battleship;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.ep2.battleship.display.Display;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.gfx.ImageLoader;
import dev.ep2.battleship.gfx.SpriteSheet;

public class Game implements Runnable {
	
	private Display display;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;	

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
		Assets.init(); // Loading the assets
		
	}
	
	int y = 0;
	private void tick() {
		y++;
	}
	
	
	private void render() {

		// preventing flickering to the screen with buffers
		bs = display.getCanvas().getBufferStrategy(); 
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);// triple buffering
			return;
		}
		
		g = bs.getDrawGraphics(); 
		g.clearRect(0, 0, width, height); //clear screen
		

		g.drawImage(Assets.p2, 10, 10, null);
		
		g = bs.getDrawGraphics();
		g.drawImage(Assets.p1, 250, 250, null);

		
		
		bs.show();
		g.dispose();
	}


	@Override
	public void run() {
	
		init(); 
		
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		while(this.running) { // game loop
			
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
			
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
