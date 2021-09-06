package com.github.maxfedorov.github.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class RepositoryPage extends PageBase {

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get readme header")
    public WebElement getReadMeHeader() {
        return driver.findElement(By.cssSelector(".markdown-body h1"));
    }

    @Step("Open tab {name}")
    public void openTab(String name) {
        driver.findElements(By.cssSelector("ul.UnderlineNav-body li a span"))
                .stream()
                .filter(e -> {
                    String attribute = e.getAttribute("data-content");
                    return attribute != null && attribute.equals(name);
                })
                .findFirst()
                .get()
                .click();
    }

    @Step("Open file/folder {name}")
    public void openFileOrFolder(String name) {
        driver.findElement(xpath(format("//div[contains(@class, 'Box-row')]//a[text()='%s']", name))).click();
    }

    @Step("Get issues list")
    public List<WebElement> getIssues() {
        return driver.findElements(By.cssSelector("div[aria-label='Issues'] .js-navigation-item.js-issue-row"));
    }

    @Step("Get file body")
    public WebElement getFileBody() {
        return driver.findElement(By.cssSelector("div[itemprop='text'] tbody"));
    }
}
