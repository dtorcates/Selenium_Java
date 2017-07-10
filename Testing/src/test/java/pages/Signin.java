package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Signin {

	WebDriver driver;
	By user99GuruName = By.name("uid");
	By password99Guru = By.name("password");
	By passwordConfirm = By.name("passwordConfirm");
	By firstname = By.id("firstName");
	By lastname = By.id("lastName");
	By dateofbirth = By.id("DOB");
	By titleText =By.className("barone");
	By login = By.className("btn submit");
	
	public Signin(WebDriver driver){
		this.driver = driver;
	}
	//Set user name in textbox
	public void setUserName(String strUserName){
		driver.findElement(user99GuruName).sendKeys(strUserName);;
	}
	
	//Set password in password textbox
	public void setPassword(String strPassword){
		 driver.findElement(password99Guru).sendKeys(strPassword);
	}

	//Set password in confirm password textbox
	public void setpasswordConfirm(String strConfirmPass){
		driver.findElement(passwordConfirm).sendKeys(strConfirmPass);
	}

	//Set fisrt name in textbox
	public void setFirstName(String strFirstName){
		driver.findElement(firstname).sendKeys(strFirstName);;
	}

	//Set lastName in textbox
	public void setLastName(String strLastName){
		driver.findElement(lastname).sendKeys(strLastName);;
	}

	//Set lastName in textbox
	public void setDOB(String strdateofbirth){
		driver.findElement(dateofbirth).sendKeys(strdateofbirth);;
	}
	//Click on login button
	public void clickLogin(){
			driver.findElement(login).click();
	}
	
	//Get the title of Login Page
	public String getLoginTitle(){
	 return	driver.findElement(titleText).getText();
	}
	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @param strConfirmPass
	 * @param strFirstName
	 * @param strLastName
	 * @param strdateofbirth
	 * @return
	 */
	public void loginToGuru99(String strUserName,String strPasword,String strConfirmPass,String strFirstName,String strLastName,String strdateofbirth ){

		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Fill confirm password
		this.setpasswordConfirm(strConfirmPass);
    	//Fill FirstName
		this.setFirstName(strFirstName);
		//Fill LastName
		this.setLastName(strLastName);
		//Fill LastName
		this.setDOB(strdateofbirth);
		//Click Login button
		this.clickLogin();		
		
	}
}
