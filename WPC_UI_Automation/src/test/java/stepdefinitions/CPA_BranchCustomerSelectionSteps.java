package stepdefinitions;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CPA_BranchCustomerSelectionPage;
import pages.LoginPage;


public class CPA_BranchCustomerSelectionSteps {
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	CPA_BranchCustomerSelectionPage cpa_branchCustomerSelections = new CPA_BranchCustomerSelectionPage(driver);
	
	@Given("the user is on the Branch\\/Customer Selection screen")
	public void the_user_is_on_the_branch_customer_selection_screen() throws IOException, InterruptedException {
		System.out.println("DEBUG DRIVER INSTANCE: " + DriverFactory.getDriver());
		cpa_branchCustomerSelections.navigateTo();
	}

	@Then("the user clicks on filters and selects options based on requirements")
	public void the_user_clicks_on_filters_and_selects_options_based_on_requirements() throws IOException, InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		cpa_branchCustomerSelections.FiltersTo();
	}

	@Then("the user selects a metric from the metrics dropdown")
	public void the_user_selects_a_metric_from_the_metrics_dropdown() throws IOException, InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		cpa_branchCustomerSelections.SelectMetric();
	}

	@Then("the user should be able to zoom in and out of the map using the + and - icons on the zoom slider")
	public void the_user_should_be_able_to_zoom_in_and_out_of_the_map_using_the_and_icons_on_the_zoom_slider() throws IOException, InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
//		cpa_branchCustomerSelections.ClicksOnZoomIcons();
	}

	@When("the map is updated, the user clicks on bubbles to highlight branches on the geographical map")
	public void the_map_is_updated_the_user_clicks_on_bubbles_to_highlight_branches_on_the_geographical_map()throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//		cpa_branchCustomerSelections.SelectBranchMap();
	}
	
	@Then("the user clicks on the Select Branch dropdown and searches for a branch, which gets highlighted on the map")
	public void the_user_clicks_on_the_select_branch_dropdown_and_searches_for_a_branch_which_gets_highlighted_on_the_map()throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		cpa_branchCustomerSelections.SelectBranchDropdown();
	}
	
	@When("the user clicks the Analyze button, which redirects to the Customer Selection dialog screen")
	public void the_user_clicks_the_analyze_button_which_redirects_to_the_customer_selection_dialog_screen()throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		cpa_branchCustomerSelections.ClickAnalyze();
	}
	
	@Then("the user selects customers from the plot and dropdown, clicks Save Customers, and is redirected to the Peer Selection screen")
	public void the_user_selects_customers_from_the_plot_and_dropdown_clicks_save_customers_and_is_redirected_to_the_peer_selection_screen()throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	


}
