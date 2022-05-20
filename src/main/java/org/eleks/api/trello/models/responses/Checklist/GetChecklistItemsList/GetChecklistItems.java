package org.eleks.api.trello.models.responses.Checklist.GetChecklistItemsList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetChecklistItems {

	@JsonProperty("pos")
	private int pos;

	@JsonProperty("due")
	private Object due;

	@JsonProperty("idChecklist")
	private String idChecklist;

	@JsonProperty("idMember")
	private Object idMember;

	@JsonProperty("name")
	private String name;

	@JsonProperty("nameData")
	private NameData nameData;

	@JsonProperty("state")
	private String state;

	@JsonProperty("id")
	private String id;

	public void setPos(int pos){
		this.pos = pos;
	}

	public int getPos(){
		return pos;
	}

	public void setDue(Object due){
		this.due = due;
	}

	public Object getDue(){
		return due;
	}

	public void setIdChecklist(String idChecklist){
		this.idChecklist = idChecklist;
	}

	public String getIdChecklist(){
		return idChecklist;
	}

	public void setIdMember(Object idMember){
		this.idMember = idMember;
	}

	public Object getIdMember(){
		return idMember;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setNameData(NameData nameData){
		this.nameData = nameData;
	}

	public NameData getNameData(){
		return nameData;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}