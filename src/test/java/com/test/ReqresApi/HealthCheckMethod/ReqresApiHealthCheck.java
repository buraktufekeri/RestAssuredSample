package com.test.ReqresApi.HealthCheckMethod;

import com.ApiRequestMethod.BaseRequestMethod;
import com.utilities.base.BaseTest;
import com.utilities.helper.RerunFailedTestCases;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresApiHealthCheck extends BaseTest {

    @Test(priority = 1, retryAnalyzer = RerunFailedTestCases.class)
    public void apiUnknownHealthCheck(){
        BaseRequestMethod baseRequestMethod = new BaseRequestMethod(configurationGet.getBaseURI());
        Response response = baseRequestMethod.getMethod("/api/unknown");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, retryAnalyzer = RerunFailedTestCases.class)
    public void apiSetlistHealthCheck(){
        BaseRequestMethod baseRequestMethod = new BaseRequestMethod(configurationGet.getBaseURI());
        Response response = baseRequestMethod.postMethod("/api/setlist", "");

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
