package dev.ep2.battleship.gfx;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Assets {

	public static BufferedImage user_turn_target, pc_turn_target, hit_target, sink_target, filter, btn_start, btn_start_hover, game_title;
	public static BufferedImage avatar_base, avatar_male, avatar_male_ingame, avatar_female, avatar_female_ingame, btn_sex, btn_male_hover, btn_male_pressed;
	public static BufferedImage btn_fem_hover, btn_fem_pressed, btn_rank, btn_rank_hover, btn_ok_warning, btn_ok_warning_hover; 
	public static BufferedImage btn_single_shot, btn_radar, btn_area_shot, btn_airstrike, btn_airstrike_vertical, btn_airstrike_horizontal;
	public static BufferedImage btn_single_shot_pressed, btn_radar_pressed, btn_area_shot_pressed, btn_airstrike_pressed, btn_airstrike_vertical_pressed, btn_airstrike_horizontal_pressed;
	public static BufferedImage popup_warning, left_panel;
	
	public Image wave_animation = new ImageIcon(getClass().getResource("/textures/wave_animation.gif")).getImage();
	public static Font military_font30, military_font40, military_font50;

	
	public static void init() {
		
		loadStrategies();
		loadFonts();
		loadAvatars();
		loadBtnSex();
		loadTargets();	
		loadPanels();
		
		SpriteSheet gameTitleSheet = new SpriteSheet(ImageLoader.loadImage("/textures/game_title.png"));
		game_title = gameTitleSheet.crop(0, 0, 1200, 500);
		
		SpriteSheet filterSheet = new SpriteSheet(ImageLoader.loadImage("/textures/filter.png"));
		filter = filterSheet.crop(0, 0, 550, 200);
		
		SpriteSheet btnStartSheet = new SpriteSheet(ImageLoader.loadImage("/textures/btn_start.png"));
		SpriteSheet btnStartSheetHover = new SpriteSheet(ImageLoader.loadImage("/textures/btn_start_hover.png"));
		
		SpriteSheet btnRankSheet = new SpriteSheet(ImageLoader.loadImage("/textures/btn_rank.png"));
		SpriteSheet btnRankSheetHover = new SpriteSheet(ImageLoader.loadImage("/textures/btn_rank_hover.png"));
		
		SpriteSheet btnOkSheet = new SpriteSheet(ImageLoader.loadImage("/textures/btn_ok_warning.png"));
		SpriteSheet btnOkSheetHover = new SpriteSheet(ImageLoader.loadImage("/textures/btn_ok_warning_hover.png"));
		
		SpriteSheet popupsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/popup_warning.png"));
		
		
		popup_warning = popupsSheet.crop(0, 0, 1129, 585);
		
		btn_start = btnStartSheet.crop(0, 0, 454, 166);
		btn_start_hover = btnStartSheetHover.crop(0, 0, 454, 166);
		btn_rank = btnRankSheet.crop(0, 0, 454, 166);
		btn_rank_hover = btnRankSheetHover.crop(0, 0, 454, 166);
		btn_ok_warning = btnOkSheet.crop(0, 0, 454, 166);
		btn_ok_warning_hover = btnOkSheetHover.crop(0, 0, 454, 166);
	
		
			
		
	}
	
	private static void loadStrategies() {
		
		SpriteSheet strategiesSheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet_btn_strategy.png"));
		SpriteSheet strategiesPressedSheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet_btn_strategy_pressed.png"));
		
		
		btn_single_shot = strategiesSheet.crop(0, 0, 150, 150);
		btn_radar = strategiesSheet.crop(150, 0, 150, 150);
		btn_area_shot = strategiesSheet.crop(300, 0, 150, 150);
		btn_airstrike = strategiesSheet.crop(450, 0, 150, 150);
		btn_airstrike_vertical = strategiesSheet.crop(600, 0, 150, 150);
		btn_airstrike_horizontal = strategiesSheet.crop(750, 0, 150, 150);
		
		btn_single_shot_pressed = strategiesPressedSheet.crop(0, 0, 150, 150);
		btn_radar_pressed = strategiesPressedSheet.crop(150, 0, 150, 150);
		btn_area_shot_pressed = strategiesPressedSheet.crop(300, 0, 150, 150);
		btn_airstrike_pressed = strategiesPressedSheet.crop(450, 0, 150, 150);
		btn_airstrike_vertical_pressed = strategiesPressedSheet.crop(600, 0, 150, 150);
		btn_airstrike_horizontal_pressed = strategiesPressedSheet.crop(750, 0, 150, 150);
	}
	
	private static void loadFonts() {
		
		military_font30 = FontLoader.loadFont("res/fonts/Don't Delay, Act Now!.otf", 30);
		military_font40 = FontLoader.loadFont("res/fonts/Don't Delay, Act Now!.otf", 40);
		military_font50 = FontLoader.loadFont("res/fonts/Don't Delay, Act Now!.otf", 50);
	}
	
	private static void loadAvatars() {
		
		SpriteSheet userAvatarSheet  = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet_user_avatar.png"));
		
		avatar_base = userAvatarSheet.crop(0, 0, 512, 512);
		avatar_male = userAvatarSheet.crop(512, 0, 512, 512);
		avatar_female = userAvatarSheet.crop(1024, 0, 512, 512);
		avatar_male_ingame = userAvatarSheet.crop(1536, 0, 512, 512);
		avatar_female_ingame = userAvatarSheet.crop(2048, 0, 512, 512);
	}
	
	private static void loadBtnSex() {
		
		SpriteSheet btnSexSheet  = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet_btn_sex.png"));
		
		btn_sex = btnSexSheet.crop(0, 0, 454, 166);
		btn_male_hover = btnSexSheet.crop(454, 0, 454, 166);
		btn_fem_hover = btnSexSheet.crop(908, 0, 454, 166);
		btn_male_pressed = btnSexSheet.crop(1362, 0, 454, 166);
		btn_fem_pressed = btnSexSheet.crop(1816, 0, 454, 166);

	}
	
	private static void loadTargets() {
		
		SpriteSheet targetsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/targets_sprite_sheet.png"));
		
		user_turn_target = targetsSheet.crop(0, 0, 200, 200);
		pc_turn_target = targetsSheet.crop(200, 0, 200, 200);
		hit_target = targetsSheet.crop(400, 0, 200, 200);
		sink_target = targetsSheet.crop(600, 0, 200, 200);

	}
	
	private static void loadPanels() {
		
		SpriteSheet panelsSheet  = new SpriteSheet(ImageLoader.loadImage("/textures/left_panel.png"));
		
		left_panel = panelsSheet.crop(0, 0, 300, 840);
	}
	
	
	
	public Image getIconWaveAnimation() {
		return wave_animation;
	}
	
}
