package TestCases;

import Constant.Constant;
import PageObject.Railway.ChangePasswordPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase {
    @Test(description = "TC09 - User can't change password when 'New Password' and 'Confirm Password' are different.")
    public void TC09() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ChangePasswordPage changePasswordPage = new ChangePasswordPage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println(" Navigate to QA Railway Website");
        homePage.open();



        System.out.println("Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println(" Click on 'Change Password' tab");
        homePage.gotoChangePassword();

        System.out.println(" Enter valid information into 'Current Password' textbox but " +
                "enter 'a123:\"/{}!@$' into 'New Password' textbox " +
                "and 'b456:\"/{}!@$' into 'Confirm Password' textbox.");
        changePasswordPage.changePassword("trungkg@1998","a123:\"/{}!@$","b456:\"/{}!@$");

        String actualMessage = changePasswordPage.getChangePasswordErrorMessage();
        String expectedMessage = "Password change failed. Please correct the errors and try again.";

        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected");
    }
}
