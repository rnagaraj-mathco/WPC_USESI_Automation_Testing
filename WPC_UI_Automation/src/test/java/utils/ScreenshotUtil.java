// ✅ ScreenshotUtil.java
package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String scenarioName) {
		try {
			if (driver == null) {
				System.err.println("❌ WebDriver is null. Screenshot not taken.");
				return null;
			}

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			if (!src.exists() || src.length() == 0) {
				System.err.println("❌ Screenshot file is empty or not created.");
				return null;
			}

			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String baseFolder = ExtentReporter.getReportFolderPath();
			String screenshotsDir = baseFolder + "screenshots/";

			String cleanName = scenarioName.replaceAll("[^a-zA-Z0-9_]", "_");
			cleanName = cleanName.length() > 100 ? cleanName.substring(0, 100) : cleanName;
			String fileName = cleanName + "_" + timestamp + ".png";

			File dest = new File(screenshotsDir + fileName);
			FileUtils.copyFile(src, dest);

			return "./screenshots/" + fileName;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
