package dev.ep2.battleship.gfx;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Assets {

	public static BufferedImage user_turn_target, pc_turn_target, hit_target, sink_target, filter, btn_start, btn_start_hover, game_title;
	public static BufferedImage avatar_base, avatar_male, avatar_female, btn_sex, btn_male_hover, btn_male_pressed;
	public static BufferedImage btn_fem_hover, btn_fem_pressed; 
	public Image wave_animation = new ImageIcon(getClass().getResource("/textures/wave_animation.gif")).getImage();
	public static Font military_font28;

	
	public static void init() {

		SpriteSheet gameTitleSheet = new SpriteSheet(ImageLoader.loadImage("/textures/game_title.png"));
		SpriteSheet filterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/filter.png"));
		SpriteSheet targetsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/targets_sprite_sheet.png"));
		SpriteSheet userAvatarSheet  = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet_user_avatar.png"));
		SpriteSheet btnSexSheet  = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet_btn_sex.png"));
		
		SpriteSheet btnStartSheet = new SpriteSheet(ImageLoader.loadImage("/textures/btn_start.png"));
		SpriteSheet btnStartSheetHover = new SpriteSheet(ImageLoader.loadImage("/textures/btn_start::hover.png"));
		//SpriteSheet popups = new SpriteSheet(ImageLoader.loadImage("/textures/popup_alert.png"));
		
				
		
		btn_start = btnStartSheet.crop(0, 0, 454, 166);
		btn_start_hover = btnStartSheetHover.crop(0, 0, 454, 166);
		
		military_font28 = FontLoader.loadFont("res/fonts/Don't Delay, Act Now!.otf", 28);
		game_title = gameTitleSheet.crop(0, 0, 1200, 500);
		filter = filterSheet.crop(0, 0, 550, 200);
		
		avatar_base = userAvatarSheet.crop(0, 0, 512, 512);
		avatar_male = userAvatarSheet.crop(512, 0, 512, 512);
		avatar_female = userAvatarSheet.crop(1024, 0, 512, 512);

		btn_sex = btnSexSheet.crop(0, 0, 454, 166);
		btn_male_hover = btnSexSheet.crop(454, 0, 454, 166);
		btn_fem_hover = btnSexSheet.crop(908, 0, 454, 166);
		btn_male_pressed = btnSexSheet.crop(1362, 0, 454, 166);
		btn_fem_pressed = btnSexSheet.crop(1816, 0, 454, 166);

		
		user_turn_target = targetsSheet.crop(0, 0, 200, 200);
		pc_turn_target = targetsSheet.crop(200, 0, 200, 200);
		hit_target = targetsSheet.crop(400, 0, 200, 200);
		sink_target = targetsSheet.crop(600, 0, 200, 200);
		
		
	}
	public Image getIconWaveAnimation() {
		return wave_animation;
	}
	
}
