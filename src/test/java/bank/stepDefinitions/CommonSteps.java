package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractPageUI;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;

/*
 * This class is the collection of common actions like : 
 *  - click to header menu link( account, register, login...), 
 *  - click to bottom link (search...), 
 *  this mean some functions at abstract page will be moved to here 
 * */

public class CommonSteps extends AbstractPage {
    
    WebDriver driver; 
    
    public CommonSteps() {
	this.driver = Hooks.openAndQuitBrowser();
    }
    
    @When("^I click on Account menu$")
    public void i_click_on_Account_menu() {
	waitToElementClickable(driver,AbstractPageUI.ACCOUNT_HEADER_MENU);
	clickToElement(driver, AbstractPageUI.ACCOUNT_HEADER_MENU);
    }

    @Given("^I choose \"([^\"]*)\" link at Account menu at header menu$")
    public void i_choose_link_at_Account_menu_at_header_menu(String subPageName) throws Throwable {
	waitToElementClickable(driver, AbstractPageUI.DYNAMIC_ACCOUNT_SUB_ITEMS_HEADER_MENU, subPageName);
	clickToElement(driver, AbstractPageUI.DYNAMIC_ACCOUNT_SUB_ITEMS_HEADER_MENU, subPageName);
    }
    
    @When("^I click to Mobile link at header menu$")
    public void i_click_on_Mobile_link_at_header_menu() {
	waitToElementClickable(driver, AbstractPageUI.MOBILE_LINK_AT_HEADER_MENU);
	clickToElement(driver, AbstractPageUI.MOBILE_LINK_AT_HEADER_MENU);
	waitToJQueryAndJSLoadedSuccess(driver);
    }    

    @When("^I click to TV link at header menu$")
    public void i_click_to_TV_link_at_header_menu() {
	waitToElementClickable(driver, AbstractPageUI.TV_LINK_AT_HEADER_MENU);
	clickToElement(driver, AbstractPageUI.TV_LINK_AT_HEADER_MENU);
	waitToJQueryAndJSLoadedSuccess(driver);
    }
    
    @When("^I Click to Advanced Search link at bottom page$")
    public void i_Click_to_Advanced_Search_link_at_bottom_page() {
	waitToElementClickable(driver, AbstractPageUI.DYNAMIC_PAGE_NAME_AT_BOTTOM_PAGE, "Advanced Search");
	clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_NAME_AT_BOTTOM_PAGE, "Advanced Search");
    }
}
