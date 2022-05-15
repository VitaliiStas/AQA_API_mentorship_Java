import org.eleks.api.trello.bo.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class CustomTestSuit extends BaseTest {

    @Test
    public void addAttachmentToCardAndCheckTestBO2() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initCardAttachmentBO()
                .addAttachmentToCard()
        ;
    }

    @Test
    public void addAttachmentAndChecklist() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initCardAttachmentBO()
                .addAttachmentToCard()
                .initCardBO()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .addChecklistItemsAndCheck()
        ;
    }

    @Test
    public void checkRemovingCard() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .deleteCardAndCheckResponse();
        ;
    }

    @Test
    public void checkRemovingCardWithAttachmentAndChecklist() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .initCardBO()
                .initCardAttachmentBO()
                .addAttachmentToCard()
                .initCardBO()
                .deleteCardAndCheckResponse();
        ;
    }

    @Test
    public void checkAllRemoving() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .initCardBO()
                .initCardAttachmentBO()
                .addAttachmentToCard()
                .deleteAttachmentOnCard()
                .initCardBO()
                .deleteCardAndCheckResponse()
                .initListBO()
                .closeListAndCheckResponseBO()
        ;
    }


    @Test
    public void smokeTest() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .moveCardToBetweenListsAndCheck()
                .updateCardAndCheckResponse()
                .moveCardToBetweenListsAndCheck()
                .updateCardAndCheckResponse()
                .initCardAttachmentBO()
                .addAttachmentToCard()
                .initCardBO()
                .updateCardAndCheckResponse()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .addChecklistItemsAndCheck()
                .initCardBO()
                .deleteCardAndCheckResponse()
                .createCardAndCheckResponse()
                .initListBO()
                .closeListAndCheckResponseBO()
                .initBoardBO()
                .deleteBoardAndCheckResponseBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .updateListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .updateCardAndCheckResponse()
                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .addChecklistItemsAndCheck()
                .initCardBO()
                .initCardAttachmentBO()
                .addAttachmentToCard()
                .initCardBO()
                .deleteCardAndCheckResponse()
                .initListBO()
                .closeListAndCheckResponseBO()
                .initBoardBO()
        ;
    }
}
