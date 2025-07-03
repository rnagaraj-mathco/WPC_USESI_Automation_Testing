package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class CPA_PeerSelectionPage {
	WebDriver driver;
	WebDriverWait wait;

	// gets driver status
	public CPA_PeerSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // wait initialized once
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Peer Selection - 01
	// Select Target Customer for Peer Matching table
	// Entire Table
	By CPA_PS1_SelectTargetCustomerTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]");
	// First row record
	By CPA_PS1_SelectTargetCustomerTableFirstRow = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");
	// First row - Extract BILL To ID (2nd column)
	By CPA_PS1_SelectTargetCustomerTableFirstRow_BillTOId = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");

	// Search Keyword
	By CPA_PS1_SearchKeywordSelectTargetCustomer = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// Select Customer Button
	By CPA_PS1_SelectCustomerBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");
	// Back button
	By CPA_PS1_BackBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");
	// Geographical Map
	By CPA_GeographicalMap = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div");
	// Download button
	By CPA_PS1_DownloadBtn_SelectTargetCustomerTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// SearchRecord
	By CPA_PS1_SearchedRecord_SelectTargetCustomerTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// SearchRecord - Extract BILL To ID -105097
	By CPA_PS1_SearchedRecordBillToId_SelectTargetCustomerTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[3]/td[2]");

	// Peer Selection -02
	// Comparative Peer Group Selection table - First row BILL To ID
	By CPA_PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");
	// Comparative Peer Group Selection table
	By CPA_ComparativePeerGroupSelectionTable = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]");
	// Back button
	By CPA_PS2_BackBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/button[1]");

	// Set Peer Matching Criteria
	By CPA_PS2_SetPeerMatchingCriteriaBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/button[1]");

	// Set Peer Matching Criteria - Select Model Dropdown click
	By CPA_PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// Set Peer Matching Criteria - Select Model Dropdown -
	// Selecting Options:Existing Model
	By CPA_PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown_Options = By
			.xpath("/html/body/div[6]/div[3]/ul/li[1]/div");

	// Set Peer Matching Criteria - Set Threshold value -
	// Setting value to 45
	By CPA_PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/input[1]");

	// Set Peer Matching Criteria - Set Threshold value - Appy btn
	By CPA_PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue_ApplyBtn = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[7]/div[1]/div[1]/button[1]/span[1]");

	// Loading the Peer Selection Screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Branch Customer Selection Screen
		driver.get(ConfigReader.cpa_peerSelection());
		// Function waits till the Entire Overview Screen is getting loaded
		waitForElement(CPA_PS1_SelectTargetCustomerTable);
		System.out.println(
				"--- Loaded the Peer Selection -01 Screen where Target customer will be selected for Peer Matching");
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
			throw new AssertionError(
					"--- Not Landed on the Peer Selection Screen --- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

	}
	// Select Target Customer for Peer Matching table
	// Search keyword of Select Target Customer for Peer Matching table

	public void searchForKeyword_STC() throws IOException, InterruptedException {
		WebElement PS1_SearchKeywordSelectTargetCustomer = waitForElement(CPA_PS1_SearchKeywordSelectTargetCustomer);
		PS1_SearchKeywordSelectTargetCustomer.click();
		PS1_SearchKeywordSelectTargetCustomer.clear();
		PS1_SearchKeywordSelectTargetCustomer.sendKeys("Nagaraj");
		System.out.println("--- Searched: Keyword search was done");
		Thread.sleep(5000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS1_SearchKeywordSelectTargetCustomer.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
		PS1_SearchKeywordSelectTargetCustomer.click();
		PS1_SearchKeywordSelectTargetCustomer.sendKeys(Keys.CONTROL + "a");
		PS1_SearchKeywordSelectTargetCustomer.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		System.out.println("--- Searched: Keyword search has been cleared from the search field");

	}

	// Select Target Customer Button with selection
	public void selectCustomerBtnWithSelection() throws IOException, InterruptedException {
		// waits for the first row of the table and clicks as the button gets activated
		WebElement PS1_SelectTargetCustomerTableFirstRow = waitForElement(CPA_PS1_SelectTargetCustomerTableFirstRow);
		// waits for the BILL To ID of first row
		WebElement PS1_SelectTargetCustomerTableFirstRow_BillTOId = waitForElement(
				CPA_PS1_SelectTargetCustomerTableFirstRow_BillTOId);

		// waits for the Select Customer button to get load
		WebElement PS1_SelectCustomerBtn = waitForElement(CPA_PS1_SelectCustomerBtn);
		// Extracts the BILL To ID of the first row
		String PS1_billToId = PS1_SelectTargetCustomerTableFirstRow_BillTOId.getText().trim();
		System.out.println("--- The Selected Target Customer BILL To ID is:" + PS1_billToId);
		// Clicks the First row record
		PS1_SelectTargetCustomerTableFirstRow.click();
		System.out.println("--- Clicked: Select Target Customer for Peer Matching Table first row");
		Thread.sleep(5000);

		// Clicks the Select Customer button
		PS1_SelectCustomerBtn.click();
		System.out.println("--- Clicked: Select Customer Button");

		// Waits till the Comparative Peer Group Selection table gets loaded in the Peer
		// Selection - 02
		waitForElement(CPA_ComparativePeerGroupSelectionTable);
		Thread.sleep(4000);

		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/SelectCustomerbtnWithSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// PS2 -Comparative Peer Group table of Peer Selection-02 - Table First Row
		WebElement PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId = waitForElement(
				CPA_PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId);
		// Extracts the BILL To ID from the first row
		String PS2_billToId = PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId.getText().trim();
		System.out.println("--- The Selected Target Customer BILL To ID is:" + PS2_billToId);

		// Comparing both the BILL To ID's
		if (!PS1_billToId.equals(PS2_billToId)) {
			throw new AssertionError("--- BILL To ID mismatch: Select Target Customer table = " + PS1_billToId
					+ ", Comparative Peer Group table = " + PS2_billToId);
		}
		System.out.println(
				" --- The BILL To ID's matches and ensures the same record passed to the Peer Selection -02 screen");

		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();
		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError(
					"--- Not Landed on the Peer Selection Screen --- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

		Thread.sleep(1000);

	}

	// Clicks the Select Customer button without selection
	public void selectCustomerBtnWithOutSelection() throws IOException, InterruptedException {
		// waits for the Select Customer button to get load
		WebElement PS1_SelectCustomerBtn = waitForElement(CPA_PS1_SelectCustomerBtn);
		// Clicks the Create Sensitivity Scenario button
		PS1_SelectCustomerBtn.click();
		System.out.println("--- Clicked: Select Customer Button without selecting a record");
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
		WebElement PS1_DownloadBtn_SelectTargetCustomerTable = waitForElement(
				CPA_PS1_DownloadBtn_SelectTargetCustomerTable);
		PS1_DownloadBtn_SelectTargetCustomerTable.click();
		System.out.println("--- Clicked - Download Button of the Select Target Customer for Peer Matching table");
		Thread.sleep(5000);

	}

	// Clicks the Back button of Peer Selection - 02 and get redirected to
	// Peer Selection - 01 screen
	public void redirectionToPeerSelection_01_Screen() throws IOException, InterruptedException {
		WebElement PS2_BackBtn = waitForElement(CPA_PS2_BackBtn);
		Thread.sleep(1000);
		PS2_BackBtn.click();
		System.out.println(
				"--- Clicked - Back Button of Peer Selection - 02 and got redirected to the Peer Selection - 01");
		// Waits till the table gets loaded
		waitForElement(CPA_PS1_SelectTargetCustomerTable);
		Thread.sleep(3000);

	}

	// Clicks the Back button of Peer Selection - 01 and get redirected to
	// Branch/Customer Page
	public void redirectionToBranchCustomerScreen() throws IOException, InterruptedException {
		// Back button
		WebElement PS1_BackBtn = waitForElement(CPA_PS1_BackBtn);
		PS1_BackBtn.click();
		System.out.println(
				"--- Clicked - Back Button of Peer Selection - 01 and got redirected to the Branch/Customer Selection Screen");
		waitForElement(CPA_GeographicalMap);
		Thread.sleep(5000);

	}

	// Peer Selection 01 Target Customer Selection - Customer Selection by Searching
	// and Selecting the the record
	public void searchForRecord() throws IOException, InterruptedException {
		// Search field
		WebElement PS1_SearchKeywordSelectTargetCustomer = waitForElement(CPA_PS1_SearchKeywordSelectTargetCustomer);
		// waits for the BILL To ID of Searched Record
		WebElement PS1_SearchedRecordBillToId_SelectTargetCustomerTable = waitForElement(
				CPA_PS1_SearchedRecordBillToId_SelectTargetCustomerTable);

		PS1_SearchKeywordSelectTargetCustomer.click();
		PS1_SearchKeywordSelectTargetCustomer.clear();
		PS1_SearchKeywordSelectTargetCustomer.sendKeys("105097");
		System.out.println("--- Searched the Target Customer Record: Customer ID 105097");
		Thread.sleep(5000);
		// waits for the searched record
		WebElement PS1_SearchedRecord_SelectTargetCustomerTable = waitForElement(
				CPA_PS1_SearchedRecord_SelectTargetCustomerTable);

		PS1_SearchedRecord_SelectTargetCustomerTable.click();
		System.out.println("--- Selected the Searched Target Customer Record: Customer ID 105097");
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS1_SearchSelectRecord_SelectTargetCustomer.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Clearing the Search Keyword
		PS1_SearchKeywordSelectTargetCustomer.click();
		PS1_SearchKeywordSelectTargetCustomer.sendKeys(Keys.CONTROL + "a");
		PS1_SearchKeywordSelectTargetCustomer.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		System.out.println("--- Searched record has been cleared from the search field");
		// Extracts the BILL To ID of the first row
		String PS1_billToId_record = PS1_SearchedRecordBillToId_SelectTargetCustomerTable.getText().trim();
		System.out.println("--- The Selected Target Customer BILL To ID is:" + PS1_billToId_record);

		// waits for the Select Customer button to get load
		WebElement PS1_SelectCustomerBtn = waitForElement(CPA_PS1_SelectCustomerBtn);
		// Clicks the Select Customer button with selection
		PS1_SelectCustomerBtn.click();
		System.out.println("--- Clicked: Select Customer Button");
		// Waits till the Comparative Peer Group Selection table gets loaded in the Peer
		// Selection - 02
		waitForElement(CPA_ComparativePeerGroupSelectionTable);
		Thread.sleep(4000);

		// PS2 -Comparative Peer Group table of Peer Selection-02 - Table First Row
		WebElement PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId = waitForElement(
				CPA_PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId);
		// Extracts the BILL To ID from the first row
		String PS2_billToId_record = PS2_ComparativePeerGroupSelectionTableFirstRow_BillToId.getText().trim();
		System.out.println("--- The Selected Target Customer BILL To ID is:" + PS2_billToId_record);

		// Comparing both the BILL To ID's
		if (!PS1_billToId_record.equals(PS2_billToId_record)) {
			throw new AssertionError("--- BILL To ID mismatch: Select Target Customer table = " + PS1_billToId_record
					+ ", Comparative Peer Group table = " + PS2_billToId_record);
		}
		System.out.println(
				" --- The BILL To ID's matches and ensures the same record passed to the Peer Selection -02 screen");

		// Clicking Back button of Peer Selection - 02 for redirection to Peer Selection
		// - 01
		WebElement PS2_BackBtn = waitForElement(CPA_PS2_BackBtn);
		Thread.sleep(3000);
		PS2_BackBtn.click();
		System.out.println(
				"--- Clicked - Back Button of Peer Selection - 02 and got redirected to the Peer Selection - 01");
		// Waits till the table gets loaded
		waitForElement(CPA_PS1_SelectTargetCustomerTable);

		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();
		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError(
					"--- Not Landed on the Peer Selection Screen --- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}
		Thread.sleep(4000);
	}

	// Peer Selection 02 Comparative Peer Group Selection
	// -- SPMC - Peer Dropdown -Table - Buttons
	public void setPeerMatchingCriteria() throws IOException, InterruptedException {
		// Set Peer Matching Criteria
		WebElement PS2_SetPeerMatchingCriteriaBtn = waitForElement(CPA_PS2_SetPeerMatchingCriteriaBtn);
		PS2_SetPeerMatchingCriteriaBtn.click();
		// Pop-Up
		// Select Model - Dropdown
		WebElement PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown = waitForElement(
				CPA_PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown);
		PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown.click();
		Thread.sleep(3000);
		System.out.println("--- Clicked: Select Model Dropdown");
		// Select Model - Dropdown - Options
		WebElement PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown_Options = waitForElement(
				CPA_PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown_Options);
		PS2_SetPeerMatchingCriteriaBtn_SelectModelDropdown_Options.click();
		Thread.sleep(3000);
		System.out.println("--- Clicked: Select Model Dropdown Options: Existing Model");
		// Set Threshold Value
		WebElement PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue = waitForElement(
				CPA_PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue);
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue.click();
		Thread.sleep(2000);
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue.sendKeys(Keys.CONTROL + "a");
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Enter the Threshold value as 40
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue.sendKeys("40");
		Thread.sleep(3000);
		System.out.println("--- Entered: Threshold value");
		// Apply button
		WebElement PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue_ApplyBtn = waitForElement(
				CPA_PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue_ApplyBtn);
		PS2_SetPeerMatchingCriteriaBtn_SetThresholdValue_ApplyBtn.click();
		System.out.println("--- Clicked: Appy button which then updates the table");

	}

}
