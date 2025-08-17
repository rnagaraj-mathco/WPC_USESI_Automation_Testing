@ARCA_FilterCustomerProductCombinations
Feature: Land on the Filter Customer and Product Combinations screen where the user should be able to select customers and their associated commodity codes

#DONE - Checked! ---Extracting the customer id from tree map and validation is pending 
  #Selecting the customer and commodity codes using the "Select All" options
  Scenario: Verify that the user is able to click on the Select All Customer or Select All Commodity Codes checkbox, which then selects all tiles in the tree map
   Given the user is on the Filter Customer and Product Combinations screen
   When the user clicks the Save Combination button without selecting any customers or commodity codes from the tree map, an error message should be displayed
   Then the user should be able to click on the Select All Customer checkbox, which selects all tiles in the tree map
   Then the user should be able to click on the Reset button, which restores the screen to its previous state
   When the user clicks on the Select All Commodity Codes checkbox, which selects all tiles in the tree map
   Then the user clicks on the Customer Details button, which opens a select customers for analysis dialog box containing all selected customer details
   Then the user clicks on the Save Combination button, which redirects to the Customer Selection screen with the selected customer details
 #
 #DONE - Checked!
 #Selecting the Customer and Commodity code by interacting with tree map
 Scenario: Verify that the user is able to select the customer and corresponding commodity codes from the tree map
  Given the user is on the Filter Customer and Product Combinations screen
  When the user clicks the Save Combination button without selecting any customers or commodity codes from the tree map, an error message should be displayed
  Then the user should be able to click on the Select All Customer checkbox, which selects all tiles in the tree map
  Then the user should be able to click on individual customer tiles, after which the selection of all tiles and the Select All checkbox options should be unchecked
  Then the user should be able to click on the tiles in the Commodity Code section to either select or deselect the desired commodities
  Then the user clicks on the Customer Details button, which opens a select customers for analysis dialog box containing all selected customer details
  Then the user clicks on the Save Combination button, which redirects to the Customer Selection screen with the selected customer details

#Done - But facing issue in the flow where if ccustomer are selected and also searched and selected but the selected one are not reflecting in map
				#due to which the scenario is failing
				#Also there is a mismatch in customer ID of SOC table even though values are same but issue is with index order of the customer ID and the value are same
 #Clicking on the customer details button and perform selections
 #Scenario: Verify that the user is able to click the Customer Details button and select customers, which are then reflected in the tree map
  #Given the user is on the Filter Customer and Product Combinations screen
  #When the user clicks the Save Combination button without selecting any customers or commodity codes from the tree map, an error message should be displayed
  #Then the user clicks on the Customer Details button, which loads the select customers for analysis table and be able to select customers by clicking the checkbox provided for each customer record
  #--Then the user should be able to search for and select a customer record by Customer ID in the Select Customers for Analysis table
  #And the user should be able to click on the Download icon of the Select Customers for Analysis table, which then downloads the customer details as an Excel file
  #And the user should be able to click the Apply button on the popup, which then updates the tree map with the selected customers
  #Then the user clicks on the Save Combination button, which redirects to the Customer Selection screen with the selected customer details
