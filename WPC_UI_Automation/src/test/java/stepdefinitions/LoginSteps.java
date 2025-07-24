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
import pages.LoginPage;

public class LoginSteps {
	// WebDriver driver = DriverFactory.initializeDriver(); //This was loading the
	// browser twice
	WebDriver driver = DriverFactory.getDriver();

	PageObjectManager pageManager = new PageObjectManager(driver);
	ConfigReader configReader = new ConfigReader();
	LoginPage loginPage = new LoginPage(driver);

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws IOException {
//		Hooks.logStep("the user is on the login page");
		loginPage.navigateTo();
	}

	@When("the user enters the credentials")
	public void the_user_enters_the_credentials() throws InterruptedException {
//		Hooks.logStep("the user enters the credentials");
		loginPage.loginTo();
	}

	@When("the user click on the Login button")
	public void the_user_click_on_the_login_button() throws IOException, InterruptedException {
//		Hooks.logStep("the user click on the Login button");
		loginPage.loginBtn();
	}

	@Then("user lands on the homescreen and validate the logged-in user")
	public void user_lands_on_the_homescreen_and_validate_the_logged_in_user()
			throws InterruptedException, IOException {
//		Hooks.logStep("user lands on the homescreen and validate the logged-in user");
		loginPage.landingURL();
	}

	// Negative Scenario code

	// This function is for the entering the Invalid Credentials
	@When("the user enters invalid credentials")
	public void the_user_enters_invalid_credentials() throws IOException, InterruptedException {
		System.out.println(" --- For the Invalid Credentials Scenario ---");
//		Hooks.logStep("the user enters invalid credentials");
		loginPage.enterInvalidCredentials();
	}

	// This checks whether user is on the login page even after entering the Invalid
	// credentials and not redirected to other pages
	@Then("the user should remain on the login page")
	public void the_user_should_remain_on_the_login_page() throws IOException {
		loginPage.invalidLoginPageStay();
//		Hooks.logStep("the user should remain on the login page");
		System.out.println("No login happended due to Invalid Credentials");
	}

	// This checks whether the Error message is displayed when the user clicked
	// Login btn by entering Invalid credentials
	// This is calling a boolean function which returns true if it finds the error
	// message or false if it does not finds the error which then displays the below
	// error message
	@And("an error message should be displayed")
	public void an_error_message_should_be_displayed() {
		if (!loginPage.isErrorMessageVisible()) {
			throw new AssertionError("❌ Error message not shown for invalid login.");
		}
	}

}
