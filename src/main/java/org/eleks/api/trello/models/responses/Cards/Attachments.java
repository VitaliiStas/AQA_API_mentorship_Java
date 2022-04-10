package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachments{
	private PerBoard perBoard;

	public void setPerBoard(PerBoard perBoard){
		this.perBoard = perBoard;
	}

	public PerBoard getPerBoard(){
		return perBoard;
	}
}
