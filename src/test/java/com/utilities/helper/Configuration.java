package com.utilities.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class Configuration {

    private static Configuration instance;
    private String environment;
    private String baseURI;
    private String sample;

    public static Configuration getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
    }

    private Configuration() {
        InputStream inputStream = null;
        try {
            inputStream = ClassLoader.getSystemResourceAsStream("config.properties");
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            Properties configProps = new Properties();
            configProps.load(reader);

            this.environment = System.getProperties().getProperty("environment");

            this.baseURI = configProps.getProperty("baseURI");
            this.sample = configProps.getProperty("sample");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String[][] stringTo2DArray(String string) {
        String[][] datas = new String[(string.split("\\|\\|")).length][(string.split("\\|\\|")[0]).split(",").length];

        for (int i = 0; i < (string.split("\\|\\|")).length; i++) {
            datas[i] = (string.split("\\|\\|")[i]).split(",");
        }

        return datas;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getBaseURI() {
        return baseURI;
    }

    public String[][] getSample(){
        return stringTo2DArray(sample);
    }
}
