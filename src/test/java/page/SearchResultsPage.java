package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//div[@class=\"srg\"]/div")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//a[@aria-label=\"Page 2\"]")
    private WebElement linkToNextSearchPage;


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementIsClickable(searchResultsTotal);
    }

    public boolean isPageLoaded() {
        return searchResultsTotal.isDisplayed()
                && driver.getTitle().contains("Selenium - Поиск в Google");
    }

    public int getSearchResultsCount() {
        return searchResultElements.size();
    }

    public List<String> getSearchResultsList() {
        List<String> searchResultStringsList = new ArrayList<String>();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultElement);
            String searchResultString = searchResultElement.getText();
            searchResultStringsList.add(searchResultString);
        }
        return searchResultStringsList;
    }

    public SearchResultsPage goToNextSearchPage() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkToNextSearchPage);
        linkToNextSearchPage.click();
        return new SearchResultsPage(driver);
    }


}
