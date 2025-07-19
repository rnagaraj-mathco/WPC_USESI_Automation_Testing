package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class CPA_ViewScenarioImpactPage {
	WebDriver driver;
	WebDriverWait wait;

	// gets driver status
	public CPA_ViewScenarioImpactPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // wait initialized once
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Locators
	// Loads the Create Scenario screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Overview screen
		driver.get(ConfigReader.cpa_createScenario());
		// waits till the silder component is loaded
//		waitForElement(cpa_csc_scenarioSlider);
		Thread.sleep(2000);
//		waitForElement(cpa_csc_saveAndShowImpactBtn);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/ScenarioBuilder/ViewScenarioImapact/ViewScenarioImapactScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Scenario builder - View Scenario Impact
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.cpa_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully landed on the Scenario screen with the sliders required to simulate the scenario");

	}

}
