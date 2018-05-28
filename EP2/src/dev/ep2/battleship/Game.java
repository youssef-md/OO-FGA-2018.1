package dev.ep2.battleship;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.ep2.battleship.display.Display;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.input.KeyManager;
import dev.ep2.battleship.states.State;


public class Game extends Canvas implements Runnable {
	
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

		setGraphics();
		
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
			display.getCanvas().createBufferStrategy(3);// triple buffering for smooth gameplay
			return;								
		}
		
		g = bs.getDrawGraphics(); 
		g.clearRect(0, 0, width, height); // clear screen

		if(route.isThereAView()) {
			
			State currentView = route.getView();
			currentView.render(g); // pass the Graphics for the current State render()
		}
		
		g.dispose();
		bs.show();
		
	}


	@Override
	public void run() {
	
		init(); 
		
		long timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
 		double ns = 1000000000 / 30.0;
 		double delta = 0;
 		
 		int frames = 0;
 		int ticks = 0;
				
		while(running) { // game loop

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				System.out.println(ticks + "ups, " + frames + " fps");  
				ticks = 0;
				frames = 0;
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
	
	

	private void setGraphics() {
		
		
		bs = display.getCanvas().getBufferStrategy(); 
		
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;								
		}
		
		g = bs.getDrawGraphics(); 
		
		g.clearRect(0, 0, width, height);

		
	}
	
}
