package dev.ep2.battleship.states.components;

import java.awt.Graphics;

import dev.ep2.battleship.gfx.Assets;

public class Board {


	private final int WIDTH = 8;
	private final int HEIGHT = 8;
	
	private int animationCounterDirection = 0;
	private int animationCounter = 0;
	
	public Board() {
		

	}
	
	public void tick() {
		
		
	}
	
	public void render(Graphics g) {
	
		//refatorar esse código para a class Animation, passar para GameState o tamnho dos blocos
		//1000px / widthDada = tamBlocoX
		//1000px / heighDada = tamBlocoY
		//Criar outra Thread para rodar a animação do background
		//Preocurar outro refatoramento com threads
		
		if(animationCounterDirection == 0) {
			if (animationCounter < 20) {
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

		
		//g.drawImage(Assets.wave[animationCounter], 400, 0, null);

		
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				g.drawImage(Assets.target, i * 125 + 400, j * 125 , 125, 125, null);
			}
		}
		
	
		//System.out.println("Board");
	}
	
}
