package bank.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageUIs.MyWishlistPageUI;

public class MyWishlistPageSteps  extends AbstractPage {
    
    WebDriver driver; 
    
    public MyWishlistPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
    }
    
    @Then("^I see the message product \"([^\"]*)\" has been addded to your wishlist$")
    public void i_see_the_message_product_has_been_addded_to_your_wishlist(String productName) {
        Assert.assertEquals(getSuccessMessage(driver), productName + " has been added to your wishlist. Click here to continue shopping.");
        
    }

    @When("^I click to Share Wishlish button$")
    public void i_click_to_Share_Wishlish_button() {
	waitToElementClickable(driver, MyWishlistPageUI.SHARE_WISHLIST_BUTTON);
	clickToElement(driver, MyWishlistPageUI.SHARE_WISHLIST_BUTTON);
        
    }

    @When("^I input to Email textarea \"([^\"]*)\"$")
    public void i_input_to_Email_textarea(String emailAddress) {
	waitToElementVisible(driver, MyWishlistPageUI.EMAIL_TEXTAREA_AT_SHARE_WISHLIST_PAGE);
	sendkeyToElement(driver, MyWishlistPageUI.EMAIL_TEXTAREA_AT_SHARE_WISHLIST_PAGE, emailAddress);
        
    }

    @When("^I input to Message textarea$")
    public void i_input_to_Message_textarea() {
	String message = RegisterPageSteps.fullName + " is sharing to you about product " + ProductListingPageSteps.productName;
        waitToElementVisible(driver, MyWishlistPageUI.MESSAGE_TEXTAREA_AT_SHARE_WISHLIST_PAGE);
	sendkeyToElement(driver, MyWishlistPageUI.MESSAGE_TEXTAREA_AT_SHARE_WISHLIST_PAGE, message);	
    }

    @Then("^I see the success Message \"([^\"]*)\"$")
    public void i_see_the_success_Message(String expectedMessage) {	
	Assert.assertEquals(getSuccessMessage(driver), expectedMessage); 
    }

}
