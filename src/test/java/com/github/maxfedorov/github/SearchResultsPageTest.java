package com.github.maxfedorov.github;

import com.github.maxfedorov.github.pages.RepositoryPage;
import com.github.maxfedorov.github.pages.SearchResultsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Search results page")
public class SearchResultsPageTest extends TestBase {
    @Test
    @Feature("Pages")
    @Story("Search results page")
    @DisplayName("Open repository")
    void openRepo() {
        driver.get("https://github.com/search?q=selenide");
        new SearchResultsPage(driver).openSearchResult("selenide/selenide");
        step("Verify read me file", () -> {
            Assertions.assertThat(new RepositoryPage(driver).getReadMeHeader().getText())
                    .isEqualTo("Selenide = UI Testing Framework powered by Selenium WebDriver");
        });
    }

    @Test
    @Feature("Pages")
    @Story("Search results page")
    @DisplayName("Select commits tab")
    void selectCommitsTab() {
        driver.get("https://github.com/search?q=selenide");
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectSideTab("Commits");
        step("Verify page", () -> {
            Assertions.assertThat(searchResultsPage.getCommitButton().isDisplayed())
                    .as("Page should contain commit button, but it does not.")
                    .isTrue();
        });
    }
}
