@ARCA_CustomerSelection
Feature: Land on the Customer Selection screen where the user should be able to select the customer and the corresponding commodity code for the simulation

#DONE: last three are pending
#Select One Customer for Simulation Table
 #Select the customer from the Single One Customer for Simulation table and load the Select Root Cause Products for Simulation table
 #Scenario: Verify whether the user is able to select the customer from the Select One Customer for Simulation table
  #Given the user is on the Customer Selection screen
  #When the user clicks on the Back button of the Select One Customer for Simulation table then it should redirect to the Filter Customer and Product Combinations screen
  #When the user clicks on the Select Customer button without selecting a record then an error message should be displayed
  #Then the user should be able to search for a keyword in the Select One Customer for Simulation table
  #When the user clicks on the download icon present in the Select One Customer for Simulation table header, then the entire table records should be downloaded as an excel file
  #Then the user should be able to select the customer from the Select One Customer for Simulation table
  #When the user clicks on the Select Customer button then the corresponding commodity code gets displayed in the Select Root Cause Products for Simulation table only if a customer record is selected
  #--And the user should be able to zoom in and zoom out of the Select One Customer for Simulation table using the + and - icons
  #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select One Customer for Simulation table
  #--Then user should be able to interact with the Rows per page dropdown of the Select One Customer for Simulation table and select a value, which updates the visible records
	
 #Search & Select the customer from the Single One Customer for Simulation table and load the Select Root Cause Products for Simulation table
 #Scenario: Verify whether the user is able to search and select the customer from the Select One Customer for Simulation table
  #Given the user is on the Customer Selection screen
  #When the user clicks on the Back button of the Select One Customer for Simulation table then it should redirect to the Filter Customer and Product Combinations screen
  #When the user clicks on the Select Customer button without selecting a record then an error message should be displayed
  #Then the user should be able to search for a customer record and select it in the Select One Customer for Simulation table
  #When the user clicks on the download icon present in the Select One Customer for Simulation table header, then the entire table records should be downloaded as an excel file
  #Then the user should be able to select the customer from the Select One Customer for Simulation table
  #When the user clicks on the Select Customer button then the corresponding commodity code gets displayed in the Select Root Cause Products for Simulation table only if a customer record is selected
  #--And the user should be able to zoom in and zoom out of the Select One Customer for Simulation table using the + and - icons
  #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select One Customer for Simulation table
  #--Then user should be able to interact with the Rows per page dropdown of the Select One Customer for Simulation table and select a value, which updates the visible records
	
#Select Root Cause Product for Simulation table
 #Select and Deselect the commodity code for the selected customer
 Scenario: Verify whether the user is able to select or multiselect the commodity code from the Select Root Cause Product for Simulation for the selected customer table
  Given the user is on the Customer Selection screen
  Then the user should be able to select the customer from the Select One Customer for Simulation table
  When the user clicks on the Select Customer button then the corresponding commodity code gets displayed in the Select Root Cause Products for Simulation table only if a customer record is selected
  #SRCP - Steps
  When the user clicks on the Save and Analyze button of Select Root Cause Product for Simulation table without selecting any commodity code then a Save and Proceed dialog screen appears with a warning message
  #When the user clicks on the Back button of Select Root Cause Product for Simulation table then the screen should reload to the previous state displaying only Select Root Cause Products for Simulation table
  And the user should be able to click on the select all checkbox present in the header of Select Root Cause Product for Simulation table and all commodity code should be selected
  #When the user clicks on the Reset button then all the selected commodity codes should be cleared and the Select Root Cause Product for Simulation table should rever to its previous state
  #Then the user should be able to select the commodity codes from Select Root Cause Product for Simulation table
  #And the user should be able to deselect the commodity codes from Select Root Cause Product for Simulation table
  #Then the user should be able to clicks on the Save and Analyze button of Select Root Cause Product for Simulation table then the Save and Proceed dialog screen should appear
  #And the user should be able to enter the name for the combination in the Save and Proceed dialog screen and click on the Proceed button then the user should be redirected to the Profit Bridge screen
  
  #--And the user should be able to zoom in and zoom out of the Select Root Cause Product for Simulation table using the + and - icons
  #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Root Cause Product for Simulation table
  #--Then user should be able to interact with the Rows per page dropdown of the Select Root Cause Product for Simulation table and select a value, which updates the visible records
	
 # Search, Select and Deselect the commodity code for the selected customer
 #Scenario: Verify whether the user is able to select or multiselect the commodity code from the Select Root Cause Product for Simulation for the selected customer table
  #Given the user is on the Customer Selection screen
  #When the user clicks on the Save and Analyze button of Select Root Cause Product for Simulation table without selecting any commodity code then a Save and Proceed dialog screen appears with a warning message
  #When the user clicks on the Back button of Select Root Cause Product for Simulation table then the screen should reload to the previous state displaying only Select Root Cause Products for Simulation table
  #Then the user clicks on the download icon present in the Select Root Cause Product for Simulation table header, then the entire table records should be downloaded as an excel file
  #And the user should be able to click on the select all checkbox present in the header of Select Root Cause Product for Simulation table and all commodity code should be selected
  #When the user clicks on the Reset button then all the selected commodity codes should be cleared and the Select Root Cause Product for Simulation table should rever to its previous state
  #Then the user should be able to select the commodity codes from Select Root Cause Product for Simulation table
  #And the user should be able to deselect the commodity codes from Select Root Cause Product for Simulation table
  #Then the user should be able to search for the commodity codes record and select the commodity code
  #And the user should be able to search for the commodity codes record and deselect the commodity code
  #Then the user should be able to clicks on the Save and Analyze button of Select Root Cause Product for Simulation table then the Save and Proceed dialog screen should appear
  #And the user should be able to enter the name for the combination in the Save and Proceed dialog screen and click on the Proceed button then the user should be redirected to the Profit Bridge screen
  #--And the user should be able to zoom in and zoom out of the Select Root Cause Product for Simulation table using the + and - icons
  #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Root Cause Product for Simulation table
  #--Then user should be able to interact with the Rows per page dropdown of the Select Root Cause Product for Simulation table and select a value, which updates the visible records
	