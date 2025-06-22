@CustomerPeerAnalysis_Overview
Feature: Land on the Overview screen of the Customer Peer Analysis and perform actions on starting new peer analysis button, saved customer peer selections and saved sensitivity simulation scenario table

  @StartNewPeerAnalysisButton
  Scenario: Verify whether the user is able to click on the Start New Peer Analysis button and get redirected to the Branch/Customer Selection sub tab under the Selections tab
    Given user is on the Overview page of the Customer Peer Analysis
    Then user should be able to click on the Start New Peer Analysis button and get redirected to the Branch/Customer Selection sub tab
    
  @SavedCustomerPeerSelections
	Scenario: Verify that the user can interact with the Saved Customer Peer Selection table and perform various actions
	  Given user is on the Overview page of the Customer Peer Analysis
	  Then user should be able to search for a keyword in the Saved Customer Peer Selection table
	  Then user should be able to click on the Create Sensitivity Scenario button and get redirected to the Create Scenario screen only if one record from the Saved Customer Peer Selection table is selected
	  When user clicks on the Create Sensitivity Scenario button without selecting any records, an error message should be displayed
	  And  user should be able to click on the Edit button of any one record of the Saved Customer Peer Selection, which then redirects to the Peer Selection screen
#	  When user clicks on the delete dropdown of the Saved Customer Peer Selection table, then should get options and where if Delete is selected then that record should get deleted after clicking on the delete icon
	  When user clicks on the delete icon of the Saved Customer Peer Selection table without setting to the Delete from the dropdown, an error message should be displayed
	  When user clicks the download icon of a record in the Saved Customer Peer Selection table, the corresponding Peer Selection should be downloaded as an Excel file
#	  Then user should be able to interact with the Rows per page dropdown of the Saved Customer Peer Selection table and select a value, which updates the visible records

	@SavedSensitivitySimulationScenario
	Scenario: Verify that the user can interact with the Saved Sensitivity Simulation Scenario table and perform various actions
	  Given user is on the Overview page of the Customer Peer Analysis
	  Then user should be able to search for a keyword in the Saved Sensitivity Simulation Scenario table
	  Then user should be able to click on the View Impact button and get redirected to the View Scenario Impact screen only if any one record from the Saved Sensitivity Simulation scenario table is selected
	  When user clicks on the View Impact button without selecting any records, an error message should be displayed
	  And  user should be able to click on the Edit button for any one record of the Saved Sensitivity Simulation Scenario table, which then redirects to the Create Scenario screen
#	  When user clicks on the delete dropdown of the Saved Sensitivity Simulation Scenario table, then should get options and where if Delete is selected then that record should get deleted after clicking on the delete icon
	  When user clicks on the delete icon of the Saved Sensitivity Simulation Scenario table without setting to the Delete from the dropdown, an error message should be displayed
	  When user clicks the download icon of a record in the Saved Sensitivity Simulation Scenario table, the corresponding scenario should be downloaded as an Excel file
#	  Then user should be able to interact with the Rows per page dropdown of the Saved Sensitivity Simulation Screen and select a value, which updates the visible records

