package bank.stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageUIs.AdvancedSearchPageUI;

public class AdvancedSearchPageSteps extends AbstractPage {
    
    WebDriver driver; 
    
    public AdvancedSearchPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
    }

    @When("^I input \"([^\"]*)\" to Price From textbox$")
    public void i_input_to_Price_From_textbox(String priceFrom) {
	waitToElementVisible(driver, AdvancedSearchPageUI.PRICE_FROM_TEXTBOX);
	sendkeyToElement(driver, AdvancedSearchPageUI.PRICE_FROM_TEXTBOX, priceFrom);
        
    }

    @When("^I input \"([^\"]*)\" to Price To textbox$")
    public void i_input_to_Price_To_textbox(String priceTo) {
	waitToElementVisible(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX);
	sendkeyToElement(driver, AdvancedSearchPageUI.PRICE_TO_TEXTBOX, priceTo);
        
    }

    @When("^Click to Search button$")
    public void click_to_Search_button() {
	waitToElementClickable(driver, AdvancedSearchPageUI.SEARCH_BUTTON);
	clickToElement(driver, AdvancedSearchPageUI.SEARCH_BUTTON);
        
    }

    @Then("^I see products have price in range \"([^\"]*)\" to \"([^\"]*)\"$")
    public void i_see_products_have_price_in_range_to(String priceFrom, String priceTo) {
        
	boolean areProductInCurrentRange = true;
	waitToAllElementVisible(driver, AdvancedSearchPageUI.PRODUCT_PRICE_ARRAY_AT_SEARCH_RESULT_PAGE);
	List<WebElement> allPriceItems = getElements(driver, AdvancedSearchPageUI.PRODUCT_PRICE_ARRAY_AT_SEARCH_RESULT_PAGE);
	
	for (WebElement item:allPriceItems) {
	    String currentPrice = item.getText().replace("$", "").replace(".00", "");
	    int currentPriceInt = Integer.parseInt(currentPrice);
	    if (currentPriceInt < Integer.parseInt(priceFrom) || currentPriceInt > Integer.parseInt(priceTo)) {
		areProductInCurrentRange = false;
	    }
	}
	
	Assert.assertTrue(areProductInCurrentRange);
    }
}
