package org.eleks.api.trello.bo;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.BoardHttpClient;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.DeleteBoardResponse;
import org.eleks.api.trello.utils.JsonUtils;
import org.testng.Assert;

public class BoardBO {


    private String boardID;
    private String boardName;

    private static String randomString = RandomStringUtils.randomAlphabetic(10);

    private static BoardBO boardBO = new BoardBO();
    private static BoardHttpClient boardHttpClient = new BoardHttpClient();
    private static JsonUtils jsonUtils = new JsonUtils();


    public static void getBoardByIdAndCheckResponseAndDelete() {
        BaseBoardResponse baseBoardResponse = boardBO.createBoard();
        Assert.assertEquals(jsonUtils
                        .convertObjectToJSON(boardHttpClient
                        .getBoardByIdRequest(baseBoardResponse.getId()))
                ,jsonUtils
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
        String boardName = "Board" + randomString;
        return boardHttpClient.createBoardRequest(boardName);
    }



}
