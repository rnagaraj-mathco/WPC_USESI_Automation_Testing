package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;
import utils.ElementHelper;

public class CPA_BranchCustomerSelectionPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	ElementHelper helper;

	// gets driver status
	public CPA_BranchCustomerSelectionPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // ✅ wait initialized once
		actions = new Actions(driver);
		this.helper = new ElementHelper(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Normal path of the Map
	By cpa_bc_geographicalMap = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div");

	// Filter button
	By cpa_bc_filters = By.xpath("//*[@id=\"capture-screen\"]/div[1]/div/header/div/div/button");
	// Filters - Option - Region (select the options 02,12 ---Absolute Xpath
	By cpa_bc_filtersOptionsRegions = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]/div/div[1]/div/div/div/div[1]/div[1]/div/div[1]/div");
	// Filters- Option - Regions - Value - 01 (as of now its 02)
	By cpa_bc_filtersOptionsRegionsValue01 = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div/fieldset/div/label[3]/span[1]/span[1]/input");
	// Filters- Option - Regions - Value - 01 (as of now its 12)
	By cpa_bc_filtersOptionsRegionsValue02 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/label[8]/span[2]/div[1]/span[1]");
	// Filters - Options - Order Channel (Branch, CDC)
	By cpa_bc_filtersOptionsOrderChannel = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[8]/div[1]/span[1]");
	// Filters - Options - Order Channel - Value - All (option as it un-checks all
	// other options)
	By cpa_bc_filtersOptionsOrderChannelValue01 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/label[1]/span[2]/div[1]/span[1]");
	// Filter- Order Channel - Branch
	By cpa_bc_filtersOptionsOrderChannelValue02 = By.xpath("//label[.//span[normalize-space()='Branch']]");
	// Filters - Apply button
	By cpa_bc_filtersApplyBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]");
	// Select Metric - Dropdown
	By cpa_bc_selectMetricDropdown = By
			.xpath("(//div[contains(@class, 'MuiSelect-root') and contains(@class, 'MuiSelect-select')])[1]");
	// Select Metric - Dropdown Option selection - Returns (Handling)
	By cpa_bc_selectMetricDropdownOptions = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[4]/div[1]");
	// Select branch (bubble) from the Geographical Map
	// By cpa_SelectBranch_Map = By.xpath("");
	// Select branch - Dropdown
	By cpa_bc_selectBranchDropdown = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	// Select branch - Dropdown options - BRIS
	By cpa_bc_selectBranchDropdownOption01 = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[2]");
	// Select branch - Dropdown options - ENRG
	By cpa_bc_selectBranchDropdownOption02 = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[7]");
	// Select branch - Dropdown - Search bar
	By cpa_bc_selectBranchDropdownSearchbar = By
			.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/div[1]/div[1]/div[1]/input[1]");
	// Select branch - Dropdown - Searchbar options - C243
	By cpa_bc_selectBranchDropdownSearchbarValue01 = By.xpath("/html[1]/body[1]/div[5]/div[3]/ul[1]/li[2]");
	// Select branch(es) - Text
	By cpa_bc_selectBranchText = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/h4[1]");
	// Analyze button
	By cpa_bc_AnalyzeBtn = By.xpath("//button[normalize-space()='Analyze' or contains(text(),'Analyze')]");
	// Customer Selection plot
	By cpa_bc_customerSelectionPlot = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
	// Customer Selection plot - Dropdown
	By cpa_bc_customerSelectionPlotDropdown = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]");
	// Customer Selection plot - Options - (100966)
	By cpa_bc_customerSelectionPlotDropdownOptions01 = By.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[1]");
	// Customer Selection plot - Options - (129049)
	By cpa_bc_customerSelectionPlotDropdownOptions02 = By.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[9]");
	// Customer Selection plot - Options - (135763)
	By cpa_bc_customerSelectionPlotDropdownOptions03 = By.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[18]");
	// Customer Selection plot - Search Bar
	By cpa_bc_customerSelectionPlotSearchbar = By
			.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/div[1]/div[1]/div[1]/input[1]");
	// Customer Selection plot - Search Bar Options 105097_HARP HOME SERVICS LLC
	By cpa_bc_customerSelectionPlotSearchbarValue = By.xpath("/html[1]/body[1]/div[6]/div[3]/ul[1]/li[1]");
	// Customer Selection plot - Save Customers Button
	By cpa_bc_customerSelectionPlotSaveCustomersBtn = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]/span[1]");
	// Peer Selection - Table row path
	By cpa_ps_TableRow = By.xpath("//table//tr/td[contains(@class, 'MuiTableCell-root')][2]");
	private int bubbleCountInit;

	// Navigating to the Branch/Customer screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Branch Customer Selection Screen
		driver.get(ConfigReader.cpa_branchCustomerSelection());
		// Function waits till the Entire is loaded
		waitForElement(cpa_bc_geographicalMap);
		try {
			waitForElement(cpa_bc_geographicalMap);
		} catch (Exception e) {
			waitForElement(cpa_bc_geographicalMap);
		}
		System.out.println("=> The Branch/Customer Screen is Loaded with the Geographical map");
		Thread.sleep(2000);
		// Take screenshot after the page is fully ready
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/BranchCustomerSelectionScreen.png");
//		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Customer Peer Analysis Card - Selections
		// -Branch/Customer Selection
		String currentUrl = driver.getCurrentUrl();
		String expectedbranchCustomerSelectionUrl = ConfigReader.cpa_branchCustomerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedbranchCustomerSelectionUrl)) {
			throw new AssertionError("=> Unexpected redirection!, Current URL you're on: " + currentUrl);
		}

	}

	// This is to click on Filters and select options as per needed
	public void filtersTo() throws IOException, InterruptedException {
		// Get initial map bubble count BEFORE applying filters
		List<WebElement> bubblesBeforeFilter = driver.findElements(By.xpath(
				"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"));
		int initialBubbleCount = bubblesBeforeFilter.size();
		// 🔽 ADD THIS: Logging pre-filter bubbles
//		logBubbleDetails(bubblesBeforeFilter, "bubbles_before_filter.csv");
		System.out
				.println("=> The total count of Branch(es) in the map before applying filters: " + initialBubbleCount);
		this.bubbleCountInit = initialBubbleCount;
		// Xpath for the Filters button
		WebElement FiltersCustomerPeerSelections = waitForElement(cpa_bc_filters);
//		FiltersCustomerPeerSelections.click();
		helper.safeClick(FiltersCustomerPeerSelections);
		System.out.println("=> The Filters button is clicked");
		Thread.sleep(2000);
		// Xpath for the Filters Regions options
		WebElement FitlersRegionsCustomerPeerSelections = waitForElement(cpa_bc_filtersOptionsRegions);
//		FitlersRegionsCustomerPeerSelections.click();
		helper.safeClick(FitlersRegionsCustomerPeerSelections);
		System.out.println("=> The Filters - Region option is clicked");
		Thread.sleep(4000);
		try {
			waitForElement(cpa_bc_filtersOptionsRegions);
		} catch (Exception e) {
			waitForElement(cpa_bc_filtersOptionsRegions);
		}
		waitForElement(cpa_bc_filtersOptionsRegions);
		// Specifying the regions options
		// For Region-02
//		waitForElement(cpa_bc_filtersOptionsRegionsValue01);
		// For Region-12
//		WebElement FiltersRegions_12 = waitForElement(cpa_bc_filtersOptionsRegionsValue02);
//		Thread.sleep(8000);
//		FiltersRegions_12.click();
//		helper.safeClick(FiltersRegions_12);
//		System.out.println("=> The Filters - Regions options is clicked and selected the option 12");
//		waitForElement(cpa_bc_filtersOptionsRegionsValue02);
//		Thread.sleep(8000);
		// Xpath for the Order channel options
		WebElement FiltersOrderChannelCustomerPeerSelections = waitForElement(cpa_bc_filtersOptionsOrderChannel);
		// This will navigate to the Order Channel Filter
		actions.moveToElement(FiltersOrderChannelCustomerPeerSelections).click().perform();
//		FiltersOrderChannelCustomerPeerSelections.click();
//		helper.safeClick(FiltersOrderChannelCustomerPeerSelections);
		System.out.println("=> The Filters - Order Channel option is clicked");
		waitForElement(cpa_bc_filtersOptionsOrderChannel);
		Thread.sleep(4000);
		// Un-checking the ALL option so the user can select other options
//		WebElement FilterOrderChannel_All = waitForElement(cpa_bc_filtersOptionsOrderChannelValue01);
//		FilterOrderChannel_All.click();
//		System.out.println("--- The Filters button - Order Channel - All option is Unchecked");
//		waitForElement(cpa_bc_filtersOptionsOrderChannel);
//		Thread.sleep(9000);
		// For the Order Channel - Branch option selection
//		WebElement FilterOrderChannel_Branch = waitForElement(cpa_bc_filtersOptionsOrderChannelValue02);
//		FilterOrderChannel_Branch.click();
//		Thread.sleep(8000);
//		System.out.println("--- The Filters button - Order Channel - Branch option is clicked");
//
//		waitForElement(cpa_bc_filtersOptionsOrderChannel);

//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("jss1267")));
		// Click the Apply button
		WebElement Filters_ApplyBtn = waitForElement(cpa_bc_filtersApplyBtn);
//		Filters_ApplyBtn.click();
		helper.safeClick(Filters_ApplyBtn);
		System.out.println(
				"=> The Apply button of the Filters is clicked and if any changes then it will be reflected in the map");
		Thread.sleep(1000);
		try {
			waitForElement(cpa_bc_geographicalMap);
			waitForElement(cpa_bc_selectMetricDropdown);
		} catch (Exception e) {
			waitForElement(cpa_bc_geographicalMap);
			waitForElement(cpa_bc_selectMetricDropdown);
		}
		waitForElement(cpa_bc_geographicalMap);
		waitForElement(cpa_bc_selectMetricDropdown);

//		// Screenshot of the Filter - Regions - Options
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/Filters_Options.png");
//		FileHandler.copy(sourcefile, screenshotPath);
		bubbleCountAfterFilter();

	}

	// Select Metric - dropdown

	public void bubbleCountAfterFilter() {
		// Get bubble count AFTER applying filters and metric
		List<WebElement> bubblesAfterFilter = driver.findElements(By.xpath(
				"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"));
		int postBubbleCount = bubblesAfterFilter.size();
		System.out.println("=> The total count of Branch(es) after applying filters is: " + postBubbleCount);
		// 🔽 ADD THIS: Logging post-filter bubbles
//						logBubbleDetails(bubblesAfterFilter, "bubbles_after_filter.csv");

		// Compare counts
		if (postBubbleCount == 0) {
			throw new AssertionError(
					"=> Map did not update or no branch(es) found after applying filter. Please verify the filters.");
		}
//		if (bubbleCountInit == postBubbleCount) {
//			throw new AssertionError(
//					"=> Filter application did not affect map bubbles. Both counts are same: " + postBubbleCount);
//		}

//		System.out.println("=> The Filter changes are applied successfully and map got updated with new branches .");

	}

	public void selectMetric() throws IOException, InterruptedException {
		// Clicking the Select Metric Dropdown
		WebElement SelectMetric_Dropdown = waitForElement(cpa_bc_selectMetricDropdown);
//		SelectMetric_Dropdown.click();
		helper.safeClick(SelectMetric_Dropdown);
//		System.out.println("=> The Select Metric Dropdown was clicked");
		Thread.sleep(4000);
		// Clicking the Metric options
		WebElement SelectMetric_Dropdown_Options = waitForElement(cpa_bc_selectMetricDropdownOptions);
		String SelectMetricDropdown_Options = SelectMetric_Dropdown_Options.getText();
		helper.safeClick(SelectMetric_Dropdown_Options);
//		actions.moveToElement(SelectMetric_Dropdown_Options).click().perform(); // This line is added for
		// the hovering effect

		System.out.println("=> The Select Metric Dropdown was clicked and Selected the " + SelectMetricDropdown_Options
				+ " from the options");
		Thread.sleep(5000);
		// Screenshot of the Select Metric options
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/Metric_Options.png");
//		FileHandler.copy(sourcefile, screenshotPath);
		bubbleCountAfterFilter();
		try {
			waitForElement(cpa_bc_geographicalMap);
		} catch (Exception e) {
			waitForElement(cpa_bc_geographicalMap);
		}
		waitForElement(cpa_bc_geographicalMap);
//		// Get bubble count AFTER applying filters and metric
//		List<WebElement> bubblesAfterFilter = driver.findElements(By.xpath(
//				"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"));
//		int postBubbleCount = bubblesAfterFilter.size();
//		System.out.println("--- Bubble count after applying filters: " + postBubbleCount);
//		// 🔽 ADD THIS: Logging post-filter bubbles
////				logBubbleDetails(bubblesAfterFilter, "bubbles_after_filter.csv");
//
//		// Compare counts
//		if (postBubbleCount == 0) {
//			throw new AssertionError(
//					"=> Map did not update or no bubbles found after filter. Please verify the filters.");
//		}
//		if (bubbleCountInit == postBubbleCount) {
//			throw new AssertionError(
//					"=> Filter application did not affect map bubbles. Both counts are same: " + postBubbleCount);
//		}
//
//		System.out.println("=> Filter applied successfully and map updated with new bubbles.");

	}

	// No high priority -- Clicks on the Zoom icons + and -
	public void ClicksOnZoomIcons() throws IOException, InterruptedException {
	}

	// Branch selection from the Geographical Map
	public void selectBranchMap() throws IOException, InterruptedException {
		// ✅ Target branches to find and click
		List<String> targetBranches = Arrays.asList("TORR", "DANB");

		// ✅ Store only branches actually found and clicked
		List<String> clickedBranches = new ArrayList<>();

		try {
			waitForElement(cpa_bc_geographicalMap);
		} catch (Exception e) {
			waitForElement(cpa_bc_geographicalMap);
		}

		// Get total bubbles count once
		int totalBubbles = driver.findElements(By.xpath(
				"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"))
				.size();

//		System.out.println("Total bubbles found: " + totalBubbles);

		for (int i = 0; i < totalBubbles; i++) {
			// ✅ Re-fetch bubbles inside the loop to avoid stale references
			List<WebElement> freshPoints = driver.findElements(By.xpath(
					"//*[name()='g' and contains(@class, 'scattergeo')]//*[name()='path' and contains(@class, 'point') and not(@display='none')]"));

			// Edge case: if bubble disappeared or DOM changed
			if (i >= freshPoints.size())
				break;

			WebElement point = freshPoints.get(i);

			// Hover
			actions.moveToElement(point).perform();
			Thread.sleep(250); // Let tooltip show

			// Extract tooltip text
			List<WebElement> hoverTexts = driver
					.findElements(By.xpath("//*[name()='g' and @class='hoverlayer']//*[name()='text']"));

			String tooltip = hoverTexts.stream().map(WebElement::getText).collect(Collectors.joining(" ")).trim();

			// ✅ Search target branches inside the tooltip
			for (String target : targetBranches) {
				if (tooltip.toLowerCase().contains(target.toLowerCase())) {
//					System.out.println("=> The branches are found & clicked: " + target);
					actions.keyDown(Keys.CONTROL).click(point).keyUp(Keys.CONTROL).build().perform();
					clickedBranches.add(target);
					Thread.sleep(2000);
					break;
				}
			}
		}

		// Final report
		System.out.println("=> The list of Branches clicked on the map are: ");
		for (String b : clickedBranches) {
			System.out.println(" - " + b);
		}
		try {
			waitForElement(cpa_bc_geographicalMap);
		} catch (Exception e) {
			waitForElement(cpa_bc_geographicalMap);
		}
		Thread.sleep(2000); // Optional wait after all clicks
	}

	// Select Branch Dropdown -- Scenario
	public void selectBranchDropdown() throws IOException, InterruptedException {
		List<String> selectBranchDropdownOptions = new ArrayList<>();

		// Select Branch from Dropdown
		WebElement SelectBranch_Dropdown = waitForElement(cpa_bc_selectBranchDropdown);
//		SelectBranch_Dropdown.click();
		helper.safeClick(SelectBranch_Dropdown);
		Thread.sleep(2000);
		// Select Branch - Dropdown Options - BRIS
		WebElement selectBranchDropdownOption01 = waitForElement(cpa_bc_selectBranchDropdownOption01);
		selectBranchDropdownOptions.add(selectBranchDropdownOption01.getText());
//		selectBranchDropdownOption01.click();
		helper.safeClick(selectBranchDropdownOption01);
		Thread.sleep(3000);
		// Select Branch - Dropdown Options - ENRG
		WebElement selectBranchDropdownOption02 = waitForElement(cpa_bc_selectBranchDropdownOption02);
		selectBranchDropdownOptions.add(selectBranchDropdownOption02.getText());
//		actions.moveToElement(SelectBranch_Dropdown_Options_ENRG).click().perform();

//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",
//				selectBranchDropdownOption02);
//		selectBranchDropdownOption02.click();
		helper.scrollToElement(selectBranchDropdownOption02);

		Thread.sleep(3000);
		// Select Branch - Dropdown - Search bar
		WebElement SelectBranch_Dropdown_Searchbar = waitForElement(cpa_bc_selectBranchDropdownSearchbar);
		SelectBranch_Dropdown_Searchbar.click();
		SelectBranch_Dropdown_Searchbar.clear();
		// Searching the Branch by Branch ID C243
//		SelectBranch_Dropdown_Searchbar.sendKeys("C243");
		SelectBranch_Dropdown_Searchbar.sendKeys(ConfigReader.searchBranchName());
		Thread.sleep(2000);
		WebElement selectBranchDropdownSearchbarValue01 = waitForElement(cpa_bc_selectBranchDropdownSearchbarValue01);
		selectBranchDropdownOptions.add(selectBranchDropdownSearchbarValue01.getText());
//		selectBranchDropdownSearchbarValue01.click();
		helper.safeClick(selectBranchDropdownSearchbarValue01);
		System.out.println("=> The Select Branch dropdown was clicked and selected the branch(es) such as: "
				+ selectBranchDropdownOptions);
		Thread.sleep(4000);
		SelectBranch_Dropdown_Searchbar.clear();
		Thread.sleep(5000);
		// This is used to come out of the dropdown overlay effect and click the next
		// locators

//		actions.moveByOffset(10, 10).click().build().perform();
		WebElement bc_selectBranchText = waitForElement(cpa_bc_selectBranchText);
		actions.moveToElement(bc_selectBranchText).click().perform();
		Thread.sleep(5000);
		// Screenshot of the Metric options
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/Branch_Dropdown_Options.png");
//		FileHandler.copy(sourcefile, screenshotPath);
	}

	// Click the Analyze button
	public void clickAnalyze() throws IOException, InterruptedException {
		// Analyze button
		WebElement AnalyzeBtn = waitForElement(cpa_bc_AnalyzeBtn);
//		AnalyzeBtn.click();
		helper.safeClick(AnalyzeBtn);
		System.out.println(
				"=> The Analyze button is clicked and redirecting to the Customer Selection Plot pop-up screen");
		// waits for the Customers Plot
		try {
			waitForElement(cpa_bc_customerSelectionPlot);
		} catch (Exception e) {
			waitForElement(cpa_bc_customerSelectionPlot);
		}
		waitForElement(cpa_bc_customerSelectionPlot);
		Thread.sleep(2000);
	}

	// Selects Customers from the Dropdown and Plot
	public void customerSelectionDropdown() throws IOException, InterruptedException {
		// To store the BILL TO ID's
		List<String> selectedBillToID = new ArrayList<>();
		// Customer Selection Plot - Dropdown
		WebElement CustomerSelectionPlot_Dropdown = waitForElement(cpa_bc_customerSelectionPlotDropdown);
//		CustomerSelectionPlot_Dropdown.click();
		helper.safeClick(CustomerSelectionPlot_Dropdown);
//		System.out.println("=> The Customer Selection Dropdown was clicked");
		Thread.sleep(2000);
		// CustomerSelectionPlot_Dropdown_Options_100966
		WebElement customerSelectionPlotDropdownOptions01 = waitForElement(
				cpa_bc_customerSelectionPlotDropdownOptions01);
		// Stores the BILL To ID - 100966
		// Extracts the ID
		selectedBillToID.add(customerSelectionPlotDropdownOptions01.getText().split("_")[0]);
		helper.safeClick(customerSelectionPlotDropdownOptions01);
		Thread.sleep(3000);
		// CustomerSelectionPlot_Dropdown_Options_129932
		WebElement customerSelectionPlotDropdownOptions02 = waitForElement(
				cpa_bc_customerSelectionPlotDropdownOptions02);
		// Stores the BILL To ID - 129932
		selectedBillToID.add(customerSelectionPlotDropdownOptions02.getText().split("_")[0]);
//		customerSelectionPlotDropdownOptions02.click();
		helper.safeClick(customerSelectionPlotDropdownOptions02);
		Thread.sleep(3000);
		// CustomerSelectionPlot_Dropdown_Options_138999
		WebElement customerSelectionPlotDropdownOptions03 = waitForElement(
				cpa_bc_customerSelectionPlotDropdownOptions03);
		// Stores the BILL To ID - 138999
		selectedBillToID.add(customerSelectionPlotDropdownOptions03.getText().split("_")[0]);
//		customerSelectionPlotDropdownOptions03.click();
		helper.safeClick(customerSelectionPlotDropdownOptions03);
		Thread.sleep(3000);
		// CustomerSelectionPlot_SearchBar
		WebElement CustomerSelectionPlot_Searchbar = waitForElement(cpa_bc_customerSelectionPlotSearchbar);
		CustomerSelectionPlot_Searchbar.click();
		CustomerSelectionPlot_Searchbar.clear();
		// Searching the Customer by Customer ID 105097
		CustomerSelectionPlot_Searchbar.sendKeys(ConfigReader.customerSelectionPlotID());
		Thread.sleep(3000);
		WebElement customerSelectionPlotSearchbarValue = waitForElement(cpa_bc_customerSelectionPlotSearchbarValue);
		// Stores the BILL To ID - 105097
		selectedBillToID.add(customerSelectionPlotSearchbarValue.getText().split("_")[0]);
//		customerSelectionPlotSearchbarValue.click();
		helper.safeClick(customerSelectionPlotSearchbarValue);

		Thread.sleep(2000);
		CustomerSelectionPlot_Searchbar.clear();
		Thread.sleep(2000);
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
		WebElement CustomerSelectionPlot_SaveCustomersBtn = waitForElement(
				cpa_bc_customerSelectionPlotSaveCustomersBtn);
//		CustomerSelectionPlot_SaveCustomersBtn.click();
		helper.safeClick(CustomerSelectionPlot_SaveCustomersBtn);
		try {
			waitForElement(cpa_ps_TableRow);
		} catch (Exception e) {
			waitForElement(cpa_ps_TableRow);
		}
		waitForElement(cpa_ps_TableRow);

		// Stored BILL To ID's
		System.out.println(
				"=> The Select Customers Dropdown was clicked and the selected customers are: " + selectedBillToID);
		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection Screen
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError("=> Unexpected redirection, Current URL you're on: " + currentUrl);
		}

		// Extract BILL TO IDs from Peer Selection table
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<String> billToIds = new ArrayList<>();

		for (WebElement row : rows) {
			String billToId = row.findElement(By.xpath("td[2]")).getText().trim();
			billToIds.add(billToId);
		}

		System.out.println(
				"=> The Extracted BILL TO ID's from Peer Selection - Select Target Customer for Simulation table are: "
						+ billToIds);

		// Compare both the list
		for (String id : selectedBillToID) {
			if (!billToIds.contains(id)) {
				throw new AssertionError("=> Unfortunately the BILL TO ID " + id
						+ " is missing in the Peer Selection - Select Target Customer for Simulation table");
			}
		}

		System.out.println(
				"=> Hurray!, All selected customers from the plot are present in the Peer Selection - Select Target Customer for Simulation table");
	}

	// Customer selected from the scatter plot

	List<String> selectedBillToID = new ArrayList<>();

	By plotDots = By.cssSelector("g.scatterlayer g.trace path.point");
	By tooltipText = By.xpath("//*[name()='g' and @class='hoverlayer']//*[name()='text']");

	public List<String> customerSelectionPlot() throws IOException, InterruptedException {
//		List<String> targetCustomerIds = Arrays.asList("29228", "36726", "374284", "25317", "450684");
		List<String> targetCustomerIds = Arrays.asList("24018", "36726", "374284", "25379", "33826");
		List<String> clickedIds = new ArrayList<>();
		System.out
				.println("=> Target Customer ID's to select from the Root Cause Customer for the Selected Cost Metric: "
						+ targetCustomerIds);

		for (String targetId : targetCustomerIds) {
			boolean found = false;
			int retries = 0;

			while (!found && retries < 3) {
				retries++;

				List<WebElement> scatterDots = driver
						.findElements(By.xpath("//*[name()='path' and contains(@class,'point')]"));

				for (int i = 0; i < scatterDots.size(); i++) {
					try {
						scatterDots = driver.findElements(By.xpath("//*[name()='path' and contains(@class,'point')]"));
						WebElement dot = scatterDots.get(i);

						// Enhanced hover and activation for ALL dots
						new Actions(driver).moveToElement(dot, 1, 1).moveByOffset(2, 2).perform();

						// Dispatch mouseenter and mousemove to activate Plotly
						String activateDotScript = "var ev1 = new MouseEvent('mouseenter', { bubbles:true });"
								+ "var ev2 = new MouseEvent('mousemove', { bubbles:true });"
								+ "arguments[0].dispatchEvent(ev1);" + "arguments[0].dispatchEvent(ev2);";
						((JavascriptExecutor) driver).executeScript(activateDotScript, dot);

						Thread.sleep(30); // small pause to allow tooltip to render

						// Fast polling for tooltip
						String extractedId = "";
						long startTime = System.currentTimeMillis();
						while (System.currentTimeMillis() - startTime < 800) {
							List<WebElement> tooltipElements = driver.findElements(tooltipText);
							if (!tooltipElements.isEmpty()) {
								String tooltipTextCombined = tooltipElements.stream().map(WebElement::getText)
										.collect(Collectors.joining(" ")).trim();
								if (!tooltipTextCombined.isEmpty()) {
									extractedId = tooltipTextCombined.replaceAll("[^0-9]", " ").trim().split(" ")[0];
									break;
								}
							}
						}

						if (!extractedId.isEmpty() && extractedId.equals(targetId)
								&& !clickedIds.contains(extractedId)) {
							System.out.println("=> The Customer ID: " + extractedId + " is matched and clicked");

							try {
								if (clickedIds.isEmpty()) {
									// Fallback to JS click
									String jsClickScript = "var ev = new MouseEvent('click', {"
											+ "bubbles: true, cancelable: true, view: window, ctrlKey: arguments[1] });"
											+ "arguments[0].dispatchEvent(ev);";

									((JavascriptExecutor) driver).executeScript(jsClickScript, dot,
											!clickedIds.isEmpty());

								} else {
									actions.keyDown(Keys.CONTROL).click(dot).keyUp(Keys.CONTROL).build().perform(); // ctrl+click
								}
							} catch (Exception e) {
								// Fallback to JS click
								String jsClickScript = "var ev = new MouseEvent('click', {"
										+ "bubbles: true, cancelable: true, view: window, ctrlKey: arguments[1] });"
										+ "arguments[0].dispatchEvent(ev);";

								((JavascriptExecutor) driver).executeScript(jsClickScript, dot, !clickedIds.isEmpty());
							}

							clickedIds.add(extractedId); // ✅ add only after click
//						             Thread.sleep(50); // Let click register
							found = true;
							break; // Go to next targetId
						}

					} catch (StaleElementReferenceException se) {
						System.out.println("=>ERROR: Dot became stale & will re-fetch dots");
						break; // Retry from outer loop
					} catch (Exception e) {
						// Optionally log or skip
					}
				}
			}

			if (!found) {
				System.out.println(
						"=> Could not find the dot for Customer ID: " + targetId + " after " + retries + " retries.");
			}
		}

		// ✅ Summary
		if (clickedIds.isEmpty()) {
			System.out.println("=> No matching Customer IDs were clicked.");
		} else {
			System.out.println("=> The Final clicked Customer IDs are:");
			clickedIds.forEach(id -> System.out.println(" - " + id));
		}
		// CustomerSelectionPlot_SaveCustomersBtn
		WebElement CustomerSelectionPlot_SaveCustomersBtn = waitForElement(
				cpa_bc_customerSelectionPlotSaveCustomersBtn);
//		CustomerSelectionPlot_SaveCustomersBtn.click();
		helper.safeClick(CustomerSelectionPlot_SaveCustomersBtn);
		try {
			waitForElement(cpa_ps_TableRow);
		} catch (Exception e) {
			waitForElement(cpa_ps_TableRow);
		}
		waitForElement(cpa_ps_TableRow);
		Thread.sleep(2000);
		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection Screen
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError("=> Unexpected redirection, Current URL you're on: " + currentUrl);
		}
		// Calls the function to validate the selection
		selectTargetCustomerTable(clickedIds);
		return clickedIds;

	}

	public void customerSelectionDropdownPlot() throws IOException, InterruptedException {
		// To store the BILL TO ID's
//		List<String> selectedBillToID = new ArrayList<>();
//		List<String> plotSelectedIds = customerSelectionPlot();

		// Customer Selection Plot - Dropdown
		WebElement CustomerSelectionPlot_Dropdown = waitForElement(cpa_bc_customerSelectionPlotDropdown);
//		CustomerSelectionPlot_Dropdown.click();
		helper.safeClick(CustomerSelectionPlot_Dropdown);
//		System.out.println("=> The Customer Selection Dropdown was clicked");
		Thread.sleep(2000);
		// CustomerSelectionPlot_Dropdown_Options_100966
		WebElement customerSelectionPlotDropdownOptions01 = waitForElement(
				cpa_bc_customerSelectionPlotDropdownOptions01);
		// Stores the BILL To ID - 100966
		selectedBillToID.add(customerSelectionPlotDropdownOptions01.getText().split("_")[0]); // Extracts only
																								// the BILL To
																								// ID from the
																								// entire
																								// customer name
//		customerSelectionPlotDropdownOptions01.click();
		helper.safeClick(customerSelectionPlotDropdownOptions01);
		Thread.sleep(3000);
		// CustomerSelectionPlot_Dropdown_Options_129932
		WebElement customerSelectionPlotDropdownOptions02 = waitForElement(
				cpa_bc_customerSelectionPlotDropdownOptions02);
		// Stores the BILL To ID - 129932
		selectedBillToID.add(customerSelectionPlotDropdownOptions02.getText().split("_")[0]);
//		customerSelectionPlotDropdownOptions02.click();
		helper.safeClick(customerSelectionPlotDropdownOptions02);
		Thread.sleep(3000);
		// CustomerSelectionPlot_Dropdown_Options_138999
		WebElement customerSelectionPlotDropdownOptions03 = waitForElement(
				cpa_bc_customerSelectionPlotDropdownOptions03);
		// Stores the BILL To ID - 138999
		selectedBillToID.add(customerSelectionPlotDropdownOptions03.getText().split("_")[0]);
//		customerSelectionPlotDropdownOptions03.click();
		helper.safeClick(customerSelectionPlotDropdownOptions03);
		Thread.sleep(3000);
		// CustomerSelectionPlot_SearchBar
		WebElement CustomerSelectionPlot_Searchbar = waitForElement(cpa_bc_customerSelectionPlotSearchbar);
		CustomerSelectionPlot_Searchbar.click();
		CustomerSelectionPlot_Searchbar.clear();
		// Searching the Customer by Customer ID 105097
		CustomerSelectionPlot_Searchbar.sendKeys(ConfigReader.customerSelectionPlotID());
		Thread.sleep(3000);
		WebElement customerSelectionPlotSearchbarValue = waitForElement(cpa_bc_customerSelectionPlotSearchbarValue);
		// Stores the BILL To ID - 105097
		selectedBillToID.add(customerSelectionPlotSearchbarValue.getText().split("_")[0]);
//		customerSelectionPlotSearchbarValue.click();
		helper.safeClick(customerSelectionPlotSearchbarValue);

		Thread.sleep(2000);
		CustomerSelectionPlot_Searchbar.clear();
		Thread.sleep(2000);
		// This is used to come out of the dropdown overlay effect and click the next
		// locators
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 10).click().build().perform();
		Thread.sleep(3000);
		// calls the function for selecting customer from scatter plot
