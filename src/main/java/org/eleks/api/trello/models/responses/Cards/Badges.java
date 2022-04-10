package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Badges{
	private int comments;
	private int attachments;
	private AttachmentsByType attachmentsByType;
	private boolean dueComplete;
	private boolean description;
	private boolean subscribed;
	private String due;
	private boolean viewingMemberVoted;
	private boolean location;
	private int votes;
	private String fogbugz;
	private int checkItems;
	private int checkItemsChecked;

	public void setComments(int comments){
		this.comments = comments;
	}

	public int getComments(){
		return comments;
	}

	public void setAttachments(int attachments){
		this.attachments = attachments;
	}

	public int getAttachments(){
		return attachments;
	}

	public void setAttachmentsByType(AttachmentsByType attachmentsByType){
		this.attachmentsByType = attachmentsByType;
	}

	public AttachmentsByType getAttachmentsByType(){
		return attachmentsByType;
	}

	public void setDueComplete(boolean dueComplete){
		this.dueComplete = dueComplete;
	}

	public boolean isDueComplete(){
		return dueComplete;
	}

	public void setDescription(boolean description){
		this.description = description;
	}

	public boolean isDescription(){
		return description;
	}

	public void setSubscribed(boolean subscribed){
		this.subscribed = subscribed;
	}

	public boolean isSubscribed(){
		return subscribed;
	}

	public void setDue(String due){
		this.due = due;
	}

	public String getDue(){
		return due;
	}

	public void setViewingMemberVoted(boolean viewingMemberVoted){
		this.viewingMemberVoted = viewingMemberVoted;
	}

	public boolean isViewingMemberVoted(){
		return viewingMemberVoted;
	}

	public void setLocation(boolean location){
		this.location = location;
	}

	public boolean isLocation(){
		return location;
	}

	public void setVotes(int votes){
		this.votes = votes;
	}

	public int getVotes(){
		return votes;
	}

	public void setFogbugz(String fogbugz){
		this.fogbugz = fogbugz;
	}

	public String getFogbugz(){
		return fogbugz;
	}

	public void setCheckItems(int checkItems){
		this.checkItems = checkItems;
	}

	public int getCheckItems(){
		return checkItems;
	}

	public void setCheckItemsChecked(int checkItemsChecked){
		this.checkItemsChecked = checkItemsChecked;
	}

	public int getCheckItemsChecked(){
		return checkItemsChecked;
	}
}
