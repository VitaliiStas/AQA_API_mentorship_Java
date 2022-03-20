package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.models.requests.BaseBoardRequest;
import org.eleks.api.trello.models.requests.BoardBodyBuilder;
import org.eleks.api.trello.models.requests.ListHttpClient;
import org.eleks.api.trello.models.requests.ListRequest;
import org.eleks.api.trello.models.requests.board_request_nested_objects.LabelNames;
import org.eleks.api.trello.models.responses.BaseBoardResponse;
import org.eleks.api.trello.models.responses.Lists.ListResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class ListBO {
    public static BoardBO2 boardBO = new BoardBO2();
    private static ListBO listBO = new ListBO();
    private static ListHttpClient listHttpClient = new ListHttpClient();
    private static ListResponse baseListResponse;



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
    public static ListBO updateListAndCheckResponseBO() {
        ListRequest listRequest = new ListRequest();
        listRequest.setName("Updated Name");
        listRequest.setPos(123456789);

        updateList(baseListResponse.getId(), listRequest);
        return new ListBO();
    }

    public static ListBO closeListAndCheckResponseBO() {
        ListRequest listResponse = new ListRequest();
        listResponse.setName("Updated Name");
        listResponse.setPos(8192);
        listResponse.setClosed(true);

        updateList(baseListResponse.getId(), listResponse);
        return new ListBO();
    }


    public static ListBO createListAndCheckResponseBO() {
        listBO.createList();

        assertThat(baseListResponse)
                .isNotNull()
                .usingRecursiveComparison().ignoringFields("limits")
                .isEqualTo(getList());

        return new ListBO();
    }

    //todo updateList
    private static ListRequest updateList(String id, ListRequest requestBody) {

       ListRequest request = listHttpClient.updateListRequest(id, requestBody);
        assertThat(request)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits", "id", "idBoard")
                .isEqualTo(requestBody);

        return request;
    }


    private static void setBaseListResponse(ListResponse baseListResponse) {
        ListBO.baseListResponse = baseListResponse;
    }

    private static ListResponse getList() {
        return getListById(baseListResponse.getId());
    }

    @Step("Get List by ID")
    private static ListResponse getListById(String iD) {
        return listHttpClient.getListRequest(iD);
    }

    @Step("Create List")
    private ListResponse createList() {
        ListResponse listResponse = listHttpClient
                .createListRequest("Test_List" + RandomStringUtils.randomAlphabetic(10) + "Test_List"
                        , BoardBO2.getCreateResponse().getId());
        listBO.setBaseListResponse(listResponse);
        return listResponse;
    }

    private void createLists(int num) {
        for (int i = 0; i < num; i++) {
            createList();
        }
    }


}
