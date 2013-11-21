package com.game.xoro.client;
import com.google.gwt.user.client.ui.Button;
public class Cell {
    Button square;
   
	public Cell(){
    	this.init();
    }
	 public Button getSquare() {
			return this.square;
		}
	public void init() {
		this.square= new Button("Cell");
		this.square.setText("");
		this.setPixelSize(50, 50);
	}
	public void setPixelSize(int i, int j) {
		this.square.setPixelSize(i, j);
	}
	
  
}
