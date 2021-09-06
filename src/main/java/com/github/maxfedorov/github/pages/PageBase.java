package com.github.maxfedorov.github.pages;

import org.openqa.selenium.WebDriver;

public class PageBase {

    protected PageBase(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;
}
