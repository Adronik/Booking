import Pages.SearchResultsPage;
import Utils.WebDriverManager;
import Utils.WebsiteNavigation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingTest {

    @BeforeMethod
    public void BeforeEachTest() {
        WebDriverManager.openBrowser();
    }

    @Test
    public void cheapestHotelPurchase() {
        SearchResultsPage searchResultsPage = WebsiteNavigation.openBookingHomePage().searchForLosAngelesCity("Los Angeles");
        searchResultsPage.selectNextMonth();
        searchResultsPage.selectDate();
        searchResultsPage.selectOnePerson();
        searchResultsPage.clickFindButton();
        searchResultsPage.selectCheapestHotel();
        searchResultsPage.selectRoom();
        searchResultsPage.clickOnBookRoomButton();

    }

    //@AfterMethod
    //public void AfterEachTest() {
        //WebDriverManager.closeBrowser();
    //}

}