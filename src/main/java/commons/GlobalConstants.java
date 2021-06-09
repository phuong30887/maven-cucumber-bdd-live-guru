package commons;

public class GlobalConstants {
    public static final String LIVE_DEMO_USERS_PAGE_URL = "http://live.demoguru99.com/";
    public static final String LIVE_DEMO_ADMIN_PAGE_URL = "http://live.demoguru99.com/index.php/backendlogin";
    
    public static final String BACKEND_USERNAME = "user01";
    public static final String BACKEND_PASSWORD = "guru99com";
    
    public static final String PROJECT_LOCATION = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    
    
    public static final long LONG_TIMEOUT = 30;
    public static final long SHORT_TIMEOUT = 15;    
    
    public static final String currentDate = java.time.LocalDate.now().toString();
    public static final String DOWNLOAD_FOLDER_LOCATION = PROJECT_LOCATION + "\\src\\test\\resources\\downloadFiles\\" + currentDate + "\\";
    
    
}
