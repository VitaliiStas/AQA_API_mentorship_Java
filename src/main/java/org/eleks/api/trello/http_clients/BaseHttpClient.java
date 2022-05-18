package org.eleks.api.trello.http_clients;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public abstract class BaseHttpClient {
    private static final String BASEURL = "https://api.trello.com/1";
    private static final String APIKEY = "9d44432a6247b3a2c1e1288fc23a1865";
    private static final String TOKEN = "cf82f9f78e5e09f4ae0dcdaa86cd8341c449c7227157b379f083031a5ce2db15";

    protected static RequestSpecification createRequestSpecification() {
        return given()
                .baseUri(BASEURL)
                .contentType(ContentType.JSON)
                .queryParam("key", APIKEY)
                .queryParam("token", TOKEN);

    }
//This function use generics for using diff pojo(response) classes.
// Also after CRUD type added response logs
    protected <T> T parsResponse(Response response, Class<T> classType){
        return   response
                .then()
                .log()
                .all()
                .extract()
                .as(classType);
    }


}