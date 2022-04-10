package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdChecklistsItem{
	private String id;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}
