package org.eleks.api.trello.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.testng.Assert;

public class JsonUtils {

    private ObjectMapper mapper = new ObjectMapper();

    public String convertObjectToJSON(BaseBoardResponse boardResponse) {
        String json;
        try {
            json = mapper.writeValueAsString(boardResponse);
            return json;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Assert.fail("Converting Object into JSON FAILED!!!");
        }return null;
    }
}
