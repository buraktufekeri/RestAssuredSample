package com.test.ReqresApi.PostMethod;

import com.pojo.response.ReqresApi.ApiSetlist.ApiSetlistResponseDTO;
import com.ApiRequestMethod.BaseRequestMethod;
import com.FillRequestBody.PostMethod.ReqresApi.ApiSetlist.FillApiSetlistRequestBody;
import com.ApiResponse.BaseApiResponseConvertToDTO;
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
        BaseRequestMethod baseRequestMethod = new BaseRequestMethod(configurationGet.getBaseURI());
        FillApiSetlistRequestBody fillApiSetlistRequestBody = new FillApiSetlistRequestBody();
        BaseApiResponseConvertToDTO baseApiResponseConvertToDTO = new BaseApiResponseConvertToDTO();

        Response response = baseRequestMethod.postMethod("/api/setlist", fillApiSetlistRequestBody.fillApiSetlistRequestBody());
        ApiSetlistResponseDTO apiSetlistResponseDTO = baseApiResponseConvertToDTO.apiResponseConvertToDTO(response, ApiSetlistResponseDTO.class);

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(apiSetlistResponseDTO.getTotal().toString(), "300000000");
        Assert.assertEquals(apiSetlistResponseDTO.getData().get(0).getName(), "fghfdasfghgfdsfg");
        Assert.assertNotNull(apiSetlistResponseDTO.getId());
        Assert.assertNotNull(apiSetlistResponseDTO.getCreatedAt());
    }
}
