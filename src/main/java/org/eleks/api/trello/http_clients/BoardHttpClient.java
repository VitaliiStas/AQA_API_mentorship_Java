package org.eleks.api.trello.http_clients;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.responses.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardHttpClient {


    private static String boardId = "avlnYUa4";
    private static String defaultPath = "/boards/";


    public static void updateBoard(String boardIdForUpdate) {
        //        todo create builder for object
        //todo move to the boardhttpclient.class

        BaseBoardRequest updateBoardRequest = new BaseBoardRequest();
        updateBoardRequest.setName(RandomStringUtils.randomAlphabetic(10));
        updateBoardRequest.setDesc(RandomStringUtils.randomAlphabetic(10));
//todo move to the boardhttpclient.class
        BaseBoardResponse updateBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .body(updateBoardRequest)
                .put(defaultPath + boardIdForUpdate)
                .then().log().all()
                .extract()
                .as(BaseBoardResponse.class);

        assertThat(updateBoardRequest)
                .isNotNull()
                .extracting(BaseBoardRequest::getName)
                .isEqualTo(updateBoardResponse.getName());
    }

    public static void deleteBoard(String boardIdForDelete) {

        DeleteBoardResponse deleteBoardResponse = BaseHttpClient.createRequestSpecification()
                //todo move to the boardhttpclient.class
                .delete(defaultPath + boardIdForDelete)
                .then()
                .log()
                .all()
                .statusCode(200).extract().as(DeleteBoardResponse.class);

        assertThat(deleteBoardResponse)
                .isNotNull();

    }

    public static void createBoard() {
        BaseBoardRequest createBoardRequest = new BaseBoardRequest();
        createBoardRequest.setName("TestBoardCreatedByAPI1");
//

        BaseBoardResponse createBoardResponse = BaseHttpClient
                .createRequestSpecification()
                .body(createBoardRequest)
                .basePath(defaultPath)
                .post()
                .then()
                .extract()
                .as(BaseBoardResponse.class);


        assertThat(createBoardResponse)
                .isNotNull()
                .extracting(BaseBoardResponse::getName)
                .isEqualTo(createBoardRequest.getName());
    }

    public static void getBoardById() {
//todo move to the boardhttpclient.class
        BaseBoardResponse getBoardResponse = BaseHttpClient.createRequestSpecification()
                .get(defaultPath + boardId)
                .then()
                .statusCode(200)
                .extract()
                .as(BaseBoardResponse.class);

        assertThat(getBoardResponse)
                .isNotNull();
    }
}
