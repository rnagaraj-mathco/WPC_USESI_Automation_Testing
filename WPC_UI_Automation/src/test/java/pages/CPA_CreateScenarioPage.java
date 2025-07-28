package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class CPA_CreateScenarioPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public CPA_CreateScenarioPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // wait initialized once
		actions = new Actions(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	// Locators
	// xpath of the Create Scenario screen - Slider component
	By cpa_csc_scenarioSlider = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]");

	// xpath of the Create Scenario screen - Back btn
	By cpa_csc_backBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/button[1]");

	// xpath of the Create Scenario screen - Filter button
	By cpa_csc_filtersBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Create Scenario screen - Reset button
	By cpa_csc_resetBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");

	// xpath of the Create Scenario screen - Filter - Customer + Peer Selection Name
	// option
	By cpa_csc_filterCustomerPeerGroupOption = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Create Scenario screen - Filter - Customer + Peer Selection Name
	// - Value01
	By cpa_csc_filterCustomerPeerGroupOptionValue01 = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Create Scenario screen - Filter - Customer + Peer Selection Name
	// - Value02
	By cpa_csc_filterCustomerPeerGroupOptionValue02 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[1]/label[2]/span[2]");

	// xpath of the Filter - Cancel button
	By cpa_csc_filterCancelBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the save and shwow impact
	By cpa_csc_saveAndShowImpactBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/button[1]");

	// xpath of the save and show impace button error message
	By cpa_csc_errorMessage = By.xpath("//h4[contains(text(),'❌ Enter a Scenario Name... !')]");

	// xpath of the save and show impace button success message
	By cpa_csc_successMessage = By.xpath(
			"//h4[contains(text(),'✅ Scenario created successfully! 🚀 Redirecting you to the Impact screen... 📊')]");

	// xpath of the Filter - Apply button
	By cpa_csc_filterApplyBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]");

	// Comparative Peer Group Selection table
	By cpa_ps2_comparativePeerGroupSelectionTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]");

	// Peer Selection -02
	// Comparative Peer Group Selection table - First row BILL To ID
	By cpa_ps2_TableFirstRowBillToIdCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// hovering on the components of the Peer Comparison - Pricing and Peer
	// Comparison - Cost To Serve chart
	// xpath of the Peer Comparison - Pricing (PCP) - Customer Peer Average dot
	By cpa_csc_customerPeerAverageDotPCP = By.xpath("//span[contains(@class, 'MuiSlider-thumb') and @role='slider']");

	// xpath of the Peer Comparison - Pricing (PCP) - System Price bar
	By cpa_csc_systemPriceBarPCP = By.xpath("//span[contains(@class, 'MuiBox-root jss20194')]");

	// xpath of the Peer Comparison - Pricing (PCP) - Peer Average Pricing bar
	By cpa_csc_peerAveragePricingPCP = By.xpath("//span[contains(@class, 'MuiBox-root jss20195')]");

	// xapth of the Customer Range/Average text
	By cpa_csc_customerRangeText = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/h4[1]");

	// xpath of the Start Simulating Here - Pricing (SSP) - Customer New Average
	By cpa_csc_customerNewAverageSSP = By
			.xpath("(//div[contains(@class,'MuiBox-root') and contains(@style,'cursor: pointer;')]//span)[4]");

	// xpath of the Start Simulating Here - Pricing (SSP) - Customer New Average
	// Text
	By cpa_csc_customerNewAverageTextSSP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/h4[1]");
	// Peer Comparison - Cost To Serve
	// xpath of the Peer Comparison - Cost To Serve - Customer Average
	By cpa_csc_customerAveragePC = By.xpath("(//div[contains(@class, 'MuiBox-root') and @style])[22]");

	// xpath of the Peer Comparison - Cost To Serve - Customer Average Text
	By cpa_csc_customerAverageTextPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/h4[1]");

	// xpath of the Peer Comparison - Cost To Serve - Peer Average
	By cpa_csc_peerAveragePC = By.xpath("(//div[contains(@class, 'MuiBox-root') and @style])[21]");

	// xpath of the Peer Comparison - Cost To Serve - Peer Average Text
	By cpa_csc_peerAverageTextPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h4[1]");

	// xpath of the Peer Comparison - Cost To Serve - Peer
	By cpa_csc_peerPC = By.xpath("(//div[contains(@class, 'MuiBox-root') and @style])[20]");

	// xpath of the Peer Comparison - Cost To Serve - Peer Text
	By cpa_csc_peerTextPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h4[1]");

	// Start Simulating Here - Cost To Serve (SSCS)
	// xpath of the Start Simulating Here - Cost To Serve (SSCS) - Customer Average
	// Text
	By cpa_csc_customerAverageTextSSCS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/h4[2]");

	// xpath of the Start Simulating Here - Cost To Serve (SSCS) - Peer Average
	// Text
	By cpa_csc_peerAverageTextSSCS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/h4[1]");

	// xpath of the Inbound Frieght - Customer Average
	// The position starts from 9 and can mention till last dot of the component
	By cpa_csc_inboundFrieghtCustomerAverageSSCS = By.xpath(
			"(//div[contains(@class,'MuiBox-root') and contains(@class,'jss')]//span[contains(@class,'MuiSlider-root')]/span)[9]");

	// xpath of the Inbound Frieght - Peer Average
	// The position starts from 4 for this metric and next metric starts from 8
	// (multiples of 4)
	By cpa_csc_inboundFrieghtPeerAverageSSCS = By.xpath(
			"(//div[contains(@class, 'MuiBox-root') and contains(@style, 'cursor: pointer') and contains(@style, 'translate')])[10]");

	// Entering the Numeric Values to Order Handling costs (OHC)
	// xpath of the inputfied
	By cpa_csc_inputFieldOHC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[8]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]");

	// xpath of the slider max value:
	By cpa_csc_sliderMaxValueOHC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/div[9]/div[3]/div[1]/div[1]/div[2]/div[2]/h5[1]");

	// xpath of the Entering Scenario Name
	By cpa_csc_enterScenarioName = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the View Scenario Impact - All three widgets
	By cpa_vsi_allThreewidgets = By
			.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div");

	// xapth of the Filters btn
	By cpa_vsi_filters = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]");

	// xpath of the Filters - Customer + Scenario Name
	By cpa_vsi_filtersCustomerScenarioOption = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Filters - Customer + Scenario Name - Value 01
	By cpa_vsi_filterOptionValue01 = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Filters - Cancel btn
	By cpa_vsi_filtersCancelBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");

	// xpath of the chart component
	By cpa_vsi_chartComponent = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// Loads the Create Scenario screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Overview screen
		driver.get(ConfigReader.cpa_createScenario());
		// waits till the silder component is loaded
		waitForElement(cpa_csc_scenarioSlider);
		Thread.sleep(2000);
		waitForElement(cpa_csc_saveAndShowImpactBtn);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/ScenarioBuilder/CreateScenario/CreateScenarioScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Auto Root Cause Analysis - Overview screen
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.cpa_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully landed on the Scenario screen with the sliders required to simulate the scenario");

	}

	// clicks the save and show impact button without entering the scenario name
	public void saveAndShowImpactBtnWithoutName() throws IOException, InterruptedException {
		// waits for the Save and Show Impact button
		WebElement csc_saveAndShowImpactBtn = waitForElement(cpa_csc_saveAndShowImpactBtn);
		csc_saveAndShowImpactBtn.click();
		errorMessage();
		Thread.sleep(1000);
		waitForElement(cpa_csc_scenarioSlider);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/ScenarioBuilder/CreateScenario/SaveAndShowImpactBtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Thread.sleep(3000);
	}

	// This is to validate the error message
	public void errorMessage() {
		// Assertion
		// Assertion to confirm message text
		WebElement errorToasterMessage = waitForElement(cpa_csc_errorMessage);
		String actualMsg = errorToasterMessage.getText();
		String expectedMsg = "❌ Enter a Scenario Name... !";
		Assert.assertEquals("=> The Error Toaster message validation for the Save and Show Impact button has failed!",
				expectedMsg, actualMsg);
	}

	// This is to validate the success message
	public void successMessage() {
		// Assertion
		// Assertion to confirm message text
		WebElement successToasterMessage = waitForElement(cpa_csc_successMessage);
		String actualMsg = successToasterMessage.getText();
		String expectedMsg = "✅ Scenario created successfully! 🚀 Redirecting you to the Impact screen... 📊";
		Assert.assertEquals("=> The Success Toaster message validation for the Save and Show Impact button has failed!",
				expectedMsg, actualMsg);
	}

	private String filterCustomerPeerGroupOptionValue01;

	// clicks on filters and perform actions
	public void filters() throws IOException, InterruptedException {
		// waits for the filter button
		WebElement csc_filter = waitForElement(cpa_csc_filtersBtn);
		csc_filter.click();
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerPeerGroupOption = waitForElement(cpa_csc_filterCustomerPeerGroupOption);
		csc_filterCustomerPeerGroupOption.click();
		// Waits for the Filter - Options - Value01
		WebElement csc_filterCustomerPeerGroupOptionValue01 = waitForElement(
				cpa_csc_filterCustomerPeerGroupOptionValue01);
		// extracts the value 01 for the validation of back button
		this.filterCustomerPeerGroupOptionValue01 = csc_filterCustomerPeerGroupOptionValue01.getText().trim();
		Thread.sleep(2000);
		// waits for the Filter - Options - Value01

//		WebElement csc_filterCustomerPeerGroupOptionValue02 = waitForElement(
//				cpa_csc_filterCustomerPeerGroupOptionValue02);
//		csc_filterCustomerPeerGroupOptionValue02.click();
//		String filterCustomerPeerGroupOptionValue02 = csc_filterCustomerPeerGroupOptionValue02.getText().trim();
		// clicks on the apply button
		WebElement csc_filterApplyBtn = waitForElement(cpa_csc_filterApplyBtn);
		csc_filterApplyBtn.click();
		System.out.println("=> The Customer + Peer Group Name: " + filterCustomerPeerGroupOptionValue01
				+ " was clicked and slider is loaded to simulate the scenario");
		waitForElement(cpa_csc_scenarioSlider);
		Thread.sleep(3000);
	}

	// Extracts the Filter - Customer and Product Combination - Value 01
	public void filtersOptionValue01() throws InterruptedException {
		WebElement csc_filter = waitForElement(cpa_csc_filtersBtn);
		csc_filter.click();
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerPeerGroupOption = waitForElement(cpa_csc_filterCustomerPeerGroupOption);
		csc_filterCustomerPeerGroupOption.click();

		// Waits for the Filter - Options - Value01
		WebElement csc_filterCustomerPeerGroupOptionValue01 = waitForElement(
				cpa_csc_filterCustomerPeerGroupOptionValue01);
		// extracts the value 01 for the validation of back button
		this.filterCustomerPeerGroupOptionValue01 = csc_filterCustomerPeerGroupOptionValue01.getText().trim();
		Thread.sleep(2000);
		// clicks on the cancel button
		waitForElement(cpa_csc_filterCancelBtn).click();

	}

	private String customerId, customerDetails;

	// clicks on the back button
	public void backBtn() throws IOException, InterruptedException {
		// navigates to extracts the Filter - Customer and Product Combination - Value
		// 01 - Defined bcz to test this step separately
//		filtersOptionValue01();

		this.customerDetails = filterCustomerPeerGroupOptionValue01.split("\\+")[0].trim();
		this.customerId = customerDetails.split("_")[0].trim();
		// waits for the back button
		WebElement csc_backBtn = waitForElement(cpa_csc_backBtn);
		csc_backBtn.click();
		System.out.println(customerId);
		System.out.println(
				"=> The Back button was clicked and redirected to the Peer Selection - Select Comparative Peer Group table screen");
		// This is pending due to wrong navigation ---------------------------
//		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
//		// Extracts the BILL To ID - Table first row
//		WebElement ps2_TableFirstRowBillToIdCPGS = waitForElement(cpa_ps2_TableFirstRowBillToIdCPGS);
//		String customerIdCPGS = ps2_TableFirstRowBillToIdCPGS.getText().trim();
//		// Validating the Customer details
//		if (!customerIdCPGS.equalsIgnoreCase(customerId)) {
//			throw new AssertionError("=> Mismatch in the Customer Id | Selected = [" + customerId
//					+ "] vs Comparative Peer Group Selection table = [" + customerIdCPGS + "]");
//		}
//		System.out.println(
//				"=> The Customer ID  matched and confirms that the redirection is of the same customer records");
		// redirecting to the create scenario screen for now
		Thread.sleep(3000);
		driver.get(ConfigReader.cpa_createScenario());
		Thread.sleep(2000);

	}

	// Clicks and hovers on the components of the Peer Comparison - Pricing and Peer
	// Comparison - Cost To Serve chart
	public void hoversSlider() throws IOException, InterruptedException {
		// waits for the Peer Comparison - Pricing (PCP) - Customer Peer Average dot
		WebElement csc_customerPeerAverageDotPCP = waitForElement(cpa_csc_customerPeerAverageDotPCP);
		Thread.sleep(2000);
		actions.moveToElement(csc_customerPeerAverageDotPCP, -5, 0).perform();
		Thread.sleep(1000);
		WebElement csc_customerRangeText = waitForElement(cpa_csc_customerRangeText);

		actions.moveToElement(csc_customerRangeText).click().perform();
		System.out.println("=> Hovered on the Customer Peer Average of Peer Comparison Pricing dot");
//		Thread.sleep(1000);
		// Not getting the exact xpath and the xpath of the bar are updating dynamically
//		// waits for the Peer Comparison - Pricing (PCP) - System Price bar
//		WebElement csc_systemPriceBarPCP = waitForElement(cpa_csc_systemPriceBarPCP);
//		Thread.sleep(1000);
//		actions.moveToElement(csc_systemPriceBarPCP).perform();
//		Thread.sleep(1000);
//		actions.moveToElement(csc_customerRangeText).click().perform();
//		Thread.sleep(1000);
//		// waits for the Peer Comparison - Pricing (PCP) - Peer Average Pricing bar
//		WebElement csc_peerAveragePricingPCP = waitForElement(cpa_csc_peerAveragePricingPCP);
//		Thread.sleep(2000);
//		actions.moveToElement(csc_peerAveragePricingPCP).perform();
//		Thread.sleep(1000);
//		actions.moveToElement(csc_customerRangeText).click().perform();
//		Thread.sleep(1000);
		// waits for the Start Simulating Here - Pricing (SSP) - Customer Peers Average
		WebElement csc_customerNewAverageSSP = waitForElement(cpa_csc_customerNewAverageSSP);
		Thread.sleep(2000);
		actions.moveToElement(csc_customerNewAverageSSP, 10, 0).perform();
		WebElement csc_customerNewAverageTextSSP = waitForElement(cpa_csc_customerNewAverageTextSSP);
		actions.moveToElement(csc_customerNewAverageTextSSP).click().perform();
//		actions.clickAndHold(csc_customerPeerAverageSSP).moveByOffset(40, 0).release().perform();
		Thread.sleep(4000);
		System.out.println("=> Hovered on the Customer New Average of Start Simulating Here - Pricing");

		// waits for the Peer Comparison - Cost To Serve - Customer Average
		WebElement csc_customerAveragePC = waitForElement(cpa_csc_customerAveragePC);
		Thread.sleep(1000);
		actions.moveToElement(csc_customerAveragePC, -10, 0).perform();
		WebElement csc_customerAverageTextPC = waitForElement(cpa_csc_customerAverageTextPC);
		actions.moveToElement(csc_customerAverageTextPC).click().perform();
		System.out.println("=> Hovered on the Customer Average of Peer Comparison - Cost To Serve chart");
		Thread.sleep(4000);

		// waits for the Peer Comparison - Cost To Serve - Peer Average
		WebElement csc_peerAveragePC = waitForElement(cpa_csc_peerAveragePC);
		Thread.sleep(1000);
		actions.moveToElement(csc_peerAveragePC).perform();
		WebElement csc_peerAverageTextPC = waitForElement(cpa_csc_peerAverageTextPC);
		actions.moveToElement(csc_peerAverageTextPC).click().perform();
		System.out.println("=> Hovered on the Peer Average of Peer Comparison - Cost To Serve chart");

		// waits for the Peer Comparison - Cost To Serve - Peer
		WebElement csc_peerPC = waitForElement(cpa_csc_peerPC);
		Thread.sleep(1000);
		actions.moveToElement(csc_peerPC).perform();
		WebElement csc_peerTextPC = waitForElement(cpa_csc_peerTextPC);
		actions.moveToElement(csc_peerTextPC).click().perform();
		Thread.sleep(5000);
		System.out.println("=> Hovered on the Peer of Peer Comparison - Cost To Serve chart");

	}

	// Clicks and hovers the slider of the Start Simulating Here - Cost To Serve
	public void adjustSlider() throws IOException, InterruptedException {
		// Start Simulating Here - Pricing (SSP)
		// waits for the Customer Peers Average
		WebElement csc_customerNewAverageSSP = waitForElement(cpa_csc_customerNewAverageSSP);
		Thread.sleep(2000);
		actions.moveToElement(csc_customerNewAverageSSP).perform();
		WebElement csc_customerNewAverageTextSSP = waitForElement(cpa_csc_customerNewAverageTextSSP);
		actions.moveToElement(csc_customerNewAverageTextSSP).click().perform();
		// Moves the Customer Peer Average slider
		actions.clickAndHold(csc_customerNewAverageSSP).moveByOffset(40, 0).release().perform();
		Thread.sleep(2000);
		System.out.println("=> Hovered and moved the Customer New Average of Start Simulating Here - Pricing");

		// Start Simulating Here - Cost To Serve (SSCS) -
		// waits for the Inbound Frieght - Customer Average
		WebElement csc_inboundFrieghtCustomerAverageSSCS = waitForElement(cpa_csc_inboundFrieghtCustomerAverageSSCS);
		// -10,0 is used to hover only on the customer average as normal hover was
		// failing due to overlap of the peer average
		// clickAndHold() is used to move the dot by specified vlaue
		actions.moveToElement(csc_inboundFrieghtCustomerAverageSSCS, -10, 0).clickAndHold().moveByOffset(70, 0)
				.release().perform();
		// waits for the Inbound Frieght - Customer Average Text
		WebElement csc_customerAverageTextSSCS = waitForElement(cpa_csc_customerAverageTextSSCS);
		actions.moveToElement(csc_customerAverageTextSSCS).click().perform();
		// Moves the slider
//		actions.clickAndHold(csc_inboundFrieghtCustomerAverageSSCS).moveByOffset(70, 0).release().perform();
		Thread.sleep(2000);
		System.out.println("=> Hovered and moved the Customer Average of Start Simulating Here - Pricing");

		// waits for the Inbound Frieght - Peer Average
		WebElement csc_inboundFrieghtPeerAverageSSCS = waitForElement(cpa_csc_inboundFrieghtPeerAverageSSCS);
		Thread.sleep(1000);
		actions.moveToElement(csc_inboundFrieghtPeerAverageSSCS).click().perform();
		Thread.sleep(2000);
		WebElement csc_peerAverageTextSSCS = waitForElement(cpa_csc_peerAverageTextSSCS);
		actions.moveToElement(csc_peerAverageTextSSCS).click().perform();
		Thread.sleep(2000);
		System.out.println("=> Hovered on the Peer Average of Start Simulating Here - Pricing");

	}

	// clicks on the Reset buttton
	public void resetBtn() throws IOException, InterruptedException {
		// waits for the reset button
		WebElement csc_resetBtn = waitForElement(cpa_csc_resetBtn);
		csc_resetBtn.click();
		// waits till the slider component is loaded
		waitForElement(cpa_csc_scenarioSlider);
		Thread.sleep(2000);
		waitForElement(cpa_csc_saveAndShowImpactBtn);
		System.out.println("=> The Reset button was clicked which reloaded the entire screen");
		Thread.sleep(2000);
	}

	// Enter the numeric value to metric for simulation
	public void numericValues() throws IOException, InterruptedException {
		// waits for the input field of Order Handling Costs
		WebElement csc_inputFieldOHC = waitForElement(cpa_csc_inputFieldOHC);
		actions.moveToElement(csc_inputFieldOHC).click().perform();
		Thread.sleep(3000);
		csc_inputFieldOHC.clear();
		csc_inputFieldOHC.sendKeys(Keys.CONTROL + "a");
		csc_inputFieldOHC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Calculates the values of based on the slider maximum value
		WebElement csc_sliderMaxValueOHC = waitForElement(cpa_csc_sliderMaxValueOHC);
		// Get the 'aria-valuemax' attribute as double
		Double simulateValue = Double.parseDouble(csc_sliderMaxValueOHC.getText());
		// Calculate 50% of the max value
//		double simulatehalfValue = simulateValue / 2.0;
//		// Format to 2 decimal places (optional)
//		String halfValueFormatted = String.format("%.2f", simulatehalfValue);
//		csc_inputFieldOHC.sendKeys(halfValueFormatted);

		try {
			// Calculate 50% of the max value
			double simulatehalfValue = simulateValue / 2.0;
			// Format to 2 decimal places
			String halfValueFormatted = String.format("%.2f", simulatehalfValue);
			csc_inputFieldOHC.sendKeys(halfValueFormatted);
		} catch (Exception e) {
			System.out.println("=> Error: In fetching the maximum value from the slider");
		}
		Thread.sleep(3000);
	}

	private String scenarioName, vsi_customerDetails;

	// Enter the scenario name and clicks the Save and Show Impact
	public void saveAndShowImpactBtnWithName() throws IOException, InterruptedException {
		// waits for the input field of scenario name
		WebElement csc_enterScenarioName = waitForElement(cpa_csc_enterScenarioName);
		csc_enterScenarioName.click();
		csc_enterScenarioName.clear();
		this.scenarioName = customerId + "_Scenario";
		csc_enterScenarioName.sendKeys(scenarioName);
		Thread.sleep(1000);
		// Customer + Scenario concatenation
		String csc_cutsomerAndScenarioName = customerDetails + scenarioName;
//		waitForElement(cpa_csc_scenarioSlider);
		// waits for the Save and Show Impact button
		WebElement csc_saveAndShowImpactBtn = waitForElement(cpa_csc_saveAndShowImpactBtn);
		csc_saveAndShowImpactBtn.click();
//		successMessage();
		// waiting for the component loading
		try {
			waitForElement(cpa_vsi_allThreewidgets);
			waitForElement(cpa_vsi_chartComponent);
		} catch (Exception e) {
			waitForElement(cpa_vsi_allThreewidgets);
			waitForElement(cpa_vsi_chartComponent);
		}
		waitForElement(cpa_vsi_allThreewidgets);
		// Validating the Customer + Scenario name in the View Scenario Impact screen
		WebElement vsi_filters = waitForElement(cpa_vsi_filters);
		vsi_filters.click();
		// Filters - Customer + Scenario Name
		WebElement vsi_filtersCustomerScenarioOption = waitForElement(cpa_vsi_filtersCustomerScenarioOption);
		vsi_filtersCustomerScenarioOption.click();
		// waits for the Filters - Customer + Scenario Name - Value 01
		WebElement vsi_filterOptionValue01 = waitForElement(cpa_vsi_filterOptionValue01);
		// extracts the value 01 for the validation
		this.vsi_customerDetails = vsi_filterOptionValue01.getText().trim();
		// validates the filter value
		if (!csc_cutsomerAndScenarioName.equalsIgnoreCase(vsi_customerDetails)) {
			throw new AssertionError("=> Mismatch in the Customer + Scenario Name | View Scenario Impact = ["
					+ vsi_customerDetails + "] vs Create Scenario  = [" + csc_cutsomerAndScenarioName + "]");
		}
		System.out.println(
				"=> The Customer + Scenario name is matched, which means the View Scenario Impact is loaded with the created scenario");
		// waits for the Filters - Cancel button
		WebElement vsi_filtersCancelBtn = waitForElement(cpa_vsi_filtersCancelBtn);
		vsi_filtersCancelBtn.click();
		try {
			waitForElement(cpa_vsi_allThreewidgets);
			waitForElement(cpa_vsi_chartComponent);
		} catch (Exception e) {
			waitForElement(cpa_vsi_allThreewidgets);
			waitForElement(cpa_vsi_chartComponent);
		}
	}

}
