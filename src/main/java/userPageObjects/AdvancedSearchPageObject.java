package userPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import userPageUIs.AdvancedSearchPageUI;

public class AdvancedSearchPageObject extends AbstractPage{

    WebDriver driver;

    public AdvancedSearchPageObject(WebDriver driver) {
	this.driver = driver;
    }

    public void inputToPriceFromTextbox(String priceFrom) {
	waitToElementVisible(driver, AdvancedSearchPageUI.PRICE_FROM_TEXTBOX);
	sendkeyToElement(driver, AdvancedSearchPageUI.PRICE_FROM_TEXTBOX, priceFrom);
    }

    public void inputToPriceToTextbox(String priceTo) {
	waitToElementVisible(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX);
	sendkeyToElement(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX, priceTo);
    }

    public void clickToSearchButton() {
	waitToElementClickable(driver, AdvancedSearchPageUI.SEARCH_BUTTON);
	clickToElement(driver, AdvancedSearchPageUI.SEARCH_BUTTON);
    }

    public boolean areProductsHavePriceInRange(int priceFrom, int priceTo) {
	waitToAllElementVisible(driver, AdvancedSearchPageUI.PRODUCT_PRICE_ARRAY_AT_SEARCH_RESULT_PAGE);
	List<WebElement> allPriceItems = getElements(driver, AdvancedSearchPageUI.PRODUCT_PRICE_ARRAY_AT_SEARCH_RESULT_PAGE);
	
	for (WebElement item:allPriceItems) {
	    String currentPrice = item.getText().replace("$", "").replace(".00", "");
	    int currentPriceInt = Integer.parseInt(currentPrice);
	    if (currentPriceInt < priceFrom || currentPriceInt > priceTo) {
		return false;
	    }
	}
	
	return true;	
    }




    
}
