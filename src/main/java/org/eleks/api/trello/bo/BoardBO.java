package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.models.requests.CreateBoardRequest;
import org.eleks.api.trello.models.requests.DeleteBoardRequest;
import org.eleks.api.trello.models.requests.GetBoardRequest;
import org.eleks.api.trello.models.requests.UpdateBoardRequest;
import org.eleks.api.trello.models.responses.CreateBoardResponse;
import org.eleks.api.trello.models.responses.DeleteBoardResponse;
import org.eleks.api.trello.models.responses.GetBoardResponse;
import org.eleks.api.trello.models.responses.UpdateBoardRespons;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.*;

public class BoardBO extends BaseRequestBO {
    private static String boardId = "avlnYUa4";
    private static String defaultPath = "/boards/";


    public static void updateBoard(String boardIdForUpdate){
        UpdateBoardRequest updateBoardRequest = new UpdateBoardRequest();
        updateBoardRequest.setName(RandomStringUtils.randomAlphabetic(10));
        updateBoardRequest.setDesc("RandomStringUtils.randomAlphabetic(66)");

        UpdateBoardRespons updateBoardResponse = BaseRequestBO
                .createRequestSpecification()
                .body(updateBoardRequest)
                .put(defaultPath+boardIdForUpdate)
                .then().log().all()
                .extract()
                .as(UpdateBoardRespons.class);

        checkResponse(updateBoardResponse, updateBoardResponse.getName(), updateBoardRequest.getName());
//        checkResponse(updateBoardResponse, updateBoardResponse.getDesc(), updateBoardRequest.getDesc());
    }

    public static void deleteBoard(String boardIdForDelete) {

        DeleteBoardResponse deleteBoardResponse = BaseRequestBO.createRequestSpecification()
                .delete(defaultPath + boardIdForDelete)
                .then()
                .log()
                .all()
                .statusCode(200).extract().as(DeleteBoardResponse.class);

        assertThat(deleteBoardResponse)
                .isNotNull();

    }

    public static void createBoardAndCheckName() {
        CreateBoardRequest createBoardRequest = new CreateBoardRequest();
        createBoardRequest.setName("TestBoardCreatedByAPI1");

        CreateBoardResponse createBoardResponse = BaseRequestBO
                .createRequestSpecification()
                .body(createBoardRequest)
                .basePath(defaultPath)
                .post()
                .then()
                .extract()
                .as(CreateBoardResponse.class);

        checkResponse(createBoardResponse, createBoardResponse.getName(), createBoardRequest.getName());

//        assertThat(createBoardResponse)
//                .isNotNull()
//                .extracting(CreateBoardResponse::getName)
//                .isEqualTo(createBoardRequest.getName());
    }

    public static void getBoardById() {
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setId(boardId);

        GetBoardResponse getBoardResponse = BaseRequestBO.createRequestSpecification()
                .get(defaultPath + boardId)
                .then()
                .statusCode(200)
                .extract()
                .as(GetBoardResponse.class);

        checkResponse(getBoardResponse, getBoardResponse.getName(), "Agile Sprint Board");


    }

    private static <T> void checkResponse(T response, String actualResult, String expectedResult) {
        assertThat(response).isNotNull();
        Assert.assertEquals(actualResult, expectedResult, "The Board name is different.");
    }

}
