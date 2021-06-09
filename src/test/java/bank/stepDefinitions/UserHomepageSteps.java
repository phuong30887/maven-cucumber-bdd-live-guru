package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.GlobalConstants;
import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;

public class UserHomepageSteps extends AbstractPage {
    
    WebDriver driver;   

    public UserHomepageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
    }
    
    @Given("^Open user homepage$")
    public void open_user_homepage() {        
	openPageURL(driver, GlobalConstants.LIVE_DEMO_USERS_PAGE_URL);
    }
    

}
