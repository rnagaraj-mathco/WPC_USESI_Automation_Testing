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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import config.ConfigReader;
import hooks.Hooks;
import utils.ElementHelper;

public class ARCA_OverviewPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	ElementHelper helper;

	// gets driver status
	public ARCA_OverviewPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // wait initialized once
		actions = new Actions(driver);
		this.helper = new ElementHelper(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	// Locators
	By arca_costMetric = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div");

	// This is the xpath of the Cost Metric - Dynamically
	private static final String ARCA_COST_METRIC_SELECTION_XPATH = "//label[.//span[text()='%s']]";
	private String selectedMetricName;
	public static final Logger logger = LoggerFactory.getLogger(ARCA_OverviewPage.class);
	// This is the xpath of the View Saved Scenario button
	By arca_viewSavedScenarioBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/button[1]");

	// xpath of the Saved Customer Product Combinations
	By arca_savedCustomerProductCombinationsTable = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[7]");

	// xpath of the Saved Scenario Simulations
	By arca_savedScenarioSimulationsTable = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[11]");

	// This is the xpath of the Create New Root Cause Analysis button
	By arca_createNewRootCauseAnalysisBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Root Cause Customers for the Selected Cost Metric plot in the
	// Customer Analysis
	By arca_ca_rootCauseCustomerPlot = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]");
