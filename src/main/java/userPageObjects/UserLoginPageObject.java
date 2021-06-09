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
	
    }

    public void inputToPasswordTextbox(String pass) {
	
    }

    public AccountDashboardPageObject clickToLoginButton() {
	
	return UserPageGenaratorManager.getAccountDashboardPage(driver);
    }

    public void loginByUserAccount(String email, String pass) {
	inputToEmailTextbox(email);
	inputToPasswordTextbox(pass);
	clickToLoginButton();	
    }
    
}
