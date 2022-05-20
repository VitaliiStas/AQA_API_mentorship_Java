package org.eleks.api.trello.models.responses.CardAttachmentResponse.GetCardsAttachmentsResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCardAttachmentsResponseItemResponse {

	@JsonProperty("date")
	private String date;

	@JsonProperty("edgeColor")
	private String edgeColor;

	@JsonProperty("fileName")
	private String fileName;

	@JsonProperty("pos")
	private int pos;

	@JsonProperty("bytes")
	private int bytes;

	@JsonProperty("idMember")
	private String idMember;

	@JsonProperty("name")
	private String name;

	@JsonProperty("previews")
	private List<GetCardAttachmentsPreviewsItemResponse> previews;

	@JsonProperty("id")
	private String id;

	@JsonProperty("isUpload")
	private boolean isUpload;

	@JsonProperty("mimeType")
	private String mimeType;

	@JsonProperty("url")
	private String url;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setEdgeColor(String edgeColor){
		this.edgeColor = edgeColor;
	}

	public String getEdgeColor(){
		return edgeColor;
	}

	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	public String getFileName(){
		return fileName;
	}

	public void setPos(int pos){
		this.pos = pos;
	}

	public int getPos(){
		return pos;
	}

	public void setBytes(int bytes){
		this.bytes = bytes;
	}

	public int getBytes(){
		return bytes;
	}

	public void setIdMember(String idMember){
		this.idMember = idMember;
	}

	public String getIdMember(){
		return idMember;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPreviews(List<GetCardAttachmentsPreviewsItemResponse> previews){
		this.previews = previews;
	}

	public List<GetCardAttachmentsPreviewsItemResponse> getPreviews(){
		return previews;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setIsUpload(boolean isUpload){
		this.isUpload = isUpload;
	}

	public boolean isIsUpload(){
		return isUpload;
	}

	public void setMimeType(String mimeType){
		this.mimeType = mimeType;
	}

	public String getMimeType(){
		return mimeType;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}