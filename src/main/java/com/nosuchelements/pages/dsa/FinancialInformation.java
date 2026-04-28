package com.nosuchelements.pages.dsa;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;
import com.nosuchelements.utils.dsa.CommonUtils;
import com.nosuchelements.utils.dsa.pdfUtil;

import lombok.Data;

@PageObject
@Data
public class FinancialInformation extends BasePage {
	
	ArrayList<String> tabs;
	
	@Autowired
	private pdfUtil PU;
	
	@Autowired
	private CommonUtils commutil;
	
	@FindBy(how = How.XPATH, using = "//h1[@id='financial-information__heading']")
    private WebElement financialHeader;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fiEmploymentStatus']")
    private WebElement financialStatus;
	
	@FindBy(how = How.XPATH, using = "//div[@class='row']/h2[@class='fiTitle']")
    private WebElement employStatusHeader;
	
	@FindBy(how = How.XPATH, using = "//div[@class='helper-text']/span")
    private WebElement providingHelperText;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiEmploymentStatus']")
    private WebElement fiStatusLabel;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiJobCategory']")
    private WebElement fiJobCategory;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fiJobCategoryContainer']//..//..")
    private WebElement jobCategoryContainer;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiJobCategory']")
    private WebElement fiJobCategoryLabel;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiJobTitle']")
    private WebElement fiJobTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fiJobTitleContainer']")
    private WebElement fiJobDescDatalist;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fiJobTitle']")
    private WebElement fiJobDesc;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiJobTitle']")
    private WebElement fiJobDescLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fiJobTitleOther']")
    private WebElement fiJobTitleOther;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiJobTitleOther']")
    private WebElement fiJobTitleOtherLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fiEmployerName']")
    private WebElement fiEmployerName;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiEmployerName']")
    private WebElement fiEmployerLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fiCity']")
    private WebElement fiCity;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiCity']")
    private WebElement fiCityLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fiEmployerTelephoneNumber']")
    private WebElement fiEmpPhone;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiEmployerTelephoneNumber']")
    private WebElement fiEmpPhoneLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fiEmployerTelephoneNumberValidations']//small")
    private WebElement fiEmpPhoneError;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiMonth']")
    private WebElement fiMonth;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiMonth']")
    private WebElement fiMonthLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fiYear']")
    private WebElement fiYear;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiYear']")
    private WebElement fiYearLabel;
	
//	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show, 'employerDetails')]//h4[@id='fiTitle']")
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-12']/h2[@class='fiTitle']")
	private WebElement financesHeader;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "//div[@id='fiPersonalIncomeContainer']/input[@id='fiPersonalIncome']")
	//DSA3
//	@FindBy(how = How.XPATH, using = "//input[@id='fiPersonalIncome']")
    private WebElement fiPersonalIncome;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiPersonalIncomeFreq']")
    private WebElement fiPerIncFreqDropdown;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiPersonalIncome']")
    private WebElement fiPersonalIncomeLabel;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiPersonalIncomeFreq']")
    private WebElement fiPersonalIncomeFreqDropdown;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiPersonalIncomeFreq']")
    private WebElement fiPersonalIncomeFreqLabel;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiPersonalIncomeFreq']/option[@label='Annually']")
    private WebElement fiPersonalIncomeAnnually;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiPersonalIncomeFreq']/option[@label='Monthly']")
    private WebElement fiPersonalIncomeMonthly;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiPersonalIncomeFreq']/option[@label='Semi-monthly']")
    private WebElement fiPersonalIncomeSemiMonthly;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiPersonalIncomeFreq']/option[@label='Weekly']")
    private WebElement fiPersonalIncomeWeekly;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiPersonalIncomeFreq']/option[@label='Bi-weekly']")
    private WebElement fiPersonalIncomeBiweekly;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-12 col-md-6']/div[@class='helper-text']/small[1]")
    private WebElement fiPersonalIncomeFreqHelperText;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "//div[@id='fiHouseIncomeContainer']//input[@id='fiHouseIncome']")
	//DSA3
//	@FindBy(how = How.XPATH, using = "//input[@id='fiHouseIncome']")
    private WebElement fiHouseIncome;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiHouseIncome']")
    private WebElement fiHouseIncomeLabel;
