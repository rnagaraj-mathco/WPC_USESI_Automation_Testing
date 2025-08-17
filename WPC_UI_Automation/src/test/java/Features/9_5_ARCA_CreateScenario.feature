@ARCA_CreateScenario
Feature: Land on the Create Scenario screen where the user will be able to create the scenario based on the simulation options

#DONE - Checked!
#--->Create scenario with default values
 #Scenario: Verify that the user is able to create a scenario without any simulations
  #Given the user is on the Create Scenario screen
  #Then the user clicks on the Filter and perform action such as Apply, Reset and Cancel on the Customer and Product combinations option
  #---Customer Details button
  #When the user clicks on the Customer Details button, a popup should appear titled Select Customer and Products Combination containing Selected Target Customer for Simulation and Selected Product for Root Cause Analysis table
  #---Create Scenario button
  #When the user clicks on the Create Scenario button,a scenario should be created with before and after comparison in the Estimated Impact widget
  #---Save Scenario button
  #Then the user clicks on the Save Scenario button without entering a Scenario name, an error should be dispalyed
  #When the user clicks on the Save Scenario button after entering a Scenario name, a success message should be displayed

 #--------------------------------#--------------------------------------------------------------#---------------------------

#DONE- Checked!
#--->Create Scenario based on the % Order change in Order $ Sales simulator
 #Scenario: Verify that the user is able to create a scenario using the % Order change in Order $ Sales simulator
  #Given the user is on the Create Scenario screen
  #Then the user clicks on the Filter and perform action such as Apply, Reset and Cancel on the Customer and Product combinations option
  #When the user clicks on the Customer Details button, a popup should appear titled Select Customer and Products Combination containing Selected Target Customer for Simulation and Selected Product for Root Cause Analysis table
 #	#---Moves the slider to create the scenario
  #And the user should be able to move the slider to Simulator Changes in Sales of the %Change in Order $ Sales simulator to view the Current Customer Sales(After Simulation)
  #When the user clicks on the Create Scenario button,a scenario should be created with before and after comparison in the Estimated Impact widget
  #Then the user clicks on the Reset Simulation button of the Pre-Programmed Scenario widget, which resets the simulator to its previous state
  #---Moves the slider again to visualize the simualtion and Reset Simulation of Estimated Impact widget
  #And the user is able to move again the slider to Simulator Changes in Sales of the %Change in Order $ Sales simulator again to view the Current Customer Sales(After Simulation)
  #When the user clicks on the Create Scenario button,a scenario should be created with before and after comparison in the Estimated Impact widget
  #Then the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state
  #---Enter the numeric value for Simualtion of the Pre-Programmed Scenario widget
  #And the user is able to enter the value in the numeric field of the %Change in Order $ Sales for simulation
  #---Clicks the Create Scenario button
  #When the user clicks on the Create Scenario button,a scenario should be created with before and after comparison in the Estimated Impact widget
  #---Download the chart
  #Then the user clicks on the download icon of the before simulation chart, which should download the chart as an image  
 #	Then the user clicks on the download icon of the after simulation, which should download the chart as an image
 #	#---Save Scenario button
 #	Then the user clicks on the Save Scenario button without entering a Scenario name, an error should be dispalyed
  #When the user clicks on the Save Scenario button after entering a Scenario name, a success message should be displayed
  #Then the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state
  #
 #----------------------------* Enforce Per Order charge *---------------------------
 
 #DONE - Checked!-Only that Error message validation is pending of the Estimated Widget
 #--->Create Scenario - Simulation using Enforce Per Order Charge
  #Scenario: Verify that the user is able to create a scenario using the Enforce Per Order Charge simulation
  #Given the user is on the Create Scenario screen
  #Then the user clicks on the Filter and perform action such as Apply, Reset and Cancel on the Customer and Product combinations option
  #When the user clicks on the Customer Details button, a popup should appear titled Select Customer and Products Combination containing Selected Target Customer for Simulation and Selected Product for Root Cause Analysis table
 #	
 #	#---Simulation - By entering both %Sales and Flat$ value - 
  #When the user enters both the %Sales and Flat$ value without selecting the Enforce Per Order Charge Simulation and click on Create Scenario button, then the scenario should not be created
 #	#-----><-- Below steps: selecting and entering both value is not validated as it is not mapping to the error messsage but script is correct
  #--Then the user should be able to select the Enforce Per Order Charge simulation and enter both the %Sales and Flat$ value, and click on Create Scenario button, then the scenario should not be created
  #Then the user clicks on the Reset Simulation button of the Pre-Programmed Scenario widget, which resets the simulator to its previous state
  #
  #---Simulation - By entering the %Sales value
 #	When the user enters the %Sales value without selecting the Enforce Per Charge Simulation and click on the Create Scenario button, then the scenario should not be created
  #Then the user should be able to select the Enforce Per Order Charge simulation and enter the %Sales value, click on the Create Scenario button, then the scenario should be created
  #---- This Error msg has to implemented but due to dev issue of error msg in estimated impact widget for now reset simulation of Pre- Programmed scenario widget
  #--Then the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state
  #Then the user clicks on the Reset Simulation button of the Pre-Programmed Scenario widget, which resets the simulator to its previous state
  #
  #---Simulation - By entering the Flat$ value
  #When the user enters the Flat$ value without selecting the Enforce Per Charge Simulation and click on Create Scenario button, then the scenario should not be created
  #Then the user should be able to select the Enfore Per Order Charge simulation and enter the Flat$ value, click on the Create Scenario button, then the scenario should be created
  #
  #---Download the chart
  #Then the user clicks on the download icon of the before simulation chart, which should download the chart as an image  
 #	Then the user clicks on the download icon of the after simulation, which should download the chart as an image
 #
 #	#---Save Scenario button
 #	Then the user clicks on the Save Scenario button without entering a Scenario name, an error should be dispalyed
  #When the user clicks on the Save Scenario button after entering a Scenario name, a success message should be displayed
 #	#--- Reset Simulation - Estimated Impact - To enable the next scenario
  #Then the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state
  
