package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.UserLoginPageUI;

public class UserLoginPageObject extends AbstractPage{

    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public void inputToEmailTextbox(String email) {
	waitToElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String pass) {
	waitToElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, pass);
    }

    public AccountDashboardPageObject clickToLoginButton() {
	waitToElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
	return UserPageGenaratorManager.getAccountDashboardPage(driver);
    }

    public void loginByUserAccount(String email, String pass) {
	inputToEmailTextbox(email);
	inputToPasswordTextbox(pass);
	clickToLoginButton();	
    }
    
}
