package com.demoapp.pages;

import com.demoapp.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProjectPage extends BasePage {


    // Step 1: Private By locators (store the locators)
    private By projectsButtons = By.xpath("//nav[@class='flex-1 overflow-y-auto']/button");


    public ProjectPage(WebDriver driver) {
        super(driver); // calls super to pass the driver to basePage
    }


    // Step 3: Action method ()
    public void selectProject(String projectName) {
        List<WebElement> projects = driver.findElements(projectsButtons);
        for (WebElement project : projects) {
            if (project.getText().contains(projectName)) {
                project.click();
                break;

            }
        }
    }


    public boolean verifyTaskInColumn(String taskName, String columnName) {
        try {

            //build xpath dynamically based on parameters
            String xPath = String.format("//h2[contains(text(),'%s')]/following-sibling::div//h3[text()='%s']", columnName, taskName); // <-- passed in method when called

            WebElement task = driver.findElement(By.xpath(xPath));
            return task.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyTasksTags(String taskName, List<String> expectedTags) {
        try {

            // Find all tags for this specific task
            String xpath = String.format(
                    "//h3[text()='%s']/following-sibling::div//span",
                    taskName
            );

            List<WebElement> tagElements = driver.findElements(By.xpath(xpath));

            System.out.println("Found " + tagElements.size() + " tag elements");  // DEBUG


            //Extract text from elements
            List<String> actualTags = new ArrayList<>();
            for (WebElement tag : tagElements) {
                String tagText = tag.getText();
                System.out.println("Tag found: " + tagText);
                actualTags.add(tag.getText());
            }

            System.out.println("Expected tags: " + expectedTags);  // DEBUG
            System.out.println("Actual tags: " + actualTags);  // DEBUG

            //verify all expected tags are present
            return actualTags.containsAll(expectedTags);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());  // DEBUG

            return false;
        }


    }
}
