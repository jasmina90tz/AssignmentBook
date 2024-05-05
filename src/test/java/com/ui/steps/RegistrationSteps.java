package com.ui.steps;

import com.ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationSteps {
    private WebDriver driver = Driver.get(); // Get WebDriver instance

    @Given("that user visits the homepage")
    public void thatUserVisitsTheHomepage() {
        driver.get("url");
    }

    @Then("user click the login button")
    public void userClickTheLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//span [text()='Login']")); // Example XPath
        loginButton.click();
    }

    @Then("user click the register button")
    public void userClickTheRegisterButton() {
        WebElement registerButton = driver.findElement(By.xpath("//span [text()='Registration']")); // Example XPath
        registerButton.click();
    }

    @Then("user should be redirected to the registration page")
    public void userShouldBeRedirectedToTheRegistrationPage() {
        String expectedUrl = "urlRegister";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not redirected to the registration page", actualUrl.contains(expectedUrl));
    }

    @Then("user fill the form {string}, {string}, {string}, {string}")
    public void userFillTheForm(String firstName, String lastName, String pass, String confirmPass) {
        // Locate and fill the registration form fields
        WebElement firstNameField = driver.findElement(By.xpath("//form/mat-form-field[1]/div[1]")); // Example ID
        firstNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.id("last-name")); // Example ID
        lastNameField.sendKeys(lastName);

        WebElement passField = driver.findElement(By.id("password")); // Example ID
        passField.sendKeys(pass);

        WebElement confirmPassField = driver.findElement(By.id("confirm-password")); // Example ID
        confirmPassField.sendKeys(confirmPass);
    }
}
