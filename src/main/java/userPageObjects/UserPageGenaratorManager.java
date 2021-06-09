package userPageObjects;

import org.openqa.selenium.WebDriver;

public class UserPageGenaratorManager {
    
    public static UserHomepageObject getUserHomepage(WebDriver driver) {
	return new UserHomepageObject(driver);
    }
    
    public static RegisterPageObject getRegisterPage(WebDriver driver) {
	return new RegisterPageObject(driver);
    }
    
    public static AccountDashboardPageObject getAccountDashboardPage(WebDriver driver) {
	return new AccountDashboardPageObject(driver);
    }
    
    public static AccountInformationPageObject getAccountInformationPage(WebDriver driver) {
	return new AccountInformationPageObject(driver);
    }
    
    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
	return new UserLoginPageObject(driver);
    }
    
    public static ProductListingPageObject getProductListingPage(WebDriver driver) {
	return new ProductListingPageObject(driver);
    }
    
    public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
	return new ProductDetailPageObject(driver);
    }
    
    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
	return new ShoppingCartPageObject(driver);
    }
    
    public static MyWishlistPageObject getMyWishlistPage(WebDriver driver) {
	return new MyWishlistPageObject(driver);
    }
    
    public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
	return new CheckoutPageObject(driver);
    }

    public static AdvancedSearchPageObject getAdvancedSearchPage(WebDriver driver) {
	return new AdvancedSearchPageObject(driver);
    }
}
