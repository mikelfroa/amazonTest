package com.webdriver.tests.testrunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"com/webdriver/tests/testhooks","com/webdriver/tests/stepdefinitions"}
)
public class RunnerClassTest {

}
