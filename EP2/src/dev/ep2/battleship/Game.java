package dev.ep2.battleship;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.ep2.battleship.display.Display;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.input.KeyManager;
import dev.ep2.battleship.input.MouseManager;
import dev.ep2.battleship.states.State;
import dev.ep2.battleship.Handler;


public class Game extends Canvas implements Runnable {
	
	private boolean running = false;
	private Display display;
	public int width, height;
	public String title;
	
	public Thread thread;
	private BufferStrategy bs;
	public static Graphics g; 
	private Route route;
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private Handler handler;

	public Game(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
	}

	public synchronized void start() { 
		
		if(!running) {
		
			running = true;
			thread = new Thread(this); // Running Game class(this) as a Thread
			thread.start();
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
	

	@Override
	public void run() {
	
		init(); 
		
		int fps = 30;
		long timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
 		double ns = 1000000000 / fps;
 		double delta = 0;
 		
 		int frames = 0;
 		int ticks = 0;
				
		while(running) { // game loop

			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) { // Restricting update to 30fps, so every pc will run in the same game speed
				tick();
				render();
				ticks++;
				frames++;
				delta--;
			}
									
			if(System.currentTimeMillis() - timer > 1000) {
				
				timer += 1000;
				display.getFrame().setTitle(title + "  |  " + ticks + " updates: update( )  | " + frames + " FPS: render( ) ");
				ticks = 0;
				frames = 0;
			}
		}

		
		stop() ; // In case the game hasn't been stopped
	}
	
	private void init() {
		
		display = new Display(width, height);
		display.getFrame().addKeyListener(keyManager); // KeyManager implements KeyListener
		display.getFrame().addMouseListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		
		Assets.init();
		
		handler = new Handler(this);
		route = new Route(handler);
		
	}
	

	private void tick() { 

		keyManager.tick(); // Updating the keys that are being pressed
		//mouseManager.tick();
		
		if(route.isThereAView()) { 
			
			route.getView().tick(); 
		}
		
	}
	


	
	private void render() {

		
		// Preventing flickering to the screen with buffers
		bs = display.getCanvas().getBufferStrategy(); 
		
		if(bs == null) { // Create the BufferStrategy only once
			display.getCanvas().createBufferStrategy(3);// Triple buffering for smooth gameplay
			return;								
		}
		
		g = bs.getDrawGraphics();
		
		{ // Able to draw using Graphics g
			
			g.clearRect(0, 0, width, height); // Clear screen
	
			if(route.isThereAView()) {
				
				route.getView().render(g); // Pass the Graphics for the current View to render()
			}
		}
		
		g.dispose();
		bs.show();
		
	}
	
	public Graphics getGraphicsG() {
		return g;
	}
	
	public KeyManager getKeyManager() {
		
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		
		return mouseManager;
	}
	
	public int getAppWidth() {
		return width;
	}
	
	public int getAppHeight() {
		return height;
	}


}
