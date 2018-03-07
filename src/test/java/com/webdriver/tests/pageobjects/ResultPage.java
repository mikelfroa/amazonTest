package com.webdriver.tests.pageobjects;

import com.webdriver.tests.utility.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

public class ResultPage extends BasePage{


    //Field results
    @FindBy(id = "nav-flyout-searchAjax")
    private WebElement fld_results;

    //WebEl Best Seller
    @FindBy(xpath = "//*[@id='s-results-list-atf']//li[contains(@id,'result_')]")
    private WebElement webEl_results;

    //Item results title
    @FindBy(xpath = "//*[@id='s-results-list-atf']//li[contains(@id,'result_')]//a[contains(@class,'s-access-detail-page')]")
    private List<WebElement> webEl_resultTitle;

    public ResultPage(WebDriver driver) {
        super(driver);
    }


    public String getResults(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fld_results));
        return fld_results.getText();
    }


    public void chooseRandomItem() {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(webEl_results));
        Random randomizer = new Random();
        WebElement random = webEl_resultTitle.get(randomizer.nextInt(webEl_resultTitle.size()));

        //Print the result for the search
        for (WebElement element:webEl_resultTitle) {
            System.out.println(element.getText());
        }

        Constant.title = random.getText();
        System.out.println("GeneralUtils.title " + Constant.title);
        random.click();

    }
}