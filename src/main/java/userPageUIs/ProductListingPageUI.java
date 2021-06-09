package userPageUIs;

public class ProductListingPageUI {

    public static final String DYNAMIC_PRODUCT_NAME_LINK = "//h2[@class='product-name']/a[text()='%s']";
    public static final String DYNAMIC_PRODUCT_PRICE_TEXT = "//h2[@class='product-name']/a[text()='%s']/../following-sibling::div//span[@class='price']";
    public static final String DYNAMIC_ADD_TO_COMPARE_LINK_BY_PRODUCT_NAME = "//h2[@class='product-name']/a[text()='%s']/parent::h2/following-sibling::div/ul/li/a[text()='Add to Compare']";
    public static final String DYNAMIC_ADD_TO_WISHLIST_LINK_BY_PRODUCT_NAME = "//h2[@class='product-name']/a[text()='%s']/parent::h2/following-sibling::div/ul/li/a[text()='Add to Wishlist']";
    public static final String DYNAMIC_ADD_TO_COMPARISON_LIST_BY_PRODUCT_NAME = "//li[@class='success-msg']/ul/li/span[text()='The product %s has been added to comparison list.']";
    
    public static final String COMPARE_PRODUCTS_BUTTON = "//div[contains(@class, 'block-compare')]//button//span[text()='Compare']";
    public static final String COMPARE_PRODUCTS_TITLE_AT_COMPARE_PRODUCTS_WINDOW = "//div[contains(@class,'page-title')]/h1[text()='Compare Products']";
    public static final String DYNAMIC_PRODUCT_NAME_AT_COMPARE_PRODUCTS_WINDOW = "//table[@id='product_comparison']//tr/td/h2[@class='product-name']/a[text()='%s']";
    public static final String CLOSE_WINDOW_AT_COMPARE_PRODUCTS_WINDOW = "//button[@title='Close Window']";
}
