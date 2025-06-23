package DriverManager;

import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;

public class PageObjectManager {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null)
            loginPage = new LoginPage(driver);
        return loginPage;
    }
    
    public DashboardPage getDashboardPage() {
        if (dashboardPage == null)
        	dashboardPage = new DashboardPage(driver);
        return dashboardPage;
    }
}
