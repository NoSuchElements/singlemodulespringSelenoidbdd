package com.nosuchelements.pages.dsa;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;
import com.nosuchelements.utils.DriverHelper;
import com.nosuchelements.utils.dsa.CommonUtils;

import lombok.Data;

@PageObject
@Data
public class ReviewAndSubmitPage extends BasePage {

	
	@Autowired
	protected DriverHelper driverHelper;
	
	@Autowired
	private CommonUtils commutil;
	
	protected void getAllValues() {
		
		
	}

	public WebElement getSuppPhoneNumValue() {
		String ddSuppPhoneNumLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-037");
		return driverManager.getDriver().findElement(By.xpath("//div[contains(@data-ng-if,'hasSupp')]//p[contains(text(),'"+ddSuppPhoneNumLabel.replace(":", "")+"')]//..//following-sibling::div/p"));
	}

	public WebElement getAddressValueLabel() {
		String ddmyaddress = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-02");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyaddress+"']//..//..//p[contains(text(),'Address')]"));
	}

	public WebElement getResidentialStatusLabel() {
		String ddmyaddress = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-02");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyaddress+"']//..//..//p[contains(text(),'Residential Status')]"));
	}

	public WebElement getMonthlyPaymentLabel() {
		String ddmyaddress = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-02");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyaddress+"']//..//..//p[contains(text(),'Monthly payment')]"));
	}

	public WebElement getAddressSinceLabel() {
		String ddmyaddress = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-02");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyaddress+"']//..//..//p[contains(text(),'address since')]"));
	}

