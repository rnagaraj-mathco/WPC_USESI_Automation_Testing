package pages;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    //gets driver status
    public CPA_PeerSelectionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // ✅ wait initialized once
    }
    //Waits for the specified element by locator
    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Peer Selection - 01
    //Select Target Customer for Peer Matching table
    //Entire Table
    By CPA_PS1_SelectTargetCustomerTable = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]");
    //First row record
    By CPA_PS1_SelectTargetCustomerTableFirstRow = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]");
    //SearchField 
    By CPA_PS1_PS1_SearchKeywordSelectTargetCustomer = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
    //Select Customer Button
    By CPA_PS1_SelectCustomerBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/button[1]");
    //Back button
    By CPA_PS1_BackBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/button[1]");
    //Geographical Map 
    By CPA_GeographicalMap = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div");
    //Download button
    By CPA_PS1_DownloadBtn_SelectTargetCustomerTable = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/button[1]");
    
    //Peer Selection -02 
    //Comparative Peer Group Selection table
    By CPA_ComparativePeerGroupSelectionTable = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]");
    //Back button
    By CPA_PS2_BackBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[9]/div[1]/div[1]/button[1]");
    
    
    
    
    
    
    
    
    
    //Loading the Peer Selection Screen
    public void navigateTo() throws IOException, InterruptedException {
    	//This gets the URL of the Branch Customer Selection Screen
  		driver.get(ConfigReader.cpa_peerSelection());
  		//Function waits till the Entire Overview Screen is getting loaded
  		waitForElement(CPA_PS1_SelectTargetCustomerTable);
  	    System.out.println("--- Loaded the Peer Selection -01 Screen where Target customer will be selected for Peer Matching");
  		Thread.sleep(2000);
  		// Take screenshot after the page is fully ready
          TakesScreenshot screenshot = (TakesScreenshot) driver;
          File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
          File screenshotPath = new File("src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PeerSelection_01_Screen.png");
          FileHandler.copy(sourcefile, screenshotPath);	
        //Verify whether it landed on the Customer Peer Analysis Card - Selections - Peer Selection
	      String currentUrl = driver.getCurrentUrl();
	      String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();
	      if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
	          throw new AssertionError("--- Not Landed on the Peer Selection Screen --- Unexpected redirection :( !Current URL you're on: " + currentUrl);
	      }
    	
    }
    //SearchField of Select Target Customer for Peer Matching table
    
    public void searchForKeyword_STC() throws IOException, InterruptedException {
 	   WebElement PS1_SearchKeywordSelectTargetCustomer = waitForElement(CPA_PS1_PS1_SearchKeywordSelectTargetCustomer);
 	  PS1_SearchKeywordSelectTargetCustomer.click();
 	  PS1_SearchKeywordSelectTargetCustomer.clear();
 	  PS1_SearchKeywordSelectTargetCustomer.sendKeys("Nagaraj");
 	   System.out.println("--- Searched: Keyword search was done");
 	    Thread.sleep(5000); 
 	 // Take screenshot after the keyword is searched
         TakesScreenshot screenshot = (TakesScreenshot) driver;
         File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
         File screenshotPath = new File("src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/PS1_SearchKeywordSelectTargetCustomer.png");
         FileHandler.copy(sourcefile, screenshotPath);
         	
         //Clearing the Search Keyword
         PS1_SearchKeywordSelectTargetCustomer.click();
         PS1_SearchKeywordSelectTargetCustomer.sendKeys(Keys.CONTROL + "a");
         PS1_SearchKeywordSelectTargetCustomer.sendKeys(Keys.BACK_SPACE);
         Thread.sleep(2000);
       //This is used to come out of the dropdown overlay effect and click the next locators
//   		Actions actions = new Actions(driver);
//   		actions.moveByOffset(10, 10).click().build().perform();
         System.out.println("--- Searched: Keyword search has been cleared from the search field");
 	    
 	   }
    
    //Select Target Customer Button with selection
  	public void selectCustomerBtnWithSelection() throws IOException, InterruptedException{
  		//finds the first row of the table and clicks as the button gets activated
  		WebElement PS1_SelectTargetCustomerTableFirstRow = waitForElement(CPA_PS1_SelectTargetCustomerTableFirstRow);
  		//waits for the Select Customer button to get load
  		WebElement PS1_SelectCustomerBtn = waitForElement(CPA_PS1_SelectCustomerBtn);
  		
  		PS1_SelectTargetCustomerTableFirstRow.click();
  		System.out.println("--- Clicked: Select Target Customer for Peer Matching Table first row");
  		Thread.sleep(5000);
  		
  		//Clicks the Select Customer button with selection
  		PS1_SelectCustomerBtn.click();
  		System.out.println("--- Clicked: Select Customer Button");
  		//Waits till the Comparative Peer Group Selection table gets loaded in the Peer Selection - 02
  		waitForElement(CPA_ComparativePeerGroupSelectionTable);
  		Thread.sleep(4000);
  	   // Take screenshot after the page is fully ready
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
        File screenshotPath = new File("src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/SelectCustomerbtnWithSelection.png");
        FileHandler.copy(sourcefile, screenshotPath);
        //Clicking Back button of Peer Selection - 02 for redirection to Peer Selection - 01
        WebElement PS2_BackBtn  = waitForElement(CPA_PS2_BackBtn);
        Thread.sleep(3000);
        PS2_BackBtn.click();
        System.out.println("--- Clicked - Back Button of Peer Selection - 02 and got redirected to the Peer Selection - 01");
        //Waits till the table gets loaded
        waitForElement(CPA_PS1_SelectTargetCustomerTable);
  		
  	    //Verify whether it landed on the Customer Peer Analysis Card - Selections - Peer Selection
	      String currentUrl = driver.getCurrentUrl();
	      String expectedPeerSelectionUrl = ConfigReader.cpa_peerSelection();
	      if (!currentUrl.equalsIgnoreCase(expectedPeerSelectionUrl)) {
	          throw new AssertionError("--- Not Landed on the Peer Selection Screen --- Unexpected redirection :( !Current URL you're on: " + currentUrl);
	      }
        
//          driver.navigate().back(); //temporary but need to code for the flow till creation of scenario
          Thread.sleep(4000);
  		
  	}
  	
  	//Clicks the Select Customer button without selection
  	public void selectCustomerBtnWithOutSelection() throws IOException, InterruptedException{
  	    //waits for the Select Customer button to get load
  		WebElement PS1_SelectCustomerBtn = waitForElement(CPA_PS1_SelectCustomerBtn);
  		//Clicks the Create Sensitivity Scenario button
  		PS1_SelectCustomerBtn.click();
  		System.out.println("--- Clicked: Select Customer Button without selecting a record");
        Thread.sleep(5000);
  		// Take screenshot after the page is fully ready
          TakesScreenshot screenshot = (TakesScreenshot) driver;
          File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
          File screenshotPath = new File("src/test/resources/screenshots/CustomerPeerAnalysis/Selections/PeerSelections/SelectCustomerbtnWithOutSelection.png");
          FileHandler.copy(sourcefile, screenshotPath);
         
  	}
  	
  //Select Target Customer for Peer Matching table Record Download
  	public void tableRecordsDownload() throws IOException, InterruptedException{
  		//Download button present in the table
  		WebElement PS1_DownloadBtn_SelectTargetCustomerTable = waitForElement(CPA_PS1_DownloadBtn_SelectTargetCustomerTable);
  		PS1_DownloadBtn_SelectTargetCustomerTable.click();
  		System.out.println("--- Clicked - Download Button of the Select Target Customer for Peer Matching table");
  		Thread.sleep(5000);
  		
  	}
    //Clicks the Back button of Peer Selection - 01 and get redirected to Branch/Customer Page
  	public void redirectionTo() throws IOException, InterruptedException{
  		//Back button
  		WebElement PS1_BackBtn = waitForElement(CPA_PS1_BackBtn);
  		PS1_BackBtn.click();
  		System.out.println("--- Clicked - Back Button of Peer Selection - 01 and got redirected to the Branch/Customer Selection Screen");
  		waitForElement(CPA_GeographicalMap);
  		Thread.sleep(5000);
  		
  	}
  	
    
    
    
    

}
