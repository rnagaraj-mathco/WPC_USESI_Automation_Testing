//package hooks;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import org.openqa.selenium.WebDriver;
//
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
//
//import DriverManager.DriverFactory;
//import io.cucumber.plugin.ConcurrentEventListener;
//import io.cucumber.plugin.event.EventPublisher;
//import io.cucumber.plugin.event.PickleStepTestStep;
//import io.cucumber.plugin.event.Status;
//import io.cucumber.plugin.event.TestStepFinished;
//import utils.ScreenshotUtil;
//
//public class StepReporter implements ConcurrentEventListener {
//
//	@Override
//	public void setEventPublisher(EventPublisher publisher) {
//		publisher.registerHandlerFor(TestStepFinished.class, this::afterStep);
//	}
//
//	private void afterStep(TestStepFinished event) {
//		if (!(event.getTestStep() instanceof PickleStepTestStep))
//			return;
//
//		PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
//		String stepText = step.getStep().getKeyword() + step.getStep().getText();
//		WebDriver driver = DriverFactory.getDriver();
//
//		System.out.println("➡️ StepReporter captured: " + stepText); // 🐞 Debug log
//
//		try {
//			if (event.getResult().getStatus() == Status.FAILED) {
//				ExtentCucumberAdapter.addTestStepLog("❌ " + stepText);
//				String screenshotPath = ScreenshotUtil.takeScreenshot(driver, stepText);
//
//				if (screenshotPath != null && Files.exists(Paths.get(screenshotPath))) {
//					ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath);
//				} else {
//					ExtentCucumberAdapter.addTestStepLog("⚠️ Screenshot missing for failed step.");
//				}
//			} else {
//				ExtentCucumberAdapter.addTestStepLog("✅ " + stepText);
//			}
//		} catch (Exception e) {
//			ExtentCucumberAdapter.addTestStepLog("⚠️ StepReporter Exception: " + e.getMessage());
//		}
//	}
//}

//////////// Complete scenario loggg to extent report
package hooks;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import DriverManager.DriverFactory;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestStepFinished;
import utils.ScreenshotUtil;

public class StepReporter implements ConcurrentEventListener {

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestStepFinished.class, this::afterStep);
	}

	private void afterStep(TestStepFinished event) {
		if (!(event.getTestStep() instanceof PickleStepTestStep))
			return;

		PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
		String stepText = step.getStep().getKeyword() + step.getStep().getText();
		WebDriver driver = DriverFactory.getDriver();

		try {
			if (event.getResult().getStatus() == Status.FAILED) {
				ExtentCucumberAdapter.addTestStepLog("❌ " + stepText);
				String screenshotPath = ScreenshotUtil.takeScreenshot(driver, stepText);
				if (screenshotPath != null) {
					ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath);
				} else {
					ExtentCucumberAdapter.addTestStepLog("⚠️ Screenshot missing for failed step.");
				}
			} else {
				ExtentCucumberAdapter.addTestStepLog("✅ " + stepText);
			}
		} catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog("⚠️ StepReporter Exception: " + e.getMessage());
		}
	}
}
