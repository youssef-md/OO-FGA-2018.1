package dev.ep2.battleship;

public class Launcher {

	public static void main(String[] args) {
		
		Game game = new Game("Battleship", 1000, 1000);
		game.start();
	}
}


