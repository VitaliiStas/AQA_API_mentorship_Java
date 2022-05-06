package org.eleks.api.trello.models.responses.Checklist.GetChecklistItemsList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NameData{

	@JsonProperty("emoji")
	private Emoji emoji;

	public void setEmoji(Emoji emoji){
		this.emoji = emoji;
	}

	public Emoji getEmoji(){
		return emoji;
	}
}