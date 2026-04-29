package com.nosuchelements.steps.dsa;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.LetsGetStartedPage;

import io.cucumber.java.en.And;

public class LetsGetStartedStepDef extends BasePage {
	
	@Autowired
	private LetsGetStartedPage letsGetStarted;
	
	
	
	ArrayList<String> tabs;
	
	@And("User Starts Online Application")
	public void startOnlineApp()
	{
		try
		{
			System.out.println("DSM Data in startOnlineApp method: "+context.getDsaDmData());
			letsGetStarted.letsGetStarted(context.getDsaDmData(),context.getDsaDmData().getCardType());
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Start Online Application");
			
		}
	}
	
	
	@And("User checks Mock ID verification checkbox on Application")
	public void optMockVerification()
	{
		try
		{
			Thread.sleep(3000);
			letsGetStarted.mockVerification();
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to opt SK Mock Verification");
			
		}
	}
	
//	@And("User checks Mock ID verification checkbox does not appear on production")
//	public void MockVerificationProd()
//	{
//		try
//		{
//			Thread.sleep(3000);
//			letsGetStarted.noMock();
//		}catch(Exception e) {
//			e.printStackTrace();
//			Assert.fail("Failed to opt SK Mock Verification");
//			
//		}
//	}
	
	@And("User validates effective date")
	@And("User validates COCD modal content")
	public void validateEffDate()
	{
		try
		{
			System.out.println("\n Validating effective date");
			letsGetStarted.validateEffDt(context.getDsaDmData());
//			letsGetStarted.validateCOCDContent(context.getDsaDmData().getCardType());
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate Effective Date");
			
		}
	}
	
