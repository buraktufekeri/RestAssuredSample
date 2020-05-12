package com.ResponseJSonToDTO;

import com.google.gson.Gson;
import io.restassured.response.Response;

public class ResponseJSonToDTO {

    public <T> T responseBodyJSonToDTO(Response response, Class<T> classOfT) {
        Gson gson = new Gson();
        String jsonResponse = response.jsonPath().prettify();

        return gson.fromJson(jsonResponse, classOfT);
    }
}
