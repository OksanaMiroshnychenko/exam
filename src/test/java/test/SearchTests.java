package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultsPage;

import java.util.List;

public class SearchTests extends BaseTest {

    @Test
    public void caseSensitiveSearchTest() {
        String searchTerm = "Selenium";

        Assert.assertTrue(googleSearchHomePage.isPageLoaded(), "GoogleSearchHome page did not load.");

        SearchResultsPage FirstSearchResultsPage = googleSearchHomePage.search(searchTerm);
        Assert.assertTrue(FirstSearchResultsPage.isPageLoaded(), "FirstSearchResult page did not load.");
        Assert.assertEquals(FirstSearchResultsPage.getSearchResultsCount(), 9, "Not enough search results on search page.");


        List<String> FirstSearchResultsPageList = FirstSearchResultsPage.getSearchResultsList();
        for (String searchResult: FirstSearchResultsPageList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "Search Term" + searchTerm + "not found in:\\n" + searchResult );
        }

        SearchResultsPage SecondSearchResultsPage = googleSearchHomePage.search(searchTerm);
        Assert.assertTrue(SecondSearchResultsPage.isPageLoaded(), "FirstSearchResult page did not load.");
        Assert.assertEquals(SecondSearchResultsPage.getSearchResultsCount(), 10, "Not enough search results on search page.");

        List<String> SecondSearchResultsPageList = SecondSearchResultsPage.getSearchResultsList();
        for (String searchResult: SecondSearchResultsPageList) {
            Assert.assertTrue(searchResult.contains(searchTerm), "Search Term" + searchTerm + "not found in:\\n" + searchResult );
        }

    }

}
