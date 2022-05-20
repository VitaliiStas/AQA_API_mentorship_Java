import io.qameta.allure.Step;
import org.eleks.api.trello.bo.board.BoardBO2;
import org.eleks.api.trello.http_clients.BoardHttpClient;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;


@Listeners(LogListener.class)
public class BaseTest{
    @AfterMethod
    @Step("Remove tested board")
    public void deleteBoard() {
       new BoardHttpClient()
               .deleteBoardRequest(new BoardBO2().getCreateBoardResponse().getId());
    }
}
