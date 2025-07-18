@CPA_PeerSelection
Feature: Land on the Peer Selection screen where the user should be able to select a customer from the set of customers chosen on the 
         Branch/Customer Selection screen, and then select peers for the Selected Target Customer based on threshold and similarity model.
#DONE

  #Peer Selection 01 - Select Target Customer for Peer Matching - Customer Selection by clicking on the records of the table
  #Scenario: Verify that the user is able to select a customer from the Select Target Customer for Peer Matching table
    #Given the user is on the Peer Selection page of the Customer Peer Analysis
    #Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
    #And the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file
     #--And the user should be able to zoom in and zoom out of the Select Target Customer for Peer Matching table using the + and - icons
     #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Target Customer for Peer Matching table
    #When the user clicks on the Select Customer button without selecting any records, an error message should be displayed
    #And the user should be able to select a customer record from the Select Target Customer for Peer Matching table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
    #And the user should be able to click the Back button, which then redirects to the Peer Selection - Select Target Customer for Peer Matching page
    #And the user should be able to click the Back button, which then redirects to the Branch/Customer Selection page
     #--Then user should be able to interact with the Rows per page dropdown of the Select Target Customer for Peer Matching table and select a value, which updates the visible records
	
#DONE -But Reset is pending

 #Peer Selection 01 - Select Target Customer for Peer Matching - Customer Selection by Searching and Selecting the the record
  #Scenario: Verify that the user is able to select a customer by searching the record from the Select Target Customer for Peer Matching table
    #Given the user is on the Peer Selection page of the Customer Peer Analysis
    #Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
     #And the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file
     #--And the user should be able to zoom in and zoom out of the Select Target Customer for Peer Matching table using the + and - icons
     #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Target Customer for Peer Matching table
    #When the user clicks on the Select Customer button without selecting any records, an error message should be displayed
    #And the user should be able to search for a customer record and select it from the Select Target Customer for Peer Matching table and click on the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
    #And the user should be able to click the Back button, which then redirects to the Peer Selection - Select Target Customer for Peer Matching screen
    #And the user should be able to click the Back button, which then redirects to the Branch/Customer Selection page
     #--Then user should be able to interact with the Rows per page dropdown of the Select Target Customer for Peer Matching table and select a value, which updates the visible records

#DONE -But Reset is pending for that try to use select all checkbox in the table header

 #Peer Selection 02 Comparative Peer Group Selection -- SPMC - Peer Dropdown - Table - Buttons
	Scenario: Verify that the user is able to select the peers by clicking on the Select Peer Matching Criteria button and 
	          select peers from the dropdown and also select from the Select Comparative Peer Group table for the Selected Target Customer
		Given the user is on the Peer Selection page of the Customer Peer Analysis
    #Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
    And the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file
    #--And the user should be able to zoom in and zoom out of the Select Target Customer for Peer Matching table using the + and - icons
    #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Target Customer for Peer Matching table
    When the user clicks on the Select Customer button without selecting any records, an error message should be displayed
    And the user should be able to select a customer record from the Select Target Customer for Peer Matching table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
    #SPMC - Peer Dropdown - Table - Buttons
    Then the user is on the Peer Selection - Comparative Peer Group Selection screen, where the user should be able to click on the Set Peer Matching Criteria button to enter threshold values and select a similarity model
    Then the user should be able to click on the Select Peers Dropdown and choose the desired peers count 
    And the user should be able to search for a keyword in the Select Comparative Peer Group table 
    And the user should be able to click on the download icon present in the Select Comparative Peer Group table header, which downloads the table records as an Excel file
     #--And the user should be able to zoom in and zoom out of the Select Comparative Peer Group table using the + and - icons
     #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    Then the user should be able to select the peers by clicking on the checkbox of each peer record
    And the user should be able to deselect the peers by clicking on the checkbox of each peer record
    And the user should be able to search for the peers records and select the peers
    And the user should be able to search for the peers records and deselect the peers
    Then the user should be able to click on the Compare Peers button which then opens up the dialog box to enter the name and save the peer selections
    #Then the user should be able to click on the Reset button which then resets the peer selections and updates the table to older version

#DONE - But Reset is pending
 #Peer Selection 02 Comparative Peer Group Selection - SPMC - Peer Dropdown - Buttons (In table only search keyword, download,column filters)
