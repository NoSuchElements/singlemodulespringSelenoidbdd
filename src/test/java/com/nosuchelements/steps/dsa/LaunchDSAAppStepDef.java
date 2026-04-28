package com.nosuchelements.steps.dsa;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.dsa.LaunchDSAApp;
import com.nosuchelements.session.SessionContext;

import io.cucumber.java.en.And;

public class LaunchDSAAppStepDef  {
	
	@Autowired
	private LaunchDSAApp launchDsaApp;
	
	@Autowired
	private SessionContext context;
	
	private static Logger log = LogManager.getLogger(LaunchDSAAppStepDef.class);

	DSA_DM dsa;
	String applicantEmail;
	
	@And ("^Launch New Ecomm Simulator$")
	public void launchNewEcommSimulator() throws Exception {		
		try
		{
			DSA_DM dsaDM =context.getDsaDmData()!=null?context.getDsaDmData(): new DSA_DM();
			System.out.println("DSA Data in Launch Ecomm Simulator: "+context.getDsaDmData());
			System.out.println("Setting channel: ");
			dsaDM.setChannel("WP");
			System.out.println("Get channel:"+dsaDM.getChannel());
			System.out.println("Getting Language:"+context.getLanguage());
			log.info("Launch the DSA application: PASS");
			launchDsaApp.navigateToNewSimulator(context.getLanguage());
			context.setDsaDmData(dsaDM); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Failed to launch DSA application");
			throw new Exception(e);
		}
	}
	
	@And("Launch DSA Application")
	public void launchDSAApp() throws Exception {		
		try
		{
			log.info("Launch the dash application: PASS");
			launchDsaApp.navigateToDSA(context.getLanguage());
			Thread.sleep(2000); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.log(Level.ERROR, e.getMessage(), e);
			Assert.fail("Failed to launch DSA Application");
			throw new Exception(e);
		}
	}
	
	@And("Launch DSA Application for {string}")
	public void launchDSAAppForCard(String cardType) throws Exception {		
		try
		{
			DSA_DM updatedDetails =context.getDsaDmData()!=null?context.getDsaDmData(): new DSA_DM();
//			context.setLanguage(TestLanguage.getLanguage().toString());
			System.out.println("Language from Context:"+context.getLanguage());
			log.info("Launch the DSA application: PASS");
			launchDsaApp.navigateToDSA(context.getLanguage(), cardType);
			Thread.sleep(2000);
			updatedDetails.setLanguage(context.getLanguage());
			updatedDetails.setCardType(cardType);;
			updatedDetails.setChannel("IN");
			context.setDsaDmData(updatedDetails); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.log(Level.ERROR, e.getMessage(), e);
			Assert.fail("Failed to launch DSA Application");
			throw new Exception(e);
		}
	}
	
	@And("Launch DSA Application for {string} with promo code {string}")
	public void launchDSAAppwithPromo(String cardType, String promo) throws Exception {		
		try
		{
			System.out.println("DSA Data From Context in Launch DSA App: "+ context.getDsaDmData());
			DSA_DM updatedDetails =context.getDsaDmData()!=null?context.getDsaDmData(): new DSA_DM();
//			context.setLanguage(TestLanguage.getLanguage().toString());
			log.info("Launch the DSA application: PASS");
			System.out.println("Context Language:"+context.getLanguage());
			launchDsaApp.navigateToDSAPromoCode(context.getLanguage(), promo, cardType);
			Thread.sleep(2000);
			updatedDetails.setLanguage(context.getLanguage());
			updatedDetails.setCardType(cardType);;
			updatedDetails.setChannel("IN");
			context.setDsaDmData(updatedDetails); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.log(Level.ERROR, e.getMessage(), e);
			Assert.fail("Failed to launch DSA Application with Promo code");
			throw new Exception(e);
		}
	}
	
	@And("Launch DSA Application for {string} on WDC")
	public void launchDSAAppwdc(String cardtype) throws Exception {		
		try
		{
			DSA_DM updatedDetails =context.getDsaDmData()!=null?context.getDsaDmData(): new DSA_DM();
//			context.setLanguage(TestLanguage.getLanguage());
			log.info("Launch the dash application: PASS");
//			driverHelper.navigateTo("https://mastercard.triangle.com/content/dsa2/en.html?cardType=OMX");
			launchDsaApp.navigateToDSAwdc(context.getLanguage(),cardtype);
			Thread.sleep(2000); 
			updatedDetails.setLanguage(context.getLanguage());
			updatedDetails.setCardType(cardtype);
			updatedDetails.setChannel("IN");
			context.setDsaDmData(updatedDetails); 

		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.log(Level.ERROR, e.getMessage(), e);
			Assert.fail("Failed to launch DSA Application");
			throw new Exception(e);
		}
	}
	
	@And("Launch DSA Application for {string} on production")
	public void launchDSAAppProd(String cardtype) throws Exception {		
		try
		{
			log.info("Launch the dash application: PASS \n");
			launchDsaApp.navigateToDSAProd(context.getLanguage(),cardtype);
			Thread.sleep(2000); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.log(Level.ERROR, e.getMessage(), e);
			Assert.fail("Failed to launch DSA Application");
			throw new Exception(e);
		}
	}
	
}
