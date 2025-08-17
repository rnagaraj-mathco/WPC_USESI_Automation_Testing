//package utils;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.TimeZone;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ExtentReporter {
//
//	private static ExtentReports extent;
//	private static String reportFolderPath;
//
//	public static ExtentReports getInstance() throws IOException {
//		if (extent == null) {
//			// Use IST timestamp
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
//			sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//			String timestamp = sdf.format(new Date());
//
//			String folderName = "WPC_USESI_ExtentReport_" + timestamp;
//			reportFolderPath = "reports/" + folderName + "/";
//
//			ExtentSparkReporter spark = new ExtentSparkReporter(reportFolderPath + "ExtentReport.html");
//			spark.loadXMLConfig("src/test/resources/spark-config.xml");
//
//			spark.config().setTheme(Theme.DARK);
//			spark.config().setReportName("WPC - US ELECTRICALS INC - AUTOMATION TESTING REPORT");
//			spark.config().setDocumentTitle("Execution Report");
//			spark.config().setEncoding("utf-8");
//			spark.config().setTimelineEnabled(true);
//
//			extent = new ExtentReports();
//			extent.attachReporter(spark);
//
//			extent.setSystemInfo("Executed By", System.getProperty("user.name"));
//			extent.setSystemInfo("Environment", "QA");
//			extent.setSystemInfo("OS", System.getProperty("os.name"));
//		}
//		return extent;
//	}
//
//	public static String getReportFolderPath() {
//		return reportFolderPath;
//	}
//}

/// Complete scenario logg to extent report
package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	private static ExtentReports extent;
	private static String reportFolderPath;

	public static ExtentReports getInstance() throws IOException {
		if (extent == null) {
			// Use IST timestamp
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			String timestamp = sdf.format(new Date());

			String folderName = "WPC_USESI_ExtentReport_" + timestamp;
			reportFolderPath = "reports/" + folderName + "/";

			// Setup the ExtentSparkReporter
			ExtentSparkReporter spark = new ExtentSparkReporter(reportFolderPath + "ExtentReport.html");
			spark.loadXMLConfig("src/test/resources/spark-config.xml");

			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("WPC - US ELECTRICALS INC - AUTOMATION TESTING REPORT");
			spark.config().setDocumentTitle("Execution Report");
			spark.config().setEncoding("utf-8");
			spark.config().setTimelineEnabled(true);

			extent = new ExtentReports();
			extent.attachReporter(spark);

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
