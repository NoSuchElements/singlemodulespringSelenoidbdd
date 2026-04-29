package com.nosuchelements.steps.dsa;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.constants.Constants.Language;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.CreditProtectorPage;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CreditProtectorStepDef extends BasePage {
	
	@Autowired
	private CreditProtectorPage CP;
	ArrayList<String> tabs;
	
	@Autowired
	private CommonUtils commutil;

	@And("User Validates Credit Protection with Insrance as {string}")
	public void verifyCreditProtection(String type)
	{
		try
		{
			CP.creditProtection(context.getDsaDmData(), type);
		}catch(Exception e) {
			Assert.fail("Failed to Credit Protection");
			e.printStackTrace();
		}
	}
	
	@And("User is on Credit Protection Insurance Page")
	public void verifyCPI() {
		DSA_DM updatedDetails = context.getDsaDmData();
		try
		{
			Thread.sleep(3000);
			commutil.validate(context.getDsaDmData().getCardType());
			updatedDetails.setCPIType(CP.getCpiSubTitle().getText());
			context.setDsaDmData(updatedDetails);
			CP.validate();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate Credit Protection Insurance Page");
			
		}
	}
	
	@And("User on Credit Protection Insurance Page Clicks on {string} checkbox")
	@And("User on Credit Protection Insurance Page Clicks on {string} button")
	@And("User on Credit Protection Insurance Page Clicks on {string} Link")
	public void clickOnElement(String fieldName) throws Exception {
		WebElement element = null;
		try
		{
			DSA_DM updatedDetails = context.getDsaDmData();
			switch (fieldName) {
			case "Yes":
				element = CP.getYesShowMe();
				updatedDetails.setCPIEnroll("Y");
				break;
			case "No":
				element = CP.getNoThanks();
				updatedDetails.setCPIEnroll("N");
				break;
			case "Next":
				element = CP.getNextBtn();
				break;
			case "TermsAndConditions":
				element = CP.getLegalCheckbox();
				break;
			case "AssurantsPolicy":
				element = CP.getAssurantCheckbox();
				break;
			case "Howmuch":
				element = CP.getHowmuchLink();
				break; 
			case "HowCancel":
				element = CP.getHowtoCancelLink();
				break;
			case "SummaryLink":
				element = CP.getSummaryLink();
				break;
			case "Summary_English":
				element = CP.getSummaryLink_English();
				break;
			case "Summary_French":
				element = CP.getSummaryLink_French();
				break;
			case "FactsheetLink":
				Thread.sleep(1000);
				element = CP.getFactSheetLinkROC();
				break;
			case "Factsheet_English":
				element = CP.getFactSheetLink_English(); //QC
				break; 
			case "Factsheet_French":
				element = CP.getFactSheetLink_French();  //QC
				break;
			case "CertOfInsurance": //QC eng
				element = CP.getCertOfInsurance();
				break;
			case "COI_English_QC":
				element = CP.getCOI_English_QC();
				break; 
			case "COI_English":
				element = CP.getCOI_English_ROC();
				break;
			case "COI_Frc":
				element = CP.getCOI_Frc();
				break;
			case "SaveorPrint":
				element = CP.getSummary_SaveorPrint();
				break;
			case "COI_French":
				Thread.sleep(3000);
				element = CP.getCOI_French();
				break;	
			case "BackToReview":
				element = CP.getCpEditNext();
				break; 
			case "GotIt":
				waitForSeconds(5);
				element=CP.getGotItBtn();
				break;
			}
			clickElement(element);
			Thread.sleep(5000);
			System.out.println("\n CLICKED on CP page element : "+fieldName);
			context.setDsaDmData(updatedDetails);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to click on " + fieldName );
			throw new Exception(e);
		}
	}
	
	@And("User on Credit Protection Insurance Page Verifies the Inline Error Message for {string} Field as {string} in {string} Colour")
	public void verifyerror(String fieldName, String _text, String colour) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "Selection":
				element = CP.getSelectionErrorMessage();
				break;
			case "TermsandConditions":
				element = CP.getTermsError();
				break;
			case "AssurantsPolicy":
				element = CP.getAssurantError();
				break;
			}
			verifyErrorMessage(element, expText, colour);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Inline Error Message for " + fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Credit Protection Insurance Page Verifies {string} link")
	@And("User on Credit Protection Insurance Page Verifies {string} checkbox")
	@And("User on Credit Protection Insurance Page Verifies {string} button")
	public void verifyfield(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "Yes":
				element = CP.getYesShowMe();
				break;
			case "No":
				element = CP.getNoThanks();
				break;
			case "next":
				element = CP.getNextBtn();
				break;
			case "TermsAndConditions":
				element = CP.getLegalCheckbox();
				break;
			case "Howmuch":
				element = CP.getHowmuchLink();
				break; 
			case "HowCancel":
				element = CP.getHowtoCancelLink();
				break;
			case "SummaryLink":
				element = CP.getSummaryLink();
				break;
			case "Summary_English":
				element = CP.getSummaryLink_English();
				break;
			case "Summary_French":
				element = CP.getSummaryLink_French();
				break;
			case "Toggle":
				element = CP.getSummaryToggle();
				break;
//			case "FactsheetLink":
//				element = CP.getFactSheetLink();
//				break;
			case "Factsheet_English":
				element = CP.getFactSheetLink_English();
				break; 
			case "Factsheet_French":
				element = CP.getFactSheetLink_French();
				break;
			case "CertOfInsurance":
				element = CP.getCertOfInsurance();
				break;
			case "COI_English_QC":
				element = CP.getCOI_English_QC();
				break; 
			case "COI_English_ROC":
				element = CP.getCOI_English_ROC();
				break;
			case "SaveorPrint":
				element = CP.getSummary_SaveorPrint();
				break;
			case "COI_French":
				element = CP.getCOI_French();
				break;	
			case "Next":
				element = CP.getNextBtn();
				break;
			}
			if (!isElementVisible(element)) {
				System.out.println("Element not visible");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to Validate visibility of" + fieldName);
			throw new Exception(e);
		}
	}
	
	@And("User on Credit Protection Insurance Page Verifies {string} label should be {string}")
	@And("User on Credit Protection Insurance Page Verifies {string} text should be {string}")
	@And("User on Credit Protection Insurance Page Verifies {string} header should be {string}")
	public void verifyMessage(String fieldName, String message) throws Exception {
		message = getInputText(message);
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "Header":
				element = CP.getCpiHeader();
				break;
			case "SubTitle":
				element = CP.getCpiSubTitle();
				break;
			case "Yes":
				element = CP.getYesShowMe();
				break;
			case "No":
				element = CP.getNoThanks();
				break;
			case "SummaryHeader":
				element = CP.getSummaryHeader();
				break;
			case "SummaryHeaderOMXFrc":
				element = CP.getSummaryHeaderOMXFrc();
				break;
			case "TermsandConditions":
				element = CP.getTnCText();
				break;
			case "AssurantPolicy":
				element = CP.getAssurantPolicy();
				break;
			case "TnC_Para1":
				element = CP.getTnCText_Para1();
				break;
			case "TnC_Para2":
				element = CP.getTnCText_Para2();
				break;
			case "LegalFootnotes":
				element = CP.getLegalFooternotes();
				CP.getLegalFootNotesExpand().click();
				break;	
			}
			validateText(element, message);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify " + fieldName + " text should be " + message +"on CP page");
			throw new Exception(e);
		}
	}
	
	@And("User on Credit Protection Insurance Page Verifies mandatory field {string} text should be {string}")
	public void verifyMandatoryMessage(String fieldName, String message) throws Exception {
		message = getInputText(message);
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "TermsandConditions":
				element = CP.getTnCText();
				validateText(element.getText(),message,true);
				break;
			case "EngTermsandConditionsROC":
				element = CP.getTnCText();
				if(CP.getCpiSubTitle().getText().contains("Complete")) {
					validateText(element.getText(),message+getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-138-A"),true);
				}
				else
					validateText(element.getText(),message+getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-138-B"),true);
				break;
			case "AssurantPolicy":
				element = CP.getAssurantPolicy();
				validateText(element.getText(), message+getInputText("dd:normalized:DSA-IBM-REQ"),true);
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate mandatory field text for "+fieldName);
			throw e;
		}
	}
	
	@And("User on Credit Protection Insurance Page Verifies {string} text should be {string} in {string}")
	public void verifyMessage(String fieldName, String key, String lang) throws Exception {
		WebElement element = null;
		String message = null;
		try
		{
			switch (fieldName) {
				case "SummaryHeader":
					element = CP.getSummaryHeader();
					break;
				case "SummaryText":
					element = CP.getSummaryText();
					break;	
			}
			if(lang.equals("French")) {
				message = getInputText(key,Language.French);
				System.out.println("message found for "+lang+ "is "+message);
			}
				
			else
				message = getInputText(key,Language.English);
			
			validateText(element, message);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify " + fieldName + " text should be " + message);
		}
	}
	
	@And("User on Credit Protection Insurance Page Verifies the Inline Error Message for {string} Field should not be displayed")
	public void verifyErrorNotDisplayed(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "Selection":
				element = CP.getSelectionErrorMessage();
				break;
			case "TermsandConditions":
				element = CP.getTermsError();
				break;
				
			}
			if (isElementVisible(element)) {
				Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
			}
			;
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
			throw new Exception(e);
		}
	}
	
	@And("User on Credit Protection Insurance Page Verifies {string} Field should not be displayed")
	@And("User on Credit Protection Insurance Page Verifies {string} Link should not be displayed")
	public void verifyFieldNotDisplayed(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "Summary_English":
				element = CP.getSummaryLink_English();
				break;
			case "Summary_French":
				element = CP.getSummaryLink_French();
				break;
			case "Factsheet_English":
				element = CP.getFactSheetLink_English();
				break; 
			case "Factsheet_French":
				element = CP.getFactSheetLink_French();
				break;
			case "COI_English_QC":
				element = CP.getCOI_English_QC();
				break; 
			case "COI_English_ROC":
				element = CP.getCOI_English_ROC();
				break;
			case "SaveorPrint":
				element = CP.getSummary_SaveorPrint();
				break;
			case "COI_French":
				element = CP.getCOI_French();
				break;
			case "toggle":
				element = CP.getSummaryToggle();
				break;
				
			}
			if (isElementVisible(element)) {
				Assert.fail("Failed to verify " + fieldName + " is not displayed");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
			throw new Exception(e);
		}
	}
	
	@And("User on Credit Protection Insurance Page Toggle {string} in {string} popup")
	public void selectToggle(String option, String window) {
	 try {
		switch(window) {
			case "Summary":
				waitForVisible(CP.getSummaryHeader());
				CP.getSummaryToggle().click();
				Thread.sleep(3000);
				break;
		}
	 }
	 catch(Exception e) {
		 e.printStackTrace();
			Assert.fail("Failed to Toggle "+window+"in Credit Protector Page");
		}
	}
	
	@And("User on Credit Protection Insurance Page Accepts popup with header {string}")
	public void acceptPopup(String popupHeaderText) throws Exception {
		try {
//			String popupHeaderXpath = "//h1[@id='ngdialog2-aria-labelledby']";
			log.info("Attempting to Accept popup");
			try {
//				log.info("Attempting to Accept popup");
					
//					expectedTitle = getInputText(popupHeaderText);
//					driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
//					pageTitle();
				
			} catch (Exception e) {
				log.info("Page validation failed.");
				e.printStackTrace();
			}
//			validateText(CP.getSummaryHeader(), getInputText(popupHeaderText));
//			clickElement(CP.getGotIt());
//			scrollIntoView(driverManager.getWebDriver().findElement(By.xpath("//*[@id='cp-coc-agree-terms']")));
			scrollIntoView(driverManager.getDriver().findElement(By.xpath("//p[@class='ModalLegal_title']")));
			System.out.println("Scrolled to last point");
			if(CP.getGotIt().isEnabled()) {
				Thread.sleep(2000);
				clickElement(CP.getGotIt());
				waitForSeconds(10);
			}
			else
				Assert.fail("GotIt Button is not Enabled");
		} catch (Exception e) {
			log.info("Caught error attempting to accept");
			e.printStackTrace();
			Assert.fail(" Failed at GOT IT button enable \n");
			throw e;
		}
	}
	
	@And("User on Credit Protection Insurance Page Accepts EligiblePlan popup")
		public void acceptPlanPopup() throws Exception {
			try {
				System.out.println(" Accepting Pop Up : Eligible for : Triangle Credit Protector Life and Disability \n");
				clickElement(CP.getGotItBtn());
				Thread.sleep(2000);
				driverWait.getDriverWait().until(ExpectedConditions.invisibilityOf(CP.getGotItBtn()));
			}catch(Exception e) {
				throw e;
			}
	}
	
	@When("User on CPI page Scrolls to the bottom of {string} Field")
	public void scrollDown(String ele)throws Exception
	{
		try {
			switch (ele) {
			case "Summary":
//				if(context.getDsaDmData().getLanguage().startsWith("E"))
					try {
					System.out.println("\n Scrolled \n");
					 if(driverManager.isMobile()) {
						JavascriptExecutor jsx = (JavascriptExecutor)driverManager.getDriver();
						waitForSeconds(6);
						jsx.executeScript("document.getElementById('scrollable-content').scrollTo({top:7000,left:0});", "");					  	
	                }
					 else
							scrollIntoView(driverManager.getDriver().findElement(By.xpath("//div[@data-ng-controller='CPCostDialogController as cpCostDialog']//ul//li/p[contains(text(),'www.assurant.ca')]")));
     					 	Thread.sleep(2000);
					}catch(Exception e) {
						e.printStackTrace();
						throw e;
					}
//					else
//					scrollIntoView(driverManager.getWebDriver().findElement(By.xpath("//div[@id='scrollable-content']//ul//li/p[contains(text(),'confidential')]")));
//				scrollIntoTandCTextBox();
				break;
			case "Factsheet":
				scrollIntoView(driverManager.getDriver().findElement(By.xpath("//div[@id='scrollable-content']//ul//li[12]")));
//				scrollIntoTandCTextBox();
				break;
			}
		}catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to Scrolls to the bottom of "+ele+" Field");
			throw new Exception(e);
		}	
	}
	
	@And("User is on Credit Protection Insurance Page verifies {string} PDF in New Tab")
	public void verifyNewTab(String page) throws Exception {
		
		try {
			Thread.sleep(3000);
			String activeWindow;
			tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
			if(context.getDsaDmData().getChannel().equals("WP")) 
				activeWindow = tabs.get(2);
			else
				 activeWindow = tabs.get(1);
			driverManager.getDriver().switchTo().window(activeWindow);
			System.out.println("CurrentURL: "+driverManager.getDriver().getCurrentUrl());
//			driverWait.getDriverWait().until(ExpectedConditions.titleContains("pdf"));
			String currUrl = driverManager.getDriver().getCurrentUrl();   
			String stripText=" ";
			switch(page) {
					case "COI_Eng":
//						if(!currUrl.contains("Cert")) 
//						Assert.fail("Failed to verify Certificate of Insurance PDF Page");
									stripText = CP.pdfFetch("COIEnglish");
									System.out.println("\n Fetched data. Staring to validate Eng content... \n");
									CP.pdfValidate(stripText,"COIEng");
									System.out.println("\n Address validated on COI \n");
									Thread.sleep(4000);
									break;
					case "COI_Frc":
								   System.out.println("\n Fetching Frc COI text..\n");
								   stripText = CP.pdfFetch("COIFrench");
								   System.out.println("\n Fetched data. Staring to validate Frc address content... \n");
								   CP.pdfValidate(stripText,"COIFrc");
									System.out.println("\n Address validated on COI Frc \n");
									Thread.sleep(4000);
								   break;
					case "FactSheet_Eng":
//						if(!currUrl.contains("Summary")) 
//							Assert.fail("Failed to verify Factsheet PDF Page");
							stripText = CP.pdfFetch("SummFactSheetEnglish");
							System.out.println("\n Fetched data. Staring to validate Eng content Summary Factsheet... \n");
							CP.pdfValidate(stripText,"SummFactSheetEng");
							break;
					case "FactSheet_Frc":
							stripText = CP.pdfFetch("SummFactSheetFrench");
							System.out.println("\n~~~ Fetched data. Staring to validate French content Summary Factsheet ~~~ \n");
							CP.pdfValidate(stripText,"SummFactSheetFrc");
							break;
					case "SummaryOfCoverage_FR":
						stripText = CP.pdfFetch("SummaryOfCoverageFR");
						System.out.println("Current Url: "+currUrl);
						if(currUrl.contains("SummaryofCoverage") && currUrl.contains("0725_FR"))
							System.out.println("Latest Summary Of Coverage for French is found");
						else
							Assert.fail("Summary Of Coverage is not matched");
						CP.pdfValidate(stripText,"SummaryOfCoverageFr");
						break;
					case "SummaryOfCoverage_EN":
						stripText = CP.pdfFetch("SummaryOfCoverageEN");
						System.out.println("Current Url: "+currUrl);
						if(currUrl.contains("SummaryofCoverage") && currUrl.contains("0725_EN"))
							System.out.println("Latest Summary Of Coverage for English is found");
						else
							Assert.fail("Summary Of Coverage is not matched");
						CP.pdfValidate(stripText,"SummaryOfCoverageEn");
						break;
					case "SaveOrPrint":
//						String activeWindow;
//						tabs = new ArrayList<String>(driverManager.getWebDriver().getWindowHandles());
//						if(context.getDsaDmData().getChannel().equals("WP")) 
//							activeWindow = tabs.get(tabs.size()-1);
//						else
//							 activeWindow = tabs.get(tabs.size()-1);
//						driverManager.getWebDriver().switchTo().window(activeWindow);
//						System.out.println("CurrentURL: "+driverManager.getWebDriver().getCurrentUrl());
////						driverWait.getDriverWait().until(ExpectedConditions.titleContains("pdf"));
//						String currUrl = driverManager.getWebDriver().getCurrentUrl(); 
						System.out.println("URL from new tab: "+currUrl);
							try {
								if(!currUrl.contains("Summary"))
									System.out.println("Match found for English Summary");
								else if(!currUrl.contains("Sommaire"))
									System.out.println("Match found for French Summary");
								else
									System.out.println("Match not found for Summary");
							}catch (Exception e) {
								log.error("An error occurred: {}", e.getMessage(), e);
								e.printStackTrace();
								Assert.fail("Failed to verify "+page+" PDF Page");
								throw new Exception(e);
							}
							break;
				}
			}catch (Exception e) {
				log.error("An error occurred: {}", e.getMessage(), e);
				e.printStackTrace();
				Assert.fail("Failed to verify "+page+" PDF Page");
				throw new Exception(e);
			}
	}
	
	// validates only ~the trade name of ~ line on the popup
	@And("User validates updated text on {string} modal")
	public void validatePDFonCP(String sheet) {
		try {
			System.out.println(" Inside Summary of Cov modal \n");
			switch(sheet) {
					case "SummAssuranceText_Eng":
							System.out.println(" Summ Assu Text"+CP.getSummAssurantText().getText()+"\n");
							Assert.assertTrue(CP.getSummAssurantText().getText().contains("the trade name of Assurant"));
							System.out.println("~~ 1) SummAssurantText Eng passed");
						    break;
					case "SummAssuranceROC_Frc":
							System.out.println(" Summ Assu Text"+CP.getSummAssurantTextROCfr().getText()+"\n");
							Assert.assertTrue(CP.getSummAssurantTextROCfr().getText().contains("la dénomination sociale Assurant"));
							System.out.println("1) SummAssurantText Frc ROC passed ** ");
						    break;
					case "SummAssuranceQC_Eng":
							System.out.println(" Summ Assu Text"+CP.getSummAssurantTextQCEng().getText()+"\n");
							Assert.assertTrue(CP.getSummAssurantTextQCEng().getText().contains("the trade name of Assurant"));
							System.out.println("i) SummAssurantText passed");
						    break;
					case "SummAssuranceQC_Frc":
							System.out.println("Verifying Assurant Text QC Eng app, Frc modal ");
							System.out.println(" Summ Assu Text"+CP.getSummAssurantTextQCEng().getText()+"\n");
							Assert.assertTrue(CP.getSummAssurantTextQCEng().getText().contains("dénomination sociale Assurant"));
							System.out.println("i) SummAssurantText passed in QC Eng app, Frc modal");
					case "SummaryOfCoverage_Frc":
						System.out.println(" Summary Of Coverage Text: "+CP.getSummaryOfCoverageModalText().getText()+"\n");
//						Assert.assertTrue(CP.getSummaryOfCoverageModalText().getText().contains("the trade name of Assurant"));
						Assert.assertTrue(CP.getSummaryOfCoverageModalText().getText().contains("Vous comprenez que si vous avez fait une fausse déclaration d’âge et que vous étiez âgé de moins de 18 ans ou de 75 ans ou plus au moment de l’adhésion, la responsabilité de l'Assureur se limitera à un remboursement de toutes les primes payées (y compris les taxes applicables)"));
						System.out.println("i) SummAssurantText passed");
					    break;
					case "SummaryOfCoverage_Eng":
						System.out.println("Verifying Assurant Text QC Eng  modal ");
						System.out.println(" Summ Assu Text"+CP.getSummaryOfCoverageModalText().getText()+"\n");
						Assert.assertTrue(CP.getSummaryOfCoverageModalText().getText().contains("You understand that if You misstated Your age and were under the age of 18 or 75 years of age or over at time of enrollment the Insurer's liability is limited to a refund of all premiums (including applicable taxes)"));
						System.out.println("Summary Of Coverage modal validation Passed");
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	@And("User validates updated text on {string} modal or pdf")
	public void validatePDF(String sheet) {
		try {
			System.out.println(" Inside Summary of Coverage modal \n");
			String text ="";
			String dd = "";
			switch(sheet) {
			case "SummaryOfCoverage":
				    if(CP.getSummAddressClaimProcedures().getText().contains(getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-108")))
						System.out.println("2) Claim Procedure validation passed");
					else
						Assert.fail("Claim Procedure validation failed \n");
				
					scrollIntoView(CP.getSummaryClaimtext());
					
					text = CP.getSummaryClaimtext().getText();
					text=text.replaceAll("[\\n\\t\\r ]", "");
				    System.out.println(" Summ Claim Text : "+text+"\n");
				    
				    dd = getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-109").replaceAll("[\\n\\t\\r ]", "");
				    System.out.println("Data Dic : "+dd);
					if(text.contains(dd))
						System.out.println("3) Summary claim text validation passed");
					else
						Assert.fail("Summary claim text failed \n");
					
					scrollIntoView(CP.getSummAssurantThirdBulletText());
					
					text = CP.getSummAssurantThirdBulletText().getText().replaceAll("[\\n\\t\\r ]", "");
					dd = getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-126").replaceAll("[\\n\\t\\r ]", "");
					
					System.out.println("Third bullet : "+text);
					System.out.println("DD : "+dd);
					if(text.contains(dd))
						System.out.println("4) Third Bullet validation passed");
					else
						Assert.fail("Third Bullet validation failed \n");
					
					text = CP.getSummAssurantLastbulletText().getText().replaceAll("[\\n\\t\\r ]", "");
					dd = getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-136").replaceAll("[\\n\\t\\r ]", "");
					
					if(text.contains(dd))
						System.out.println("5) Last Bullet validation passed");
					else
						Assert.fail("Last Bullet validation failed \n");  
			break;
			case "SummaryOfCoverageQCEng":
					if(CP.getSummAddressClaimProceduresQCEng().getText().contains(getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-108-FRENCH")))
						System.out.println("ii) Claim Procedure validation Frc passed");
					else
						Assert.fail("Claim Procedure validation failed Frc \n");
				
					scrollIntoView(CP.getSummaryClaimtextQCEng());
					
					text = CP.getSummaryClaimtextQCEng().getText();
					text=text.replaceAll("[\\n\\t\\r ]", "");
				    System.out.println(" Summ Claim Text QC: "+text+"\n");
				    
				    dd = getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-109-FRENCH").replaceAll("[\\n\\t\\r ]", "");
				    System.out.println("Data Dic : "+dd);
					if(text.contains(dd))
						System.out.println("iii) Summary claim text Frc validation passed");
					else
						Assert.fail("Summary claim text Frc failed \n");
					
					scrollIntoView(CP.getSummAssurantThirdBulletQCEng());
					
					text = CP.getSummAssurantThirdBulletQCEng().getText().replaceAll("[\\n\\t\\r ]", "");
					dd = getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-126-FRENCH").replaceAll("[\\n\\t\\r ]", "");
					
					System.out.println("Third bullet : "+text);
					System.out.println("DD : "+dd);
					if(text.contains(dd))
						System.out.println("iv) Third Bullet validation Frc passed");
					else
						Assert.fail("Third Bullet validation Frc failed \n");
					
					text = CP.getSummAssurantLastbulletQCEng().getText().replaceAll("[\\n\\t\\r ]", "");
					dd = getInputText("dd:normalized:DSA-IBM-CREDIT-PROTECTOR-136-FRENCH").replaceAll("[\\n\\t\\r ]", "");
					
					if(text.contains(dd))
						System.out.println("v) Last Bullet validation Frc passed");
					else
						Assert.fail("Last Bullet validation Frc failed \n");  
				break;
			}//switch 
		}catch (Exception e) {
					log.info("Updated text validation on modal/pdf Frc failed \n");
					e.printStackTrace();
					Assert.fail(" Summary of Coverage validation Frc failed *****");
				}
	}
	
	
	@And("User on Credit Protection Insurance Page closes new Tab")
	public void closenewTab() throws Exception {
		try {
		String activeWindow;
		
//		driverManager.getWebDriver().switchTo().window(activeWindow);
		driverManager.getDriver().close();
		tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
		activeWindow = tabs.get(tabs.size()-1);
//		Thread.sleep(5000);
		System.out.println("No of Tabs"+tabs.size());
		if(context.getDsaDmData().getChannel().equals("WP")) {
			System.out.println("Switching in Ecom tab for CP page");
			driverManager.getDriver().switchTo().window(activeWindow);
		}
		else {
			System.out.println("Switching in NonEcom tab for CP page");
			driverManager.getDriver().switchTo().window(activeWindow);
		}
	} catch (Exception e) {
		log.error("An error occurred: {}", e.getMessage(), e);
		e.printStackTrace();
		Assert.fail("Failed to Close New Tab");
		throw new Exception(e);
	}
 }
	
}
	
	
