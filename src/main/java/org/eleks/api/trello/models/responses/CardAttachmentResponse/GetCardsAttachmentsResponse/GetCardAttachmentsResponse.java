package org.eleks.api.trello.models.responses.CardAttachmentResponse.GetCardsAttachmentsResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCardAttachmentsResponse {

	@JsonProperty("GetCardAttachmentsResponse")
	private List<GetCardAttachmentsResponseItemResponse> response;

	public void setResponse(List<GetCardAttachmentsResponseItemResponse> response){
		this.response = response;
	}

	public List<GetCardAttachmentsResponseItemResponse> getResponse(){
		return response;
	}
}