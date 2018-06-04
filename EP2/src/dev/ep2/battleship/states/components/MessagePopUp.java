package dev.ep2.battleship.states.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.gfx.Text;
import dev.ep2.battleship.states.MenuView;

public class MessagePopUp {

		
	public MessagePopUp() {
		
	}
	
	
	public static void showAlert(String message) {
		
		//g.drawImage(Assets.popup_alert, 350, 500, 700, 350, null);
		JOptionPane.showMessageDialog(null, message, "WARNING", JOptionPane.WARNING_MESSAGE);
		MenuView.isAlertVisible = false;
	}
	
	public static void showWarning(String message, Graphics g, boolean hover, boolean click) {
		
		g.drawImage(Assets.popup_warning, 395, 230, 650, 380, null);
		if(click) 
			MenuView.isPopUpVisible = false;
			
		if(!hover)
			g.drawImage(Assets.btn_ok_warning, 620, 480, 200, 70, null);
		else
			g.drawImage(Assets.btn_ok_warning_hover, 620, 480, 200, 70, null);
		
		Text.drawString(g, message, 720, 420, true, Color.white, Assets.military_font30);
	}
	
}
