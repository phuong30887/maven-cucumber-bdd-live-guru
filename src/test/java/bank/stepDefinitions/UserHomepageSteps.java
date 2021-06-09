package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.GlobalConstants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageObjects.UserHomepageObject;
import userPageObjects.UserPageGenaratorManager;

public class UserHomepageSteps {
    
    WebDriver driver;   
    UserHomepageObject userHomepage;

    public UserHomepageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
	userHomepage = UserPageGenaratorManager.getUserHomepage(driver);
    }
    
    @Given("^Open user homepage$")
    public void open_user_homepage() {        
	userHomepage.openPageURL(driver, GlobalConstants.LIVE_DEMO_USERS_PAGE_URL);
    }

    @When("^I click on Acount menu$")
    public void i_click_on_Acount_menu() {        
	userHomepage.clickToAccountLinkAtHeaderMenu(driver);
    }
    
    @When("^I choose Register link$")
    public void i_choose_Register_link() {
	userHomepage.clickToSubMenuItemOfAccountLinkAtHeaderMenu(driver, "Register");
        
    }

}
