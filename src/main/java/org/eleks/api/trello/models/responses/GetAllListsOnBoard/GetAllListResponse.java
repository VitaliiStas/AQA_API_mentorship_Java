package org.eleks.api.trello.models.responses.GetAllListsOnBoard;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllListResponse {

	@JsonProperty("GetAllListResponse")
	private List<GetAllListResponseItem> response;

	public void setResponse(List<GetAllListResponseItem> response){
		this.response = response;
	}

	public List<GetAllListResponseItem> getResponse(){
		return response;
	}
}