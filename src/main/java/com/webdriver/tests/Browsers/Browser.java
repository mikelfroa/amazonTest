package com.webdriver.tests.Browsers;

import com.webdriver.tests.pages.BasePage;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class Browser extends BasePage{

    protected String name;
    protected DesiredCapabilities capabilities;
}
