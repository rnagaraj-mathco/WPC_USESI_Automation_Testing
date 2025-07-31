@ARCA_Overview
Feature: Land on the Overview screen of the Auto Root Cause Analysis and perform actions such as choosing a Metric, and interacting with Saved Customer Product Combinations and Saved Scenario Simulations table

#Done - Checked!
 #Choosing the Metric
 Scenario: Verify that the user is able to choose a Metric and click on View Saved Scenario button, which then updates the screen with 
           the Saved Customer Product Combinations and Saved Scenario Simulations table
 
  Given the user is on the Overview screen of the Auto Root Cause Analysis
  Then the user selects the metric "Returns Handling and Freight Costs" 
  And the user should be able to click the View Saved Scenarios button, which should then load the screen with the Saved Customer Product Combinations and Saved Scenario Simulations tables
  And the user should be able to click the Create New Root Cause Analysis button, which then redirects the to the Customer Analysis screen

#--DONE - Checked! Delete is not tested ---- |pagianatio, zoom , column filter is pending
 #--Saved Customer Product Combinations table - Selecting a record from the table
 Scenario: Verify that the user is able to choose a metric and click the View Saved Scenario button, which then updates the screen with Saved Customer Product Combinations table and perform various actions
  Given the user is on the Overview screen of the Auto Root Cause Analysis
  Then the user selects the metric "Returns Handling and Freight Costs" 
  And the user should be able to click the View Saved Scenarios button, which should then load the screen with the Saved Customer Product Combinations and Saved Scenario Simulations tables
  #--Saved Customer Product Combinations table - Selects
#
  Given the user should be able to search for a keyword in the Saved Customer Product Combinations table 
  When the user clicks the Create New Scenario button without selecting any records, an error message should be displayed
  And the user should be able to click the Edit button of any record in the Saved Customer Product Combinations table, which then redirects to the Customer Selection screen
  And the user should be able to click the Create New Scenario button and get redirected to the Create Scenario screen only if one record from the Saved Customer Product Combinations table is selected
  When the user clicks on the delete icon of the Saved Customer Product Combinations table without selecting Delete option from the dropdown, an error message should be displayed
  When the user clicks the download icon of a record in the Saved Customer Product Combinations table, the corresponding Customer Product Combinations should be downloaded as an Excel file
  
  #--When the user clicks on the delete dropdown of the Saved Customer Product Combinations table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon
  #--And the user should be able to zoom in and zoom out of the Saved Customer Product Combinations table using the + and - icons
  #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Saved Customer Product Combinations table
  #--Then the user should be able to interact with the Rows per page dropdown of the Saved Customer Product Combinations table to select a value, which updates the number of visible records

#DONE - Checked! - Delete is not tested | pagianatio, zoom , column filter is pending
 #Saved Customer Product Combinations table - Search and Select a record from the table
 Scenario: Verify that the user is able to choose a metric and click the View Saved Scenario button, which then updates the screen with Saved Customer Product Combinations table and perform various actions
  Given the user is on the Overview screen of the Auto Root Cause Analysis
  Then the user selects the metric "Returns Handling and Freight Costs" 
  And the user should be able to click the View Saved Scenarios button, which should then load the screen with the Saved Customer Product Combinations and Saved Scenario Simulations tables
  #--Saved Customer Product Combinations table - Search
  Given the user should be able to click the Edit button of any record in the Saved Customer Product Combinations table, which then redirects to the Customer Selection screen
  When the user clicks the Create New Scenario button without selecting any records, an error message should be displayed
  Then the user should be able to search for a record and select it in the Saved Customer Product Combinations table 
  And the user should be able to click the Create New Scenario button and get redirected to the Create Scenario screen only if one record from the Saved Customer Product Combinations table is selected
  When the user clicks on the delete icon of the Saved Customer Product Combinations table without selecting Delete option from the dropdown, an error message should be displayed
  When the user clicks the download icon of a record in the Saved Customer Product Combinations table, the corresponding Customer Product Combinations should be downloaded as an Excel file
  
  #--When the user clicks on the delete dropdown of the Saved Customer Product Combinations table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon
  #--And the user should be able to zoom in and zoom out of the Saved Customer Product Combinations table using the + and - icons
  #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Saved Customer Product Combinations table
  #--Then the user should be able to interact with the Rows per page dropdown of the Saved Customer Product Combinations table to select a value, which updates the number of visible records

