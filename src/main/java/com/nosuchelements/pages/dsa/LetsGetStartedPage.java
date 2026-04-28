package com.nosuchelements.pages.dsa;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.config.PropertyConfig;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;
import com.nosuchelements.utils.dsa.CommonUtils;
import com.nosuchelements.utils.dsa.pdfUtil;

import lombok.Data;

@PageObject
@Data
public class LetsGetStartedPage extends BasePage {

	
	@Autowired
	private pdfUtil PU;
	
	@Autowired
	private CommonUtils commutil;
	
	@Autowired
    private PropertyConfig applicationProperties;
	
//	ArrayList<String> tabs = new ArrayList<String>();
	ArrayList<String> tabs;
	private String expectedTitle;
	
	@FindBy(how = How.XPATH, using = "//*[@id='landing-page-section']//h1[1]")
    private WebElement letsGetStartedHeader1;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "//*[@id='landing-page-section']//div[@class='landing-msg-2']")
	//DSA3
//	@FindBy(how = How.XPATH, using = "//*[@id='landing-page-section']//h1[2]")
    private WebElement letsGetStartedHeader2;
	
	@FindBy(how = How.XPATH, using = "//h2[@class='nosuchelements-footer__legalTitle']")
	private WebElement legalFooter;
	
	@FindBy(how = How.XPATH, using = "//div[@class='container nosuchelements-footerlegal__container footerWrapper']/p")
    private WebElement legalPara;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "//*[@id='landing-page-section']//h2")
	//DSA3
//	@FindBy(how = How.XPATH, using = "//div[@id='lpBtnsWrapper']/p")
    private WebElement subHeading;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "(//*[@id='lpBtnsWrapper']//p)[1]")
	//DSA3
//	@FindBy(how = How.XPATH, using = "(//*[@id='lpBtnsWrapper']//div//div)[1]")
    private WebElement descPara1;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "(//*[@id='lpBtnsWrapper']//p)[2]")
	//DSA3
//	@FindBy(how = How.XPATH, using = "(//*[@id='lpBtnsWrapper']//div//div)[4]")
    private WebElement descPara2;
	
//	@FindBy(how = How.XPATH, using = "//div[@id='landing-page-section']//div[@class='item-icon-wrapper'][2]/p/a")
	@FindBy(how = How.XPATH, using = "//div[@id='lpBtnsWrapper']//p/a")
    private WebElement privacyLink;
	
	//DSA2
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'lpNextBtn') and contains(@class,'ng-scope')]")
	//DSA3
//	@FindBy(how = How.XPATH, using = "//div[@id='lpBtnsWrapper']//following-sibling::button")
	private WebElement nextBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@role='alertdialog']//h1")
    private WebElement popUpHeader;
	
	@FindBy(how = How.XPATH, using = "//div[@role='alertdialog']//p[1]")
    private WebElement popUpPara;
	
	@FindBy(how = How.XPATH, using = "//button[@id='coc-agree-terms']")
    private WebElement agreeBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@role='alertdialog']//p[3]")
    private WebElement effDatePara;
	
	@FindBy(how = How.XPATH, using = "//input[@id='skRequestMockCheckbox']")
    private WebElement mockCheckbox;
	
	@FindBy(how = How.XPATH, using = "//div[@class='glb-legal section']//a[2]")
    private WebElement footerSecurityLink;
	
	@FindBy(how = How.XPATH, using = "//div[@class='glb-legal section']//a[contains(@href,'legal')]")
    private WebElement footerLegalPrivacyLink;
	
	
	//COST OF CREDIT DISCLOSURE
	
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/p[2]/span[@class='pdf-img']/a")
    private WebElement savepdfCOCD;
	
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/p[8]/span[@class='pdf-img']/a")
    private WebElement savepdfBottomCOCD;
	
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/div//tr[2]/td/span")
    private WebElement annualRateCOCD;// right side content
	
	@FindBy(how = How.XPATH, using = "//div[@class='glb-legal-table ng-scope']/center/div/table/tbody/tr[3]/td")
    private WebElement intGraceCOCD;// right side content
	
	@FindBy(how = How.XPATH, using = "//div[@class='glb-legal-table ng-scope']/center/div/table/tbody/tr[4]/td")
    private WebElement minPaymentCOCD;// right side content

	@FindBy(how = How.XPATH, using = "//div[@class='glb-legal-table ng-scope']/center/div/table/tbody/tr[5]/td")
    private WebElement foreignCcy;// right side content
		
	@FindBy(how = How.XPATH, using = "//div[@class='glb-legal-table ng-scope']/center/div/table/tbody/tr[6]/td")
    private WebElement annualFees;// right side content
	
	@FindBy(how = How.XPATH, using = "//div[@class='glb-legal-table ng-scope']/center/div/table/tbody/tr[7]/td")
    private WebElement otherFees;// right side content
	
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/p[3]")
    private WebElement accrualPara;

