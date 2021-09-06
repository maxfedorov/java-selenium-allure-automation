package com.github.maxfedorov.github.helpers;

import com.github.maxfedorov.github.config.DriverConfig;
import io.qameta.allure.Attachment;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class AttachmentHelper {
    private WebDriver driver;
    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    public AttachmentHelper(WebDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public String attachVideo(String sessionId) {
        String videoUrl = System.getProperty("driver").equals("selenoid") ? getSelenoidVideoUrl(sessionId) : getBrowserVideoUrl(sessionId);
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + videoUrl + "' type='video/mp4'></video></body></html>";
    }

    public String getSessionId() {
        return ((RemoteWebDriver) driver).getSessionId().toString();
    }

    private String getSelenoidVideoUrl(String sessionId) {
        try {
            return new URL(driverConfig.videoUrl() + sessionId + ".mp4") + "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getBrowserVideoUrl(String sessionId) {
        return given()
                .auth().basic(driverConfig.browserstackUser(), driverConfig.browserstackKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}
