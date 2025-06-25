package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	// Gets the Driver Status
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // ✅ wait initialized once
	}

	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Home Screen
	By homeScreen = By.xpath("//*[@id=\"bodyContent\"]/div[2]/div[2]");
	// Profile Icon
	By ProfileIcon = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/div[2]/div[3]/div[1]");
	// Customer Peer Analysis - Card
	By CustomerPeerAnalysisCard = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]");
	// Auto Root Cause Analysis - Card
	By AutoRootCauseAnalysisCard = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]");
	// Customer Peer Analysis - Side NavBar
	By CustomerPeerAnalysisSideNavBar = By.xpath("//*[@id='125463']");
	// Auto Root Cause Analysis - Side NavBar
	By AutoRootCauseAnalysisSideNavBar = By.xpath("//*[@id='125464']");
	// Customer Peer Analysis - Side NavBar - Options
	By CustomerPeerAnalysisSideNavBarOptions = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]");
	// Auto Root Cause Analysis - Side NavBar - Options
	By AutoRootCauseAnalysisSideNavBarOptions = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]");

	// Navigating to the homescreen Screen
	public void navigateTo() throws IOException {
		// This gets the URL of the homescreen Screen
		driver.get(ConfigReader.homeScreenUrl());
		// Wait for homescreen page to load by checking known visible element
		waitForElement(CustomerPeerAnalysisCard);
		// Take screenshot after the page is fully loaded
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/HomeScreen/homescreenScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	// Gets the Profile Icon and Hovers on it
	public void profileIcon() throws IOException, InterruptedException {
		// Profile Icon
		WebElement profileHover = waitForElement(ProfileIcon);
		// Hovers on the profile Icon
		new Actions(driver).moveToElement(profileHover).perform();
		System.out.println("--- Hovered Successfully on the Profile Icon!");

		// Take Screenshot of the Profile Hover
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/HomeScreen/ProfileIconHover.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Thread.sleep(500);
	}

	// Customer Peer Analysis - Card
	public void customerPeerAnalysisCardClick() throws IOException, InterruptedException {
		WebElement customerPeerAnalysisCard = waitForElement(CustomerPeerAnalysisCard);
		customerPeerAnalysisCard.click();
		System.out.println("---Clicked Customer Peer Analysis card.");

		// Verify whether it landed on the Customer Peer Analysis Card - Overview screen
		String currentUrl = driver.getCurrentUrl();
		String expectedCustomerOverviewUrl = ConfigReader.customerOverview();

		if (!currentUrl.equalsIgnoreCase(expectedCustomerOverviewUrl)) {
			throw new AssertionError(
					"--- Customer Peer Analysis Card - Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

		Thread.sleep(10000);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/HomeScreen/CustomerPeerAnalysisCardClick.png");
		FileHandler.copy(sourcefile, screenshotPath);

		driver.navigate().back();
		Thread.sleep(2000);
	}

	// Auto Root Cause Analysis - Card
	public void autoRootCauseAnalysisCardClick() throws IOException, InterruptedException {
		WebElement autoRootCauseAnalysisCard = waitForElement(AutoRootCauseAnalysisCard);
		autoRootCauseAnalysisCard.click();
		System.out.println("---Clicked Auto Root Cause Analysis card.");

		// Verify whether it landed on the Auto Root Cause Analysis Card - Overview
		// screen
		String currentUrl = driver.getCurrentUrl();
		String expectedAutoRootCauseUrl = ConfigReader.autorootOverview();

		if (!currentUrl.equalsIgnoreCase(expectedAutoRootCauseUrl)) {
			throw new AssertionError(
					"--- Auto Root Cause Analysis Card - Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

		Thread.sleep(10000);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/HomeScreen/AutomatedRootCauseAnalysisCardClick.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// This goes back to the homescreen screen
		driver.navigate().back();
		Thread.sleep(2000);
	}

	// Verifies whether the user stays on the homescreen Screen
	public void homescreenPageStay() throws IOException, InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.homeScreenUrl();
		// Screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/HomeScreen/StaysOnhomescreenScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"--- homescreen - Unexpected redirection :( !Current URL you're on: " + currentUrl);
		}
	}

	// Customer Peer Analysis - Side NavBar
	public void customerPeerAnalysisSideNavBar() throws IOException, InterruptedException {
		WebElement customerPeerAnalysisSideNav = waitForElement(CustomerPeerAnalysisSideNavBar);
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// customerPeerAnalysis);
		// Thread.sleep(1000);
		new Actions(driver).moveToElement(customerPeerAnalysisSideNav).click().perform();

		System.out.println("--- Customer Peer Analysis Side Navigation is clicked!");

		// Verify whether it landed on the Customer Peer Analysis Side NavBar - Overview
		// screen
		String currentUrl = driver.getCurrentUrl();
		String expectedCustomerOverviewUrl = ConfigReader.customerOverview();

		if (!currentUrl.equalsIgnoreCase(expectedCustomerOverviewUrl)) {
			throw new AssertionError(
					"--- Customer Peer Analysis Side NavBar - Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}
		Thread.sleep(2000);

		// Hover submenu items
		List<WebElement> customerSubOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a")));

		System.out.println("--- Found " + customerSubOptions.size() + " options under Customer Peer Analysis.");
		for (WebElement option : customerSubOptions) {
			new Actions(driver).moveToElement(option).perform();
			System.out.println("--- Hovered: " + option.getText());
			Thread.sleep(2000);
			// Takes Screenshot of the Customer Peer Analysis Side NavBar click
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
			File screenshotPath = new File(
					"src/test/resources/screenshots/HomeScreen/CustomerPeerAnalysisSideNavBar.png");
			FileHandler.copy(sourcefile, screenshotPath);

		}
		// Move back to main
//        new Actions(driver).moveByOffset(-300, 0).perform();
		driver.navigate().back();
		Thread.sleep(1000);

	}

	// Auto Root Cause Analysis - Side NavBar
	public void autoRootCauseAnalysisSideNavBar() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebElement autoRootSidebar = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='125464']")));
		new Actions(driver).moveToElement(autoRootSidebar).click().perform();
		System.out.println("--- Auto Root Cause Analysis Side Navigation is clicked!");
		// Verify whether it landed on the Auto Root Cause Analysis Side NavBar -
		// Overview screen
		String currentUrl = driver.getCurrentUrl();
		String expectedAutoRootCauseUrl = ConfigReader.autorootOverview();

		if (!currentUrl.equalsIgnoreCase(expectedAutoRootCauseUrl)) {
			throw new AssertionError(
					"--- Auto Root Cause Analysis Side NavBar - Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

		Thread.sleep(2000);

		// Hover sub-options under Auto Root
		List<WebElement> autoRootSubOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a")));

		System.out.println("Found " + autoRootSubOptions.size() + " options under Auto Root Cause Analysis.");
		for (WebElement option : autoRootSubOptions) {
			new Actions(driver).moveToElement(option).perform();
			System.out.println("Hovered: " + option.getText());
			Thread.sleep(2000);
			// Takes Screenshot of the Auto Root Cause Analysis Side NavBar click
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
			File screenshotPath = new File(
					"src/test/resources/screenshots/HomeScreen/AutoRootCauseAnalysisSideNavBar.png");
			FileHandler.copy(sourcefile, screenshotPath);
		}

		// Move back to homescreen screen
		driver.navigate().back();
		Thread.sleep(1000);

	}

}
