package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
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

		if (scenario.getSourceTagNames().contains("@CustomerPeerAnalysis_BranchCustomerSelection")) { // add
			// @Home,@CustomerPeerAnalysis_Overview,@CustomerPeerAnalysis_BranchCustomerSelection,@CustomerPeerAnalysis_PeerSelection
			// to run that code
			// Auto-login only for Dashboard, CustomerPeerAnalysisOverview scenarios
			LoginPage loginPage = pageManager.getLoginPage();
			loginPage.navigateTo();
			loginPage.loginTo();
			loginPage.loginBtn();
		}
//		if (scenario.getSourceTagNames().stream()
//				.anyMatch(tag -> tag.equalsIgnoreCase("@Home") || tag.equalsIgnoreCase("@CustomerPeerAnalysis_Overview")
//						|| tag.equalsIgnoreCase("@CustomerPeerAnalysis_BranchCustomerSelection")
//						|| tag.equalsIgnoreCase("@CustomerPeerAnalysis_PeerSelection"))) {
//			LoginPage loginPage = pageManager.getLoginPage();
//			loginPage.navigateTo();
//			loginPage.loginTo();
//			loginPage.loginBtn();
//		}

	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
