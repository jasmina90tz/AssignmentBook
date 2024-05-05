package com.ui.steps;

import com.ui.pages.HomePage;
import com.ui.pages.RegisterPage;
import com.ui.utilities.ConfigurationReader;
import com.ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Given("that I visit the homepage")
    public void thatIVisitTheHomepage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("I navigate to the login button")
    public void iNavigateToTheLoginButton() {
        homePage.LoginButton.click();
    }
}
