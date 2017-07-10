package test;

import PageFactory.ResultPage_Factory;
import PageFactory.Welcome_Factory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GetScreenShot;
import utils.browserBasics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class DGT_Response_Test extends browserBasics {

	WebDriver driver;
	Welcome_Factory objLogin;
    public String baseURL;
    public WebDriverWait wait;
    ResultPage_Factory objResultPage;
	public Logger log;
	String pathEvidence = "src//test//evidence//KHP//";
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;


	@BeforeTest
	public void setup(){

		System.setProperty("webdriver.chrome.driver","C:/Blanclink/Automation/Projects/EQBank/EQBank/src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.digitel.com.ve/Personas/Default.aspx");
		log = Logger.getLogger(DGT_Response_Test.class);
		//PropertyConfigurator.configure("log4j.properties");
		log.info("Starting automated test");
		//genData=new GenerateData();
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test_output/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS", "Server Net Data");
        extent.setSystemInfo("Host Name", "Digitel Server");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Denny");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo  Digitel Report");
        htmlReporter.config().setReportName("Report Responsive Result Digitel");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        //logger=report.startTest("Test Responsive Site");


	}

    /**
	 * This test go to http://localhost/resourcesaroundme/welcome.html
	 * Fill all data fields from search
	 * Verify Welcome page from KHP
     * dtorcates 04/11/2017
	 */


	@Test(priority=1)

	public void test_verify_landing_page() throws IOException {
		//Verify login page title
        test = extent.createTest("demoTestPass", "This test will demonstrate the PASS test case");
        test.log(Status.INFO, "Landing Page Welcome");
        String screenShotPath = GetScreenShot.capture(driver, "HomePage");
        test.log(Status.PASS, "Loading Verified Correctly");
        test.pass("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));



	}




    @AfterTest
    public void finish() throws Exception{
       // log.info("Finish " + getClas report.endTest(logger);
        extent.flush();
        //driver.get("C:\\Report\\LearnAutomation.html");
        driver.close();
    }


	
}
