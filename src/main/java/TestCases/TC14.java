package TestCases;

import Constant.Constant;
import PageObject.Railway.BookTicketPage;
import PageObject.Railway.HomePage;
import PageObject.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    @Test
    public void TC14(){
        System.out.println("TC14 - User can book many tickets at a time");
        HomePage homePage = new HomePage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).gotoBookTicketPage();
        bookTicketPage.bookingTicket(Constant.DEPART_DATE,Constant.DEPART_FROM, Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT);

        String actualMsg = bookTicketPage.getSuccessMessage();
        String expectedMsg = "Ticket booked successfully!";
        String actualDepartDate = bookTicketPage.getTicketDepartDate();
        String expectedDepartDate = Constant.DEPART_DATE;
        String actualDepartStation = bookTicketPage.getTicketDepartStation();
        String expectedDepartStation = Constant.DEPART_FROM;
        String actualArriveStation = bookTicketPage.getTicketArriveStation();
        String expectedArriveStation = Constant.ARRIVE_AT;
        String actualSeatType = bookTicketPage.getTicketSeatType();
        String expectedSeatType = Constant.SEAT_TYPE;
        String actualTicketAmount = bookTicketPage.getTicketAmount();
        String expectedTicketAmount = Constant.TICKET_AMOUNT;

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart date is not displayed as expected.");
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected.");
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected.");
        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat type is not displayed as expected.");
        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket amount is not displayed as expected.");
    }
}
