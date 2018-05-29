package dev.ep2.battleship.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import dev.ep2.battleship.gfx.Assets;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private int width, height;
	
	public Display(int width, int height) {
		
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay() {
		
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		
		canvas.setFocusable(false);
		frame.add(canvas); //Appending canvas to the JFrame
		frame.pack();
		
	}
	
	
	public Canvas getCanvas() { 
	
		return canvas; 
	}
	
	public JFrame getFrame() {
		
		return frame;
	}
}
