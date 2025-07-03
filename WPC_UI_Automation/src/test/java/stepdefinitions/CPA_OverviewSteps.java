package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CPA_OverviewPage;

public class CPA_OverviewSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	CPA_OverviewPage cpa_overviewPage = new CPA_OverviewPage(driver);

	// Start New Peer Analysis Button Scenario

	@Given("the user is on the Overview page of the Customer Peer Analysis")
	public void the_user_is_on_the_overview_page_of_the_customer_peer_analysis()
			throws IOException, InterruptedException {
		// Gets driver instance and confirms that driver is initialized
		System.out.println("DEBUG DRIVER INSTANCE: " + DriverFactory.getDriver());
		cpa_overviewPage.navigateTo();
	}

	@Then("the user should be able to click on the Start New Peer Analysis button and get redirected to the Branch\\/Customer Selection screen")
	public void the_user_should_be_able_to_click_on_the_start_new_peer_analysis_button_and_get_redirected_to_the_branch_customer_selection_screen()
			throws IOException, InterruptedException {
		cpa_overviewPage.startnewpeeranalysisbtn();
	}

	// Saved Customer Peer Selections-Selecting a Peer Selection record from the
	// table

	@Then("the user should be able to search for a keyword in the Saved Customer Peer Selection table")
	public void the_user_should_be_able_to_search_for_a_keyword_in_the_saved_customer_peer_selection_table()
			throws IOException, InterruptedException {
		cpa_overviewPage.searchForKeyword_SCP();
	}

	@Then("the user should be able to click on the Create Sensitivity Scenario button and get redirected to the Create Scenario screen only if one record from the Saved Customer Peer Selection table is selected")
	public void the_user_should_be_able_to_click_on_the_create_sensitivity_scenario_button_and_get_redirected_to_the_create_scenario_screen_only_if_one_record_from_the_saved_customer_peer_selection_table_is_selected()
			throws IOException, InterruptedException {
		cpa_overviewPage.createSensitivityScenarioBtnWithSelection();
	}

	@When("the user clicks on the Create Sensitivity Scenario button without selecting any records, an error message should be displayed")
	public void the_user_clicks_on_the_create_sensitivity_scenario_button_without_selecting_any_records_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		cpa_overviewPage.createSensitivityScenarioBtnWithoutSelection();