#	Scenario: Verify that the user is able to select the peers by clicking on the Select Peer Matching Crieteria button and 
#	          select peers only from the dropdown for the Selected Target Customer
#		Given the user is on the Peer Selection page of the Customer Peer Analysis
    #Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
    #And the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file
    #--And the user should be able to zoom in and zoom out of the Select Comparative Peer Group table using the + and - icons
    #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #When the user clicks on the Select Customer button without selecting any records, an error message should be displayed
    #And the user should be able to select a customer record from the Select Target Customer for Peer Matching table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
   #SPMC - Peer Dropdown - Table - Buttons
    #Then the user is on the Peer Selection - Comparative Peer Group Selection screen, where the user should be able to click on the Set Peer Matching Criteria button to enter threshold values and select a similarity model
    #Then the user should be able to click on the Select Peers Dropdown and choose the desired peers count
    #And the user should be able to search for a keyword in the Select Comparative Peer Group table 
    #And the user should be able to click on the download icon present in the Select Comparative Peer Group table header, which downloads the table records as an Excel file
     #--And the user should be able to zoom in and out of the Select Comparative Peer Group table using the + and - icons
     #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #Then the user should be able to click on the Compare Peers button which then opens up the dialog box to enter the name and save the peer selections
    #Then the user should be able to click on the Reset button which then resets the peer selections and updates the table to older version
    
#DONE - But reset is pending
 #Peer Selection 02 Comparative Peer Group Selection - SPMC - Table - Buttons
  #Scenario: Verify that the user is able to select the peers by clicking on the Select Peer Matching Crieteria button and 
#	          selecting peer from the Select Comparative Peer Group table for the Selected Target Customer
   #	Given the user is on the Peer Selection page of the Customer Peer Analysis
    #Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
    #And the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file
    #--And the user should be able to zoom in and zoom out of the Select Comparative Peer Group table using the + and - icons
    #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #When the user clicks on the Select Customer button without selecting any records, an error message should be displayed
    #And the user should be able to select a customer record from the Select Target Customer for Peer Matching table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
  #	#SPMC - Table - Buttons
    #Then the user is on the Peer Selection - Comparative Peer Group Selection screen, where the user should be able to click on the Set Peer Matching Criteria button to enter threshold values and select a similarity model
    #And the user should be able to search for a keyword in the Select Comparative Peer Group table 
    #And the user should be able to click on the download icon present in the Select Comparative Peer Group table header, which downloads the table records as an Excel file
     #--And the user should be able to zoom in and out of the Select Comparative Peer Group table using the + and - icons
     #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #Then the user should be able to select the peers by clicking on the checkbox of each peer record
    #And the user should be able to deselect the peers by clicking on the checkbox of each peer record
    #And the user should be able to search for the peers records and select the peers
    #And the user should be able to search for the peers records and deselect the peers
    #Then the user should be able to click on the Compare Peers button which then opens up the dialog box to enter the name and save the peer selections
    #Then the user should be able to click on the Reset button which then resets the peer selections and updates the table to older version

#DONE - but reset is pending
 #Peer Selection 02 Comparative Peer Group Selection - SPMC(View) - Peer Dropdown - Table - Buttons
#	Scenario: Verify that the user is able to click on the Set Peer Matching Crieteria button and view the Model selected and Threshold value and then
#	          select peers from the dropdown and also select from the Select Comparative Peer Group table for the Selected Target Customer
#		Given the user is on the Peer Selection page of the Customer Peer Analysis
    #Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
    #And the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file
    #--And the user should be able to zoom in and zoom out of the Select Comparative Peer Group table using the + and - icons
    #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #When the user clicks on the Select Customer button without selecting any records, an error message should be displayed
    #And the user should be able to select a customer record from the Select Target Customer for Peer Matching table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
  #	#SPMC(View) - Peer Dropdown - Table - Buttons
    #Then the user is on the Peer Selection - Comparative Peer Group Selection screen, where the user should be able to click on the Set Peer Matching Criteria button and view the threshold value and the model selected
    #And the user should be able to search for a keyword in the Select Comparative Peer Group table 
    #Then the user should be able to click on the Select Peers Dropdown and choose the desired peers count
    #And the user should be able to click on the download icon present in the Select Comparative Peer Group table header, which downloads the table records as an Excel file
     #--And the user should be able to zoom in and out of the Select Comparative Peer Group table using the + and - icons
     #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
   #Then the user should be able to select the peers by clicking on the checkbox of each peer record
    #And the user should be able to deselect the peers by clicking on the checkbox of each peer record
    #And the user should be able to search for the peers records and select the peers
    #And the user should be able to search for the peers records and deselect the peers
    #Then the user should be able to click on the Compare Peers button which then opens up the dialog box to enter the name and save the peer selections
    #Then the user should be able to click on the Reset button which then resets the peer selections and updates the table to older version

