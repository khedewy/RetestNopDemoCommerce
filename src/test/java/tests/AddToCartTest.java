package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.SearchPage;

public class AddToCartTest extends TestBase{
    HomePage homePage;
    SearchPage search;
    AddToCartPage add;
    @Test
    public void SearchForMacProduct(){
        homePage = new HomePage(driver);
        homePage.navigateToSearchPage("mac");
    }

    @Test(priority = 1)
    public void NavigateToMacProduct(){
        search = new SearchPage(driver);
        search.navigateToMacProduct();
        Assert.assertEquals(search.getMacProductAssertionMessage(),"Apple MacBook Pro 13-inch");
    }

    @Test(priority = 2)
    public void addProductToCart(){
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getAddToCartAssertionMessage(),"Apple MacBook Pro 13-inch");
    }
}
