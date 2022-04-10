package org.eleks.api.trello.models.responses.Cards;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardsResponse {
    private DescData descData;
    private List<IdLabelsItem> idLabels;
    private String shortUrl;
    private String dateLastActivity;
    private String idList;
    private List<String> idMembersVoted;
    private String shortLink;
    private String creationMethod;
    private Cover cover;
    private String dueReminder;
    private boolean subscribed;
    private int pos;
    private List<IdChecklistsItem> idChecklists;
    private String id;
    private String email;
    private Limits limits;
    private String address;
    private String idBoard;
    private String locationName;
    private String url;
    private List<String> labels;
    private Badges badges;
    private List<String> idMembers;
    private int idShort;
    private String due;
    private String name;
    private boolean closed;
    private boolean manualCoverAttachment;
    private String desc;

    public void setDescData(DescData descData){
        this.descData = descData;
    }

    public DescData getDescData(){
        return descData;
    }

    public void setIdLabels(List<IdLabelsItem> idLabels){
        this.idLabels = idLabels;
    }

    public List<IdLabelsItem> getIdLabels(){
        return idLabels;
    }

    public void setShortUrl(String shortUrl){
        this.shortUrl = shortUrl;
    }

    public String getShortUrl(){
        return shortUrl;
    }

    public void setDateLastActivity(String dateLastActivity){
        this.dateLastActivity = dateLastActivity;
    }

    public String getDateLastActivity(){
        return dateLastActivity;
    }

    public void setIdList(String idList){
        this.idList = idList;
    }

    public String getIdList(){
        return idList;
    }

    public void setIdMembersVoted(List<String> idMembersVoted){
        this.idMembersVoted = idMembersVoted;
    }

    public List<String> getIdMembersVoted(){
        return idMembersVoted;
    }

    public void setShortLink(String shortLink){
        this.shortLink = shortLink;
    }

    public String getShortLink(){
        return shortLink;
    }

    public void setCreationMethod(String creationMethod){
        this.creationMethod = creationMethod;
    }

    public String getCreationMethod(){
        return creationMethod;
    }

    public void setCover(Cover cover){
        this.cover = cover;
    }

    public Cover getCover(){
        return cover;
    }

    public void setDueReminder(String dueReminder){
        this.dueReminder = dueReminder;
    }

    public String getDueReminder(){
        return dueReminder;
    }

    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }

    public boolean isSubscribed(){
        return subscribed;
    }

    public void setPos(int pos){
        this.pos = pos;
    }

    public int getPos(){
        return pos;
    }

    public void setIdChecklists(List<IdChecklistsItem> idChecklists){
        this.idChecklists = idChecklists;
    }

    public List<IdChecklistsItem> getIdChecklists(){
        return idChecklists;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setLimits(Limits limits){
        this.limits = limits;
    }

    public Limits getLimits(){
        return limits;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setIdBoard(String idBoard){
        this.idBoard = idBoard;
    }

    public String getIdBoard(){
        return idBoard;
    }

    public void setLocationName(String locationName){
        this.locationName = locationName;
    }

    public String getLocationName(){
        return locationName;
    }


    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public void setLabels(List<String> labels){
        this.labels = labels;
    }

    public List<String> getLabels(){
        return labels;
    }

    public void setBadges(Badges badges){
        this.badges = badges;
    }

    public Badges getBadges(){
        return badges;
    }

    public void setIdMembers(List<String> idMembers){
        this.idMembers = idMembers;
    }

    public List<String> getIdMembers(){
        return idMembers;
    }

    public void setIdShort(int idShort){
        this.idShort = idShort;
    }

    public int getIdShort(){
        return idShort;
    }

    public void setDue(String due){
        this.due = due;
    }

    public String getDue(){
        return due;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setClosed(boolean closed){
        this.closed = closed;
    }

    public boolean isClosed(){
        return closed;
    }

    public void setManualCoverAttachment(boolean manualCoverAttachment){
        this.manualCoverAttachment = manualCoverAttachment;
    }

    public boolean isManualCoverAttachment(){
        return manualCoverAttachment;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }
}
