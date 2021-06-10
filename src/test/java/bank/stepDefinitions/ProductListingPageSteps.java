package bank.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageUIs.ProductListingPageUI;

public class ProductListingPageSteps extends AbstractPage {

    WebDriver driver;
    static String productName, productPrice;

    public ProductListingPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
    }
    
    @When("^I get cost of \"([^\"]*)\" at product listing page$")
    public void i_get_cost_of_at_product_listing_page(String productName) { 
	this.productName = productName;
	waitToElementVisible(driver,  ProductListingPageUI.DYNAMIC_PRODUCT_PRICE_TEXT, productName);
	this.productPrice = getElementText(driver,  ProductListingPageUI.DYNAMIC_PRODUCT_PRICE_TEXT, productName);
    }

    @When("^I click to product link \"([^\"]*)\"$")
    public void i_click_to_product_link(String productName) {
	waitToElementClickable(driver,  ProductListingPageUI.DYNAMIC_PRODUCT_NAME_LINK, productName);
	clickToElement(driver,  ProductListingPageUI.DYNAMIC_PRODUCT_NAME_LINK, productName);	
    }
    
}
