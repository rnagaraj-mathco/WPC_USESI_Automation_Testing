package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ARCA_CreateScenarioPage;

public class ARCA_CreateScenarioSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	ARCA_CreateScenarioPage arca_createScenarioPage = new ARCA_CreateScenarioPage(driver);

	// --->Create scenario with default values
	@Given("the user is on the Create Scenario screen")
	public void the_user_is_on_the_create_scenario_screen() throws IOException, InterruptedException {
		arca_createScenarioPage.navigateTo();
	}

	@Then("the user clicks on the Filter and perform action such as Apply, Reset and Cancel on the Customer and Product combinations option")
	public void the_user_clicks_on_the_filter_and_perform_action_such_as_apply_reset_and_cancel_on_the_customer_and_product_combinations_option()
			throws IOException, InterruptedException {
		arca_createScenarioPage.filters();
	}

	@When("the user clicks on the Customer Details button, a popup should appear titled Select Customer and Products Combination containing Selected Target Customer for Simulation and Selected Product for Root Cause Analysis table")
	public void the_user_clicks_on_the_customer_details_button_a_popup_should_appear_titled_select_customer_and_products_combination_containing_selected_target_customer_for_simulation_and_selected_product_for_root_cause_analysis_table()
			throws IOException, InterruptedException {
		arca_createScenarioPage.customerDetailsBtn();
	}

	@When("the user clicks on the Create Scenario button,a scenario should be created with before and after comparison in the Estimated Impact widget")
	public void the_user_clicks_on_the_create_scenario_button_a_scenario_should_be_created_with_before_and_after_comparison_in_the_estimated_impact_widget()
			throws IOException, InterruptedException {
		arca_createScenarioPage.createScenarioBtn();
	}

	@Then("the user clicks on the Save Scenario button without entering a Scenario name, an error should be dispalyed")
	public void the_user_clicks_on_the_save_scenario_button_without_entering_a_scenario_name_an_error_should_be_dispalyed()
			throws IOException, InterruptedException {
		arca_createScenarioPage.saveScenarioWithoutNameBtn();
	}

	@When("the user clicks on the Save Scenario button after entering a Scenario name, a success message should be displayed")
	public void the_user_clicks_on_the_save_scenario_button_after_entering_a_scenario_name_a_success_message_should_be_displayed()
			throws IOException, InterruptedException {
		arca_createScenarioPage.saveScenarioWithNameBtn();
	}

	// Create Scenario based on the % Order change in Order $ Sales simulator

	@When("the user should be able to move the slider to Simulator Changes in Sales of the %Change in Order $ Sales simulator to view the Current Customer Sales\\(After Simulation)")
	public void the_user_should_be_able_to_move_the_slider_to_simulator_changes_in_sales_of_the_change_in_order_$_sales_simulator_to_view_the_current_customer_sales_after_simulation()
			throws IOException, InterruptedException {
		arca_createScenarioPage.moveSlider();
	}

	@Then("the user clicks on the Reset Simulation button of the Pre-Programmed Scenario widget, which resets the simulator to its previous state")
	public void the_user_clicks_on_the_reset_simulation_button_of_the_pre_programmed_scenario_widget_which_resets_the_simulator_to_its_previous_state()
			throws IOException, InterruptedException {
		arca_createScenarioPage.resetPPS();
	}

	@Then("the user is able to move again the slider to Simulator Changes in Sales of the %Change in Order $ Sales simulator again to view the Current Customer Sales\\(After Simulation)")
	public void the_user_is_able_to_move_again_the_slider_to_simulator_changes_in_sales_of_the_change_in_order_$_sales_simulator_again_to_view_the_current_customer_sales_after_simulation()
			throws IOException, InterruptedException {
		arca_createScenarioPage.moveSliderAgain();
	}

	@Then("the user clicks on the Reset Simulation button of the Estimated Impact widget, which reloads the screen to its previous state")
	public void the_user_clicks_on_the_reset_simulation_button_of_the_estimated_impact_widget_which_reloads_the_screen_to_its_previous_state()
			throws IOException, InterruptedException {
		arca_createScenarioPage.resetEI();
	}

	@Then("the user is able to enter the value in the numeric field of the %Change in Order $ Sales for simulation")
	public void the_user_is_able_to_enter_the_value_in_the_numeric_field_of_the_change_in_order_$_sales_for_simulation()
			throws IOException, InterruptedException {
		arca_createScenarioPage.enterValueSales();
	}

	@Then("the user clicks on the download icon of the before simulation chart, which should download the chart as an image")
	public void the_user_clicks_on_the_download_icon_of_the_before_simulation_chart_which_should_download_the_chart_as_an_image()
			throws IOException, InterruptedException {
		arca_createScenarioPage.downloadBefore();
	}

	@Then("the user clicks on the download icon of the after simulation, which should download the chart as an image")
	public void the_user_clicks_on_the_download_icon_of_the_after_simulation_which_should_download_the_chart_as_an_image()
			throws IOException, InterruptedException {
		arca_createScenarioPage.downloadAfter();
	}

	// --->Create Scenario - Simulation using Enforce Per Order Charge
	@When("the user enters both the %Sales and Flat$ value without selecting the Enforce Per Order Charge Simulation and click on Create Scenario button, then the scenario should not be created")
	public void the_user_enters_both_the_sales_and_flat$_value_without_selecting_the_enforce_per_order_charge_simulation_and_click_on_create_scenario_button_then_the_scenario_should_not_be_created()
			throws IOException, InterruptedException {
		arca_createScenarioPage.enterBothValueEPOC();
	}

	@Then("the user should be able to select the Enforce Per Order Charge simulation and enter both the %Sales and Flat$ value, and click on Create Scenario button, then the scenario should not be created")
	public void the_user_should_be_able_to_select_the_enforce_per_order_charge_simulation_and_enter_both_the_sales_and_flat$_value_and_click_on_create_scenario_button_then_the_scenario_should_not_be_created()
			throws IOException, InterruptedException {
		arca_createScenarioPage.selectAndenterBothValueEPOC();
	}

	@When("the user enters the %Sales value without selecting the Enforce Per Charge Simulation and click on the Create Scenario button, then the scenario should not be created")
	public void the_user_enters_the_sales_value_without_selecting_the_enforce_per_charge_simulation_and_click_on_the_create_scenario_button_then_the_scenario_should_not_be_created()
			throws IOException, InterruptedException {
		arca_createScenarioPage.enterSalesValueWithoutSelectingEPOC();
	}

	@Then("the user should be able to select the Enforce Per Order Charge simulation and enter the %Sales value, click on the Create Scenario button, then the scenario should be created")
	public void the_user_should_be_able_to_select_the_enforce_per_order_charge_simulation_and_enter_the_sales_value_click_on_the_Create_Scenario_button_then_the_scenario_should_be_created()
			throws IOException, InterruptedException {
		arca_createScenarioPage.enterSalesValueWithSelectingEPOC();
	}

	@When("the user enters the Flat$ value without selecting the Enforce Per Charge Simulation and click on Create Scenario button, then the scenario should not be created")
	public void the_user_enters_the_flat$_value_without_selecting_the_enforce_per_charge_simulation_and_click_on_create_scenario_button_then_the_scenario_should_not_be_created()
			throws IOException, InterruptedException {
		arca_createScenarioPage.enterFlatValueWithoutSelectingEPOC();
	}

	@Then("the user should be able to select the Enfore Per Order Charge simulation and enter the Flat$ value, click on the Create Scenario button, then the scenario should be created")
	public void the_user_should_be_able_to_select_the_enfore_per_order_charge_simulation_and_enter_the_flat$_value_click_on_the_Create_Scenario_button_then_the_scenario_should_be_created()
			throws IOException, InterruptedException {
		arca_createScenarioPage.enterFlatValueWithSelectingEPOC();
	}

}
