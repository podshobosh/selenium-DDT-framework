package com.demoapp.pages;

import com.demoapp.base.BasePage;
import com.demoapp.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Step 1: Private By locators (store the locators)
    private By emailInputField = By.id("username");
    private By passwordInputField = By.id("password");
    private By signInButton = By.xpath("//button[@type='submit']");





    // Step 2: Constructor (pass driver to BasePage)
    public LoginPage(WebDriver driver){
        super(driver); // calls super to pass the driver to basePage
    }


    // Step 3: Action method (login functionality)
    public void login(String email, String password){
        type(emailInputField, email);
        type(passwordInputField, password);
        click(signInButton);
    }

}
