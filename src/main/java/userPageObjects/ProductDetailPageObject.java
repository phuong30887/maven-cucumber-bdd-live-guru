package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.ProductDetailPageUI;

public class ProductDetailPageObject extends AbstractPage{

    WebDriver driver;

    public ProductDetailPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public String getProductPrice() {
	waitToElementVisible(driver, ProductDetailPageUI.PRODUCT_PRICE_TEXT);
	return getElementText(driver, ProductDetailPageUI.PRODUCT_PRICE_TEXT);
    }

    public ShoppingCartPageObject clickToAddToCartButton() {
	waitToElementClickable(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
	clickToElement(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
	return UserPageGenaratorManager.getShoppingCartPage(driver);
    }

    public void clickToAddYourReviewLink() {
	waitToElementClickable(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
	clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK);	
    }
    

    public void clearTextOfNickNameTextbox() {
	waitToElementVisible(driver, ProductDetailPageUI.YOUR_NICKNAME_TEXTBOX_AT_REVIEW_PAGE);
	sendkeyToElement(driver, ProductDetailPageUI.YOUR_NICKNAME_TEXTBOX_AT_REVIEW_PAGE, "");
    }

    public void clickToSubmitReviewButton() {
	waitToElementClickable(driver, ProductDetailPageUI.SUBMIT_REVIEW_BUTTON_AT_REVIEW_PAGE);
	clickToElement(driver, ProductDetailPageUI.SUBMIT_REVIEW_BUTTON_AT_REVIEW_PAGE);
    }

    public boolean isThisRequiredFieldMessageDisplayed(String fieldName) {
	return isElementDisplayed(driver, ProductDetailPageUI.DYNAMIC_REQUIRED_FIELD_AT_REVIEW_PAGE, fieldName);
    }

    public String getRateRequiredMessage() {
	waitToElementVisible(driver, ProductDetailPageUI.RATE_THIS_PRODUCT_REQUIRED_MESSAGE_AT_REVIEW_PAGE);
	return getElementText(driver, ProductDetailPageUI.RATE_THIS_PRODUCT_REQUIRED_MESSAGE_AT_REVIEW_PAGE);
    }

    public void selectRate5RadioButton() {
	waitToElementClickable(driver, ProductDetailPageUI.RATE_5_RADIO_BUTTON_AT_REVIEW_PAGE);
	clickToElement(driver, ProductDetailPageUI.RATE_5_RADIO_BUTTON_AT_REVIEW_PAGE);
    }

    public void inputToLetUsKnowYourThoughtsTextbox(String value) {
	waitToElementVisible(driver, ProductDetailPageUI.YOUR_THOUGHTS_TEXTAREA_AT_REVIEW_PAGE);
	sendkeyToElement(driver, ProductDetailPageUI.YOUR_THOUGHTS_TEXTAREA_AT_REVIEW_PAGE, value);
    }

    public void inputToSummaryOfYourReviewTextbox(String value) {
	waitToElementVisible(driver, ProductDetailPageUI.YOUR_REVIEW_TEXTBOX_AT_REVIEW_PAGE);
	sendkeyToElement(driver, ProductDetailPageUI.YOUR_REVIEW_TEXTBOX_AT_REVIEW_PAGE, value);
    }

    public void inputToWhatYourNickNameTextbox(String value) {
	waitToElementVisible(driver, ProductDetailPageUI.YOUR_NICKNAME_TEXTBOX_AT_REVIEW_PAGE);
	sendkeyToElement(driver, ProductDetailPageUI.YOUR_NICKNAME_TEXTBOX_AT_REVIEW_PAGE, value);
    }

    public void clickToReivewsTab() {
	waitToElementClickable(driver, ProductDetailPageUI.REVIEWS_TAB_AT_REVIEW_PAGE);
	clickToElement(driver, ProductDetailPageUI.REVIEWS_TAB_AT_REVIEW_PAGE);
    }

    public boolean isYourReviewDisplayed(String yourReview, String yourThoughtReview, String yourNicknameReview) {
	return isElementDisplayed(driver, ProductDetailPageUI.YOUR_REVIEW_AT_REVIEWS_TAB_AT_PRODUCT_DETAIL_PAGE, yourReview, yourThoughtReview, yourNicknameReview);
    }





    
}
