package PageObject.Railway;

import Constant.Constant;
import PageObject.Railway.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{

    // Locators
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");


    // Elements
    public WebElement getTxtUsername()
    {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin()
    {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    // Methods
    public HomePage login(String username, String password)
    {
        //Submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

        //Land on Home page
        return new HomePage();
    }

    public WebElement getLabelLoginErrorMessage()
    {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    public String getLoginErrorMsg()
    {
        return this.getLblLoginErrorMsg().getText();
    }

    public String getLoginErrorMessage()
    {
        return this.getLabelLoginErrorMessage().getText();
    }

    public void loginMultipleTimes(String username,String password,int number)
    {
        this.login(username,password);
        for(int i = 1;i <= number-1;i++)
        {
            this.login("",password);
        }
    }
}