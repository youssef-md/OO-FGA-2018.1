package dev.ep2.battleship.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage wave;
	
	private static final int WAVE_WIDTH = 80, WAVE_HEIGHT = 80;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/img/ondas.jpg"));
		
		wave = sheet.crop(0, 0, WAVE_WIDTH, WAVE_HEIGHT);
		
	}
	
	public static int getWaveSize() {
		return WAVE_WIDTH;
	}
}
