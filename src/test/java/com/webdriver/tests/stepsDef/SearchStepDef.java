package com.webdriver.tests.stepsDef;

import com.webdriver.tests.pages.BasePage;
import com.webdriver.tests.pages.DetailPage;
import com.webdriver.tests.pages.HomePage;
import com.webdriver.tests.pages.ResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class SearchStepDef  extends BasePage{

    @Given("^I am at the home page$")
    public void iAmAtTheHomePage() throws Throwable {
        Assert.assertTrue("I am at the home page", driver.getCurrentUrl().equalsIgnoreCase("https://www.amazon.co.uk/"));
    }

    @When("^I filter the department \"([^\"]*)\"$")
    public void iFilterTheType(String department) throws Throwable {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.filterByType(department);
    }

    @When("^I look for \"([^\"]*)\" in the search bar$")
    public void iLookForInTheSearchBar(String itemSearched) throws Throwable {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.lookfor(itemSearched);
    }

    @And("^I launch the search$")
    public void iLaunchTheSearch() throws Throwable {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.makeSearch();
    }

    @Then("^the page returns the result for \"([^\"]*)\"$")
    public void thePageReturnsTheResultFor(String itemSearched) throws Throwable {
        ResultPage result = PageFactory.initElements(driver, ResultPage.class);
        Assert.assertTrue("the page returns the result for " + itemSearched, result.getResults().contains(itemSearched));

    }

    @And("^I choose the \"([^\"]*)\" item in the suggestion dropdown$")
    public void iChooseTheItemInTheSearchDropdown(String item) throws Throwable {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.clickItemInDropdown(item);
    }


    @And("^the title product is displayed$")
    public void theTitleProductIsDisplayed() throws Throwable {
        DetailPage detail = PageFactory.initElements(driver, DetailPage.class);
        Assert.assertTrue("I am at the item detail page", detail.prodTitleIsDisplayed());
    }

    @And("^I go to a random product$")
    public void iGoToARandomProduct() throws Throwable {
        ResultPage result = PageFactory.initElements(driver, ResultPage.class);
        result.chooseRandomItem();
    }
}
