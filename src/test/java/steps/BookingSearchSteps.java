package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BookingMainPage;
import pages.BookingSearchPage;

public class BookingSearchSteps {

    private static final String BOOKING_URL = "https://www.booking.com/";
    BookingSearchPage searchPage;
    WebDriver driver;
    BookingMainPage bookingMainPage;
    String searchHotel;
    String keyword;


    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("Keyword for search is {string}")
    public void searchKeywordIsString(String keyword) {
        this.searchHotel = keyword;
    }

    @When("Searching hotels in location")
    public void hotelSearching() {
        driver.get(BOOKING_URL);
        bookingMainPage = new BookingMainPage(driver);
        bookingMainPage.searchByKeyword(searchHotel);
        searchPage = new BookingSearchPage(driver);
    }

    @Then("Booking hotel on the first page is {string}, {string}")
    public void assertSearchResult(String result, String popularity) {
//        assertThat(String.format("There are no results for search string '%s' on first search page", result),
//                searchPage.getResultLinks(),
//                hasItem(result));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@data-testid='title'][1]")).getText(), result, "On the first line: " + result);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Superb'][1]")).getText(), popularity, "The hotel popularity is: " + popularity);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
