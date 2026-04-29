package com.nosuchelements.runners;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;

import com.nosuchelements.config.singlemodulespringbddApplication;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
	    features = "src\\test\\resources\\features\\DSA",
	    glue = {"com.nosuchelements.steps", "com.nosuchelements.hooks", "com.nosuchelements.config"},
	    plugin = { 
	        "pretty",
//	        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", 
	        "json:target/cucumber-reports/Cucumber.json",  // Changed path to match plugin
	        "rerun:rerunTC/runner-rerun.txt"
	    },
	    monochrome = true,
	    dryRun = false
        ,tags = "@OMX_Eng_ActiveLoyaltyCASLestatment"
        )
	@SpringBootTest(classes = singlemodulespringbddApplication.class)
	public class WebTestRunner extends AbstractTestNGCucumberTests {
	
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	}