	public WebElement getJobCategoryValue() {
		String ddjobCategoryLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-027");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddjobCategoryLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getJobDescriptionValue() {
		String ddjobDescLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-059");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddjobDescLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getJobTitleOtherValue() {
		String ddjobTitleOtherLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-050");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddjobTitleOtherLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getEmployerNameValue() {
		String ddemployerNameLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-058");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddemployerNameLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getEmployerCityValue() {
		String ddempCityLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-060");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddempCityLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getEmployerPhoneValue() {
		String ddempPhoneLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-057");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddempPhoneLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getEmployerSince() {
		String ddempSinceLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-029");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddempSinceLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getAnnualPersonalIncome() {
		String ddpersonalAnnlIncLabel = searchDataDictionary("dd:DSA-IBM-FINANCIAL-INFO-0008");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddpersonalAnnlIncLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getAnnualHHIncome() {
		String ddannualHHIncLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-031");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddannualHHIncLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getEmploymentStatusLabel() {
		String ddmyWork = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-03");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyWork+"']//..//..//p[contains(text(),'Employment Status')]"));
	}

	public WebElement getMyPrefLabel() {
		String ddmyPref = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-05");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyPref+"']"));
	}

	public WebElement getMyPrefExpand() {
		String ddmyPref = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-05");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyPref+"']//..//span[@aria-hidden='false']"));
	}

	public WebElement getStatements() {
		String ddstmtLabel = searchDataDictionary("dd:DSA-IBM-REVIEW-SUBMIT-011");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddstmtLabel+"')]//..//following-sibling::div/p[contains(@class,'value') and @aria-hidden='false']"));
	}

	public WebElement getLoyaltyNumberValue() {
		String ddtriangleRewardNumLabel = getInputText("dd:normalized:DSA-LOYALTY-VIEW-0002").substring(5, 15);
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddtriangleRewardNumLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}

	public WebElement getSuppCardMemberValue() {
		String ddsuppCardMemLabel = searchDataDictionary("dd:DSA-IBM-REVIEW-SUBMIT-012");
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddsuppCardMemLabel+"')]//..//following-sibling::div/p[contains(@class,'value') and @aria-hidden='false']"));
	}

	public WebElement getSuppNameValue() {
		String ddSuppNameLabel =searchDataDictionary("dd:DSA-REVIEW-SUBMIT-013");
		return driverManager.getDriver().findElement(By.xpath("//div[contains(@data-ng-if,'hasSupp')]//p[contains(text(),'"+ddSuppNameLabel+"')]//..//following-sibling::div/p"));
	}

	public WebElement getSuppDOBValue() {
		String ddSuppDOBLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-014");
		return driverManager.getDriver().findElement(By.xpath("//div[contains(@data-ng-if,'hasSupp')]//p[contains(text(),'"+ddSuppDOBLabel+"')]//..//following-sibling::div/p"));
	}

	public WebElement getSuppAddressValue() {
		String ddSuppAddressLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-038");
		return driverManager.getDriver().findElement(By.xpath("//div[contains(@data-ng-if,'hasSupp')]//p[contains(text(),'"+ddSuppAddressLabel+"')]//..//following-sibling::div/p"));
	}

	public WebElement getStatementsLabel() {
		String ddmyPref = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-05");
		String ddstmtLabel = searchDataDictionary("dd:DSA-IBM-REVIEW-SUBMIT-011");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyPref+"']//..//..//p[contains(text(),'"+ddstmtLabel+"')]"));
	}

	public WebElement getTriangleMemShpCardNoLabel() {
		String ddmyPref = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-05");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyPref+"']//..//..//p[contains(text(),'Membership Number')]"));
	}

	public WebElement getSuppCardMemberLabel() {
		String ddmyPref = searchDataDictionary("dd:DSA-IBM-LEFT-NAV-05");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='"+ddmyPref+"']//..//..//p[contains(text(),'Supplementary card member')]"));
	}

	public WebElement getStatusLabel() {
		String ddcpiEnrollStatusLabel = searchDataDictionary("dd:DSA-REVIEW-SUBMIT-013");
		return driverManager.getDriver().findElement(By.xpath("//h5[text()='Credit']//..//..//p[contains(text(),'"+ddcpiEnrollStatusLabel+"')]"));
	}
	
	public WebElement getTriangleRewardsAccNum() {
		String ddtriangleRewardNumLabel = getInputText("dd:normalized:DSA-LOYALTY-VIEW-0002").substring(5, 15);
		return driverManager.getDriver().findElement(By.xpath("//p[contains(text(),'"+ddtriangleRewardNumLabel+"')]//..//following-sibling::div/p[contains(@class,'value')]"));
	}
	

	@FindBy(how = How.XPATH, using = "//div[@id='step-12-review-submit']/h1")
    private WebElement reviewHeader;
	
	@FindBy(how = How.XPATH, using = "//div[@id='step-12-review-submit']/div[2]/div/div[1]/h5")
    private WebElement aboutMeLabel;
	
	@FindBy(how = How.XPATH, using = "//button[@class='editLink' and contains(@data-ng-click,'personal')]")
    private WebElement aboutMeEdit;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordionAboutMe']//p/span[@aria-hidden='false']")
    private WebElement aboutMeExpand;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'personal')]/../div[1]/div[2]/p")
    private WebElement NameValue;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'personal')]/../div[2]/div[2]/p")
    private WebElement DOBValue;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'personal')]/../div[4]/div[2]/p[@aria-hidden='false']")
    private WebElement marketingPreference;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'personal')]/../div[5]/div[2]/p")
    private WebElement preferredLangeValue;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'personal')]/../div[6]/div[2]")
    private WebElement PhoneNumberValue;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'personal')]/../div[3]/div[2]/p")
    private WebElement emailValue;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordionAboutMe']/div//div[7]//div[2]/p")
    private WebElement SINValue;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='About Me']//..//..//p[contains(text(),'Name')]")
    private WebElement NameLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='About Me']//..//..//p[contains(text(),'Date of Birth')]")
    private WebElement DOBLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='About Me']//..//..//p[contains(text(),'Marketing Preferences')]")
    private WebElement MarketingPreferenceLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='About Me']//..//..//p[contains(text(),'Phone Number')]")
    private WebElement PhoneNumberLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='About Me']//..//..//p[contains(text(),'Email')]")
    private WebElement EmailAddressLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='About Me']//..//..//p[contains(text(),'SIN')]")
    private WebElement SINLabel;

	@FindBy(how = How.XPATH, using = "//a[@class='editLink' and contains(@data-ng-click,'address')]/../preceding-sibling::div/h5")
	private WebElement myAddressLabel;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@aria-label,'Edit My Address')]")
    private WebElement myAddressEdit;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordionMyAddress']/button/p/span[@aria-hidden='false']")
    private WebElement myAddressExpand;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='accordionMyAddress']//div[@class='panel']/div//div[2]/p)[1]")
    private WebElement AddressValue;
	
	@FindBy(how = How.XPATH, using = "//a[@class='editLink' and contains(@data-ng-click,'address')]/..//div[2]/div[2]/p")
    private WebElement residentialStatus;
	
	@FindBy(how = How.XPATH, using = "//a[@class='editLink' and contains(@data-ng-click,'address')]/..//div[3]/div[2]/p")
    private WebElement monthlyPayment;
	
	@FindBy(how = How.XPATH, using = "//a[@class='editLink' and contains(@data-ng-click,'address')]/..//div[4]/div[2]/p")
    private WebElement addressSince;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-if,'addressline1_prev')]//p[@class='value ng-binding']")
    private WebElement prevAddressValue;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'financial')]/../preceding-sibling::div/h5")
    private WebElement myWorkLabel;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@data-ng-click,'financial')]")
    private WebElement myWorkEdit;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordionMyWork']//span[@aria-hidden='false']")
    private WebElement myWorkExpand;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordionMyWork']//div/div[10]/div[1]")
    private WebElement myWorkCreditLimitTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordionMyWork']/div/div[4]/div[1]/p")
    private WebElement myWorkCrLimitTitleRetired;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-if,'reviewSubmitCtrl.inQC')]//p[@class='value ng-binding']")
    private WebElement myWorkCreditLimitAmount;
	
	@FindBy(how = How.XPATH, using = "//p[contains(@data-ng-if,'employmentStatus')]")
    private WebElement EmploymentStatusValue;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='My work']//..//..//p[contains(text(),'Job Category')]")
    private WebElement JobCategoryLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='My work']//..//..//p[contains(text(),'Job Title')]")
    private WebElement JobTitleLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='My work']//..//..//p[contains(text(),'Other')]")
    private WebElement JobTitleOtherLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='My work']//..//..//p[contains(text(),'Employer')]")
    private WebElement EmployerNameLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordionMyWork']/div/div[6]/div[1]/p")
    private WebElement EmployerCityLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='My work']//..//..//p[contains(text(),'employer since')]")
    private WebElement EmployerSinceLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='My work']//..//..//p[contains(text(),'Annual Personal Income')]")
    private WebElement AnnualPersonalIncomeLabel;
	
	@FindBy(how = How.XPATH, using = "//h5[text()='My work']//..//..//p[contains(text(),'Annual Household Income')]")
    private WebElement AnnualHHIncomeLabel;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@data-ng-click,'contact') and contains(@data-ng-keydown,'reviewSubmitCtrl')]")
    private WebElement myPrefEdit;
	
	@FindBy(how = How.XPATH, using = "//p[contains(@data-ng-if,'suppRelationship')]")
    private WebElement SuppRelationValue;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'cp')]/..//preceding-sibling::div/h5")
    private WebElement cpiLabel;
	
	@FindBy(how = How.XPATH, using = "//button[@class='editLink' and contains(@data-ng-click,'cp')]")
    private WebElement creditProtectEdit;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordionCreditProtectionInsurance']//p/span/img[@aria-hidden='false']")
    private WebElement creditProtectExpand;
	
	@FindBy(how = How.XPATH, using = "//p[contains(@data-ng-if,'optionalInsurance_CP')]")
    private WebElement status;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement legalHeader;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']//p[@class='marTop20'][1]")
    private WebElement reviewDocPara;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div/div/div[1]/div[1]/ul[1]/li[2]/strong[2]")
    private WebElement aprAuthTandC1;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div/div/div[1]/div[1]/ul[1]/li[2]/strong[3]")
    private WebElement aprAuthTandC2;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl') and @aria-hidden='false']//span[contains(@class,'printOrDownload')]//a")
    private WebElement TnCPdflink;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']//button)[2]")
    private WebElement privacyCharterLink;
	
	@FindBy(how = How.XPATH, using = "//div[@id='dialog-header']/div//h1")
    private WebElement privacyChartPopupHeader;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dialog-header']/div[1]/div/h1")
    private WebElement privacyChartPopupHeaderAfterToggle;
	
	@FindBy(how = How.XPATH, using = "//button[@id='cocAgreeBtn']")
    private WebElement privacyCharterGotIt;
	
	@FindBy(how = How.XPATH, using = "(//span[@class='marTop30 marBot10'])[1]/h4/a")
    private WebElement privacyCharterLinkOMX;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@data-ng-show,'reviewSubmitCtrl')]//a[contains(@href,'privacy_security')])[4]")
    private WebElement privacyCharterLinkOMP;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@data-ng-show,'reviewSubmitCtrl')]//a[contains(@href,'privacy_security')])[3]")
    private WebElement privacyCharterLinkOMR;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@id,'rsLegalCheckboxValidations')]/small")
    private WebElement readScroll;
	
