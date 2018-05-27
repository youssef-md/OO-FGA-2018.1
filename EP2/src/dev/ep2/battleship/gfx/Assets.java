package dev.ep2.battleship.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage wave, water_block;
	
	private static final int WAVE_SIZE = 1000;
	
	public static void init() {
		
		SpriteSheet sheetWave = new SpriteSheet(ImageLoader.loadImage("/img/water_top_view.jpg"));
		SpriteSheet sheetBlock = new SpriteSheet(ImageLoader.loadImage("/img/block.png"));
		
		wave = sheetWave.crop(0, 0, WAVE_SIZE, WAVE_SIZE);
		water_block = sheetBlock.crop(0, 0, 80, 80);
		
	}
	
	public static int getWaveSize() {
		return WAVE_SIZE;
	}
}
