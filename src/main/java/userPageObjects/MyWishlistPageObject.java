package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.MyWishlistPageUI;

public class MyWishlistPageObject extends AbstractPage{

    WebDriver driver;

    public MyWishlistPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public void clickToShareWishlistButton() {
	waitToElementClickable(driver, MyWishlistPageUI.SHARE_WISHLIST_BUTTON);
	clickToElement(driver, MyWishlistPageUI.SHARE_WISHLIST_BUTTON);
    }

    public void inputToEmailTextarea(String friendEmail) {
	waitToElementVisible(driver, MyWishlistPageUI.EMAIL_TEXTAREA_AT_SHARE_WISHLIST_PAGE);
	sendkeyToElement(driver, MyWishlistPageUI.EMAIL_TEXTAREA_AT_SHARE_WISHLIST_PAGE, friendEmail);
    }

    public void inputToMessageTextarea(String message) {
	waitToElementVisible(driver, MyWishlistPageUI.MESSAGE_TEXTAREA_AT_SHARE_WISHLIST_PAGE);
	sendkeyToElement(driver, MyWishlistPageUI.MESSAGE_TEXTAREA_AT_SHARE_WISHLIST_PAGE, message);	
    }

    public boolean isProductNameDisplayedAtMyWishlistPage(String productName) {
	return isElementDisplayed(driver, MyWishlistPageUI.DYNAMIC_PRODUCT_NAME_AT_SHARE_WISHLIST_PAGE, productName);
    }

    public ShoppingCartPageObject clickToAddToCartButton() {
	waitToElementClickable(driver, MyWishlistPageUI.ADD_TO_CART_BUTTON);
	clickToElement(driver, MyWishlistPageUI.ADD_TO_CART_BUTTON);
	return UserPageGenaratorManager.getShoppingCartPage(driver);
    }




    
}
