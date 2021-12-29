package TestCases;

import Constant.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase {
    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.REGISTER_RANDOM_EMAIL(),"","","");

        String actualErrorMessage = registerPage.getRegisterErrorMessage();
        String actualPasswordValidationErrorMessage = registerPage.getPasswordValidationErrorMessage();
        String actualPIDValidationErrorMessage = registerPage.getPIDValidationErrorMessage();

        Assert.assertEquals(actualErrorMessage,"There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(actualPasswordValidationErrorMessage,"Invalid password length.");
        Assert.assertEquals(actualPIDValidationErrorMessage,"Invalid ID length.");
    }
}