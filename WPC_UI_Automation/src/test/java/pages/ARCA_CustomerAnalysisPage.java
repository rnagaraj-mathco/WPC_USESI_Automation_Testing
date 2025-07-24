package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

public class ARCA_CustomerAnalysisPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public ARCA_CustomerAnalysisPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(100)); // ✅ wait initialized once
		actions = new Actions(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Locators
	// xpath of the Root Cause Customers for the Selected Cost Metric plot in the
	// Customer Analysis
	By arca_ca_rootCauseCustomerPlot = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]");

	// xpath of the Filter button
	By arca_ca_filterBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Filter - Cost Metric
	By arca_ca_filterCostMetric = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");

	// xpath of the Filter - Customer Size
	By arca_ca_filterCustomerSize = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]");

	// xpath of the Filter - Customer Size - Value_01 (Large)
	By arca_ca_filterCustomerSizeValue1 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/label[2]/span[2]/div[1]");

	// xpath of the Filter - Customer Price Class
	By arca_ca_filterCustomerPriceClass = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/div[1]/div[1]/div/div[4]/div");

	// xpath of the Filter - Customer Price Class - Value_01 (BUILDR)
	By arca_ca_filterCustomerPriceClassValue1 = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div/fieldset/div[2]/label[3]/span[2]");

	// xpath of the Filter - Customer Price Class - Value_02 (CASHNE)
	By arca_ca_filterCustomerPriceClassValue2 = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div/fieldset/div[2]/label[8]/span[2]/div/span");

	// xpath of the Filter - Customer Price Class - Value_03 (WW84)
	By arca_ca_filterCustomerPriceClassValue3 = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div/fieldset/div[2]/label[27]/span[2]/div/span");

	// xpath of the Filter - Product Type
	By arca_ca_filterProductType = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/span[1]");

	// xpath of the Filter - Product Type - Search bar
	By arca_ca_filterProductTypeSearchBar = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the Filter - Product Type - Value_01
	By arca_ca_filterProductTypeValue1 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/label[2]/span[2]/div[1]/span[1]");

	// xpath of the Filter - Product Type - Value_02 -
	By arca_ca_filterProductTypeValue2 = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/label[1]/span[2]/div[1]/span[2]");

	// xpath of the Apply button
	By arca_ca_filterApplyButton = By.xpath("//button[@aria-label='apply filter']");

	// xpath of the Save Customer button
	By arca_ca_saveCustomerBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Customer Selection - Filter Customer Product Combination - Tree
	// Map
	By arca_fcp_treeMap = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]");

	// xpath of Root Cause Customer Plot - Select All Checkboxes
	By arca_ca_rootCauseCustomerPlotSelectAllCheckboxes = By.xpath(
			"/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div/div/div/div/div/div[3]/div/div/div[1]/form/div/div[2]/div/div/div[1]/p/div/fieldset/label/span[2]");

	// xpath of Reset button
	By arca_ca_resetBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]/span[1]");

	// xpath of the Save Combination of Filter Customer and Product Combination
	// screen
	By arca_fcp_saveCombination = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/button[1]");

	// Navigating to Customer Analysis screen
	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Customer Analysis screen
		driver.get(ConfigReader.arca_customerAnalysis());
		// waits till the Root Cause Customers for the Selected Cost Metric
		waitForElement(arca_ca_rootCauseCustomerPlot);
		System.out.println(
				"=> The Customer Analysis Screen is loaded with the Root Cause Customers for the Selected Cost Metric plot");
		Thread.sleep(5000);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/CustomerAnalysis/CustomerAnalysisScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Auto Root Cause Analysis - CustomerAnalysis
		String currentUrl = driver.getCurrentUrl();
		String expectedbranchCustomerSelectionUrl = ConfigReader.arca_customerAnalysis();

		if (!currentUrl.equalsIgnoreCase(expectedbranchCustomerSelectionUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println("=> Successfully landed on Customer Analysis screen");
	}

// This is the dynamic way of performing actions on filters but failing for the search and select in product type option
//	public void filtersTo() throws IOException, InterruptedException {
//		// Waits for the Filter button
//		WebElement ca_filter = waitForElement(arca_ca_filterBtn);
//		ca_filter.click();
//		Thread.sleep(1000);
//		System.out.println("=> The Filter button is clicked");
//		// Step 2: Define filters and their target values dynamically
//		Map<String, List<String>> filtersWithValues = new LinkedHashMap<>();
//
//		filtersWithValues.put("Customer Size", Arrays.asList("Large", "Medium"));
//		filtersWithValues.put("Customer Price Class", Arrays.asList("CASHNE", "BUILDR", "WW84"));
//		filtersWithValues.put("Product Type", Arrays.asList("Type A"));
//
//		// Step 3: Iterate through each filter section and select corresponding values
//		for (Map.Entry<String, List<String>> entry : filtersWithValues.entrySet()) {
//			String filterCategory = entry.getKey();
//			List<String> valuesToSelect = entry.getValue();
//
//			// Click filter section (like "Customer Size")
//			By filterSection = By.xpath("//div[@name='" + filterCategory + "']");
//			WebElement filterElement = waitForElement(filterSection);
//			actions.moveToElement(filterElement).click().perform();
//			System.out.println("=> Clicked Filter Category: " + filterCategory);
//			Thread.sleep(1500);
//
//			// Select values inside the opened filter
//			for (String value : valuesToSelect) {
//				By valueCheckbox = By.xpath("//input[@type='checkbox' and @value='" + value + "']/ancestor::label");
//				WebElement checkboxElement = waitForElement(valueCheckbox);
//				actions.moveToElement(checkboxElement).click().perform();
//				System.out.println("   => Selected Value: " + checkboxElement.getText().trim());
//				Thread.sleep(1200);
//			}
//		}
//	}

	// Filters operation in traditional way
	public void filtersTo() throws IOException, InterruptedException {
		// Waits for the Filter button
		WebElement ca_filter = waitForElement(arca_ca_filterBtn);
		ca_filter.click();
		Thread.sleep(1000);
		System.out.println("=> The Filter button is clicked");
		// Waits for the Filter - Cost Metric option
		WebElement ca_filterCostMetric = waitForElement(arca_ca_filterCostMetric);
		ca_filterCostMetric.click();
		System.out.println("=> The Filter - Cost Metric option is clicked");
		Thread.sleep(5000);
		// Waits for the Filter - Customer Size option
		WebElement ca_filterCustomerSize = waitForElement(arca_ca_filterCustomerSize);
		actions.moveToElement(ca_filterCustomerSize).click().perform();
		ca_filterCustomerSize.click();
		System.out.println("=> The Filter - Customer Size option is clicked ");
		// Waits for the Filter - Customer Size option - Value_1
		WebElement ca_filterCustomerSizeValue = waitForElement(arca_ca_filterCustomerSizeValue1);
		String filterCustomerSizeValue1 = ca_filterCustomerSizeValue.getText().trim();
		ca_filterCustomerSizeValue.click();
		Thread.sleep(5000);
		System.out.println("=> The Filter - Cost Metric option Value is clicked: " + filterCustomerSizeValue1);
		// Waits for the Filter - Customer Price Class
		WebElement ca_filterCustomerPriceClass = waitForElement(arca_ca_filterCustomerPriceClass);
		actions.moveToElement(ca_filterCustomerPriceClass).click().perform();
		Thread.sleep(4000);
		// Waits for the Filter - Customer Price Class - Value1
		List<String> selectedCustomerPriceClassValues = new ArrayList<>();
		WebElement ca_filterCustomerPriceClassValue1 = waitForElement(arca_ca_filterCustomerPriceClassValue1);
		selectedCustomerPriceClassValues.add(ca_filterCustomerPriceClassValue1.getText());
		ca_filterCustomerPriceClassValue1.click();
		waitForElement(arca_ca_filterApplyButton);
		Thread.sleep(4000);
		// Waits for the Filter - Customer Price Class - Value2
		WebElement ca_filterCustomerPriceClassValue2 = waitForElement(arca_ca_filterCustomerPriceClassValue2);
		selectedCustomerPriceClassValues.add(ca_filterCustomerPriceClassValue2.getText());
		ca_filterCustomerPriceClassValue2.click();
		waitForElement(arca_ca_filterApplyButton);
		Thread.sleep(9000);
		// Waits for the Filter - Customer Price Class - Value3
		WebElement ca_filterCustomerPriceClassValue3 = waitForElement(arca_ca_filterCustomerPriceClassValue3);
		selectedCustomerPriceClassValues.add(ca_filterCustomerPriceClassValue3.getText());
		actions.moveToElement(ca_filterCustomerPriceClassValue3).click().perform();
		waitForElement(arca_ca_filterApplyButton);
		Thread.sleep(5000);
		System.out.println("=> The Filter - Customer Price Class option is clicked and selected values such as: "
				+ selectedCustomerPriceClassValues);
		// Waits for the Filter - Product Type
		WebElement ca_filterProductType = waitForElement(arca_ca_filterProductType);
		actions.moveToElement(ca_filterProductType).click().perform();
		System.out.println("=> The Filter - Product Type option is clicked ");
		Thread.sleep(3000);
		// waits for the Filter - Product Type - Search bar
		List<String> selectedProdcutTypeValues = new ArrayList<>();
		WebElement ca_filterProductTypeSearchBar = waitForElement(arca_ca_filterProductTypeSearchBar);
		ca_filterProductTypeSearchBar.click();
		ca_filterProductTypeSearchBar.clear();
		// Searches for the option - 00
		ca_filterProductTypeSearchBar.sendKeys("00");

		// Waits for the Filter - Product Type - Value - 00
		WebElement ca_filterProductTypeValue1 = waitForElement(arca_ca_filterProductTypeValue1);
		selectedProdcutTypeValues.add(ca_filterProductTypeValue1.getText());
		ca_filterProductTypeValue1.click();
		Thread.sleep(4000);
		ca_filterProductTypeSearchBar.click();
		ca_filterProductTypeSearchBar.sendKeys(Keys.CONTROL + "a");
		ca_filterProductTypeSearchBar.sendKeys(Keys.BACK_SPACE);
		actions.moveByOffset(10, 10).click().build().perform();
		waitForElement(arca_ca_filterProductTypeValue1);
		Thread.sleep(4000);
		// Waits for the Filter - Product Type - Value - 05
		ca_filterProductTypeSearchBar.click();
		ca_filterProductTypeSearchBar.clear();
		// Searches for the option - 00
		ca_filterProductTypeSearchBar.sendKeys("05");
		// Waits for the Filter - Product Type - Value - 00
		WebElement ca_filterProductTypeValue2 = waitForElement(arca_ca_filterProductTypeValue2);
		selectedProdcutTypeValues.add(ca_filterProductTypeValue2.getText());
		ca_filterProductTypeValue2.click();
		Thread.sleep(4000);
		ca_filterProductTypeSearchBar.click();
		ca_filterProductTypeSearchBar.sendKeys(Keys.CONTROL + "a");
		ca_filterProductTypeSearchBar.sendKeys(Keys.BACK_SPACE);
		actions.moveByOffset(10, 10).click().build().perform();
		waitForElement(arca_ca_filterProductTypeValue2);
		Thread.sleep(1000);
		System.out.println("=> The Filter - Product Type option is clicked and selected values such as: "
				+ selectedProdcutTypeValues);
		// Waits for the Filter - Apply button
		WebElement ca_filterApplyButton = waitForElement(arca_ca_filterApplyButton);
		ca_filterApplyButton.click();
		waitForElement(arca_ca_rootCauseCustomerPlot);
		Thread.sleep(2000);

	}

	// Locators
	By plotDots = By.cssSelector("g.scatterlayer g.trace path.point");
	By tooltipText = By.xpath("//*[name()='g' and @class='hoverlayer']//*[name()='text']");

	public List<String> rootCauseCustomerSelectionPlot() throws IOException {
		List<String> targetCustomerIds = Arrays.asList("98322", "194293", "40555", "46777", "87327");
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

		return clickedIds;
	}

	// Select All Customers selection
	public void selectAllCustomersCheckBox() throws IOException, InterruptedException {
		// Waits for the Select All Checkboxes
		WebElement ca_rootCauseCustomerPlotSelectAllCheckboxes = waitForElement(
				arca_ca_rootCauseCustomerPlotSelectAllCheckboxes);
		ca_rootCauseCustomerPlotSelectAllCheckboxes.click();
		Thread.sleep(2000);
		waitForElement(arca_ca_rootCauseCustomerPlot);
		System.out.println(
				"=> The Select All Customers option is selected and all the customers in plot are got selected");

	}

	// Save Customer Btn
	public void saveCustomersBtn() throws IOException, InterruptedException {
		// Waits for the Save Customers Button
		WebElement ca_saveCustomerBtn = waitForElement(arca_ca_saveCustomerBtn);
		actions.moveToElement(ca_saveCustomerBtn).click().perform();
		Thread.sleep(1000);
		System.out.println("=> The Save Customers Button is clicked");
		waitForElement(arca_fcp_treeMap);
		waitForElement(arca_fcp_saveCombination);
		Thread.sleep(2000);

		// Verify whether it landed on the Auto Root Cause Analysis - CustomerAnalysis
		String currentUrl = driver.getCurrentUrl();
		String expectedbranchCustomerSelectionUrl = ConfigReader.arca_filterCustomerAndProductCombinations();

		if (!currentUrl.equalsIgnoreCase(expectedbranchCustomerSelectionUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully landed on Customer Selection - Filter Customer and Product Combinations screen");
		waitForElement(arca_fcp_treeMap);
		driver.navigate().back();
	}

	// Reset Btn
	public void resetBtn() throws IOException, InterruptedException {
		// Waits for the Save Customers Button
		waitForElement(arca_ca_rootCauseCustomerPlot);
		WebElement ca_resetBtn = waitForElement(arca_ca_resetBtn);
		actions.moveToElement(ca_resetBtn).click().perform();
		Thread.sleep(3000);
		System.out.println("=> The Reset Button is clicked and the plot is reverted to its previous state");
		waitForElement(arca_ca_rootCauseCustomerPlot);

	}

}
