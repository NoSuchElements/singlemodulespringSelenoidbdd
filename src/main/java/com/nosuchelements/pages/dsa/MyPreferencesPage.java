package com.nosuchelements.pages.dsa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;

import lombok.Data;

@PageObject
@Data
public class MyPreferencesPage extends BasePage {
	
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='scI18nValues']/following-sibling::h1")
    private WebElement prefHeader;
	
	@FindBy(how = How.XPATH, using = "//div[@class='parsys_1 responsivegrid']//button[@id='ciNextBtn']")
    private WebElement cNextBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@id='ciBacktoReviewBtn']")
    private WebElement mPNextReviewBtn;
	
	@FindBy(how = How.XPATH, using = "//form[@id='contact-info-form']/h2[@class='marTop30']")
    private WebElement statementsHeader;
	
	@FindBy(how = How.XPATH, using = "//form[@id='contact-info-form']/h2[@class='marTop30']//following-sibling::p")
    private WebElement statementAdvisory;
	
	@FindBy(how = How.XPATH, using = "//button[@id='ciSelecteStatement']")
    private WebElement eStatements;
	
	@FindBy(how = How.XPATH, using = "//div[@id='eStatementMessage']/button")
    private WebElement eStatementsTnCLink;
	
	@FindBy(how = How.XPATH, using = "//div[@id='eStatementMessage']/button/div")
    private WebElement eStatementsTnCLinkText;
	
//	@FindBy(how = How.XPATH, using = "//div[@id='dialog-header']//div[contains(@data-ng-if,'estatementToggleLanguage')]/h1")
	@FindBy(how = How.XPATH, using = "//div[@id='dialog-header']//div[contains(@ng-switch,'contactInfoCtrl')]")
    private WebElement eStatementsTnCPopupHeader;
	
	@FindBy(how = How.XPATH, using = "//input[@id='language-toggle']//..")
    private WebElement eStatementsTnCPopupEnglishToggle;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scrollableDiv']//div[contains(@data-ng-if,'estatementToggleLanguage')]")
    private WebElement eStatementsTnCPopupText;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='scrollableDiv']//div[contains(@data-ng-if,'estatementToggleLanguage')]//p)[1]")
    private WebElement eStatementsSaveOrPrint;
	
	@FindBy(how = How.XPATH, using = "//button[@id='cocAgreeBtn']")
    private WebElement gotItBtn;
	
	@FindBy(how = How.XPATH, using = "//input[@name='ciEstatementCheckbox']")
    private WebElement eStatementCheckBox;
	
//	@FindBy(how = How.XPATH, using = "//label[@for='ciEstatementCheckbox']//div[@ng-switch-when='true']")
	@FindBy(how = How.XPATH, using = "//label[@for='ciEstatementCheckbox']/div")
    private WebElement eStatementsConsetText;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ciSelectMail']")
    private WebElement mailedStmnt;
	
	@FindBy(how = How.XPATH, using = "//div[@id='mailMessage']//span[@id='poBoxMsg-msg']")
    private WebElement mailedStmntAdvisory;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ciSelectYesTriangle']")
    private WebElement triangleCardNumberYes;
	
	@FindBy(how = How.XPATH, using = "//*[@id='lvLoyaltyNumber']")
    private WebElement loyaltyNumber;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ciSelectNoTriangle']")
    private WebElement triangleCardNumberNo;
	
	@FindBy(how = How.XPATH, using = "//div[@data-ng-show='contactInfoCtrl.viewNoLoyalty']//span[@id='poBoxMsg-msg']")
    private WebElement triangleCardNoAdvisory;
	
	//fieldset[@aria-labelledby='triangleNumberSelectionhelper']/div[2]/div/p
	
	@FindBy(how = How.XPATH, using = "//div[@data-ng-show='contactInfoCtrl.viewNoLoyalty']//span[@id='contPoBoxMsg-msg2']")
    private WebElement loyaltyLanguage;
	
