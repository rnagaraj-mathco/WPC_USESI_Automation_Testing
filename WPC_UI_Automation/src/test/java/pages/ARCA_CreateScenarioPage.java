package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
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

public class ARCA_CreateScenarioPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	// gets driver status
	public ARCA_CreateScenarioPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(90)); // wait initialized once
		actions = new Actions(driver);
	}

	// Waits for the specified element by locator
	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Locators
	// xpath of the Pre-programmed Scenario widget
	By arca_csc_preProgrammedScenario = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]");

	// xpath of the Estimated Impact Widget
	By arca_csc_estimatedImpact = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");

	// xpath of the Estimated Impact Widget - Error message
	By arca_csc_estimatedImpactError = By.xpath("//h3[img[@alt='Lightbulb Icon']]");

	// xpath of the Filters
	By arca_csc_filtersBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/header[1]/div[1]/div[1]/button[1]");

	// xpath of the Filters - Customer and Product Combinations
	By arca_csc_filtersOptions = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Filter - Customer and Product Combinations - Value
	By arca_csc_filterOptionsValue = By.xpath(
			"//label[contains(@class, 'MuiFormControlLabel-root')]//input[@type='radio' and @checked]/ancestor::label");

	// xpath of the Filter - Cancel btn
	By arca_csc_filterCancel = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");

	// xpath of the Filter - Apply btn
	By arca_csc_filterApply = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]");

	// xpath of the headerText with customer Id and Customer name of
	// Pre-Programmed Scenario (PPS)
	By arca_csc_headerTextPPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/h5[1]");

	// xpath of the customer details btn
	By arca_csc_customerDetailsBtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/button[1]");

	// xpath of the popup - Selected Customers and Products Combination
	By arca_csc_popupSCPC = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]");

	// xpath of the Selected Target for Simulation - First Row - Customer ID
	By arca_csc_firstRowCustomerIdSTS = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");

	// xpath of the Selected Target for Simulation - Close icon
	By arca_csc_closeIconSTS = By.xpath("/html[1]/body[1]/div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]");

	// xpath of the Selected Target for Simulation - Download icon
	By arca_csc_downloadIconSTC = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// xpath of the Selected Product for Root Cause Analysis (SPRCA) - Download icon
	By arca_csc_downloadIconSPRCA = By.xpath(
			"/html[1]/body[1]/div[5]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");

	// xpath of the PPS - Create Scenario button
	By arca_csc_createScenarioBtnPPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[32]/div[1]/div[1]/button[1]");

	// xpath of the PPS - Reset Simulation
	By arca_csc_resetSimulationBtnPPS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[31]/div[1]/div[1]/button[1]");

	// xpath of the EI - Reset Simulation
	By arca_csc_resetSimulationBtnEI = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/button[1]");

	// xpath of the Estimated Impact (EI) - Save Scenario btn
	By arca_csc_saveScenarioEI = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/div[1]/div[1]/button[1]");

	// xpath of the Error message to Save Scenario button
	By arca_csc_errorMessageSaveScenariobtn = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/p[1]");

	// xpath of the Enter Scenario name input field
	By arca_csc_inputScenarioName = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the success message
	By arca_csc_successMessage = By
			.xpath("//h4[contains(text(),'✅ Your scenario results have been successfully saved! 🎉')]");

	// Pre-Programmed Scenario Widget
	// xpath of the % Change in Order $ Sales - Slider to Simulator Changes in Sales
	// (SSCS)
	By arca_csc_silderSSCS = By.xpath("//span[contains(@class, 'MuiSlider-thumb') and @role='slider']");

	// xpath of the % Change in Order $ Sales - Current Sales(Before Simulation)
	By arca_csc_silderCusrrentSales = By.xpath("(//div[contains(@class, 'MuiBox-root') and @style])[3]");

	// xpath of the % Change in Order $ Sales - Enter numeric value field
	By arca_csc_numericValueSales = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[8]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/input[1]");

	// xpath of the download icon of Estimates Impact - Before
	By arca_csc_downloadBefore = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]");

	// xpath of the Estimated Impact - Before Simulation chart
	By arca_csc_beforeSimulation = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the download icon of Estimates Impact - Before
	By arca_csc_downloadAfter = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]");

	// xpath of the Estimated Impact - After Simulation chart
	By arca_csc_afterSimulation = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the Estimated Impact - Before - Simulation - Enterprise Profit (EP)
	// - Text
	By arca_csc_beforeSimulationEPText = By
			// Here the 4 denotes the 4th path tag having class as point and next to it is
			// of the text
			.xpath("(//*[name()='form']//following::*[name()='g' and contains(@class,'point')])[5]/*[name()='text']");

	// xpath of the Estimated Impact - After - Simulation - Enterprise Profit (EP) -
	// Text
	By arca_csc_afterSimulationEPText = By
			// Here the 4 denotes the 4th path tag having class as point and next to it is
			// of the text
			.xpath("(//*[name()='form']//following::*[name()='g' and contains(@class,'point')])[last()]/*[name()='text']");

	// xpath's for the Enforce Per Order Charge simulation (EPOC)
	// xpath of the Enforce Per Order Charge simulation text
	By arca_csc_simulationEPOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[12]/div[1]/fieldset[1]/div[1]/label[1]/span[2]");

	// xpath of the Enforce Per Order Charge simulation - % Sales input
	By arca_csc_salesInputEPOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[14]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the Enforce Per Order Charge simulation - Flat $ input
	By arca_csc_flatInputEPOC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[17]/div[1]/div[1]/div[1]/input[1]");

	// --->Create Scenario - Enforce Per Return Surcharge (EPRS)
	// xpath of the %Sales - EPRS
	By arca_csc_salesInputEPRS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[20]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the Flat$ - EPRS
	By arca_csc_flatInputEPRS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[23]/div[1]/div[1]/div[1]/input[1]");

	// xpath of the EPRS - Text
	By arca_csc_simulationEPRS = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[18]/div[1]/fieldset[1]/div[1]/label[1]");

	// Simulation using Eliminate System Pricing Overrides
	// Surcharge

	// xpath of the simulation text
	By arca_csc_simulationESPO = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[24]/div[1]/fieldset[1]/div[1]/label[1]");

	// xpath of the toggle - ESPO
	By arca_csc_toggleESPO = By
			.xpath("//span[contains(@class, 'MuiIconButton-label')]//span[contains(@class, 'MuiSwitch-thumb')]");

	// xpath of the ESPO error message when selected without toggline
	By arca_csc_errorWithoutToggle = By
			.xpath("//h4[contains(text(),'Please enter the required metric values to proceed')]");

	// Simulation using Move To A New Customer Price Class
	// xpath of the simulation text
	By arca_csc_simulationMNCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[26]/div[1]/fieldset[1]/div[1]/label[1]");

	// xpath of the price class dropdown
	By arca_csc_priceClassDropdownMNCPC = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[28]/div[1]/div[1]/div[1]/div[1]");

	// xpath of the price class dropdown - value (CCASHN1)
	By arca_csc_priceClassDropdownValueMNCPC = By.xpath("(//ul[contains(@class,'MuiMenu-list')]/li)[5]");

	// xpath of the after simulation
	By arca_csc_afterSimulationChart = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]");

	// Loads the Create Scenario Screen

	public void navigateTo() throws IOException, InterruptedException {
		// This gets the URL of the Create Scenario screen
		driver.get(ConfigReader.arca_createScenario());
		// waits for the Pre-programmed Scenario widget
		waitForElement(arca_csc_preProgrammedScenario);
		Thread.sleep(2000);
		waitForElement(arca_csc_estimatedImpact);
		// Take screenshot after the page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File(
				"src/test/resources/screenshots/AutoRootCauseAnalysis/ScenarioBuilder/CreateScenario/CreateScenarioScreen.png");
		FileHandler.copy(sourcefile, screenshotPath);
		// Verify whether it landed on the Scenario builder - View Scenario Impact
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.arca_createScenario();

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"=> Unexpected Redirection and landed on wrong screen - The Current URL you're on: " + currentUrl);
		}
		System.out.println(
				"=> Successfully landed on the Create Scenario with the Pre-Programmed Scenario and Estimated Impact widgets which are required to simulate the scenario");
	}

	private String filtercustomerId, ppsCustomerId;

	// Clicks on the filters and perform actions
	public void filters() throws IOException, InterruptedException {
		// waits for the Filters btn
		WebElement csc_filtersBtn = waitForElement(arca_csc_filtersBtn);
		csc_filtersBtn.click();
		// waits for the Filters - Customer Product combination option
		WebElement csc_filtersOptions = waitForElement(arca_csc_filtersOptions);
		csc_filtersOptions.click();
		WebElement csc_filterOptionsValue = waitForElement(arca_csc_filterOptionsValue);
		String filterOptionsValue = csc_filterOptionsValue.getText().trim();
		// stores only the Customer Id from the filter
		this.filtercustomerId = filterOptionsValue.split("_")[0].trim();

		// waits for the headerText of the Pre-Programmed Scneario (PPS)
		WebElement csc_headerTextPPS = waitForElement(arca_csc_headerTextPPS);
		String headerTextPPS = csc_headerTextPPS.getText().trim();
		// stores only the Customer Id from the header text
		// this \\D+ : matches one or more non-digit characters and "" will remove
		// everything that is not digit
		this.ppsCustomerId = headerTextPPS.replaceAll("\\D+", "");
		// Validating the Customer details
		if (!ppsCustomerId.equalsIgnoreCase(filtercustomerId)) {
			throw new AssertionError("=> Mismatch in the Customer ID | Filter = [" + filtercustomerId
					+ "] vs HeaderText = [" + ppsCustomerId + "]");
		}
		System.out.println("=> The Customer ID's: " + ppsCustomerId + " matched and confirms the: " + filterOptionsValue
				+ " customer and product combination is loaded for the simulation");
		Thread.sleep(2000);
		// waits for the Filter - Cancel btn
		WebElement csc_filterCancel = waitForElement(arca_csc_filterCancel);
		csc_filterCancel.click();
		// waits for the Pre-programmed Scenario widget
		waitForElement(arca_csc_preProgrammedScenario);
		Thread.sleep(2000);
		waitForElement(arca_csc_estimatedImpact);
	}

	// Clicks the Customer Details btn
	public void customerDetailsBtn() throws IOException, InterruptedException {
		// waits for the Customer Details btn
		WebElement csc_customerDetailsBtn = waitForElement(arca_csc_customerDetailsBtn);
		csc_customerDetailsBtn.click();
		// waits for the Select Target Customer for Simulation - Table First Row -
		// Customer ID
		WebElement csc_firstRowCustomerIdSTS = waitForElement(arca_csc_firstRowCustomerIdSTS);
		String firstRowCustomerIdSTS = csc_firstRowCustomerIdSTS.getText().trim();
		// validates
		if (!firstRowCustomerIdSTS.equalsIgnoreCase(filtercustomerId)) {
			throw new AssertionError("=> Mismatch in the Customer ID | Filter = [" + filtercustomerId
					+ "] vs HeaderText of the STS table = [" + firstRowCustomerIdSTS + "]");
		}
		System.out.println("=> The Customer ID's: " + firstRowCustomerIdSTS
				+ " matched and confirms the same customer and product combination is displayed in the Selected Target Customer for Simulation table of the pop-up");
		Thread.sleep(2000);
		// waits for the Selected Target for Simulation - Download icon
		WebElement csc_downloadIconSTC = waitForElement(arca_csc_downloadIconSTC);
		csc_downloadIconSTC.click();
		Thread.sleep(1000);
		// waits for the Selected Product for Root Cause Analysis (SPRCA) - Download
		// icon
		WebElement csc_downloadIconSPRCA = waitForElement(arca_csc_downloadIconSPRCA);
		csc_downloadIconSPRCA.click();
		System.out.println("=> Downloaded the table records of both table");
		// wait for the close icon of the pop-up
		WebElement csc_closeIconSTS = waitForElement(arca_csc_closeIconSTS);
		csc_closeIconSTS.click();
		Thread.sleep(1000);
		// waits for the Pre-programmed Scenario widget
		waitForElement(arca_csc_preProgrammedScenario);
		Thread.sleep(2000);
		waitForElement(arca_csc_estimatedImpact);
	}

	// clicks on the create scenario button
