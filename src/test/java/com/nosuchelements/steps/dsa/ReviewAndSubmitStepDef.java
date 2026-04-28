package com.nosuchelements.steps.dsa;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.config.PropertyConfig;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.ReviewAndSubmitPage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;
import com.nosuchelements.utils.dsa.CommonUtils;
import com.nosuchelements.utils.dsa.pdfUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ReviewAndSubmitStepDef extends BasePage {

	ArrayList<String> tabs;

	@Autowired
	private ReviewAndSubmitPage RS;

	@Autowired
	private pdfUtil PU;
	
	@Autowired
	private CommonUtils commutil;

	@Autowired
	private PropertyConfig applicationProperties;

	@And("User is on Review Page")
	public void verifyReviewPage() {
		try {
			Thread.sleep(3000);
			System.out.println("DSA DM FirstName: " + context.getDsaDmData().getFirstName());
			System.out.println("DSA DM LastName: " + context.getDsaDmData().getLastName());
			commutil.validate(context.getDsaDmData().getCardType());
			RS.validate();
		} catch (Exception e) {
			Assert.fail("Failed to Validate Review Page");
			e.printStackTrace();
		}
	}

	@And("User Reviews and Click on Submit")
	public void reviewAndClickSubmit() {
		try {
			RS.reviewAndSubmit(context.getDsaDmData());
		} catch (Exception e) {
			Assert.fail("Failed to Review and Click on Submit button");
			e.printStackTrace();
		}
	}

	@And("User on Review Page Verifies {string} link")
	@And("User on Review Page Verifies {string} checkbox")
	@And("User on Review Page Verifies {string} button")
	public void verifyfield(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "TnCPDF":
				element = RS.getTnCPdflink();
				break;
			case "CTPrivacyCharter":
				element = RS.getPrivacyCharterLink();
				break;
			case "CTPrivacyCharterOMX":
				element = RS.getPrivacyCharterLinkOMX();
				break;
			case "CTPrivacyCharterOMP":
				element = RS.getPrivacyCharterLinkOMP();
				break;
			case "CTPrivacyCharterOMR":
				element = RS.getPrivacyCharterLinkOMR();
				break;
			case "Authorization":
				if (context.getDsaDmData().getCardType().equals("OMZ"))
					element = RS.getRsLegalCheckboxOMZ();
				else
					element = RS.getRsLegalCheckbox();
				break;
			case "Submit":
				element = RS.getSubmitBtn();
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

	@And("User on Review Page Verifies {string} label should be {string}")
	@And("User on Review Page Verifies {string} text should be {string}")
	public void verifyText(String fieldName, String _text) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "Header":
				element = RS.getReviewHeader();
				break;
			case "PhoneNumber":
				element = RS.getPhoneNumberLabel();
//				if(BankAcquisition_DTO.getInstance().getContactInfo().getPhoneDevice().equals(DashPhoneDeviceDTO.MOBILE)){
//					expText=expText+getInputText("dd:BANK-APPLY-CONTACT-INFO-002");
//				}else {
//					expText=expText+"Home";
//				}
				break;
			case "EmailAddress":
				element = RS.getEmailAddressLabel();
				break;
			case "MarketingPreference":
				element = RS.getMarketingPreferenceLabel();
				break;
			case "PIHeader":
				element = RS.getAboutMeLabel();
				break;
			case "Name":
				element = RS.getNameLabel();
				break;
			case "DOB":
				element = RS.getDOBLabel();
				break;
			case "SIN":
				element = RS.getSINLabel();
				break;
			case "RIHeader":
				element = RS.getMyAddressLabel();
				break;
			case "Address":
				element = RS.getAddressValueLabel();
				break;
			case "FIHeader":
				element = RS.getMyWorkLabel();
				break;
			case "EmploymentStatus":
				element = RS.getEmploymentStatusLabel();
				break;
			case "MyPrefHeader":
				element = RS.getMyPrefLabel();
				break;
			case "CPIHeader":
				element = RS.getCpiLabel();
				break;
			case "LegalHeader":
				element = RS.getLegalHeader();
				break;
//			case "ReadAgree":
//				element = ReadAgree;
//				break;
//			case "BankT&CContent":
//				element = BankTandCContent;
//				break;
			case "ReadScroll":
				element = RS.getReadScroll();
				break;
			case "EmployerName":
				element = RS.getEmployerNameLabel();
				break;
			case "EmployerCity":
				element = RS.getEmployerCityLabel();
				break;
			case "JobCategory":
				element = RS.getJobCategoryLabel();
				break;
			case "JobTitle":
				element = RS.getJobTitleLabel();
				break;
			case "JobTitleOther":
				element = RS.getJobTitleLabel();
				break;
			case "CardMemberAgreement":
				element = RS.getCardMemberAgreement();
				break;
			case "LegalFootnotes":
				element = RS.getLegalFooternotes();
				RS.getLegalFootNotesExpand().click();
				break;
			case "MyWorkCreditLabel": // label
				System.out.println("Emp status : "+context.getDsaDmData().getEmployementstatus()+"\n");
				if((context.getDsaDmData().getEmployementstatus().contains("Retired")) || (context.getDsaDmData().getEmployementstatus().contains("Seasonal")) || (context.getDsaDmData().getEmployementstatus().contains("Unemployed")) || (context.getDsaDmData().getEmployementstatus().contains("Retraité")))
					element=RS.getMyWorkCrLimitTitleRetired();
				else
					element = RS.getMyWorkCreditLimitTitle();
				break;
			}
			validateText(element, expText.trim());

		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Validate " + fieldName + " with " + _text);
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Clicks on {string} Icon")
	@And("User on Review Page Clicks on {string} Link")
	@And("User on Review Page Clicks on {string} Button")
	@And("User on Review Page Clicks on {string} Checkbox")
	@And("User on Review Page unchecks {string} checkbox")
	public void clickOn(String ele) throws Exception {
		WebElement element = null;
		try {
			Thread.sleep(2000);
			switch (ele) {
			case "Authorization":
//				if(context.getDsaDmData().getCardType().equals("OMZ"))
//					element = RS.getRsLegalCheckboxOMZ();
//				else
				element = RS.getRsLegalCheckbox();
				break;
			case "CollectionOfInfo":
				element = RS.getRsFirstCheckbox();
				break;
			case "CreditReporting":
				element = RS.getRsSecCheckbox();
				break;
			case "TnCPDF":
				element = RS.getTnCPdflink();
				break;
			case "CTPrivacyCharter":
				element = RS.getPrivacyCharterLink();
				break;
			case "CTPrivacyCharterOMX":
				element = RS.getPrivacyCharterLinkOMX();
				break;
			case "CTPrivacyCharterOMP":
				element = RS.getPrivacyCharterLinkOMP();
				break;
			case "CTPrivacyCharterOMR":
				element = RS.getPrivacyCharterLinkOMR();
				break;
			case "Submit":
				element = RS.getSubmitBtn();
				break;

			case "FIEdit":
				element = RS.getMyWorkEdit();
				break;
			case "PIEdit":
				element = RS.getAboutMeEdit();
				break;
			case "RIEdit":
				element = RS.getMyAddressEdit();
				break;
			case "CPIEdit":
				element = RS.getCreditProtectEdit();
				break;
			case "MyPrefEdit":
				element = RS.getMyPrefEdit();
				break;
			case "ExpandPI":
				element = RS.getAboutMeExpand();
				break;
			case "ExpandRI":
				element = RS.getMyAddressExpand();
				break;
			case "ExpandFI":
				element = RS.getMyWorkExpand();
				break;
			case "ExpandMyPref":
				element = RS.getMyPrefExpand();
				break;
			case "ExpandCPI":
				element = RS.getCreditProtectExpand();
				break;
			case "SpcChar":
				element = RS.getSpcChar();
				break;
//			case "DownloadCDICBrochure":
//				xpath = locDownloadCDICBrochureLink();
//				break;
//			case "DownloadTermsandConditionsforDepositProducts":
//				xpath = locDownloadTermsandConditionsforDepositProducts();
//				break;
//			case "DownloadGICProductInformation":
//				xpath = "";
//				break;
//			case "DownloadRegisteredProductsInformation":
//				xpath = locDownloadRegisteredProductsInformation();
//				break;
//			case "PrivacyCharter":
//				xpath = locDownloadPrivacyCharter();
//				break;
			}
//			Thread.sleep(6000);
			clickElementJS(element);
//			if(ele.equals("DownloadCDICBrochure") || ele.equals("DownloadTermsandConditionsforDepositProducts") || ele.equals("DownloadGICProductInformation") || ele.equals("DownloadRegisteredProductsInformation") || ele.equals("PrivacyCharter")) {
//				tabs = new ArrayList<String>(driver.getWindowHandles());
//				System.out.println("tabs"+tabs);
//			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to click on " + ele + " Review Page");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Name")
	public void verifyName() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			String name = dsaDM.getFirstName() + " " + dsaDM.getLastName();
			System.out.println("dsaName=" + name);
			System.out.println("getTextName=" + getText(RS.getNameValue()));
			validateText(getText(RS.getNameValue()), name);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Name");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies DOB")
	public void verifyDOB() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getDOBValue(), dsaDM.getDob().toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Date of Birth");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Marketing Preference")
	public void verifyMarketingPefs() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			String pref = "";
			pref = "OPTED OUT" + "-" + dsaDM.getLanguage();
//			if(dsaDM.getLanguage()) {
//				pref ="OPTED IN";
//			}else {
//				pref ="OPTED OUT";
//			}
			validateText(RS.getMarketingPreference(), pref.toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Marketing Preference");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Preferred Language")
	public void verifyPreferLnge() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			System.out.println("dsa Lang=" + dsaDM.getPreferLanguage().toUpperCase());
			System.out.println("get text Lang=" + getText(RS.getPreferredLangeValue()));
			validateText(getText(RS.getPreferredLangeValue()), dsaDM.getPreferLanguage().toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Preferred Language");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Phone Number")
	public void verifyPhoneNumber() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			String phoneType = null;
			if (context.getLanguage().startsWith("E")) {
				if (dsaDM.getPhoneType().equalsIgnoreCase("Home Phone"))
					phoneType = "HOME";
				else
					phoneType = "MOBILE";
			} else {
				if (dsaDM.getPhoneType().equalsIgnoreCase("Home Phone"))
					phoneType = "HOME";
				else
					phoneType = "MOBILES";
			}
			String phoneNumber = phoneType + dsaDM.getPhoneNumber();
			WebElement actualPhNoP1 = getElementWhenVisible(By.xpath(getXpath(RS.getPhoneNumberValue())
					+ "/span[contains(@data-ng-show,'phone_Type') and @aria-hidden='false'][1]"));
			WebElement actualPhNoP2 = getElementWhenVisible(By.xpath(getXpath(RS.getPhoneNumberValue())
					+ "/span[contains(@data-ng-show,'phone_Type') and @aria-hidden='false'][2]"));
			String actualPhNo = getText(actualPhNoP1) + getText(actualPhNoP2);
			validateText(actualPhNo.trim().replaceAll("[^a-zA-Z0-9]", "").toUpperCase(), phoneNumber.toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Phone Number");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Email Address")
	public void verifyEmailAddress() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getEmailValue(), dsaDM.getEmail().toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Email Address");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies SIN")
	public void verifySIN() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getSINValue(), dsaDM.getSin());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify SIN");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Address")
	public void verifyAddress() throws Exception {
		try {
//			DSA_DM dsaDM = context.getDsaDmData();
			String[] addressArray = getText(RS.getAddressValue()).split("\n");
			if (context.getDsaDmData().getUnitNumber() == null)
				validateText(context.getDsaDmData().getAddressLine1().trim(), addressArray[0].trim());
			else
				validateText(
						context.getDsaDmData().getUnitNumber() + "-" + context.getDsaDmData().getAddressLine1().trim(),
						addressArray[0].trim());
			String dtoAddressLine2 = context.getDsaDmData().getCityString() + " "
					+ commutil.returnProvince(context.getDsaDmData().getProvince()).toString() + " "
					+ context.getDsaDmData().getPostCode();

			validateText(dtoAddressLine2.toUpperCase(), addressArray[1]);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Address");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Previous Address")
	public void verifyPreviousAddress() throws Exception {
		try {
			String[] addressArray = getText(RS.getPrevAddressValue()).trim().split("\n");

			System.out.println("Context Address:" + context.getDsaDmData().getPreviousAdd1().trim());
			System.out.println("Adress in Array:" + addressArray[0]);
			validateText(context.getDsaDmData().getPreviousAdd1().toUpperCase().trim().replace("- ", "-"),
					addressArray[0].trim());

			String dtoAddressLine2 = context.getDsaDmData().getPreviousCityString() + " "
					+ commutil.returnProvince(context.getDsaDmData().getPreviousProvince()).toString() + " "
					+ context.getDsaDmData().getPreviousPostCode();

			validateText(dtoAddressLine2.toUpperCase(), addressArray[1]);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Previous Address");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Residential Status")
	public void verifyResidentialStatus() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			String residenceStatus = dsaDM.getResidenceType();
			if (residenceStatus.trim().equalsIgnoreCase("LiveWithParents"))
				residenceStatus = "WITHPARENTS";
			System.out.println("residentialStatus" + residenceStatus);
			validateText(RS.getResidentialStatus(), residenceStatus.toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Residential Status");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Monthly Payment")
	public void verifyMonthlyPayment() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			String monthlyRent = dsaDM.getMonthlyRentString() + "00";
			validateText(RS.getMonthlyPayment(), monthlyRent);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Monthly Payment");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Address Since")
	public void verifyAddressSince() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			String addressAtSince = dsaDM.getMonthatAddress().toUpperCase() + " " + dsaDM.getYrAtAddress();
			System.out.println("addressAtSince" + addressAtSince);
			validateText(RS.getAddressSince(), addressAtSince);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Address");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Employment Information")
	public void verifyEmploymentInformation() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			if (dsaDM.getEmployementstatus().toUpperCase()
					.equalsIgnoreCase(searchDataDictionary("dd:DSA-FINANCIAL-INFO-0005"))
					|| dsaDM.getEmployementstatus().toUpperCase()
							.equalsIgnoreCase(searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-003"))
					|| dsaDM.getEmployementstatus().toUpperCase()
							.equalsIgnoreCase(searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-016"))) {
				validateText(RS.getEmploymentStatusValue(), dsaDM.getEmployementstatus().toUpperCase());
			} else {
				validateText(RS.getEmploymentStatusValue(), dsaDM.getEmployementstatus().toUpperCase());
				getText(RS.getJobCategoryValue()).contains(dsaDM.getJobCategory().toUpperCase());
//				validateText(By.xpath(JobCategoryValue), dsaDM.getJobCategory().toUpperCase());
				validateText(RS.getJobDescriptionValue(), dsaDM.getJobTitle().toUpperCase());
				validateText(RS.getEmployerNameValue(), dsaDM.getEmployerName().toUpperCase());
				validateText(RS.getEmployerCityValue(), dsaDM.getEmployerCity().toUpperCase());
//				validateText(By.xpath(EmployerPhoneValue), dsaDM.getEmp().toUpperCase());
			}

		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Employment Status");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Employment Status")
	public void verifyEmploymentStatus() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getEmploymentStatusValue(), dsaDM.getEmployementstatus().toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Employment Status");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Job Category")
	public void verifyJobCategory() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getJobCategoryValue(), dsaDM.getJobCategory().toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Job Category");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Job Description")
	public void verifyJobDescription() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getJobDescriptionValue(), dsaDM.getJobTitle().toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Job Title");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Employer Name")
	public void verifyEmployerName() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getEmployerNameValue(), dsaDM.getEmployerName().toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Employer Name");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Employer City")
	public void verifyEmployerCity() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getEmployerCityValue(), dsaDM.getEmployerCity().toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Employer City");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Employer Since")
	public void verifyEmployerSince() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			validateText(RS.getEmployerSince(), dsaDM.getMonthOfEmployement() + " 1, " + dsaDM.getYrOfEmployement());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Employer Since");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Annual Personal Income")
	public void verifyAnnualPersonalIncome() throws Exception {
		try {
			String perInc = "";
			DSA_DM dsaDM = context.getDsaDmData();
			perInc = RS.getAnnualPersonalIncome().getText();
			if (dsaDM.getLanguage().contains("E"))
				perInc = perInc.replaceAll("[.]00", "").replaceAll("[$, ]", "");
			else
				perInc = perInc.replaceAll("[,.]00", "").replaceAll("[$, ]", "");
//			validateText(RS.getAnnualPersonalIncome(), dsaDM.getIncome()+"00");
			Assert.assertEquals(perInc, dsaDM.getGrossPersonalIncome(),
					"Failed to validate Gross Personal Income on Review Submit Page \n");
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Annual Personal Income");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Annual Household Income")
	public void verifyAnnualHouseholdIncome() throws Exception {
		try {
			String houseInc = "";
			DSA_DM dsaDM = context.getDsaDmData();
//			validateText(RS.getAnnualHHIncome(), dsaDM.getHouseholdincome()+"00");
			houseInc = RS.getAnnualHHIncome().getText();
			if (dsaDM.getLanguage().contains("E"))
				houseInc = houseInc.replaceAll("[.]00", "").replaceAll("[$, ]", "");
			else
				houseInc = houseInc.replaceAll("[,.]00", "").replaceAll("[$, ]", "");
			System.out.println("Annual house Income :" + RS.getAnnualHHIncome().getText());
			System.out.println("Dsa house Income :" + dsaDM.getGrossHouseholdIncome() + "\n");
			Assert.assertEquals(houseInc, dsaDM.getGrossHouseholdIncome(),
					"Failed to validate Gross Household Income on Review Submit Page \n");
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Annual Household Income");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Requested Credit Limit")
	public void verifyCreditLimit() throws Exception {
		try {
			String crLimit="";
			crLimit=RS.getMyWorkCreditLimitAmount().getText();
			DSA_DM dsaDM = context.getDsaDmData();
			if (dsaDM.getLanguage().contains("E"))
				crLimit = crLimit.replaceAll("[.]00", "").replaceAll("[$, ]", "");
			else
				crLimit = crLimit.replaceAll("[,.]00", "").replaceAll("[$, ]", "");
			System.out.println("Req Credit Limit :" + RS.getMyWorkCreditLimitAmount().getText());
			System.out.println("Dsa req Credit Limit :" + dsaDM.getCreditLimit() + "\n");
			Assert.assertEquals(crLimit, dsaDM.getCreditLimit(),"Failed to validate Requested credit limit on Review Submit Page \n");
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to validate Requested credit Limit");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Statements Mode")
	public void verifyStatements() throws Exception {
		try {
			String selection = null;
			DSA_DM dsaDM = context.getDsaDmData();
			if (dsaDM.getStmtMode().toUpperCase().equals("Y"))
				selection = getInputText("dd:DSA-IBM-CONTACT-INFO-0020");
			else
				selection = getInputText("dd:DSA-IBM-CONTACT-INFO-0021");
			validateText(RS.getStatements(), selection.toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to validate Statements mode");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Triangle Membeship Subscription")
	public void verifyTrngleMemCardNo() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
			if (dsaDM.getTrngleMemship().equalsIgnoreCase("yes"))
				validateText(RS.getLoyaltyNumberValue(), dsaDM.getLoyaltyNumber());
			else
				validateText(RS.getTriangleRewardsAccNum(), "NO, ASSIGN ME ONE");

		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to validate Triangle Membership Number");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies Supplementary Card Member Details")
	public void verifySuppCardMember() throws Exception {
		try {
			DSA_DM dsaDM = context.getDsaDmData();
//			String selection = dsaDM.getSupplAccount().split(",")[0];
//			if (dsaDM.getSupplAccount().equalsIgnoreCase("Yes")) {
				if (dsaDM.getSupplAccount().equalsIgnoreCase(getInputText("dd:DSA-CONTACT-INFO-0030"))){
				validateText(RS.getSuppCardMemberValue(), dsaDM.getSupplAccount().toUpperCase());
				String name = dsaDM.getSuppFirstName() + " " + dsaDM.getSuppLastName();
				validateText(RS.getSuppNameValue(), name.toUpperCase());
//				validateText(By.xpath(SuppDOBValue), dsaDM.getSuppDob());
				validateText(RS.getSuppPhoneNumValue(), dsaDM.getSuppPhoneNumberString());
				validateText(RS.getSuppRelationValue(), dsaDM.getSuppRelationship().toUpperCase());
//				validateText(By.xpath(SuppAddressValue), dsaDM.getSuppAddress2());
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Validate Supplementary details");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies CPI Enrollment Status")
	public void verifyEnrollStatus() throws Exception {
		try {
			String selection = null;
			DSA_DM dsaDM = context.getDsaDmData();
			if (dsaDM.getCPIEnroll() == "Y")
				selection = getInputText("dd:DSA-IBM-REVIEW-SUBMIT-016");
			else
				selection = getInputText("dd:DSA-IBM-REVIEW-SUBMIT-017");
			validateText(RS.getStatus(), selection.toUpperCase());
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to validate CPI enrollment");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@When("User on Review Page Scrolls to the bottom of {string} Field")
	public void scrollDown(String ele) throws Exception {
		try {
			switch (ele) {
			case "Authorization":
				System.out.println("\n Scrolling to the bottom of the RS page s");
//				if(context.getDsaDmData().getCardType().equals("OMZ"))
//					scrollIntoView(RS.getRsLegalCheckboxOMZ());
//				else
//					scrollIntoView(RS.getRsLegalCheckbox());
				scrollIntoView(RS.getCrCreditRepText());
				break;
//				scrollIntoTandCTextBox();
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Scrolls to the bottom of " + ele + " Field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies the Inline Error Message for {string} Checkbox as {string} in {string} Colour")
	public void verifyerror(String fieldName, String _text, String colour) throws Exception {
		try {
			String expText = getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "OMXAuthorization":
				element = RS.getRsAuthErrorMsg();
//				element= RS.getTermsAndCondErrorMsgOMX();
				break;
			case "OMZAuthorization":
				element = RS.getRsAuthErrorMsg();
//				element= RS.getTermsAndCondErrorMsgOMZ();
				break;
			case "OMPAuthorization":
				element = RS.getRsAuthErrorMsg();
//				element= RS.getTermsAndCondErrorMsgOMP();
				break;
			case "OMRAuthorization":
				element = RS.getRsAuthErrorMsg();
//				element= RS.getTermsAndCondErrorMsgOMR();
				break;
			case "CollectionOfInfo":
				element = RS.getRsCollectionErrorMsg();
				break;
			case "CreditReporting":
				element = RS.getRsCreditErrorMsg();
				break;
			}
			validateText(element, expText);
//			verifyErrorMessage(element, expText, colour);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Inline Error Message for " + fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Verifies the Inline Error Message for {string} Checkbox should not be displayed")
	public void verifyErrorNotDisplayed(String fieldName) throws Exception {
		WebElement element = null;
		try {
			switch (fieldName) {
			case "OMXAuthorization":
				element = RS.getTermsAndCondErrorMsgOMX();
				break;
			case "OMZAuthorization":
				element = RS.getTermsAndCondErrorMsgOMZ();
				break;
			case "OMPAuthorization":
				element = RS.getTermsAndCondErrorMsgOMP();
				break;
			case "OMRAuthorization":
				element = RS.getTermsAndCondErrorMsgOMR();
				break;
			case "CollectionOfInfo":
				element = RS.getRsCollectionErrorMsg();
				break;
			case "CreditReporting":
				element = RS.getRsCreditErrorMsg();
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

	@And("User clicks on Triangle Rewards Program Terms and Conditions")
	public void clickTriRewardsPDF() throws Exception {
		try {
			if (!isElementVisible(RS.getPrintRewardsTCOMXOMZ())) {
				Assert.fail("\n Failed to validate : Triangle Rewards link  \n");
			} else {
				clickElement(RS.getPrintRewardsTCOMXOMZ());
			}
		} catch (Exception e) {
			System.out.println("\n Error while clicking Triangle Rewards pdf link on Review Page \n");
			throw e;
		}
	}

	@And("User is on Triangle Rewards Program Terms and Conditions PDF in New Tab")
	public void verifyTriangleRewardsTnC() throws Exception {
		try {
			Thread.sleep(2000);
			String activeWindow;
			tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
			if (context.getDsaDmData().getChannel().equals("WP"))
				activeWindow = tabs.get(2);
			else
				activeWindow = tabs.get(1);
			driverManager.getDriver().switchTo().window(activeWindow);
			System.out.println("CurrentURL: " + driverManager.getDriver().getCurrentUrl());
			String currUrl = driverManager.getDriver().getCurrentUrl();
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail(
					" \n Caught Error while switiching to new window : Failed to verify Triangle Rewards Terms and Conditions in new tab \n");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User clicks on Privacy Charter")
	public void clickPrivacyCharter() throws Exception {
		JavascriptExecutor jsx = (JavascriptExecutor) driverManager.getDriver();
		jsx.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(5000);
		try {
			if (!isElementVisible(RS.getPrivacyCharterLink())) {
				Assert.fail("\n Failed to validate : Privacy Charter link in Eng \n");
			} else {
				clickElementJS(RS.getPrivacyCharterLink());
			}
		} catch (Exception e) {
			System.out.println("\n Error while clicking Privacy Charter link on Review Page \n");
			throw e;
		}
	}

	// For Quebec Eng flow
	@And("User on Review Submit Page Verifies header text of Privacy Charter popup for Quebec Eng flow")
	public void verifyPrivacyCharter() throws Exception {
		WebElement element = null;
		WebElement element2 = null;
		try {
			element = RS.getPrivacyChartPopupHeader();
			Thread.sleep(5000);
//				  if(!isElementVisible(element)){
//					  Assert.fail("\n Failed to validate : Privacy Charter Header in Frc ( QC eng flow) \n" );
//				  }
//		    	  else {
			/*
			 * validateText(element,"Protection des renseignements personnels"); if
			 * (RS.getToggleInWindow().isDisplayed()) RS.getToggleInWindow().click(); else
			 * System.out.println("\n Toggle button not available"); Thread.sleep(2000);
			 * System.out.println("\n Verifying the Privacy Charter Header after Toggle");
			 */

			element2 = RS.getPrivacyChartPopupHeader();

			validateText(element2, "Privacy Charter");
//		    	  }
		} catch (Exception e) {
			System.out.println("\n CATCH BLOCK \n");
			throw e;
		}

//		try {
//			JavascriptExecutor jsx = (JavascriptExecutor) driverManager.getWebDriver();
//			jsx.executeScript("window.scrollBy(0,400)", "");
//			Thread.sleep(2000);
//
//			if (RS.getPrivacyCharterGotIt().isEnabled())
//				RS.getPrivacyCharterGotIt().click();
//			else
//				Assert.fail("\n Failed to validate : Got it button on Privacy charter popup : Review Submit Page \n");
//
//		} catch (Exception e) {
//			log.error("An error occurred: {}", e.getMessage(), e);
//			Assert.fail("Failed to verify privacy charter popup QC Eng Flow");
//			e.printStackTrace();
//			throw new Exception(e);
//		}
	}

	// For ROC and Quebec Frc flow
	@And("User on Review Submit Page Verifies header text of Privacy Charter popup")
	public void verifyPrivacyChart() throws Exception {
		WebElement element = null;
		try {
			element = RS.getPrivacyChartPopupHeader();

			if (context.getDsaDmData().getLanguage().contains("E")) {
				if (!isElementVisible(element)) {
					Assert.fail("\n Failed to validate : Privacy Charter Header in Eng \n");
				} else {
					validateText(element, "Privacy Charter");
					RS.getToggleInWindow().click();
					Thread.sleep(2000);
					System.out.println("\n Verifying the Privacy Charter Header after Toggle");
					validateText(element, "Protection des renseignements personnels");
				}
			} else {
				if (!isElementVisible(RS.getPrivacyChartPopupHeader())) {
					Assert.fail("\n Failed to validate : Privacy Charter Header in Frc on popup \n");
				} else {
					validateText(element, "Protection des renseignements personnels");
					RS.getToggleInWindow().click();
					Thread.sleep(2000);
					System.out.println("\n Verifying the Privacy Charter Header after Toggle");
					validateText(element, "Privacy Charter");
				}
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify privacy charter QC Eng Flow");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Review Page Accepts Privacy Charter poopup")
	public void acceptPopup() throws Exception {
		try {
			String popupHeaderXpath = "//h1[@id='ngdialog2-aria-labelledby']";
			log.info("Attempting to Accept popup");
			if (RS.getPrivacyCharterGotIt().isEnabled())
				RS.getPrivacyCharterGotIt().click();
			else
				Assert.fail("\n Failed to validate : Got it button on Privacy charter popup : Review Submit Page \n");
			} catch (Exception e) {
				log.info("Caught error attempting to accept");
				e.printStackTrace();
				throw e;
			}
	}

//	@And("User clicks {string} CMA link on review page for QC Eng")
//	public void clickCMA(String link) throws Exception {
//		try {
//			switch(link) {
//				case "Eng":
//					if (!isElementVisible(RS.getCMAinEng())) {
//						Assert.fail("\n Failed to validate : CMA link in Eng \n" );
//						break;
//					}
//					else {
//						clickElement(RS.getCMAinEng());
//					}
//					Thread.sleep(5000);
//						break;
//				case "Frc":		
//					if (!isElementVisible(RS.getCMAinFrc())) {
//						Assert.fail("\n Failed to validate : CMA link in Frc \n" );
//						break;
//					}
//					else {
//						clickElement(RS.getCMAinFrc());
//					}
//					Thread.sleep(5000);
//						break;
//			}
//		}catch(Exception e) {
//			System.out.println("\n Error while clicking CMA links for QC Eng flow \n");
//			throw e;
//		}
//	}

	@And("User verifies {string} CMA pdf in new tab for QC Eng")
	public void verifyCMA_QC(String language) throws Exception {
		JavascriptExecutor jsx = (JavascriptExecutor) driverManager.getDriver();
		jsx.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		String currUrl = "";
		tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
		System.out.println("Tabs size: " + tabs.size());
		Thread.sleep(2000);
		if (applicationProperties.getBrowser().contains("android")) {
			System.out.println("Inside Mobile: Waiting for PDF to load");
			if (context.getDsaDmData().getLanguage().startsWith("E"))
				currUrl = "docs_EN.pdf";
			else
				currUrl = "docs_FR.pdf";
			PU.clickBack();
			System.out.println("Clicked on Back button");
			Thread.sleep(4000);
		} else if (applicationProperties.getBrowser().contains("iphone")) {
			Thread.sleep(8000);
			System.out.println("\n Inside Iphone block \n");
			currUrl = driverManager.getDriver().getCurrentUrl();
			PU.switchTab(driverManager.getDriver());
			Thread.sleep(15000);
		} else {
			if (context.getDsaDmData().getChannel().equals("WP"))
				driverManager.getDriver().switchTo().window(tabs.get(2));
			else
				driverManager.getDriver().switchTo().window(tabs.get(1));

			currUrl = driverManager.getDriver().getCurrentUrl();
		}
//		currUrl = driverManager.getWebDriver().getCurrentUrl();
		String title = driverManager.getDriver().getTitle();
		System.out.println("CurrentURL: " + currUrl);
		System.out.println("Title: " + title);
		String stripText = PU.openPdfandStripLastPage(currUrl);
		System.out.println("Content : \n" + stripText);
		switch (language) {
		case "ENG":
			System.out.println("\n ** Verifying CMA link in Eng in new tab : QC ** \n");
			if (!currUrl.contains("CMA") && !currUrl.contains("EN"))
				Assert.fail("\n Failed to Validate visibility of :QC CMA Eng in new tab \n");
			else {
				if (stripText.contains("50462125• CMA-ENG • 1225 • 7348"))
					System.out.println(" Version matched on CMA pdf \n");
				else
					Assert.fail("\n Version not matched on pdf \n");
			}
			break;
		case "FRC":
			System.out.println("\n ** Verifying CMA link in Frc in new tab : QC** \n");
			if (!currUrl.contains("CMA") && !currUrl.contains("_FR"))
				Assert.fail("\n Failed to Validate visibility of :QC CMA Frc in new tab \n");
			else {
				if (stripText.contains("50474205 • CMA-FRE • 1225 • 7348"))
					System.out.println(" Version matched on CMA pdf \n");
				else
					Assert.fail("\n Version not matched on pdf \n");
			}
			break;
		}
	}

	@And("User clicks {string} CMA link on review page for QC Eng")
	@And("User clicks {string} CMA link on review page")
	public void clickCMALink(String link) throws Exception {
		try {
			switch (link) {
			case "Eng":
//					if (!isElementVisible(RS.getCMAinEng())) {
//						Assert.fail("\n Failed to validate : CMA link in Eng \n" );
//						break;
//					}
//					else {
				Thread.sleep(2000);
				System.out.println("Going to click CMA Eng \n");
				clickElement(RS.getCMAinEng());
//					}
				break;
			case "Frc":
//					if (!isElementVisible(RS.getCMAinFrc())) {
//						Assert.fail("\n Failed to validate : CMA link in Frc \n" );
//						break;
//					}
//					else {
				Thread.sleep(2000);

				clickElement(RS.getCMAinFrc());
//					}
				break;
			}
		} catch (Exception e) {
			System.out.println("\n Error while clicking CMA links for QC Eng flow \n");
			throw e;
		}
	}

	@And("User verifies CMA pdf in new tab") // ROC and QC Frc
	public void verifyCMA() throws Exception {
		try {
			JavascriptExecutor jsx = (JavascriptExecutor) driverManager.getDriver();
			jsx.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);
			String currUrl = "";
			tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
			if (applicationProperties.getBrowser().contains("android")) {
				System.out.println("Inside Mobile: Waiting for PDF to load");
				if (context.getDsaDmData().getLanguage().startsWith("E"))
					currUrl = "docs_EN.pdf";
				else
					currUrl = "docs_FR.pdf";
				PU.clickBack();
				System.out.println("Clicked on Back button");
				Thread.sleep(4000);
			} else if (applicationProperties.getBrowser().contains("iphone")) {
				Thread.sleep(8000);
				System.out.println("\n Inside Iphone block \n");
				currUrl = driverManager.getDriver().getCurrentUrl();
				PU.switchTab(driverManager.getDriver());
				Thread.sleep(15000);
			} else {
				if (context.getDsaDmData().getChannel().equals("WP"))
					driverManager.getDriver().switchTo().window(tabs.get(2));
				else
					driverManager.getDriver().switchTo().window(tabs.get(1));

				currUrl = driverManager.getDriver().getCurrentUrl();
			}
			System.out.println("CurrentURL: " + currUrl);
			String stripText = PU.openPdfandStripLastPage(currUrl);
			System.out.println("Text from PDF Last page: \n" + stripText);
			if (context.getDsaDmData().getLanguage().contains("E")) {
				System.out.println("\n ** ROC/QC Frc Verifying CMA Link in Eng ** \n");
				if (!currUrl.contains("CMA_INSERTS_EN")) {
					Assert.fail("\n Failed to Validate visibility of : CMA link in Eng \n");
				} else {
					if (stripText.contains("50462125• CMA-ENG • 0625 • 7091"))
						System.out.println(" Version matched on CMA pdf \n");
					else
						Assert.fail("\n Version not matched on pdf \n");
				}
			} else {
				System.out.println("\n ** ROC/QC Frc Verifying CMA Link in Frc ** \n");
				if (!currUrl.contains("CMA_INSERTS_FR")) {
					Assert.fail("\n Failed to Validate visibility of : CMA link in Frc \n");
				} else {
					if (stripText.contains("50462126 • CMA-FRE • 0625 • 7091"))
						System.out.println(" Version matched on CMA pdf \n");
					else
						Assert.fail("\n Version not matched on pdf \n");
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@And("User Closes Triangle Rewards Program Terms and Conditions PDF Browser Tab")
	@And("User closes Privacy Charter Page Tab")
	@And("User closes CMA Link Tab")
	@And("User closes new Tab")
	public void closenewTab() throws Exception {
		try {
			String activeWindow;
			tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
			activeWindow = tabs.get(tabs.size() - 1);
			driverManager.getDriver().switchTo().window(activeWindow);
			driverManager.getDriver().close();
			Thread.sleep(5000);
			System.out.println("No of Tabs" + tabs.size());
			if (tabs.size() > 2) {
				System.out.println("Switching in Ecom tab");
				driverManager.getDriver().switchTo().window(tabs.get(1));
			} else {
				System.out.println("Switching in NonEcom tab");
				driverManager.getDriver().switchTo().window(tabs.get(0));
			}
			Thread.sleep(6000);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to Close New Tab");
			throw new Exception(e);
		}
	}

	// Roadside, Certificate and Residents pdfs
	@And("User clicks {string} on review page for QC Eng")
	public void clickPDF_QClink(String link) throws Exception {
		try {
			switch (link) {
			case "Roadside_FR":
				if (!isElementVisible(RS.getRoadSideTCFRC())) {
					Assert.fail("\n Failed to validate : Roadside link in Frc \n");
				} else
					clickElement(RS.getRoadSideTCFRC());
				break;
			case "Roadside_EN":
				if (!isElementVisible(RS.getRoadSideTC())) {
					Assert.fail("\n Failed to validate : Roadside link in Eng \n");
				} else
					clickElement(RS.getRoadSideTC());
				break;
			case "Certificate_Eng":
				if (!isElementVisible(RS.getCertInsuranceOMZ())) {
					Assert.fail("\n Failed to validate : Cerificate Insurance in Eng \n");
				} else
					clickElement(RS.getCertInsuranceOMZ());
				break;
			case "Certificate_Frc":
				if (!isElementVisible(RS.getCertInsuranceOMZFRC())) {
					Assert.fail("\n Failed to validate : Certificate Insurance in Frc \n");
				} else
					clickElement(RS.getCertInsuranceOMZFRC());
				break;
			case "Resident_En":
				if (!isElementVisible(RS.getResidentsQCEng())) {
					Assert.fail("\n Failed to validate : Resident link in Eng \n");
				} else
					clickElement(RS.getResidentsQCEng());
				break;
			case "Resident_Fr":
				if (!isElementVisible(RS.getResidentsQC())) {
					Assert.fail("\n Failed to validate : Resident link in Frc \n");
				} else
					clickElement(RS.getResidentsQC());
				break;
			}// switch
		} catch (Exception e) {
			System.out.println("\n ERROR : While clicking one of the pdf links \n");
		}
	}

	@And("User verifies {string} link in new tabs for QC Eng")
	public void verifyPDF_QC(String page) throws Exception {
		JavascriptExecutor jsx = (JavascriptExecutor) driverManager.getDriver();
		jsx.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		String activeWindow;
		tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
		if (context.getDsaDmData().getChannel().equals("WP"))
			activeWindow = tabs.get(2);
		else
			activeWindow = tabs.get(1);
		driverManager.getDriver().switchTo().window(activeWindow);
		System.out.println("CurrentURL: " + driverManager.getDriver().getCurrentUrl());
		String currUrl = driverManager.getDriver().getCurrentUrl();
		System.out.println("\n ** Verifying 6 pdf links in Eng and Frc ** \n");
		Thread.sleep(4000);
		try {

			switch (page) {
			case "Roadside_en":
				if (!currUrl.contains("Assistance_EN"))
					Assert.fail("1) Failed to Validate visibility of Roadside Assistance T & C \n");
				break;
			case "Roadside_Fr":
				if (!currUrl.contains("Assistance_FR"))
					Assert.fail("2) Failed to Validate visibility of Roadside Assistance T & C in FRC \n");
				break;

			case "Certificate_En":
				if (!currUrl.contains("COI_EN"))
					Assert.fail("3) Failed to Validate visibility of PDF : Certificate of Insurance \n");
				break;

			case "Certificate_Fr":
				if (!currUrl.contains("COI_FR"))
					Assert.fail("4) Failed to Validate visibility of PDF FRC: Certificate of Insurance \n");
				break;
			case "Resident_Fr":
				if (!currUrl.contains("Summary_FR"))
					Assert.fail("5) Failed to Validate visibility of PDF FRC: Residents of Quebec \n");
				break;
			case "Resident_En":
				if (!currUrl.contains("Summary_EN"))
					Assert.fail("6) Failed to Validate visibility of PDF : Residents of Quebec \n");
				break;
			}// switch

		} catch (Exception e) {
			System.out.println("  ERROR :  Failed to validate 6 pdf links in new tabs for QC Eng");
			throw e;
		}
	}

	@And("User verifies toggle buttons on review page")
	public void verifyToggle() throws Exception {
		try {
			switch (context.getDsaDmData().getProvince().toUpperCase()) {

			case "QUEBEC":
				if (context.getDsaDmData().getLanguage().contains("E")) {
					if (!isElementVisible(RS.getToggleInWindow())) {
						Assert.fail("Failed to Validate visibility of toggle button in TC window \n");
					} else {
						RS.getToggleInWindow().click();
						Thread.sleep(2000);
					}
				} else {
					System.out.println("\n\n No Toggle required \n");
				}
			}// switch
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("\n OMZ :Failed to validate Toggle button on Review Submit Page \n ");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User validates Authorization TC text on review page")
	public void verifyAuthTC() throws Exception {
		try {

			if (context.getDsaDmData().getCardType() == "OMX") {
				System.out.println(" Text on App = " + RS.getAuthTCOMX().getText());
				validateText(RS.getAuthTCOMX().getText(), getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-009"),
						true);
			}

			if (context.getDsaDmData().getCardType() == "OMZ") {
				System.out.println(" Text on App = " + RS.getAuthTCOMZ().getText());
				validateText(RS.getAuthTCOMZ().getText(), getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-009"),
						true);
			}

			if (context.getDsaDmData().getCardType() == "OMR") {
				System.out.println(" Text on App = " + RS.getAuthTCOMR().getText());
				validateText(RS.getAuthTCOMR().getText(), getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-009"),
						true);
			}

			if (context.getDsaDmData().getCardType() == "OMP") {
				System.out.println(" Text on App = " + RS.getAuthTCOMP().getText());
				validateText(RS.getAuthTCOMP().getText(), getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-009"),
						true);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@And("User on Review and Submit page validates {string} link")
	public void validatePrivacyCharter(String fieldName) {
		try {
			ArrayList<String> tabs;
			switch (fieldName) {
			case "PrivacyCharter":
				RS.getPrivacyCharterLink().click();
				break;
			}
			Thread.sleep(3000);
			String activeWindow;
			tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
			if (context.getDsaDmData().getChannel().equals("WP"))
				activeWindow = tabs.get(2);
			else
				activeWindow = tabs.get(1);
			driverManager.getDriver().switchTo().window(activeWindow);
			System.out.println("CurrentURL: " + driverManager.getDriver().getCurrentUrl());
			String currUrl = driverManager.getDriver().getCurrentUrl();
			switch (fieldName) {
			case "PrivacyCharter":
				if (currUrl.contains("privacy_security") && currUrl.contains("docs3/")) {
					Assert.fail("Failed to validate " + fieldName);
				}
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate " + fieldName);

		}
	}

//	@And("User verifies credit check on review page")  --> previously
	@And("User verifies Credit and ID Check {string} text on review page")
	public void verifyTextRSPage(String ref) throws Exception {
		try {
			switch (ref) {
			case "PrivacyConsent":
				Thread.sleep(5000);
				System.out.println("Validating Privacy Consent on RS Page \n");
				if (!RS.getCrPrivacyText().isDisplayed()) {
					Assert.fail(
							"\n Failed to validate :CREDIT & ID CHECK -> Privacy Consent Terms and Conditions (First checkbox) \n");
				} else {
					System.out.println("\n * Verifying the Privacy Charter Consent on RS Page (First checkbox) *\n");
					String text1 = RS.getCrPrivacyText().getText();
					System.out.println(" Text from app : " + text1);
					String text2 = getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-020");
					System.out.println(" Data Dictionary : " + text2);
					validateText(text2.trim() + " " + getInputText("dd:normalized:DSA-IBM-REQ"),
							text1.replaceAll("\n", "").replace(".You", ". You"));
				}
				break;
			case "CreditReporting":
				if (!isElementVisible(RS.getCrCreditRepText())) {
					Assert.fail(
							"\n Failed to validate :CREDIT & ID CHECK -> PersonalInfo Terms and Conditions (Second checkbox) \n");
				} else {
					System.out.println(
							"\n ^ Verifying the Personal Info Terms and Conditions on RS Page (Second checkbox) ^\n");
					validateText(getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-021") + " "
							+ getInputText("dd:normalized:DSA-IBM-REQ"), RS.getCrCreditRepText().getText());
				}
				break;
			case "Authorization":
				switch (context.getDsaDmData().getCardType()) {
				case "OMX":
					if (context.getDsaDmData().getProvince().contains("Q")) {
						if (context.getDsaDmData().getLanguage().contains("E")) {
							System.out.println(
									"\n Verifying the Auth Terms and Conditions for OMX Eng QC flow on RS Page (Third checkbox)\n");
							validateText(
									getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-010-B") + " "
											+ getInputText("dd:normalized:DSA-IBM-REQ"),
									RS.getCrAuthTextQC().getText(), true);
						}
					} else {
						System.out.println(
								"\n Verifying the Auth Terms and Conditions for OMX ROC flow on RS Page (Third checkbox)\n");
						validateText(
								getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-010") + " "
										+ getInputText("dd:normalized:DSA-IBM-REQ"),
								RS.getCrAuthText().getText(), true);
					}
					break;
				case "OMZ":
					System.out.println("PRov" + context.getDsaDmData().getProvince());
					if (context.getDsaDmData().getProvince().contains("Q")) {
						if (context.getDsaDmData().getLanguage().contains("E")) {
							System.out.println(
									"\n Verifying the Auth Terms and Conditions for OMZ QC flow on RS Page (Third checkbox)\n");
							validateText(
									getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-010-B") + " "
											+ getInputText("dd:normalized:DSA-IBM-REQ"),
									RS.getCrAuthTextQC().getText(), true);
						}
					} else {
						System.out.println(
								"\n Verifying the Authorization Terms and Conditions for OMZ ROC flow on RS Page (Third checkbox)\n");
						validateText(
								getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-010") + " "
										+ getInputText("dd:normalized:DSA-IBM-REQ"),
								RS.getCrAuthText().getText(), true);
					}
					break;
				case "OMR":
					if (context.getDsaDmData().getProvince().contains("Q")) {
						if (context.getDsaDmData().getLanguage().contains("E")) {
							System.out.println(
									"\n Verifying the Auth Terms and Conditions for OMR QC flow on RS Page (Third checkbox)\n");
							validateText(
									getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-OMR-010-A") + " "
											+ getInputText("dd:normalized:DSA-IBM-REQ"),
									RS.getCrAuthTextQC().getText(), true);
						}
					} else {
						System.out.println(
								"\n Verifying the Auth Terms and Conditions for OMR ROC flow on RS Page (Third checkbox)\n");
						validateText(
								getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-OMR-010") + " "
										+ getInputText("dd:normalized:DSA-IBM-REQ"),
								RS.getCrAuthText().getText(), true);
					}
					break;
				}
			}// switch
		} catch (Exception e) {
			System.out.println("\n Failed to verify Credit Check checkboxes text on RS Page \n");
			throw e;
		}
	}

	@And("User on Review and Submit page validates NSF fees is no longer presented")
	public void validateText() throws ValidationException {
		if (RS.getReviewDocPara().isDisplayed())
			validateText(getInputText("dd:normalized:DSA-IBM-REVIEW-SUBMIT-003"), RS.getReviewDocPara().getText(),
					true);

		else
			Assert.fail("NSF Fee line showing on Review Submit Page");

	}

	@And("User on Review and Submit page validates APR")
	public void validateAPR() throws ValidationException {
		JavascriptExecutor jsx = (JavascriptExecutor) driverManager.getDriver();
		jsx.executeScript("window.scrollBy(0,300)", "");
		System.out.println("\n Validating APR on RS Page \n");
		if (context.getDsaDmData().getLanguage().contains("E")) {
			validateText("28.99", RS.getAprAuthTandC1().getText(), true);
			validateText("28.99", RS.getAprAuthTandC2().getText(), true);
		}
		else {
			validateText("28,99", RS.getAprAuthTandC1().getText(), true);
			validateText("28.99", RS.getAprAuthTandC2().getText(), true);
		}

	}
}
