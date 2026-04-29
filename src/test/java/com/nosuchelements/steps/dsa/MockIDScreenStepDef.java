package com.nosuchelements.steps.dsa;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.MockIdPage;

import io.cucumber.java.en.And;

public class MockIDScreenStepDef extends BasePage {
	
	@Autowired
	private MockIdPage MI;
	
	@And("User on Mock Screen enters details for {string} SK")
	public void enterValue(String value) throws Exception {
//		MockScreen_dto mockElements =context.getMockDTO()!=null?context.getMockDTO(): new MockScreen_dto(); 
		try {
			switch(value) {
			case "Passed":
//				try {
				System.out.println("\n Filling the data on Mock Screen \n");
				Thread.sleep(10000);
				MI.passedApp(context.getDsaDmData());
				Thread.sleep(3000);
				clickElement(MI.getSubmitBtn());
				Thread.sleep(2000); 
//				}catch(Exception e) {
//					throw e;
//					System.out.println(" ERROR caught : Passed Mock Id \n");
//				}
				break;
			
			case "DOBMismatch":
//				try {
				System.out.println(" \n Entering data for DOB mismatch \n");
//				inputText(MI.getDob(), "12/01/1986");
//				inputText(MI.getDobMatchScore(),"50");
//				inputText(MI.getStreetAddress(),"H-461B SAINT CLARENS AVE");
//				inputText(MI.getCity(),"TORONTO");
				Thread.sleep(2000);
				MI.dobMismatch(context.getDsaDmData());
				Thread.sleep(5000);
				System.out.println("\n Clicking SUBMIT \n");
				clickElement(MI.getSubmitBtn());
				break;
				
			case "NameMismatch":
				Thread.sleep(2000);
				System.out.println("\n Filling the data on Mock Screen with different Name \n");
				MI.nameMismatch(context.getDsaDmData());
				// Keep Name different than application
//				MI.getFirstName().clear();
				Thread.sleep(4000);
//				inputText(MI.getFirstName(), "NCATLKLK");
//				inputText(MI.getProvince(), "AB");
//				inputText(MI.getFnMatchScore(),"-300");
				System.out.println("\n Going to select rejected flag");
				clickElement(MI.getRejMatch());
				Thread.sleep(5000);
				System.out.println("\n Clicking SUBMIT \n");
				clickElement(MI.getSubmitBtn());
				Thread.sleep(2000);
				break;
				
			case "ExpiredID":
				Thread.sleep(2000);
				System.out.println("\n Filling the data on Mock Screen with Expired ID \n");
				Thread.sleep(8000);
				MI.expiredID(context.getDsaDmData());
				clickElement(MI.getDocExpire());
//				clickElement(MI.getSupportedDoc());
				System.out.println("\n Rejected flag selected : Doc Expire \n");
				clickElement(MI.getRejMatch());
				clickElement(MI.getScanRej());
				Thread.sleep(3000);
				System.out.println("\n Clicking SUBMIT \n");
				clickElement(MI.getSubmitBtn());
				Thread.sleep(20000);
				break;
				
			case "InvalidID":
				Thread.sleep(5000);
				System.out.println("\n Filling the data on Mock Screen with Invalid ID \n");
				Thread.sleep(5000);
				MI.invalidID(context.getDsaDmData());
				clickElement(MI.getDataConsist());
				System.out.println("\n Clicked Data Consist : Rejected flag  \n");
				clickElement(MI.getRejMatch());
				Thread.sleep(1000);
				clickElement(MI.getSubmitBtn());
				System.out.println("\n Clicked SUBMIT \n");
				break;
			}//switch
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Enter details on Mock Screen \n" );
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Mock Screen enter {string} number and {string} type")
	public void enterSKdata(String idNum, String idType) throws Exception {
		DSA_DM updatedDetails = context.getDsaDmData();
		System.out.println("\n Entering SK ID type and Number on Mock Screen");
		Thread.sleep(5000);
		MI.passedApp(context.getDsaDmData());
		inputText(MI.getIdDocNum(),idNum);
		updatedDetails.setSkIdDocNumber(idNum);
		
		inputText(MI.getIdExpiry(),"01312027");
		updatedDetails.setSkIdExpiryDate("01312027");
		
		inputText(MI.getIssingCountry(),"CA");
		updatedDetails.setSkIdIssuingCountry("CA");
		
		clickElement(MI.getIdDocType());
		switch(idType) {
		
		case"national_card":
							clickElement(MI.getIdTypeNationalCard());
							updatedDetails.setSkIdDocType("national_card");
							break;
		
		case"drivers_license":
							clickElement(MI.getIdTypeDriverLic());
							updatedDetails.setSkIdDocType("drivers_license");
							break;
							
		case"passport":
							clickElement(MI.getIdTypePassport());
							updatedDetails.setSkIdDocType("passport");
							break;
							
		case"indigenous_card":
							clickElement(MI.getIdTypeIndigenous());
							updatedDetails.setSkIdDocType("indigenous_card");
							break;
							
		case"resident_permit":
							clickElement(MI.getIdTypeResident());
							updatedDetails.setSkIdDocType("resident_permit");
							break;
		case"unknown":
							clickElement(MI.getIdTypeUnknown());
							updatedDetails.setSkIdDocType("unknown");
							break;
		}
		Thread.sleep(3000);
		context.setDsaDmData(updatedDetails);
		clickElement(MI.getSubmitBtn());
		
	}

}
