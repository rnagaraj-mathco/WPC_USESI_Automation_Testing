@AutoRootCauseAnalysis_CustomerAnalysis
Feature: Land on the Customer Analysis screen where the user should be able to interact with filters and select the customer from the plot

#Selecting customer from plot is pending
 #Selecting Customer from plot based on the Filter operations
 Scenario: Verify that the user is able to interact with filters and select customers from the plot and save the selection
  Given the user is on the Customer Analysis screen
  #Then the user clicks on Filters and select options based on the requirements
  Then the user should be able to Select Customers from the Root Cause Customers for the Selected Cost Metric plot
  And the user should click on the Save Customers button which then saves the selection and redirects to the Filter Customer and Product Combinations screen
  #When the user clicks the Reset button, the entire customer selection in the Root Cause Customers for the Selected Cost Metric plot is reverted to its previous state.

#DONE
 #Selecting Customer from Select All option based on the Filter operations
 #Scenario: Verify that the user is able to interact with filters and select customers from the plot and save the selection
  #Given the user is on the Customer Analysis screen
  #Then the user clicks on Filters and select options based on the requirements
  #Then the user should be able to Select all the customers from the Root Cause Customers for the Selected Cost Metric plot by clicking on the Select All Customer option
  #And the user should click on the Save Customers button which then saves the selection and redirects to the Filter Customer and Product Combinations screen
  #When the user clicks the Reset button, the entire customer selection in the Root Cause Customers for the Selected Cost Metric plot is reverted to its previous state.
 
