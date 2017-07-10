package test;

import PageFactory.HomePage_Factory;
import PageFactory.Signin_Factory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import utils.browserBasics;

import static java.lang.Thread.sleep;

public class SignInMsg_Test {

	WebDriver driver;
	Signin_Factory objLogin;
	HomePage_Factory objHomePage;
	public Logger log;
	String pathEvidence = "src//test//evidence//Signin//";//This variable is to set path for screenshots. The fourth field is the name for automation test case
    static int linkCount=0;
	@BeforeTest
	public void setup(){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:/Blanclink/Automation/Projects/EQBank/EQBank/src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//log.info("Creating instance for " + driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://dev.eqb.blanclabs.com:9000/cust-web/index.html#/");

		log = Logger.getLogger(SignInMsg_Test.class);
		PropertyConfigurator.configure("log4j.properties");
		log.info("Starting automated test");

	}

	/**
	 * This test go to http://dev.eqb.blanclabs.com:8080/cust-web/index.html#/
	 * Verify validation message
	 */
	@Test(priority=0)
	public void test_Home_Page_Appear_Correct() throws InterruptedException {
		//Create Login Page object
		objLogin = new Signin_Factory(driver);
	//Verify Message on email empty
	//login to application

        // Using tag name "a" , we get all the links
        List<WebElement> links2 = driver.findElements(By.tagName("a"));

        // Get how many web links are present on a web page
        int numberOfWebLinks = links2.size();


        // Get the text from the links
        for (WebElement link : links2) {
            System.out.println("The links are "+link.getText());
        }

        // Using for loop
		/*
        for (int i=0; i<numberOfWebLinks; i++) {
            System.out.println(links.get(i).getText());
            System.out.println(links.get(i).getAttribute("href"));


        }*/

		System.out.println(links2.size());

        for(WebElement links : driver.findElements(By.tagName("a")))
        {
            System.out.println(links.getText());
            links.click();
            linkCount++;
        }
	}


	//Print Evidence
/*
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(scrFile, new File(pathEvidence + "image1.png"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

*/
    @AfterTest
    public void finish() throws Exception{
        log.info("Finish " + getClass().getName() + " and closing browser");
        driver.close();
    }

}
