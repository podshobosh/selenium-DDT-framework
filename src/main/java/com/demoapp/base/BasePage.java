package com.demoapp.base;

import com.demoapp.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    //Fields
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        int explicitWait = Integer.parseInt(ConfigReader.getProperty("explicit.wait"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }


    public void click(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();

    }

    public void type(By locator, String text) {
        waitForElementToBeVisible(locator);// waits first
        driver.findElement(locator).clear(); // clear existing text
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        waitForElementToBeVisible(locator);
        return driver.findElement(locator).getText();
    }

    /**
     *
     * without try-catch, will throw exception.
     * With try-catch, returns false
     */
    public boolean isDisplayed(By locator) {
        try {
            waitForElementToBeVisible(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false; // Element not found = not displayed
        }
    }


    //wait methods
    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }


}
