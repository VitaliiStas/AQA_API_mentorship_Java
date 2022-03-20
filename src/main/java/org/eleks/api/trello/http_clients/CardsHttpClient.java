package org.eleks.api.trello.http_clients;

import io.qameta.allure.Step;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.CardsResponse;

public class CardsHttpClient extends BaseHttpClient {
    protected static final String PATH = "/cards/";


//    @Step("Create a new Card on a Board")

//    public CardsResponse createCard(String idList, String name, String color) {
//        CardsResponse createCard = BaseHttpClient
//                .createRequestSpecification()
//                .basePath(PATH + idList + "/labels")
//                .queryParams("name", name, "color", color)
//                .post()
//                .then()
////                .log()
////                .all()
//                .extract()
//                .as(CardsResponse.class);
//        return createCard;
//    }
}
