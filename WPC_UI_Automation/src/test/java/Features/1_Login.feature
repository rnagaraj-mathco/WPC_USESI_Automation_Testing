@Login
Feature: Login to WPC - USESI application
	#Valid Login
  Scenario: Verify user logs in to the WPC - USESI application with valid credentials
    Given the user is on the login page
    When the user enters the credentials
    And the user click on the Login button
    Then user lands on the homescreen and validate the logged-in user 

  #Invalid Login
  Scenario: Verify user login fails to the WPC - USESI application with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    And the user click on the Login button
    Then the user should remain on the login page
    And an error message should be displayed