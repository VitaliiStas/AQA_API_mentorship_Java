import org.eleks.api.trello.bo.board.BoardBO2;
import org.eleks.api.trello.listeners.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.ThreadLocalRandom;


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
    public void softAssert() {
        SoftAssert softAssert = new SoftAssert();
        int num = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        System.out.println(num);
        softAssert.assertEquals(false, false, "soft assert1");
        softAssert.assertEquals(num % 2, 0, "soft assert2");
        softAssert.assertEquals(num % 2, 0, "soft assert3");
        softAssert.assertEquals(false, false, "soft assert1");

        softAssert.assertAll();
    }

    @Test
    public void softAssert2() {
        SoftAssert softAssert = new SoftAssert();
        int num = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        System.out.println(num);
        softAssert.assertEquals(num % 2, 0, "soft assert22");
        softAssert.assertEquals(num % 2, 0, "soft assert23");
        softAssert.assertEquals(true, true, "soft assert21");

        softAssert.assertAll();
    }


}
