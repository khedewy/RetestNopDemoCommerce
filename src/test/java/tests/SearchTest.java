package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class SearchTest extends TestBase{
    HomePage homePage;
    SearchPage search;

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
}