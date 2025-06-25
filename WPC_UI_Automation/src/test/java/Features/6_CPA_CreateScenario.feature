@CustomerPeerAnalysis_CreateScenario
Feature: Land on the Create Scenario screen where the user should be able to create a scenario to the Selected Target Customer and its 
         Selected Comparative Peer Group by moving the simulator slider present for each metric 


  #Create Scenario
  Scenario: Verify that the user can create a scenario by adjusting the simulation sliders of the charts
  	Given the user is on the Create Scenario Screen 
  	Then the user should be able to open the Filters and select the previously created customer + peer group name, which should then load on the screen
  	When the user hovers over the sliders in the Peer Comparison - Pricing and Peer Comparison - Cost To Serve chart, then the corresponding value should be displayed
  	Then the user should be able to adjust the sliders in the Start Simulating - Pricing and Start Simulating - Cost To Serve charts to simulate the scenario
  	And the user should be able to enter numeric values directly in the input fields, which should update the slider positions accordingly
 		And the user should be able to enter a scenario name in the Scenario Name field and click the Save and Show Impact button
    Then the user should be redirected to the View Scenario Impact screen, only if a scenario name is provided	
  	When the user clicks on the Save and Show Impact button without entering the Scenario Name, an error message should get displayed
  	When the user clicks on the Back button then the user should get redirected to the Peer Selection - Select Target Comparative Peer Group Selection Screen
  	When the user clicks on the Reset button then the both the simulation chart updates to the initial state
 