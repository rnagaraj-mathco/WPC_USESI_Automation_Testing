package DriverManager;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LoginPage;

public class PageObjectManager {

	WebDriver driver;
	LoginPage loginPage;
	HomePage dashboardPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null)
			loginPage = new LoginPage(driver);
		return loginPage;
	}

	public HomePage getDashboardPage() {
		if (dashboardPage == null)
			dashboardPage = new HomePage(driver);
		return dashboardPage;
	}
}
