package commons;

public class AbstractPageUI {

    // ============= HEADER MENU USER ====================
    public static final String ACCOUNT_HEADER_MENU = "//div[@class='page-header-container']//a/span[text()='Account']";
    public static final String DYNAMIC_ACCOUNT_SUB_ITEMS_HEADER_MENU = "//div[@id='header-account']//ul/li/a[text()='%s']";

    public static final String MAGENTO_LOGO = "//a[@class='logo']";
    public static final String MOBILE_LINK_AT_HEADER_MENU = "//a[contains(text(),'Mobile')]";
    public static final String TV_LINK_AT_HEADER_MENU = "//a[contains(text(),'TV')]";

    // ============= USER BOTTOM MENU ====================
    public static final String DYNAMIC_PAGE_NAME_AT_BOTTOM_PAGE = "//div[@class='footer']//ul/li/a[text()='%s']";

    // ============= USER ACCOUNT PAGE ====================
    public static final String DYNAMIC_PAGENAME_OF_LEFT_MENU_AT_MY_ACCOUNT_PAGE = "//div[@class='main']//div[@class='block-content']/ul/li/a[string()='%s']";
    public static final String PAGE_TITLE_AT_ACCOUNT_PAGE = "//div[@class='page-title']";

    // ================================================
    public static final String SUCCESS_MESSAGE_TEXT = "//li[@class='success-msg']/ul/li/span";
    public static final String ERROR_MESSAGE_TEXT = "//li[@class='error-msg']/ul/li/span";
    public static final String AJAX_LOADING_SPIN_ICON = "//span[@id='shipping-please-wait']";
    public static final String ADMIN_LOADING_SPIN_ICON = "//p[@id='loading_mask_loader']";

    // ============= HEADER MENU ADMIN ====================
    public static final String ADMIN_DYNAMIC_HEADER_MENU_ITEM = "//div[@class='nav-bar']/ul/li/a/span[text()='%s']";
    public static final String ADMIN_DYNAMIC_SUB_MENU_ITEM_AT_HEADER_MENU = "//ul[@id='nav']//li/a/span[text()='%s']";

    // ============= ADMIN COMMON ====================
    public static final String LOG_OUT_LINK = "//a[contains(text(),'Log Out')]";

}
