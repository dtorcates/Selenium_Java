package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;


public class Signin_Factory {

	/**
	 * Step 1
	 * All WebElements are identified by @FindBy annotation
	 */

    @FindBy(className="title")
    WebElement titleText;


	WebDriver driver;
	@FindBy(name="email")
	WebElement user99GuruName;
	
	@FindBy(name="password")
	WebElement password99Guru;

	@FindBy(name="passwordConfirm")
	WebElement ConfirmPass;

	@FindBy(id="firstName")
	WebElement firstName;


	@FindBy(id="lastName")
	WebElement lastName;

	@FindBy(id="DOB")
	WebElement dateofbirth;


	@FindBy(xpath="html/body/div/div/div/form/div/div[7]/button")
			//"html/body/div/main/ui-view/div/form/div/div[7]/button")

	WebElement login;

	@FindBy(xpath="html/body/div/main/ui-view/div/form/div/section/div[2]/div[1]/div[2]")
	WebElement email_mouseover_icon;

	@FindBy(xpath="html/body/div/main/ui-view/div/form/div/div[3]/div/div[1]/div[1]/div[2]")
	WebElement dob_mouseover_icon;


	@FindBy(xpath="html/body/div/main/ui-view/div/form/div/div[5]/div/div[2]")
	WebElement rem_dev_mouseover_icon;


	@FindBy(className="error-msg")
	WebElement error_msg_email;


	@FindBy(xpath="html/body/div/main/ui-view/div/form/div/section/div[3]/span[1]")
	WebElement error_msg_pass;

	@FindBy(xpath = "html/body/div[1]/main/ui-view/div/form/div/div[4]/label")
	WebElement checkbox1;

    @FindBy(xpath = "html/body/div[1]/main/ui-view/div/form/div/div[5]/label")
    WebElement checkbox2;

	@FindBy(xpath = "html/body/div/main/ui-view/div/form/div/section/div[4]/span")
	WebElement notmatchpasslabel;

	@FindBy(xpath = "html/body/div/main/ui-view/div/form/div/div[2]/div/div[1]/span")
	WebElement firstnamelabel;


	@FindBy(xpath = "html/body/div/main/ui-view/div/form/div/div[2]/div/div[2]/span")
	WebElement lastnamelabel;

	@FindBy(xpath = "html/body/div/main/ui-view/div/form/div/div[3]/div/div[1]/span")
	WebElement doblabel;

	public Signin_Factory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Step 2
	 * All User Actions Defined to this features (methods)
	 */

	//Set user name in textbox
	public void setUserName(String strUserName){
		user99GuruName.sendKeys(strUserName);
		
	}
	//Set password in password textbox
	public void setPassword(String strPassword){
		password99Guru.sendKeys(strPassword);
	}

	//Set confim password in password textbox
	public void setConfirmPass(String strConfirmPass){
		ConfirmPass.sendKeys(strConfirmPass);
	}

	//Set FirstName in fistname textbox
	public void setFirstName(String strFirstName){
		firstName.sendKeys(strFirstName);
	}


	//Set DOB in DOB dropdown
	public void setLastName(String strLastName){
		lastName.sendKeys(strLastName);
	}

	//Set LastName in lastname textbox
	public void setDOB(String strdateofbirth){
		dateofbirth.sendKeys(strdateofbirth);
	}

	//Click on login button

	public void clickLogin(){
			login.click();
	}


	public void  EmailMouseOver( ){
		Actions act = new Actions(driver);
		// Mouse over an element
		act.moveToElement(email_mouseover_icon).perform();
		return ;
	}

	public void  DOBMouseOver( ){
		Actions act = new Actions(driver);
		// Mouse over an element
		act.moveToElement(dob_mouseover_icon).perform();
		return ;
	}

	public void  Remember_device_MouseOver( ){

		Actions act = new Actions(driver);
		// Mouse over an element
		act.moveToElement(rem_dev_mouseover_icon).perform();
		return ;
	}




	//Get the title of Login Page
	public String getLoginTitle(){
		return	titleText.getText();
	}


	//Get Error message for Email//Get Error message for Email

	public String getEmailMissingError(){
		return	error_msg_email.getText();
	}

	public String getPassMissingError(){
		return	error_msg_pass.getText();
	}

	public String getMatchpassword(){
		return	notmatchpasslabel.getText();
	}


	public String getFirstNameMissinglabel(){
		return	firstnamelabel.getText();
	}


	public String getLasNameMissinglabel(){
		return	lastnamelabel.getText();
	}

