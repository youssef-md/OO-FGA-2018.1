package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.helpers.HitBoxHelper;
import dev.ep2.battleship.states.components.FileNavigator;
import dev.ep2.battleship.states.components.MessagePopUp;

public class MenuView extends State	{

	private final String ID = "MenuView"; 
	private FileNavigator fileNavigator;
	private HitBoxHelper hitbox;
	private MessagePopUp messagePopUp;
	private String alertMessage;
	private boolean isHoverMale, isHoverFemale, isMalePressed, isFemalePressed;
	private boolean isHoverBtnStart, isBtnStartPressed, isHoverBtnRank, isBtnRankPressed, isMapLoaded;
	private boolean isPopUpVisible, isAlertVisible;
	
	Assets assets;
	public MenuView(Handler handler) {
		
		super(handler);
		assets = new Assets();
		hitbox = new HitBoxHelper(handler);
		messagePopUp = new MessagePopUp(handler);
		fileNavigator = new FileNavigator();		
		isPopUpVisible = false;
		isAlertVisible = false;
		
	}
	
	@Override
	public void tick() {
			
		//System.out.println("MouseX = " + handler.getMouseManager().getMouseX() + " MouseY = " + handler.getMouseManager().getMouseY());
		
		if(!isPopUpVisible) {
			updateUserSexOption();
			updateBtnStartAndRank();
		} else 
			resetFlags();
					
		if(isBtnStartPressed) {
			if(isMalePressed || isFemalePressed) { 
				findTheFileAndLoadIt();
				if(isMapLoaded)
					handler.getRoute().setView(handler.getGameView());
			} else { 
				isPopUpVisible = true;
				alertMessage = "Select your sex";
			}	 		
		}
		
		if(isBtnRankPressed) {
			//carregar a View de Rank e carregar o arquivo e usar fontes pra renderizar
			System.out.println("Rank click");
		}
			
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(assets.getIconWaveAnimation(), 0, 0, handler.getAppWidth(), handler.getAppHeight(), null);
		g.drawImage(Assets.game_title, 490, 20, 460, 200, null);
		g.drawImage(Assets.filter, 0, 0, handler.getAppWidth(), handler.getAppHeight(), null);
		
		renderUserAvatar(g);
		renderUserSexOption(g);
		renderStartButton(g);
		renderRankButton(g);
		
		if(isPopUpVisible)
			isPopUpVisible = messagePopUp.makeWarningVisible(alertMessage, g);
		
		if(isAlertVisible) 
			isAlertVisible = messagePopUp.showAlert(alertMessage);	

	}
	
	private void updateUserSexOption() {
		
		isHoverMale = hitbox.hoverHitBox(619, 712, 511, 576);
		isHoverFemale = hitbox.hoverHitBox(720, 815, 511, 576);
		
		if(!isMalePressed && !isFemalePressed) {
			isMalePressed = hitbox.clickHitBox(619, 712, 511, 576);
			isFemalePressed = hitbox.clickHitBox(720, 815, 511, 576);
			setPlayerSex();
		}
	}
	
	private void updateBtnStartAndRank() {
		
		isHoverBtnStart = hitbox.hoverHitBox(595, 838, 615, 703);
		isBtnStartPressed = hitbox.clickHitBox(595, 838, 615, 703);
		isHoverBtnRank = hitbox.hoverHitBox(595, 838, 734, 821);
		isBtnRankPressed = hitbox.clickHitBox(595, 838, 734, 821);
	}
	
	private void resetFlags() {
		
		isBtnStartPressed = isHoverBtnStart = isBtnRankPressed = isHoverBtnRank = false;
		isHoverMale = isHoverFemale = isMalePressed = isFemalePressed = false;
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
			alertMessage = "Select a map";
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
		
	private void renderStartButton(Graphics g) {
		
		if(!isHoverBtnStart)
			g.drawImage(Assets.btn_start, 593, 610, 250, 100, null);
		else
			g.drawImage(Assets.btn_start_hover, 593, 610, 250, 100, null);
	}
	
	private void renderRankButton(Graphics g) {
		
		if(!isHoverBtnRank)
			g.drawImage(Assets.btn_rank, 593, 730, 250, 98, null);
		else
			g.drawImage(Assets.btn_rank_hover, 593, 730, 250, 98, null);
	}
		
	@Override
	public String getID() {
		
		return ID;
	}
	

}
