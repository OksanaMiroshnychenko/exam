package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.GoogleSearchHomePage;

public class BaseTest {
    private WebDriver driver;
    public GoogleSearchHomePage googleSearchHomePage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        googleSearchHomePage = new GoogleSearchHomePage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
