package com.test.ReqresApi.PostMethod;

import com.pojo.response.ReqresApi.ApiSetlist.ApiSetlistResponseDTO;
import com.RequestMethods.RequestMethods;
import com.FillRequestBody.PostMethod.ReqresApi.ApiSetlist.FillRequestBodyApiSetlist;
import com.ResponseJSonToDTO.ResponseJSonToDTO;
import com.utilities.base.BaseTest;
import com.utilities.helper.RerunFailedTestCases;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApiSetlistTest extends BaseTest {

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
    public void apiSetlistTest(String param, String param2){
        RequestMethods requestMethods = new RequestMethods(configurationGet.getReqresApiBaseURI());
        FillRequestBodyApiSetlist fillRequestBodyApiSetlist = new FillRequestBodyApiSetlist();
        ResponseJSonToDTO responseJSonToDTO = new ResponseJSonToDTO();

        Response response = requestMethods.postMethod("/api/setlist", fillRequestBodyApiSetlist.fillRequestBody());
        ApiSetlistResponseDTO apiSetlistResponseDTO = responseJSonToDTO.responseBodyJSonToDTO(response, ApiSetlistResponseDTO.class);

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(apiSetlistResponseDTO.getTotal().toString(), "300000000");
        Assert.assertEquals(apiSetlistResponseDTO.getData().get(0).getName(), "fghfdasfghgfdsfg");
        Assert.assertNotNull(apiSetlistResponseDTO.getId());
        Assert.assertNotNull(apiSetlistResponseDTO.getCreatedAt());
    }
}
