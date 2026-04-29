package com.nosuchelements.steps.dsa;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.DashEnrollPage;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class DashEnrollStepDef extends BasePage {
	
	@Autowired
	private DashEnrollPage DEP;
	
	@Autowired
	private CommonUtils commutil;
	
	@And("User is on MOA Enrollment Page")
	public void verifyMOAEnrollPage() {
		try
		{
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(nextSubtitle))));
			commutil.validate(context.getDsaDmData().getCardType());
			waitForSeconds(5);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate MOA Enrollment page");
			
		}
	}
	
	@And("User is on DASH Login Page")
	public void verifyDashLoginPage() {
		try
		{
			DEP.validate();
			waitForSeconds(5);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate DASH login page");
			
		}
	}
	
	
	
	@And("User on MOA Enrollment Page Clicks on {string} button")
	@And("User on MOA Enrollment Page Clicks on {string} link")
	@And("User on MOA Enrollment Page Clicks on {string} checkbox")
	public void clickElement(String fieldName) {
		try {
			WebElement element = null;
			switch(fieldName) {
			case "SetupNow":
				element = DEP.getSetupNowBtn();
				break;
			case "SetupLater":
				element = DEP.getSetupLaterBtn();
				break;
			case "Done":
				element = DEP.getDoneBtn();
				break;
			case "TnCLink":
				element = DEP.getTnCLink();
				break;
			case "PrivacyPolicy":
				element = DEP.getPrivacyPolicyLink();
				break;
			case "PrivacyCharter":
				element = DEP.getPrivacyCharterLink();
				break;
			case "PrivacyCharterChkbox":
				element = DEP.getPrivacyCharterCheckbox();
				break;
			case "MyOnlineAccount":
				element = DEP.getMyOnlineAcct_ConfirmPage();
				break;
			case "Done_ConfirmPage":
				element = DEP.getDoneBtn_ConfirmPage();
				break;
			case "TnCCheckbox":
				element = DEP.getTnCCheckbox();
				break;
			case "PCToggle":
				element = DEP.getPrivacyCharterToggle();
				break;
			case "GotIt":
				waitForSeconds(3);
				element = DEP.getGotIt();
				waitForSeconds(5);
				break;
			}
			clickElement(element);
			System.out.println("Clicked on "+fieldName);
		}
		
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on "+fieldName+"button");
		}
	}
	
	@And("User on MOA Enrollment Page Verifies {string} text should be {string}")
	public void verifyText(String fieldName, String _text) throws Exception {
		try {
			String expText=getInputText(_text);
			WebElement element = null;
			
			switch (fieldName) {
			case "Header_Enroll":
				element = DEP.getPageHeader();
				break;
			case "SubTitle_Enroll":
				element = DEP.getPageSubTitle();
				break;
			case "Paragraph":
				element = DEP.getParagraph();
				break;
			case "SetupNow":
				element = DEP.getSetupNowBtn();
				break;
			case "SetupLater":
				element = DEP.getSetupLaterBtn();
				break;
			case "Header_LoginPage":
				element = DEP.getPageHeader();
				break;
			case "UsernameInfo":
				element = DEP.getUserNameInfo();
				break;
			case "PasswordInfo":
				element = DEP.getPasswordInfo();
				break;
			case "TnCText":
				element = DEP.getTnCText();
				break;
			case "FrenchDisclaimer":
				element = DEP.getTnCTextPara1();
				break;
			case "EnglishDisclaimer":
				expText=expText+getInputText("dd:normalized:DSA-IBM-REQ");
				element = DEP.getTnCTextPara2();
				break;
			case "PCHeader":
				element = DEP.getPrivacyCharterHeader();
				break;
			case "Header_Confirm":
				Thread.sleep(5000);
				Thread.sleep(5000);
				Thread.sleep(5000);
				Thread.sleep(5000);
				element = DEP.getPageHeader_ConfirmPage();
				break;
			case "SubTitle_Confirm":
				element = DEP.getSubTitle_ConfirmPage();
				break;
			
			}
			System.out.println("\n expected text "+expText);
			System.out.println("\n Element Text: "+element.getText());
			validateText(element, expText);
			
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify text "+fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on MOA Enrollment Page Verifies {string} text should be {string} and {string}")
	public void verifyMultipleText(String fieldName, String key1, String key2) throws Exception {
		try {
			String expText=getInputText(key1)+getInputText(key2); //+getInputText("dd:normalized:DSA-IBM-REQ");
			WebElement element = null;
			if(!context.getDsaDmData().getProvince().contains("QC"))
				expText=expText+getInputText("dd:normalized:DSA-IBM-REQ");
			switch (fieldName) {
			case "TnCText":
				element = DEP.getTnCText();
				break;
			case "PrivacyCharterText":
				element = DEP.getPrivacyCharterText();
				break;
			}
				System.out.println("\n expected text: "+expText);
				validateText(element, expText);
				
			} catch (Exception e) {
				log.error("An error occurred: {}", e.getMessage(), e);
				Assert.fail("Failed to verify text "+fieldName);
				e.printStackTrace();
				throw new Exception(e);
			}
		}
	@And("User on MOA Enrollment Page Verifies {string} field")
	@And("User on MOA Enrollment Page Verifies {string} button")
	@And("User on MOA Enrollment Page Verifies {string} checkbox")
	public void verifyField(String fieldName) {
		try {
			WebElement element = null;
			switch(fieldName) {
			case "SetupNow":
				element = DEP.getSetupNowBtn();
				break;
			case "SetupLater":
				element = DEP.getSetupLaterBtn();
				break;
			case "Done":
				element = DEP.getDoneBtn();
				break;
			case "TnCLink":
				element = DEP.getTnCLink();
				break;
			case "PrivacyPolicy":
				element = DEP.getPrivacyPolicyLink();
				break;
			case "PrivacyCharter":
				element = DEP.getPrivacyCharterCheckbox();
				break;
			case "MyOnlineAccount":
				element = DEP.getMyOnlineAcct_ConfirmPage();
				break;
			case "Done_ConfirmPage":
				element = DEP.getDoneBtn_ConfirmPage();
				break;
			case "AppleImg":
				element = DEP.getAppleImg_ConfirmPage();
				break;
			case "GoogleImg":
				element = DEP.getGoogleImg_ConfirmPage();
				break;
			case "TnCCheckbox":
				element = DEP.getTnCCheckbox();
				break;
			case "Username":
				element = DEP.getUserNameTxt();
				break;
			case "Password":
				element = DEP.getPasswordTxt();
				break;
			case "RepeatPassword":
				element = DEP.getReenterPasswordTxt();
				break;
			}
			waitForVisible(element);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to verify "+fieldName);
		}
		
	}
	
	@And("User on MOA Enrollment Page Enters {string} in {string} Field")
	public void enterValues(String type, String field) throws Exception {
		WebElement element = null;
		try {
			DSA_DM updatedDetails =context.getDsaDmData()!=null?context.getDsaDmData(): new DSA_DM(); 
//			DSA_DM updatedDetails = context.getDsaDmData();
			switch (field) {

				case "Username":
					if (type.equals("valid")) {
						type = "NCAT";
					}
					element = DEP.getUserNameTxt();
					updatedDetails.setDash_userName(type);
					System.out.println("DASH UserName: "+type);
					break;
				case "Password":
					if (type.equals("valid")) {
						type = "Central1";
					}
					element = DEP.getPasswordTxt();
					updatedDetails.setDash_password(type);
					break;
				case "RepeatPassword":
					if (type.equals("valid")) {
						type = updatedDetails.getDash_password();
					}
					element = DEP.getReenterPasswordTxt();
					break;
			}
			element.clear();
			inputText(element, type);
			context.setDsaDmData(updatedDetails);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Enter "+ field +"DASH Enroll Login page");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on MOA Enrollment Page Verifies the Inline Error Message for {string} Field as {string} in {string} Colour")
	public void verifyerror(String fieldName, String _text, String colour) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "Username":
				waitForSeconds(10);
				element = DEP.getUserNameErrorMsg();
				break;
			case "Password":
				waitForSeconds(10);
				element = DEP.getPasswordErrorMsg();
				break;
			case "ReenterPassword":
				waitForSeconds(10);
				element = DEP.getReenterPasswordErrorMsg();
				break;
			case "TnCCheckbox":
				element = DEP.getTnCCheckboxErrorMsg();
				break;
			case "PrivacyCharter":
				element = DEP.getPrivacyCharterCheckboxErrorMsg();
				break;
			}
			if (expText.equalsIgnoreCase("NoError")) {
				if (isElementVisible(element)) {
					System.out.println("Error Text is " + getText(element));
					System.err.println("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
					Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
				}
			} else
					verifyErrorMessage(element, expText, colour);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Inline Error Message for " + fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on MOA Enrollment Page Verifies the Inline Error Message for {string} Dropdown should not be displayed")
	@And("User on MOA Enrollment Page Verifies the Inline Error Message for {string} Field should not be displayed")
	public void verifyErrorNotDisplayed(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "Username":
				waitForSeconds(10);
				element = DEP.getUserNameErrorMsg();
				break;
			case "Password":
				waitForSeconds(10);
				element = DEP.getUserNameErrorMsg();
				break;
			case "ReenterPassword":
				waitForSeconds(10);
				element = DEP.getUserNameErrorMsg();
				break;
			case "TnCCheckbox":
				element = DEP.getUserNameErrorMsg();
				break;
				
			}
			if (isElementVisible(element)) {
				Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
			}
			;
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
		
		@And("User on MOA Enrollment Page Verifies {string} in {string} Field")
		public void verifyDataInnField(String data, String field) throws Exception {
			WebElement element = null;
			try {
				switch (field) {
				case "UserName":
					element = DEP.getUserNameTxt();
					break;
				case "Password":
					element = DEP.getPasswordTxt();
					break;
				}
				String actual = "";
				if (data.equalsIgnoreCase("blank")) {
					data = "";
				}
				element.sendKeys(Keys.TAB);
				actual = getAttribute(element, "value");
				System.out.println("Actual Text " + actual);
				System.out.println("Expected Text " + data);
				if (!data.equalsIgnoreCase(actual.trim())) {
					log.info("Failed to verify MOA Enrollment Page Verifies " + data + " in " + field
							+ " field");
					Assert.fail("Failed to verify MOA Enrollment Page Verifies " + data + " in "
							+ field + " field");
				}
			} catch (Exception e) {
				log.error("An error occurred: {}", e.getMessage(), e);
				Assert.fail("Failed to verify MOA Enrollment Page Verifies " + data + " in " + field
						+ " field");
				e.printStackTrace();
				throw new Exception(e);
			}
		}
		
		@And("User on MOA Enrollment Page Verifies {string} link is not displayed")
		public void verifyFieldNotDisplayed(String fieldName) throws Exception {
			WebElement element = null;
			try {
				switch (fieldName) {
				case "PrivacyPolicy":
					waitForSeconds(10);
					element = DEP.getPrivacyPolicyLink();
					break;
				}
				if (isElementVisible(element)) {
					Assert.fail("Failed to verify " + fieldName + " field is not displayed");
				}
			} catch (Exception e) {
				log.error("An error occurred: {}", e.getMessage(), e);
				Assert.fail("Failed to verify " + fieldName + " field is not displayed");
				e.printStackTrace();
				throw new Exception(e);
			}
		}

		@And("User on Dash Enrollment page validates {string} link")
		public void validatePrivacyCharter(String fieldName)
		{
			try
			{
				ArrayList<String> tabs;
				switch(fieldName) {
				case "PrivacyPolicy":
					DEP.getPrivacyPolicyLink().click();
					break;
				case "PrivacyCharter":
					DEP.getPrivacyCharterLink().click();
					break;
				case "TnC":
					DEP.getTnCLink().click();
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
				System.out.println("CurrentURL: "+driverManager.getDriver().getCurrentUrl());
				String currUrl = driverManager.getDriver().getCurrentUrl();
				switch(fieldName) {
				case "PrivacyCharter":
					if(!currUrl.contains("privacy_charter") && !currUrl.contains("docs3/")) {
						Assert.fail("Failed to validate "+fieldName);
					}
					else {
						System.out.println("Privacy CHarter validated successfully");
						driverManager.getDriver().close();
						if(context.getDsaDmData().getChannel().equals("WP")) 
							activeWindow = tabs.get(1);
						else
							 activeWindow = tabs.get(0);
						driverManager.getDriver().switchTo().window(activeWindow);
					}
					break;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				Assert.fail("Failed to validate "+fieldName);
				
			}
		}
		
		@And("User on MOA Enrollment Page validates PrivacyCharter content in {string}")
		public void validatePrivacyCharterContent(String language)
		{
			try
			{
				switch(language) {
				case "English":
					DEP.getPrivacyCharterContent().getText().contains("September 2023");
					break;
				case "French":
					DEP.getPrivacyCharterContent().getText().contains("septembre 2023");
					break;
				}
			}catch(Exception e) {
				e.printStackTrace();
				Assert.fail("Failed to validate content for "+language);
			}
			}
		@When("User on MOA Enrollment page Scrolls to the bottom of {string} Field")
		public void scrollDown(String ele)throws Exception
		{
			try {
				switch (ele) {
				case "PrivacyCharter":
						scrollIntoView(driverManager.getDriver().findElement(By.xpath("//div[@id='scrollable-content']//ul//li/p[contains(text(),'privacyoffice@cantire.com')]")));
//					scrollIntoTandCTextBox();
					break;
				case "TermsnConditions":
					if(context.getDsaDmData().getLanguage().startsWith("E"))
						scrollIntoView(driverManager.getDriver().findElement(By.xpath("//div[@id='scrollable-content']//ul//li/p[contains(text(),'23. Acceptance ')]")));
					else
						scrollIntoView(driverManager.getDriver().findElement(By.xpath("//div[@id='scrollable-content']//ul//li/p[contains(text(),'VEUILLEZ SÉLECTIONNER')]")));
					break;
				}
			}catch (Exception e) {
				log.error("An error occurred: {}", e.getMessage(), e);
				Assert.fail("Failed to Scrolls to the bottom of "+ele+" Field");
				e.printStackTrace();
				throw new Exception(e);
			}	
		}
		
}
