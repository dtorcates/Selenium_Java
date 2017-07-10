package test;

import PageFactory.HomePage_Factory;
import PageFactory.Signin_Factory;
import PageFactory.Welcome_Factory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import scenarios.login;
import utils.GenerateData;
import utils.browserBasics;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;

public class SignIn_Test_mobile extends browserBasics {

	WebDriver driver;

	Welcome_Factory objLogin;
    public String baseURL;
    public WebDriverWait wait;
	HomePage_Factory objHomePage;
	public Logger log;
	private String pathEvidence = "src//test//evidence//Signin//";
	GenerateData genData;



	@BeforeTest
	//@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","C:/Blanclink/Automation/Projects/EQBank/EQBank/src/drivers/chromedriver.exe");
        //driver = new ChromeDriver();
		//PropertyConfigurator.configure("log4j.properties");
//		log.info("Starting automated test");
		genData=new GenerateData();
        //noinspection MismatchedQueryAndUpdateOfCollection
        Map<String,String> mobileEmulation= new HashMap <>();

        //mobileEmulation.put("deviceName","Apple iPhone 5");
         mobileEmulation.put("deviceName","Apple iPad");
        //mobileEmulation.put("deviceName","Google Nexus 5");
        Map<String, Object> chromeOptions=new HashMap <>();
        chromeOptions.put("mobileEmulation",mobileEmulation);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        DesiredCapabilities capabilities= DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
		capabilities.setCapability("rotatable", true);

        System.setProperty("webdriver.chrome.driver","C:/Blanclink/Automation/Projects/EQBank/EQBank/src/drivers/chromedriver.exe");


       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log = Logger.getLogger(SignIn_Test_mobile.class);
        driver = new ChromeDriver(capabilities);
        driver.get("http://qa.khp.blanclabs.com/resourcesaroundme/welcome.html");

		//WebDriver augmentedDriver = new Augmenter().augment(driver);
		//((Rotatable)augmentedDriver).rotate(ScreenOrientation.LANDSCAPE);



	}

    /**
	 * This test go to http://dev.eqb.blanclabs.com:9000/cust-web/index.html#/
	 * Fill all data fields from Sign in Page
	 * Click on Create Account
	 * Verify next page message
     * dtorcates 04/11/2017
	 */


		@Test(priority=1)
		public void test_signin_for_mobile(){

			objLogin = new Welcome_Factory(driver);
			//Verify login page title
			String welcomePageTitle = objLogin.getwelcomeTitle();
			log.info("Set  variable test-->" + welcomePageTitle);
			Assert.assertEquals(welcomePageTitle,"Resources Around Me");


			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
			FileUtils.copyFile(scrFile, new File(pathEvidence + "image3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	@AfterTest
    public void finish() throws Exception{
        log.info("Finish " + getClass().getName() + " and closing browser");
        explicitWait(driver, 5);
        driver.close();
    }


	
}
