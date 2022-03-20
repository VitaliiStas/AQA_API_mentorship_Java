import org.eleks.api.trello.bo.BoardBO;
import org.eleks.api.trello.bo.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(LogListener.class)
public class BaseTest {


    @Test
    public void getBoardByIdTest() {
        BoardBO.getBoardByIdAndCheckResponseAndDelete();
    }

    //    @Test
//    public void createBoardTest(){
//        BoardBO.createBoardAndCheckName();
//    }
    @Test
    public void updateBoardTest() {
        BoardBO.updateBoardAndCheckResponseAndDelete();
    }

    @Test
    public void deleteBoardTest() {
        BoardBO.deleteBoardAndCheckResponse();
    }


    @Test
    public void deleteBoardTestBO2() {
        BoardBO2
                .createBoardBO2()
                .deleteBoardAndCheckResponseBO2();
    }

    @Test
    public void updateBoardTestBO2() {
        BoardBO2
                .createBoardBO2()
                .updateBoardAndCheckResponseBO2()
                .deleteBoardAndCheckResponseBO2();
    }

    @Test
    public void getBoardByIdTestBO2() {
        BoardBO2
                .createBoardBO2()
                .getBoardByIdAndCheckResponseBO2()
                .deleteBoardAndCheckResponseBO2();
    }

    @Test
    public void createLabelOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .createLabelOnBoardAndCheckResponseBO2()
                .deleteBoardAndCheckResponseBO2()
        ;
    }

    @Test
    public void createListOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .listBO.createListAndCheckResponseBO()
                .boardBO.deleteBoardAndCheckResponseBO2()
        ;
    }
    @Test
    public void updateListOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .listBO.createListAndCheckResponseBO()
                .updateListAndCheckResponseBO()
                .boardBO.deleteBoardAndCheckResponseBO2()
        ;
    }
    @Test
    public void closeListOnBoardAndCheckResponseTestBO2() {
        BoardBO2
                .createBoardBO2()
                .listBO.createListAndCheckResponseBO()
                .updateListAndCheckResponseBO()
                .closeListAndCheckResponseBO()
                .boardBO.deleteBoardAndCheckResponseBO2()
        ;
    }


}
