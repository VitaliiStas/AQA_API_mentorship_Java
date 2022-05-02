package org.eleks.api.trello.bo;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.BoardHttpClient;
import org.eleks.api.trello.http_clients.BoardLableHttpClient;
import org.eleks.api.trello.http_clients.GetAllListHttpClient;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.requests.BoardBodyBuilder;
import org.eleks.api.trello.models.requests.board_request_nested_objects.LabelNames;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.DeleteBoardResponse;
import org.testng.Assert;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardBO2 {
    //todo static createResponse2 should be wrapped in thread local, it should be set in the default constructor BoardBO2
//    private BaseBoardResponse createResponse;
    private static ThreadLocal<BaseBoardResponse> createBoardResponse = new ThreadLocal<>();
    private static BoardHttpClient boardHttpClient = new BoardHttpClient();

    private static List<String> colors =
            Arrays.asList("blue", "black", "red", "green", "purple", "orange", "yellow");



    //todo new method initListBO(){

    public ListBO initListBO() {
        return new ListBO(getCreateBoardResponse().getId());
    }
//        return new ListBO(createResponse.getId());
//    }


//    public HashMap<String,String> allBoardsId() {
//        HashMap<String,String> idsMap= new HashMap<>();
//         Arrays.stream(new GetAllListHttpClient()
//                .getAllListsFromBoard(getCreateBoardResponse().getId()))
//                 .forEach(x->idsMap.put(x.getResponse().iterator().next().getName()
//                         ,x.getResponse().iterator().next().getId()));
//        return idsMap;
//             }


//    public HashMap<String,String> allBoardsId() {
//        HashMap<String,String> idsMap= new HashMap<>();
//        new GetAllListHttpClient()
//                .getAllListsFromBoard(getCreateBoardResponse().getId())
//                .getResponse()
//                .forEach(x->idsMap.put(x.getName(), x.getId()));
//        return idsMap;
//    }



    //    todo how to compare two diff JSON?? or how to create map from
    public BoardBO2 createLabelOnBoardAndCheckResponseBO2() {
//        String boardID = createResponse.getId();
        String boardID = getCreateBoardResponse().getId();
        BaseBoardResponse labelNames = addBoardLabel(boardID, "LabelName", colors.get(1));
//        boardHttpClient.getBoardByIdRequest(boardID).getLabelNames();


        assertThat(labelNames)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("labelNames", "color", "name", "id", "desc", "prefs")
                .isEqualTo(boardHttpClient.getBoardByIdRequest(boardID).getLabelNames().getBlack())
//todo diff json how to create check properly??
        ;
//        {
//            "id": "62409cd64276c65e93301dbe",
//                "idBoard": "62409cd5ce32a61a59feae37",
//                "name": "LabelName",
//                "color": "black",
//                "limits": {
//
//        }
//        }
//        "labelNames": {
//                    "green": "",
//                    "yellow": "",
//                    "orange": "",
//                    "red": "",
//                    "purple": "",
//                    "blue": "",
//                    "sky": "",
//                    "lime": "",
//                    "pink": "",
//                    "black": "LabelName"
//        }

        return new BoardBO2();
    }

    @Step("Get board by ID")
    public BoardBO2 getBoardByIdAndCheckResponseBO2() {
        BaseBoardResponse baseBoardResponse = boardHttpClient.getBoardByIdRequest(
                getCreateBoardResponse().getId());
//                createResponse.getId());

        assertThat(baseBoardResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(getCreateBoardResponse());
//                .isEqualTo(createResponse);

        return new BoardBO2();
    }

    @Step("Update board(set value for update and send request)")
    public BoardBO2 updateBoardAndCheckResponseBO2() {
        LabelNames labelNames = new LabelNames();
        labelNames.setBlack("black");
        labelNames.setBlue("blue");
        labelNames.setGreen("green");

        BaseBoardRequest baseBoardRequest = new BoardBodyBuilder()
                .setLabelNames(labelNames)
                .build();

        BaseBoardResponse baseBoardResponse = boardHttpClient.updateBoard(
                getCreateBoardResponse().getId(), baseBoardRequest);
//                createResponse.getId(), baseBoardRequest);

        assertThat(baseBoardResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id", "prefs", "labelNames")
                .isEqualTo(boardHttpClient.getBoardByIdRequest(getCreateBoardResponse().getId()));
//                .isEqualTo(boardHttpClient.getBoardByIdRequest(createResponse.getId()));

        return new BoardBO2();

    }

    @Step("Delete created/updated board")
    public void deleteBoardAndCheckResponseBO2() {
        Assert.assertEquals(boardHttpClient
                .deleteBoardRequest(getCreateBoardResponse().getId())
//                .deleteBoardRequest(createResponse.getId())
                .get_value(), new DeleteBoardResponse()
                .get_value(), "ListResponse mismatch");

    }

    //todo createBoardBO2() should be only static
    @Step("Create board")
    public static BoardBO2 createBoardBO2() {
        BaseBoardResponse baseBoardResponse = boardHttpClient
                .createBoardRequest("Board" + RandomStringUtils.randomAlphabetic(10));
        return new BoardBO2(baseBoardResponse);
    }
//    private void setCreateResponse(BaseBoardResponse createResponse) {
//        this.createResponse = createResponse;
//    }

    //todo maybe doesn't work?????
    public BoardBO2() {
    }

    public BoardBO2(BaseBoardResponse boardResponse) {
        createBoardResponse.set(boardResponse);
//        setResponse(boardResponse);
    }

//    private static void setResponse(BaseBoardResponse response) {
//        createBoardResponse.set(response);
//    }

    public static BaseBoardResponse getCreateBoardResponse() {
        return createBoardResponse.get();
    }


    //todo add labels

    private BaseBoardResponse addBoardLabel(String boardId, String lableName, String colorName) {
        return new BoardLableHttpClient().createLabel(boardId, lableName, colorName);
    }

    @Step("Add all Labels")
    private void addAllBoardLabels(String boardId) {
        colors.stream()
                .forEach((colors) -> addBoardLabel(boardId, colors + "LabelName", colors));
    }

    private BoardBO2 addAllBoardLabelsBO2() {
        addAllBoardLabels(getCreateBoardResponse().getId());
//        addAllBoardLabels(createResponse.getId());
        return new BoardBO2();
    }


}