	@And("User validates {string} link")
	public void validatePrivacyCharter(String fieldName)
	{
		try
		{
			switch(fieldName) {
			case "PrivacyCharter":
				letsGetStarted.getPrivacyLink().click();
				break;
			case "SecurityCenter":
				letsGetStarted.getFooterSecurityLink().click();
				break;
			case "LegalnPrivacy":
				letsGetStarted.getFooterLegalPrivacyLink().click();
				break;
			}
			Thread.sleep(3000);
			String activeWindow;
			tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
			if(context.getDsaDmData().getChannel().equals("WP")) 
				activeWindow = tabs.get(2);
			else
				 activeWindow = tabs.get(1);
			driverManager.getDriver().switchTo().window(activeWindow);
			String currUrl = driverManager.getDriver().getCurrentUrl();
			System.out.println("CurrentURL: "+currUrl);
			switch(fieldName) {
			case "PrivacyCharter":
			case "SecurityCenter":
				if(!currUrl.contains("privacy_security") && !currUrl.contains("docs3")) {
					Assert.fail("Failed to validate "+fieldName);
				}
				break;
			case "LegalnPrivacy":
				if(!currUrl.contains("legal") && !currUrl.contains("docs")) {
					Assert.fail("Failed to validate Legal privacy tab");
				}
				break;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate "+fieldName);
			
		}
	}
	
	@And("User validates APR on {string} page")
	public void validateAPR(String field) {
		WebElement element = null;
		try {
			switch(field) {
				case "CostOfCreditDisclosure":
					  element = driverManager.getDriver().findElement(By.xpath("//span[contains(@data-ng-if, 'costCreditCtrl')]/span[1]"));
					  element.getText().contains("28.99");
				      break;
				case "FooterLegal":
					 Thread.sleep(1000);
					 letsGetStarted.getLegalFooter().click();
					 System.out.println(" \n CLICKED LEGAL FOOTER \n");
					 element = driverManager.getDriver().findElement(By.xpath("//div[@id='dsa_legal_accordion_content']"));
					 String legalText = element.getText();
					 System.out.println("Footer Text: "+legalText);
					 if(context.getDsaDmData().getLanguage().contains("E")) {
						 try {
							 if(legalText.indexOf("21.99% ")<0) {
								 Assert.fail("\n 1) Legal Footer rate 1 text does not match \n");
							 }
							 if(legalText.indexOf("21.99%")<0) {
								 Assert.fail("\n 2) Legal Footer rate 2 text does not match \n");
							 }
							 if(legalText.indexOf("$1.81")<0) {
								 Assert.fail("\n 3) Legal Footer charges 1 text does not match \n");
							 }
							 if(legalText.indexOf("$9.04")<0) {
								 Assert.fail("\n 4) Legal Footer charges 2 text does not match \n");
							 }
							 if(legalText.indexOf("$18.07")<0) {
								 Assert.fail("\n 5) Legal Footer charges 3 text does not match \n");
							 }
							 if(legalText.indexOf("$36.15")<0) {
								 Assert.fail("\n 6) Legal Footer charges 4 text does not match \n");
							 }
						 }catch(Exception e) {
							 System.out.println("\n Error : LEGAL FOOTER : ENG flow \n");
							 throw e;
						 }
					 }
					 else {
						 try {
							 if(legalText.indexOf("21,99 % ")<0) {
								 Assert.fail("\n 1) French : Legal Footer rate text does not match \n");
							 }
							 if(legalText.indexOf("21,99 %")<0) {
								 Assert.fail("\n 2) French : Legal Footer rate text does not match \n");
							 }
							 if(legalText.indexOf("1,81 $")<0) {
								 Assert.fail("\n 3) French : Legal Footer rate text does not match \n");
							 }
							 if(legalText.indexOf("9,04 $")<0) {
								 Assert.fail("\n 4) French : Legal Footer rate text does not match \n");
							 }
							 if(legalText.indexOf("18,07 $")<0) {
								 Assert.fail("\n 5) French : Legal Footer rate text does not match \n");
							 }
							 if(legalText.indexOf("36,15 $")<0) {
								 Assert.fail("\n 6) French : Legal Footer rate text does not match \n");
							 }
						 }catch(Exception e) {
							 System.out.println("\n Error : LEGAL FOOTER : FRC flow \n");
							 throw e;
						 }
					 }
					 break;
				case "Review":
				      element = driverManager.getDriver().findElement(By.xpath(""));
				      element.getText().contains("20.99");
				      break;
			}
//		element.getText().contains("20.99");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate APR");
		}
	}
	
	
	@And("User Starts Non Ecom Online Application")
	public void startOnlineAppNonEcom()
	{
		try
		{
			Thread.sleep(3000);
			letsGetStarted.letsGetStartedforNonEcom(context.getDsaDmData().getCardType());
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Start Online Application");
			
		}
	}
	
	@And("User Agrees Cost of Credit Disclosure for Credit Card Application")
	public void agreeCOCForCredit()
	{
		try
		{
			letsGetStarted.validateCOCD(context.getDsaDmData().getCardType());
			letsGetStarted.agreeCOC(context.getDsaDmData());
			Thread.sleep(3000);
		}catch(Exception e) {
			Assert.fail("Failed to Agree Cost of Credit Disclosure for Credit Card Application");
			e.printStackTrace();
		}
	}
	
	@And("User on landing page closes new Tab")
	public void closenewTab() throws Exception {
		try {
			driverManager.getDriver().close();
			Thread.sleep(5000);
			Thread.sleep(5000);
			System.out.println("No of Tabs"+tabs.size());
			if(tabs.size()>2) {
				System.out.println("Switching in Ecom tab");
				driverManager.getDriver().switchTo().window(tabs.get(1));
			}
			else {
				System.out.println("Switching in NonEcom tab");
				driverManager.getDriver().switchTo().window(tabs.get(0));
			}
			Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Close New Tab");
			throw new Exception(e);
		}
	}
	
	@And("User opens pdf Save or Print {string} on Cost of credit disclosure for validation")
	public void validateCOCDandPdf(String button) throws Exception
	{
		DSA_DM dsa = context.getDsaDmData();
		try
		{
//			letsGetStarted.validateCOCD(context.getDsaDmData().getCardType());
			System.out.println("\n *** opening pdf on COCD\n ");
			String pdfText = letsGetStarted.openPdfonCOCD(button);  // Validating APR
			letsGetStarted.validateCOCDPdfContent(dsa.getCardType(), pdfText); //Validating Eff Date
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate COCD \n");
			
		}
	}
	
	@And("User closes Cost of credit disclosure tab and switches to DSA app")
	public void closeTabCOCD() throws Exception
	{
		try
		{
			letsGetStarted.closeCOCD();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to close COCD tab \n");
			
		}
	}
	
	
	
	@And("User on Landing Page Verifies {string} text should be {string}")
	public void verifyText(String fieldName, String key) {
		String expText = getInputText(key);
		WebElement element = null;
		try {
			switch(fieldName) {
			case "LegalFootnotes":
				element = letsGetStarted.getLegalFootnotes();
				break;
			}
			validateText(element, expText);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate Legal Footnotes on Landing Page");
		}
	}
	
	@And("User on Landing Page Clicks on {string} Superscript")
	@And("User on Landing Page Clicks on {string} Link")
	@And("User on Landing Page Clicks on {string} Icon")
	public void clickElement(String fieldName) {
		WebElement element = null;
		try {
			switch(fieldName) {
			case "®1":
				element = letsGetStarted.getRegTrademark1();
				break;
			case "®2":
//				element = letsGetStarted.getRegTrademark2();
				break;
			case "Regtrademark1_Back":
//				element = letsGetStarted.getRegTrademark1_back();
				break;
			case "Regtrademark2_Back":
//				element = letsGetStarted.getRegTrademark2_back();
				break;
			case "LegalNotesExpand":
				element = letsGetStarted.getLegalFootnotesExpand();
				break;
			}
			clickElementJS(element);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Click on "+fieldName +" Landing Page");
			
		}
		
	}
}
