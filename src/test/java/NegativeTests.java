import org.eleks.api.trello.bo.board.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.nio.file.Files;

@Listeners(LogListener.class)
public class NegativeTests {

    @Test // Negative board test
    public void createBoardWithEmptyNameTestBO2() {
        new BoardBO2()
                .createBoardWithStatusCode400()
        ;
    }

    @Test // Negative board test
    public void createBoardWithBogusUrlTestBO2() {
        new BoardBO2()
                .createBoardWithStatusCode404()
        ;
    }
    @Test // Negative board test
    public void createBoardWithInvalidAPIKEYTestBO2() {
        new BoardBO2()
                .createBoardWithStatusCode401()
        ;
    }

    @Test // Negative board test
    public void updateWithEmptyNameTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .updateBoardWithStatusCode400()
                .deleteBoardAndCheckResponseBO2()
        ;
    }

    @Test // Negative board test
    public void updateBoardWithBogusUrlTestBO2() {
        new BoardBO2()
                .createBoardBO2()
                .updateBoardWithStatusCode404()
                .deleteBoardAndCheckResponseBO2()
        ;
        Object object = new Object();
    }
    @Test
    public void defaultFailing() {
        Assert.assertEquals(1,2,"this test all time fails");
    }

}