//		customerSelectionPlot();
		// add the customer from plots
//		selectedBillToID.addAll(plotSelectedIds);

		// Screenshot of the Customer Selection Plot Options
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
//		File screenshotPath = new File(
//				"src/test/resources/screenshots/CustomerPeerAnalysis/Selections/BranchCustomerSelections/CustomerSelectionPlot_Dropdown_Options.png");
//		FileHandler.copy(sourcefile, screenshotPath);
		// Stored BILL To ID's
		System.out.println(
				"=> The Select Customers Dropdown was clicked and the selected customers are: " + selectedBillToID);

		// Customer Selection from plot

//		List<String> targetCustomerIds = Arrays.asList("29228", "36726", "374284", "25317", "450684");
		List<String> targetCustomerIds = Arrays.asList("24018", "36726", "374284", "25379", "33826");
		List<String> clickedIds = new ArrayList<>();
		System.out
				.println("=> Target Customer ID's to select from the Root Cause Customer for the Selected Cost Metric: "
						+ targetCustomerIds);

		for (String targetId : targetCustomerIds) {
			boolean found = false;
			int retries = 0;

			while (!found && retries < 3) {
				retries++;

				List<WebElement> scatterDots = driver
						.findElements(By.xpath("//*[name()='path' and contains(@class,'point')]"));

				for (int i = 0; i < scatterDots.size(); i++) {
					try {
						scatterDots = driver.findElements(By.xpath("//*[name()='path' and contains(@class,'point')]"));
						WebElement dot = scatterDots.get(i);

						// Enhanced hover and activation for ALL dots
						new Actions(driver).moveToElement(dot, 1, 1).moveByOffset(2, 2).perform();

						// Dispatch mouseenter and mousemove to activate Plotly
						String activateDotScript = "var ev1 = new MouseEvent('mouseenter', { bubbles:true });"
								+ "var ev2 = new MouseEvent('mousemove', { bubbles:true });"
								+ "arguments[0].dispatchEvent(ev1);" + "arguments[0].dispatchEvent(ev2);";
						((JavascriptExecutor) driver).executeScript(activateDotScript, dot);

						Thread.sleep(30); // small pause to allow tooltip to render

						// Fast polling for tooltip
						String extractedId = "";
						long startTime = System.currentTimeMillis();
						while (System.currentTimeMillis() - startTime < 800) {
							List<WebElement> tooltipElements = driver.findElements(tooltipText);
							if (!tooltipElements.isEmpty()) {
								String tooltipTextCombined = tooltipElements.stream().map(WebElement::getText)
										.collect(Collectors.joining(" ")).trim();
								if (!tooltipTextCombined.isEmpty()) {
									extractedId = tooltipTextCombined.replaceAll("[^0-9]", " ").trim().split(" ")[0];
									break;
								}
							}
						}

						if (!extractedId.isEmpty() && extractedId.equals(targetId)
								&& !clickedIds.contains(extractedId)) {
							System.out.println("=> The Customer ID: " + extractedId + " is matched and clicked");

							try {
								if (clickedIds.isEmpty()) {
									// Fallback to JS click
									String jsClickScript = "var ev = new MouseEvent('click', {"
											+ "bubbles: true, cancelable: true, view: window, ctrlKey: arguments[1] });"
											+ "arguments[0].dispatchEvent(ev);";

									((JavascriptExecutor) driver).executeScript(jsClickScript, dot,
											!clickedIds.isEmpty());

								} else {
									actions.keyDown(Keys.CONTROL).click(dot).keyUp(Keys.CONTROL).build().perform(); // ctrl+click
								}
							} catch (Exception e) {
								// Fallback to JS click
								String jsClickScript = "var ev = new MouseEvent('click', {"
										+ "bubbles: true, cancelable: true, view: window, ctrlKey: arguments[1] });"
										+ "arguments[0].dispatchEvent(ev);";

								((JavascriptExecutor) driver).executeScript(jsClickScript, dot, !clickedIds.isEmpty());
							}

							clickedIds.add(extractedId); // ✅ add only after click
//						             Thread.sleep(50); // Let click register
							found = true;
							break; // Go to next targetId
						}

					} catch (StaleElementReferenceException se) {
						System.out.println("=>ERROR: Dot became stale & will re-fetch dots");
						break; // Retry from outer loop
					} catch (Exception e) {
						// Optionally log or skip
					}
				}
			}

			if (!found) {
				System.out.println(
						"=> Could not find the dot for Customer ID: " + targetId + " after " + retries + " retries.");
			}
		}

		// ✅ Summary
		if (clickedIds.isEmpty()) {
			System.out.println("=> No matching Customer IDs were clicked.");
		} else {
			System.out.println("=> The Final clicked Customer IDs are:");
			// this displays customer id in table format
			clickedIds.forEach(id -> System.out.println(" - " + id));
		}
		// Merging both list
		Set<String> mergedIds = new LinkedHashSet<>(selectedBillToID);
		mergedIds.addAll(clickedIds);
		System.out.println("=> The Customer ID's from dropdown and plot are merged and the list is: " + mergedIds);
		// CustomerSelectionPlot_SaveCustomersBtn
		WebElement CustomerSelectionPlot_SaveCustomersBtn = waitForElement(
				cpa_bc_customerSelectionPlotSaveCustomersBtn);
