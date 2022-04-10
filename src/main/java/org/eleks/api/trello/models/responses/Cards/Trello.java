package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trello{
	private int board;
	private int card;

	public void setBoard(int board){
		this.board = board;
	}

	public int getBoard(){
		return board;
	}

	public void setCard(int card){
		this.card = card;
	}

	public int getCard(){
		return card;
	}
}
