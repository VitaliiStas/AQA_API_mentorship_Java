package org.eleks.api.trello.models.requests.board_request_nested_objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelNames{

	@JsonProperty("orange")
	private String orange;

	@JsonProperty("red")
	private String red;

	@JsonProperty("sky")
	private String sky;

	@JsonProperty("pink")
	private String pink;

	@JsonProperty("green")
	private String green;

	@JsonProperty("blue")
	private String blue;

	@JsonProperty("lime")
	private String lime;

	@JsonProperty("yellow")
	private String yellow;

	@JsonProperty("black")
	private String black;

	@JsonProperty("purple")
	private String purple;

	public void setOrange(String orange){
		this.orange = orange;
	}

	public String getOrange(){
		return orange;
	}

	public void setRed(String red){
		this.red = red;
	}

	public String getRed(){
		return red;
	}

	public void setSky(String sky){
		this.sky = sky;
	}

	public String getSky(){
		return sky;
	}

	public void setPink(String pink){
		this.pink = pink;
	}

	public String getPink(){
		return pink;
	}

	public void setGreen(String green){
		this.green = green;
	}

	public String getGreen(){
		return green;
	}

	public void setBlue(String blue){
		this.blue = blue;
	}

	public String getBlue(){
		return blue;
	}

	public void setLime(String lime){
		this.lime = lime;
	}

	public String getLime(){
		return lime;
	}

	public void setYellow(String yellow){
		this.yellow = yellow;
	}

	public String getYellow(){
		return yellow;
	}

	public void setBlack(String black){
		this.black = black;
	}

	public String getBlack(){
		return black;
	}

	public void setPurple(String purple){
		this.purple = purple;
	}

	public String getPurple(){
		return purple;
	}


}
