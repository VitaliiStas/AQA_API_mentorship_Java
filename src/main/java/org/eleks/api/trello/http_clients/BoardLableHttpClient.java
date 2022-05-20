package org.eleks.api.trello.http_clients;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.eleks.api.trello.models.responses.BaseBoardResponse;

public class BoardLableHttpClient extends BoardHttpClient{

    @Step("Create a Label on a Board")
    public BaseBoardResponse createLabel(String boardId, String name, String color) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH + boardId + "/labels")
                .queryParams("name",name,"color",color)
                .post();

        return parsResponse(response, BaseBoardResponse.class);
    }

}
