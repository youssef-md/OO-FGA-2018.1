package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import dev.ep2.battleship.gfx.Assets;

public class MessagePopUp {

		
	public MessagePopUp(String message) {
		
		show(message);
	}
	
	public void render(Graphics g) {
		
	}
	
	public void show(String message) {
		
		//g.drawImage(Assets.hit_target, 350, 500, null);
		JOptionPane.showMessageDialog(null, message);
	}
	
	
}
