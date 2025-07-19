package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // wait initialized once
	}

	private WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// private By username = By.id("username");
	By username = By.xpath("//*[@id=\"username\"]");
	By password = By.xpath("//*[@id=\"password\"]");
	By loginBtn = By.xpath("//*[@id=\"loginEmail\"]");

	// SSO Login button
	By SSOLogin_Btn = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]");
	// SSO Login Credentials
	By SSOLogin_Credentials = By.xpath(
			"/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div/div/div/div[2]");

	// Profile Icon
	By ProfileIcon = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/div[2]/div[3]/div[1]");
	// Welcome text
	By welcomeTextLocator = By
			.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]");

	public void navigateTo() throws IOException {
		driver.get(ConfigReader.getAppUrl());

		// Wait for login page to load by waiting for a known visible element (like the
		// username field)
		waitForElement(username); // waits until user name is visible

		// Now take screenshot only after page is fully ready
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/login/loginpage.png");
		FileHandler.copy(sourcefile, screenshotPath);
	}

	public void loginTo() throws InterruptedException {

		// SSO Login steps
//    	WebElement SSO_Login = waitForElement(SSOLogin_Btn);
//    	SSO_Login.click();
//    	Thread.sleep(1000);
//    	System.out.println("--- SSO Login button was clicked");
//    	WebElement SSO_LoginCredentials = waitForElement(SSOLogin_Credentials);
//    	SSO_LoginCredentials.click();
//    	Thread.sleep(1000);
//    	System.out.println("--- SSO Login Credentials clicked");

		// Entering Credentials manually
		WebElement usernameField = waitForElement(username);
		usernameField.clear();
		usernameField.sendKeys(ConfigReader.userEmailId());
		Thread.sleep(1000);

		WebElement passwordField = waitForElement(password);
		passwordField.clear();
		passwordField.sendKeys(ConfigReader.password());
		Thread.sleep(1000);
	}

	public void loginBtn() throws IOException, InterruptedException {
		WebElement loginButton = waitForElement(loginBtn);
		loginButton.click();
		Thread.sleep(1000);
	}

	public void landingURL() throws InterruptedException, IOException {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.getProperty("expected.home.url");

		System.out.println("--- The Current URL: " + actualUrl);
		System.out.println("---  The Expected URL: " + expectedUrl);

		if (!actualUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError(
					"! Mismatch: Landed on wrong page. Expected: " + expectedUrl + " but was: " + actualUrl);
		}

		System.out.println("--- URL verification successful: You landed on the correct page.");

		By homeScreen = By.xpath("//*[@id=\"bodyContent\"]/div[2]/div[2]");
		waitForElement(homeScreen);

		// Logged In user Validation
		// Profile Icon
		WebElement profileHover = waitForElement(ProfileIcon);
		// Hovers on the profile Icon
		new Actions(driver).moveToElement(profileHover).perform();
		Thread.sleep(2000);
		System.out.println(
				"--- Successfully hovered over the profile icon, and the displayed username confirms a valid login");
		// This is to click on the screen to skip the hovering
//		Actions actions = new Actions(driver);
//		actions.moveByOffset(10, 10).click().build().perform();
		// Validation through Welcome text
		WebElement welcomeTextElement = waitForElement(welcomeTextLocator);
		String welcomeText = welcomeTextElement.getText();
		String actualUserName = welcomeText.replace("Welcome ", "").replace(",", "").trim();
		String expectedUserName = ConfigReader.getUserName();

		if (!actualUserName.equalsIgnoreCase(expectedUserName)) {
			throw new AssertionError("Expected user '" + expectedUserName + "' but found '" + actualUserName + "'");
		}

		System.out.println("User login validated: " + actualUserName);
		// Takes screenshot of the Dashboard Screen
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/login/LoginSuccess_HomeScreenLoad.png");
		FileHandler.copy(sourcefile, screenshotPath);
		Thread.sleep(1500);
		System.out.println("--- Home screen loaded fully.");

	}

	// Function for Invalid Credentials

	public void enterInvalidCredentials() throws IOException, InterruptedException {

		WebElement usernameField = waitForElement(username);
		usernameField.clear();
		usernameField.sendKeys("nagaraj");
		Thread.sleep(1000);

		WebElement passwordField = waitForElement(password);
		passwordField.clear();
		passwordField.sendKeys("nagaraj_r");
		Thread.sleep(1000);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/login/LoginFails_InvalidCredentials.png");
		FileHandler.copy(sourcefile, screenshotPath);

		System.out.println("\n --- Invalid Credentials was entered!");

	}

	// Checks whether user is on the login page after clicking the login btn by
	// entering the invalid credentials.

	public void invalidLoginPageStay() throws IOException {
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = ConfigReader.getAppUrl();
		// This checks whether the user is redirected to different screen by entering
		// the invalid credentials
		// Here checking the Current URL and Expected URL should be of the app URL as
		// user should not login with invalid credentials
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotPath = new File("src/test/resources/screenshots/login/Login_UnSuccessful.png");
		FileHandler.copy(sourcefile, screenshotPath);

		if (!currentUrl.equalsIgnoreCase(expectedUrl)) {
			throw new AssertionError("--- Unexpected redirection :( !Current URL your in:  " + currentUrl);

		}
	}

	// Checks for the error message displayed when Invalid credentials entered and
	// login btn is clicked
	public boolean isErrorMessageVisible() {
		try {
			WebElement error = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div/div/h5"));
			return error.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

}
