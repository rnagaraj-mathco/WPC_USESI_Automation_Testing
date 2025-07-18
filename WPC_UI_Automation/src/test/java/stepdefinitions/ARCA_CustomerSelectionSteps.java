package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ARCA_CustomerSelectionPage;

public class ARCA_CustomerSelectionSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	ARCA_CustomerSelectionPage arca_customerSelectionPage = new ARCA_CustomerSelectionPage(driver);

	// Select One Customer for Simulation table
	// Select a customer record
	@Given("the user is on the Customer Selection screen")
	public void the_user_is_on_the_customer_selection_screen() throws IOException, InterruptedException {
		arca_customerSelectionPage.navigateTo();
	}

	@When("the user clicks on the Select Customer button without selecting a record then an error message should be displayed")
	public void the_user_clicks_on_the_select_customer_button_without_selecting_a_record_then_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.selectCustomerBtnWithoutSelection();
	}

	@Then("the user should be able to search for a keyword in the Select One Customer for Simulation table")
	public void the_user_should_be_able_to_search_for_a_keyword_in_the_select_one_customer_for_simulation_table()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.selectForKeywordSOC();
	}

	@When("the user clicks on the download icon present in the Select One Customer for Simulation table header, then the entire table records should be downloaded as an excel file")
	public void the_user_clicks_on_the_download_icon_present_in_the_select_one_customer_for_simulation_table_header_then_the_entire_table_records_should_be_downloaded_as_an_excel_file()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.downloadIconSOC();
	}

	@Then("the user should be able to select the customer from the Select One Customer for Simulation table")
	public void the_user_should_be_able_to_select_the_customer_from_the_select_one_customer_for_simulation_table()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.selectCustomerSOC();
	}

