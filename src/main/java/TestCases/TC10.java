package TestCases;

import Common.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase {
    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println(" Navigate to QA Railway Website");
        homePage.open();

        System.out.println(" Click on 'Register' tab");
        homePage.gotoRegisterPage();

        System.out.println(" Enter information of the created account in Pre-condition");
        System.out.println(" Click on 'Register' button");
        registerPage.register(Constant.USERNAME,Constant.REGISTER_PASSWORD,Constant.REGISTER_CONFIRM_PASSWORD,Constant.REGISTER_PID);

        String actualMessage = registerPage.getRegisterErrorMessage();
        String expectedMessage = "This email address is already in use.";

        Assert.assertEquals(actualMessage,expectedMessage,"Error message is not displayed as expected");
    }
}
