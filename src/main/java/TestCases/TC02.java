package TestCases;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    @Test(description = "TC02 - User can't login with blank 'Username' textbox")
    public void TC02() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println(" Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println(" User doesn't type any words into 'Username' textbox but enter valid information into 'Passwprd' textbox");
        System.out.println(" Click on 'Login' button");
        loginPage.login("",Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();

        Assert.assertEquals(actualMsg,"There was a problem with your login and/or errors exist in your form.");
    }
}
