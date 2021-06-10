package bank.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageUIs.ProductDetailPageUI;

public class ProductDetailPageSteps  extends AbstractPage {

    WebDriver driver;

    public ProductDetailPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
    }

    
    @Then("^I see the cost at product detail page equals to cost at product listing page$")
    public void i_see_the_cost_at_product_detail_page_equals_with_cost_at_product_listing_page() {
	waitToElementVisible(driver, ProductDetailPageUI.PRODUCT_PRICE_TEXT);
	String actualPrice = getElementText(driver, ProductDetailPageUI.PRODUCT_PRICE_TEXT);
	Assert.assertEquals(actualPrice, ProductListingPageSteps.productPrice);
    }
    
    @When("^I click to Add to card button$")
    public void i_click_to_Add_to_card_button() {
	waitToElementClickable(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
	clickToElement(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
    }
}
