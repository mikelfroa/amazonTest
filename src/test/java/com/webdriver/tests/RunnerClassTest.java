package com.webdriver.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"com/webdriver/tests/stepsDef"}
)
public class RunnerClassTest {

}
