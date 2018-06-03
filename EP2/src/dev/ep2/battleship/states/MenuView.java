package dev.ep2.battleship.states;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JTextField;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.gfx.Text;
import dev.ep2.battleship.states.components.FileNavigator;
import dev.ep2.battleship.states.components.MessagePopUp;

public class MenuView extends State	{

	final String ID = "MenuView"; 
	FileNavigator fileNavigator;
	
	private boolean isHoverMale, isHoverFemale, isMalePressed, isFemalePressed;
	private boolean isHoverBtnStart, isMapLoaded, isAlertVisible;
	
	Assets assets;
	public MenuView(Handler handler) {
		
		super(handler);
		assets = new Assets();
		fileNavigator = new FileNavigator();

	}
	
	@Override
	public void tick() {
			
		//System.out.println("MouseX = " + handler.getMouseManager().getMouseX() + " MouseY = " + handler.getMouseManager().getMouseY());
		

				
		isHoverMale = hoverHitBox(619, 712, 511, 576);
		isHoverFemale = hoverHitBox(720, 815, 511, 576);
		
		if(!isMalePressed && !isFemalePressed) isMalePressed = clickHitBox(619, 712, 511, 576);
		if(!isFemalePressed && !isMalePressed) isFemalePressed = clickHitBox(720, 815, 511, 576);
		
		setPlayerSex();
		
		
		System.out.println(Player.sex);
		// Hit box for the Load/Start Button
		/*
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
		 */
		
	
	}

	@Override
	public void render(Graphics g) {
		
		
		g.drawImage(assets.getIconWaveAnimation(), 0, 0, handler.getAppWidth(), handler.getAppHeight(), null);
		g.drawImage(Assets.game_title, 490, 20, 460, 200, null);
		g.drawImage(Assets.filter, 0, 0, handler.getAppWidth(), handler.getAppHeight(), null);
		
		renderUserAvatar(g);
		renderUserSexOption(g);
		
		
	
		/*
		if(isHoverBtnStart)
			g.drawImage(Assets.btn_start_hover, 520, 500, 350, 130, null);
		else
			g.drawImage(Assets.btn_start, 520, 500, 350, 130, null);
		*/
		
		if(isAlertVisible) 
			MessagePopUp.showAlert("Please, open a map");
		
		
		//Text.drawString(g, "Battleship", 500, 500, true, Color.white, Assets.military_font28);

	}
	
	private boolean hoverHitBox(int x1, int x2, int y1, int y2) {
		
		if(handler.getMouseManager().getMouseX() > x1 && handler.getMouseManager().getMouseX() < x2) {
			if(handler.getMouseManager().getMouseY() > y1 && handler.getMouseManager().getMouseY() < y2) {
				
				return true;	
			}
		}
		
		return false;
	}
	
	private boolean clickHitBox(int x1, int x2, int y1, int y2) {
		
		if(hoverHitBox(x1, x2, y1, y2) && handler.getMouseManager().isLeftPressed())
			return true;
		
		return false;
	}

	private void setPlayerSex() {
		
		if(isMalePressed) Player.sex = 'M';
		else if(isFemalePressed) Player.sex = 'F';
	}
	
	private void findTheFileAndLoadIt() {
		
		fileNavigator.Navigate("Load a map");
		if(fileNavigator.getPath() != null ) {
			
			handler.setGameView(fileNavigator.getPath());	
			isMapLoaded = true;
			
		} else if(fileNavigator.getPath() == null) {
		
			isAlertVisible = true;
		}

	}
	
	private void renderUserAvatar(Graphics g) {
		
		if(!isMalePressed && !isFemalePressed)
			g.drawImage(Assets.avatar_base, 595, 250, 250, 250, null);
		
		if((isHoverMale && !isFemalePressed) || isMalePressed)
			g.drawImage(Assets.avatar_male, 595, 250, 250, 250, null);
		
		if((isHoverFemale && !isMalePressed) || isFemalePressed)
			g.drawImage(Assets.avatar_female, 595, 250, 250, 250, null);
	}
	
	private void renderUserSexOption(Graphics g) {
		
		if(!isHoverMale || !isHoverFemale || !isMalePressed || !isFemalePressed) 
			g.drawImage(Assets.btn_sex, 617, 510, 200, 70, null);
		
		if(isHoverMale && !isMalePressed && !isFemalePressed) 
			g.drawImage(Assets.btn_male_hover, 617, 510, 200, 70, null);
		
		if(isMalePressed)
			g.drawImage(Assets.btn_male_pressed, 617, 510, 200, 70, null);
		
		if(isHoverFemale && !isFemalePressed && !isMalePressed)
			g.drawImage(Assets.btn_fem_hover, 617, 510, 200, 70, null);
		
		if(isFemalePressed)
			g.drawImage(Assets.btn_fem_pressed, 617, 510, 200, 70, null);
	}
			
	
	@Override
	public String getID() {
		
		return ID;
	}

}
