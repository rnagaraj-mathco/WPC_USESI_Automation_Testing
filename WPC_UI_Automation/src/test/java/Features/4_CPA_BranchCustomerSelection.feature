@CPA_BranchCustomerSelection
Feature: Lands on the Branch/Customer Selection where the user should be able to select the branch(es) based on the metric and 
         other filters from the geographical map and select customer for the peer selection
         
#DONE - But the filter operation is pending 
  #Branch Selection - Map | Customer selection - dropdown
  #Scenario: Verify that the user can select a branch from the geographical map and select customers from the dropdown
    #Given the user is on the Branch/Customer Selection screen
    #Then the user clicks on Filters and selects options based on requirements
    #And the user selects a metric from the metrics dropdown
    #--And the user should be able to zoom in and out of the map using the + and - icons on the zoom slider
    #When the map is updated, the user clicks on bubbles and select the branches on the geographical map
    #And the user clicks the Analyze button, which redirects to the Customer Selection dialog screen
    #Then the user selects customers from the dropdown, clicks Save Customers, and is redirected to the Peer Selection screen
#
#DONE - Filter operation is pending
  #Branch Selection - Dropdown | Customer selection - dropdown
  #Scenario: Verify that the user can select a branch using the Select Branch dropdown and select customers from the dropdown
    #Given the user is on the Branch/Customer Selection screen
    #Then the user clicks on Filters and selects options based on requirements
    #And the user selects a metric from the metrics dropdown
    #--And the user should be able to zoom in and out of the map using the + and - icons on the zoom slider
    #Then the user clicks on the Select Branch dropdown and searches for a branch, which gets highlighted on the map
    #And the user clicks the Analyze button, which redirects to the Customer Selection dialog screen
    #Then the user selects customers from the dropdown, clicks Save Customers, and is redirected to the Peer Selection screen
  #
  #Branch Selection - Dropdown | Customer Selection - Plot
  #Scenario: Verify that the user can select a branch using the Select Branch dropdown and select customers from the scatter plot
    #Given the user is on the Branch/Customer Selection screen
    #Then the user clicks on Filters and selects options based on requirements
    #And the user selects a metric from the metrics dropdown
    #--And the user should be able to zoom in and out of the map using the + and - icons on the zoom slider
    #Then the user clicks on the Select Branch dropdown and searches for a branch, which gets highlighted on the map
    #And the user clicks the Analyze button, which redirects to the Customer Selection dialog screen
    #Then the user selects customers from the scatter plot, clicks Save Customers, and is redirected to the Peer Selection screen
    #
  #DONE - Checked! - Only with Filters need to be validated and 24018 is not selected
  #Branch Selection - Map | Customer Selection - Plot
  #Scenario: Verify that the user can select a branch from the geographical map and select customers from the scatter plot
    #Given the user is on the Branch/Customer Selection screen
    #Then the user clicks on Filters and selects options based on requirements
    #And the user selects a metric from the metrics dropdown
    #--And the user should be able to zoom in and out of the map using the + and - icons on the zoom slider
    #When the map is updated, the user clicks on bubbles and select the branches on the geographical map
    #Then the user clicks on the Select Branch dropdown and searches for a branch, which gets highlighted on the map
    #And the user clicks the Analyze button, which redirects to the Customer Selection dialog screen
    #Then the user selects customers from the scatter plot, clicks Save Customers, and is redirected to the Peer Selection screen
   #
   
  #DONE - Checked! - Only with Filters need to be validated and 24018 is not selected 
  #Branch Selection - Geaographical Map & Dropdown | Customer Selection - Dropdown & Plot
  Scenario: Verify that the user can select a branch initially from the geographical map and then Select Branch(es) dropdown and select customers from both the scatter plot and dropdown
    Given the user is on the Branch/Customer Selection screen
    Then the user clicks on Filters and selects options based on requirements
    And the user selects a metric from the metrics dropdown
    #--And the user should be able to zoom in and out of the map using the + and - icons on the zoom slider
    When the map is updated, the user clicks on bubbles and select the branches on the geographical map
    Then the user clicks on the Select Branch dropdown and searches for a branch, which gets highlighted on the map
    And the user clicks the Analyze button, which redirects to the Customer Selection dialog screen
    Then the user selects customers from the both the dropdown and scatter plot, clicks Save Customers, and is redirected to the Peer Selection screen
   
   
    
    