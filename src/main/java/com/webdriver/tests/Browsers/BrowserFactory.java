package com.webdriver.tests.Browsers;

import com.webdriver.tests.pages.BasePage;

import java.net.MalformedURLException;

public class BrowserFactory extends BasePage{

    public static Browser getBrowser(String browserName) throws MalformedURLException {
        if (browserName == null ){
            browserName = "chrome";
        }
        Browser browser = null;
        switch (browserName) {
            case "firefox":
                browser = new FirefoxBrowser();
                break;
            case "chrome":
                browser = new ChromeBrowser();
                break;
        }

        return browser;
    }

    public static void closeBrowser(){
        driver.close();
        driver.quit();
        driver = null;
    }
}
