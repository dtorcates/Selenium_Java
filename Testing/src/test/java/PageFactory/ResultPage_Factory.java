package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage_Factory {

	/**
	 * Step 1
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(css=".button.yes")
	WebElement buttonyes;

    @FindBy(css=".amount")
    WebElement result_label;



	/**
	 * Step 2
	 * All User Actions Defined to this features (methods)
	 */

	public ResultPage_Factory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Verify load page
	public void Load_ResultPage(){
		if( buttonyes.isDisplayed());{
		    System.out.println("Click on Yes button");
		    buttonyes.click();

        }



	}

    //Verify Display Results
    public String Displays_ResultPage(){
        return result_label.getText();
    }

}
