package com.github.maxfedorov.github;

import com.github.maxfedorov.github.pages.JoinPage;
import com.github.maxfedorov.github.pages.MainPage;
import com.github.maxfedorov.github.pages.SearchResultsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static io.qameta.allure.Allure.step;

@DisplayName("Main page")
public class MainPageTest extends TestBase {
    @Test
    @Feature("Pages")
    @Story("Main page")
    @DisplayName("Search repository")
    void searchRepo() {
        driver.get("https://github.com");
        new MainPage(driver).search("selenide");
        SearchResultsPage result = new SearchResultsPage(driver);
        WebElement resultLink = result.getSearchResultLinkByNumber(1);
        step("Verify results", () -> {
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(result.getSearchResultsHeader().endsWith("repository results"))
                    .as("Page header should contain text ending with 'repository results' but it does not.")
                    .isTrue();
            softAssertions.assertThat(resultLink.getText()).isEqualTo("selenide/selenide");
            softAssertions.assertThat(resultLink.getAttribute("href")).isEqualTo("https://github.com/selenide/selenide");
            softAssertions.assertAll();
        });
    }

    @Test
    @Feature("Pages")
    @Story("Main page")
    @DisplayName("Sign up")
    void signUp() {
        driver.get("https://github.com");
        new MainPage(driver).signUp("test@e.mail");
        new JoinPage(driver).validate();
    }
}
