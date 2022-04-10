package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Limits{
	private Attachments attachments;

	public void setAttachments(Attachments attachments){
		this.attachments = attachments;
	}

	public Attachments getAttachments(){
		return attachments;
	}
}
