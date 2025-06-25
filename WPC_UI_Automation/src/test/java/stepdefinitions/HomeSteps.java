package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import config.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//importing the pages
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {
	// Getting driver as it is initialized in driverfactory.java
	WebDriver driver = DriverFactory.getDriver();
	// Basic requirements
	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	LoginPage loginPage = new LoginPage(driver);// Login page
	HomePage homeScreenPage = new HomePage(driver);// homeScreen page

	// Feature steps
	// Cards Scenario
	@Given("the user is on the Home screen")
	public void the_user_is_on_the_home_screen() throws IOException {
		// Gets driver instance and confirms that driver is initialized
		System.out.println("DEBUG DRIVER INSTANCE: " + DriverFactory.getDriver());
		homeScreenPage.navigateTo();
	}

	@Then("the user shoud be able to click on the profile icon and view all the available options")
	public void the_user_shoud_be_able_to_click_on_the_profile_icon_and_view_all_the_available_options()
			throws IOException, InterruptedException {
		homeScreenPage.profileIcon();
	}

	@When("the user clicks on the Customer Peer Analysis card then the user should be redirected to the Overview screen and return to the Home screen")
	public void the_user_clicks_on_the_customer_peer_analysis_card_then_the_user_should_be_redirected_to_the_overview_screen_and_return_to_the_home_screen()
			throws IOException, InterruptedException {
		homeScreenPage.customerPeerAnalysisCardClick();
	}

	@When("the user should be able to click on the Auto Root Cause Analysis card then the user should be redirected to the Overview screen and return to the Home screen")
	public void the_user_should_be_able_to_click_on_the_auto_root_cause_analysis_card_then_the_user_should_be_redirected_to_the_overview_screen_and_return_to_the_home_screen()
			throws IOException, InterruptedException {
		homeScreenPage.autoRootCauseAnalysisCardClick();
	}

	@Then("the user should remain on the Home screen")
	public void the_user_should_remain_on_the_home_screen() throws IOException, InterruptedException {
		homeScreenPage.homescreenPageStay();

	}

	// Side Nav bar scenario
	@When("the user clicks on the Customer Peer Analysis option from side navigation bar then user must get redirected to the Overview screen and be able to hover on the available options")
	public void the_user_clicks_on_the_customer_peer_analysis_option_from_side_navigation_bar_then_user_must_get_redirected_to_the_overview_screen_and_be_able_to_hover_on_the_available_options()
			throws IOException, InterruptedException {
		homeScreenPage.customerPeerAnalysisSideNavBar();
	}

	@When("the user clicks on the Auto Root Cause Analysis option from side navigation bar then user must get redirected to the Overview screen and be able to hover on the available options")
	public void the_user_clicks_on_the_auto_root_cause_analysis_option_from_side_navigation_bar_then_user_must_get_redirected_to_the_overview_screen_and_be_able_to_hover_on_the_available_options()
			throws IOException, InterruptedException {
		homeScreenPage.autoRootCauseAnalysisSideNavBar();
	}
}
