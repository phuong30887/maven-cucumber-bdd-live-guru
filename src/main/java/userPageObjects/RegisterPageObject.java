package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{

    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public void inputToFirstNameTextbox(String firstName) {
	
    }

    public void inputToLastNameTextbox(String lastName) {
	
	
    }

    public void inputToEmailTextbox(String email) {
	
	
    }

    public void inputToPasswordTextbox(String pass) {
	
	
    }

    public void inputToConfirmPasswordTextbox(String pass) {
	
	
    }

    public AccountDashboardPageObject clickToRegisterButton() {
	
	return UserPageGenaratorManager.getAccountDashboardPage(driver);
    }
    
    public AccountDashboardPageObject RegisterAnUser(String firstName, String lastName, String email, String pass) {
	
	inputToFirstNameTextbox(firstName);

	inputToLastNameTextbox(lastName);

	inputToEmailTextbox(email);
	
	inputToPasswordTextbox(pass);
	
	inputToConfirmPasswordTextbox(pass);
	
	return clickToRegisterButton();
    }
    
}
