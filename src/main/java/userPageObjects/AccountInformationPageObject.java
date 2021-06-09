package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.AccountInformationPageUI;

public class AccountInformationPageObject extends AbstractPage{

    WebDriver driver;

    public AccountInformationPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public String getFirstNameValue() {
	waitToElementVisible(driver, AccountInformationPageUI.FIRSTNAME_TEXTBOX);
	return getElementAttribute(driver, AccountInformationPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameValue() {
	waitToElementVisible(driver, AccountInformationPageUI.LASTNAME_TEXTBOX);
	return getElementAttribute(driver, AccountInformationPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getEmailValue() {
	waitToElementVisible(driver, AccountInformationPageUI.EMAIL_TEXTBOX);
	return getElementAttribute(driver, AccountInformationPageUI.EMAIL_TEXTBOX, "value");
    }


    
}
