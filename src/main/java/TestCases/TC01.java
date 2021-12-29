package TestCases;
import Constant.Constant;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {
    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        System.out.println(" Navigate to QA Railway Website");
        homePage.open();

        System.out.println(" Click on 'Login' tab");
        homePage.gotoLoginPage();

        System.out.println(" Enter valid Email and Password");
        System.out.println(" Click on 'Login' button");
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg,expectedMsg,"Welcome message is not displayed as expected");
    }
}
