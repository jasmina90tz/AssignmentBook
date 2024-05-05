package com.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTestAutomation {

    public static void main(String[] args) {
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // UI Test: User Login
        driver.get("https://bookcart.azurewebsites.net/login");
        // Fill the login form
        WebElement usernameInput = driver.findElement(By.id("mat-input-0"));
        WebElement passwordInput = driver.findElement(By.id("mat-input-1"));

        usernameInput.sendKeys("jastest");
        passwordInput.sendKeys("Test1234");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//form/mat-card-actions/button"));
        loginButton.click();

        // Wait for the login process to complete (adjust the timeout as needed)
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // UI Test: Positive User Registration
        driver.get("https://bookcart.azurewebsites.net/register");

        // Fill the form using JavaScript
        WebElement firstnameInput = driver.findElement(By.id("mat-input-0"));
        WebElement lastnameInput = driver.findElement(By.id("mat-input-1"));
        WebElement userNameInput = driver.findElement(By.id("mat-input-2"));
        WebElement passInput = driver.findElement(By.id("mat-input-3"));
        WebElement confirmPassInput = driver.findElement(By.id("mat-input-4"));

        firstnameInput.sendKeys("Emir");
        lastnameInput.sendKeys("Santi");
        userNameInput.sendKeys("Santi123");
        passInput.sendKeys("Test5555");
        confirmPassInput.sendKeys("Test5555");

        // Click on the "Male" radio button
        js.executeScript("document.querySelector('input[value=\"Male\"]').click();");

        // Click on the register button
        WebElement registerButton = driver.findElement(By.xpath("//mat-card-content/form/mat-card-actions/button"));
        registerButton.click();

        // Wait for the form submission to complete (adjust the timeout as needed)
        try {
            Thread.sleep(5000); // Wait for 5 seconds
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}


