import org.eleks.api.trello.bo.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class CardTests extends BaseTest {
    @Test
    public void createNewCardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
        ;
    }

    @Test
    public void updateCardAndCheckResponseTestBO2() {
        BoardBO2
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
        BoardBO2
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
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .deleteCardAndCheckResponse()
        ;
    }
}