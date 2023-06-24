package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailToFriendPage {
    private final WebDriver driver;
    public EmailToFriendPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailToFriendButton = By.xpath("//button[@class='button-2 email-a-friend-button']");
    private final By emailToFriendPageAssertion = By.xpath("//h1");
    private final By friendEmailTxt = By.id("FriendEmail");
    private final By messageTxt = By.id("PersonalMessage");
    private final By sendEmailButton = By.xpath("//button[@class='button-1 send-email-a-friend-button']");
    private final By emailSendSuccessfully = By.xpath("//div[@class='result']");

    public void navigateToEmailToFriendPage(){
        driver.findElement(emailToFriendButton).click();
    }

    public String getEmailToFriendPageAssertionMessage(){
        return driver.findElement(emailToFriendPageAssertion).getText();
    }

    public void SendAMessageToAFriend(String F_Email, String message) throws InterruptedException {
        driver.findElement(friendEmailTxt).sendKeys(F_Email);
        driver.findElement(messageTxt).sendKeys(message);
        Thread.sleep(4000);
        driver.findElement(sendEmailButton).click();
    }

    public String getSuccessfulMessageAssertion(){
        return driver.findElement(emailSendSuccessfully).getText();
    }
}
