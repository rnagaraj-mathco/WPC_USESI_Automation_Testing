@CustomerPeerAnalysis_BranchCustomerSelection
Feature: Lands on the Branch/Customer Selection where the user should be able to select the branch(es) based on the metric and 
         other filters from the geographical map and select customer for the peer selection
         
  #Branch Selection - Map
  #Scenario: Verify that the user can select a branch from the geographical map
    #Given the user is on the Branch/Customer Selection screen
    #Then the user clicks on Filters and selects options based on requirements
    #And the user selects a metric from the metrics dropdown
    #And the user should be able to zoom in and out of the map using the + and - icons on the zoom slider
    #When the map is updated, the user clicks on bubbles to highlight branches on the geographical map
    #And the user clicks the Analyze button, which redirects to the Customer Selection dialog screen
    #Then the user selects customers from the plot and dropdown, clicks Save Customers, and is redirected to the Peer Selection screen

  #Branch Selection Dropdown
  Scenario: Verify that the user can select a branch using the Select Branch dropdown
    Given the user is on the Branch/Customer Selection screen
    Then the user clicks on Filters and selects options based on requirements
    And the user selects a metric from the metrics dropdown
    And the user should be able to zoom in and out of the map using the + and - icons on the zoom slider
    Then the user clicks on the Select Branch dropdown and searches for a branch, which gets highlighted on the map
    And the user clicks the Analyze button, which redirects to the Customer Selection dialog screen
    Then the user selects customers from the plot and dropdown, clicks Save Customers, and is redirected to the Peer Selection screen