import org.eleks.api.trello.bo.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LogListener.class)
public class ListTest extends BaseTest {
    @Test
    public void createLabelOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .createLabelOnBoardAndCheckResponseBO2()
//                .deleteBoardAndCheckResponseBO2()
        ;
    }

    @Test
    public void createListOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .initListBO()
                .createListAndCheckResponseBO()
                .initBoardBO()
//                .deleteBoardAndCheckResponseBO2()
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
//                .deleteBoardAndCheckResponseBO2()
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
//                .deleteBoardAndCheckResponseBO2()
        ;
    }
}
