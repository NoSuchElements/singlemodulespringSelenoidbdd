package com.nosuchelements.pages.dsa;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class CreditProtectorPage extends BasePage {
	
	ArrayList<String> tabs;
	
	@Autowired
	private CommonUtils commutil;

	@Autowired
	private pdfUtil pu;
	
	
	@FindBy(how = How.XPATH, using = "//h1[@id='credit-protector__heading']")
    private WebElement cpiHeader;
	
	@FindBy(how = How.XPATH, using = "//h2[@id='cpMainTitle']")
    private WebElement cpiSubTitle;
	
	@FindBy(how = How.XPATH, using = "//input[@id='cpSelectEnrolYes']")
    private WebElement yesShowMe;
	
	@FindBy(how = How.XPATH, using = "//input[@id='cpSelectEnrolNo']")
    private WebElement noThanks;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'ngDialogCpHowMuch')]")
    private WebElement howmuchLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@data-ng-click,'ngDialogCpCancel')]")
    private WebElement howtoCancelLink;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='cpBoxLegal']//span[contains(@data-ng-show,'displayTriangleCreditProtector') and @aria-hidden='false']/div)[2]")
    private WebElement summaryLink_English;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='cpBoxLegal']//span[contains(@data-ng-show,'displayTriangleCreditProtector') and @aria-hidden='false']/div)[1]")
    private WebElement summaryLink_French;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cpBoxLegal']//span[contains(@data-ng-show,'displayTriangleCreditProtector') and @aria-hidden='false']/strong")
    private WebElement summaryLink;
	
	@FindBy(how = How.XPATH, using = "//h2[@class='cp-modal-title']")
//	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/h2/span[2]/strong")
	private WebElement summaryHeader;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@ng-switch,'cpCostDialog')]//h4/span[@aria-hidden='false']")
    private WebElement summaryHeaderOMXFrc;
	
	@FindBy(how = How.XPATH, using = "//div[@id='scrollable-content']")
    private WebElement summaryText;
	
	@FindBy(how = How.XPATH, using = "(//input[@id='language-toggle']//..)[1]")
    private WebElement summaryToggle;
	
	@FindBy(how = How.XPATH, using = "//div[@data-ng-model='cpCostDialog.scrollComplete']/div[3]/div[1]/p[3]/span[2]")
    private WebElement summAssurantText;  // the trade name of Assurant 
	
	@FindBy(how = How.XPATH, using = "//div[@data-ng-model='cpCostDialog.scrollComplete']/div[3]/div[1]/p[3]")
    private WebElement summAssurantTextROCfr;
	
//	@FindBy(how = How.XPATH, using = "//div[@id='scrollable-content']/div[1]/p[3]/span[2]")
	@FindBy(how = How.XPATH, using = "//div[@id='scrollable-content']/div[1]/p[3]")  
    private WebElement summAssurantTextQCEng;  // the trade name of Assurant
	
//	@FindBy(how = How.XPATH, using = "//div[@data-ng-model='cpCostDialog.scrollComplete']/div[3]/div[1]/p[16]")
	@FindBy(how = How.XPATH, using = "//div[@id='cpModalBody']/div/p[17]")
    private WebElement summAddressClaimProcedures; 
	
	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/p[22]") 
    private WebElement summAddressClaimProceduresQCEng;
	
	@FindBy(how = How.XPATH, using = "//div[@data-ng-model='cpCostDialog.scrollComplete']/div[3]/div[1]/p[18]")
    private WebElement summaryClaimtext; //the insurer pays...     and if your claim is denied
	
	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/p[23]")
    private WebElement summaryClaimtextQCEng; //the insurer pays...     and if your claim is denied
	
//	@FindBy(how = How.XPATH, using = "//div[@id='scrollable-content']/ul[4]/li[4]") 
	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/ul[4]/li[3]/p")
    private WebElement summAssurantThirdBulletText; //3rd bullet
	
	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/ul[4]/li[3]/p") 
    private WebElement summAssurantThirdBulletQCEng; //3rd bullet
	
	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/ul[4]/li[13]") 
    private WebElement summAssurantLastbulletText; //Assurant is committed to safeguarding
	
	@FindBy(how = How.XPATH, using = "//div[@id='scrollable-content']/div[1]/ul[4]/li[13]") 
    private WebElement summAssurantLastbulletQCEng; //Assurant is committed to safeguarding
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@ng-switch,'cpCostDialog')]//div[@class='ng-scope']//span/a)[1]")
    private WebElement summary_SaveorPrint;
