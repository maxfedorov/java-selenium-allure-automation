package com.github.maxfedorov.github;

import com.github.maxfedorov.github.drivers.DriverFactory;
import com.github.maxfedorov.github.helpers.AttachmentHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class TestBase {
    protected WebDriver driver;

    @BeforeEach
    void before() {
        driver = DriverFactory.getDriver();
    }

    @AfterEach
    public void afterEach() {
        AttachmentHelper attachmentHelper = new AttachmentHelper(driver);
        String sessionId = attachmentHelper.getSessionId();
        attachmentHelper.screenshotAs("After test screenshot");
        driver.quit();
        if (!System.getProperty("driver").equals("local")) {
            attachmentHelper.attachVideo(sessionId);
        }
    }
}
