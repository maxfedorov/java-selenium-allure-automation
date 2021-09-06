package com.github.maxfedorov.github.pages;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class JoinPage extends PageBase {

    public JoinPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate page")
    public void validate() {
        Assertions.assertThat(driver.findElements(cssSelector(".signup-content-container")).size() > 0)
                .as("Join page should be displayed, but it was not.")
                .isTrue();
    }

}
