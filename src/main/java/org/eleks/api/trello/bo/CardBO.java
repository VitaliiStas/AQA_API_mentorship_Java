package org.eleks.api.trello.bo;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.CardsHttpClient;
import org.eleks.api.trello.http_clients.GetAllListHttpClient;
import org.eleks.api.trello.models.requests.CardsRequest;
import org.eleks.api.trello.models.responses.Cards.CardsResponse;
import org.eleks.api.trello.models.responses.Cards.Cover;

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


    //todo
    public CardBO moveCardToBetweenLists() {
        /*
        I'm extracting listId(list for the moving card ) from the map(saved all list names & listId)
        "defaultLists" List of default board lists
 */
//        return moveCardToTheList(baseCardResponse.get().getId()
//                , allBoardsId().get(defaultLists.get(0)));
//        for (int i = 0; i < defaultLists.size(); i++) {
//            moveCardToTheList(baseCardResponse.get().getId()
//                    , allBoardsId().get(defaultLists.get(i)));
//        }
        defaultLists.stream().forEach(x-> moveCardToTheList(baseCardResponse.get().getId(),x));
        return this;
    }


    private CardBO moveCardToTheList(String cardId, String listID) {
        CardsRequest cardsRequest = new CardsRequest();
        cardsRequest.setIdList(listID);
        updateCard(cardId, cardsRequest);
        return new CardBO();
    }

    //todo don't work cant deserialize from array ?????
    private HashMap<String, String> allBoardsId() {
/* I'm parsing it and extract key:"name" and value:"getId" to the map
From this map I'm extracting
 */
        HashMap<String, String> idsMap = new HashMap<>();

        getAllListHttpClient
                .getAllListsFromBoard(BoardBO2.getCreateBoardResponse().getId())
                .forEach(x -> idsMap.put(x.getName(), x.getId()));
        return idsMap;
    }

    private CardBO() {
    }

    public CardBO(String listID) {
        this.listID = listID;
    }

    private CardBO(CardsResponse cardsResponse) {
        setBaseCardResponse(cardsResponse);
    }

    public static CardsResponse getBaseCardResponse() {
        return baseCardResponse.get();
    }

    public static void setBaseCardResponse(CardsResponse baseCardResponse) {
        CardBO.baseCardResponse.set(baseCardResponse);
    }

    public ListBO initListBO() {
        return new ListBO();
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

    public CardBO deleteCardAndCheckResponse() {
        CardsResponse cardsResponse = deleteCard(getBaseCardResponse().getId());
        assertThat(cardsResponse).isNotNull();
        return new CardBO();
    }

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


    public CardBO createCardAndCheckResponse() {
        CardsResponse cardsResponse = createCard(listID, "New Test Card" + RandomStringUtils.randomAlphabetic(10));

        assertThat(cardsResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits")
                .isEqualTo(getCardById(cardsResponse.getId()));
        return new CardBO(cardsResponse);
    }

    private CardBO multiCardsCreation() {
        createCards(listID, 10);
        return new CardBO();
    }

    private CardsResponse createCard(String listID, String cardName) {
        return cardHttpClient.createCardRequest(listID, cardName);
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
