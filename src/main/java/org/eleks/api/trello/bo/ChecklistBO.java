package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.ChecklistHttpClient;
import org.eleks.api.trello.models.requests.Checklist.ChecklistRequest;
import org.eleks.api.trello.models.responses.Checklist.ChecklistResponse;
import org.eleks.api.trello.models.responses.Checklist.GetChecklistItemsList.GetChecklistItems;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ChecklistBO {

    private String idCard;
    private ChecklistHttpClient checklistHttpClient = new ChecklistHttpClient();
    private static ThreadLocal<ChecklistResponse> baseChecklistResponse = new ThreadLocal<>();

    private static List<String> checklistItemsList =
            Arrays.asList("1.item1", "2.item2", "3.item3", "4.item4", "5.item5", "6.item6");

    private static ChecklistResponse getBaseChecklistResponse() {
        return baseChecklistResponse.get();
    }

    private ChecklistBO() {
        if (baseChecklistResponse.get() != null) {
            this.idCard = baseChecklistResponse.get().getIdCard();
        }
    }

    public ChecklistBO(String idCard) {
        this.idCard = idCard;
    }

    @Step("Return to the card")
    public CardBO initCardBO(){return new CardBO(); }

    @Step("Create checklist on the card")
    public ChecklistBO createChecklistAndCheckResponse() {
        createChecklist(idCard
                , "New Test Checklist" + RandomStringUtils.randomAlphabetic(10));

        assertThat(getBaseChecklistResponse())
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits")
                .isEqualTo(getChecklistById(getBaseChecklistResponse().getId()));
        return new ChecklistBO();
    }

    //todo add checking
    @Step("Add checklistItems on the checklist")
    public ChecklistBO addChecklistItemsAndCheck() {
        String checklistId = getBaseChecklistResponse().getId();

        for (int i = 0; i < checklistItemsList.size(); i++) {
            checklistHttpClient
                    .addChecklistItemsRequest(checklistId, checklistItemsList.get(i));
        }
        List<GetChecklistItems> checkListResponse = checklistHttpClient.getChecklistItemsRequest(checklistId);

        for (int i = 0; i < checkListResponse.size(); i++) {
            Assert.assertEquals(checkListResponse.get(i).getName(), checklistItemsList.get(i)
                    , "<!!!!!!!!Checklist Items mismatch!!!!!!!>");
        }
        return new ChecklistBO();
    }


    private ChecklistRequest addChecklistItems(String idChecklist, String checklistItemName) {
        return checklistHttpClient.addChecklistItemsRequest(idChecklist, checklistItemName);
    }

    private ChecklistBO createChecklist(String idCard, String checklistName) {
        baseChecklistResponse.set(checklistHttpClient.createChecklistRequest(idCard, checklistName));
        return this;
    }

    private ChecklistResponse getChecklistById(String idChecklist) {
        return checklistHttpClient.getChecklistRequest(idChecklist);
    }

    private ChecklistRequest updateChecklistById(String idChecklist, ChecklistRequest checklistRequestBody) {
        return checklistHttpClient.updateChecklistRequest(idChecklist, checklistRequestBody);
    }
}
/*
 {
    "idChecklist": "627448b5a2d2a01a98d0b48a",
    "state": "incomplete",
    "id": "627448b661c90c4149d9c319",
    "name": "2.item2",
    "nameData": {
        "emoji": {

        }
    },
    "pos": 16384,
    "due": null,
    "idMember": null,
    "limits": {

    }
}

Process finished with exit code 0

* */