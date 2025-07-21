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
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			reportFolderPath = "reports/Report_" + timestamp + "/";
			ExtentSparkReporter spark = new ExtentSparkReporter(reportFolderPath + "ExtentReport.html");

			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("WPC- US ELECTRICALS INC - AUTOMATION REPORT");
			spark.config().setDocumentTitle("Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}

	public static String getReportFolderPath() {
		return reportFolderPath;
	}
}
