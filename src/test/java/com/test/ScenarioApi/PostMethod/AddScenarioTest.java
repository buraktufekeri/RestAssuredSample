package com.test.ScenarioApi.PostMethod;

import com.RequestMethods.RequestMethods;
import com.ResponseJSonToDTO.ResponseJSonToDTO;
import com.pojo.response.ScenarioApi.AddScenario.AddScenarioResponseDTO;
import com.utilities.FileOperations.FileOperations;
import com.utilities.base.BaseTest;
import com.utilities.helper.RerunFailedTestCases;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddScenarioTest extends BaseTest {

    @DataProvider(name = "configParam")
    public static Object[][] loginData() {
        Object[][] configDatas = new Object[configurationGet
                .getSample().length][configurationGet.getSample()[0].length];
        for (int i = 0; i < configurationGet.getSample().length; i++) {
            configDatas[i] = configurationGet.getSample()[i];
        }
        return configDatas;
    }

    @Test(priority = 1, retryAnalyzer = RerunFailedTestCases.class, dataProvider = "configParam")
    public void addScenarioTest(String param, String param2){
        FileOperations fileOperations = new FileOperations();
        RequestMethods requestMethods = new RequestMethods(configurationGet.getScenarioApiBaseURI());
        ResponseJSonToDTO responseJSonToDTO = new ResponseJSonToDTO();

        Response response = requestMethods.postMethod("/api/v1/scenario/addScenario",
                                                      fileOperations.fileToJSONObject(
                                                      fileOperations.bufferedReader(configurationGet.getApiAddScenarioPostRequestBodyJSonResourcePath())),
                                                      "admin", "admin123456");
        AddScenarioResponseDTO addScenarioResponseDTO = responseJSonToDTO.responseBodyJSonToDTO(response, AddScenarioResponseDTO.class);

        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("softwareSpecialist:" + addScenarioResponseDTO.getSoftwareSpecialist());
        System.out.println("testSpecialist:" + addScenarioResponseDTO.getTestSpecialist());
    }
}
