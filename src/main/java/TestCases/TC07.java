package TestCases;

import Common.Constant;
import Common.Utilities;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        System.out.println("Navigate to QA Railway Website");
        homePage.open();

        System.out.println(" Click on 'Register' tab");
        homePage.gotoRegisterPage();

        System.out.println("Enter valid information into all fields");
        System.out.println(" Click on 'Register' button");
        registerPage.register(Utilities.REGISTER_RANDOM_EMAIL(),Constant.REGISTER_PASSWORD,Constant.REGISTER_CONFIRM_PASSWORD,Constant.REGISTER_PID);
        String actualMessage = registerPage.getRegisterSuccessMessage();
        String expectedMessage = "Thank you for registering your account";

        Assert.assertEquals(actualMessage,expectedMessage,"Successful register message is not displayed as expected");
    }
}