#----------------------------* Enforce Per Return Surcharge *---------------------------
  
 #DONE - Only that Error message validation is pending of the Estimated Widget
 #--->Create Scenario - Simulation using Enforce Per Return Surcharge
 #Scenario: Verify that the user is able to create a scenario using the Enforce Per Return Surcharge simulation
#	Given the user is on the Create Scenario screen
#	Then the user clicks on the Filter and perform action such as Apply, Reset and Cancel on the Customer and Product combinations option
#	When the user clicks on the Customer Details button, a popup should appear titled Select Customer and Products Combination containing Selected Target Customer for Simulation and Selected Product for Root Cause Analysis table
 #	
 #	#---Simulation - By entering both %Sales and Flat$ value
 #	When the user enters both the %Sales and Flat$ value without selecting the Enforce Per Return Surcharge Simulation and click on Create Scenario button, then the scenario should not be created
  #------><-----Need to script for this case
 #	#--Then the user should be able to select the Enforce Per Return Surcharge simulation and enter both the %Sales and Flat$ value, and click on Create Scenario button, then the scenario should not be created
 #	Then the user clicks on the Reset Simulation button of the Pre-Programmed Scenario widget, which resets the simulator to its previous state
  #
 #	#---Simulation - By entering the %Sales value
 #	When the user enters the %Sales value without selecting the Enforce Per Return Surcharge Simulation and click on the Create Scenario button, then the scenario should not be created
  #Then the user should be able to select the Enforce Per Return Surcharge simulation and enter the %Sales value, click on the Create Scenario button, then the scenario should be created
  #Then the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state
  #
  #---Simulation - By entering the Flat$ value
  #When the user enters the Flat$ value without selecting the Enforce Per Return Surcharge Simulation and click on Create Scenario button, then the scenario should not be created
  #Then the user should be able to select the Enfore Per Return Surcharge simulation and enter the Flat$ value, click on the Create Scenario button, then the scenario should be created
 #
  #---Download the chart
  #Then the user clicks on the download icon of the before simulation chart, which should download the chart as an image  
 #	Then the user clicks on the download icon of the after simulation, which should download the chart as an image
 #
 #	#---Save Scenario button
 #	Then the user clicks on the Save Scenario button without entering a Scenario name, an error should be dispalyed
  #When the user clicks on the Save Scenario button after entering a Scenario name, a success message should be displayed
 #	
 #	#--- Reset Simulation - Estimated Impact - To enable the next scenario
  #Then the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state
  #
  #----------------------------* Eliminate System Pricing Overrides *---------------------------
  
  #DONE - Checked!
 #	#--->Create Scenario - Simulation using Eliminate System Pricing Overrides Surcharge
 #Scenario: Verify that the user is able to create a scenario using the Eliminate System Pricing Overrides simulation
  #Given the user is on the Create Scenario screen
  #Then the user clicks on the Filter and perform action such as Apply, Reset and Cancel on the Customer and Product combinations option
  #When the user clicks on the Customer Details button, a popup should appear titled Select Customer and Products Combination containing Selected Target Customer for Simulation and Selected Product for Root Cause Analysis table
 #	#---Simulation - By toggling
 #	#Need to validate as The same issue of error messsage is present
 #	When the user toggles the Eliminate System Pricing Overrides Surcharge without selecting it and clicks on create sceanrio button, then the scenario should not be created
 #	#---Simulation - By selecting
 #	When the user selects the Eliminate System Pricing Overrides Surcharge without toggling it and clicks on create sceanrio button, then the scenario should not be created
 #	#---Simulation - By toggling and selecting
 #	Then the user selects and toggles the Eliminate System Pricing Overrides Surcharge, and clicks on create sceanrio button, then the scenario should be created
 #---Download the chart
  #Then the user clicks on the download icon of the before simulation chart, which should download the chart as an image  
 #	Then the user clicks on the download icon of the after simulation, which should download the chart as an image
 #	#---Save Scenario button
 #	Then the user clicks on the Save Scenario button without entering a Scenario name, an error should be dispalyed
  #When the user clicks on the Save Scenario button after entering a Scenario name, a success message should be displayed
 #	#--- Reset Simulation - Estimated Impact - To enable the next scenario
 #	Then the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state

