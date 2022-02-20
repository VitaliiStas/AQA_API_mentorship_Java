package org.eleks.api.trello.http_clients;

import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.responses.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardHttpClient {

    //    private static String boardId = "avlnYUa4";
    private static final String PATH = "/boards/";

    //    todo return the changes


    public BaseBoardResponse updateBoard(String boardIdForUpdate, BaseBoardRequest requestBody) {

        BaseBoardResponse updateBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .body(requestBody)
                .put(PATH + boardIdForUpdate)
                .then()
                .extract()
                .as(BaseBoardResponse.class);
        return updateBoardResponse;
// todo move
//        assertThat(updateBoardResponse)
//                .isNotNull()
//                .extracting(BaseBoardResponse::getName)
//                .isEqualTo(requestBody.getName());
    }

    public DeleteBoardResponse deleteBoardRequest(String boardIdForDelete) {

        DeleteBoardResponse deleteBoardResponse = BaseHttpClient.createRequestSpecification()
                .delete(PATH + boardIdForDelete)
                .then()
                .log()
                .all()
                .statusCode(200).extract().as(DeleteBoardResponse.class);
        return deleteBoardResponse;
    }

    public BaseBoardResponse createBoardRequest(String boardName) {
        BaseBoardRequest createBoardRequest = new BaseBoardRequest();
        createBoardRequest.setName(boardName);

        BaseBoardResponse createBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .body(createBoardRequest)
                .basePath(PATH)
                .post()
                .then()
                .extract()
                .as(BaseBoardResponse.class);

        return createBoardResponse;
    }

    public BaseBoardResponse getBoardByIdRequest(String boardId) {
        BaseBoardResponse getBoardResponse = BaseHttpClient.createRequestSpecification()
                .get(PATH + boardId)
                .then()
                .extract()
                .as(BaseBoardResponse.class);

        return getBoardResponse;
    }
}
