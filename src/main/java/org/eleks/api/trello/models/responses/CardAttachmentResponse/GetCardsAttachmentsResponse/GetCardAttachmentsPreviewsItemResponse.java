package org.eleks.api.trello.models.responses.CardAttachmentResponse.GetCardsAttachmentsResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCardAttachmentsPreviewsItemResponse {

	@JsonProperty("scaled")
	private boolean scaled;

	@JsonProperty("bytes")
	private int bytes;

	@JsonProperty("width")
	private int width;

	@JsonProperty("id")
	private String id;

	@JsonProperty("_id")
	private String _id;

	@JsonProperty("url")
	private String url;

	@JsonProperty("height")
	private int height;

	public void setScaled(boolean scaled){
		this.scaled = scaled;
	}

	public boolean isScaled(){
		return scaled;
	}

	public void setBytes(int bytes){
		this.bytes = bytes;
	}

	public int getBytes(){
		return bytes;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void set_id(String _id){
		this._id = _id;
	}

	public String get_Id(){
		return _id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}
}