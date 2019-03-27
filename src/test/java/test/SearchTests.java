package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultsPage;

public class SearchTests extends BaseTest {

    @Test
    public void SearchTest() {
        String searchTerm = "Selenium";

        Assert.assertTrue(googleSearchHomePage.isPageLoaded(), "GoogleSearchHome page did not load.");

        SearchResultsPage searchResultsPage = googleSearchHomePage.search(searchTerm);
        Assert.assertTrue(searchResultsPage.isPageLoaded(), "SearchResults page did not load.");

        Assert.assertTrue(searchResultsPage.getSearchResultsCount() >= 9, "Not enough search results on search page");

    }

}
