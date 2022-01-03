package PageObject.Railway;

import Constant.Constant;
import PageObject.Railway.GeneralPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage extends GeneralPage {

    // Locators
    private final By frmBookTicketForm = By.xpath("//fieldset");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By ddlDepartStation = By.xpath("//select[@name='DepartStation']");
    private final By ddlArriveStation = By.xpath("//select[@name='ArriveStation']");
    private final By ddlSeatType = By.xpath("//select[@name='SeatType']");
    private final By ddlTicketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By ddlDepartDate = By.xpath("//select[@name='Date']");
    private final By tdSeatType = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Seat Type']/preceding-sibling::th)+1]");
    private final By tdDepartStation = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By tdDepartDate = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Depart Date']/preceding-sibling::th)+1]");
    private final By tdTicketAmount = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Amount']/preceding-sibling::th)+1]");
    private final By tdArriveStation = By.xpath("//div[@class='DivTable']//tr[@class='OddRow']//td[count(//div[@class='DivTable']//tr[@class='TableSmallHeader']//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private final By lblBookTicketErrorMsg = By.xpath("//p[@class='message error']");
    private final By lblBookTicketValidationErrorMsg = By.xpath("//label[@class='validation-error']");

    // Elements
    public Select getDdlDepartDate(){ return new Select(Constant.WEBDRIVER.findElement(ddlDepartDate)); }
    public WebElement getFrmBookTicketForm()
    {
        return Constant.WEBDRIVER.findElement(frmBookTicketForm);
    }
    public WebElement getBtnBookTicket(){ return Constant.WEBDRIVER.findElement(btnBookTicket); }
    public Select getDdlArriveStation(){ return new Select(Constant.WEBDRIVER.findElement(ddlArriveStation)); }
    public Select getDdlDepartStation(){ return new Select(Constant.WEBDRIVER.findElement(ddlDepartStation));}
    public Select getDdlTicketAmount(){ return new Select(Constant.WEBDRIVER.findElement(ddlTicketAmount)); }
    public Select getDdlSeatType(){ return new Select(Constant.WEBDRIVER.findElement(ddlSeatType)); }
    public WebElement getTdSeatType(){ return Constant.WEBDRIVER.findElement(tdSeatType); }
    public WebElement getTdDepartStation(){ return Constant.WEBDRIVER.findElement(tdDepartStation); }
    public WebElement getTdDepartDate(){ return Constant.WEBDRIVER.findElement(tdDepartDate); }
    public WebElement getTdTicketAmount(){ return Constant.WEBDRIVER.findElement(tdTicketAmount); }
    public WebElement getLblBookSuccess(){ return Constant.WEBDRIVER.findElement(btnBookTicket); }
    public WebElement getTdArriveStation(){ return Constant.WEBDRIVER.findElement(tdArriveStation); }
    public WebElement getLabelBookTicketErrorMessage() { return Constant.WEBDRIVER.findElement(lblBookTicketErrorMsg);}
    public WebElement getLabelBookTicketValidationErrorMessage() { return Constant.WEBDRIVER.findElement(lblBookTicketValidationErrorMsg);}
    // Methods
    public boolean checkBookTicketForm()
    {
        return getFrmBookTicketForm().isDisplayed();
    }

    public void bookingTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount){
        try {
            Select dllDepartD = this.getDdlDepartDate();
            ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", dllDepartD);
            dllDepartD.selectByVisibleText(departDate);Thread.sleep(2000);

            Select dllDepartS = this.getDdlDepartStation();
            ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", dllDepartS);
            dllDepartS.selectByVisibleText(departStation);Thread.sleep(2000);

            Select dllArriveS = this.getDdlArriveStation();
            ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", dllArriveS);
            dllArriveS.selectByVisibleText(arriveStation);Thread.sleep(2000);

            Select dllSeat = this.getDdlSeatType();
            ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", dllSeat);
            dllSeat.selectByVisibleText(seatType);Thread.sleep(2000);

            Select dllAmount = this.getDdlTicketAmount();
            ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", dllAmount);
            dllAmount.selectByVisibleText(ticketAmount);
            Thread.sleep(5000);
            this.getBtnBookTicket().click();
        }catch (Exception e){
            System.out.println("Cannot chose an option in book ticket form!");
            e.printStackTrace();
        }
    }
    public boolean checkBookTicketPageTitle()
    {
        String title = "Book ticket";
        return this.getLabelPageTitle().getText().equals(title);
    }

    public String getTicketSeatType(){
        try{
            return this.getTdSeatType().getText();
        }catch (Exception e){
            return "";
        }
    }


    public String getTicketDepartDate(){
        try{
            return this.getTdDepartDate().getText();
        }catch (Exception e){
            return "";
        }
    }

    public String getTicketDepartStation(){
        try{
            return this.getTdDepartStation().getText();
        }catch (Exception e){
            return "";
        }
    }

    public String getSuccessMessage(){
        try{
            return this.getLblBookSuccess().getText();
        }catch (Exception e){
            return "";
        }
    }

    public String getTicketArriveStation(){
        try{
            return this.getTdArriveStation().getText();
        }catch (Exception e){
            return "";
        }
    }
    public String getTicketAmount(){
        try{
            return this.getTdTicketAmount().getText();
        }catch (Exception e){
            return "";
        }
    }
    public String getBookTicketErrorMessage()
    {
        return this.getLabelBookTicketErrorMessage().getText();
    }

    public String getBookTicketValidationErrorMessage()
    {
        return this.getLabelBookTicketValidationErrorMessage().getText();
    }
}