#----------------------------* Move to A New Price Class *---------------------------
 #DONE - Checked!
 #	#--->Create Scenario - Simulation using Move To A New Customer Price Class
 Scenario: Verify that the user is able to create a scenario using the Move To A New Customer Price Class simulation
  Given the user is on the Create Scenario screen
  Then the user clicks on the Filter and perform action such as Apply, Reset and Cancel on the Customer and Product combinations option
  When the user clicks on the Customer Details button, a popup should appear titled Select Customer and Products Combination containing Selected Target Customer for Simulation and Selected Product for Root Cause Analysis table
  #---Simulation - By clicking the dropdown and selecting the price class
  When the user clicks on the dropdown of Move To A New Customer Price Class and selects a price class without selecting it, and clicks on create sceanrio button, then the scenario should not be created
 	#---Simulation - By selecting
  When the user clicks selects the Move To A New Customer Price Class but does not select a price class from the dropdown, and clicks on create sceanrio button, then the scenario should not be created
 	#---Simulation - By clicking the dropdown and selecting the price class and Selecting 
 	Then the user selects the Move To A New Customer Price Class and selects a price class from the dropdown, and clicks on create sceanrio button, then the scenario should be created
  #---Download the chart
  Then the user clicks on the download icon of the before simulation chart, which should download the chart as an image  
 	Then the user clicks on the download icon of the after simulation, which should download the chart as an image
 	#---Save Scenario button
 	Then the user clicks on the Save Scenario button without entering a Scenario name, an error should be dispalyed
  When the user clicks on the Save Scenario button after entering a Scenario name, a success message should be displayed
 	#--- Reset Simulation - Estimated Impact - To enable the next scenario
 	Then the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state
  
  