package dev.ep2.battleship.states.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.gfx.Text;
import dev.ep2.battleship.helpers.HitBoxHelper;
import dev.ep2.battleship.states.MenuView;

public class MessagePopUp {

		
	private boolean isHoverBtnOk, isBtnOkPressed, isAlertVisible;
	public boolean isPopUpVisible = true;
	private HitBoxHelper hitbox;
	private Handler handler;
	
	
	public MessagePopUp(Handler handler) {
		
		this.handler = handler;
		hitbox = new HitBoxHelper(handler);
	}
	
	
	public boolean showAlert(String message) {
		
		//g.drawImage(Assets.popup_alert, 350, 500, 700, 350, null);
		JOptionPane.showMessageDialog(null, message, "WARNING", JOptionPane.WARNING_MESSAGE);
		return false;
	}
	
	public boolean makeWarningVisible(String message, Graphics g) {
		
		g.drawImage(Assets.popup_warning, 395, 230, 650, 380, null);
		
		updateBtnOk();
				
		if(!isHoverBtnOk)
			g.drawImage(Assets.btn_ok_warning, 620, 480, 200, 70, null);
		else
			g.drawImage(Assets.btn_ok_warning_hover, 620, 480, 200, 70, null);
		
		Text.drawString(g, message, 720, 420, true, Color.white, Assets.military_font30);

		if(isBtnOkPressed) 
			 return false;
		else 
			return true;
		
	}
	
	public void youLose(String message, Graphics g) {
		
		g.drawImage(Assets.popup_warning, 395, 230, 650, 380, null);
		updateBtnOk();
		
		if(!isHoverBtnOk)
			g.drawImage(Assets.btn_ok_warning, 620, 480, 200, 70, null);
		else
			g.drawImage(Assets.btn_ok_warning_hover, 620, 480, 200, 70, null);
		
		Text.drawString(g, message, 720, 420, true, Color.white, Assets.military_font30);

		if(isBtnOkPressed) 
			handler.getRoute().setView(handler.getMenuView());
	}
	
	private void updateBtnOk() {
		
		isHoverBtnOk = hitbox.hoverHitBox(624, 818, 483, 544);
		isBtnOkPressed = hitbox.clickHitBox(624, 818, 483, 544);
	}
	
}
