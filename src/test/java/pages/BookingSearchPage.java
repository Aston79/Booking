package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BookingSearchPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Our top picks')]")
    private List<WebElement> resultsLinks;

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultLinks() {
        return resultsLinks.stream().map(result -> result.getAttribute("innerText"))
                .filter(result -> !result.isEmpty()).collect(Collectors.toList());
    }
}
