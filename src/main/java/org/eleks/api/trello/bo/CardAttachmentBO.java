package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import org.eleks.api.trello.http_clients.CardAttachmentHttpClient;
import org.eleks.api.trello.models.requests.CardsRequest;
import org.eleks.api.trello.models.responses.CardAttachmentResponse.CardAttachmentResponse;
import org.eleks.api.trello.models.responses.CardAttachmentResponse.GetCardsAttachmentsResponse.GetCardAttachmentsResponseItemResponse;
import org.eleks.api.trello.models.responses.Cards.CardsResponse;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CardAttachmentBO {
    private String idCard;
    private String attachmentUrl = "https://glavcom.ua/img/article/7466/53_main.jpeg";

    private CardAttachmentHttpClient cardAttachmentHttpClient = new CardAttachmentHttpClient();

    //    private static ThreadLocal<GetCardAttachmentsResponseItemResponse> baseCardAttachmentResponse = new ThreadLocal<>();
    private static ThreadLocal<CardAttachmentResponse> baseCardAttachmentResponse = new ThreadLocal<>();

    public CardAttachmentBO() {

    }

    public CardAttachmentBO(String idCard) {
        this.idCard = idCard;
    }

    @Step("Return to the card")
    public CardBO initCardBO() {
        return new CardBO();
    }


    @Step("Delete attachment")
    public CardAttachmentBO deleteAttachmentOnCard() {
        deleteAttachment(idCard, baseCardAttachmentResponse.get().getId());
        return this;
    }

    @Step("Add attachment to the card by URL(link to the attachment)")
    public CardAttachmentBO addAttachmentToCard() {
        createAttachment(idCard, "<<<Test Attachment>>>", attachmentUrl);
        assertThat(baseCardAttachmentResponse.get())
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits")
                .isEqualTo(getAttachmentById(idCard, baseCardAttachmentResponse.get().getId()));
        return this;
    }


    private void createAttachment(String idCard, String attachmentName, String attachmentUrl) {
        baseCardAttachmentResponse.set(cardAttachmentHttpClient.createAttachmentOnCardRequest(idCard, attachmentName, attachmentUrl));
    }

    private CardAttachmentResponse getAttachmentById(String idCard, String idAttachment) {
        return cardAttachmentHttpClient.getAttachmentOnCardRequest(idCard, idAttachment);
    }

    private CardAttachmentResponse deleteAttachment(String idCard, String idAttachment) {
        return cardAttachmentHttpClient.deleteAttachmentOnCardRequest(idCard, idAttachment);
    }


    //todo DELETE
//    public static void main(String[] args) {
//        ChecklistHttpClient checklistHttpClient = new ChecklistHttpClient();
//        //        cardBO.getCardById("6273d28ba6924d842050cd78");
////  checklist "6273f537354b03587ffd01be
//
////        checklistHttpClient.createChecklistRequest("6273d28ba6924d842050cd78", "2test checklist2").getId();
////        checklistHttpClient.deleteChecklistRequest("6273f021c9cd488a7ca88822");
////        checklistHttpClient.getChecklistRequest("627448b5a2d2a01a98d0b48a");
//
////        ChecklistRequest checklistRequestBody = new ChecklistRequest();
////        List<String> list = Arrays.asList("1.item1", "2.item2", "3.item3");
////        checklistRequestBody.setCheckItems(checklistItemsList);
////        checklistRequestBody.setCheckItems(list);
////        checklistHttpClient.updateChecklistRequest("62743d09924ec00e284a3a9a", checklistRequestBody);
////        checklistHttpClient
////                .addChecklistItemsRequest(checklistHttpClient
////                        .createChecklistRequest("6273d28ba6924d842050cd78", "asdasdasdasdasd")
////                        .getId(), list.get(1));
////
//
//
//           /*
//            "id": "6275271b8e3b73367bf36cb1",
//    "name": "asdasdasdasdasd",
//    "idBoard": "6273d26fae8b9b07a3cef076",
//    "idCard": "6273d28ba6924d842050cd78",
//
//    * "idChecklist": "6275271b8e3b73367bf36cb1",
//    "state": "incomplete",
//    "id": "6275271b24eafd39770f468b",
//    "name": "2.item2",
//    * */
//        CardAttachmentHttpClient cardAttachmentHttpClient =new CardAttachmentHttpClient();
//        CardsHttpClient cardsHttpClient = new CardsHttpClient();
////        cardsHttpClient.getCardRequest("6273d28ba6924d842050cd78");
////        cardAttachmentHttpClient.getAttachmentsOnCardRequest("6273d28ba6924d842050cd78");
////      attachment id  "id": "6275286ae1debd30086ba97b",
//        cardAttachmentHttpClient.getAttachmentOnCardRequest("6273d28ba6924d842050cd78","6275286ae1debd30086ba97b");
//    }
}

