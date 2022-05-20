import org.eleks.api.trello.bo.BoTestPreconditions;
import org.eleks.api.trello.bo.board.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class ListTest extends BaseTest {
    @Test
    public void createLabelOnBoardAndCheckResponseTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .createLabelOnBoardAndCheckResponseBO2()
        ;
    }

    @Test
    public void createListOnBoardAndCheckResponseTestBO2() {
        new BoTestPreconditions().
        createListPreconditions()
        ;
    }
    @Test
    public void updateListOnBoardAndCheckResponseTestBO2() {
        new BoTestPreconditions().
                createListPreconditions()

                .updateListAndCheckResponseBO()
        ;
    }
    @Test
    public void closeListOnBoardAndCheckResponseTestBO2() {
        new BoTestPreconditions().
                createListPreconditions()

                .closeListAndCheckResponseBO()
        ;
    }
}
