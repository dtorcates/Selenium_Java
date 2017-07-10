package scenarios;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.browserBasics;

import java.net.MalformedURLException;

/**
 * This class have all scenarios for login test case.
 */

public class login extends browserBasics {
    public Logger log;
    public String baseURL;
    public WebDriverWait wait;
    public String username = "juniorc@blanclabs.com";
    public String password = "*L0cky02*";
    public int i=1;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{
        baseURL = "https://blanclinklabs.atlassian.net/secure/Dashboard.jspa";
        log = Logger.getLogger(login.class);
        PropertyConfigurator.configure("log4j.properties");
        log.info("Set Up automated test");
        prepareBrowser(2);
        wait = new WebDriverWait(driver,60);
        log.info("Finish set up");
    }
/*
    @Test
    public void switchBetweenWindows() throws InterruptedException{
        while (i<3){
            driver.get(baseURL);
            explicitWait(driver, 10);
            driver.findElement(By.id("dashboard-content")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/nav/div/div[2]/h1/a/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-options")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[1]/div/div[1]/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[4]/div/div[2]/div/div/div/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer-logo")));
            driver.findElement(By.id("user-options")).click();
            log.info("Waiting for starting Jira and navigates to login page");
            driver.close();
            i++;
            try {
                prepareBrowser(i);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        i = 1;
    }
*/
    @Test (priority = 1)
    public void emptyUsername() throws InterruptedException {

       // while (i<3){
            log.info("Starting test case: " + getClass().getName() + ".emptyUsername()");
            driver.get(baseURL);
            log.info("Navigate to " + driver.getCurrentUrl());

            //Starting test page
            explicitWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/nav/div/div[2]/h1/a/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-options")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[1]/div/div[1]/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[4]/div/div[2]/div/div/div/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer-logo")));
            driver.findElement(By.id("user-options")).click();
            log.info("Waiting for starting Jira and navigates to login page");

            //Login page
            explicitWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h2")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("google-signin-button")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("login-submit")).click();
            explicitWait(driver,2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("login-submit")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/div[1]/div/section/form/div[1]/div")));
            driver.findElement(By.xpath("/html/body/div/section/div[1]/div/section/form/div[1]/div")).getText().equals("Enter your Atlassian account");
            log.info("Finishing test case: " + getClass().getName() + ".emptyUsername()");
            //driver.close();
            /*i++;
            try {
                prepareBrowser(i);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        i = 1;*/
    }


    @Test (priority = 2)
    public void emptyPassword() throws InterruptedException {
        //while (i<3) {
            log.info("Starting test case: " + getClass().getName() + ".emptyPassword()");
            driver.get(baseURL);
            log.info("Navigate to " + driver.getCurrentUrl());

            //Starting test page
            explicitWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/nav/div/div[2]/h1/a/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-options")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[1]/div/div[1]/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[4]/div/div[2]/div/div/div/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer-logo")));
            driver.findElement(By.id("user-options")).click();
            log.info("Waiting for starting Jira and navigates to login page");

            //Login page
            explicitWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h2")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("google-signin-button")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("login-submit")).click();
            explicitWait(driver,2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("login-submit")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/div[1]/div/section/form/div[2]/div")));
            driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div/section/form/div[2]/div")).getText().equals("Enter your password");
            log.info("Finishing test case: " + getClass().getName() + ".emptyPassword()");
            /*driver.quit();
            i++;
            try {
                prepareBrowser(i);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        i=1;*/
    }
    /*
        @Test (priority = 3)
        public void unSuccessLoginWrongPassword() throws InterruptedException {
            log.info("Starting test case: " + getClass().getName() + ".unSuccessLoginWrongPassword()");
            driver.get(baseURL);
            log.info("Navigate to " + driver.getCurrentUrl());

            //Starting test page
            explicitWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/nav/div/div[2]/h1/a/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-options")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[1]/div/div[1]/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[4]/div/div[2]/div/div/div/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer-logo")));
            driver.findElement(By.id("user-options")).click();
            log.info("Waiting for starting Jira and navigates to login page");

            //Login page
            explicitWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h2")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("google-signin-button")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("login-submit")).click();
            explicitWait(driver,2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("thisisnotthepassword");
            driver.findElement(By.id("login-submit")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/div[1]/div/section/form/div[2]/div")));
            driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div/section/form/div[2]/div")).getText().equals("The email address or password you entered is incorrect.");
            log.info("Finishing test case: " + getClass().getName() + ".unSuccessLoginWrongPassword()");
            //driver.quit();
        }

        @Test (priority = 4)
        public void unSuccessLoginWrongUsername() throws InterruptedException {
            log.info("Starting test case: " + getClass().getName() + ".unSuccessLoginWrongUsername()");
            driver.get(baseURL);
            log.info("Navigate to " + driver.getCurrentUrl());

            //Starting test page
            explicitWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/nav/div/div[2]/h1/a/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-options")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[1]/div/div[1]/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[4]/div/div[2]/div/div/div/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer-logo")));
            driver.findElement(By.id("user-options")).click();
            log.info("Waiting for starting Jira and navigates to login page");

            //Login page
            explicitWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h2")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("google-signin-button")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(username + ".ve");
            driver.findElement(By.id("login-submit")).click();
            explicitWait(driver,2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-submit")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/div[1]/div/section/form/div[2]/div")));
            driver.findElement(By.xpath("/html/body/div[1]/section/div[1]/div/section/form/div[2]/div")).getText().equals("The email address or password you entered is incorrect.");
            log.info("Finishing test case: " + getClass().getName() + ".unSuccessLoginWrongUsername()");
            //driver.quit();
        }

        @Test (priority = 5)
        public void successLoginLogOut() throws InterruptedException{
            log.info("Starting test case: " + getClass().getName() + ".successLoginLogOut()");
            driver.get(baseURL);
            log.info("Navigate to " + driver.getCurrentUrl());

            //Starting test page
            explicitWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/header/nav/div/div[2]/h1/a/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-options")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[1]/div/div[1]/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/section/dashboard/div[1]/div/div[4]/div/div[2]/div/div/div/img")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer-logo")));
            driver.findElement(By.id("user-options")).click();
            log.info("Waiting for starting Jira and navigates to login page");

            //Login page
            explicitWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h2")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("google-signin-button")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("login-submit")).click();
            explicitWait(driver,2);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            driver.findElement(By.id("username")).equals("juniorc@blanclabs.com");
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-submit")).click();
            log.info("Writing username and password on login page and starting session");

            //Starting session
            explicitWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("browse_link")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("find_link")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.thed.zephyr.je__zfjConnect-topnav-section")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("create_link")));
            driver.findElement(By.id("gadget-10000-title")).equals("Introduction");
            driver.findElement(By.id("gadget-10002-title")).equals("Assigned to Me");
            log.info("Starting session successfully");
            driver.findElement(By.id("header-details-user-fullname")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("log_out")));
            driver.findElement(By.id("log_out")).click();
            explicitWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h1")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/section/header/div/div/h2")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("google-signin-button")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
            log.info("Finishing test case: " + getClass().getName() + ".successLoginLogOut()");
            //driver.quit();
        }
    */
    @AfterTest
    public void finish() throws Exception{
        log.info("Finish " + getClass().getName() + " and closing browser");
        driver.close();
    }

}