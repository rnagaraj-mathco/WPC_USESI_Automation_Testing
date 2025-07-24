package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.LoginPage;
import utils.ExtentReporter; // ✅ Your custom reporter class
import utils.ScreenshotUtil;

public class Hooks {

	private WebDriver driver;
	private PageObjectManager pageManager;

	private static ExtentReports extent = ExtentReporter.getInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static ThreadLocal<StringBuilder> scenarioStepSummary = new ThreadLocal<>();

	public static void logStep(String stepDescription) {
		ExtentTest test = extentTest.get();
		if (test != null) {
			test.info(stepDescription);
		}

		StringBuilder summary = scenarioStepSummary.get();
		if (summary != null) {
			summary.append("• ").append(stepDescription).append("\n");
		}
	}

	@Before
	public void setUp(Scenario scenario) throws IOException, InterruptedException {
		scenarioStepSummary.set(new StringBuilder("Executed Steps:\n"));
		DriverFactory.initializeDriver();
		driver = DriverFactory.getDriver();
		pageManager = new PageObjectManager(driver);

		// Create Extent test entry
		if (extent != null) {
			ExtentTest test = extent.createTest(scenario.getName());
			extentTest.set(test);
		}

		// Conditional auto-login
		if (scenario.getSourceTagNames().stream()
				.anyMatch(tag -> tag.equalsIgnoreCase("@Home") || tag.equalsIgnoreCase("@CPA_Overview")
						|| tag.equalsIgnoreCase("@CPA_BranchCustomerSelection")
						|| tag.equalsIgnoreCase("@CPA_PeerSelection") || tag.equalsIgnoreCase("@CPA_CreateScenario")
						|| tag.equalsIgnoreCase("@CPA_ViewScenarioImpact") || tag.equalsIgnoreCase("@ARCA_Overview")
						|| tag.equalsIgnoreCase("@ARCA_CustomerAnalysis")
						|| tag.equalsIgnoreCase("@ARCA_FilterCustomerProductCombinations")
						|| tag.equalsIgnoreCase("@ARCA_CustomerSelection") || tag.equalsIgnoreCase("@ARCA_ProfitBridge")
						|| tag.equalsIgnoreCase("@ARCA_CreateScenario"))) {

			LoginPage loginPage = pageManager.getLoginPage();
			loginPage.navigateTo();
			loginPage.loginTo();
			loginPage.loginBtn();
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			if (scenario.isFailed()) {
				String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName());
				ExtentTest test = extentTest.get();
				if (test != null) {
					test.fail("Scenario Failed: " + scenario.getName()).addScreenCaptureFromPath(screenshotPath);
				}
			} else {
				ExtentTest test = extentTest.get();
				if (test != null) {
					test.pass("Scenario Passed");
				}
			}

			// Log the summary
			ExtentTest test = extentTest.get();
			StringBuilder summary = scenarioStepSummary.get();
			if (test != null && summary != null) {
				test.info("----- Scenario Summary -----\n" + summary.toString());
			}

			extent.flush();

		} catch (Exception e) {
			System.err.println("Error in tearDown(): " + e.getMessage());
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
}
