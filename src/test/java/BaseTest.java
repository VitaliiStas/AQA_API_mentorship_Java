
import org.eleks.api.trello.bo.BoardBO;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(LogListener.class)
public class BaseTest {


    @Test
    public void checkBoardNameTest(){
        BoardBO.boardNameCheck();
    }
    @Test
    public void createBoardTest(){
        BoardBO.createBoardAndCheckName();
    }
}
