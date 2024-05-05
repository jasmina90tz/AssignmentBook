package com.ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTestAutomation {

    public static void main(String[] args) {
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // UI Test: Positive User Registration
        driver.get("https://bookcart.azurewebsites.net/register");

        // Fill the form using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('mat-input-0').value = 'John';");
        js.executeScript("document.getElementById('mat-input-1').value = 'Doe';");
        js.executeScript("document.getElementById('mat-input-2').value = 'johnZee123';");
        js.executeScript("document.getElementById('mat-input-3').value = 'Password123';");
        js.executeScript("document.getElementById('mat-input-4').value = 'Password123';");

        // Click on the "Male" radio button
        js.executeScript("document.querySelector('input[value=\"Male\"]').click();");

        // Click on the register button
        js.executeScript("document.getElementByXpath('//span [text()='Register'').click();");

        // Wait for the form submission to complete (adjust the timeout as needed)
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}

