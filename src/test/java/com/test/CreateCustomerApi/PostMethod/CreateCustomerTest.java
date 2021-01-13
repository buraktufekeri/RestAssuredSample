package com.test.CreateCustomerApi.PostMethod;

import com.RequestMethods.RequestMethods;
import com.ResponseJSonToDTO.ResponseJSonToDTO;
import com.pojo.response.CreateCustomerApi.CreateCustomerResponseDTO;
import com.utilities.FileOperations.FileOperations;
import com.utilities.base.BaseTest;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateCustomerTest extends BaseTest {

    @DataProvider(name = "configParam")
    public static Object[][] loginData() {
        Object[][] configDatas = new Object[configurationGet
                .getSample().length][configurationGet.getSample()[0].length];
        for (int i = 0; i < configurationGet.getSample().length; i++) {
            configDatas[i] = configurationGet.getSample()[i];
        }
        return configDatas;
    }

    @Test(priority = 1, dataProvider = "configParam")
    public void createCustomerTest(String param, String param2){
        FileOperations fileOperations = new FileOperations();
        RequestMethods requestMethods = new RequestMethods("http://customer.tkb-int-copy.dev2.rally.softtech");
        ResponseJSonToDTO responseJSonToDTO = new ResponseJSonToDTO();

        Header h1 = new Header("x-rly-corr", "1");
        Header h2 = new Header("x-rly-ins-unit", "1");
        Header h3 = new Header("x-rly-session", "1");
        Header h4 = new Header("x-rly-tenant", "1");
        Header h5 = new Header("x-rly-user-id", "1");
        List<Header> headerList = new ArrayList<>();
        headerList.add(h1);
        headerList.add(h2);
        headerList.add(h3);
        headerList.add(h4);
        headerList.add(h5);

        Headers headers = new Headers(headerList);

        Response response = requestMethods.postMethod("/api/party/organisations/",
                                                      fileOperations.fileToJSONObject(
                                                      fileOperations.bufferedReader("src/test/resources/RequestBody/CreateCustomerApi/CreateCustomerPostRequestBody.json")), headers);
        CreateCustomerResponseDTO createCustomerResponseDTO = responseJSonToDTO.responseBodyJSonToDTO(response, CreateCustomerResponseDTO.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("id:" + createCustomerResponseDTO.getId());
        System.out.println("timestamp:" + createCustomerResponseDTO.getTimestamp());
        System.out.println("success:" + createCustomerResponseDTO.getSuccess());
        System.out.println("correlationId:" + createCustomerResponseDTO.getCorrelationId());
        System.out.println("entityId:" + createCustomerResponseDTO.getEntityId());
    }
}
