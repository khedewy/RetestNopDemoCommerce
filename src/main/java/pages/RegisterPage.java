package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private final WebDriver driver;
    Select select;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    private final By assertionMessage = By.xpath("//h1[text()='Register']");
    private final By genderButton = By.id("gender-male");
    private final By firstNameTxt = By.id("FirstName");
    private final By lastNameTxt = By.id("LastName");
    private final By dayOfBirth = By.name("DateOfBirthDay");
    private final By monthOfBirth = By.name("DateOfBirthMonth");
    private final By yearOfBirth = By.name("DateOfBirthYear");
    private final By emailTxt = By.id("Email");
    private final By companyTxt = By.id("Company");
    private final By passwordTxt = By.id("Password");
    private final By confirmPasswordTxt = By.id("ConfirmPassword");
    private final By registerButton = By.id("register-button");
    private final By registerAssertion = By.xpath("//div[@class='result']");
    private final By continueButton = By.xpath("//a[@class='button-1 register-continue-button']");

    public String RegisterPageAssertion(){
        return driver.findElement(assertionMessage).getText();
    }


    public void enterUserData(String firstName, String lastName, String day, String month, String year){
        driver.findElement(genderButton).click();
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        select = new Select(driver.findElement(dayOfBirth));
        select.selectByVisibleText(day);
        select = new Select(driver.findElement(monthOfBirth));
        select.selectByVisibleText(month);
        select = new Select(driver.findElement(yearOfBirth));
        select.selectByVisibleText(year);
    }

    public void completeUserData(String email, String company, String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(companyTxt).sendKeys(company);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(confirmPasswordTxt).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public String registerAssertionMessage(){
        return driver.findElement(registerAssertion).getText();
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

}
