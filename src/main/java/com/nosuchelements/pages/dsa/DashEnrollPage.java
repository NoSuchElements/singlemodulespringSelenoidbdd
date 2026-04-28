package com.nosuchelements.pages.dsa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.pages.BasePage;

import lombok.Data;

@PageObject
@Data
public class DashEnrollPage extends BasePage {
	

	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'dashEnrollCtrl') and @aria-hidden='false']//div[@id='pageHeading']//h2")
    private WebElement pageHeader;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'dashEnrollCtrl') and @aria-hidden='false']//div[@id='pageHeading']//h3")
    private WebElement pageSubTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@id='lpBtnsWrappers']//div[@class='landing-msg-3']")
    private WebElement paragraph;
	
	@FindBy(how = How.ID, using = "enrollSetUpNowBtn")
    private WebElement setupNowBtn;
	
	@FindBy(how = How.ID, using = "enrollSetUpLaterBtn")
    private WebElement setupLaterBtn;
	
	/**************************** Login Page   ****************************/
	
	@FindBy(how = How.XPATH, using = "//div[@id='loginHead']/h1")
    private WebElement loginPage_Title;
	
	@FindBy(how = How.ID, using = "username")
    private WebElement userNameTxt;
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']//following-sibling::div/small")
    private WebElement userNameInfo;
	
	@FindBy(how = How.XPATH, using = "//div[@id='usernameValidations']/small")
    private WebElement userNameErrorMsg;
	
	@FindBy(how = How.ID, using = "password")
    private WebElement passwordTxt;
	
	@FindBy(how = How.XPATH, using = "//input[@id='password']//following-sibling::div/small")
    private WebElement passwordInfo;
	
	@FindBy(how = How.XPATH, using = "//div[@id='passwordStrength']/div[@aria-hidden='false']")
    private WebElement passwordCriteria;
	
	@FindBy(how = How.XPATH, using = "//button[@id='dsaEnrolPassword-eyeIcon']")
    private WebElement passwordEyeIcon;
	
	@FindBy(how = How.XPATH, using = "//div[@id='passwordValidations']/small")
    private WebElement passwordErrorMsg;
	
	@FindBy(how = How.ID, using = "passwordRepeat")
    private WebElement reenterPasswordTxt;
	
	@FindBy(how = How.XPATH, using = "//div[@id='passwordRepeatValidations']/small")
    private WebElement reenterPasswordErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//button[@id='dsaEnrolPasswordRepeat-eyeIcon']")
    private WebElement reenterPasswordEyeIcon;
	
	@FindBy(how = How.ID, using = "termsConditions")
    private WebElement TnCCheckbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='termsConditions']//following-sibling::label")
    private WebElement TnCText;
	
	@FindBy(how = How.XPATH, using = "//label[@for='termsConditions']/p[1]")
    private WebElement TnCTextPara1;
	
	@FindBy(how = How.XPATH, using = "//label[@for='termsConditions']/p[2]")
    private WebElement TnCTextPara2;
	
	@FindBy(how = How.XPATH, using = "//label[@for='termsConditions']//following-sibling::div/small")
    private WebElement TnCCheckboxErrorMsg;
	
	@FindBy(how = How.XPATH, using = "//label[@for='termsConditions']//a[@id='dashEnrolmentModal']")
    private WebElement TnCLink;
	
	@FindBy(how = How.ID, using = "privacyCharter")
    private WebElement privacyCharterCheckbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='privacyCharter']//following-sibling::label")
    private WebElement privacyCharterText;
	
	@FindBy(how = How.XPATH, using = "//input[@id='termsConditions']//following-sibling::label/a[contains(@href,'privacy')]")
    private WebElement privacyPolicyLink;
	
	@FindBy(how = How.XPATH, using = "//label[@for='privacyCharter']//a")
    private WebElement privacyCharterLink;
	
	@FindBy(how = How.XPATH, using = "//h2[@id='ngdialog1-aria-labelledby']")
    private WebElement privacyCharterHeader;
	
	@FindBy(how = How.XPATH, using = "//input[@id='language-toggle']")
    private WebElement privacyCharterToggle;
	
	@FindBy(how = How.XPATH, using = "//p[@id='ngdialog1-aria-describedby']//following-sibling::div/p[1]")
    private WebElement privacyCharterContent;
	
	@FindBy(how = How.XPATH, using = "//button[@id='cocAgreeBtn']")
    private WebElement gotIt;
	
	@FindBy(how = How.XPATH, using = "//label[@for='privacyCharter']//following-sibling::div/small")
    private WebElement privacyCharterCheckboxErrorMsg;
	
	@FindBy(how = How.ID, using = "enrollSubmitBtn")
    private WebElement doneBtn;
	
	@FindBy(how = How.XPATH, using = "")
    private WebElement progressBar_OMX;
	
	
	/**************************** Confirm Page   ****************************/

	@FindBy(how = How.XPATH, using = "//div[@id='pageHeading']/h4")
    private WebElement pageHeader_ConfirmPage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='pageHeading']/h5")
    private WebElement subTitle_ConfirmPage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accountScreenBtnWrapper']/button[contains(@class,'lpNextBtn')]")
    private WebElement doneBtn_ConfirmPage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='accountScreenBtnWrapper']/button[@id='DeBacktoReviewBtn']")
    private WebElement myOnlineAcct_ConfirmPage;
	
	@FindBy(how = How.XPATH, using = "//a[@class='apple-img']")
    private WebElement appleImg_ConfirmPage;
	
	@FindBy(how = How.XPATH, using = "//a[@class='google-img']")
    private WebElement googleImg_ConfirmPage;
	
	/**************************** DASH Login Page   ****************************/
	
	@FindBy(how = How.XPATH, using = "//div[@id='log-in']/h3")
    private WebElement pageHeader_dash;
	
	@FindBy(how = How.XPATH, using = "//div[@id='log-in']/h3")
    private WebElement loginHeader_dash;
	
	public void validate() throws InterruptedException {
		waitForVisible(pageHeader_dash);
		waitForVisible(loginHeader_dash);
		
	}
	
	public void validatePCModal() throws InterruptedException {
		waitForVisible(privacyCharterHeader);
		waitForVisible(privacyCharterToggle);
		waitForVisible(privacyCharterContent);
	}
	

}
