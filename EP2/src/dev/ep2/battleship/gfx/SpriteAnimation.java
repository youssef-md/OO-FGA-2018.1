package dev.ep2.battleship.gfx;

import java.awt.image.BufferedImage;

public class SpriteAnimation {

	private BufferedImage bs_sheet;
	private int numberOfFrames;
	private int animationCounterDirection;
	private int animationCounter;
	private int x;
	private int y;

	public SpriteAnimation(BufferedImage bs_sheet, int numberOfFrames,  int x, int y) {
		
		this.bs_sheet = bs_sheet;
		this.numberOfFrames = numberOfFrames;
		this.x = x;
		this.y = y;
	}
	
	public void animate() {
		
		if(animationCounterDirection == 0) {
			if (animationCounter < numberOfFrames) {
				animationCounter++;
			}
			else {
				animationCounterDirection = 1;
			}
		}
		else {
			if (animationCounter > 0) {
				animationCounter--;
			}
			else {
				animationCounterDirection = 0;
			}
		}
	
		//g.drawImage(bs_sheet[animationCounter], x, y, null);
	}
}
