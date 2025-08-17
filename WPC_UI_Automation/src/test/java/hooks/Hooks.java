//
//package hooks;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//import java.util.TimeZone;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//
//import DriverManager.DriverFactory;
//import DriverManager.PageObjectManager;
//import ch.qos.logback.classic.LoggerContext;
//import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
//import ch.qos.logback.core.FileAppender;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import pages.LoginPage;
//import utils.ExtentReporter;
//import utils.ScreenshotUtil;
//
//public class Hooks {
//
//	private WebDriver driver;
//	private PageObjectManager pageManager;
//
//	private static ExtentReports extent;
//
//	static {
//		try {
//			extent = ExtentReporter.getInstance();
//		} catch (IOException e) {
//			System.err.println("❌ Failed to initialize ExtentReporter: " + e.getMessage());
//		}
//	}
//
//	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
//	private static ThreadLocal<StringBuilder> scenarioStepSummary = new ThreadLocal<>();
//
//	public static Logger logger;
//	private static final Map<String, Logger> loggerMap = new ConcurrentHashMap<>();
//
//	private static final String logsFolderTimestamp;
//
//	static {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//		logsFolderTimestamp = sdf.format(new Date());
//		new File("logs/WPC_USESI_Logs_" + logsFolderTimestamp).mkdirs();
//	}
//
//	@Before
//	public void setUp(Scenario scenario) throws IOException, InterruptedException {
//		String rawFeaturePath = scenario.getUri().getPath();
//		String featureFileName = rawFeaturePath.substring(rawFeaturePath.lastIndexOf("/") + 1).replace(".feature", "")
//				.replaceAll("[^a-zA-Z0-9-_]", "_");
//
//		if (!loggerMap.containsKey(featureFileName)) {
//			loggerMap.put(featureFileName, createLoggerForFeature(featureFileName));
//		}
//		logger = loggerMap.get(featureFileName);
//
//		logger.info("🔄 Starting scenario: {}", scenario.getName());
//
//		scenarioStepSummary.set(new StringBuilder("Executed Steps:\n"));
//		DriverFactory.initializeDriver();
//		driver = DriverFactory.getDriver();
//		pageManager = new PageObjectManager(driver);
//
//		if (extent != null) {
//			ExtentTest test = extent.createTest(scenario.getName());
//			extentTest.set(test);
//		}
//
//		if (scenario.getSourceTagNames().stream()
//				.anyMatch(tag -> tag.equalsIgnoreCase("@Login") || tag.equalsIgnoreCase("@Home")
//						|| tag.equalsIgnoreCase("@CPA_Overview") || tag.equalsIgnoreCase("@CPA_BranchCustomerSelection")
//						|| tag.equalsIgnoreCase("@CPA_PeerSelection") || tag.equalsIgnoreCase("@CPA_CreateScenario")
//						|| tag.equalsIgnoreCase("@CPA_ViewScenarioImpact") || tag.equalsIgnoreCase("@ARCA_Overview")
//						|| tag.equalsIgnoreCase("@ARCA_CustomerAnalysis")
//						|| tag.equalsIgnoreCase("@ARCA_FilterCustomerProductCombinations")
//						|| tag.equalsIgnoreCase("@ARCA_CustomerSelection") || tag.equalsIgnoreCase("@ARCA_ProfitBridge")
//						|| tag.equalsIgnoreCase("@ARCA_CreateScenario"))) {
//
//			LoginPage loginPage = pageManager.getLoginPage();
//			loginPage.navigateTo();
//			loginPage.loginTo();
//			loginPage.loginBtn();
//		}
//	}
//
//	@After
//	public void tearDown(Scenario scenario) {
//		try {
//			ExtentTest test = extentTest.get();
//
//			if (scenario.isFailed()) {
//				String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName());
//
//				// ✅ Attach screenshot to Extent Report
//				if (test != null && screenshotPath != null) {
//					test.fail("Step Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//				}
//
//				// ✅ Attach screenshot to Cucumber report
//				if (screenshotPath != null) {
//					byte[] screenshotBytes = Files.readAllBytes(Paths.get(screenshotPath));
//					scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
//				}
//
//				logger.error("❌ Scenario FAILED: {}", scenario.getName());
//			} else {
//				if (test != null) {
//					test.pass("Scenario Passed");
//				}
//				logger.info("✅ Scenario PASSED: {}", scenario.getName());
//			}
//
//			StringBuilder summary = scenarioStepSummary.get();
//			if (test != null && summary != null) {
//				test.info("----- Scenario Summary -----\n" + summary.toString());
//			}
//
//			logger.info("─────────────────────────────── End of Scenario ───────────────────────────────");
//
//			extent.flush();
//		} catch (Exception e) {
//			System.err.println("Error in tearDown(): " + e.getMessage());
//		} finally {
//			if (driver != null) {
//				driver.quit();
//			}
//		}
//	}
//
//	public static void logStep(String stepDescription) {
//		if (logger != null)
//			logger.info(stepDescription);
//
//		ExtentTest test = extentTest.get();
//		if (test != null)
//			test.info(stepDescription);
//
//		StringBuilder summary = scenarioStepSummary.get();
//		if (summary != null)
//			summary.append("• ").append(stepDescription).append("\n");
//	}
//
//	private Logger createLoggerForFeature(String featureFileName) {
//		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
//
//		String logFilePath = "logs/WPC_USESI_Logs_" + logsFolderTimestamp + "/" + featureFileName + "_"
//				+ logsFolderTimestamp + ".log";
//
//		FileAppender fileAppender = new FileAppender();
//		fileAppender.setContext(loggerContext);
//		fileAppender.setName("FILE_" + featureFileName);
//		fileAppender.setFile(logFilePath);
//
//		PatternLayoutEncoder encoder = new PatternLayoutEncoder();
//		encoder.setContext(loggerContext);
//		encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level ▶ %msg%n");
//		encoder.start();
//
//		fileAppender.setEncoder(encoder);
//		fileAppender.start();
//
//		ch.qos.logback.classic.Logger dynamicLogger = loggerContext.getLogger("FeatureLogger_" + featureFileName);
//		dynamicLogger.detachAndStopAllAppenders();
//		dynamicLogger.addAppender(fileAppender);
//		dynamicLogger.addAppender(loggerContext.getLogger("ROOT").getAppender("STDOUT"));
//		dynamicLogger.setAdditive(false);
//
//		return dynamicLogger;
//	}
//}
//////////////////////////////////// This is working but updating the script to log all scenario to extent report
//package hooks;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//import java.util.TimeZone;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//
//import DriverManager.DriverFactory;
//import DriverManager.PageObjectManager;
//import ch.qos.logback.classic.LoggerContext;
//import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
//import ch.qos.logback.core.FileAppender;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import pages.LoginPage;
//import utils.ExtentReporter;
//import utils.ScreenshotUtil;
//
//public class Hooks {
//
//	private WebDriver driver;
//	private PageObjectManager pageManager;
//
//	private static ExtentReports extent;
//
//	static {
//		try {
//			extent = ExtentReporter.getInstance();
//		} catch (IOException e) {
//			System.err.println("❌ Failed to initialize ExtentReporter: " + e.getMessage());
//		}
//	}
//
//	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
//	private static ThreadLocal<StringBuilder> scenarioStepSummary = new ThreadLocal<>();
//
//	public static Logger logger;
//	private static final Map<String, Logger> loggerMap = new ConcurrentHashMap<>();
//
//	private static final String logsFolderTimestamp;
//
//	static {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//		logsFolderTimestamp = sdf.format(new Date());
//		new File("logs/WPC_USESI_Logs_" + logsFolderTimestamp).mkdirs();
//	}
//
//	@Before
//	public void setUp(Scenario scenario) throws IOException, InterruptedException {
//		String rawFeaturePath = scenario.getUri().getPath();
//		String featureFileName = rawFeaturePath.substring(rawFeaturePath.lastIndexOf("/") + 1).replace(".feature", "")
//				.replaceAll("[^a-zA-Z0-9-_]", "_");
//
//		if (!loggerMap.containsKey(featureFileName)) {
//			loggerMap.put(featureFileName, createLoggerForFeature(featureFileName));
//		}
//		logger = loggerMap.get(featureFileName);
//
//		logger.info("🔄 Starting scenario: {}", scenario.getName());
//
//		scenarioStepSummary.set(new StringBuilder("Executed Steps:\n"));
//		DriverFactory.initializeDriver();
//		driver = DriverFactory.getDriver();
//		pageManager = new PageObjectManager(driver);
//
//		if (extent != null) {
//			ExtentTest test = extent.createTest(scenario.getName());
//			extentTest.set(test);
//		}
//
//		if (scenario.getSourceTagNames().stream()
//				.anyMatch(tag -> tag.equalsIgnoreCase("@Login") || tag.equalsIgnoreCase("@Home")
//						|| tag.equalsIgnoreCase("@CPA_Overview") || tag.equalsIgnoreCase("@CPA_BranchCustomerSelection")
//						|| tag.equalsIgnoreCase("@CPA_PeerSelection") || tag.equalsIgnoreCase("@CPA_CreateScenario")
//						|| tag.equalsIgnoreCase("@CPA_ViewScenarioImpact") || tag.equalsIgnoreCase("@ARCA_Overview")
//						|| tag.equalsIgnoreCase("@ARCA_CustomerAnalysis")
//						|| tag.equalsIgnoreCase("@ARCA_FilterCustomerProductCombinations")
//						|| tag.equalsIgnoreCase("@ARCA_CustomerSelection") || tag.equalsIgnoreCase("@ARCA_ProfitBridge")
//						|| tag.equalsIgnoreCase("@ARCA_CreateScenario"))) {
//
//			LoginPage loginPage = pageManager.getLoginPage();
//			loginPage.navigateTo();
//			loginPage.loginTo();
//			loginPage.loginBtn();
//		}
//	}
//
//	@After
//	public void tearDown(Scenario scenario) {
//		try {
//			ExtentTest test = extentTest.get();
//
//			if (scenario.isFailed()) {
//				String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName());
//
//				// ✅ Attach screenshot to Extent Report
//				if (test != null && screenshotPath != null) {
//					test.fail("Step Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//				}
//
//				// ✅ Attach screenshot to Cucumber report
//				if (screenshotPath != null) {
//					byte[] screenshotBytes = Files.readAllBytes(Paths.get(screenshotPath));
//					scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
//				}
//
//				logger.error("❌ Scenario FAILED: {}", scenario.getName());
//			} else {
//				if (test != null) {
//					test.pass("Scenario Passed");
//				}
//				logger.info("✅ Scenario PASSED: {}", scenario.getName());
//			}
//
//			StringBuilder summary = scenarioStepSummary.get();
//			if (test != null && summary != null) {
//				test.info("----- Scenario Summary -----\n" + summary.toString());
//			}
//
//			logger.info("─────────────────────────────── End of Scenario ───────────────────────────────");
//
//			extent.flush();
//		} catch (Exception e) {
//			System.err.println("Error in tearDown(): " + e.getMessage());
//		} finally {
//			if (driver != null) {
//				driver.quit();
//			}
//		}
//	}
//
//	public static void logStep(String stepDescription) {
//		if (logger != null)
//			logger.info(stepDescription);
//
//		ExtentTest test = extentTest.get();
//		if (test != null)
//			test.info(stepDescription);
//
//		StringBuilder summary = scenarioStepSummary.get();
//		if (summary != null)
//			summary.append("• ").append(stepDescription).append("\n");
//	}
//
//	private Logger createLoggerForFeature(String featureFileName) {
//		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
//
//		String logFilePath = "logs/WPC_USESI_Logs_" + logsFolderTimestamp + "/" + featureFileName + "_"
//				+ logsFolderTimestamp + ".log";
//
//		FileAppender fileAppender = new FileAppender();
//		fileAppender.setContext(loggerContext);
//		fileAppender.setName("FILE_" + featureFileName);
//		fileAppender.setFile(logFilePath);
//
//		PatternLayoutEncoder encoder = new PatternLayoutEncoder();
//		encoder.setContext(loggerContext);
//		encoder.setPattern("%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level ▶ %msg%n");
//		encoder.start();
//
//		fileAppender.setEncoder(encoder);
//		fileAppender.start();
//
//		ch.qos.logback.classic.Logger dynamicLogger = loggerContext.getLogger("FeatureLogger_" + featureFileName);
//		dynamicLogger.detachAndStopAllAppenders();
//		dynamicLogger.addAppender(fileAppender);
//		dynamicLogger.addAppender(loggerContext.getLogger("ROOT").getAppender("STDOUT"));
//		dynamicLogger.setAdditive(false);
//
//		return dynamicLogger;
//	}
//}

