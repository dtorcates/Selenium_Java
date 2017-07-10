package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by blanclink34 on 16/03/2017.
 */
public class browserBasics {
    protected WebDriver driver;
    public Logger log;
    //public static String SELENIUM_HUB_URL;
    //public static String TARGET_SERVER_URL;

    //This function creates instance for browsers
    protected void prepareBrowser(int browser) throws MalformedURLException{
        log = Logger.getLogger(browserBasics.class);
        DesiredCapabilities browsers;

        if(browser == 1) {//Create browser instance for Firefox
            driver = new FirefoxDriver();
            log.info("Creating instance for " + driver);
        }
        else{
            if(browser == 2){//Create browser instance for Chrome
                //System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver");
                System.setProperty("webdriver.chrome.driver","C:/Blanclink/Automation/Projects/EQBank/EQBank/src/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                log.info("Creating instance for " + driver);
            }
            else{
                if(browser == 3){//Create browser instance for Safari
                    driver = new SafariDriver();
                    log.info("Creating instance for " + driver);
                }
                //This section it is to implement Automated test cases on Internet Explorer. It is neccesary implement a Virtual Machine.
                /*else{
                    if(browser == 4){
                        SELENIUM_HUB_URL = getConfigurationProperty("SELENIUM_HUB_URL","test.selenium.hub.url","http://10.10.10.158:4444/wd/hub");
                        //TARGET_SERVER_URL = getConfigurationProperty("TARGET_SERVER_URL","test.target.server.url","http://localhost:8080/sdc.samples.selenium");
                        //System.setProperty("webdriver.ie.driver","src/drivers/MicrosoftWebDriver.exe");
                        browsers = DesiredCapabilities.internetExplorer();
                        driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL),browsers);
                        log.info("Creating instance for " + driver);
                    }
                }*/
            }
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      //  driver.manage().window().maximize();
    }

    //This function helps to wait for some page resources.
    protected void explicitWait(WebDriver waitdriver, int timing){
        synchronized (waitdriver){
            try{
                waitdriver.wait(timing * 1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //
    /*protected static String getConfigurationProperty(String envKey, String sysKey, String defValue){
        String retValue = defValue;
        String envValue = System.getenv(envKey);
        String sysValue = System.getProperty(sysKey);
        // system property prevails over environment variable
        if(sysValue != null){
            retValue = sysValue;
        }
        else if(envValue != null){
            retValue = envValue;
        }
        return retValue;
    }*/
}
