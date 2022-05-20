package org.eleks.api.trello.http_clients;
import io.restassured.response.Response;
import org.eleks.api.trello.models.responses.CardAttachmentResponse.CardAttachmentResponse;
import org.eleks.api.trello.models.responses.CardAttachmentResponse.GetCardsAttachmentsResponse.GetCardAttachmentsResponseItemResponse;

import java.util.List;

public class CardAttachmentHttpClient extends BaseHttpClient {
    protected static final String PATH = "/cards/";
    protected static final String PATHAttachments = "/attachments/";

    public CardAttachmentResponse createAttachmentOnCardRequest(String idCard, String attachmentName,String attachmentUrl) {

        Response response = BaseHttpClient
                .createRequestSpecification()
                .basePath(PATH+idCard+PATHAttachments)
                .queryParams("name", attachmentName)
                .queryParams("url", attachmentUrl)
                .post();

        return parsResponse(response, CardAttachmentResponse.class);
    }

    public CardAttachmentResponse getAttachmentOnCardRequest(String idCard,String idAttachment) {

        Response response = BaseHttpClient.createRequestSpecification()
                .get(PATH + idCard+PATHAttachments+idAttachment);

        return parsResponse(response, CardAttachmentResponse.class);
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

        Response response = BaseHttpClient
                .createRequestSpecification()
                .delete(PATH + idCard+PATHAttachments+idAttachment);

        return parsResponse(response, CardAttachmentResponse.class);
    }
}
