package com.nosuchelements.pages.dsa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;

import lombok.Data;

@PageObject
@Data
public class SecureKeyVerificationPage extends BasePage {
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'continueBtn')]")
    private WebElement continueBtn;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='type-passport']/div[@class='doc-name'])[1]")
    private WebElement passportLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='passport']")
    private WebElement passportBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='drivers_license']//preceding-sibling::div//div[2]")
    private WebElement driversLicenseLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='drivers_license']")
    private WebElement driversLicenseBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='national_card']//preceding-sibling::div//div[2]")
    private WebElement provincionalCardLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='national_card']")
    private WebElement provincionalCardBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='resident_permit']//preceding-sibling::div//div[2]")
    private WebElement permanentResidentCardLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='resident_permit']")
    private WebElement permanentResidentCardBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@id='indigenous_card']//preceding-sibling::div//div[2]")
    private WebElement IndianStatusCardLabel;
	
	@FindBy(how = How.XPATH, using = "//input[@id='indigenous_card']")
    private WebElement IndianStatusCardBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='terms-and-conditions']")
    private WebElement SKTnCCheckbox;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'continueBtn ')]")
    private WebElement TnCcontinueBtn;
	
}
