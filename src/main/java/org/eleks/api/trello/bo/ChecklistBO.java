package org.eleks.api.trello.bo;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.ChecklistHttpClient;
import org.eleks.api.trello.models.requests.Checklist.ChecklistRequest;
import org.eleks.api.trello.models.responses.Cards.Cover;
import org.eleks.api.trello.models.responses.Checklist.ChecklistResponse;

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


    public ChecklistBO createChecklistAndCheckResponse() {
        ChecklistBO checklistBO = createChecklist(idCard
                , "New Test Checklist" + RandomStringUtils.randomAlphabetic(10));

        assertThat(checklistBO)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits")
                .isEqualTo(getChecklistById(getBaseChecklistResponse().getId()));
        return new ChecklistBO();
    }

//todo add checking
    public ChecklistBO addChecklistItemsAndCheck() {

        for (int i = 0; i <checklistItemsList.size() ; i++) {
            checklistHttpClient
                    .addChecklistItemsRequest(getBaseChecklistResponse().getId(),checklistItemsList.get(i));
        }
        return new ChecklistBO();
    }


    private ChecklistRequest addChecklistItems(String idChecklist, String checklistItemName) {
        return checklistHttpClient.addChecklistItemsRequest(idChecklist,checklistItemName);
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


    //todo DELETE
    public static void main(String[] args) {
        //        cardBO.getCardById("6273d28ba6924d842050cd78");
//  checklist "6273f537354b03587ffd01be
        ChecklistHttpClient checklistHttpClient = new ChecklistHttpClient();
//        checklistHttpClient.createChecklistRequest("6273d28ba6924d842050cd78", "2test checklist2").getId();
//        checklistHttpClient.deleteChecklistRequest("6273f021c9cd488a7ca88822");
//        checklistHttpClient.getChecklistRequest("6273f537354b03587ffd01be");

        ChecklistRequest checklistRequestBody = new ChecklistRequest();
//        List<String> list = Arrays.asList("1.item1", "2.item2", "3.item3");
//        checklistRequestBody.setCheckItems(checklistItemsList);
//        checklistRequestBody.setCheckItems(list);
//        checklistHttpClient.updateChecklistRequest("62743d09924ec00e284a3a9a", checklistRequestBody);
        checklistHttpClient
                .addChecklistItemsRequest(checklistHttpClient
                        .createChecklistRequest("6273d28ba6924d842050cd78", "2test checklist2").getId(), checklistItemsList.get(1));
    }
}
/*
 {
    "id": "6273d9dffb56a0508a376f5f",
    "name": "test checklist",
    "idBoard": "6273d26fae8b9b07a3cef076",
    "idCard": "6273d28ba6924d842050cd78",
    "pos": 16384,
    "checkItems": [],
    "limits": {}
}
* */