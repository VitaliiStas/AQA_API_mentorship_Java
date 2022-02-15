package org.eleks.api.trello.bo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.BoardHttpClient;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.DeleteBoardResponse;
import org.testng.Assert;

public class BoardBO {


    private String boardID;
    private String boardName;

    static ObjectMapper mapper = new ObjectMapper();

    private static String randomString = RandomStringUtils.randomAlphabetic(10);

    private static BoardBO boardBO = new BoardBO();
    private static BoardHttpClient boardHttpClient = new BoardHttpClient();


    public static void getBoardByIdAndCheckResponseAndDelete() {
        BaseBoardResponse baseBoardResponse = boardBO.createBoard();
        Assert.assertEquals(boardBO.convertObjectToJSON(boardHttpClient
                        .getBoardByIdRequest(baseBoardResponse.getId()))
                , boardBO.convertObjectToJSON(baseBoardResponse)
                , "Get Board by ID Response mismatch");
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

    private String convertObjectToJSON(BaseBoardResponse boardResponse) {
        String json;
        try {
            json = mapper.writeValueAsString(boardResponse);
            return json;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Assert.fail("Converting Object into JSON FAILED!!!");
        }return null;
    }

}
