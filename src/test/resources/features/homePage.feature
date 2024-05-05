Feature: User should be able to to register on page

  @test
  Scenario: User should be able to visit home page
    Given that user visits the homepage
    Then user click the login button
    And user should be redirected to the login page
    Then user click the register button
    And user should be redirected to the register page
    Then user fill the form
    And user click the submit button
    Then user click the login button
    And user should be successfully logged in




