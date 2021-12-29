package TestCases;

import PageObject.Railway.ContactPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC06 extends TestBase {
    @Test(description = "TC06 - User is redirected to Home page after logging out")
    public void TC06() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ContactPage contactPage =  new ContactPage();

        System.out.println(" Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Login with valid Email and Password");
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println(" Click on 'Contact' tab");
        homePage.gotoContactPage();

        System.out.println(" Click on 'Log out' tab");
        contactPage.clickTabLogout();

        String checkTabLogout = String.valueOf(homePage.checkTabLogout());
        Assert.assertEquals(checkTabLogout,"false");
    }
}