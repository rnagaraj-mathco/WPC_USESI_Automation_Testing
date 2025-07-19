package stepdefinitions;

import java.io.IOException;

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
	ARCA_ProfitBridgePage arca_profitBridgePage = new ARCA_ProfitBridgePage(driver);

	// View the Pricing and Profit Bridge chart
	@Given("the user is on the Profit Bridge screen")
	public void the_user_is_on_the_profit_bridge_screen() throws IOException, InterruptedException {
		arca_profitBridgePage.navigateTo();
	}

	@Then("the user clicks on the Filters and perform actions such as Apply, Reset and Cancel on the available options")
	public void the_user_clicks_on_the_filters_and_perform_actions_such_as_apply_reset_and_cancel_on_the_available_options()
			throws IOException, InterruptedException {
		arca_profitBridgePage.filters();
	}

	@Then("the user clicks on the camera icon above the Profit Bridge chart to download the chart")
	public void the_user_clicks_on_the_camera_icon_above_the_profit_bridge_chart_to_download_the_chart()
			throws IOException, InterruptedException {
		arca_profitBridgePage.downloadIcon();
	}

	@When("the user clicks on the Back button then it should get redirected to the Customer Selection screen where the Select One Customer for Simulation table is present")
	public void the_user_clicks_on_the_back_button_then_it_should_get_redirected_to_the_customer_selection_screen_where_the_select_one_customer_for_simulation_table_is_present()
			throws IOException, InterruptedException {
		arca_profitBridgePage.backBtn();
	}

	@Then("the user clicks on the Go to Simulator button which should redirect to the Create Scenario screen for scenario creation")
	public void the_user_clicks_on_the_go_to_simulator_button_which_should_redirect_to_the_create_scenario_screen_for_scenario_creation()
			throws IOException, InterruptedException {
		arca_profitBridgePage.goToSimulatorBtn();
	}

}
