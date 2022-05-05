package org.eleks.api.trello.models.responses.Checklist;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChecklistResponse {
	@JsonProperty("idBoard")
	private String idBoard;

	@JsonProperty("pos")
	private int pos;

	@JsonProperty("idCard")
	private String idCard;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private String id;

	@JsonProperty("checkItems")
	private List<String> checkItems;

	@JsonProperty("limits")
	private Limits limits;

	public String getIdBoard(){
		return idBoard;
	}

	public int getPos(){
		return pos;
	}

	public String getIdCard(){
		return idCard;
	}

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public List<String> getCheckItems(){
		return checkItems;
	}

	public Limits getLimits(){
		return limits;
	}

	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCheckItems(List<String> checkItems) {
		this.checkItems = checkItems;
	}

	public void setLimits(Limits limits) {
		this.limits = limits;
	}
}