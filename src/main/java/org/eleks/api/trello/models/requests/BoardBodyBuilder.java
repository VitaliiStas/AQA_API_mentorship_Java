package org.eleks.api.trello.models.requests;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.models.requests.board_request_nested_objects.LabelNames;
import org.eleks.api.trello.models.requests.board_request_nested_objects.Prefs;

public class BoardBodyBuilder {
    private String generateRandomString(String startString) {
        return startString + RandomStringUtils.randomAlphabetic(10);
    }


    private final BaseBoardRequest updateBoardRequest;

    public BoardBodyBuilder() {
        updateBoardRequest = new BaseBoardRequest();
//        todo create privat method for setup base field
        setDefaultFields();
    }
    private BoardBodyBuilder setDefaultFields(){
        updateBoardRequest.name= generateRandomString("Updated Board Name ");
        updateBoardRequest.desc= generateRandomString("Updated Description  text ");
        return this;
    }

    public BoardBodyBuilder setName(String name) {
        updateBoardRequest.name = name;
        return this;
    }


    public BoardBodyBuilder setDesc(String desc) {
        updateBoardRequest.desc = desc;
        return this;
    }


    public BoardBodyBuilder setPrefs(Prefs prefs) {
        updateBoardRequest.prefs = prefs;
        return this;
    }
    public BoardBodyBuilder setLabelNames(LabelNames labelNames) {
        updateBoardRequest.labelNames = labelNames;
        return this;
    }


    public BaseBoardRequest build() {
        return updateBoardRequest;
    }
}
