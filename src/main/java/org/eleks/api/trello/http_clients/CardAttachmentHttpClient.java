package org.eleks.api.trello.http_clients;

import org.eleks.api.trello.models.responses.CardAttachmentResponse.CardAttachmentResponse;
import org.eleks.api.trello.models.responses.CardAttachmentResponse.GetCardsAttachmentsResponse.GetCardAttachmentsResponseItemResponse;

import java.util.List;

public class CardAttachmentHttpClient extends BaseHttpClient {
    protected static final String PATH = "/cards/";
    protected static final String PATHAttachments = "/attachments/";

    public CardAttachmentResponse createAttachmentOnCardRequest(String idCard, String attachmentName) {
        return BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH+idCard+PATHAttachments)
                .queryParams("name", attachmentName)
                .post()
                .then()
                .log()
                .all()
                .extract()
                .as(CardAttachmentResponse.class);
    }

    public CardAttachmentResponse getAttachmentOnCardRequest(String idCard,String idAttachment) {
        return BaseHttpClient.createRequestSpecification()
                .get(PATH + idCard+PATHAttachments+idAttachment)
                .then()
                .log()
                .all()
                .extract()
                .as(CardAttachmentResponse.class);
    }

    public List<GetCardAttachmentsResponseItemResponse> getAttachmentsOnCardRequest(String idCard) {
        List<GetCardAttachmentsResponseItemResponse> responseList =
        BaseHttpClient.createRequestSpecification()
                .basePath(PATH + idCard+PATHAttachments)
                .queryParams("fields", "all")
                .queryParams("filter", "cover")
                .get()
                .then()
                .log()
                .all()
                .extract().jsonPath().getList(".",GetCardAttachmentsResponseItemResponse.class);
        return responseList;
    }

    public CardAttachmentResponse deleteAttachmentOnCardRequest(String idCard,String idAttachment) {
        return BaseHttpClient
                .createRequestSpecification()
                .delete(PATH + idCard+PATHAttachments+idAttachment)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(CardAttachmentResponse.class);
    }
}
