package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;
import utils.ElementHelper;

public class CPA_PeerSelectionPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	ElementHelper helper;

	// gets driver status
	public CPA_PeerSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(90)); // wait initialized once
		actions = new Actions(driver);
		this.helper = new ElementHelper(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Peer Selection - 01
	// Select Target Customer for Peer Matching table - STC
	// Entire Table
	By cpa_ps1_tableSTCTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]");
	// First row record
	By cpa_ps1_tableFirstRowSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");
	// First row - Extract BILL To ID (2nd column)
	By cpa_ps1_firstRowBillToIdSTC = By.xpath("//table//tr[1]/td[2][normalize-space()]");

	// Search Keyword - STC
	By cpa_ps1_SearchBarSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// STC Table First Row - Customer ID
	By cpa_ps1_firstRowSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");
	// Select Customer Button
	By cpa_ps1_selectCustomerBtnSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");
	// Back button
	By cpa_ps1_BackBtnSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");
	// Geographical Map
	By cpa_bc_geographicalMap = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div");
	// Download icon
	By cpa_ps1_downloadIconSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// SearchRecord
	By cpa_ps1_searchedRecordSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// SearchRecord - Extract BILL To ID -105097 -- Need to modify to get the first
	// row customer ID
	By cpa_ps1_searchRecordBillToIdSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[3]/td[2]");

	// Peer Selection -02 -Comparative Peer Group Selection table (CPGS)
	// Comparative Peer Group Selection table - First row BILL To ID
	By cpa_ps2_firstRowBillToIdCPGS = By.xpath("//table//tr[1]/td[2][normalize-space()]");

	// Comparative Peer Group Selection table
	By cpa_ps2_comparativePeerGroupSelectionTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]");
	// Back button
	By cpa_ps2_backBtnCPGS = By.xpath("//button[.//span[text()='Back'] and contains(@class, 'MuiButton-root')]");

	// Set Peer Matching Criteria - SPMC
	By cpa_ps2_SPMCBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]");

	// Set Peer Matching Criteria - Select Model Dropdown click
	By cpa_ps2_selectModelDropdownSPMC = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// Set Peer Matching Criteria - Select Model Dropdown -
	// Selecting Options:Existing Model
	By cpa_ps2_selectModelDropdownOptionsSPMC = By
			.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[1]/div[1]/div[1]/span[1]");

	// Set Peer Matching Criteria - Set Threshold value -
	// Setting value to 40
	By cpa_ps2_setThresholdValueSPMC = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/input[1]");

	// Set Peer Matching Criteria - Set Threshold value - Appy btn
	By cpa_ps2_applyBtnSPMC = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/button[1]/span[1]");

	// Set Peer Matching Criteria
	// Set Threshold value locator after entering the value
	By cpa_ps2_setThresholdValueAfterValueSPMC = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/input[1]");
	// Set Peer Matching Criteria
	// Extracts all the values from the Similarity score column
	By cpa_ps2_similarityScoreColumnValuesCPGS = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[6]/div/div/div/div[3]/table/tbody/tr[1]/td[4]");
	// Paginations - next button
	By cpa_ps2_nextButtonCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/button[2]");

	// Paginations - Previous button
	By cpa_ps2_prevButtonCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/button[1]");

	// Set Peer Matching Criteria
	// Extracting the model type from the table's 2nd row
	By cpa_ps2_typeOfModelCPGS = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[6]/div/div/div/div[3]/table/tbody/tr[2]/td[17]");

	// Select Peers Dropdown - SPD
	By cpa_ps2_selectPeersDropdown = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]");

	// Select Peers Dropdown SPD - Options - Top 5
	By cpa_ps2_optionsSPD = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[1]/div[1]");

	// Search Keyword
	By cpa_ps2_searchBarCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// Download icons xpath
	By cpa_ps2_downloadIconCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// Compare Peers Button
	By cpa_ps2_comparePeersBtnCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/div[1]/button[1]/span[1]");

	// Select all row
	By cpa_ps2_selectAllRowCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/thead[1]/tr[1]/th[1]");

	// Reset Button
	By cpa_ps2_resetBtnCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/button[1]/span[1]");

	// Compare Peers Button - Name input field
	By cpa_ps2_peerGroupNameCPGS = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");

	// Compare Peers Button - Save and Proceed button
	By cpa_ps2_saveAndProceedBtnCPGS = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/button[1]/span[1]");

	// Peer Selection in table - 91331
	By cpa_ps2_selectPeers01CPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[15]/td[1]");

	// Peer Selection in table - 66810
	By cpa_ps2_selectPeers02CPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[3]/td[1]");

	// Peer Selection in table - 176174
	By cpa_ps2_selectPeers03CPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[7]/td[1]");

	// Peer Selection in table - 192021
	By cpa_ps2_selectPeers04CPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[10]/td[1]");

	// Peer Selection in table - 149734
	By cpa_ps2_selectPeers05CPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[9]/td[1]");

	// Peer Search and Select in table -
	By cpa_ps2_searchAndSelectPeers01CPGS = By.xpath("//table//tr[11]/td[2][normalize-space()]");

	// Peer Search and Select in table -
	By cpa_ps2_searchAndSelectPeers02CPGS = By.xpath("//table//tr[13]/td[2][normalize-space()]");

	// Peer Search and De-Select in table - 192021
	By cpa_ps2_searchAndDeselectPeer01CPGS = By.xpath("//table//tr[11]/td[2][normalize-space()]");

	// Set Peer Matching - View - Cancel (X)
	By cpa_ps2_CancelBtnSPMC = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]");

	// Pagination - Clicks on the pagination
	By cpa_ps2_paginationCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]");

	// Pagination - Clicks Option - 45
	By cpa_ps2_paginationValue45 = By.xpath("//li[@role='option' and text()='45']");

	// Pagination - Clicks option - 15
	By cpa_ps2_paginationValue15 = By.xpath("//li[@role='option' and text()='15']");
	// Create Scenario - Slider Component
	By cpa_csc_sliderComponent = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]");

	By cpa_csc_scenarioSlider = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]");

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

	// Loading the Peer Selection Screen

	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Peer Selection Screen
		driver.get(ConfigReader.cpa_peerSelection());
		// Function waits till the Entire screen loaded
		try {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		} catch (Exception e) {
			waitForElement(cpa_ps1_tableSTCTable);
		}
		waitForElement(cpa_ps1_tableSTCTable);
