package com.demoapp.tests;

import com.demoapp.base.BaseTest;
import com.demoapp.config.ConfigReader;
import com.demoapp.models.TestCase;
import com.demoapp.models.TestData;
import com.demoapp.pages.LoginPage;
import com.demoapp.pages.ProjectPage;
import com.demoapp.utils.JsonDataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class DemoAppTest extends BaseTest {

    @DataProvider(name = "testCases")
    public Object[][] getTestData() throws IOException {
        // TODO: Create JsonDataReader
        JsonDataReader dataReader = new JsonDataReader();
        // TODO: Read test data
        TestData testData = dataReader.readTestData();
        // TODO: Get list of test cases
        List<TestCase> testCases = testData.getTestCases();
        // TODO: Convert to Object[][]
        Object[][] data = new Object[testCases.size()][1];
        for (int i = 0; i < testCases.size(); i++) {
            data[i][0] = testCases.get(i);
        }
        // TODO: Return the array
        return data;
    }

    @Test(dataProvider = "testCases")
    public void verifyTaskTest(TestCase testCase) {
        LoginPage loginPage = new LoginPage(driver);
        ProjectPage projectPage = new ProjectPage(driver);

        //login using creds
        String email = ConfigReader.getProperty("login.email");
        String password = ConfigReader.getProperty("login.password");
        loginPage.login(email, password);

        //select project form testCase
        projectPage.selectProject(testCase.getProject());

        //verify task in column
        boolean taskFound = projectPage.verifyTaskInColumn(testCase.getTask(), testCase.getColumn());

        Assert.assertTrue(taskFound, "Task '" + testCase.getTask() + "' not found in column '" + testCase.getColumn() + "'");

        // verify tags
        boolean tagsMatch = projectPage.verifyTasksTags(testCase.getTask(), testCase.getTags());
        Assert.assertTrue(tagsMatch, "Tags don't match for task: " + testCase.getTask());
    }
}
