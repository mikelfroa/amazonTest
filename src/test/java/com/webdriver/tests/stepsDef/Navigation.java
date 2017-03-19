package com.webdriver.tests.stepsDef;

import com.webdriver.tests.pages.BasePage;

public class Navigation extends BasePage {


    public static void goToPage(String page) {
        String url = null;
        switch (page) {
            case "HomePage":
                url ="https://www.amazon.co.uk/";
                break;
        }

        driver.get(url);
    }



}
