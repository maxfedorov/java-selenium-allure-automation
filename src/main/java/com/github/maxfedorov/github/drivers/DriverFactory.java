package com.github.maxfedorov.github.drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory extends DriverBase {

    public static WebDriver getDriver() {
        String driver = System.getProperty("driver");
        if (driver.equals("local")) {
            return new LocalDriver().getDriver();
        } else if (driver.equals("selenoid")) {
            return new SelenoidDriver().getDriver();
        } else if (driver.equals("browserstack")) {
            return new BrowserstackDriver().getDriver();
        } else throw new RuntimeException("Unknown driver type. Use: local, selenoid, browserstack");
    }
}
