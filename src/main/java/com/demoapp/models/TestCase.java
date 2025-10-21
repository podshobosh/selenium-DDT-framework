package com.demoapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TestCase {

    @JsonProperty("testId")
    private String testId;

    @JsonProperty("project")
    private String project;

    @JsonProperty("task")
    private String task;

    @JsonProperty("column")
    private String column;

    @JsonProperty("tags")
    private List<String> tags;

    //Getters and Setters


    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    //toString method

    @Override
    public String toString() {
        return "TestCase{" +
                "testId='" + testId + '\'' +
                ", project='" + project + '\'' +
                ", task='" + task + '\'' +
                ", column='" + column + '\'' +
                ", tags=" + tags +
                '}';
    }
}
