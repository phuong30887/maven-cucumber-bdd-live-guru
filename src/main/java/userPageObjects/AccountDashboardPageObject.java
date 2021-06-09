package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.AccountDashboardPageUI;

public class AccountDashboardPageObject extends AbstractPage{

    WebDriver driver;

    public AccountDashboardPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public boolean isUserFullNameDisplayed(String fullName) {
	return isElementDisplayed(driver,  AccountDashboardPageUI.HELLO_TEXT, fullName);
    }

    public boolean isOrdersInformationDisplayedAtMyDashboardPage(String orderNumber, String shippingFullName,
	    String grandTotalValue, String status) {
	waittingForAjaxLoadingInvisible(driver);
	sleepInSecond(2);
	return isElementDisplayed(driver, AccountDashboardPageUI.DYNAMIC_ORDER_INFORMATION, orderNumber, shippingFullName, grandTotalValue, status);
    }

}
