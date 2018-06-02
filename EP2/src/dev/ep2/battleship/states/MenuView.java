package dev.ep2.battleship.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.ep2.battleship.Game;
import dev.ep2.battleship.display.Display;
import dev.ep2.battleship.gfx.Assets;

public class MenuView extends State	{

	final String ID = "MenuView"; 

	Assets assets = new Assets();
	public MenuView(Game game) {
		
		super(game);
	}
	
	@Override
	public void tick() {
		
		System.out.println("MouseX = " + game.getMouseManager().getMouseX() + " MouseY = " + game.getMouseManager().getMouseY());
	}

	@Override
	public void render(Graphics g) {
		
		
		g.drawImage(assets.getIconWaveAnimation(), 0, 0, Display.frameWidth, Display.frameHeight, null);
		g.drawImage(Assets.filter, 0, 0, Display.frameWidth, Display.frameHeight, null);
		g.setColor(Color.RED);
		g.fillRect(game.getMouseManager().getMouseX(), game.getMouseManager().getMouseY(), 10, 10);
	}

	@Override
	public String getID() {
		
		return ID;
	}

}
