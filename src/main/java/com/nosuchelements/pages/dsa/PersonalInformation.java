package com.nosuchelements.pages.dsa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.constants.Constants.Phone_Type;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;
import com.nosuchelements.utils.dsa.CommonUtils;

import lombok.Data;

@PageObject
@Data
public class PersonalInformation extends BasePage {
	
	@Autowired
	private CommonUtils commutil;
	

	@FindBy(how = How.ID, using = "piTitle")
    private WebElement selectTitle;

	@FindBy(how = How.XPATH, using = "//div[@id='piNonEditBtnsWrapper']//button[@id='piNextBtn']")
    private WebElement personalInfoNext;
	
	@FindBy(how = How.XPATH, using = "//h1[@id='personal-information__heading1']")
    private WebElement personalInfoHeader;
	
	@FindBy(how = How.XPATH, using = "//div[@class='container-fluid paddingNone'][@aria-hidden='false']/p")
    private WebElement instructionMsg;
	
	@FindBy(how = How.XPATH, using = "//*[@id='personal-info-form']/div[1]")
    private WebElement advisoryMsg;
	
	@FindBy(how = How.XPATH, using = "//input[@id='piFirstName']")
    private WebElement firstName;
	
	@FindBy(how = How.XPATH, using = "//label[@for='piFirstName']")
    private WebElement firstNameLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='piLastName']")
    private WebElement lastName;
	
	@FindBy(how = How.XPATH, using = "//label[@for='piLastName']")
    private WebElement lastNameLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='piDob']")
    private WebElement dob;
	
	@FindBy(how = How.XPATH, using = "//label[@for='piDob']")
    private WebElement dobLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='piDobValidations']//small")
    private WebElement dobAdvisory;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ciEmail']")
    private WebElement emailTextBox;
	
	@FindBy(how = How.XPATH, using = "//label[@for='ciEmail']")
    private WebElement emailLabel;
	
	@FindBy(how = How.XPATH, using = "(//input[@id='ciEmail']/following::small)[1]")
    private WebElement emailAdvisory;
	
	@FindBy(how = How.XPATH, using = "//h3[@id='bonus-title']")
    private WebElement ciHeader;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ciCheckbox']")
    private WebElement ciCheckBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ciCheckbox']/../label[@for='ciCheckbox']/b[@aria-hidden='false']")
    private WebElement ciCheckBoxLabel;
			
	@FindBy(how = How.XPATH, using = "//*[@id='ciCheckbox']/../div/i")
    private WebElement ciConsentMessage;
	
	@FindBy(how = How.XPATH, using = "//*[@id='piLangPref']")
    private WebElement preferLanguage;
	
	@FindBy(how = How.XPATH, using = "//label[@for='piLangPref']")
    private WebElement preferLanguageLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciPhoneNumContainer']//..//../preceding-sibling::div//div[@class='marTop50']")
    private WebElement addMobile;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ciPhoneOptions']")
    private WebElement phoneTypeDrpdwn;
	
	@FindBy(how = How.XPATH, using = "//select[@id='ciPhoneOptionsMobile']")
    private WebElement phoneTypeDrpdwnMobileSelected;
	
	@FindBy(how = How.XPATH, using = "//select[@id='ciPhoneOptionsHome']")
    private WebElement phoneTypeDrpdwnHomeSelected;
	
	@FindBy(how = How.XPATH, using = "//label[@for='ciPhoneOptions']")
    private WebElement phoneTypeLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ciPhoneNum']")
    private WebElement phoneNum;
	
	@FindBy(how = How.XPATH, using = "//label[@for='ciPhoneNum']")
    private WebElement phoneNumLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciPhoneNumContainer']/div/small")
    private WebElement phoneNumAdvisory;
	
	@FindBy(how = How.XPATH, using = "//input[@id='piSIN']")
    private WebElement sinTextBox;
	
	@FindBy(how = How.XPATH, using = "//label[@for='piSIN']")
    private WebElement sinLabel;
	
	@FindBy(how = How.XPATH, using = "//form[@id='personal-info-form']//h2")
    private WebElement sinHeading;
	
	@FindBy(how = How.XPATH, using = "//form[@id='personal-info-form']//p")
    private WebElement sinInstructions;
	
	@FindBy(how = How.XPATH, using = "//form[@id='personal-info-form']//*[@id='piSINContainer']//small")
    private WebElement sinAdvisory;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciPhoneNumErrorValidations' and contains(@class,'error-messages')]")
    private WebElement phnNumberErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='piFirstNameValidations']/small")
    private WebElement firstNameErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='piLastNameValidations']/small")
    private WebElement lastNameErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='piDobValidations']/div[contains(@class,'error-messages')]/small")
    private WebElement dobErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciEmailValidations' and contains(@class,'error-messages')]/small")
    private WebElement emailErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciPhoneOptionsValidations']/small")
    private WebElement phoneTypeErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='piSINValidations']/small")
    private WebElement sinErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//button[@id='startBrbBtn'][@aria-hidden='false']")
    private WebElement noManualBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@id='startManualBtn']")
    private WebElement manualBtn;
	
//	@FindBy(how = How.XPATH, using = "//*[@class='button-container text-right']/*[@id='piNextBtn']")
	@FindBy(how = How.XPATH, using = "//button[@id='piNextBtnMain']")
	private WebElement nextButtonHome;
	
