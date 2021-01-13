package com.utilities.FileOperations;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class FileOperations {

    public BufferedReader bufferedReader(String filePath) {
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
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
