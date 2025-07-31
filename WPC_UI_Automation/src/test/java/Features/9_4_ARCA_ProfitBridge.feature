@ARCA_ProfitBridge
Feature: Land on the Profit Bridge screen where the user should be able to view the Pricing and Profit Bridge chart for the created customer - commodity code combination
         and create a scenario simulation
         
 #View the Pricing and Profit Bridge chart
 Scenario: Verify whether the user is able to view the Pricing and Profit Bridge chart for the selected Customer - Commodity code combination and create a scenario simulation
  Given the user is on the Profit Bridge screen
  Then the user clicks on the Filters and perform actions such as Apply, Reset and Cancel on the available options
  And the user clicks on the camera icon above the Profit Bridge chart to download the chart
  When the user clicks on the Back button then it should get redirected to the Customer Selection screen where the Select One Customer for Simulation table is present 
  Then the user clicks on the Go to Simulator button which should redirect to the Create Scenario screen for scenario creation
   
   Scenario: Verify whether the user is able to view the Pricing and Profit Bridge chart for the selected Customer - Commodity code combination and create a scenario simulation
  Given the user is on the Profit Bridge screen
  Then the user clicks on the Filters and perform actions such as Apply, Reset and Cancel on the available options
  And the user clicks on the camera icon above the Profit Bridge chart to download the chart
  When the user clicks on the Back button then it should get redirected to the Customer Selection screen where the Select One Customer for Simulation table is present 
  Then the user clicks on the Go to Simulator button which should redirect to the Create Scenario screen for scenario creation
    