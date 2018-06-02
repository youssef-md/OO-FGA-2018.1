package dev.ep2.battleship.states.components;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class FileNavigator {

	private JButton open;
	private JFileChooser fileChooser;
	private String path;
	
	public FileNavigator() {
		
		open = new JButton();
		fileChooser = new JFileChooser();
	}
	
	public void Navigate(String title) {
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setDialogTitle(title);
		if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {}
		
		path = fileChooser.getSelectedFile().getAbsolutePath();
	}
	
	public String getAbsolutePath() {
		
		return path;
	}
	
}
