package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Game;
import dev.ep2.battleship.display.Display;
import dev.ep2.battleship.gfx.Assets;

public class MenuView extends State	{

	final String ID = "MenuView"; 

		
	public MenuView(Game game) {
		
		super(game);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
										
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.marpat, 0, 0, Display.frameWidth, Display.frameHeight, null);
	}

	@Override
	public String getID() {
		
		return ID;
	}

}
