package com.FillRequestBody.PostMethod.ReqresApi.ApiSetlist;

import com.RequestMethods.RequestMethods;
import com.google.gson.Gson;
import com.pojo.request.ReqresApi.ApiSetllist.ApiSetlistRequestDTO;
import com.pojo.request.ReqresApi.ApiSetllist.Datum;

import java.util.List;

public class FillRequestBodyApiSetlist extends RequestMethods {

    public FillRequestBodyApiSetlist() {
    }

    public FillRequestBodyApiSetlist(String baseURI) {
        super(baseURI);
    }

    public String fillRequestBody(){
        //Response response = getApi();
        //String result = response.jsonPath().prettify();

        Gson gson = new Gson();
        ApiSetlistRequestDTO apiSetlistRequestDTO = gson.fromJson(fileOperations.bufferedReader(configurationGet.getApiSetlistRequestJSonBodyResourcePath()), ApiSetlistRequestDTO.class);

        apiSetlistRequestDTO.setPage(30303030);
        apiSetlistRequestDTO.setPerPage(8888888);
        apiSetlistRequestDTO.setTotal(300000000);
        apiSetlistRequestDTO.setTotalPages(88888888);

        Datum data = new Datum();
        data.setId(10);
        data.setName("fghfdasfghgfdsfg");
        data.setYear(453453);
        data.setColor("#f43242");
        data.setPantoneValue("Test dfgfdgfdg Value");

        Datum data2 = new Datum();
        data2.setId(15);
        data2.setName("burak");
        data2.setYear(19);
        data2.setColor("#tyuyrefe");
        data2.setPantoneValue("fsd");

        List<Datum> datumList = apiSetlistRequestDTO.getData();
        datumList.set(0,data);
        datumList.set(5,data2);

        apiSetlistRequestDTO.setData(datumList);

        /*for (Datum data : exampleTestClass.getData()){
            data.setId(10);
            data.setName("Sarı");
            data.setYear(5000);
            data.setColor("#999999999");
            data.setPantoneValue("Test Pandone Value");
        }*/

        logger.info("Manipule Edilen Data:" + gson.toJson(apiSetlistRequestDTO));

        return gson.toJson(apiSetlistRequestDTO);
    }
}