#Done - but reset is pending
 #Peer Selection 02 Comparative Peer Group Selection - SPMC(View) - Table - Buttons
#	Scenario: Verify that the user is able to click on the Set Peer Matching Crieteria button and view the Model selected and Threshold value and then
#	          select peers from the Select Comparative Peer Group table for the Selected Target Customer
#		Given the user is on the Peer Selection page of the Customer Peer Analysis
    #Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
    #And the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file
    #--And the user should be able to zoom in and zoom out of the Select Comparative Peer Group table using the + and - icons
    #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #When the user clicks on the Select Customer button without selecting any records, an error message should be displayed
    #And the user should be able to select a customer record from the Select Target Customer for Peer Matching table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
  #	 #SPMC(View) - Peer Dropdown - Table - Buttons
    #Then the user is on the Peer Selection - Comparative Peer Group Selection screen, where the user should be able to click on the Set Peer Matching Criteria button and view the threshold value and the model selected
    #And the user should be able to search for a keyword in the Select Comparative Peer Group table 
    #And the user should be able to click on the download icon present in the Select Comparative Peer Group table header, which downloads the table records as an Excel file
     #--And the user should be able to zoom in and out of the Select Comparative Peer Group table using the + and - icons
     #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #Then the user should be able to select the peers by clicking on the checkbox of each peer record
    #And the user should be able to deselect the peers by clicking on the checkbox of each peer record
    #And the user should be able to search for the peers records and select the peers
    #And the user should be able to search for the peers records and deselect the peers
    #Then the user should be able to click on the Compare Peers button which then opens up the dialog box to enter the name and save the peer selections
    #Then the user should be able to click on the Reset button which then resets the peer selections and updates the table to older version

#Done - but reset and back btn is pending
 #Peer Selection 02 Comparative Peer Group Selection - SPMC(View) - Peer Dropdown - Table - Back button
#	Scenario: Verify that the user is able to click on the Set Peer Matching Crieteria button and view the Model selected and the Threshold value and 
#	          select the peers from the dropdown and the table of Select Comparative Peer Group table for the Selected Target Customer and click on back button
#		Given the user is on the Peer Selection page of the Customer Peer Analysis
    #Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
    #And the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file
    #--And the user should be able to zoom in and zoom out of the Select Comparative Peer Group table using the + and - icons
    #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #When the user clicks on the Select Customer button without selecting any records, an error message should be displayed
    #And the user should be able to select a customer record from the Select Target Customer for Peer Matching table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
  #	#SPMC(View) - Peer Dropdown - Table - Back button
    #Then the user is on the Peer Selection - Comparative Peer Group Selection screen, where the user should be able to click on the Set Peer Matching Criteria button and view the threshold value and the model selected
    #And the user should be able to search for a keyword in the Select Comparative Peer Group table 
    #Then the user should be able to click on the Select Peers Dropdown and choose the desired peers count
    #And the user should be able to click on the download icon present in the Select Comparative Peer Group table header, which downloads the table records as an Excel file
     #--And the user should be able to zoom in and out of the Select Comparative Peer Group table using the + and - icons
     #--And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table
    #Then the user should be able to select the peers by clicking on the checkbox of each peer record
    #And the user should be able to deselect the peers by clicking on the checkbox of each peer record
    #And the user should be able to search for the peers records and select the peers
    #And the user should be able to search for the peers records and deselect the peers
    #Then the user should be able to click on the Compare Peers button which then opens up the dialog box to enter the name and save the peer selections
    #Then the user should be able to click on the Reset button which then resets the peer selections and updates the table to older version
    #Then the user should be able to click on the Back button which then redirects the user to the Peer Selection - Target Customer Selection Screen
   
    
      
    
    