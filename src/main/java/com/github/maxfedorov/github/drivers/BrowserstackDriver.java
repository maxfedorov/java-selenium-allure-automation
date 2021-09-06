package com.github.maxfedorov.github.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BrowserstackDriver extends DriverBase {
    public WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", driverConfig.browserstackUser() );
        capabilities.setCapability("browserstack.key", driverConfig.browserstackKey());
        capabilities.setCapability("browser", driverConfig.browserName());
        capabilities.setCapability("browser_version", driverConfig.browserVersion());
        capabilities.setCapability("os", driverConfig.os());
        capabilities.setCapability("os_version", driverConfig.osVersion());
        capabilities.setCapability("build", driverConfig.browserstackBuild());
        capabilities.setCapability("name", driverConfig.browserstackName());
        WebDriver driver = new RemoteWebDriver(driverConfig.url(), capabilities);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
