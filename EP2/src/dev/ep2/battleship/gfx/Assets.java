package dev.ep2.battleship.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage p1, p2, p3, p4;
	private static final int WIDTH = 250, HEIGHT = 250;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/img/spritesheet_teste.png"));
		
		p1 = sheet.crop(0, 0, WIDTH, HEIGHT);
		p2 = sheet.crop(250, 0, WIDTH, HEIGHT);
		p3 = sheet.crop(0, 250, WIDTH, HEIGHT);
		p4 = sheet.crop(250, 250, WIDTH, HEIGHT);
	}
}