//	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/p[5]")
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/h3[2]")
    private WebElement resiQCTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/p[4]")
    private WebElement resiQC;// until outside Canada phone number
	
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/p[6]")
    private WebElement elecDisclosurePara;
	
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/p[7]")
    private WebElement addressCTBPara;
	
	@FindBy(how = How.XPATH, using = "//div[@id='consent-modal']/p[5]")
    private WebElement triangleMasterPara;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-show,'updownsellDialog') and @aria-hidden = 'false']//p[9]")
    private WebElement bottomLineOMZ;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-if,'landingPage')]//div[@id='sect1']/div")
    private WebElement legalFootnotes;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@data-ng-if,'landingPage')]//button[@id='legalFooter']")
    private WebElement legalFootnotesExpand;
	
	@FindBy(how = How.XPATH, using = "(//h1[@id='landingHeader']//span)[1]")
    private WebElement regTrademark1;
	
	
	public String pageTitle() {
		String actualTitle = driverManager.getDriver().getTitle();
		System.out.println("Actual Title: "+actualTitle);
		driverWait.getDriverWait().until(ExpectedConditions.titleIs(actualTitle));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("\n" + actualTitle + "\n" + expectedTitle + "\n");
		return actualTitle;
	}
	
	public void letsGetStarted(DSA_DM dsa, String cardType) throws Exception { 
		 
		try {
			log.info("Attempting to start online application");
			try {
				log.info("Attempting to validate page");
//				if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
//					expectedTitle = "C’est parti!";
//					driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
//					pageTitle();
//				} else {
//					expectedTitle = getInputText("dd:DSA-PAGE-TITLE-03");
//					driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
//					pageTitle();
//				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Page validation failed.");
				
			}
			// DSA-IBM-LANDING-PAGE-09 which is Data Dictionary reference Label instead of String
			if(cardType.equalsIgnoreCase("OMX"))
			{
				validateText(letsGetStartedHeader1, getInputText("dd:normalized:DSA-IBM-LANDING-PAGE-01"));
			}
			else if(cardType.equalsIgnoreCase("OMZ")) {
				validateText(letsGetStartedHeader1, getInputText("dd:normalized:DSA-IBM-LANDING-PAGE-OMZ-01"));
			}
			System.out.println("HeaderText:"+getText(letsGetStartedHeader1));
			validateText(letsGetStartedHeader2, getInputText("dd:DSA-IBM-LANDING-PAGE-02"));
			validateText(subHeading,getInputText("dd:DSA-IBM-PAGE-TITLE-1"));
			validateText(descPara1, getInputText("dd:DSA-IBM-LANDING-PAGE-05"));
			validateText(descPara2, getInputText("dd:normalized:DSA-IBM-LANDING-PAGE-06")); 
			if (!isElementVisible(privacyLink)) {
				Assert.fail("Failed to Validate visibility of " + privacyLink +" on Landing Page \n");
			}
//			try {
//				 if (isElementVisible(descPara2)) {
//	    				Assert.fail("Failed : Privacy Charter line displayed \n" );
//					}
//			}catch(Exception e) {
//				log.info( "\n FAILED : : LetsGetStartedPage ECOMM \n");
//				throw e;
//			}
			clickElement(nextBtn);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(nextBtn)));
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Caught error attempting to start application process");
			throw e;
		}
	}

	public void letsGetStartedforNonEcom(String cardType) throws Exception { 
		try {
			log.info("Attempting to start online application");
			try {
				log.info("Attempting to validate page");
			/*	if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
					expectedTitle = "C’est parti!";
					wait.until(ExpectedConditions.titleContains(expectedTitle));
					pageTitle();
				} else {*/
//					expectedTitle = getInputText("dd:DSA-PAGE-TITLE-03");
//					wait.until(ExpectedConditions.titleContains(expectedTitle));
					pageTitle();
				//}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("Page validation failed.");
				
			}
			// DSA-IBM-LANDING-PAGE-09 which is Data Dictionary reference Label instead of String
			if(cardType.equalsIgnoreCase("OMX"))
			{
				validateText(letsGetStartedHeader1, getInputText("dd:normalized:DSA-IBM-LANDING-PAGE-01"));
			}
			else if(cardType.equalsIgnoreCase("OMZ")) {
				validateText(letsGetStartedHeader1, getInputText("dd:normalized:DSA-IBM-LANDING-PAGE-OMZ-01"));
			}
			validateText(letsGetStartedHeader2, getInputText("dd:DSA-IBM-LANDING-PAGE-02"));
			validateText(subHeading,getInputText("dd:DSA-IBM-PAGE-TITLE-1"));
			validateText(descPara1, getInputText("dd:DSA-IBM-LANDING-PAGE-05"));
			validateText(descPara2, getInputText("dd:normalized:DSA-IBM-LANDING-PAGE-06"));  
			if (!isElementVisible(privacyLink)) {
				Assert.fail("Failed to Validate visibility of " + privacyLink +" on Landing Page \n");
			}
			clickElement(nextBtn);
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(nextBtn)));
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Caught error attempting to start application process");
			
			throw e;
		}
	}
	
	public void mockVerification() throws Exception {
		try {
			if (!isElementVisible(mockCheckbox)) {
				Assert.fail("\n Failed to validate : Mock ID Checkbox \n" );
			}
			else {
				clickElement(mockCheckbox);
			}
			
		}catch(Exception e) {
			System.out.println("\n Failed to check Mock Id Services \n");
			throw e;
		}
	}
	public void validateCOCD(String cardType) {
		try {
			WebElement element = driverManager.getDriver().findElement(By.xpath("//div[@id='consent-modal']/div//tr[2]/td/span"));
			String annualInterestRateText = getText(element);
			String COCDText = getText(driverManager.getDriver().findElement(By.xpath("//div[@id='consent-modal']//p[4]")));
			switch(cardType) {
			case "OMX":
				annualInterestRateText.contains("Triangle® Mastercard®");
				COCDText.contains("Triangle® Mastercard®");
				break;
			case "OMZ":
				COCDText.contains("Triangle® World Elite® Mastercard®");
				getText(driverManager.getDriver().findElement(By.xpath("//div[@id='consent-modal']//p[8]"))).contains("Triangle® World Elite® Mastercard®");
				break;
			case "OMP":
				COCDText.contains("Gas Advantage® Mastercard®");
				break;
			case "OMR":
				COCDText.contains("Cash Advantage® Mastercard®");
				break;
			}
			
		} catch (Exception e) {
			log.info("COCD validation failed.");
			e.printStackTrace();
		}
	}
	
	public void validateCOCDContent(String cardType) {
		try {
			WebElement element = driverManager.getDriver().findElement(By.xpath("//div[@id='consent-modal']/div//tr[2]/td/span"));
			String annualInterestRateText = getText(element);
			String COCDText = getText(driverManager.getDriver().findElement(By.xpath("//div[@id='consent-modal']//p[4]")));
			switch(cardType) {
				case "OMX":
					annualInterestRateText.contains("Triangle® Mastercard®");
					COCDText.contains("Triangle® Mastercard®");
					if(!isElementVisible(annualRateCOCD)){
						Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
					}
					else {
						System.out.println("\n ^ Verifying COCD AnnualRate text ^\n");
						validateText(annualRateCOCD.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-INT-RATE-OMX"),true);
					}
					
					if(!isElementVisible(triangleMasterPara)){
						Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
					}
					else {
						System.out.println("\n ^ Verifying COCD Triangle mastercard text ^\n");
						validateText(triangleMasterPara.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0037"),true);
					}
					
					break;
				case "OMZ":
					COCDText.contains("Triangle® World Elite® Mastercard®");
					getText(driverManager.getDriver().findElement(By.xpath("//div[@id='consent-modal']//p[8]"))).contains("Triangle® World Elite® Mastercard®");
					if(!isElementVisible(annualRateCOCD)){
						Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
					}
					else {
						System.out.println("\n ^ Verifying COCD AnnualRate text ^\n");
						validateText(annualRateCOCD.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-INT-RATE-OMZ"),true);
					}
					
					if(!isElementVisible(triangleMasterPara)){
						Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
					}
					else {
						System.out.println("\n ^ Verifying COCD Triangle mastercard text ^\n");
						validateText(triangleMasterPara.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0040"),true);
					}
					break;
			/*	case "OMP":
					COCDText.contains("Gas Advantage® Mastercard®");
					if(!isElementVisible(annualRateCOCD)){
						Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
					}
					else {
						System.out.println("\n ^ Verifying COCD AnnualRate text ^\n");
						validateText(annualRateCOCD.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-INT-RATE-OMP"),true);
					}
					
					if(!isElementVisible(triangleMasterPara)){
						Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
					}
					else {
						System.out.println("\n ^ Verifying COCD Triangle mastercard text ^\n");
						validateText(triangleMasterPara.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0041"),true);
					}
					break;  */
				case "OMR":
					COCDText.contains("Cash Advantage® Mastercard®");
					if(!isElementVisible(annualRateCOCD)){
						Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
					}
					else {
						System.out.println("\n ^ Verifying COCD AnnualRate text ^\n");
						validateText(annualRateCOCD.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-INT-RATE-OMR"),true);
					}
					
					if(!isElementVisible(triangleMasterPara)){
						Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
					}
					else {
						System.out.println("\n ^ Verifying COCD Triangle mastercard text ^\n");
						validateText(triangleMasterPara.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0042"),true);
					}
					break;
			}// switch
			if(!isElementVisible(intGraceCOCD)){
				Assert.fail("Failed to validate :COCD POPUP Interest Grace TEXT \n" );
			}
			else {
				System.out.println("\n ^ Verifying COCD Interest Grace text ^\n");
				if(context.getDsaDmData().getLanguage().contains("E"))
					validateText(intGraceCOCD.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0010")+"21"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0011")+"26"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0012")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0013")+"21"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0014")+"26"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0015")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0016"),true);
				else
					validateText(intGraceCOCD.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0010")+"26"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0011")+"21"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0012")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0013")+"26"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0014")+"21"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0015")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0016"),true);
			}
			
			if(!isElementVisible(minPaymentCOCD)){
				Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
			}
			else {
				System.out.println("\n ^ Verifying COCD Min Payment text ^\n");
				validateText(minPaymentCOCD.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0018")+"1000"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0019")+"1000"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0020")+"1000"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0044")+"5"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0045")+"1000"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0046"),true);
			}
			
			if(!isElementVisible(foreignCcy)){
				Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
			}
			else {
				System.out.println("\n ^ Verifying COCD Foreign Currency text ^\n");
				validateText(foreignCcy.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0022")+"25"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0023")+"25"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0024"),true);
			}
			
			if(!isElementVisible(annualFees)){
				Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
			}
			else {
				System.out.println("\n ^ Verifying COCD AnnualFees text ^\n");
				validateText(annualFees.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0026"),true);
			}

			if(!isElementVisible(resiQC)){
				Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
			}
			else {
				System.out.println("\n ^ Verifying COCD ResiQuebec text ^\n");
				validateText(resiQCTitle.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0074"),true);
//				validateText(resiQC.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0075"),true);
			}  
			
			if(!isElementVisible(otherFees)){
				Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
			}
			else {
					System.out.println("\n ^ Verifying COCD Other fees text ^\n");
					validateText(otherFees.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0028")+"3"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0029")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0030")+"200"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0031")+"200"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0032")+"2"+
								getInputText("dd:normalized:DSA-COST-OF-CREDIT-0033"),true);
			}
			
			//*YY
			if(!isElementVisible(accrualPara)){
				Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
			}
			else {
				System.out.println("\n ^ Verifying COCD accrual Int text ^\n");
				validateText(accrualPara.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0073"),true);
			}  
			
			if(!isElementVisible(elecDisclosurePara)){
				Assert.fail("\n Failed to validate :COCD POPUP Electronic Disc TEXT \n" );
			}
			else {
				System.out.println("\n ^ Verifying COCD elecDisclosure text ^\n");
				validateText(elecDisclosurePara.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0077"),true);
			}
			
			if(!isElementVisible(addressCTBPara)){
				Assert.fail("\n Failed to validate :COCD POPUP TEXT \n" );
			}
			else {
				System.out.println("\n ^ Verifying COCD Address paragraph text ^\n");
				validateText(addressCTBPara.getText(),getInputText("dd:normalized:DSA-COST-OF-CREDIT-0079"),true);
			}
			
		} catch (Exception e) {
			log.info("COCD validation failed \n");
			e.printStackTrace();
			Assert.fail("Failed to validate COCD Modal");
		}
	}
	
	public void validateCOCDPdfContent(String cardType, String pdfText) {
		try {
			String modelText = "";
			String modelText2="";
			String modelText3="";
			System.out.println("\n Validating PDF content for Cardtype :"+context.getDsaDmData().getCardType()+"\n");
			pdfText = commutil.trimText(pdfText, true);
			switch(cardType) {
			
						case "OMX":
							System.out.println("\n Validating OMX pdf \n");
//							modelText = MS.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0037")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0076")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0077")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0078")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0079"),true);
							modelText = commutil.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0037"),true);
							modelText2= commutil.trimText("3"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0029"), true);
							if(context.getLanguage().contains("E"))
								modelText3=commutil.trimText("Information effective as of December 10, 2025.", true);
							else
								modelText3=commutil.trimText("Les renseignements sont en vigueur à compter du 10 Décembre 2025.", true);
//							System.out.println("Text from pdf: "+pdfText);
							System.out.println("Text 1: "+modelText);
							System.out.println("Text 2: "+modelText2);
							System.out.println("Text 3: "+modelText3);
									Assert.assertTrue(pdfText.contains(modelText));
									Assert.assertTrue(pdfText.contains(modelText2));
									Assert.assertTrue(pdfText.contains(modelText3));
							System.out.println("Validated changes on COCD modal successfully");
							break;
						case "OMZ":
//							modelText = MS.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0037")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0076")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0077")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0078")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0079"),true);
							modelText = commutil.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0040"),true);
							modelText2= commutil.trimText("3%"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0029"), true);
							if(context.getLanguage().contains("E"))
								modelText3=commutil.trimText("Information effective as of December 10, 2025.", true);
							else
								modelText3=commutil.trimText("Les renseignements sont en vigueur à compter du 10 Décembre 2025.", true);
							String bottomText = commutil.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0039"),true);
							System.out.println("Text from DD: "+modelText);
							try {
										Assert.assertTrue(pdfText.contains(modelText),"Failed to validate modelText");
										Assert.assertTrue(pdfText.contains(modelText2),"Failed to validate modelText2");
										Assert.assertTrue(pdfText.contains(modelText3),"Failed to validate modelText3");
										Assert.assertTrue(pdfText.contains(bottomText),"Failed to validate bottomText");
							}catch(Exception e) {
								throw e;
							}
							System.out.println("OMZ COCD Validated changes successfully \n");
							break;
						case "OMR":
//							modelText = MS.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0042")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0076")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0077")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0078")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0079"),true);
							modelText = commutil.trimText(getInputText("dd:normalized:DSA-COST-OF-CREDIT-0042"),true);
							modelText2= commutil.trimText("3%"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0029"), true);
							if(context.getLanguage().contains("E"))
								modelText3=commutil.trimText("Information effective as of December 10, 2025.", true);
							else
								modelText3=commutil.trimText("Les renseignements sont en vigueur à compter du 10 Décembre 2025.", true);
							System.out.println("\n Text from DD: "+modelText);
							try {
									Assert.assertTrue(pdfText.contains(modelText));
									Assert.assertTrue(pdfText.contains(modelText2));
									Assert.assertTrue(pdfText.contains(modelText3));
							}catch(Exception e) {
								throw e;
							}
							System.out.println("OMR COCD Validated changes successfully \n");
							break;
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("COCD validation failed \n");
		}
	}
	
	public void agreeCOC(DSA_DM dsa) throws Exception {
		try {
			log.info("Attempting to agree Cost of Credit Disclosure for Credit Card Application");
			try {
				log.info("Attempting to validate Cost of Credit Disclosure for Credit Card Application page");
				/*if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
					expectedTitle = "Déclaration sur le coût du crédit";
					wait.until(ExpectedConditions.titleContains(expectedTitle));
					pageTitle();
				} else { */
					expectedTitle = getInputText("dd:DSA-PAGE-TITLE-03");
					driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
					pageTitle();
				//}
			} catch (Exception e) {
				log.info("Page validation failed.");
				e.printStackTrace();
			}
//			validateText(By.xpath(popUpHeader), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-01"));
//			validateText(By.xpath(popUpPara), getInputText("dd:DSA-IBM-LANDING-PAGE-04"));
			clickElement(agreeBtn);
			Thread.sleep(3000);
//			driverWait.getDriverWait().until(ExpectedConditions.invisibilityOf(agreeBtn));
		} catch (Exception e) {
			log.info("Caught error attempting to agree COC");
			e.printStackTrace();
			throw e;
		}
	}
	
	public String openPdfonCOCD(String button) throws Exception
	{
        String url="";
        String stripText = "";
        try {		
        	 switch(button) {
        		
        		case "Top":
        			  clickElement(savepdfCOCD);
        			  System.out.println("\n Clicked Top Save or Print");
        			  break;
                    
        		case "Bottom":     
                      clickElement(savepdfBottomCOCD);
                      System.out.println("\n Clicked Botton Save or Print");
                      break;
        		}
       		
       		System.out.println("\n Fetching url for PDF \n ^^^^^^^");
			Thread.sleep(7000);
			if(context.getDsaDmData().getLanguage().contains("E")) 
				 url="docs_EN.pdf";
			 else
				 url="docs_FR.pdf";
			 if(applicationProperties.getBrowser().contains("android")) {
//				 Thread.sleep(7000);
				 System.out.println("Inside Mobile: Waiting for PDF to load");
				 PU.clickBack();
				 System.out.println("Clicked on Back button");
				 Thread.sleep(8000);
			 }
			 else if(applicationProperties.getBrowser().contains("iphone")) {
//				 clickElement(savepdfCOCD);
				 Thread.sleep(7000);
				 System.out.println("\n Inside Iphone block \n");
				 PU.switchTab(driverManager.getDriver());
//				 url=driverManager.getDriver().getCurrentUrl();
				 System.out.println("Current URL:"+url);
			 }
			 else 
			 {
				 System.out.println("Switching to PDF tab");
    			String activeWindow;
         		tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
         		activeWindow = tabs.get(tabs.size()-1);
         		System.out.println("Number of tabs: "+tabs.size());
         		driverManager.getDriver().switchTo().window(activeWindow);
//    			url = driverManager.getDriver().getCurrentUrl();
			 }
    			System.out.println("Current URL:"+url);
    			System.out.println("Fetching text from PDF");
                stripText = PU.openPdfandStripText(url);
                System.out.println("Text from PDF: \n"+stripText);
                System.out.println("\n Starting validation \n");
                if(context.getDsaDmData().getLanguage().contains("E") && context.getDsaDmData().getCardType().equals("OMX")) {
                	 if(stripText.contains("28.99%")) {
                		 System.out.println(" Rate matched on COCD \n");
                	 }
                	 else
                		 Assert.fail("\n COCD rate 28.99% text in ENG does not match \n");
    			}	
                if(context.getDsaDmData().getLanguage().contains("F") && context.getDsaDmData().getCardType().equals("OMX")) {
                    if(stripText.contains("28,99 %")) 
                    	 System.out.println(" Rate matched on COCD in FRC\n");
                    else
                    	 Assert.fail("\n COCD rate 28,99 % text in FRC does not match \n");
                }        
                System.out.println("* Validation completed : COCD pdf *");    
                if(!driverManager.isMobile()) {
               	 closeCOCD();
                }
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
//            	driverManager.getDriver().close();
            	Thread.sleep(3000);
             	System.out.println("No of Tabs"+tabs.size());
             	if(context.getDsaDmData().getChannel().equals("WP")) {
             		System.out.println("Switching in Ecom tab");
					driverManager.getDriver().switchTo().window(tabs.get(1));
             	}
				else {
					System.out.println("Switching in NonEcom tab");
					 driverManager.getDriver().switchTo().window(tabs.get(0));
				}
//             	Thread.sleep(2000);
             	} catch (Exception e) {
             		e.printStackTrace();
           			Assert.fail("Failed to Close Cost Of Credit Disclosure Tab");
           			throw e;
             	}
	}
	
	public void validateEffDt(DSA_DM dsa) throws Exception {
		try {
			log.info(" Attempting to validate Effective date : agree Cost of Credit Disclosure : LetsGetStartedPage\n");
			System.out.println("Attempting to validate Effective date : agree Cost of Credit Disclosure : LetsGetStartedPage\n");
			String dateParagraph = effDatePara.getText();
			if(context.getDsaDmData().getLanguage().contains("E")) {
				if(dateParagraph.indexOf("Information effective as of December 10, 2025.")>=0) {
					System.out.println(" \n Effective Date validated\n");
				}
				
			}
			else{
				if(dateParagraph.indexOf("Les renseignements sont en vigueur à compter du 10 Décembre 2025.")>=0) {
					System.out.println(" \n Effective Date validated in FRC\n");
				}
			}
		}catch(Exception e) {
			log.info( "\n FAILED : Effective date not validated: LetsGetStartedPage\n");
			throw e;
		}
	}

//	@Override
	public void validate() throws ValidationException {
		// TODO Auto-generated method stub
		
	}
	
}

// pdf text validation

//String textFromDD= (getInputText("dd:normalized:DSA-COST-OF-CREDIT-0001")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0003")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-INT-RATE-OMX")+
//	getInputText("dd:normalized:DSA-COST-OF-CREDIT-0009")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0010")+"21"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0011")+"26"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0012")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0013")+"21"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0014")+"26"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0015")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0016")+
// getInputText("dd:normalized:DSA-COST-OF-CREDIT-0017")+
// getInputText("dd:normalized:DSA-COST-OF-CREDIT-0018")+"10"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0019")+"10"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0020")+"10"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0044")+"5"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0045")+"10"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0046")+
// getInputText("dd:normalized:DSA-COST-OF-CREDIT-0021")+
// getInputText("dd:normalized:DSA-COST-OF-CREDIT-0022")+"25"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0023")+"25"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0024")+
// getInputText("dd:normalized:DSA-COST-OF-CREDIT-0025")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0026")+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0027")+
// getInputText("dd:normalized:DSA-COST-OF-CREDIT-0028")+"3 of the amount of the transaction, up to a maximum of 10 - charged for cash withdrawals and other cash transactions (excluding balance transfers and convenience cheques) when the transaction is posted to your account."+
// getInputText("dd:normalized:DSA-COST-OF-CREDIT-0030")+"2 - Charged when you request a copy of a statement."+"Credit Balance Fee The lesser of"+"2"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0032")+"2"+getInputText("dd:normalized:DSA-COST-OF-CREDIT-0033")+
// getInputText("dd:normalized:DSA-COST-OF-CREDIT-0036"));
