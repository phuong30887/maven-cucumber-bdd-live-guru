package userPageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import userPageUIs.ProductListingPageUI;

public class ProductListingPageObject extends AbstractPage{

    WebDriver driver;

    public ProductListingPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public ProductDetailPageObject clickToLinkOfAProduct(String productName) {
	waitToElementClickable(driver,  ProductListingPageUI.DYNAMIC_PRODUCT_NAME_LINK, productName);
	clickToElement(driver,  ProductListingPageUI.DYNAMIC_PRODUCT_NAME_LINK, productName);
	return UserPageGenaratorManager.getProductDetailPage(driver);
    }

    public String getPriceOfAProduct(String productName) {
	waitToElementVisible(driver,  ProductListingPageUI.DYNAMIC_PRODUCT_PRICE_TEXT, productName);
	return getElementText(driver,  ProductListingPageUI.DYNAMIC_PRODUCT_PRICE_TEXT, productName);
    }

    public void clickToAddToCompareLinkOfAProduct(String productName) {
	waitToElementClickable(driver, ProductListingPageUI.DYNAMIC_ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);
	clickToElement(driver, ProductListingPageUI.DYNAMIC_ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);	
    }

    public boolean isAddedToComparisonListForAProductNameMessageDisplayed(String productName) {	
	return isElementDisplayed(driver, ProductListingPageUI.DYNAMIC_ADD_TO_COMPARISON_LIST_BY_PRODUCT_NAME, productName);
    }      

    public void clickToCompareProductButton() {
	waitToElementClickable(driver,  ProductListingPageUI.COMPARE_PRODUCTS_BUTTON);
	clickToElement(driver,  ProductListingPageUI.COMPARE_PRODUCTS_BUTTON);	
	
    }

    public void switchToCompareProductsWindow(String childWindowID) {
	switchToWindowByID(driver, childWindowID);	
    }

    public boolean isCompareProductsTitleDisplayed() {
	// TODO Auto-generated method stub
	return isElementDisplayed(driver, ProductListingPageUI.COMPARE_PRODUCTS_TITLE_AT_COMPARE_PRODUCTS_WINDOW);
    }

    public boolean isProductNameDisplayedAtCompareProductsTable(String productName) {
	// TODO Auto-generated method stub
	return isElementDisplayed(driver, ProductListingPageUI.COMPARE_PRODUCTS_TITLE_AT_COMPARE_PRODUCTS_WINDOW, productName);
    }

    public void clickToCloseWindow() {
	waitToElementClickable(driver,  ProductListingPageUI.CLOSE_WINDOW_AT_COMPARE_PRODUCTS_WINDOW);
	clickToElementByJS(driver,  ProductListingPageUI.CLOSE_WINDOW_AT_COMPARE_PRODUCTS_WINDOW);	
	
    }

    public void switchToProductListingWindow(String parentWindowID) {
	switchToWindowByID(driver, parentWindowID);
	
    }

    public MyWishlistPageObject clickToAddToWishlistLinkOfAProduct(String productName) {
	waitToElementClickable(driver, ProductListingPageUI.DYNAMIC_ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME, productName);
	clickToElement(driver, ProductListingPageUI.DYNAMIC_ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME, productName);	
	return UserPageGenaratorManager.getMyWishlistPage(driver);	
    }



    
    
}
