package PageObject.Railway;

public class ContactPage extends GeneralPage {
    // Locators

    // Elements

    // Methods
    public boolean checkContactPageTitle()
    {
        String title = "Contact Information";
        return this.getLabelPageTitle().getText().equals(title);
    }
}
