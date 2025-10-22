package com.demoapp.listeners;


import com.aventstack.extentreports.Status;
import com.demoapp.utils.ExtentReportManager;
import com.demoapp.utils.ScreenShotsUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
        ExtentReportManager.flush();  // Write report to file
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        ExtentReportManager.createTest(testName, description);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        ExtentReportManager.removeTest();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        ExtentReportManager.getTest().fail(result.getThrowable());

        // Capture screenshot
        try {
            Object testClass = result.getInstance();
            WebDriver driver = (WebDriver) testClass.getClass().getField("driver").get(testClass);

            if (driver != null) {
                String screenshotPath = ScreenShotsUtils.captureScreenshot(driver, result.getMethod().getMethodName());
                if (screenshotPath != null) {
                    ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }

        ExtentReportManager.removeTest();
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        ExtentReportManager.removeTest();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not commonly used
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }



}
