package com.nosuchelements.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.config.PropertyConfig;
import com.nosuchelements.constants.TestLanguage;
import com.nosuchelements.constants.Constants.Language;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.Logout;
import com.nosuchelements.session.SessionContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LogoutStepDef extends BasePage {
	
	@Autowired
	private SessionContext context;
	
	@Autowired
	private Logout Logout;
	
	@Autowired
	private PropertyConfig pc;

	private final static Logger log = LoggerFactory.getLogger(LogoutStepDef.class);

	@Then("User on Log Out Page Clicks on {string} Button")
	public void logout_CRCC_Application_And_Click_BackToLogin(String fieldname) throws Throwable {
		try {
			navigateTo("https://www.saucelabs-demo.com/en/public/logout.html?rc=100");
			if (fieldname.equalsIgnoreCase("Back To Login")) {
				log.info("STEP DEFINITION: Application logout And Click Back To Login");
				Logout.clickBackToLogin();

			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Logout and Click Back To Login");
			log.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	public void navigateTo(Language lang) {
		String url = null;
		navigateTo("https://www.saucelabs-demo.com/en/public/logout.html?rc=100");
	}
}