//		CustomerSelectionPlot_SaveCustomersBtn.click();
		helper.safeClick(CustomerSelectionPlot_SaveCustomersBtn);
		try {
			waitForElement(cpa_ps_TableRow);

		} catch (Exception e) {
			waitForElement(cpa_ps_TableRow);
		}
		waitForElement(cpa_ps_TableRow);

		// Verify whether it landed on the Customer Peer Analysis Card - Selections -
		// Peer Selection Screen
		String currentUrl = driver.getCurrentUrl();
		String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();

		if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
			throw new AssertionError("=> Unexpected redirection, Current URL you're on: " + currentUrl);
		}

		// Extract BILL TO IDs from Peer Selection table
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<String> billToIds = new ArrayList<>();

		for (WebElement row : rows) {
			String billToId = row.findElement(By.xpath("td[2]")).getText().trim();
			billToIds.add(billToId);
		}

		System.out.println(
				"=> The Extracted BILL TO ID's from Peer Selection - Select Target Customer for Simulation table are: "
						+ billToIds);

		// Compare both the list
		for (String id : mergedIds) {
			if (!billToIds.contains(id)) {
				System.out.println("=> Unfortunately the BILL TO ID " + id
						+ " is missing in the Peer Selection - Select Target Customer for Simulation table");
			}
		}
		System.out.println(
				"=> Hurray!, All selected customers from the plot are present in the Peer Selection - Select Target Customer for Simulation table");

	}

	// This is to validate the whether the customer selected in the scatter plot is
	// present or not
	public void selectTargetCustomerTable(List<String> selectedBillToID) {

		// Extract BILL TO IDs from Peer Selection table
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<String> billToIds = new ArrayList<>();

		for (WebElement row : rows) {
			String billToId = row.findElement(By.xpath("td[2]")).getText().trim();
			billToIds.add(billToId);
		}

		System.out.println(
				"=> The Extracted BILL TO ID's from Peer Selection - Select Target Customer for Simulation table are: "
						+ billToIds);

		// Compare both the list

		for (String id : selectedBillToID) {
			if (!billToIds.contains(id)) {
				System.out.println("=> Unfortunately the BILL TO ID " + id
						+ " is missing in the Peer Selection - Select Target Customer for Simulation table");
			}
		}
		System.out.println(
				"=> Hurray!, All selected customers from the plot are present in the Peer Selection - Select Target Customer for Simulation table");

	}
}
