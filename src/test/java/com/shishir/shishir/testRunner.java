package com.shishir.shishir;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resources/Features"},
plugin = {"json:target/cucumber.json"},
glue = "Stepdefinition") //,tags= {"@bona"})

 public class testRunner extends AbstractTestNGCucumberTests {

}
