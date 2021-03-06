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
	
		fileChooser.setCurrentDirectory(new java.io.File("./res/boards"));
		fileChooser.setDialogTitle(title);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			
		int result = fileChooser.showOpenDialog(open);
		
		if(result == JFileChooser.APPROVE_OPTION) {
			
			path = fileChooser.getSelectedFile().getAbsolutePath();
			
		} else if(result == JFileChooser.CANCEL_OPTION){
		
			path = null;
		}
			
	}
	
	public String getPath() {
		
		return path;
	}
	
}
