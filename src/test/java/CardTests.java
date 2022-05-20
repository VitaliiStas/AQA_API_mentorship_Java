import org.eleks.api.trello.bo.BoTestPreconditions;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class CardTests extends BaseTest {
    @Test
    public void createNewCardAndCheckResponseTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()
        ;
    }

    @Test
    public void updateCardAndCheckResponseTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .updateCardAndCheckResponse()
        ;
    }

    @Test
    public void getCardAndCheckResponseTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .updateCardAndCheckResponse()
                .getCardAndCheckResponse()
        ;
    }

    @Test
    public void deleteCardAndCheckResponseTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .deleteCardAndCheckResponse()
        ;
    }

    //    todo added
    @Test
    public void moveCardBetweenListsAndCheckTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .moveCardToBetweenListsAndCheck()
        ;
    }

    @Test
    public void addChecklistToCardAndCheckResponseTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .initChecklistBO()
                .createChecklistAndCheckResponse()
        ;
    }

    @Test
    public void addChecklistItemsToCardAndCheckTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .initChecklistBO()
                .createChecklistAndCheckResponse()
                .addChecklistItemsAndCheck()
        ;
    }

    @Test
    public void addAttachmentToCardAndCheckTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .initCardAttachmentBO()
                .addAttachmentToCard()
        ;
    }
}
