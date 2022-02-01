package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingMainPage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//div[2]/button[@class='sb-searchbox__button ']")
    private WebElement searchButton;

    public BookingMainPage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword) {
        searchField.sendKeys(keyword);
        searchButton.click();
    }


}
