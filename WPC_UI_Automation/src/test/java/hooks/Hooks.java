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

// --- New approach
public class Hooks {

    private WebDriver driver;
    private PageObjectManager pageManager;

    @Before
    public void setUp(Scenario scenario) throws IOException, InterruptedException {
        DriverFactory.initializeDriver();
        driver = DriverFactory.getDriver();
        pageManager = new PageObjectManager(driver);

        if (scenario.getSourceTagNames().contains("@Dashboard")) { //add @Dashboard,@CustomerPeerAnalysis_Overview,@CustomerPeerAnalysis_BranchCustomerSelection,@CustomerPeerAnalysis_PeerSelection to run that code
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
