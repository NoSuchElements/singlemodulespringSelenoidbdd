package com.nosuchelements.pages.dsa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;

import lombok.Data;

@PageObject
@Data
public class ResidentialInfoPage extends BasePage {
	

	@FindBy(how = How.XPATH, using = "//h1[@id='address-form__heading']/span/strong")
    private WebElement header;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afAddressLookupContainer']/p")
    private WebElement instructionMsg;
	
	@FindBy(how = How.XPATH, using = "//label[@for='afAddressLookup']")
    private WebElement addressLookUpFieldLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='address_list']//div[@role='option']")
    private WebElement lookUpAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id='afAddressLookup']")
    private WebElement addressLookUpField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='address_list_item0']")
    private WebElement addressList;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='address_list'])[1]")
    private WebElement addressListBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='afAddressLookupContainer']/button")
    private WebElement enterManualAddressLink;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afUnitNum']")
    private WebElement unitNumberLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afUnitNum']")
    private WebElement unitNumberField;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afAddressLine1']")
    private WebElement addressLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afAddressLine1']")
    private WebElement addressLine1;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afAddressLine2']")
    private WebElement address2Label;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afAddressLine2']")
    private WebElement addressLine2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afCity']")
    private WebElement cityField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afPostal']")
    private WebElement postalCodeField;
	
	@FindBy(how = How.XPATH, using = "//select[@id='afProvince']")
    private WebElement provinceField;
	
	@FindBy(how = How.XPATH, using = "//*[@id='afResiStatus']")
    private WebElement residentStatus;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afResiStatus']")
    private WebElement residentStatusLabel;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "//div[@class='container-fluid paddingNone']//input[@id='afHousePayment']")
	//DSA3
//	@FindBy(how = How.XPATH, using = "//input[@id='afHousePayment']")
    private WebElement afHousePayment;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afHousePayment']")
    private WebElement afHousePaymentLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afYear']")
    private WebElement afYearLabel;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "//div[@class='container-fluid paddingNone']//input[@id='afYear']")
	//DSA3
