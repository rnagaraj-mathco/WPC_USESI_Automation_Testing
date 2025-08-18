//package utils;
// import net.masterthought.cucumber.Configuration;
//
//import net.masterthought.cucumber.ReportBuilder;
// 
//import java.io.File;
//
//import java.util.ArrayList;
//
//import java.util.List;
// public class ExtendedReports {
//    public static void generateReport() {
//        try {
//            // Output directory for report
//            File reportOutputDirectory = new File("target/cucumber-reports");
//            // Cucumber JSON report files
//            List<String> jsonFiles = new ArrayList<>();
//
//            jsonFiles.add("target/cucumber-reports/cucumber.json");
// 
//            // Project name
//
//            String projectName = "WPC - USESI UI Automation Testing Report";
// 
//            // Configuring the report
//
//            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// 
//            // Metadata / Classifications
//
//            configuration.addClassifications("Platform", "Windows");
//
//            configuration.addClassifications("Browser", "Chrome");
//
//            configuration.addClassifications("Version", "v1.0");
//
//            configuration.addClassifications("Environment", "Test");
//
//            configuration.addClassifications("UI", "Automation");
//
//            configuration.addClassifications("Build Number", "1234");
//
//            configuration.addClassifications("Java Version", System.getProperty("java.version"));
//
//            configuration.addClassifications("OS", System.getProperty("os.name"));
// 
//            // Trends stats file
//
//            configuration.setTrendsStatsFile(new File("target/cucumber-reports/trends.json"));
// 
//            // Create and generate report
//
//            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
//
//            reportBuilder.generateReports();
// 
//            System.out.println(" Extended cucumber report generated successfully!");
//
//        } catch (Exception e) {
//
//            System.err.println(" Failed to generate extended report: " + e.getMessage());
//
//            e.printStackTrace();
//
//        }
//
//    }
//
//}

///// Complete scenario in Extent Reports

package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ExtendedReports {
	public static void generateReport() {
		try {
			// Output directory for Cucumber HTML report
			File reportOutputDirectory = new File("target/cucumber-reports");

			// Cucumber JSON report files
			List<String> jsonFiles = new ArrayList<>();
			jsonFiles.add("target/cucumber-reports/cucumber.json");

			// Project name
			String projectName = "WPC - USESI UI Automation Testing Report";

			// Configuring the report
			Configuration configuration = new Configuration(reportOutputDirectory, projectName);

			// Add classifications for the metadata (e.g., OS, browser version)
			configuration.addClassifications("Platform", "Windows");
			configuration.addClassifications("Browser", "Chrome");
			configuration.addClassifications("Version", "v1.0");
			configuration.addClassifications("Environment", "Demo");

			// Generate the report
			ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
			reportBuilder.generateReports();

			System.out.println("Extended cucumber report generated successfully!");
		} catch (Exception e) {
			System.err.println("Failed to generate extended report: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
