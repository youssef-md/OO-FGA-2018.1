package dev.ep2.battleship.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage p1, p2, p3, p4;
	private static final int WIDTH = 250, HEIGHT = 250;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/img/spritesheet_teste.png"));
		
		
	}
}
