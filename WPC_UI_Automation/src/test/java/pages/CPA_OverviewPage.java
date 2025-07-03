package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class CPA_OverviewPage {

	WebDriver driver;
	WebDriverWait wait;

	// gets driver status
	public CPA_OverviewPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(100)); // ✅ wait initialized once
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Entire screen XPATH (Considers all components)
	By CPA_Overview = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]");
	// Start New Peer Analysis buttons
	By CPA_StartNewPeerAnalysisBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/button[1]");
	// Geographical Map
	By CPA_GeographicalMap = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div");
	// Saved Customer Peer Selections table
	// Search Keyword
	By CPA_SearchKeywordSavedPeerSelections = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	// Searched record selection
	By CPA_SearchedRecordSavedPeerSelections = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// Create Sensitivity Scenario btn - Row Selection
	By CPA_SavedCustomerPeerTableFirstRow = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[4]/div/div/div/div[3]/table/tbody/tr/td[1]");
	// Create Sensitivity Scenario btn
	By CPA_CreateSensitivityScenarioBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/button[1]");
	// Edit btn - Saved Peer Selections table
	By CPA_EditbtnSavedPeerSelections = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[6]");
	// Back btn -01 - Saved Peer Selections table (This is the btn of the screen
	// where user lands when Edit btn clicked from overview screen
	By CPA_PeerSelectionBackBtn_01 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");
	// Back btn -02 - Saved Peer Selections table
	By CPA_PeerSelectionBackBtn_02 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");
	// Delete Dropdown - Saved Peer Selections table
	By CPA_DeleteDropdownSavedPeerSelections = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[7]/div[1]"); // deletes.
	// Delete Dropdown Options - Saved Peer Selections table
	By CPA_DeleteOptionsSavedPeerSelections = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[2]/div[1]");
	// Delete Icon - Saved Peer Selections table
	By CPA_DeleteIconSavedPeerSelections = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");
	// Download Icon - Saved Peer Selections table
	By CPA_DownloadIconSavedPeerSelections = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[8]/div[1]");
	// Pagination - Saved Peer Selections table
	By CPA_PaginationSavedPeerSelections = By.xpath("");

	// Saved Sensitivity Scenario Simulation table
	// Search Keyword
	By CPA_SearchKeywordSavedSensitivitySimulation = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	// Searched Record Selection
	By CPA_SearchedRecordSavedSensitivitySimulation = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// View Scenario btn - Row Selection
	By CPA_SavedSensitivitySimluationTableFirstRow = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1] ");
	// ViewImpact btn -
	By CPA_ViewImpactBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/div[1]");
	// Edit btn Saved Sensitivity Simulation Scenario
	By CPA_EditbtnSavedSensitivitySimulationScenario = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[8]/div/div/div/div[3]/table/tbody/tr[1]/td[7]/button");
	// Delete dropdown
	By CPA_DeleteDropdownSavedSensitivitySimulationScenario = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[8]/div[1]");
	// Delete dropdown options
	By CPA_DeleteOptionsSavedSensitivitySimulationScenario = By
			.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[2]/div[1]/div[1]/span[1]");
	// Delete Icon
	By CPA_DeleteIconSavedSensitivitySimulationScenario = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/button[1]");
	// Download Icon
	By CPA_DownloadIconSavedSensitivitySimulationScenario = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[9]/div[1]");

	// Start New Peer Analysis Button Scenario
	// Loading the Overview screen
	public void navigateTo() throws IOException, InterruptedException {
		driver.get(ConfigReader.cpa_overview());
		// Function waits till the Entire Overview Screen is getting loaded
		waitForElement(CPA_StartNewPeerAnalysisBtn);
		Thread.sleep(5000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/OverviewScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	// Start New Peer Analysis button

	public void startnewpeeranalysisbtn() throws IOException, InterruptedException {
		WebElement StartNewPeerAnalysisBtn = waitForElement(CPA_StartNewPeerAnalysisBtn);// Gets the button location
		StartNewPeerAnalysisBtn.click();
		System.out.println("--- Clicked: Start New Peer Analysis Button");
		// waits till the geographical map
		waitForElement(CPA_GeographicalMap);
		Thread.sleep(10000);
		// Verify whether it landed on the Customer Peer Analysis Card - Selections
		// -Branch/Customer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedbranchCustomerSelectionUrl = ConfigReader.cpa_branchCustomerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedbranchCustomerSelectionUrl)) {
			throw new AssertionError(
					"--- Not Landed on Branch/Customer Selection Screen by clicking on the Start New Peer Analysis Button --- Unexpected redirection :( !Current URL you're on: "
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
	// SearchField Saved Customer Peer Selections

	public void searchForKeyword_SCP() throws IOException, InterruptedException {
		WebElement SearchKeywordSavedPeerSelections = waitForElement(CPA_SearchKeywordSavedPeerSelections);

		SearchKeywordSavedPeerSelections.click();
		SearchKeywordSavedPeerSelections.clear();
		SearchKeywordSavedPeerSelections.sendKeys("Nagaraj");
		System.out.println("--- Searched: Keyword search was done");
		Thread.sleep(5000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/SearchKeywordSavedPeerSelections.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
		SearchKeywordSavedPeerSelections.click();
		SearchKeywordSavedPeerSelections.sendKeys(Keys.CONTROL + "a");
		SearchKeywordSavedPeerSelections.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		System.out.println("--- Searched: Keyword search has been cleared from the search field");

	}

	// Create Sensitivty scenario with selection
	public void createSensitivityScenarioBtnWithSelection() throws IOException, InterruptedException {
		// finds the first row of the table and clicks as the button gets activated
		WebElement SavedCustomerPeerTableFirstRow = waitForElement(CPA_SavedCustomerPeerTableFirstRow);
		// waits for the Create Sensitivity scenario btn to get load
		WebElement CreateSensitivityScenarioBtn = waitForElement(CPA_CreateSensitivityScenarioBtn);

		SavedCustomerPeerTableFirstRow.click();
		System.out.println("--- Clicked: Create Sensitivity Scenario Table first row");
		Thread.sleep(1000);

		// Clicks the Create Sensitivity Scenario button with selection
		CreateSensitivityScenarioBtn.click();
		System.out.println("--- Clicked: Create Sensitivity Scenario Button");
		Thread.sleep(5000);
		// Verify whether it landed on the Customer Peer Analysis Card - Scenario
		// Builder - Create Scenario
		String currentUrl = driver.getCurrentUrl();
		String expectedCreateScenarioUrl = ConfigReader.cpa_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedCreateScenarioUrl)) {
			throw new AssertionError(
					"--- Not Landed on Create Scenario Screen by clicking on the Create Sensitivity Scenario Button with selected record --- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

		Thread.sleep(2000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/CreateSensitivityScenarioBtnWithSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);

		driver.navigate().back(); // temporary but need to code for the flow till creation of scenario
		Thread.sleep(6000);

	}

	// Clicks the Create Sensitivity Scenario button without selection
	public void createSensitivityScenarioBtnWithoutSelection() throws IOException, InterruptedException {
		// waits for the Create Sensitivity scenario btn to get load
		WebElement CreateSensitivityScenarioBtn = waitForElement(CPA_CreateSensitivityScenarioBtn);
		// Clicks the Create Sensitivity Scenario button
		CreateSensitivityScenarioBtn.click();
		System.out.println("--- Clicked: Create Sensitivity Scenario Button without selecting a record");
//		WebElement ErrorWithoutSelectingRecord = waitForElement(); 
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiBox-root jss56431 jss831 jss55537']")));
//		Thread.sleep(3000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/CreateSensitivityScenarioBtnWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Thread.sleep(2000);
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
	public void editButtonPeerSelections() throws IOException, InterruptedException {
		// waits for the Create Sensitivity scenario btn to get load
		WebElement EditBtnPeerSelection = waitForElement(CPA_EditbtnSavedPeerSelections);
		// Clicks the Create Sensitivity Scenario button
		EditBtnPeerSelection.click();
		System.out.println("--- Clicked: Edit Button of Saved Customer Peer Selection table");
		Thread.sleep(10000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"node20822356576\"]/div[1]/form/div/div[6]/div/div/div[3]/table/tbody/tr[1]/td[1]"))); //Peer Selection all table and dropdown component
		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError(
					"--- Not Landed on Peer Selection screen even after clicking on the Eidt button of the Create Sensitivity Scenario table--- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/EditBtn_SavedPeerSelections.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clicking back button of Peer Selection -02 which then redirecting to the Peer
		// Selection - 01
//        WebElement PeerSelectionBtn_02 = waitForElement(CPA_PeerSelectionBackBtn_02);
//        PeerSelectionBtn_02.click();    
//        waitForElement(CPA_PeerSelectionBackBtn_01);

		driver.navigate().back();
		Thread.sleep(5000);
	}

	// Deleting the records

	public void deleteDropdownPeerSelections() throws IOException, InterruptedException {
		// Waits for the Delete Dropdown and clicks
		WebElement DeleteDropdownSavedPeerSelections = waitForElement(CPA_DeleteDropdownSavedPeerSelections);
		DeleteDropdownSavedPeerSelections.click();
		System.out.println("--- Clicked: Delete Dropdown of Saved Customer Peer Selection table");
		Thread.sleep(3000);
		// Waits for the delete option in the dropdown and clicks
		WebElement DeleteOptionsSavedPeerSelections = waitForElement(CPA_DeleteOptionsSavedPeerSelections);
		DeleteOptionsSavedPeerSelections.click();
		System.out.println("--- Clicked: Delete options of Saved Customer Peer Selection table");
		Thread.sleep(1000);
		// Take screenshot of the delete option selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteOption_SavedPeerSelections.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Waits for Delete Icon and clicks it
		WebElement DeleteIconSavedPeerSelections = waitForElement(CPA_DeleteIconSavedPeerSelections);
		DeleteIconSavedPeerSelections.click();
		System.out.println("--- Clicked: Delete Icon of Saved Customer Peer Selection table");
		Thread.sleep(2000);

	}

	// Delete Icon of Saved Customer Peer Selection table without setting to delete
	// option in the dropdown
	public void deleteIconPeerSelections() throws IOException, InterruptedException {
		// Waits for Delete Icon and clicks it
		WebElement DeleteIconSavedPeerSelections = waitForElement(CPA_DeleteIconSavedPeerSelections);
		DeleteIconSavedPeerSelections.click();
		System.out.println(
				"--- Clicked: Delete Icon of Saved Customer Peer Selection table without setting to delete option in the dropdown");
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIcon_SavedPeerSelections.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Download Icon of Saved Customer Peer Selection table
	public void downloadIconPeerSelections() throws IOException, InterruptedException {
		// Waits for Delete Icon and clicks it
		WebElement DownloadIconSavedPeerSelections = waitForElement(CPA_DownloadIconSavedPeerSelections);
		DownloadIconSavedPeerSelections.click();
		System.out.println("--- Clicked: Download Icon of Saved Customer Peer Selection table");
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIcon_SavedPeerSelections.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Pagination is a least priority
	public void paginationPeerSelection() throws IOException, InterruptedException {
	}

	// Search and select the record of Saved Customer Peer Selection table
	public void searchForRecord_SCP() throws IOException, InterruptedException {
		WebElement SearchKeywordSavedPeerSelections = waitForElement(CPA_SearchKeywordSavedPeerSelections);

		SearchKeywordSavedPeerSelections.click();
		SearchKeywordSavedPeerSelections.clear();
		SearchKeywordSavedPeerSelections.sendKeys("23299");
		System.out.println("--- Searched the Customer Peer Selection record: Customer ID 23299");
		Thread.sleep(1000);
		// Clearing the Search Keyword
		SearchKeywordSavedPeerSelections.click();
		SearchKeywordSavedPeerSelections.sendKeys(Keys.CONTROL + "a");
		SearchKeywordSavedPeerSelections.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Search the Saved Customer Peer Selection record
		WebElement SearchedRecordSavedPeerSelections = waitForElement(CPA_SearchedRecordSavedPeerSelections);
		SearchedRecordSavedPeerSelections.click();

	}

	// Saved Sensitivity Simulation Scenario table
	public void searchForKeyword_SSS() throws IOException, InterruptedException {
		WebElement SearchKeywordSavedSensitivitySimulation = waitForElement(
				CPA_SearchKeywordSavedSensitivitySimulation);
		// Scrolls to the Table
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",
				SearchKeywordSavedSensitivitySimulation);
		Thread.sleep(3000);
		SearchKeywordSavedSensitivitySimulation.click();
		SearchKeywordSavedSensitivitySimulation.clear();
		SearchKeywordSavedSensitivitySimulation.sendKeys("Nagaraj");
		System.out.println("--- Sensitivity Simulation Scenario: Searched: Keyword search was done");
		Thread.sleep(5000);
		// Take screenshot after the keyword is searched
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/SearchKeywordSavedSensitivitySimulationScenario.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Clearing the Search Keyword
		SearchKeywordSavedSensitivitySimulation.click();
		SearchKeywordSavedSensitivitySimulation.sendKeys(Keys.CONTROL + "a");
		SearchKeywordSavedSensitivitySimulation.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(5000);
		System.out
				.println("--- Sensitivity Simulation Scenario: Keyword search has been cleared from the search field");

	}

	// View Impact btn with records selection
	public void viewImpactBtnWithSelection() throws IOException, InterruptedException {
		// finds the first row of the table and clicks as the button gets activated
		WebElement SavedSensitivitySimluationTableFirstRow = waitForElement(
				CPA_SavedSensitivitySimluationTableFirstRow);
		// waits for the View Impact btn to get load
		WebElement ViewImpactBtn = waitForElement(CPA_ViewImpactBtn);

		// Scrolls to the View Impact button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",
				ViewImpactBtn);
		Thread.sleep(3000);

		SavedSensitivitySimluationTableFirstRow.click();
		System.out.println("--- Clicked: Saved Sensitivity Simluation Table first row");
		Thread.sleep(4000);

		// Clicks the Create Sensitivity Scenario button with selection
		ViewImpactBtn.click();
		System.out.println("--- Clicked: View Impact Button");
		Thread.sleep(5000);
		// Verify whether it landed on the Customer Peer Analysis Card - Scenario
		// Builder - Create Scenario
		String currentUrl = driver.getCurrentUrl();
		String expectedCreateScenarioUrl = ConfigReader.cpa_ScenarioImapct();

		if (!currentUrl.equalsIgnoreCase(expectedCreateScenarioUrl)) {
			throw new AssertionError(
					"--- Not Landed on View Scenario Impact Screen by clicking on the View Impact Button with selected record --- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

		Thread.sleep(2000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/ViewImpactWithSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);

		driver.navigate().back(); // temporary but need to code for the flow as some screen are not stable
		Thread.sleep(6000);

	}

	// View Impact btn without selecting the records
	public void viewImpactBtnWithOutSelection() throws IOException, InterruptedException {
		// waits for the View Impact btn to get load
		WebElement ViewImpactBtn = waitForElement(CPA_ViewImpactBtn);
		// Scrolls to the View Impact button
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",
				ViewImpactBtn);
		Thread.sleep(3000);
		// Clicks the View Scenario Impact button without selecting the record
		ViewImpactBtn.click();
		System.out.println("--- Clicked: View Impact Button without selecting a record");
		Thread.sleep(6000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/ViewImpactWithOutSelection.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Thread.sleep(2000);

	}

	// Edit Button - Saved Sensitivity Simulation Scenario
	public void editButtonScenarioSelections() throws IOException, InterruptedException {
		// waits for the Create Sensitivity scenario btn to get load
		WebElement EditbtnSavedSensitivitySimulationScenario = waitForElement(
				CPA_EditbtnSavedSensitivitySimulationScenario);
		// Clicks the Create Sensitivity Scenario button
		EditbtnSavedSensitivitySimulationScenario.click();
		System.out.println("--- Clicked: Edit Button of Saved Customer Peer Selection table");
		Thread.sleep(10000);
		// Verify whether it landed on the Customer Peer Analysis Card - Scenario
		// Builder - Create Scenario
		String currentUrl = driver.getCurrentUrl();
		String expectedScenarioSelectionUrl = ConfigReader.cpa_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedScenarioSelectionUrl)) {
			throw new AssertionError(
					"--- Not Landed on Create Scenario Screen even after clicking on the Edit button of the Saved Sensitivity Simulation Scenario table--- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/EditBtn_SavedSenstivitiySimulationScenario.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Redirection is pending due to screen break

		driver.navigate().back();
		Thread.sleep(5000);
	}

	// Delete Icon of Saved Sensitivity Simulation Scenario table with setting to
	// delete option in the dropdown
	public void deleteDropdownScenarioSelections() throws IOException, InterruptedException {
		// Waits for the Delete Dropdown and clicks
		WebElement DeleteDropdownSavedSensitivitySimulationScenario = waitForElement(
				CPA_DeleteDropdownSavedSensitivitySimulationScenario);
		DeleteDropdownSavedSensitivitySimulationScenario.click();
		System.out.println("--- Clicked: Delete Dropdown of Saved Sensitivity Simulation Scenario table");
		Thread.sleep(3000);
		// Waits for the delete option in the dropdown and clicks
		WebElement DeleteOptionsSavedSensitivitySimulationScenario = waitForElement(
				CPA_DeleteOptionsSavedSensitivitySimulationScenario);
		DeleteOptionsSavedSensitivitySimulationScenario.click();
		System.out.println("--- Clicked: Delete options of Saved Sensitivity Simulation Scenario table");
		Thread.sleep(1000);
		// Take screenshot of the delete option selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteOption_SavedSenstivitiySimulationScenario.png");
		FileHandler.copy(sourcefile, screenshotPath);

		// Waits for Delete Icon and clicks it
		WebElement DeleteIconSavedSensitivitySimulationScenario = waitForElement(
				CPA_DeleteIconSavedSensitivitySimulationScenario);
		DeleteIconSavedSensitivitySimulationScenario.click();
		System.out.println("--- Clicked: Delete Icon of Saved Sensitivity Simulation Scenario table");
		Thread.sleep(2000);

	}

	// Delete Icon of Saved Customer Peer Selection table without setting to delete
	// option in the dropdown
	public void deleteIconScenarioSelections() throws IOException, InterruptedException {
		// Waits for Delete Icon and clicks it
		WebElement DeleteIconSavedSensitivitySimulationScenario = waitForElement(
				CPA_DeleteIconSavedSensitivitySimulationScenario);
		DeleteIconSavedSensitivitySimulationScenario.click();
		System.out.println(
				"--- Clicked: Delete Icon of Saved Sensitivity Simulation Scenario table without setting to delete option in the dropdown");
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIcon_SavedSenstivitiySimulationScenario.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Download Icon of Saved Sensitivity Simulation Scenario table
	public void downloadIconScenarioSelections() throws IOException, InterruptedException {
		// Waits for Download Icon and clicks it
		WebElement DownloadIconSavedSensitivitySimulationScenario = waitForElement(
				CPA_DownloadIconSavedSensitivitySimulationScenario);
		DownloadIconSavedSensitivitySimulationScenario.click();
		System.out.println("--- Clicked: Download Icon of Saved Sensitivity Simulation Scenario table");
		Thread.sleep(2000);
		// Take screenshot of the delete icon selection
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Overview/DeleteIcon_SavedSenstivitiySimulationScenario.png");
		FileHandler.copy(sourcefile, screenshotPath);

	}

	// Search and select the record of Saved Sensitivity Simulation Scenario table
	public void searchForRecord_SSS() throws IOException, InterruptedException {
		// Search keyword
		WebElement SearchKeywordSavedSensitivitySimulation = waitForElement(
				CPA_SearchKeywordSavedSensitivitySimulation);
		// Search the Saved Customer Peer Selection record
		WebElement SearchedRecordSavedSensitivitySimulation = waitForElement(
				CPA_SearchedRecordSavedSensitivitySimulation);
		By CPA_Scroller = By.xpath(
				"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div");
		WebElement Scroller = waitForElement(CPA_Scroller);
		// Scrolls to the Table
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", Scroller,
				SearchedRecordSavedSensitivitySimulation);
		Thread.sleep(3000);
		SearchKeywordSavedSensitivitySimulation.click();
		SearchKeywordSavedSensitivitySimulation.clear();
		SearchKeywordSavedSensitivitySimulation.sendKeys("390338");
		System.out.println("--- Searched the Customer Peer Selection record: Customer ID 390338");
		Thread.sleep(5000);
		// Clearing the Search Keyword
		SearchKeywordSavedSensitivitySimulation.click();
		SearchKeywordSavedSensitivitySimulation.sendKeys(Keys.CONTROL + "a");
		SearchKeywordSavedSensitivitySimulation.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		// Search and Select the record
		SearchedRecordSavedSensitivitySimulation.click();

	}

}
