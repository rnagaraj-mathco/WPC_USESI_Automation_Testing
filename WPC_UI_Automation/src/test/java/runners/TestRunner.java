//package runners;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.testng.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/java/Features", glue = { "stepdefinitions", "hooks" }, plugin = { "pretty",
//		"json:target/cucumber.json", "html:target/cucumber-html-report",
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "hooks.StepReporter" // ✅ This must
//																										// match the
//																										// full class
//																										// name
//}, monochrome = true)
//public class TestRunner {
//}

//package runners;
//
//import org.testng.annotations.DataProvider;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(features = "src/test/java/Features", glue = { "stepdefinitions", "hooks" }, plugin = { "pretty",
//		"json:target/cucumber.json", "html:target/cucumber-html-report",
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)
//public class TestRunner extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel = false)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
//}

package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Features", glue = { "stepdefinitions", "hooks" }, plugin = { "pretty",
		"html:target/cucumber-html-report", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