//	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']//input[@id='rsLegalCheckbox']")
	@FindBy(how = How.XPATH, using = "//div[@class='termBox']//input[@id='rsLegalCheckbox2']")
    private WebElement rsLegalCheckbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='rsLegalCheckboxPC']")
    private WebElement rsFirstCheckbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='rsLegalCheckboxTC']")
    private WebElement rsSecCheckbox;
	
//	@FindBy(how = How.XPATH, using = "//div[@id='rsLegalCheckboxPC2Validations']/small")   OMR
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div[2]/div[1]/div/div/div/small")
	private WebElement rsCollectionErrorMsg;
	
//	@FindBy(how = How.XPATH, using = "//div[@id='rsLegalCheckboxTC2Validations']/small")
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div[2]/div[2]/div/div/div/small")
    private WebElement rsCreditErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div[2]/div[3]/div/div[2]/div/small")
    private WebElement rsAuthErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']//input[@id='rsLegalCheckboxAuth']")
    private WebElement rsLegalCheckboxOMZ;
	
	// Folowing 4 termsandCondErrorMsg replaced by rsAuthErrorMsg
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'OMZ')]//div[@id='rsLegalCheckboxValidations']//small[@class='ng-scope']")
	private WebElement termsAndCondErrorMsgOMZ;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'OMX')]//div[@class='term-checkbox-group']/div/div[2]")
    private WebElement termsAndCondErrorMsgOMX;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'OMP')]//div[@id='rsLegalCheckboxValidations']//small[@class='ng-scope']")
    private WebElement termsAndCondErrorMsgOMP;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'OMR')]//div[@id='rsLegalCheckboxValidations']//small[@class='ng-scope']")
	private WebElement termsAndCondErrorMsgOMR;
	
	@FindBy(how = How.XPATH, using = "//button[@id='rsSubmitBtn']")
    private WebElement submitBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@class=' marTop20 marBot20']/div[1]/a[1]")
    private WebElement pdfCertificateIns;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Print or Download PDF version of Summary')]")
    private WebElement pdfResidentsQuebec;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Print or Download PDF version of the Roadside Assi')]")
    private WebElement pdfRoadsideAssistance;
	
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Roadside Assistance Terms and Conditions & Embedde')]")
    private WebElement roadsideAssisTC;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Roadside Assistance, Purchase Protection, Extended')]")
    private WebElement roadsideParagraph;
	
	@FindBy(how = How.XPATH, using = "//div[@class='marTop20']/ul/li[3]")
    private WebElement cardMemberAgreement;
	
