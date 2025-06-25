@Home
Feature: Land on the Home screen after login and perform actions on the cards, top bar and the side navigation bar
  
  #Cards
  Scenario: Verify that user lands on the Home screen and interacts with the top bar and the cards
    Given the user is on the Home screen
    Then the user shoud be able to click on the profile icon and view all the available options
    When the user clicks on the Customer Peer Analysis card then the user should be redirected to the Overview screen and return to the Home screen
    And the user should be able to click on the Auto Root Cause Analysis card then the user should be redirected to the Overview screen and return to the Home screen
    Then the user should remain on the Home screen
  
  #Side Navigation Bar
  Scenario: Verify that the user land on the Home screen and interacts with the side navigation bar
    Given the user is on the Home screen
    When the user clicks on the Customer Peer Analysis option from side navigation bar then user must get redirected to the Overview screen and be able to hover on the available options 
    When the user clicks on the Auto Root Cause Analysis option from side navigation bar then user must get redirected to the Overview screen and be able to hover on the available options 
    Then the user should remain on the Home screen
    

