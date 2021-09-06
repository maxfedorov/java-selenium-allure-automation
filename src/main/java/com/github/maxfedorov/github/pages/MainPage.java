package com.github.maxfedorov.github.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Search {text}")
    public void search(String text) {
        driver.findElement(cssSelector(".header-search-input")).sendKeys(text, Keys.ENTER);
    }

    @Step("Sign up with email {mail}")
    public void signUp(String mail) {
        driver.findElement(id("user_email")).sendKeys(mail);
        driver.findElement(cssSelector("[type='submit']")).click();
    }

}