///////////////////// Complete scenario logg in to Extent Report
package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

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

	private static ExtentReports extent;

	static {
		try {
			extent = ExtentReporter.getInstance();
		} catch (IOException e) {
			System.err.println("❌ Failed to initialize ExtentReporter: " + e.getMessage());
		}
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static ThreadLocal<StringBuilder> scenarioStepSummary = new ThreadLocal<>();

	public static Logger logger;
	private static final Map<String, Logger> loggerMap = new ConcurrentHashMap<>();

	private static final String logsFolderTimestamp;

	static {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		logsFolderTimestamp = sdf.format(new Date());
		new File("logs/WPC_USESI_Logs_" + logsFolderTimestamp).mkdirs();
	}

	@Before
	public void setUp(Scenario scenario) throws IOException, InterruptedException {
		String rawFeaturePath = scenario.getUri().getPath();
		String featureFileName = rawFeaturePath.substring(rawFeaturePath.lastIndexOf("/") + 1).replace(".feature", "")
				.replaceAll("[^a-zA-Z0-9-_]", "_");

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

				// Attach screenshot to Extent Report
				if (test != null && screenshotPath != null) {
					test.fail("Step Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				}

				// Attach screenshot to Cucumber report
				if (screenshotPath != null) {
					byte[] screenshotBytes = Files.readAllBytes(Paths.get(screenshotPath));
					scenario.attach(screenshotBytes, "image/png", "Failure Screenshot");
				}

				logger.error("❌ Scenario FAILED: {}", scenario.getName());
			} else {
				if (test != null) {
					test.pass("Scenario Passed");
				}
				logger.info("✅ Scenario PASSED: {}", scenario.getName());
			}

			StringBuilder summary = scenarioStepSummary.get();
			if (test != null && summary != null) {
				test.info("----- Scenario Summary -----\n" + summary.toString());
			}

			logger.info("─────────────────────────────── End of Scenario ───────────────────────────────");

			// Ensure Extent Report is flushed after every scenario
			extent.flush();
		} catch (Exception e) {
			System.err.println("Error in tearDown(): " + e.getMessage());
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

	private Logger createLoggerForFeature(String featureFileName) {
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

		String logFilePath = "logs/WPC_USESI_Logs_" + logsFolderTimestamp + "/" + featureFileName + "_"
				+ logsFolderTimestamp + ".log";

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
		dynamicLogger.addAppender(loggerContext.getLogger("ROOT").getAppender("STDOUT"));
		dynamicLogger.setAdditive(false);

		return dynamicLogger;
	}
}
