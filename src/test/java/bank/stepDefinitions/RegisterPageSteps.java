package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageObjects.RegisterPageObject;
import userPageObjects.UserPageGenaratorManager;
import utilities.FakerConfig;

public class RegisterPageSteps {  
    
    WebDriver driver;   
    RegisterPageObject registerPage;
    FakerConfig fakerData;    
    static String firstName, lastName, email, pass, fullName, friendEmail;    

    public RegisterPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
	registerPage = UserPageGenaratorManager.getRegisterPage(driver);
	
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
	registerPage.inputToFirstNameTextbox(firstName);
    }

    @When("^Input to LastName textbox$")
    public void input_to_LastName_textbox() {
	registerPage.inputToLastNameTextbox(lastName);
        
    }

    @When("^Input to Email textbox$")
    public void input_to_Email_textbox() {
	registerPage.inputToEmailTextbox(email);
        
    }

    @When("^Input to Password textbox$")
    public void input_to_Password_textbox() {
	registerPage.inputToPasswordTextbox(pass);
        
    }

    @When("^Input to Confirm Password textbox$")
    public void input_to_Confirm_Password_textbox() {
	registerPage.inputToConfirmPasswordTextbox(pass);
        
    }

    @When("^I click to Register button$")
    public void i_click_to_Register_button() {
	registerPage.clickToRegisterButton();
        
    }
    
}
