package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import dev.ep2.battleship.gfx.Assets;

public class MessagePopUp {

		
	public MessagePopUp() {
		
	}
	
	
	public static void showAlert( String message) {
		
		//g.drawImage(Assets.popup_alert, 350, 500, 700, 350, null);
		JOptionPane.showMessageDialog(null, message);
	}
	
	
}
