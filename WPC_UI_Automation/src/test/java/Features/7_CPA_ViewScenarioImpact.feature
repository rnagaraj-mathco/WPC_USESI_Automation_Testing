#@CPA_ViewScenarioImpact
Feature: Land on the View Scenario Impact Screen where the user should be able to view the Important Metric values and the scenario chart


 #View Scenario Impact
 Scenario: Verify that the user can view the impact of the created scenario and compare it with the default scenario
   Given the user is on the View Scenario Impact screen
   Then the user should be able to click on the Back button, which then redirects to the Create Scenario screen
   Then the user should be able to click on the Filters and perform actions such as Apply, Reset and Cancel based on requirements 
   When the user clicks on the After button,the chart is displayed shoul be displayed with simulated values
   And the user clicks on the Comparison button, which should display a table showing the differences between the default and simulated scenario values
   And the user should be able to search for a keyword in the Comparison table
   And the user should be able to click the download icon in the Comparison table header to download the table records as an Excel file
   And the user should be able to zoom in and out of the Comparison table using the + and - icons
   Then the user should be able to click the column filter icon to select which columns should be displayed in the Comparison table
   When the user clicks the Back button, the chart should update with the default scenario values
   And the user should be able to click on the Reset button, which redirects the the user to the Branch/Customer Selection screen 
   
   
   
# Ask Ranjith about the chart name, validating the KPI values and Chart Values. Or WHat all the possible 
# validation can be done in this screen (Name we can validate)
#
# the metrics above the profit (post tier 1) is Total tier 1
# the metrics b/w profit (post tier 1) to profit (post tier 1-2) is of the Cost to serve
# the metrics b/w Tier 3 costs - Enterprise profit is of Enterprise profit