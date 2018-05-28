package dev.ep2.battleship.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage target;
	public static BufferedImage[] wave;
	
	private int WAVE_SIZE = 1000;
	
	public static void init() {

		SpriteSheet sheetTarget = new SpriteSheet(ImageLoader.loadImage("/img/target.png"));
		target = sheetTarget.crop(0, 0, 200, 200);
		
		/*
		 SpriteSheet sheetWave = new SpriteSheet(ImageLoader.loadImage("/img/waves_sprite_sheet.png"));
		 
			
		
		wave = new BufferedImage[21];
		
		wave[0] = sheetWave.crop(0, 0, 1000, 1000);
		wave[1] = sheetWave.crop(1000, 0, 1000, 1000);
		wave[2] = sheetWave.crop(2000, 0, 1000, 1000);
		wave[3] = sheetWave.crop(3000, 0, 1000, 1000);
		wave[4] = sheetWave.crop(4000, 0, 1000, 1000);
		wave[5] = sheetWave.crop(5000, 0, 1000, 1000);
		wave[6] = sheetWave.crop(6000, 0, 1000, 1000);
		wave[7] = sheetWave.crop(7000, 0, 1000, 1000);
		wave[8] = sheetWave.crop(8000, 0, 1000, 1000);
		wave[9] = sheetWave.crop(9000, 0, 1000, 1000);
		wave[10] = sheetWave.crop(10000, 0, 1000, 1000);
		wave[11] = sheetWave.crop(11000, 0, 1000, 1000);
		wave[12] = sheetWave.crop(12000, 0, 1000, 1000);
		wave[13] = sheetWave.crop(13000, 0, 1000, 1000);
		wave[14] = sheetWave.crop(14000, 0, 1000, 1000);
		wave[15] = sheetWave.crop(15000, 0, 1000, 1000);
		wave[16] = sheetWave.crop(16000, 0, 1000, 1000);
		wave[17] = sheetWave.crop(17000, 0, 1000, 1000);
		wave[18] = sheetWave.crop(18000, 0, 1000, 1000);
		wave[19] = sheetWave.crop(19000, 0, 1000, 1000);
		wave[20] = sheetWave.crop(20000, 0, 1000, 1000);
		
		
		*/
		
	}
	
}
