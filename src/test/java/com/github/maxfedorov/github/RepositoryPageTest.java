package com.github.maxfedorov.github;

import com.github.maxfedorov.github.pages.RepositoryPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Repository page")
public class RepositoryPageTest extends TestBase {
    @Test
    @Feature("Pages")
    @Story("Repository page")
    @DisplayName("Open issues tab")
    void openIssues() {
        driver.get("https://github.com/selenide/selenide");
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.openTab("Issues");
        step("Verify issues count", () -> {
            Assertions.assertThat(repositoryPage.getIssues().size() > 0)
                    .as("Page should contain issues, but it does not.")
                    .isTrue();
        });
    }

    @Test
    @Feature("Pages")
    @Story("Repository page")
    @DisplayName("Open file with code")
    void openFileWithCode() {
        driver.get("https://github.com/selenide/selenide");
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.openFileOrFolder("gradle");
        repositoryPage.openFileOrFolder("wrapper");
        repositoryPage.openFileOrFolder("gradle-wrapper.properties");
        step("Verify file body", () -> {
            Assertions.assertThat(repositoryPage.getFileBody().getText().startsWith("distributionBase=GRADLE_USER_HOME"))
                    .as("File should contain text starting with distributionBase=GRADLE_USER_HOME, but it does not.")
                    .isTrue();
        });
    }
}