//		System.out.println(
//				"--- Loaded the Peer Selection -01 Screen where Target customer will be selected for Peer Matching");

		// Take screenshot after the page is fully ready
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PeerSelection_01_Screen.png");
//		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();
		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError("=> Unexpected Redirection and landed on wrong screen " + currentUrl);
		}

	}
	// Select Target Customer for Peer Matching table
	// Search keyword of Select Target Customer for Peer Matching table

	public void searchForKeyword_STC() throws IOException, InterruptedException {
		WebElement ps1_SearchBarSTC = waitForElement(cpa_ps1_SearchBarSTC);
//		ps1_SearchBarSTC.click();
		helper.safeClick(ps1_SearchBarSTC);
		ps1_SearchBarSTC.clear();
		// waits for the STC - Table first row - Customer ID
		WebElement ps1_firstRowSTC = waitForElement(cpa_ps1_firstRowSTC);
		String firstRowSTC = ps1_firstRowSTC.getText().trim();
		ps1_SearchBarSTC.sendKeys(firstRowSTC);
//		System.out.println("--- Searched: Keyword search was done");
		Thread.sleep(1000);
		// Take screenshot after the keyword is searched
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/ps1_searchBarSTC.png");
//		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
//		ps1_SearchBarSTC.click();
		helper.safeClick(ps1_SearchBarSTC);
		ps1_SearchBarSTC.sendKeys(Keys.CONTROL + "a");
		ps1_SearchBarSTC.sendKeys(Keys.BACK_SPACE);
		waitForElement(cpa_ps1_SearchBarSTC);
//		System.out.println("--- Searched: Keyword search has been cleared from the search field");

	}

	// Select Target Customer Button with selection
	public void selectCustomerBtnWithSelection() throws IOException, InterruptedException {
		// Ensure overlays are gone first (if any)
		helper.waitForOverlaysToDisappear();
		// waits for the first row of the table and clicks as the button gets activated
		WebElement ps1_tableFirstRowSTC = waitForElement(cpa_ps1_tableFirstRowSTC);
		// waits for the BILL To ID of first row
		WebElement ps1_firstRowBillToIdSTC = waitForElement(cpa_ps1_firstRowBillToIdSTC);

		// waits for the Select Customer button to get load
		WebElement ps1_selectCustomerBtnSTC = waitForElement(cpa_ps1_selectCustomerBtnSTC);
		// Extracts the BILL To ID of the first row
		String ps1_billToId = ps1_firstRowBillToIdSTC.getText().trim();
//		System.out.println(
//				"--- The Selected Target Customer BILL To ID in Select Target Customer table is:" + ps1_billToId);
		// Clicks the First row record
		ps1_tableFirstRowSTC.click();

//		System.out.println("--- Clicked: Select Target Customer for Peer Matching Table first row");
		Thread.sleep(2000);

		// Clicks the Select Customer button
//		ps1_selectCustomerBtnSTC.click();
		helper.safeClick(ps1_selectCustomerBtnSTC);
//		System.out.println("--- Clicked: Select Customer Button");

		// Waits till the Comparative Peer Group Selection table gets loaded in the Peer
		// Selection - 02
		try {
			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		} catch (Exception e) {
			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		}

		// Take screenshot after the page is fully ready
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/SelectCustomerbtnWithSelection.png");
//		FileHandler.copy(sourcefile, screenshotPath);

		// PS2 -Comparative Peer Group table of Peer Selection-02 - Table First Row
		WebElement ps2_firstRowBillToIdCPGS = waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		// Extracts the BILL To ID from the first row
		String ps2_billToId = ps2_firstRowBillToIdCPGS.getText().trim();
		System.out.println("=> The Selected Target Customer BILL To ID in Comparative Peer Group Selection table is:"
				+ ps2_billToId);

		// Comparing both the BILL To ID's
		if (!ps1_billToId.equals(ps2_billToId)) {
			throw new AssertionError("=> There is BILL To ID mismatch: Select Target Customer table = " + ps1_billToId
					+ ", Comparative Peer Group table = " + ps2_billToId);
		}
		System.out.println(
				" => The BILL To ID's matches and ensures the same record passed to the Peer Selection -02 screen");

		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();
		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError("=> Unexpected Redirection and landed on wrong screen " + currentUrl);
		}

	}

	// Clicks the Select Customer button without selection
	public void selectCustomerBtnWithOutSelection() throws IOException, InterruptedException {
		// Ensure overlays are gone first (if any)
		helper.waitForOverlaysToDisappear();
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		// waits for the Select Customer button to get load
		WebElement ps1_selectCustomerBtnSTC = waitForElement(cpa_ps1_selectCustomerBtnSTC);
		// Clicks the Create Sensitivity Scenario button
//		ps1_selectCustomerBtnSTC.click();
		helper.safeClick(ps1_selectCustomerBtnSTC);
//		System.out.println("--- Clicked: Select Customer Button without selecting a record");
		Thread.sleep(2000);
		// Take screenshot after the page is fully ready
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/SelectCustomerbtnWithOutSelection.png");
//		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Select Target Customer for Peer Matching table Record Download
	public void tableRecordsDownload() throws IOException, InterruptedException {
		// Ensure overlays are gone first (if any)
		helper.waitForOverlaysToDisappear();
		try {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		} catch (Exception e) {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		}
		waitForElement(cpa_ps1_tableSTCTable);
		// Download button present in the table
		WebElement ps1_downloadIconSTC = waitForElement(cpa_ps1_downloadIconSTC);
//		ps1_downloadIconSTC.click();
		helper.safeClick(ps1_downloadIconSTC);
//		System.out.println("=> The Download Button of the Select Target Customer for Peer Matching table was clicked");
		Thread.sleep(1000);
		try {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		} catch (Exception e) {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		}
	}

	// Clicks the Back button of Peer Selection - 02 and get redirected to
	// Peer Selection - 01 screen
	public void redirectionToPeerSelection_01_Screen() throws IOException, InterruptedException {
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		WebElement ps2_backBtnCPGS = waitForElement(cpa_ps2_backBtnCPGS);
//		ps2_backBtnCPGS.click();
		helper.safeClick(ps2_backBtnCPGS);
		System.out.println(
				"=> The Back Button of Peer Selection - 02 was clicked and redirected to the Peer Selection - 01");
		// Waits till the table gets loaded
		try {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		} catch (Exception e) {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		}
	}

	// Clicks the Back button of Peer Selection - 01 and get redirected to
	// Branch/Customer Page
	public void redirectionToBranchCustomerScreen() throws IOException, InterruptedException {
		// Back button
		WebElement ps1_BackBtnSTC = waitForElement(cpa_ps1_BackBtnSTC);
//		ps1_BackBtnSTC.click();
		helper.safeClick(ps1_BackBtnSTC);
		System.out.println(
				"=> The Back Button of the Peer Selection - 01 was clickd and redirected to the Branch/Customer Selection Screen");
		try {
			waitForElement(cpa_bc_geographicalMap);
		} catch (Exception e) {
			waitForElement(cpa_bc_geographicalMap);
		}

		// redirect to the peer selection screen
		driver.get(ConfigReader.cpa_peerSelection());
		// Function waits till the Entire screen loaded
		try {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		} catch (Exception e) {
			waitForElement(cpa_ps1_tableSTCTable);
			waitForElement(cpa_ps1_firstRowBillToIdSTC);
		}
		waitForElement(cpa_ps1_tableSTCTable);

	}

	// Peer Selection 01 Target Customer Selection - Customer Selection by Searching
	// and Selecting the the record
	public void searchForRecord() throws IOException, InterruptedException {
		WebElement ps1_SearchBarSTC = waitForElement(cpa_ps1_SearchBarSTC);
//		ps1_SearchBarSTC.click();
		helper.safeClick(ps1_SearchBarSTC);
		ps1_SearchBarSTC.clear();
		// waits for the STC - Table first row - Customer ID
		WebElement ps1_firstRowSTC = waitForElement(cpa_ps1_firstRowSTC);
		String firstRowSTC = ps1_firstRowSTC.getText().trim();
		ps1_SearchBarSTC.sendKeys(firstRowSTC);
//		System.out.println("--- Searched: Keyword search was done : " + firstRowSTC);
		Thread.sleep(2000);
		// Click the radio button corresponding to the searched record
		// Assumption: table row where td[2] = Customer ID, and td[1] has radio button
		String radioXPath = "//table//tr[td[2][normalize-space()='" + firstRowSTC
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";

		// table//tr[td[2][normalize-space()='135763']]//td[1]//span[contains(@class,'MuiButtonBase-root')]

		WebElement radioButton = waitForElement(By.xpath(radioXPath));
		actions.moveToElement(radioButton).click().perform();

//		System.out.println("--- Selected the Searched Target Customer Record: Customer ID 105097");
		// Take screenshot after the keyword is searched
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS1_SearchSelectRecord_SelectTargetCustomer.png");
//		FileHandler.copy(sourcefile, screenshotPath);
		// Clearing the Search Keyword
//		ps1_SearchBarSTC.click();
		helper.safeClick(ps1_SearchBarSTC);
		ps1_SearchBarSTC.sendKeys(Keys.CONTROL + "a");
		ps1_SearchBarSTC.sendKeys(Keys.BACK_SPACE);
		try {
			waitForElement(cpa_ps1_firstRowSTC);
		} catch (Exception e) {
			waitForElement(cpa_ps1_firstRowSTC);
		}
//		System.out.println("--- Searched record has been cleared from the search field");

		System.out.println(
				"=> The Selected Target Customer BILL To ID in Select Target Customer table is:" + firstRowSTC);

		// waits for the Select Customer button to get load
		WebElement PS1_SelectCustomerBtn = waitForElement(cpa_ps1_selectCustomerBtnSTC);
		// Clicks the Select Customer button with selection
//		PS1_SelectCustomerBtn.click();
		helper.safeClick(PS1_SelectCustomerBtn);
//		System.out.println("--- Clicked: Select Customer Button");
		// Waits till the Comparative Peer Group Selection table gets loaded in the Peer
		// Selection - 02
		try {
			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		} catch (Exception e) {
			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		}
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);

		// PS2 -Comparative Peer Group table of Peer Selection-02 - Table First Row
		WebElement ps2_firstRowBillToIdCPGS = waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		// Extracts the BILL To ID from the first row
		String ps2_billToId_record = ps2_firstRowBillToIdCPGS.getText().trim();
		System.out.println("=> The Selected Target Customer BILL To ID in Comparative Peer Group Selection table is:"
				+ ps2_billToId_record);

		// Comparing both the BILL To ID's
		if (!firstRowSTC.equals(ps2_billToId_record)) {
			throw new AssertionError("=> There is a BILL To ID mismatch: Select Target Customer table = " + firstRowSTC
					+ ", Comparative Peer Group table = " + ps2_billToId_record);
		}
		System.out.println(
				" => The BILL To ID's matches and ensures the same record passed to the Peer Selection -02 screen");

		// Clicking Back button of Peer Selection - 02 for redirection to Peer Selection
		// - 01
//		WebElement ps2_backBtnCPGS = waitForElement(cpa_ps2_backBtnCPGS);
		Thread.sleep(3000);
//		ps2_backBtnCPGS.click();
//		helper.safeClick(ps2_backBtnCPGS);
////		System.out.println(
////				"--- Clicked - Back Button of Peer Selection - 02 and got redirected to the Peer Selection - 01");
//		// Waits till the table gets loaded
//		waitForElement(cpa_ps1_tableSTCTable);
//		try {
//			waitForElement(cpa_ps1_tableSTCTable);
//			waitForElement(cpa_ps1_firstRowBillToIdSTC);
//		} catch (Exception e) {
//			waitForElement(cpa_ps1_tableSTCTable);
//			waitForElement(cpa_ps1_firstRowBillToIdSTC);
//		}

		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();
		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError("=> Unexpected Redirection and landed on wrong screen" + currentUrl);
		}

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Set Peer Matching Criteria Button

	public void setPeerMatchingCriteria() throws IOException, InterruptedException {
		try {
			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		} catch (Exception e) {
			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		}
		// Set Peer Matching Criteria
		WebElement ps2_SPMCBtn = waitForElement(cpa_ps2_SPMCBtn);
//		ps2_SPMCBtn.click();
		helper.safeClick(ps2_SPMCBtn);
		// Pop-Up
		// Select Model - Dropdown
		WebElement ps2_selectModelDropdownSPMC = waitForElement(cpa_ps2_selectModelDropdownSPMC);
//		ps2_selectModelDropdownSPMC.click();
		helper.safeClick(ps2_selectModelDropdownSPMC);
		Thread.sleep(3000);
//		System.out.println("--- Clicked: Select Model Dropdown");

		// Select Model - Dropdown - Options
		WebElement ps2_selectModelDropdownOptionsSPMC = waitForElement(cpa_ps2_selectModelDropdownOptionsSPMC);
		String selectedModel = ps2_selectModelDropdownOptionsSPMC.getText().trim();
//		ps2_selectModelDropdownOptionsSPMC.click();
		helper.safeClick(ps2_selectModelDropdownOptionsSPMC);
		Thread.sleep(3000);
//		System.out.println("--- Clicked: Select Model Dropdown Options: " + selectedModel);
		// Maps dropdown model options to the model options present in the table
		String expectedModelText;
		if (selectedModel.equalsIgnoreCase("Existing Model")) {
			expectedModelText = "Existing Similarity Model";
		} else if (selectedModel.equalsIgnoreCase("Enhanced Model")) {
			expectedModelText = "Enhanced Similarity Model";
		} else {
			throw new IllegalArgumentException("=> Unknown model selected: " + selectedModel);
		}
		// Set Threshold Value
		WebElement ps2_setThresholdValueSPMC = waitForElement(cpa_ps2_setThresholdValueSPMC);
//		ps2_setThresholdValueSPMC.click();
		helper.safeClick(ps2_setThresholdValueSPMC);
		Thread.sleep(2000);
		ps2_setThresholdValueSPMC.sendKeys(Keys.CONTROL + "a");
		ps2_setThresholdValueSPMC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Enter the Threshold value as 40
		ps2_setThresholdValueSPMC.sendKeys("40");

		// Take screenshot
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS2_SetPeerMatchingCriteriaBtn.png");
//		FileHandler.copy(sourcefile, screenshotPath);

		// Validating the Entered Threshold Value and Similarity Score in Comparative -
		// Peer Group Selection table
		// Store's the entered Threshold value
		WebElement ps2_setThresholdValueAfterValueSPMC = waitForElement(cpa_ps2_setThresholdValueAfterValueSPMC);
		// As we are comparing the numerical so we use Double datatype
		Double enteredThresholdValue = Double
				.parseDouble((ps2_setThresholdValueAfterValueSPMC).getAttribute("value").trim());
		System.out.println("=> The Entered Threshold value is:" + enteredThresholdValue);

		// Apply button
		WebElement ps2_applyBtnSPMC = waitForElement(cpa_ps2_applyBtnSPMC);
//		ps2_applyBtnSPMC.click();
		helper.safeClick(ps2_applyBtnSPMC);
//		System.out.println("--- Clicked: Apply button which then updates the table");
		Thread.sleep(1000);

		// Waits for the Comparative Peer Group Selection table

		try {
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);

		} catch (Exception e) {
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);

		}
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		// This will wait till the success toaster message gets disappear
		helper.waitForOverlaysToDisappear();
		// Changing the pagination value
		WebElement ps2_paginationCPGS = waitForElement(cpa_ps2_paginationCPGS);
