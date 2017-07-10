package test;

import PageFactory.HomePage_Factory;
import PageFactory.Signin_Factory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.GenerateData;
import utils.browserBasics;

import java.io.File;
import java.util.concurrent.TimeUnit;


//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;


public class SignIn_Test extends browserBasics {

	WebDriver driver;
	Signin_Factory objLogin;
    public String baseURL;
    public WebDriverWait wait;
	HomePage_Factory objHomePage;
	public Logger log;
	String pathEvidence = "src//test//evidence//Signin//";
	GenerateData genData;

    //ExtentReports report;
    //ExtentTest logger;


	@BeforeTest
	public void setup(){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:/Blanclink/Automation/Projects/Selenium/Testing/src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://qa.khp.blanclabs.com/resourcesaroundme/welcome.html");
		log = Logger.getLogger(SignIn_Test.class);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Starting automated test");
		genData=new GenerateData();
//        report=new ExtentReports("C:\\Report\\LearnAutomation.html");

//        logger=report.startTest("VerifyBlogTitle");

	}

    /**
	 * This test go to http://dev.eqb.blanclabs.com:9000/cust-web/index.html#/
	 * Fill all data fields from Sign in Page
	 * Click on Create Account
	 * Verify next page message
     * dtorcates 04/11/2017
	 */
/*
        @Test(priority=1)
        public void test_mouseover_on_email_field(){
            //Create Login Page object
            objLogin = new Signin_Factory(driver);
            explicitWait(driver, 3);
            objLogin.EmailMouseOver();
            explicitWait(driver, 5);

        }

	@Test(priority=2)
	public void test_mouseover_on_DOB_field(){
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
		explicitWait(driver, 3);
		objLogin.DOBMouseOver();
		explicitWait(driver, 5);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(pathEvidence + "mouseover_remember_device.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority=3)
	public void test_mouseover_on_remember_device_icon(){
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
		explicitWait(driver, 3);
		objLogin.Remember_device_MouseOver();
		explicitWait(driver, 5);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(pathEvidence + "mouseover_remember_device.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(priority=4)
	public void test_validate_first_name(){
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
		explicitWait(driver, 5);
		objLogin.Validate_Email( "","Abcd#1234","Abcd#1234","TestUser","LastNameuser","02");
        String Error_msg = objLogin.getEmailMissingError();
        log.info("Set  variable test-->"+Error_msg);
        explicitWait(driver, 5);
        Assert.assertFalse(Error_msg.toLowerCase().contains("Email address is required."));

	}

    @Test(priority=5)
    public void test_validate_first_pass(){
        //Create Login Page object
        objLogin = new Signin_Factory(driver);
        driver.navigate().refresh();
        objLogin.Validate_Pass( "TestUser@gmail.com","Abcd#1234","TestUser","LastNameuser","02");
        String Error_msg = objLogin.getPassMissingError();
        log.info("Set  variable test-->"+Error_msg);
        explicitWait(driver, 3);
        Assert.assertFalse(Error_msg.toLowerCase().contains("Password is required."));

    }



	@Test(priority=6)
	public void test_validate_Check1_name(){
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
        driver.navigate().refresh();
		boolean check = objLogin.Test_uncheck_option_1();
		log.info("la variable check retorno-->"+check);
		explicitWait(driver, 5);
        Assert.assertEquals(check,false);



    }


    @Test(priority=7)
    public void test_validate_Check2_name(){
        //Create Login Page object
        objLogin = new Signin_Factory(driver);
        driver.navigate().refresh();
        boolean check = objLogin.Test_uncheck_option_2();
        log.info("la variable check2 retorno-->"+check);
        explicitWait(driver, 5);
        Assert.assertEquals(check,false);



    }


	@Test(priority=8)

	public void test_validate_first_pass(){
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
		driver.navigate().refresh();
		objLogin.Validate_Firstname( "TestUser@gmail.com","Abcd#1234","TestUser","LastNameuser","02");
		String Error_msg = objLogin.getPassMissingError();
		log.info("Set  variable test-->"+Error_msg);
		explicitWait(driver, 3);
		Assert.assertFalse(Error_msg.toLowerCase().contains("Password is required."));

	}

	@Test(priority=9)
	public void test_first_name_empty(){
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
		driver.navigate().refresh();

		String email=genData.generateEmail(30);
		String name="";
		String lastname=genData.generateRandomAlphaNumeric(30);
		String password="Abcd#1234";
		objLogin.ValidateFisrtNameEmpty(email, password, password,name,lastname,"02");
		String Error_msg = objLogin.getFirstNameMissinglabel();
		log.info("Set  variable test-->"+Error_msg);
		explicitWait(driver, 3);
		Assert.assertEquals(Error_msg,"First Name is required.");
	}


	@Test(priority=10)
	public void test_last_name_empty(){
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
		driver.navigate().refresh();

		String email=genData.generateEmail(30);
		String name=genData.generateRandomAlphaNumeric(30);;
		String lastname="";
		String password="Abcd#1234";
		objLogin.ValidateLastNameEmpty(email, password, password,name,lastname,"02");
		String Error_msg = objLogin.getLasNameMissinglabel();
		log.info("Set  variable test-->"+Error_msg);
		explicitWait(driver, 3);
		Assert.assertEquals(Error_msg,"Last Name is required.");
	}



	@Test(priority=11)
	public void test_dob_name_empty(){
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
		driver.navigate().refresh();

		String email=genData.generateEmail(30);
		String name=genData.generateRandomAlphaNumeric(30);;
		String lastname="UserLastName";
		String password="Abcd#1234";
		objLogin.ValidateDobEmpty(email, password, password,name,lastname,"");
		String Error_msg = objLogin.getdobMissinglabel();
		log.info("Set  variable test-->"+Error_msg);
		explicitWait(driver, 3);
		Assert.assertEquals(Error_msg,"Date of Birth is required.");
	}

/*

*/
		@Test(priority=2)
		public void test_Home_Page_Appear_Correct(){
			//Create Login Page object
			objLogin = new Signin_Factory(driver);


			//Verify login page title
			String loginPageTitle = objLogin.getLoginTitle();
			log.info("Set  variable test-->"+loginPageTitle);
			Assert.assertFalse(loginPageTitle.toLowerCase().contains("Create Your Sign In"));

			/*
			String email=genData.generateEmail(30);
			String name=genData.generateRandomAlphaNumeric(30);
			String lastname=genData.generateRandomAlphaNumeric(30);
			String password="Abcd#1234";

				System.out.println("email es -->"+email);
			//login to application
			objLogin.SignInPage(email, password, password,name,lastname,"02");


			// go the next page
			objHomePage = new HomePage_Factory(driver);
			//Verify home page
				String HomePageTitle = objHomePage.getWelcomePageLabel();
				log.info("Set  variable test-->"+HomePageTitle);
			Assert.assertFalse(objHomePage.getWelcomePageLabel().toLowerCase().contains("You need to confirm your activations please check your email account. Thanks! "));

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
			FileUtils.copyFile(scrFile, new File(pathEvidence + "image1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
*/
	}



	@AfterTest
    public void finish() throws Exception{
        log.info("Finish " + getClass().getName() + " and closing browser");
        explicitWait(driver, 5);
        driver.close();
    }


	
}
