package bank.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import userPageUIs.ShoppingCartPageUI;

public class CheckoutPageSteps extends AbstractPage {

    WebDriver driver;

    public CheckoutPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
    }

    @When("^Input \"([^\"]*)\" to Discount codes textbox$")
    public void input_to_Discount_codes_textbox(String discountCode) {
	waitToElementVisible(driver, ShoppingCartPageUI.DISCOUNT_CODES_TEXTBOX);
	sendkeyToElement(driver, ShoppingCartPageUI.DISCOUNT_CODES_TEXTBOX, discountCode);
    }

    @When("^Click to Apply button$")
    public void click_to_Apply_button() {
	waitToElementClickable(driver, ShoppingCartPageUI.APPLY_DISCOUNT_CODES_LINK);
	clickToElement(driver, ShoppingCartPageUI.APPLY_DISCOUNT_CODES_LINK);
    }

    @Then("^I see the success message Coupon code \"([^\"]*)\" was applied\\. displayed$")
    public void i_see_the_success_message_Coupon_code_was_applied_displayed(String discountCode) {
	Assert.assertEquals(getSuccessMessage(driver), "Coupon code \"" + discountCode + "\" was applied.");

    }

    @Then("^I see the discount value is \"([^\"]*)\"$")
    public void i_see_the_discount_value_is(String discountValue) {
	waitToElementVisible(driver, ShoppingCartPageUI.DISCOUNT_VALUE_AT_TOTALS_TABLE);
	Assert.assertEquals(getElementText(driver, ShoppingCartPageUI.DISCOUNT_VALUE_AT_TOTALS_TABLE), discountValue);
    }

    @Then("^I see the grand total value is discounted \"([^\"]*)\"$")
    public void i_see_the_grand_total_value_is_discounted(String discountValue) {
	String subTotalValue = getSubTotalValue();
	String grandTotalValue = getSubTotalValue();
	Assert.assertEquals(grandTotalValue, calculateValueOfGrandTotal(subTotalValue, discountValue));
    }    

    public String getSubTotalValue() {
	waitToElementVisible(driver, ShoppingCartPageUI.SUB_TOTAL_VALUE_AT_TOTALS_TABLE);
	return getElementText(driver, ShoppingCartPageUI.SUB_TOTAL_VALUE_AT_TOTALS_TABLE);
    }
    
    public String getGrandTotalValue() {
	waitToElementVisible(driver, ShoppingCartPageUI.GRAND_TOTAL_VALUE_AT_TOTALS_TABLE);	
	return getElementText(driver, ShoppingCartPageUI.GRAND_TOTAL_VALUE_AT_TOTALS_TABLE);
    }

    public String calculateValueOfGrandTotal(String subtotal, String changeValue) {
	String totalValue = "";
	float totalValueFloat = Float.parseFloat(subtotal.replace("$", "")) + Float.parseFloat(changeValue.replace("$", ""));	
	
	totalValue = "$" + Float.toString(totalValueFloat);
	totalValue = totalValue.replace(".0", ".00");
	System.out.println("============== totalValue: " + totalValue);
	return totalValue;
    }

}
