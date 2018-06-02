package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.display.Display;
import dev.ep2.battleship.gfx.Assets;

public class MenuView extends State	{

	final String ID = "MenuView"; 
	
	Assets assets;
	public MenuView(Handler handler) {
		
		super(handler);
		assets = new Assets();
	}
	
	@Override
	public void tick() {
		
		System.out.println("MouseX = " + handler.getMouseManager().getMouseX() + " MouseY = " + handler.getMouseManager().getMouseY());
		
	
	}

	@Override
	public void render(Graphics g) {
		
		
		g.drawImage(assets.getIconWaveAnimation(), 0, 0, Display.frameWidth, Display.frameHeight, null);
		g.drawImage(Assets.filter, 0, 0, Display.frameWidth, Display.frameHeight, null);
		
	}

	@Override
	public String getID() {
		
		return ID;
	}

}
