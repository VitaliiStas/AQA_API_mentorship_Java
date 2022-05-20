import org.eleks.api.trello.bo.board.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class BoardTests extends BaseTest {

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

}
