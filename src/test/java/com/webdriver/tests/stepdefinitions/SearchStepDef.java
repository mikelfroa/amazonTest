package com.webdriver.tests.stepdefinitions;

import com.webdriver.tests.pageobjects.DetailPage;
import com.webdriver.tests.pageobjects.HomePage;
import com.webdriver.tests.pageobjects.ResultPage;
import com.webdriver.tests.utility.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchStepDef  {

    private WebDriver driver;

    @Given("^I am at the home page$")
    public void iAmAtTheHomePage() throws Throwable {
        driver = new DriverFactory().getDriver();
        Assert.assertTrue("I am at the home page", driver.getCurrentUrl().equalsIgnoreCase("https://www.amazon.co.uk/"));
    }

    @When("^I filter the department \"([^\"]*)\"$")
    public void iFilterTheType(String department) throws Throwable {
        driver = new DriverFactory().getDriver();
        HomePage home = new HomePage(driver);
        home.filterByType(department);
    }

    @When("^I look for \"([^\"]*)\" in the search bar$")
    public void iLookForInTheSearchBar(String itemSearched) throws Throwable {
        driver = new DriverFactory().getDriver();
        HomePage home = new HomePage(driver);
        home.lookfor(itemSearched);
    }

    @And("^I launch the search$")
    public void iLaunchTheSearch() throws Throwable {
        driver = new DriverFactory().getDriver();
        HomePage home = new HomePage(driver);
        home.makeSearch();
    }

    @Then("^the page returns the result for \"([^\"]*)\"$")
    public void thePageReturnsTheResultFor(String newitem)  {
        driver = new DriverFactory().getDriver();
        ResultPage result = new ResultPage(driver);
        Assert.assertTrue("the page returns the result for " + newitem, result.getResults().contains(newitem));

    }

    @And("^I choose the \"([^\"]*)\" item in the suggestion dropdown$")
    public void iChooseTheItemInTheSearchDropdown(String item) throws Throwable {
        driver = new DriverFactory().getDriver();
        HomePage home = new HomePage(driver);
        home.clickItemInDropdown(item);
    }


    @And("^the title product is displayed$")
    public void theTitleProductIsDisplayed() throws Throwable {
        driver = new DriverFactory().getDriver();
        DetailPage detail = new DetailPage(driver);
        Assert.assertTrue("I am at the item detail page", detail.prodTitleIsDisplayed());
    }

    @And("^I go to a random product$")
    public void iGoToARandomProduct() throws Throwable {
        driver = new DriverFactory().getDriver();
        ResultPage result = new ResultPage(driver);
        result.chooseRandomItem();
    }
}