//		ps2_paginationCPGS.click();
		helper.safeClick(ps2_paginationCPGS);

		// waits for the pagination value - 45
		WebElement ps2_paginationValue45 = waitForElement(cpa_ps2_paginationValue45);
		helper.safeClick(ps2_paginationValue45);
//		actions.moveToElement(ps2_paginationValue45, 0, 0).click().perform();
//		 Validates the similarity score and the model in the table

		List<Double> scoreValues = new ArrayList<>();
		boolean mismatchFound = false;

		while (true) {
			List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

			for (WebElement row : rows) {
				try {
					// Similarity score
					String scoreText = row.findElement(By.xpath("td[4]")).getText().trim();
					if (!scoreText.isEmpty()) {
						scoreValues.add(Double.parseDouble(scoreText));
					}

					// Model type
					String modelText = row.findElement(By.xpath("td[17]")).getText().trim();
					if (!modelText.equalsIgnoreCase(expectedModelText)) {
						System.out.println("=> There is a Model mismatch - Expected: " + expectedModelText + ", Found: "
								+ modelText);
						mismatchFound = true;
					}

				} catch (Exception e) {
					System.out.println("=>  Skipped row due to error: " + e.getMessage());
				}
			}

			WebElement nextButton = driver.findElement(cpa_ps2_nextButtonCPGS);
			String isDisabled = nextButton.getAttribute("disabled");
			if (isDisabled != null && (isDisabled.equals("true") || isDisabled.equals("disabled"))) {
				break;
			}
//			nextButton.click();
			helper.safeClick(nextButton);
			Thread.sleep(2000);
		}
		// Waits for the Type of Model column from the table row
		WebElement ps2_typeOfModelCPGS = waitForElement(cpa_ps2_typeOfModelCPGS);

		actions.moveToElement(ps2_typeOfModelCPGS).perform();

		// Similarity score assertion
		double minValue = scoreValues.stream().min(Double::compareTo).orElse(Double.MAX_VALUE);
		if (enteredThresholdValue > minValue) {
			throw new AssertionError("=> Then entered Threshold value is " + enteredThresholdValue
					+ " which is greater than minimum score: " + minValue);
		} else {
			System.out.println("=> The entered Threshold value is : " + enteredThresholdValue
					+ " which is lesser than than the minimum value (" + minValue + ") of the similarity score column");
		}

		// Model assertion
		if (mismatchFound) {
			throw new AssertionError("=> Some rows did not match with selected model: " + expectedModelText);
		} else {
			System.out.println("=> All the rows of table matched with the selected model: " + expectedModelText);
		}
		// This navigate to back to the first page of table by clicking previous button
		navigateToFirstPageOfTable();
		WebElement ps2_firstRowBillToIdCPGS = waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		actions.moveToElement(ps2_firstRowBillToIdCPGS).perform();
		Thread.sleep(5000);

	}

	public void navigateToFirstPageOfTable() throws InterruptedException {

		while (true) {
			WebElement prevButton = waitForElement(cpa_ps2_prevButtonCPGS);
			String isDisabled = prevButton.getAttribute("disabled");

			if (isDisabled != null && (isDisabled.equals("true") || isDisabled.equals("disabled"))) {
				System.out.println("=> Reached the first page of the table.");
				break;
			}

			actions.moveToElement(prevButton).click().perform();
			Thread.sleep(2000); // Wait for the table to update
		}
		// clicking the pagination
		WebElement ps2_paginationCPGS = waitForElement(cpa_ps2_paginationCPGS);
//		ps2_paginationCPGS.click();
		helper.safeClick(ps2_paginationCPGS);
		// selecting the pagination value to 15
		WebElement ps2_paginationValue15 = waitForElement(cpa_ps2_paginationValue15);
		helper.safeClick(ps2_paginationValue15);
//		actions.moveToElement(ps2_paginationValue15).click().perform();
		try {
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		} catch (Exception e) {
			waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		}

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Select Peers Dropdown
//	public void selectPeersDropdown() throws IOException, InterruptedException {
//		// Select Peers Dropdown
//		WebElement PS2_SelectPeersDropdown = waitForElement(cpa_ps2_selectPeersDropdown);
//		PS2_SelectPeersDropdown.click();
//		System.out.println("--- Clicked: Select Peers Dropdown");
//
//		// Select Peers Dropdown - Options - Top 10
//		WebElement PS2_SelectPeersDropdown_Options = waitForElement(cpa_ps2_optionsSPD);
//		String dropDownOptionValue = PS2_SelectPeersDropdown_Options.getText().trim();
//		PS2_SelectPeersDropdown_Options.click();
//		System.out.println("--- Clicked: Select Peers Dropdown Option: Top 10");
//		// Storing the option value for validation
////		String dropDownOptionValue = PS2_SelectPeersDropdown_Options.getText().trim();
//		// This is used to come out of the dropdown overlay effect
//		new Actions(driver).moveByOffset(10, 10).click().build().perform();
//
//		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
//		Thread.sleep(4000);
//		// Locates all the cells of checkbox column
//		List<WebElement> checkboxes = driver.findElements(By.xpath("//table/tbody/tr[position()>1]//td[1]"));
//		System.out.println("--- Total checkboxes found: " + checkboxes.size());
//
//	}

	private String optionText;

	public void selectPeersDropdown() throws IOException, InterruptedException {
		// Open the dropdown
		WebElement ps2_selectPeersDropdown = waitForElement(cpa_ps2_selectPeersDropdown);
		helper.safeClick(ps2_selectPeersDropdown);
		System.out.println("=> Clicked: Select Peers Dropdown");

		// Select dropdown option
		WebElement ps2_optionsSPD = waitForElement(cpa_ps2_optionsSPD);
		this.optionText = ps2_optionsSPD.getText().trim(); // Top 5, Top 10, etc.
		helper.safeClick(ps2_optionsSPD);
		System.out.println("=> The Selected Peers Option is: " + optionText);

		// Dismiss dropdown overlay and wait for table
		new Actions(driver).moveByOffset(10, 10).click().build().perform();
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(3000);

		// Parse expected count
		int expectedCheckedCount;
		if (optionText.equalsIgnoreCase("Select All")) {
			// When "Select All" is selected, handle pagination and check all rows
			expectedCheckedCount = Integer.MAX_VALUE; // No specific limit
		} else {
			// For other options like "Top 5", "Top 10", etc.
			Matcher matcher = Pattern.compile("\\d+").matcher(optionText);
			expectedCheckedCount = matcher.find() ? Integer.parseInt(matcher.group()) : 0;
		}

		int checkedCount = 0;
		List<String> checkedBillToIds = new ArrayList<>();

		// Handle "Select All" scenario: Change the pagination value
		if (optionText.equalsIgnoreCase("Select All")) {
			// Changing the pagination value
			WebElement ps2_paginationCPGS = waitForElement(cpa_ps2_paginationCPGS);
			helper.safeClick(ps2_paginationCPGS);

			// waits for the pagination value - 45
			WebElement ps2_paginationValue45 = waitForElement(cpa_ps2_paginationValue45);
			actions.moveToElement(ps2_paginationValue45, 0, 0).click().perform();

			waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
			Thread.sleep(2000); // Adjust sleep if necessary

			// Loop across pages of the table
			while (true) {
				List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

				for (int i = 0; i < rows.size(); i++) {
					WebElement row = rows.get(i);

					// Try finding checkbox inside row
					List<WebElement> checkboxes = row.findElements(By.xpath("td[1]//input[@type='checkbox']"));
					if (checkboxes.isEmpty())
						continue; // No checkbox (maybe header or empty row)

					WebElement checkbox = checkboxes.get(0);
					boolean isChecked = checkbox.getAttribute("checked") != null;

					if (isChecked) {
						checkedCount++;
						// Get BILL TO ID value (2nd column)
						String billToId = row.findElement(By.xpath("td[2]")).getText().trim();
						checkedBillToIds.add(billToId);

						if (checkedCount > expectedCheckedCount) {
							throw new AssertionError("=> More checkboxes checked than expected: " + checkedCount);
						}
					} else if (checkedCount < expectedCheckedCount) {
						// If we are still within expected top N and it’s unchecked, that’s an error
						throw new AssertionError("=> Row " + (i + 1) + " should be checked but is not.");
					}

					if (checkedCount == expectedCheckedCount) {
						break; // Done checking required peers
					}
				}

				if (checkedCount == expectedCheckedCount)
					break; // Stop if reached required count

				// Move to next page if available
				WebElement nextButton = driver.findElement(cpa_ps2_nextButtonCPGS);
				String disabled = nextButton.getAttribute("disabled");
				if (disabled != null && (disabled.equals("true") || disabled.equals("disabled")))
					break;

				helper.safeClick(nextButton);
				Thread.sleep(2000);
			}
		} else {
			// Handle other scenarios like "Top 5", "Top 10", etc.
			System.out.println("=> Expected checkbox count: " + expectedCheckedCount);
		}
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Search for a keyword
	public void searchForKeyword_SCPG() throws IOException, InterruptedException {
		WebElement ps2_searchBarCPGS = waitForElement(cpa_ps2_searchBarCPGS);
//		ps2_searchBarCPGS.click();
		helper.safeClick(ps2_searchBarCPGS);
		ps2_searchBarCPGS.clear();
		WebElement ps2_firstRowBillToIdCPGS = waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		String firstRowBillToIdCPGS = ps2_firstRowBillToIdCPGS.getText().trim();
		ps2_searchBarCPGS.sendKeys(firstRowBillToIdCPGS);
//		System.out.println("--- Searched: Keyword search was done");
		Thread.sleep(1000);

//		System.out.println("--- Searched: Keyword search was done");
		Thread.sleep(5000);

		// Clearing the Search Keyword
//		ps2_searchBarCPGS.click();
		helper.safeClick(ps2_searchBarCPGS);
		ps2_searchBarCPGS.sendKeys(Keys.CONTROL + "a");
		ps2_searchBarCPGS.sendKeys(Keys.BACK_SPACE);
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
//		System.out.println("--- Searched: Keyword search has been cleared from the search field");

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Download Icon
	public void downloadIcon_SCPG() throws IOException, InterruptedException {
		// Download Icon
		WebElement ps2_downloadIconCPGS = waitForElement(cpa_ps2_downloadIconCPGS);
//		ps2_downloadIconCPGS.click();
		helper.safeClick(ps2_downloadIconCPGS);
//		System.out.println("=> The Download Icon of the Comparative Peer Group Selection Table was clicked");
		Thread.sleep(2000);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Select Peers
	public void selectPeers() throws IOException, InterruptedException {
		// Waits for the Peer - 91331
		List<String> selectedPeersID = new ArrayList<>();

		WebElement ps2_selectPeers01CPGS = waitForElement(cpa_ps2_selectPeers01CPGS);
		String PS2_SelectPeersID01 = ps2_selectPeers01CPGS.getText();
		selectedPeersID.add(PS2_SelectPeersID01);
//		ps2_selectPeers01CPGS.click();
		helper.safeClick(ps2_selectPeers01CPGS);
//		System.out.println("--- Selected: Peer 91331");
		Thread.sleep(3000);
		// Waits for the Peer - 66810
		WebElement ps2_selectPeers02CPGS = waitForElement(cpa_ps2_selectPeers02CPGS);
		String PS2_SelectPeersID02 = ps2_selectPeers02CPGS.getText();
		selectedPeersID.add(PS2_SelectPeersID02);
//		ps2_selectPeers02CPGS.click();
		helper.safeClick(ps2_selectPeers02CPGS);
//		System.out.println("--- Selected: Peer 66810");
		Thread.sleep(3000);
		// Waits for the Peer - 176174
		WebElement ps2_selectPeers03CPGS = waitForElement(cpa_ps2_selectPeers03CPGS);
		String PS2_SelectPeersID03 = ps2_selectPeers03CPGS.getText();
		selectedPeersID.add(PS2_SelectPeersID03);
//		ps2_selectPeers03CPGS.click();
		helper.safeClick(ps2_selectPeers03CPGS);
//		System.out.println("--- Selected: Peer 176174");
		Thread.sleep(3000);
		// Waits for the Peer - 192021
		WebElement ps2_selectPeers04CPGS = waitForElement(cpa_ps2_selectPeers04CPGS);
		String PS2_SelectPeersID04 = ps2_selectPeers04CPGS.getText();
		selectedPeersID.add(PS2_SelectPeersID04);
		actions.moveToElement(ps2_selectPeers04CPGS).click().perform();
//		System.out.println("--- Selected: Peer 192021");
		Thread.sleep(3000);
		// Waits for the Peer - 149734
		WebElement ps2_selectPeers05CPGS = waitForElement(cpa_ps2_selectPeers05CPGS);
		String PS2_SelectPeersID05 = ps2_selectPeers05CPGS.getText();
		selectedPeersID.add(PS2_SelectPeersID05);
//		ps2_selectPeers05CPGS.click();
		helper.safeClick(ps2_selectPeers05CPGS);
//		System.out.println("=> The Peers Selected by click are: " + selectedPeersID);
		Thread.sleep(1000);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// De-select Peers
	public void deselectPeers() throws IOException, InterruptedException {
		// Waits for the Peer - 176174
		WebElement ps2_selectPeers03CPGS = waitForElement(cpa_ps2_selectPeers03CPGS);
//		ps2_selectPeers03CPGS.click();
		helper.safeClick(ps2_selectPeers03CPGS);
//		System.out.println("--- De-Selected: Peer 176174");
		Thread.sleep(3000);
		// Waits for the Peer - 66810
		WebElement ps2_selectPeers02CPGS = waitForElement(cpa_ps2_selectPeers02CPGS);
//		ps2_selectPeers02CPGS.click();
		helper.safeClick(ps2_selectPeers02CPGS);
//		System.out.println("--- De-Selected: Peer 66810");
		Thread.sleep(3000);

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Search and select Peers
	public void searchAndSelectPeers() throws IOException, InterruptedException {
		// For First Peer
		// Waits for the Search bar
		actions.moveByOffset(10, 10).click().build().perform();
		WebElement ps2_searchBarCPGS = waitForElement(cpa_ps2_searchBarCPGS);
//		ps2_searchBarCPGS.click();
		helper.safeClick(ps2_searchBarCPGS);
		ps2_searchBarCPGS.clear();
		// Search's Peer - 25525
		Thread.sleep(3000);
		// Waits for the peer 01
		WebElement ps2_searchAndSelectPeers01CPGS = waitForElement(cpa_ps2_searchAndSelectPeers01CPGS);
		String searchAndSelectPeers01CPGS = ps2_searchAndSelectPeers01CPGS.getText().trim();
		ps2_searchBarCPGS.sendKeys(searchAndSelectPeers01CPGS);
		Thread.sleep(1000);
		// System.out.println("=> Searched the Peer: " + searchAndSelectPeers01CPGS);
		String checkboxXPath01 = "//table//tr[td[2][normalize-space()='" + searchAndSelectPeers01CPGS
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";

//		String checkboxXPath01 = "//table//tr[td[2][normalize-space()='361219']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		Thread.sleep(1000);
		WebElement radioButton01 = waitForElement(By.xpath(checkboxXPath01));
		helper.safeClick(radioButton01);
//		actions.moveToElement(radioButton01).click().perform();
		Thread.sleep(1000);

//		// Check whether the Peer is checked or not
		if (!ps2_searchAndSelectPeers01CPGS.isSelected()) {
			ps2_searchAndSelectPeers01CPGS.click();
//			System.out.println("--- Searched and Selected the Peer : 25525");
		} else {
//			System.out.println("--- Peer 25525 already selected. Skipping click.");
		}
		Thread.sleep(2000);
		// Clearing the Search Keyword
//		ps2_searchBarCPGS.click();
		helper.safeClick(ps2_searchBarCPGS);
		ps2_searchBarCPGS.sendKeys(Keys.CONTROL + "a");
		ps2_searchBarCPGS.sendKeys(Keys.BACK_SPACE);
		actions.moveByOffset(10, 10).click().build().perform();
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(3000);

		// For Second Peer
//		ps2_searchBarCPGS.click();
		helper.safeClick(ps2_searchBarCPGS);
		ps2_searchBarCPGS.clear();
		// Waits for the peer - 79678
		WebElement ps2_searchAndSelectPeers02CPGS = waitForElement(cpa_ps2_searchAndSelectPeers02CPGS);
		String searchAndSelectPeers02CPGS = ps2_searchAndSelectPeers02CPGS.getText().trim();
		ps2_searchBarCPGS.sendKeys(searchAndSelectPeers02CPGS);
		// clicks the checkbox
		String checkboxXPath02 = "//table//tr[td[2][normalize-space()='" + searchAndSelectPeers02CPGS
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		Thread.sleep(1000);
		WebElement radioButton02 = waitForElement(By.xpath(checkboxXPath02));
		helper.safeClick(radioButton02);
//		actions.moveToElement(radioButton02).click().perform();
		System.out.println("=> Searched and Selected the Peer: " + searchAndSelectPeers01CPGS + " , "
				+ searchAndSelectPeers02CPGS);
		Thread.sleep(1000);

		// Check whether the Peer is checked or not
		if (!ps2_searchAndSelectPeers02CPGS.isSelected()) {
			ps2_searchAndSelectPeers02CPGS.click();
//			System.out.println("--- Searched and Selected the Peer : 79678");
		} else {
//			System.out.println("✔️ Peer 79678 already selected. Skipping click.");
		}
		Thread.sleep(5000);
		// Clearing the Search Keyword
//		ps2_searchBarCPGS.click();
		helper.safeClick(ps2_searchBarCPGS);
		ps2_searchBarCPGS.sendKeys(Keys.CONTROL + "a");
		ps2_searchBarCPGS.sendKeys(Keys.BACK_SPACE);
		actions.moveByOffset(10, 10).click().build().perform();
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(3000);

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Search and De Select Peers
	public void searchAndDeSelectPeers() throws IOException, InterruptedException {
		// For First Peer
		// Waits for the Search bar
		WebElement ps2_searchBarCPGS = waitForElement(cpa_ps2_searchBarCPGS);
//		ps2_searchBarCPGS.click();
		helper.safeClick(ps2_searchBarCPGS);
		ps2_searchBarCPGS.clear();
		// Waits for the peer - 192021
		WebElement ps2_searchAndDeselectPeer01CPGS = waitForElement(cpa_ps2_searchAndDeselectPeer01CPGS);
		String searchAndDeselectPeer01CPGS = ps2_searchAndDeselectPeer01CPGS.getText().trim();
		ps2_searchBarCPGS.sendKeys(searchAndDeselectPeer01CPGS);
		String checkboxXPath01 = "//table//tr[td[2][normalize-space()='" + searchAndDeselectPeer01CPGS
				+ "']]//td[1]//span[contains(@class, 'MuiButtonBase-root')]";
		Thread.sleep(1000);
		WebElement radioButton01 = waitForElement(By.xpath(checkboxXPath01));
		actions.moveToElement(radioButton01).click().perform();

//		System.out.println("--- Searched and De-Selected the Peer : 1776671");
		Thread.sleep(5000);
		// Clearing the Search Keyword
//		ps2_searchBarCPGS.click();
		helper.safeClick(ps2_searchBarCPGS);
		ps2_searchBarCPGS.sendKeys(Keys.CONTROL + "a");
		ps2_searchBarCPGS.sendKeys(Keys.BACK_SPACE);
		actions.moveByOffset(10, 10).click().build().perform();
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(3000);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Compare Peers Button
	private String namePeerGroup, filterCustomerPeerGroupOptionValue01;

	public void comparePeersBtn() throws IOException, InterruptedException {
		// Compare Peer Button
		WebElement ps2_comparePeersBtnCPGS = waitForElement(cpa_ps2_comparePeersBtnCPGS);
//		ps2_comparePeersBtnCPGS.click();
		helper.safeClick(ps2_comparePeersBtnCPGS);
		System.out.println("=> The Compare Peers Button was clicked");
		// Pop - Up
		// Waits for the Enter the Name input field
		WebElement ps2_peerGroupNameCPGS = waitForElement(cpa_ps2_peerGroupNameCPGS);
//		ps2_peerGroupNameCPGS.click();
		helper.safeClick(ps2_peerGroupNameCPGS);
		ps2_peerGroupNameCPGS.clear();
		// PS2 -Comparative Peer Group table of Peer Selection-02 - Table First Row
		WebElement ps2_firstRowBillToIdCPGS = waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		// Extracts the BILL To ID from the first row
		String ps2_billToId = ps2_firstRowBillToIdCPGS.getText().trim();
		System.out.println("=> The Selected Target Customer BILL To ID in Comparative Peer Group Selection table is:"
				+ ps2_billToId);
		// The naming convention is based on the BILL To ID + S

//		this.namePeerGroup = ps2_billToId + "_Comparative_PeersCombination";
		ps2_peerGroupNameCPGS.sendKeys(namePeerGroup);
		Thread.sleep(7000);
		// Screenshot of Entering the Comparative Peer Group
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS2_EnteringComparativePeerGroupName.png");
//		FileHandler.copy(sourcefile, screenshotPath);
		// Waits for the Save and Proceed Button
		WebElement ps2_saveAndProceedBtnCPGS = waitForElement(cpa_ps2_saveAndProceedBtnCPGS);
//		ps2_saveAndProceedBtnCPGS.click();
		helper.safeClick(ps2_saveAndProceedBtnCPGS);
		System.out.println("=> The Save and Proceed button was clicked and redirected to Create Scenario screen");
		waitForElement(cpa_csc_scenarioSlider);
		// waits for the filter button
		WebElement csc_filter = waitForElement(cpa_csc_filtersBtn);
//		csc_filter.click();
		helper.safeClick(csc_filter);
		Thread.sleep(3000);
		// Waits for the Filter - Options
		WebElement csc_filterCustomerPeerGroupOption = waitForElement(cpa_csc_filterCustomerPeerGroupOption);
//		csc_filterCustomerPeerGroupOption.click();
		helper.safeClick(csc_filterCustomerPeerGroupOption);
		// Waits for the Filter - Options - Value01
		WebElement csc_filterCustomerPeerGroupOptionValue01 = waitForElement(
				cpa_csc_filterCustomerPeerGroupOptionValue01);
		// extracts the value 01 for the validation of back button
		this.filterCustomerPeerGroupOptionValue01 = csc_filterCustomerPeerGroupOptionValue01.getText().trim();
		Thread.sleep(2000);
		waitForElement(cpa_csc_filterCancelBtn).click();
		// Validating
		if (!filterCustomerPeerGroupOptionValue01.toLowerCase().contains(namePeerGroup.toLowerCase())) {
			throw new AssertionError("=> Mismatch in the Customer + Scenario Name | Peer Selection  = ["
					+ filterCustomerPeerGroupOptionValue01 + "] vs Create Scenario  = [" + namePeerGroup + "]");
		}
		System.out.println(
				"=> The Customer + Peer Group combination name is matched, which means the Create Scenario screen is loaded with the created peer group combination");

		Thread.sleep(2000);
		// Waits for the Create Scenario - Slider Component
//		waitForElement(cpa_csc_sliderComponent);   ------ This has to be uncommented after the redirection failure solved
		// Verify whether it landed on the Customer Peer Analysis Card - Scenario
		// Builder -
		// Create Scenario Screen
		String currentUrl = driver.getCurrentUrl();
		String expectedCreateScenarioUrl = ConfigReader.cpa_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedCreateScenarioUrl)) {
			throw new AssertionError("=> Unexpected Redirection and landed on wrong screen" + currentUrl);
		}
		System.out.println("=> Successfully, Landed on the Create Scenario Screen with the selected peer group!");

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Reset Button
	public void resetBtn() throws IOException, InterruptedException {
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		// waits for the select all row of the CPGS table
		WebElement ps2_selectAllRowCPGS = waitForElement(cpa_ps2_selectAllRowCPGS);
//		ps2_selectAllRowCPGS.click();
		helper.safeClick(ps2_selectAllRowCPGS);
		Thread.sleep(2000);

		// Reset Button
		WebElement ps2_resetBtnCPGS = waitForElement(cpa_ps2_resetBtnCPGS);
//		ps2_resetBtnCPGS.click();
		helper.safeClick(ps2_resetBtnCPGS);
		System.out.println("=> Clicked: Reset Button");
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(2000);

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// SPMC(View) - Peer Dropdown - Table - Buttons
	// Set Peer Matching Criteria - View
	public void setPeerMatchingCriteriaView() throws IOException, InterruptedException {
		// View's only the Set Peer Matching Criteria pop up
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		WebElement ps2_SPMCBtn = waitForElement(cpa_ps2_SPMCBtn);
//		ps2_SPMCBtn.click();
		helper.safeClick(ps2_SPMCBtn);
		Thread.sleep(5000);
		// Waits for the cancel icon
		WebElement ps2_CancelBtnSPMC = waitForElement(cpa_ps2_CancelBtnSPMC);
//		ps2_CancelBtnSPMC.click();
		helper.safeClick(ps2_CancelBtnSPMC);
		System.out.println("The Cancel (X) icon of the Set Peer Matching Criteria Pop-Up was clicked");
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// SPMC(View) - Peer Dropdown - Table - Buttons
	// Back button
	public void backBtn() throws IOException, InterruptedException {
		// waits for the Back button
		WebElement ps2_backBtnCPGS = waitForElement(cpa_ps2_backBtnCPGS);
//		ps2_backBtnCPGS.click();
		helper.safeClick(ps2_backBtnCPGS);
		System.out.println("=> The Back button is clicked and got redirected to Peer Selection - 01 screen");
		selectCustomerBtnWithSelection();
		System.out.println("=> Successfully, redirected to Peer Selection - 02 screen");

	}
}