//	@FindBy(how = How.LINK_TEXT, using = "Cardmember Agreement")
	@FindBy(how = How.XPATH, using = "(//div[@class='marTop20']//ul/li[3]/span/a)[2]")
    private WebElement CMAinEng;
	
//	@FindBy(how = How.LINK_TEXT, using = "Contrat du titulaire de la carte")
	@FindBy(how = How.XPATH, using = "(//div[@class='marTop20']//ul/li[3]/span/a)[1]")
	private WebElement CMAinFrc;
	
	@FindBy(how = How.XPATH, using = "//form[@id='review-form']//div[contains(@data-ng-show,'reviewSubmitCtrl') and @aria-hidden='false']//div/div[@class='marBot16']/span/a")
    private WebElement printRewardsTCOMXOMZ;
	
	@FindBy(how = How.LINK_TEXT, using = "Print or Download PDF version of Gas Advantage Mastercard Rewards Program Terms & Conditions")
    private WebElement printRewardsTCOMP;
	
	@FindBy(how = How.LINK_TEXT, using = "Print or Download PDF version of Gas Advantage Mastercard Rewards Program Terms & Conditions")
    private WebElement printRewardsTCOMR;
	
	@FindBy(how = How.XPATH, using = "//form[@id='review-form']//div[contains(@data-ng-show,'reviewSubmitCtrl') and @aria-hidden='false']//div/div[@class='termText']")
    private WebElement CreditCheckQC;
	
	@FindBy(how = How.XPATH, using = "//form[@id='review-form']//div[contains(@data-ng-show,'reviewSubmitCtrl') and @aria-hidden='false']//div/p[@class='termText']")
    private WebElement CreditCheckPara;
	
	@FindBy(how = How.LINK_TEXT, using = "Print or Download PDF version of the Certificate of Insurance")
    private WebElement CertInsuranceOMZ;
	
	@FindBy(how = How.LINK_TEXT, using = "Imprimez ou téléchargez la version PDF de l'attestation d'assurance")
    private WebElement CertInsuranceOMZFRC;
	
	@FindBy(how = How.LINK_TEXT, using = "Print or Download PDF version of the Roadside Assistance Terms and Conditions")
    private WebElement roadSideTC;
	
	@FindBy(how = How.LINK_TEXT, using = "Imprimez ou téléchargez la version PDF du Modalités de l'assistance routière")
    private WebElement roadSideTCFRC;
	
	@FindBy(how = How.LINK_TEXT, using = "Résidents du Québec seulement : Imprimez ou téléchargez la version PDF du sommaire")
    private WebElement residentsQC;
	
	@FindBy(how = How.LINK_TEXT, using = "Residents of Quebec Only: Print or Download PDF version of Summary")
    private WebElement residentsQCEng;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dialog-header']/div[2]/label")
    private WebElement toggleInWindow;
	
	// CREDIT & ID CHECK
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div[2]/div[1]/div[1]/label")
	private WebElement crPrivacyText;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div[2]/div[2]/div[1]/label")
    private WebElement crCreditRepText;
	
