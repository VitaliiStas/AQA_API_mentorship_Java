package org.eleks.api.trello.bo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.BoardHttpClient;
import org.eleks.api.trello.http_clients.BoardLableHttpClient;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.requests.BoardBodyBuilder;
import org.eleks.api.trello.models.requests.board_request_nested_objects.LabelNames;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.DeleteBoardResponse;
import org.testng.Assert;

import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardBO2 {

    public static ListBO listBO = new ListBO();

    protected static BoardHttpClient boardHttpClient = new BoardHttpClient();
    private static BaseBoardResponse createResponse;
    private static List<String> colors =
            Arrays.asList("blue", "black", "red", "green", "purple", "orange", "yellow");


    public static BaseBoardResponse getCreateResponse() {
        return createResponse;
    }

    //    todo how to compare two diff JSON?? or how to create map from
    public static BoardBO2 createLabelOnBoardAndCheckResponseBO2() {
        String boardID = createResponse.getId();
        BaseBoardResponse labelNames = addBoardLabel(boardID, "LabelName", colors.get(1));

        try {
            Map<String, String> map = new HashMap<>();
            map.put(labelNames.getName(), labelNames.getColor());

            boardHttpClient.getBoardByIdRequest(boardID).getLabelNames();

            Map<String, Object> result =
                    new ObjectMapper().readValue(boardHttpClient.getBoardByIdRequest(boardID).getLabelNames().toString(), HashMap.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(labelNames)
                .isNotNull();

        return new BoardBO2();
    }

    @Step("Get board by ID")
    public static BoardBO2 getBoardByIdAndCheckResponseBO2() {
        BaseBoardResponse baseBoardResponse = boardHttpClient.getBoardByIdRequest(
                createResponse.getId());

        assertThat(baseBoardResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(createResponse);

        return new BoardBO2();
    }

    @Step("Update board(set value for update and send request)")
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
                .usingRecursiveComparison()
                .ignoringFields("id", "prefs", "labelNames")
                .isEqualTo(baseBoardRequest);

        return new BoardBO2();

    }

    @Step("Delete created/updated board")
    public static void deleteBoardAndCheckResponseBO2() {
        Assert.assertEquals(boardHttpClient
                .deleteBoardRequest(createResponse.getId())
                .get_value(), new DeleteBoardResponse()
                .get_value(), "ListResponse mismatch");

    }

    @Step("Create board")
    public static BoardBO2 createBoardBO2() {
        BaseBoardResponse baseBoardResponse = boardHttpClient
                .createBoardRequest("Board" + RandomStringUtils.randomAlphabetic(10));
        setCreateResponse(baseBoardResponse);
        return new BoardBO2();
    }

    //    @Step("Save create request")
    private static void setCreateResponse(BaseBoardResponse createResponse) {
        BoardBO2.createResponse = createResponse;
    }

    //todo add labels

    private static BaseBoardResponse addBoardLabel(String boardId, String lableName, String colorName) {
        return new BoardLableHttpClient().createLabel(boardId, lableName, colorName);
    }

    @Step("Add all Labels")
    private static void addAllBoardLabels(String boardId) {
        colors.stream()
                .forEach((colors) -> addBoardLabel(boardId, colors + "LabelName", colors));
    }

    private static BoardBO2 addAllBoardLabelsBO2() {
        addAllBoardLabels(createResponse.getId());
        return new BoardBO2();
    }


}
