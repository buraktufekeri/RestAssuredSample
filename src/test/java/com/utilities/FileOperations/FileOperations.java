package com.utilities.FileOperations;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {

    public FileReader fileReader(String filePath) {
        try {
            return new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject fileToJSONObject(FileReader fileReader) {
        try {
            JSONParser jsonParser = new JSONParser();
            return (JSONObject) jsonParser.parse(fileReader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
