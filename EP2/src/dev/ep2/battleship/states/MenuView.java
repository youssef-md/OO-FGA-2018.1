package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.states.components.FileNavigator;
import dev.ep2.battleship.states.components.MessagePopUp;

public class MenuView extends State	{

	final String ID = "MenuView"; 
	private boolean isHoverBtnLoad, isHoverBtnStart = false;
	
	Assets assets;
	public MenuView(Handler handler) {
		
		super(handler);
		assets = new Assets();
	}
	
	@Override
	public void tick() {
		
		//System.out.println("MouseX = " + handler.getMouseManager().getMouseX() + " MouseY = " + handler.getMouseManager().getMouseY());
		
		// Hit box for the Load Button
		if(handler.getMouseManager().getMouseX() >= 530 && handler.getMouseManager().getMouseX() <= 862) {
			if(handler.getMouseManager().getMouseY() >= 506 && handler.getMouseManager().getMouseY() <= 612) {
				
				isHoverBtnLoad = true;
				
				
				if(handler.getMouseManager().isLeftPressed()) { 
					
					FileNavigator fileNavigator = new FileNavigator();

					fileNavigator.Navigate("Load a map");
					
					if(fileNavigator.getPath() != null ) {
						
						handler.setGameView(fileNavigator.getPath());	
					
					} else if(fileNavigator.getPath() == null) {
					
						MessagePopUp message = new MessagePopUp(handler.getGame().getGraphicsG(), "Where is the file???");
					}
				}
			}
		}
		
		// Hit box for the Start Button
		if(handler.getMouseManager().getMouseX() >= 530 && handler.getMouseManager().getMouseX() <= 862) {
			if(handler.getMouseManager().getMouseY() >= 669 && handler.getMouseManager().getMouseY() <= 766) {
				
				isHoverBtnStart = true;
				
				if(handler.getMouseManager().isLeftPressed()) { 
					
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
		
		if(isHoverBtnLoad)
			g.drawImage(Assets.btn_load_hover, 520, 500, 350, 130, null);
		else
			g.drawImage(Assets.btn_load, 520, 500, 350, 130, null);
		
		if(isHoverBtnStart)
			g.drawImage(Assets.btn_start_hover, 520, 650, 350, 130, null);
		else
			g.drawImage(Assets.btn_start, 520, 650, 350, 130, null);
		
		isHoverBtnLoad = false;
		isHoverBtnStart = false;
		
	}

	@Override
	public String getID() {
		
		return ID;
	}

}
