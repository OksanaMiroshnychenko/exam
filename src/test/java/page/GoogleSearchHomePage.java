package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchHomePage extends BasePage {

    public GoogleSearchHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;


    public boolean isPageLoaded() {
        return searchField.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.google.com/")
                && driver.getTitle().equals("Google");
    }

    public SearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

}
