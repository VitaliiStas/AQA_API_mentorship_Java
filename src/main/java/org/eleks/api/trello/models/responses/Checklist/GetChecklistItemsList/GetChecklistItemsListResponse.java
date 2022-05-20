package org.eleks.api.trello.models.responses.Checklist.GetChecklistItemsList;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChecklistItemsListResponse {

	@JsonProperty("GetChecklistItemsListResponse")
	private List<GetChecklistItems> response;

	public void setResponse(List<GetChecklistItems> response){
		this.response = response;
	}

	public List<GetChecklistItems> getResponse(){
		return response;
	}
}