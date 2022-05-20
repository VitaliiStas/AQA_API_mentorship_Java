package org.eleks.api.trello.http_clients;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.responses.*;


public class BoardHttpClient extends BaseHttpClient {

    protected static final String PATH = "/boards/";

    @Step("Send update board request/POST")
    public BaseBoardResponse updateBoard(String boardIdForUpdate, BaseBoardRequest requestBody) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .body(requestBody)
                .put(PATH + boardIdForUpdate);

        return parsResponse(response, BaseBoardResponse.class);

    }

    @Step("Send delete board request/DELETE")
    public DeleteBoardResponse deleteBoardRequest(String boardIdForDelete) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .delete(PATH + boardIdForDelete);

        return parsResponse(response, DeleteBoardResponse.class);
    }

    @Step("Send create board request/POST")
    public BaseBoardResponse createBoardRequest(String boardName) {
        BaseBoardRequest createBoardRequest = new BaseBoardRequest();
        createBoardRequest.setName(boardName);

        Response response = BaseHttpClient
                .createRequestSpecification()
                .body(createBoardRequest)
                .basePath(PATH)
                .post();

        return parsResponse(response, BaseBoardResponse.class);
    }

    @Step("Send get board request/GET")
    public BaseBoardResponse getBoardByIdRequest(String boardId) {

        Response response = BaseHttpClient.createRequestSpecification()
                .get(PATH + boardId);

        return parsResponse(response, BaseBoardResponse.class);
    }
}
