package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.ExtendedReports;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = { "stepdefinitions", "hooks" }, // here the feature file is
																								// glued by default with
																								// the stepdefinitions
																								// so not required to
																								// mention the [ath
		plugin = { "pretty", "html:target/cucumber-html-report.html", "json:target/cucumber-report.json",
//        "junit:target/cucumber-report.xml"
		},

		monochrome = true // Color coding in console and display the outputs
)
public class TestRunner {

	public static void GeneratedExtendedReports() {
		ExtendedReports.generateReport();
	}
} // If any additional report plugins required we can add it in this class
