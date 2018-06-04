package dev.ep2.battleship.states.components;

import java.awt.Color;
import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.gfx.Text;

public class LeftPanel {

	private Handler handler;
	private boolean isSingleShotPressed, isRadarPressed, isAreaShotPressed, isAirstrikePressed, isAirstrikeVertPressed, isAirstrikeHorzPressed;
	
	
	public LeftPanel(Handler handler) {
		
		this.handler = handler;
	}
	
	public void tick() {
		//Verificar as flags das habilidades, e os pontos
		
		//System.out.println("Q: " + Player.isQPressed + " W: " + Player.isWPressed + " E: " + Player.isEPressed + " R: " + Player.isRPressed);
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(Assets.left_panel, 0, 0, null);
		
		if(Player.sex == 'M')
			g.drawImage(Assets.avatar_male_ingame, 25, 25, 250, 250, null);
		else if(Player.sex == 'F')
			g.drawImage(Assets.avatar_female_ingame, 25, 25, 250, 250, null);
		
		Text.drawString(g, "cpt.youssef", 150, 300, true, Color.white, Assets.military_font30);
		Text.drawString(g, "points", 150, 365, true, Color.white, Assets.military_font40);
		Text.drawString(g, "9999", 150, 429, true, new Color(99, 184, 203), Assets.military_font50);
		
		
		g.drawImage(Assets.btn_single_shot, 25, 479, 75, 75, null);
		Text.drawString(g, "single shot", 195, 504, true, Color.white, Assets.military_font30);
		Text.drawString(g, "hit Q", 141, 534, true, Color.white, Assets.military_font30);
		
		g.drawImage(Assets.btn_radar, 25, 565, 75, 75, null);
		Text.drawString(g, "Radar 2x2", 185, 590, true, Color.white, Assets.military_font30);
		Text.drawString(g, "hit W", 148, 620, true, Color.white, Assets.military_font30);
		
		g.drawImage(Assets.btn_area_shot, 25, 650, 75, 75, null);
		Text.drawString(g, "shot in area", 198, 675, true, Color.white, Assets.military_font30);
		Text.drawString(g, "hit E", 141, 704, true, Color.white, Assets.military_font30);
		
		g.drawImage(Assets.btn_airstrike, 25, 735, 75, 75, null);
		Text.drawString(g, "Airstrike", 178, 760, true, Color.white, Assets.military_font30);
		Text.drawString(g, "hit R", 141, 789, true, Color.white, Assets.military_font30);
		
		
	}
}
