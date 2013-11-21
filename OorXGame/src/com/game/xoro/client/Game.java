package com.game.xoro.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class Game implements ClickHandler{

	ArrayList<Player> players;
	Player player_o,player_x;
	MainGrid main_grid;
	Button init_scores;
	Button new_game;

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
		this.main_grid= new MainGrid();
		this.main_grid.init();
		this.init_scores= new Button();
		this.new_game=new Button("New Game");
		this.init_scores.setText("Init scores");
		this.players= new ArrayList<Player>();
		this.player_o= new Player("player_o");
		this.player_x= new Player("player_x");
		this.players.add(this.player_o);
		this.players.add(this.player_x);
		this.main_grid.addPlayerToUpdateHisScore(this.players);
		this.initScores();
		this.init_scores.addClickHandler((ClickHandler) this);
		this.new_game.addClickHandler((ClickHandler) this);
	
	}
	public void drawUi(){
		RootPanel.get("new_game").add( this.new_game);
		RootPanel.get("init_scores").add( this.init_scores);
		RootPanel.get("main_grid").add( this.main_grid.drawUi());
		RootPanel.get("player_o").add(this.player_o.drawUi());
		RootPanel.get("player_x").add(this.player_x.drawUi());
		
	}
	public void initGrid(){
		this.main_grid.init();
	}

	public void initScores(){
		this.player_o.initScore();
		this.player_x.initScore();
	}
	@Override
	public void onClick(ClickEvent event) {
		if(event.getSource()==this.init_scores){
			this.initScores();
			return;
		}
		if(event.getSource()==this.new_game){
			//this.initScores();
			this.initTextOfCellsInCurrentGrid();
			return;
		}
	}
	private void initTextOfCellsInCurrentGrid() {
		this.main_grid.initTextCells();
	}

}