/*	
//	@FindBy(how = How.XPATH, using = "//div[contains(@ng-switch,'creditProCtrl')]//p[@class='ng-scope']//a[@aria-hidden='false']")
	@FindBy(how = How.XPATH, using = "(//span[contains(@data-ng-show,'creditProCtrl') and @aria-hidden='false']/div[@class='pdf-img']/a)[2]")
	private WebElement certOfInsurance; // Eng QC
	
//	@FindBy(how = How.XPATH, using = "(//span[contains(@data-ng-show,'creditProCtrl') and @aria-hidden='false']/div[@class='pdf-img']/a)[1]")
	@FindBy(how = How.XPATH, using = "//div[contains(@ng-switch,'creditProCtrl')]/div/span[2]/div[1]/a[1]/span")
	private WebElement COI_French; //QC
	
//	@FindBy(how = How.XPATH, using = "//div[contains(@ng-switch,'creditProCtrl')]//p[@class='ng-scope']//a[@aria-hidden='false']")
	@FindBy(how = How.XPATH, using = "//p[@class='ng-scope']/a[2]")
	private WebElement certOfIns;  //OMR, OMX frc
	
	@FindBy(how = How.XPATH, using = "//p[@class='ng-scope']/a[2]/span[@class='pdfLink']")
    private WebElement COI_English; //ROC
	
	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/span/a[2]/span[@class='pdfLink']")
    private WebElement factSheetLink;  //ROC Eng
	
//	@FindBy(how = How.XPATH, using = "(//span[contains(@data-ng-show,'creditProCtrl') and @aria-hidden='false']/div[@class='pdf-img']/a)[3]")
	@FindBy(how = How.XPATH, using = "//div[@class='ng-scope']/span[1]/a[2]/span[1]")
    private WebElement factSheetLink_French;  //QC
	
	@FindBy(how = How.XPATH, using = "(//span[contains(@data-ng-show,'creditProCtrl') and @aria-hidden='false']/div[@class='pdf-img']/a)[4]")
    private WebElement factSheetLink_English; //QC
	*/
	
	// QC address
	@FindBy(how = How.XPATH, using = "(//span[contains(@data-ng-show,'creditProCtrl') and @aria-hidden='false']/div[@class='pdf-img']/a)[2]")
	private WebElement certOfInsurance; 

	@FindBy(how = How.XPATH, using = "//span[contains(@data-ng-show,'creditProCtrl') and @aria-hidden='false']//span[contains(text(),'assurance')]")
	private WebElement COI_French; 
	
	@FindBy(how = How.XPATH, using = "(//div[@id='cpBoxLegal']/div[1]/div/span/div[2]/a)[1]")
	private WebElement COI_English_QC; //QC
	
	@FindBy(how = How.XPATH, using = "//div[@id='cpBoxLegal']/div[1]/p/a[2]/span")
	private WebElement COI_English_ROC; 
	
	@FindBy(how = How.XPATH, using = "(//*[@id='cpBoxLegal']//div[1]/p/a)[1]")
	private WebElement COI_Frc;

	@FindBy(how = How.XPATH, using = "(//span[contains(@data-ng-show,'creditProCtrl') and @aria-hidden='false']/div[@class='pdf-img']/a)[4]")
    private WebElement factSheetLink_English; 
	
	@FindBy(how = How.XPATH, using = "(//span[contains(@data-ng-show,'creditProCtrl') and @aria-hidden='false']/div[@class='pdf-img']/a)[3]")
    private WebElement factSheetLink_French; 
	
	//ROC
	
	@FindBy(how = How.XPATH, using = " //p[@class='ng-scope']/a[2]/span[@class='pdfLink']")
	private WebElement certOfInsROC; 

