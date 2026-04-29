package com.nosuchelements.steps.dsa;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.FinancialInformation;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class FinancialInfoStepDef extends BasePage {
	
	@Autowired
	private FinancialInformation FI;
	
	@Autowired
	private CommonUtils commutil;
	
	@And("User Validates Financial Information page")
	public void validateFinancialInfo() {
		try
		{
			FI._financialInformation(context.getDsaDmData());
		}catch(Exception e) {
			Assert.fail("Failed to Validate Personal Information page");
			e.printStackTrace();
		}
	}
	
	@And("User is on Financial Information Page")
	public void verifyFinancialInfo() {
		try
		{
//			Thread.sleep(8000);
			commutil.validate(context.getDsaDmData().getCardType());
			FI.validate();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate Financial Information");
			
		}
	}
	
	
	@And("User on Financial Information Page Clicks on {string} checkbox")
	@And("User on Financial Information Page Clicks on {string} Button")
	@And("User on Financial Information Page Clicks on {string} Link")
	public void clickOnElement(String fieldName) throws Exception {
		WebElement element = null;
		
		try
		{
			switch(fieldName) {
			case "Next":
				element = FI.getFiNextBtn();
				break;
			case "BackToReview":
				element = FI.getFiBackToReview();
				break;
			case "Next_ReviewPage":
				element = FI.getFiNextReviewBtn();
				break;
			case "UpsellLegalFooter":
				Thread.sleep(2000);
				element = FI.getUpsellLegalFooterbutton();
				break;
			case "DownsellLegalFooter":
				Thread.sleep(2000);
				element = FI.getDownsellLegalFooterButton();
				break;
			case "SavenPrint_Top":
				element = FI.getSaveorPrintTop();
				break;
			case "SavenPrint_Bottom_OMX":
				element = FI.getSaveorPrintBottom_downsell();
				break;
			case "SavenPrint_Bottom_OMZ":
				element = FI.getSaveorPrintBottom_upsell();
				break;
			case "EmploymentStatus":
				System.out.println("\n Clicking on dropdown");
				element = FI.getFinancialStatus();
				break;
			case "AnlPersonalInc":
				element = FI.getFiPersonalIncome();
				break;
			}
				clickElement(element);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on " + fieldName );
			throw new Exception(e);
		}
	}
	
	@And("User on Financial Information Page selects {string} for {string} popup")
	public void selectPopup(String opt, String type) {
		try {
			waitForSeconds(5);
			DSA_DM updatedDetails = context.getDsaDmData();
			switch(type) {
				case "IncomeCorrection":
					FI.incomeCorrectionPopup(opt);
					System.out.println(" Income Correction sslected \n");
					break;
				case "Upsell":
//					FI.validateCardName(type);
					FI.upsellPopup(opt);
					break;
				case "Downsell":
					FI.validateCardName(type);
					FI.downsellPopup(opt);
					break;
				case "UpsellConfirmation":
					FI.upsellConfirmation(opt);
					if(opt.equals("Agree"))
						updatedDetails.setCardType("OMZ");
					break;
				case "DownsellConfirmation":
					FI.downsellConfirmation(opt);
					if(opt.equals("Agree"))
						updatedDetails.setCardType("OMX");
					break;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on " + opt + " for "+ type + "popup");
		}
	}
	
	@When("User on Financial Information Page Selects {string} in {string} dropdown")
	public void selectOpt(String opt, String dropdown) throws Exception {
		try {
			DSA_DM updatedDetails = context.getDsaDmData();
			String value = null;
			switch (dropdown) {
			case "EmploymentStatus":
				switch (opt) {
				case "valid":
//					opt=getInputText("dd:DSA-FINANCIAL-INFO-0002");
//					FI.getFinancialStatus().click();
//					driverManager.getDriver().findElement(By.xpath("//li[@data-value='FULL_TIME']")).click();
					opt = FI.selectFullTime();
					break;
				case "Retired":
//					FI.getFinancialStatus().click();
//					driverManager.getDriver().findElement(By.xpath("//li[@data-value='RETIRED']")).click();
					opt = FI.selectRetired();
					break;
				case "Full time":
					opt = FI.selectFullTime();
					break;
				case "Part time less 25":
					opt = FI.selectPartTimeless();
					break;
				case "Part time more 25":
					opt = FI.selectPartTimemore();
					break;
				case "Seasonal":
					opt = FI.selectSeasonal();
					break;
				case "Homemaker":
					opt = FI.selectHomemaker();
					break;
				case "Unemployed":
					opt = FI.selectUnemployed();
					break;
				}
				updatedDetails.setEmployementstatus(opt);
				break;
			case "JobCategory":
				switch (opt) {
				case "valid":
//					opt=getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-010");
					opt=FI.selectDriver();
					break;
				case "Driver":
					opt=FI.selectDriver();
					break;
				case "ProductionWorker":
					opt=FI.selectProductionWorker();
					break;
				case "Guard":
					opt=FI.selectGuard();
					break;
				case "Owner":
					opt=FI.selectOwner();
					break;
				case "Homemaker":
					opt=FI.selectHomemaker();
					break;
				case "Labourer":
					opt=FI.selectLabourer();
					break;
				case "Management":
					opt=FI.selectManager();
					break;
				case "Military":
					opt=FI.selectMilitary();
					break;
				case "OfficeStaff":
					opt=FI.selectOfficeStaff();
					break;
				case "OfficeWorker":
					opt=FI.selectOfficeWorker();
					break;
				case "Professional":
					opt=FI.selectProfessional();
					break;
				case "Repairer":
					opt=FI.selectRepairer();
					break;
				case "Sales":
					opt=FI.selectSales();
					break;
				case "Service/Repair":
					opt=FI.selectService();
					break;
				case "Student":
					opt=FI.selectStudent();
					break;
				case "Trades":
					opt=FI.selectTrades();
					break;
				case "Other":
					opt=FI.selectOther();
					break;
				case "ParentalLeave":
					opt=FI.selectParental();
					break;
				case "RetailRep":
					opt=FI.selectRetailRep();
					break;
				}
				System.out.println("Selected option= " +opt);
				updatedDetails.setJobCategory(opt);
				break;
			case "JobTitle":
				WebElement element = FI.getFiJobTitle();
				
				if(opt.equalsIgnoreCase("valid")) {
					selectFromDropdownByIndex(element, 2);
					opt = element.getText();
				}
				else 
					selectFromDropdownByText(element,opt);
//					selectJobTitle(xpath, opt);
				updatedDetails.setJobTitle(opt);
				break;
			case "Month":
				if(opt.equalsIgnoreCase("valid")) {
					opt=getInputText("dd:DSA-MONTH-MARCH");
					selectFromDropdownByText(FI.getFiMonth(),opt );
				}
				else {
					 opt = getInputText("dd:DSA-MONTH-"+opt.toUpperCase());
					selectFromDropdownByText(FI.getFiMonth(),opt);
				}
				updatedDetails.setMonthOfEmployement(opt);
				break;
			
			case "PersFrequency":
				switch(opt) {
				case "Weekly":
						opt = FI.selectWeekly(dropdown);
					break;
				
				case "Bi-weekly":
					opt = FI.selectBiweekly(dropdown);
					break;
					
				case "Monthly":
					opt = FI.selectMonthly(dropdown);
					break;
					
				case "SemiMonthly":
					opt = FI.selectSemimonthly(dropdown);
					break;
					
				case "Annually":
					opt = FI.selectAnnually(dropdown);
					break;
				}
				updatedDetails.setPersonalIncFrequency(opt);
				String grossPerIncome = Integer.toString(FI.getGrossIncome(updatedDetails.getPersonalincome(),opt));
				updatedDetails.setGrossPersonalIncome(grossPerIncome);
				System.out.println("Pers Freq Selected: "+updatedDetails.getPersonalIncFrequency());
				break;
			case "HHFrequency":
				switch(opt) {
				case "Weekly":
						opt = FI.selectWeekly(dropdown);
					break;
				
				case "Bi-weekly":
					opt = FI.selectBiweekly(dropdown);
					break;
					
				case "Monthly":
					opt = FI.selectMonthly(dropdown);
					break;
					
				case "SemiMonthly":
					opt = FI.selectSemimonthly(dropdown);
					break;
					
				case "Annually":
					opt = FI.selectAnnually(dropdown);
					break;
				}
				updatedDetails.setHouseIncomeFrequency(opt);
				String grossHHIncome = Integer.toString(FI.getGrossIncome(updatedDetails.getHouseholdincome(),opt));
				updatedDetails.setGrossHouseholdIncome(grossHHIncome);
				System.out.println("Household Freq Selected: "+updatedDetails.getHouseIncomeFrequency());
				break;
			}
			
			context.setDsaDmData(updatedDetails);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to Select " + opt + " from " + dropdown + " Dropdown");
			throw new Exception(e);
		}
	}
	
	/*@And("User on Financial Information Page Selects {string} from JobTitle dropdown")
	public void selectJobTitle(String xpath, String option) throws Exception {
		
		String text = getInputText(option);
		try {
			List<String> options = retrieveValuesFromSelect(By.xpath(xpath));
				selectFromDropdownByText(By.xpath(xpath),text);
			
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to select " + option + " from Job title dropdown");
			e.printStackTrace();
			throw new Exception(e);
		}
	}*/
	
	@And("User on Financial Information Page Verifies the Inline Error Message for {string} Dropdown as {string} in {string} Colour")
	@And("User on Financial Information Page Verifies the Inline Error Message for {string} Field as {string} in {string} Colour")
	public void verifyerror(String fieldName, String _text, String colour) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "City":
				element = FI.getCityNameError();
				break;
			case "Employer":
				element = FI.getEmployerNameError();
				break;
			case "EmployerCity":
				element = FI.getCityNameError();
				break;
			case "EmploymentStatus":
				element = FI.getEmploymentStatusError();
				break;
			case "JobCategory":
				element = FI.getJobCategoryError();
				break;
			case "JobTitleOther":
				element = FI.getJobTitleOtherError();
				break;
			case "JobDescription":
				element = FI.getJobDescError();
				break;
			case "PhoneNumber":
				element = FI.getFiEmpPhoneError();
				break;
			case "Date":
				element = FI.getDateError();
				break;
			case "CreditLimit":
				element=FI.getCreditError();
				break;
			case "AnlPersonalInc":
				Thread.sleep(3000);
				element = FI.getFiPersonalIncomeError();
				System.out.println("Actual error Message :"+element.getText());
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

	@And("User on Financial Information Page Verifies the Inline Error Message for {string} Dropdown should not be displayed")
	@And("User on Financial Information Page Verifies the Inline Error Message for {string} Field should not be displayed")
	public void verifyErrorNotDisplayed(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "City":
				element = FI.getCityNameError();
				break;
			case "Employer":
				element = FI.getEmployerNameError();
				break;
			case "EmploymentStatus":
				element = FI.getEmploymentStatusError();
				break;
			case "JobCategory":
				element = FI.getJobCategoryError();
				break;
			case "JobTitle":
				element = FI.getJobDescError();
				break;
			case "PhoneNumber":
				element = FI.getFiEmpPhoneError();
				break;
			case "Date":
				element = FI.getDateError();
				break;
			case "AnlPersonalInc":
				element = FI.getFiPersonalIncomeError();
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

	@When("User on Financial Information Page Enters {string} in {string} Field")
	public void enterValue(String _text, String fieldName) throws Exception {
		WebElement element = null;
		String grossPerIncome = null;
		String text = getInputText(_text);
		try {
			DSA_DM updatedDetails = context.getDsaDmData();
			switch (fieldName) {
			case "Employer":
				element = FI.getFiEmployerName();
				if(text.equalsIgnoreCase("valid")) {
					text = "";
				}
				updatedDetails.setEmployerName(text);
				break;
			case "City":
				element = FI.getFiCity();
				if(text.equalsIgnoreCase("valid")) {
					text = "";
				}
				updatedDetails.setEmployerCity(text.replaceAll("[^a-zA-Z0-9]", ""));
				break;
			case "JobTitleOther":
				element = FI.getFiJobTitleOther();
				if(text.equalsIgnoreCase("valid")) {
					text = "";
				}
				updatedDetails.setJobTitleOther(text);
				break;
			case "JobDescription":
				element = FI.getFiJobDesc();
				Thread.sleep(1000);
				if(text.equalsIgnoreCase("valid")) {
					String text2 = null;
				    inputText(element, "Ma");
					int num = 4;
					System.out.println("Selecting JobDesc at"+getXpath(FI.getFiJobDescDatalist())+"//li["+num+"]");
					WebElement ele = getElementWhenVisible(By.xpath(getXpath(FI.getFiJobDescDatalist())+"//li["+num+"]"));
					text2 = ele.getText().trim();
					
					clickElementJS(ele);
					System.out.println("selected: "+text2);
					waitForSeconds(5);
					updatedDetails.setJobTitle(text2);
				}
				else if(text.equalsIgnoreCase("other")) {
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-017");
					element.clear();
					element.sendKeys(text);
					System.out.println("Setting Job Desc to "+text);
					updatedDetails.setJobTitle(text);
				}
				else {
					
					element.clear();
					element.sendKeys(text);
					clickElementJS(getElementWhenVisible(By.xpath("//ul[@id='jobDescList']//li[1]")));
//					getElementWhenVisible(By.xpath("//ul[@id='jobDescList']//li[1]")).click();
					updatedDetails.setJobTitle(text);
				}
				
				break;
			case "PhoneNumber":
				element = FI.getFiEmpPhone();
				switch (text) {
				case "valid":
					text= "";
					break;
				case "invalid":
					text= "36735533";
					break;
				}
				break;
			case "Year":
				element = FI.getFiYear();
				if(text.equals("valid"))
					text=Integer.toString(1980);
				updatedDetails.setYrOfEmployement(text);
				break;
			case "AnlPersonalInc":
				Thread.sleep(1000);
				element = FI.getFiPersonalIncome();
//				if(text.equalsIgnoreCase("valid")) {
//					text = MiscFunctions.ge(text);
//				}
				updatedDetails.setPersonalincome(text);
				if(updatedDetails.getPersonalIncFrequency()!=null) {
					grossPerIncome = Integer.toString(FI.getGrossIncome(text, updatedDetails.getPersonalIncFrequency()));
					updatedDetails.setGrossPersonalIncome(grossPerIncome);
				}
				else
					updatedDetails.setGrossPersonalIncome(text);
				break;
			case "AnlHousingInc":
				element = FI.getFiHouseIncome();
				if(text.equalsIgnoreCase("valid")) {
					text = Integer.toString(100);
				}
				updatedDetails.setHouseholdincome(text);
				if(updatedDetails.getHouseIncomeFrequency()!=null) {
					grossPerIncome = Integer.toString(FI.getGrossIncome(text, updatedDetails.getHouseIncomeFrequency()));
					updatedDetails.setGrossHouseholdIncome(text);
				}
				else
					updatedDetails.setGrossHouseholdIncome(text);
				Thread.sleep(1000);
				break;
			case "ReqCreditLimit":
				element=FI.getCreditLimitInput();
				if(text.equalsIgnoreCase("valid")) {
					text = Integer.toString(199);
					updatedDetails.setCreditLimit(text);
					System.out.println("FI : Valid credit Limit set to : "+updatedDetails.getCreditLimit());
				}
				else {
						updatedDetails.setCreditLimit(text);
						System.out.println("** FI : Credit Limit set to : "+updatedDetails.getCreditLimit());
				}
				break;
			}
			
//			if(fieldName.equals("JobDescription") ){//&& isElementVisible(By.element("(//datalist[@id='jobDescriptions']/option[1]"))) {
////				clickElementJS(By.element("(//datalist[@id='jobDescriptions']/option[1]"));
//				updatedDetails.setJobTitle(text);
//				
//			}
//			else
			if(!fieldName.equals("JobDescription")) {
				element.clear();
				element.sendKeys(text);
				if(fieldName.equals("AnlPersonalInc")||fieldName.equals("AnlHousingInc")) {
					Actions actions = new Actions(driverManager.getDriver());
//					actions.moveToElement(element).click().sendKeys(Keys.TAB).perform();
				}
			}
			context.setDsaDmData(updatedDetails);
		
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to Enter " + _text + " in " + fieldName + " Field");
			throw new Exception(e);
		}
	}
	@And("User on Financial Information Page Verifies {string} label should be {string}")
	@And("User on Financial Information Page Verifies {string} text should be {string}")
	public void verifyText(String fieldName, String _text) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "Header":
				element = FI.getFinancialHeader();
				break;
			case "EmpStatusHeader":
				element = FI.getEmployStatusHeader();
				break;
//			case "RequiredFieldAdvisory":
//				element = requiredFieldAdvisory;
//				break;
			case "EmploymentStatus":
				element = FI.getFiStatusLabel();
				break;
			case "Employer":
				element = FI.getFiEmployerLabel();
				break;
			case "EmploymentInfoText":
				System.out.println(" \n Validating helper text \n ");
				element = FI.getProvidingHelperText();
				break;
			case "City":
				element = FI.getFiCityLabel();
				break;
			case "JobCategory":
				element = FI.getFiJobCategoryLabel();
				break;
			case "JobDescription":
				element = FI.getFiJobDescLabel();
				break;
//			case "jobTitleOther":
//				element = jobTitleOtherLabel;
//				break;
			case "EmployerPhone":
				element = FI.getFiEmpPhoneLabel();
				break;
			case "Month":
				element = FI.getFiMonthLabel();
				break;
			case "Year":
				element = FI.getFiYearLabel();
				break;
			case "FinancesHeader":
				element = FI.getFinancesHeader();
				break;
			case "AnlPersonalInc":
				element = FI.getFiPersonalIncomeLabel();
				break;
			case "AnlHousingInc":
				element = FI.getFiHouseIncomeLabel();
				break;
			case "Next":
				element = FI.getFiNextBtn();
				break;
			case "PersonalIncFreqHelperText":
				element=FI.getFiPersonalIncomeFreqHelperText();
				System.out.println("PersIncHlperText : "+element.getText());
				break;
			case "HouseIncFreqHelperText":
				element = FI.getFiHouseIncomeFreqHelperText();
				System.out.println("HouseIncHlperText : "+element.getText());
				break;
			case "LegalFootnotes":
				element = FI.getLegalFooternotes();
				FI.getLegalFootNotesExpand().click();
				break;
			case "UpsellLegalNotes":
				FI.getUpsellLegalFooterbutton().click();
				element = FI.getUpsellLegalText();
//				expText = expText.replaceAll("triangle.com" , "");
				break;
			case "DownsellLegalNotes":
				FI.getDownsellLegalFooterButton().click();
				element = FI.getDownsellLegalText();
//				expText = expText.replaceAll("triangle.com" , "");
				break;
			case "CreditLimitHeader":
				element = FI.getPrefCreditHeader();
				break;
			case "CreditHelperText":
				element = FI.getCreditHelperText();
				break;
			}
			validateText(element, expText);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify " + fieldName + " with " + _text);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Financial Information Page Verifies header text")
	public void verifyHeaderText() throws Exception {
		try {
			validateText(getInputText("dd:normalized:DSA-IBM-FINANCIAL-INFO-0003")+" "+getInputText("dd:normalized:DSA-IBM-REQ-HEADLINE"),FI.getFinancialHeader().getText(),true);
		}catch(Exception e) {
			System.out.println("  ERROR : **** ");
			throw e;
		}
	}
	
	@And("User on Financial Information Page verifies {string} label should be {string} for mandatory field")
	public void verifyMandatoryField(String fieldName, String _text) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "EmploymentStatus":
				element = FI.getFiStatusLabel();
				break;
			case "EmploymentStatusReq":
				element = FI.getFiStatusLabel();
				break;
			case "Employer":
				element = FI.getFiEmployerLabel();
				break;
			case "City":
				element = FI.getFiCityLabel();
				break;
			case "JobCategory":
				element = FI.getFiJobCategoryLabel();
				break;
			case "JobDescription":
				element = FI.getFiJobDescLabel();
				break;	
			case "AnlPersonalInc":
				element = FI.getFiPersonalIncomeLabel();
				break;
			case "EmployerPhone":
				element = FI.getFiEmpPhoneLabel();
				break;
			case "Month":
				element = FI.getFiMonthLabel();
				break;
			case "Year":
				element = FI.getFiYearLabel();
				break;
			case "CreditLimit":
				element = FI.getCreditLabel();
				break;
			}
			validateText(element, expText+"dd:DSA-IBM-REQ");
			}catch(Exception e) {
				
			}
	}
	
	@And("User on Financial Information Page Verifies {string} default text should be {string}")
	public void verifyDefaultText(String fieldName, String _text) throws Exception {
		try {
			String expText = getInputText(_text);
			String actualValue = "";
			switch (fieldName) {
			case "EmploymentStatus":
				actualValue = retrieveValueFromSelect(FI.getFinancialStatus());
				break;
			case "Employer":
				actualValue = getAttribute(FI.getFiEmployerName(), "placeholder");
				break;
			case "City":
				actualValue = getAttribute(FI.getFiCity(), "placeholder");
				break;
			case "JobCategory":
				actualValue = retrieveValueFromSelect(FI.getFiJobCategory());
				break;
			case "JobDescription":
				actualValue = getAttribute(FI.getFiJobDesc(), "placeholder");
				break;
			}
			validateText(actualValue, expText);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify " + fieldName + " with " + _text);
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Financial Information Page Verifies {string} dropdown")
	@And("User on Financial Information Page Verifies {string} Field")
	@And("User on Financial Information Page Verifies {string} Button")
	public void verifyfield(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "EmploymentStatus":
				element = FI.getFinancialStatus();
				break;
			case "Employer":
				element = FI.getFiEmployerName();
				break;
			case "City":
				element = FI.getFiCity();
				break;
			case "JobCategory":
				element = FI.getFiJobCategory();
				break;
			case "JobDescription":
				element = FI.getFiJobDesc();
				break;
			case "JobTitleOther":
				element = FI.getFiJobTitleOther();
				break;
			case "EmployerPhone":
				element = FI.getFiEmpPhone();
				break;
			case "Month":
				element = FI.getFiMonth();
				break;
			case "Year":
				element = FI.getFiYear();
				break;
			case "AnlPersonalInc":
				element = FI.getFiPersonalIncome();
				break;
			case "AnlHousingInc":
				element = FI.getFiHouseIncome();
				break;
			case "Next":
				element = FI.getFiNextBtn();
				break;
			case "CreditLimitInput":
				element = FI.getCreditLimitInput();
				break;
			}
			if (!isElementVisible(element)) {
				Assert.fail("Failed to Validate visibility of" + fieldName);
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Validate visibility of" + fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@When("User on Financial Information Page Verifies {string} Field is disabled and cleared")
	public void verifydisabledAndClear(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "Employer":
				element = FI.getFiEmployerName();
				break;
			case "City":
				element = FI.getFiCity();
				break;
			case "JobDescription":
				element = FI.getFiJobDesc();
				break;
			case "JobTitleOther":
				element = FI.getFiJobTitleOther();
				break;
			}
			if (isElementVisible(element) || !waitForEmptyText(element)) {
				Assert.fail("Failed to verify Disability of " + fieldName + " Field");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Disability of " + fieldName + " Field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@When("User on Financial Information Page Verifies {string} Dropdown menu is disabled and cleared")
	public void verifydisabledAndClearDropdown(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "JobCategory":
				element = FI.getJobCategoryContainer();
//				Thread.sleep(9000);
				break;
			case "EmploymentStatus":
				element = FI.getFinancialStatus();
				break;
			}
			if(isElementVisible(element)) {
//			if (!waitForDisabled(By.xpath(xpath))) {
				Assert.fail("Failed to verify Disability of " + fieldName + " Field");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Disability of " + fieldName + " Field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Financial Information Page Verifies {string} Displays in {string} dropdown")
	public void verifyDropdownOptions(String option, String fieldName) throws Exception {
		WebElement element = null;
		String text = getInputText(option);
		try {
			switch (fieldName) {
			case "JobCategory":
				element = FI.getFiJobCategory();
				switch(text) {
				case "Driver":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-001");
					break;
				case "Factory Worker":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-030");
					break;
				case "Guard/Police":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-024");
					break;
				case "Internship":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-018");
					break;
				case "Labourer":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-004");
					break;
				case "Management":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-026");
					break;
				case "Military":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-006");
					break;
				case "Office Worker":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-027");
					break;
				case "Professional":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-010");
					break;
				case "Service/Repair":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-028");
					break;
				case "Sales":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-012");
					break;
				case "Retail Representative":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-021");
					break;
				case "Student":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-014-JOB-TITLE-001");
					break;
				case "Trades":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-015");
					break;
				case "Other":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-015-JOB-TITLE-026");
					break;
				case "Owner":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-008");
					break;
				case "Medical Field":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-019");
					break;
				case "Parental Leave":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-020");
					break;
				case "Student Coop Placement":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-023");
					break;
				case "Sabbatical":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-022");
					break;
				case "Cust Service/Hospitality/Tourism":
					text = getInputText("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-029");
					break;
				}
				break;
			case "JobTitle":
				element = FI.getFiJobTitle();
				break;
			}
			List<String> options = retrieveValuesFromSelect(element);
			if(!options.contains(text)) {
			Assert.fail("Failed to verify " + option + " Displays in" + fieldName + " dropdown");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify " + option + " Displays in" + fieldName + " dropdown");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	
	@And("User on Financial Information Page Verifies {string} suggestion in JobDescription Field")
	public void verifyJobDesc(String option) throws Exception {
		String actualOption=null;
		List<WebElement> options = driverManager.getDriver().findElements(By.xpath("//li[contains(@data-ng-repeat,'jobDescription')]"));
		System.out.println("No.Of Options"+options.size());
    	for (WebElement el : options) {
    		actualOption = el.getText().toLowerCase();
    		System.out.println("Verifying"+actualOption);
//    		if((Pattern.matches("*["+option+"]*", actualOption))) {
    		if(actualOption.contains(option)) {
    			System.out.println("Matched");
    		}
    		else
    			System.out.println("Not Matched");
    	}
		
	}
	

	@And("User on Financial Information Page Verifies {string} suggestion in {string} Field")
	public void verifyFieldOptions(String option, String fieldName ) throws Exception {
		WebElement element = null;
		
		String[] Jobtitlelist = option.split(",");
		List<String> expJobtitlelist = new ArrayList<>();
		for (String JobTitle : Jobtitlelist) {
			expJobtitlelist.add(JobTitle.trim());
		}
		try {
			
			switch (fieldName) {
			case "JobTitle":
				element = FI.getFiJobTitle();
				break;
			case "JobDescription":
				element = FI.getFiJobDescDatalist();
				break;
			}
			
			List<WebElement> options = driverManager.getDriver().findElements(By.xpath(getXpath(element)+"//option"));
			List<String> ActualSuggestionList = new ArrayList<String>();
	    	for (WebElement el : options) {
	    		ActualSuggestionList.add(el.getAttribute("value"));
	    		System.out.println("Actual List: "+el.getAttribute("value"));
	    	}
			
			if (!expJobtitlelist.equals(ActualSuggestionList)) {
				Assert.fail("Failed to verify " + option + " Displays in" + fieldName + " dropdown");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify " + option + " Displays in" + fieldName + " dropdown");
			
			throw new Exception(e);
		}
	}
	
	@And("User on Financial Information Page leaves {string} Field")
	public void leaveField(String field) throws Exception {
		try {
			WebElement element = null;
			switch (field) {
			case "Employer":
				element = FI.getFiEmployerName();
				break;
			case "City":
				element = FI.getFiCity();
				break;
			case "JobTitle":
				element = FI.getFiJobTitle();
				break;
			case "JobTitleOther":
				element = FI.getFiJobTitleOther();
				break;
			
			}
			FI.userLeavesField(element);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to leave " + field + " field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Financial Information Page Verifies {string} Popup is displayed")
	public void verifyPopup(String field) throws Exception {
		try {
			WebElement element = null;
			switch (field) {
			case "IncomeCorrection":
				element = FI.getIncomeCorrectPopup();
				break;
			case "Upsell":
				element = FI.getUpsellPopup();
				break;
			case "Downsell":
				element = FI.getDownsellPopup();
				break;
			case "UpsellConfirmation":
				element = FI.getUpsellAgreeBtn();
				break;
			case "DownsellConfirmation":
				element = FI.getDownsellAgreeBtn();
				break;
			
			}
//			getElementWhenVisible(By.xpath(xpath));
			if(!isElementVisible(element))
				Assert.fail("Failed to display " + field + "popup");
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify " + field + "popup is displayed");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Financial Information Page Verifies {string} in {string} Field")
	public void verifyDataInnField(String data, String field) throws Exception {
		WebElement element = null;
		try {
			switch (field) {
			
			case "PhoneNumber":
				element = FI.getFiEmpPhone();
				break;
			case "ReqCreditLimit":
				element = FI.getCreditLimitInput();
				break;
			}
			String actual = "";
			if (data.equalsIgnoreCase("blank")) {
				data = "";
			}
			element.sendKeys(Keys.TAB);
//			System.out.println("xpath is " + xpath);
			actual = getAttribute(element, "value");
			System.out.println("Actual Text " + actual.replaceAll("[,.]", "").replaceAll("[$, ]", "").trim());
			System.out.println("Expected Text " + data);
			if (!data.equalsIgnoreCase(actual.replaceAll("[,.]", "").replaceAll("[$, ]", "").trim())) {
				log.info("Failed to verify Financial Information Page Verifies " + data + " in " + field
						+ " field");
				Assert.fail("Failed to verify Financial Information Page Verifies " + data + " in "
						+ field + " field");
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Financial Information Page Verifies " + data + " in " + field
					+ " field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User validates APR in Legal footer on {string} popup")
	public void validateLegalDescPopup(String field) throws Exception {
		try {
			WebElement element = null;
			switch (field) {
			case "Upsell":
				 Thread.sleep(1000);
				 FI.getUpsellLegalFooterbutton().click();
				 element = driverManager.getDriver().findElement(By.xpath("//div[@class='marTop10 col-md-12 col-xs-12 upDownSellModalLegal-OMZ']"));
				 String legalText = element.getText();
				 if(context.getDsaDmData().getLanguage().contains("E")){
				 	if(legalText.indexOf("related fees and 21.99% ")<0) {
				 		Assert.fail("\n 1) Legal Footer rate text does not match \n");
				 	}
				 	if(legalText.indexOf("assuming that all charges are purchases bearing interest at the regular annual rate of 21.99%")<0) {
				 		Assert.fail("\n 2) Legal Footer rate text does not match \n");
				 	}
				 	try {
						String dateParagraph = FI.getEffDateUpsell().getText();
						if(dateParagraph.indexOf("Information effective as of March 6 2024.")>=0) {
							System.out.println(" \n Effective Date validated\n");
						}
					}catch(Exception e) {
						log.info( "\n FAILED : Effective date not validated: Upsell ENG\n");
						throw e;
					}
				 }
				 else {
					 if(legalText.indexOf("21,99 % ")<0) {
					 		Assert.fail("\n 1) FRC Legal Footer rate text does not match \n");
					 	}
					 	if(legalText.indexOf("21,99 %")<0) {
					 		Assert.fail("\n 2) FRC Legal Footer rate text does not match \n");
					 	}
					try {
					 	String dateParagraph = FI.getEffDateUpsell().getText();
						if(dateParagraph.indexOf("6 mars 2024")>=0) {
							System.out.println(" \n Effective Date validated FRC\n");
						}
					}catch(Exception e) {
						log.info( "\n FAILED : Effective date not validated: Upsell FRC\n");
						throw e;
					}
				 }
				 
				break;
			case "Downsell":
				Thread.sleep(1000);
				FI.getDownsellLegalFooterButton().click();
				 element = driverManager.getDriver().findElement(By.xpath("//div[@class='marTop10 col-md-12 col-xs-12 upDownSellModalLegal-OMX']"));
				 String legalTextpara = element.getText();
				if(context.getDsaDmData().getLanguage().contains("E")) {
				 	if(legalTextpara.indexOf("related fees and 21.99% ")<0) {
				 		Assert.fail("\n 1) Legal Footer rate text does not match \n");
				 	}
				 	if(legalTextpara.indexOf("assuming that all charges are purchases bearing interest at the regular annual rate of 21.99%")<0) {
				 		Assert.fail("\n 2) Legal Footer rate text does not match \n");
				 	}
				 	try {
						String dateParagraph = FI.getEffDateDownsell().getText();
						if(dateParagraph.indexOf("Information effective as of March 6 2024.")>=0) {
							System.out.println(" \n Effective Date validated\n");
						}
					}catch(Exception e) {
						log.info( "\n FAILED : Effective date not validated: Downsell ENG\n");
						throw e;
					}
				 }
				 else {
					 if(legalTextpara.indexOf("21,99 % ")<0) {
					 		Assert.fail("\n 1) FRC Legal Footer rate text does not match \n");
					 	}
					 	if(legalTextpara.indexOf("21,99 %")<0) {
					 		Assert.fail("\n 2) FRC Legal Footer rate text does not match \n");
					 	}
					try {
						 	String dateParagraph = FI.getEffDateDownsell().getText();
							if(dateParagraph.indexOf("6 mars 2024")>=0) {
								System.out.println(" \n Effective Date validated FRC\n");
							}
						}catch(Exception e) {
							log.info( "\n FAILED : Effective date not validated: Downsell FRC\n");
							throw e;
						}
				 }
				break;
			}
			if(!isElementVisible(element))
				Assert.fail("Failed to display Legal footer on" + field + "popup");
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify legal footer " + field + "popup is displayed");
			e.printStackTrace();
			throw new Exception(e);
		}
	}		
	
	
//	For TC-23186
	@When("User on Financial Information Page Enters {string} in Job Description Field")
	public void validateMaitre(String _text) throws Exception {
		WebElement element = null;
		String text = getInputText(_text);
		try {
			DSA_DM updatedDetails = context.getDsaDmData();
			element = FI.getFiJobDesc();
			Thread.sleep(1000);
			String text2 = null;
			element.sendKeys(text);
			System.out.println("Selecting JobDesc at"+getXpath(FI.getFiJobDescDatalist())+"//li[1]");
			WebElement ele = getElementWhenVisible(By.xpath(getXpath(FI.getFiJobDescDatalist())+"//li[1]"));
			text2 = ele.getText().trim();
			clickElementJS(ele);
    		System.out.println("Retreived Job Desc: "+text2);
   			Assert.assertEquals(text2,"Maître D'","Failed to validate retreived Job Description : Maître D'");
			element.clear();
			element.sendKeys("Maître D'");
			Assert.assertEquals(text2,"Maître D'","Failed to validate Job Description : Maître D'");
			System.out.println("Setting Job Desc to : "+text);
			updatedDetails.setJobTitle(text);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@And("User on Financial Information Page validate {string} in {string} popup")
	public void validatePopupText(String fieldToValidate, String field) throws Exception {
		String legalFooterText;
		String modalText;
		Thread.sleep(2000);
		try {
			switch(field) {
			case "upsell":
				if(fieldToValidate.equalsIgnoreCase("LegalFooter")||fieldToValidate.contains("APR")) {
					legalFooterText=FI.getUpsellLegalText().getText();
					validateText(legalFooterText,getInputText("dd:normalized:DSA-FOOTER-LEGAL-CARD-SELECT-UP"),true);
				}
				else if(fieldToValidate.equalsIgnoreCase("ModalText")) {
//					modalText = FI.getDownsellPopupText().getText();
					modalText =driverManager.getDriver().findElement(By.xpath("//ul[@class='updownsell-modal-list']/li[4]")).getText();
//					validateText(getInputText("dd:normalized:DSA-IBM-FINANCIAL-INFO-MODAL-07"), modalText, true);
					validateText(modalText,getInputText("dd:normalized:DSA-IBM-UP-SELL-MODAL-005"), true);
				}
				break;
			case "downsell":
				if(fieldToValidate.equalsIgnoreCase("legalFooter")||fieldToValidate.contains("APR")) {
					legalFooterText=FI.getDownsellLegalText().getText();
					validateText(legalFooterText,getInputText("dd:normalized:DSA-FOOTER-LEGAL-CARD-SELECT"),true);
				}
				else if(fieldToValidate.equalsIgnoreCase("ModalText")) {
//					modalText = FI.getUpsellPopupText().getText();
					modalText =driverManager.getDriver().findElement(By.xpath("//ul[@class='updownsell-modal-list']/li[4]")).getText();
					validateText(modalText,getInputText("dd:normalized:DSA-IBM-FINANCIAL-INFO-MODAL-07"),true);
				}
				break;
			case "upsell_confirmation":
				if(fieldToValidate.equalsIgnoreCase("BottomLine")){
					System.out.println("\n ^ Verifying COCD Triangle mastercard text ^\n");
					validateText(FI.getBottomLine_upsellCOCD().getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0039"),true);
				}
				else if(fieldToValidate.equalsIgnoreCase("OMZVerbiage")){
					System.out.println("\n ^ Verifying COCD Triangle mastercard text ^\n");
					validateText(FI.getBottomLine_upsellCOCD().getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0039"),true);
				}
				else {
					System.out.println("\n Invalid option selected for Upsell confirmation COCD popup text \n" );
				} 
				break;
			case "downsell_confirmation":
				if(fieldToValidate.equalsIgnoreCase("OMXVerbiage")){
					System.out.println("\n ^ Verifying COCD Triangle mastercard text ^\n");
					validateText(FI.getOMXVerbiage_downsellCOCD().getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0037"),true);
				}
				else {
					System.out.println("\n Invalid option selected for Upsell confirmation COCD popup text \n" );
				} 
				break;
			}
		}
		catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify text for " + field + "popup ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	
	@And("User on Financial Information Page validates {string} in COCD PDF")
	public void validatePDFText(String fieldToValidate) throws Exception {
		try {
			String pdfText="";
			String modalText ="";
			switch(fieldToValidate) {
			case "OMXVerbiage":
				pdfText = FI.getPDFText();
				pdfText = commutil.trimText(pdfText, true);
				System.out.println("\n ^ Verifying COCD OMX verbiage ^\n");
//				pdfText.contains(MS.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0039"),true));
//				getInputText("dd:normalized:DSA-COST-OF-CREDIT-0028")+"3 of the amount of the transaction, up to a maximum of 10 - charged for cash withdrawals and other cash transactions (excluding balance transfers and convenience cheques) when the transaction is posted to your account.
//			    pdfText.contains(MS.trimText("3%"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0029"), true));
			    if(context.getLanguage().contains("E"))
					modalText=commutil.trimText("Information effective as of December 10, 2025.", true);
				else
					modalText=commutil.trimText("Les renseignements sont en vigueur à compter du 10 Décembre 2025.", true);
			    Assert.assertTrue(pdfText.contains(modalText));
			    System.out.println(" Changes validated on Fin Page Modal pdf : OMX \n");
				break;
			case "OMZVerbiage":
				pdfText = FI.getPDFText();
				pdfText = commutil.trimText(pdfText, true);
				System.out.println("\n ^ Verifying COCD OMZ Verbiage ^\n");
//				pdfText.contains(MS.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0040"),true));
//			    pdfText.contains(MS.trimText("3%"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0029"), true));
			    if(context.getLanguage().contains("E"))
					modalText=commutil.trimText("Information effective as of December 10, 2025.", true);
				else
					modalText=commutil.trimText("Les renseignements sont en vigueur à compter du 10 Décembre 2025.", true);
			    Assert.assertTrue(pdfText.contains(modalText));
			    System.out.println(" Changes validated on Fin Page Modal pdf : OMZ \n");
				break;
			case "BottomLine":
				System.out.println("\n ^ Verifying COCD OMZ Bottom line ^\n");
				pdfText.contains(commutil.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0039"),true));
				break;
			}
		}
		catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify text for " + fieldToValidate + "popup ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	
	@And("User on Financial Information Page validates there is No Select option in dropdown")
	public void validateSelectisNotanOption() {
		    WebElement dropdownElement = FI.getFinancialStatus();
		    Select dropdown = new Select(dropdownElement);
		    List <WebElement> allOpt = dropdown.getOptions();
		    List <String > allValues = new ArrayList<>();
		    for (WebElement we : allOpt) {
		    	allValues.add(we.getText());
		    }	
		    System.out.println( allValues +"\n");
		    	if(allValues.contains(getInputText("dd:normalized:DSA-SELECT-DROPDOWN"))) {
			    	System.out.println( "Select option present in dropdown *********");
				    Assert.assertFalse(true, "Select option present in dropdown *");
			    }
			    else {
			    	System.out.println( "Select option not present in dropdown *********");
			    	Assert.assertTrue(true, "Select option not present \n");
		    	}
	}
	
	@And("User on Financial Information Page validates helper text in french")
	public void validateFrcHelperText() throws Exception {
		System.out.println(" \n Validating helper text in frc \n ");
		WebElement element = FI.getProvidingHelperText();
		validateText(element,"Le fait de fournir des renseignements sur votre emploi peut nous aider à vérifier votre source de revenu.");
	}

	@And("User on Financial Information Page validates gross calculated {string} income")
//	@And("User on Financial Information Page validates gross calculated personal income")
	public void validateGrossPersonal(String incType) throws Exception {
		try {
				DSA_DM updatedDetails = context.getDsaDmData();
				switch(incType) {
				case"Personal":
					String givenGrossPersIncome = updatedDetails.getGrossPersonalIncome();
					String actualGrossPersIncome = FI.getFiGrossPersonalIncCalulated().getText();
							System.out.println("Gross Personal Income before editing:"+actualGrossPersIncome);
							System.out.println("Language :"+updatedDetails.getLanguage());
							if(updatedDetails.getLanguage().startsWith("E"))
								actualGrossPersIncome = actualGrossPersIncome.replaceAll(".00$","").replaceAll("[\\$, ]","");
							else
								actualGrossPersIncome = actualGrossPersIncome.replaceAll(",00","").replaceAll("[\\$, ]","");
							System.out.println("Gross Income After Editing:"+actualGrossPersIncome);
							Assert.assertEquals(givenGrossPersIncome,actualGrossPersIncome, "Failed to validate Gross Annual Personal Income \n");
							break;
				case"Household":
					String givenGrossHHIncome = updatedDetails.getGrossHouseholdIncome();
					String actualGrossHHIncome = FI.getFiGrossHouseIncCalulated().getText();
						System.out.println("Gross Household Income before editing:"+actualGrossHHIncome);
						System.out.println("Language :"+updatedDetails.getLanguage());
						if(updatedDetails.getLanguage().startsWith("E"))
							actualGrossHHIncome = actualGrossHHIncome.replaceAll(".00$","").replaceAll("[\\$, ]","");
						else
							actualGrossHHIncome = actualGrossHHIncome.replaceAll(",00","").replaceAll("[$, ]","");
						System.out.println("Gross Household Income after Editing:"+actualGrossHHIncome);
						Assert.assertEquals(givenGrossHHIncome,actualGrossHHIncome, "Failed to validate Gross Annual Household Income \n");
						break;
						}
				System.out.println("Validation for Gross "+incType+" Income passed \n");
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	@And("User on Financial Information Page validates {string} label for {string}")
	public void validateLabels(String value, String field) throws Exception {
		try {
			
				switch(field) {
				case "HouseholdInc":
				
							switch(value) {
//								case "Required":
//										validateText(getInputText("dd:normalized:DSA-IBM-FINANCIAL-INFO-0015")+getInputText("dd:normalized:DSA-IBM-REQ"),FI.getFiHouseIncomeLabel().getText(), true);
//									    break;
								case "Optional":
										validateText(getInputText("dd:normalized:DSA-IBM-FINANCIAL-INFO-0016")+getInputText("dd:normalized:DSA-IBM-OPT"),FI.getFiHouseIncomeLabel().getText(), true);
									    break;
							}
					break;
					
				case "HHIncFrequency":
							switch(value) {
								case "Required":
										validateText(getInputText("dd:normalized:DSA-FINANCIAL-INFO-0040")+getInputText("dd:normalized:DSA-IBM-REQ"),FI.getFiHouseIncomeFreqLabel().getText(), true);
									    break;
								case "Optional":
										validateText(getInputText("dd:normalized:DSA-FINANCIAL-INFO-0040")+getInputText("dd:normalized:DSA-IBM-OPT"),FI.getFiHouseIncomeFreqLabel().getText(), true);
									    break;
							}
					break;
					
				case "CreditLimit":
					switch(value) {
						case "Required":
								validateText(getInputText("dd:normalized:DSA-IBM-FINANCIAL-INFO-0019")+getInputText("dd:normalized:DSA-IBM-REQ"),FI.getCreditLabel().getText(), true);
							    break;
						
					}
			break;
				}
			}catch(Exception e) {
				throw e;
			}
	}
	
	@And("User on Financial Information Page validates {string} dropdown values")
	public void verifyDropdownOptions(String fieldName) throws Exception {
		WebElement element = null;
		List<String> expectedValues = Arrays.asList("Anually", "Monthly","Semimonthly", "Weekly","Bi-Weekly");
		boolean isValid = true;
		try {
			switch(fieldName) {
			case "PersonalIncFreq":
				element = FI.getFiPerIncFreqDropdown();
				break;
			case "HHIncFreq":
				element = FI.getFiPerIncFreqDropdown();
				break;
			}
			List<String> options = retrieveValuesFromSelect(element);
			if (options.size() == expectedValues.size()) {
	            for (int i = 0; i < expectedValues.size(); i++) {
	                String expectedValue = expectedValues.get(i);
	                String actualValue = options.get(i);

	                if (!actualValue.equals(expectedValue)) {
	                    System.out.println("Option at index " + i + " is incorrect. Expected: " + expectedValue + ", Found: " + actualValue);
	                    isValid = false;
	                }
	            }
	        } else {
	            System.out.println("Dropdown size mismatch. Expected: " + expectedValues.size() + ", Found: " + options.size());
	            isValid = false;
	        }
			if (isValid) {
	            System.out.println("All expected options are present in the dropdown in the correct order.");
	        }
			String selectedValue = FI.getSelectedFrequency(element);
			Assert.assertEquals(selectedValue, "ANNUALLY","Default selection is not matching");
		}catch(Exception e) {
			throw e;
		}
		
		}
	
	@And("User on Financial Information Page closes pdf")
	public void closePDF() throws Exception {
		try {
			FI.closeCOCD();
		}catch(Exception e) {
			throw e;
		}
	}

}
