package com.webdriver.tests.stepsDef;

import com.webdriver.tests.Browsers.BrowserFactory;
import com.webdriver.tests.utility.GeneralUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks  {


    @Before(order = 1, value = "@SetupDriver")
    public void setupSeleniumConnectionHook() throws Exception {
        BrowserFactory.getBrowser(System.getProperty("browser"));

    }

    @Before("@GoHomePage")
    public void setupHomePage() throws Throwable {
        Navigation.goToPage("HomePage");

    }

    @After("@SetupDriver")
    public void tearDownSeleniumConnectionHook(Scenario scenario) throws Exception {
        if (scenario.isFailed())
            GeneralUtils.embedScreenshot(scenario);
        BrowserFactory.closeBrowser();
    }

}
