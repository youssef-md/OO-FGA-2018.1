package dev.ep2.battleship.states;

import java.awt.Graphics;

import dev.ep2.battleship.Handler;
import dev.ep2.battleship.entities.creatures.Player;
import dev.ep2.battleship.gfx.Assets;
import dev.ep2.battleship.states.components.Board;
import dev.ep2.battleship.states.components.LeftPanel;
import dev.ep2.battleship.states.components.MessagePopUp;

public class GameView extends State{

	private Board board;
	private LeftPanel leftPanel;
	private Assets assets;
	private MessagePopUp messagePopUp;
	private final String ID = "GameView"; 
		
	public GameView(Handler handler, String boardPath) {
		
		super(handler);	
		handler.getMouseManager().setLeftPressed(false);
		assets = new Assets();
		handler.setPlayer(new Player(handler, 30, 150)); //(x,y) para posicionar o hp do player
		leftPanel = new LeftPanel(handler);
		board = new Board(boardPath, handler);
		messagePopUp = new MessagePopUp(handler);
	}
	

	
	@Override
	public void tick() {
		
		leftPanel.tick();
		board.tick();  
		handler.getPlayer().tick();		
		
		//System.out.println("x: " + handler.getMouseManager().getMouseX() + " y: " + handler.getMouseManager().getMouseY());
	}

	@Override	
	public void render(Graphics g) {
		
		//render wave animation
		
		g.drawImage(assets.getIconWaveAnimation(), board.BORDER, 0, board.BOARD_RESOLUTION, board.BOARD_RESOLUTION, null);
		g.drawImage(Assets.filter, board.BORDER, 0, board.BOARD_RESOLUTION, board.BOARD_RESOLUTION, null);

		leftPanel.render(g);
		board.render(g);
		if(handler.getPlayer().getPoints() < 40) {
			messagePopUp.youLose("you lost", g);
		}
			//salvar os pontos num arquivo e fechar o jogo
			
	}

	@Override
	public String getID() {
		
		return ID;
	}
	
	
	
	

	
}
