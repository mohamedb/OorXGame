package com.game.xoro.client;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
public class Player {
  int score=0;
  HorizontalPanel hp_players;
  Label score_player;
  String name="player";
  
  public Player(String name){
	 
	  this.score_player= new Label();
	  this.name= name;
	  this.initScore();
  }
  public Label getScore_player() {
	return score_player;
}
public void setScore_player(Label score_player) {
	this.score_player = score_player;
}
public String getName() {
	return name;
  }
  public void playerWin(){
	  this.score++;
  }
public void setName(String name) {
	this.name = name;
}
public Player(){
	  this.score_player= new Label();
	  this.initScore();
  }
  public int getScore() {
	return score;
  }

  public void setScore(int score) {
	this.score = score;
	this.score_player.setText(""+this.score);
  }

  public void initScore() {
	this.score=0;
	this.score_player.setPixelSize(40, 40);
	this.score_player.setText(this.score+"");
  }
  public HorizontalPanel drawUi(){
	  this.hp_players= new HorizontalPanel();
	  this.hp_players.add(this.score_player);
	  return this.hp_players;
  }
}
