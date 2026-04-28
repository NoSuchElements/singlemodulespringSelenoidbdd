package com.nosuchelements.steps.dsa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.config.PropertyConfig;
import com.nosuchelements.constants.TestLanguage;
import com.nosuchelements.driver.DriverManager;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.session.SessionContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GenericSteps extends BasePage {

	
	
	@Autowired
    protected SessionContext context;
	
	@Autowired
	protected DriverManager driverManager;
	
	@Autowired
	private PropertyConfig appProp;
	
	
	private static Logger log = LogManager.getLogger(GenericSteps.class);
	
	
	@Given("Launch the Browser {string} and set the Language as {string}")
	public void launchBrowser(String browserName, String language)
	{
		System.setProperty("Application", "DSA");
		context.setLanguage(language);
		TestLanguage.setLanguage(language);
		 context.setDsaDmData(null);
		System.out.println("Launch Browser");
		if(appProp.getBrowser().contains("android")||appProp.getBrowser().contains("iphone"))
			System.out.println("Skipping Miximize window for mobile execution");
		else
			driverManager.getDriver().manage().window().maximize();
		try
		{
			System.out.println("Browser Name "+browserName);
			log.info("Browser Name "+browserName);
//			Drivers.getInstance().createDashDriver(browserName);
			System.out.println("Setting Language in GenericStep for test : "+language);
			System.out.println("Language "+language);
//			TestLanguage.setLanguage(language);
//			context.setLanguage(language);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			}
	 @And("Launch ICV Application")
	public void launchICVApplication() throws Exception {
		try{					
			System.out.println("Creating ICV driver");
//			icv.getInstantCreditView();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
