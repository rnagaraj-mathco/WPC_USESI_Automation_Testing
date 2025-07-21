package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.LoginPage;
import utils.ExtentReporter; // ✅ This is YOUR utility class
import utils.ScreenshotUtil;

public class Hooks {

	private WebDriver driver;
	private PageObjectManager pageManager;

	private static ExtentReports extent = ExtentReporter.getInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Before
	public void setUp(Scenario scenario) throws IOException, InterruptedException {
		DriverFactory.initializeDriver();
		driver = DriverFactory.getDriver();
		pageManager = new PageObjectManager(driver);
		// Create ExtentTest for this scenario
		ExtentTest test = extent.createTest(scenario.getName());
		extentTest.set(test);

		if (scenario.getSourceTagNames().contains("")) { // add
			// @Home,@CPA_Overview, @CPA_BranchCustomerSelection, @CPA_PeerSelection,
			// @CPA_CreateScenario
			// @ARCA_Overview,@ARCA_CustomerAnalysis,@ARCA_FilterCustomerProductCombinations
			// @ARCA_CustomerSelection, @ARCA_ProfitBridge
			// Auto-login only for Dashboard, CustomerPeerAnalysisOverview scenarios
			LoginPage loginPage = pageManager.getLoginPage();
			loginPage.navigateTo();
			loginPage.loginTo();
			loginPage.loginBtn();
		}
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
//
//	}

	public void tearDown(Scenario scenario) {
		// Screenshot on failure
		if (scenario.isFailed()) {
			String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName());
			extentTest.get().fail("Scenario Failed: " + scenario.getName()).addScreenCaptureFromPath(screenshotPath);
		} else {
			extentTest.get().pass("Scenario Passed");
		}
		extent.flush();

		// Quit browser
		if (driver != null) {
			driver.quit();
		}
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}
}