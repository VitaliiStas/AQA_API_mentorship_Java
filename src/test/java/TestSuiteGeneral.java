import org.eleks.api.trello.bo.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class TestSuiteGeneral extends BaseTest {



    @Test
    public void updateBoardTestBO2() {
        BoardBO2
                .createBoardBO2()
                .updateBoardAndCheckResponseBO2()
                ;
    }

    @Test
    public void getBoardByIdTestBO2() {
        BoardBO2
                .createBoardBO2()
                .getBoardByIdAndCheckResponseBO2()
        ;
    }

    @Test
    public void createLabelOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .createLabelOnBoardAndCheckResponseBO2()
        ;
    }

    @Test
    public void createListOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initBoardBO()
        ;
    }
    @Test
    public void updateListOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
//                todo use initListBO
                .initListBO()
                .createListAndCheckResponseBO()
                .updateListAndCheckResponseBO()
                .initBoardBO()
        ;
    }
    @Test
    public void closeListOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .updateListAndCheckResponseBO()
                .closeListAndCheckResponseBO()
                .initBoardBO()
        ;
    }

    @Test
    public void createNewCardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .initListBO()
                .closeListAndCheckResponseBO()
                .initBoardBO()
        ;
    }

    @Test
    public void moveCardBetweenListsAndCheckTestBO2() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initCardBO()
                .createCardAndCheckResponse()
                .moveCardToBetweenListsAndCheck()
        ;
    }

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


}
