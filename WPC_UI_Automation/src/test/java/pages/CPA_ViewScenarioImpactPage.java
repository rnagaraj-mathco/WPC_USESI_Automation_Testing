package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

public class CPA_ViewScenarioImpactPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public CPA_ViewScenarioImpactPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // wait initialized once
		actions = new Actions(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Locators
	// xapth of the Filters btn
	By cpa_vsi_filters = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]");

	// xpath of the Filters - Customer + Scenario Name
	By cpa_vsi_filtersCustomerScenarioOption = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Filters - Customer + Scenario Name - Value 01
	By cpa_vsi_filterOptionValue01 = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Filters - Customer + Scenario Name - Value 02
	By cpa_vsi_filterOptionValue02 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[1]/label[2]/span[2]");

	// xpath of the Filters - Cancel btn
	By cpa_vsi_filtersCancelBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");

	// xpath of the chart component
	By cpa_vsi_chartComponent = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Back button
	By cpa_vsi_backBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");

	// xpath of the Create Scenario screen for validation
	// xpath of the Create Scenario screen - Filter button
	By cpa_csc_filtersBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Create Scenario screen - Filter - Customer + Peer Selection Name
	// option
	By cpa_csc_filterCustomerPeerGroupOption = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Create Scenario screen - Filter - Customer + Peer Selection Name
	// - Value01
	By cpa_csc_filterCustomerPeerGroupOptionValue01 = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Filter - Cancel button
	By cpa_csc_filterCancelBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the VSI - Chart - After button
	By cpa_csc_afterBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/button[2]/span[1]");

	// xpath of the VSI - Chart - After button - Enterprise Profit text
	By cpa_csc_valueEPTextAfter = By.xpath("(//*[name()='g'][@class='point']/*[name()='text'])[last()]");

	// xpath of the VSI - Chart - Before button - Enterprise Profit text
	By cpa_csc_valueEPTextBefore = By.xpath("(//*[name()='g'][@class='point']/*[name()='text'])[last()]");

	// xpath of the VSI - Chart - Comparison
	By cpa_csc_comparisonBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/button[3]/span[1]");

	// xpath of the VSI - Chart - Before
	By cpa_csc_beforeBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]");

	// xpath of the VSI - Chart - Comparison - Table
	By cpa_csc_comparisonBtnTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]");

	// xpath of the VSI - Chart - Comparison - Table - Searchbar
	By cpa_csc_comparisonBtnTableSearchBar = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the VSI - Chart - Comparison - Table - Download icon
	By cpa_csc_comparisonBtnTableDownload = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// xpath of the VSI - Chart - Comparison - Table - First Row: First Cell
	By cpa_csc_comparisonBtnTableSearchRecord = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// xpath of the VSI - Reset Button
	By cpa_csc_resetBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/button[1]/span[1]");

	// xpath of th Geographical Map
	By cpa_geographicalMap = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div");

	// Loads the View Impact screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the View Scenario Impact screen
		driver.get(ConfigReader.cpa_viewScenarioImapct());
		// waits till the silder component is loaded
//		waitForElement(cpa_csc_scenarioSlider);
		Thread.sleep(2000);
