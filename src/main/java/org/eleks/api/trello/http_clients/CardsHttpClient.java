package org.eleks.api.trello.http_clients;

import io.qameta.allure.Step;
import org.eleks.api.trello.models.requests.CardsRequest;
import org.eleks.api.trello.models.responses.Cards.CardsResponse;

public class CardsHttpClient extends BaseHttpClient {
    protected static final String PATH = "/cards/";


    @Step("Create a new Card on a Board")
    public CardsResponse createCardRequest(String idList,String name) {
//        CardsResponse createCardResponse = BaseHttpClient
        return BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH)
                .queryParams("idList", idList)
                .queryParams("name", name)
                .post()
                .then()
//                .log()
//                .all()
                .extract()
                .as(CardsResponse.class);
//        return createCardResponse;
    }

    public CardsResponse getCardRequest(String idCard) {
        return BaseHttpClient.createRequestSpecification()
                .get(PATH + idCard)
                .then()
                .log()
                .all()
                .extract()
                .as(CardsResponse.class);
    }

    public CardsResponse deleteCardRequest(String idCard) {
        return BaseHttpClient
                .createRequestSpecification()
                .delete(PATH + idCard)
                .then()
                .log()
                .all()
                .statusCode(200).extract().as(CardsResponse.class);
    }

    public CardsRequest updateCardRequest(String idCard, CardsRequest cardsRequestBody) {
        return BaseHttpClient
                .createRequestSpecification()
                .body(cardsRequestBody)
                .put(PATH + idCard)
                .then()
//                .log()
//                .all()
                .extract()
                .as(CardsRequest.class);
    }

}
