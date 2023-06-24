package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    @Test
    public void NavigateToRegisterPage(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.NavigateToRegisterPage();
        Assert.assertEquals(registerPage.RegisterPageAssertion(),"Register");
    }

    @Test(priority = 1)
    public void RegisterNewUser() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.UserData();

        registerPage = new RegisterPage(driver);
        registerPage.enterUserData(data.firstName, data.lastName, data.day, data.month, data.year);
        registerPage.completeUserData(data.email+currentTime+"@gmail.com", data.company, data.password);
        Assert.assertEquals(registerPage.registerAssertionMessage(),"Your registration completed");
        registerPage.clickContinueButton();
    }
}
