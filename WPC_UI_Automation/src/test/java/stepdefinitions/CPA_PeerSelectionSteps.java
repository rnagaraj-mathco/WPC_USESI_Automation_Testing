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

	@Then("the user should be able to zoom in and zoom out of the Select Target Customer for Peer Matching table using the + and - icons")
	public void the_user_should_be_able_to_zoom_in_and_zoom_out_of_the_select_target_customer_for_peer_matching_table_using_the_and_icons() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click on the column filter icon to select which columns should be displayed in the Select Target Customer for Peer Matching table")
	public void the_user_should_be_able_to_click_on_the_column_filter_icon_to_select_which_columns_should_be_displayed_in_the_select_target_customer_for_peer_matching_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to select a customer record from the Select Target Customer for Peer Matching table and click the Select Customer button, which redirects to the Peers Selection screen only if one record is selected")
	public void the_user_should_be_able_to_select_a_customer_record_from_the_Select_Target_Customer_for_Peer_Matching_table_and_click_the_select_customer_button_which_redirects_to_the_peers_selection_screen_only_if_one_record_is_selected()
			throws IOException, InterruptedException {
		cpa_peerSelections.selectCustomerBtnWithSelection();
	}

	@When("the user clicks on the Select Customer button without selecting any records, an error message should be displayed")
	public void the_user_clicks_on_the_select_customer_button_without_selecting_any_records_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		cpa_peerSelections.selectCustomerBtnWithOutSelection();
	}

	@Then("the user should be able to click on the Download icon present in the Select Target Customer for Peer Matching table header, which downloads the table records as an Excel file")
	public void the_user_should_be_able_to_click_on_the_download_icon_present_in_the_select_target_customer_for_peer_matching_table_header_which_downloads_the_table_records_as_an_excel_file()
			throws IOException, InterruptedException {

		cpa_peerSelections.tableRecordsDownload();
	}

	@Given("the user should be able to click the Back button, which then redirects to the Peer Selection - Select Target Customer for Peer Matching page")
	public void the_user_should_be_able_to_click_the_back_button_which_then_redirects_to_the_peer_selection_select_target_customer_for_peer_matching_page()
			throws IOException, InterruptedException {
		cpa_peerSelections.redirectionToPeerSelection_01_Screen();
	}

	@Then("the user should be able to click the Back button, which then redirects to the Branch\\/Customer Selection page")
	public void the_user_should_be_able_to_click_the_back_button_which_then_redirects_to_the_branch_customer_selection_page()
			throws IOException, InterruptedException {
		cpa_peerSelections.redirectionToBranchCustomerScreen();
	}

	@Then("user should be able to interact with the Rows per page dropdown of the Select Target Customer for Peer Matching table and select a value, which updates the visible records")
	public void user_should_be_able_to_interact_with_the_rows_per_page_dropdown_of_the_select_target_customer_for_peer_matching_table_and_select_a_value_which_updates_the_visible_records() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Peer Selection 01 Target Customer Selection - Customer Selection by Searching
	// and Selecting the the record
	@Then("the user should be able to search for a customer record and select it from the Select Target Customer for Peer Matching table and click on the Select Customer button, which redirects to the Peers Selection screen only if one record is selected")
	public void the_user_should_be_able_to_search_for_a_customer_record_and_select_it_from_the_Select_Target_Customer_for_Peer_Matching_table_and_click_on_the_select_customer_button_which_redirects_to_the_peers_selection_screen_only_if_one_record_is_selected()
			throws IOException, InterruptedException {
		cpa_peerSelections.searchForRecord();
	}

	// Peer Selection -02 Scenario's
	// Peer Selection 02 Comparative Peer Group Selection -- SPMC - Peer Dropdown -
	// Table - Buttons

	@Then("the user is on the Peer Selection - Comparative Peer Group Selection screen, where the user should be able to click on the Set Peer Matching Criteria button to enter threshold values and select a similarity model")
	public void the_user_is_on_the_peer_selection_comparative_peer_group_selection_screen_where_the_user_should_be_able_to_click_on_the_set_peer_matching_criteria_button_to_enter_threshold_values_and_select_a_similarity_model()
			throws IOException, InterruptedException {
		cpa_peerSelections.setPeerMatchingCriteria();
	}

	@Then("the user should be able to click on the Select Peers Dropdown and choose the desired peers count")
	public void the_user_should_be_able_to_click_on_the_select_peers_dropdown_and_choose_the_desired_peers_count()
			throws IOException, InterruptedException {
		cpa_peerSelections.selectPeersDropdown();
	}

	@Then("the user should be able to search for a keyword in the Select Comparative Peer Group table")
	public void the_user_should_be_able_to_search_for_a_keyword_in_the_select_comparative_peer_group_table()
			throws IOException, InterruptedException {
		cpa_peerSelections.searchForKeyword_SCPG(); // SCPG is the table name
	}

	@Then("the user should be able to click on the download icon present in the Select Comparative Peer Group table header, which downloads the table records as an Excel file")
	public void the_user_should_be_able_to_click_on_the_download_icon_present_in_the_select_comparative_peer_group_table_header_which_downloads_the_table_records_as_an_excel_file()
			throws IOException, InterruptedException {
		cpa_peerSelections.downloadIcon_SCPG();
	}

	@Then("the user should be able to zoom in and zoom out of the Select Comparative Peer Group table using the + and - icons")
	public void the_user_should_be_able_to_zoom_in_and_zoom_out_of_the_select_comparative_peer_group_table_using_the_and_icons() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to click on the column filter icon to select which columns should be displayed in the Select Comparative Peer Group table")
	public void the_user_should_be_able_to_click_on_the_column_filter_icon_to_select_which_columns_should_be_displayed_in_the_select_comparative_peer_group_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to select the peers by clicking on the checkbox of each peer record")
	public void the_user_should_be_able_to_select_the_peers_by_clicking_on_the_checkbox_of_each_peer_record()
			throws IOException, InterruptedException {
//		cpa_peerSelections.selectPeers();
	}

	@Then("the user should be able to deselect the peers by clicking on the checkbox of each peer record")
	public void the_user_should_be_able_to_deselect_the_peers_by_clicking_on_the_checkbox_of_each_peer_record()
			throws IOException, InterruptedException {
//		cpa_peerSelections.deselectPeers();
	}

	@Then("the user should be able to search for the peers records and select the peers")
	public void the_user_should_be_able_to_search_for_the_peers_records_and_select_the_peers()
			throws IOException, InterruptedException {
//		cpa_peerSelections.searchAndSelectPeers();
	}

	@Then("the user should be able to search for the peers records and deselect the peers")
	public void the_user_should_be_able_to_search_for_the_peers_records_and_deselect_the_peers()
			throws IOException, InterruptedException {
//		cpa_peerSelections.searchAndDeSelectPeers();
	}

	@Then("the user should be able to click on the Compare Peers button which then opens up the dialog box to enter the name and save the peer selections")
	public void the_user_should_be_able_to_click_on_the_compare_peers_button_which_then_opens_up_the_dialog_box_to_enter_the_name_and_save_the_peer_selections()
			throws IOException, InterruptedException {
		cpa_peerSelections.comparePeersBtn();
	}

	@Then("the user should be able to click on the Reset button which then resets the peer selections and updates the table to older version")
	public void the_user_should_be_able_to_click_on_the_reset_button_which_then_resets_the_peer_selections_and_updates_the_table_to_older_version()
			throws IOException, InterruptedException {
//		cpa_peerSelections.resetBtn();
	}
}
