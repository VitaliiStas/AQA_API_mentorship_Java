package org.eleks.api.trello.models.requests;

import org.eleks.api.trello.http_clients.BaseHttpClient;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.Lists.ListResponse;

public class ListHttpClient extends BaseHttpClient {

    protected static final String PATH = "/lists/";

    public ListResponse createListRequest(String listName, String idBoard) {

        ListResponse createListRequest = new ListResponse();

        ListResponse createListResponse = BaseHttpClient
                .createRequestSpecification()
                .queryParam(listName)
                .queryParam(idBoard)
                .basePath(PATH)
                .queryParam("name", listName)
                .queryParam("idBoard", idBoard)
                .post()
                .then()
                .log()
                .all()
                .extract()
                .as(ListResponse.class);
        return createListResponse;
    }

    public ListResponse getListRequest(String idList) {
        return BaseHttpClient.createRequestSpecification()
                .get(PATH + idList)
                .then()
//                .log()
//                .all()
                .extract()
                .as(ListResponse.class);
    }

    public ListRequest updateListRequest(String idList, ListRequest requestBody) {

        ListRequest updateBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .body(requestBody)
                .put(PATH + idList)
                .then()
//                .log()
//                .all()
                .extract()
                .as(ListRequest.class);
        return updateBoardResponse;
    }

}