//	@FindBy(how = How.XPATH, using = "//input[@id='lvLoyaltyNumber']")
//    private WebElement traingleMemberNo;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ciSelectNoSuppCard']")
    private WebElement noSupCard;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ciSelectYesSuppCard']")
    private WebElement yesSupCard;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scFirstName']")
    private WebElement scFirstName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scLastName']")
    private WebElement scLastName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scDateOfBirth'][1]")
    private WebElement scDob;
	
	@FindBy(how = How.XPATH, using = "//select[@id='scRelationship']")
    private WebElement applcntRltnshp;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scPhoneNum']")
    private WebElement scPhoneNumber;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scSameAddress']")
    private WebElement scSameAddress;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scNewAddress']")
    private WebElement scNewAddress;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scCheckbox']")
    private WebElement sameAddressCheckbox;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'SuppTerms')]")
    private WebElement suppTnCLink;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scAddressLookup']")
    private WebElement scAddressLookup;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'manualText')]")
    private WebElement scManualEntry;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scUnitNum']")
    private WebElement scUnitNo;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scAddressLine1']")
    private WebElement scMailingAddLn1;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scAddressLine2']")
    private WebElement scMailingAddLn2;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scCity']")
    private WebElement scCity;
	
	@FindBy(how = How.XPATH, using = "//select[@id='scProvince']")
    private WebElement scProvince;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scPostal']")
    private WebElement scPostalCode;
	
	@FindBy(how = How.XPATH, using = "//div[@class='row marTop20 marLeft10']/button")
    private WebElement scImpInfoLink;
	
	@FindBy(how = How.XPATH, using = "//div[@class='row marTop20 marLeft10']")
    private WebElement scImpInfoLinkText;
	
	@FindBy(how = How.XPATH, using = "//h2[@id='ngdialog3-aria-labelledby']")
    private WebElement scImpInfoHeader;
	
	@FindBy(how = How.XPATH, using = "//div[@id='lvLoyaltyNumContainer']//label[@for='lvLoyaltyNumber']")
    private WebElement triangleCardNoLabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement addressLabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement unitNumberLabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement address2Label;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement cityLabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement provinceLabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement postalCodeLabel;
	
	@FindBy(how = How.XPATH, using = "//label[@for='ciSelectMail']")
    private WebElement mailedStmntLabel;
	
	@FindBy(how = How.XPATH, using = "//label[@for='ciSelecteStatement']")
    private WebElement eStatementsLabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement triangleCardNumberYeslabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement triangleCardNumberNolabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement suppAccountYesLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scFirstNameContainer']//label[@for='scFirstName']")
    private WebElement suppFirstNameLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scLastNameContainer']//label[@for='scLastName']")
    private WebElement suppLastNameLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scDateOfBirthContainer']//label[@for='scDateOfBirth']")
    private WebElement suppDobLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scPhoneNumContainer']//label[@for='scPhoneNum']")
    private WebElement suppPhoneLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scRelationshipContainer']//label[@for='scRelationship']")
    private WebElement suppRelationLabel;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement suppAccountNoLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scFirstNameContainer']//input[@id='scFirstName']")
    private WebElement suppFName;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scLastNameContainer']//input[@id='scLastName']")
    private WebElement suppLName;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scDateOfBirthContainer']//input[@id='scDateOfBirth']")
    private WebElement suppDOB;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scRelationshipContainer']//select[@id='scRelationship']")
    private WebElement relationStatus;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scPhoneNumContainer']//input[@id='scPhoneNum']")
    private WebElement phoneNumber;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'contactInfo')]//input[@id='scSameAddress']")
    private WebElement sameAddress;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'contactInfo')]//input[@id='scNewAddress']")
    private WebElement diffAddress;
	
	@FindBy(how = How.XPATH, using = "//label[@for='scAddressLookup']/../input[@id='scAddressLookup']")
    private WebElement addressLookUp;
	
	@FindBy(how = How.XPATH, using = "//div[@class='pcaautocomplete pcatext' and not(contains(@style,'none'))]//div[@id='address_list']//div[@role='option']")
    private WebElement lookUpAddress;
	
	@FindBy(how = How.XPATH, using = "(//*[@id='address_list_item0'])[1]")
    private WebElement addressList;
	
	@FindBy(how = How.XPATH, using = "//input[@id='scCheckbox']")
    private WebElement suppTnCCheckBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ciBacktoReviewBtn']")
    private WebElement backToReview;
	
	@FindBy(how = How.XPATH, using = "//button[@id='cp-change-understood']")
    private WebElement gotItPopup;
	
	@FindBy(how = How.XPATH, using = "//h1[@id='ngdialog3-aria-labelledby']")
    private WebElement suppImpInfoPopupHeader;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciSelecteEstatementValidations']//small")
    private WebElement stmtModeErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciSelectTriangleValidations']//small")
    private WebElement traingleMemshipErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='lvLoyaltyNumValidations']//small")
    private WebElement loyaltyNumberErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciSelectSuppValidations']//small")
    private WebElement suppAccountErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ciEstatementCheckboxValidations']//small")
    private WebElement estmtTandCErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='lvLoyaltyNumValidations' and contains(@class,'error-messages')]//small")
    private WebElement traingleCardNoErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scFirstNameValidations']//small")
    private WebElement supFfirstNameError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scLastNameValidations']//small")
    private WebElement supLastNameError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scDateOfBirthValidations']//div[contains(@class,'error-messages')]/small")
    private WebElement supDobErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scRelationshipValidations']//small")
    private WebElement supRelationshipErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scPhoneNumValidations' and contains(@class,'error-messages')]//small")
    private WebElement supPhoneNumberErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scCheckboxValidations']//small")
    private WebElement suppTandCErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scSameaddressValidations']//small")
    private WebElement suppAddressErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scAddressLookupValidations']//small")
    private WebElement suppAddressLookUpError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scAddressLine1Validations']//small")
    private WebElement suppAddressLine1Error;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scCityValidations']//small")
    private WebElement suppCityError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scProvinceValidations']//small")
    private WebElement suppProvinceError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scPostalValidations']//small")
    private WebElement suppPostCodeError;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'contactLegal')]//div[@id='sect1']/div")
	private WebElement legalFooternotes;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'contactLegal')]//button[@id='legalFooter']")
	private WebElement legalFootNotesExpand;
	
	
	
	public void triangleRewards(String statements, String cardNumber, String cardType) throws InterruptedException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);
		if(statements.equalsIgnoreCase("Estatements"))
		{
			clickElement(eStatements);
			clickElement(eStatementCheckBox);
		}else {
			clickElement(mailedStmnt);
		}
		if(cardNumber.equalsIgnoreCase("no")) {
			clickElement(triangleCardNumberNo);
		}
		else
		{
			clickElement(triangleCardNumberYes);
			inputText(loyaltyNumber, cardNumber);
		}
		if(cardType.equalsIgnoreCase("NoSupCard"))
		{
			clickElement(noSupCard);
		}
		else {
			clickElement(yesSupCard);;
		}
		clickElement(cNextBtn);
	}

	public void triangleRewards(DSA_DM dsa, String statements, String cardNumber, String cardType, String addressType) {
	try{
		try {
	
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(statements.equalsIgnoreCase("Estatements"))
		{
			clickElement(eStatements);
			clickElement(eStatementCheckBox);
			dsa.setStmtMode("Y");
		}else {
			clickElement(mailedStmnt);
			dsa.setStmtMode("N");
		}
		if(dsa.getCardType().equalsIgnoreCase("OMX")||dsa.getCardType().equalsIgnoreCase("OMZ")) {
			if(cardNumber.equalsIgnoreCase("no")) {
				clickElement(triangleCardNumberNo);
				dsa.setLoyaltyNumber("");
			}
			else
			{
				clickElement(triangleCardNumberYes);
				inputText(loyaltyNumber, dsa.getLoyaltyNumber());
				dsa.setLoyaltyNumber(dsa.getLoyaltyNumber());
			}
		}
		
		if(cardType.equalsIgnoreCase("No"))
		{
			clickElement(noSupCard);
			dsa.setSupplAccount("No");
		}
		else {
			try {
			clickElement(yesSupCard);
			dsa.setSupplAccount("Yes");
			inputText(suppFName, dsa.getSuppFirstName());
			inputText(suppLName, dsa.getSuppLastName());
			inputText(suppDOB,dsa.getSuppDob());
			inputText(phoneNumber,dsa.getSuppPhoneNumberString());
			selectFromDropdownByText(relationStatus, dsa.getSuppRelationship());
			
			if(addressType.equalsIgnoreCase("Different")) {
				clickElement(diffAddress);
				
				
					 inputText(addressLookUp, dsa.getSuppStreetNumber() + " " + dsa.getSuppStreetName() +", "+dsa.getSuppAddress2()+", "+ dsa.getSuppCity() +", "+ dsa.getSuppProvince().substring(5, dsa.getSuppProvince().length())+", "+ dsa.getSuppPostCode());
//					   WebElement ele = getElementWhenVisible(addressList);
					   Actions action = new Actions(driverManager.getDriver());
					   action.doubleClick(addressList).build().perform();
					   if(isElementVisible(addressList))
					   {
						   action.doubleClick(addressList).build().perform();
					   }
					
			}	
			
			else {
				clickElement(sameAddress);
			}
			clickElement(suppTnCCheckBox);
			} catch (Exception e) {
				e.printStackTrace();		
			}	//catch
		}
		clickElement(cNextBtn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeLockforLoyalty(String loyaltyNumber) throws SQLException {
		Connection conn = null;
		Statement stat = null;
			try {
				System.out.println("Fetched Loyalty Number:"+loyaltyNumber);
				conn.setAutoCommit(false); 
				stat = conn.createStatement();
				System.out.println("Executing select query....");
				String selectSql = "SELECT WELCOME_KIT, PROCESSED FROM LOYALTYCUSTOMERMAINT WHERE MEMBERNUM = '"+loyaltyNumber+"'";
				ResultSet rs = stat.executeQuery(selectSql);
				if(rs.next()==false)
					System.out.println("No records found for given loyalty number. Update not required");
				else
					{
					System.out.println("Executing Update query...");
					String sql = "UPDATE LOYALTYCUSTOMERMAINT SET PROCESSED = 'N' WHERE MEMBERNUM = " + loyaltyNumber;
				log.info("removeLocks with sql=" + sql);
				stat.execute(sql);
				conn.commit();
					}
				
				
			} catch (Throwable t) {
				t.printStackTrace();
				throw new RuntimeException(t);
			} finally {
				stat.close();
				conn.close();
	
			}
	}
	
	protected long randomNumber(long min, long max) {
		 Random rand = new Random();
		return rand.nextLong() + min;
	}
	

//	@Override
	public void validate() throws ValidationException, InterruptedException {
//		validateText(By.xpath(prefHeader), getInputText("dd:DSA-IBM-CONTACT-INFO-0001"));
//		validateText(By.xpath(instructionMsg), getInputText("dd:DSA-IBM-PERSONAL-INFO-0046"));
		waitForVisible(eStatements);
//		waitForVisible(yesSupCard);
//		waitForVisible(By.xpath(cNextBtn));
		
	}
	

}
