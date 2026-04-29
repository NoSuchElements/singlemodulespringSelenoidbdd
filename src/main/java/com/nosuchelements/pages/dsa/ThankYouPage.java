package com.nosuchelements.pages.dsa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;

import lombok.Data;

@PageObject
@Data
public class ThankYouPage extends BasePage {
	

//	@FindBy(how = How.ID, using = "pendingTitle")
//    private WebElement pageTitle;
	
	@FindBy(how = How.XPATH, using = "//h2[@id='pendingTitle']")
    private WebElement pageTitle;
	
//	@FindBy(how = How.ID, using = "pendImgWrapper")
//    private WebElement pendingImg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='pendImgWrapper']")
    private WebElement pendingImg;
	
//	@FindBy(how = How.XPATH, using = "//a[@id='skStartNoBtn']")
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'review') and @aria-hidden='false']//a[@id='skStartNoBtn']")
    private WebElement verifyLaterBtn;
	
//	@FindBy(how = How.LINK_TEXT, using = "Verify Later")
//    private WebElement verifyLaterBtn;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'review') and @aria-hidden='false']//button[@id='skStartYesBtn']")
//	@FindBy(how = How.XPATH, using = "//button[@id='skStartYesBtn']")
    private WebElement verifyNowBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@id='endSessionModalYesBtn']")
    private WebElement endSessionBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@id='endSessionModalNoBtn']")
    private WebElement verifyNowPopupBtn;
	
	@FindBy(how = How.XPATH, using = "//p[@id='skOptInSubtitle2']")
    private WebElement SKContent2;
	
	@FindBy(how = How.XPATH, using = "//div[@id='skOptInContentContainer']")
    private WebElement SKContent;
	
	@FindBy(how = How.XPATH, using = "//*[@id='btnEnroll']/button")
    private WebElement continueBtn;
	
	@FindBy(how = How.XPATH, using = "//p[@class='nosuchelements-footer__legalText ng-binding']")
    private WebElement legalFooter;
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='card-img']")
    private WebElement traingleCardImg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='nextstopBox']")
    private WebElement nextSubtitle;
	
	@FindBy(how = How.XPATH, using = "//div[@id='nextstopBox']/h5[contains(text(),'resubmit')]")
    private WebElement resubmitSubTitle;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'pendingCtrl') and @aria-hidden='false']")
    private WebElement nextStepText;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@compile,'approvedCtrl')]")
	private WebElement nextStepText_approved;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ecommPending']//div[@id='nextstopBox']")
	private WebElement nextStepTextEcommPending;
	
	public WebElement getNextStopTitleText() {
		String nextStopTitle = searchDataDictionary("dd:DSA-IBM-FINAL-DII-APPROVED-PAGE-07");
		return driverManager.getDriver().findElement(By.xpath("//div[@id='nextstopBox']/h5[contains(text(),'"+nextStopTitle+"')]"));
	}
	
	@FindBy(how = How.XPATH, using = "//main[@id='main-container']")
    private WebElement thankYouPage;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'animateLoaderOverlay')]/div[@class='spinner'])[1]")
    private WebElement progressBar;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ngdialog2']//div[@class='spinner']")
    private WebElement progressBar_OMP;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ngdialog3']//div[@class='spinner']")
    private WebElement progressBar_OMX;
	
	
//	public static String thankyouTitle = "";

	@FindBy(how = How.XPATH, using = "//div[@class='card-img marTop20']/img")
    private WebElement triangleLogo;
	
	@FindBy(how = How.XPATH, using = "//section[@id='pending-section']//div[@id='pendImgWrapper']//img")
    private WebElement pendingIcon;
	
	@FindBy(how = How.XPATH, using = "//section[@id='pending-section']//h2")
    private WebElement pendingTitle;
	
	@FindBy(how = How.XPATH, using = "//section[@id='pending-section']//div[@id='card-img']//img")
    private WebElement pendingCardImg;
	
	@FindBy(how = How.XPATH, using = "//section[@id='pending-section']//div[@id='nextstopBox']//h5")
    private WebElement pendingNextTitle;
	
	@FindBy(how = How.XPATH, using = "(//section[@id='pending-section']//div[@id='nextstopBox']//center/strong)[1]")
    private WebElement pendingResubmitTitle;
	
			//img[contains(@class,'navLogo') and @aria-hidden='false']";
	

	@FindBy(how = How.XPATH, using = "//section[@id='approved-section']//h1")
    private WebElement approvedTitle;
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-section']//div[@id='titleContainer']//img")
    private WebElement approvedIcon;
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-section']//img[@id='imgCard']")
    private WebElement approvedCardImg;
	
//	@FindBy(how = How.XPATH, using = "//section[@id='approved-section']//div[@id='cardContainer']//div[2]/h4[1]")
//    private WebElement approvedCreditLimit;
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-section']//div[@id='cardContainer']//div[2]/h4[2]")
    private WebElement approvedAnnualInterestRate;
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-section']//div[@id='msgContainer']//h4")
    private WebElement approvedNextSubtitle;
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-dii-section']//h1[@aria-hidden='false']")
    private WebElement approvedDIITitle;
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-dii-section']//div[@id='card-img']/img[@aria-hidden='false']")
    private WebElement approvedDIICardImg;
	
	@FindBy(how = How.XPATH, using = "(//section[@id='approved-dii-section']//div[@id='cardContainer']//div[contains(@class,'right')]/h4)[1]")
    private WebElement approvedDIICreditLimit;
	
	@FindBy(how = How.XPATH, using = "(//section[@id='approved-dii-section']//div[@id='cardContainer']//div[contains(@class,'right')]/h4)[2]")
    private WebElement approvedDIIAnnualInterestRate;
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-dii-section']//div[@class='boxContent']/h3")
    private WebElement approvedDIISubTitle;
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-dii-section']//div[@class='container adii-icon-container']")
    private WebElement approvedDIIPaymentOptions;
	
	
	@FindBy(how = How.XPATH, using = "//section[@id='approved-dii-section']//div[@id='adiiNoThanksBtnWrapper']")
    private WebElement approvedDIIFooter;
	
	// Credit Limit
	@FindBy(how = How.XPATH, using = "//div[@id='cardContainer3']/div[2]/p[1]/strong")
    private WebElement reqCreditLimitLabel;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cardContainer3']/div[2]/p[2]")
    private WebElement reqCreditAmount;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cardContainer3']/div[2]/p[4]")
    private WebElement approvedCreditLimit;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cardContainer3']/div[2]/p[3]/strong")
    private WebElement apprCreditLabel;
	
/*	public void validate(String cardType) throws InterruptedException 
	{
		waitForVisible(progressBar);
		waitForVisible(triangleLogo);
		waitForSeconds(5);
		waitForSeconds(5);
		waitForSeconds(5);
	} */

	
	

}
