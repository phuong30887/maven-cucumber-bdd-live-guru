package userPageUIs;

public class ShoppingCartPageUI {

    // ============ DISCOUNT ===========
    public static final String DISCOUNT_CODES_TEXTBOX = "//input[@id='coupon_code']";
    public static final String APPLY_DISCOUNT_CODES_LINK = "//button[@title='Apply']";
    //public static final String APPLY_DISCOUNT_CODES_SUCCESS_MESSAGE = "//div[@id='header-account']//ul/li/a[text()='%s']";
    
    // ============ PRODUCT ===========    
    public static final String QUANTITY_TEXTBOX = "//td[@class='product-cart-actions']//input[@type='text']";
    public static final String UPDATE_BUTTON = "//td[@class='product-cart-actions']//button[@type='submit']";
    public static final String DYNAMIC_MAXIMUN_QUANTITY_ALLOWED_ERROR_MESSAGE = "//h2[@class='product-name']/a[text()='%s']/parent::h2/following-sibling::p[@class='item-msg error']";
    
    // =================================
    
    public static final String EMPTY_CART_LINK = "//span[contains(text(),'Empty Cart')]";
    public static final String SHOPPING_CART_IS_EMPTY_MESSAGE = "//h1[contains(text(),'Shopping Cart is Empty')]";
    public static final String NO_ITEMS_MESSAGE = "//div[@class='cart-empty']//p[contains(text(),'You have no items in your shopping cart.')]";
    
    // ============ ESTIMATE SHIPPING AND TAX ===========
    public static final String COUNTRY_DROPDOWN_AT_ESTIMATE_SHIPPING = "//select[@id='country']";
    public static final String STATE_DROPDOWN_AT_ESTIMATE_SHIPPING = "//select[@id='region_id']";
    public static final String ZIP_TEXTBOX_AT_ESTIMATE_SHIPPING = "//input[@id='postcode']";
    public static final String ESTIMATE_LINK_AT_ESTIMATE_SHIPPING = "//span[contains(text(),'Estimate')]";
    public static final String FLAT_RATE_FIXED_PRICE_AT_ESTIMATE_SHIPPING = "//label[contains(text(),'Fixed')]/span[@class='price']";
    public static final String FLAT_RATE_FIXED_RADIO_BUTTON_AT_ESTIMATE_SHIPPING = "//label[contains(text(),'Fixed')]/span[@class='price']/parent::label/preceding-sibling::input";
    public static final String FLAT_RATE_UPDATE_TOTAL_BUTTON_AT_ESTIMATE_SHIPPING = "//button[@title='Update Total']";
    
    
    // ============ TOTALS TABLE ===========
    public static final String DISCOUNT_TITLE_AT_TOTALS_TABLE = "//table[@id='shopping-cart-totals-table']//td[contains(text(),'Discount (%s)')]";
    public static final String DISCOUNT_VALUE_AT_TOTALS_TABLE = "//table[@id='shopping-cart-totals-table']//td[contains(text(), 'Discount')]/parent::tr/td/span[@class='price']";
    public static final String SUB_TOTAL_VALUE_AT_TOTALS_TABLE = "//table[@id='shopping-cart-totals-table']//tr/td[contains(text(),'Subtotal')]/following-sibling::td/span[@class='price']";
    public static final String GRAND_TOTAL_VALUE_AT_TOTALS_TABLE = "//table[@id='shopping-cart-totals-table']//td/strong[text()='Grand Total']/../following-sibling::td//span[@class='price']";
    public static final String PROCEED_TO_CHECKOUT_AT_TOTALS_TABLE = "//div[@class='cart-totals-wrapper']//button[@title='Proceed to Checkout']";
}
