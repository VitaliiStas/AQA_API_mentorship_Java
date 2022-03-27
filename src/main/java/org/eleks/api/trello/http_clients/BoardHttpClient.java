package org.eleks.api.trello.http_clients;

import io.qameta.allure.Step;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.responses.*;


public class BoardHttpClient {

    //    private static String boardId = "avlnYUa4";
    protected static final String PATH = "/boards/";



    @Step("Send update board request/POST")
    public BaseBoardResponse updateBoard(String boardIdForUpdate, BaseBoardRequest requestBody) {

        BaseBoardResponse updateBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .body(requestBody)
                .put(PATH + boardIdForUpdate)
                .then()
//                .log()
//                .all()
                .extract()
                .as(BaseBoardResponse.class);
        return updateBoardResponse;
    }

    @Step("Send delete board request/DELETE")
    public DeleteBoardResponse deleteBoardRequest(String boardIdForDelete) {

        DeleteBoardResponse deleteBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .delete(PATH + boardIdForDelete)
                .then()
                .log()
                .all()
                .statusCode(200).extract().as(DeleteBoardResponse.class);
        return deleteBoardResponse;
    }

    @Step("Send create board request/POST")
    public BaseBoardResponse createBoardRequest(String boardName) {
        BaseBoardRequest createBoardRequest = new BaseBoardRequest();
        createBoardRequest.setName(boardName);

        BaseBoardResponse createBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .body(createBoardRequest)
                .basePath(PATH)
                .post()
                .then()
//                .log()
//                .all()
                .extract()
                .as(BaseBoardResponse.class);

        return createBoardResponse;
    }

    @Step("Send get board request/GET")
    public BaseBoardResponse getBoardByIdRequest(String boardId) {
//        BaseBoardResponse getBoardResponse = BaseHttpClient.createRequestSpecification()
        return BaseHttpClient.createRequestSpecification()
                .get(PATH + boardId)
                .then()
                .log()
                .all()
                .extract()
                .as(BaseBoardResponse.class);

//        return getBoardResponse;
    }
}
