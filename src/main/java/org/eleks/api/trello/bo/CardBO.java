package org.eleks.api.trello.bo;

import org.apache.commons.lang3.RandomStringUtils;
import org.eleks.api.trello.http_clients.CardsHttpClient;
import org.eleks.api.trello.models.requests.CardsRequest;
import org.eleks.api.trello.models.responses.Cards.CardsResponse;
import org.eleks.api.trello.models.responses.Cards.Cover;
import org.eleks.api.trello.models.responses.Lists.ListResponse;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardBO {
    private static String listID;
    private static CardsHttpClient cardHttpClient = new CardsHttpClient();
    private static ThreadLocal<CardsResponse> baseCardResponse = new ThreadLocal<>();

    private static List<String> colors =
            Arrays.asList("pink", "yellow", "lime", "blue", "black", "orange", "red", "purple", "sky", "green");

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

    public ListBO initListBO(){
        return new  ListBO();
    }

    public CardBO getCardAndCheckResponse(){
        CardsResponse cardsResponse = getCardById(getBaseCardResponse().getId());
        assertThat(cardsResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits")
                .isEqualTo(getCardById(cardsResponse.getId()));
        return new CardBO();
    }

    public CardBO deleteCardAndCheckResponse(){
        CardsResponse cardsResponse = deleteCard(getBaseCardResponse().getId());
        assertThat(cardsResponse).isNotNull();
        return new CardBO();
    }

    public CardBO updateCardAndCheckResponse(){
        CardsRequest cardsRequest = new CardsRequest();
            cardsRequest.setName("UPDATED NAME");
            cardsRequest.setDesc("UPDATED DeScRiPtIoN");
            cardsRequest.setAddress("UPDATED Address");
                Cover cover = new Cover();
                    cover.setColor(colors.get(1));
            cardsRequest.setCover(cover);
        cardHttpClient.updateCardRequest(getBaseCardResponse().getId(),cardsRequest);
        return new CardBO();
    }


    public CardBO createCardAndCheckResponse(){
        CardsResponse cardsResponse = createCard(listID,"New Test Card"+ RandomStringUtils.randomAlphabetic(10));

        assertThat(cardsResponse)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("limits")
                .isEqualTo(getCardById(cardsResponse.getId()));
        return new CardBO(cardsResponse);
    }

    private CardBO multiCardsCreation(){
        createCards(listID,10);
        return new  CardBO();
    }

    private CardsResponse createCard(String listID, String cardName){
        return cardHttpClient.createCardRequest(listID,cardName);
    }
    private void createCards(String listID, int cardCount){
        for (int i = 0; i <cardCount; i++) {
             cardHttpClient.createCardRequest(listID,"Card №: "+(i+1));
        }
    }

    private CardsRequest updateCard(String idCard, CardsRequest cardsRequestBody){
        return cardHttpClient.updateCardRequest(idCard,cardsRequestBody);
    }

    private CardsResponse getCardById(String idCard){
        return cardHttpClient.getCardRequest(idCard);
    }

    private CardsResponse deleteCard(String idCard){
        return cardHttpClient.deleteCardRequest(idCard);
    }

}
