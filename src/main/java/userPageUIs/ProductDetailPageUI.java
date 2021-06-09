package userPageUIs;

public class ProductDetailPageUI {

    public static final String PRODUCT_PRICE_TEXT = "//span[@class='price']";
    public static final String ADD_TO_CART_BUTTON = "//button[@title='Add to Cart']";
    
    // ============== REVIEW ===================
    public static final String ADD_YOUR_REVIEW_LINK = "//a[contains(text(),'Add Your Review')]";
    public static final String SUBMIT_REVIEW_BUTTON_AT_REVIEW_PAGE = "//button[@title='Submit Review']";
    public static final String DYNAMIC_REQUIRED_FIELD_AT_REVIEW_PAGE = "//ul[@class='form-list']/li/label[contains(string(),\"%s\")]/following-sibling::div/div[text()='This is a required field.']";
    public static final String RATE_THIS_PRODUCT_REQUIRED_MESSAGE_AT_REVIEW_PAGE = "//h4[text()='How do you rate this product? ']/following-sibling::div[@id='advice-validate-rating-validate_rating']";
    public static final String RATE_5_RADIO_BUTTON_AT_REVIEW_PAGE = "//input[@id='Quality 1_5']";
    public static final String YOUR_THOUGHTS_TEXTAREA_AT_REVIEW_PAGE = "//textarea[@id='review_field']";
    public static final String YOUR_REVIEW_TEXTBOX_AT_REVIEW_PAGE = "//input[@id='summary_field']";
    public static final String YOUR_NICKNAME_TEXTBOX_AT_REVIEW_PAGE = "//input[@id='nickname_field']";
    public static final String REVIEWS_TAB_AT_REVIEW_PAGE = "//li[@class='last']//span[contains(text(),'Reviews')]";
    
    
    public static final String YOUR_REVIEW_AT_REVIEWS_TAB_AT_PRODUCT_DETAIL_PAGE = "//div[@id='customer-reviews']/dl/dt/a[contains(text(), '%s')]/parent::dt/following-sibling::dd[contains(text(),'%s')]/span[contains(text(),'%s')]";
    
}
