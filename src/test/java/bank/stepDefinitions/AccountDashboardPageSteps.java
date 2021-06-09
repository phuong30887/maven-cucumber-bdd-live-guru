package bank.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import userPageObjects.AccountDashboardPageObject;
import userPageObjects.UserPageGenaratorManager;

public class AccountDashboardPageSteps {
    WebDriver driver;
    AccountDashboardPageObject accountDashboardPage;

    public AccountDashboardPageSteps() {
	this.driver = Hooks.openAndQuitBrowser();
	accountDashboardPage = UserPageGenaratorManager.getAccountDashboardPage(driver);
    }

    @Then("^Verify display message \"([^\"]*)\"$")
    public void verify_display_message_Thank_you_for_registering_with_Main_Website_Store(String message) {
	Assert.assertEquals(accountDashboardPage.getSuccessMessage(driver), message);
    }

}
