package org.eleks.api.trello.models.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.eleks.api.trello.models.requests.board_request_nested_objects.LabelNames;
import org.eleks.api.trello.models.requests.board_request_nested_objects.Prefs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseBoardRequest {
    protected String id;
    protected String name;
    protected String desc;
    protected Prefs prefs;
    protected LabelNames labelNames;

    public LabelNames getLabelNames() {
        return labelNames;
    }

    public void setLabelNames(LabelNames labelNames) {
        this.labelNames = labelNames;
    }

    public Prefs getPrefs() {
        return prefs;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }
}


