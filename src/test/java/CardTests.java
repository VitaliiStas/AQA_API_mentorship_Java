import org.eleks.api.trello.bo.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class CardTests extends BaseTest {
    @Test
    public void createNewCardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
        ;
    }

    @Test
    public void updateCardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .updateCardAndCheckResponse()
        ;
    }
    @Test
    public void getCardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .updateCardAndCheckResponse()
                .getCardAndCheckResponse()
        ;
    }
    @Test
    public void deleteCardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .deleteCardAndCheckResponse()
        ;
    }
//    todo added
    @Test
    public void moveCardBetweenListsAndCheckTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .moveCardToBetweenListsAndCheck()
        ;
    }

    @Test
    public void addChecklistToCardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
        ;
    }

    @Test
    public void addChecklistItemsToCardAndCheckTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .addChecklistItemsAndCheck()
        ;
    }
    @Test
    public void addAttachmentToCardAndCheckTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initCardAttachmentBO()
                .addAttachmentToCard()
        ;
    }
}
