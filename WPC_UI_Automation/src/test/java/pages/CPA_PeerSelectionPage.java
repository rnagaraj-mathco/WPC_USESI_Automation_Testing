package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class CPA_PeerSelectionPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public CPA_PeerSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(90)); // wait initialized once
		actions = new Actions(driver);
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
	By cpa_ps1_firstRowBillToIdSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// Search Keyword - STC
	By cpa_ps1_SearchKeywordSTC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

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
	By cpa_ps2_firstRowBillToIdCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");
	// Comparative Peer Group Selection table
	By cpa_ps2_comparativePeerGroupSelectionTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]");
	// Back button
	By cpa_ps2_backBtnCPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/button[1]");

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
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/div[1]/button[1]");

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

	// Peer Search and Select in table - 25525
	By cpa_ps2_searchAndSelectPeers01CPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// Peer Search and Select in table - 79678
	By cpa_ps2_searchAndSelectPeers02CPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// Peer Search and De-Select in table - 192021
	By cpa_ps2_searchAndDeselectPeer01CPGS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// Set Peer Matching - View - Cancel (X)
	By cpa_ps2_CancelBtnSPMC = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/span[1]/*[name()='svg'][1]");
	// Create Scenario - Slider Component
	By cpa_csc_sliderComponent = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]");

	By cpa_csc_scenarioSlider = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]");

	// Loading the Peer Selection Screen

	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Branch Customer Selection Screen
		driver.get(ConfigReader.cpa_peerSelection());
		// Function waits till the Entire Overview Screen is getting loaded
		waitForElement(cpa_ps1_tableSTCTable);
//		System.out.println(
//				"--- Loaded the Peer Selection -01 Screen where Target customer will be selected for Peer Matching");
		Thread.sleep(2000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PeerSelection_01_Screen.png");
		FileHandler.copy(sourcefile, screenshotPath);
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
		WebElement ps1_SearchKeywordSTC = waitForElement(cpa_ps1_SearchKeywordSTC);
		ps1_SearchKeywordSTC.click();
		ps1_SearchKeywordSTC.clear();
		ps1_SearchKeywordSTC.sendKeys("135763");
//		System.out.println("--- Searched: Keyword search was done");
		Thread.sleep(5000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/ps2_searchBarCPGS.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
		ps1_SearchKeywordSTC.click();
		ps1_SearchKeywordSTC.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
//		System.out.println("--- Searched: Keyword search has been cleared from the search field");

	}

	// Select Target Customer Button with selection
	public void selectCustomerBtnWithSelection() throws IOException, InterruptedException {
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
		Thread.sleep(5000);

		// Clicks the Select Customer button
		ps1_selectCustomerBtnSTC.click();
//		System.out.println("--- Clicked: Select Customer Button");

		// Waits till the Comparative Peer Group Selection table gets loaded in the Peer
		// Selection - 02
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(4000);

		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/SelectCustomerbtnWithSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);

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

		Thread.sleep(1000);

	}

	// Clicks the Select Customer button without selection
	public void selectCustomerBtnWithOutSelection() throws IOException, InterruptedException {
		// waits for the Select Customer button to get load
		WebElement ps1_selectCustomerBtnSTC = waitForElement(cpa_ps1_selectCustomerBtnSTC);
		// Clicks the Create Sensitivity Scenario button
		ps1_selectCustomerBtnSTC.click();
//		System.out.println("--- Clicked: Select Customer Button without selecting a record");
		Thread.sleep(5000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/SelectCustomerbtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Select Target Customer for Peer Matching table Record Download
	public void tableRecordsDownload() throws IOException, InterruptedException {
		// Download button present in the table
		WebElement ps1_downloadIconSTC = waitForElement(cpa_ps1_downloadIconSTC);
		ps1_downloadIconSTC.click();
//		System.out.println("=> The Download Button of the Select Target Customer for Peer Matching table was clicked");
		Thread.sleep(5000);

	}

	// Clicks the Back button of Peer Selection - 02 and get redirected to
	// Peer Selection - 01 screen
	public void redirectionToPeerSelection_01_Screen() throws IOException, InterruptedException {
		WebElement ps2_backBtnCPGS = waitForElement(cpa_ps2_backBtnCPGS);
		Thread.sleep(1000);
		ps2_backBtnCPGS.click();
		System.out.println(
				"=> The Back Button of Peer Selection - 02 was clicked and redirected to the Peer Selection - 01");
		// Waits till the table gets loaded
		waitForElement(cpa_ps1_tableSTCTable);
		Thread.sleep(3000);

	}

	// Clicks the Back button of Peer Selection - 01 and get redirected to
	// Branch/Customer Page
	public void redirectionToBranchCustomerScreen() throws IOException, InterruptedException {
		// Back button
		WebElement ps1_BackBtnSTC = waitForElement(cpa_ps1_BackBtnSTC);
		ps1_BackBtnSTC.click();
		System.out.println(
				"=> The Back Button of the Peer Selection - 01 was clickd and redirected to the Branch/Customer Selection Screen");
		waitForElement(cpa_bc_geographicalMap);
		Thread.sleep(5000);

	}

	// Peer Selection 01 Target Customer Selection - Customer Selection by Searching
	// and Selecting the the record
	public void searchForRecord() throws IOException, InterruptedException {
		// Search field
		WebElement ps2_searchBarCPGS = waitForElement(cpa_ps2_searchBarCPGS);
		// waits for the BILL To ID of Searched Record
		WebElement PS1_SearchedRecordBillToId_SelectTargetCustomerTable = waitForElement(
				cpa_ps1_searchRecordBillToIdSTC);

		ps2_searchBarCPGS.click();
		ps2_searchBarCPGS.clear();
		ps2_searchBarCPGS.sendKeys("105097");
//		System.out.println("--- Searched the Target Customer Record: Customer ID 105097");
		Thread.sleep(5000);
		// waits for the searched record
		WebElement PS1_SearchedRecord_SelectTargetCustomerTable = waitForElement(cpa_ps1_searchedRecordSTC);

		PS1_SearchedRecord_SelectTargetCustomerTable.click();
//		System.out.println("--- Selected the Searched Target Customer Record: Customer ID 105097");
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS1_SearchSelectRecord_SelectTargetCustomer.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Clearing the Search Keyword
		ps2_searchBarCPGS.click();
		ps2_searchBarCPGS.sendKeys(Keys.CONTROL + "a");
		ps2_searchBarCPGS.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
//		System.out.println("--- Searched record has been cleared from the search field");
		// Extracts the BILL To ID of the first row
		String ps1_billToId_record = PS1_SearchedRecordBillToId_SelectTargetCustomerTable.getText().trim();
		System.out.println(
				"=> The Selected Target Customer BILL To ID in Select Target Customer table is:" + ps1_billToId_record);

		// waits for the Select Customer button to get load
		WebElement PS1_SelectCustomerBtn = waitForElement(cpa_ps1_selectCustomerBtnSTC);
		// Clicks the Select Customer button with selection
		PS1_SelectCustomerBtn.click();
//		System.out.println("--- Clicked: Select Customer Button");
		// Waits till the Comparative Peer Group Selection table gets loaded in the Peer
		// Selection - 02
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(4000);

		// PS2 -Comparative Peer Group table of Peer Selection-02 - Table First Row
		WebElement PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId = waitForElement(
				cpa_ps2_firstRowBillToIdCPGS);
		// Extracts the BILL To ID from the first row
		String ps2_billToId_record = PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId.getText().trim();
		System.out.println("=> The Selected Target Customer BILL To ID in Comparative Peer Group Selection table is:"
				+ ps2_billToId_record);

		// Comparing both the BILL To ID's
		if (!ps1_billToId_record.equals(ps2_billToId_record)) {
			throw new AssertionError("=> There is a BILL To ID mismatch: Select Target Customer table = "
					+ ps1_billToId_record + ", Comparative Peer Group table = " + ps2_billToId_record);
		}
		System.out.println(
				" => The BILL To ID's matches and ensures the same record passed to the Peer Selection -02 screen");

		// Clicking Back button of Peer Selection - 02 for redirection to Peer Selection
		// - 01
		WebElement PS2_BackBtn = waitForElement(cpa_ps2_backBtnCPGS);
		Thread.sleep(3000);
		PS2_BackBtn.click();
//		System.out.println(
//				"--- Clicked - Back Button of Peer Selection - 02 and got redirected to the Peer Selection - 01");
		// Waits till the table gets loaded
		waitForElement(cpa_ps1_tableSTCTable);

		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();
		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError("=> Unexpected Redirection and landed on wrong screen" + currentUrl);
		}
		Thread.sleep(4000);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Set Peer Matching Criteria Button

	public void setPeerMatchingCriteria() throws IOException, InterruptedException {

		// Set Peer Matching Criteria
		WebElement PS2_SetPeerMatchingCriteriaBtn = waitForElement(cpa_ps2_SPMCBtn);
		PS2_SetPeerMatchingCriteriaBtn.click();
		// Pop-Up
		// Select Model - Dropdown
		WebElement PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown = waitForElement(cpa_ps2_selectModelDropdownSPMC);
		PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown.click();
		Thread.sleep(3000);
//		System.out.println("--- Clicked: Select Model Dropdown");

		// Select Model - Dropdown - Options
		WebElement PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown_Options = waitForElement(
				cpa_ps2_selectModelDropdownOptionsSPMC);
		String selectedModel = PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown_Options.getText().trim();
		PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown_Options.click();
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
		WebElement PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue = waitForElement(cpa_ps2_setThresholdValueSPMC);
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue.click();
		Thread.sleep(2000);
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue.sendKeys(Keys.CONTROL + "a");
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Enter the Threshold value as 40
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue.sendKeys("40");

		// Take screenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS2_SetPeerMatchingCriteriaBtn.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Validating the Entered Threshold Value and Similarity Score in Comparative -
		// Peer Group Selection table
		// Store's the entered Threshold value
		WebElement PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue_AfterValue = waitForElement(
				cpa_ps2_setThresholdValueAfterValueSPMC);
		// As we are comparing the numerical so we use Double datatype
		Double enteredThresholdValue = Double.parseDouble(
				(PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue_AfterValue).getAttribute("value").trim());
		System.out.println("=> The Entered Threshold value is:" + enteredThresholdValue);

		// Apply button
		WebElement PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue_ApplyBtn = waitForElement(cpa_ps2_applyBtnSPMC);
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue_ApplyBtn.click();
//		System.out.println("--- Clicked: Apply button which then updates the table");
		Thread.sleep(6000);
		// Waits for the Comparative Peer Group Selection table
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		// Validates the similarity score and the model in the table

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
			nextButton.click();
			Thread.sleep(2000);
		}
		// Waits for the Type of Model column from the table row
		WebElement PS2_SetPeerMatchingCriteriaBtn_ExtractTypeOfModel = waitForElement(cpa_ps2_typeOfModelCPGS);

		actions.moveToElement(PS2_SetPeerMatchingCriteriaBtn_ExtractTypeOfModel).perform();

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
	public void selectPeersDropdown() throws IOException, InterruptedException {
		// Open the dropdown
		WebElement PS2_SelectPeersDropdown = waitForElement(cpa_ps2_selectPeersDropdown);
		PS2_SelectPeersDropdown.click();
//		System.out.println("--- Clicked: Select Peers Dropdown");

		// Select dropdown option
		WebElement PS2_SelectPeersDropdown_Options = waitForElement(cpa_ps2_optionsSPD);
		String optionText = PS2_SelectPeersDropdown_Options.getText().trim(); // Top 5, Top 10, etc.
		PS2_SelectPeersDropdown_Options.click();
		System.out.println("=> The Selected Peers Option is: " + optionText);

		// Dismiss dropdown overlay and wait for table
		new Actions(driver).moveByOffset(10, 10).click().build().perform();
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(3000);

		// Parse expected count
		int expectedCheckedCount;
		if (optionText.equalsIgnoreCase("Select All")) {
			expectedCheckedCount = Integer.MAX_VALUE;
		} else {
			Matcher matcher = Pattern.compile("\\d+").matcher(optionText);
			expectedCheckedCount = matcher.find() ? Integer.parseInt(matcher.group()) : 0;
		}

		int checkedCount = 0;
		List<String> checkedBillToIds = new ArrayList<>();

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

			nextButton.click();
			Thread.sleep(2000);
		}

		// Final result validation
//		System.out.println("=> The selected Peer Count is : " + checkedCount);
//		System.out.println("=> The BILL TO IDs checked for for " + optionText + ": " + checkedBillToIds);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Search for a keyword
	public void searchForKeyword_SCPG() throws IOException, InterruptedException {
		WebElement ps2_searchBarCPGS = waitForElement(cpa_ps2_searchBarCPGS);
		ps2_searchBarCPGS.click();
		ps2_searchBarCPGS.clear();
		ps2_searchBarCPGS.sendKeys("105097");
//		System.out.println("--- Searched: Keyword search was done");
		Thread.sleep(5000);

		// Clearing the Search Keyword
		ps2_searchBarCPGS.click();
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
		WebElement PS2_DownloadBtn_ComparativePeerGroupSelectionTable = waitForElement(cpa_ps2_downloadIconCPGS);
		PS2_DownloadBtn_ComparativePeerGroupSelectionTable.click();
//		System.out.println("=> The Download Icon of the Comparative Peer Group Selection Table was clicked");
		Thread.sleep(2000);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Select Peers
	public void selectPeers() throws IOException, InterruptedException {
		// Waits for the Peer - 91331
		List<String> selectedPeersID = new ArrayList<>();

		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_91331 = waitForElement(cpa_ps2_selectPeers01CPGS);
		String PS2_SelectPeersID01 = PS2_SelectPeers_ComparativePeerGroupSelectionTable_91331.getText();
		selectedPeersID.add(PS2_SelectPeersID01);
		PS2_SelectPeers_ComparativePeerGroupSelectionTable_91331.click();
//		System.out.println("--- Selected: Peer 91331");
		Thread.sleep(3000);
		// Waits for the Peer - 66810
		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_66810 = waitForElement(cpa_ps2_selectPeers02CPGS);
		String PS2_SelectPeersID02 = PS2_SelectPeers_ComparativePeerGroupSelectionTable_66810.getText();
		selectedPeersID.add(PS2_SelectPeersID02);
		PS2_SelectPeers_ComparativePeerGroupSelectionTable_66810.click();
//		System.out.println("--- Selected: Peer 66810");
		Thread.sleep(3000);
		// Waits for the Peer - 176174
		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_176174 = waitForElement(
				cpa_ps2_selectPeers03CPGS);
		String PS2_SelectPeersID03 = PS2_SelectPeers_ComparativePeerGroupSelectionTable_176174.getText();
		selectedPeersID.add(PS2_SelectPeersID03);
		PS2_SelectPeers_ComparativePeerGroupSelectionTable_176174.click();
//		System.out.println("--- Selected: Peer 176174");
		Thread.sleep(3000);
		// Waits for the Peer - 192021
		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_192021 = waitForElement(
				cpa_ps2_selectPeers04CPGS);
		String PS2_SelectPeersID04 = PS2_SelectPeers_ComparativePeerGroupSelectionTable_192021.getText();
		selectedPeersID.add(PS2_SelectPeersID04);
		actions.moveToElement(PS2_SelectPeers_ComparativePeerGroupSelectionTable_192021).click().perform();
//		System.out.println("--- Selected: Peer 192021");
		Thread.sleep(3000);
		// Waits for the Peer - 149734
		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_149734 = waitForElement(
				cpa_ps2_selectPeers05CPGS);
		String PS2_SelectPeersID05 = PS2_SelectPeers_ComparativePeerGroupSelectionTable_149734.getText();
		selectedPeersID.add(PS2_SelectPeersID05);
		PS2_SelectPeers_ComparativePeerGroupSelectionTable_149734.click();
//		System.out.println("=> The Peers Selected by click are: " + selectedPeersID);
		Thread.sleep(1000);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// De-select Peers
	public void deselectPeers() throws IOException, InterruptedException {
		// Waits for the Peer - 176174
		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_176174 = waitForElement(
				cpa_ps2_selectPeers03CPGS);
		PS2_SelectPeers_ComparativePeerGroupSelectionTable_176174.click();
//		System.out.println("--- De-Selected: Peer 176174");
		Thread.sleep(3000);
		// Waits for the Peer - 66810
		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_66810 = waitForElement(cpa_ps2_selectPeers02CPGS);
		PS2_SelectPeers_ComparativePeerGroupSelectionTable_66810.click();
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
		ps2_searchBarCPGS.click();
		ps2_searchBarCPGS.clear();
		// Search's Peer - 25525
		Thread.sleep(3000);
		ps2_searchBarCPGS.sendKeys("176671");
		Thread.sleep(2000);
		// Waits for the peer - 25525
		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_25525 = waitForElement(
				cpa_ps2_searchAndSelectPeers01CPGS);

		// Check whether the Peer is checked or not
		if (!PS2_SelectPeers_ComparativePeerGroupSelectionTable_25525.isSelected()) {
			PS2_SelectPeers_ComparativePeerGroupSelectionTable_25525.click();
//			System.out.println("--- Searched and Selected the Peer : 25525");
		} else {
//			System.out.println("--- Peer 25525 already selected. Skipping click.");
		}
		Thread.sleep(5000);
		// Clearing the Search Keyword
		ps2_searchBarCPGS.click();
		ps2_searchBarCPGS.sendKeys(Keys.CONTROL + "a");
		ps2_searchBarCPGS.sendKeys(Keys.BACK_SPACE);
		actions.moveByOffset(10, 10).click().build().perform();
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(3000);

		// For Second Peer
		ps2_searchBarCPGS.click();
		ps2_searchBarCPGS.clear();
		// Search's Peer - 79678
		ps2_searchBarCPGS.sendKeys("79678");
		Thread.sleep(2000);
		// Waits for the peer - 79678
		WebElement PS2_SelectPeers_ComparativePeerGroupSelectionTable_79678 = waitForElement(
				cpa_ps2_searchAndSelectPeers02CPGS);
		// Check whether the Peer is checked or not
		if (!PS2_SelectPeers_ComparativePeerGroupSelectionTable_79678.isSelected()) {
			PS2_SelectPeers_ComparativePeerGroupSelectionTable_79678.click();
//			System.out.println("--- Searched and Selected the Peer : 79678");
		} else {
//			System.out.println("✔️ Peer 79678 already selected. Skipping click.");
		}
		Thread.sleep(5000);
		// Clearing the Search Keyword
		ps2_searchBarCPGS.click();
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
		ps2_searchBarCPGS.click();
		ps2_searchBarCPGS.clear();
		// Search's Peer - 192021
		ps2_searchBarCPGS.sendKeys("176671");
		Thread.sleep(3000);
		// Waits for the peer - 192021
		WebElement ps2_searchAndDeselectPeer01CPGS = waitForElement(cpa_ps2_searchAndDeselectPeer01CPGS);
		ps2_searchAndDeselectPeer01CPGS.click();
//		System.out.println("--- Searched and De-Selected the Peer : 1776671");
		Thread.sleep(5000);
		// Clearing the Search Keyword
		ps2_searchBarCPGS.click();
		ps2_searchBarCPGS.sendKeys(Keys.CONTROL + "a");
		ps2_searchBarCPGS.sendKeys(Keys.BACK_SPACE);
		actions.moveByOffset(10, 10).click().build().perform();
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);
		Thread.sleep(3000);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	// Compare Peers Button
	public void comparePeersBtn() throws IOException, InterruptedException {
		// Compare Peer Button
		WebElement ps2_comparePeersBtnCPGS = waitForElement(cpa_ps2_comparePeersBtnCPGS);
		ps2_comparePeersBtnCPGS.click();
		System.out.println("=> The Compare Peers Button was clicked");
		// Pop - Up
		// Waits for the Enter the Name input field
		WebElement ps2_peerGroupNameCPGS = waitForElement(cpa_ps2_peerGroupNameCPGS);
		ps2_peerGroupNameCPGS.click();
		ps2_peerGroupNameCPGS.clear();
		// PS2 -Comparative Peer Group table of Peer Selection-02 - Table First Row
		WebElement ps2_firstRowBillToIdCPGS = waitForElement(cpa_ps2_firstRowBillToIdCPGS);
		// Extracts the BILL To ID from the first row
		String ps2_billToId = ps2_firstRowBillToIdCPGS.getText().trim();
		System.out.println("=> The Selected Target Customer BILL To ID in Comparative Peer Group Selection table is:"
				+ ps2_billToId);

		String namePeerGroup = ps2_billToId + "_Top_05_Customzied_PeersCombination";
		ps2_peerGroupNameCPGS.sendKeys(namePeerGroup);
		Thread.sleep(7000);
		// Screenshot of Entering the Comparative Peer Group
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS2_EnteringComparativePeerGroupName.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Waits for the Save and Proceed Button
		WebElement ps2_saveAndProceedBtnCPGS = waitForElement(cpa_ps2_saveAndProceedBtnCPGS);
		ps2_saveAndProceedBtnCPGS.click();
		System.out.println("=> The Save and Proceed button was clicked and redirected to Create Scenario screen");
		waitForElement(cpa_csc_scenarioSlider);
		Thread.sleep(3000);
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
		// Reset Button
		WebElement ps2_resetBtnCPGS = waitForElement(cpa_ps2_resetBtnCPGS);
		ps2_resetBtnCPGS.click();
//		System.out.println("--- Clicked: Reset Button");
		waitForElement(cpa_ps2_comparativePeerGroupSelectionTable);

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// SPMC(View) - Peer Dropdown - Table - Buttons
	// Set Peer Matching Criteria - View
	public void setPeerMatchingCriteriaView() throws IOException, InterruptedException {
		// View's only the Set Peer Matching Criteria pop up
		WebElement ps2_SPMCBtn = waitForElement(cpa_ps2_SPMCBtn);
		ps2_SPMCBtn.click();
		Thread.sleep(5000);
		// Waits for the cancel icon
		WebElement ps2_CancelBtnSPMC = waitForElement(cpa_ps2_CancelBtnSPMC);
		ps2_CancelBtnSPMC.click();
		System.out.println("The Cancel (X) icon of the Set Peer Matching Criteria Pop-Up was clicked");

	}

	// Peer Selection 02 Comparative Peer Group Selection
	// SPMC(View) - Peer Dropdown - Table - Buttons
	// Back button
	public void backBtn() throws IOException, InterruptedException {
		// waits for the Back button
		WebElement ps2_backBtnCPGS = waitForElement(cpa_ps2_backBtnCPGS);
		ps2_backBtnCPGS.click();
		System.out.println("=> The Back button is clicked and got redirected to Peer Selection - 01 screen");

	}
}
