package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
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
		
		//System.out.println("MouseX = " + handler.getMouseManager().getMouseX() + " MouseY = " + handler.getMouseManager().getMouseY());
		
		// load button
		if(handler.getMouseManager().getMouseX() >= 530 && handler.getMouseManager().getMouseX() <= 862) {
			if(handler.getMouseManager().getMouseY() >= 506 && handler.getMouseManager().getMouseY() <= 612) {
				//hover
				//color change and sound
				
				if(handler.getMouseManager().isLeftPressed()) { 
					//click
					
				}
			}
		}
		
		// start button
		if(handler.getMouseManager().getMouseX() >= 530 && handler.getMouseManager().getMouseX() <= 862) {
			if(handler.getMouseManager().getMouseY() >= 669 && handler.getMouseManager().getMouseY() <= 766) {
				//hover
				//color change and sound
				
				if(handler.getMouseManager().isLeftPressed()) { 
					//click
					handler.getRoute().setView(handler.getGameView());
				}
			}
		}
		
	
	}

	@Override
	public void render(Graphics g) {
		
		
		g.drawImage(assets.getIconWaveAnimation(), 0, 0, handler.getAppWidth(), handler.getAppHeight(), null);
		g.drawImage(Assets.game_title, 210, 20, 1000, 400, null);
		g.drawImage(Assets.filter, 0, 0, handler.getAppWidth(), handler.getAppHeight(), null);
		
		g.drawImage(Assets.btn_load, 520, 500, 350, 130, null);
		g.drawImage(Assets.btn_start, 520, 650, 350, 130, null);
		
	}

	@Override
	public String getID() {
		
		return ID;
	}

}
