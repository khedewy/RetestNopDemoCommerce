package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private final WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private By agreeServices = By.id("termsofservice");
    private By checkOutButton = By.id("checkout");

    private final By countryTxt = By.id("BillingNewAddress_CountryId");
    private final By cityTxt = By.id("BillingNewAddress_City");
    private final By addressOneTxt = By.id("BillingNewAddress_Address1");
    private final By addressTowTxt = By.id("BillingNewAddress_Address2");
    private final By zipCodeTxt = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneNumTxt = By.id("BillingNewAddress_PhoneNumber");
    private final By faxNumberTxt = By.id("BillingNewAddress_FaxNumber");
    private final By continueButton = By.name("save");
    private final By shippingMethode = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    private final By paymentMethode = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private final By paymentInformation = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private final By confirmOrder = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
    private final By confirmOrderAssertion = By.xpath("//strong[text()='Your order has been successfully processed!']");



    public void navigateToCheckout(){
        driver.findElement(agreeServices).click();
        driver.findElement(checkOutButton).click();
    }


    public void EnterUserAddress(String country, String city, String addressOne, String addressTow,
                                 String zip, String phone, String fax){

        Select select = new Select(driver.findElement(countryTxt));
        select.selectByVisibleText(country);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(addressOneTxt).sendKeys(addressOne);
        driver.findElement(addressTowTxt).sendKeys(addressTow);
        driver.findElement(zipCodeTxt).sendKeys(zip);
        driver.findElement(phoneNumTxt).sendKeys(phone);
        driver.findElement(faxNumberTxt).sendKeys(fax);
        driver.findElement(continueButton).click();
    }

    public void setShippingMethode(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(shippingMethode)));
        driver.findElement(shippingMethode).click();
    }

    public void setPaymentMethode(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(paymentMethode)));
        driver.findElement(paymentMethode).click();
    }

    public void setPaymentInformation(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(paymentInformation)));
        driver.findElement(paymentInformation).click();
    }

    public void setConfirmOrder(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(confirmOrder)));
        driver.findElement(confirmOrder).click();
    }

    public String confirmOrderAssertionMessage(){
        return driver.findElement(confirmOrderAssertion).getText();
    }


    }
