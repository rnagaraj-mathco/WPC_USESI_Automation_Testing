package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CPA_ViewScenarioImpactPage;

public class CPA_ViewScenarioImpactSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	CPA_ViewScenarioImpactPage cpa_viewScenarioImpact = new CPA_ViewScenarioImpactPage(driver);

	@Given("the user is on the View Scenario Impact screen")
	public void the_user_is_on_the_view_scenario_impact_screen() throws IOException, InterruptedException {
		cpa_viewScenarioImpact.navigateTo();
	}

	@Then("the user should be able to click on the Back button, which then redirects to the Create Scenario screen")
	public void the_user_should_be_able_to_click_on_the_back_button_which_then_redirects_to_the_create_scenario_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the After button,the chart is displayed shoul be displayed with simulated values")
	public void the_user_clicks_on_the_after_button_the_chart_is_displayed_shoul_be_displayed_with_simulated_values() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks on the Comparison button, which should display a table showing the differences between the default and simulated scenario values")
	public void the_user_clicks_on_the_comparison_button_which_should_display_a_table_showing_the_differences_between_the_default_and_simulated_scenario_values() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user should be able to search for a keyword in the Comparison table")
	public void the_user_should_be_able_to_search_for_a_keyword_in_the_comparison_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user should be able to click the download icon in the Comparison table header to download the table records as an Excel file")
	public void the_user_should_be_able_to_click_the_download_icon_in_the_comparison_table_header_to_download_the_table_records_as_an_excel_file() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user should be able to zoom in and out of the Comparison table using the + and - icons")
	public void the_user_should_be_able_to_zoom_in_and_out_of_the_comparison_table_using_the_and_icons() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click the column filter icon to select which columns should be displayed in the Comparison table")
	public void the_user_should_be_able_to_click_the_column_filter_icon_to_select_which_columns_should_be_displayed_in_the_comparison_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks the Back button, the chart should update with the default scenario values")
	public void the_user_clicks_the_back_button_the_chart_should_update_with_the_default_scenario_values() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("the user should be able to click on the Reset button, which redirects the the user to the Branch\\/Customer Selection screen")
	public void the_user_should_be_able_to_click_on_the_reset_button_which_redirects_the_the_user_to_the_branch_customer_selection_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
