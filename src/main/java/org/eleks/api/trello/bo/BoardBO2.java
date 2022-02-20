package org.eleks.api.trello.bo;

import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.requests.BoardBodyBuilder;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.DeleteBoardResponse;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardBO2 extends BoardBO {
    private static String boardID;

    public void setBoardID(String boardID) {
        this.boardID = boardID;
    }
//    public static void getBoardByIdAndCheckResponseAndDelete() {
//        BaseBoardRequest baseBoardRequest = new BoardBodyBuilder().build();
//        boardHttpClient.getBoardByIdRequest(baseBoardResponse.getId()))
//
//
//        //delete created board
//        boardHttpClient.deleteBoardRequest(baseBoardResponse.getId());
//
//        Assertions.assertThat(baseBoardResponse)
//                .isNotNull()
//                .usingRecursiveComparison()
//                .isEqualTo(baseBoardRequest);
//
//    }


    public static BoardBO2 updateBoardAndCheckResponseBO2() {
        BaseBoardRequest baseBoardRequest = new BoardBodyBuilder().build();
        BaseBoardResponse baseBoardResponse =
        boardHttpClient.updateBoard(
                boardID, baseBoardRequest);


        assertThat(baseBoardResponse).isNotNull()
                .usingRecursiveComparison().ignoringFields("id","prefs")
                .isEqualTo(baseBoardRequest);

        return new BoardBO2();

    }

    public static void deleteBoardAndCheckResponse2() {
        Assert.assertEquals(boardHttpClient
                .deleteBoardRequest(boardID)
                .get_value(), new DeleteBoardResponse()
                .get_value(), "Response mismatch");

    }

    public static BoardBO2 createBoard2() {
        BaseBoardResponse baseBoardResponse = boardHttpClient
                .createBoardRequest("Board" + RandomStringUtils.randomAlphabetic(10));
        new BoardBO2().setBoardID(baseBoardResponse.getId());
        return new BoardBO2();
    }
}