	public String getdobMissinglabel(){
		return	doblabel.getText();
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


    /**
     * Step 3
     * All User Services Defined to this features (methods)
     * In this Case is Sign in features
     */

	public void ClearFields(){
		//Fill user name
		this.setUserName("");

		//Fill password
		this.setPassword("");

		//Fill confirm password
		this.setConfirmPass("");

		//Fill FirstName
		this.setFirstName("");

		//Fill LastName
		this.setLastName("");

		//Clear DOB
		this.setDOB("");


	}

    // Validate Email
	public String Validate_Email(String strUserName, String strPasword, String strConfirmPass,String strFirstname ,String strLastName, String strdateofbirth){
		//Fill user name
		this.setUserName("");

		//Fill password
		this.setPassword(strPasword);

		//Fill confirm password
		this.setConfirmPass(strConfirmPass);

		//Fill FirstName
		this.setFirstName(strFirstname);

		//Fill LastName
		this.setLastName(strLastName);

		//Clear DOB
		this.setDOB("strFirstname");
		//Fill DOB
		this.setDOB(strdateofbirth);

		//Click Login button
		this.clickLogin();


		return	error_msg_email.getText();


	}

	// Validate pass empty

	public String Validate_Pass(String strUserName, String strConfirmPass,String strFirstname ,String strLastName, String strdateofbirth){
		//Fill user name

		this.setUserName(strUserName);

		//Fill password
		this.setPassword("");

		//Fill confirm password
		this.setConfirmPass(strConfirmPass);

		//Fill FirstName
		this.setFirstName(strFirstname);

		//Fill LastName
		this.setLastName(strLastName);

		//Clear DOB
		this.setDOB("");
		//Fill DOB
		this.setDOB(strdateofbirth);

		//Click Login button
		this.clickLogin();


		return	error_msg_pass.getText();


	}

     // Validate Uncheck 1
	public boolean Test_uncheck_option_1(){
		this.checkbox1.click();
		return false ;

	}

    // Validate Uncheck 1
    public boolean Test_uncheck_option_2(){
        this.checkbox2.click();
        return false ;

    }

	// Compare pass asn confirm
	public String compare_pass(String strUserName,String strPasword,String strConfirmPass){
		this.setUserName(strUserName);

		//Fill password
		this.setPassword(strPasword);

		//Fill confirm password
		this.setConfirmPass(strConfirmPass);

		//Fill FirstName

		this.clickLogin();
		return	notmatchpasslabel.getText();

	}


	// Validate FirstName empty

	public String ValidateFirstNameEmpty(String strUserName,String strPasword,String strConfirmPass,String strFirstName,String strLastName,String strdateofbirth ){
		//Fill user name
		this.setUserName(strUserName);

		//Fill password
		this.setPassword(strPasword);

		//Fill confirm password
		this.setConfirmPass(strConfirmPass);

		//Fill FirstName
		this.setFirstName("");

		//Fill LastName
		this.setLastName(strLastName);

		//Clear DOB
		this.setDOB("");
		//Fill DOB
		this.setDOB(strdateofbirth);

		//Click Login button
		this.clickLogin();
		return	firstnamelabel.getText();

	}


// Validate LastName empty

	public String ValidateLastNameEmpty(String strUserName,String strPasword,String strConfirmPass,String strFirstName,String strLastName,String strdateofbirth ){
		//Fill user name
		this.setUserName(strUserName);

		//Fill password
		this.setPassword(strPasword);

		//Fill confirm password
		this.setConfirmPass(strConfirmPass);

		//Fill FirstName
		this.setFirstName(strFirstName);

		//Fill LastName
		this.setLastName("");

		//Clear DOB
		this.setDOB("");
		//Fill DOB
		this.setDOB(strdateofbirth);

		//Click Login button
		this.clickLogin();
		return	lastnamelabel.getText();

	}


	// Validate LastName empty

	public String ValidateDobEmpty(String strUserName,String strPasword,String strConfirmPass,String strFirstName,String strLastName,String strdateofbirth ){
		//Fill user name
		this.setUserName(strUserName);

		//Fill password
		this.setPassword(strPasword);

		//Fill confirm password
		this.setConfirmPass(strConfirmPass);

		//Fill FirstName
		this.setFirstName(strFirstName);

		//Fill LastName
		this.setLastName(strLastName);

		//Clear DOB
		this.setDOB("");
		//Fill DOB
		this.setDOB(strdateofbirth);

		//Click Login button
		this.clickLogin();
		return	doblabel.getText();

	}

	public void SignInPage(String strUserName,String strPasword,String strConfirmPass,String strFirstName,String strLastName,String strdateofbirth ){
		//Fill user name
		this.setUserName(strUserName);

		//Fill password
		this.setPassword(strPasword);

		//Fill confirm password
		this.setConfirmPass(strConfirmPass);

		//Fill FirstName
		this.setFirstName(strFirstName);

        //Fill LastName
        this.setLastName(strLastName);

        //Clear DOB
        this.setDOB("");
        //Fill DOB
        this.setDOB(strdateofbirth);

		//Click Login button
		this.clickLogin();

	}


}
