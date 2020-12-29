package com.test.ReqresApi.HealthCheckMethod;

import com.RequestMethods.RequestMethods;
import com.utilities.base.BaseTest;
import com.utilities.helper.RerunFailedTestCases;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresApiHealthCheck extends BaseTest {

    @Test(priority = 1, retryAnalyzer = RerunFailedTestCases.class)
    public void apiUnknownHealthCheck(){
        RequestMethods requestMethods = new RequestMethods(configurationGet.getReqresApiBaseURI());
        Response response = requestMethods.getMethod("/api/unknown");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, retryAnalyzer = RerunFailedTestCases.class)
    public void apiSetlistHealthCheck(){
        RequestMethods requestMethods = new RequestMethods(configurationGet.getReqresApiBaseURI());
        Response response = requestMethods.postMethod("/api/setlist");

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
