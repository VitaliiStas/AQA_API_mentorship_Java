package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentsByType{
	private Trello trello;

	public void setTrello(Trello trello){
		this.trello = trello;
	}

	public Trello getTrello(){
		return trello;
	}
}
