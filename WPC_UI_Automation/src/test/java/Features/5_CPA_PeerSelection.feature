@CustomerPeerAnalysis_PeerSelection
Feature: Land on the Peer Selection screen where the user should be able to select a customer from the set of customers chosen on the 
         Branch/Customer Selection screen, and then select peers for the chosen customer based on threshold and similarity model.

  @CustomerSelection
  Scenario: Verify that the user is able to select a customer from the Select Target Customer for Peer Matching table
    Given the user is on the Peer Selection page of the Customer Peer Analysis
    Then the user should be able to search for a keyword in the Select Target Customer for Peer Matching table
    #And the user should be able to zoom in and out of the table using the + and - icons
    #And the user should be able to click on the column filter icon to select which columns should be displayed in the Select Target Customer for Peer Matching table
    And the user should be able to select a customer record from the table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected
    When user clicks on the Select Customer button without selecting any records, an error message should be displayed
    #Then the user should be able to click on the Download icon present in the table header, which downloads the table records as an Excel file
    #And the user should be able to click the Back button, which then redirects to the Branch/Customer Selection page
    #Then user should be able to interact with the Rows per page dropdown of the Saved Customer Peer Selection table and select a value, which updates the visible records
