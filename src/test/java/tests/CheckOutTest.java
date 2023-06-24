package tests;

import data.CheckoutData;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class CheckOutTest extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage log;
    AddToCartPage add;
    SearchPage search;
    CheckoutPage check;
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
    public void addProductToCart(){
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getAddToCartAssertionMessage(),"Apple MacBook Pro 13-inch");
    }

    @Test(priority = 7)
    public void navigateToCheckOut(){
        check = new CheckoutPage(driver);
        check.navigateToCheckout();
    }
    @Test(priority = 8)
    public void completeCheckOut() throws IOException, ParseException {
        CheckoutData data = new CheckoutData();
        data.UserData();
        check = new CheckoutPage(driver);
        check.EnterUserAddress(data.country, data.city, data.addressOne, data.addressTow, data.zip, data.phone, data.fax);
        check.setShippingMethode();
        check.setPaymentMethode();
        check.setPaymentInformation();
        check.setConfirmOrder();
        Assert.assertEquals(check.confirmOrderAssertionMessage(),"Your order has been successfully processed!");
    }

}
