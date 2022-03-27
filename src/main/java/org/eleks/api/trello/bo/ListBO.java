package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.models.requests.ListHttpClient;
import org.eleks.api.trello.models.requests.ListRequest;
import org.eleks.api.trello.models.responses.Lists.ListResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class ListBO {
    //    todo fix all static to non-static
    public BoardBO2 boardBO = new BoardBO2();
    private ListHttpClient listHttpClient = new ListHttpClient();
    private String boardID;
    private static ListResponse baseListResponse;

    private ListBO() {
    }

    //todo create constructor for board id
    public ListBO(String boardID) {
        this.boardID = boardID;
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

        updateList(baseListResponse.getId(), listRequest);
        return new ListBO();
    }

    public ListBO closeListAndCheckResponseBO() {
        ListRequest listResponse = new ListRequest();
        listResponse.setName("Updated Name");
        listResponse.setPos(8192);
        listResponse.setClosed(true);

        updateList(baseListResponse.getId(), listResponse);
        return new ListBO();
    }


    public ListBO createListAndCheckResponseBO() {
        createList(boardID);

        assertThat(baseListResponse)
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


    private  void setBaseListResponse(ListResponse baseListResponse) {
        this.baseListResponse = baseListResponse;
    }

    private ListResponse getList() {
        return getListById(baseListResponse.getId());
    }

    @Step("Get List by ID")
    private ListResponse getListById(String iD) {
        return listHttpClient.getListRequest(iD);
    }

    @Step("Create List")
    private ListResponse createList(String boardID) {
        ListResponse listResponse = baseListResponse = listHttpClient
                .createListRequest("Test_List" + RandomStringUtils.randomAlphabetic(10) + "Test_List"
                        , boardID);

        setBaseListResponse(listResponse);
        return listResponse;
    }

    private void createLists(String boardID, int num) {
        for (int i = 0; i < num; i++) {
            createList(boardID);
        }
    }





}
