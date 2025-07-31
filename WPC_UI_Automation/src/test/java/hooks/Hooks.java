package hooks;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import DriverManager.DriverFactory;
import DriverManager.PageObjectManager;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.FileAppender;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.LoginPage;
import utils.ExtentReporter;
import utils.ScreenshotUtil;

public class Hooks {

	private WebDriver driver;
	private PageObjectManager pageManager;

	private static ExtentReports extent = ExtentReporter.getInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static ThreadLocal<StringBuilder> scenarioStepSummary = new ThreadLocal<>();

	public static Logger logger;
	private static final Map<String, Logger> loggerMap = new ConcurrentHashMap<>();

	@Before
	public void setUp(Scenario scenario) throws IOException, InterruptedException {
		String rawFeaturePath = scenario.getUri().getPath();
		String featureFileName = rawFeaturePath.substring(rawFeaturePath.lastIndexOf("/") + 1).replace(".feature", "")
				.replaceAll("[^a-zA-Z0-9-_]", "_");

		// 💡 Only create logger once per feature file
		if (!loggerMap.containsKey(featureFileName)) {
			loggerMap.put(featureFileName, createLoggerForFeature(featureFileName));
		}
		logger = loggerMap.get(featureFileName);

		logger.info("🔄 Starting scenario: {}", scenario.getName());

		scenarioStepSummary.set(new StringBuilder("Executed Steps:\n"));
		DriverFactory.initializeDriver();
		driver = DriverFactory.getDriver();
		pageManager = new PageObjectManager(driver);

		if (extent != null) {
			ExtentTest test = extent.createTest(scenario.getName());
			extentTest.set(test);
		}

		if (scenario.getSourceTagNames().stream()
				.anyMatch(tag -> tag.equalsIgnoreCase("@Login") || tag.equalsIgnoreCase("@Home")
						|| tag.equalsIgnoreCase("@CPA_Overview") || tag.equalsIgnoreCase("@CPA_BranchCustomerSelection")
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
			ExtentTest test = extentTest.get();

			if (scenario.isFailed()) {
				String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName());
				if (test != null) {
					test.fail("Scenario Failed: " + scenario.getName()).addScreenCaptureFromPath(screenshotPath);
				}
				logger.error("❌ Scenario FAILED: {}", scenario.getName());
			} else {
				if (test != null) {
					test.pass("Scenario Passed");
				}
				logger.info("✅ Scenario PASSED: {}", scenario.getName());
			}

			// 🔻 Separator line after each scenario
			logger.info("─────────────────────────────── End of Scenario ───────────────────────────────");

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

	public static void logStep(String stepDescription) {
		if (logger != null)
			logger.info(stepDescription);

		ExtentTest test = extentTest.get();
		if (test != null)
			test.info(stepDescription);

		StringBuilder summary = scenarioStepSummary.get();
		if (summary != null)
			summary.append("• ").append(stepDescription).append("\n");
	}

	// ✅ Feature-scoped logger creator
	private Logger createLoggerForFeature(String featureFileName) {
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

		// Timestamped unique file name
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String logFilePath = "logs/" + featureFileName + "_" + timestamp + ".log";

		FileAppender fileAppender = new FileAppender();
		fileAppender.setContext(loggerContext);
		fileAppender.setName("FILE_" + featureFileName);
		fileAppender.setFile(logFilePath);

		PatternLayoutEncoder encoder = new PatternLayoutEncoder();
		encoder.setContext(loggerContext);
		encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level ▶ %msg%n");
		encoder.start();

		fileAppender.setEncoder(encoder);
		fileAppender.start();

		ch.qos.logback.classic.Logger dynamicLogger = loggerContext.getLogger("FeatureLogger_" + featureFileName);
		dynamicLogger.detachAndStopAllAppenders();
		dynamicLogger.addAppender(fileAppender);

		// Also attach STDOUT appender from root
		dynamicLogger.addAppender(loggerContext.getLogger("ROOT").getAppender("STDOUT"));
		dynamicLogger.setAdditive(false);

		return dynamicLogger;
	}
}
