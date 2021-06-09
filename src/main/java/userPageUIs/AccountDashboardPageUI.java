package userPageUIs;

public class AccountDashboardPageUI {
    
    public static final String HELLO_TEXT = "//div[@class='welcome-msg']/p/strong[text()='Hello, %s!']";
    public static final String DYNAMIC_ORDER_INFORMATION = "//table[@id='my-orders-table']//tr/td[@class='number' and text()='%s']/following-sibling::td[@class='ship' and text()=\"%s\"]/following-sibling::td[@class='total']/span[@class='price' and text()='%s']/parent::td/following-sibling::td[@class='status' and string()='%s']";
}
