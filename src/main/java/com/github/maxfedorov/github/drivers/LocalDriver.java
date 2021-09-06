package com.github.maxfedorov.github.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocalDriver extends DriverBase {

    public WebDriver getDriver() {
        String driverPath = driverConfig.webdriverChromeDriver();
        if (!driverPath.isEmpty()) {
            System.setProperty("webdriver.chrome.driver", driverPath);
        }
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
