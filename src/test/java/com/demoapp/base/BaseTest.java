package com.demoapp.base;

import com.demoapp.config.ConfigReader;
import com.demoapp.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Reading from config
        String browser = ConfigReader.getProperty("browser");
        String headlessStr = ConfigReader.getProperty("headless");
        String url = ConfigReader.getProperty("app.url");
        boolean headless = Boolean.parseBoolean(headlessStr);

        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicit.wait"));
        int pageLoadTimeout = Integer.parseInt(ConfigReader.getProperty("page.load.timeout"));

        //setting up driver
        DriverManager.initializeDriver(browser, headless);
        driver = DriverManager.getDriver();

        //set timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));

        //navigate to env
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }


}
