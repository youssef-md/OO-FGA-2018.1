package dev.ep2.battleship.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Assets {

	public static BufferedImage user_turn_target, pc_turn_target, hit_target, sink_target, filter, btn_start, btn_load, game_title, btn_load_hover, btn_start_hover;
	public Image wave_animation = new ImageIcon(getClass().getResource("/textures/wave_animation.gif")).getImage();
	

	
	public static void init() {

		SpriteSheet filterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/filter.png"));
		SpriteSheet gameTitleSheet = new SpriteSheet(ImageLoader.loadImage("/textures/game_title.png"));
		SpriteSheet btnStartSheet = new SpriteSheet(ImageLoader.loadImage("/textures/btn_start.png"));
		SpriteSheet btnLoadSheet = new SpriteSheet(ImageLoader.loadImage("/textures/btn_load.png"));
		
		SpriteSheet btnStartSheetHover = new SpriteSheet(ImageLoader.loadImage("/textures/btn_start::hover.png"));
		SpriteSheet btnLoadSheetHover = new SpriteSheet(ImageLoader.loadImage("/textures/btn_load::hover.png"));
		
		SpriteSheet targets = new SpriteSheet(ImageLoader.loadImage("/textures/targets_sprite_sheet.png"));
		
		game_title = gameTitleSheet.crop(0, 0, 1200, 500);
		
		btn_start = btnStartSheet.crop(0, 0, 454, 166);
		btn_load = btnLoadSheet.crop(0, 0, 454, 166);
		
		btn_start_hover = btnStartSheetHover.crop(0, 0, 454, 166);
		btn_load_hover = btnLoadSheetHover.crop(0, 0, 454, 166);
		
		
		filter = filterSheet.crop(0, 0, 550, 200);
		
		
		user_turn_target = targets.crop(0, 0, 200, 200);
		pc_turn_target = targets.crop(200, 0, 200, 200);
		hit_target = targets.crop(400, 0, 200, 200);
		sink_target = targets.crop(600, 0, 200, 200);
		
		
	}
	public Image getIconWaveAnimation() {
		return wave_animation;
	}
	
}
