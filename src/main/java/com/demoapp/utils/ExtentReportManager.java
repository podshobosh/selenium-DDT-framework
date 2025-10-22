package com.demoapp.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    //initialized ExtentReports
    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("DDT Framework Test Results");
        sparkReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Podsho Boshkhuja");
        extent.setSystemInfo("Framework", "Selenium DDT");
        extent.setSystemInfo("Browser", "Chrome");

        return extent;
    }

    //get ExtentsReport instance
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("test-output/ExtentReport.html");
        }
        return extent;
    }

    //create test in report
    public static ExtentTest createTest(String testName, String description) {
        ExtentTest extentTest = getInstance().createTest(testName, description);
        test.set(extentTest);
        return extentTest;

    }

    // get current test from ThreadLocal
    public static ExtentTest getTest() {
        return test.get();
    }

    // Remove test from ThreadLocal (prevent memory leaks)
    public static void removeTest() {
        test.remove();
    }

    // Flush reports (write to file)
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
