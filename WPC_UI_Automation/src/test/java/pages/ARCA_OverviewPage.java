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

public class ARCA_OverviewPage {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public ARCA_OverviewPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // wait initialized once
		actions = new Actions(driver);
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
	By arca_searchKeywordSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of Create New Scenario button
	By arca_createNewScenrioBtnSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/button[1]/span[1]");

	// xpath of Edit Button
	By arca_editBtnSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[6]/button[1]/span[1]");

	// Validation of Edit button redirection
	// xpath of the Customer ID from the table
	By arca_editBtnSCPCCustomerId = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// xpath of the Customer ID from the Customer Selection Screen
	By arca_cs_customerIdSelectCustomerSimulationTableCustomerSelection = By.xpath(
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
	By arca_ca_filterCustomerProductCombinationOptionValue = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Delete Icon
	By arca_deleteIconSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/button[1]");

	// xpath of the download button - SCPC
	By arca_downloadIconSCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/button[1]");

	// xpath of the delete icon - error message
	By arca_errorMessageDeleteIconSCPC = By.xpath(
			"//h4[normalize-space()='Please update at least one scenario dropdown value before clicking the Delete button to proceed with record deletion.')]");

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
	By arca_searchKeywordSSS = By.xpath(
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

	By arca_errorCancel = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]/*[name()='svg'][1]");

	// Navigating to the Overview Screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Overview screen
		driver.get(ConfigReader.arca_overview());
		// waits till the Entire Cost Metric and button is loaded
		waitForElement(arca_costMetric);
		System.out.println("=> The Overview Screen is loaded with the Cost Metric");
		Thread.sleep(5000);
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
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully landed on Overview screen");

	}

	// Selecting the cost metric
	public void selectMetricRadioButton(String metricName) throws IOException, InterruptedException {
		this.selectedMetricName = metricName; // Store it for use in second method
		By arca_costMetricSelection = By.xpath(String.format(ARCA_COST_METRIC_SELECTION_XPATH, metricName));
		WebElement metricRadio = waitForElement(arca_costMetricSelection);
		metricRadio.click();
		System.out.println("=> Clicked " + metricName + "Metric");

	}

	// Clicking on the View Saved Scenario Button
	public void viewSavedScenarioBtn() throws IOException, InterruptedException {
		// Waits for the View Saved Scenario button
		WebElement viewSavedScenarioBtn = waitForElement(arca_viewSavedScenarioBtn);
		viewSavedScenarioBtn.click();
		System.out.println(
				"=> Clicked the View Saved Scenario Button and loaded the Saved Customer Product Combinations and Saved Scenario Simulations tables");
		waitForElement(arca_savedCustomerProductCombinationsTable);
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(3000);

	}

	// Clicking on the Create New Root Cause Analysis Button
	public void createNewRootCauseAnalysisBtn() throws IOException, InterruptedException {
		// Waits for the View Saved Scenario button
		WebElement createNewRootCauseAnalysisBtn = waitForElement(arca_createNewRootCauseAnalysisBtn);
		createNewRootCauseAnalysisBtn.click();

		System.out.println("=> You have clicked the Create New Root Cause Analysis Button");
		waitForElement(arca_ca_rootCauseCustomerPlot);
		Thread.sleep(3000);
		// Validating whether the Customer Analysis has the content based on the Cost
		// Metric selected
		WebElement ca_filter = waitForElement(arca_ca_filter);
		ca_filter.click();
		Thread.sleep(3000);
		WebElement ca_filterCostMetric = waitForElement(arca_ca_filterCostMetric);
		ca_filterCostMetric.click();
		WebElement ca_filterCostMetricValue = waitForElement(arca_ca_filterCostMetricValue);
		Thread.sleep(5000);
		String filterCostMetricValue = ca_filterCostMetricValue.getText().trim();

		// Assertion to validate selected and filtered cost metric values
		if (!selectedMetricName.equalsIgnoreCase(filterCostMetricValue)) {
			throw new AssertionError("=> Mismatch in Cost Metric: Selected = [" + selectedMetricName + "] vs Filter = ["
					+ filterCostMetricValue + "]");
		}
		System.out.println(
				"=> The Customer Analysis screen is loaded based on the metric selected in the Overview screen \n   => Cost Metric Match Successful: "
						+ selectedMetricName + " == " + filterCostMetricValue);

		// Verify whether it landed on the Auto Root Cause Analysis - Customer Analysis
		// screen
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_customerAnalysis();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully redirected to the Customer Analysis screen");
	}

	// Saved Customer Product Combinations table (SCPC) - Selecting a record from
	// the table
	// Search Keyword
	public void searchKeywordSCPC() throws IOException, InterruptedException {
		// Waits for the Search bar of table
		WebElement searchKeywordSCPC = waitForElement(arca_searchKeywordSCPC);

		searchKeywordSCPC.click();
		searchKeywordSCPC.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSCPC = waitForElement(arca_searchRecordSCPC);
		String searchRecord = searchRecordSCPC.getText().trim();
		searchKeywordSCPC.sendKeys(searchRecord);
		System.out
				.println("=> Searched the Customer and Product Combination record of the Customer ID: " + searchRecord);
		Thread.sleep(2000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/SearchKeywordSavedCustomerProductCombinations.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
		searchKeywordSCPC.click();
		searchKeywordSCPC.sendKeys(Keys.CONTROL + "a");
		searchKeywordSCPC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		System.out.println("=> The Searched keyword has been cleared");
	}

	// Create New Scenario button without Selection
	public void createNewScnearioBtnWithoutSelection() throws IOException, InterruptedException {
		// Waits for the button
		WebElement createNewScenrioBtnSCPC = waitForElement(arca_createNewScenrioBtnSCPC);
		createNewScenrioBtnSCPC.click();
		System.out.println(
				"=> The Create New Scenario button was clicked without selecting a record which throwed an error message");
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/CreateNewScnearioBtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		waitForElement(arca_savedCustomerProductCombinationsTable);
		Thread.sleep(2000);

	}

	// Edit button
	public void editBtnSCPC() throws IOException, InterruptedException {
		// Waits for the Customer ID column
		WebElement editBtnSCPCCustomerId = waitForElement(arca_editBtnSCPCCustomerId);
		String SavedCustomerProductCombinationsCustomerId = editBtnSCPCCustomerId.getText().trim();
		// Waits for the Edit button
		WebElement editBtnSCPC = waitForElement(arca_editBtnSCPC);
		editBtnSCPC.click();
		waitForElement(arca_cs_selectRootCauseProductsTable);

		// Extracts the Customer Id from the Selected Customer for Simulation table of-
		// Customer Selection Screen
		// Waits for the Customer Id
		WebElement customerIdSelectCustomerSimulationTableCustomerSelection = waitForElement(
				arca_cs_customerIdSelectCustomerSimulationTableCustomerSelection);
		String customerIdSelectCustomerSimulationTable = customerIdSelectCustomerSimulationTableCustomerSelection
				.getText().trim();
		Thread.sleep(3000);
		System.out.println("=> Clicked the Edit button of Saved Customer Product Combinations table");
		// Verify whether it landed on the Auto Root Cause Analysis -
		// Customer Selections - Selections screen
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_customerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully redirected to the Customer Selections screen");
		// Assertion to validate selected Customer ID record is loaded in the
		// Customer Selection Screen

		if (!SavedCustomerProductCombinationsCustomerId.equalsIgnoreCase(customerIdSelectCustomerSimulationTable)) {
			throw new AssertionError("=> Mismatch in Customer ID: Selected = ["
					+ SavedCustomerProductCombinationsCustomerId + "] vs Loaded in Customer Selection Screen = ["
					+ customerIdSelectCustomerSimulationTable + "]");
		}
		System.out.println(
				"=> The Customer ID matched successfully and this validates that edit button of the selected record is loaded in the Customer Selection Screen:  "
						+ SavedCustomerProductCombinationsCustomerId + " == "
						+ customerIdSelectCustomerSimulationTable);

		// Redirection to the Overview screen
		driver.get(ConfigReader.arca_overview());
		System.out.println("=> Navigated back to the Overview screen from Customer Selection screen");
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
		System.out.println("=> Reloaded View Saved Scenario for metric: " + selectedMetricName);
	}

	// Create New Scenario button without Selection
	public void createNewScnearioBtnWithSelection() throws IOException, InterruptedException {
		// Waits for the first row of the table
		WebElement tableFirstRowSCPC = waitForElement(arca_tableFirstRowSCPC);
		tableFirstRowSCPC.click();
		Thread.sleep(2000);
		// Verify whether it landed on the Auto Root Cause Analysis -
		// Scenario Builder - Create Scenario screen
		// Extracting the Customer and Product Combination column value from the SCPC
		WebElement SavedCustomerProductCombinationsTableCustomerProductName = waitForElement(
				arca_customerProductCombinationNameSCPC);
		String customerProductCombinationName = SavedCustomerProductCombinationsTableCustomerProductName.getText();

		// Waits for the button
		WebElement createNewScenrioBtnSCPC = waitForElement(arca_createNewScenrioBtnSCPC);
		createNewScenrioBtnSCPC.click();
		System.out.println(
				"=> The Create New Scenario button was clicked and redirected to Create Scenario Screen with Customer and Product Combination record: "
						+ customerProductCombinationName);

		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/CreateNewScnearioBtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Thread.sleep(2000);

		// Validating based on the Customer and Product Combination name from the filter
		// on Create Scenario
		WebElement csc_filter = waitForElement(arca_csc_filter);
		csc_filter.click();
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerProductCombinationOption = waitForElement(
				arca_csc_filterCustomerProductCombinationOption);
		csc_filterCustomerProductCombinationOption.click();
		// Waits for the Filter - Options - Value
		WebElement ca_filterCustomerProductCombinationOptionValue = waitForElement(
				arca_ca_filterCustomerProductCombinationOptionValue);
		Thread.sleep(5000);
		String filterCustomerProductCombinationOptionValue = ca_filterCustomerProductCombinationOptionValue.getText()
				.trim();

		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerProductCombinationName.equalsIgnoreCase(filterCustomerProductCombinationOptionValue)) {
			throw new AssertionError(
					"=> Mismatch in Customer and Product Combination: Selected = [" + customerProductCombinationName
							+ "] vs Filter = [" + filterCustomerProductCombinationOptionValue + "]");
		}
		System.out.println(
				"=> The Customer and Product Combination names matched successfully and this validates that selected record is loaded in the Create Scenario Screen:  "
						+ customerProductCombinationName + " == " + filterCustomerProductCombinationOptionValue);

		// Validates the URL after redirection
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully redirected to the Create Scenario screen");

		// Waits for the Filter - Cancel button
		WebElement ca_filterCancelBtn = waitForElement(arca_ca_filterCancelBtn);
		ca_filterCancelBtn.click();
		waitForElement(arca_csc_filter);
		Thread.sleep(1000);

		// Redirection to the Overview screen
		driver.get(ConfigReader.arca_overview());
		System.out.println("=> Navigated back to the Overview screen from Create Scenario");
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
		System.out.println("=> Reloaded View Saved Scenario for metric: " + selectedMetricName);

	}

	// Delete Icon of Saved Customer Product Combinations table without setting to
	// delete option in the dropdown

	public void deleteIconSCPC() throws IOException, InterruptedException {
		waitForElement(arca_savedCustomerProductCombinationsTable);
		// Waits for Delete Icon and clicks it
		WebElement deleteIconSCPC = waitForElement(arca_deleteIconSCPC);
		deleteIconSCPC.click();
		// Error message validation
//		errorMessageDelete();
		Thread.sleep(100);
		WebElement errorCancel = waitForElement(arca_errorCancel);
		errorCancel.click();
		System.out.println(
				"=> Clicked the Delete Icon of Saved Customer Product Combinations table without setting to delete option in the dropdown");

		try {
			waitForElement(arca_savedCustomerProductCombinationsTable);
			waitForElement(arca_downloadIconSCPC);
		} catch (Exception e) {
			waitForElement(arca_savedCustomerProductCombinationsTable);
			waitForElement(arca_downloadIconSCPC);
		}
//		Thread.sleep(3000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIcon_SavedCustomerProductCombinationstable.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	public void errorMessageDelete() {
		WebElement errorMessageDeleteIconSCPC = waitForElement(arca_errorMessageDeleteIconSCPC);
		String actualMsg = errorMessageDeleteIconSCPC.getText();
		String expectedMsg = "Please update at least one scenario dropdown value before clicking the Delete button to proceed with record deletion.";
		Assert.assertEquals(
				"=> The Error Toaster message validation for the Create Sensitivity Scenario button has failed!",
				expectedMsg, actualMsg);
	}

	// Download Icon of Saved Customer Product Combinations table
	public void downloadIconSCPC() throws IOException, InterruptedException {
		waitForElement(arca_savedCustomerProductCombinationsTable);
		// Waits for Download Icon and clicks it
		WebElement downloadIconSCPC = waitForElement(arca_downloadIconSCPC);
		downloadIconSCPC.click();
		System.out.println("=> Clicked the Download Icon of Saved Customer Product Combinations table");
		try {
			waitForElement(arca_savedCustomerProductCombinationsTable);
		} catch (Exception e) {
			waitForElement(arca_savedCustomerProductCombinationsTable);
		}

//		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DownloadIcon_SCPC.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	// Delete the records of the Saved Customer Product Combinations table
	public void deleteDropdownSCPC() throws IOException, InterruptedException {
		// Waits for the Delete Dropdown and clicks
		WebElement deleteDropdownSCPC = waitForElement(arca_deleteDropdownSCPC);
		deleteDropdownSCPC.click();
		System.out.println("=> Clicked the Delete Dropdown of Saved Customer Peer Selection table");
		Thread.sleep(3000);
		// Waits for the delete option in the dropdown and clicks
		WebElement deleteDropdownOptionSCPC = waitForElement(arca_deleteDropdownOptionSCPC);
		deleteDropdownOptionSCPC.click();
		System.out.println("=> Selected the Delete options of Saved Customer Peer Selection table");
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
		deleteIconSCPC.click();
		System.out.println(
				"=> Clicked the Delete Icon of Saved Customer Peer Selection table and the record deleted successfully");
		Thread.sleep(2000);
	}

	// Search and select the record of Saved Customer Product Combinations table
	public void searchForRecordSCPC() throws IOException, InterruptedException {
		// Waits for the Search bar
		WebElement searchKeywordSCPC = waitForElement(arca_searchKeywordSCPC);

		searchKeywordSCPC.click();
		searchKeywordSCPC.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSCPC = waitForElement(arca_searchRecordSCPC);
		String searchRecord = searchRecordSCPC.getText().trim();
		searchKeywordSCPC.sendKeys(searchRecord);
		System.out
				.println("=> Searched the Customer and Product Combination record of the Customer ID: " + searchRecord);
		Thread.sleep(2000);
		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "//table//tr[td[2][normalize-space()='" + searchRecord
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		actions.moveToElement(radioButton).click().perform();
		System.out.println("=> Selected the searched record of the Customer ID: " + searchRecord);
		Thread.sleep(1000);
		// Clearing the Search Keyword
		searchKeywordSCPC.click();
		searchKeywordSCPC.sendKeys(Keys.CONTROL + "a");
		searchKeywordSCPC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Waits for the Saved Customer Peer Selection record
		waitForElement(arca_savedCustomerProductCombinationsTable);

	}

	// Saved Scenario Simulations table
	// Selecting a record and performing other actions
	// Search for a keyword
	public void searchKeywordSSS() throws IOException, InterruptedException {
		// Waits for the Search bar of table
		WebElement searchKeywordSSS = waitForElement(arca_searchKeywordSSS);
		searchKeywordSSS.click();
		searchKeywordSSS.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSSS = waitForElement(arca_searchRecordSSS);
		String searchRecord = searchRecordSSS.getText().trim();
		searchKeywordSSS.sendKeys(searchRecord);
		System.out.println("=> Searched the Saved Sensitivity Scenario record of the Customer ID: " + searchRecord);
		Thread.sleep(2000);

		// Clearing the Search Keyword
		searchKeywordSSS.click();
		searchKeywordSSS.sendKeys(Keys.CONTROL + "a");
		searchKeywordSSS.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
	}

	// Clicks View Impact button with Selecting a record
	public void viewImapctWithSelection() throws IOException, InterruptedException {
		// Waits for the first row of table
		WebElement tableFirstRowSSS = waitForElement(arca_tableFirstRowSSS);
		tableFirstRowSSS.click();

		// Waits for the scenario name value of the table
		WebElement scenarioNameSSS = waitForElement(arca_scenarioNameSSS);
		String scenarioName = scenarioNameSSS.getText().trim();

		// Waits for the View Impact button
		WebElement viewImpactBtnSSS = waitForElement(arca_viewImpactBtnSSS);
		viewImpactBtnSSS.click();
		waitForElement(arca_scenarioSimulationPopUpSSS);
		Thread.sleep(2000);

		// Waits for the Scenario Name present in the View Impact Pop-Up
		WebElement scenarioNamePopUpSSS = waitForElement(arca_scenarioNamePopUpSSS);
		String scenarioNamePopUp = scenarioNamePopUpSSS.getText().trim();
		// Extract just the scenario name (after the colon)
		String extractedScenarioName = scenarioNamePopUp.substring(scenarioNamePopUp.indexOf(":") + 1).trim();
		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!scenarioName.equalsIgnoreCase(extractedScenarioName)) {
			throw new AssertionError("=> Mismatch in the Scenario Name : Selected = [" + scenarioName
					+ "] vs Filter = [" + extractedScenarioName + "]");
		}
		System.out.println(
				"=> The scenario names of the record matches successfully with the simuluation scenario name,\n and this validates that simulation screen is loaded with selected record:  "
						+ scenarioName + " == " + extractedScenarioName);

		// Waits for the View Impact button - Cancel button
		WebElement viewImpactBtnSSSCancelIcon = waitForElement(arca_viewImpactBtnSSSCancelIcon);
		viewImpactBtnSSSCancelIcon.click();
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(2000);
	}

	// Clicks View Impact button without Selecting a record
	public void viewImapctWithOutSelection() throws IOException, InterruptedException {
		// Waits for the View Impact button
		WebElement viewImpactBtnSSS = waitForElement(arca_viewImpactBtnSSS);
		viewImpactBtnSSS.click();
		waitForElement(arca_viewImpactBtnSSSError);
		// Waits for the View Impact button - Cancel button
		WebElement viewImpactBtnSSSCancelIcon = waitForElement(arca_viewImpactBtnSSSCancelIcon);
		viewImpactBtnSSSCancelIcon.click();
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(2000);
		System.out.println(
				"=> The View Scenario Impact button was clicked without selecting a record which throws an error message in a pop up");
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/Overview/ViewScnearioImpactBtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	// Clicks the Edit button and redirects to the create scenario
	public void editBtnSSS() throws IOException, InterruptedException {
		// Waits for the Customer and Product Combination column
		WebElement customerProductCombinationNameSSS = waitForElement(arca_customerProductCombinationNameSSS);
		String customerProductCombinationName = customerProductCombinationNameSSS.getText().trim();

		String radioXPath = "//table//tr[td[normalize-space()='" + customerProductCombinationName + "']]/td[2]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		String customerId = radioButton.getText().trim();
		actions.moveToElement(radioButton).click().perform();
		System.out.println("=> The Edit button of the Customer ID: " + customerId
				+ " is clicked whose Customer and Product Combination name is: " + customerProductCombinationName);
		// Waits for the Edit button
		WebElement editBtnSSS = waitForElement(arca_editBtnSSS);
		editBtnSSS.click();
		waitForElement(arca_csc_scenarioBothWidgets);
		Thread.sleep(1000);
		// Validating based on the Customer and Product Combination name from the filter
		// on Create Scenario
		WebElement csc_filter = waitForElement(arca_csc_filter);
		csc_filter.click();
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerProductCombinationOption = waitForElement(
				arca_csc_filterCustomerProductCombinationOption);
		csc_filterCustomerProductCombinationOption.click();
		// Waits for the Filter - Options - Value
		WebElement ca_filterCustomerProductCombinationOptionValue = waitForElement(
				arca_ca_filterCustomerProductCombinationOptionValue);
		Thread.sleep(5000);
		String filterCustomerProductCombinationOptionValue = ca_filterCustomerProductCombinationOptionValue.getText()
				.trim();

		// Assertion to validate selected and filtered customer and product combination
		// names
		if (!customerProductCombinationName.equalsIgnoreCase(filterCustomerProductCombinationOptionValue)) {
			throw new AssertionError(
					"=> Mismatch in Customer and Product Combination: Selected = [" + customerProductCombinationName
							+ "] vs Filter = [" + filterCustomerProductCombinationOptionValue + "]");
		}
		System.out.println(
				"=> The Customer and Product Combination names matched successfully and this validates that selected record is loaded in the Create Scenario Screen:  "
						+ customerProductCombinationName + " == " + filterCustomerProductCombinationOptionValue);

		// Verify whether it landed on the Auto Root Cause Analysis -
		// Customer Selections - Selections screen
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully redirected to the Customer Selections screen");

		// Waits for the Filter - Cancel button
		WebElement ca_filterCancelBtn = waitForElement(arca_ca_filterCancelBtn);
		ca_filterCancelBtn.click();
		waitForElement(arca_csc_filter);
		Thread.sleep(1000);

		// Redirection to the Overview screen
		driver.get(ConfigReader.arca_overview());
		System.out.println("=> Navigated back to the Overview screen from Create Scenario");
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
		System.out.println("=> Reloaded View Saved Scenario for metric: " + selectedMetricName);

	}

	// Delete's the record from Saved Scenario Simulations table
	public void deleteDropdownSSS() throws IOException, InterruptedException {
		// Waits for the Delete Dropdown and clicks
		WebElement deleteDropdownSSS = waitForElement(arca_deleteDropdownSSS);
		deleteDropdownSSS.click();
		System.out.println("=> Clicked the Delete Dropdown of Saved Scenario Simulations table");
		Thread.sleep(3000);
		// Waits for the delete option in the dropdown and clicks
		WebElement deleteDropdownOptionSSS = waitForElement(arca_deleteDropdownOptionSSS);
		deleteDropdownOptionSSS.click();
		System.out.println("=> Selected the Delete options of Saved Scenario Simulations table");
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
		deleteIconSSS.click();
		System.out.println(
				"=> Clicked the Delete Icon of Saved Customer Peer Selection table and the record deleted successfully");
		Thread.sleep(2000);
	}

	// Delete Icon of Saved Scenario Simulations table without setting to
	// delete option in the dropdown
	public void deleteIconSSS() throws IOException, InterruptedException {
		// Waits for Delete Icon and clicks it
		WebElement deleteIconSSS = waitForElement(arca_deleteIconSSS);
		deleteIconSSS.click();
		System.out.println(
				"=> Clicked the Delete Icon of Saved Scenario Simulations table without setting to delete option in the dropdown");
		Thread.sleep(1000);
		WebElement errorCancel = waitForElement(arca_errorCancel);
		errorCancel.click();
		try {
			waitForElement(arca_savedScenarioSimulationsTable);
			waitForElement(arca_downloadIconSSS);
		} catch (Exception e) {
			waitForElement(arca_savedScenarioSimulationsTable);
			waitForElement(arca_downloadIconSSS);
		}
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIcon_SSS.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Download Icon of Saved Scenario Simulations table
	public void downloadIconSSS() throws IOException, InterruptedException {
		waitForElement(arca_savedScenarioSimulationsTable);
		// Waits for Download Icon and clicks it
		WebElement downloadIconSSS = waitForElement(arca_downloadIconSSS);
		downloadIconSSS.click();
		System.out.println("=> Clicked the Download Icon of Saved Scenario Simulations table");
		waitForElement(arca_savedScenarioSimulationsTable);
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DownloadIcon_SSS.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	// Search and select the record of Saved Scenario Simulations table
	public void searchForRecord_SSS() throws IOException, InterruptedException {
		// Waits for the Search bar of table
		WebElement searchKeywordSSS = waitForElement(arca_searchKeywordSSS);
		searchKeywordSSS.click();
		searchKeywordSSS.clear();
		// Waits for the Customer ID from the first row of table
		WebElement searchRecordSSS = waitForElement(arca_searchRecordSSS);
		String searchRecord = searchRecordSSS.getText().trim();
		searchKeywordSSS.sendKeys(searchRecord);
		System.out.println("=> Searched the Sensitivity Scenario record of the Customer ID: " + searchRecord);
		Thread.sleep(2000);
		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "//table//tr[td[2][normalize-space()='" + searchRecord
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		actions.moveToElement(radioButton).click().perform();
		System.out.println("=> Selected the searched record of the Customer ID: " + searchRecord);
		Thread.sleep(3000);
		// Clearing the Search Keyword
		searchKeywordSSS.click();
		searchKeywordSSS.sendKeys(Keys.CONTROL + "a");
		searchKeywordSSS.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Waits for the Saved Scenario Simulation Table
		waitForElement(arca_savedScenarioSimulationsTable);

	}

}
