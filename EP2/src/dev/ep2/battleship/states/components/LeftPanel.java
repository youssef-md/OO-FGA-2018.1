package dev.ep2.battleship.states.components;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.gfx.Text;

public class LeftPanel {

	private Handler handler;
	public static boolean isSingleShotPressed, isRadarPressed, isShotInAreaPressed, isAirstrikePressed, isAirstrikeVertPressed, isAirstrikeHorzPressed;
	
	
	public LeftPanel(Handler handler) {
		
		this.handler = handler;
		readPlayerInfo();
	}
	
	public void tick() {
		//Verificar as flags das habilidades, e os pontos
		
		//System.out.println("Q: " + Player.isQPressed + " W: " + Player.isWPressed + " E: " + Player.isEPressed + " R: " + Player.isRPressed);
		
		if(Player.isQPressed) {
			isSingleShotPressed = true;
			isRadarPressed = isShotInAreaPressed = isAirstrikePressed = false;
		}
			
		if(Player.isWPressed) {
			isRadarPressed = true;
			isSingleShotPressed = isShotInAreaPressed = isAirstrikePressed = false;
		}
			
		if(Player.isEPressed) {
			isShotInAreaPressed = true;
			isSingleShotPressed = isRadarPressed = isAirstrikePressed = false;
		}
		
		if(Player.isRPressed) {
			isAirstrikePressed = true;
			isSingleShotPressed = isRadarPressed = isShotInAreaPressed = false;
		}
			
		
		if(handler.getMouseManager().isLeftPressed()) 
			isSingleShotPressed = isRadarPressed = isShotInAreaPressed = isAirstrikePressed = false;
		
			
		
		
			
	}
	
	public void render(Graphics g) {
		
		g.drawImage(Assets.left_panel, 0, 0, null);
		renderPlayerData(g);
		renderStrategies(g);	
		
	}
	
	private void readPlayerInfo()  {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("playername.txt"));
			
			String line;
			try {
				line = reader.readLine();
				handler.getPlayer().setName(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		

	}
	
	private void renderPlayerData(Graphics g) {
		
		if(Player.sex == 'M')
			g.drawImage(Assets.avatar_male_ingame, 25, 25, 250, 250, null);
		else if(Player.sex == 'F')
			g.drawImage(Assets.avatar_female_ingame, 25, 25, 250, 250, null);
		
		Text.drawString(g, "cpt. " + handler.getPlayer().getName(), 150, 300, true, Color.white, Assets.military_font30);
		Text.drawString(g, "points", 150, 365, true, Color.white, Assets.military_font40);
		Text.drawString(g, handler.getPlayer().getPointsToString(), 150, 429, true, new Color(83, 125, 80), Assets.military_font50);
	}
	
	private void renderStrategies(Graphics g) {
		
		renderSingleShot(g);		
		renderRadar(g);
		renderShotInArea(g);
		renderAirStrike(g);
	}
	
	private void renderSingleShot(Graphics g) {
		
		if(!isSingleShotPressed)
			g.drawImage(Assets.btn_single_shot, 25, 479, 75, 75, null);
		else
			g.drawImage(Assets.btn_single_shot_pressed, 25, 479, 75, 75, null);

		Text.drawString(g, "single shot", 195, 504, true, Color.white, Assets.military_font30);
		Text.drawString(g, "hit Q", 141, 534, true, Color.white, Assets.military_font30);
	}
	
	private void renderRadar(Graphics g) {
		
		if(!isRadarPressed)
			g.drawImage(Assets.btn_radar, 25, 565, 75, 75, null);
		else
			g.drawImage(Assets.btn_radar_pressed, 25, 565, 75, 75, null);
		
		Text.drawString(g, "Radar 2x2", 185, 590, true, Color.white, Assets.military_font30);
		Text.drawString(g, "hit W", 148, 620, true, Color.white, Assets.military_font30);
	}
	
	private void renderShotInArea(Graphics g) {
	
		if(!isShotInAreaPressed)
			g.drawImage(Assets.btn_area_shot, 25, 650, 75, 75, null);
		else
			g.drawImage(Assets.btn_area_shot_pressed, 25, 650, 75, 75, null);
		
		Text.drawString(g, "shot in area", 198, 675, true, Color.white, Assets.military_font30);
		Text.drawString(g, "hit E", 141, 704, true, Color.white, Assets.military_font30);
	}
	
	private void renderAirStrike(Graphics g) {
		
		if(!isAirstrikePressed)
			g.drawImage(Assets.btn_airstrike, 25, 735, 75, 75, null);
		else
			g.drawImage(Assets.btn_airstrike_pressed, 25, 735, 75, 75, null);
		
		Text.drawString(g, "Airstrike", 178, 760, true, Color.white, Assets.military_font30);
		Text.drawString(g, "hit R", 141, 789, true, Color.white, Assets.military_font30);
	}
	
}