//	@FindBy(how = How.XPATH, using = "//input[@id='afYear']")
    private WebElement afYear;
	
	@FindBy(how = How.XPATH, using = "//*[@id='afCurAddressMonth']")
    private WebElement afCurAddressMonth;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afCurAddressMonth']")
    private WebElement afCurAddressMonthLabel;
	
	@FindBy(how = How.XPATH, using = "//select[@id='afResiStatus']")
    private WebElement afResiStatus;
	
	@FindBy(how = How.XPATH, using = "//button[@id='afNextBtn']")
    private WebElement nextBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"afAddressLookupContainer\"]/button")
    private WebElement editAddressLink;
	
	@FindBy(how = How.XPATH, using = "//button[@id='afBacktoReviewBtn']")
    private WebElement nextReviewRIBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afCity']")
    private WebElement cityLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afProvince']")
    private WebElement provinceLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afPostal']")
    private WebElement postalCodeLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@class='pcaautocomplete pcatext' and not(contains(@style,'none'))]//div[@id='address_list']//div[@role='option']")
    private WebElement prevLookupAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id='afPrevAddressLookup']")
    private WebElement prevAddressLookup;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afPrevAddressLookup']")
    private WebElement prevAddressLookupLabel;
	
	@FindBy(how = How.XPATH, using = "//*[@id='afPrevAddressLookupContainer']/button")
    private WebElement prevEnterManualAddressLink;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afPrevUnitNum']")
    private WebElement prevUnitNumberLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afPrevUnitNum']")
    private WebElement prevUnitNumberField;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afPrevAddressLine1']")
    private WebElement prevAddressLine1Label;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afPrevAddressLine1']")
    private WebElement prevAddressLine1;
	
	@FindBy(how = How.XPATH, using = "//*[@for='afPrevStreetName']")
    private WebElement prevAddress2Label;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afPrevAddressLine2']")
    private WebElement prevAddressLine2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afPrevCity']")
    private WebElement prevCityField;
	
	@FindBy(how = How.XPATH, using = "//label[@for='afPrevCity']")
    private WebElement prevCityLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='afPrevPostal']")
    private WebElement prevPostalCodeField;
	
	@FindBy(how = How.XPATH, using = "//label[@for='afPrevPostal']")
    private WebElement prevPostalCodeLabel;
	
	@FindBy(how = How.XPATH, using = "//select[@id='afPrevProvince']")
    private WebElement prevProvinceField;
	
	@FindBy(how = How.XPATH, using = "//label[@for='afPrevProvince']")
    private WebElement prevProvinceLabel;
	
	@FindBy(how = How.XPATH, using = "//button[@id='saErrorOkBtn']")
    private WebElement addressCorrectionButton;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afAddressLookupValidations']/small")
    private WebElement addressLookUpError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afAddressLine1Validations']/small")
    private WebElement addressLine1Error;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afCityValidations']/small")
    private WebElement cityError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afProvinceValidations']/small")
    private WebElement provinceError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afPostalValidations']/small")
    private WebElement postalCodeError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afResiStatusValidations']/small")
    private WebElement residentialStatusError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afHousePaymentValidations']/small")
    private WebElement housingPaymentError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afCurAddressMonthValidation']/small")
    private WebElement currAddrMonthError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afYearValidations']/small")
    private WebElement currAddrYearError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afAddressLookupValidations']/small")
    private WebElement prevAddressLookUpError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afPrevAddressLine1Validations']/small")
    private WebElement prevAddressLine1Error;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afPrevCityValidations']/small")
    private WebElement prevCityError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afPrevProvinceValidations']/small")
    private WebElement prevProvinceError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='afPrevPostalValidations']/small")
    private WebElement prevPostalCodeError;
	
	@FindBy(how = How.XPATH, using = "//button[@id='afBacktoReviewBtn']")
    private WebElement backToReviewRI;
	
	@FindBy(how = How.XPATH, using = "//button[@id='afBacktoReviewBtn']")
    private WebElement riNextReviewBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'addressLegal')]//div[@id='sect1']/div")
	private WebElement legalFooternotes;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'addressLegal')]//button[@id='legalFooter']")
	private WebElement legalFootNotesExpand;
	
	
	public void residentialInformation(DSA_DM dsa) throws Exception {
		try {
			log.info("Attempting to enter Residential Information");
			WebElement residentialInfo = driverWait.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='parsys_3 parsys']//form[@id='address-form']")));
			try {
				log.info("Attempting to validate page");
				if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
					WebElement pageHeader = residentialInfo.findElement(By.xpath("//section[@id='address-form-section']/h1"));
					Assert.assertTrue(pageHeader.getText().contains("Informations Résidentielles"));
				} else {
//					expectedTitle = "Residential";
//					wait.until(ExpectedConditions.titleContains(expectedTitle));
//					pageTitle();
				}
			} catch (Exception e) {
				log.info("Caught error attempting to validate page");
				e.printStackTrace();
			}
			if(dsa.getAddressLine2().equals("")) {
					//WebElement addressLookUp = driver.findElement(By.xpath(".//form[@id='address-form']//input[@id='afAddressLookup']"));
				  // inputText(By.xpath(addressLookUpField), dsa.getAddressLine1() +", "+ dsa.getCityString() +", "+ dsa.getProvince().substring(5, dsa.getProvince().length())+", "+ dsa.getPostCode());
				  /* WebElement ele = driver.findElement(By.xpath(addressList));
				   Actions action = new Actions(driver);
				   action.doubleClick(ele).build().perform();
				   if(isElementVisible(By.xpath(addressList)))
				   {
					   action.doubleClick(ele).build().perform();
				   }*/
				   
				   clickElement(enterManualAddressLink);
					inputText(unitNumberField, "");
					inputText(addressLine1, dsa.getAddressLine1());
					inputText(cityField, dsa.getCityString());
					inputText(postalCodeField, dsa.getPostCode());
					if(dsa.getProvince().contains("-")) {
					selectFromDropdownByText(provinceField,dsa.getProvince().substring(5, dsa.getProvince().length()));
					dsa.setProvince(dsa.getProvince().substring(5, dsa.getProvince().length()));
					}
					else {
						selectFromDropdownByText(provinceField,dsa.getProvince());
						dsa.setProvince(dsa.getProvince());
					}
				    inputText(afHousePayment,dsa.getMonthlyRentString());
					inputText(afYear,dsa.getYrAtAddress());
					selectFromDropdownByText(afCurAddressMonth, dsa.getMonthatAddress());
					selectFromDropdownByText(afResiStatus, dsa.getResidenceType());//s
				//	clickElement(By.xpath("//div[@class='button-container mobile-reverse']/button[@id='afNextBtn']"));
				//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//form[@id='address-form']//input[@id='afAddressLookup']")));//
			}else
			{
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("enter your mailing address")));
					clickElement(enterManualAddressLink);
					inputText(unitNumberField, "");
					inputText(addressLine1, dsa.getAddressLine1());
					inputText(addressLine2, dsa.getAddressLine2());
					inputText(cityField, dsa.getCityString());
					inputText(postalCodeField, dsa.getPostCode());
					
					selectFromDropdownByText(provinceField,dsa.getProvince().substring(5, dsa.getProvince().length()));
					selectFromDropdownByText(residentStatus, dsa.getResidenceType());
					Thread.sleep(2000);
			/*	}
				else {	
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("saisir votre adresse postale")));
						driver.findElement(By.linkText("saisir votre adresse postale")).click();
						inputText(By.xpath(unit), "");
						inputText(By.xpath(addressLine1), dsa.getAddressLine1());
						inputText(By.xpath(addressLine2), dsa.getAddressLine2());
						inputText(By.xpath(cityField), dsa.getCityString());
						inputText(By.xpath(postalCodeField), dsa.getPostCode());
						
						selectFromDropdownByText(By.xpath(provinceField),dsa.getProvince().substring(5, dsa.getProvince().length()));
						selectFromDropdownByText(By.xpath(residentStatus), dsa.getResidenceType());//s
				}
					
			}
			else {
					if (dsa.getLanguage().equals("Eng")) {
						driver.findElement(By.linkText("enter your mailing address")).click();
					} else {
						driver.findElement(By.linkText("saisir votre adresse postale")).click();
					}
				//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@id='afAddressLine1']")));
					driver.findElement(By.xpath(".//input[@id='afUnitNum']")).sendKeys("");
					driver.findElement(By.xpath(".//input[@id='afAddressLine1']")).sendKeys(dsa.getAddressLine1());
					driver.findElement(By.xpath(".//input[@id='afAddressLine2']")).sendKeys(dsa.getAddressLine2());
					driver.findElement(By.xpath(".//input[@id='afCity']")).sendKeys(dsa.getCityString());
					driver.findElement(By.xpath(".//input[@id='afPostal']")).sendKeys(dsa.getPostCode());
					selectFromDropdownByText(By.xpath("//select[@id='afProvince']"),dsa.getProvince().substring(5, dsa.getProvince().length()));//s
					selectFromDropdownByText(By.xpath("//select[@id='afResiStatus']"), dsa.getResidenceType());//s
					selectFromDropdownByValue(By.xpath("//select[@id='afCurAddressMonth']"), dsa.getMonthatAddress());
					WebElement yrAtResidence = residentialInfo.findElement(By.xpath("//input[@id='afYear']"));
					yrAtResidence.sendKeys(dsa.getYrAtAddress());
					WebElement housePayment = driver.findElement(By.xpath(".//input[@id='afHousePayment']"));
					housePayment.sendKeys(dsa.getMonthlyRentString());
				//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='afNextBtn']")));
					//clickElement(By.xpath("//div[@class='button-container mobile-reverse']/button[@id='afNextBtn']"));
			} */
			}
			Thread.sleep(3000);
			WebElement nxtButton = getElementWhenVisible(By.xpath(".//div[contains(@class,'button-container')]/button[@id='afNextBtn']"));
			clickElement(nxtButton);
			Thread.sleep(3000);
		} catch (Exception e) {
			log.info("Caught error attempting to enter residential information");
			System.out.println("\n\n"+e);
			e.printStackTrace();
			throw e;
		}	
	}


