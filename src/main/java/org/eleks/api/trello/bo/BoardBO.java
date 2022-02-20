package org.eleks.api.trello.bo;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.BoardHttpClient;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.requests.BoardBodyBuilder;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.DeleteBoardResponse;
import org.eleks.api.trello.utils.JsonUtils;
import org.testng.Assert;


public class BoardBO {

//    private String boardID;
    private String boardName;

    protected static BoardBO boardBO = new BoardBO();
    protected static BoardHttpClient boardHttpClient = new BoardHttpClient();
    protected static JsonUtils jsonUtils = new JsonUtils();


    public static void updateBoardAndCheckResponseAndDelete() {

        BaseBoardResponse baseBoardResponse = boardBO.createBoard();
        boardHttpClient.updateBoard(
                baseBoardResponse.getId()
                , boardBO.updateRequestBodyBuilder());

        boardHttpClient.deleteBoardRequest(baseBoardResponse.getId());

    }

    public static void getBoardByIdAndCheckResponseAndDelete() {
        BaseBoardResponse baseBoardResponse = boardBO.createBoard();
        Assert.assertEquals(jsonUtils
                        .convertObjectToJSON(boardHttpClient
                                .getBoardByIdRequest(baseBoardResponse.getId()))
                , jsonUtils
                        .convertObjectToJSON(baseBoardResponse)
                , "Get Board by ID Response mismatch");
        //delete created board
        boardHttpClient.deleteBoardRequest(baseBoardResponse.getId());

    }

    public static void deleteBoardAndCheckResponse() {
        Assert.assertEquals(boardHttpClient
                .deleteBoardRequest(boardBO.createBoard().getId())
                .get_value(), new DeleteBoardResponse()
                .get_value(), "Response mismatch");

    }


    private BaseBoardResponse createBoard() {
        return boardHttpClient
                .createBoardRequest("Board" + RandomStringUtils.randomAlphabetic(10));
    }

    private BaseBoardRequest updateRequestBodyBuilder() {
        return new BoardBodyBuilder().build();
    }

}
