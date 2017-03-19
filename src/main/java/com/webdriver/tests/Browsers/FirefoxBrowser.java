package com.webdriver.tests.Browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;


public class FirefoxBrowser extends Browser{

    public FirefoxBrowser() throws MalformedURLException {
        FirefoxProfile profile = new FirefoxProfile();
        this.name = "firefox";
        this.capabilities = new DesiredCapabilities();
        driver = new FirefoxDriver(profile);
    }

}
