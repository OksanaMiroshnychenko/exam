package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {
    public WebDriver driver;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//div[@class=\"srg\"]/div")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//a[@aria-label=\"Page 2\"]")
    private WebElement linkToNextPage;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsClickable(searchResultsTotal);
    }

    public boolean isPageLoaded() {
        return searchResultsTotal.isDisplayed()
                && driver.getCurrentUrl().contains("/search/results")
                && driver.getTitle().contains("Selenium - Поиск в Google");
    }

}
