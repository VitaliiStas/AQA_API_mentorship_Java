import org.eleks.api.trello.bo.BoTestPreconditions;
import org.eleks.api.trello.bo.board.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class TestSuiteGeneral extends BaseTest {



    @Test
    public void updateBoardTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .updateBoardAndCheckResponseBO2()
                ;
    }

    @Test
    public void getBoardByIdTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .getBoardByIdAndCheckResponseBO2()
        ;
    }

    @Test
    public void createLabelOnBoardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .createLabelOnBoardAndCheckResponseBO2()
        ;
    }

    @Test
    public void createListOnBoardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initBoardBO()
        ;
    }
    @Test
    public void updateListOnBoardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .updateListAndCheckResponseBO()
                .initBoardBO()
        ;
    }
    @Test
    public void closeListOnBoardAndCheckResponseTestBO2() {
        new BoTestPreconditions()
                .createListPreconditions()

                .closeListAndCheckResponseBO()
        ;
    }

    @Test
    public void createNewCardAndCheckResponseTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()
        ;
    }

    @Test
    public void moveCardBetweenListsAndCheckTestBO2() {
        new BoTestPreconditions()
                .createCardPreconditions()

                .moveCardToBetweenListsAndCheck()
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
