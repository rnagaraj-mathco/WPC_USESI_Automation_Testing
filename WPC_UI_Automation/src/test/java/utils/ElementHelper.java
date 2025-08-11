package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {

	private WebDriver driver;
	private Actions actions;

	public ElementHelper(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}

	/**
	 * Safe click method using By locator to find and click an element. This method
	 * ensures re-location if the element is stale.
	 */
	public void safeClick(By locator) {
		WebElement element = waitForClickableElement(locator); // Dynamically wait for the element to be clickable
		safeClick(element);
	}

	/**
	 * Safe click method using WebElement directly to ensure the click is performed
	 * safely. It retries in case the element becomes stale.
	 */
	public void safeClick(WebElement element) {
		try {
			scrollToElement(element); // Ensure the element is in view
			element.click(); // Perform the click
			System.out.println("✅ Clicked using .click()");
		} catch (Exception e1) {
			System.out.println("⚠️ Normal click failed: " + e1.getMessage());

			// Fallback to JavaScript click if normal click fails
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				System.out.println("✅ Clicked using JavaScriptExecutor");
			} catch (Exception e2) {
				System.out.println("⚠️ JS click failed: " + e2.getMessage());

				// Final fallback to Actions click if JS click fails
				try {
					actions.moveToElement(element).click().perform();
					System.out.println("✅ Clicked using Actions");
				} catch (Exception e3) {
					System.out.println("❌ All click attempts failed");
					throw new RuntimeException("All click attempts failed on WebElement", e3);
				}
			}
		}
	}

	/**
	 * Wait for an element to be visible and return the WebElement. This method is
	 * dynamic and can be reused for any element.
	 */
	public WebElement waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Wait for an element to be clickable (visibility + enabled) and return the
	 * WebElement.
	 */
	public WebElement waitForClickableElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * A helper method that handles overlays by waiting for them to disappear.
	 */
	public void waitForOverlaysToDisappear() {
		try {
			By overlayLocator = By.cssSelector(".MuiBackdrop-root"); // Example CSS selector for overlays
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
			System.out.println("✅ Overlays disappeared.");
		} catch (Exception e) {
			System.out.println("No overlays found or timed out — proceeding.");
		}
	}

	/**
	 * Scroll to the specified element to ensure it's in the visible area before
	 * interacting.
	 */
	public void scrollToElement(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		} catch (Exception e) {
			System.out.println("⚠️ Failed to scroll to element: " + e.getMessage());
		}
	}
}
