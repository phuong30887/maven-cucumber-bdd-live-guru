package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.ShoppingCartPageUI;

public class ShoppingCartPageObject extends AbstractPage{

    WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public void inputToDiscountCodesTextbox(String discountCode) {
	waitToElementVisible(driver, ShoppingCartPageUI.DISCOUNT_CODES_TEXTBOX);
	sendkeyToElement(driver, ShoppingCartPageUI.DISCOUNT_CODES_TEXTBOX, discountCode);
    }

    public void clickToApplyLink() {
	waitToElementClickable(driver, ShoppingCartPageUI.APPLY_DISCOUNT_CODES_LINK);
	clickToElement(driver, ShoppingCartPageUI.APPLY_DISCOUNT_CODES_LINK);
    }

    public boolean isDiscountCostDisplayedAtTotalsTable(String discountCode) {	
	return isElementDisplayed(driver, ShoppingCartPageUI.DISCOUNT_TITLE_AT_TOTALS_TABLE, discountCode);
    }

    public String getDiscountCostValue() {
	waitToElementVisible(driver, ShoppingCartPageUI.DISCOUNT_VALUE_AT_TOTALS_TABLE);
	return getElementText(driver, ShoppingCartPageUI.DISCOUNT_VALUE_AT_TOTALS_TABLE);
    }

    public String getSubTotalValue() {
	waitToElementVisible(driver, ShoppingCartPageUI.SUB_TOTAL_VALUE_AT_TOTALS_TABLE);
	return getElementText(driver, ShoppingCartPageUI.SUB_TOTAL_VALUE_AT_TOTALS_TABLE);
    }

    public void inputToQuantityTextbox(String productQuantity) {
	waitToElementVisible(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX);
	sendkeyToElement(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX, productQuantity);
    }

    public void clickToUpdateButton() {
	waitToElementClickable(driver, ShoppingCartPageUI.UPDATE_BUTTON);
	clickToElement(driver, ShoppingCartPageUI.UPDATE_BUTTON);
    }

    public String getMaximumQuantityAllowedMessageOfAProduct(String productName) {
	waitToElementVisible(driver, ShoppingCartPageUI.DYNAMIC_MAXIMUN_QUANTITY_ALLOWED_ERROR_MESSAGE, productName);	
	return getElementText(driver, ShoppingCartPageUI.DYNAMIC_MAXIMUN_QUANTITY_ALLOWED_ERROR_MESSAGE, productName);
    }

    public void clickToEmptyCartLink() {
	waitToElementClickable(driver, ShoppingCartPageUI.EMPTY_CART_LINK);
	clickToElement(driver, ShoppingCartPageUI.EMPTY_CART_LINK);	
    }

    public boolean isShoppingCartIsEmptyMessageDisplayed() {
	return isElementDisplayed(driver, ShoppingCartPageUI.SHOPPING_CART_IS_EMPTY_MESSAGE);
    }

    public boolean isYouHaveNoItemsInYourShoppingCartMessageDisplayed() {
	return isElementDisplayed(driver, ShoppingCartPageUI.NO_ITEMS_MESSAGE);
    }

    public void selectCountryAtEstimateShipping(String country) {
	waitToElementClickable(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN_AT_ESTIMATE_SHIPPING);
	selectItemInDropdown(driver, ShoppingCartPageUI.COUNTRY_DROPDOWN_AT_ESTIMATE_SHIPPING, country);
    }

    public void selectStateDropdownAtEstimateShipping(String state) {
	waitToElementClickable(driver, ShoppingCartPageUI.STATE_DROPDOWN_AT_ESTIMATE_SHIPPING);
	selectItemInDropdown(driver, ShoppingCartPageUI.STATE_DROPDOWN_AT_ESTIMATE_SHIPPING, state);
    }

    public void inputZipAtEstimateShipping(String zip) {
	waitToElementVisible(driver, ShoppingCartPageUI.ZIP_TEXTBOX_AT_ESTIMATE_SHIPPING);
	sendkeyToElement(driver, ShoppingCartPageUI.ZIP_TEXTBOX_AT_ESTIMATE_SHIPPING, zip);
    }

    public void clickToEstimateLink() {
	waitToElementClickable(driver, ShoppingCartPageUI.ESTIMATE_LINK_AT_ESTIMATE_SHIPPING);
	clickToElement(driver, ShoppingCartPageUI.ESTIMATE_LINK_AT_ESTIMATE_SHIPPING);
    }

    public String getTheFlatRateFixed() {
	waitToElementVisible(driver, ShoppingCartPageUI.FLAT_RATE_FIXED_PRICE_AT_ESTIMATE_SHIPPING);	
	return getElementText(driver, ShoppingCartPageUI.FLAT_RATE_FIXED_PRICE_AT_ESTIMATE_SHIPPING);
    }

    public void clickToFixedFlatRateRadioButton() {
	waitToElementClickable(driver, ShoppingCartPageUI.FLAT_RATE_FIXED_RADIO_BUTTON_AT_ESTIMATE_SHIPPING);
	clickToElement(driver, ShoppingCartPageUI.FLAT_RATE_FIXED_RADIO_BUTTON_AT_ESTIMATE_SHIPPING);
    }

    public void clickToUpdateTotalButton() {
	waitToElementClickable(driver, ShoppingCartPageUI.FLAT_RATE_UPDATE_TOTAL_BUTTON_AT_ESTIMATE_SHIPPING);
	clickToElement(driver, ShoppingCartPageUI.FLAT_RATE_UPDATE_TOTAL_BUTTON_AT_ESTIMATE_SHIPPING);
    }    

    public String getGrandTotalValue() {
	waitToElementVisible(driver, ShoppingCartPageUI.GRAND_TOTAL_VALUE_AT_TOTALS_TABLE);	
	return getElementText(driver, ShoppingCartPageUI.GRAND_TOTAL_VALUE_AT_TOTALS_TABLE);
    }

    public String calculateGrandTotal(String subtotal, String flatRateFixed) {
	String totalValue = "";
	float totalValueFloat = Float.parseFloat(subtotal.replace("$", "")) + Float.parseFloat(flatRateFixed.replace("$", ""));	
	
	totalValue = "$" + Float.toString(totalValueFloat);
	totalValue = totalValue.replace(".0", ".00");
	System.out.println("============== totalValue: " + totalValue);
	return totalValue;
    }

    public CheckoutPageObject clickToProceedToCheckoutButton() {
	waitToElementClickable(driver, ShoppingCartPageUI.PROCEED_TO_CHECKOUT_AT_TOTALS_TABLE);
	clickToElement(driver, ShoppingCartPageUI.PROCEED_TO_CHECKOUT_AT_TOTALS_TABLE);
	return UserPageGenaratorManager.getCheckoutPage(driver);
    }





    
}
