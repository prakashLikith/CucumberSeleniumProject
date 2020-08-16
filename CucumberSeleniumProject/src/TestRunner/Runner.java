package TestRunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",
				plugin = {"pretty", "html:test_result/cucumber-html-report",
							"json:test_result/cucumber.json", "junit:test_result/cucumber.xml", 
							"rerun:test_result/rerun.txt"},
				glue={"StepDefinition"})

public class Runner {

}
