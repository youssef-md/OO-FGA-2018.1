package dev.ep2.battleship.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage wave;
	
	private static final int WAVE_SIZE = 1500;
	
	public static void init() {
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/img/water_top_view.jpg"));
		
		wave = sheet.crop(0, 0, WAVE_SIZE, WAVE_SIZE);
		
	}
	
	public static int getWaveSize() {
		return WAVE_SIZE;
	}
}
