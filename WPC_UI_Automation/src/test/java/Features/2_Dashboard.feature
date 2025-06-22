@Dashboard
Feature: Land on the dashboard screen after login and perform actions on cards, top navigation bar and side navigation bar
  
  @cards
  Scenario: Verify whether the user is able to land on the dashboard screen and perform actions on cards and top bar using cards
    Given user is on the dashboard screen
    Then user shoud be able to click on the profile icon and view all the options
    When user clicks on the Customer Peer Analysis card the user must redirected and return to dashboard screen
    And user should be able to click on Auto Root Cause Analysis card and come back to dashboard screen
    Then user stays on the dashboard screen
  
  @sidenavbar
  Scenario: Verify whether the user is able to land on the dashboard screen and perform actions on cards and top bar using side navigation bar
    Given user is on the dashboard screen
    When user clicks on the Customer Peer Analysis option then user must get redirected and hover on the options 
    When user clicks on Auto Root Cause Analysis option then user must get redirected and hover on the options
    Then user stays on the dashboard screen
    