//	
	@FindBy(how = How.XPATH, using = "//select[@id='fiHouseIncomeFreq']/option[@label='Annually']")
    private WebElement fiHouseIncomeAnnually;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiHouseIncomeFreq']/option[@label='Semi-monthly']")
    private WebElement fiHouseIncomeSemiMonthly;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiHouseIncomeFreq']/option[@label='Monthly']")
    private WebElement fiHouseIncomeMonthly;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiHouseIncomeFreq']/option[@label='Weekly']")
    private WebElement fiHouseIncomeWeekly;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiHouseIncomeFreq']/option[@label='Bi-weekly']")
    private WebElement fiHouseIncomeBiweekly;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fiHouseIncomeFreq']")
    private WebElement fiHouseIncomeFreqLabel;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fiHouseIncomeFreq']")
    private WebElement fiHouseIncomeFreqDropdown;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-12 col-md-6']/div[@class='helper-text ng-scope']/small[1]")
    private WebElement fiHouseIncomeFreqHelperText;
	
	@FindBy(how = How.XPATH, using = "//span[@class='value fiIncomeMsg-value ng-binding']")
    private WebElement fiGrossPersonalIncCalulated;
	
	@FindBy(how = How.XPATH, using = "//span[@class='value fiIncomeMsg-value ng-binding ng-scope']")
    private WebElement fiGrossHouseIncCalulated;
	
	@FindBy(how = How.XPATH, using = "//button[@id='fiNextBtn']")
    private WebElement fiNextBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fiEmploymentStatusValidations']//small")
    private WebElement employmentStatusError;
	
	@FindBy(how = How.XPATH, using = "//button[@id='fiBacktoReviewBtn']")
    private WebElement fiNextReviewBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fiJobCategoryValidations']//small")
    private WebElement jobCategoryError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fiJobTitleValidations']//small")
    private WebElement jobDescError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fiJobTitleOtherValidations']//small")
    private WebElement jobTitleOtherError;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'finInfoCtrl') and @aria-hidden='false']//div[@id='fiEmployerNameValidations']//small")
    private WebElement employerNameError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='fiCityValidations']//small")
    private WebElement cityNameError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='employerDateValidations']//small")
    private WebElement dateError;
	
	//Mobile
	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-12 hidden-md hidden-lg hidden-xl']//div[@id='fiPersonalIncomeValidations']/small")
	//Desktop
//	@FindBy(how = How.XPATH, using = "//div[@class='hidden-xs hidden-sm']/div[@id='fiPersonalIncomeValidations']/small")
	private WebElement fiPersonalIncomeError;
	
	@FindBy(how = How.XPATH, using = "//button[@id='incomeIncorrectBtn']")
    private WebElement editButton;
	
	@FindBy(how = How.XPATH, using = "//button[@id='incomeCorrectBtn']")
    private WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "//button[@id='upsellReturnToAppBtn']")
    private WebElement noUpgrade;
	
	@FindBy(how = How.XPATH, using = "//button[@id='upsellShowCostCreditBtn']")
    private WebElement upgrade;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ngdialog2']//p[4]")
    private WebElement effDateUpsell;
	
	@FindBy(how = How.XPATH, using = "//button[@id='upsellCostCreditConfirmBtn']")
    private WebElement upsellAgreeBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@id='upsellCostCreditCancelBtn']")
    private WebElement upsellCancelBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@id='downsellCostCreditConfirmBtn' and @aria-hidden='false']")
    private WebElement downsellAgreeBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ngdialog2']//p[4]")
    private WebElement effDateDownsell;
	
	@FindBy(how = How.XPATH, using = "//button[@id='downsellCostCreditCancelBtn']")
    private WebElement downsellCancelBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@id='downsellReturnToAppBtn']")
    private WebElement downsellEditInfo;
	
	@FindBy(how = How.XPATH, using = "//button[@id='downsellShowCostCreditBtn']")
    private WebElement downsellUpdateCard;
	
	@FindBy(how = How.XPATH, using = "//div[@ng-controller='IncomeDialogController as incomeDialog']//h1[@id='ngdialog2-aria-labelledby']")
    private WebElement incomeCorrectPopup;
	
	@FindBy(how = How.XPATH, using = "//div[@id='updownsell-modal']//div[contains(@data-ng-show,'showUpsellText') and @aria-hidden='false']")
    private WebElement upsellPopup;
	
	@FindBy(how = How.XPATH, using = "//div[@id='updownsell-modal']//div[contains(@data-ng-show,'showDownsellText') and @aria-hidden='false' and @id='modal-text']")
    private WebElement downsellPopup;
	
	@FindBy(how = How.XPATH, using = "//h1[@id='ngdialog2-aria-labelledby']")
    private WebElement popupHeader;
	
	@FindBy(how = How.XPATH, using = "//p[@id='ngdialog2-aria-describedby']")
    private WebElement popupText;
	
	@FindBy(how = How.XPATH, using = "//*[@id='fiBacktoReviewBtn']")
    private WebElement fiBackToReview;
	
	//upsell/downsell
	@FindBy(how = How.XPATH, using = "//div[@data-ng-if='updownsellDialog.visible.showUpsellText' and @id='modal-text']")
    private WebElement upsellPopupText;
	