//	    if (!cpa_overviewPage.isErrorMessageVisible()) {
//            throw new AssertionError("Error message not shown when the Create Sensitivity Scenario Button is clicked without selecting the record.");
//        }
	}

	@When("the user should be able to click on the Edit button of any record of the Saved Customer Peer Selection table, which then redirects to the Peer Selection screen")
	public void the_user_should_be_able_to_click_on_the_edit_button_of_any_record_of_the_saved_customer_peer_selection_table_which_then_redirects_to_the_peer_selection_screen()
			throws IOException, InterruptedException {
		cpa_overviewPage.editButtonPeerSelections();
	}

	@When("the user clicks on the delete dropdown of the Saved Customer Peer Selection table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon")
	public void the_user_clicks_on_the_delete_dropdown_of_the_saved_customer_peer_selection_table_then_should_get_options_and_if_the_delete_is_selected_then_that_record_should_get_deleted_after_clicking_on_the_delete_icon()
			throws IOException, InterruptedException {
		cpa_overviewPage.deleteDropdownPeerSelections();
	}

	@When("the user clicks on the delete icon of the Saved Customer Peer Selection table without selecting Delete option from the dropdown, an error message should be displayed")
	public void the_user_clicks_on_the_delete_icon_of_the_saved_customer_peer_selection_table_without_selecting_delete_option_from_the_dropdown_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		cpa_overviewPage.deleteIconPeerSelections();
	}

	@When("the user clicks the download icon of a record in the Saved Customer Peer Selection table, the corresponding Peer Selection should be downloaded as an Excel file")
	public void the_user_clicks_the_download_icon_of_a_record_in_the_saved_customer_peer_selection_table_the_corresponding_peer_selection_should_be_downloaded_as_an_excel_file()
			throws IOException, InterruptedException {
		cpa_overviewPage.downloadIconPeerSelections();
	}

	@Then("the user should be able to interact with the Rows per page dropdown of the Saved Customer Peer Selection table to select a value, which updates the number of visible records")
	public void the_user_should_be_able_to_interact_with_the_rows_per_page_dropdown_of_the_saved_customer_peer_selection_table_to_select_a_value_which_updates_the_number_of_visible_records()
			throws IOException, InterruptedException {
		cpa_overviewPage.paginationPeerSelection();
	}

	// Saved Customer Peer Selections - Search and Select the Peer Selection record
	// from table
	@Then("the user should be able to search for a record and select it in the Saved Customer Peer Selection table")
	public void the_user_should_be_able_to_search_for_a_record_and_select_it_in_the_saved_customer_peer_selection_table()
			throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		cpa_overviewPage.searchForRecord_SCP();
	}

	// Saved Sensitivity Simulation Scenario - Selecting a Sensitivity Simulation
	// Scenario record from the table

	@Then("the user should be able to search for a keyword in the Saved Sensitivity Simulation Scenario table")
	public void the_user_should_be_able_to_search_for_a_keyword_in_the_saved_sensitivity_simulation_scenario_table()
			throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		cpa_overviewPage.searchForKeyword_SSS();
	}

	@Then("the user should be able to click on the View Impact button and get redirected to the View Scenario Impact screen only if any one record from the Saved Sensitivity Simulation scenario table is selected")
	public void the_user_should_be_able_to_click_on_the_view_impact_button_and_get_redirected_to_the_view_scenario_impact_screen_only_if_any_one_record_from_the_saved_sensitivity_simulation_scenario_table_is_selected()
			throws IOException, InterruptedException {
		cpa_overviewPage.viewImpactBtnWithSelection();
	}

	@When("the user clicks on the View Impact button without selecting any records, an error message should be displayed")
	public void the_user_clicks_on_the_view_impact_button_without_selecting_any_records_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		cpa_overviewPage.viewImpactBtnWithOutSelection();
	}

	@When("the user should be able to click on the Edit button for any one record of the Saved Sensitivity Simulation Scenario table, which then redirects to the Create Scenario screen")
	public void the_user_should_be_able_to_click_on_the_edit_button_for_any_one_record_of_the_saved_sensitivity_simulation_scenario_table_which_then_redirects_to_the_create_scenario_screen()
			throws IOException, InterruptedException {
		cpa_overviewPage.editButtonScenarioSelections();
	}

	@When("the user clicks on the delete dropdown of the Saved Sensitivity Simulation Scenario table, then should get options and if the Delete is selected then that record should get deleted after clicking on the delete icon")
	public void the_user_clicks_on_the_delete_dropdown_of_the_saved_sensitivity_simulation_scenario_table_then_should_get_options_and_if_the_delete_is_selected_then_that_record_should_get_deleted_after_clicking_on_the_delete_icon()
			throws IOException, InterruptedException {
		cpa_overviewPage.deleteDropdownScenarioSelections();
	}

	@When("the user clicks on the delete icon of the Saved Sensitivity Simulation Scenario table without selecting Delete option from the dropdown, an error message should be displayed")
	public void the_user_clicks_on_the_delete_icon_of_the_saved_sensitivity_simulation_scenario_table_without_selecting_delete_option_from_the_dropdown_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		cpa_overviewPage.deleteIconScenarioSelections();
	}

	@When("the user clicks the download icon of a record in the Saved Sensitivity Simulation Scenario table, the corresponding Sensitivity Simulation scenario should be downloaded as an Excel file")
	public void the_user_clicks_the_download_icon_of_a_record_in_the_saved_sensitivity_simulation_scenario_table_the_corresponding_sensitivity_simulation_scenario_should_be_downloaded_as_an_excel_file()
			throws IOException, InterruptedException {
		cpa_overviewPage.downloadIconScenarioSelections();
	}

	@Then("the user should be able to interact with the Rows per page dropdown of the Saved Sensitivity Simulation table to select a value, which updates the number of visible records")
	public void the_user_should_be_able_to_interact_with_the_rows_per_page_dropdown_of_the_saved_sensitivity_simulation_table_to_select_a_value_which_updates_the_number_of_visible_records() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Saved Sensitivity Simulation Scenario - Search and Select the Peer Selection
	// record --- Pending
	@Then("the user should be able to search for a record and select it in the Saved Sensitivity Simulation Scenario table")
	public void the_user_should_be_able_to_search_for_a_record_and_select_it_in_the_saved_sensitivity_simulation_scenario_table()
			throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		cpa_overviewPage.searchForRecord_SSS();
	}

}