//	Desktop xpath
	@FindBy(how = How.XPATH, using = "//*[@id='piNextBtnEdit1']")
//	@FindBy(how = How.XPATH, using = "//form[@id='personal-info-form']/div[3]/button[1]")
//	Mobile xpath
//	@FindBy(how = How.XPATH, using = "//*[@id='piNextBtnEdit2']")
    private WebElement nextButtonPI;
	
	@FindBy(how = How.XPATH, using = "//button[@id='piBacktoReviewBtn']")
    private WebElement nextReviewButtonPI;
	
	@FindBy(how = How.XPATH, using = "//form[@id='personal-info-form']/div[1]")
    private WebElement personalInfoInstruction;
	
	@FindBy(how = How.XPATH, using = "//button[@id='piBacktoReviewBtn']")
    private WebElement backToReview;

//	@FindBy(how = How.XPATH, using = "//button[@id='dsa_legal_accordion']/h2/span[1]")
	@FindBy(how = How.XPATH, using = "//button[@id='dsa_legal_accordion']")
	private WebElement pilegalFooter;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'personalLegal')]//div[@id='sect1']/div")
	private WebElement legalFooternotes;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'personalLegal')]//button[@id='legalFooter']")
	private WebElement legalFootNotesExpand;
	
	public void _personalInformation(DSA_DM dsa, String firstname, String lastname,  String emailAdd, Phone_Type phoneType, boolean doManualEntry) throws Exception {
		//completePersonalInfo(dsa, doManualEntry);
		try {
			log.info("Entering Personal Information");
			try {
				log.info("Attempting to validate PI page");
				if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
					expectedTitle = "Renseignements personnels";
					driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
					commutil.pageTitle();
				} else {
//					expectedTitle = "Personal Information";
//					wait.until(ExpectedConditions.titleContains(expectedTitle));
//					pageTitle();
				}
			} catch (Exception e) {
				log.info("Caught error attempting to validate page");
				e.printStackTrace();
			}
//			validateText(By.xpath(personalInfoHeader),getInputText("dd:DSA-IBM-PERSONAL-INFO-0028"));
//			validateText(By.xpath(personalInfoInstruction), getInputText("dd:DSA-IBM-PERSONAL-INFO-0029"));
			try {
				if(doManualEntry == true) {
				if (!dsa.getTitle().equals(null)) {
						System.out.println("Title Value is "+dsa.getTitle());
						//selectFromDropdownByText(By.xpath(selectTitle), dsa.getTitle());
						inputText(firstName,firstname);
						inputText(lastName,lastname);
						inputText(dob,dsa.getDob());
						
//						WebElement email = driver.findElement(By.xpath(emailTextBox));
						System.out.println("Email Id is "+emailAdd);
						actions.moveToElement(emailTextBox).build().perform();
						emailTextBox.sendKeys(emailAdd);
						
						selectFromDropdownByValue(phoneTypeDrpdwn, phoneType.toString());
						System.out.println("Phone NUmber is "+dsa.getPhoneNumber());
//						WebElement inputPhoneNumber = driver.findElement(By.xpath(phoneNum));
						actions.moveToElement(phoneNum).build().perform();
						phoneNum.sendKeys(dsa.getPhoneNumber());

						System.out.println("SIN Number is "+dsa.getSin());
						inputText(sinTextBox,dsa.getSin());
					}
				}
				else 
				{
					/*if (!dsa.getTitle().equals(null)) {
						selectFromDropdownByText(By.xpath(selectTitle), dsa.getTitle());
					}*/
					inputText(dob,dsa.getDob());
//					WebElement email = driver.findElement(By.xpath(emailTextBox));
					System.out.println("Email Id is "+emailAdd);
					actions.moveToElement(emailTextBox).build().perform();
					emailTextBox.sendKeys(emailAdd);
					
					selectFromDropdownByValue(phoneTypeDrpdwn, phoneType.toString());
					System.out.println("Phone NUmber is "+dsa.getPhoneNumber());
//					WebElement inputPhoneNumber = driver.findElement(By.xpath(phoneNum));
					actions.moveToElement(phoneNum).build().perform();
					phoneNum.sendKeys(dsa.getPhoneNumber());

					System.out.println("SIN Number is "+dsa.getSin());
					inputText(sinTextBox,dsa.getSin());
				}
				
//				Screen_Shots.takeScreenShot(driver, this.getClass());
				clickElement(personalInfoNext);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			log.info("Caught error entering Personal Information");
			e.printStackTrace();
			throw e;
		}
	}


	private void completePersonalInfo(DSA_DM dsa, boolean doManualEntry) {
		try {
			if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
				expectedTitle = "Renseignements personnels";
				driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
				commutil.pageTitle();
			} else {
				expectedTitle = "Personal Information";
				driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
				System.out.println(driverManager.getDriver().getTitle());
				commutil.pageTitle();
			}
			if(doManualEntry == false) {
				WebElement button = driverWait.getDriverWait().until(ExpectedConditions.visibilityOf(noManualBtn));
				button.click();
			}else if(doManualEntry == true) {
				WebElement button = driverWait.getDriverWait().until(ExpectedConditions.visibilityOf(manualBtn));
				button.click();
			}
			clickElement(nextButtonHome);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

//	@Override
	public void validate() throws ValidationException, InterruptedException {
		waitForVisible(firstNameLabel);
		waitForVisible(lastNameLabel);
		
	}
	
	

}