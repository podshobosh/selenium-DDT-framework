package com.demoapp.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties; //Holds all config data

    //Load the config file (called once)
    public static void loadConfig() {
        try {
            properties = new Properties();
            InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");

            if (inputStream == null){
                throw new RuntimeException("config.properties file not found in resources!");
            }

            properties.load(inputStream);
            inputStream.close();

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }


    //get Property value
    public static String getProperty(String key){
        if (properties == null){
            loadConfig();
        }
        return properties.getProperty(key);
    }


}
