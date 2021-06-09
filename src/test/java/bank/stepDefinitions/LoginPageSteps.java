package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import userPageUIs.UserLoginPageUI;

public class LoginPageSteps extends AbstractPage {
    
    WebDriver driver;   

    public LoginPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();	
    }
    
    @Given("^Input to Email textbox at Login page$")
    public void input_to_Email_textbox_at_Login_page() {
	waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, RegisterPageSteps.email);       
    }

    @Given("^Input to Password textbox at Login page$")
    public void input_to_Password_textbox_at_Login_page() {
	waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, RegisterPageSteps.pass);       
    }

    @Given("^Click to Login button$")
    public void click_to_Login_button() {
	waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);       
    }

    public void loginByUserAccount(String email, String pass) {
	input_to_Email_textbox_at_Login_page();
	input_to_Password_textbox_at_Login_page();
	click_to_Login_button();	
    }
}
