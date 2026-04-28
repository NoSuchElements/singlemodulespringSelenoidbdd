package com.nosuchelements.steps.dsa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.constants.Constants.Phone_Type;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.PersonalInformation;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class PersonalInfoStepDef extends BasePage  {

	@Autowired
	private PersonalInformation personalInfo;
	
	@Autowired
	private CommonUtils commutil;
	
	 @And("User Validates Personal Information page")
	public void validatePersonalInfo() {
		try
		{
			Phone_Type value = Phone_Type.MOBILE;
			personalInfo._personalInformation(context.getDsaDmData(), context.getDsaDmData().getFirstName(), context.getDsaDmData().getLastName(),context.getDsaDmData().getEmail(), value, true);
		}catch(Exception e) {
			Assert.fail("Failed to Validate Personal Information page");
			e.printStackTrace();
		}
	}
	
	@And("User is on Personal Information Page")
	public void verifyPersonalInfo() throws ValidationException
	{
		try
		{
			commutil.validate(context.getDsaDmData().getCardType());
			personalInfo.validate();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate Personal Information Page");
		}
	}
	
	@And("User validates Card Name in Header Notes")
	public void verifyHeader() throws ValidationException
	{
		try
		{
			String cardType = context.getDsaDmData().getCardType();
			WebElement header = driverManager.getDriver().findElement(By.xpath("//div[@class='navbar-header']//span[@class='select-card ng-scope']/span[contains(@data-ng-show,'\"+cardType+\"')]"));
			String headerText = getText(header);
			System.out.println("Header Notes: "+headerText);
			
			if(cardType.equals("OMX"))
				headerText.contains("Triangle® Mastercard®");
			else if(cardType.equals("OMZ"))
				headerText.contains("Triangle® World Elite® Mastercard®");
			else if(cardType.equals("OMP"))
				headerText.contains("Gas Advantage® Mastercard®");
			else if(cardType.equals("OMR"))
				headerText.contains("Cash Advantage® Mastercard®");
			else
				System.out.println("Invalid Card TYpe");
		}
		catch(Exception e) {
			Assert.fail("Failed to validate Header Notes");
			e.printStackTrace();
		}
	}
	
	@And("User validates Card Name in Footer Notes")
	public void verifyFooter() throws ValidationException
	{
		try
		{
			String cardType = context.getDsaDmData().getCardType();
			WebElement footer = driverHelper.getElementWhenVisible(By.xpath("//div[@class='navbar-header']//span[@class='select-card ng-scope']/span[contains(@data-ng-show,'"+cardType+"')]"));
			String headerText = getText(footer);
			System.out.println("Header Notes: "+headerText);
			if(cardType.equals("OMX"))
				headerText.contains("Triangle® Mastercard®");
			else if(cardType.equals("OMZ"))
				headerText.contains("Triangle® World Elite® Mastercard®");
			else if(cardType.equals("OMP"))
				headerText.contains("Gas Advantage® Mastercard®");
			else if(cardType.equals("OMR"))
				headerText.contains("Cash Advantage® Mastercard®");
			else
				System.out.println("Invalid Card TYpe");
		}
		catch(Exception e) {
			Assert.fail("Failed to validate Header Notes");
			e.printStackTrace();
		}
	}
	
	@And("User on Personal Information Page Verifies {string} label should be {string}")
	@And("User on Personal Information Page Verifies {string} text should be {string}")
	public void verifyMessage(String fieldName, String message) throws Exception {
		message = getInputText(message);
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "Header":
				element = personalInfo.getPersonalInfoHeader();
				break;
			case "Instructions":
				element = personalInfo.getInstructionMsg();
				break;
			case "Advisory":
				element = personalInfo.getAdvisoryMsg();
				break;
			case "Sure, use my profile info":
				element = personalInfo.getNoManualBtn();
				break;
			case "No, I'll fill it myself":
				element = personalInfo.getManualBtn();
				break;
			case "FirstName":
				element = personalInfo.getFirstNameLabel();
				break;
			case "LastName":
				element = personalInfo.getLastNameLabel();
				break;
			case "DOB":
				element = personalInfo.getDobLabel();
				break;
			case "DOBAdvisory":
				element = personalInfo.getDobAdvisory();
				break;
			case "Email":
				element = personalInfo.getEmailLabel();
				break;
			case "EmailAdvisory":
				element = personalInfo.getEmailAdvisory();
				break;
			case "Consent":
				element = personalInfo.getCiCheckBoxLabel();
				break;
			case "Consent Message":
				element = personalInfo.getCiConsentMessage();
				break;
			case "Preferred Language":
				element = personalInfo.getPreferLanguageLabel();
				break;
			case "MobileNumber Instructions":
				element = personalInfo.getAddMobile();
				break;
			case "Phone Type":
				element = personalInfo.getPhoneTypeLabel();
				break;
			case "Phone Number":
				element = personalInfo.getPhoneNumLabel();
				break;
			case "PhoneNumberAdvisory":
				element = personalInfo.getPhoneNumAdvisory();
				break;
			case "SINAdvisory":
				element = personalInfo.getSinAdvisory();
				break;
			case "SINSubTitle":
				element = personalInfo.getSinHeading();
				break;
			case "SINReason":
				element = personalInfo.getSinInstructions();
				break;
			case "SIN":
				element = personalInfo.getSinLabel();
				break;
			case "LegalFootnotes":
				element = personalInfo.getLegalFooternotes();
				personalInfo.getLegalFootNotesExpand().click();
				break;
			}
			validateText(element, message);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to verify " + fieldName + " text should be " + message);
			throw new Exception(e);
		}
	}
	
	@And("User on Personal Information Page Verifies {string} label should be {string} for mandatory fields")
	public void verifyRequiredLabel(String fieldName, String message) throws Exception {
		message = getInputText(message);
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "FirstName":
				element = personalInfo.getFirstNameLabel();
				break;
			case "LastName":
				element = personalInfo.getLastNameLabel();
				break;
			case "DOB":
				element = personalInfo.getDobLabel();
				break;
			}
			validateText(element, message+"dd:DSA-IBM-REQ");
		}catch(Exception e) {
			Assert.fail("Failed to verify " + fieldName + " text should be " + message);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Personal Information Page Clicks on {string} checkbox")
	@And("User on Personal Information Page Selects on {string} button")
	@And("User on Personal Information Page Clicks on {string} button")
	public void clickOnElement(String fieldName) throws Exception {
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "Sure, use my profile info":
				element = personalInfo.getNoManualBtn();
				break;
			case "No, I'll fill it myself":
				element = personalInfo.getManualBtn();
				break;
			case "Next":
				element = personalInfo.getNextButtonHome();
				break;
			case "NextPI":
				System.out.println("Before Next Value: "+personalInfo.getPhoneNum().getAttribute("value"));
				System.out.println("Before Next Value: "+personalInfo.getSinTextBox().getAttribute("value"));
				element = personalInfo.getNextButtonPI();
				break;
			case "PromoCheckbox":
				element = personalInfo.getCiCheckBox();
				break;
			case "BackToReview":
				element = personalInfo.getBackToReview();
				break;
			case "Next_ReviewPage":
				element= personalInfo.getNextReviewButtonPI();
				break;
			}
			clickElementJS(element);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on " + fieldName );
			throw new Exception(e);
		}
	}
	
	@And("User on Personal Information Page Verifies {string} Field")
	@And("User on Personal Information Page Verifies {string} button")
	@And("User on Personal Information Page Verifies {string} Dropdown")
	@And("User on Personal Information Page Verifies {string} Checkbox")
	public void verifyElement(String fieldName) throws Exception
	{
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "Sure, use my profile info":
				element = personalInfo.getNoManualBtn();
				break;
			case "No, I'll fill it myself":
				element = personalInfo.getManualBtn();
				break;
			case "Next":
				element = personalInfo.getNextButtonHome();
				break;
			case "NextPI":
				element = personalInfo.getNextButtonPI();
				break;
			case "FirstName":
				element = personalInfo.getFirstName();
				break;
			case "LastName":
				element = personalInfo.getLastName();
				break;
			case "DOB":
				element = personalInfo.getDob();
				break;
			case "Email":
				element = personalInfo.getEmailTextBox();
				break;
			case "Consent":
				element = personalInfo.getCiCheckBox();
				break;
			case "Preferred Language":
				element = personalInfo.getPreferLanguage();
				break;
			case "Phone Type":
				element = personalInfo.getPhoneTypeDrpdwn();
				break;
			case "Phone Number":
				element = personalInfo.getPhoneNum();
				break;
			case "SIN":
				element = personalInfo.getSinTextBox();
				break;
			}
			waitForVisible(element);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to verify " + fieldName );
			throw new Exception(e);
		}
	}
	

	@And("User on Personal Information Page Enters {string} in {string} Field")
	public void enterValues(String type, String field) throws Exception {
		WebElement element = null;
		try {
			DSA_DM updatedDetails =context.getDsaDmData()!=null?context.getDsaDmData(): new DSA_DM(); 
//			DSA_DM updatedDetails = context.getDsaDmData();
			switch (field) {

			case "FirstName":
				if (type.equals("valid")) {
					type = "NCAT" ;
				}
				element = personalInfo.getFirstName();
				updatedDetails.setFirstName(type);
				break;
			case "LastName":
				if (type.equals("valid")) {
					type = "AUTON" ;
				}
				element = personalInfo.getLastName();
				updatedDetails.setLastName(type);
				break;

			case "FirstLongName":
				if (type.equals("valid")) {
					type = "NCAT" ;
				}
				element = personalInfo.getFirstName();
				updatedDetails.setFirstName(type);
				break;
				
			case "LastLongName":
				if (type.equals("valid")) {
					type = "AUTON";
				}
				element = personalInfo.getLastName();
				updatedDetails.setLastName(type);
				break;
				
			case "SIN":
				if (type.equals("valid")) {
					type = "";
				}
				element = personalInfo.getSinTextBox();
				updatedDetails.setSin(type);
				break;
			case "EmailAddress":
				element = personalInfo.getEmailTextBox();
				switch (type) {
				case "valid":
					type="test@gmail.com";
					break;
				case "invalid":
					type="ct.fsautom@ation1@gmail.c.om";
					break;
				default:
					break;
				}
				updatedDetails.setEmail(type);
				break;
			case "DOB":
				String dobValue = null;
				if (type.equals("valid")) {
					int i = 3;
					String day = i > 9 ? i + "" : "0" + i;
					int j = 2;
					String month = j > 9 ? j + "" : "0" + j;
					String year = "1995";
					type = year+"/"+month+"/"+day ;
					System.out.println(" DOB before formatting " + type);
					dobValue = getFormattedDate(type,"MM/dd/yyyy");
//					System.out.println("day " + day + " " + "month " + month + "year " + year);
					System.out.println("Formatted DOB Value " + dobValue);

				}else
				{
//					type = getFormattedDate(type,"YYYY-MM-dd");
					dobValue = getFormattedDate(type,"MM/dd/yyyy");
					System.out.println("Formatted DOB value:"+dobValue);
				}
				updatedDetails.setDob1(dobValue);
				element = personalInfo.getDob();
				break;
			case "PhoneNumber":
				Thread.sleep(5000);
				element = personalInfo.getPhoneNum();
				switch (type) {
				case "valid":
					type= "8764568732";
					Thread.sleep(5000);
					System.out.println("\n Phone number entered : "+type);
					break;
				case "invalid":
					type= "36735533";
					break;
				default:
					break;
				}
				element.click();
				updatedDetails.setPhoneNumber(type);
				break;
			}
			System.out.println("Entering value for "+field);
			//For DSA3
		/*	if(field.equalsIgnoreCase("PhoneNumber") || field.equalsIgnoreCase("SIN") ) {
				long value = Long.parseLong(type);
				System.out.println("Entering "+value);
			    element.click();
			    Actions actions = new Actions(driverManager.getDriver());
			    actions.moveToElement(element)
			           .click()
			           .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			           .sendKeys(type)
			           .build().perform();
					waitForSeconds(10);
					String actualValue = element.getAttribute("value");
					System.out.println("Value: "+actualValue);
			}
			else {
				System.out.println("Other fields");
				inputText(element, type);
			} */
			inputText(element, type);
//			System.out.println("Latest Value: "+element.getAttribute("value"));
			context.setDsaDmData(updatedDetails);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to enter "+type+" for the field "+field);
			throw new Exception(e);
		}
	}


	@And("User on Personal Information Page Verifies {string} in {string} Field")
	public void verifyDataInnField(String data, String field) throws Exception {
		WebElement element = null;
		try {
			switch (field) {
			case "FirstName":
				element = personalInfo.getFirstName();
				break;
			case "LastName":
				element = personalInfo.getLastName();
				break;
			case "DOB":
				element = personalInfo.getDob();
				break;
			case "SIN":
				element = personalInfo.getSinTextBox();
				break;
			case "EmailAddress":
				element = personalInfo.getEmailTextBox();
				break;
			case "PhoneNumber":
				element = personalInfo.getPhoneNum();
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
				log.info("Failed to verify Personal Information Page Verifies " + data + " in " + field
						+ " field");
				Assert.fail("Failed to verify Personal Information Page Verifies " + data + " in "
						+ field + " field");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Personal Information Page Verifies " + data + " in " + field
					+ " field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Personal Information Page Verifies the Inline Error Message for {string} Dropdown as {string} in {string} Colour")
	@And("User on Personal Information Page Verifies the Inline Error Message for {string} Field as {string} in {string} Colour")
	public void verifyerror(String fieldName, String _text, String colour) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch(fieldName) {
			case "FirstName":
				element = personalInfo.getFirstNameErrorMessage();
				break;
			case "LastName":
				element = personalInfo.getLastNameErrorMessage();
				break;
			case "DOB":
				element = personalInfo.getDobErrorMessage();
				break;
			case "EmailAddress":
				element = personalInfo.getEmailErrorMessage();
				break;
			case "PhoneType":
				element = personalInfo.getPhoneTypeErrorMessage();
				break;
			case "SIN":
				element = personalInfo.getSinErrorMessage();
				break;
			case "PhoneNumber":
				Thread.sleep(2000);
				element = personalInfo.getPhnNumberErrorMessage();
				break;
			}

			if (expText.equalsIgnoreCase("NoError")) {
				if (isElementVisible(element)) {
					System.out.println("Error Text is " + getText(element));
					System.err.println("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
					Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
				}
			} else {
				verifyErrorMessage(element, expText, colour);
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Inline Error Message for " + fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Personal Information Page Verifies the Inline Error Message for {string} Dropdown should not be displayed")
	@And("User on Personal Information Page Verifies the Inline Error Message for {string} Radio Button should not be displayed")
	@And("User on Personal Information Page Verifies the Inline Error Message for {string} Field should not be displayed")
	public void verifyErrorNotDisplayed(String fieldName) throws Exception {
		WebElement element = null;
				try {
					switch(fieldName) {
					case "FirstName":
						element = personalInfo.getFirstNameErrorMessage();
						break;
					case "LastName":
						element = personalInfo.getLastNameErrorMessage();
						break;
					case "DOB":
						element = personalInfo.getDobErrorMessage();
						break;
					case "EmailAddress":
						element = personalInfo.getEmailErrorMessage();
						break;
					case "PhoneType":
						element = personalInfo.getPhoneTypeErrorMessage();
						break;
					case "SIN":
						element = personalInfo.getSinErrorMessage();
						break;
					case "PhoneNumber":
						element = personalInfo.getPhnNumberErrorMessage();
						break;
					}
				
			if(isElementVisible(element)) {
				Assert.fail("Failed to verify Inline Error Message for "+fieldName+" is not displayed");
			};
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Inline Error Message for "+fieldName+" is not displayed");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@When("User on Personal Information Page Selects {string} in {string} dropdown")
	public void selectOpt(String opt, String dropdown) throws Exception {
		try {
			DSA_DM updatedDetails = context.getDsaDmData();
			switch (dropdown) {
			case "PhoneType":
				switch (opt) {
				case "valid":
					opt=getInputText("dd:DSA-CONTACT-INFO-0012");
//					personalInfo.getPhoneTypeDrpdwn().click();
//					driverManager.getDriver().findElement(By.xpath("//li[@data-value='mobile']")).click();
					selectFromDropdownByText(personalInfo.getPhoneTypeDrpdwn(), opt.toString());
					break;
				case "Mobile":
					opt=getInputText("dd:DSA-CONTACT-INFO-0012");
//					personalInfo.getPhoneTypeDrpdwn().click();
//					driverManager.getDriver().findElement(By.xpath("//li[@data-value='mobile']")).click();
					selectFromDropdownByText(personalInfo.getPhoneTypeDrpdwn(), opt.toString());
					break;
				case "Home Phone":
					opt=getInputText("dd:DSA-CONTACT-INFO-0013");
//					personalInfo.getPhoneTypeDrpdwn().click();
//					driverManager.getDriver().findElement(By.xpath("//li[@data-value='home']")).click();
					selectFromDropdownByText(personalInfo.getPhoneTypeDrpdwn(), opt.toString());
					break;
				case "change to Home Phone":
//					opt=getInputText("dd:DSA-CONTACT-INFO-0013");
					selectFromDropdownByText(personalInfo.getPhoneTypeDrpdwnHomeSelected(), getInputText("dd:DSA-CONTACT-INFO-0013").toString());
					break;
				case "change to Mobile":
//					opt=getInputText("dd:DSA-CONTACT-INFO-0013");
					selectFromDropdownByText(personalInfo.getPhoneTypeDrpdwnMobileSelected(), getInputText("dd:DSA-CONTACT-INFO-0012").toString());
					break;
				
				}
				System.out.println("Setting Phone Type");
				updatedDetails.setPhoneType(opt);
				break;
			case "PreferredLanguage":
				switch (opt) {
				case "valid":
					opt=getInputText("dd:DSA-ENGLISH");
//					personalInfo.getPreferLanguage().click();
//					driverManager.getDriver().findElement(By.xpath("//li[@data-value='English']")).click();
					selectFromDropdownByText(personalInfo.getPreferLanguage(), opt.toString());
					break;
				case "English":
					opt=getInputText("dd:DSA-ENGLISH");
//					personalInfo.getPreferLanguage().click();
//					driverManager.getDriver().findElement(By.xpath("//li[@data-value='English']")).click();
					selectFromDropdownByText(personalInfo.getPreferLanguage(), opt.toString());
					break;
				case "French":
					opt=getInputText("dd:DSA-FRENCH");
//					personalInfo.getPreferLanguage().click();
//					driverManager.getDriver().findElement(By.xpath("//li[@data-value='French']")).click();
					selectFromDropdownByText(personalInfo.getPreferLanguage(), opt.toString());
					break;
				
				}
				System.out.println("Setting Preferred Language"+opt);
				updatedDetails.setPreferLanguage(opt);
				break;
			}
			context.setDsaDmData(updatedDetails);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Select " + opt + " from " + dropdown + " Dropdown");
			e.printStackTrace();
			throw new Exception(e);
		}
	} 

	@And("User on Personal Information page validates text in legal footer")
	public void validateAPRonPIpage() {
		WebElement element = null;
		try {
					 System.out.println("\n Clicking Legal footer to validate text \n");
					 personalInfo.getPilegalFooter().click();
					 element = driverManager.getDriver().findElement(By.xpath("//div[@id='dsa_legal_accordion_content']"));
					 String legalText = element.getText();
					 legalText.replaceAll("br", "");
					 System.out.println("Footer Text: "+legalText);
					 switch(context.getDsaDmData().getCardType()) {
					
					   case "OMX":
					 			 try {
					 				 System.out.println("\n Comparing Legal footer text :  OMX \n");
					 				 String dataDic =getInputText("dd:normalized:DSA-FOOTER-LEGAL-OMX").replaceAll("This is rates table", "");
						 			 validateText(dataDic, legalText, true);
					 			 }catch(Exception e) {
					 				 throw e;
					 			 }
					 			break;
					 	case "OMZ":
					 		 	try {
					 			    System.out.println("\n Comparing Legal footer text :  OMZ \n");
					 			    String dataDic =getInputText("dd:normalized:DSA-FOOTER-LEGAL-OMZ").replaceAll("This is rates table", "");
					 			    validateText(dataDic, legalText, true);
					 		 	}catch(Exception e) {
					 			 throw e;
						 	    }
					 			break;
					 	case "OMR":
					 		try {
								System.out.println("\n Comparing Legal footer text :  OMR \n");
								String dataDic = getInputText("dd:normalized:DSA-FOOTER-LEGAL-OMR").replaceAll("This is rates table", "");
								validateText(dataDic, legalText, true);
					 			} catch (Exception e) {
					 				e.printStackTrace();
					 			}
					 			break;
					 	case "OMP":
					 		try {
					 			System.out.println("\n Comparing Legal footer text :  OMP \n");
					 			String dataDic = getInputText("dd:normalized:DSA-FOOTER-LEGAL-OMP").replaceAll("This is rates table", "");
					 			validateText(dataDic, legalText, true);
					 			} catch (Exception e) {
					 				e.printStackTrace();
					 			}
					 			break;
					}//switch
			}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate APR Text in legal footer");
		}
	}
	
	@And("User on Personal Information Page waits for ten minutes before navigating")
	public void wait10min() throws Exception {
		
		try {
			Thread.sleep(100000);
		}catch(Exception e) {
			throw e;
		}
		}
}	
	
	
