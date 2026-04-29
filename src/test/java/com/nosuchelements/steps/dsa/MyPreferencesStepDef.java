package com.nosuchelements.steps.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.constants.Constants.Language;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.MyPreferencesPage;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MyPreferencesStepDef extends BasePage {
	
	@Autowired
	private MyPreferencesPage MP;
	
	@Autowired
	private CommonUtils commutil;
	
	ArrayList<String> tabs;

	@And("User Enters MyPreferences Details")
	public void clickTriangleRewards()
	{
		try
		{
			MP.triangleRewards("Estatements","no","NoSupCard");
		}catch(Exception e) {
			Assert.fail("Failed to Click on Tringle Rewards");
			e.printStackTrace();
		}
	}
	
	@And("User is on My Preferences Page")
	public void verifyPreferenes() {
		try
		{
			Thread.sleep(1000);
			commutil.validate(context.getDsaDmData().getCardType());
			MP.validate();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate My Preferences Page");
		}
	}
	@And("User Enters MyPreferences Details with Statements Preferences as {string} Triangle Reward as {string} Supp Card as {string} with {string} Supp Card Addres")
	public void clickStatement(String statementType, String triangleReward, String suppCard, String suppCardAddressType)
	{
		try
		{
			MP.triangleRewards(context.getDsaDmData(),statementType, triangleReward, suppCard, suppCardAddressType);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Click on Tringle Rewards");
			
		}
	}
	
	@And("User on My Preferences Page Clicks on {string} link")
	@And("User on My Preferences Page Clicks on {string} checkbox")
	@And("User on My Preferences Page Clicks on {string} button")
	public void clickOnElement(String fieldName) throws Exception {
		WebElement element = null;
		String value="";
		DSA_DM updatedDetails = context.getDsaDmData();
		try
		{
			Thread.sleep(5000);
			switch (fieldName) {
			case "eStatements":
				element = MP.getEStatements();
				value= "Y";
				updatedDetails.setStmtMode(value);
				break;
			case "Mail Statements":
				element = MP.getMailedStmnt();
				value= "N";
				updatedDetails.setStmtMode(value);
				break;
			case "Next":
				element = MP.getCNextBtn();
				break;
			case "Next_ReviewPage":
				element = MP.getMPNextReviewBtn();
				break;
			case "TermsAndConditions":
				element = MP.getEStatementCheckBox();
				break;
			case "eStstementsTnCLink":
				element = MP.getEStatementsTnCLink();
				break;
			case "TraingleMembership_Yes":
				element = MP.getTriangleCardNumberYes();
				break;
			case "TraingleMembership_No":
				element = MP.getTriangleCardNumberNo();
				break;
			case "SuppAccount_Yes":
				element = MP.getYesSupCard();
				break;
			case "SuppAccount_No":
				element = MP.getNoSupCard();
				break;
			case "SuppNewAddress":
				element = MP.getScNewAddress();
				break;
			case "SuppSameAddress":
				element = MP.getScSameAddress();
				if(context.getDsaDmData().getUnitNumber()!=null)
					updatedDetails.setSuppSuitNumber(context.getDsaDmData().getUnitNumber());
				updatedDetails.setSuppAddress1(context.getDsaDmData().getAddressLine1());
				updatedDetails.setSuppCity(context.getDsaDmData().getCityString());
				updatedDetails.setSuppProvince(context.getDsaDmData().getProvince());
				updatedDetails.setSuppPostCode(context.getDsaDmData().getPostCode());
				break;
			case "SuppManualEntry":
				element = MP.getScManualEntry();
				break;
			case "SuppTnC":
				element = MP.getSuppTnCLink();
				break;
			case "SuppImportantInfo":
				element = MP.getScImpInfoLink();
				break;
			case "SuppTandC":
				element = MP.getSuppTnCCheckBox();
				break;
			case "SaveOrPrint":
				element = MP.getEStatementsSaveOrPrint();
				break;
			case "GotIt":
				element = MP.getGotItBtn();
				break;	
			case "BackToReview":
				element = MP.getBackToReview();
				break;
			}
			clickElement(element);
			context.setDsaDmData(updatedDetails);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to click on " + fieldName );
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on My Preferences Page Clicks on {string} for {string} Field")
	public void clickOnElementforField(String opt, String fieldName) throws Exception {
		WebElement element = null;
		try
		{
			DSA_DM updatedDetails = context.getDsaDmData();
			String value = "";
			switch (fieldName) {
			case "TraingleMembership":
				switch(opt) {
					case "Yes":
						element = MP.getTriangleCardNumberYes();
						opt=getInputText("dd:DSA-CONTACT-INFO-0030");
						break;
					case "No":
						element = MP.getTriangleCardNumberNo();
						opt=getInputText("dd:DSA-CONTACT-INFO-0031");
						break;
				}
				updatedDetails.setTrngleMemship(opt);
				break;
			case "Supplementarycard":
				switch(opt) {
					case "Yes":
						updatedDetails.setSupplAccount(opt);
						element = MP.getYesSupCard();
						opt=getInputText("dd:DSA-CONTACT-INFO-0030");
						break;
					case "No":
						updatedDetails.setSupplAccount(opt);
						element = MP.getNoSupCard();
						opt=getInputText("dd:DSA-CONTACT-INFO-0031");
						break;
			}
				break;
			}
			clickElement(element);
			context.setDsaDmData(updatedDetails);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to click on " + fieldName );
			e.printStackTrace();
			throw new Exception(e);
		}
	}
		
	@And("User on My Preferences Page Verifies {string} header should be {string}")
	@And("User on My Preferences Page Verifies {string} label should be {string}")
	@And("User on My Preferences Page Verifies {string} text should be {string}")
	public void verifyMessage(String fieldName, String key) throws Exception {
		String message = getInputText(key);
		System.out.println("Message Found:"+message);
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "Header":
				element = MP.getPrefHeader();
				break;
			case "Mail Advisory":
				element = MP.getMailedStmntAdvisory();
				break;
			case "Triangle Membership Advisory":
				element = MP.getTriangleCardNoAdvisory();
				break;
			case "LoyaltyLang":
				element = MP.getLoyaltyLanguage();
				break;
			case "eStatements":
				element = MP.getEStatementsLabel();
				break;
			case "eStatementsTnCLink":
				element = MP.getEStatementsTnCLink();
				break;	
			case "eStatementsTnCLinkText":
				Thread.sleep(3000);
				element = MP.getEStatementsTnCLinkText();
				break;
			case "eStatementsTnCPopupHeader":
				element = MP.getEStatementsTnCPopupHeader();
			/*	if(context.getDsaDmData().getProvince().equals("QUEBEC")) {
					message = getInputText("dd:DSA-CONTACT-INFO-0027",Language.French);
					System.out.println("Message Found for Popup:"+message);
				} */
				break;
			case "eStatementsTnCPopupText":
				element = MP.getEStatementsTnCPopupText();
				if(context.getDsaDmData().getProvince().equals("QUEBEC")) {
					message = "DSA-CONTACT-INFO-0028c"+getInputText("dd:normalized:DSA-CONTACT-INFO-0028a",Language.French);
							//+getInputText("dd:DSA-IBM-CONTACT-INFO-0027");
					System.out.println("Message Found for Popup:"+message);
				}
				break;
			case "eStatementsConsetText":
				element = MP.getEStatementsConsetText();
				break;
			case "mailStatements":
				element = MP.getMailedStmntLabel();
				break;
			case "TraingleMembership_Yes":
				element = MP.getTriangleCardNumberYeslabel();
				break;
			case "TriangleCardNumber":
				element = MP.getTriangleCardNoLabel();
				break;
			case "TraingleMembership_No":
				element = MP.getTriangleCardNumberNolabel();
				break;
			case "SuppAccount_Yes":
				element = MP.getSuppAccountYesLabel();
				break;
			case "SuppAccount_No":
				element = MP.getSuppAccountNoLabel();
				break;
			case "SuppFirstName":
				element = MP.getSuppFirstNameLabel();
				break;
			case "SuppLastName":
				element = MP.getSuppLastNameLabel();
				break;
			case "SuppDOB":
				element = MP.getSuppDobLabel();
				break;
			case "SuppRelationship":
				element = MP.getSuppRelationLabel();
				break;
			case "SuppPhoneNumber":
				element = MP.getSuppPhoneLabel();
				break;
			case "UnitNumber":
				element = MP.getUnitNumberLabel();
				break;
			case "AddressLine1":
				element = MP.getAddressLabel();
				break;
			case "AddressLine2":
				element = MP.getAddress2Label();
				break;
			case "City":
				element = MP.getCityLabel();
				break;
			case "Province":
				element = MP.getProvinceLabel();
				break;
			case "PostalCode":
				element = MP.getPostalCodeLabel();
				break;
			case "SuppImpInfoLink":
				element = MP.getScImpInfoLinkText();
				message = getInputText("dd:DSA-CONTACT-INFO-0028g")+getInputText("dd:DSA-CONTACT-INFO-0028h");
				break;
			case "SuppImpInfoPopupHeader":
				element = MP.getScImpInfoHeader();
				break;
			case "LegalFootnotes":
				element = MP.getLegalFooternotes();
				MP.getLegalFootNotesExpand().click();
				break;
			}
			validateText(element, message);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify " + fieldName + " text should be " + message);
		}
	}
	
	@And("User on My Preferences Page Verifies {string} required text should be {string}")
	public void verifyMessageRequired(String fieldName, String key) throws Exception {
		String message = getInputText(key);
		System.out.println("Message Found:"+message);
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "eStatementsConsetText":
				element = MP.getEStatementsConsetText();
				break;
			case "Mail Advisory":
				break;
			}
			validateText(element, message+getInputText("dd:normalized:DSA-IBM-REQ"));
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify " + fieldName + " text should be " + message);
		}
	}
	
	@And("User on My Preferences Page Verifies {string} text should be {string} in {string}")
	public void verifyMessage(String fieldName, String key, String lang) throws Exception {
		WebElement element = null;
		String message = null;
		try
		{
			switch (fieldName) {
				case "eStatementsTnCPopupHeader":
					element = MP.getEStatementsTnCPopupHeader();
					if(lang.equals("French"))
						message = getInputText(key,Language.French);
					else
						message = getInputText(key,Language.English);
					
					break;
				case "eStatementsTnCPopupText":
					element = MP.getEStatementsTnCPopupText();
					if(lang.equals("French"))
						message = "Enregistrer ou imprimer" + getInputText(key,Language.French);
					else
						message = "Save or print"+getInputText(key,Language.English);
					break;	
			}
			
			element.getText().contains(message);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify " + fieldName + " text should be " + message);
			e.printStackTrace();
		}
	}
	
	@And("User on My Preferences Page Verifies {string} field")
	@And("User on My Preferences Page Verifies {string} link")
	@And("User on My Preferences Page Verifies {string} checkbox")
	@And("User on My Preferences Page Verifies {string} button")
	public void verifyfield(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "eStatements":
				element = MP.getEStatements();
				break;
			case "mailStatements":
				element = MP.getMailedStmnt();
				break;
			case "TermsAndConditions":
				element = MP.getEStatementCheckBox();
				break;
			case "TraingleMembership_Yes":
				element = MP.getTriangleCardNumberYes();
				break;
			case "TraingleMembership_No":
				element = MP.getTriangleCardNumberNo();
				break;
			case "TriangleCardNumber":
				element = MP.getLoyaltyNumber();
				break;
			case "SuppAccount_Yes":
				element = MP.getYesSupCard();
				break;
			case "SuppAccount_No":
				element = MP.getNoSupCard();
				break;
			case "SuppSameAddress":
				element = MP.getScSameAddress();
				break;
			case "SuppDiffAddress":
				element = MP.getScNewAddress();
				break;
			case "SuppFirstName":
				element = MP.getScFirstName();
				break;
			case "SuppLastName":
				element = MP.getScLastName();
				break;
			case "SuppDOB":
				element = MP.getScDob();
				break;
			case "SuppRelationship":
				element = MP.getApplcntRltnshp();
				break;
			case "SuppPhoneNumber":
				element = MP.getScPhoneNumber();
				break;
			case "SuppTnC":
				element = MP.getSuppTnCLink();
				break;
			case "Next":
				element = MP.getCNextBtn();
				break;
			}
			if(element.isEnabled()) {
				if (!isElementVisible(element)) {
				Assert.fail("Failed to Validate visibility of" + fieldName);
				}
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Validate visibility of" + fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on My Preferences Page Verifies the Inline Error Message for {string} Dropdown as {string} in {string} Colour")
	@And("User on My Preferences Page Verifies the Inline Error Message for {string} Field as {string} in {string} Colour")
	public void verifyerror(String fieldName, String _text, String colour) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "StatementMode":
				element = MP.getStmtModeErrorMsg();
				break;
			case "TraingleMembership":
				element = MP.getTraingleMemshipErrorMsg();
				break;
			case "LoyaltyNumber":
				element = MP.getLoyaltyNumberErrorMsg();
				break;
			case "TriangleCardNumber":
				element = MP.getTraingleCardNoErrorMsg();
				break;
			case "Supplementarycard":
				element = MP.getSuppAccountErrorMsg();
				break;
			case "SuppFirstName":
				element = MP.getSupFfirstNameError();
				break;
			case "SuppLastName":
				element = MP.getSupLastNameError();
				break;
			case "SuppDOB":
				element = MP.getSupDobErrorMsg();
				break;
			case "SuppPhoneNumber":
				element = MP.getSupPhoneNumberErrorMsg();
				break;
			case "SuppRelationship":
				element = MP.getSupRelationshipErrorMsg();
				break;
			case "SuppAddressLine1":
				element = MP.getSuppAddressLine1Error();
				break;
			case "SuppCity":
				element = MP.getSuppCityError();
				break;
			case "SuppProvince":
				element = MP.getSuppProvinceError();
				break;
			case "SuppPostCode":
				element = MP.getSuppPostCodeError();
				break;
			case "SuppTandC":
				element = MP.getSuppTandCErrorMsg();
				break;
			case "SuppAddress":
				element = MP.getSuppAddressErrorMsg();
				break;
			case "SuppAddressLookup":
				element = MP.getSuppAddressLookUpError();
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

	@And("User on My Preferences Page Verifies the Inline Error Message for {string} Dropdown should not be displayed")
	@And("User on My Preferences Page Verifies the Inline Error Message for {string} Field should not be displayed")
	public void verifyErrorNotDisplayed(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "StatementMode":
				element = MP.getStmtModeErrorMsg();
				break;
			case "TraingleMembership":
				element = MP.getTraingleMemshipErrorMsg();
				break;
			case "TriangleCardNumber":
				element = MP.getTraingleCardNoErrorMsg();
				break;
			case "Supplementarycard":
				element = MP.getSuppAccountErrorMsg();
				break;
			case "SuppFirstName":
				element = MP.getSupFfirstNameError();
				break;
			case "SuppLastName":
				element = MP.getSupLastNameError();
				break;
			case "SuppDob":
				element = MP.getSupDobErrorMsg();
				break;
			case "SuppRelationship":
				element = MP.getSupRelationshipErrorMsg();
				break;
			case "SuppPhoneNumber":
				element = MP.getSupPhoneNumberErrorMsg();
				break;
//			case "SuppPersonalInfo":
//				element = supPersonalInfoErrorMsg;
//				break;
			case "SuppTandC":
				element = MP.getSuppTandCErrorMsg();
				break;
			case "SuppAddress":
				element = MP.getSuppAddressErrorMsg();
				break;
			case "SuppCity":
				element = MP.getSuppCityError();
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

	@And("User on My Preferences Page Verifies {string} Field should not be displayed")
	public void verifyFieldNotDisplayed(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
				case "SuppTandC":
					element = MP.getSuppTnCCheckBox();
					break;
			}
			if (isElementVisible(element)) {
				Assert.fail("Failed to verify " + fieldName + " is not displayed");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify " + fieldName + " is not displayed");
			throw new Exception(e);
		}
	}
	
	@When("User on My Preferences Page Enters {string} for {string} Field")
	public void enterValue(String _text, String fieldName) throws Exception {
		WebElement element = null;
//		LoyaltyProfileManager lp= new LoyaltyProfileManager();
		String text = getInputText(_text);
		try {
			DSA_DM updatedDetails = context.getDsaDmData();
			switch (fieldName) {
			case "TraingleCardNo":
				element = MP.getLoyaltyNumber();
				updatedDetails.setLoyaltyGroup(text);
				switch (text) {
				case "valid":
					text = "xxxxxxxxxx";
					text=(text+text).substring(0, 16);
					break;
				case "Merge":
					System.out.println("Getting Merged Loyalty");
//					text = lp.getMergedAccount().getLoyaltyNumber();
					text = "";
					System.out.println("Merged Loyalty:"+text);
					break;
				case "Pending":
					if(updatedDetails.getLoyaltyNumber()==null || updatedDetails.getLoyaltyNumber().equals("")) {
//					text = lp.getPendingAccount();
					text = "";
					System.out.println("Loyalty Number:"+text);
					MP.removeLockforLoyalty(text);
					}
					else
						text = updatedDetails.getLoyaltyNumber();
					break;
				case "Mod10Check":
					System.out.println("\nMyPreferencesStepDef: Mod 10 Check \n");
					System.out.println(" Loyalty Number : "+updatedDetails.getLoyaltyNumber());
					if(updatedDetails.getLoyaltyNumber().isEmpty() || updatedDetails.getLoyaltyNumber()==null) {
//						text = lp.getPendingAccount();
						text = "";
						MP.removeLockforLoyalty(text);
					}
					else {
						text = updatedDetails.getLoyaltyNumber();
					}
					System.out.println("Pending Loyalty Number:"+text+" \n");
					String lastChar = text.substring(15, 16);
					String subStrLess_onedigit = text.substring(0, 15);
					int x = Integer.parseInt(lastChar);
					if(x<9) {
						x++;
					}
					else
						x--;
					String last = String.valueOf(x);
					String newNum = subStrLess_onedigit + last;
					System.out.println("Mod10Check: New Loyalty Number check "+newNum+"\n");
					text=newNum;
					updatedDetails.setLoyaltyNumber(newNum);
					break;
				case "Active":
//					if(updatedDetails.getLoyaltyNumber().equals(null) || updatedDetails.getLoyaltyNumber().equals("")) {
//						text = LoyaltyProfileManager.getActiveAccountWithTransactions();
						text = "";
					MP.removeLockforLoyalty(text);
//					}
//					else
//						text = updatedDetails.getLoyaltyNumber();   
					break;
				case "Closed":
//					text = LoyaltyProfileManager.getLostAccount().getOldAccountNumber();
					text = "";
					break;
				case "New":
					System.out.println("New Loyalty Number:"+updatedDetails.getLoyaltyNumber());
					text = updatedDetails.getLoyaltyNumber();
					break;
				case "invalid":
					text = "36735533";
					break;
				}
				System.out.println("Loyalty Number:"+text);
				updatedDetails.setLoyaltyNumber(text);
				break;
			case "SuppFirstName":
				if (text.equals("valid")) {
					text = "Jogpa" ;
				}
				element = MP.getScFirstName();
				updatedDetails.setSuppFirstName(text);
				break;
			case "SuppLastName":
				if (text.equals("valid")) {
					text = "";
				}
				element = MP.getScLastName();
				updatedDetails.setSuppLastName(text);
				break;
			case "SuppDOB":
				Thread.sleep(3000);
				String dobValue = null;
				if (text.equals("valid")) {
					int i =  28;
					String day = i > 9 ? i + "" : "0" + i;
					int j =  12;
					String month = j > 9 ? j + "" : "0" + j;
					String year = "";
					text = year+"/"+month+"/"+day ;
					System.out.println(" DOB before formatting " + text);
					dobValue = getFormattedDate(text,"MM/dd/yyyy");
					System.out.println("Formatted DOB Value " + dobValue);

				}else
				{
					dobValue = getFormattedDate(text,"MM/dd/yyyy");
					System.out.println("Formatted Supp DOB value:"+dobValue);
				}
				element = MP.getScDob();
				updatedDetails.setSuppDob(dobValue);
				break;
			case "SuppAddressLine1":
				element = MP.getScMailingAddLn1();
				updatedDetails.setSuppAddress1(text);
				break;
			case "SuppAddressLine2":
				element = MP.getScMailingAddLn2() ;
				break;
			case "SuppCity":
				element = MP.getScCity();
				updatedDetails.setSuppCity(text);
				break;
			case "SuppPostal":
				element = MP.getScPostalCode();
				updatedDetails.setSuppPostCode(text);
				break;
			case "SuppUnitNumber":
				element = MP.getScUnitNo();
				updatedDetails.setSuppSuitNumber(text);
				break;
			case "SuppRelationship":
				element = MP.getApplcntRltnshp();
				updatedDetails.setSuppRelationship(text);
				break;
			case "SuppPhoneNumber":
				element = MP.getScPhoneNumber();
				switch (text) {
				case "valid":
					text = "xxxxxxxxxx";
					break;
				case "invalid":
					text = "36735533";
					break;
				default:
					break;
				}
				updatedDetails.setSuppPhoneNumberString(text);
				break;
			}
			element.clear();
			element.sendKeys(text);
			context.setDsaDmData(updatedDetails);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Enter " + _text + " in " + fieldName + " Field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on My Preferences Page Verifies {string} in {string} Field")
	public void verifyDataInnField(String data, String field) throws Exception {
		WebElement element = null;
		try {
			switch (field) {
			case "TraingleCardNo":
				element = MP.getLoyaltyNumber();
				break;
			case "SuppFirstName":
				element = MP.getScFirstName();
				break;
			case "SuppLastName":
				element = MP.getScLastName();
				break;
			case "SuppDOB":
				element = MP.getScDob();
				break;
			case "SuppRelationship":
				element = MP.getApplcntRltnshp();
				break;
			case "SuppPhoneNumber":
				element = MP.getScPhoneNumber();
				break;
			}
			String actual = "";
			if (data.equalsIgnoreCase("blank")) {
				data = "";
			}
			element.sendKeys(Keys.TAB);
//			System.out.println("xpath is " + xpath);
			actual = getAttribute(element, "value");
			System.out.println("Actual Text " + actual);
			System.out.println("Expected Text " + data);
			if (!data.equalsIgnoreCase(actual.trim())) {
				log.info("Failed to verify My Preferences Page Verifies " + data + " in " + field
						+ " field");
				Assert.fail("Failed to verify My Preferences Page Verifies " + data + " in "
						+ field + " field");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify My Preferences Page Verifies " + data + " in " + field
					+ " field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User is on My Preferences Page select date from Calendar for {string} date")
	public void selectDate(WebElement element, String date) {
		try
		{
			clickElement(element);
			
		}
		catch(Exception e) {
			Assert.fail("Failed to Validate My Preferences Page");
			e.printStackTrace();
		}
	}
	@And("User on My Preferences Page select {string} in {string} dropdown")
	public void selectOption(String opt, String fieldname) {
		try
		{
			DSA_DM updatedDetails = context.getDsaDmData();
			switch(fieldname) {
			case "SuppRelationship": 
				switch (opt) {
				case "valid":
					System.out.println(" MYPREFSTEPDEF : Inside Valid \n\n");
					opt=getInputText("dd:DSA-SUPP-CARD-019");
					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
					break;
				case "Spouse":
					opt=getInputText("dd:DSA-SUPP-CARD-019");
					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
					break;
				case "SignificantOther":
					opt=getInputText("dd:DSA-SUPP-CARD-020");
					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
					break;
//				case "Son":
//					opt=getInputText("dd:DSA-SUPP-CARD-020");
//					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
//					break;
//				case "Daughter":
//					opt=getInputText("dd:DSA-SUPP-CARD-021");
//					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
//					break;
				case "Relative":
					opt=getInputText("dd:DSA-SUPP-CARD-022");
					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
					break;
				case "Parent":
					opt=getInputText("dd:DSA-SUPP-CARD-021");
					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
					break;
				case "Child":
					opt=getInputText("dd:DSA-SUPP-CARD-032");
					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
					break;
				case "Other":
					opt=getInputText("dd:DSA-SUPP-CARD-023");
					selectFromDropdownByText(MP.getRelationStatus(), opt.toString());
					break;
				}
				updatedDetails.setSuppRelationship(opt);
				context.setDsaDmData(updatedDetails);
				break;
//				if(opt.equalsIgnoreCase("valid")){
//					opt=getInputText("dd:DSA-SUPP-CARD-019");
//					selectFromDropdownByText(By.xpath(relationStatus), opt);
//					break;
//				}
//				else
//					selectFromDropdownByText(By.xpath(relationStatus), opt);
//				updatedDetails.setSuppRelationship(opt);
//				break;
//			case "SuppProvince":
//				selectFromDropdownByText(By.xpath(scProvince), opt);
//				updatedDetails.setSuppProvince(opt);
//			}
//			
//			context.setDsaDmData(updatedDetails);
			
        case "SuppProvince":
			if(opt.equalsIgnoreCase("valid")) {
				opt=getInputText("dd:DSA-PROVINCE-09");
				selectFromDropdownByText(MP.getScProvince(), opt.toString());
			}
			else
				selectFromDropdownByText(MP.getScProvince(), opt);
			
			updatedDetails.setSuppProvince(opt);
			break;
        
		}
		
		context.setDsaDmData(updatedDetails);
		}
		catch(Exception e) {
			Assert.fail("Failed to Validate My Preferences Page");
			e.printStackTrace();
		}
	}
	
	@And("User on My Preferences Page Toggle {string} in {string} popup")
	public void selectToggle(String option, String window) {
	 try {
		switch(window) {
			case "eStatementsTnC":
				waitForVisible(MP.getEStatementsTnCPopupHeader());
			    MP.getEStatementsTnCPopupEnglishToggle().click();
			    break;
		}
	 }
	 catch(Exception e) {
		 e.printStackTrace();
			Assert.fail("Failed to Toggle on "+window);
		}
	}
	
	/* @And("User on My Preferences Page Agrees {string} popup")
	public void agreePopup(String window) {
	 try {
		switch(window) {
			case "eStatementsTnC":
				MP.getEStatementsGotIt().click();
				break;
			case "ImportantInfo":
				MP.getSuppImpInfoGotIt().click();
				break;
		}
	 }
	 catch(Exception e) {
			Assert.fail("Failed to Validate My Preferences Page");
			e.printStackTrace();
		}
	} */
	
	@And("User on My Preferences Page Enters {string} in AddressLookup field")
	public void enterAddress(String addressType) throws Exception
	{
		try
		{
			switch (addressType) {
			case "Valid Address":
				String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
				int num =4;
				int alphaNum = 21;
				inputText(MP.getScAddressLookup(),alphabet[alphaNum]);
				WebElement al = getElementWhenVisible(By.xpath("("+getXpath(MP.getLookUpAddress())+")["+num+"]"));
				clickElement(al);
				while (isElementVisible(By.xpath("//button[@id='poErrorOkBtn']"))) {
					clickElementJS(getElementWhenVisible(By.xpath("//button[@id='poErrorOkBtn']")));
					inputText(MP.getScAddressLookup(), "a");
					 num = 3;
					 WebElement ele = getElementWhenVisible(By.xpath("("+getXpath(MP.getLookUpAddress())+")["+num+"]"));
						clickElement(ele);
				}
				
				break;
				
				default:
					inputText(MP.getAddressLookUp(), addressType);
					clickElement(getElementWhenVisible(By.xpath("("+getXpath(MP.getLookUpAddress())+")[1]")));
					break;
				}
					if(isElementVisible(By.xpath("(//*[@class='formatted-address']/div[1])[3]")))
					{
						DSA_DM dsaDMData = context.getDsaDmData();
						System.out.println("Address1: "+getText(getElementWhenVisible(By.xpath("(//*[@class='formatted-address']/div[1])[3]"))));
						dsaDMData.setSuppAddress1(getText(getElementWhenVisible(By.xpath("(//*[@class='formatted-address']/div[1])[3]"))));
						String text = getText(getElementWhenVisible(By.xpath("(//*[@class='formatted-address']/div[3])[3]")));
						String addr[] = text.split(",");
						System.out.println("Address:City= "+addr[0]+"Province= "+addr[1]);
						dsaDMData.setSuppCity(addr[0]);
						dsaDMData.setSuppProvince(addr[1]);
						System.out.println("PostalCode:"+getText(getElementWhenVisible(By.xpath("(//*[@class='formatted-address']/div[4])[3]"))));
						dsaDMData.setSuppPostCode(getText(getElementWhenVisible(By.xpath("(//*[@class='formatted-address']/div[4])[3]"))));
						context.setDsaDmData(dsaDMData);
					}
					else
						System.out.println("Unable to select address from Lookup");
			
		}
		catch(Exception e)
		{
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Enter Supplementary Residential Information");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	@And("User on My Preferences Page Enters {string}")
	public void enterManualAddress(String address) throws Exception
	{
		try
		{
			System.out.println("Length is "+address.split(",").length);
			for(String addr:address.split(","))
			{
				System.out.println("Address Line "+addr);
			}
			if(address.split(",").length == 4)
			{
				DSA_DM dsaDMData = context.getDsaDmData();
				
				inputText(MP.getScMailingAddLn1(), address.split(",")[0]);
				dsaDMData.setSuppAddress1((address.split(",")[0]));
				inputText(MP.getScCity(), address.split(",")[1]);
				selectFromDropdownByText(MP.getScProvince(), address.split(",")[2].trim());
				inputText(MP.getScPostalCode(), address.split(",")[3].trim());
				dsaDMData.setSuppCity(address.split(",")[1]);
				dsaDMData.setSuppProvince(address.split(",")[2].trim());
				dsaDMData.setSuppPostCode(address.split(",")[3].trim());
				context.setDsaDmData(dsaDMData);
			}
		}catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to enter "+address);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on My Preferences Page Verifies Valid Address Populated in Address Fields")
	public void verifyAddressInField() throws Exception
	{
		try
		{
			if(getAttribute(MP.getScUnitNo(), "value").isEmpty()||getAttribute(MP.getScUnitNo(), "value").equalsIgnoreCase(""))
			{
			 validateText(context.getDsaDmData().getSuppAddress1(),getAttribute(MP.getScMailingAddLn1(), "value"));
			}else 
			{
				validateText(context.getDsaDmData().getSuppAddress1(),getAttribute(MP.getScUnitNo(), "value")+"-"+getAttribute(MP.getScMailingAddLn1(), "value"));
			}
			validateText(context.getDsaDmData().getSuppCity(),getAttribute(MP.getScCity(), "value"));
			validateText(context.getDsaDmData().getSuppProvince().toString(),retrieveValueFromSelect(MP.getScProvince()));
			validateText(context.getDsaDmData().getSuppPostCode(),getAttribute(MP.getScPostalCode(), "value"));
		}
		catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to validate Address in fields");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on My Preferences Page Verifies Same Address Populated in Supplementary Address Fields")
	public void verifySuppAddressInField() throws Exception
	{
		try
		{
			String oldAddress = getText(getElementWhenVisible(By.xpath("//div[contains(@data-ng-show,'viewOldAddress')]/div")));
			System.out.println("Old Address = " + oldAddress);
			String[] addressArray = oldAddress.split("\n");
			String addressLine1 = addressArray[0].trim();
			String city = addressArray[1].split(" ")[0].trim();
			String province = addressArray[1].split(" ")[1].trim();
			String postCode = addressArray[1].split(" ")[2].trim();
			
			validateText(context.getDsaDmData().getAddressLine1(),addressLine1);
			validateText(context.getDsaDmData().getCityString(),city);
			validateText(commutil.returnProvince(context.getDsaDmData().getProvince().toString()),province);
			validateText(context.getDsaDmData().getPostCode(),postCode);
		}
		catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to validate Address in fields");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User is on My Preferences Page verifies {string} PDF in New Tab")
	public void verifyNewTab(String page) throws Exception {
		try {
			String activeWindow;
			tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
			System.out.println("Windows size: "+tabs.size());
			if(context.getDsaDmData().getChannel().equals("WP")) 
				activeWindow = tabs.get(tabs.size()-1);
			else
				 activeWindow = tabs.get(tabs.size()-1);
			driverManager.getDriver().switchTo().window(activeWindow);
			String currUrl = driverManager.getDriver().getCurrentUrl();
			System.out.println("CurrentURL: "+currUrl);
			switch(page) {
				case "SaveOrPrint":
					if(!currUrl.contains("eStatements")) {
						Assert.fail("Failed to verify Save or Print in eStatements Popup");
					}break;
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify GIC Product Information PDF Page");
			throw new Exception(e);
		}
	}
	@And("User on My Preferences Page closes new Tab")
	public void closenewTab() throws Exception {
		try {
			String activeWindow;
			
			System.out.println("Current URL to be closed: "+driverManager.getDriver().getCurrentUrl());
			driverManager.getDriver().close();
			tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
			System.out.println("No of Tabs"+tabs.size());
			activeWindow = tabs.get(tabs.size()-1);
//			System.out.println("No of Tabs"+tabs.size());
//			System.out.println("Current URL to be closed: "+driverManager.getWebDriver().getCurrentUrl());
			if(context.getDsaDmData().getChannel().equals("WP")) {
				System.out.println("Switching in Ecom tab");
				driverManager.getDriver().switchTo().window(activeWindow);
			}
			else {
				System.out.println("Switching in NonEcom tab");
				driverManager.getDriver().switchTo().window(activeWindow);
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to Close New Tab");
			throw new Exception(e);
		}
	}
	
	@And("User on My Preferences Page validates Supp relationship dropdown options")
	public void readDropdownclosenewTab() throws Exception {
		try {
			
			WebElement dropdownElement = driverHelper.getElementWhenVisible(MP.getRelationStatus());
			Select dropdown = new Select(dropdownElement);
			
			List<String> optionsText = new ArrayList<>();
			List<WebElement> allOptions = dropdown.getOptions();
			for(WebElement option : allOptions) {
				optionsText.add(option.getText().trim());
				System.out.println("=>"+optionsText);
				if(context.getDsaDmData().getLanguage().contains("E")) {
					if(optionsText.contains("Son") || optionsText.contains("Daughter")) {
					Assert.fail(" Failed : Son/Daughter option present in Supp relationship dropdown");
					}
				}
				else {
					if(optionsText.contains("Fils") || optionsText.contains("Fille")) {
						Assert.fail(" Failed : Son/Daughter FRC option present in Supp relationship dropdown");
						}
				}    
			}
			Object[] expArray = {getInputText("dd:DSA-SUPP-CARD-019"),getInputText("dd:DSA-SUPP-CARD-020"),getInputText("dd:DSA-SUPP-CARD-023"),getInputText("dd:DSA-SUPP-CARD-022"),getInputText("dd:DSA-SUPP-CARD-021"),getInputText("dd:DSA-SUPP-CARD-032")};
			List<Object> expectedValues = Arrays.asList(expArray);
			for(Object expected : expectedValues) {
				System.out.println("**    "+expectedValues);
				if(!optionsText.contains(expected)) {
					Assert.fail("Missing dropdwon value : Supp Relationship \n");
				}
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to validate Supp Relationship dropdown");
			throw new Exception(e);
		}
	}
	
	@When("User on My Preferences Page validates the following fields:")
	public void validateFields(DataTable dataTable) {
	    try {
	        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
	        for (Map<String, String> row : rows) {
	            String fieldName = row.get("FieldName");
	            String inputValue = row.get("InputValue");
	            String expectedValue = row.get("ExpectedValue");
	            String error = row.get("Error");

	            // Enter input value into specified field (SuppFirstName or SuppLastName)
	            enterValue(inputValue, fieldName);

	            // Verify displayed value matches expected
	            verifyDataInnField(expectedValue, fieldName);

	            // Verify inline error message matches expected error and is red
	            verifyerror(fieldName, error, "red");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        Assert.fail("Failed to validate fields");
	    }
	}

		
	
}
