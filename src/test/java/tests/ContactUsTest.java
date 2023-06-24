package tests;

import data.ContactUsData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.io.IOException;

public class ContactUsTest extends TestBase{
    HomePage homePage;
    ContactUsPage contact;

    @Test
    public void navigateToContactUsPage(){
        homePage = new HomePage(driver);
        homePage.navigateToContactUs();
        contact = new ContactUsPage(driver);
        Assert.assertEquals(contact.getContactUsPageAssertionMessage(),"Put your contact information here." +
                " You can edit this in the admin site.");
    }

    @Test(priority = 1)
    public void UseContactUs() throws IOException, ParseException {
        ContactUsData data = new ContactUsData();
        data.UserData();
        contact = new ContactUsPage(driver);
        contact.ContactUs(data.name, data.email, data.message);
        Assert.assertEquals(contact.getContactUsAssertionMessage(),"Your enquiry has been successfully sent to the store owner.");
    }
}
