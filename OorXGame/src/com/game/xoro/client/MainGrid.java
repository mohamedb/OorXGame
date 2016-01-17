package com.game.xoro.client;
import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class MainGrid implements ClickHandler{
    Grid grid;
	ArrayList<Cell> cells;
	HorizontalPanel mainGridHorizontalPanel; 
	Button currentCellBtn= new Button();
	boolean isGameOver=false;
	boolean isPlayerToggle= false;
	ArrayList<Player> players = new ArrayList<Player>();
    
	public void init() {
		this.grid= new Grid(3,3);
		this.cells=new ArrayList<Cell>();
		this.createCells();
		this.initCells();
		this.addListenerOnCells();
		this.isGameOver=false;
		this.isPlayerToggle=false;
	}
	
	public void initTextCells() {
		for(Cell cell:this.cells){
    		cell.getSquare().setText("");
    		this.isGameOver=false;
    		this.isPlayerToggle=false;
    	}
	}
	
	public void createCells(){
		for (int i = 0; i < 9; i++) {
			this.cells.add(new Cell());
			 
		}
	}
	 public void initCells(){
	    	for(Cell cell:this.cells){
	    		cell.init();
	    	}
	    	     
	    }
	 public void addListenerOnCells(){
		 for(Cell cell:this.cells){
			 cell.getSquare().addClickHandler((ClickHandler)this);
		 }
	 }

	public HorizontalPanel drawUi() {
		this.mainGridHorizontalPanel = new HorizontalPanel();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells.get(i * 3 + j).setPixelSize(50, 50);
				grid.setWidget(i, j, cells.get(i * 3 + j).getSquare());
			}
		}
	    this.mainGridHorizontalPanel.add(grid);
	    return this.mainGridHorizontalPanel;
	}

	@Override
	public void onClick(ClickEvent event) {
		this.currentCellBtn=(Button) event.getSource();
		if (!this.isGameOver) {
			if (currentCellBtn.getText().equals("")) {
				if (isPlayerToggle) {

					currentCellBtn.setText("X");
					this.gameOver();

				} else {
					currentCellBtn.setText("O");
					this.gameOver();
				}
				isPlayerToggle = !isPlayerToggle;
			} else {
				Window.alert("The square is already taken !");
			}
		} else 
			Window.alert("Game is Over! ");
	}
	public void gameOver() {
		String[][] tab = new String[3][3];

		int j = 0, k = 0;
		for (int i = 0; i < 9; i++) {
		 
			tab[j][k] = cells.get(i).getSquare().getText();
			k++;
			if (k % 3 == 0) {
				k = 0;
				j++;
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int h = 0; h < 3; h++) {
				if (h == 0) {
					if (tab[i][h].equals(tab[i][h + 1])
							&& tab[i][h].equals(tab[i][h + 2])
							&& (tab[i][h].equals("O") || tab[i][h]
									.equals("X"))) {
						this.isGameOver = true;
						this.updateScore(tab[i][h]);
						Window.alert(" Player " + tab[i][h] + "  WIN :) ");

					}

				}
				if (i == 0) {
					if (tab[i][h].equals(tab[i + 1][h])
							&& tab[i + 2][h].equals(tab[i][h])
							&& (tab[i][h].equals("O") || tab[i][h]
									.equals("X"))) {
						this.isGameOver = true;
						this.updateScore(tab[i][h]);
						Window.alert(" Player " + tab[i][h] + "  WIN :) ");
					}

				}

				if ((i == h) && h == 0
						&& tab[i][h].equals(tab[i + 1][h + 1])
						&& tab[i][h].equals(tab[i + 2][h + 2])
						&& (tab[i][h].equals("O") || tab[i][h].equals("X"))) {
					this.isGameOver = true;
					this.updateScore(tab[i][h]);
					Window.alert(" Player " + tab[i][h] + "  WIN :) ");
				}
				if ((i == 0) && h == 2
						&& tab[i][h].equals(tab[i + 1][h - 1])
						&& tab[i][h].equals(tab[i + 2][h - 2])
						&& (tab[i][h].equals("O") || tab[i][h].equals("X"))) {
					this.isGameOver = true;
					this.updateScore(tab[i][h]);
					Window.alert(" Player " + tab[i][h] + "  WIN :) ");
				}
			}
		}
	}

	public void addPlayerToUpdateHisScore(ArrayList<Player> players) {
		this.players= players;
	}

	private void updateScore(String playerEndName) {
		String playerName="player_"+playerEndName.toLowerCase();
		for(Player player:this.players){
			if(player.getName().equals(playerName)){
				player.playerWin();
				Label scoreLabel= player.getScore_player();
				String scoreOnLabel=player.getScore()+"";
				scoreLabel.setText(scoreOnLabel);		
				player.setScore(scoreLabel);
				return;
			}
		}
	}

	
}


