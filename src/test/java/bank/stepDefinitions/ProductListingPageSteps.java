package bank.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageUIs.ProductListingPageUI;

public class ProductListingPageSteps extends AbstractPage {

    WebDriver driver;
    static String productName, productPrice;
    String parentWindowID, childWindowID;

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
    
    @Then("^I see the message the product \"([^\"]*)\" has been added to comparison list$")
    public void i_see_the_message_the_product_has_been_added_to_comparison_list(String productName) {
	Assert.assertTrue(isElementDisplayed(driver, ProductListingPageUI.DYNAMIC_ADD_TO_COMPARISON_LIST_BY_PRODUCT_NAME, productName));
    }

    @When("^I click to Add To Compare link of product \"([^\"]*)\"$")
    public void i_click_to_Add_To_Compare_link_of_product(String productName) {
	waitToElementClickable(driver, ProductListingPageUI.DYNAMIC_ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);
	clickToElement(driver, ProductListingPageUI.DYNAMIC_ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME, productName);
    }

    @When("^I click to Compare button$")
    public void i_click_to_Compare_button() {
	this.parentWindowID = getCurrentWindowID(driver);
	waitToElementClickable(driver,  ProductListingPageUI.COMPARE_PRODUCTS_BUTTON);
	clickToElement(driver,  ProductListingPageUI.COMPARE_PRODUCTS_BUTTON);	
    }
    
    @Then("^I see the title of page is \"([^\"]*)\"$")
    public void i_see_the_title_of_page_is(String pageTitle) {
	this.childWindowID = getCurrentWindowID(driver);
	switchToWindowByID(driver, childWindowID);
	Assert.assertTrue(isElementDisplayed(driver, ProductListingPageUI.COMPARE_PRODUCTS_TITLE_AT_COMPARE_PRODUCTS_WINDOW));
    }
    
    @Then("^I see the product name \"([^\"]*)\" is displayed at compare products table$")
    public void i_see_the_product_name_is_displayed_at_compare_products_table(String productName) {
	Assert.assertTrue(isElementDisplayed(driver, ProductListingPageUI.COMPARE_PRODUCTS_TITLE_AT_COMPARE_PRODUCTS_WINDOW, productName));
    }

    @Then("^I close the Compare Products window$")
    public void i_close_the_Compare_Products_window() {
	waitToElementClickable(driver,  ProductListingPageUI.CLOSE_WINDOW_AT_COMPARE_PRODUCTS_WINDOW);
	clickToElementByJS(driver,  ProductListingPageUI.CLOSE_WINDOW_AT_COMPARE_PRODUCTS_WINDOW);
	switchToWindowByID(driver, parentWindowID);
    }
    
}