//	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'showDownsellText') and contains(@class,'modal-text')]")
	@FindBy(how = How.XPATH, using = "//div[@id='modal-text']")
	private WebElement downsellPopupText;
	
	@FindBy(how = How.XPATH, using = "//div[@id='legalModalDescription']")
    private WebElement upsellLegalText;
	
	@FindBy(how = How.XPATH, using = "//div[@id='legalDescription']")
    private WebElement downsellLegalText;

//	@FindBy(how = How.XPATH, using = "//button[@class='ng-scope']")
	@FindBy(how = How.XPATH, using = "//div[@class='marTop10 col-md-12 col-xs-12 upDownSellModalLegal-OMZ']/button[@class='ng-scope']")
    private WebElement upsellLegalFooterbutton;
	
//	@FindBy(how = How.XPATH, using = "//div[@class='marTop10 col-md-12 col-xs-12 upDownSellModalLegal-OMZ']/button")
	@FindBy(how = How.XPATH, using = "//div[@id='legalDescription']//preceding-sibling::button")
	private WebElement downsellLegalFooterButton;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'updownsellDialog') and @aria-hidden = 'false']//p[10]")
    private WebElement bottomLine_upsellCOCD;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'updownsellDialog') and @aria-hidden = 'false']//p[5]")
    private WebElement OMZVerbiage_upsellCOCD;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'updownsellDialog') and @aria-hidden = 'false']//p[5]")
    private WebElement OMXVerbiage_downsellCOCD;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'consent-modal')]/p[1]/span[@class='pdf-img']/a")
    private WebElement saveorPrintTop;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'consent-modal')]//following-sibling::div//p[12]/span[@class='pdf-img']/a")
    private WebElement saveorPrintBottom_upsell;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'consent-modal')]//following-sibling::div//p[11]/span[@class='pdf-img']/a")
    private WebElement saveorPrintBottom_downsell;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'consent-modal')]/div//tr[2]/td/span")
    private WebElement updateCOCDmodelText;
	
	@FindBy(how = How.XPATH, using = "//div[@id='modal-text']/div[2]/ul/li[1]/h5")
    private WebElement collect4pctTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-7']/ul[1]/li[1]/p")
    private WebElement onQualifyingText;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-7']/ul/li[2]/h5")
    private WebElement collCTmoneyheading ;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-7']/ul/li[2]/p")
    private WebElement grocPurchaseText;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-7']/ul/li[3]/h5")
    private WebElement collect05pctHeading ;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-7']/ul/li[3]/p")
    private WebElement everywhereText;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-7']/ul/li[4]/h5")
    private WebElement collect5cHeading ;
	
	@FindBy(how = How.XPATH, using = "//div[@class='col-lg-7']/ul/li[4]/p")
    private WebElement gasPetroText;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'financialLegal ')]//div[@id='sect1']/div")
	private WebElement legalFooternotes;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'financialLegal')]//button[@id='legalFooter']")
	private WebElement legalFootNotesExpand;
	
	// New field Credit Limit
	
	@FindBy(how = How.XPATH, using = "//div[@class='row marTop30 ng-scope']/div/h2[@class='fiTitle']")
	private WebElement prefCreditHeader;
	
	@FindBy(how = How.XPATH, using = "//input[@id='requestCreditLimit']")
	private WebElement creditLimitInput;
	
	@FindBy(how = How.XPATH, using = "//div[@class='row marTop30 ng-scope']/div/div[@class='helper-text']")
	private WebElement creditHelperText;
	
	@FindBy(how = How.XPATH, using = "//label[@for='requestCreditLimit']")
	private WebElement creditLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='requestCreditLimitValidations']/small")
	private WebElement creditError;
	
