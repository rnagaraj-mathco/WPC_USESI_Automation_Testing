This README provides important details on the automation suite files, their purpose and usage for the WPC_USESI application.

src/test/java/config/

1. ConfigReader.java:
	Defines methods for accessing variables declared in Config.properties, enabling centralized and reusable retrieval of 
	configuration values across the suite. 
	
src/test/resources/

2. Config.properties:
	Stores critical configuration values, including screen URLs and important variables. 
	Email ID and password are placeholders, with actual values retrieved securely from Azure Key Vault via the .yaml file.
	
3. extent.properties:
	Configures the Extent Report, including the storage path for screenshots, ensuring that failure details are captured 
	and linked within the report for effective debugging.

4. logback.xml:
	Defines the structure and configuration of the .txt log files, maintaining scenario-level logging for all features 
	in an organized, readable format.
	
5. spark-config.xml:
	Configures the visual layout and theme of the Extent Report in HTML format, providing dashboards, charts 
	and a visually intuitive summary of test execution.
	
src/test/java/Utils/

6. ElementHelper.java:
 	Provides robust methods for interacting with web elements, including normal click, JavaScript click, and Actions click. 
 	If one method fails, it automatically falls back to another. Also handles dynamic waits, scrolling, and overlays, 
 	ensuring stable and reliable element interactions.
 
7. ExtendedReports.java:
	Generates a detailed Cucumber HTML report using Masterthought Cucumber Reporting. Reads JSON output from 
	executed scenarios, applies project metadata (Platform, Browser, Version, Environment), and produces a 
	comprehensive report with execution summary, classifications and trends.

8. ExtentReporter.java:
	Configures and generates ExtentReports with timestamped folders for each execution. Applies dark-themed HTML layout 
	using spark-config.xml, attaches system metadata, and captures scenario-level logs including passed and failed steps 
	for stakeholder review.

9. ScreenshotUtil.java:
	Captures screenshots during test execution and stores them in the Extent Report folder. Cleans scenario names for 
	file safety, creates the screenshots directory if it doesn’t exist, and ensures failed test cases have visual evidence 
	for debugging and complete scenario logging.
 	
   
	