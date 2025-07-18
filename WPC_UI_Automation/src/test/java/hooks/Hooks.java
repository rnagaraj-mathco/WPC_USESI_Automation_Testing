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

		if (scenario.getSourceTagNames().contains("@ARCA_ProfitBridge")) { // add
			// @Home,@CPA_Overview, @CPA_BranchCustomerSelection, @CPA_PeerSelection,

			// @ARCA_Overview,@ARCA_CustomerAnalysis,@ARCA_FilterCustomerProductCombinations
			// @ARCA_CustomerSelection, @ARCA_ProfitBridge
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
