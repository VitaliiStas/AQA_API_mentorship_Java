package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cover{
	private boolean idUploadedBackground;
	private String brightness;
	private String color;
	private String size;
	private boolean isTemplate;

	public void setIdUploadedBackground(boolean idUploadedBackground){
		this.idUploadedBackground = idUploadedBackground;
	}

	public boolean isIdUploadedBackground(){
		return idUploadedBackground;
	}

	public void setBrightness(String brightness){
		this.brightness = brightness;
	}

	public String getBrightness(){
		return brightness;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setIsTemplate(boolean isTemplate){
		this.isTemplate = isTemplate;
	}

	public boolean isIsTemplate(){
		return isTemplate;
	}
}