//	@Then("the user should be able to interact with the Rows per page dropdown of the Select One Customer for Simulation table to select a value, which updates the number of visible records")
//	public void the_user_should_be_able_to_interact_with_the_rows_per_page_dropdown_of_the_select_one_customer_for_simulation_table_to_select_a_value_which_updates_the_number_of_visible_records()
//			throws IOException, InterruptedException {
//		arca_customerSelectionPage.paginationSOC();
//	}

	@When("the user clicks on the Select Customer button then the corresponding commodity code gets displayed in the Select Root Cause Products for Simulation table only if a customer record is selected")
	public void the_user_clicks_on_the_select_customer_button_then_the_corresponding_commodity_code_gets_displayed_in_the_select_root_cause_products_for_simulation_table_only_if_a_customer_record_is_selected()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.selectCustomerBtnWithSelection();
	}

	@When("the user clicks on the Back button of the Select One Customer for Simulation table then it should redirect to the Filter Customer and Product Combinations screen")
	public void the_user_clicks_on_the_back_button_of_the_select_one_customer_for_simulation_table_then_it_should_redirect_to_the_filter_customer_and_product_combinations_screen()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.backBtnSOC();
	}

	@Given("the user should be able to zoom in and zoom out of the Select One Customer for Simulation table using the + and - icons")
	public void the_user_should_be_able_to_zoom_in_and_zoom_out_of_the_select_one_customer_for_simulation_table_using_the_and_icons()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.zoomOperationSOC();
	}

	@Given("the user should be able to click on the column filter icon to select which columns should be displayed in the Select One Customer for Simulation table")
	public void the_user_should_be_able_to_click_on_the_column_filter_icon_to_select_which_columns_should_be_displayed_in_the_select_one_customer_for_simulation_table()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.columnFiterOperationSOC();
	}

	@Then("user should be able to interact with the Rows per page dropdown of the Select One Customer for Simulation table and select a value, which updates the visible records")
	public void user_should_be_able_to_interact_with_the_rows_per_page_dropdown_of_the_select_one_customer_for_simulation_table_and_select_a_value_which_updates_the_visible_records()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.paginationSOC();
	}

	// Search and Select a customer record
	@Then("the user should be able to search for a customer record and select it in the Select One Customer for Simulation table")
	public void the_user_should_be_able_to_search_for_a_customer_record_and_select_it_in_the_select_one_customer_for_simulation_table()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.searchAndSelectRecordSOC();
	}

	// Select Root Cause Product for Simulation table
	// Select and Deselect the commodity code for the selected customer
	@When("the user clicks on the Save and Analyze button of Select Root Cause Product for Simulation table without selecting any commodity code then a Save and Proceed dialog screen appears with a warning message")
	public void the_user_clicks_on_the_save_and_analyze_button_of_select_root_cause_product_for_simulation_table_without_selecting_any_commodity_code_then_a_save_and_proceed_dialog_screen_appears_with_a_warning_message()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.saveAndAnalyzeBtnSRCP();
	}

	@When("the user clicks on the Back button of Select Root Cause Product for Simulation table then the screen should reload to the previous state displaying only Select Root Cause Products for Simulation table")
	public void the_user_clicks_on_the_back_button_of_select_root_cause_product_for_simulation_table_then_the_screen_should_reload_to_the_previous_state_displaying_only_select_root_cause_products_for_simulation_table()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.backBtnSRCP();
	}

	@When("the user should be able to click on the select all checkbox present in the header of Select Root Cause Product for Simulation table and all commodity code should be selected")
	public void the_user_should_be_able_to_click_on_the_select_all_checkbox_present_in_the_header_of_select_root_cause_product_for_simulation_table_and_all_commodity_code_should_be_selected()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.selectAllCheckboxSRCP();
	}

	@When("the user clicks on the Reset button then all the selected commodity codes should be cleared and the Select Root Cause Product for Simulation table should rever to its previous state")
	public void the_user_clicks_on_the_reset_button_then_all_the_selected_commodity_codes_should_be_cleared_and_the_select_root_cause_product_for_simulation_table_should_rever_to_its_previous_state()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.resetBtnSRCP();
	}

	@Then("the user should be able to select the commodity codes from Select Root Cause Product for Simulation table")
	public void the_user_should_be_able_to_select_the_commodity_codes_from_select_root_cause_product_for_simulation_table()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.selectCommoditySRCP();
	}

	@Then("the user should be able to deselect the commodity codes from Select Root Cause Product for Simulation table")
	public void the_user_should_be_able_to_deselect_the_commodity_codes_from_select_root_cause_product_for_simulation_table()
			throws IOException, InterruptedException {
		arca_customerSelectionPage.deSelectCommoditySRCP();
	}

	@Then("the user should be able to clicks on the Save and Analyze button of Select Root Cause Product for Simulation table then the Save and Proceed dialog screen should appear")
	public void the_user_should_be_able_to_clicks_on_the_save_and_analyze_button_of_select_root_cause_product_for_simulation_table_then_the_save_and_proceed_dialog_screen_should_appear() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to enter the name for the combination in the Save and Proceed dialog screen and click on the Proceed button then the user should be redirected to the Profit Bridge screen")
	public void the_user_should_be_able_to_enter_the_name_for_the_combination_in_the_save_and_proceed_dialog_screen_and_click_on_the_proceed_button_then_the_user_should_be_redirected_to_the_profit_bridge_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to zoom in and zoom out of the Select Root Cause Product for Simulation table using the + and - icons")
	public void the_user_should_be_able_to_zoom_in_and_zoom_out_of_the_select_root_cause_product_for_simulation_table_using_the_and_icons() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click on the column filter icon to select which columns should be displayed in the Select Root Cause Product for Simulation table")
	public void the_user_should_be_able_to_click_on_the_column_filter_icon_to_select_which_columns_should_be_displayed_in_the_select_root_cause_product_for_simulation_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user clicks on the download icon present in the Select Root Cause Product for Simulation table header, then the entire table records should be downloaded as an excel file")
	public void the_user_clicks_on_the_download_icon_present_in_the_select_root_cause_product_for_simulation_table_header_then_the_entire_table_records_should_be_downloaded_as_an_excel_file() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user should be able to interact with the Rows per page dropdown of the Select Root Cause Product for Simulation table and select a value, which updates the visible records")
	public void user_should_be_able_to_interact_with_the_rows_per_page_dropdown_of_the_select_root_cause_product_for_simulation_table_and_select_a_value_which_updates_the_visible_records() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Search, Select and Deselect the commodity code for the selected customer
	@Then("the user should be able to search for the commodity codes record and select the commodity code")
	public void the_user_should_be_able_to_search_for_the_commodity_codes_record_and_select_the_commodity_code() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to search for the commodity codes record and deselect the commodity code")
	public void the_user_should_be_able_to_search_for_the_commodity_codes_record_and_deselect_the_commodity_code() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
