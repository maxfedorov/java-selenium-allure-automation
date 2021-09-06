package com.github.maxfedorov.github.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${driver}.properties"
})
public interface DriverConfig extends Config {

    @Key("enable.vnc")
    @DefaultValue("true")
    boolean enableVNC();

    @Key("enable.video")
    @DefaultValue("true")
    boolean enableVideo();

    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();

    @Key("browser.version")
    @DefaultValue("91.0")
    String browserVersion();

    @Key("os")
    @DefaultValue("Windows")
    String os();

    @Key("os.version")
    @DefaultValue("10")
    String osVersion();

    @Key("url")
    URL url();

    @Key("video.url")
    String videoUrl();

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("browserstack.build")
    @DefaultValue("Github")
    String browserstackBuild();

    @Key("browserstack.name")
    @DefaultValue("Tests")
    String browserstackName();

    @Key("webdriver.chrome.driver")
    @DefaultValue("")
    String webdriverChromeDriver();
}
