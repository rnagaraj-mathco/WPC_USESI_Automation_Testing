package stepdefinitions;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ARCA_ProfitBridgePage;

public class ARCA_ProfitBridgeSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	ARCA_ProfitBridgePage arca_ProfitBridgePage = new ARCA_ProfitBridgePage(driver);

	// View the Pricing and Profit Bridge chart

	@Given("the user is on the Profit Bridge screen")
	public void the_user_is_on_the_profit_bridge_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Filters button it displays the Selected Customer Metric and Customer and Product\\(s) combination options")
	public void the_user_clicks_on_the_filters_button_it_displays_the_selected_customer_metric_and_customer_and_product_s_combination_options() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click on the Filter - Selected Customer Metric option and select the required Cost Metic value")
	public void the_user_should_be_able_to_click_on_the_filter_selected_customer_metric_option_and_select_the_required_cost_metic_value() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click on the Filter - Customer and Product\\(s) combination option and select the required Combination")
	public void the_user_should_be_able_to_click_on_the_filter_customer_and_product_s_combination_option_and_select_the_required_combination() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click on the Filter - Apply button which updates the chart as per the changed selections")
	public void the_user_should_be_able_to_click_on_the_filter_apply_button_which_updates_the_chart_as_per_the_changed_selections() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Filter - Reset button then the option selection should be revereted back to its previous state")
	public void the_user_clicks_on_the_filter_reset_button_then_the_option_selection_should_be_revereted_back_to_its_previous_state() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Filter - Cancel button then the options should disappear and there should not be any changes in both charts")
	public void the_user_clicks_on_the_filter_cancel_button_then_the_options_should_disappear_and_there_should_not_be_any_changes_in_both_charts() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the camera icon present above the Profit Bridge chart then the chart should be downloaded")
	public void the_user_clicks_on_the_camera_icon_present_above_the_profit_bridge_chart_then_the_chart_should_be_downloaded() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Back then it should get redirected to the Customer Selection screen where the Select Root Cause Product for Simulation table is present")
	public void the_user_clicks_on_the_back_then_it_should_get_redirected_to_the_customer_selection_screen_where_the_select_root_cause_product_for_simulation_table_is_present() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user clicks on the Go to Simulator button which should redirect the user to the Create Scenario screen for scenario creation")
	public void the_user_clicks_on_the_go_to_simulator_button_which_should_redirect_the_user_to_the_create_scenario_screen_for_scenario_creation() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
