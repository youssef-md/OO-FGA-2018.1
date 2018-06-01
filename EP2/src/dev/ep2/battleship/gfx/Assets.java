package dev.ep2.battleship.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Assets {

	public static BufferedImage user_turn_target, pc_turn_target, hit_target, sink_target, filter;
	public Image wave_animation = new ImageIcon(getClass().getResource("/textures/wave_animation.gif")).getImage();
	//public Image wave_animation = new ImageIcon(getClass().getResource("/textures/Sequence_02.gif")).getImage();

	private int WAVE_SIZE = 1000;
	
	public static void init() {

		SpriteSheet filterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/filter.png"));
		
		filter = filterSheet.crop(0, 0, 550, 200);
		
		SpriteSheet targets = new SpriteSheet(ImageLoader.loadImage("/textures/targets_sprite_sheet.png"));
		
		user_turn_target = targets.crop(0, 0, 200, 200);
		pc_turn_target = targets.crop(200, 0, 200, 200);
		hit_target = targets.crop(400, 0, 200, 200);
		sink_target = targets.crop(600, 0, 200, 200);
		
		
	}
	public Image getIconWaveAnimation() {
		return wave_animation;
	}
	
}
