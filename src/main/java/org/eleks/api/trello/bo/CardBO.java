package org.eleks.api.trello.bo;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.bo.board.BoardBO2;
import org.eleks.api.trello.http_clients.CardsHttpClient;
import org.eleks.api.trello.http_clients.GetAllListHttpClient;
import org.eleks.api.trello.models.requests.CardsRequest;
import org.eleks.api.trello.models.responses.Cards.CardsResponse;
import org.eleks.api.trello.models.responses.Cards.Cover;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardBO {
    private String listID;
    private CardsHttpClient cardHttpClient = new CardsHttpClient();

    private GetAllListHttpClient getAllListHttpClient = new GetAllListHttpClient();

    private static ThreadLocal<CardsResponse> baseCardResponse = new ThreadLocal<>();

    private static List<String> colors =
            Arrays.asList("pink", "yellow", "lime", "blue", "black", "orange", "red", "purple", "sky", "green");
    private static List<String> defaultLists =
            Arrays.asList("To Do", "Doing", "Done");


    public CardBO moveCardToBetweenListsAndCheck() {
        /*
        I'm extracting listId(list for the moving card ) from the map(saved all list names & listId)
        "defaultLists" List of default board lists
 */
        //todo doesn't work
//        defaultLists.stream().forEach(x-> moveCardToTheList(baseCardResponse.get().getId(),x));

        for (int i = 0; i < defaultLists.size(); i++) {
            moveCardToTheList(baseCardResponse.get().getId()
                    , allBoardListsId().get(defaultLists.get(i)));

//            todo check if moved to the correct List

            Assert.assertEquals(getCardById(baseCardResponse.get().getId()).getIdList()
                    , allBoardListsId().get(defaultLists.get(i))
                    , "Card moved to the incorrect List: '" + defaultLists.get(i) + "'");
        }
        return this;
    }


    private CardBO moveCardToTheList(String cardId, String listID) {
        CardsRequest cardsRequest = new CardsRequest();
        cardsRequest.setIdList(listID);
        updateCard(cardId, cardsRequest);
        return new CardBO();
    }

    //todo work fine ?????
    private HashMap<String, String> allBoardListsId() {
/* I'm parsing it and extract key:"name" and value:"getId" to the map
From this map I'm extracting
 */
        HashMap<String, String> idsMap = new HashMap<>();

        getAllListHttpClient
                .getAllListsFromBoard(new BoardBO2().getCreateBoardResponse().getId())
                .forEach(x -> idsMap.put(x.getName(), x.getId()));
        return idsMap;
    }

    public CardBO() {
        if (baseCardResponse.get() != null) {
            this.listID = baseCardResponse.get().getIdList();
        }
    }

    public CardBO(String listID) {
        this.listID = listID;
    }

    @Step("Return to the list")
    public ListBO initListBO() {
        return new ListBO();
    }

    @Step("Go to the checklist")
    public ChecklistBO initChecklistBO() {
        return new ChecklistBO(getBaseCardResponse().getId());
    }

    @Step("Go to the attachment")
    public CardAttachmentBO initCardAttachmentBO() {
        return new CardAttachmentBO(getBaseCardResponse().getId());
    }

    private static CardsResponse getBaseCardResponse() {
        return baseCardResponse.get();
    }


    public CardBO getCardAndCheckResponse() {
        CardsResponse cardsResponse = getCardById(getBaseCardResponse().getId());
        assertThat(cardsResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits")
                .isEqualTo(getCardById(cardsResponse.getId()));
        return new CardBO();
    }

    @Step("Delete card")
    public CardBO deleteCardAndCheckResponse() {
        CardsResponse cardsResponse = deleteCard(getBaseCardResponse().getId());
        assertThat(cardsResponse).isNotNull();
        return new CardBO();
    }

    @Step("Update card")
    public CardBO updateCardAndCheckResponse() {
        CardsRequest cardsRequest = new CardsRequest();
        cardsRequest.setName("UPDATED NAME");
        cardsRequest.setDesc("UPDATED DeScRiPtIoN");
        cardsRequest.setAddress("UPDATED Address");
        Cover cover = new Cover();
        cover.setColor(colors.get(1));
        cardsRequest.setCover(cover);
        cardHttpClient.updateCardRequest(getBaseCardResponse().getId(), cardsRequest);
        return new CardBO();
    }

    @Step("Create new card")
    public CardBO createCardAndCheckResponse() {
        createCard(listID, "New Test Card" + RandomStringUtils.randomAlphabetic(10));
        assertThat(getBaseCardResponse())
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits")
                .isEqualTo(getCardById(getBaseCardResponse().getId()));
        return new CardBO();
    }

    private CardBO multiCardsCreation() {
        createCards(listID, 10);
        return new CardBO();
    }


    //    private CardsResponse createCard(String listID, String cardName) {
    private CardBO createCard(String listID, String cardName) {
        baseCardResponse.set(cardHttpClient.createCardRequest(listID, cardName));
        return this;
    }

    private void createCards(String listID, int cardCount) {
        for (int i = 0; i < cardCount; i++) {
            cardHttpClient.createCardRequest(listID, "Card №: " + (i + 1));
        }
    }

    private CardsRequest updateCard(String idCard, CardsRequest cardsRequestBody) {
        return cardHttpClient.updateCardRequest(idCard, cardsRequestBody);
    }

    private CardsResponse getCardById(String idCard) {
        return cardHttpClient.getCardRequest(idCard);
    }

    private CardsResponse deleteCard(String idCard) {
        return cardHttpClient.deleteCardRequest(idCard);
    }

}
