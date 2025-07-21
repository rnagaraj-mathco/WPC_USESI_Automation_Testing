package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.ExtendedReports;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", // path to your feature files
		glue = { "stepdefinitions", "hooks" }, // glue code packages
		plugin = { "pretty" }, monochrome = true)
public class TestRunner {

	public static void GeneratedExtendedReports() {
		ExtendedReports.generateReport();
	}
} // If any additional report plugins required we can add it in this class
