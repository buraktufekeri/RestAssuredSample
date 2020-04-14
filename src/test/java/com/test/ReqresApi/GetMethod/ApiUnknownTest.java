package com.test.ReqresApi.GetMethod;

import com.pojo.response.ReqresApi.ApiUnknown.ApiUnknownResponseDTO;
import com.ApiRequestMethod.BaseRequestMethod;
import com.ApiResponse.BaseApiResponseConvertToDTO;
import com.utilities.base.BaseTest;
import com.utilities.helper.RerunFailedTestCases;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApiUnknownTest extends BaseTest {

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
    public void apiUnknownTest(String param, String param2){
        BaseRequestMethod baseRequestMethod = new BaseRequestMethod(configurationGet.getBaseURI());
        BaseApiResponseConvertToDTO baseApiResponseConvertToDTO = new BaseApiResponseConvertToDTO();

        Response response = baseRequestMethod.getMethod("/api/unknown");
        ApiUnknownResponseDTO apiUnknownResponseDTO = baseApiResponseConvertToDTO.apiResponseConvertToDTO(response, ApiUnknownResponseDTO.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(apiUnknownResponseDTO.getTotal().toString(), "12");
        Assert.assertEquals(apiUnknownResponseDTO.getData().get(0).getName(), "cerulean");
        Assert.assertEquals(apiUnknownResponseDTO.getAd().getCompany(), "StatusCode Weekly");
    }

    @Test(priority = 2, retryAnalyzer = RerunFailedTestCases.class, dataProvider = "configParam")
    public void apiUnknownTest2(String param, String param2){
        BaseRequestMethod baseRequestMethod = new BaseRequestMethod(configurationGet.getBaseURI());
        BaseApiResponseConvertToDTO baseApiResponseConvertToDTO = new BaseApiResponseConvertToDTO();

        Response response = baseRequestMethod.getMethod("/api/unknown");
        ApiUnknownResponseDTO apiUnknownResponseDTO = baseApiResponseConvertToDTO.apiResponseConvertToDTO(response, ApiUnknownResponseDTO.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(apiUnknownResponseDTO.getTotalPages().toString(), "2");
        Assert.assertEquals(apiUnknownResponseDTO.getData().get(1).getName(), "fuchsia rose");
        Assert.assertEquals(apiUnknownResponseDTO.getAd().getCompany(), "StatusCode Weekly");
    }
}
