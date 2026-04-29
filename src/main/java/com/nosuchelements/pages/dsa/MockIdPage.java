package com.nosuchelements.pages.dsa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;

import lombok.Data;

@PageObject
@Data
@Component

public class MockIdPage extends BasePage {

	
	@FindBy(how = How.XPATH, using = "//input[@id='given_name']")
    private WebElement firstName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='family_name']")
    private WebElement lastName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='birthDate']")
    private WebElement dob;
	
	@FindBy(how = How.XPATH, using = "//input[@id='postal_code']")
    private WebElement postalCode;
	
	@FindBy(how = How.XPATH, using = "//input[@id='street_address']")
    private WebElement streetAddress;
	
	@FindBy(how = How.XPATH, using = "//input[@id='locality']")
    private WebElement city;
	
	@FindBy(how = How.XPATH, using = "//input[@id='region']")
    private WebElement province;
	
	@FindBy(how = How.XPATH, using = "//input[@id='country']")
    private WebElement country;
	
	@FindBy(how = How.XPATH, using = "//input[@id='doc_number']")
    private WebElement idDocNum;
	
	@FindBy(how = How.XPATH, using = "//select[@id='doc_type']")
    private WebElement idDocType;
	
//	ID Types
	@FindBy(how = How.XPATH, using = "//option[@value='0: Object']")
    private WebElement idTypeDriverLic;
	
	@FindBy(how = How.XPATH, using = "//option[@value='2: Object']")
    private WebElement idTypeNationalCard;
	
	@FindBy(how = How.XPATH, using = "//option[@value='1: Object']")
    private WebElement idTypePassport;
	
	@FindBy(how = How.XPATH, using = "//option[@value='3: Object']")
    private WebElement idTypeResident;
	
	@FindBy(how = How.XPATH, using = "//option[@value='4: Object']")
    private WebElement idTypeIndigenous;
	
	@FindBy(how = How.XPATH, using = "//option[@value='5: Object']")
    private WebElement idTypeUnknown;
	
	@FindBy(how = How.XPATH, using = "//input[@id='expiry_date']")
    private WebElement idExpiry;
	
	@FindBy(how = How.XPATH, using = "//input[@id='issuing_authority']")
    private WebElement idIssuingAuthority;
	
	@FindBy(how = How.XPATH, using = "//input[@id='issue_date']")
    private WebElement idIssueDate;
	
	@FindBy(how = How.XPATH, using = "//input[@id='source']")
    private WebElement source;
	
	@FindBy(how = How.XPATH, using = "//input[@id='UILanguage']")
    private WebElement lang;
	
	@FindBy(how = How.XPATH, using = "//select[@id='scan_result']")
    private WebElement scanResult;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'REJECTED')]")
    private WebElement scanRej;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'SUSPECTED')]")
    private WebElement scanSuspect;
	
	@FindBy(how = How.XPATH, using = "//input[@id='nationality']")
    private WebElement nationality;
	
	@FindBy(how = How.XPATH, using = "//input[@id='given_name_score']")
    private WebElement fnMatchScore;
	
	@FindBy(how = How.XPATH, using = "//input[@id='family_name_score']")
    private WebElement lnMatchScore;
	
	@FindBy(how = How.XPATH, using = "//input[@id='birthdate_score']")
    private WebElement dobMatchScore;
	
	@FindBy(how = How.XPATH, using = "//input[@id='postal_code_score']")
    private WebElement postMatchScore;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fail_reason']")
    private WebElement failReason;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fail_description']")
    private WebElement matchFail;
	
	@FindBy(how = How.XPATH, using = "//input[@id='issuing_country']")
    private WebElement issingCountry;
	
	@FindBy(how = How.XPATH, using = "//select[@name='match_status']/option[contains(text(),'CLEAR')]")
    private WebElement clrMatch;
	
	@FindBy(how = How.XPATH, using = "//select[@name='match_status']/option[contains(text(),'REJECTED')]")
    private WebElement rejMatch;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
    private WebElement submitBtn;
	
