package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import utils.ElementHelper;

public class ARCA_FilterCustomerProductCombinationsPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	ElementHelper helper;

	// gets driver status
	public ARCA_FilterCustomerProductCombinationsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(90)); // wait initialized once
		actions = new Actions(driver);
		this.helper = new ElementHelper(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

// Filter Customer and Product Combination (fcp)
// Locators
	By arca_fcp_treeMap = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]");

	// xpath of the Save Combination button
	By arca_fcp_saveCombinationBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/button[1]");

	// xpath of the Error message - Save combination without selection
	By arca_fcp_errorSaveCombinationBtn = By
			.xpath("//h4[contains(text(),'⚠️ No customer-product combination selected.')]");

// xpath of the Select All Customers checkbox
	By arca_fcp_selectAllCustomersCheckbox = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/div[1]/fieldset[1]/label[1]");

// xpath of the Select All Commodity Codes checkbox
	By arca_fcp_selectAllCommodityCodeCheckbox = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/div[1]/fieldset[1]/label[1]");

// xpath of the Reset Button
	By arca_fcp_resetBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/button[1]/span[1]");

// xpath of the Customer Details button
	By arca_fcp_customerDetailsBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]/span[1]");

// xpath of the Customer Details btn - Select Customers for Analysis pop-up
// screen
	By arca_fcp_customerDetailsBtnPopUp = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]");

