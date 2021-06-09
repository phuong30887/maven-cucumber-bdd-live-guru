package userPageUIs;

public class CheckoutPageUI {
    
    // ============== BILLING INFORMATION ============
    public static final String FIRST_NAME_TEXTBOX_AT_BILLING_INFORMATION = "//input[@id='billing:firstname']";
    public static final String LAST_NAME_TEXTBOX_AT_BILLING_INFORMATION = "//input[@id='billing:lastname']";
    public static final String ADDRESS_TEXTBOX_AT_BILLING_INFORMATION = "//input[@id='billing:street1']";
    public static final String CITY_TEXTBOX_AT_BILLING_INFORMATION = "//input[@id='billing:city']";
    public static final String STATE_DROPDOWN_AT_BILLING_INFORMATION = "//select[@id='billing:region_id']";
    public static final String ZIP_TEXTBOX_AT_BILLING_INFORMATION = "//input[@id='billing:postcode']";
    public static final String COUNTRY_DROPDOWN_AT_BILLING_INFORMATION = "//select[@id='billing:country_id']";
    public static final String TELEPPHONE_TEXTBOX_AT_BILLING_INFORMATION = "//input[@id='billing:telephone']";
    public static final String SHIP_TO_THIS_ADDRESS_RADIO_BUTTON_AT_BILLING_INFORMATION = "//label[contains(text(),'Ship to this address')]/preceding-sibling::input";
    public static final String SHIP_TO_DIFFERENT_ADDRESS_RADIO_BUTTON_AT_BILLING_INFORMATION = "//label[contains(text(),'Ship to different address')]/preceding-sibling::input";
    public static final String CONTINUE_BUTTON_AT_BILLING_INFORMATION = "//div[@id='billing-buttons-container']/button[@title='Continue']";   
    
    
    // ============== SHIPPING INFORMATION ============
    public static final String FIRST_NAME_TEXTBOX_AT_SHIPPING_INFORMATION = "//input[@id='shipping:firstname']";
    public static final String LAST_NAME_TEXTBOX_AT_SHIPPING_INFORMATION = "//input[@id='shipping:lastname']";
    public static final String ADDRESS_TEXTBOX_AT_SHIPPING_INFORMATION = "//input[@id='shipping:street1']";
    public static final String CITY_TEXTBOX_AT_SHIPPING_INFORMATION = "//input[@id='shipping:city']";
    public static final String STATE_DROPDOWN_AT_SHIPPING_INFORMATION = "//select[@id='shipping:region_id']";
    public static final String ZIP_TEXTBOX_AT_SHIPPING_INFORMATION = "//input[@id='shipping:postcode']";
    public static final String COUNTRY_DROPDOWN_AT_SHIPPING_INFORMATION = "//select[@id='shipping:country_id']";
    public static final String TELEPPHONE_TEXTBOX_AT_SHIPPING_INFORMATION = "//input[@id='shipping:telephone']";
    public static final String CONTINUE_BUTTON_AT_SHIPPING_INFORMATION = "//div[@id='shipping-buttons-container']/button[@title='Continue']";
    
    
 // ============== SHIPPING METHOD ============
    public static final String CONTINUE_BUTTON_AT_SHIPPING_METHOD = "//div[@id='shipping-method-buttons-container']/button[@type='button']";
    
    
    // ============== PAYMENT INFORMATION ============
    
    public static final String CHECK_MONEY_ORDER_RADIO_BUTTON ="//label[contains(text(),'Check / Money order')]/preceding-sibling::input";
    public static final String CONTINUE_BUTTON_AT_PAYMENT_INFORMATION = "//div[@id='payment-buttons-container']/button";
    
    // ============== ORDER REVIEW ============
    public static final String PLACE_ORDER_BUTTON = "//div[@id='review-buttons-container']/button";
    
    
    public static final String ORDER_SUCCESS_MESSAGE = "//div[@class='page-title']/h1";
    public static final String ORDER_ID_TEXT = "//div[@class='col-main']/p[text()='Your order # is: ']/a";
}
