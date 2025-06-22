@Login
Feature: Login to WPC - USESI application
	@validlogin
  Scenario: Verify user logs in to the WPC - USESI application with valid credentials
    Given user is on the login page
    When user enters the credentials
    And user click on the Login button
    Then user lands on the homescreen

  @invalidlogin
  Scenario: Verify user login fails to the WPC - USESI application with invalid credentials
    Given user is on the login page
    When user enters invalid credentials
    And user click on the Login button
    Then user should remain on the login page
    And an error message should be displayed