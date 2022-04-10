package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.ListHttpClient;
import org.eleks.api.trello.models.requests.ListRequest;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.Lists.ListResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class ListBO {
    //    todo fix all static to non-static
//    public BoardBO2 boardBO = new BoardBO2();
//    public static BoardBO2 boardBO;
    private ListHttpClient listHttpClient = new ListHttpClient();
    private String boardID;
    //todo why it doesn't work with regular var and setters/getters? because it not static and cant work in the threads????
    private static ThreadLocal<ListResponse> baseListResponse = new ThreadLocal<>();
//    private ListResponse baseListResponse;

    public ListBO() {
    }
    //todo create constructor for board id
    public ListBO(String boardID) {
        this.boardID = boardID;
    }
    public ListBO(ListResponse response) {
       setBaseListResponse(response);
    }

    public BoardBO2 initBoardBO() {
        return new BoardBO2();
    }

    public CardBO initCardBO() {
        return new CardBO(getBaseListResponse().getId());
    }



/*
    delete
    {
    "id": "6237386f8a579729e29d51e6",
    "name": "Test_ListCfgoZOYwUATest_List",
    "closed": false,
    "idBoard": "6237386e2289102cb1024971",
    "pos": 8192,
    "limits": {
    }
*/


    @Step("Update List")
    public ListBO updateListAndCheckResponseBO() {
        ListRequest listRequest = new ListRequest();
        listRequest.setName("Updated Name");
        listRequest.setPos(123456789);

        updateList(getBaseListResponse().getId(), listRequest);
        return new ListBO();
    }

    public ListBO closeListAndCheckResponseBO() {
        ListRequest listResponse = new ListRequest();
        listResponse.setName("Updated Name");
        listResponse.setPos(8192);
        listResponse.setClosed(true);

        updateList(getBaseListResponse().getId(), listResponse);
        return new ListBO();
    }


    public ListBO createListAndCheckResponseBO() {
        createList(boardID);

        assertThat(getBaseListResponse())
                .isNotNull()
                .usingRecursiveComparison().ignoringFields("limits")
                .isEqualTo(getList());

        return new ListBO();
    }

    //todo updateList
    private ListRequest updateList(String id, ListRequest requestBody) {

        ListRequest request = listHttpClient.updateListRequest(id, requestBody);
        assertThat(request)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits", "id", "idBoard")
                .isEqualTo(requestBody);

        return request;
    }

    public static ListResponse getBaseListResponse() {
        return baseListResponse.get();
    }

    public static void setBaseListResponse(ListResponse baseListResponse) {
        ListBO.baseListResponse.set(baseListResponse);
    }

    private ListResponse getList() {
        return getListById(getBaseListResponse().getId());
    }

    @Step("Get List by ID")
    private ListResponse getListById(String iD) {
        return listHttpClient.getListRequest(iD);
    }

    @Step("Create List")
    private ListBO createList(String boardID) {
//        ListResponse listResponse = listHttpClient
        return new ListBO( listHttpClient
                .createListRequest("Test_List" + RandomStringUtils.randomAlphabetic(10) + "Test_List"
                        , boardID));

//        return new ListBO();
    }

    private void createLists(String boardID, int num) {
        for (int i = 0; i < num; i++) {
            createList(boardID);
        }
    }


}
