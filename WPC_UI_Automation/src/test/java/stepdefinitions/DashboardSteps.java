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
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardSteps {
	//Getting driver as it is initialized in driverfactory.java
	WebDriver driver = DriverFactory.getDriver();
	//Basic requirements
	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
    LoginPage loginPage = new LoginPage(driver);//Login page 
	DashboardPage dashboardPage = new DashboardPage(driver);//Dashboard page
	
	//Feature steps
	//Cards Scenario
	@Given("user is on the dashboard screen")
	public void user_is_on_the_dashboard_screen() throws IOException {
		//Gets driver instance and confirms that driver is initialized
		System.out.println("DEBUG DRIVER INSTANCE: " + DriverFactory.getDriver());
	    dashboardPage.navigateTo();
	}

	@Then("user shoud be able to click on the profile icon and view all the options")
	public void user_shoud_be_able_to_click_on_the_profile_icon_and_view_all_the_options() throws IOException, InterruptedException{
		dashboardPage.profileIcon();
	}

	@When("user clicks on the Customer Peer Analysis card the user must redirected and return to dashboard screen")
	public void user_clicks_on_the_customer_peer_analysis_card_the_user_must_redirected_and_return_to_dashboard_screen() throws IOException, InterruptedException {
	    dashboardPage.customerPeerAnalysisCardClick();
	}

	@When("user should be able to click on Auto Root Cause Analysis card and come back to dashboard screen")
	public void user_should_be_able_to_click_on_auto_root_cause_analysis_card_and_come_back_to_dashboard_screen() throws IOException, InterruptedException {
	    dashboardPage.autoRootCauseAnalysisCardClick(); 
	}
	
	@Then("user stays on the dashboard screen")
	public void user_stays_on_the_dashboard_screen() throws IOException, InterruptedException {
		dashboardPage.dashboardPageStay();
		
	}
	//Side Nav bar scenario
	@When("user clicks on the Customer Peer Analysis option then user must get redirected and hover on the options")
	public void user_clicks_on_the_customer_peer_analysis_option_then_user_must_get_redirected_and_hover_on_the_options() throws IOException, InterruptedException{
		dashboardPage.customerPeerAnalysisSideNavBar();
	}
	
	@When("user clicks on Auto Root Cause Analysis option then user must get redirected and hover on the options")
	public void user_clicks_on_auto_root_cause_analysis_option_then_user_must_get_redirected_and_hover_on_the_options() throws IOException, InterruptedException{
		dashboardPage.autoRootCauseAnalysisSideNavBar();
	 }
	}