//	@FindBy(how = How.XPATH, using = "//div[@class='term-checkbox-group'][3]/div/div/label[@for='rsLegalCheckbox1']")
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div[2]/div[3]/div/div/label")
	private WebElement crAuthText;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'reviewSubmitCtrl.cardType') and @aria-hidden='false']/div[@class='termBox']/div[3]/div[1]/div[1]/label[@class='termText']")
	private WebElement crAuthTextQC;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'OMX')]/div[1]/div[@class='marTop20']/div/div")
    private WebElement authTCOMX;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'OMZ')]/div[1]/div[@class='marTop20']/div/div")
    private WebElement authTCOMZ;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'OMP')]/div[1]/div[@class='marTop20']/div/div")
    private WebElement authTCOMP;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'OMR')]/div[1]/div[@class='marTop20']/div/div")
    private WebElement authTCOMR;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement spcChar;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'reviewLegal')]//div[@id='sect1']/div")
	private WebElement legalFooternotes;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'reviewLegal')]//button[@id='legalFooter']")
	private WebElement legalFootNotesExpand;

	
	public void reviewAndSubmit(DSA_DM dsa) throws IOException {
		try
		{
			if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
				expectedTitle = "Un dernier coup d’œil!";
				System.out.println("--------"+expectedTitle+"---------");
				driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
				commutil.pageTitle();
			} else {
//				expectedTitle = "Credit Protector";
//				//expectedTitle = "One Last Check!";
//				System.out.println("title is "+driver.getTitle());
//				wait.until(ExpectedConditions.titleContains(expectedTitle));
//				pageTitle();
			}
			

			driverWait.getDriverWait().until(ExpectedConditions.elementToBeClickable(rsLegalCheckbox)).click();
			submitBtn.click();
			
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			boolean status = isElementVisible(getElementWhenVisible(By.xpath("//button[@id='rsSubmitBtn']")));
			if(status)
			{
				throw new Exception("Failed to Submit");
			}
			//WebDriverWait newWait = new WebDriverWait(driver, 60);
			
			String response = "Thank you, we've received your application. | Triangle MasterCard";
			
			//for (String currentResponse : response) {
				String responseTitle = driverManager.getDriver().getTitle();
				System.out.println("Current Response Title "+response);
				System.out.println("Response Title "+responseTitle);
				if(response.equals(responseTitle)) {
					System.out.println("RESPONSE: " + response);
				}
				else
				{
					throw new Exception("Failed to Submit");
				}
			//}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

//	@Override
	public void validate() throws ValidationException, InterruptedException {
//		validateText(By.xpath(reviewHeader), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-02"));
//		waitForVisible(By.xpath(aboutMeLabel));
		waitForVisible(submitBtn);
	}

}
