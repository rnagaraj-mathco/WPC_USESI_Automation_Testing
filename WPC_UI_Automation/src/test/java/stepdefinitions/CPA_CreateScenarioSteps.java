package stepdefinitions;

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
	CPA_CreateScenarioPage cpa_createScenario = new CPA_CreateScenarioPage(driver);

	@Given("the user is on the Create Scenario Screen")
	public void the_user_is_on_the_create_scenario_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to open the Filters and select the previously created customer + peer group name, which should then load on the screen")
	public void the_user_should_be_able_to_open_the_filters_and_select_the_previously_created_customer_peer_group_name_which_should_then_load_on_the_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user hovers over the sliders in the Peer Comparison - Pricing and Peer Comparison - Cost To Serve chart, then the corresponding value should be displayed")
	public void the_user_hovers_over_the_sliders_in_the_peer_comparison_pricing_and_peer_comparison_cost_to_serve_chart_then_the_corresponding_value_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to adjust the sliders in the Start Simulating - Pricing and Start Simulating - Cost To Serve charts to simulate the scenario")
	public void the_user_should_be_able_to_adjust_the_sliders_in_the_start_simulating_pricing_and_start_simulating_cost_to_serve_charts_to_simulate_the_scenario() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to enter numeric values directly in the input fields, which should update the slider positions accordingly")
	public void the_user_should_be_able_to_enter_numeric_values_directly_in_the_input_fields_which_should_update_the_slider_positions_accordingly() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to enter a scenario name in the Scenario Name field and click the Save and Show Impact button")
	public void the_user_should_be_able_to_enter_a_scenario_name_in_the_scenario_name_field_and_click_the_save_and_show_impact_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the View Scenario Impact screen, only if a scenario name is provided")
	public void the_user_should_be_redirected_to_the_view_scenario_impact_screen_only_if_a_scenario_name_is_provided() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Save and Show Impact button without entering the Scenario Name, an error message should get displayed")
	public void the_user_clicks_on_the_save_and_show_impact_button_without_entering_the_scenario_name_an_error_message_should_get_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Back button then the user should get redirected to the Peer Selection - Select Target Comparative Peer Group Selection Screen")
	public void the_user_clicks_on_the_back_button_then_the_user_should_get_redirected_to_the_peer_selection_select_target_comparative_peer_group_selection_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Reset button then the both the simulation chart updates to the initial state")
	public void the_user_clicks_on_the_reset_button_then_the_both_the_simulation_chart_updates_to_the_initial_state() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
