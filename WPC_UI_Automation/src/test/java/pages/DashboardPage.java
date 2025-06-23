package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

import config.ConfigReader;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;
    //gets driver status
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // ✅ wait initialized once
    }
    //This is 
    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

   By homeScreen = By.xpath("//*[@id=\"bodyContent\"]/div[2]/div[2]");
   //xpath: profile icon
   By ProfileIcon = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/div[2]/div[3]/div[1]");
   //xpath: Customer Peer Analysis Card 
   By CustomerPeerAnalysisCard = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]");
   //xpath: Auto Root Cause Analysis Card
   By AutoRootCauseAnalysisCard = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]");
   //xpath: Customer Peer Analysis Side NavBar
   By CustomerPeerAnalysisSideNavBar = By.xpath("//*[@id='125463']");
   //xpath: Auto Root Cause Analysis Side NavBar
   By AutoRootCauseAnalysisSideNavBar = By.xpath("//*[@id='125464']");
   //xpath: Customer Peer Analysis Side NavBar Options
   By CustomerPeerAnalysisSideNavBarOptions = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]");
 //xpath: Auto Root Cause Analysis Side NavBar Options
   By AutoRootCauseAnalysisSideNavBarOptions = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]");
   
   
   public void navigateTo() throws IOException {
        // Wait for Dashboard page to load by checking known visible element
    	waitForElement(CustomerPeerAnalysisCard);// Gets the button location
        // Take screenshot after the page is fully ready
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        File screenshotPath = new File("src/test/resources/screenshots/dashboard/dashboardScreen.png");
        FileHandler.copy(sourcefile, screenshotPath);
    }

    public void profileIcon() throws IOException, InterruptedException {
    	
        WebElement profileHover = waitForElement(ProfileIcon);
        new Actions(driver).moveToElement(profileHover).perform();
        System.out.println("---Hovered Successfully on the Profile Icon!");

        // Screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        File screenshotPath = new File("src/test/resources/screenshots/dashboard/ProfileIconHover.png");
        FileHandler.copy(sourcefile, screenshotPath);

        Thread.sleep(500);
    }

    public void customerPeerAnalysisCardClick() throws IOException, InterruptedException {
    	WebElement customerPeerAnalysisCard = waitForElement(CustomerPeerAnalysisCard);
    	customerPeerAnalysisCard.click();
        System.out.println("---Clicked Customer Peer Analysis card.");
        
       //Verify whether it landed on the Customer Peer Analysis Card - Overview screen
        String currentUrl = driver.getCurrentUrl();
        String expectedCustomerOverviewUrl = ConfigReader.customerOverview();
        
        if (!currentUrl.equalsIgnoreCase(expectedCustomerOverviewUrl)) {
            throw new AssertionError("--- Customer Peer Analysis Card- Unexpected redirection :( !Current URL you're on: " + currentUrl);
        }
        
        Thread.sleep(10000);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        File screenshotPath = new File("src/test/resources/screenshots/dashboard/CustomerPeerAnalysisCardClick.png");
        FileHandler.copy(sourcefile, screenshotPath);

        driver.navigate().back();
        Thread.sleep(2000);
    }

    public void autoRootCauseAnalysisCardClick() throws IOException, InterruptedException {
        WebElement autoRootCauseAnalysisCard = waitForElement(AutoRootCauseAnalysisCard);
        autoRootCauseAnalysisCard.click();
        System.out.println("---Clicked Auto Root Cause Analysis card.");
        
      //Verify whether it landed on the Auto Root Cause Analysis Card - Overview screen
        String currentUrl = driver.getCurrentUrl();
        String expectedAutoRootCauseUrl = ConfigReader.autorootOverview();
        
        if (!currentUrl.equalsIgnoreCase(expectedAutoRootCauseUrl)) {
            throw new AssertionError("--- Auto Root Cause Analysis Card - Unexpected redirection :( !Current URL you're on: " + currentUrl);
        }
        
        Thread.sleep(10000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        File screenshotPath = new File("src/test/resources/screenshots/dashboard/AutomatedRootCauseAnalysisCardClick.png");
        FileHandler.copy(sourcefile, screenshotPath);

        //This goes back to the dashboard screen
        driver.navigate().back();
        Thread.sleep(2000);
    }

    public void dashboardPageStay() throws IOException, InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = ConfigReader.dashboardUrl();
        //Screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        File screenshotPath = new File("src/test/resources/screenshots/dashboard/StaysOnDashboardScreen.png");
        FileHandler.copy(sourcefile, screenshotPath);

        if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
            throw new AssertionError("--- Dashboard - Unexpected redirection :( !Current URL you're on: " + currentUrl);
        }
    }

	public void customerPeerAnalysisSideNavBar() throws IOException, InterruptedException{
		WebElement customerPeerAnalysisSideNav = waitForElement(CustomerPeerAnalysisSideNavBar);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", customerPeerAnalysis);
//		Thread.sleep(1000);
		new Actions(driver).moveToElement(customerPeerAnalysisSideNav).click().perform();

        System.out.println("--- Customer Peer Analysis Side Navigation is clicked!");
        
      //Verify whether it landed on the Customer Peer Analysis Side NavBar - Overview screen
        String currentUrl = driver.getCurrentUrl();
        String expectedCustomerOverviewUrl = ConfigReader.customerOverview();
        
        if (!currentUrl.equalsIgnoreCase(expectedCustomerOverviewUrl)) {
            throw new AssertionError("--- Customer Peer Analysis Side NavBar - Unexpected redirection :( !Current URL you're on: " + currentUrl);
        }
        Thread.sleep(2000);
 
        // Hover submenu items
        List<WebElement> customerSubOptions = 
        		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
        		(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a")));

        System.out.println("--- Found " + customerSubOptions.size() + " options under Customer Peer Analysis.");
        for (WebElement option : customerSubOptions) {
            new Actions(driver).moveToElement(option).perform();
            System.out.println("--- Hovered: " + option.getText());
            Thread.sleep(2000);
            // Takes Screenshot of the Customer Peer Analysis Side NavBar click
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
            File screenshotPath = new File("src/test/resources/screenshots/dashboard/CustomerPeerAnalysisSideNavBar.png");
            FileHandler.copy(sourcefile, screenshotPath);
            
        }
        // Move back to main
//        new Actions(driver).moveByOffset(-300, 0).perform();
        driver.navigate().back();
        Thread.sleep(1000);
		
	}

	public void autoRootCauseAnalysisSideNavBar() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebElement autoRootSidebar = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='125464']")));
		new Actions(driver).moveToElement(autoRootSidebar).click().perform();
        System.out.println("--- Auto Root Cause Analysis Side Navigation is clicked!");
      //Verify whether it landed on the Auto Root Cause Analysis Side NavBar - Overview screen
        String currentUrl = driver.getCurrentUrl();
        String expectedAutoRootCauseUrl = ConfigReader.autorootOverview();
        
        if (!currentUrl.equalsIgnoreCase(expectedAutoRootCauseUrl)) {
            throw new AssertionError("--- Auto Root Cause Analysis Side NavBar - Unexpected redirection :( !Current URL you're on: " + currentUrl);
        }
        
        Thread.sleep(2000);

        // Hover sub-options under Auto Root
        List<WebElement> autoRootSubOptions = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a")));

        System.out.println("Found " + autoRootSubOptions.size() + " options under Auto Root Cause Analysis.");
        for (WebElement option : autoRootSubOptions) {
        	new Actions(driver).moveToElement(option).perform();
            System.out.println("Hovered: " + option.getText());
            Thread.sleep(2000);
         // Takes Screenshot of the Auto Root Cause Analysis Side NavBar click
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
            File screenshotPath = new File("src/test/resources/screenshots/dashboard/AutoRootCauseAnalysisSideNavBar.png");
            FileHandler.copy(sourcefile, screenshotPath);
        }

        // Move back to dashboard scren
        driver.navigate().back();
        Thread.sleep(1000);
        
	}

	
	
}
