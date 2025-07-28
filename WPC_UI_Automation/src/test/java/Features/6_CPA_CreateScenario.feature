@CPA_CreateScenario
Feature: Land on the Create Scenario screen where the user should be able to create a scenario to the Selected Target Customer and its 
         Selected Comparative Peer Group by moving the simulator slider present for each metric 

	#DONE - Back btn scripted but need to validated after redirection is resolved
  #Create Scenario with simulation
  Scenario: Verify that the user can create a scenario by adjusting the simulation sliders of the charts
  	Given the user is on the Create Scenario Screen 
  	When the user clicks on the Save and Show Impact button without entering a Scenario Name, an error message should be displayed
  #25/07_ If a filter is clicked then not able to create the sceanrio   
  	Then the user should be able to click on the Filters and perform actions such as Apply, Reset and Cancel based on requirements
  #Back buttton scripts are done but the redirection is not proper and reported to developers
   When the user clicks on the Back button then it should get redirected to the Peer Selection - Select Target Comparative Peer Group Selection Screen
  	When the user hovers over the sliders in the Peer Comparison - Pricing and Peer Comparison - Cost To Serve chart, the corresponding value should be displayed
  	Then the user should be able to adjust the sliders in the Start Simulating - Pricing and Start Simulating - Cost To Serve charts to simulate the scenario
  	When the user clicks on the Reset button then the both the simulation chart updates to the initial state
  	Then the user should be able to adjust the sliders in the Start Simulating - Pricing and Start Simulating - Cost To Serve charts to simulate the scenario
  	And the user should be able to enter numeric values directly in the input fields, which should update the slider positions accordingly
 		And the user should be able to enter a scenario name in the Scenario Name field and click the Save and Show Impact button, which should redirect to the View Scenario Impact screen only if a name is entered
  	
  #DONE - Checked! - Back btn scripted but need to validated after redirection is resolved | Need to be validatedd and also filter is failing but on 27/07 it worked paritally
  #Create Scenario without simulation
  #Scenario: Verify that the user can create a scenario without performing simulation in the charts
  #	Given the user is on the Create Scenario Screen 
  #	When the user clicks on the Save and Show Impact button without entering a Scenario Name, an error message should be displayed
#	#25/07_ If a filter is clicked then not able to create the sceanrio   
  #	Then the user should be able to click on the Filters and perform actions such as Apply, Reset and Cancel based on requirements
  #Back buttton scripts are done but the redirection is not proper and reported to developers
   #When the user clicks on the Back button then it should get redirected to the Peer Selection - Select Target Comparative Peer Group Selection Screen
  #	And the user should be able to enter a scenario name in the Scenario Name field and click the Save and Show Impact button, which should redirect to the View Scenario Impact screen only if a name is entered
  	
  
 