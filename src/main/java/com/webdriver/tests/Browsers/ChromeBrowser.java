package com.webdriver.tests.Browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;

public class ChromeBrowser extends Browser{

    public ChromeBrowser() throws MalformedURLException {

        this.name = "chrome";
        this.capabilities = new DesiredCapabilities();

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=EN");
        driver = new ChromeDriver(options);
    }

}
