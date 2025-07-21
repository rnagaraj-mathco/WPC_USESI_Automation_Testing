package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String scenarioName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String path = "reports/screenshots/" + scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";
		File dest = new File(path);

		try {
			Files.createDirectories(dest.getParentFile().toPath());
			Files.copy(src.toPath(), dest.toPath());
			return dest.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
