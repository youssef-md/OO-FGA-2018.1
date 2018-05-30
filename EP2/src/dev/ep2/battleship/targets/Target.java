package dev.ep2.battleship.targets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Target {

	protected BufferedImage texture;
	
	protected final int ID;
	
	public static Target[] targets	= new Target[5];
	
	public static Target userTurnTarget = new UserTurnTarget(0);
	public static Target pcTurnTarget = new PCTurnTarget(1);
	public static Target hitTarget = new HitTarget(2);
	public static Target sinkTarget = new SinkTarget(3);

	
	public Target(BufferedImage texture, int ID) {
		
		this.texture = texture;
		this.ID = ID;
		
		targets[ID] = this; // Creating an array of different types of Target Objects
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y, int targetWidth, int targetHeight) {
		
		g.drawImage(texture, x, y, targetWidth, targetHeight, null);
	}
	
	
	public boolean isClickable() {
		
		return true;
	}
	
}
