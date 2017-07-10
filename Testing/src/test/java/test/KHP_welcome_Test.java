package test;

import PageFactory.Welcome_Factory;
import PageFactory.ResultPage_Factory;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GetScreenShot;
import utils.browserBasics;
import java.util.concurrent.TimeUnit;
import java.io.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class KHP_welcome_Test extends browserBasics {

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
		driver.get("http://qa.khp.blanclabs.com/resourcesaroundme/welcome.html");
		log = Logger.getLogger(KHP_welcome_Test.class);
		//PropertyConfigurator.configure("log4j.properties");
		log.info("Starting automated test");
		//genData=new GenerateData();
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test_output/MyOwnReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS", "Mac Sierra");
        extent.setSystemInfo("Host Name", "Krishna");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Krishna Sakinala");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("My Own Report");
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

	public void test_verify_welcome_title() throws IOException {
		//Create Login Page object
		objLogin = new Welcome_Factory(driver);
		//Verify login page title
		String welcomePageTitle = objLogin.getwelcomeTitle();
		log.info("Set  variable test-->" + welcomePageTitle);
        test = extent.createTest("demoTestPass", "This test will demonstrate the PASS test case");
        test.log(Status.INFO, "Loadig Page Welcome");
        Assert.assertTrue(true);
		Assert.assertEquals(welcomePageTitle,"Resources Around Me");
        String screenShotPath = GetScreenShot.capture(driver, "screenShotName1");
        test.log(Status.PASS, "Title Verified Correctly");
        test.pass("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));



	}



    @Test(priority=2)
    public void test_counselling_category() throws IOException {
        //Create Login Page object
        test = extent.createTest("Click on Search Button", "This test will demonstrate the PASS test case");
        objLogin = new Welcome_Factory(driver);
        driver.navigate().refresh();
        test.log(Status.INFO, "Click on Search button");
        explicitWait(driver, 5);
        objLogin.click_search();
        test.log(Status.PASS, "Wait for 5 Seconds");
        String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
        test.log(Status.PASS, "Search Verified Correctly");
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
