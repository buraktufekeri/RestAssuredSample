package com.utilities.FileOperations;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileOperations {

    public FileReader fileReader(String filePath) {
        try {
            return new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
