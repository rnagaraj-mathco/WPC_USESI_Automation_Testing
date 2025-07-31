package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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

public class ARCA_CustomerSelectionPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public ARCA_CustomerSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(90)); // wait initialized once
		actions = new Actions(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Locators
	// xpath of the Customer Selection - Select One Customer for Simulation table
	By arca_cs_tableSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]");

	// xpath of the Customer Selection - SOC Pagination
	By arca_cs_tableNextPaginationSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/button[2]");

	// xpath of the Select Customer Button - SOC
	By arca_cs_selectCustomerBtnSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");

	// xpath of the Back button - SOC
	By arca_cs_backBtnSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");

	// xpath of the Search bar - SOC
	By arca_cs_searchBarSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the record to search - SOC
	By arca_cs_searchRecordSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// xpath of the download icon - SOC
	By arca_cs_downloadIconSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// xpath of the radio button of the SOC - Table first row
	By arca_cs_tableFirstRowRadioSOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// xpath of to extract the customer Id only if radio button is selected - SOC
	// Table first row
	By arca_cs_customerIdSOC = By.xpath(
			"//table[contains(@class,'MuiTable-root')]//tbody/tr[.//span[contains(@class,'Mui-checked')]]/td[2]");

	// xpath of the Tree Map
	By arca_fcp_treeMap = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]");

	// Select Root Cause Products for Simulation table - SRCP
	// xpath of the table - SRCP
	By arca_cs_tableSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]");

	// xpath of the Save and Analyze - SRCP
	By arca_cs_saveAndAnalyzeBtnSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/button[1]");

	// xpath of the Back button - SRCP
	By arca_cs_backBtnSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/button[1]");

	// xpath of the Reset button - SRCP
	By arca_cs_resetBtnSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/button[1]");

	// xpath of the Save and Analyze - SRCP - PopUp
	By arca_cs_PopUpSRCP = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]");

	// xpath of the Save and Analyze - SRCP - PopUp - Close Icon
	By arca_cs_PopUpCancelSRCP = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/span[1]/*[name()='svg'][1]/*[name()='path'][4]");

	// xpath of the Save and Analyze - SRCP - PopUp - Error Message
	By arca_cs_PopUpErrorSRCP = By
			.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/h4[1]");

	// xpath of the Select All row checkbox - SRCP
	By arca_cs_selectAllCheckboxSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/thead[1]/tr[1]/th[1]/div[1]/div[1]/div[1]");
// xpath for selecting the commodity value:01
	By arca_cs_selectCommodityValue01 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// xpath for selecting the commodity value:01
	By arca_cs_selectCommodityValue02 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// xpath of the Header checkbox -SRCP
	By arca_cs_headerCheckboxSRCP = By.xpath("//thead//input[@type='checkbox']");

	// xpath of the row checkbox - SRCP
	By arca_cs_rowCheckboxesSRCP = By.xpath("//tbody//input[@type='checkbox']");

	// xpath of the next button - SRCP
	By arca_cs_nextPaginationSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/button[2]");

	// xpath of the Commodity code - 01 - SRCP (2nd row)
	By arca_cs_commodityCodeSRCP_01 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[1]");

	// xpath of the Commodity code - 02 - SRCP (5th row)
	By arca_cs_commodityCodeSRCP_02 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[5]/td[1]");

	// xpath of the Commodity code - 03 - SRCP (7th row)
	By arca_cs_commodityCodeSRCP_03 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[7]/td[1]");

	// xpath of the Commodity code - 04 - SRCP (8th row)
	By arca_cs_commodityCodeSRCP_04 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[9]/td[1]");

	// xpath of the Commodity code - 05 - SRCP (11th row)
	By arca_cs_commodityCodeSRCP_05 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[11]/td[1]");

	// xpath of the Commodity code - 06 - SRCP (13th row)
	By arca_cs_commodityCodeSRCP_06 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[13]/td[1]");

	// xpath of the enter name input of save and proceed pop-up SRCP
	By arca_cs_nameInputSaveSRCP = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the Proceed button - Save and Analyze - SRCP
	By arca_cs_proceedBtn = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/button[1]/span[1]");

	// waits for the Go to Simulator button of Profit bridge
	By arca_pb_goToSimulator = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");

	// xpath of the download Icon - SRCP
	By arca_cs_downloadIconSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// xpath of the Search bar - SRCP
	By arca_cs_searchBarSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the searched record - SRCP
	By arca_cs_searchedRecordSRCP = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// Navigating to the Customer Selection Screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Customer Selection screen
		driver.get(ConfigReader.arca_customerSelection());
		// waits for the Single One Customer for Simulation table
		waitForElement(arca_cs_tableSOC);
		System.out.println("=> The Customer Selection screen is loaded with Select One Customer for Simulation table");
		Thread.sleep(5000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/CustomerSelections/CustomerSelectionScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Auto Root Cause Analysis - Customer Selection
		// - Customer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_customerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully!, Landed on Customer Selection Screen");

	}

	// Select One Customer for Simulation table
	// Clicks the Select Customer without selection
	public void selectCustomerBtnWithoutSelection() throws IOException, InterruptedException {
		// waits for the Select Customer button
		WebElement cs_selectCustomerBtnSOC = waitForElement(arca_cs_selectCustomerBtnSOC);
		cs_selectCustomerBtnSOC.click();
		System.out.println(
				"=> The Select Customer Button was clicked without selecting a record in Select One Customer for Simulation table, an error message popped");
		Thread.sleep(5000);
		waitForElement(arca_cs_tableSOC);
	}

	public String searchRecordSOC;

	// Search for keyword in the Select One Customer for Simulation
	public void selectForKeywordSOC() throws IOException, InterruptedException {
		// waits for the Search bar of SOC table
		WebElement cs_searchBarSOC = waitForElement(arca_cs_searchBarSOC);
		cs_searchBarSOC.click();
		cs_searchBarSOC.clear();
		// Waits for the First row table customer Id
		WebElement cs_searchRecordSOC = waitForElement(arca_cs_searchRecordSOC);
		this.searchRecordSOC = cs_searchRecordSOC.getText().trim();
		cs_searchBarSOC.sendKeys(searchRecordSOC);
		System.out.println(
				"=> Searched the Customer and Product Combination record of the Customer ID: " + searchRecordSOC);
		Thread.sleep(5000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/CustomerSelections/SearchKeywordSOC.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
		cs_searchBarSOC.click();
		cs_searchBarSOC.sendKeys(Keys.CONTROL + "a");
		cs_searchBarSOC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
	}

	// Clicks the download icon of the Select One Customer for Simulation
	public void downloadIconSOC() throws IOException, InterruptedException {
		// waits for the SOC - Download Icon
		WebElement cs_downloadIconSOC = waitForElement(arca_cs_downloadIconSOC);
		cs_downloadIconSOC.click();
		Thread.sleep(3000);
		System.out.println(
				"=> The download icon of Select One Customer for Simulation table is clicked and downloaded the table records as an excel file");
		waitForElement(arca_cs_tableSOC);
	}

	public String cs_customerId_SOC;

	// Selects the customer from the Select One Customer for Simulation
	public void selectCustomerSOC() throws IOException, InterruptedException {
		// waits for the SOC table first row radio button
		WebElement cs_tableFirstRowRadioSOC = waitForElement(arca_cs_tableFirstRowRadioSOC);
		cs_tableFirstRowRadioSOC.click();
		waitForElement(arca_cs_tableSOC);
		System.out.println("=> Selected the record of Select One Customer for Simulation table");
		Thread.sleep(2000);
		WebElement cs_customerIdSOC = waitForElement(arca_cs_customerIdSOC);
		this.cs_customerId_SOC = cs_customerIdSOC.getText().trim();
		System.out.println("=> The record of BILL To ID: " + cs_customerId_SOC + " is selected");

	}

	// Pagination action on the Select One Customer for Simulation
	public void paginationSOC() throws IOException, InterruptedException {
	}

	// Cicks on the Select customer button after selecting the record in Select One
	// Customer for Simulation table
	public void selectCustomerBtnWithSelection() throws IOException, InterruptedException {
		// waits for the Select Customer button
		WebElement cs_selectCustomerBtnSOC = waitForElement(arca_cs_selectCustomerBtnSOC);
		cs_selectCustomerBtnSOC.click();
		System.out.println(
				"=> The Select Customer Button of Select One Customer for Simulation table was clicked which then loads the Select Root Cause Products for Simulation table");
		Thread.sleep(3000);
		waitForElement(arca_cs_tableSRCP);

	}

	// Clicks the Back button of the Select One Customer for Simulation
	public void backBtnSOC() throws IOException, InterruptedException {
		// waits for the SOC - Back button
		WebElement cs_backBtnSOC = waitForElement(arca_cs_backBtnSOC);
		cs_backBtnSOC.click();
		System.out.println(
				"=> The Back button of the Select One Customer for Simulation table was clicked and redirected to the Filter Customer and Product Combinations screens");
		Thread.sleep(2000);
		waitForElement(arca_fcp_treeMap);
		// Redirecting to Customer Selection screen
		driver.get(ConfigReader.arca_customerSelection());
		System.out.println("=> Navigated back to the Customer Selection screen");
		Thread.sleep(3000);
		waitForElement(arca_cs_tableSOC);

	}

	// Interacts with Select One Customer for Simulation by zoom in and zoom out
	public void zoomOperationSOC() throws IOException, InterruptedException {
	}

	// Interacts with Select One Customer for Simulation column by column filters
	// icon
	public void columnFiterOperationSOC() throws IOException, InterruptedException {
	}

	// Search and Selects the record of the Select One Customer for Simulation
	public void searchAndSelectRecordSOC() throws IOException, InterruptedException {
		// waits for the Search bar of SOC table
		WebElement cs_searchBarSOC = waitForElement(arca_cs_searchBarSOC);
		cs_searchBarSOC.click();
		cs_searchBarSOC.clear();
		// Waits for the First row table customer Id
		WebElement cs_searchRecordSOC = waitForElement(arca_cs_searchRecordSOC);
		searchRecordSOC = cs_searchRecordSOC.getText().trim();
		cs_searchBarSOC.sendKeys(searchRecordSOC);
		System.out.println(
				"=> Searched the Customer and Product Combination record of the Customer ID: " + searchRecordSOC);
		Thread.sleep(5000);
		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "//table//tr[td[2][normalize-space()='" + searchRecordSOC
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		actions.moveToElement(radioButton).click().perform();
		System.out.println("=> Selected the searched record of the Customer ID: " + searchRecordSOC);
		Thread.sleep(3000);
		// Clearing the Search Keyword
		// Clearing the Search Keyword
		cs_searchBarSOC.click();
		cs_searchBarSOC.sendKeys(Keys.CONTROL + "a");
		cs_searchBarSOC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		// Waits for the Saved Scenario Simulation Table
		waitForElement(arca_cs_tableSOC);
	}

	// Save and Analyze button without selection
	public void saveAndAnalyzeBtnWithoutSelectionSRCP() throws IOException, InterruptedException {
		// waits for the Save and Analyze button - SRCP
		WebElement cs_saveAndAnalyzeBtnSRCP = waitForElement(arca_cs_saveAndAnalyzeBtnSRCP);
		cs_saveAndAnalyzeBtnSRCP.click();

		// waits for the Save and Analyze button - SRCP - Error Message
		waitForElement(arca_cs_PopUpErrorSRCP);
		// waits for the Save and Analyze button - SRCP - PopUp - Cancel
		WebElement cs_PopUpCancelSRCP = waitForElement(arca_cs_PopUpCancelSRCP);
		cs_PopUpCancelSRCP.click();
		Thread.sleep(2000);
	}

	// Select Root Cause Product for Simulation table
	public void saveAndAnalyzeBtnSRCP() throws IOException, InterruptedException {
		// waits for the Save and Analyze button - SRCP
		WebElement cs_saveAndAnalyzeBtnSRCP = waitForElement(arca_cs_saveAndAnalyzeBtnSRCP);
		cs_saveAndAnalyzeBtnSRCP.click();
		// waits for the name input field
		WebElement cs_nameInputSaveSRCP = waitForElement(arca_cs_nameInputSaveSRCP);
		cs_nameInputSaveSRCP.sendKeys(cs_customerId_SOC + "_CommodityCodeCombination");
		// waits for the Save and Analyze button - SRCP - Error Message
//		waitForElement(arca_cs_PopUpErrorSRCP);
//		// waits for the Save and Analyze button - SRCP - PopUp - Cancel
//		WebElement cs_PopUpCancelSRCP = waitForElement(arca_cs_PopUpCancelSRCP);
//		cs_PopUpCancelSRCP.click();
		// waits for the Proceed button
		WebElement cs_proceedBtn = waitForElement(arca_cs_proceedBtn);
		cs_proceedBtn.click();
		waitForElement(arca_pb_goToSimulator);
		Thread.sleep(2000);
	}

	// Click on the Back button of SRCP
	public void backBtnSRCP() throws IOException, InterruptedException {
		// waits for the SRCP - Back button
		WebElement cs_backBtnSRCP = waitForElement(arca_cs_backBtnSRCP);
		cs_backBtnSRCP.click();
		// waits for the SOC Table
		waitForElement(arca_cs_tableSOC);
		selectCustomerSOC();
		Thread.sleep(3000);
		selectCustomerBtnWithSelection();
		Thread.sleep(3000);
		waitForElement(arca_cs_tableSRCP);
	}

	// Clicks the Select All checkbox in the SRCP table header
	public void selectAllCheckboxSRCP() throws IOException, InterruptedException {
		// waits for the SRCP - Select All Checkbox
		WebElement cs_selectAllCheckboxSRCP = waitForElement(arca_cs_selectAllCheckboxSRCP);
		cs_selectAllCheckboxSRCP.click();
		waitForElement(arca_cs_tableSRCP);
		Thread.sleep(1000);

	}

	// Clicks the Select All checkbox in the SRCP table header
	public void resetBtnSRCP() throws IOException, InterruptedException {
		// waits for the SRCP - Select All Checkbox
		WebElement cs_resetBtnSRCP = waitForElement(arca_cs_resetBtnSRCP);
		cs_resetBtnSRCP.click();
		waitForElement(arca_cs_tableSRCP);
		Thread.sleep(1000);

	}

	// Selects the commodity code from SRCP table
	public void selectCommoditySRCP() throws IOException, InterruptedException {
		// waits for the table
		waitForElement(arca_cs_tableSRCP);
		List<String> selectedCommodityCode = new ArrayList<>();

		// waits for the commodity code and clicks it
		WebElement cs_commodityCodeSRCP_01 = waitForElement(arca_cs_commodityCodeSRCP_01);
		String commodityCodeSRCP_01 = cs_commodityCodeSRCP_01.getText().trim();
		selectedCommodityCode.add(commodityCodeSRCP_01);
		cs_commodityCodeSRCP_01.click();
		Thread.sleep(1000);
		WebElement cs_commodityCodeSRCP_02 = waitForElement(arca_cs_commodityCodeSRCP_02);
		String commodityCodeSRCP_02 = cs_commodityCodeSRCP_02.getText().trim();
		selectedCommodityCode.add(commodityCodeSRCP_02);
		cs_commodityCodeSRCP_02.click();
		Thread.sleep(1000);
		WebElement cs_commodityCodeSRCP_03 = waitForElement(arca_cs_commodityCodeSRCP_03);
		String commodityCodeSRCP_03 = cs_commodityCodeSRCP_03.getText().trim();
		selectedCommodityCode.add(commodityCodeSRCP_03);
		cs_commodityCodeSRCP_03.click();
		Thread.sleep(1000);
		WebElement cs_commodityCodeSRCP_04 = waitForElement(arca_cs_commodityCodeSRCP_04);
		String commodityCodeSRCP_04 = cs_commodityCodeSRCP_04.getText().trim();
		selectedCommodityCode.add(commodityCodeSRCP_04);
		cs_commodityCodeSRCP_04.click();
		Thread.sleep(1000);
		WebElement cs_commodityCodeSRCP_05 = waitForElement(arca_cs_commodityCodeSRCP_05);
		String commodityCodeSRCP_05 = cs_commodityCodeSRCP_05.getText().trim();
		selectedCommodityCode.add(commodityCodeSRCP_05);
		cs_commodityCodeSRCP_05.click();
		Thread.sleep(1000);
		WebElement cs_commodityCodeSRCP_06 = waitForElement(arca_cs_commodityCodeSRCP_06);
		String commodityCodeSRCP_06 = cs_commodityCodeSRCP_06.getText().trim();
		selectedCommodityCode.add(commodityCodeSRCP_06);
		cs_commodityCodeSRCP_06.click();
		Thread.sleep(1000);
//		System.out.println("=> The Commodity code selected from the Select Root Cause Products for Simulation is: "
//				+ selectedCommodityCode);

	}

	// Uncheck the commodity code
	public void deSelectCommoditySRCP() throws IOException, InterruptedException {
		// waits for the table
		waitForElement(arca_cs_tableSRCP);
		List<String> deSelectedCommodityCode = new ArrayList<>();

		WebElement cs_commodityCodeSRCP_02 = waitForElement(arca_cs_commodityCodeSRCP_02);
		String commodityCodeSRCP_02 = cs_commodityCodeSRCP_02.getText().trim();
		deSelectedCommodityCode.add(commodityCodeSRCP_02);
		cs_commodityCodeSRCP_02.click();
		Thread.sleep(1000);
		WebElement cs_commodityCodeSRCP_03 = waitForElement(arca_cs_commodityCodeSRCP_03);
		String commodityCodeSRCP_03 = cs_commodityCodeSRCP_03.getText().trim();
		deSelectedCommodityCode.add(commodityCodeSRCP_03);
		cs_commodityCodeSRCP_03.click();
		Thread.sleep(1000);

	}

	// Clicks on download icon of SRCP
	public void downloadIconSRCP() throws IOException, InterruptedException {
		// waits for the table
		waitForElement(arca_cs_tableSRCP);
		// waits for the download icon
		WebElement cs_downloadIconSRCP = waitForElement(arca_cs_downloadIconSRCP);
		cs_downloadIconSRCP.click();
		try {
			waitForElement(arca_cs_tableSRCP);
		} catch (Exception e) {
			waitForElement(arca_cs_tableSRCP);
		}

	}

	// Search and Select the commodity code
	public void searchAndSelectSRCP() throws IOException, InterruptedException {
		// waits for the table
		waitForElement(arca_cs_tableSRCP);
		// waits for the search bar of the SRCP
		WebElement cs_searchBarSRCP = waitForElement(arca_cs_searchBarSRCP);
		cs_searchBarSRCP.click();
		cs_searchBarSRCP.clear();
		// waits for the search
		WebElement cs_searchedRecordSRCP = waitForElement(arca_cs_searchedRecordSRCP);
		String searchedRecordSRCP = cs_searchedRecordSRCP.getText().trim();
		cs_searchBarSRCP.sendKeys(searchedRecordSRCP);
		String checkboxXPath01 = "//table//tr[td[2][normalize-space()='" + searchedRecordSRCP
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		Thread.sleep(1000);
		WebElement radioButton01 = waitForElement(By.xpath(checkboxXPath01));
		actions.moveToElement(radioButton01).click().perform();
		Thread.sleep(1000);
		cs_searchBarSRCP.click();
		cs_searchBarSRCP.sendKeys(Keys.CONTROL + "a");
		cs_searchBarSRCP.sendKeys(Keys.BACK_SPACE);

	}

	// Search and DeSelect the commodity code
	public void searchAndDeSelectSRCP() throws IOException, InterruptedException {
		// waits for the table
		waitForElement(arca_cs_tableSRCP);
		// waits for the search bar of the SRCP
		WebElement cs_searchBarSRCP = waitForElement(arca_cs_searchBarSRCP);
		cs_searchBarSRCP.click();
		cs_searchBarSRCP.clear();
		// waits for the search
		WebElement cs_searchedRecordSRCP = waitForElement(arca_cs_searchedRecordSRCP);
		String searchedRecordSRCP = cs_searchedRecordSRCP.getText().trim();
		cs_searchBarSRCP.sendKeys(searchedRecordSRCP);
		String checkboxXPath01 = "//table//tr[td[2][normalize-space()='" + searchedRecordSRCP
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		Thread.sleep(1000);
		WebElement radioButton01 = waitForElement(By.xpath(checkboxXPath01));
		actions.moveToElement(radioButton01).click().perform();
		Thread.sleep(1000);
		cs_searchBarSRCP.click();
		cs_searchBarSRCP.sendKeys(Keys.CONTROL + "a");
		cs_searchBarSRCP.sendKeys(Keys.BACK_SPACE);

	}

}
