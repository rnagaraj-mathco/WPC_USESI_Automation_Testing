@CustomerPeerAnalysis_ViewScenarioImpact
Feature: Land on the View Scenario Impact Screen where the user should be able to view the Important Metric values and the scenario chart


 #View Scenario Impact
  Scenario: Verify that the user can view the impact of the created scenario and compare it with the default scenario
   Given the user is on the View Scenario Impact screen
   Then the user should be able to open the Filters and select a previously created customer + saved scenario name, which should then load on the screen 
   When the user clicks on the After button, the chart should update with the new simulated values
   And the user clicks on the Comparison button, which should display the table showing differences between the default and simulated scenario values
   And the user should be able to search for a keyword in the Comparison table
   And the user should be able to click the download icon in the Comparison table header to download the table records as an Excel file
   And the user should be able to zoom in and out of the Comparison table using the + and - icons
   Then the user should be able to click on the column filter icon to select which columns should be displayed in the Comparison table
   When the user clicks on the Back button, the chart should update with the default simulated values
   Then the user should be able to click on the Back button which then redirects the user to the Create Scenario screen
   And the user should be able to click on the Reset button which then redirects the the user to the Branch/Customer Selection screen 
   
# Ask Ranjith about the chart name, validating the KPI values and Chart Values. Or WHat all the possible 
# validation can be done in this screen (Name we can validate)
