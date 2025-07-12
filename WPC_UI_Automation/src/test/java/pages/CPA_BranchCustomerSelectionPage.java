package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class CPA_BranchCustomerSelectionPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public CPA_BranchCustomerSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // ✅ wait initialized once
		actions = new Actions(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Normal path of the Map
	By CPA_GeographicalMap = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div");

	// Geographical Map - This is xpath of on the map and not the entire div tag
//    By CPA_GeographicalMap = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][8]/*[name()='g'][1]/*[name()='g'][1]/*[name()='rect'][1]");
	// Filter button
	By CPA_Filters = By.xpath("//*[@id=\"capture-screen\"]/div[1]/div/header/div/div/button");
	// Filters - Region (select the options 01,12 ---Absolute Xpath
	By CPA_Filters_Regions = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div[1]/div/div[1]/div");
	// Filters- Regions - 02 options
	By CPA_Filters_Regions_02 = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div/fieldset/div/label[3]/span[1]/span[1]/input");
	// Filters- Regions - 02 options
	By CPA_Filters_Regions_12 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/label[8]/span[2]/div[1]/span[1]");
	// Filters- Order Channel (Branch, CDC)
	By CPA_Filters_OrderChannel = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[8]/div[1]/span[1]");
	// Filters - Order Channel - All option as it un-checks all other options
	By CPA_Filters_OrderChannel_All = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/label[1]/span[2]/div[1]/span[1]");
	// Filter- Order Channel - Branch
	By CPA_Filters_OrderChannel_Branch = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/label[2]/span[2]/div[1]");
	// Filters - Apply button
	By CPA_Filters_ApplyBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]");
	// Select Metric - Dropdown
	By CPA_SelectMetric_Dropdown = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");
	// Select Metric - Dropdown Option selection - Returns (Handling)
	By CPA_SelectMetric_Dropdown_Options = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[4]/div[1]");
	// Select branch (bubble) from the Geographical Map
	// By CPA_SelectBranch_Map = By.xpath("");
	// Select branch - Dropdown
	By CPA_SelectBranch_Dropdown = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	// Select branch - Dropdown options - BRIS
	By CPA_SelectBranch_Dropdown_Options_BRIS = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[2]");
	// Select branch - Dropdown options - ENRG
	By CPA_SelectBranch_Dropdown_Options_ENRG = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[7]");
	// Select branch - Dropdown - Search bar
	By CPA_SelectBranch_Dropdown_Searchbar = By
			.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/div[1]/div[1]/div[1]/input[1]");
	// Select branch - Dropdown - Searchbar options - C243
	By CPA_SelectBranch_Dropdown_Searchbar_Options_C243 = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[2]");
	// Select branch(es) - Text
	By CPA_SelectBranch_Text = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/h4[1]");
	// Analyze button
	By CPA_AnalyzeBtn = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[3]/div/div[2]/div[2]/div/button");
	// Customer Selection plot
	By CPA_CustomerSelectionPlot = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
	// Customer Selection plot - Dropdown
	By CPA_CustomerSelectionPlot_Dropdown = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]");
	// Customer Selection plot - Options - 100966_Ravex Systems,INC
	By CPA_CustomerSelectionPlot_Dropdown_Options_100966 = By.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[1]");
	// Customer Selection plot - Options - 129932 Synergy Electrical Systems
	By CPA_CustomerSelectionPlot_Dropdown_Options_129932 = By.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[9]");
	// Customer Selection plot - Options - 138999 Rogers Electric
	By CPA_CustomerSelectionPlot_Dropdown_Options_138999 = By.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[18]");
	// Customer Selection plot - Search Bar
	By CPA_CustomerSelectionPlot_Searchbar = By
			.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/div[1]/div[1]/div[1]/input[1]");
	// Customer Selection plot - Search Bar Options 105097_HARP HOME SERVICS LLC
	By CPA_CustomerSelectionPlot_Searchbar_Options_105097 = By.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[1]");
	// Customer Selection plot - Save Customers Button
	By CPA_CustomerSelectionPlot_SaveCustomersBtn = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]/span[1]");
	// Peer Selection - Table row path
	By CPA_PeerSelectionTableRow = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/div[1]");

	// Navigating to the Branch/Customer screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Branch Customer Selection Screen
		driver.get(ConfigReader.cpa_branchCustomerSelection());
		// Function waits till the Entire Overview Screen is getting loaded
		waitForElement(CPA_GeographicalMap);
		System.out.println("--- Loaded Screen along with the Geographical map");
		Thread.sleep(5000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/BranchCustomerSelectionScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Customer Peer Analysis Card - Selections
		// -Branch/Customer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedbranchCustomerSelectionUrl = ConfigReader.cpa_branchCustomerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedbranchCustomerSelectionUrl)) {
			throw new AssertionError(
					"--- Not Landed on Branch/Customer Selection Screen by clicking on the Start New Peer Analysis Button --- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

	}

	// This is to click on Filters and select options as per needed
	public void FiltersTo() throws IOException, InterruptedException {
		// Get initial map bubble count BEFORE applying filters
		List<WebElement> bubblesBeforeFilter = driver.findElements(By.xpath(
				"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"));
		int initialBubbleCount = bubblesBeforeFilter.size();
		// 🔽 ADD THIS: Logging pre-filter bubbles
//		logBubbleDetails(bubblesBeforeFilter, "bubbles_before_filter.csv");
		System.out.println("--- Bubble count before applying filters: " + initialBubbleCount);
		// Xpath for the Filters button
		WebElement FiltersCustomerPeerSelections = waitForElement(CPA_Filters);
		FiltersCustomerPeerSelections.click();
		System.out.println("--- The Filters button is clicked");
		Thread.sleep(2000);
		// Xpath for the Filters Regions options
		WebElement FitlersRegionsCustomerPeerSelections = waitForElement(CPA_Filters_Regions);
		FitlersRegionsCustomerPeerSelections.click();
		System.out.println("--- Filters - Region option is clicked");
		Thread.sleep(7000);
		// Specifying the regions options
		// For Region-02
//		waitForElement(CPA_Filters_Regions_02);
		// For Region-12
		WebElement FiltersRegions_12 = waitForElement(CPA_Filters_Regions_12);
		Thread.sleep(3000);
		FiltersRegions_12.click();
		System.out.println("--- The Filters - Regions options is clicked and selected the option 12");
		Thread.sleep(7000);
		// Xpath for the Order channel options
		WebElement FiltersOrderChannelCustomerPeerSelections = waitForElement(CPA_Filters_OrderChannel);
		// This will navigate to the Order Channel Filter
		actions.moveToElement(FiltersOrderChannelCustomerPeerSelections).click().perform();
//		FiltersOrderChannelCustomerPeerSelections.click();
		System.out.println("--- The Filters button - Order Channel option is clicked");
		Thread.sleep(2000);
		// Un-checking the ALL option so the user can select other options
		WebElement FilterOrderChannel_All = waitForElement(CPA_Filters_OrderChannel_All);
		FilterOrderChannel_All.click();
		System.out.println("--- The Filters button - Order Channel - All option is Unchecked");
		waitForElement(CPA_Filters_OrderChannel_All);
		Thread.sleep(9000);
		// For the Order Channel - Branch option selection
		WebElement FilterOrderChannel_Branch = waitForElement(CPA_Filters_OrderChannel_Branch);
		FilterOrderChannel_Branch.click();
		System.out.println("--- The Filters button - Order Channel - Branch option is clicked");
		waitForElement(CPA_Filters_OrderChannel_Branch);

//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("jss1267")));
		// Click the Apply button
		WebElement Filters_ApplyBtn = waitForElement(CPA_Filters_ApplyBtn);
		Filters_ApplyBtn.click();
		System.out.println("--- Filters: Apply button is clicked and the screen is loaded with new filters");
		Thread.sleep(3000);
		waitForElement(CPA_GeographicalMap);

		// Screenshot of the Filter - Regions - Options
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/Filters_Options.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Get bubble count AFTER applying filters
		List<WebElement> bubblesAfterFilter = driver.findElements(By.xpath(
				"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"));
		int postBubbleCount = bubblesAfterFilter.size();
		System.out.println("--- Bubble count after applying filters: " + postBubbleCount);
		// 🔽 ADD THIS: Logging post-filter bubbles
//		logBubbleDetails(bubblesAfterFilter, "bubbles_after_filter.csv");

		// Compare counts
		if (postBubbleCount == 0) {
			throw new AssertionError(
					"--- Map did not update or no bubbles found after filter. Please verify the filters.");
		}
		if (initialBubbleCount == postBubbleCount) {
			throw new AssertionError(
					"--- Filter application did not affect map bubbles. Both counts are same: " + postBubbleCount);
		}

		System.out.println("--- Filter applied successfully and map updated with new bubbles.");

	}

//	private void logBubbleDetails(List<WebElement> bubbles, String fileName) {
//		try {
//			FileWriter writer = new FileWriter("src/test/resources/debug/" + fileName);
//			writer.write("Index,d,fill,transform,tooltip\n");
//			int i = 1;
//			for (WebElement bubble : bubbles) {
//				writer.write(i + "," + "\"" + safeAttr(bubble, "d") + "\"," + "\"" + safeAttr(bubble, "fill") + "\","
//						+ "\"" + safeAttr(bubble, "transform") + "\"," + "\"" + safeAttr(bubble, "aria-label")
//						+ "\"\n");
//				i++;
//			}
//			writer.close();
//			System.out.println("--- Bubble log written to: " + fileName);
//		} catch (IOException e) {
//			System.err.println("Error writing bubble debug log: " + e.getMessage());
//		}
//	}

	// Safely get attributes without null issues
//	private String safeAttr(WebElement element, String attr) {
//		String val = element.getAttribute(attr);
//		return val == null ? "" : val.replace("\"", "'");
//	}

//	public void FiltersTo() throws IOException, InterruptedException {
//		// Step 1: Get initial map bubble count BEFORE applying filters
//		List<WebElement> bubblesBeforeFilter = driver.findElements(By.xpath(
//				"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"));
//		int initialBubbleCount = bubblesBeforeFilter.size();
//		System.out.println("--- Bubble count before applying filters: " + initialBubbleCount);
//
//		// Step 2: Click Filters
//		waitForElement(CPA_Filters).click();
//		System.out.println("--- Clicked Filters");
//		Thread.sleep(2000);
//
//		// Step 3: Select Region
//		waitForElement(CPA_Filters_Regions).click();
//		System.out.println("--- Clicked Region filter");
//		Thread.sleep(2000);
//		waitForElement(CPA_Filters_Regions_12).click();
//		System.out.println("--- Selected Region 12");
//
//		// Step 4: Select Order Channel - Branch
//		WebElement orderChannel = waitForElement(CPA_Filters_OrderChannel);
//		actions.moveToElement(orderChannel).click().perform();
//		System.out.println("--- Clicked Order Channel");
//		Thread.sleep(2000);
//
//		waitForElement(CPA_Filters_OrderChannel_Branch_All).click(); // Uncheck all
//		System.out.println("--- Deselected All options");
//
//		waitForElement(CPA_Filters_OrderChannel_Branch).click(); // Select Branch
//		System.out.println("--- Selected Branch");
//
//		// Step 5: Click Apply
//		waitForElement(CPA_Filters_ApplyBtn).click();
//		System.out.println("--- Clicked Apply");
//		Thread.sleep(5000); // Allow map to load new bubbles
//
//		waitForElement(CPA_GeographicalMap);
//
//		// Step 6: Get bubble count AFTER applying filters
//		List<WebElement> bubblesAfterFilter = driver.findElements(By.xpath(
//				"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"));
//		int postBubbleCount = bubblesAfterFilter.size();
//		System.out.println("--- Bubble count after applying filters: " + postBubbleCount);
//
//		// Step 7: Compare counts
//		if (postBubbleCount == 0) {
//			throw new AssertionError("--- Map did not update or no bubbles found after filter. Please verify filters.");
//		}
//		if (initialBubbleCount == postBubbleCount) {
//			throw new AssertionError(
//					"--- Filter application did not affect map bubbles. Both counts are same: " + postBubbleCount);
//		}
//
//		System.out.println("--- Filter applied successfully and map updated with new bubbles.");
//
//		// Step 8: Screenshot for documentation
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/Filters_Options.png");
//		FileHandler.copy(sourcefile, screenshotPath);
//	}

	// Select Metric - dropdown
	public void SelectMetric() throws IOException, InterruptedException {
		// Clicking the Select Metric Dropdown
		WebElement SelectMetric_Dropdown = waitForElement(CPA_SelectMetric_Dropdown);
		SelectMetric_Dropdown.click();
		System.out.println("--- Clicked the Select Metric Dropdown");
		Thread.sleep(5000);
		// Clicking the Metric options
		WebElement SelectMetric_Dropdown_Options = waitForElement(CPA_SelectMetric_Dropdown_Options);
		new Actions(driver).moveToElement(SelectMetric_Dropdown_Options).click().perform(); // This line is added for
																							// the hovering effect
		System.out.println("--- Selected the Return (Handling) Metric from the options");
		Thread.sleep(5000);
		// Screenshot of the Select Metric options
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/Metric_Options.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}
	// No high priority -- Clicks on the Zoom icons + and -
//  	public void ClicksOnZoomIcons() throws IOException, InterruptedException  {}

	// Branch selection from the Geographical Map
//  	public void SelectBranchMap() throws IOException, InterruptedException {
//  		//WebElement GeographicalMap = waitForElement(CPA_GeographicalMap);
//  		List<WebElement> allBubbles = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][8]/*[name()='g'][1]/*[name()='g'][1]/*[name()='rect'][1]"));
//  		System.out.println("Total bubbles found: " + allBubbles.size());
//  		if (!allBubbles.isEmpty()) {
//  		    allBubbles.get(0).click();  // or loop to click all
//  		    System.out.println("Clicked the first bubble.");
//  		}

	// Select Branch Dropdown -- Scenario
	public void SelectBranchDropdown() throws IOException, InterruptedException {
		// Select Branch from Dropdown
		WebElement SelectBranch_Dropdown = waitForElement(CPA_SelectBranch_Dropdown);
		SelectBranch_Dropdown.click();
		System.out.println("--- Clicked - Select Branch Dropdown");
		Thread.sleep(2000);
		// Select Branch - Dropdown Options - BRIS
		WebElement SelectBranch_Dropdown_Options_BRIS = waitForElement(CPA_SelectBranch_Dropdown_Options_BRIS);
		SelectBranch_Dropdown_Options_BRIS.click();
		System.out.println("--- Clicked - Select Branch Dropdown Options - BRIS");
		Thread.sleep(3000);
		// Select Branch - Dropdown Options - ENRG
		WebElement SelectBranch_Dropdown_Options_ENRG = waitForElement(CPA_SelectBranch_Dropdown_Options_ENRG);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",
				SelectBranch_Dropdown_Options_ENRG);
		SelectBranch_Dropdown_Options_ENRG.click();
		System.out.println("--- Clicked - Select Branch Dropdown Options - ENRG");
		Thread.sleep(4000);
		// Select Branch - Dropdown - Search bar
		WebElement SelectBranch_Dropdown_Searchbar = waitForElement(CPA_SelectBranch_Dropdown_Searchbar);
		SelectBranch_Dropdown_Searchbar.click();
		SelectBranch_Dropdown_Searchbar.clear();
		// Searching the Branch by Branch ID C243
		SelectBranch_Dropdown_Searchbar.sendKeys("C243");
		Thread.sleep(4000);
		WebElement SelectBranch_Dropdown_Searchbar_Options_C243 = waitForElement(
				CPA_SelectBranch_Dropdown_Searchbar_Options_C243);
		SelectBranch_Dropdown_Searchbar_Options_C243.click();
		System.out.println("--- Searched and Clicked - Select Branch Dropdown Options - C243");
		Thread.sleep(4000);
		SelectBranch_Dropdown_Searchbar.clear();
		Thread.sleep(5000);
		// This is used to come out of the dropdown overlay effect and click the next
		// locators
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 10).click().build().perform();
		Thread.sleep(5000);
		// Screenshot of the Metric options
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/Branch_Dropdown_Options.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	// Click the Analyze button
	public void ClickAnalyze() throws IOException, InterruptedException {
		// Analyze button
		WebElement AnalyzeBtn = waitForElement(CPA_AnalyzeBtn);
		AnalyzeBtn.click();
		System.out.println("--- Clicked - Analyze button");
		// waits for the Customers Plot
		waitForElement(CPA_CustomerSelectionPlot);
		Thread.sleep(2000);
	}

	// Selects Customers from the Dropdown and Plot
	public void CustomerSelectionPlot() throws IOException, InterruptedException {
		// To store the BILL TO ID's
		List<String> selectedBillToID = new ArrayList<>();
		// Customer Selection Plot - Dropdown
		WebElement CustomerSelectionPlot_Dropdown = waitForElement(CPA_CustomerSelectionPlot_Dropdown);
		CustomerSelectionPlot_Dropdown.click();
		System.out.println("--- Clicked - Customer Selection Dropdown");
		Thread.sleep(2000);
		// CustomerSelectionPlot_Dropdown_Options_100966
		WebElement CustomerSelectionPlot_Dropdown_Options_100966 = waitForElement(
				CPA_CustomerSelectionPlot_Dropdown_Options_100966);
		// Stores the BILL To ID - 100966
		selectedBillToID.add(CustomerSelectionPlot_Dropdown_Options_100966.getText().split("_")[0]); // Extracts only
																										// the BILL To
																										// ID from the
																										// entire
																										// customer name
		CustomerSelectionPlot_Dropdown_Options_100966.click();
		System.out.println("--- Clicked - Customer Selection Dropdown Options --- 100966");
		Thread.sleep(3000);
		// CustomerSelectionPlot_Dropdown_Options_129932
		WebElement CustomerSelectionPlot_Dropdown_Options_129932 = waitForElement(
				CPA_CustomerSelectionPlot_Dropdown_Options_129932);
		// Stores the BILL To ID - 129932
		selectedBillToID.add(CustomerSelectionPlot_Dropdown_Options_129932.getText().split("_")[0]);
		CustomerSelectionPlot_Dropdown_Options_129932.click();
		System.out.println("--- Clicked - Customer Selection Dropdown Options --- 129932");
		Thread.sleep(3000);
		// CustomerSelectionPlot_Dropdown_Options_138999
		WebElement CustomerSelectionPlot_Dropdown_Options_138999 = waitForElement(
				CPA_CustomerSelectionPlot_Dropdown_Options_138999);
		// Stores the BILL To ID - 138999
		selectedBillToID.add(CustomerSelectionPlot_Dropdown_Options_138999.getText().split("_")[0]);
		CustomerSelectionPlot_Dropdown_Options_138999.click();
		System.out.println("--- Clicked - Customer Selection Dropdown Options --- 138999");
		Thread.sleep(3000);
		// CustomerSelectionPlot_SearchBar
		WebElement CustomerSelectionPlot_Searchbar = waitForElement(CPA_CustomerSelectionPlot_Searchbar);
		CustomerSelectionPlot_Searchbar.click();
		CustomerSelectionPlot_Searchbar.clear();
		// Searching the Customer by Customer ID 105097
		CustomerSelectionPlot_Searchbar.sendKeys("105097");
		Thread.sleep(3000);
		WebElement CustomerSelectionPlot_Searchbar_Options_105097 = waitForElement(
				CPA_CustomerSelectionPlot_Searchbar_Options_105097);
		// Stores the BILL To ID - 105097
		selectedBillToID.add(CustomerSelectionPlot_Searchbar_Options_105097.getText().split("_")[0]);
		CustomerSelectionPlot_Searchbar_Options_105097.click();
		System.out.println("--- Searched and Clicked - Customer Select Plot Dropdown Options - 105097");
		Thread.sleep(4000);
		CustomerSelectionPlot_Searchbar.clear();
		Thread.sleep(5000);
		// This is used to come out of the dropdown overlay effect and click the next
		// locators
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 10).click().build().perform();
		Thread.sleep(3000);
		// Screenshot of the Customer Selection Plot Options
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/CustomerSelectionPlot_Dropdown_Options.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// CustomerSelectionPlot_SaveCustomersBtn
		WebElement CustomerSelectionPlot_SaveCustomersBtn = waitForElement(CPA_CustomerSelectionPlot_SaveCustomersBtn);
		CustomerSelectionPlot_SaveCustomersBtn.click();
		System.out.println("--- Clicked - Save Customer Button of the Customer Selection Plot");
		waitForElement(CPA_PeerSelectionTableRow);
		Thread.sleep(8000);
		// Stored BILL To ID's
		System.out.println("Selected Customer IDs: " + selectedBillToID);
		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection Screen
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError(
					"--- Not Landed on Peer Selection Screen by clicking on the Save Customers Button of the Customer Selection Plot --- Unexpected redirection :( !Current URL you're on: "
							+ currentUrl);
		}

		// Extract BILL TO IDs from Peer Selection table
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<String> billToIds = new ArrayList<>();

		for (WebElement row : rows) {
			String billToId = row.findElement(By.xpath("td[2]")).getText().trim();
			billToIds.add(billToId);
		}

		System.out.println("--- Extracted BILL TO IDs from Peer Selection table: " + billToIds);

		// Compare both the list
		for (String id : selectedBillToID) {
			if (!billToIds.contains(id)) {
				throw new AssertionError("--- BILL TO ID " + id + " is missing in the Peer Selection table.");
			}
		}

		System.out.println("--- All selected customers are present in the Peer Selection table.");

	}

}
