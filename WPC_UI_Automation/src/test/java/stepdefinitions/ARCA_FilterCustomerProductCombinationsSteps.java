package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ARCA_FilterCustomerProductCombinationsPage;

public class ARCA_FilterCustomerProductCombinationsSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	ARCA_FilterCustomerProductCombinationsPage arca_filterCustomerProductCombinationPage = new ARCA_FilterCustomerProductCombinationsPage(
			driver);

	@Given("the user is on the Filter Customer and Product Combinations screen")
	public void the_user_is_on_the_filter_customer_and_product_combinations_screen()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.navigateTo();
	}

	@When("the user clicks the Save Combination button without selecting any customers or commodity codes from the tree map, an error message should be displayed")
	public void the_user_clicks_the_save_combination_button_without_selecting_any_customers_or_commodity_codes_from_the_tree_map_an_error_message_should_be_displayed()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.saveCombinationsWithoutSelections();
	}

	@Then("the user should be able to click on the Select All Customer checkbox, which selects all tiles in the tree map")
	public void the_user_should_be_able_to_click_on_the_select_all_customer_checkbox_which_selects_all_tiles_in_the_tree_map()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.selectAllCustomer();
	}

	@Then("the user should be able to click on the Reset button, which restores the screen to its previous state")
	public void the_user_should_be_able_to_click_on_the_reset_button_which_restores_the_screen_to_its_previous_state()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.resetBtn();
	}

	@When("the user clicks on the Select All Commodity Codes checkbox, which selects all tiles in the tree map")
	public void the_user_clicks_on_the_select_all_commodity_codes_checkbox_which_selects_all_tiles_in_the_tree_map()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.selectAllCommodityCode();
	}

	@Then("the user clicks on the Customer Details button, which opens a select customers for analysis dialog box containing all selected customer details")
	public void the_user_clicks_on_the_customer_details_button_which_opens_a_select_customers_for_analysis_dialog_box_containing_all_selected_customer_details()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.customerDetailsBtn();
	}

	@Then("the user clicks on the Save Combination button, which redirects to the Customer Selection screen with the selected customer details")
	public void the_user_clicks_on_the_save_combination_button_which_redirects_to_the_customer_selection_screen_with_the_selected_customer_details()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.saveCombinationsBtnWithSelections();
	}

	@Then("the user should be able to click on individual customer tiles, after which the selection of all tiles and the Select All checkbox options should be unchecked")
	public void the_user_should_be_able_to_click_on_individual_customer_tiles_after_which_the_selection_of_all_tiles_and_the_select_all_checkbox_options_should_be_unchecked()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.customerSelection();
	}

	@Then("the user should be able to click on the tiles in the Commodity Code section to either select or deselect the desired commodities")
	public void the_user_should_be_able_to_click_on_the_tiles_in_the_commodity_code_section_to_either_select_or_deselect_the_desired_commodities()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.commodityCodeSelection();
	}

	@Then("the user clicks on the Customer Details button, which loads the select customers for analysis table and be able to select customers by clicking the checkbox provided for each customer record")
	public void the_user_clicks_on_the_customer_details_button_which_loads_the_select_customers_for_analysis_table_and_be_able_to_select_customers_by_clicking_the_checkbox_provided_for_each_customer_record()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.customerDetailsBtnSelectCustomers();
	}

	@Then("the user should be able to search for and select a customer record by Customer ID in the Select Customers for Analysis table")
	public void the_user_should_be_able_to_search_for_and_select_a_customer_record_by_customer_id_in_the_select_customers_for_analysis_table()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.searchAndSelectVRCA();
	}

	@Then("the user should be able to click on the Download icon of the Select Customers for Analysis table, which then downloads the customer details as an Excel file")
	public void the_user_should_be_able_to_click_on_the_download_icon_of_the_select_customers_for_analysis_table_which_then_downloads_the_customer_details_as_an_excel_file()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.downloadIconVRCA();
	}

	@Then("the user should be able to click the Apply button on the popup, which then updates the tree map with the selected customers")
	public void the_user_should_be_able_to_click_the_apply_button_on_the_popup_which_then_updates_the_tree_map_with_the_selected_customers()
			throws IOException, InterruptedException {
		arca_filterCustomerProductCombinationPage.applyBtnVRCA();
	}

}
