import org.eleks.api.trello.bo.BoTestPreconditions;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class CustomTestSuit extends BaseTest {

    @Test
    public void addAttachmentToCardAndCheckTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .initCardAttachmentBO()
                .addAttachmentToCard()
        ;
    }

    @Test
    public void addAttachmentAndChecklist() {
        new BoTestPreconditions()
                .createCardWithAttachmentPreconditions()
        ;
    }

    @Test
    public void checkRemovingCard() {
        new BoTestPreconditions()
        .createCardPreconditions()

                .deleteCardAndCheckResponse();
        ;
    }

    @Test
    public void checkRemovingCardWithAttachmentAndChecklist() {
        new BoTestPreconditions()
                .createCardChecklistChecklistItemsAttachmentPreconditions()

                .initCardBO()
                .deleteCardAndCheckResponse();
        ;

    }


    public void checkAllRemoving() {
        new BoTestPreconditions()
                .createCardWithAttachmentPreconditions()

                .deleteAttachmentOnCard()
                .initCardBO()
                .deleteCardAndCheckResponse()
                .initListBO()
                .closeListAndCheckResponseBO()
        ;
    }


}
