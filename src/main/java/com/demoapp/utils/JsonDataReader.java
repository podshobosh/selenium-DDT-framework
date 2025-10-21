package com.demoapp.utils;

import com.demoapp.models.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonDataReader {

    // responsible for conversion of JSON --> JAVA
    private ObjectMapper objectMapper = new ObjectMapper();

    public JsonDataReader(){}


    // read JSON and return TestData object
    public TestData readTestData() throws IOException {
        String filePath = "testdata/testData.json";

        //Get files as inputStream
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

        //USe ObjectMapper to convert JSON -> Java
        TestData testData = objectMapper.readValue(inputStream, TestData.class);

        //return TestData object
        return testData;
    }

}
