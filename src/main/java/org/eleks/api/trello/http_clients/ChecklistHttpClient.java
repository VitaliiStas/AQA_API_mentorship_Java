package org.eleks.api.trello.http_clients;

import org.eleks.api.trello.models.requests.Checklist.ChecklistRequest;
import org.eleks.api.trello.models.responses.Checklist.ChecklistResponse;
import org.eleks.api.trello.models.responses.Checklist.GetChecklistItemsList.GetChecklistItems;

import java.util.List;

public class ChecklistHttpClient extends BaseHttpClient {
    protected static final String PATH = "/checklists/";

    public ChecklistResponse createChecklistRequest(String idCard, String checklistName) {
        return BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH)
                .queryParams("idCard", idCard)
                .queryParams("name", checklistName)
                .post()
                .then()
                .log()
                .all()
                .extract()
                .as(ChecklistResponse.class);
    }

    public ChecklistResponse getChecklistRequest(String idChecklist) {
        return BaseHttpClient.createRequestSpecification()
                .get(PATH + idChecklist)
                .then()
                .log()
                .all()
                .extract()
                .as(ChecklistResponse.class);
    }

    public ChecklistResponse deleteChecklistRequest(String idChecklist) {
        return BaseHttpClient
                .createRequestSpecification()
                .delete(PATH + idChecklist)
                .then()
                .log()
                .all()
                .statusCode(200).extract().as(ChecklistResponse.class);
    }

    public ChecklistRequest updateChecklistRequest(String idChecklist, ChecklistRequest checklistRequestBody) {
        return BaseHttpClient
                .createRequestSpecification()
                .body(checklistRequestBody)
                .put(PATH + idChecklist)
                .then()
//                .log()
//                .all()
                .extract()
                .as(ChecklistRequest.class);
    }

    //protected static final String PATH = "/checklists/";
    public ChecklistRequest addChecklistItemsRequest(String idChecklist, String checklistItem) {
        return BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH + idChecklist + "/checkItems/")
                .queryParams("name", checklistItem)
                .post()
                .then()
                .log()
                .all()
                .extract()
                .as(ChecklistRequest.class);
    }

    public List<GetChecklistItems> getChecklistItemsRequest(String idChecklist) {

        List<GetChecklistItems> getChecklistItemsList = BaseHttpClient.createRequestSpecification()
                .get(PATH + idChecklist + "/checkItems/")
                .then()
                .log()
                .all()
                .extract()
//                .as(List<GetChecklistItems>.class);
                .body().jsonPath().getList(".", GetChecklistItems.class);
        return getChecklistItemsList;
    }

}