//	@SuppressWarnings("finally")
	public int createScenarioBtn() throws IOException, InterruptedException {
		// waits for the Pre-programmed Scenario widget
		waitForElement(arca_csc_preProgrammedScenario);
		// waits for the create scenario button
		WebElement csc_createScenarioBtnPPS = waitForElement(arca_csc_createScenarioBtnPPS);
		csc_createScenarioBtnPPS.click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", csc_createScenarioBtnPPS);

		Thread.sleep(1000);

		try {
//			 checks for the Error message present or not
//			 If it present then will skip other steps
			if (isElementPresent(arca_csc_estimatedImpactError)) {
				WebElement errorTextMessage = waitForElement(arca_csc_estimatedImpactError);
				String errorText = errorTextMessage.getText().trim();

				if (errorText.equalsIgnoreCase("Please create a scenario to visualise impact!")) {
					System.out.println(
							"=> The Error message to create scenario is displayed - So Scenario is not created");
					return 1; // Skip further checks
				}
			}
		} catch (Exception e) {
			// Check if Estimated Impact widget is visible
			if (isElementPresent(arca_csc_estimatedImpact)) {
				System.out.println(
						"=> Estimated Impact widget is loaded and proceeding to validate the Enterprise Profit");
				try {
					waitForElement(arca_csc_estimatedImpact);
				} catch (Exception ex) {
					waitForElement(arca_csc_estimatedImpact);
				}

				// waits for the Before Simulation - Enterprise Profit - Text
				WebElement csc_beforeSimulationEPText = waitForElement(arca_csc_beforeSimulationEPText);
				actions.moveToElement(csc_beforeSimulationEPText).click().perform();
				String beforeSimulationEPText = csc_beforeSimulationEPText.getText().trim();
				System.out.println(beforeSimulationEPText);

				// waits for the After Simulation - Enterprise Profit - Text
				waitForElement(arca_csc_afterSimulationChart);
				WebElement csc_afterSimulationEPText = waitForElement(arca_csc_afterSimulationEPText);
				actions.moveToElement(csc_afterSimulationEPText).click().perform();
				String afterSimulationEPText = csc_afterSimulationEPText.getText().trim();
				System.out.println(afterSimulationEPText);
				// Check if both are same or not
				if (!beforeSimulationEPText.equalsIgnoreCase(afterSimulationEPText)) {
					System.out.println(
							"=> The Enterprise Profit values of Estimated Impact - Before and After are not matching");
					return 0; // Success case
				} else {
					System.out.println(
							"=> The Enterprise Profit values of Estimated Impact - Before and After are matching");
					return 1; // Failure case
				}
			} else {
				System.out.println("=> Estimated Impact widget is NOT loaded.");
				return 1; // Return failure if widget is not visible

			}
		}
		return 0;
	}

	// This is check whether the element is present or not
	public boolean isElementPresent(By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// clicks on the create scenario button
	public void saveScenarioWithoutNameBtn() throws IOException, InterruptedException {
		// waits for the Save Scenario Button

		waitForElement(arca_csc_estimatedImpact);
		WebElement csc_saveScenarioEI = waitForElement(arca_csc_saveScenarioEI);
		actions.moveToElement(csc_saveScenarioEI).click().perform();

		// Function to validate the error message
		errorMessageSaveScenario();
		System.out.println("=> The Save Scenario button was clicked without entering the scenario name");
		Thread.sleep(2000);
		waitForElement(arca_csc_estimatedImpact);
	}

	// Error message - Save Scenario
	public void errorMessageSaveScenario() {
		// Assertion
		// Assertion to confirm message text
		WebElement errorToasterMessage = waitForElement(arca_csc_errorMessageSaveScenariobtn);
		String actualMsg = errorToasterMessage.getText();
		actions.moveToElement(errorToasterMessage).click().perform();
		String expectedMsg = "We can't proceed without a valid value";
		Assert.assertEquals("=> The Error Toaster message validation for the Save Scenario button has failed!",
				expectedMsg, actualMsg);
	}

	// Success Message - Save Scenario
	public void successMessageSaveScenario() {
		// Assertion
		// Assertion to confirm message text
		waitForElement(arca_csc_estimatedImpact);
		WebElement successToasterMessage = waitForElement(arca_csc_successMessage);
		String actualMsg = successToasterMessage.getText();
		String expectedMsg = "✅ Your scenario results have been successfully saved! 🎉";
		Assert.assertEquals("=> The Success Toaster message validation for the Save Scenario button has failed!",
				expectedMsg, actualMsg);
	}

	// Clicks save scenario after entering scenario name
	public void saveScenarioWithNameBtn() throws IOException, InterruptedException {
		// waits for the Scenario name input field
		WebElement csc_inputScenarioName = waitForElement(arca_csc_inputScenarioName);

		String scenarioName = ppsCustomerId + " Scenario";

		csc_inputScenarioName.sendKeys(scenarioName);
		Thread.sleep(1000);
		// waits for the save scenario button
		WebElement csc_saveScenarioEI = waitForElement(arca_csc_saveScenarioEI);
		actions.moveToElement(csc_saveScenarioEI).click().perform();
		successMessageSaveScenario();
		System.out.println("=> Successfully, The Scenario has been created and named as: " + scenarioName);
		try {
			waitForElement(arca_csc_estimatedImpact);
		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpact);

		}
		Thread.sleep(1000);
	}

	// Create Scenario based on the % Order change in Order $ Sales simulator
	// Hovers and move the Siders
	public void moveSlider() throws IOException, InterruptedException {
		// waits for the % Change in Order $ Sales - Slider to Simulator Changes in
		// Sales
		waitForElement(arca_csc_preProgrammedScenario);
		waitForElement(arca_csc_estimatedImpact);
		WebElement csc_silderSSCS = waitForElement(arca_csc_silderSSCS);
		actions.moveToElement(csc_silderSSCS, -10, 0).clickAndHold().moveByOffset(70, 0).release().perform();
		Thread.sleep(3000);
		// waits for the % Change in Order $ Sales - Current Sales (Before Simulation)
		WebElement csc_silderCusrrentSales = waitForElement(arca_csc_silderCusrrentSales);
		actions.moveToElement(csc_silderCusrrentSales, -10, 0).perform();
		Thread.sleep(3000);
	}

	// Clicks on the reset simulation button of PPS
	public void resetPPS() throws IOException, InterruptedException {
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception ee) {
			waitForElement(arca_csc_estimatedImpact);
//			waitForElement(arca_csc_estimatedImpactError);
		}
		// waits for the reset simulation button of PPS
		WebElement csc_resetSimulationBtnPPS = waitForElement(arca_csc_resetSimulationBtnPPS);
		csc_resetSimulationBtnPPS.click();
		System.out.println("=> The Reset Simulation of Pre Programmed Scenario is clicked and the widget is reloaded");
		try {
			waitForElement(arca_csc_estimatedImpact);
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_createScenarioBtnPPS);
		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpact);
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_createScenarioBtnPPS);

		}

	}

	// Hovers and move the Siders again
	public void moveSliderAgain() throws IOException, InterruptedException {
		// waits for the % Change in Order $ Sales - Slider to Simulator Changes in
		// Sales
		waitForElement(arca_csc_preProgrammedScenario);
		waitForElement(arca_csc_estimatedImpact);
		Thread.sleep(5000);
		WebElement csc_silderSSCS = waitForElement(arca_csc_silderSSCS);
		actions.moveToElement(csc_silderSSCS, -10, 0).clickAndHold().moveByOffset(90, 0).release().perform();
		Thread.sleep(5000);
		// waits for the % Change in Order $ Sales - Current Sales (Before Simulation)
		WebElement csc_silderCusrrentSales = waitForElement(arca_csc_silderCusrrentSales);
		actions.moveToElement(csc_silderCusrrentSales, -10, 0).perform();
		Thread.sleep(5000);
	}

	// Clicks on the reset simulation button of Estimated Impact widget (EI)
	public void resetEI() throws IOException, InterruptedException {

		try {
			waitForElement(arca_csc_estimatedImpact);
		} catch (Exception ee) {
			waitForElement(arca_csc_estimatedImpact);
		}

		WebElement csc_resetSimulationBtnEI = waitForElement(arca_csc_resetSimulationBtnEI);
		csc_resetSimulationBtnEI.click();
		System.out.println("=> The Reset Simulation of Estimated Impact is clicked and the widget is reloaded");

		try {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_createScenarioBtnPPS);
		} catch (Exception e) {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);

		}
		Thread.sleep(1000);
	}

	// Enter the value to the slider component
	public void enterValueSales() throws IOException, InterruptedException {
		// waits for the input field to enter the value
		try {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);
		}
		Thread.sleep(3000);
		WebElement csc_numericValueSales = waitForElement(arca_csc_numericValueSales);
		csc_numericValueSales.click();
		csc_numericValueSales.sendKeys(Keys.CONTROL + "a");
		csc_numericValueSales.sendKeys(Keys.BACK_SPACE);
		// Enter the value
		csc_numericValueSales.sendKeys("40");

		waitForElement(arca_csc_preProgrammedScenario);
		waitForElement(arca_csc_estimatedImpact);
		Thread.sleep(5000); // Hovers on the slider
		WebElement csc_silderSSCS = waitForElement(arca_csc_silderSSCS);
		actions.moveToElement(csc_silderSSCS, -10, 0).perform();
		Thread.sleep(5000);
		// waits for the % Change in Order $ Sales - Current Sales (Before Simulation)
		WebElement csc_silderCusrrentSales = waitForElement(arca_csc_silderCusrrentSales);
		actions.moveToElement(csc_silderCusrrentSales, -10, 0).perform();
		Thread.sleep(5000);

	}

	// Clicks the download icon of the Estimated Impact- Before Simulation
	public void downloadBefore() throws IOException, InterruptedException {
		waitForElement(arca_csc_estimatedImpact);
		waitForElement(arca_csc_beforeSimulation);
		Thread.sleep(4000);
		// waits for the download icon of before simulation
		WebElement csc_downloadBefore = waitForElement(arca_csc_downloadBefore);
		csc_downloadBefore.click();
		System.out.println("=> The Before Simulation chart was downloaded");
	}

	// Clicks the download icon of the Estimated Impact- After Simulation
	public void downloadAfter() throws IOException, InterruptedException {
		waitForElement(arca_csc_estimatedImpact);
		waitForElement(arca_csc_afterSimulation);
		Thread.sleep(4000);
		// waits for the download icon of before simulation
		WebElement csc_downloadAfter = waitForElement(arca_csc_downloadAfter);
		csc_downloadAfter.click();
		System.out.println("=> The Before Simulation chart was downloaded");
	}

	// --->Create Scenario - Simulation using Enforce Per Order Charge
	// Enters %Sale and Flat $ value without selecting the simulation
	public void enterBothValueEPOC() throws IOException, InterruptedException {
		waitForElement(arca_csc_simulationEPOC);
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);

		}

		// waits for the Sales Input
		System.out.println("----------------------------* Enforce Per Order Charge *---------------------------");
		WebElement csc_salesInputEPOC = waitForElement(arca_csc_salesInputEPOC);
		csc_salesInputEPOC.click();
		csc_salesInputEPOC.sendKeys(Keys.CONTROL + "a");
		csc_salesInputEPOC.sendKeys(Keys.BACK_SPACE);
		Double salesValue = 20.5;
		csc_salesInputEPOC.sendKeys(String.valueOf(salesValue));
		waitForElement(arca_csc_salesInputEPOC);
		Thread.sleep(1000);

		// waits for the flat input

		WebElement csc_flatInputEPOC = waitForElement(arca_csc_flatInputEPOC);
		csc_flatInputEPOC.click();
		csc_flatInputEPOC.sendKeys(Keys.CONTROL + "a");
		csc_flatInputEPOC.sendKeys(Keys.BACK_SPACE);
		Double flatValue = 23.0;
		csc_flatInputEPOC.sendKeys(String.valueOf(flatValue));
		waitForElement(arca_csc_flatInputEPOC);
		Thread.sleep(1000);

		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println("=> SUCCESS: The Scenario is not created even after entering the values of %Sales: "
					+ String.format("%.2f", salesValue) + " and Flat$: " + String.format("%.2f", flatValue)
					+ "  as the Enforce Per Order charge simulation is not selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenario has been created without selecting the Enforce Per Order Charge simulation.");
		}
	}

	// --->Create Scenario - Simulation using Enforce Per Order Charge
	// Enters %Sale and Flat $ value by also selecting the simulation
	public void selectAndenterBothValueEPOC() throws IOException, InterruptedException {
		WebElement csc_simulationEPOC = waitForElement(arca_csc_simulationEPOC);
		csc_simulationEPOC.click();
		// waits for the Sales Input

		WebElement csc_salesInputEPOC = waitForElement(arca_csc_salesInputEPOC);
		csc_salesInputEPOC.click();
		csc_salesInputEPOC.sendKeys(Keys.CONTROL + "a");
		csc_salesInputEPOC.sendKeys(Keys.BACK_SPACE);
		Double salesValue = 20.5;
		csc_salesInputEPOC.sendKeys(String.valueOf(salesValue));
		waitForElement(arca_csc_salesInputEPOC);
		Thread.sleep(1000);

		// waits for the flat input

		WebElement csc_flatInputEPOC = waitForElement(arca_csc_flatInputEPOC);
		csc_flatInputEPOC.click();
		csc_flatInputEPOC.sendKeys(Keys.CONTROL + "a");
		csc_flatInputEPOC.sendKeys(Keys.BACK_SPACE);
		Double flatValue = 23.0;
		csc_flatInputEPOC.sendKeys(String.valueOf(flatValue));
		waitForElement(arca_csc_flatInputEPOC);
		Thread.sleep(1000);

		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println("=> SUCCESS: The Scenario is  created by entering the values of %Sales: "
					+ String.format("%.2f", salesValue) + " and Flat$: " + String.format("%.2f", flatValue)
					+ "  and also selecting the Enforce Per Order charge simulation.");
		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been not created even after entering the value and selecting the Enforce Per Order Charge simulation.");
		}
	}

	// --->Create Scenario - Simulation using Enforce Per Order Charge
	// Enters %Sale value and clicks create scenario button without selecting the
	// simulation
	// simulation
	public void enterSalesValueWithoutSelectingEPOC() throws IOException, InterruptedException {
		// waits for the simulation
		waitForElement(arca_csc_simulationEPOC);
		try {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception ee) {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);
		}

		// waits for the Sales Input

		WebElement csc_salesInputEPOC = waitForElement(arca_csc_salesInputEPOC);
		csc_salesInputEPOC.click();
		csc_salesInputEPOC.sendKeys(Keys.CONTROL + "a");
		csc_salesInputEPOC.sendKeys(Keys.BACK_SPACE);
		Double salesValue = 20.5;
		csc_salesInputEPOC.sendKeys(String.valueOf(salesValue));
		waitForElement(arca_csc_salesInputEPOC);
		Thread.sleep(1000);

		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println("=> SUCCESS: The Scenario is not created even after entering the %Sales value : "
					+ String.format("%.2f", salesValue)
					+ " as the Enforce Per Order charge simulation is not selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been create without selecting the Enforce Per Order Charge simulation.");
		}
		Thread.sleep(1000);
	}

	// Enters %Sale value and clicks create scenario button after selecting the
	// simulation
	public void enterSalesValueWithSelectingEPOC() throws IOException, InterruptedException {
		try {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception ee) {
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_estimatedImpact);
		}
		// waits for the simulation
		WebElement csc_simulationEPOC = waitForElement(arca_csc_simulationEPOC);
		csc_simulationEPOC.click();
		// waits for the Sales Input
		WebElement csc_salesInputEPOC = waitForElement(arca_csc_salesInputEPOC);
		csc_salesInputEPOC.click();
		csc_salesInputEPOC.sendKeys(Keys.CONTROL + "a");
		csc_salesInputEPOC.sendKeys(Keys.BACK_SPACE);
		Double salesValue = 20.5;
		csc_salesInputEPOC.sendKeys(String.valueOf(salesValue));
		waitForElement(arca_csc_salesInputEPOC);
		Thread.sleep(2000);
		int result = createScenarioBtn();

		if (result == 0) {
			System.out.println("=> SUCCESS: The Scenario has been created by entering the %Sales value: "
					+ String.format("%.2f", salesValue)
					+ " and selecting the Enforce Per Order charge simulation is selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been not created even after selecting the Enforce Per Order Charge simulation.");
		}
	}

	// Enters Flat$ value and clicks create scenario button without selecting the
	// simulation
	public void enterFlatValueWithoutSelectingEPOC() throws IOException, InterruptedException {

		try {

			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_simulationEPOC);
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {

			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_simulationEPOC);
			waitForElement(arca_csc_estimatedImpact);
		}
		// waits for the Simulation - Text
		waitForElement(arca_csc_flatInputEPOC);
		// waits for the flat input
		WebElement csc_flatInputEPOC = waitForElement(arca_csc_flatInputEPOC);
		csc_flatInputEPOC.click();
		csc_flatInputEPOC.sendKeys(Keys.CONTROL + "a");
		csc_flatInputEPOC.sendKeys(Keys.BACK_SPACE);
		Double flatValue = 23.0;
		csc_flatInputEPOC.sendKeys(String.valueOf(flatValue));
		waitForElement(arca_csc_flatInputEPOC);
		Thread.sleep(1000);

		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println("=> SUCCESS: The Scenario is not created even after entering the Flat $ value: "
					+ String.format("%.2f", flatValue)
					+ " as the Enforce Per Order charge simulation is not selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been created without selecting the Enforce Per Order Charge simulation.");
		}
	}

	// Enters %Sale value and clicks create scenario button after selecting the
	// simulation
	public void enterFlatValueWithSelectingEPOC() throws IOException, InterruptedException {
		// waits for the simulation
		WebElement csc_simulationEPOC = waitForElement(arca_csc_simulationEPOC);
		csc_simulationEPOC.click();
		// waits for the flat input
		WebElement csc_flatInputEPOC = waitForElement(arca_csc_flatInputEPOC);
		csc_flatInputEPOC.click();
		csc_flatInputEPOC.sendKeys(Keys.CONTROL + "a");
		csc_flatInputEPOC.sendKeys(Keys.BACK_SPACE);
		Double flatValue = 23.0;
		csc_flatInputEPOC.sendKeys(String.valueOf(flatValue));
		waitForElement(arca_csc_flatInputEPOC);
		Thread.sleep(1000);
		int result = createScenarioBtn();

		if (result == 0) {
			System.out.println("=> SUCCESS: The Scenario has been created by entering the Flat $ value: "
					+ String.format("%.2f", flatValue)
					+ "  and selecting the Enforce Per Order charge simulation is selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been not created even after selecting the Enforce Per Order Charge simulation.");
		}
	}

	// --->Create Scenario - Simulation using Enforce Per Return Surcharge (EPRS)
	// Enters %Sales and Flat$ value
	public void enterBothValueEPRS() throws IOException, InterruptedException {
		System.out.println("----------------------------* Enforce Per Return Surcharge *---------------------------");

		waitForElement(arca_csc_simulationEPRS);
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);

		}
		// waits for the Sales input
		WebElement csc_salesInputEPRS = waitForElement(arca_csc_salesInputEPRS);
		csc_salesInputEPRS.click();
		csc_salesInputEPRS.sendKeys(Keys.CONTROL + "a");
		csc_salesInputEPRS.sendKeys(Keys.BACK_SPACE);
		Double salesValue = 20.5;
		csc_salesInputEPRS.sendKeys(String.valueOf(salesValue));
		waitForElement(arca_csc_salesInputEPRS);
		Thread.sleep(1000);

		// waits for the flat input
		WebElement csc_flatInputEPRS = waitForElement(arca_csc_flatInputEPRS);
		csc_flatInputEPRS.click();
		csc_flatInputEPRS.sendKeys(Keys.CONTROL + "a");
		csc_flatInputEPRS.sendKeys(Keys.BACK_SPACE);
		Double flatValue = 23.0;
		csc_flatInputEPRS.sendKeys(String.valueOf(flatValue));
		waitForElement(arca_csc_flatInputEPRS);
		Thread.sleep(3000);

		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println("=> SUCCESS: The Scenario is not created even after entering the values of %Sales: "
					+ String.format("%.2f", salesValue) + " and Flat$: " + String.format("%.2f", flatValue)
					+ "  as the Enforce Per Return Surcharge simulation is not selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenario has been created without selecting the Enforce Per Return Surcharge simulation.");
		}

		try {
			waitForElement(arca_csc_estimatedImpact);
		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpact);
		}
		Thread.sleep(1000);
	}

	// Selects and enter both the value
	public void selectAndenterBothValueEPRS() throws IOException, InterruptedException {
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);

		}
		// waits for the EPRS Simulation text
		WebElement csc_simulationEPRS = waitForElement(arca_csc_simulationEPRS);
		csc_simulationEPRS.click();
		//
		WebElement csc_salesInputEPRS = waitForElement(arca_csc_salesInputEPRS);
		csc_salesInputEPRS.click();
		csc_salesInputEPRS.sendKeys(Keys.CONTROL + "a");
		csc_salesInputEPRS.sendKeys(Keys.BACK_SPACE);
		Double salesValue = 20.5;
		csc_salesInputEPRS.sendKeys(String.valueOf(salesValue));
		waitForElement(arca_csc_salesInputEPRS);
		Thread.sleep(1000);

		// waits for the flat input
		WebElement csc_flatInputEPRS = waitForElement(arca_csc_flatInputEPRS);
		csc_flatInputEPRS.click();
		csc_flatInputEPRS.sendKeys(Keys.CONTROL + "a");
		csc_flatInputEPRS.sendKeys(Keys.BACK_SPACE);
		Double flatValue = 23.0;
		csc_flatInputEPRS.sendKeys(String.valueOf(flatValue));
		waitForElement(arca_csc_flatInputEPRS);
		Thread.sleep(2000);

		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println("=> SUCCESS: The Scenario is not created even after entering the values of %Sales: "
					+ String.format("%.2f", salesValue) + " and Flat$: " + String.format("%.2f", flatValue)
					+ "  as the Enforce Per Order charge simulation is also selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenario has been created even after entering %Sales and Flat$ value and selecting the Enforce Per Return Surcharge simulation.");
		}

	}

	// Enforce Per Return Surcharge
	// Enters %Sale value and clicks create scenario button without selecting the
	// simulation
	// simulation
	public void enterSalesValueWithoutSelectingEPRS() throws IOException, InterruptedException {
		// waits for the simulation
		waitForElement(arca_csc_simulationEPRS);
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);

		}

		// waits for the Sales Input

		WebElement csc_salesInputEPRS = waitForElement(arca_csc_salesInputEPRS);
		csc_salesInputEPRS.click();
		csc_salesInputEPRS.sendKeys(Keys.CONTROL + "a");
		csc_salesInputEPRS.sendKeys(Keys.BACK_SPACE);
		Double salesValue = 20.5;
		csc_salesInputEPRS.sendKeys(String.valueOf(salesValue));
		waitForElement(arca_csc_salesInputEPOC);
		Thread.sleep(5000);
		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println("=> SUCCESS: The Scenario is not created even after entering the %Sales value : "
					+ String.format("%.2f", salesValue)
					+ " as the Enforce Per Return Suracharge simulation is not selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been create without selecting the Enforce Per Return Suracharge simulation");
		}
	}

	// Enforce Per Return Surcharge
	// Enters %Sale value and clicks create scenario button without selecting the
	// simulation
	// simulation
	public void enterSalesValueWithSelectingEPRS() throws IOException, InterruptedException {
		try {
			waitForElement(arca_csc_estimatedImpact);
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_simulationEPRS);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpact);
			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_simulationEPRS);
			waitForElement(arca_csc_estimatedImpact);
		}
		// waits for the simulation
		WebElement csc_simulationEPRS = waitForElement(arca_csc_simulationEPRS);
		csc_simulationEPRS.click();
		// waits for the Sales Input

		WebElement csc_salesInputEPRS = waitForElement(arca_csc_salesInputEPRS);
		csc_salesInputEPRS.click();
		csc_salesInputEPRS.sendKeys(Keys.CONTROL + "a");
		csc_salesInputEPRS.sendKeys(Keys.BACK_SPACE);
		Double salesValue = 20.5;
		csc_salesInputEPRS.sendKeys(String.valueOf(salesValue));
		waitForElement(arca_csc_salesInputEPOC);
		Thread.sleep(1000);
		int result = createScenarioBtn();

		if (result == 0) {
			System.out.println("=> SUCCESS: The Scenario is created after entering the %Sales value : "
					+ String.format("%.2f", salesValue)
					+ " as the Enforce Per Return Suracharge simulation is selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenario is not created as Enforce Per Return Surcharge simulation is not selected");
		}
	}

	// Enters Flat$ value and clicks create scenario button without selecting the
	// simulation
	public void enterFlatValueWithoutSelectingEPRS() throws IOException, InterruptedException {
		try {

			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_simulationEPRS);
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {

			waitForElement(arca_csc_preProgrammedScenario);
			waitForElement(arca_csc_simulationEPRS);
			waitForElement(arca_csc_estimatedImpact);
		}
		// waits for the simulation
		waitForElement(arca_csc_simulationEPRS);
		// waits for the flat input
		WebElement csc_flatInputEPRS = waitForElement(arca_csc_flatInputEPRS);
		csc_flatInputEPRS.click();
		csc_flatInputEPRS.sendKeys(Keys.CONTROL + "a");
		csc_flatInputEPRS.sendKeys(Keys.BACK_SPACE);
		Double flatValue = 23.0;
		csc_flatInputEPRS.sendKeys(String.valueOf(flatValue));
		waitForElement(arca_csc_flatInputEPOC);
		Thread.sleep(1000);

		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println("=> SUCCESS: The Scenario is not created even after entering the Flat $ value: "
					+ String.format("%.2f", flatValue)
					+ " as the Enforce Per Return Surcharge simulation is not selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been created without selecting the Enforce Per Return Surcharge");
		}
	}

	// Enters %Sale value and clicks create scenario button after selecting the
	// simulation
	public void enterFlatValueWithSelectingEPRS() throws IOException, InterruptedException {
		// waits for the simulation
		WebElement csc_simulationEPRS = waitForElement(arca_csc_simulationEPRS);
		csc_simulationEPRS.click();
		// waits for the flat input
		WebElement csc_flatInputEPRS = waitForElement(arca_csc_flatInputEPRS);
		csc_flatInputEPRS.click();
		csc_flatInputEPRS.sendKeys(Keys.CONTROL + "a");
		csc_flatInputEPRS.sendKeys(Keys.BACK_SPACE);
		Double flatValue = 23.0;
		csc_flatInputEPRS.sendKeys(String.valueOf(flatValue));
		waitForElement(arca_csc_flatInputEPRS);
		Thread.sleep(1000);
		int result = createScenarioBtn();

		if (result == 0) {
			System.out.println("=> SUCCESS: The Scenario has been created by entering the Flat $ value: "
					+ String.format("%.2f", flatValue)
					+ "  and selecting the Enforce Per Return Surcharge simulation is selected.");
		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been not created even after selecting the Enforce Per Return Surcharge simulation.");
		}
	}

	// --->Create Scenario - Simulation using Eliminate System Pricing Overrides
	// Surcharge
	// Clicks only the toggle of ESPO
	public void togglesESPO() throws IOException, InterruptedException {
		// waits for the simulation
		waitForElement(arca_csc_simulationESPO);
		System.out.println(
				"----------------------------* Eliminate System Pricing Overrides *---------------------------");

		waitForElement(arca_csc_simulationESPO);
		// waits for the toggle button of ESPO
		WebElement csc_toggleESPO = waitForElement(arca_csc_toggleESPO);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", csc_toggleESPO);
		boolean isOn = csc_toggleESPO.isSelected();
		System.out.println("Toggle is currently: " + (isOn ? "ON" : "OFF"));
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);

		}
		// create scenario
		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println(
					"=> SUCCESS: The Scenario has not been created as the Simulation using Eliminate System Pricing Overrides Surcharge is not selected ");

		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been created even after without selecting the Simulation using Eliminate System Pricing Overrides Surcharge");
		}
	}

	// Selects the ESPO
	public void selectsESPO() throws IOException, InterruptedException {
		// waits for the simulation
		WebElement csc_simulationESPO = waitForElement(arca_csc_simulationESPO);
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);

		}
		csc_simulationESPO.click();
		// waits for the toggle button of ESPO
