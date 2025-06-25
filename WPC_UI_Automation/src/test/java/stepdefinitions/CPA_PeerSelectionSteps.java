package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CPA_PeerSelectionPage;

public class CPA_PeerSelectionSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	CPA_PeerSelectionPage cpa_peerSelections = new CPA_PeerSelectionPage(driver);

	@Given("the user is on the Peer Selection page of the Customer Peer Analysis")
	public void the_user_is_on_the_peer_selection_page_of_the_customer_peer_analysis()
			throws IOException, InterruptedException {
		System.out.println("DEBUG DRIVER INSTANCE: " + DriverFactory.getDriver());
		cpa_peerSelections.navigateTo();
	}

	@Then("the user should be able to search for a keyword in the Select Target Customer for Peer Matching table")
	public void the_user_should_be_able_to_search_for_a_keyword_in_the_select_target_customer_for_peer_matching_table()
			throws IOException, InterruptedException {
		cpa_peerSelections.searchForKeyword_STC();
	}

	@Then("the user should be able to zoom in and out of the table using the + and - icons")
	public void the_user_should_be_able_to_zoom_in_and_out_of_the_table_using_the_and_icons() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click on the column filter icon to select which columns should be displayed in the Select Target Customer for Peer Matching table")
	public void the_user_should_be_able_to_click_on_the_column_filter_icon_to_select_which_columns_should_be_displayed_in_the_select_target_customer_for_peer_matching_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to select a customer record from the table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected")
	public void the_user_should_be_able_to_select_a_customer_record_from_the_table_and_click_the_select_customer_button_which_redirects_to_the_peers_selection_screen_only_if_one_record_is_selected()
			throws IOException, InterruptedException {
		cpa_peerSelections.selectCustomerBtnWithSelection();
	}

	@When("user clicks on the Select Customer button without selecting any records, an error message should be displayed")
	public void user_clicks_on_the_select_customer_button_without_selecting_any_records_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		cpa_peerSelections.selectCustomerBtnWithOutSelection();
	}

	@Then("the user should be able to click on the Download icon present in the table header, which downloads the table records as an Excel file")
	public void the_user_should_be_able_to_click_on_the_download_icon_present_in_the_table_header_which_downloads_the_table_records_as_an_excel_file()
			throws IOException, InterruptedException {
		cpa_peerSelections.tableRecordsDownload();
	}

	@Then("the user should be able to click the Back button, which then redirects to the Branch\\/Customer Selection page")
	public void the_user_should_be_able_to_click_the_back_button_which_then_redirects_to_the_branch_customer_selection_page()
			throws IOException, InterruptedException {
		cpa_peerSelections.redirectionTo();
	}
}
