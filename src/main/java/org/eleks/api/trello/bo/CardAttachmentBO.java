package org.eleks.api.trello.bo;

import org.eleks.api.trello.http_clients.CardAttachmentHttpClient;
import org.eleks.api.trello.http_clients.CardsHttpClient;
import org.eleks.api.trello.http_clients.ChecklistHttpClient;
import org.eleks.api.trello.models.requests.Checklist.ChecklistRequest;

import java.util.Arrays;
import java.util.List;

public class CardAttachmentBO {
    CardAttachmentHttpClient cardAttachmentHttpClient =new CardAttachmentHttpClient();



    //todo DELETE
    public static void main(String[] args) {
        //        cardBO.getCardById("6273d28ba6924d842050cd78");
//  checklist "6273f537354b03587ffd01be
        ChecklistHttpClient checklistHttpClient = new ChecklistHttpClient();
//        checklistHttpClient.createChecklistRequest("6273d28ba6924d842050cd78", "2test checklist2").getId();
//        checklistHttpClient.deleteChecklistRequest("6273f021c9cd488a7ca88822");
//        checklistHttpClient.getChecklistRequest("627448b5a2d2a01a98d0b48a");

//        ChecklistRequest checklistRequestBody = new ChecklistRequest();
//        List<String> list = Arrays.asList("1.item1", "2.item2", "3.item3");
//        checklistRequestBody.setCheckItems(checklistItemsList);
//        checklistRequestBody.setCheckItems(list);
//        checklistHttpClient.updateChecklistRequest("62743d09924ec00e284a3a9a", checklistRequestBody);
//        checklistHttpClient
//                .addChecklistItemsRequest(checklistHttpClient
//                        .createChecklistRequest("6273d28ba6924d842050cd78", "asdasdasdasdasd")
//                        .getId(), list.get(1));
//


           /*
            "id": "6275271b8e3b73367bf36cb1",
    "name": "asdasdasdasdasd",
    "idBoard": "6273d26fae8b9b07a3cef076",
    "idCard": "6273d28ba6924d842050cd78",

    * "idChecklist": "6275271b8e3b73367bf36cb1",
    "state": "incomplete",
    "id": "6275271b24eafd39770f468b",
    "name": "2.item2",
    * */
        CardAttachmentHttpClient cardAttachmentHttpClient =new CardAttachmentHttpClient();
        CardsHttpClient cardsHttpClient = new CardsHttpClient();
//        cardsHttpClient.getCardRequest("6273d28ba6924d842050cd78");
        cardAttachmentHttpClient.getAttachmentsOnCardRequest("6273d28ba6924d842050cd78");
//      attachment id  "id": "6275286ae1debd30086ba97b",
    }
}