//		WebElement csc_toggleESPO = waitForElement(arca_csc_toggleESPO);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", csc_toggleESPO);
//		boolean isOn = csc_toggleESPO.isSelected();
//		System.out.println("Toggle is currently: " + (isOn ? "ON" : "OFF"));
		waitForElement(arca_csc_simulationESPO);
		Thread.sleep(1000);
		// create scenario
		WebElement csc_createScenarioBtnPPS = waitForElement(arca_csc_createScenarioBtnPPS);
		csc_createScenarioBtnPPS.click();
		Thread.sleep(1000);
		errorToasterMessage();
		try {
			waitForElement(arca_csc_estimatedImpact);
		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);
		}
		Thread.sleep(7000);
		System.out.println(
				"=> SUCCESS: The Scenario has not been created as the Simulation using Eliminate System Pricing Overrides Surcharge - Toggle is not clicked ");
	}

	// Validates the error toast message when the ESPO simulation is selected and
	// not toggled
	public void errorToasterMessage() {
		// Assertion for Button clicks
		WebElement csc_errorWithoutToggle = waitForElement(arca_csc_errorWithoutToggle);
		String actualMsg = csc_errorWithoutToggle.getText();
		String expectedMsg = "Please enter the required metric values to proceed!😊";
		Assert.assertEquals(
				"=> The Error Toaster message validated for  Clicking Create Scenario button by selecting the Eliminate System Pricing Overrides Surcharge and not toggling!",
				expectedMsg, actualMsg);
	}

	// Selects and Toggles the ESPO
	public void selectsAndTogglesESPO() throws IOException, InterruptedException {
		// waits for the simulation
		waitForElement(arca_csc_simulationESPO);
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);
		}

		// waits for the toggle button of ESPO
		WebElement csc_toggleESPO = waitForElement(arca_csc_toggleESPO);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", csc_toggleESPO);
		// waits for the simulation to get selected
		WebElement csc_simulationESPO = waitForElement(arca_csc_simulationESPO);
		csc_simulationESPO.click();
		// create scenario
		int result = createScenarioBtn();

		if (result == 0) {
			System.out.println(
					"=> SUCCESS: The Scenario has been created as the Simulation using Eliminate System Pricing Overrides Surcharge is Selected and Toggled ");

		} else {
			System.out.println(
					"=> ERROR: The Scenraio has not been created even after Selecting and Toggling the Simulation using Eliminate System Pricing Overrides Surcharge");
		}

	}

	// --->Create Scenario - Simulation using Move To A New Customer Price Class
	// clicks dropdown and selects a price class
	public void dropdownMNCPC() throws IOException, InterruptedException {
		System.out.println("----------------------------* Move to A New Price Class *---------------------------");
		// waits for the simulation text
		waitForElement(arca_csc_simulationMNCPC);
		try {
			waitForElement(arca_csc_estimatedImpact);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);

		}
		// waits for the dropdown and click
		WebElement csc_priceClassDropdownMNCPC = waitForElement(arca_csc_priceClassDropdownMNCPC);
		csc_priceClassDropdownMNCPC.click();
		// waits for the dropdown - values
		try {
			WebElement csc_priceClassDropdownValueMNCPC = waitForElement(arca_csc_priceClassDropdownValueMNCPC);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", csc_priceClassDropdownValueMNCPC);
			System.out.println("=> The Dropdown option selected successfully.");
		} catch (StaleElementReferenceException stale) {
			System.out.println("=> Element was stale. Retrying fetch and click...");

			WebElement csc_priceClassDropdownValueMNCPC = waitForElement(arca_csc_priceClassDropdownValueMNCPC);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", csc_priceClassDropdownValueMNCPC);
			System.out.println("=> Dropdown option re-fetched and selected.");
		}