#Done - Checked! -  |pagianatio, zoom , column filter is pending
 #Saved Scenario Simulations table - Selecting a record from the table
 Scenario: Verify that the user is able to choose a metric and click the View Saved Scenario button, which then updates the screen with Saved Scenario Simulations table and perform various actions
  Given the user is on the Overview screen of the Auto Root Cause Analysis
  Then the user selects the metric "Returns Handling and Freight Costs" 
  And the user should be able to click the View Saved Scenarios button, which should then load the screen with the Saved Customer Product Combinations and Saved Scenario Simulations tables
  #--Saved Scenario Simulations table - Select
  #Given the user should be able to search for a keyword in the Saved Scenario Simulations table 
  When the user clicks the View Impact button without selecting any records, a dialog box with an error message should be displayed
  And the user should be able to click the Edit button of any record in the Saved Scenario Simulations table, which then redirects to the Create Scenario screen
  And the user should be able to click the View Impact button, which opens a dialog box displaying the impact chart for the selected scenario, only if one record from the table is selected
  When the user clicks on the delete icon of the Saved Scenario Simulations table without selecting Delete option from the dropdown, an error message should be displayed in the popup 
  When the user clicks the download icon of a record in the Saved Scenario Simulations table, the corresponding Customer Product Combinations should be downloaded as an Excel file
  #
  #--When the user clicks on the delete dropdown of the Saved Scenario Simulations table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon
  #--And the user should be able to zoom in and zoom out of the Saved Scenario Simulations table using the + and - icons
  #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Saved Scenario Simulations table
  #--Then the user should be able to interact with the Rows per page dropdown of the Saved Scenario Simulations table to select a value, which updates the number of visible records

#DONE - Search -- selecting record and Pagination is not tested |pagianatio, zoom , column filter is pending
 #Saved Scenario Simulations table - Search and Select a record from the table
 Scenario: Verify that the user is able to choose a metric and click the View Saved Scenario button, which then updates the screen with Saved Scenario Simulations table and perform various actions
  Given the user is on the Overview screen of the Auto Root Cause Analysis
  Then the user selects the metric "Returns Handling and Freight Costs" 
  And the user should be able to click the View Saved Scenarios button, which should then load the screen with the Saved Customer Product Combinations and Saved Scenario Simulations tables

  #--Saved Scenario Simulations table - Search
  Given the user should be able to click the Edit button of any record in the Saved Scenario Simulations table, which then redirects to the Create Scenario screen
  When the user clicks the View Impact button without selecting any records, a dialog box with an error message should be displayed 
  Then the user should be able to search for a record and select it in the Saved Scenario Simulations table 
  And the user should be able to click the View Impact button, which opens a dialog box displaying the impact chart for the selected scenario, only if one record from the table is selected
  When the user clicks on the delete icon of the Saved Scenario Simulations table without selecting Delete option from the dropdown, an error message should be displayed in the popup 
  When the user clicks the download icon of a record in the Saved Scenario Simulations table, the corresponding Customer Product Combinations should be downloaded as an Excel file
 
  #--When the user clicks on the delete dropdown of the Saved Scenario Simulations table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon
  #--And the user should be able to zoom in and zoom out of the Saved Scenario Simulations table using the + and - icons
  #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Saved Scenario Simulations table
  #--Then the user should be able to interact with the Rows per page dropdown of the Saved Scenario Simulations table to select a value, which updates the number of visible records
  
