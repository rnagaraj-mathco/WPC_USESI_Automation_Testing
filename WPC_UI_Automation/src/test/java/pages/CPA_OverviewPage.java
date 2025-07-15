package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CPA_OverviewPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public CPA_OverviewPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(100)); // wait initialized once
		actions = new Actions(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	private String customerId_SCPS;
	private String customerId_SSS;

	// Entire screen XPATH (Considers all components)
	By cpa_overview = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]");
	// Start New Peer Analysis buttons
	By cpa_startNewPeerAnalysisBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/button[1]");
	// Geographical Map
	By cpa_geographicalMap = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div");

	// Saved Customer Peer Selections table - SCPS
	// Search Keyword - SCPS
	By cpa_searchBarSCPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// Searched record selection - SCPS
	By cpa_searchRecordSCPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// Create Sensitivity Scenario btn - Row Selection - SCPS
	// xpath of the table first row
	By cpa_tableFirstRowSCPS = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[4]/div/div/div/div[3]/table/tbody/tr/td[1]");

	// xpath of Customer name of the Table first row - SCPS
	By cpa_customerIDFirstRowSCPS = By.xpath("//table/tbody/tr[1]/td[2]");

	// xpath of Customer name of the Table first row - SCPS
	By cpa_customerNameFirstRowSCPS = By.xpath("//table/tbody/tr[1]/td[3]");

	// xpath of Peer Selection name of the Table first row - SCPS
	By cpa_peerSelectionFirstRowSCPS = By.xpath("//table/tbody/tr[1]/td[4]");

	// xpath of Create Sensitivity Scenario btn - SCPS
	By cpa_createSensitivityScenarioBtnSCPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/button[1]");

	// xpath of the Create Scenario screen - Slider component
	By cpa_csc_scenarioSlider = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]");

	// xpath of the Create Scenario screen - Back btn
	By cpa_csc_backBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/button[1]");

	// xpath of the Peer Selection - 02 - Set Peer Matching Criteria
	By cpa_ps2_setPeerMatchingCriteriaBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]");

	// xpath of the Create Scenario screen - Filter button
	By cpa_csc_filtersBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Create Scenario screen - Filter - Customer + Peer Selection Name
	// option
	By cpa_csc_filterCustomerPeerGroupOption = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Create Scenario screen - Filter - Customer + Peer Selection Name
	// - Value
	By cpa_csc_filterCustomerPeerGroupOptionValue = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Filter - Cancel button
	By cpa_csc_filterCancelBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]");

	// Edit btn - SCPS
	By cpa_editbtnSCPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[6]");

	// xpath of the Peer Selection -02 - Comparative Peer Group Selection table -
	// First row - Customer Id
	By cpa_ps2_customerIdCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// Back btn -01 - Select a Target Customer for Peer Matching (STCP) (Peer
	// Selection -01) (This is the btn of
	// the screen where user lands when Edit btn clicked from overview screen

	By cpa_ps_BackBtnSTCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");

	// Back btn -02 - Comparative Peer Group Selection - CPGS (Peer Selection -02)
	By cpa_ps_BackBtnCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/button[1]");

	// Delete Dropdown - SCPS
	By cpa_DeleteDropdownSCPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[7]/div[1]"); // deletes.

	// Delete Dropdown Options - SCPS
	By cpa_deleteOptionsSCPS = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[2]/div[1]");

	// Delete Icon - SCPS
	By cpa_deleteIconSCPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");

	// Download Icon - SCPS
	By cpa_downloadIconSCPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[8]/div[1]");

	// Pagination - SCPS
	By cpa_paginationSCPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/button[2]/span[1]/*[name()='svg'][1]");
	// Error Message - SCS
	By cpa_errorToasterMessage = By.xpath("//h4[normalize-space()='Please select a record to create scenario !']");

	// Saved Sensitivity Scenario Simulation table - SSS
	// Search Keyword - SSS
	By cpa_searchBarSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// Searched Record Selection - SSS
	By cpa_searchRecordSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// Table first row - SSS
	By cpa_tableFirstRowSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// ViewImpact btn - SSS
	By cpa_viewImpactBtnSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/div[1]/div[1]/button[1]");

	// xpath of Customer name of the Table first row - SSS
	By cpa_customerIDFirstRowSSS = By.xpath("(//table[contains(@class, 'MuiTable-root')])[2]//tbody/tr/td[2]");

	// xpath of Customer name of the Table first row - SSS
	By cpa_customerNameFirstRowSSS = By.xpath("(//table[contains(@class, 'MuiTable-root')])[2]//tbody/tr/td[3]");

	// xpath of Sensitivity Scenario name of the Table first row - SSS
	By cpa_sensitivityScenarioFirstRowSSS = By.xpath("(//table[contains(@class, 'MuiTable-root')])[2]//tbody/tr/td[4]");

	// xpath of Peer Selection name of the Table first row - SSS
	By cpa_peerSelectionNameFirstRowSSS = By.xpath("(//table[contains(@class, 'MuiTable-root')])[2]//tbody/tr/td[5]");

	// Validation of View Impact screen
	// Xpath of the Widget
	By cpa_vsi_widgetThree = By
			.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div/div[3]");

	// xpath of the View Impact Screen - Filters
	By cpa_vsi_filterBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]");

	// xpath of the View Impact Screen - Filters - Customer + Scenario Name
	By cpa_vsi_filterCustomerScenarioOption = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the View Impact Screen - Filters - Customer + Scenario Name - Value
	By cpa_vsi_filterCustomerScenarioOptionValue = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the View Impact Screen - Filters - Cancel button
	By cpa_vsi_filterCancelBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");

	// xpath of the View Impact Screen - Back button
	By cpa_vsi_BackBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");

	// Edit btn - SSS
	By cpa_editbtnSSS = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[8]/div/div/div/div[3]/table/tbody/tr[1]/td[7]/button");

	// Delete dropdown - SSS
	By cpa_deleteDropdownSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[8]/div[1]");

	// Delete dropdown options - SSS
	By cpa_deleteOptionsSSS = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[2]/div[1]/div[1]/span[1]");

	// Delete Icon - SSS
	By cpa_deleteIconSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/button[1]");

	// Download Icon - SSS
	By cpa_downloadIconSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[9]/div[1]");

	// Navigating the Overview screen
	public void navigateTo() throws IOException, InterruptedException {
		driver.get(ConfigReader.cpa_overview());
		// Waits for Start New Peer Analysis btn
		waitForElement(cpa_startNewPeerAnalysisBtn);
		Thread.sleep(3000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/OverviewScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	// Start New Peer Analysis button
	public void startnewpeeranalysisbtn() throws IOException, InterruptedException {
		// Waits for Start New Peer Analysis btn
		WebElement startNewPeerAnalysisBtn = waitForElement(cpa_startNewPeerAnalysisBtn);
		startNewPeerAnalysisBtn.click();
		System.out.println(
				"=> The Start New Peer Analysis button was clicked and redirected to the Branch/Customer Selection");
		// Waits for the geographical map
		waitForElement(cpa_geographicalMap);
		Thread.sleep(5000);

		// Verify whether it landed on the Customer Peer Analysis Card - Selections
		// -Branch/Customer Selection screen
		String currentUrl = driver.getCurrentUrl();
		String expectedbranchCustomerSelectionUrl = ConfigReader.cpa_branchCustomerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedbranchCustomerSelectionUrl)) {
			throw new AssertionError(
					"=> Not Landed on Branch/Customer Selection Screen by clicking on the Start New Peer Analysis Button - Unexpected redirection! - Current URL you're on: "
							+ currentUrl);
		}
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/StarteNewPeerAnalysisBtn.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// navigating back to overview screen
		driver.navigate().back();
		Thread.sleep(1000);

	}

	// Search a keyword - SCPS
	public void searchForKeywordSCPS() throws IOException, InterruptedException {
		WebElement searchBarSCPS = waitForElement(cpa_searchBarSCPS);
		searchBarSCPS.click();
		searchBarSCPS.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSCPS = waitForElement(cpa_searchRecordSCPS);
		String searchRecord = searchRecordSCPS.getText().trim();
		searchBarSCPS.sendKeys(searchRecord);
		Thread.sleep(1000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/SearchKeywordSCPS.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Clearing the Search Keyword
		searchBarSCPS.click();
		searchBarSCPS.sendKeys(Keys.CONTROL + "a");
		searchBarSCPS.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		System.out.println("=> The Saved Customer Peer Selection for the Customer Id: " + searchRecord
				+ " was searched successfully!");

	}

	// Create Sensitivity scenario with selection
	public void createSensitivityScenarioBtnWithSelection() throws IOException, InterruptedException {
		// Waits for the first row of the SCPS table
		WebElement tableFirstRowSCPS = waitForElement(cpa_tableFirstRowSCPS);
		// waits for the Create Sensitivity scenario btn to get load
		WebElement CreateSensitivityScenarioBtn = waitForElement(cpa_createSensitivityScenarioBtnSCPS);
		tableFirstRowSCPS.click();
		// Validating whether the landed screen also has the same record
		// Waits for the customer name of table first row - SCPS
		WebElement customerNameFirstRowSCPS = waitForElement(cpa_customerNameFirstRowSCPS);
		String customerName = customerNameFirstRowSCPS.getText();

		// Waits for the peer selection name of table first row - SCPS
		WebElement peerSelectionFirstRowSCPS = waitForElement(cpa_peerSelectionFirstRowSCPS);
		String peerSelectionName = peerSelectionFirstRowSCPS.getText();

		// concate both the values
		String customerPeerSelectionName = customerName + " + " + peerSelectionName;
		System.out.println(
				"=> The Customer + Peer Selection Name of the selected first record of Saved Customer Peer Selections table is: "
						+ customerPeerSelectionName);

		// Clicks the Create Sensitivity Scenario button with selection
		CreateSensitivityScenarioBtn.click();
		// Create Scenario validations
		waitForElement(cpa_csc_scenarioSlider);
		WebElement csc_filter = waitForElement(cpa_csc_filtersBtn);
		csc_filter.click();
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerPeerGroupOption = waitForElement(cpa_csc_filterCustomerPeerGroupOption);
		csc_filterCustomerPeerGroupOption.click();
		// Waits for the Filter - Options - Value
		WebElement csc_filterCustomerPeerGroupOptionValue = waitForElement(cpa_csc_filterCustomerPeerGroupOptionValue);
		// Take screenshot of the Create Scenario - Filter - Customer+Peer Selection
		// name - Value
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/CreateSensitivityScenarioBtnWithSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);

		Thread.sleep(3000);
		String filterCustomerPeerGroupOptionValue = csc_filterCustomerPeerGroupOptionValue.getText().trim();

		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerPeerSelectionName.equalsIgnoreCase(filterCustomerPeerGroupOptionValue)) {
			throw new AssertionError(
					"=> Mismatch in Customer and Peer Selection Name and the Create Scenario is loaded with different combination: Selected = ["
							+ customerPeerSelectionName + "] vs Filter = [" + filterCustomerPeerGroupOptionValue + "]");
		}
		System.out.println(
				"=> The Customer and Peer Selection names matched successfully and this validates that selected record is loaded in the Create Scenario Screen:  "
						+ customerPeerSelectionName + " == " + filterCustomerPeerGroupOptionValue);

		WebElement csc_filterCancelBtn = waitForElement(cpa_csc_filterCancelBtn);
		csc_filterCancelBtn.click();

		// Verify whether it landed on the Customer Peer Analysis Card - Scenario
		// Builder - Create Scenario using assertion
		String currentUrl = driver.getCurrentUrl();
		String expectedCreateScenarioUrl = ConfigReader.cpa_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedCreateScenarioUrl)) {
			throw new AssertionError("=> Unexpected redirection!, Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully!, Redirected to the Create Scenario from the Overview screen by selecting the customer record and clicking on the Create Sensitivity Scenario Button");
		Thread.sleep(4000);

		// Navigating back to overview screen only by back button
		// Waits for the Create Scenario - Back button cpa_csc_backBtn
		WebElement csc_backBtn = waitForElement(cpa_csc_backBtn);
		csc_backBtn.click();
		// Waits for the Peer selection -02 - Button
//		waitForElement(cpa_ps2_setPeerMatchingCriteriaBtn);
//		// Waits for the Peer Selection - 02 - Back button
//		// Comparative peer group selection table
//		WebElement ps_BackBtnCPGS = waitForElement(cpa_ps_BackBtnCPGS);
//		ps_BackBtnCPGS.click();
		// Waits for the Peer selection -01 - Back button
		// Select Target Customer for Peer Matching
		WebElement ps_BackBtnSTCP = waitForElement(cpa_ps_BackBtnSTCP);
		ps_BackBtnSTCP.click();
		Thread.sleep(7000);
		// waits for the Geographical map
		waitForElement(cpa_geographicalMap);
		Thread.sleep(3000);
		// Redirection to the Overview screen
		driver.get(ConfigReader.cpa_overview());
		System.out.println("=> Successfully!, Navigated back to the Overview screen from Create Scenario");
		waitForElement(cpa_startNewPeerAnalysisBtn);
		// temporary but need to code for the flow till creation of scenario
//		driver.navigate().back(); 
		Thread.sleep(5000);

	}

	// Clicks the Create Sensitivity Scenario button without selection
	public void createSensitivityScenarioBtnWithoutSelection() throws IOException, InterruptedException {
		// waits for the Create Sensitivity scenario btn to get load
		WebElement createSensitivityScenarioBtnSCPS = waitForElement(cpa_createSensitivityScenarioBtnSCPS);
		// Clicks the Create Sensitivity Scenario button
		createSensitivityScenarioBtnSCPS.click();
		System.out.println(
				"=> The Create Sensitivity Scenario Button was clicked without selecting a record due to which an error message was popped");
		Thread.sleep(3000);
		// Assertion
		// Assertion to confirm message text
		WebElement errorToasterMessage = waitForElement(cpa_errorToasterMessage);
		String actualMsg = errorToasterMessage.getText();
		String expectedMsg = "Please select a record to create scenario !";
		Assert.assertEquals(
				"=> The Error Toaster message validation for the Create Sensitivity Scenario button has failed!",
				expectedMsg, actualMsg);

		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/CreateSensitivityScenarioBtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Thread.sleep(3000);
	}

	// Error Message tracker
//	public boolean isErrorMessageVisible() {
//	    try {
//	        WebElement error = driver.findElement(By.xpath("//div[@class='MuiBox-root jss56431 jss831 jss55537']"));
//	        String errorMsg = error.getText();
//	        System.out.println("Snackbar error message: " + errorMsg);
//	        return error.isDisplayed() && errorMsg.toLowerCase().contains("select"); // Update text check as needed
//	    } catch (Exception e) {
//	        return false;
//	    }
//	}

	// Edit Button
	public void editButtonSCPS() throws IOException, InterruptedException {
		// waits for the Create Sensitivity scenario btn to get load
		WebElement editbtnSCPS = waitForElement(cpa_editbtnSCPS);
		// waits to extract the Customer Id from the first row of the SCPS table
		WebElement customerIDFirstRowSCPS = waitForElement(cpa_customerIDFirstRowSCPS);
		String customerIdSCPS = customerIDFirstRowSCPS.getText();
		this.customerId_SCPS = customerIdSCPS;
		// Clicks the Edit button - SCPS
		editbtnSCPS.click();
		System.out.println("=> Clicked the Edit Button of Saved Customer Peer Selection table");
		waitForElement(cpa_ps2_setPeerMatchingCriteriaBtn);
		Thread.sleep(4000);

		// Validting the Customer Id present in the Comparative Peer Group Selection
		// table
		WebElement ps2_customerIdCPGS = waitForElement(cpa_ps2_customerIdCPGS);
		String customerIdCPGS = ps2_customerIdCPGS.getText();
		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError("=> Unexpected redirection!, Current URL you're on: " + currentUrl);
		}
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/CustomerPeerAnalysis/Overview/EditBtnSCPS.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerIdSCPS.equalsIgnoreCase(customerIdCPGS)) {
			throw new AssertionError("=> Mismatch in the Customer ID | Selected = [" + customerIdSCPS
					+ "] vs Filter = [" + customerIdCPGS + "]");
		}
		System.out.println(
				"=> The Customer ID matched successfully and this validates that selected record is loaded in the Peer Selection - Comparative Peer Group Selection Screen:  "
						+ customerIdSCPS + " == " + customerIdCPGS);
		Thread.sleep(4000);
		// Comparative peer group selection table
		WebElement ps_BackBtnCPGS = waitForElement(cpa_ps_BackBtnCPGS);
		ps_BackBtnCPGS.click();
		Thread.sleep(3000);
		// Waits for the Peer selection -01 - Back button
		// Select Target Customer for Peer Matching
		WebElement ps_BackBtnSTCP = waitForElement(cpa_ps_BackBtnSTCP);
		// Validates the BILL To ID in Peer Selection:01
		// Basically the BILL To ID of Peer Selection:02 is searched in the
		// Peer Selection:02 table and validated
		List<WebElement> customerIdCells = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		boolean matchFound = false;

		for (WebElement cell : customerIdCells) {
			String actualCustomerId = cell.getText().trim();
			if (actualCustomerId.equalsIgnoreCase(customerIdCPGS)) {
				System.out.println(
						"=> By clicking the Back button in Peer Selection - Comparative Peer Group Selection screen it redirected to Peer Selection - Select a Target Customer for Peer Matching and validated by the BILL To ID:"
								+ actualCustomerId);
				matchFound = true;
				break;
			}
		}

		if (!matchFound) {
			System.out.println("=> The BILL To ID not found in Select a Target Customer for Peer Matching table.");
		}

		ps_BackBtnSTCP.click();
		Thread.sleep(5000);
		// waits for the Geographical map
		waitForElement(cpa_geographicalMap);
		Thread.sleep(4000);
		// Redirection to the Overview screen
		driver.get(ConfigReader.cpa_overview());
		System.out.println(
				"=> Successfully!, Navigated back to the Overview screen from Peer Selection - Comparative Peer Group Selection screen");
		waitForElement(cpa_startNewPeerAnalysisBtn);
		Thread.sleep(5000);
	}

	// Deleting the records

	public void deleteDropdownPeerSelections() throws IOException, InterruptedException {
		// Waits for the Delete Dropdown and clicks
		WebElement DeleteDropdownSCPS = waitForElement(cpa_DeleteDropdownSCPS);
		DeleteDropdownSCPS.click();
//		System.out.println("=> The Delete Dropdown of Saved Customer Peer Selection table was clicked");
		Thread.sleep(3000);
		// Waits for the delete option in the dropdown and clicks
		WebElement deleteOptionsSCPS = waitForElement(cpa_deleteOptionsSCPS);
		deleteOptionsSCPS.click();
//		System.out.println("=> The Delete options of Saved Customer Peer Selection table is selected");
		Thread.sleep(1000);
		// Take screenshot of the delete option selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteOption_SCPS.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Waits for Delete Icon and clicks it
		WebElement DeleteIconSCPS = waitForElement(cpa_deleteIconSCPS);
		DeleteIconSCPS.click();
		System.out.println("=> The record of the Customer Id: " + customerId_SCPS
				+ " was Deleted from the Saved Customer Peer Selection table");
		Thread.sleep(2000);

	}

	// Delete Icon of Saved Customer Peer Selection table without setting to delete
	// option in the dropdown
	public void deleteIconPeerSelections() throws IOException, InterruptedException {
		// Waits for Delete Icon and clicks it
		WebElement deleteIconSCPS = waitForElement(cpa_deleteIconSCPS);
		deleteIconSCPS.click();
		System.out.println(
				"=> The Delete Icon of Saved Customer Peer Selection table is clicked without setting to delete option in the dropdown due to which an error message popped");
		Thread.sleep(5000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIconSCPS.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Download Icon of Saved Customer Peer Selection table
	public void downloadIconPeerSelections() throws IOException, InterruptedException {
		// Waits for Delete Icon and clicks it
		WebElement downloadIconSCPS = waitForElement(cpa_downloadIconSCPS);
		downloadIconSCPS.click();
		System.out.println(
				"=> The Download Icon of Saved Customer Peer Selection table was clicked and then table records donwloaded as an Excel file");
		Thread.sleep(3000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DownloadIconSCPS.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Pagination is a least priority
	public void paginationPeerSelection() throws IOException, InterruptedException {
	}

	// Search and select the record of Saved Customer Peer Selection table
	public void searchForRecordSCPS() throws IOException, InterruptedException {
		WebElement searchBarSCPS = waitForElement(cpa_searchBarSCPS);
		searchBarSCPS.click();
		searchBarSCPS.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSCPS = waitForElement(cpa_searchRecordSCPS);
		String searchRecord = searchRecordSCPS.getText().trim();
		searchBarSCPS.sendKeys(searchRecord);
		Thread.sleep(1000);
		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "//table//tr[td[2][normalize-space()='" + searchRecord
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		actions.moveToElement(radioButton).click().perform();
		System.out.println("=> Searched and Selected the Saved Customer Peer Selections record of the Customer ID: "
				+ searchRecord);
		Thread.sleep(1000);
		// Clearing the Search Keyword
		searchBarSCPS.click();
		searchBarSCPS.sendKeys(Keys.CONTROL + "a");
		searchBarSCPS.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);

	}

	// Saved Sensitivity Simulation Scenario table - SSS
	// Search keyword
	public void searchForKeywordSSS() throws IOException, InterruptedException {
		WebElement searchBarSSS = waitForElement(cpa_searchBarSSS);
		// Scrolls to the Table
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", searchBarSSS);
		Thread.sleep(2000);
		searchBarSSS.click();
		searchBarSSS.clear();

		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSSS = waitForElement(cpa_searchRecordSSS);
		String searchRecord = searchRecordSSS.getText().trim();
		searchBarSSS.sendKeys(searchRecord);
		Thread.sleep(2000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/SearchKeywordSavedSensitivitySimulationScenario.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
		searchBarSSS.click();
		searchBarSSS.sendKeys(Keys.CONTROL + "a");
		searchBarSSS.sendKeys(Keys.BACK_SPACE);
		System.out.println("=> The Saved Sensitivity Simulation Scenario for the Customer Id: " + searchRecord
				+ " was searched successfully!");
		Thread.sleep(5000);

	}

	// View Impact btn with records selection
	public void viewImpactBtnWithSelection() throws IOException, InterruptedException {
		// waits for the Save Sensitivity Simulation Scenario Table First Row
		WebElement tableFirstRowSSS = waitForElement(cpa_tableFirstRowSSS);
		// waits for the View Impact btn to get load
		WebElement ViewImpactBtn = waitForElement(cpa_viewImpactBtnSSS);
		tableFirstRowSSS.click();
		// Scrolls to the View Impact button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",
				ViewImpactBtn);
		Thread.sleep(3000);
		// Validating whether the landed screen also has the same record
		// Waits for the customer name of table first row - SSS
		WebElement customerNameFirstRowSSS = waitForElement(cpa_customerNameFirstRowSSS);
		String customerNameSSS = customerNameFirstRowSSS.getText();

		// Waits for the peer selection name of table first row - SSS
		WebElement sensitivityScenarioFirstRowSSS = waitForElement(cpa_sensitivityScenarioFirstRowSSS);
		String sensitivityScenarioName = sensitivityScenarioFirstRowSSS.getText();

		// concate both the values
		String customerSensitivityScenarioName = customerNameSSS + " + " + sensitivityScenarioName;
		System.out.println(
				"=> The Customer + Sensitivity Scenario Name of the selected first record of Saved Sensitivity Simulation Scenario table is: "
						+ customerSensitivityScenarioName);

		// Clicks the View Impact button with selection
		ViewImpactBtn.click();
		// Create Scenario validations
		waitForElement(cpa_vsi_widgetThree);
		WebElement vsi_filter = waitForElement(cpa_vsi_filterBtn);
		vsi_filter.click();
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement vsi_filterCustomerScenarioOption = waitForElement(cpa_vsi_filterCustomerScenarioOption);
		vsi_filterCustomerScenarioOption.click();
		// Waits for the Filter - Options - Value
		WebElement vsi_filterCustomerScenarioOptionValue = waitForElement(cpa_vsi_filterCustomerScenarioOptionValue);
		// Take screenshot of the Create Scenario - Filter - Customer+Peer Selection
		// name - Value
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/ViewImpactBtnWithSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);

		Thread.sleep(3000);
		String filterCustomerPeerGroupOptionValue = vsi_filterCustomerScenarioOptionValue.getText().trim();

		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerSensitivityScenarioName.equalsIgnoreCase(filterCustomerPeerGroupOptionValue)) {
			throw new AssertionError(
					"=> Mismatch in Customer and Sensitivity Simulation Scenario Name and the View Scenario Impact screen is loaded with different combination: Selected = ["
							+ customerSensitivityScenarioName + "] vs Filter = [" + filterCustomerPeerGroupOptionValue
							+ "]");
		}
		System.out.println(
				"=> The Customer and Sensitivity Simulation Scenario names matched successfully and this validates that selected record is loaded in the View Impact Screen:  "
						+ customerSensitivityScenarioName + " == " + filterCustomerPeerGroupOptionValue);

		WebElement vsi_filterCancelBtn = waitForElement(cpa_vsi_filterCancelBtn);
		vsi_filterCancelBtn.click();
		// Verify whether it landed on the Customer Peer Analysis Card - Scenario
		// Builder - Create Scenario
		String currentUrl = driver.getCurrentUrl();
		String expectedCreateScenarioUrl = ConfigReader.cpa_ScenarioImapct();

		if (!currentUrl.equalsIgnoreCase(expectedCreateScenarioUrl)) {
			throw new AssertionError("=> Unexpected redirection!, Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully!, Redirected to the View Scenario Imapct screen from the Overview screen by selecting the customer record and clicking on the View Impact Button");
		Thread.sleep(4000);

		// Navigating back to overview screen only by back button
		// waits for the View Scenario Impact - Back button
//		WebElement vsi_BackBtn = waitForElement(cpa_vsi_BackBtn);
//		vsi_BackBtn.click();
//		Thread.sleep(3000);
		// As there was no back button in the demo so consider the URL redirection
		driver.get(ConfigReader.cpa_createScenario());
		// Waits for the Create Scenario - Back button cpa_csc_backBtn
		WebElement csc_backBtn = waitForElement(cpa_csc_backBtn);
		csc_backBtn.click();
		// Waits for the Peer selection -02 - Button
//		waitForElement(cpa_ps2_setPeerMatchingCriteriaBtn);
//	    //Waits for the Peer Selection - 02 - Back button
//		// Comparative peer group selection table
//		WebElement ps_BackBtnCPGS = waitForElement(cpa_ps_BackBtnCPGS);
//		ps_BackBtnCPGS.click();
		// Waits for the Peer selection -01 - Back button
		// Select Target Customer for Peer Matching
		WebElement ps_BackBtnSTCP = waitForElement(cpa_ps_BackBtnSTCP);
		ps_BackBtnSTCP.click();
		Thread.sleep(7000);
		// waits for the Geographical map
		waitForElement(cpa_geographicalMap);
		Thread.sleep(3000);
		// Redirection to the Overview screen
		driver.get(ConfigReader.cpa_overview());
		System.out.println("=> Successfully!, Navigated back to the Overview screen from Create Scenario");
		waitForElement(cpa_startNewPeerAnalysisBtn);
		// temporary but need to code for the flow till creation of scenario
//				driver.navigate().back(); 
		Thread.sleep(5000);

	}

	// View Impact btn without selecting the records
	public void viewImpactBtnWithOutSelection() throws IOException, InterruptedException {
		// waits for the View Impact btn to get load
		WebElement viewImpactBtnSSS = waitForElement(cpa_viewImpactBtnSSS);
		// Scrolls to the View Impact button
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",
//				viewImpactBtnSSS);

		// Clicks the View Scenario Impact button without selecting the record
		viewImpactBtnSSS.click();

		System.out.println(
				"=> The View Impact Button was clicked without selecting a record due to which an error message was popped");

		errorToasterMessage();
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/ViewImpactWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	public void errorToasterMessage() {
		// Assertion for Button clicks
		WebElement errorToasterMessage = waitForElement(cpa_errorToasterMessage);
		String actualMsg = errorToasterMessage.getText();
		String expectedMsg = "Please select a record to create scenario !";
		Assert.assertEquals(
				"=> The Error Toaster message validation for the Create Sensitivity Scenario button has failed!",
				expectedMsg, actualMsg);

	}

	// Edit Button - Saved Sensitivity Simulation Scenario
	public void editButtonScenarioSelections() throws IOException, InterruptedException {
		// waits for the Create Sensitivity scenario btn to get load
		WebElement editbtnSSS = waitForElement(cpa_editbtnSSS);

		// waits for the Peer Selection name of the Saved Sensitivity Simulation
		// Scenario table
		WebElement peerSelectionNameFirstRowSSS = waitForElement(cpa_peerSelectionNameFirstRowSSS);
		String peerSelectionName = peerSelectionNameFirstRowSSS.getText();

		WebElement customerNameFirstRowSSS = waitForElement(cpa_customerNameFirstRowSSS);
		String customerNameSSS = customerNameFirstRowSSS.getText();

		// Concate customer Id and Peer selection name
		String customerPeerSelectionNameSSS = customerNameSSS + " + " + peerSelectionName;
		System.out.println(
				"=> The Customer + Peer Selection Name of the selected first record of Saved Sensitivity Simulation Scenario table is: "
						+ customerPeerSelectionNameSSS);

		// Clicks the Edit button
		editbtnSSS.click();
		Thread.sleep(3000);
		// Create Scenario validations
		waitForElement(cpa_csc_scenarioSlider);
		WebElement csc_filter = waitForElement(cpa_csc_filtersBtn);
		csc_filter.click();
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerPeerGroupOption = waitForElement(cpa_csc_filterCustomerPeerGroupOption);
		csc_filterCustomerPeerGroupOption.click();
		// Waits for the Filter - Options - Value
		WebElement csc_filterCustomerPeerGroupOptionValue = waitForElement(cpa_csc_filterCustomerPeerGroupOptionValue);
		// Take screenshot of the Create Scenario - Filter - Customer+Peer Selection
		// name - Value
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/CustomerPeerAnalysis/Overview/EditBtnSSS.png");
		FileHandler.copy(sourcefile, screenshotPath);

		Thread.sleep(3000);
		String filterCustomerPeerGroupOptionValue = csc_filterCustomerPeerGroupOptionValue.getText().trim();

		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerPeerSelectionNameSSS.equalsIgnoreCase(filterCustomerPeerGroupOptionValue)) {
			throw new AssertionError(
					"=> Mismatch in Customer and Peer Selection Name and the Create Scenario is loaded with different combination: Selected = ["
							+ customerPeerSelectionNameSSS + "] vs Filter = [" + filterCustomerPeerGroupOptionValue
							+ "]");
		}
		System.out.println(
				"=> The Customer and Peer Selection names matched successfully and this validates that selected record is loaded in the Create Scenario Screen:  "
						+ customerPeerSelectionNameSSS + " == " + filterCustomerPeerGroupOptionValue);

		WebElement csc_filterCancelBtn = waitForElement(cpa_csc_filterCancelBtn);
		csc_filterCancelBtn.click();

		// Verify whether it landed on the Customer Peer Analysis Card - Scenario
		// Builder - Create Scenario using assertion
		String currentUrl = driver.getCurrentUrl();
		String expectedCreateScenarioUrl = ConfigReader.cpa_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedCreateScenarioUrl)) {
			throw new AssertionError("=> Unexpected redirection!, Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully!, Redirected to the Create Scenario from the Overview screen by selecting the customer record and clicking on the Edit Button");
		Thread.sleep(4000);

		// Navigating back to overview screen only by back button
		// Waits for the Create Scenario - Back button cpa_csc_backBtn
		WebElement csc_backBtn = waitForElement(cpa_csc_backBtn);
		csc_backBtn.click();
		// Waits for the Peer selection -02 - Button
//		waitForElement(cpa_ps2_setPeerMatchingCriteriaBtn);
//		// Waits for the Peer Selection - 02 - Back button
//		// Comparative peer group selection table
//		WebElement ps_BackBtnCPGS = waitForElement(cpa_ps_BackBtnCPGS);
//		ps_BackBtnCPGS.click();
		// Waits for the Peer selection -01 - Back button
		// Select Target Customer for Peer Matching
		WebElement ps_BackBtnSTCP = waitForElement(cpa_ps_BackBtnSTCP);
		ps_BackBtnSTCP.click();
		Thread.sleep(7000);
		// waits for the Geographical map
		waitForElement(cpa_geographicalMap);
		Thread.sleep(3000);
		// Redirection to the Overview screen
		driver.get(ConfigReader.cpa_overview());
		System.out.println("=> Successfully!, Navigated back to the Overview screen from Create Scenario");
		waitForElement(cpa_startNewPeerAnalysisBtn);
		// temporary but need to code for the flow till creation of scenario
//		driver.navigate().back(); 
		Thread.sleep(5000);

	}

	// Delete Icon of Saved Sensitivity Simulation Scenario table with setting to
	// delete option in the dropdown
	public void deleteDropdownScenarioSelections() throws IOException, InterruptedException {
		// Waits for the Delete Dropdown and clicks
		WebElement deleteDropdownSSS = waitForElement(cpa_deleteDropdownSSS);
		deleteDropdownSSS.click();
		System.out.println("--- Clicked: Delete Dropdown of Saved Sensitivity Simulation Scenario table");
		Thread.sleep(3000);
		// Waits for the delete option in the dropdown and clicks
		WebElement deleteOptionsSSS = waitForElement(cpa_deleteOptionsSSS);
		deleteOptionsSSS.click();
		System.out.println("--- Clicked: Delete options of Saved Sensitivity Simulation Scenario table");
		Thread.sleep(1000);
		// Take screenshot of the delete option selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteOption_SavedSenstivitiySimulationScenario.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Waits for Delete Icon and clicks it
		WebElement DeleteIconSSS = waitForElement(cpa_deleteIconSSS);
		DeleteIconSSS.click();
		System.out.println("=> The Saved Sensitivity Simulation Scenario record is Deleted");
		Thread.sleep(2000);

	}

	// Delete Icon of Saved Customer Peer Selection table without setting to delete
	// option in the dropdown
	public void deleteIconScenarioSelections() throws IOException, InterruptedException {
		// Waits for Delete Icon and clicks it
		WebElement deleteIconSSS = waitForElement(cpa_deleteIconSSS);
		deleteIconSSS.click();
		System.out.println(
				"The Delete Icon of Saved Sensitivity Simulation table is clicked without setting to delete option in the dropdown due to which an error message popped");
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIconSSS.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Download Icon of Saved Sensitivity Simulation Scenario table
	public void downloadIconScenarioSelections() throws IOException, InterruptedException {
		// Waits for Download Icon and clicks it
		WebElement downloadIconSSS = waitForElement(cpa_downloadIconSSS);
		downloadIconSSS.click();
		System.out.println(
				"The Download Icon of Saved Sensitivity Simulation Scenario table was clicked and then table records donwloaded as an Excel file");
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DownloadIconSS.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Search and select the record of Saved Sensitivity Simulation Scenario table
	public void searchForRecordSSS() throws IOException, InterruptedException {
		// Search keyword
		WebElement searchBarSSS = waitForElement(cpa_searchBarSSS);
		searchBarSSS.click();
		searchBarSSS.clear();
		// Search the Saved Customer Peer Selection record
		WebElement searchRecordSSS = waitForElement(cpa_searchRecordSSS);
		By cpa_Scroller = By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div");
		WebElement Scroller = waitForElement(cpa_Scroller);
		// Scrolls to the Table
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", Scroller,
				searchRecordSSS);
		Thread.sleep(3000);

		// Waits for the Customer ID from the first row of table
		String searchRecord = searchRecordSSS.getText().trim();
		searchBarSSS.sendKeys(searchRecord);
		Thread.sleep(2000);

		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "(//table[contains(@class, 'MuiTable-root')])[2]//tr[td[2][normalize-space()='"
				+ searchRecord + "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		actions.moveToElement(radioButton).click().perform();
		System.out.println("=> Searched and Selected the Saved Customer Peer Selections record of the Customer ID: "
				+ searchRecord);
		Thread.sleep(1000);
		// Clearing the Search Keyword
		searchBarSSS.click();
		searchBarSSS.sendKeys(Keys.CONTROL + "a");
		searchBarSSS.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);

	}

}
