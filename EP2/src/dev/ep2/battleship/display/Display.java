package dev.ep2.battleship.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class Display {

	private JFrame frame;
	private Canvas canvas;
	private int frameWidth, frameHeight;
	
	
	public Display(int width, int height) {
		
		this.frameWidth = width;
		this.frameHeight = height;
		
	}
	
	public void createDisplay() {
		
		frame = new JFrame();
		frame.setSize(frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(frameWidth, frameHeight));
		canvas.setMinimumSize(new Dimension(frameWidth, frameHeight));
		canvas.setMaximumSize(new Dimension(frameWidth, frameHeight));
		
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
		
	}
	
	
	public Canvas getCanvas() { 
		return canvas; 
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}
