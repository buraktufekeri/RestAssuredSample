package com.utilities.FileOperations;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileOperations {

    public BufferedReader bufferedReader(String filePath) {
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject fileToJSONObject(BufferedReader bufferedReader) {
        try {
            JSONParser jsonParser = new JSONParser();
            return (JSONObject) jsonParser.parse(bufferedReader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
