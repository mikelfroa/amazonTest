package com.webdriver.tests.testhooks;

import com.webdriver.tests.utility.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks  {

    private WebDriver driver;

    @Before(order = 1, value = "@SetupDriver")
    public void setupSeleniumConnectionHook() throws Exception {
        driver = new DriverFactory().getDriver();
    }

    @Before("@GoHomePage")
    public void setupHomePage() throws Throwable {
        driver.get("https://www.amazon.co.uk");

    }

    @After("@SetupDriver")
    public void tearDownSeleniumConnectionHook(Scenario scenario) throws Exception {
        if (scenario.isFailed()){
            driver = new DriverFactory().getDriver();
         scenario.write("Current page " + driver.getCurrentUrl());
        }
        new DriverFactory().destroyDriver();
    }

}
