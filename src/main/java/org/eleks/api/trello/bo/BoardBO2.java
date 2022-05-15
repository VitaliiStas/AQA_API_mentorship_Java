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
    private static ThreadLocal<BaseBoardResponse> createBoardResponse = new ThreadLocal<>();
    private static BoardHttpClient boardHttpClient = new BoardHttpClient();

    private static List<String> colors =
            Arrays.asList("blue", "black", "red", "green", "purple", "orange", "yellow");


    @Step("Go to the list")
    public ListBO initListBO() {
        return new ListBO(getCreateBoardResponse().getId());
    }


    //    todo how to compare two diff JSON?? or how to create map from, now check only Black label
    public BoardBO2 createLabelOnBoardAndCheckResponseBO2() {
        String boardID = getCreateBoardResponse().getId();
        BaseBoardResponse labelNames = addBoardLabel(boardID, "LabelName", colors.get(1));


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

        assertThat(baseBoardResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id", "prefs", "labelNames")
                .isEqualTo(boardHttpClient.getBoardByIdRequest(getCreateBoardResponse().getId()));
//                .isEqualTo(boardHttpClient.getBoardByIdRequest(createResponse.getId()));

        return new BoardBO2();

    }

    @Step("Delete created/updated board")
    public BoardBO2 deleteBoardAndCheckResponseBO2() {
        Assert.assertEquals(boardHttpClient
                .deleteBoardRequest(getCreateBoardResponse().getId())
//                .deleteBoardRequest(createResponse.getId())
                .get_value(), new DeleteBoardResponse()
                .get_value(), "ListResponse mismatch");
        return this;
    }

    //todo createBoardBO2() should be only static
    @Step("Create board")
    public static BoardBO2 createBoardBO2() {
        BaseBoardResponse baseBoardResponse = boardHttpClient
                .createBoardRequest("Board" + RandomStringUtils.randomAlphabetic(10));
        return new BoardBO2(baseBoardResponse);
    }

    public BoardBO2() {
    }

    public BoardBO2(BaseBoardResponse boardResponse) {
        createBoardResponse.set(boardResponse);
    }

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
        return new BoardBO2();
    }


}