// xpath of the Customer Details btn - Select Customers for Analysis pop-up -
// Close
	By arca_fcp_customerDetailsBtnPopUpClose = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/span[1]/*[name()='svg'][1]");

	// xpath of clicked customer tile 01 - ctm: customer tree map (31445)
	By arca_fcp_ctm_customerTile1 = By.xpath("(//div//*[name()='svg']/*[name()='g'])[1]");

	// xpath of clicked customer tile 02 - ctm: customer tree map (312619)
	By arca_fcp_ctm_customerTile2 = By.xpath("(//div//*[name()='svg']/*[name()='g'])[2]");

	// xpath of clicked customer tile 03 - ctm: customer tree map (313226)
	By arca_fcp_ctm_customerTile3 = By.xpath("(//div//*[name()='svg']/*[name()='g'])[3]");

	// xpath of commodity code tile 01: (01230)

	By arca_fcp_ctm_commodityCodeTile1 = By.xpath("(//div//*[name()='svg']/*[name()='g'])[5]");

	// xpath of commodity code tile 02: (15300)
	By arca_fcp_ctm_commodityCodeTile2 = By.xpath("(//div//*[name()='svg']/*[name()='g'])[6]");

	// xpath of commodity code tile 03: (32112)
	By arca_fcp_ctm_commodityCodeTile3 = By.xpath("(//div//*[name()='svg']/*[name()='g'])[7]");

	// View Root Cause Analysis table - VRCA
	// xpath of root cause customer details
	By arca_fcp_tableVRCA = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]");

	// xpath of search bar of VRCA
	By arca_fcp_tableSearchbarVRCA = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the VRCA table first row - Customer ID
	By arca_fcp_tableSearchRecordVRCA = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/div[1]");

	// xpath of the VRCA - Download icon
	By arca_fcp_tableDownloadIcon = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]/span[1]");

	// xpath of the VRCA - Next Page button
	By arca_fcp_tableNextPaginationVRCA = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/button[2]");

	// xpath of the VRCA - Apply button
	By arca_fcp_tableVRCAapplyBtn = By
			.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/button[1]");

	// xpath of the VRCA - Cancel icon
	By arca_fcp_cancelBtn = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]");

	// xpath of the Customer Selection - Select One Customer for Simulation table
	By arca_cs_tableSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]");

	// xpath of the Customer Selection - SOC Pagination
	By arca_cs_tableNextPaginationSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/button[2]");

	// xpath of the checkbox of VRCA table for selecting the customer - 01
	By arca_cs_tableVRCACheckbox1 = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]");

	// xpath of the checkbox of VRCA table for selecting the customer - 02
	By arca_cs_tableVRCACheckbox2 = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[1]/div[1]");

	// xpath of the checkbox of VRCA table for selecting the customer - 03
	By arca_cs_tableVRCACheckbox3 = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[3]/td[1]/div[1]");

	// xpath of the download icon of VRCA table
	By arca_fcp_downloadIconVRCA = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// xpath of the search bar VRCA
	By arca_fcp_searchBarVRCA = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the seached record of VRCA
	By arca_fcp_searchRecordVRCA = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// Lands on the Filter Customer and Product Combinations
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Filter Customer and Product Combinations screen
		driver.get(ConfigReader.arca_filterCustomerAndProductCombinations());
		// waits till the Root Cause Customers for the Selected Cost Metric
		try {
			waitForElement(arca_fcp_treeMap);
		} catch (Exception e) {
			waitForElement(arca_fcp_treeMap);
		}
		waitForElement(arca_fcp_saveCombinationBtn);
		System.out.println(
				"=> The Filter Customer and Product Combination screen is loaded with the Tree map based on the customers selected");
		Thread.sleep(2000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/CustomerSelections/FilterCustomerAndProductCombinations/FCPCScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Auto Root Cause Analysis - CustomerAnalysis
		String currentUrl = driver.getCurrentUrl();
		String expectedbranchCustomerSelectionUrl = ConfigReader.arca_filterCustomerAndProductCombinations();

		if (!currentUrl.equalsIgnoreCase(expectedbranchCustomerSelectionUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully landed on Filter Customer and Product Combination screen");

	}

	// Clicks the Save Combination without selecting the customer or commodity codes
	public void saveCombinationsWithoutSelections() throws IOException, InterruptedException {
		// waits for the save combination button
		WebElement fcp_saveCombinationBtn = waitForElement(arca_fcp_saveCombinationBtn);
//		fcp_saveCombinationBtn.click();
		helper.safeClick(fcp_saveCombinationBtn);
		System.out.println(
				"=> The Save Combination button was clicked without selecting any customers or commodity codes, which displayed an error message.");
		errorMessage();
		try {
			waitForElement(arca_fcp_treeMap);
		} catch (Exception e) {
			waitForElement(arca_fcp_treeMap);
		}
		waitForElement(arca_fcp_treeMap);
		waitForElement(arca_fcp_saveCombinationBtn);

	}

	// Save combination without Selection - Error message
	public void errorMessage() {
		WebElement errorToasterMessage = waitForElement(arca_fcp_errorSaveCombinationBtn);
		String actualMsg = errorToasterMessage.getText();
		String expectedMsg = "⚠️ No customer-product combination selected.";
		Assert.assertEquals(
				"=> The Error Toaster message validation for the Create Sensitivity Scenario button has failed!",
				expectedMsg, actualMsg);
	}

	// Clicks the Select All Customer checkbox
	public void selectAllCustomer() throws IOException, InterruptedException {
		// Waits for the Select All Customer Checkbox
		WebElement fcp_selectAllCustomersCheckbox = waitForElement(arca_fcp_selectAllCustomersCheckbox);
//		fcp_selectAllCustomersCheckbox.click();
		helper.safeClick(fcp_selectAllCustomersCheckbox);
		System.out.println(
				"=> The Select All Customer checkbox was clicked which then selected the entire customers in the tree map");
		Thread.sleep(2000);
		// Waits for the Tree Map updation
		try {
			waitForElement(arca_fcp_treeMap);
		} catch (Exception e) {
			waitForElement(arca_fcp_treeMap);
		}
		Thread.sleep(2000);
	}

	// Clicks the Reset Button
	public void resetBtn() throws IOException, InterruptedException {
		// Waits for the Reset button
		WebElement fcp_resetBtn = waitForElement(arca_fcp_resetBtn);
//		fcp_resetBtn.click();
		helper.safeClick(fcp_resetBtn);
		System.out.println("=> The Reset button was clicked which restored the tree map to its previous state");
		Thread.sleep(2000);
		// Waits for the Tree Map updation
		try {
			waitForElement(arca_fcp_treeMap);
		} catch (Exception e) {
			waitForElement(arca_fcp_treeMap);
		}
		Thread.sleep(2000);
	}

	// Clicks the Select All Commodity checkbox
	public void selectAllCommodityCode() throws IOException, InterruptedException {
		waitForElement(arca_fcp_treeMap);
		// Waits for the Select All Commodity Code checkbox
		WebElement fcp_selectAllCommodityCodeCheckbox = waitForElement(arca_fcp_selectAllCommodityCodeCheckbox);
//		fcp_selectAllCommodityCodeCheckbox.click();
		helper.safeClick(fcp_selectAllCommodityCodeCheckbox);
		System.out.println(
				"=> The Select All Commodity Codes checkbox was clicked which then selected the entire customers and commodities in the tree map");

		List<String> selectedCustomerIDs = new ArrayList<>();
		List<String> selectedProductCounts = new ArrayList<>();

		// 1. Get all selected tiles using SVG fill
		List<WebElement> selectedTiles = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[name()='svg']//*[name()='rect' and @fill='#6A8FA3']")));

		System.out.println("=> Total selected tiles found: " + selectedTiles.size());

		for (WebElement tile : selectedTiles) {
			try {
				// 2. Filter only tiles with fill='#6A8FA3'
				String fill = tile.getAttribute("fill").trim();
				if (!fill.equalsIgnoreCase("#6A8FA3"))
					continue;

				// Scroll into view just in case
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tile);
				actions.moveToElement(tile).pause(Duration.ofMillis(500)).perform();

				// 3. Wait for tooltip container
				WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(@class,'MuiTooltip') or contains(@style,'z-index')]")));
				Thread.sleep(5000);

				String tooltipText = tooltip.getText();
				System.out.println("=> Tooltip Text:\n" + tooltipText);

				// 4. Extract Customer ID
				String customerId = tooltipText.split("Customer ID:")[1].split("Customer Name:")[0].trim();

				// 5. Extract No. of Root Cause Products
				String productCount = tooltipText.split("No. of Root Cause Products:")[1].split("\\$")[0].trim();

				selectedCustomerIDs.add(customerId);
				selectedProductCounts.add(productCount);

				System.out.println("=> ID: " + customerId + " | Products: " + productCount);
			} catch (Exception e) {
				System.out.println("=> Skipped a tile due to missing or malformed tooltip.");
			}
		}

		// Final list output
		System.out.println("=> Customer IDs: " + selectedCustomerIDs);
		System.out.println("=> Root Cause Products: " + selectedProductCounts);
	}

	// This is to validate with the list of the Save Customer button
	List<Double> selectedCustomerIds = new ArrayList<>();

	// Clicks the Select All Commodity checkbox
	public void customerDetailsBtn() throws IOException, InterruptedException {
		// Open Customer Details popup
		WebElement fcp_customerDetailsBtn = waitForElement(arca_fcp_customerDetailsBtn);
//		fcp_customerDetailsBtn.click();
		helper.safeClick(fcp_customerDetailsBtn);
		System.out.println("=> The Customer Details button was clicked");
		waitForElement(arca_fcp_customerDetailsBtnPopUp);
		waitForElement(arca_fcp_tableVRCA);

		// Download icon
		WebElement fcp_tableDownloadIcon = waitForElement(arca_fcp_tableDownloadIcon);
//		fcp_tableDownloadIcon.click();
		helper.safeClick(fcp_tableDownloadIcon);
		System.out.println("=> Clicked the download icon of the View Root Cause Analysis table");
		Thread.sleep(3000);

		// Loop through pages and search for the checked customer record
		while (true) {
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

			for (WebElement row : rows) {
				try {
					WebElement checkbox = row.findElement(By.xpath("td[1]//input[@type='checkbox']"));

					if (checkbox.isSelected()) {
						String customerIdText = row.findElement(By.xpath("td[2]")).getText().trim();
						if (!customerIdText.isEmpty()) {
							selectedCustomerIds.add(Double.parseDouble(customerIdText));
						}
					}
				} catch (Exception e) {
					System.out.println("⚠️ Skipped row due to error: " + e.getMessage());
				}
			}

			// Check pagination
			WebElement nextButton = driver.findElement(arca_fcp_tableNextPaginationVRCA);
			String isDisabled = nextButton.getAttribute("disabled");
			if (isDisabled != null && (isDisabled.equals("true") || isDisabled.equals("disabled"))) {
				break;
			}
//			nextButton.click();
			helper.safeClick(nextButton);
			Thread.sleep(1000); // slight wait for pagination to load
		}

		System.out.println("=> The Selected Customer IDs: " + selectedCustomerIds);
		waitForElement(arca_fcp_tableVRCA);
		Thread.sleep(3000);

		// Waits for the Cancel button
		WebElement fcp_cancelBtn = waitForElement(arca_fcp_cancelBtn);
//		fcp_cancelBtn.click();
		helper.safeClick(fcp_cancelBtn);

		waitForElement(arca_fcp_treeMap);
		Thread.sleep(3000);
	}

	// Clicks on the save combination button
	// This code was working but the customer selection from table is not being
	// carried forward due to error message coming when Apply button is clicked that
	// no customer is selected
//	public void saveCombinationsBtn() throws IOException, InterruptedException {
//		// Waits for the Save Combination Button
//		WebElement fcp_saveCombinationBtn = waitForElement(arca_fcp_saveCombinationBtn);
//		fcp_saveCombinationBtn.click();
//		System.out.println("=> Clicked the Save Combinations Button and redirected to the Customer Screen");
//		Thread.sleep(3000);
//		waitForElement(arca_cs_tableSOC);
//		Thread.sleep(5000);
//		// Stores all the customer Id of Select one customer for simulation table
//		List<Double> customerIdSOC = new ArrayList<>();
////		boolean mismatchFound = false;
//
//		while (true) {
//			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
//
//			for (WebElement row : rows) {
//				try {
//					// Similarity score
//					String scoreText = row.findElement(By.xpath("td[2]")).getText().trim();
//					if (!scoreText.isEmpty()) {
//						customerIdSOC.add(Double.parseDouble(scoreText));
//					}
//
//				} catch (Exception e) {
//					System.out.println("--- Skipped row due to error: " + e.getMessage());
//				}
//			}
//
//			WebElement nextButton = driver.findElement(arca_cs_tableNextPaginationSOC);
//			String isDisabled = nextButton.getAttribute("disabled");
//			if (isDisabled != null && (isDisabled.equals("true") || isDisabled.equals("disabled"))) {
//				break;
//			}
//			nextButton.click();
//
//		}
//		System.out.println(
//				"=> The Customer Id present in the Single One Customer for Simualtions table is " + customerIdSOC);
//
//		// Validating whether the selected customer details are present or not
//		// Compare both lists
//		Set<Double> selectedSet = new HashSet<>(selectedCustomerIds);
//		Set<Double> socSet = new HashSet<>(customerIdSOC);
//
//		// Find missing and extra IDs
//		Set<Double> missingInSOC = new HashSet<>(selectedSet);
//		missingInSOC.removeAll(socSet);
//
//		Set<Double> extraInSOC = new HashSet<>(socSet);
//		extraInSOC.removeAll(selectedSet);
//
//		if (missingInSOC.isEmpty() && extraInSOC.isEmpty()) {
//			System.out.println("=> All selected customer IDs are correctly reflected in the SOC table.");
//		} else {
//			System.out.println("=> Validation failed:");
//			if (!missingInSOC.isEmpty())
//				System.out.println("=> Missing in SOC: " + missingInSOC);
//			if (!extraInSOC.isEmpty())
//				System.out.println("=> Unexpected in SOC: " + extraInSOC);
//
//			throw new AssertionError("=> Customer ID mismatch between Customer Details and SOC tables.");
//		}
//
//		Thread.sleep(8000);
//
//	}

	// this is of working save customer where I was able to identify the error
	// message when Apply button
	public void saveCombinationsBtnWithSelections() throws IOException, InterruptedException {
		// Wait for and click the Save Combination Button
		WebElement fcp_saveCombinationBtn = waitForElement(arca_fcp_saveCombinationBtn);

		try {
			// Attempt normal click
			helper.safeClick(fcp_saveCombinationBtn);
			System.out.println("=> Clicked the Save Combinations Button and redirected to the Customer Screen");
		} catch (Exception e) {
			System.out.println("=> Intercepted! Clicking via JS...");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", fcp_saveCombinationBtn);
			System.out.println("=> Clicked the Save Combinations Button");
		}

		// Wait for the SOC table
		waitForElement(arca_cs_tableSOC);
		Thread.sleep(5000); // slight wait to allow full rendering

		// Stores all the customer Ids from Select One Customer for Simulation table
		List<Double> customerIdSOC = new ArrayList<>();

		while (true) {
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

			for (WebElement row : rows) {
				try {
					String scoreText = row.findElement(By.xpath("td[2]")).getText().trim();
					if (!scoreText.isEmpty()) {
						customerIdSOC.add(Double.parseDouble(scoreText));
					}
				} catch (Exception e) {
					System.out.println("--- Skipped row due to error: " + e.getMessage());
				}
			}

			// Robustly locate pagination button
			List<WebElement> nextButtons = driver.findElements(arca_cs_tableNextPaginationSOC);
			if (nextButtons.isEmpty()) {
				System.out.println("=> No pagination button — single page table.");
				break;
			}

			WebElement nextButton = nextButtons.get(0);
			String isDisabled = nextButton.getAttribute("disabled");
			if (isDisabled != null && (isDisabled.equals("true") || isDisabled.equals("disabled"))) {
				break;
			}

			helper.safeClick(nextButton);
			Thread.sleep(1000); // allow table to load
		}

		System.out.println(
				"=> The Customer Ids present in the Select One Customer for Simulations table are: " + customerIdSOC);

		// === Final Validation ===

		// Convert both lists to sets for comparison without considering order
		Set<Double> selectedSet = new HashSet<>(selectedCustomerIds);
		Set<Double> socSet = new HashSet<>(customerIdSOC);

		// Find missing and extra items
		Set<Double> missingInSOC = new HashSet<>(selectedSet);
		missingInSOC.removeAll(socSet); // Elements in selected but not in SOC

		Set<Double> extraInSOC = new HashSet<>(socSet);
		extraInSOC.removeAll(selectedSet); // Elements in SOC but not in selected

		if (missingInSOC.isEmpty() && extraInSOC.isEmpty()) {
			System.out.println("=> All selected customer IDs are correctly reflected in the SOC table.");
		} else {
			System.out.println("=> Validation failed:");
			if (!missingInSOC.isEmpty())
				System.out.println("=> Missing in SOC: " + missingInSOC);
			if (!extraInSOC.isEmpty())
				System.out.println("=> Unexpected in SOC: " + extraInSOC);

			throw new AssertionError("=> Customer ID mismatch between Customer Details and SOC tables.");
		}

		Thread.sleep(2000); // final buffer if needed
	}

	// Individual selection of customer
	public void customerSelection() throws IOException, InterruptedException {
		// Waits for the Select All Customers checkbox
		WebElement fcp_selectAllCustomersCheckbox = waitForElement(arca_fcp_selectAllCustomersCheckbox);
//		fcp_selectAllCustomersCheckbox.click();
		helper.safeClick(fcp_selectAllCustomersCheckbox);
		System.out.println(
				"=> The Select All Customers checkbox was clicked which then selected the entire customers and commodities in the tree map");

		// Waits for the Tree Map updation
		waitForElement(arca_fcp_treeMap);

		// Ctrl + Click multiple tiles to preserve selections
		WebElement fcp_ctm_customerTile1 = waitForElement(arca_fcp_ctm_customerTile1);
		WebElement fcp_ctm_customerTile2 = waitForElement(arca_fcp_ctm_customerTile2);
		WebElement fcp_ctm_customerTile3 = waitForElement(arca_fcp_ctm_customerTile3);

		actions.keyDown(Keys.CONTROL).click(fcp_ctm_customerTile1).click(fcp_ctm_customerTile2)
				.click(fcp_ctm_customerTile3).keyUp(Keys.CONTROL).build().perform();
		waitForElement(arca_fcp_treeMap);

	}

	// Individual selection of commodities code
	public void commodityCodeSelection() throws IOException, InterruptedException {

		// Waits for the Tree Map updation
		waitForElement(arca_fcp_treeMap);

		// Ctrl + Click multiple tiles to preserve selections
		WebElement fcp_ctm_commodityCodeTile1 = waitForElement(arca_fcp_ctm_commodityCodeTile1);
//		fcp_ctm_commodityCodeTile1.click();
		helper.safeClick(fcp_ctm_commodityCodeTile1);
		Thread.sleep(2000);
		WebElement fcp_ctm_commodityCodeTile2 = waitForElement(arca_fcp_ctm_commodityCodeTile2);
//		fcp_ctm_commodityCodeTile2.click();
		helper.safeClick(fcp_ctm_commodityCodeTile2);
		Thread.sleep(2000);
		WebElement fcp_ctm_commodityCodeTile3 = waitForElement(arca_fcp_ctm_commodityCodeTile3);
//		fcp_ctm_commodityCodeTile3.click();
		helper.safeClick(fcp_ctm_commodityCodeTile3);
		Thread.sleep(2000);

		waitForElement(arca_fcp_treeMap);
		Thread.sleep(5000);
	}

	// Click on customer details button and select the customers
	public void customerDetailsBtnSelectCustomers() throws IOException, InterruptedException {
		try {
			waitForElement(arca_fcp_treeMap);
		} catch (Exception e) {
			waitForElement(arca_fcp_treeMap);
		}
		// Open Customer Details popup
		WebElement fcp_customerDetailsBtn = waitForElement(arca_fcp_customerDetailsBtn);
//		fcp_customerDetailsBtn.click();
		helper.safeClick(fcp_customerDetailsBtn);
		System.out.println("=> The Customer Details button was clicked");
		try {
			waitForElement(arca_fcp_customerDetailsBtnPopUp);
			waitForElement(arca_fcp_tableVRCA);
		} catch (Exception e) {
			waitForElement(arca_fcp_customerDetailsBtnPopUp);
			waitForElement(arca_fcp_tableVRCA);
		}
		waitForElement(arca_fcp_customerDetailsBtnPopUp);
		waitForElement(arca_fcp_tableVRCA);
		// Waits for the checkbox of the customer: 01
		WebElement cs_tableVRCACheckbox1 = waitForElement(arca_cs_tableVRCACheckbox1);
//		cs_tableVRCACheckbox1.click();
		helper.safeClick(cs_tableVRCACheckbox1);
		// Waits for the checkbox of the customer: 02
		WebElement cs_tableVRCACheckbox2 = waitForElement(arca_cs_tableVRCACheckbox2);
//		cs_tableVRCACheckbox2.click();
		helper.safeClick(cs_tableVRCACheckbox2);
		// Waits for the checkbox of the customer: 03
		WebElement cs_tableVRCACheckbox3 = waitForElement(arca_cs_tableVRCACheckbox3);
//		cs_tableVRCACheckbox3.click();
		helper.safeClick(cs_tableVRCACheckbox3);
		Thread.sleep(1000);
		try {
			waitForElement(arca_fcp_treeMap);
		} catch (Exception e) {
			waitForElement(arca_fcp_treeMap);
		}

	}

	// Clicks on the download icon of the VRCA table
	public void downloadIconVRCA() throws IOException, InterruptedException {
		// Waits for the download icon of the VRCA table
		WebElement fcp_downloadIconVRCA = waitForElement(arca_fcp_downloadIconVRCA);
//		fcp_downloadIconVRCA.click();
		helper.safeClick(fcp_downloadIconVRCA);
		System.out.println("=> Clicked the Download Icon of the View Root Cause detailssss table");
		Thread.sleep(5000);
//		waitForElement(arca_fcp_tableVRCA);
		Thread.sleep(1000);
	}

	// Clicks on the apply button of the VRCA table
	public void applyBtnVRCA() throws IOException, InterruptedException {
		// Waits for the Apply button
		WebElement fcp_tableVRCAapplyBtn = waitForElement(arca_fcp_tableVRCAapplyBtn);
//		fcp_tableVRCAapplyBtn.click();
		helper.safeClick(fcp_tableVRCAapplyBtn);
		System.out.println(
				"=> Clicked the Apply button of the View Root Cause details table which then updates the tree map with new selections");
		waitForElement(arca_fcp_treeMap);
		Thread.sleep(5000);
	}

	// Search and Select the record from the VRCA table
	public void searchAndSelectVRCA() throws IOException, InterruptedException {
		// Waits for the Search bar
		WebElement fcp_searchBarVRCA = waitForElement(arca_fcp_searchBarVRCA);

//		fcp_searchBarVRCA.click();
		helper.safeClick(fcp_searchBarVRCA);
		fcp_searchBarVRCA.clear();
		// Waits for the Customer ID from the first row of table
		WebElement fcp_searchRecordVRCA = waitForElement(arca_fcp_searchRecordVRCA);

		String searchRecord = fcp_searchRecordVRCA.getText().trim();

		fcp_searchBarVRCA.sendKeys(searchRecord);
		System.out.println("=> Searched the record of Customer ID: " + searchRecord);
		Thread.sleep(2000);
		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "//table//tr[td[2][normalize-space()='" + searchRecord
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		helper.safeClick(radioButton);
//		actions.moveToElement(radioButton).click().perform();
		System.out.println("=> Selected the searched record of the Customer ID: " + searchRecord);
		Thread.sleep(1000);
		// Clearing the Search Keyword
//		fcp_searchBarVRCA.click();
		helper.safeClick(fcp_searchBarVRCA);
		fcp_searchBarVRCA.sendKeys(Keys.CONTROL + "a");
		fcp_searchBarVRCA.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Loop through pages to check and store the customer id's
		while (true) {
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

			for (WebElement row : rows) {
				try {
					WebElement checkbox = row.findElement(By.xpath("td[1]//input[@type='checkbox']"));

					if (checkbox.isSelected()) {
						String customerIdText = row.findElement(By.xpath("td[2]")).getText().trim();
						if (!customerIdText.isEmpty()) {
							selectedCustomerIds.add(Double.parseDouble(customerIdText));
						}
					}
				} catch (Exception e) {
					System.out.println("=> Skipped row due to error: " + e.getMessage());
				}
			}

			// Check pagination
			WebElement nextButton = driver.findElement(arca_fcp_tableNextPaginationVRCA);
			String isDisabled = nextButton.getAttribute("disabled");
			if (isDisabled != null && (isDisabled.equals("true") || isDisabled.equals("disabled"))) {
				break;
			}
//			nextButton.click();
			helper.safeClick(nextButton);
			Thread.sleep(1000); // slight wait for pagination to load
		}

		System.out.println("=> The Selected Customer IDs: " + selectedCustomerIds);
		waitForElement(arca_fcp_tableVRCA);
		Thread.sleep(3000);
		// Waits for the Saved Customer Peer Selection record
		waitForElement(arca_fcp_tableVRCA);
	}

}
