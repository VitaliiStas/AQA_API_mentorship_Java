package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.eleks.api.trello.models.requests.CreateBoardRequest;
import org.eleks.api.trello.models.requests.GetBoardRequest;
import org.eleks.api.trello.models.responses.CreateBoardResponse;
import org.eleks.api.trello.models.responses.GetBoardResponse;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.*;

public class BoardBO extends BaseRequestBO {
    private static String boardId = "avlnYUa4";



    public static void createBoardAndCheckName(){
        CreateBoardRequest createBoardRequest = new CreateBoardRequest();
        createBoardRequest.setName("TestBoardCreatedByAPI1");

        CreateBoardResponse createBoardResponse = BaseRequestBO
                .createRequestSpecification()
                .body(createBoardRequest)
                .basePath("/boards/")
                .post()
                .then()
                .log()
                .all()
                .extract()
                .as(CreateBoardResponse.class);

        assertThat(createBoardResponse)
                .isNotNull()
                .extracting(CreateBoardResponse::getName)
                .isEqualTo(createBoardRequest.getName());
    }




    public static void boardNameCheck() {
        new BoardBO().verifyBoardName(boardId, "name", "Agile Sprint Board");

    }

    private void verifyBoardName(String boardId, String dataToExtract, String dataToCompare) {
        Assert.assertEquals(dataToCompare, extractJsonData(boardId, dataToExtract), "Tne field miss mach");
    }

    private String extractJsonData(String boardId, String dataToExtract) {
        return getBoardByBordId(boardId).extract().jsonPath().getString(dataToExtract);
    }


    private ValidatableResponse getBoardByBordId(String boardId) {
        return BaseRequestBO.createRequestSpecification().get("/boards/" + boardId)
                .then()
                .log()
                .all()
                .statusCode(200);

    }

    public static void getBoardById() {
        GetBoardRequest getBoardRequest = new GetBoardRequest();
        getBoardRequest.setBoardId(boardId);

        GetBoardResponse getBoardResponse = BaseRequestBO.createRequestSpecification()
                .get("/boards/" + boardId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(GetBoardResponse.class);

        assertThat(getBoardRequest)
                .isNotNull()
                .extracting(GetBoardRequest::getBoardId)
                .isEqualTo(getBoardRequest.getBoardId());

    }
    private void checkResponse(){
        
    }

}