//		try {
//			waitForElement(arca_csc_estimatedImpact);
//
//		} catch (Exception e) {
//			waitForElement(arca_csc_estimatedImpactError);
//		}
		waitForElement(arca_csc_simulationMNCPC);
		Thread.sleep(1000);
		// create scenario
		int result = createScenarioBtn();

		if (result == 1) {
			System.out.println(
					"=> SUCCESS: The Scenario has not been created as the Simulation Move To A New Customer Price Class - Price class is Selected from dropdown but the simulation is not selected");

		} else {
			System.out.println(
					"=> ERROR: The Scenraio has been created even without Selecting Simulation Move To A New Customer Price Class");
		}

	}

	// selects the simulation
	public void selectMNCPC() throws IOException, InterruptedException {
		// waits for the simulation
		WebElement csc_simulationMNCPC = waitForElement(arca_csc_simulationMNCPC);
		csc_simulationMNCPC.click();
		Thread.sleep(1000);
		try {
			waitForElement(arca_csc_estimatedImpact);
			
			waitForElement(arca_csc_afterSimulationChart);

		} catch (Exception e) {
			waitForElement(arca_csc_estimatedImpactError);
		}

		// create scenario
		WebElement csc_createScenarioBtnPPS = waitForElement(arca_csc_createScenarioBtnPPS);
		csc_createScenarioBtnPPS.click();
		errorToasterMessage();
		System.out.println(
				"=> SUCCESS: The Scenario has not been created as the Simulation Move To A New Customer Price Class - Price Class from dropdown was not clicked ");
	}

	// selects and clicks the dropdown options
	public void selectAndDropdownMNCPC() throws IOException, InterruptedException {
		// waits for the simulation
		WebElement csc_simulationMNCPC = waitForElement(arca_csc_simulationMNCPC);
		csc_simulationMNCPC.click();
		waitForElement(arca_csc_simulationMNCPC);
		WebElement csc_priceClassDropdownMNCPC = waitForElement(arca_csc_priceClassDropdownMNCPC);
		csc_priceClassDropdownMNCPC.click();
		// waits for the dropdown - values
		try {
			WebElement csc_priceClassDropdownValueMNCPC = waitForElement(arca_csc_priceClassDropdownValueMNCPC);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", csc_priceClassDropdownValueMNCPC);
			System.out.println("=> The Dropdown option selected successfully.");
		} catch (StaleElementReferenceException stale) {
			System.out.println("=> Element was stale. Retrying fetch and click...");

			WebElement csc_priceClassDropdownValueMNCPC = waitForElement(arca_csc_priceClassDropdownValueMNCPC);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", csc_priceClassDropdownValueMNCPC);
			System.out.println("=> Dropdown option re-fetched and selected.");
		}
//		try {
//			waitForElement(arca_csc_estimatedImpact);
//
//		} catch (Exception e) {
//			waitForElement(arca_csc_estimatedImpactError);
//		}
		// Clicks create scenario button
		int result = createScenarioBtn();

		if (result == 0) {
			System.out.println(
					"=> SUCCESS: The Scenario has been created as the Simulation using Simulation using Move To A New Customer Price Class is Selected and clicked the Price Class");

		} else {
			System.out.println(
					"=> ERROR: The Scenraio has not been created even after Selecting and clicking the Price Class of the Simulation using Simulation using Move To A New Customer Price Class");
		}

	}
}
