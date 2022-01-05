package Common;

import Common.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Utilities {
    public static String getProjectPath() {
        return "C:\\Users\\trung\\ideaProjects\\SATT21.05.13KienTrung";
    }
    public static void scrollPage(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public static final String REGISTER_RANDOM_EMAIL ()
    {
        int n = 10;
        return java.time.LocalTime.now()+getAlphaNumericString(n)+"@email.com";
    }
    static String getAlphaNumericString(int n)
    {
        int lowerLimit = 97;
        int upperLimit = 122;
        Random random = new Random();
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit
                    + (int)(random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char)nextRandomChar);
        }
        return r.toString();
    }
}
