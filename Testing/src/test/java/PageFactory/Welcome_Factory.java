package PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;


public class Welcome_Factory {

	/**
	 * Step 1
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

    @FindBy(className="title")
    WebElement welcometitle;



	@FindBy(id="search-field")
	WebElement searchfield;

	@FindBy(css="a.button.find-resources")
	WebElement searchicon;

	// category buttons lists
	@FindBy(css=".button.cat-1>h4")
	WebElement Counselling_category;

	@FindBy(css=".button.cat-7>h4")
	WebElement Drugs_category;

	@FindBy(css=".button.cat-4>h4")
	WebElement Housing_category;

    @FindBy(css=".button.cat-5>h4")
    WebElement jobs_category;

    @FindBy(css=".button.cat-10>h4")
    WebElement legal_category;

	@FindBy(css=".button.cat-3>h4")
	WebElement health_category;

	@FindBy(css=".button.cat-2>h4")
	WebElement violence_category;

    @FindBy(css=".button.cat-6>h4")
    WebElement aboriginal_category;

	@FindBy(css=".back-to-top>a>span")
	WebElement hreftop;

    @FindBy(css=".footer>p>.button")
    WebElement learn_button;

    @FindBy(className=".button.find-resources")
    WebElement click_button;

    //---------Clicks on hamburg menu-----//

    @FindBy(css=".fa.fa-bars.fa-lg")
    WebElement hamburg_icon;

    @FindBy(css=".fa.fa-home.fa-lg")
    WebElement home_hamburg_icon;

    @FindBy(css=".fa.fa-search.fa-lg")
    WebElement search_hamburg_icon;

    @FindBy(css=".fa.fa-star.fa-lg")
    WebElement start_hamburg_icon;

    @FindBy(css=".fa.fa-lightbulb-o.fa-lg")
    WebElement tips_hamburg_icon;


    @FindBy(css=".fa.fa-comment.fa-lg")
    WebElement survey_hamburg_icon;


    public Welcome_Factory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

	/**
	 * Step 2
	 * All User Actions Defined to this features (methods)
	 */

	//Get the title of Welcome Page
	public String getwelcomeTitle(){
		return	welcometitle.getText();
	}


	//Set user name in textbox
	public void setkeyword(String strKeyword){
		searchfield.sendKeys(strKeyword);
	}

    public void click_search(){
        searchicon.click();
    }



	//Set user name in textbox
	public void setTypeEnter(){
		//searchfield.sendKeys(Keys.ENTER);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("javascript:form_submitSearch();");

    }


    /*
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @param strConfirmPass
	 * @param strFirstName
	 * @param strLastName
	 * @param strdateofbirth
	 * @return
	 */




	// Validate Search by Keyword
	public void SearchByKeyword(String strKeyword){
		this.setkeyword(strKeyword);
        return;
	}


    // Click on Counselling
    public void Select_Counselling_Category(){

        this.Counselling_category.click();
        return;
    }

    // Click on Drugs
    public void Select_Drugs_Category(){
        this.Drugs_category.click();
        return;
    }

    // Click on Housing
    public void Select_Housing_Category(){
        this.Housing_category.click();
        return;
    }


    // Click on Housing
    public void Select_Jobs_Category(){
        this.jobs_category.click();
        return;
    }

    // Click on Legal
    public void Select_Legal_Category(){
        this.legal_category.click();
        return;
    }

    // Click on Health
    public void Select_Health_Category(){
        this.health_category.click();
        return;
    }

    // Click on Violence
    public void Select_Violence_Category(){
        this.violence_category.click();
        return;
    }

    // Click on aboriginal
    public void Select_Aboriginal_Category(){
        this.aboriginal_category.click();
        return;
    }

    // Click on LGBTQ
    public void Select_Lgbtq_Category(){
        this.aboriginal_category.click();
        return;
    }

    // Click on top
    public void Click_top_link(){
        this.hreftop.click();
        return;
    }


    // Click on learn button
    public void click_learn_button(){
        this.learn_button.click();
        return;
    }

    // Click on hamburg_icon
    public void  click_hamburg_icon( ) {
        Actions act = new Actions(driver);
        // Mouse over an element
        act.moveToElement(hamburg_icon).perform();
        act.click(home_hamburg_icon).perform();
        return ;
    }

    // Click on hamburg_icon
    public void  click_hamburg_home_icon( ) {
        Actions act = new Actions(driver);
        // Mouse over an element
        act.click(home_hamburg_icon).perform();
        return ;
    }



    // Click on hamburg_search_icon
    public void  click_hamburg_search_icon( ) {

        Actions act = new Actions(driver);
        // Mouse over an element
        act.click(search_hamburg_icon).perform();
        return ;
    }


    // Click on click_hamburg_star_icon
    public void click_hamburg_star_icon( ) {

        Actions act = new Actions(driver);
        // Mouse over an element
        act.click(search_hamburg_icon).perform();
        return ;
    }
    public void  click_hamburg_search_tips_icon( ) {

        Actions act = new Actions(driver);
        // Mouse over an element
        act.click(tips_hamburg_icon).perform();
        return ;
    }

    public void  click_hamburg_survey_icon( ) {

        Actions act = new Actions(driver);
        // Mouse over an element
        act.click(survey_hamburg_icon).perform();
        return ;
    }



    /**
     * Step 3
     * All User Services Defined to this main features (search)
     * In this Case
     */








}
