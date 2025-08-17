// ✅ ScreenshotUtil.java
//package utils;
//
//public class ScreenshotUtil {

//	public static String takeScreenshot(WebDriver driver, String scenarioName) {
//		try {
//			if (driver == null) {
//				System.err.println("❌ WebDriver is null. Screenshot not taken.");
//				return null;
//			}
//
//			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			if (!src.exists() || src.length() == 0) {
//				System.err.println("❌ Screenshot file is empty or not created.");
//				return null;
//			}
//
//			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//			String baseFolder = ExtentReporter.getReportFolderPath();
//			String screenshotsDir = baseFolder + "screenshots/";
//
//			String cleanName = scenarioName.replaceAll("[^a-zA-Z0-9_]", "_");
//			cleanName = cleanName.length() > 100 ? cleanName.substring(0, 100) : cleanName;
//			String fileName = cleanName + "_" + timestamp + ".png";
//
//			File dest = new File(screenshotsDir + fileName);
//			FileUtils.copyFile(src, dest);
//
//			return "./screenshots/" + fileName;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
///////////////// Below is the working code but got teardown error
//	public static String takeScreenshot(WebDriver driver, String scenarioName) {
//		try {
//			if (driver == null) {
//				System.err.println("❌ WebDriver is null. Screenshot not taken.");
//				return null;
//			}
//
//			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			if (!src.exists() || src.length() == 0) {
//				System.err.println("❌ Screenshot file is empty or not created.");
//				return null;
//			}
//
//			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//			String baseFolder = ExtentReporter.getReportFolderPath();
//			String screenshotsDir = baseFolder + "screenshots/";
//
//			// Ensure the screenshots directory exists
//			File screenshotsDirFile = new File(screenshotsDir);
//			if (!screenshotsDirFile.exists()) {
//				if (screenshotsDirFile.mkdirs()) {
//					System.out.println("✅ Created screenshots directory.");
//				} else {
//					System.err.println("❌ Failed to create screenshots directory.");
//				}
//			}
//
//			// Clean the scenario name and generate the filename
//			String cleanName = scenarioName.replaceAll("[^a-zA-Z0-9_]", "_");
//			cleanName = cleanName.length() > 100 ? cleanName.substring(0, 100) : cleanName;
//			String fileName = cleanName + "_" + timestamp + ".png";
//
//			// Check if the total file path length is too long
//			String filePath = screenshotsDir + fileName;
//			if (filePath.length() > 260) { // Adjust based on the OS limit
//				fileName = fileName.substring(0, 100) + "_" + timestamp + ".png";
//				filePath = screenshotsDir + fileName;
//			}
//
//			System.out.println("Saving screenshot to: " + filePath);
//
//			// Set the destination file
//			File dest = new File(filePath);
//
//			// Copy screenshot to destination
//			FileUtils.copyFile(src, dest);
//
//			// Return relative file path for reference in reports
//			return "./screenshots/" + fileName;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//}
////////////////////////////////// This is for the Error in teardown error and it works but now updating script to solve issue of logging complete scenario to extent report
//
//package utils;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//public class ScreenshotUtil {
//
//	public static String takeScreenshot(WebDriver driver, String scenarioName) {
//		try {
//			if (driver == null) {
//				System.err.println("❌ WebDriver is null. Screenshot not taken.");
//				return null;
//			}
//
//			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			if (!src.exists() || src.length() == 0) {
//				System.err.println("❌ Screenshot file is empty or not created.");
//				return null;
//			}
//
//			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//			String baseFolder = ExtentReporter.getReportFolderPath();
//			String screenshotsDir = baseFolder + "screenshots/";
//
//			// Ensure the screenshots directory exists
//			File screenshotsDirFile = new File(screenshotsDir);
//			if (!screenshotsDirFile.exists()) {
//				if (screenshotsDirFile.mkdirs()) {
//					System.out.println("✅ Created screenshots directory.");
//				} else {
//					System.err.println("❌ Failed to create screenshots directory.");
//				}
//			}
//
//			// Clean the scenario name and generate the filename
//			String cleanName = scenarioName.replaceAll("[^a-zA-Z0-9_]", "_");
//			cleanName = cleanName.length() > 100 ? cleanName.substring(0, 100) : cleanName;
//			String fileName = cleanName + "_" + timestamp + ".png";
//
//			// Check if the total file path length is too long
//			String filePath = screenshotsDir + fileName;
//			if (filePath.length() > 260) { // Adjust based on the OS limit
//				fileName = fileName.substring(0, 100) + "_" + timestamp + ".png";
//				filePath = screenshotsDir + fileName;
//			}
//
//			System.out.println("Saving screenshot to: " + filePath);
//
//			// Set the destination file
//			File dest = new File(filePath);
//
//			// Copy screenshot to destination
//			FileUtils.copyFile(src, dest);
//
//			// Return relative file path for reference in reports
//			return "./screenshots/" + fileName;
//
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//}

/////////////////////////// Complete scenario logs in to Extent report
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

			// Ensure the screenshots directory exists
			File screenshotsDirFile = new File(screenshotsDir);
			if (!screenshotsDirFile.exists()) {
				screenshotsDirFile.mkdirs();
			}

			// Clean the scenario name and generate the filename
			String cleanName = scenarioName.replaceAll("[^a-zA-Z0-9_]", "_");
			cleanName = cleanName.length() > 100 ? cleanName.substring(0, 100) : cleanName;
			String fileName = cleanName + "_" + timestamp + ".png";

			String filePath = screenshotsDir + fileName;
			File dest = new File(filePath);
			FileUtils.copyFile(src, dest);

			return "./screenshots/" + fileName;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
