package org.eleks.api.trello.bo;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.requests.BoardBodyBuilder;
import org.eleks.api.trello.models.requests.board_request_nested_objects.LabelNames;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.DeleteBoardResponse;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardBO2 extends BoardBO {

    private static BaseBoardResponse createResponse;


    public static void setCreateResponse(BaseBoardResponse createResponse) {
        BoardBO2.createResponse = createResponse;
    }

    public static BoardBO2 getBoardByIdAndCheckResponseBO2() {
        BaseBoardResponse baseBoardResponse = boardHttpClient.getBoardByIdRequest(
                createResponse.getId());

        assertThat(baseBoardResponse).isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(createResponse);

        return new BoardBO2();
    }


    public static BoardBO2 updateBoardAndCheckResponseBO2() {
        LabelNames labelNames = new LabelNames();
        labelNames.setBlack("black");
        labelNames.setBlue("blue");
        labelNames.setGreen("green");

        BaseBoardRequest baseBoardRequest = new BoardBodyBuilder()
                .setLabelNames(labelNames)
                .build();

        BaseBoardResponse baseBoardResponse = boardHttpClient.updateBoard(
                createResponse.getId(), baseBoardRequest);

        assertThat(baseBoardResponse).isNotNull()
                .usingRecursiveComparison().ignoringFields("id","prefs","labelNames")
                .isEqualTo(baseBoardRequest);

        return new BoardBO2();

    }

    public static void deleteBoardAndCheckResponseBO2() {
        Assert.assertEquals(boardHttpClient
                .deleteBoardRequest(createResponse.getId())
                .get_value(), new DeleteBoardResponse()
                .get_value(), "Response mismatch");

    }

    public static BoardBO2 createBoardBO2() {
        BaseBoardResponse baseBoardResponse = boardHttpClient
                .createBoardRequest("Board" + RandomStringUtils.randomAlphabetic(10));
        setCreateResponse(baseBoardResponse);
        return new BoardBO2();
    }
}
