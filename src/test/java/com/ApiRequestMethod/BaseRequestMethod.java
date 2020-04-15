package com.ApiRequestMethod;

import com.utilities.helper.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class BaseRequestMethod {

    private static final Configuration configurationGet = Configuration.getInstance();
    protected static final Logger logger = Logger.getLogger(BaseRequestMethod.class);
    private String baseURI;

    public BaseRequestMethod() {
    }

    public BaseRequestMethod(String baseURI) {
        this.baseURI = baseURI;
    }

    public Response getMethod(String path) {
        RestAssured.baseURI = baseURI;
        logger.info("The Get Method Called. Path:" + path);

        return given()
                .contentType("application/json")
                .when()
                .get(path)
                .then()
                .extract().response().prettyPeek();
    }

    public Response postMethod(String path, String requestBody) {
        RestAssured.baseURI = baseURI;
        logger.info("The Post Method Called. Path:" + path);
        logger.info("The Post Method Called. RequestBody:" + requestBody);

        return given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(path)
                .then()
                .extract().response().prettyPeek();
    }
}
