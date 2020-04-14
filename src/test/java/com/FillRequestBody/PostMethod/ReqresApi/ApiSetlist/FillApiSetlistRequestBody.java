package com.FillRequestBody.PostMethod.ReqresApi.ApiSetlist;

import com.google.gson.Gson;
import com.pojo.request.ReqresApi.ApiSetllist.ApiSetlistRequestDTO;
import com.pojo.request.ReqresApi.ApiSetllist.Datum;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FillApiSetlistRequestBody {

    public String fillApiSetlistRequestBody(){
        //Response response = getApi();
        //String result = response.jsonPath().prettify();

        FileReader reader = null;
        try {
            reader = new FileReader("src/test/resources/RequestBody/ReqresApi_ApiSetlist/ApiSetlistRequestBody.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        ApiSetlistRequestDTO apiSetlistRequestDTO = gson.fromJson(reader, ApiSetlistRequestDTO.class);

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

        System.out.println("Manipule Edilen Data:" + gson.toJson(apiSetlistRequestDTO));

        return gson.toJson(apiSetlistRequestDTO);
    }
}
