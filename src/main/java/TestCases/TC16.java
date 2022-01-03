import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import PageObject.Railway.MyTicketPage;
import TestCases.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;

public class TC16 extends TestBase {
    @Test(description = "User can cancel a ticket")
    public void TC16() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("3. Book a ticket");
        homePage.gotoBookTicketPage();
        bookTicketPage.bookingTicket(Constant.DEPART_DATE,Constant.DEPART_FROM, Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);

        System.out.println("4. Click on 'My ticket' tab");
        bookTicketPage.gotoMyTicket();

        System.out.println("5. Click on 'Cancel' button of ticket which user want to cancel.");
        myTicketPage.cancelTicket();

        System.out.println("6. Click on 'OK' button on Confirmation message 'Are you sure?'");
        myTicketPage.acceptAlert();

        Assert.assertFalse(myTicketPage.isCancelButtonDisplayed());
    }
}