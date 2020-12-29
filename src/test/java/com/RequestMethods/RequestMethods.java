package com.RequestMethods;

import com.utilities.FileOperations.FileOperations;
import com.utilities.helper.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class RequestMethods {

    protected static final Configuration configurationGet = Configuration.getInstance();
    protected static final Logger logger = Logger.getLogger(RequestMethods.class);
    protected static final FileOperations fileOperations = new FileOperations();
    private String baseURI;

    public RequestMethods() {
    }

    public RequestMethods(String baseURI) {
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

    public Response postMethod(String path) {
        RestAssured.baseURI = baseURI;
        logger.info("The Post Method Called. Path:" + path);
        logger.info("The Post Method Called. RequestBody is none.");

        return given()
                .contentType("application/json")
                .when()
                .post(path)
                .then()
                .extract().response().prettyPeek();
    }

    public Response postMethod(String path, JSONObject requestBody) {
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
