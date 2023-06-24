package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By loginPageAssertion = By.xpath("//h1");
    private final By emailTxt = By.id("Email");
    private final By passwordTxt = By.id("Password");
    private final By loginButton = By.xpath("//button[@class='button-1 login-button']");
    private final By LoginAssertionMessage = By.linkText("My account");

    public String getLoginPageAssertionMessage(){
        return driver.findElement(loginPageAssertion).getText();
    }

    public void EnterUserData(String email, String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginButton).click();

    }

    public String getLoginSuccessfullyAssertionMessage(){
        return driver.findElement(LoginAssertionMessage).getText();
    }
}