// xpath of the Save Customer Btn - Customer Analysis
	By arca_ca_saveCustomerBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Filter
	By arca_ca_filter = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Filter - Option
	By arca_ca_filterCostMetric = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");

	// xpath of Filter - Option - Value
	By arca_ca_filterCostMetricValue = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Filter - Cancel btn
	By arca_ca_filterCancelBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]");

	// Saved Customer Product Combinations table (SCPC)
	// xpath of Search keyword
	By arca_searchBarSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of Create New Scenario button
	By arca_createNewScenrioBtnSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Create New Scenario button - Error message
	By arca_createNewScenrioBtnErrorMessageSCPC = By
			.xpath("//h4[normalize-space()='Please select a record to create scenario !']");
	// xpath of Edit Button
	By arca_editBtnSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[6]/button[1]/span[1]");

	// Validation of Edit button redirection
	// xpath of the Customer ID from the table
	By arca_editBtnSCPCCustomerId = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// xpath of the Customer ID from the Customer Selection Screen - Select One
	// Customer for Simulation tables (SOC)
	By arca_cs_customerIdSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// xpath of the Customer Selection - Select Root Cause Products for Simulation
	By arca_cs_selectRootCauseProductsTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]");

	// xpath of the table's first row
	By arca_tableFirstRowSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// Validation of Customer and Product Combination redirections
	// xpath of the table's customer and product combination column to get the name
	By arca_customerProductCombinationNameSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[4]");

	// xpath of the Create Scenario - Filters
	By arca_csc_filter = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Create Scenario - Filters - Customer and Product Combination
	// option
	By arca_csc_filterCustomerProductCombinationOption = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");

	// xpath of the Create Scenario - Filters - Customer and Product Combination
	// option - Value Selected
	By arca_csc_filterCustomerProductCombinationOptionValue = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Delete Icon
	By arca_deleteIconSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/button[1]");

	// xpath of the download button - SCPC
	By arca_downloadIconSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/button[1]");

	// xpath of the delete icon - error message
	By arca_errorMessageDeleteIconSCPC = By
			.xpath("//h4[contains(text(),'Please update at least one customer product combin')]");

	// xpath of the delete dropdown - SCPC
	By arca_deleteDropdownSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/div[1]/div[1]/div[1]/span[1]");

	// xpath of the delete dropdown options - SCPC
	By arca_deleteDropdownOptionSCPC = By.xpath("//li[@role='option' and normalize-space()='Delete']");

	// xpath of the first row's Customer ID for searching record and selecting
	By arca_searchRecordSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// Saved Scenario Simulations table (SSS)
	// Search Keyword
	By arca_searchBarSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the first row of table to get the customer ID
	By arca_searchRecordSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// xpath of the View Imapct button
	By arca_viewImpactBtnSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[13]/div[1]/button[1]/span[1]");

	// xpath of the View Impact button - Error message present in the pop-up -> when
	// clicked without selection
	By arca_viewImpactBtnSSSError = By
			.xpath("//h5[contains(text(), 'Please select') and contains(text(), 'View Impact')]");

	// xpath of the View Impact button - Cancel Button
	By arca_viewImpactBtnSSSCancelIcon = By.xpath("//button[@aria-label='close' and @title='close']");

	// xpath of the Delete icon
	By arca_deleteIconSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[12]/div[1]/div[1]/button[1]");

	// xpath of the delete icon - error message
	By arca_errorMessageDeleteIconSSS = By
			.xpath("//h4[contains(text(),'Please update at least one scenario dropdown value')]");

	// xpath of the Download icon
	By arca_downloadIconSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/button[1]/span[1]/*[name()='svg'][1]");

	// xpath of the Delete Dropdown
	By arca_deleteDropdownSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Delete Dropdown Options
	By arca_deleteDropdownOptionSSS = By.xpath("//li[@role='option' and normalize-space()='Delete']");

	// xpath of the customer and product combinations name column
	By arca_customerProductCombinationNameSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[5]");

	// xpath of the Edit button
	By arca_editBtnSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[7]/button[1]");

	// xpath of the Create Scenario - Both Widgets
	By arca_csc_scenarioBothWidgets = By
			.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div");

	// xpath of the View Impact - Save Scenario Simulation table first row
	By arca_tableFirstRowSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// xpath of the View Imapact -Scenario name column value of Save Scenario
	// Simulation table
	By arca_scenarioNameSSS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[11]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[4]");

	// xpath of the View Impact scenario simulation
	By arca_scenarioSimulationPopUpSSS = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]");

	// xpath of the scenario name present in the View Impact - Pop UP
	By arca_scenarioNamePopUpSSS = By.xpath("//h4[starts-with(normalize-space(.), 'Scenario Name:')]");

	// xpath of the cancel icon in error delete icon SCPCS
	By arca_errorCancel = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]/*[name()='svg'][1]");

	// xpath of the Pre-programmed Scenario widget
	By arca_csc_preProgrammedScenario = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]");

	// xpath of the Estimated Impact Widget
	By arca_csc_estimatedImpact = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");

	// Navigating to the Overview Screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Overview screen
		driver.get(ConfigReader.arca_overview());
		// waits till the Entire Cost Metric and button is loaded
		waitForElement(arca_costMetric);

//		Thread.sleep(5000);
		try {
			waitForElement(arca_costMetric);
		} catch (Exception e) {
			waitForElement(arca_costMetric);
		}
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/OverviewCostMetricScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Auto Root Cause Analysis - Overview screen
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_overview();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
//			throw new AssertionError(
//					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
			Hooks.logger.error(
					" Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		Hooks.logger.info(" The Auto-Root Cause: Overview Screen is loaded with the neccessary Cost Metric options");

	}

	// Selecting the cost metric
	public void selectMetricRadioButton(String metricName) throws IOException, InterruptedException {
		this.selectedMetricName = metricName; // Store it for use in second method
		By arca_costMetricSelection = By.xpath(String.format(ARCA_COST_METRIC_SELECTION_XPATH, metricName));
		WebElement metricRadio = waitForElement(arca_costMetricSelection);
//		metricRadio.click();
		helper.safeClick(metricRadio);
		Hooks.logger.info(" The Cost Metric:  " + metricName + " is clicked");

	}

	// Clicking on the View Saved Scenario Button
	public void viewSavedScenarioBtn() throws IOException, InterruptedException {
		// Waits for the View Saved Scenario button
		WebElement viewSavedScenarioBtn = waitForElement(arca_viewSavedScenarioBtn);
//		viewSavedScenarioBtn.click();
		helper.safeClick(viewSavedScenarioBtn);
		Hooks.logger.info(
				" The View Saved Scenario Button was clicked and the Saved Customer Product Combinations and Saved Scenario Simulations tables loaded");
		try {
			waitForElement(arca_savedCustomerProductCombinationsTable);
		} catch (Exception e) {
			waitForElement(arca_savedScenarioSimulationsTable);
		}
		Thread.sleep(3000);

	}

	// Clicking on the Create New Root Cause Analysis Button
	public void createNewRootCauseAnalysisBtn() throws IOException, InterruptedException {
		// Waits for the View Saved Scenario button
		WebElement createNewRootCauseAnalysisBtn = waitForElement(arca_createNewRootCauseAnalysisBtn);
//		createNewRootCauseAnalysisBtn.click();
		helper.safeClick(createNewRootCauseAnalysisBtn);

		Hooks.logger.info(
				" The Create New Root Cause Analysis Button was clicked and redirecting to the Customer Analysis screen");
		helper.waitForOverlaysToDisappear();
		try {
			waitForElement(arca_ca_saveCustomerBtn);
			waitForElement(arca_ca_rootCauseCustomerPlot);
		} catch (Exception e) {
			waitForElement(arca_ca_saveCustomerBtn);
			waitForElement(arca_ca_rootCauseCustomerPlot);
		}
		waitForElement(arca_ca_rootCauseCustomerPlot);
		waitForElement(arca_ca_saveCustomerBtn);
		// Verify whether it landed on the Auto Root Cause Analysis - Customer Analysis
		// screen
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_customerAnalysis();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
//					throw new AssertionError(
//							"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
			Hooks.logger.error(
					" Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		Hooks.logger.info(" Successfully, redirected to the Customer Analysis screen");
		Thread.sleep(3000);
		// Validating whether the Customer Analysis has the content based on the Cost
		// Metric selected
		WebElement ca_filter = waitForElement(arca_ca_filter);
//		ca_filter.click();
		helper.safeClick(ca_filter);
		Hooks.logger.info(" Customer Analysis: The Filter button was clicked");
		Thread.sleep(3000);
		WebElement ca_filterCostMetric = waitForElement(arca_ca_filterCostMetric);
//		ca_filterCostMetric.click();
		helper.safeClick(ca_filterCostMetric);
		Hooks.logger.info(" Customer Analysis: The Filter - Cost Metric Option was clicked");
		WebElement ca_filterCostMetricValue = waitForElement(arca_ca_filterCostMetricValue);
		Thread.sleep(5000);
		String filterCostMetricValue = ca_filterCostMetricValue.getText().trim();
		Hooks.logger.info(" Customer Analysis: The Filter - Cost Metric Option - Selected value is extracted");
		// Assertion to validate selected and filtered cost metric values
		if (!selectedMetricName.equalsIgnoreCase(filterCostMetricValue)) {
//			throw new AssertionError("=> Mismatch in Cost Metric: Selected = [" + selectedMetricName + "] vs Filter = ["
//					+ filterCostMetricValue + "]");
			Hooks.logger.error(" There is a Mismatch in Cost Metric: Selected Metric= [" + selectedMetricName
					+ "] vs Filter - Cost Metric options - Value = [" + filterCostMetricValue + "]");
		}
		Hooks.logger.info(
				" The Customer Analysis screen is loaded based on the metric selected in the Overview screen \n   => Cost Metric Match Successful: "
						+ selectedMetricName + " == " + filterCostMetricValue);

	}

	// Saved Customer Product Combinations table (SCPC) - Selecting a record from
	// the table
	// Search Keyword
	public void searchKeywordSCPC() throws IOException, InterruptedException {
		// Waits for the Search bar of table
		WebElement searchBarSCPC = waitForElement(arca_searchBarSCPC);

//		searchBarSCPC.click();
		helper.safeClick(searchBarSCPC);
		searchBarSCPC.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSCPC = waitForElement(arca_searchRecordSCPC);
		String searchRecord = searchRecordSCPC.getText().trim();
		Hooks.logger.info(
				" SCPC: The Customer ID present in the Saved Customer Product Combinations table first row is extracted to search");
		searchBarSCPC.sendKeys(searchRecord);
		Hooks.logger.info(" SCPC: The Customer and Product Combination record of the Customer ID: " + searchRecord
				+ " was searched");
		Thread.sleep(2000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/SearchKeywordSavedCustomerProductCombinations.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
//		searchBarSCPC.click();
		helper.safeClick(searchBarSCPC);
		searchBarSCPC.sendKeys(Keys.CONTROL + "a");
		searchBarSCPC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Hooks.logger.info(" SCPC: The Searched bar has been cleared");
	}

	// Create New Scenario button without Selection
	public void createNewScnearioBtnWithoutSelection() throws IOException, InterruptedException {
		// Waits for the button
		WebElement createNewScenrioBtnSCPC = waitForElement(arca_createNewScenrioBtnSCPC);
//		createNewScenrioBtnSCPC.click();
		helper.safeClick(createNewScenrioBtnSCPC);
		Hooks.logger.info(" The Create New Scenario button was clicked without selecting a record");
		// Validates the error message
		errorCreateScenarioBtn();

		Thread.sleep(3000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/CreateNewScnearioBtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		try {
			waitForElement(arca_savedCustomerProductCombinationsTable);
			waitForElement(arca_savedScenarioSimulationsTable);
		} catch (Exception e) {
			waitForElement(arca_savedCustomerProductCombinationsTable);
			waitForElement(arca_savedScenarioSimulationsTable);
		}
		waitForElement(arca_savedCustomerProductCombinationsTable);
		Thread.sleep(2000);

	}

	public void errorCreateScenarioBtn() {
		Hooks.logger.info(" The Create New Scenario button error message validation method is called");
		WebElement createNewScenrioBtnErrorMessageSCPC = waitForElement(arca_createNewScenrioBtnErrorMessageSCPC);
		String actualMsg = createNewScenrioBtnErrorMessageSCPC.getText();
		String expectedMsg = "Please select a record to create scenario !";
		Assert.assertEquals(" The Error Toaster message validation for the Create New Scenario button has failed!",
				expectedMsg, actualMsg);
	}

	// Edit button
	public void editBtnSCPC() throws IOException, InterruptedException {
		// Waits for the Customer ID column
		WebElement editBtnSCPCCustomerId = waitForElement(arca_editBtnSCPCCustomerId);
		String SavedCustomerProductCombinationsCustomerId = editBtnSCPCCustomerId.getText().trim();
		Hooks.logger.info(" SCPC: The Customer ID of the first row is extracted");
		// Waits for the Edit button
		WebElement editBtnSCPC = waitForElement(arca_editBtnSCPC);
//		editBtnSCPC.click();
		helper.safeClick(editBtnSCPC);
		Hooks.logger.info(" SCPC: The Edit Button of the first row is clicked");
		waitForElement(arca_cs_selectRootCauseProductsTable);
		// Verify whether it landed on the Auto Root Cause Analysis -
		// Customer Selections - Selections screen
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_customerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
//			throw new AssertionError(
//					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
			Hooks.logger.error(
					"Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		Hooks.logger.info(" Successfully, redirected to the Customer Selections screen");

		// Extracts the Customer Id from the Selected Customer for Simulation table of-
		// Customer Selection Screen
		// Waits for the Customer Id
		WebElement cs_customerIdSOC = waitForElement(arca_cs_customerIdSOC);
		String customerIdSOC = cs_customerIdSOC.getText().trim();
		Thread.sleep(3000);
		Hooks.logger.info(
				" The Customer ID present in the first row of the Select One Customer for Simulation table was extracted");

		// Assertion to validate selected Customer ID record is loaded in the
		// Customer Selection Screen

		if (!SavedCustomerProductCombinationsCustomerId.equalsIgnoreCase(customerIdSOC)) {
//			throw new AssertionError(
//					"=> Mismatch in Customer ID: Selected = [" + SavedCustomerProductCombinationsCustomerId
//							+ "] vs Loaded in Customer Selection Screen = [" + customerIdSOC + "]");
			Hooks.logger.error(
					" There is a mismatch in Customer ID: Selected in the Saved Customer Product Combinations table = ["
							+ SavedCustomerProductCombinationsCustomerId
							+ "] vs Loaded in the elect One Customer for Simulation table = [" + customerIdSOC + "]");
		}
		Hooks.logger.info(
				" The Customer ID's matched successfully and this validates that edit button of the Saved Customer Product Combinations table redirects as intended "
						+ SavedCustomerProductCombinationsCustomerId + " == " + customerIdSOC);

		// Redirection to the Overview screen
		driver.get(ConfigReader.arca_overview());
		Hooks.logger.info(" Navigated back to the Overview screen from Customer Selection screen");
		waitForElement(arca_costMetric);
		Thread.sleep(3000);

		// Selects previously used cost metric again
		if (selectedMetricName == null || selectedMetricName.isEmpty()) {
			throw new IllegalStateException(" No cost metric name found from previous selection. Please set it first.");
		}
		selectMetricRadioButton(selectedMetricName); // reuse your existing method

		// Click on View Saved Scenario button
		viewSavedScenarioBtn(); // reuse existing method
		Hooks.logger.info(" The Overview screen is reloaded with View Saved Scenario's for the selected metric: "
				+ selectedMetricName);
	}

	// Create New Scenario button with Selection
	public void createNewScnearioBtnWithSelection() throws IOException, InterruptedException {
		// Waits for the first row of the table
		WebElement tableFirstRowSCPC = waitForElement(arca_tableFirstRowSCPC);
//		tableFirstRowSCPC.click();
		helper.safeClick(tableFirstRowSCPC);
		Hooks.logger.info(" SCPC: The first row record is selected ");
		Thread.sleep(2000);
		// Verify whether it landed on the Auto Root Cause Analysis -
		// Scenario Builder - Create Scenario screen
		// Extracting the Customer and Product Combination column value from the SCPC
		WebElement customerProductCombinationNameSCPC = waitForElement(arca_customerProductCombinationNameSCPC);
		String customerProductCombinationName = customerProductCombinationNameSCPC.getText();
		Hooks.logger.info(" The Customer and Product Combination name of the first row is extracted");
		// Take screenshot after the selecting the record
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/CreateNewScnearioBtnWithSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Thread.sleep(2000);
		// Waits for the button
		WebElement createNewScenrioBtnSCPC = waitForElement(arca_createNewScenrioBtnSCPC);
//		createNewScenrioBtnSCPC.click();
		helper.safeClick(createNewScenrioBtnSCPC);
		Hooks.logger.info(
				" SCPC: The Create New Scenario button was clicked after selecting the record and redirected to Create Scenario Screen where the screen is loaded with selected Customer and Product Combination: "
						+ customerProductCombinationName);
		// Validates the URL after redirection
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
//			throw new AssertionError(
//					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
			Hooks.logger.error(
					" Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		Hooks.logger.info(" Successfully, redirected to the Create Scenario screen");

		try {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);
		}
		// Validating based on the Customer and Product Combination name from the filter
		// on Create Scenario
		WebElement csc_filter = waitForElement(arca_csc_filter);
//		csc_filter.click();
		helper.safeClick(csc_filter);
		Hooks.logger.info(" Create Scenario: The Filter button was clicked");
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerProductCombinationOption = waitForElement(
				arca_csc_filterCustomerProductCombinationOption);
//		csc_filterCustomerProductCombinationOption.click();
		helper.safeClick(csc_filterCustomerProductCombinationOption);
		Hooks.logger.info(" Create Scenario: The Filter - Customer and Product Combination option was clicked");
		// Waits for the Filter - Options - Value
		WebElement csc_filterCustomerProductCombinationOptionValue = waitForElement(
				arca_csc_filterCustomerProductCombinationOptionValue);
		Thread.sleep(5000);
		String filterCustomerProductCombinationOptionValue = csc_filterCustomerProductCombinationOptionValue.getText()
				.trim();
		Hooks.logger.info(
				" Create Scenario: The Filter - Customer and Product Combination - Selected values was extracted");
		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerProductCombinationName.equalsIgnoreCase(filterCustomerProductCombinationOptionValue)) {
//			throw new AssertionError(
//					"=> Mismatch in Customer and Product Combination: Selected = [" + customerProductCombinationName
//							+ "] vs Filter = [" + filterCustomerProductCombinationOptionValue + "]");
			Hooks.logger.error(
					" There is a mismatch in Customer and Product Combination: Selected in the Saved Customer and Product Combination table = ["
							+ customerProductCombinationName + "] vs in the Filter of Create Scenario = ["
							+ filterCustomerProductCombinationOptionValue + "]");
		}
		Hooks.logger.info(
				" The Customer and Product Combination names matched successfully and this validates that selected record is loaded in the Create Scenario Screen:  "
						+ customerProductCombinationName + " == " + filterCustomerProductCombinationOptionValue);

		// Waits for the Filter - Cancel button
		WebElement ca_filterCancelBtn = waitForElement(arca_ca_filterCancelBtn);
//		ca_filterCancelBtn.click();
		helper.safeClick(ca_filterCancelBtn);
		Hooks.logger.info(" Create Scenario: The Filter - Cancel button was clicked");
		waitForElement(arca_csc_filter);
		Thread.sleep(1000);

		// Redirection to the Overview screen
		driver.get(ConfigReader.arca_overview());
		Hooks.logger.info(" Navigated back to the Overview screen from Create Scenario");
		waitForElement(arca_costMetric);
		Thread.sleep(3000);

		// Selects previously used cost metric again
		if (selectedMetricName == null || selectedMetricName.isEmpty()) {
			throw new IllegalStateException(
					"=> No cost metric name found from previous selection. Please set it first.");
		}
		selectMetricRadioButton(selectedMetricName); // reuse your existing method

		// Click on View Saved Scenario button
		viewSavedScenarioBtn(); // reuse existing method
		Hooks.logger.info(" The Overview screen is reloaded with View Saved Scenario's for the selected metric: "
				+ selectedMetricName);

	}

	// Delete Icon of Saved Customer Product Combinations table without setting to
	// delete option in the dropdown

	public void deleteIconSCPC() throws IOException, InterruptedException {
		waitForElement(arca_savedCustomerProductCombinationsTable);
		// Waits for Delete Icon and clicks it
		WebElement deleteIconSCPC = waitForElement(arca_deleteIconSCPC);
//		deleteIconSCPC.click();
		helper.safeClick(deleteIconSCPC);
		Hooks.logger.info(" SCPC: The Delete icon is clicked without setting to the Delete option in the table record");
		// Error message validation
		errorMessageDeleteIconSCPC();
		Thread.sleep(2000);
//		WebElement errorCancel = waitForElement(arca_errorCancel);
//		errorCancel.click();
//		System.out.println(
//				"=> Clicked the Delete Icon of Saved Customer Product Combinations table without setting to delete option in the dropdown");
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIcon_SavedCustomerProductCombinationstable.png");
		FileHandler.copy(sourcefile, screenshotPath);

		try {
			waitForElement(arca_savedCustomerProductCombinationsTable);
			waitForElement(arca_downloadIconSCPC);
		} catch (Exception e) {
			waitForElement(arca_savedCustomerProductCombinationsTable);
			waitForElement(arca_downloadIconSCPC);
		}
//		Thread.sleep(3000);

	}

	public void errorMessageDeleteIconSCPC() {
		try {
			waitForElement(arca_errorMessageDeleteIconSCPC);
		} catch (Exception e) {
			waitForElement(arca_errorMessageDeleteIconSCPC);
		}
		WebElement errorMessageDeleteIconSCPC = waitForElement(arca_errorMessageDeleteIconSCPC);
		String actualMsg = errorMessageDeleteIconSCPC.getText();
		String expectedMsg = "Please update at least one customer product combination dropdown value before clicking the Delete button to proceed with record deletion.";
		Assert.assertEquals(
				"=> The Error Toaster message validation for the Delete icon of Saved Customer and Product Combination table has failed!",
				expectedMsg, actualMsg);
	}

	// Download Icon of Saved Customer Product Combinations table
	public void downloadIconSCPC() throws IOException, InterruptedException {
		waitForElement(arca_savedCustomerProductCombinationsTable);
		// Waits for Download Icon and clicks it
		WebElement downloadIconSCPC = waitForElement(arca_downloadIconSCPC);
//		downloadIconSCPC.click();
		helper.safeClick(downloadIconSCPC);
		Hooks.logger.info(" SCPC: The Download Icon present in the row is clicked");
		// Take screenshot of the downloading
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DownloadIcon_SCPC.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Hooks.logger.info(" SCPC: The Saved Customer and Product combination record was downloaded");
		try {
			waitForElement(arca_savedCustomerProductCombinationsTable);
		} catch (Exception e) {
			waitForElement(arca_savedCustomerProductCombinationsTable);
		}
//		Thread.sleep(2000);
	}

	// Delete the records of the Saved Customer Product Combinations table
	public void deleteDropdownSCPC() throws IOException, InterruptedException {
		// Waits for the Delete Dropdown and clicks
		WebElement deleteDropdownSCPC = waitForElement(arca_deleteDropdownSCPC);
//		deleteDropdownSCPC.click();
		helper.safeClick(deleteDropdownSCPC);
		Hooks.logger.info(
				" SCPC: The Delete Dropdown present in the table is clicked which has options Do not Delete and Delete");
		Thread.sleep(3000);
		// Waits for the delete option in the dropdown and clicks
		WebElement deleteDropdownOptionSCPC = waitForElement(arca_deleteDropdownOptionSCPC);
//		deleteDropdownOptionSCPC.click();
		helper.safeClick(deleteDropdownOptionSCPC);
		Hooks.logger.info(" SCPC: The Delete option is selected");

		Thread.sleep(2000);
		waitForElement(arca_savedCustomerProductCombinationsTable);
		// Take screenshot of the delete option selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteOption_SavedCustomerProductCombinationstable.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Waits for Delete Icon and clicks it
		WebElement deleteIconSCPC = waitForElement(arca_deleteIconSCPC);
//		deleteIconSCPC.click();
		helper.safeClick(deleteIconSCPC);
		Hooks.logger.info(
				" The Delete Icon of Saved Customer Peer Selection table is clicked and the record has been deleted");
		Thread.sleep(2000);
	}

	// Search and select the record of Saved Customer Product Combinations table
	public void searchForRecordSCPC() throws IOException, InterruptedException {
		// Waits for the Search bar
		WebElement searchBarSCPC = waitForElement(arca_searchBarSCPC);

//		searchBarSCPC.click();
		helper.safeClick(searchBarSCPC);
		searchBarSCPC.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSCPC = waitForElement(arca_searchRecordSCPC);
		String searchRecord = searchRecordSCPC.getText().trim();
		Hooks.logger.info(
				" SCPC: The Customer ID present in the Saved Customer Product Combinations table first row is extracted to search");
		searchBarSCPC.sendKeys(searchRecord);
		Hooks.logger.info(" SCPC: The Customer and Product Combination record of the Customer ID: " + searchRecord
				+ " was searched");
		Thread.sleep(2000);
		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "//table//tr[td[2][normalize-space()='" + searchRecord
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		helper.safeClick(radioButton);
//		actions.moveToElement(radioButton).click().perform();
		Hooks.logger.info(" SCPC: The record of the searched Customer ID: " + searchRecord + " is selected");
		Thread.sleep(1000);
		// Clearing the Search Keyword
//		searchBarSCPC.click();
		helper.safeClick(searchBarSCPC);
		searchBarSCPC.sendKeys(Keys.CONTROL + "a");
		searchBarSCPC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Waits for the Saved Customer Peer Selection record
		waitForElement(arca_savedCustomerProductCombinationsTable);

	}

	// Saved Scenario Simulations table
	// Selecting a record and performing other actions
	// Search for a keyword
	public void searchKeywordSSS() throws IOException, InterruptedException {
		// Waits for the Search bar of table
		WebElement searchBarSSS = waitForElement(arca_searchBarSSS);
//		searchBarSSS.click();
		helper.safeClick(searchBarSSS);
		searchBarSSS.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSSS = waitForElement(arca_searchRecordSSS);
		String searchRecord = searchRecordSSS.getText().trim();
		Hooks.logger.info(
				" SSS: The Customer ID present in the Saved Scenario Simulations table first row is extracted to search");
		searchBarSSS.sendKeys(searchRecord);
		Hooks.logger.info(" SSS: The Saved Scenario Simulations of the Customer ID: " + searchRecord + " was searched");
		Thread.sleep(2000);

		// Clearing the Search Keyword
//		searchBarSSS.click();
		helper.safeClick(searchRecordSSS);
		searchBarSSS.sendKeys(Keys.CONTROL + "a");
		searchBarSSS.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		Hooks.logger.info(" SSS: The Searched bar has been cleared");
	}

	// Clicks View Impact button with Selecting a record
	public void viewImapctWithSelection() throws IOException, InterruptedException {
		// Waits for the first row of table
		WebElement tableFirstRowSSS = waitForElement(arca_tableFirstRowSSS);
//		tableFirstRowSSS.click();
		helper.safeClick(tableFirstRowSSS);
		Hooks.logger.info(" SSS: The first row record is selected ");

		// Waits for the scenario name value of the table
		WebElement scenarioNameSSS = waitForElement(arca_scenarioNameSSS);
		String scenarioName = scenarioNameSSS.getText().trim();
		Hooks.logger.info(" SSS: The Sensitivity Scenario name of the first row is extracted");
		// Waits for the View Impact button
		WebElement viewImpactBtnSSS = waitForElement(arca_viewImpactBtnSSS);
//		viewImpactBtnSSS.click();
		helper.safeClick(viewImpactBtnSSS);
		Hooks.logger.info(" SSS: The View Impact button was clicked after selecting the record");
		waitForElement(arca_scenarioSimulationPopUpSSS);
		Thread.sleep(2000);

		// Waits for the Scenario Name present in the View Impact Pop-Up
		WebElement scenarioNamePopUpSSS = waitForElement(arca_scenarioNamePopUpSSS);
		String scenarioNamePopUp = scenarioNamePopUpSSS.getText().trim();
		Hooks.logger.info(" SSS: The scenario name present in the pop-up is extracted");
		// Extract just the scenario name (after the colon)
		String extractedScenarioName = scenarioNamePopUp.substring(scenarioNamePopUp.indexOf(":") + 1).trim();
		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!scenarioName.equalsIgnoreCase(extractedScenarioName)) {
//			throw new AssertionError("=> Mismatch in the Scenario Name : Selected = [" + scenarioName
//					+ "] vs Filter = [" + extractedScenarioName + "]");
			Hooks.logger.error(
					" There is a mismatch in the Scenario Name : Selected in the Saved Scenario Simualtion table = ["
							+ scenarioName + "] vs Scenario name in the pop-up = [" + extractedScenarioName + "]");
		}
		Hooks.logger.info(
				" SSS: The scenario names matched successfully with the Sensitivity Scenario name,\n and this validates that pop-up is loaded with impact of the selected record:  "
						+ scenarioName + " == " + extractedScenarioName);

		// Waits for the View Impact button - Cancel button
		WebElement viewImpactBtnSSSCancelIcon = waitForElement(arca_viewImpactBtnSSSCancelIcon);
//		viewImpactBtnSSSCancelIcon.click();
		helper.safeClick(viewImpactBtnSSSCancelIcon);
		Hooks.logger.info(" SSS: The Cancel icon of the pop-up is clicked");
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(2000);
	}

	// Clicks View Impact button without Selecting a record
	public void viewImapctWithOutSelection() throws IOException, InterruptedException {
		// Waits for the View Impact button
		WebElement viewImpactBtnSSS = waitForElement(arca_viewImpactBtnSSS);
//		viewImpactBtnSSS.click();
		helper.safeClick(viewImpactBtnSSS);
		Hooks.logger.info(" SSS: The scenario name present in the pop-up is extracted");
		waitForElement(arca_viewImpactBtnSSSError);
		Hooks.logger.info(" SSS: The Error messsage in the pop-up was diaplayed");
		// Take screenshot of the View Impact button - Error Pop-up
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/ViewScnearioImpactBtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Waits for the View Impact button - Cancel button
		WebElement viewImpactBtnSSSCancelIcon = waitForElement(arca_viewImpactBtnSSSCancelIcon);
//		viewImpactBtnSSSCancelIcon.click();
		helper.safeClick(viewImpactBtnSSSCancelIcon);
		Hooks.logger.info(" SSS: The Cancel icon of the pop-up is clicked");
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(2000);

	}

	// Clicks the Edit button and redirects to the create scenario
	public void editBtnSSS() throws IOException, InterruptedException {
		// Waits for the Customer and Product Combination column
		WebElement customerProductCombinationNameSSS = waitForElement(arca_customerProductCombinationNameSSS);
		String customerProductCombinationName = customerProductCombinationNameSSS.getText().trim();
		Hooks.logger.info(" SSS: The Customer and Product Combination name of first row record is extracted");
		String radioXPath = "//table//tr[td[normalize-space()='" + customerProductCombinationName + "']]/td[2]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		String customerId = radioButton.getText().trim();
		helper.safeClick(radioButton);
//		actions.moveToElement(radioButton).click().perform();
		Hooks.logger.info(" The Edit button of the Customer ID: " + customerId
				+ " is clicked whose Customer and Product Combination name is: " + customerProductCombinationName);
		// Waits for the Edit button
		WebElement editBtnSSS = waitForElement(arca_editBtnSSS);
//		editBtnSSS.click();
		helper.safeClick(editBtnSSS);
		Hooks.logger.info(" SSS: The Edit button is clicked");
		try {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);
		}
		// Verify whether it landed on the Auto Root Cause Analysis -
		// Customer Selections - Selections screen
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
//			throw new AssertionError(
//					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
			Hooks.logger.error(
					" Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		Hooks.logger.info(" Successfully, redirected to the Create Scenario screen");

		Thread.sleep(1000);

		// Validating based on the Customer and Product Combination name from the filter
		// on Create Scenario
		WebElement csc_filter = waitForElement(arca_csc_filter);
//		csc_filter.click();
		helper.safeClick(csc_filter);
		Hooks.logger.info(" Create Scenario: The Filter button was clicked");
		Thread.sleep(3000);

		// Waits for the Filter - Options
		WebElement csc_filterCustomerProductCombinationOption = waitForElement(
				arca_csc_filterCustomerProductCombinationOption);
//		csc_filterCustomerProductCombinationOption.click();
		helper.safeClick(csc_filterCustomerProductCombinationOption);
		Hooks.logger.info(" Create Scenario: The Filter - Customer and Product Combination option was clicked");
		// Waits for the Filter - Options - Value
		WebElement csc_filterCustomerProductCombinationOptionValue = waitForElement(
				arca_csc_filterCustomerProductCombinationOptionValue);
		Thread.sleep(5000);
		String filterCustomerProductCombinationOptionValue = csc_filterCustomerProductCombinationOptionValue.getText()
				.trim();
		Hooks.logger.info(
				" Create Scenario: The Filter - Customer and Product Combination - Selected values was extracted");

		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerProductCombinationName.equalsIgnoreCase(filterCustomerProductCombinationOptionValue)) {
//			throw new AssertionError(
//					"=> Mismatch in Customer and Product Combination: Selected = [" + customerProductCombinationName
//							+ "] vs Filter = [" + filterCustomerProductCombinationOptionValue + "]");
			Hooks.logger.info(
					" There is a Mismatch in Customer and Product Combination: Selected in the Saved Sensitivity Simulation table = ["
							+ customerProductCombinationName + "] vs in the Filter of Create Scenario screen = ["
							+ filterCustomerProductCombinationOptionValue + "]");
		}
		Hooks.logger.info(
				" The Customer and Product Combination names matched successfully and this validates that selected record is loaded in the Create Scenario Screen:  "
						+ customerProductCombinationName + " == " + filterCustomerProductCombinationOptionValue);

		// Waits for the Filter - Cancel button
		WebElement ca_filterCancelBtn = waitForElement(arca_ca_filterCancelBtn);
//		ca_filterCancelBtn.click();
		helper.safeClick(ca_filterCancelBtn);
		Hooks.logger.info(" Create Scenario: The Filter - Cancel button was clicked");
		waitForElement(arca_csc_filter);
		Thread.sleep(1000);

		// Redirection to the Overview screen
		driver.get(ConfigReader.arca_overview());
		Hooks.logger.info(" Navigated back to the Overview screen from Create Scenario");
		waitForElement(arca_costMetric);
		Thread.sleep(3000);

		// Selects previously used cost metric again
		if (selectedMetricName == null || selectedMetricName.isEmpty()) {
			throw new IllegalStateException(
					"=> No cost metric name found from previous selection. Please set it first.");
		}
		selectMetricRadioButton(selectedMetricName); // reuse your existing method
		// Click on View Saved Scenario button
		viewSavedScenarioBtn(); // reuse existing method
		Hooks.logger.info(" The Overview screen is reloaded with View Saved Scenario's for the selected metric: "
				+ selectedMetricName);

	}

	// Delete's the record from Saved Scenario Simulations table
	public void deleteDropdownSSS() throws IOException, InterruptedException {
		// Waits for the Delete Dropdown and clicks
		WebElement deleteDropdownSSS = waitForElement(arca_deleteDropdownSSS);
//		deleteDropdownSSS.click();
		helper.safeClick(deleteDropdownSSS);
		Hooks.logger.info(
				" SSS: The Delete Dropdown present in the table is clicked which has options Do not Delete and Delete");
		Thread.sleep(3000);
		// Waits for the delete option in the dropdown and clicks
		WebElement deleteDropdownOptionSSS = waitForElement(arca_deleteDropdownOptionSSS);
//		deleteDropdownOptionSSS.click();
		helper.safeClick(deleteDropdownOptionSSS);
		Hooks.logger.info(" SSS: The Delete option is selected");
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(1000);
		// Take screenshot of the delete option selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteOption_SSS.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Waits for Delete Icon and clicks it
		WebElement deleteIconSSS = waitForElement(arca_deleteIconSSS);
//		deleteIconSSS.click();
		helper.safeClick(deleteIconSSS);
		Hooks.logger.info(
				" SSS: The Delete Icon of Saved Scenario Simulation table is clicked and the record has been deleted");
		Thread.sleep(2000);
	}

	// Delete Icon of Saved Scenario Simulations table without setting to
	// delete option in the dropdown
	public void deleteIconSSS() throws IOException, InterruptedException {
		// Waits for Delete Icon and clicks it
		WebElement deleteIconSSS = waitForElement(arca_deleteIconSSS);
//		deleteIconSSS.click();
		helper.safeClick(deleteIconSSS);
		Hooks.logger.info(" SSS: The Delete icon is clicked without setting to the Delete option in the table record");
		Thread.sleep(1000);
//		WebElement errorCancel = waitForElement(arca_errorCancel);
//		errorCancel.click();
		errorMessageDeleteIconSSS();
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIcon_SSS.png");
		FileHandler.copy(sourcefile, screenshotPath);

		try {
			waitForElement(arca_savedScenarioSimulationsTable);
			waitForElement(arca_downloadIconSSS);
		} catch (Exception e) {
			waitForElement(arca_savedScenarioSimulationsTable);
			waitForElement(arca_downloadIconSSS);
		}
		Thread.sleep(2000);

	}

	// validate the error message of delete icon of SSS
	public void errorMessageDeleteIconSSS() {
		try {
			waitForElement(arca_errorMessageDeleteIconSSS);
		} catch (Exception e) {
			waitForElement(arca_errorMessageDeleteIconSSS);
		}
		WebElement errorMessageDeleteIconSCPC = waitForElement(arca_errorMessageDeleteIconSSS);
		String actualMsg = errorMessageDeleteIconSCPC.getText();
		String expectedMsg = "Please update at least one scenario dropdown value before clicking the Delete button to proceed with record deletion.";
		Assert.assertEquals(
				"=> The Error Toaster message validation for the Delete Icon of Saved Scenario Simulation table has failed!",
				expectedMsg, actualMsg);
	}

	// Download Icon of Saved Scenario Simulations table
	public void downloadIconSSS() throws IOException, InterruptedException {
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(2000);
		// Waits for Download Icon and clicks it
		WebElement downloadIconSSS = waitForElement(arca_downloadIconSSS);
//		downloadIconSSS.click();
		helper.safeClick(downloadIconSSS);
		Hooks.logger.info(" SSS: The Download Icon present in the row is clicked");
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DownloadIcon_SSS.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Hooks.logger.info(" SSS: The Saved Customer and Product combination record was downloaded");
		try {
			waitForElement(arca_savedScenarioSimulationsTable);
		} catch (Exception e) {
			waitForElement(arca_savedScenarioSimulationsTable);
		}
	}

	// Search and select the record of Saved Scenario Simulations table
	public void searchForRecord_SSS() throws IOException, InterruptedException {
		// Waits for the Search bar of table
		WebElement searchBarSSS = waitForElement(arca_searchBarSSS);
//		searchBarSSS.click();
		helper.safeClick(searchBarSSS);
		searchBarSSS.clear();
		// Waits for the Customer ID from the first row of table
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSSS = waitForElement(arca_searchRecordSSS);
		String searchRecord = searchRecordSSS.getText().trim();
		Hooks.logger.info(
				" SSS: The Customer ID present in the Saved Scenario Simulations table first row is extracted to search");
		searchBarSSS.sendKeys(searchRecord);
		Hooks.logger.info(" SSS: The Saved Scenario Simulations of the Customer ID: " + searchRecord + " was searched");
		Thread.sleep(2000);
		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "(//table)[2]//tr[td[2][normalize-space()='" + searchRecord
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";

		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		helper.safeClick(radioButton);
//		actions.moveToElement(radioButton).click().perform();
		Hooks.logger.info(" SSS: The record of the searched Customer ID: " + searchRecord + " is selected");
		Thread.sleep(3000);
		// Clearing the Search Keyword
//		searchBarSSS.click();
		helper.safeClick(searchBarSSS);
		searchBarSSS.sendKeys(Keys.CONTROL + "a");
		searchBarSSS.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Waits for the Saved Scenario Simulation Table
		waitForElement(arca_savedScenarioSimulationsTable);

	}

}
