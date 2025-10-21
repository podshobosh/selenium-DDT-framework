package com.demoapp.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    // Step 1: Private static WebDriver (Singleton pattern)
    private static WebDriver driver;

    // Step 2: Method to initialize driver
    public static void initializeDriver(String browser, boolean headless) {

        if (driver == null) { // only create of doesn't exist
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless) {
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--disable-gpu");
                        chromeOptions.addArguments("--window-size=1920,1080");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) {
                        firefoxOptions.addArguments("--headless");
                        firefoxOptions.addArguments("--width=1920");
                        firefoxOptions.addArguments("--height=1080");
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (headless) {
                        edgeOptions.addArguments("--headless");
                        edgeOptions.addArguments("--disable-gpu");
                        edgeOptions.addArguments("--window-size=1920,1080");
                    }
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }

            if (!headless){
                driver.manage().window().maximize();
            }


        }
    }

    // Step 3: Method to get driver (returns existing or creates new)
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized: Call initializeDriver() first.");
        }
        return driver;
    }

    // Step 4: Method to quit driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