//	@Override
	public void validate() throws ValidationException, InterruptedException {
//		validateText(By.xpath(financialHeader), getInputText("dd:DSA-IBM-FINANCIAL-INFO-0003"));
		waitForVisible(financialStatus);
//		waitForVisible(By.xpath(fiNextBtn));
		
	}
	
	
	public void validateCardName(String type) throws ValidationException {
		try {
			WebElement element = null;
			
			switch(type) {
			case "Upsell":
				getText(upsellPopupText).contains("Triangle® World Elite® Mastercard®");
				getText(upsellPopupText).contains("Tire Money");
				element = upsellLegalText;
				break;
			case "Downsell":
				getText(downsellPopupText).contains("Triangle® World Elite® Mastercard®");
				getText(downsellPopupText).contains("Tire Money");
				element = downsellLegalText;
				break;
			}
			getText(element).contains("Triangle® Mastercard®, Triangle® World Mastercard® and Triangle® World Elite® Mastercard®");
			getText(element).contains("Triangle® Mastercard® and Triangle® World Elite® Mastercard®");
			getText(element).contains("®/™ Mastercard, World Mastercard, World Elite Mastercard are registered trademarks, and the circles design is a trademark of Mastercard International Incorporated");
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to validate Card Name in "+type);
		}
		
	}
	public void _financialInformation(DSA_DM dsa) throws Exception {
		try {
			log.info("Entering Financial Information");
			try {
				log.info("Attempting to validate Financial Information page");
				if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
					expectedTitle = "Renseignements financiers";
					driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
					commutil.pageTitle();
				} else {
//					expectedTitle = "Financial Information";
//					//expectedTitle = "Financial Information";
//					System.out.println("title is "+driver.getTitle());
//					wait.until(ExpectedConditions.titleContains(expectedTitle));
//					pageTitle();
				}
				log.info("Financial Information page Validated Successfully");
			} catch (Exception e) {
				log.info("Caught error attempting to validate page");
				e.printStackTrace();
			}
			Thread.sleep(2000);
			selectFromDropdownByText(financialStatus, dsa.getEmployementstatus());
			System.out.println(" DSAMastercard : Debug : Financial");
			
			if (dsa.getEmployementstatus().equalsIgnoreCase("retired")) {
				inputText(fiPersonalIncome, dsa.getPersonalincome());
				inputText(fiHouseIncome, dsa.getHouseholdincome());
				dsa.setEmployementstatus(dsa.getEmployementstatus());
			}
			
			if (!dsa.getEmployementstatus().equalsIgnoreCase("retired") && dsa.getLanguage().equals("Frc")) {
				inputText(fiEmployerName, dsa.getEmployerName());
				inputText(fiCity, dsa.getEmployerCity());
				selectFromDropdownByValue(fiJobCategory, dsa.getJobCategory());
				inputText(fiJobDesc,dsa.getJobTitle());
				inputText(fiEmpPhone,dsa.getEmployerPhone());
				if (dsa.getJobTitle().equals("Autre")) {
					inputText(fiJobTitleOther, dsa.getJobTitleOther());
				}
				selectFromDropdownByValue(fiMonth, dsa.getMonthOfEmployement());
				inputText(fiYear, dsa.getYrOfEmployement());
				inputText(fiPersonalIncome, dsa.getPersonalincome());
				inputText(fiHouseIncome, dsa.getHouseholdincome());
			}

			if (!dsa.getEmployementstatus().equalsIgnoreCase("retired") && dsa.getLanguage().equals("Eng")) {
				inputText(fiEmployerName, dsa.getEmployerName());
				inputText(fiCity, dsa.getEmployerCity());
				selectFromDropdownByText(fiJobCategory, dsa.getJobCategory());
				inputText(fiJobDesc,dsa.getJobTitle());
				inputText(fiEmpPhone,dsa.getEmployerPhone());

				if (dsa.getJobTitle().equals("Other")) {
					inputText(fiJobTitleOther, dsa.getJobTitleOther());
				}
				selectFromDropdownByText(fiMonth, dsa.getMonthOfEmployement());
				inputText(fiYear, dsa.getYrOfEmployement());
				inputText(fiPersonalIncome, dsa.getPersonalincome());
				inputText(fiHouseIncome, dsa.getHouseholdincome());
			}
			clickElement(fiNextBtn);
			if(Integer.parseInt(dsa.getGrossPersonalIncome()) <= 5000 ) {
				incomeCorrectionPopup("continue");
			}
			else if(Integer.parseInt(dsa.getGrossPersonalIncome()) >= 80000 && dsa.getCardType().equals("OMX")) {
				upsellPopup("Upgrade");
				upsellConfirmation("Agree");
				dsa.setCardType("OMZ");
			}
			else if(Integer.parseInt(dsa.getGrossPersonalIncome()) <=80000 && dsa.getCardType().equals("OMZ")) {
				downsellPopup("UpdateCard");
				
				downsellConfirmation("Agree");
				dsa.setCardType("OMX");
			}
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='fiNextBtn']")));
		} catch (Exception e) {
			log.info("Caught error entering Financial Information");
			e.printStackTrace();
			throw e;
		}
	}
	
	public void incomeCorrectionPopup(String selection) {
		WebElement element = null;
		try {
		switch(selection) {
		case "Edit":
			element = editButton;
			break;
		case "Continue":
			element = continueButton;
			break;
			
		}
//		validateText(By.xpath(popupHeader), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-01"));
//		validateText(By.xpath(popupText), getInputText("dd:DSA-IBM-LANDING-PAGE-04"));
		clickElement(element);
		}
		catch(Exception e) {
			Assert.fail("Failed to click on "+selection+"for Income correction");
			e.printStackTrace();
		}
	}
	
	public void downsellPopup(String selection) {
		WebElement element = null;
		try {
		switch(selection) {
		case "EditInfo":
			element = downsellEditInfo;
			break;
		case "UpdateCard":
			element = downsellUpdateCard;
			break;
			
		}
//		validateText(By.xpath(popupHeader), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-01"));
//		validateText(By.xpath(popupText), getInputText("dd:DSA-IBM-LANDING-PAGE-04"));
		clickElement(element);
		}
		catch(Exception e) {
			Assert.fail("Failed to click on "+selection+"for Downsell card");
			e.printStackTrace();
		}
		
	}
	
	public void upsellPopup(String selection) {
		WebElement element = null;
		try {
			switch(selection) {
				case "DontUpgrade":
					element = noUpgrade;
					break;
				case "Upgrade":
					element = upgrade;
					break;
			}
//			validateText(By.xpath(popupHeader), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-01"));
//			validateText(By.xpath(popupText), getInputText("dd:DSA-IBM-LANDING-PAGE-04"));
			clickElement(element);
		}
	catch(Exception e) {
		e.printStackTrace();
		Assert.fail("Failed to click on "+selection+"for Upsell card");
		
	}
	
}

