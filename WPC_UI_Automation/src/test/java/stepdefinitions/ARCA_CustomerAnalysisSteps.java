package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ARCA_CustomerAnalysisPage;

public class ARCA_CustomerAnalysisSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	ARCA_CustomerAnalysisPage arca_customerAnalysisPage = new ARCA_CustomerAnalysisPage(driver);

	@Given("the user is on the Customer Analysis screen")
	public void the_user_is_on_the_customer_analysis_screen() throws IOException, InterruptedException {
		arca_customerAnalysisPage.navigateTo();
	}

	@Then("the user clicks on Filters and select options based on the requirements")
	public void the_user_clicks_on_filters_and_select_options_based_on_the_requirements()
			throws IOException, InterruptedException {
		arca_customerAnalysisPage.filtersTo();
	}

	@Then("the user should be able to Select Customers from the Root Cause Customers for the Selected Cost Metric plot")
	public void the_user_should_be_able_to_select_customers_from_the_root_cause_customers_for_the_selected_cost_metric_plot()
			throws IOException, InterruptedException {
		arca_customerAnalysisPage.rootCauseCustomerSelectionPlot();
	}

	@Then("the user should click on the Save Customers button which then saves the selection and redirects to the Filter Customer and Product Combinations screen")
	public void the_user_should_click_on_the_save_customers_button_which_then_saves_the_selection_and_redirects_to_the_filter_customer_and_product_combinations_screen()
			throws IOException, InterruptedException {
		arca_customerAnalysisPage.saveCustomersBtn();
	}

	// Select All Customer checkbox
	@Then("the user should be able to Select all the customers from the Root Cause Customers for the Selected Cost Metric plot by clicking on the Select All Customer option")
	public void the_user_should_be_able_to_select_all_the_customers_from_the_root_cause_customers_for_the_selected_cost_metric_plot_by_clicking_on_the_select_all_customer_option()
			throws IOException, InterruptedException {
		arca_customerAnalysisPage.selectAllCustomersCheckBox();
	}

	// Reset button
	@When("the user clicks the Reset button, the entire customer selection in the Root Cause Customers for the Selected Cost Metric plot is reverted to its previous state.")
	public void the_user_clicks_the_reset_button_the_entire_customer_selection_in_the_root_cause_customers_for_the_selected_cost_metric_plot_is_reverted_to_its_previous_state()
			throws IOException, InterruptedException {
		arca_customerAnalysisPage.resetBtn();
	}

}
