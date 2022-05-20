package org.eleks.api.trello.http_clients;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.eleks.api.trello.models.requests.CardsRequest;
import org.eleks.api.trello.models.responses.Cards.CardsResponse;

public class CardsHttpClient extends BaseHttpClient {
    protected static final String PATH = "/cards/";


    @Step("Create a new Card on a Board")
    public CardsResponse createCardRequest(String idList,String name) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH)
                .queryParams("idList", idList)
                .queryParams("name", name)
                .post();

        return parsResponse(response,CardsResponse.class);
    }


    public CardsResponse getCardRequest(String idCard) {

        Response response = BaseHttpClient.createRequestSpecification()
                .get(PATH + idCard);

        return parsResponse(response,CardsResponse.class);
    }

    public CardsResponse deleteCardRequest(String idCard) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .delete(PATH + idCard);

        return parsResponse(response,CardsResponse.class);
    }

    public CardsRequest updateCardRequest(String idCard, CardsRequest cardsRequestBody) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .body(cardsRequestBody)
                .put(PATH + idCard);

        return parsResponse(response,CardsRequest.class);
    }


}
