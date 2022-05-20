package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import org.eleks.api.trello.http_clients.CardAttachmentHttpClient;
import org.eleks.api.trello.models.responses.CardAttachmentResponse.CardAttachmentResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class CardAttachmentBO {
    private String idCard;
    private String attachmentUrl = "https://glavcom.ua/img/article/7466/53_main.jpeg";

    private CardAttachmentHttpClient cardAttachmentHttpClient = new CardAttachmentHttpClient();

    private static ThreadLocal<CardAttachmentResponse> baseCardAttachmentResponse = new ThreadLocal<>();

    public CardAttachmentBO() {}
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

}

