package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PerBoard{
	private int warnAt;
	private int disableAt;
	private String status;

	public void setWarnAt(int warnAt){
		this.warnAt = warnAt;
	}

	public int getWarnAt(){
		return warnAt;
	}

	public void setDisableAt(int disableAt){
		this.disableAt = disableAt;
	}

	public int getDisableAt(){
		return disableAt;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}