//		waitForElement(cpa_csc_saveAndShowImpactBtn);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/ScenarioBuilder/ViewScenarioImpact/ViewScenarioImpactScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Scenario builder - View Scenario Impact
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.cpa_viewScenarioImapct();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully landed on the Scenario screen with the sliders required to simulate the scenario");

	}

	private String filterOptionValue01;

	// Clicks on the filter and perform operations
	public void filtersTo() throws IOException, InterruptedException {
		// waits for the Filter btn
		WebElement vsi_filters = waitForElement(cpa_vsi_filters);
		vsi_filters.click();
		// Filters - Customer + Scenario Name
		WebElement vsi_filtersCustomerScenarioOption = waitForElement(cpa_vsi_filtersCustomerScenarioOption);
		vsi_filtersCustomerScenarioOption.click();
		// waits for the Filters - Customer + Scenario Name - Value 01
		WebElement vsi_filterOptionValue01 = waitForElement(cpa_vsi_filterOptionValue01);
		// extracts the value 01 for the validation
		this.filterOptionValue01 = vsi_filterOptionValue01.getText().trim();
		// waits for the Filters - Customer + Scenario Name - Value 02
		WebElement vsi_filterOptionValue02 = waitForElement(cpa_vsi_filterOptionValue02);
		String filterOptionValue02 = vsi_filterOptionValue02.getText().trim();
		vsi_filterOptionValue02.click();
		// Now clicking again the Filters - Customer + Scenario Name - Value 01
		vsi_filterOptionValue01.click();
		try {
			waitForElement(cpa_vsi_filterOptionValue01);
		} catch (Exception e) {
			waitForElement(cpa_vsi_filterOptionValue01);
		}

		System.out.println("=> The Filter was clicked and selected a Customer + Scenario name: " + filterOptionValue02
				+ "  and then selected the :" + filterOptionValue01);
		// waits for the Filters - Cancel button
		WebElement vsi_filtersCancelBtn = waitForElement(cpa_vsi_filtersCancelBtn);
		vsi_filtersCancelBtn.click();
		try {
			waitForElement(cpa_vsi_chartComponent);
		} catch (Exception e) {
			waitForElement(cpa_vsi_chartComponent);
		}
		Thread.sleep(2000);

	}

	private String customerId, createScenarioCustomerId, enterpriseValueBefore;

	// Clicks the Back button
	public void backBtn() throws IOException, InterruptedException {
		// Extracts the customer details from the filter option value
		String customerDetails = filterOptionValue01.split("\\+")[0].trim();
		this.customerId = customerDetails.split("_")[0].trim();
		// waits for the back button
		WebElement vsi_backBtn = waitForElement(cpa_vsi_backBtn);
		actions.moveToElement(vsi_backBtn, 0, 0).click().perform();
		System.out.println(customerId);
		System.out.println("=> The Back button was clicked and redirected to the Create Scenario screen");
		Thread.sleep(3000);
		// Validating the Filter of create scenario
		// waits for the Create Scenario - Filter
		WebElement csc_filtersBtn = waitForElement(cpa_csc_filtersBtn);
		csc_filtersBtn.click();

		// waits for the Create Scenario - Filter - Options
		WebElement csc_filterCustomerPeerGroupOption = waitForElement(cpa_csc_filterCustomerPeerGroupOption);
		csc_filterCustomerPeerGroupOption.click();
		// waits for the Create Scenario - Filter - Options Value
		WebElement csc_filterCustomerPeerGroupOptionValue01 = waitForElement(
				cpa_csc_filterCustomerPeerGroupOptionValue01);
		String filterCustomerPeerGroupOptionValue01 = csc_filterCustomerPeerGroupOptionValue01.getText().trim();
		String createScenariocustomerDetails = filterCustomerPeerGroupOptionValue01.split("\\+")[0].trim();
		this.createScenarioCustomerId = createScenariocustomerDetails.split("_")[0].trim();
		// Validating the Customer details
		if (!createScenarioCustomerId.equalsIgnoreCase(customerId)) {
			throw new AssertionError("=> Mismatch in the Customer Id | View Scenario Impact = [" + customerId
					+ "] vs Create Scenario  = [" + createScenarioCustomerId + "]");
		}
		System.out.println(
				"=> The Customer ID  matched and confirms that the redirection is of the same customer records");

		// waits for the Filter - Cancel
		WebElement csc_filterCancelBtn = waitForElement(cpa_csc_filterCancelBtn);
		csc_filterCancelBtn.click();
		try {
			waitForElement(cpa_csc_filtersBtn);
		} catch (Exception e) {
			waitForElement(cpa_csc_filtersBtn);
		}
		// Navigating to the View Scenario impact
		driver.get(ConfigReader.cpa_viewScenarioImapct());
		try {
			waitForElement(cpa_vsi_filters);
			waitForElement(cpa_vsi_chartComponent);
		} catch (Exception e) {
			waitForElement(cpa_vsi_filters);
			waitForElement(cpa_vsi_chartComponent);
		}
		waitForElement(cpa_vsi_chartComponent);
		// Extracting the Enterprise value to validate
		WebElement csc_valueEPTextBefore = waitForElement(cpa_csc_valueEPTextBefore);
		this.enterpriseValueBefore = csc_valueEPTextBefore.getText().trim();

	}

	// clicks on the After button
	public void afterBtn() throws IOException, InterruptedException {
		// waits for the After button
		WebElement csc_afterBtn = waitForElement(cpa_csc_afterBtn);
		csc_afterBtn.click();
		// waits for the chart
		try {
			waitForElement(cpa_vsi_chartComponent);
			waitForElement(cpa_vsi_backBtn);
		} catch (Exception e) {
			waitForElement(cpa_vsi_chartComponent);
			waitForElement(cpa_vsi_backBtn);
		}

		WebElement csc_valueEPTextAfter = waitForElement(cpa_csc_valueEPTextAfter);
		String enterpriseValueAfter = csc_valueEPTextAfter.getText().trim();
		if (!enterpriseValueAfter.equalsIgnoreCase(enterpriseValueBefore)) {
			System.out.println(
					"=> Simulation: The Enterprise Profit value is not matched, which means it confirms that simulation has happened");
		} else {
			System.out.println(
					"=> No Simulation: The Enterprise Profit value is matched, which means there was no simulation happened");
		}
		// waits for the chart
		try {
			waitForElement(cpa_vsi_chartComponent);
			waitForElement(cpa_vsi_backBtn);
		} catch (Exception e) {
			waitForElement(cpa_vsi_chartComponent);
			waitForElement(cpa_vsi_backBtn);
		}
	}

	// clicks on the Comparison table
	public void comparisonBtn() throws IOException, InterruptedException {
		// waits for the compare button
		WebElement csc_comparisonBtn = waitForElement(cpa_csc_comparisonBtn);
		csc_comparisonBtn.click();
		try {
			waitForElement(cpa_csc_comparisonBtnTable);
		} catch (Exception e) {
			waitForElement(cpa_csc_comparisonBtnTable);
		}
		waitForElement(cpa_csc_comparisonBtnTable);
//		WebElement csc_comparisonBtnTableSearchBar = waitForElement(cpa_csc_comparisonBtnTableSearchBar);
//		csc_comparisonBtnTableSearchBar.click();
//		csc_comparisonBtnTableSearchBar.clear();
//		csc_comparisonBtnTableSearchBar.sendKeys("Enterprise Profit");
		String targetMetric = "Enterprise Profit";

		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if (cells.size() < 3)
				continue;

			String metric = cells.get(0).getText().trim();
			if (metric.equalsIgnoreCase(targetMetric)) {
				String beforeText = cells.get(1).getText().replace("$", "").replace(",", "").trim();
				String afterText = cells.get(2).getText().replace("$", "").replace(",", "").trim();

				double beforeValue = Double.parseDouble(beforeText);
				double afterValue = Double.parseDouble(afterText);

				if (beforeValue != afterValue) {
					System.out.println("=> The Scenario has been created as there is difference between the values of "
							+ targetMetric + " : Before = " + beforeValue + " and After = " + afterValue);
				} else {
					System.out.println(
							"=> The Scenario has NOT created because there is NO difference between the values of "
									+ targetMetric + ": Before = After = " + beforeValue);
				}
				return;
			}
		}

		System.out.println("❗ Metric not found in table: " + targetMetric);

	}

	// Search's for the keyword in table
	public void searchKeywordComparison() throws IOException, InterruptedException {
		// waits for the table
		waitForElement(cpa_csc_comparisonBtnTable);
		// waits for the search bar of the comparison table
		WebElement csc_comparisonBtnTableSearchBar = waitForElement(cpa_csc_comparisonBtnTableSearchBar);
		csc_comparisonBtnTableSearchBar.click();
		csc_comparisonBtnTableSearchBar.clear();
		// waits for the first row of the table
		WebElement csc_comparisonBtnTableFirstRow = waitForElement(cpa_csc_comparisonBtnTableSearchRecord);
		String searchRecord = csc_comparisonBtnTableFirstRow.getText().trim();
		csc_comparisonBtnTableSearchBar.sendKeys(searchRecord);
		Thread.sleep(1000);

		// clearing the search
		// Clearing the Search Keyword
		csc_comparisonBtnTableSearchBar.click();
		csc_comparisonBtnTableSearchBar.sendKeys(Keys.CONTROL + "a");
		csc_comparisonBtnTableSearchBar.sendKeys(Keys.BACK_SPACE);
		System.out.println("=> The keyword was searched in the Comparison table");
		// waits the table
		try {
			waitForElement(cpa_csc_comparisonBtnTableSearchRecord);
		} catch (Exception e) {
			waitForElement(cpa_csc_comparisonBtnTableSearchRecord);
		}
	}

	// clicks on the download icon
	public void downloadIconComparison() throws IOException, InterruptedException {
		// waits for the table
		waitForElement(cpa_csc_comparisonBtnTable);

		// waits for the download icon of the table
		WebElement csc_comparisonBtnTableDownload = waitForElement(cpa_csc_comparisonBtnTableDownload);
		csc_comparisonBtnTableDownload.click();
		try {
			waitForElement(cpa_csc_comparisonBtnTable);
		} catch (Exception e) {
			waitForElement(cpa_csc_comparisonBtnTable);
		}
		System.out.println(
				"=> The download icon of the Comparison table was clicked and downloaded the table records as an excel file");

	}

	// clicks on the reset button
	public void resetBtn() throws IOException, InterruptedException {
		// waits for the Reset button
		WebElement csc_resetBtn = waitForElement(cpa_csc_resetBtn);
		csc_resetBtn.click();
		try {
			waitForElement(cpa_geographicalMap);
		} catch (Exception e) {
			waitForElement(cpa_geographicalMap);
		}

		// Verify whether it landed on the Scenario builder - View Scenario Impact
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.cpa_branchCustomerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully landed on the Branch/Customer Selection screen by clicking the Reset button of the View Imapct Screen");

	}

}