//	@Override
	public void validate() throws ValidationException, InterruptedException {
//		validateText(By.xpath(header), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-02"));
//		validateText(By.xpath(addressLookUpFieldLabel), getInputText("dd:"));
		waitForVisible(addressLookUpField);
//		waitForVisible(By.xpath(enterManualAddressLink));
//		waitForVisible(By.xpath(nextBtn));
		
	}
	
public void validate(String cardType) throws ValidationException {
		WebElement header = getElementWhenVisible(By.xpath("//div[@class='navbar-header']//span[@class='select-card ng-scope']/span[contains(@data-ng-show,'"+cardType+"')]"));
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
	
	public boolean verifyAddressList()
	{
		boolean status = false;
		status = isElementVisible(addressListBox);
		return status;
	}
	
	private ResidentialStatus resiStatus = ResidentialStatus.Select;
	public static String resistatusSelectedOption;
	enum ResidentialStatus {
		Select, Own , Rent, LivewithParents, StudentHousing, Other;
	}
	public void selectResiDefault() throws InterruptedException {
		resiStatus = ResidentialStatus.Select;
		resistatusSelectedOption=searchDataDictionary("dd:DSA-SELECT-DROPDOWN");
		selectEmpStatus(resistatusSelectedOption);
	}
	public void selectOwn() throws InterruptedException {
		resiStatus = ResidentialStatus.Own;
		resistatusSelectedOption=searchDataDictionary("dd:DSA-ADDRESS-FORM-0020");
		selectEmpStatus(resistatusSelectedOption);
	}
	public void selectRent() throws InterruptedException {
		resiStatus = ResidentialStatus.Rent;
		resistatusSelectedOption=searchDataDictionary("dd:DSA-ADDRESS-FORM-0021");
		selectEmpStatus(resistatusSelectedOption);
	}
	public void selectLivewithParents() throws InterruptedException {
		resiStatus = ResidentialStatus.LivewithParents;
		resistatusSelectedOption=searchDataDictionary("dd:DSA-ADDRESS-FORM-0022-LIVE-WITH-PARENTS");
		selectEmpStatus(resistatusSelectedOption);
	}
	public void selectStudentHousing() throws InterruptedException {
		resiStatus = ResidentialStatus.StudentHousing;
		resistatusSelectedOption=searchDataDictionary("dd:DSA-ADDRESS-FORM-0023");
		selectEmpStatus(resistatusSelectedOption);
	}
	public void selectOther() throws InterruptedException {
		resiStatus = ResidentialStatus.Other;
		resistatusSelectedOption=searchDataDictionary("dd:DSA-ADDRESS-FORM-0024");
		selectEmpStatus(resistatusSelectedOption);
	}
	
	
	public void selectEmpStatus(String type) throws InterruptedException {
		selectFromDropdownByText(residentStatus, type);
	}
	
	private Province province = Province.Select;
	public static String provinceSelectedOption;
	enum Province {
		Select , ALBERTA, BRITISHCOLUMBIA,MANITOBA, NEWBRUNSWICK, NEWFOUNDLANDANDLABRADOR, NOVASCOTIA, NORTHWESTTERRITORIES, 
		NUNAVUT, ONTARIO, PRINCEEDWARDISLAND, QUEBEC, SASKATCHEWAN, YUKON;
	}
	public void selectProvinceDefault() throws InterruptedException {
		province = Province.Select;
		provinceSelectedOption=searchDataDictionary("dd:DSA-SELECT-DROPDOWN");
		selectEmpStatus(provinceSelectedOption);
	}
	public String selectAlberta() throws InterruptedException {
		province = Province.ALBERTA;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-01");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}
	public String selectBritishColumbia() throws InterruptedException {
		province = Province.BRITISHCOLUMBIA;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-02");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}  
	public String selectManitoba() throws InterruptedException {
		province = Province.MANITOBA;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-03");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	} 
	public String selectNewBrunswick() throws InterruptedException {
		province = Province.NEWBRUNSWICK;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-04");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}  
	public String selectNewFoundLandAndLabrador() throws InterruptedException {
		province = Province.NEWFOUNDLANDANDLABRADOR;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-05");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}
	public String selectNovascotia() throws InterruptedException {
		province = Province.NOVASCOTIA;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-06");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}
	public String selectNorthWestTeerritories() throws InterruptedException {
		province = Province.NORTHWESTTERRITORIES;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-07");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}
	public String selectNunavut() throws InterruptedException {
		province = Province.NUNAVUT;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-08");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	} 
	public String selectOntario() throws InterruptedException {
		province = Province.ONTARIO;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-09");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}  
	public String selectPrinceEdwardIsland() throws InterruptedException {
		province = Province.PRINCEEDWARDISLAND;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-10");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}
	public String selectQubec() throws InterruptedException {
		province = Province.QUEBEC;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-11");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}
	public String selectSaskatchewan() throws InterruptedException {
		province = Province.SASKATCHEWAN;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-12");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}
	public String selectYukon() throws InterruptedException {
		province = Province.YUKON;
		provinceSelectedOption=searchDataDictionary("dd:DSA-PROVINCE-13");
		selectprovince(provinceSelectedOption);
		return provinceSelectedOption;
	}
	
	public void selectprovince(String type) throws InterruptedException {
		selectFromDropdownByText(provinceField, type);
	}
}
