package dev.ep2.battleship.display;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

				input = textField.getText();
				Game game = new Game("Battleship", 1440, 840);
				// salvar o nome do jogador num txt e no inicio da Game ler ele e settar juntamente para o futuro rank dele
				frame.dispose();
				game.start();
			}
		});
		
		System.out.println(input);

	}

}
