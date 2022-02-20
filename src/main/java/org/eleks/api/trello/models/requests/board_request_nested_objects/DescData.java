package org.eleks.api.trello.models.requests.board_request_nested_objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DescData{

	@JsonProperty("emoji")
	private Emoji emoji;

	public void setEmoji(Emoji emoji){
		this.emoji = emoji;
	}

	public Emoji getEmoji(){
		return emoji;
	}
}