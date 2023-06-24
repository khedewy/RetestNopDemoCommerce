package tests;

import data.EmailToFriendData;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class EmailToFriendTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    SearchPage search;
    LoginPage log;
    EmailToFriendPage email;
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
    @Test(priority = 2)
    public void navigateToLoginPage(){
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();
        log = new LoginPage(driver);
        Assert.assertEquals(log.getLoginPageAssertionMessage(),"Welcome, Please Sign In!");
    }

    @Test(priority = 3)
    public void Login() throws IOException, ParseException {
        RegisterData data = new RegisterData();
        data.UserData();
        log = new LoginPage(driver);
        log.EnterUserData(data.email+currentTime+"@gmail.com", data.password);
        Assert.assertEquals(log.getLoginSuccessfullyAssertionMessage(),"My account");
    }

    @Test(priority = 4)
    public void SearchForMacProduct(){
        homePage = new HomePage(driver);
        homePage.navigateToSearchPage("mac");
    }

    @Test(priority = 5)
    public void NavigateToMacProduct(){
        search = new SearchPage(driver);
        search.navigateToMacProduct();
        Assert.assertEquals(search.getMacProductAssertionMessage(),"Apple MacBook Pro 13-inch");
    }
    @Test(priority = 6)
    public void navigateToSendEmailPage(){
        email = new EmailToFriendPage(driver);
        email.navigateToEmailToFriendPage();
        Assert.assertEquals(email.getEmailToFriendPageAssertionMessage(),"Email a friend");
    }

    @Test(priority = 7)
    public void sendEmailToFriend() throws IOException, ParseException, InterruptedException {
        EmailToFriendData data = new EmailToFriendData();
        data.UserData();
        email = new EmailToFriendPage(driver);
        email.SendAMessageToAFriend(data.friendEmail, data.message);
        Assert.assertEquals(email.getSuccessfulMessageAssertion(),"Your message has been sent.");
    }
}
