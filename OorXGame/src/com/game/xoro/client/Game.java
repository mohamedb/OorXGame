package com.game.xoro.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class Game implements ClickHandler{

	ArrayList<Player> players;
	Player playerO,
	       playerX;
	MainGrid mainGrid;
	Button initScoresBtn;
	Button newGameBtn;

	public Game(){
		this.initComposants();
		this.drawUi();
	}
	public void newGame(){
		this.initGrid();
	}
	public void start() {

	}
	public void initComposants(){
		/* it's highly recommended to respect the LOGICAL order of instantiations and calls */
		this.mainGrid= new MainGrid();
		this.mainGrid.init();
		this.initScoresBtn= new Button();
		this.newGameBtn=new Button("New Game");
		this.initScoresBtn.setText("Init scores");
		this.players= new ArrayList<Player>();
		this.playerO= new Player("playerO");
		this.playerX= new Player("playerX");
		this.players.add(this.playerO);
		this.players.add(this.playerX);
		this.mainGrid.addPlayerToUpdateHisScore(this.players);
		this.initScores();
		this.initScoresBtn.addClickHandler((ClickHandler) this);
		this.newGameBtn.addClickHandler((ClickHandler) this);
	
	}
	public void drawUi(){
		RootPanel.get("newGameBtn").add( this.newGameBtn);
		RootPanel.get("initScoresBtn").add( this.initScoresBtn);
		RootPanel.get("mainGrid").add( this.mainGrid.drawUi());
		RootPanel.get("playerO").add(this.playerO.drawUi());
		RootPanel.get("playerX").add(this.playerX.drawUi());
		
	}
	public void initGrid(){
		this.mainGrid.init();
	}

	public void initScores(){
		this.playerO.initScore();
		this.playerX.initScore();
	}
	@Override
	public void onClick(ClickEvent event) {
		if(event.getSource()==this.initScoresBtn){
			this.initScores();
			return;
		}
		if(event.getSource()==this.newGameBtn){
			//this.initScores();
			this.initTextOfCellsInCurrentGrid();
			return;
		}
	}
	private void initTextOfCellsInCurrentGrid() {
		this.mainGrid.initTextCells();
	}

}
