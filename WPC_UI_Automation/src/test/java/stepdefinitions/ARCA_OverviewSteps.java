package stepdefinitions;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CPA_OverviewPage;

public class ARCA_OverviewSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	CPA_OverviewPage cpa_overviewPage = new CPA_OverviewPage(driver);

	// Choosing the Metric
	@Given("the user is on the Overview screen of the Auto Root Cause Analysis")
	public void the_user_is_on_the_overview_screen_of_the_auto_root_cause_analysis() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to select any one of the following metrics: Returns Handling and Freight Costs, All Tier {int} Costs, or Cost to Serve \\(Tiers {int}–{int})")
	public void the_user_should_be_able_to_select_any_one_of_the_following_metrics_returns_handling_and_freight_costs_all_tier_costs_or_cost_to_serve_tiers(
			Integer int1, Integer int2, Integer int3) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click the View Saved Scenarios button, which should then load the screen with the Saved Customer Product Combinations and Saved Scenario Simulations tables")
	public void the_user_should_be_able_to_click_the_view_saved_scenarios_button_which_should_then_load_the_screen_with_the_saved_customer_product_combinations_and_saved_scenario_simulations_tables() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Saved Customer Product Combinations table - Selecting a record from the table
	@Then("the user should be able to search for a keyword in the Saved Customer Product Combinations table")
	public void the_user_should_be_able_to_search_for_a_keyword_in_the_saved_customer_product_combinations_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click the Create New Scenario button and get redirected to the Create Scenario screen only if one record from the Saved Customer Product Combinations table is selected")
	public void the_user_should_be_able_to_click_the_create_new_scenario_button_and_get_redirected_to_the_create_scenario_screen_only_if_one_record_from_the_saved_customer_product_combinations_table_is_selected() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Create New Scenario button without selecting any records, an error message should be displayed")
	public void the_user_clicks_the_create_new_scenario_button_without_selecting_any_records_an_error_message_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user should be able to click the Edit button of any record in the Saved Customer Product Combinations table, which then redirects to the Customer Selection screen")
	public void the_user_should_be_able_to_click_the_edit_button_of_any_record_in_the_saved_customer_product_combinations_table_which_then_redirects_to_the_customer_selection_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the delete dropdown of the Saved Customer Product Combinations table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon")
	public void the_user_clicks_on_the_delete_dropdown_of_the_saved_customer_product_combinations_table_then_should_get_options_and_if_the_delete_is_selected_then_that_record_should_get_deleted_after_clicking_on_the_delete_icon() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the delete icon of the Saved Customer Product Combinations table without selecting Delete option from the dropdown, an error message should be displayed")
	public void the_user_clicks_on_the_delete_icon_of_the_saved_customer_product_combinations_table_without_selecting_delete_option_from_the_dropdown_an_error_message_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the download icon of a record in the Saved Customer Product Combinations table, the corresponding Customer Product Combinations should be downloaded as an Excel file")
	public void the_user_clicks_the_download_icon_of_a_record_in_the_saved_customer_product_combinations_table_the_corresponding_customer_product_combinations_should_be_downloaded_as_an_excel_file() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to interact with the Rows per page dropdown of the Saved Customer Product Combinations table to select a value, which updates the number of visible records")
	public void the_user_should_be_able_to_interact_with_the_rows_per_page_dropdown_of_the_saved_customer_product_combinations_table_to_select_a_value_which_updates_the_number_of_visible_records() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Saved Customer Product Combinations table - Search and Select a record from
	// the table
	@Then("the user should be able to search for a record and select it in the Saved Customer Product Combinations table")
	public void the_user_should_be_able_to_search_for_a_record_and_select_it_in_the_saved_customer_product_combinations_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Saved Scenario Simulations table - Selecting a record from the table
	@Then("the user should be able to search for a keyword in the Saved Scenario Simulations table")
	public void the_user_should_be_able_to_search_for_a_keyword_in_the_saved_scenario_simulations_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click the View Impact button, which opens a dialog box displaying the impact chart for the selected scenario, only if one record from the table is selected")
	public void the_user_should_be_able_to_click_the_view_impact_button_which_opens_a_dialog_box_displaying_the_impact_chart_for_the_selected_scenario_only_if_one_record_from_the_table_is_selected() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the View Impact button without selecting any records, a dialog box with an error message should be displayed")
	public void the_user_clicks_the_view_impact_button_without_selecting_any_records_a_dialog_box_with_an_error_message_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user should be able to click the Edit button of any record in the Saved Scenario Simulations table, which then redirects to the Create Scenario screen")
	public void the_user_should_be_able_to_click_the_edit_button_of_any_record_in_the_saved_scenario_simulations_table_which_then_redirects_to_the_create_scenario_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the delete dropdown of the Saved Scenario Simulations table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon")
	public void the_user_clicks_on_the_delete_dropdown_of_the_saved_scenario_simulations_table_then_should_get_options_and_if_the_delete_is_selected_then_that_record_should_get_deleted_after_clicking_on_the_delete_icon() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the delete icon of the Saved Scenario Simulations table without selecting Delete option from the dropdown, an error message should be displayed")
	public void the_user_clicks_on_the_delete_icon_of_the_saved_scenario_simulations_table_without_selecting_delete_option_from_the_dropdown_an_error_message_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the download icon of a record in the Saved Scenario Simulations table, the corresponding Customer Product Combinations should be downloaded as an Excel file")
	public void the_user_clicks_the_download_icon_of_a_record_in_the_saved_scenario_simulations_table_the_corresponding_customer_product_combinations_should_be_downloaded_as_an_excel_file() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to interact with the Rows per page dropdown of the Saved Scenario Simulations table to select a value, which updates the number of visible records")
	public void the_user_should_be_able_to_interact_with_the_rows_per_page_dropdown_of_the_saved_scenario_simulations_table_to_select_a_value_which_updates_the_number_of_visible_records() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Saved Scenario Simulations table - Search and Select a record from the table
	@Then("the user should be able to search for a record and select it in the Saved Scenario Simulations table")
	public void the_user_should_be_able_to_search_for_a_record_and_select_it_in_the_saved_scenario_simulations_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
