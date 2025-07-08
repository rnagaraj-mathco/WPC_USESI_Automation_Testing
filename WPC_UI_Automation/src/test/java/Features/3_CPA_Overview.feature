@CustomerPeerAnalysis_Overview
Feature: Land on the Overview screen of the Customer Peer Analysis and perform actions on starting new peer analysis button, saved customer peer selections and saved sensitivity simulation scenario table

  #Start New Peer Analysis Button
  #Scenario: Verify that the user is able to click on the Start New Peer Analysis button and get redirected to the Branch/Customer Selection screen
    #Given the user is on the Overview page of the Customer Peer Analysis
    #Then the user should be able to click on the Start New Peer Analysis button and get redirected to the Branch/Customer Selection screen
    
  #Saved Customer Peer Selections - Selecting a Peer Selection record from the table
	Scenario: Verify that the user can interact with the Saved Customer Peer Selection table by selecting a Peer Selection record from the table and performing various actions
	  Given the user is on the Overview page of the Customer Peer Analysis
	  Then the user should be able to search for a keyword in the Saved Customer Peer Selection table
	  Then the user should be able to click on the Create Sensitivity Scenario button and get redirected to the Create Scenario screen only if one record from the Saved Customer Peer Selection table is selected
	  When the user clicks on the Create Sensitivity Scenario button without selecting any records, an error message should be displayed
	  And  the user should be able to click on the Edit button of any record of the Saved Customer Peer Selection table, which then redirects to the Peer Selection screen
#	  ---When the user clicks on the delete dropdown of the Saved Customer Peer Selection table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon
#	  ---When the user clicks on the delete icon of the Saved Customer Peer Selection table without selecting Delete option from the dropdown, an error message should be displayed
	  When the user clicks the download icon of a record in the Saved Customer Peer Selection table, the corresponding Peer Selection should be downloaded as an Excel file
#	  ---Then the user should be able to interact with the Rows per page dropdown of the Saved Customer Peer Selection table to select a value, which updates the number of visible records

 #Saved Customer Peer Selections - Search and Select the Peer Selection record  --- Pending
#	Scenario: Verify that the user can interact with the Saved Customer Peer Selection table by searching for a Peer Selection record, selecting it and performing various actions
#	  Given the user is on the Overview page of the Customer Peer Analysis
#	  Then the user should be able to search for a record and select it in the Saved Customer Peer Selection table
#	  Then the user should be able to click on the Create Sensitivity Scenario button and get redirected to the Create Scenario screen only if one record from the Saved Customer Peer Selection table is selected
#	  When the user clicks on the Create Sensitivity Scenario button without selecting any records, an error message should be displayed
#	  And  the user should be able to click on the Edit button of any record of the Saved Customer Peer Selection table, which then redirects to the Peer Selection screen
#	  When the user clicks on the delete dropdown of the Saved Customer Peer Selection table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon
#	  When the user clicks on the delete icon of the Saved Customer Peer Selection table without selecting Delete option from the dropdown, an error message should be displayed
#	  When the user clicks the download icon of a record in the Saved Customer Peer Selection table, the corresponding Peer Selection should be downloaded as an Excel file
#	  Then the user should be able to interact with the Rows per page dropdown of the Saved Customer Peer Selection table to select a value, which updates the number of visible records


  #Saved Sensitivity Simulation Scenario - Selecting a Sensitivity Simulation Scenario record from the table
	Scenario: Verify that the user can interact with the Saved Sensitivity Simulation Scenario table and perform various actions
	  Given the user is on the Overview page of the Customer Peer Analysis
	  Then the user should be able to search for a keyword in the Saved Sensitivity Simulation Scenario table
	  Then the user should be able to click on the View Impact button and get redirected to the View Scenario Impact screen only if any one record from the Saved Sensitivity Simulation scenario table is selected
	  When the user clicks on the View Impact button without selecting any records, an error message should be displayed
	  And  the user should be able to click on the Edit button for any one record of the Saved Sensitivity Simulation Scenario table, which then redirects to the Create Scenario screen
#	  When the user clicks on the delete dropdown of the Saved Sensitivity Simulation Scenario table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon
	  When the user clicks on the delete icon of the Saved Sensitivity Simulation Scenario table without selecting Delete option from the dropdown, an error message should be displayed
	  When the user clicks the download icon of a record in the Saved Sensitivity Simulation Scenario table, the corresponding Sensitivity Simulation scenario should be downloaded as an Excel file
#	  Then the user should be able to interact with the Rows per page dropdown of the Saved Sensitivity Simulation table to select a value, which updates the number of visible records

 #Saved Sensitivity Simulation Scenario - Search and Select the Peer Selection record  --- Pending
#	Scenario: Verify that the user can interact with the Saved Sensitivity Simulation Scenario table and perform various actions
#	  Given the user is on the Overview page of the Customer Peer Analysis
#	  Then the user should be able to search for a record and select it in the Saved Sensitivity Simulation Scenario table
#	  Then the user should be able to click on the View Impact button and get redirected to the View Scenario Impact screen only if any one record from the Saved Sensitivity Simulation scenario table is selected
#	  When the user clicks on the View Impact button without selecting any records, an error message should be displayed
#	  And  the user should be able to click on the Edit button for any one record of the Saved Sensitivity Simulation Scenario table, which then redirects to the Create Scenario screen
#	  When the user clicks on the delete dropdown of the Saved Sensitivity Simulation Scenario table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon
#	  When the user clicks on the delete icon of the Saved Sensitivity Simulation Scenario table without selecting Delete option from the dropdown, an error message should be displayed
#	  When the user clicks the download icon of a record in the Saved Sensitivity Simulation Scenario table, the corresponding Sensitivity Simulation scenario should be downloaded as an Excel file
#	  Then the user should be able to interact with the Rows per page dropdown of the Saved Sensitivity Simulation table to select a value, which updates the number of visible records

