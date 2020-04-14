package com.ApiResponse;

import com.google.gson.Gson;
import io.restassured.response.Response;

public class BaseApiResponseConvertToDTO {

    public <T> T apiResponseConvertToDTO(Response response, Class<T> classOfT) {
        Gson gson = new Gson();
        String jsonResponse = response.jsonPath().prettify();

        return gson.fromJson(jsonResponse, classOfT);
    }
}
