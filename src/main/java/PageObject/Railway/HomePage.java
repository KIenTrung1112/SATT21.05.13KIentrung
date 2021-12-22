package PageObject.Railway;

import Constant.Constant;
import PageObject.Railway.GeneralPage;

public class HomePage extends GeneralPage {
    // Locators

    // Elements

    // Methods

    public HomePage open()
    {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
