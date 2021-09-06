package com.github.maxfedorov.github.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SelenoidDriver extends DriverBase {
    public WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(driverConfig.browserName());
        capabilities.setVersion(driverConfig.browserVersion());
        capabilities.setCapability("enableVNC", driverConfig.enableVNC());
        capabilities.setCapability("enableVideo", driverConfig.enableVideo());
        WebDriver driver = new RemoteWebDriver(driverConfig.url(), capabilities);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
