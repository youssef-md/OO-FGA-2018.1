package dev.ep2.battleship;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.ep2.battleship.display.Display;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.input.KeyManager;
import dev.ep2.battleship.states.GameState;
import dev.ep2.battleship.states.MenuState;
import dev.ep2.battleship.states.State;
import dev.ep2.battleship.states.StateManager;
import dev.ep2.battleship.states.components.Board;

public class Game implements Runnable {
	
	private Display display;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;	

	private Route route;
	
	private KeyManager keyManager;
	
	public int width, height;
	public String title;
	private boolean running = false;
	
	
	
	public Game(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		
	}

	
	private void init() {
		
		display = new Display(title, width, height);
		
		display.getFrame().addKeyListener(keyManager); // KeyManager implements KeyListener
		
		route = new Route(this, g);
		
		Assets.init(); // loading the assets
		
		
	}
	

	private void tick() { // update

		keyManager.tick(); // updating the keys that are being pressed
		
		if(route.isThereAView()) { // there is a current runtime state running
			
			State currentView = route.getView(); 
			currentView.tick(); 
		}
	}
	
	
	private void render() {

		
		// preventing flickering to the screen with buffers
		bs = display.getCanvas().getBufferStrategy(); 
		
		if(bs == null) {
			
			display.getCanvas().createBufferStrategy(3);// triple buffering
			return;								
		}
		
		g = bs.getDrawGraphics(); 
		g.clearRect(0, 0, width, height); // clear screen
		
		if(route.isThereAView()) {
			
			State currentView = route.getView();
			currentView.render(g); // pass the Graphics for the current State render()
		}

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
			
			try {
				thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		stop() ; // in case the game hasn't been stopped
	}
	
	
	public KeyManager getKeyManager() {
		
		return keyManager;
	}
	
	
	public synchronized void start() { // synchronizing this Thread's method 
		
		if(!running) {
		
			running = true;
			thread = new Thread(this); // running Game class(this) as a Thread
			thread.start(); // calling run()
		}			
	}
	
	public synchronized void stop() { // synchronizing this Thread's method
		
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
