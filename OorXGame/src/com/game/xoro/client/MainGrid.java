package com.game.xoro.client;
import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class MainGrid implements ClickHandler{
    Grid grid;
	ArrayList<Cell> cells;
	HorizontalPanel hp_main_grid; 
	Button current_cell= new Button();
	boolean game_over=false;
	boolean is_player_toggle= false;
	ArrayList<Player> players = new ArrayList<Player>();
    
	public void init() {
		this.grid= new Grid(3,3);
		this.cells=new ArrayList<Cell>();
		this.createCells();
		this.initCells();
		this.addListenerOnCells();
		this.game_over=false;
		this.is_player_toggle=false;
	}
	
	public void initTextCells() {
		for(Cell cell:this.cells){
    		cell.getSquare().setText("");
    		this.game_over=false;
    		this.is_player_toggle=false;
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
		this.hp_main_grid = new HorizontalPanel();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells.get(i * 3 + j).setPixelSize(50, 50);
				grid.setWidget(i, j, cells.get(i * 3 + j).getSquare());
			}
		}
	    this.hp_main_grid.add(grid);
	    return this.hp_main_grid;
	}

	@Override
	public void onClick(ClickEvent event) {
		this.current_cell=(Button) event.getSource();
		if (!this.game_over) {
			if (current_cell.getText().equals("")) {
				if (is_player_toggle) {

					current_cell.setText("X");
					this.gameOver();

				} else {
					current_cell.setText("O");
					this.gameOver();
				}
				is_player_toggle = !is_player_toggle;
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
						this.game_over = true;
						this.updateScore(tab[i][h]);
						Window.alert(" Player " + tab[i][h] + "  WIN :) ");

					}

				}
				if (i == 0) {
					if (tab[i][h].equals(tab[i + 1][h])
							&& tab[i + 2][h].equals(tab[i][h])
							&& (tab[i][h].equals("O") || tab[i][h]
									.equals("X"))) {
						this.game_over = true;
						this.updateScore(tab[i][h]);
						Window.alert(" Player " + tab[i][h] + "  WIN :) ");
					}

				}

				if ((i == h) && h == 0
						&& tab[i][h].equals(tab[i + 1][h + 1])
						&& tab[i][h].equals(tab[i + 2][h + 2])
						&& (tab[i][h].equals("O") || tab[i][h].equals("X"))) {
					this.game_over = true;
					this.updateScore(tab[i][h]);
					Window.alert(" Player " + tab[i][h] + "  WIN :) ");
				}
				if ((i == 0) && h == 2
						&& tab[i][h].equals(tab[i + 1][h - 1])
						&& tab[i][h].equals(tab[i + 2][h - 2])
						&& (tab[i][h].equals("O") || tab[i][h].equals("X"))) {
					this.game_over = true;
					this.updateScore(tab[i][h]);
					Window.alert(" Player " + tab[i][h] + "  WIN :) ");
				}
			}
		}
	}

	public void addPlayerToUpdateHisScore(ArrayList<Player> players) {
		this.players= players;
	}

	private void updateScore(String player_end_name) {
		String player_name="player_"+player_end_name.toLowerCase();
		for(Player player:this.players){
			if(player.getName().equals(player_name)){
				player.playerWin();
				Label label_score= player.getScore_player();
				String score_on_label=player.getScore()+"";
				label_score.setText(score_on_label);		
				player.setScore_player(label_score);
				return;
			}
		}
	}

	
}


