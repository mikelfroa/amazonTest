package com.webdriver.tests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailPage extends BasePage{

    //Text title
    @FindBy(id = "productTitle")
    private WebElement text_title;

    public DetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean prodTitleIsDisplayed(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(text_title));
        return text_title.getText().equalsIgnoreCase(GeneralUtils.title);
    }



}