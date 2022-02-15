package org.eleks.api.trello.http_clients;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.responses.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardHttpClient {

//    private static String boardId = "avlnYUa4";
    private static final String PATH = "/boards/";


    public void updateBoardRequest(String boardIdForUpdate) {
        //        todo create builder for object

        BaseBoardRequest updateBoardRequest = new BaseBoardRequest();
        updateBoardRequest.setName(RandomStringUtils.randomAlphabetic(10));
        updateBoardRequest.setDesc(RandomStringUtils.randomAlphabetic(10));
        BaseBoardResponse updateBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .body(updateBoardRequest)
                .put(PATH + boardIdForUpdate)
                .then().log().all()
                .extract()
                .as(BaseBoardResponse.class);

        assertThat(updateBoardRequest)
                .isNotNull()
                .extracting(BaseBoardRequest::getName)
                .isEqualTo(updateBoardResponse.getName());
    }

    public DeleteBoardResponse deleteBoardRequest(String boardIdForDelete) {

        DeleteBoardResponse deleteBoardResponse = BaseHttpClient.createRequestSpecification()
                .delete(PATH + boardIdForDelete)
                .then()
                .log()
                .all()
                .statusCode(200).extract().as(DeleteBoardResponse.class);

        assertThat(deleteBoardResponse)
                .isNotNull();
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

//check if the response isn't NULL and board name is correct
        assertThat(createBoardResponse)
                .isNotNull()
                .extracting(BaseBoardResponse::getName)
                .isEqualTo(createBoardRequest.getName());

        return createBoardResponse;
    }

    public BaseBoardResponse getBoardByIdRequest(String boardId) {
        BaseBoardResponse getBoardResponse = BaseHttpClient.createRequestSpecification()
                .get(PATH + boardId)
                .then()
                .statusCode(200)
                .extract()
                .as(BaseBoardResponse.class);

        assertThat(getBoardResponse)
                .isNotNull();
        return getBoardResponse;
    }
}
