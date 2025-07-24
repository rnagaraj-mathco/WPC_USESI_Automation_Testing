package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	private static ExtentReports extent;
	private static String reportFolderPath;

	public static ExtentReports getInstance() {
		if (extent == null) {
			// ✅ Use safe timestamp format (avoid "/" — not allowed in folder names)
			String timestamp = new SimpleDateFormat("MMdd_HHmmss").format(new Date());

			// ✅ Custom report name prefix + timestamp
			String folderName = "WPC_USESI_Report_" + timestamp;
			reportFolderPath = "reports/" + folderName + "/";

			ExtentSparkReporter spark = new ExtentSparkReporter(reportFolderPath + "ExtentReport.html");

			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("WPC - US ELECTRICALS INC - AUTOMATION TESTING REPORT");
			spark.config().setDocumentTitle("Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(spark);

			// Optional: system info
			extent.setSystemInfo("Executed By", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
		}
		return extent;
	}

	public static String getReportFolderPath() {
		return reportFolderPath;
	}
}