public void upsellConfirmation(String selection) {
	WebElement element = null;
	try {
	switch(selection) {
	case "Agree":
		element = upsellAgreeBtn;
		break;
	case "Cancel":
		element = upsellCancelBtn;
		break;
		
	}
//	validateText(By.xpath(popupHeader), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-01"));
//	validateText(By.xpath(popupText), getInputText("dd:DSA-IBM-LANDING-PAGE-04"));
	clickElement(element);

	}
	catch(Exception e) {
		e.printStackTrace();
		Assert.fail("Failed to click on " + selection + " for Upsell confirmation");
	}
	
}

public void downsellConfirmation(String selection) {
	WebElement element = null;
	try {
	switch(selection) {
	case "Agree":
		element = downsellAgreeBtn;
		break;
	case "Cancel":
		element = downsellCancelBtn;
		break;
		
	}
//	validateText(By.xpath(popupHeader), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-01"));
//	validateText(By.xpath(popupText), getInputText("dd:DSA-IBM-LANDING-PAGE-04"));
	scrollIntoView(element);
//	accept
	scrollIntoView(element);
	Assert.assertTrue(element.isDisplayed(), "Button is not visible");
	clickElement(element);

	}
	catch(Exception e) {
		Assert.fail("Failed to click on " + selection + " for Downsell confirmation");
		e.printStackTrace();
	}
	
}
		
	
	public void selectIncomeCorrection(String selection)
	{
		WebElement element = null;
		try
		{
			switch(selection) {
			case "Edit":
				element = editButton;
				break;
			case "Continue":
				element = continueButton;
				break;
				
			}
			clickOnOption(element);
			
		}catch(Exception e) {
			Assert.fail("Failed to click on Income correction for Credit Card Application");
			e.printStackTrace();
		}
	}
	
	public void clickOnOption(WebElement element) throws Exception {
		try {
			log.info("Attempting to select Income correction for Credit Card Application");
			try {
				log.info("Attempting to validate Income correction for Credit Card Application page");
				
					expectedTitle = getInputText("dd:DSA-PAGE-TITLE-03");
					driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
					commutil.pageTitle();
				
			} catch (Exception e) {
				log.info("Page validation failed.");
				e.printStackTrace();
			}
			validateText(popupHeader, getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-01"));
			validateText(popupText, getInputText("dd:DSA-IBM-LANDING-PAGE-04"));
			clickElement(element);
			driverWait.getDriverWait().until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			log.info("Caught error attempting to agree COC");
			e.printStackTrace();
			throw e;
		}
	}
	
	private EmploymentStatus empStatus = EmploymentStatus.Select;
	public static String empstatusSelectedOption;
	enum EmploymentStatus {
		Select , FullTime, PartTimelessThan25Hrs,PartTimemoreThan25Hrs, Seasonal, Retired, Homemaker, Unemployed;
	}
	public void selectEmpDefault() throws InterruptedException  {
		empStatus = EmploymentStatus.Select;
		empstatusSelectedOption=searchDataDictionary("dd:DSA-SELECT-DROPDOWN");
		selectEmpStatus(empstatusSelectedOption);
	}
	public String selectFullTime() throws InterruptedException {
		empStatus = EmploymentStatus.FullTime;
		empstatusSelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-0002");
		selectEmpStatus(empstatusSelectedOption);
		return empstatusSelectedOption;
	}
	public String selectPartTimeless() throws InterruptedException {
		empStatus = EmploymentStatus.PartTimelessThan25Hrs;
		empstatusSelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-0028");
		selectEmpStatus(empstatusSelectedOption);
		return empstatusSelectedOption;
	}  
	public String selectPartTimemore() throws InterruptedException {
		empStatus = EmploymentStatus.PartTimemoreThan25Hrs;
		empstatusSelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-0029");
		selectEmpStatus(empstatusSelectedOption);
		return empstatusSelectedOption;
	} 
	public String selectSeasonal() throws InterruptedException {
		empStatus = EmploymentStatus.Seasonal;
		empstatusSelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-0030");
		selectEmpStatus(empstatusSelectedOption);
		return empstatusSelectedOption;
	}  
	public String selectRetired() throws InterruptedException {
		empStatus = EmploymentStatus.Retired;
		empstatusSelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-0005");
		selectEmpStatus(empstatusSelectedOption);
		return empstatusSelectedOption;
	}
	public String selectHomemaker() throws InterruptedException {
		empStatus = EmploymentStatus.Homemaker;
		empstatusSelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-003");
		selectEmpStatus(empstatusSelectedOption);
		return empstatusSelectedOption;
	}
	public String selectUnemployed() throws InterruptedException {
		empStatus = EmploymentStatus.Unemployed;
		empstatusSelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-016");
		selectEmpStatus(empstatusSelectedOption);
		return empstatusSelectedOption;
	}
	
	public void selectEmpStatus(String type) throws InterruptedException {
		selectFromDropdownByText(financialStatus, type);
	}
	
	private IncFreq incFreq = IncFreq.Select;
	public static String IncomeFreqOption;
	enum IncFreq {
		 Annually, Monthly, Semimonthly, Weekly, Biweekly, Select;
	}
	
	public String selectWeekly(String dropdown) {
		incFreq = IncFreq.Weekly;
		IncomeFreqOption=searchDataDictionary("dd:DSA-PAY-FREQ-WEEKLY");
		return selectIncFreq(IncomeFreqOption,dropdown);
//		return getSelectedValue();
	}
	
	public String selectAnnually(String dropdown) {
		incFreq = IncFreq.Annually;
		IncomeFreqOption=searchDataDictionary("dd:DSA-PAY-FREQ-ANNUALLY");
		return selectIncFreq(IncomeFreqOption,dropdown);
//		return getSelectedValue();
	}
	
	public String selectMonthly(String dropdown) {
		incFreq = IncFreq.Monthly;
		IncomeFreqOption=searchDataDictionary("dd:DSA-PAY-FREQ-MONTHLY");
		return selectIncFreq(IncomeFreqOption,dropdown);
//		return getSelectedValue();
	}

	public String selectSemimonthly(String dropdown) {
		incFreq = IncFreq.Semimonthly;
		IncomeFreqOption=searchDataDictionary("dd:DSA-PAY-FREQ-SEMI-MONTHLY");
		return selectIncFreq(IncomeFreqOption,dropdown);
//		return getSelectedValue();
	}
	
	public String selectBiweekly(String dropdown) {
		incFreq = IncFreq.Biweekly;
		IncomeFreqOption=searchDataDictionary("dd:DSA-PAY-FREQ-BIWEEKLY");
		return selectIncFreq(IncomeFreqOption,dropdown);
//		String getSelectedValue();
	}
	
	
	public String selectIncFreq(String type, String dropdown) {
		String selectedValue ="";
		Select select;
		WebElement el= null;
		try {
			switch(dropdown) {
					case"PersFrequency":
						selectFromDropdownByText(fiPerIncFreqDropdown, type);
						select = new Select(fiPerIncFreqDropdown);
						el = select.getFirstSelectedOption();
						selectedValue = el.getAttribute("value");
						break;
					case"HHFrequency":
						selectFromDropdownByText(fiHouseIncomeFreqDropdown, type);
						select = new Select(fiHouseIncomeFreqDropdown);
						el = select.getFirstSelectedOption();
						selectedValue = el.getAttribute("value");
						break;
					}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedValue;
	}
	private JobCategory jobCategory = JobCategory.Select;
	public static String jobCategorySelectedOption;
	enum JobCategory {
		Select, Driver, Guard, Homemaker, Labourer, Management, Military,  OfficeStaff, ProductionWorker, OfficeWorker,
		Professional, ServiceRepair, Sales, Service , Student, Trades, Unemployed, Other, Parental, Owner, RetailRepresentative;
		 
		}
	public String selectJCDefault() {
		jobCategory = JobCategory.Select;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-SELECT-DROPDOWN");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectDriver() {
		jobCategory = JobCategory.Driver;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-001");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectOwner() {
		jobCategory = JobCategory.Owner;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-008");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	
	public String selectProductionWorker() {
		jobCategory = JobCategory.ProductionWorker;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-009");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
		
	}
	public String selectGuard() {
		jobCategory = JobCategory.Guard;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-024");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectHomemaker1() {
		jobCategory = JobCategory.Homemaker;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-003");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectLabourer() {
		jobCategory = JobCategory.Labourer;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-004");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectManager() {
		jobCategory = JobCategory.Management;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-026");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectMilitary() {
		jobCategory = JobCategory.Military;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-006");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectOfficeStaff() {
		jobCategory = JobCategory.OfficeStaff;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-007");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectOfficeWorker() {
		jobCategory = JobCategory.OfficeWorker;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-027");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectProfessional() {
		jobCategory = JobCategory.Professional;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-010");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectRepairer() {
		jobCategory = JobCategory.ServiceRepair;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-028");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectSales() {
		jobCategory = JobCategory.Sales;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-012");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectService() {
		jobCategory = JobCategory.Service;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-028");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectStudent() {
		jobCategory = JobCategory.Student;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-014");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	}
	public String selectTrades() {
		jobCategory = JobCategory.Trades;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-015");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	} 
	public String selectUnemployed1() {
		jobCategory = JobCategory.Unemployed;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-016");
		selectJobCategory(jobCategorySelectedOption);
		return getSelectedValue();
	} 
	public String selectOther() {
		jobCategory = JobCategory.Other;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-017");
		 selectJobCategory(jobCategorySelectedOption);
		 return getSelectedValue();
	}
	
	public String selectParental() {
		jobCategory = JobCategory.Parental;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-020");
		 selectJobCategory(jobCategorySelectedOption);
		 return getSelectedValue();
	}
	
	public String selectRetailRep() {
		jobCategory = JobCategory.RetailRepresentative;
		jobCategorySelectedOption=searchDataDictionary("dd:DSA-FINANCIAL-INFO-JOB-CATEGORY-021");
		 selectJobCategory(jobCategorySelectedOption);
		 return getSelectedValue();
	}
	
	public void selectJobCategory(String type) {
		try {
			selectFromDropdownByText(fiJobCategory, type);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getSelectedValue() {
		Select select = new Select(fiJobCategory);
		WebElement el = select.getFirstSelectedOption();
		String selectedValue = el.getAttribute("value");
		return selectedValue;
	}
	
	public String getSelectedFrequency(WebElement freqDropdown) {
		Select select = new Select(freqDropdown);
		WebElement el = select.getFirstSelectedOption();
		String selectedValue = el.getAttribute("value");
		return selectedValue;
	}
	
	public void userLeavesField(WebElement el) throws Exception {
		try {
			el.sendKeys(Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public String getPDFText() {
		String url= "";
		if(context.getDsaDmData().getLanguage().contains("E"))
			url ="docs_EN.pdf";
		else
			url ="docs_FR.pdf";
		
        String stripText = "";
        try {
			        if(driverManager.isMobile()) {
			//			 Thread.sleep(7000);
						 System.out.println("Inside Mobile: Waiting for PDF to load");
//						 PU.clickBack();
						 System.out.println("Clicked on Back button");
						 Thread.sleep(8000);
					 } 
			        else 
					 {
						String activeWindow = "";
						tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
						if (context.getDsaDmData().getChannel().equals("WP")) {
							activeWindow = tabs.get(1);
						} else {
							activeWindow = tabs.get(0);
						}
						driverManager.getDriver().switchTo().window(activeWindow);
						
			//    	    url = driverManager.getWebDriver().getCurrentUrl();
			
			//    		activeWindow = tabs.get(tabs.size()-1);
			//    		driverManager.getWebDriver().switchTo().window(activeWindow);
			//			url = driverManager.getWebDriver().getCurrentUrl();
					 }
						System.out.println("Current URL:"+url);
						System.out.println("Fetching text from PDF");
			           stripText = PU.openPdfandStripText(url);
			           System.out.println("Text from PDF: \n"+stripText);
        } catch (Exception e) {
        	 e.printStackTrace();
    	  Assert.fail(" \n ERROR on Cost of Credit Disclosure pdf ***");
          }
        return stripText;
	}

	
	public void closeCOCD() throws Exception {
        System.out.println("\n Closing COCD tab... \n");
        try {
        		String activeWindow;
        		tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
        		activeWindow = tabs.get(tabs.size()-1);
        		driverManager.getDriver().switchTo().window(activeWindow);
//            	driverManager.getWebDriver().close();
            	Thread.sleep(3000);
             	System.out.println("No of Tabs"+tabs.size());
             	if(tabs.size()>2) {
             		System.out.println("Switching in Ecom tab");
             			driverManager.getDriver().switchTo().window(tabs.get(1));
             	}
             	else {
             		System.out.println("Switching in NonEcom tab");
             		driverManager.getDriver().switchTo().window(tabs.get(0));
             	}
             	} catch (Exception e) {
           			Assert.fail("Failed to Close Cost Of Credit Disclosure Tab");
           			throw e;
             	}
	}
	
	public int getGrossIncome(String givenIncome, String frequency) {
		int grossIncome = 0;
		System.out.println(" Inc Frequency selected : "+frequency);
		switch(frequency) {
			case "WEEKLY":
				grossIncome = Integer.parseInt(givenIncome);
				grossIncome = grossIncome * 52;
//				grossPersIncome = FI.getFiGrossPersonalIncCalulated().getText();
				break;
	
			case "ANNUALLY":
				System.out.println(" Inside ANNUALLY gross inc validation *********** \n");
				grossIncome = Integer.parseInt(givenIncome);
//				grossPersIncome = FI.getFiGrossPersonalIncCalulated().getText();
				break;
	
			case "MONTHLY":
				grossIncome = Integer.parseInt(givenIncome);
				grossIncome = grossIncome * 12;
//				grossPersIncome = FI.getFiGrossPersonalIncCalulated().getText();
				break;
	
			case "SEMIMONTHLY":
				grossIncome = Integer.parseInt(givenIncome);
				grossIncome = grossIncome * 6;
//				grossPersIncome = FI.getFiGrossPersonalIncCalulated().getText();
				break;
								
			case "BIWEEKLY":
				grossIncome = Integer.parseInt(givenIncome);
				grossIncome = grossIncome * 26;
//				grossPersIncome = FI.getFiGrossPersonalIncCalulated().getText();
				break;
			}
		return grossIncome;
	}
}
