package com.game.xoro.client;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
public class Player {
  int score=0;
  HorizontalPanel playerHorizontalPanel;
  Label scoreLabel;
  String name="player";
  
  public Player(String name){
	 
	  this.scoreLabel= new Label();
	  this.name= name;
	  this.initScore();
  }
  public Label getscoreLabel() {
	return scoreLabel;
}
public void setscoreLabel(Label scoreLabel) {
	this.scoreLabel = scoreLabel;
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
	  this.scoreLabel= new Label();
	  this.initScore();
  }
  public int getScore() {
	return score;
  }

  public void setScore(int score) {
	this.score = score;
	this.scoreLabel.setText(""+this.score);
  }

  public void initScore() {
	this.score=0;
	this.scoreLabel.setPixelSize(40, 40);
	this.scoreLabel.setText(this.score+"");
  }
  public HorizontalPanel drawUi(){
	  this.playerHorizontalPanel= new HorizontalPanel();
	  this.playerHorizontalPanel.add(this.scoreLabel);
	  return this.playerHorizontalPanel;
  }
}
