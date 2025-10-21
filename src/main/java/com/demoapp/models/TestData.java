package com.demoapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TestData {
    @JsonProperty("loginCredentials")
    private LoginCredentials loginCredentials;

    @JsonProperty("testCases")
    private List<TestCase> testCases;



    //Getters and Setters
    public LoginCredentials getLoginCredentials() {
        return loginCredentials;
    }

    public void setLoginCredentials(LoginCredentials loginCredentials) {
        this.loginCredentials = loginCredentials;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCase> testCases) {
        this.testCases = testCases;
    }

    //toString


    @Override
    public String toString() {
        return "TestData{" +
                "loginCredentials=" + loginCredentials +
                ", testCases=" + testCases +
                '}';
    }
}
