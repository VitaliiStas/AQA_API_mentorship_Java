package org.eleks.api.trello.http_clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.eleks.api.trello.utils.PropertyUtils;

import static io.restassured.RestAssured.given;


public abstract class BaseHttpClient {

    private static final String BASEURL = PropertyUtils.getProperty("HOST");
    //    private static final String BASEURL = "https://api.trello.com/1";
    private static final String APIKEY = "9d44432a6247b3a2c1e1288fc23a1865";
//    private static final String APIKEY = "false";
    private static final String TOKEN = "cf82f9f78e5e09f4ae0dcdaa86cd8341c449c7227157b379f083031a5ce2db15";

    private static RequestSpecification createRequest(String APIKEY, String TOKEN) {
        return given()
                .baseUri(BASEURL)
                .contentType(ContentType.JSON)
                .queryParam("key", APIKEY)
                .queryParam("token", TOKEN);
    }

    protected static RequestSpecification createRequestSpecification() {
        return createRequest(APIKEY, TOKEN);
    }

    protected static RequestSpecification createRequestWithInvalidAPIKEY() {
        return createRequest("BOGUS APIKEY", TOKEN);
    }

    protected static RequestSpecification createRequestWithInvalidTOKEN() {
        return createRequest(APIKEY, "BOGUS TOKEN");
    }

    //This function use generics for using diff pojo(response) classes.
// Also after CRUD type added response logs
    protected <T> T parsResponse(Response response, Class<T> classType) {
        return response
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(classType);
    }

    // Used for the negative tests, check status codes
    protected void parsResponseAndCheckStatusCode(Response response, int statusCode) {
        response
                .then()
                .log()
                .all()
                .statusCode(statusCode)
        ;
    }


}