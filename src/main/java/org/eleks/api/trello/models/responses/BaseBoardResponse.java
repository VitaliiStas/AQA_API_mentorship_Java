package org.eleks.api.trello.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.eleks.api.trello.models.requests.board_request_nested_objects.Prefs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseBoardResponse {
    private String id;
    private String name;
    private String desc;
    private Prefs prefs;


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

    public Prefs getPrefs() {
        return prefs;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }
}
