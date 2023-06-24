package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class SearchPage {
    private final WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    private final By macProduct = By.id("ui-id-2");
    private final By macProductAssertion = By.xpath("//h1");


    public void navigateToMacProduct(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(macProduct).click();
    }

    public String getMacProductAssertionMessage(){
        return driver.findElement(macProductAssertion).getText();
    }
}
