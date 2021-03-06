package dev.ep2.battleship.display;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dev.ep2.battleship.Game;

public class Welcome {

	private JFrame frame;
	private JTextField textField;
	private JButton btnSend;
	private JLabel lblUserName;
	private String input;
	
	public Welcome() {
		
		lblUserName = new JLabel("  username  ");
		textField = new JTextField();
		btnSend = new JButton("SEND");
		initialize();
	}


	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 390, 60);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().add(lblUserName, BorderLayout.WEST);
		frame.getContentPane().add(textField, BorderLayout.CENTER);
		frame.getContentPane().add(btnSend, BorderLayout.EAST);
		textField.setColumns(20);
	
		
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game game = new Game("Battleship", 1140, 840);
				
				PrintWriter writer = null;
				
				try {
					writer = new PrintWriter("playername.txt", "UTF-8");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				
				writer.println(textField.getText());
				
				writer.close();
				frame.dispose();
				game.start();
			}
		});
		
		System.out.println(input);

	}

}
