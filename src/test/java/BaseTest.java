
import org.eleks.api.trello.bo.BoardBO;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(LogListener.class)
public class BaseTest {


    @Test
    public void getBoardByIdTest(){
        BoardBO.getBoardById();
    }
    @Test
    public void createBoardTest(){
        BoardBO.createBoardAndCheckName();
    }
    @Test
    public void updateBoardTest(){
        BoardBO.updateBoard("SZxMHWd9");
    }

    @Test
    public void deleteBoardTest(){
        BoardBO.deleteBoard("X7QhOp0x");
    }
}
