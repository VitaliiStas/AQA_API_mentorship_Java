package org.eleks.api.trello.http_clients;

import io.qameta.allure.Step;
import org.eleks.api.trello.models.responses.BaseBoardResponse;

public class BoardLableHttpClient extends BoardHttpClient{
    @Step("Create a Label on a Board")
//    public BaseBoardResponse createLabel(String boardId, String name, String color) {
    public BaseBoardResponse createLabel(String boardId, String name, String color) {
        BaseBoardResponse createLabelResponse = BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH + boardId + "/labels")
                .queryParams("name",name,"color",color)
                .post()
                .then()
                .log()
                .all()
                .extract()
                .as(BaseBoardResponse.class);
        return createLabelResponse;
    }

}
