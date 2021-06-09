package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.CheckoutPageUI;

public class CheckoutPageObject extends AbstractPage{

    WebDriver driver;

    public CheckoutPageObject(WebDriver driver) {
	this.driver = driver;
    }
    
    // ============== BILLING INFORMATION ============

    public String getFirstNameAtBillingInformation() {
	waitToElementVisible(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX_AT_BILLING_INFORMATION);
	return getElementAttribute(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX_AT_BILLING_INFORMATION, "value");
    }

    public String getLastNameAtBillingInformation() {
	waitToElementVisible(driver, CheckoutPageUI.LAST_NAME_TEXTBOX_AT_BILLING_INFORMATION);
	return getElementAttribute(driver, CheckoutPageUI.LAST_NAME_TEXTBOX_AT_BILLING_INFORMATION, "value");
    }

    public void inputToAddressTextboxAtBillingInformation(String address) {
	waitToElementVisible(driver, CheckoutPageUI.ADDRESS_TEXTBOX_AT_BILLING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.ADDRESS_TEXTBOX_AT_BILLING_INFORMATION, address);
    }

    public void inputToCityTextboxAtBillingInformation(String city) {
	waitToElementVisible(driver, CheckoutPageUI.CITY_TEXTBOX_AT_BILLING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.CITY_TEXTBOX_AT_BILLING_INFORMATION, city);
    }

    public void selectStateDropdownAtBillingInformation(String state) {
	waitToElementClickable(driver, CheckoutPageUI.STATE_DROPDOWN_AT_BILLING_INFORMATION);
	selectItemInDropdown(driver, CheckoutPageUI.STATE_DROPDOWN_AT_BILLING_INFORMATION, state);
    }

    public void inputToZipTextboxAtBillingInformation(String zip) {
	waitToElementVisible(driver, CheckoutPageUI.ZIP_TEXTBOX_AT_BILLING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.ZIP_TEXTBOX_AT_BILLING_INFORMATION, zip);
    }

    public void selectCountryDropdownAtBillingInformation(String country) {
	waitToElementClickable(driver, CheckoutPageUI.COUNTRY_DROPDOWN_AT_BILLING_INFORMATION);
	selectItemInDropdown(driver, CheckoutPageUI.COUNTRY_DROPDOWN_AT_BILLING_INFORMATION, country);
    }

    public void inputToTelephoneTextboxAtBillingInformation(String phone) {
	waitToElementVisible(driver, CheckoutPageUI.TELEPPHONE_TEXTBOX_AT_BILLING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.TELEPPHONE_TEXTBOX_AT_BILLING_INFORMATION, phone);
    }

    public void clickToShipToThisAddressRadioButton() {
	waitToElementClickable(driver, CheckoutPageUI.SHIP_TO_THIS_ADDRESS_RADIO_BUTTON_AT_BILLING_INFORMATION);
	clickToElement(driver, CheckoutPageUI.SHIP_TO_THIS_ADDRESS_RADIO_BUTTON_AT_BILLING_INFORMATION);
    }    

    public void clickToShipToDifferentAddressRadioButton() {
	waitToElementClickable(driver, CheckoutPageUI.SHIP_TO_DIFFERENT_ADDRESS_RADIO_BUTTON_AT_BILLING_INFORMATION);
	clickToElement(driver, CheckoutPageUI.SHIP_TO_DIFFERENT_ADDRESS_RADIO_BUTTON_AT_BILLING_INFORMATION);	
    }

