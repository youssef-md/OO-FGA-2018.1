package dev.ep2.battleship.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.gfx.Text;
import dev.ep2.battleship.states.components.FileNavigator;
import dev.ep2.battleship.states.components.MessagePopUp;

public class MenuView extends State	{

	final String ID = "MenuView"; 
	FileNavigator fileNavigator;
	
	private boolean isHoverBtnStart, isMapLoaded, isMessage = false;
	
	Assets assets;
	public MenuView(Handler handler) {
		
		super(handler);
		assets = new Assets();
		fileNavigator = new FileNavigator();
	}
	
	@Override
	public void tick() {
		
		//System.out.println("MouseX = " + handler.getMouseManager().getMouseX() + " MouseY = " + handler.getMouseManager().getMouseY());
		
		// Hit box for the Load/Start Button
		if(handler.getMouseManager().getMouseX() >= 530 && handler.getMouseManager().getMouseX() <= 862) {
			if(handler.getMouseManager().getMouseY() >= 506 && handler.getMouseManager().getMouseY() <= 612) {

				isHoverBtnStart = true;
				
				if(handler.getMouseManager().isLeftPressed()) { //click
					
					findTheFileAndLoadIt();
					if(isMapLoaded)
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
			
		
		if(isHoverBtnStart)
			g.drawImage(Assets.btn_start_hover, 520, 500, 350, 130, null);
		else
			g.drawImage(Assets.btn_start, 520, 500, 350, 130, null);
		
		if(isMessage) {
			//render a mensagem de erro passando o Graphics e depois seta isMessage = false quando for pra ela sumir
		}
		
		Text.drawString(g, "Battleship", 500, 500, false, Color.white, Assets.military_font28);
		isHoverBtnStart = false;		
		
	}

	private void findTheFileAndLoadIt() {
		
		fileNavigator.Navigate("Load a map");
		if(fileNavigator.getPath() != null ) {
			
			handler.setGameView(fileNavigator.getPath());	
			isMapLoaded = true;
			
		} else if(fileNavigator.getPath() == null) {
		
			MessagePopUp message = new MessagePopUp("Where is the file???");
			isMessage = true;
		}

	}
	
	@Override
	public String getID() {
		
		return ID;
	}

}
