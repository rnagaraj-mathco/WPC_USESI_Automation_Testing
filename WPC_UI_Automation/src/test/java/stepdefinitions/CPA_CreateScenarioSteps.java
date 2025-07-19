package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CPA_CreateScenarioPage;

public class CPA_CreateScenarioSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	CPA_CreateScenarioPage cpa_createScenarioPage = new CPA_CreateScenarioPage(driver);

	// STEPS

	@Given("the user is on the Create Scenario Screen")
	public void the_user_is_on_the_create_scenario_screen() throws IOException, InterruptedException {
		cpa_createScenarioPage.navigateTo();
	}

	@When("the user clicks on the Save and Show Impact button without entering a Scenario Name, an error message should be displayed")
	public void the_user_clicks_on_the_save_and_show_impact_button_without_entering_a_scenario_name_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		cpa_createScenarioPage.saveAndShowImpactBtnWithoutName();
	}

	@Then("the user should be able to click on the Filters and perform actions such as Apply, Reset and Cancel based on requirements")
	public void the_user_should_be_able_to_click_on_the_filters_and_perform_actions_such_as_Apply_Reset_and_Cancel_based_on_requirements()
			throws IOException, InterruptedException {
		cpa_createScenarioPage.filters();
	}

	@When("the user clicks on the Back button then it should get redirected to the Peer Selection - Select Target Comparative Peer Group Selection Screen")
	public void the_user_clicks_on_the_back_button_then_it_should_get_redirected_to_the_peer_selection_select_target_comparative_peer_group_selection_screen()
			throws IOException, InterruptedException {
		cpa_createScenarioPage.backBtn();
	}

	@When("the user hovers over the sliders in the Peer Comparison - Pricing and Peer Comparison - Cost To Serve chart, the corresponding value should be displayed")
	public void the_user_hovers_over_the_sliders_in_the_peer_comparison_pricing_and_peer_comparison_cost_to_serve_chart_the_corresponding_value_should_be_displayed()
			throws IOException, InterruptedException {
		cpa_createScenarioPage.hoversSlider();
	}

	@Then("the user should be able to adjust the sliders in the Start Simulating - Pricing and Start Simulating - Cost To Serve charts to simulate the scenario")
	public void the_user_should_be_able_to_adjust_the_sliders_in_the_start_simulating_pricing_and_start_simulating_cost_to_serve_charts_to_simulate_the_scenario()
			throws IOException, InterruptedException {
		cpa_createScenarioPage.adjustSlider();
	}

	@When("the user clicks on the Reset button then the both the simulation chart updates to the initial state")
	public void the_user_clicks_on_the_reset_button_then_the_both_the_simulation_chart_updates_to_the_initial_state()
			throws IOException, InterruptedException {
		cpa_createScenarioPage.resetBtn();
	}

	@Then("the user should be able to enter numeric values directly in the input fields, which should update the slider positions accordingly")
	public void the_user_should_be_able_to_enter_numeric_values_directly_in_the_input_fields_which_should_update_the_slider_positions_accordingly()
			throws IOException, InterruptedException {
		cpa_createScenarioPage.numericValues();
	}

	@Then("the user should be able to enter a scenario name in the Scenario Name field and click the Save and Show Impact button, which should redirect to the View Scenario Impact screen only if a name is entered")
	public void the_user_should_be_able_to_enter_a_scenario_name_in_the_scenario_name_field_and_click_the_save_and_show_impact_button_which_should_redirect_to_the_view_scenario_impact_screen_only_if_a_name_is_entered()
			throws IOException, InterruptedException {
		cpa_createScenarioPage.saveAndShowImpactBtnWithName();
	}

}