//	@FindBy(how = How.LINK_TEXT, using = "Submit")
//    private WebElement submitBtn;
	
	// Cancel Scenario
	
	@FindBy(how = How.LINK_TEXT, using = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@name='cancel_reason']")
    private WebElement simError;
	
	@FindBy(how = How.XPATH, using = "//input[@name='cancel_description']")
    private WebElement simErrorDesc;
	
	// Suspected Flags options
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'DATA_VALIDATION')]")
    private WebElement dataValidate;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'VISUAL_AUTHENTICITY')]")
    private WebElement visual;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'COMPROMISED_DOCUMENT')]")
    private WebElement compromised;
	
	@FindBy(how = How.XPATH, using = "//select[@name='suspected_flags']/option[contains(text(),' DATA_CONSISTENCY ')]")
    private WebElement dataConsistency;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'SOURCE_INTEGRITY')]")
    private WebElement integrity;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'FACE_MATCH')]")
    private WebElement faceMatch;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'SPOOFING_DETECTION')]")
    private WebElement spoofing;
	
	@FindBy(how = How.XPATH, using = "//select[@name='suspected_flags']/option[contains(text(),' UNKNOWN')]")
    private WebElement unknown;
	
	// Rejected Flags
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'IMAGE_QALITY')]")
    private WebElement image;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'CONCLUSIVE_DOCUMENT_QUALITY')]")
    private WebElement conclusive;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'SUPPORTED_DOCUMENT')]")
    private WebElement supportedDoc;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'COLOUR_PICTURE')]")
    private WebElement colour;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'MINIMUM_ACCEPTED_AGE')]")
    private WebElement age;
	
	@FindBy(how = How.XPATH, using = "//select[@name='rejected_flags']/option[contains(text(),' DATA_CONSISTENCY ')]")
    private WebElement dataConsist;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'FACE_DETECTION')]")
    private WebElement faceDetection;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'DOCUMENT_EXPIRATION')]")
    private WebElement docExpire;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'FACE_DETECTED')]")
    private WebElement faceDetect;
	
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'FILTERED_DOCUMEN')]")
    private WebElement filteredDoc;
	
	@FindBy(how = How.XPATH, using = "//select[@name='rejected_flags']/option[contains(text(),' UNKNOWN')]")
    private WebElement rejUnknown;
	
	
	public void passedApp(DSA_DM dsa) throws ValidationException {
		try {
			Thread.sleep(1000);
			inputText(streetAddress, dsa.getAddressLine1());
			inputText(city, dsa.getCityString());
			inputText(province,returnProv());
			inputText(postalCode, dsa.getPostCode());
			Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to enter values : Mock ID passed application \n");
			
		}
	}
	
	public void dobMismatch(DSA_DM dsa) throws ValidationException {
		try {
			System.out.println("\n Changing DOB on Mock Screen \n");
			inputText(dob, "11/05/1939");
			inputText(dobMatchScore, "50");
			inputText(streetAddress, dsa.getAddressLine1());
			inputText(city, dsa.getCityString());
			inputText(postalCode, dsa.getPostCode());
		}catch (Exception e) {
			System.out.println("\n Failed to enter values : Mock ID Page : DOB Mismatch \n");
			e.printStackTrace();
		}
	}
	
	public void nameMismatch(DSA_DM dsa) throws ValidationException {
		try {
			firstName.clear();
			inputText(firstName, "NCATNCAT");
			inputText(fnMatchScore, "-300");
			inputText(streetAddress, dsa.getAddressLine1());
			inputText(city, dsa.getCityString());
			inputText(postalCode, dsa.getPostCode());
		}catch (Exception e) {
			System.out.println("\n Failed to enter values : Mock ID Page : Name Mismatch \n");
			e.printStackTrace();
		}
	}
	
	public void expiredID(DSA_DM dsa) throws ValidationException {
		try {
			inputText(idExpiry, "11/11/2023");
			Thread.sleep(2000);
//			inputText(streetAddress,"394 CLARE AVE");
			inputText(streetAddress, dsa.getAddressLine1());
			inputText(city, dsa.getCityString());
//			inputText(city,"WELLAND");
//			inputText(postalCode,"L3C5R2");
			inputText(postalCode, dsa.getPostCode());
		}catch (Exception e) {
			System.out.println("\n Failed to enter values : Mock ID Page : Expired ID  \n");
			e.printStackTrace();
		}
	}
	
	public void invalidID(DSA_DM dsa) throws ValidationException {
		try {
			inputText(idDocNum, "GKS6NF");
			inputText(streetAddress, dsa.getAddressLine1());
			inputText(city, dsa.getCityString());
			inputText(postalCode, dsa.getPostCode());
		}catch (Exception e) {
			System.out.println("\n Failed to enter values : Mock ID Page : Invalid ID  \n");
			e.printStackTrace();
		}
	}
	
	public String returnProv() {
		String prov = context.getDsaDmData().getProvince().toUpperCase();
		String province = "";
		DSA_DM updatedDetails = context.getDsaDmData();
		switch(prov) 
		{
				case "ALBERTA":
					province = "AB";
					break;
				case ("BRITISH COLUMBIA"):
				case ("COLOMBIE BRITANNIQUE"):
					province = "BC";
					break;
				case "MANITOBA":
					province = "MB";
					break;
				case ("NEW BRUNSWICK"):
				case ("NOUVEAU BRUNSWICK"):
					province = "NB";
					break;
				case "NEWFOUNDLAND AND LABRADOR":
					province = "NL";
					break;
				case ("NOVA SCOTIA"):
				case ("NOUVELLE-ÉCOSSE"):
					province = "NS";
					break;
				case ("NORTHWEST TERRITORIES"):
				case ("TERRITOIRES DU NORD-OUEST"):
					province = "NT";
					break;
				case "NUNAVUT":
					province = "NU";
					break;
				case "ONTARIO":
					province = "ON";
					break;
				case ("PRINCE EDWARD ISLAND"):
				case ("ÎLE-DU-PRINCE-ÉDOUARD"):
					province = "PE";
					break;
				case ("QUEBEC"):
				case ("QUÉBEC"):
					province = "QC";
					break;
				case "SASKATCHEWAN":
					province = "SK";
					break;
				case "YUKON":
					province = "YT";
					break;
		}
		updatedDetails.setSkIdIssuingAuthority(province);
		context.setDsaDmData(updatedDetails);
		return province;
	}

}