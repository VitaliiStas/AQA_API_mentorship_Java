package org.eleks.api.trello.http_clients;

import io.restassured.response.Response;
import org.eleks.api.trello.models.requests.Checklist.ChecklistRequest;
import org.eleks.api.trello.models.responses.CardAttachmentResponse.CardAttachmentResponse;
import org.eleks.api.trello.models.responses.Checklist.ChecklistResponse;
import org.eleks.api.trello.models.responses.Checklist.GetChecklistItemsList.GetChecklistItems;

import java.util.List;

public class ChecklistHttpClient extends BaseHttpClient {
    protected static final String PATH = "/checklists/";

    public ChecklistResponse createChecklistRequest(String idCard, String checklistName) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH)
                .queryParams("idCard", idCard)
                .queryParams("name", checklistName)
                .post();

        return parsResponse(response, ChecklistResponse.class);
    }

    public ChecklistResponse getChecklistRequest(String idChecklist) {

        Response response = BaseHttpClient.createRequestSpecification()
                .get(PATH + idChecklist);

        return parsResponse(response, ChecklistResponse.class);
    }

    public ChecklistResponse deleteChecklistRequest(String idChecklist) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .delete(PATH + idChecklist);

        return parsResponse(response, ChecklistResponse.class);
    }

    public ChecklistRequest updateChecklistRequest(String idChecklist, ChecklistRequest checklistRequestBody) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .body(checklistRequestBody)
                .put(PATH + idChecklist);

        return parsResponse(response, ChecklistRequest.class);
    }

    public ChecklistRequest addChecklistItemsRequest(String idChecklist, String checklistItem) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH + idChecklist + "/checkItems/")
                .queryParams("name", checklistItem)
                .post();

        return parsResponse(response, ChecklistRequest.class);
    }

    public List<GetChecklistItems> getChecklistItemsRequest(String idChecklist) {

        List<GetChecklistItems> getChecklistItemsList = BaseHttpClient
                .createRequestSpecification()
                .get(PATH + idChecklist + "/checkItems/")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList(".", GetChecklistItems.class);

        return getChecklistItemsList;
    }

}
