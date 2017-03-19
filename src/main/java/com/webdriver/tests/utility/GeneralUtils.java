package com.webdriver.tests.utility;


import com.webdriver.tests.pages.BasePage;
import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;


public class GeneralUtils extends BasePage{

    public static String title;

    public static void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException wde) {
            System.err.println(wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }


}