//	@FindBy(how = How.XPATH, using = "//div[@id='cpBoxLegal']//div[@class='ng-scope']//span//a[@aria-hidden='false']")
	@FindBy(how = How.XPATH, using = "//div[@id='cpBoxLegal']//div[@class='ng-scope']//span//a[@aria-hidden='false']/span")
	private WebElement factSheetLinkROC; //All CPC
	
	@FindBy(how = How.XPATH, using = "//div[@class='parsys_1 responsivegrid']//input[@id='cpViewMore']")
    private WebElement viewMore;
	
	@FindBy(how = How.XPATH, using = "//input[@id='cpSelectEnrolYes']")
    private WebElement insuranceYes;
	
	@FindBy(how = How.XPATH, using = "//input[@id='cpLegalCheckbox']")
    private WebElement legalCheckbox;
	
	@FindBy(how = How.XPATH, using = "//div[@class='termBox marTop30']/div[1]/input[1]")
    private WebElement assurantCheckbox;
	
	@FindBy(how = How.XPATH, using = "//div[@class='termBox marTop30']/div[1]/span/div/label")
    private WebElement AssurantPolicy;
	
	@FindBy(how = How.XPATH, using = "//input[@id='cpLegalCheckbox']//following-sibling::span")
    private WebElement TnCText;
	
	@FindBy(how = How.XPATH, using = "//span[@class='termText']//div[@class='ng-scope']/span[@aria-hidden='false']")
    private WebElement TnCText_Para1;
	
	@FindBy(how = How.XPATH, using = "//span[@class='termText']//div[@class='ng-scope']//p//span[@aria-hidden='false']")
    private WebElement TnCText_Para2;
		
	@FindBy(how = How.XPATH, using = "//button[@id='cpStep1NextBtn']")
    private WebElement nextBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='cp-coc-agree-terms']")
    private WebElement gotIt;
	
	@FindBy(how = How.XPATH, using = "//div[@class='parsys_1 responsivegrid']//input[@id='cpSelectEnrolNo']")
    private WebElement noTerms;
	
	@FindBy(how = How.XPATH, using = "//form[@id='credit-protector-form-step2']//label[@class='radio-inline']/input[@id='cpEnroll']")
    private WebElement enroll;
	
	@FindBy(how = How.XPATH, using = "//button[@id='cpStep2NextBtn']")
    private WebElement step2NextBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cpSelectTermsValidations']/small")
    private WebElement selectionErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cpLegalCheckboxValidations']/small")
    private WebElement termsError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cpPrivacyCheckboxValidations']/small")
    private WebElement assurantError;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cpCost-modal']")
    private WebElement popupHeader;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cpCost-modal']")
    private WebElement popupText;
	
	@FindBy(how = How.XPATH, using = "//div[@id='cpCost-modal']")
    private WebElement summaryOfCoverageModalText;
	
	@FindBy(how = How.XPATH, using = "//h1[@id='ngdialog3-aria-labelledby']")
    private WebElement howmuchpopupHeader;
	
	@FindBy(how = How.XPATH, using = "//p[@id='ngdialog3-aria-describedby']")
    private WebElement howmuchpopupText;
	
	@FindBy(how = How.XPATH, using = "//h1[@id='ngdialog4-aria-labelledby']")
    private WebElement howcancelpopupHeader;
	
	@FindBy(how = How.XPATH, using = "//p[@id='ngdialog4-aria-describedby']")
    private WebElement howcancelpopupText;
	
	@FindBy(how = How.XPATH, using = "//h1[@id='ngdialog5-aria-labelledby']")
    private WebElement coverageandDeclpopupHeader;
	
	@FindBy(how = How.XPATH, using = "//p[@id='ngdialog5-aria-describedby']")
    private WebElement coverageandDeclpopupText;
	
	@FindBy(how = How.XPATH, using = "//*[@id='cpStep1EditNextBtn']")
    private WebElement cpEditNext;
	
	@FindBy(how = How.XPATH, using = "//button[@id='cp-change-understood']")
    private WebElement gotItBtn;
	
	@FindBy(how = How.XPATH, using = "//p[@id='ngdialog3-aria-describedby']")
    private WebElement gotItPopupText;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'cpLegal')]//div[@id='sect1']/div")
	private WebElement legalFooternotes;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'cpLegal')]//button[@id='legalFooter']")
	private WebElement legalFootNotesExpand;
	
	
	//cocAgreeBtn
	
	public void creditProtection(DSA_DM dsa, String acceptCP) throws InterruptedException {
		try {

			expectedTitle = getInputText("Personal Information");
			System.out.println("Title is "+driverManager.getDriver().getTitle());
			driverWait.getDriverWait().until(ExpectedConditions.titleContains(expectedTitle));
			commutil.pageTitle();
			if(acceptCP.equalsIgnoreCase("yes")) {
				clickElement(insuranceYes);
				dsa.setCPIEnroll("Y");
				clickElement(gotIt);
				waitForSeconds(3);
				clickElement(legalCheckbox);
				waitForSeconds(3);
			}else {
			//	clickElement(By.xpath(noTerms));
				clickElement(noThanks);
				dsa.setCPIEnroll("N");
			} 
			clickElement(nextBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

	public String pdfFetch(String pdf) throws InterruptedException {
		String stripText = "";
		String url = "";
		try {
				 Thread.sleep(2000);
				 if(driverManager.isMobile()) {
					 System.out.println("Inside Mobile: Waiting for PDF to load");
					 pu.clickBack();
					 System.out.println("Clicked on Back button");
				 }
				 Thread.sleep(8000);
//			 }  
//			 else{
//	    			String activeWindow;
//	         		tabs = new ArrayList<String>(driverManager.getWebDriver().getWindowHandles());
//	         		activeWindow = tabs.get(tabs.size()-1);
//	         		driverManager.getWebDriver().switchTo().window(activeWindow);
//	    			url = driverManager.getWebDriver().getCurrentUrl();
//			 }
			    System.out.println("Current URL:"+url);
    			System.out.println("Fetching text from PDF");
                stripText = pu.openPdfandStripText(url);
                System.out.println("Text from PDF: \n"+stripText);
                System.out.println("\n Starting validation \n");
              
                if(!driverManager.isMobile()) {
                  	 closePDF();
                }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return stripText;
	}
	
	
	public void pdfValidate(String stripText, String link) throws Exception {
		
		try {
			switch(link) {
				case"COIEng":
							Thread.sleep(1000);
							if(stripText.replaceAll("\\s+", "").contains("1945 King Street East, Suite 100 Hamilton, Ontario L8K 1W2".replaceAll("\\s+", ""))){
								System.out.println(" Assurance Address validated on Cert Of Insurance pdf \n");
							}
							else
								Assert.fail("\n Assurance Address validation failed on Cert Of Insurance ENGLISH: CP Page pdf \n");
							break;
				case"COIFrc":Thread.sleep(1000);
							/*	stripText= stripText.substring(1456,1517);
								stripText.replaceAll("/r/n", "");
								System.out.println(" Substring : \n"+stripText);
								if(stripText.contains("1945, rue King Est, bureau 100")) 
//									if(stripText.contains("1945, rue King Est, bureau 100\r\n"+ "Hamilton (Ontario) L8K 1W2\r\n"+ "")){
									System.out.println(" Address matched on COI Frc \n");
								else
									Assert.fail("\n Assurance Address validation failed on Cert Of Insurance FRENCH: CP Page pdf \n");*/
//							if(stripText.contains("1945, rue King Est, bureau 100 \r\n"
//									+ "Hamilton (Ontario) L8K 1W2")){
								if(stripText.contains("1945, rue King Est, bureau 100")){
								System.out.println(" Assurance Address validated on Cert Of Insurance Frc pdf \n");
							}
							else
								Assert.fail("\n Assurance Address validation failed on Cert Of Insurance Frc: CP Page pdf \n");
				
							break;
				case"SummFactSheetEng":
							if(stripText.contains("1945 King Street East, Suite 100, Hamilton, Ontario L8K 1W2")) {
								System.out.println(" Assurance Add validated on Summary of Factsheet Eng pdf \n");
							}
							else
								Assert.fail("\n Assurance Address validation failed on Summary of Factsheet Eng: CP Page pdf \n");
							break;
				case"SummFactSheetFrc":
							if(stripText.contains("1945, rue King Est, bureau 100, Hamilton (Ontario) L8K 1W2")) 
								System.out.println(" Summary of Factsheet Frc \n");
							else
								Assert.fail("\n Assurance Address validation failed on Cert Of Insurance FRENCH: CP Page pdf \n");
							break;
				case"SummaryOfCoverageFr":
					if(stripText.replaceAll("\\s+", " ").contains("Vous comprenez que si vous avez fait une fausse déclaration d’âge et que vous étiez âgé de moins de 18 ans ou de 75 ans ou plus au moment de l’adhésion, la responsabilité de l'Assureur se limitera à un remboursement de toutes les primes payées (y compris les taxes applicables)")) 
						System.out.println(" Summary of Coverage Frc \n");
					else
						Assert.fail("\n 3rd bullet point validation failed on Summary of Coverage FRENCH: CP Page pdf \n");
					break;
				case"SummaryOfCoverageEn":
					if(stripText.replaceAll("\\s+", " ").contains("You understand that if You misstated Your age and were under the age of 18 or 75 years of age or over at time of enrollment the Insurer's liability is limited to a refund of all premiums (including applicable taxes)")) 
						System.out.println(" Summary of Coverage Eng \n");
					else
						Assert.fail("\n 3rd bullet point validation failed on Summary of Coverage English: CP Page pdf \n");
					break;
			}//switch
		}catch(Exception e) {
			throw e;
		}
	}
	
	public void closePDF() throws Exception {
        System.out.println("\n Closing PDF tab... \n");
        try {
        		String activeWindow;
        		tabs = new ArrayList<String>(driverManager.getDriver().getWindowHandles());
        		activeWindow = tabs.get(tabs.size()-1);
        		driverManager.getDriver().switchTo().window(activeWindow);
//            	driverManager.getWebDriver().close();
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
           			Assert.fail("Failed to Close Cost Of Credit Disclosure Tab");
           			throw e;
             	}
	}
	
//	@Override
	public void validate() throws ValidationException, InterruptedException {
//		validateText(By.xpath(cpiHeader), getInputText("dd:DSA-IBM-LEFT-NAV-HEADING-02"));
//		validateText(By.xpath(instructionMsg), getInputText("dd:DSA-IBM-PERSONAL-INFO-0046"));
		waitForVisible(yesShowMe);
//		waitForVisible(By.xpath(nextBtn));
		
	}

}
