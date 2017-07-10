package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_Factory {

	/**
	 * Step 1
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;
	@FindBy(xpath="html/body/div/main/ui-view/div/md-card")
	WebElement Welcomepagelabel;


	/**
	 * Step 2
	 * All User Actions Defined to this features (methods)
	 */

	public HomePage_Factory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Get the User name from Home Page
		public String getWelcomePageLabel(){
		 return	Welcomepagelabel.getText();
		}
}
