package com.github.maxfedorov.github.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class SearchResultsPage extends PageBase {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get search results header")
    public String getSearchResultsHeader() {
        return driver.findElement(cssSelector(".codesearch-results h3")).getText();
    }

    @Step("Get search result link by number")
    public WebElement getSearchResultLinkByNumber(int i) {
        return driver.findElements(cssSelector("ul.repo-list li.repo-list-item .f4 a")).get(i - 1);
    }

    @Step("Open search result {name}")
    public void openSearchResult(String name) {
        driver.findElements(cssSelector("ul.repo-list li.repo-list-item .f4 a"))
                .stream()
                .filter(e -> e.getText().equals(name))
                .findFirst()
                .get()
                .click();
    }

    @Step("Select side tab {name}")
    public void selectSideTab(String name) {
        driver.findElement(xpath(format("//a[contains(@class, 'menu-item') and text()='%s']", name))).click();
    }

    @Step("Get commit button")
    public WebElement getCommitButton() {
        return driver.findElement(cssSelector(".commit-links-group"));
    }

}
