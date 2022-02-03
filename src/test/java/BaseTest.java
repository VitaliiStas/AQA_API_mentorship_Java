
import org.eleks.api.trello.BaseRequest;
import org.testng.annotations.Test;



public class BaseTest {


    @Test
    public void firstApiTest(){
       BaseRequest.requestSpecification.when().get("/boards/avlnYUa4").then().log().all().statusCode(200);
    }
}
