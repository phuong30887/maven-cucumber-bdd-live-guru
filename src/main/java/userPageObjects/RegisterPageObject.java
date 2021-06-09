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
	waitToElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
	waitToElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	
    }

    public void inputToEmailTextbox(String email) {
	waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	
    }

    public void inputToPasswordTextbox(String pass) {
	waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, pass);
	
    }

    public void inputToConfirmPasswordTextbox(String pass) {
	waitToElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
	sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, pass);
	
    }

    public AccountDashboardPageObject clickToRegisterButton() {
	waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
	clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
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
