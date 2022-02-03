package org.eleks.api.trello;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.testng.FileAssert;
public class BaseRequest {
    public static final String BASEURL = "https://api.trello.com/1";
    public static final String APIKEY = "9d44432a6247b3a2c1e1288fc23a1865";
    public static final String TOKEN = "eea9740497036be0be47ab7c03b5a9ed87a53993081ea6f534502d109f11d925";



    public static RequestSpecification requestSpecification = given().baseUri(BASEURL)
            .queryParam("key", APIKEY)
            .queryParam("token", TOKEN)
            .contentType(ContentType.JSON);
}