    public void clickToContinueButtonAtBillingInformation() {
	waitToElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_BILLING_INFORMATION);
	clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_BILLING_INFORMATION);
	waittingForAjaxLoadingInvisible(driver);
    }


    // ============== SHIPPING INFORMATION ============
    public void inputToFirstNameTextboxAtShippingInformation(String firstName) {
	waitToElementVisible(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX_AT_SHIPPING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.FIRST_NAME_TEXTBOX_AT_SHIPPING_INFORMATION, firstName);
    }

    public void inputToLastNameTextboxAtShippingInformation(String lastName) {
	waitToElementVisible(driver, CheckoutPageUI.LAST_NAME_TEXTBOX_AT_SHIPPING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.LAST_NAME_TEXTBOX_AT_SHIPPING_INFORMATION, lastName);
    }

    public void inputToAddressTextboxAtShippingInformation(String address) {
	waitToElementVisible(driver, CheckoutPageUI.ADDRESS_TEXTBOX_AT_SHIPPING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.ADDRESS_TEXTBOX_AT_SHIPPING_INFORMATION, address);
    }

    public void inputToCityTextboxAtShippingInformation(String city) {
	waitToElementVisible(driver, CheckoutPageUI.CITY_TEXTBOX_AT_SHIPPING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.CITY_TEXTBOX_AT_SHIPPING_INFORMATION, city);
    }

    public void selectStateDropdownAtShippingInformation(String state) {
	waitToElementClickable(driver, CheckoutPageUI.STATE_DROPDOWN_AT_SHIPPING_INFORMATION);
	selectItemInDropdown(driver, CheckoutPageUI.STATE_DROPDOWN_AT_SHIPPING_INFORMATION, state);
    }

    public void inputToZipTextboxAtShippingInformation(String zip) {
	waitToElementVisible(driver, CheckoutPageUI.ZIP_TEXTBOX_AT_SHIPPING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.ZIP_TEXTBOX_AT_SHIPPING_INFORMATION, zip);
    }

    public void selectCountryDropdownAtShippingInformation(String country) {
	waitToElementClickable(driver, CheckoutPageUI.COUNTRY_DROPDOWN_AT_SHIPPING_INFORMATION);
	selectItemInDropdown(driver, CheckoutPageUI.COUNTRY_DROPDOWN_AT_SHIPPING_INFORMATION, country);
    }

    public void inputToTelephoneTextboxAtShippingInformation(String phone) {
	waitToElementVisible(driver, CheckoutPageUI.TELEPPHONE_TEXTBOX_AT_SHIPPING_INFORMATION);
	sendkeyToElement(driver, CheckoutPageUI.TELEPPHONE_TEXTBOX_AT_SHIPPING_INFORMATION, phone);
    }

    public void clickToContinueButtonAtShippingInformation() {
	waitToElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_INFORMATION);
	clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_INFORMATION);
	waittingForAjaxLoadingInvisible(driver);
    } 
    
    // ============== SHIPPING METHOD ============

    public void clickToContinueButtonAtShippingMethod() {
	waitToElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD);
	clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_SHIPPING_METHOD);
	waittingForAjaxLoadingInvisible(driver);
    }

    // ============== PAYMENT INFORMATION ============
    
    public void clickToCheckMoneyOrderRadioButton() {
	waitToElementClickable(driver, CheckoutPageUI.CHECK_MONEY_ORDER_RADIO_BUTTON);
	clickToElement(driver, CheckoutPageUI.CHECK_MONEY_ORDER_RADIO_BUTTON);
    }
    
    public void clickToContinueButtonAtPaymentInformation() {
	waitToElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_PAYMENT_INFORMATION);
	clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_AT_PAYMENT_INFORMATION);
	waittingForAjaxLoadingInvisible(driver);
    }

    // ============== ORDER REVIEW ============
    public void clickToPlaceOrderButton() {
	waitToElementClickable(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);
	clickToElement(driver, CheckoutPageUI.PLACE_ORDER_BUTTON);
	waittingForAjaxLoadingInvisible(driver);
	sleepInSecond(1);
    }

    public String getOrderSuccessMessage() {
	waitToElementVisible(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
	return getElementText(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
    }

    public String getOrderNumber() {
	waitToElementVisible(driver, CheckoutPageUI.ORDER_ID_TEXT);
	return getElementText(driver, CheckoutPageUI.ORDER_ID_TEXT);
    }  


    
}
