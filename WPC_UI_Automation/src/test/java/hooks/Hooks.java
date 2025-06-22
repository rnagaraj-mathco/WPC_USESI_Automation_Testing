package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import core.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.LoginPage;
//
//public class Hooks extends BaseTest {
//	@Before("@Login or @Dashboard")
//	public void loginBeforeDashboardScenarios() throws IOException, InterruptedException {
//	    // ✅ Step 1: Initialize driver
//	    DriverFactory.initializeDriver();  
//
//	    // ✅ Step 2: Get the initialized driver
//	    WebDriver driver = DriverFactory.getDriver();
//
//	    // ✅ Step 3: Login before dashboard feature
//	    LoginPage loginPage = new LoginPage(driver);
//	    loginPage.navigateTo();
//	    loginPage.LoginTo();
//	    loginPage.LoginBtn();
//	}
//
//    @After
//    public void tearDown() {
//        stopApplication();
//    }
//}

//------ This is for the Login Feature

//package hooks;
//
//import core.BaseTest;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Hooks extends BaseTest {
//    @Before
//    public void setUp() {
//        startApplication();
//    }
//
//    @After
//    public void tearDown() {
//        stopApplication();
//    }
//}

// --- New approach
public class Hooks {

    private WebDriver driver;
    private PageObjectManager pageManager;

    @Before
    public void setUp(Scenario scenario) throws IOException, InterruptedException {
        DriverFactory.initializeDriver();
        driver = DriverFactory.getDriver();
        pageManager = new PageObjectManager(driver);

        if (scenario.getSourceTagNames().contains("@CustomerPeerAnalysis_BranchCustomerSelection")) { //add @Dashboard,@CustomerPeerAnalysis_Overview,@CustomerPeerAnalysis_BranchCustomerSelection to run that code
            // Auto-login only for Dashboard, CustomerPeerAnalysisOverview scenarios
            LoginPage loginPage = pageManager.getLoginPage();
            loginPage.navigateTo();
            loginPage.LoginTo();
            loginPage.LoginBtn();
        }
        
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
