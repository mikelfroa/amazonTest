package com.webdriver.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage{

    //Field search
    @FindBy(id = "twotabsearchtextbox")
    private WebElement fld_search;

    //Button search
    @FindBy(xpath = "//*[@id='nav-search']//*[@value='Go']")
    private WebElement btn_search;

    //Drowpdown type
    @FindBy(id = "searchDropdownBox")
    private WebElement dpr_type;


    //Dropdown suggestions
    @FindBy(xpath = ".//*[@id='suggestions']/div")
    private WebElement welEl_suggestions;


    public void lookfor(String object){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fld_search));
        fld_search.sendKeys(object);
    }

    public void makeSearch() {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(btn_search));
        btn_search.click();
    }


    public void clickItemInDropdown(String itemSearched) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(welEl_suggestions));
        List<WebElement> alldropdownitems = driver.findElements(By.xpath(".//*[@id='suggestions']/div"));
        int size = alldropdownitems.size();
        for (int i = 1; i <= size; i++) {

            if (alldropdownitems.get(i).getText().equalsIgnoreCase(itemSearched)) {
                alldropdownitems.get(i).click();
                break;
            }

        }
    }


    public void filterByType(String type) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(dpr_type));
        dpr_type.click();
        Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText(type);
    }
}