@AutoRootCauseAnalysis_ProfitBridge
Feature: Land on the Profit Bridge screen where the user should be able to view the Pricing and Profit Bridge chart for the created customer - commodity code combination
         and create a scenario simulation
         
 #View the Pricing and Profit Bridge chart
 Scenario: Verify whether the user is able to view the Pricing and Profit Bridge chart for the selected Customer - Commodity code combination and create a scenario simulation
  Given the user is on the Profit Bridge screen
  When the user clicks on the Filters button it displays the Selected Customer Metric and Customer and Product(s) combination options
  Then the user should be able to click on the Filter - Selected Customer Metric option and select the required Cost Metic value
  Then the user should be able to click on the Filter - Customer and Product(s) combination option and select the required Combination
  And the user should be able to click on the Filter - Apply button which updates the chart as per the changed selections
  When the user clicks on the Filter - Reset button then the option selection should be revereted back to its previous state
  When the user clicks on the Filter - Cancel button then the options should disappear and there should not be any changes in both charts
  And the user clicks on the camera icon present above the Profit Bridge chart then the chart should be downloaded
  When the user clicks on the Back then it should get redirected to the Customer Selection screen where the Select Root Cause Product for Simulation table is present 
  Then the user clicks on the Go to Simulator button which should redirect the user to the Create Scenario screen for scenario creation
  