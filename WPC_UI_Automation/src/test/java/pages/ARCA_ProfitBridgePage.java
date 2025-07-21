package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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

public class ARCA_ProfitBridgePage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public ARCA_ProfitBridgePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(100)); // ✅ wait initialized once
		actions = new Actions(driver);
	}

	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Locator
	// xpath of the profit bridge chart
	By arca_pb_chart = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Go to Simulator button
	By arca_pb_goToSimulator = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");

	// xpath of the Filter button
	By arca_pb_filterBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]");

	// xpath of the Filter - Selected Cost Metric
	By arca_pb_filterOption01 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Filter - Customer and Product Combinations
	By arca_pb_filterOption02 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]");

	// xpath of the Filter - Customer and Product Combinations - Value
	By arca_pb_filterOption02Value = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Filter - Cancel button
	By arca_pb_filterCancelBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");

	// xpath of the Filter - Apply button
	By arca_pb_filterApplyBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]");

	// xapth of the Chart header text -
	By arca_pb_chartHeaderText = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/h3[1]");
	// xpath of the Download icon - Chart (Camera)
	By arca_pb_downloadIcon = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]");

	// xpath of the back button
	By arca_pb_backBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");

	// xpath of the Select Customer Button - SOC
	By arca_cs_selectCustomerBtnSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");

	// xpath of to extract the customer Id - SOC
	// Table first row
	By arca_cs_customerIdSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// xpath of the Create Scenario - Filters
	By arca_csc_filter = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]");

	// xpath of the Create Scenario - Filters - Customer and Product Combination
	// option
	By arca_csc_filterCustomerProductCombinationOption = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Create Scenario - Filters - Customer and Product Combination
	// option - Value Selected
	By arca_csc_filterCustomerProductCombinationOptionValue = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xapth of the Create Scenario - Customer details button
	By arca_csc_customerDetailsBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/button[1]");

	// Navigating to the Profit Bridge Screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Profit Bridge screen
		driver.get(ConfigReader.arca_profitBridge());
		// waits for the profit bridge chart
		waitForElement(arca_pb_chart);
		// waits for the Go to Simulator button
		waitForElement(arca_pb_goToSimulator);
		System.out.println(
				"=> The Profit Bridge screen is loaded with the Pricing (Actual vs System %) and Profit Bridge (Gross Profit to Enterprise Profit) chart");
		Thread.sleep(1000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/ScenarioBuilder/ProfitBridge/ProfitBridgeScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Auto Root Cause Analysis - Scenario Builder -
		// Profit Bridge
		// Profit Bridge Screen
		// - Customer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_profitBridge();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully!, Landed on the Profit Bridge Screen");
	}

	public String customerDetails, customerProductDetails;

	// Clicks the Filter button and performs operations
	public void filters() throws IOException, InterruptedException {
		// waits for the filter button
		WebElement pb_filterBtn = waitForElement(arca_pb_filterBtn);
		pb_filterBtn.click();
		// waits for the Filter - Selected Cost Metric
		WebElement pb_filterOption01 = waitForElement(arca_pb_filterOption01);
		pb_filterOption01.click();
		// waits for the Filter - Customer and Product Combinations
		WebElement pb_filterOption02 = waitForElement(arca_pb_filterOption02);
		pb_filterOption02.click();
		// waits for the Filter - Customer and Product Combinations - Value -- This
		// This extracts the value of filter option
		WebElement pb_filterOption02Value = waitForElement(arca_pb_filterOption02Value);
		String filterOption02Value = pb_filterOption02Value.getText().trim();
		// This extracts the customer details from the filter option value
		this.customerDetails = filterOption02Value.split("\\+")[0].trim();
		this.customerProductDetails = filterOption02Value.split("\\+")[1].trim();
		// waits for the Filter - Cancel button
		WebElement pb_filterCancelBtn = waitForElement(arca_pb_filterCancelBtn);
		pb_filterCancelBtn.click();
		// waits for the chart
		waitForElement(arca_pb_chart);
		// waits for the chart header text
		WebElement pb_chartHeaderText = waitForElement(arca_pb_chartHeaderText);
		String chartHeaderText = pb_chartHeaderText.getText().trim();
		// extracts the customer name from the header text
		String custmerDetailsHeaderText = chartHeaderText.split("-")[1].trim();
		// Validating the Customer details
		if (!custmerDetailsHeaderText.equalsIgnoreCase(customerDetails)) {
			throw new AssertionError("=> Mismatch in the Customer deatils | Selected = [" + customerDetails
					+ "] vs Filter = [" + custmerDetailsHeaderText + "]");
		}
		System.out.println(
				"=> The Customer details matched and confirms the chart is of the Selected Customer and Product Combinations");
		Thread.sleep(2000);
	}

	// Clicks on the camera icon - downloads the chart
	public void downloadIcon() throws IOException, InterruptedException {
		// waits for the camera icon
		WebElement pb_downloadIcon = waitForElement(arca_pb_downloadIcon);
		pb_downloadIcon.click();
		System.out.println("=> The Download Icon of the chart is clicked and downloaded the chart");
		Thread.sleep(2000);
		waitForElement(arca_pb_chart);
	}

	// Clicks on the Back btn
	public void backBtn() throws IOException, InterruptedException {
		// waits for the back button
		WebElement pb_backBtn = waitForElement(arca_pb_backBtn);
		pb_backBtn.click();
		// extracts the customer id from the filter that is upto underscore
		String customerId = customerDetails.split("_")[0];
		waitForElement(arca_cs_selectCustomerBtnSOC);
		WebElement cs_customerIdSOC = waitForElement(arca_cs_customerIdSOC);
		String customerIdSOC = cs_customerIdSOC.getText().trim();
		// Validating the Customer details
		if (!customerIdSOC.equalsIgnoreCase(customerId)) {
			throw new AssertionError("=> Mismatch in the Customer ID | Profit Bridge screen = [" + customerId
					+ "] vs Customer Selection screen = [" + customerIdSOC + "]");
		}
		System.out.println("=> The Customer ID's matched and confirms that the redirection is as expected");
		Thread.sleep(2000);
		// redirecting to the create scenario screen
		driver.get(ConfigReader.arca_profitBridge());
		waitForElement(arca_pb_chart);

	}

	// Clicks the Go To Simulator button
	public void goToSimulatorBtn() throws IOException, InterruptedException {
		// This was called as this method executed as a separate
//		filters();
		Thread.sleep(2000);
		// waits for the Go To Simulator button
		WebElement pb_goToSimulator = waitForElement(arca_pb_goToSimulator);
		pb_goToSimulator.click();
		Thread.sleep(2000);
		waitForElement(arca_csc_customerDetailsBtn);
		// Validating based the redirection via URL and filterss
		WebElement csc_filter = waitForElement(arca_csc_filter);
		csc_filter.click();
		Thread.sleep(1000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerProductCombinationOption = waitForElement(
				arca_csc_filterCustomerProductCombinationOption);
		csc_filterCustomerProductCombinationOption.click();
		// Waits for the Filter - Options - Value
		WebElement csc_filterCustomerProductCombinationOptionValue = waitForElement(
				arca_csc_filterCustomerProductCombinationOptionValue);
		Thread.sleep(3000);
		String filterCustomerProductCombinationOptionValue = csc_filterCustomerProductCombinationOptionValue.getText()
				.trim();

		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerProductDetails.equalsIgnoreCase(filterCustomerProductCombinationOptionValue)) {
			throw new AssertionError(
					"=> Mismatch in Customer and Product Combination: Profit Bridge = [" + customerProductDetails
							+ "] vs Filter of Create Scenario = [" + filterCustomerProductCombinationOptionValue + "]");
		}
		System.out.println(
				"=> The Customer and Product Combination names matched successfully and this validates that selected record is loaded in the Create Scenario Screen:  "
						+ customerProductDetails + " == " + filterCustomerProductCombinationOptionValue);

		// Validates the URL after redirection
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully redirected to the Create Scenario screen");

		Thread.sleep(1000);

	}

}
