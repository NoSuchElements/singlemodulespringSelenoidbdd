package com.nosuchelements.steps.dsa;

import org.apache.logging.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.ThankYouPage;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.java.en.And;

public class ThankYouStepDef extends BasePage {
	
	@Autowired
	private ThankYouPage TP;
	
	@Autowired
	private CommonUtils commutil;
	
	@And("User is on Thank You Page")
	public void verifyThankyouPage() {
		try
		{
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nextSubtitle))));
			commutil.validate(context.getDsaDmData().getCardType());
			waitForSeconds(5);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate Thank you page");
			
		}
	}
	
	@And("User on Thank You Page Clicks {string} button")
	public void clickElement(String fieldName) {
		try {
			WebElement element = null;
			switch(fieldName) {
			case "VerifyLater":
				waitForSeconds(10);
				element = TP.getVerifyLaterBtn();
				context.getDsaDmData().setSkConsent("N");
				System.out.println("Clicked on Verify later");
				break;
			case "VerifyNow":
				element = TP.getVerifyNowBtn();
				context.getDsaDmData().setSkConsent("Y");
				System.out.println("Clicked on Verify Now");
				break;
			case "Continue":
				Thread.sleep(5000);
				waitForSeconds(10);
				waitForSeconds(10);
				waitForSeconds(10);
				element = TP.getContinueBtn();
				break;
			case "EndSession":
				waitForSeconds(5);
				element = TP.getEndSessionBtn();
//				context.getDsaDmData().setSkConsent("N");
				System.out.println("Clicked on EndSession");
				break;
			case "VerifyNowPopup":
				waitForSeconds(5);
				element = TP.getVerifyNowPopupBtn();
//				context.getDsaDmData().setSkConsent("N");
				System.out.println("Clicked on Verify Now popup");
				break;
			}
			clickElement(element);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on "+fieldName+"button");
		}
	}
	
	@And("User on Thank you Page Verifies {string} text should be {string}")
	public void verifyText(String fieldName, String _text) throws Exception {
		try {
			String expText=getInputText(_text);
			WebElement element = null;
			
			switch (fieldName) {
			case "DIITitle":
				element = TP.getApprovedDIITitle();
				break;
			case "ApprovedTitle":
				element = TP.getApprovedTitle();
				break;
			case "PendingTitle":
				element = TP.getPendingTitle();
				break;
			case "LegalFooter":
				element = TP.getLegalFooter();
				getText(TP.getLegalFooter()).contains("Interac and the Interac logo are trademarks of Interac Corp. Used under licence.");
				break;
			case "AcceptedIDList":
				waitForSeconds(3);
				element = TP.getSKContent();
				expText = getInputText("dd:normalized:DSA-IBM-SECURE-KEY-CONTENT-01")+expText;
				break;
			case "LoyaltyLang":
				waitForSeconds(10);
				waitForSeconds(10);
				waitForSeconds(10);
				waitForSeconds(10);
				waitForSeconds(10);
//				waitForSeconds(7);
//				waitForVisible(TP.getNextStepText());
				element = TP.getNextStepText();
				break;
			case "LoyaltyLang_Approved":
				waitForSeconds(10);
				waitForSeconds(10);
				waitForSeconds(10);
				waitForSeconds(10);
//				waitForSeconds(10);
//				waitForVisible(TP.getNextStepText());
				element = TP.getNextStepText_approved();
				break;
			case "EcommPendingLoyaltyLang":
				waitForSeconds(10);
				waitForSeconds(10);
				waitForSeconds(10);
				waitForSeconds(10);
//				waitForSeconds(10);
//				waitForVisible(TP.getNextStepText());
				element = TP.getNextStepTextEcommPending();
				break;
			
			}
			System.out.println("expected text "+expText);
			validateText(element, expText);
			
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify text "+fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Thank you Page Verifies Legal Footer Notes")
	public void verifyFooterLegal() throws Exception {
		try {
			if(context.getLanguage().startsWith("E"))
				getText(TP.getLegalFooter()).contains("Interac and the Interac logo are trademarks of Interac Corp. Used under licence.");
			else
				getText(TP.getLegalFooter()).contains("Interac et le logo Interac sont des marques de commerce d'Interac Corp. Utilisées sous licence.");
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify text ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Thank you Page Verifies {string} image")
	@And("User on Thank you Page Verifies {string}")
	public void verifyImage(String fieldName) {
		try {
			Thread.sleep(20000);
			WebElement element = null;
			switch(fieldName) {
				case "DIICardImage":
					element = TP.getApprovedDIICardImg();
					break;
				case "DIICreditLimit":
					element = TP.getApprovedDIICreditLimit();
					break;
				case "DIIAnnualInterestRate":
					element = TP.getApprovedDIIAnnualInterestRate();
					break;
				case "ApprovedCardImage":
					element = TP.getApprovedCardImg();
					break;
				case "ApprovedCreditLimit":
				case "ApprovedCreditLimitLabel":
					waitForSeconds(1);
					element = TP.getApprovedCreditLimit();
					break;
				case "ApprovedAnnualInterestRate":
					element = TP.getApprovedAnnualInterestRate();
					break;
				case "PendingCardImage":
					element = TP.getPendingCardImg();
					break;
				case "PendingIcon":
					element = TP.getPendingIcon();
					break;
				case "ReqCreditAmount":
					waitForSeconds(1);
					element = TP.getReqCreditAmount();
					break;
				case "ReqCreditLabel":
					waitForSeconds(2);
					element = TP.getReqCreditLimitLabel();
					break;
				case "VerifyNowInterac":
					element = getElementWhenVisible(By.xpath(getXpath(TP.getVerifyNowBtn())+"/img"));
					break;
			}
			waitForVisible(element);
		}
		catch(Exception e) {
			Assert.fail("Failed to verify "+fieldName);
			e.printStackTrace();
		}
		
	}
	
	@And("User is on Thank You Page after submitting mock screen for passed application")
	public void verifyThankPage() {
		try
		{
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nextSubtitle))));
			Thread.sleep(19000);
			
			if(!isElementVisible(TP.getApprovedTitle())) {
				Assert.fail("\n 1) Failed to validate Thank you page after mock screen \n");
			}
			else
				System.out.println(" Thank you page validated after Mock Screen \n");
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate Thank you page : Passed Application");
			
		}
	}
	
	@And("User is on Thank You Page after submitting mock screen with Expired ID")
	public void verifyPage() {
		try
		{
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nextSubtitle))));
			Thread.sleep(20000);
			if(!isElementVisible(TP.getPendingImg())) {
				Assert.fail("\n 2) Failed to validate Thank you page after mock screen \n");
			}
			else
				System.out.println(" Thank you page validated after Mock Screen \n");
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate Thank you page : Expired ID");
			
		}
	}
	
	@And("User is on Thank You Page after submitting mock screen with different details")
	public void verifyTYPage() {
		try
		{
			Thread.sleep(25000);
			if(!isElementVisible(TP.getPendingImg())) {
				Assert.fail("\n 3) Failed to validate Thank you page after mock screen \n");
			}
			else
				System.out.println(" Thank you page validated after Mock Screen \n");
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate Thank you page : different details");
			
		}
	}
	
	@And("User on Thank You Page verifies requested credit limit")
	public void verifyCreditLimit() {
		try
		{
			waitForSeconds(4);
			waitForVisible(TP.getReqCreditAmount());
			String crLimit="";
			crLimit=TP.getReqCreditAmount().getText();
			DSA_DM dsaDM = context.getDsaDmData();
			if (dsaDM.getLanguage().contains("E"))
				crLimit = crLimit.replaceAll("[.]00", "").replaceAll("[$, ]", "");
			else
				crLimit = crLimit.replaceAll("[,.]00", "").replaceAll("[$, ]", "");
			System.out.println("Req Credit Limit :" + TP.getReqCreditAmount().getText());
			System.out.println("Dsa req Credit Limit :" + dsaDM.getCreditLimit() + "\n");
			Assert.assertEquals(crLimit,dsaDM.getCreditLimit(),"Failed to validate requested Credit Limit : Not matching on Thank You Page");
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate Thank you page : Credit Limits amounts");
			
		}
	}

}
