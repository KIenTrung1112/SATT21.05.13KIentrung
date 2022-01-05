package Common;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway.somee.com/Account/Login.cshtml";
    public static final String USERNAME = "trannguyen_kientrung@yahoo.com";
    public static final String PASSWORD = "trunganchao1998";
    public static final String INVALID_PASSWORD = PASSWORD+"zzz";
    public static final String INVALID_EMAIL = "12345@amail.com";

    public static final String REGISTER_PASSWORD = "123456789";
    public static final String REGISTER_CONFIRM_PASSWORD = "123456789";
    public static final String REGISTER_PID = "123456789";

    public static final String NO_BOOKED_TICKET_USERNAME_1 = "bookernumber1@email.com";
    public static final String NO_BOOKED_TICKET_PASSWORD_1 = "123456789";

    public static final String NO_BOOKED_TICKET_USERNAME_2 = "bookernumber2@email.com";
    public static final String NO_BOOKED_TICKET_PASSWORD_2 = "123456789";

    public static final String NO_BOOKED_TICKET_USERNAME_3 = "bookernumber3@email.com";
    public static final String NO_BOOKED_TICKET_PASSWORD_3 = "123456789";

    public static final String NO_BOOKED_TICKET_USERNAME_4 = "trannguyen_kientrung@yahoo.com";
    public static final String NO_BOOKED_TICKET_PASSWORD_4 = "trunganchao1998";

    public static final int WAITING_TIME = 1000;
}
