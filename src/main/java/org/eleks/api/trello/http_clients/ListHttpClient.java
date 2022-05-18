package org.eleks.api.trello.http_clients;

import io.restassured.response.Response;
import org.eleks.api.trello.models.requests.ListRequest;
import org.eleks.api.trello.models.responses.Lists.ListResponse;

public class ListHttpClient extends BaseHttpClient {

    protected static final String PATH = "/lists/";

    public ListResponse createListRequest(String listName, String idBoard) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .queryParam(listName)
                .queryParam(idBoard)
                .basePath(PATH)
                .queryParam("name", listName)
                .queryParam("idBoard", idBoard)
                .post();

        return parsResponse(response, ListResponse.class);
    }

    public ListResponse getListRequest(String idList) {

        Response response = BaseHttpClient.createRequestSpecification()
                .get(PATH + idList);

        return parsResponse(response, ListResponse.class);
    }

    public ListRequest updateListRequest(String idList, ListRequest requestBody) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .body(requestBody)
                .put(PATH + idList);

        return parsResponse(response, ListRequest.class);
    }

}
