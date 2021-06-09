package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageUIs.RegisterPageUI;
import utilities.FakerConfig;

public class RegisterPageSteps extends AbstractPage {

    WebDriver driver;
    FakerConfig fakerData;
    static String firstName, lastName, email, pass, fullName, friendEmail;

    public RegisterPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();

	fakerData = FakerConfig.getData();
	firstName = fakerData.getFirstName();
	lastName = fakerData.getLastName();
	fullName = firstName + " " + lastName;
	email = fakerData.getEmail(firstName, lastName);
	friendEmail = fakerData.getEmail();
	pass = fakerData.getPassword();
    }

    @When("^Input to FirstName textbox$")
    public void input_to_FirstName_textbox() {
	waitToElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @When("^Input to LastName textbox$")
    public void input_to_LastName_textbox() {
	waitToElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    @When("^Input to Email textbox$")
    public void input_to_Email_textbox() {
	waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    @When("^Input to Password textbox$")
    public void input_to_Password_textbox() {
	waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, pass);
    }

    @When("^Input to Confirm Password textbox$")
    public void input_to_Confirm_Password_textbox() {
	waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, pass);
    }

    @When("^I click to Register button$")
    public void i_click_to_Register_button() {
	waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
	clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }
    
    public void RegisterAnUser() {
	
	input_to_FirstName_textbox();

	input_to_LastName_textbox();

	input_to_Email_textbox();
	
	input_to_Password_textbox();
	
	input_to_Confirm_Password_textbox();
	
	i_click_to_Register_button();
    }

}
