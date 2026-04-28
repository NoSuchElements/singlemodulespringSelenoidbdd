package com.nosuchelements.pages.dsa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.constants.TestLanguage;
import com.nosuchelements.constants.Constants.Language;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;
import com.nosuchelements.utils.dsa.CommonUtils;

import lombok.Data;

@PageObject
@Data
public class SelectCardPage extends BasePage {
	
	@Autowired
	private CommonUtils commutil;

	
	@FindBy(how = How.XPATH, using = "(//button[@id='applyNowOMX'])[2]")
    private WebElement omxApplyNowBtn;
	
	@FindBy(how = How.XPATH, using = "(//button[@id='applyNowOMZ'])[2]")
    private WebElement omzApplyNowBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ecomm-card-select']/h1")
    private WebElement cardSelectorPageHeader;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='container-fluid'])[3]/div/div[1]/div")
    private WebElement omxProdDiv;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='container-fluid'])[3]/div/div[1]/div/img")
    private WebElement omxProdImg;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='container-fluid'])[3]/div/div[2]/div")
    private WebElement omzProdDiv;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='container-fluid'])[3]/div/div[2]/div/img")
    private WebElement omzProdImg;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='container-fluid'])[3]/div/div[1]/div/p[1]")
    private WebElement omxProdName;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='container-fluid'])[3]/div/div[2]/div/p[1]")
    private WebElement omzProdName;
	
	protected String currentUrl = "https://qa-mastercard.triangle.com/content/dsa2";
	
	public void chooseCard(DSA_DM dsa, String cardType) throws Exception {
		try {
			log.info("Attemting to select card/Product type");
			try {
				log.info("Attempting to validate 'Choose Product' page");
				System.out.println(driverManager.getDriver().getWindowHandles().size());
				for (String window : driverManager.getDriver().getWindowHandles()) {
					driverManager.getDriver().switchTo().window(window);
					//Below 2 lines are only for WDC Testing
//					currentUrl = driverManager.getWebDriver().getCurrentUrl().replace("qa-mastercard", "wdc-qa-mastercard");
//					driverHelper.navigateTo(currentUrl);
					
					System.out.println("Actual URL:" +driverManager.getDriver().getCurrentUrl());
					System.out.println("Expected URL:" +currentUrl);
					if (driverManager.getDriver().getCurrentUrl().contains(currentUrl)) {
						log.info("Successfully redirected to DSA website");
					}
				}

			/*	if (dsa.getLanguage().equalsIgnoreCase("Frc")) {
					clickElement(By.xpath(navBarLink));
					expectedTitle = "Demandez une MastercardMD TriangleMC";
					wait.until(ExpectedConditions.titleContains(expectedTitle));
					pageTitle();
				} else { */
//					expectedTitle = getInputText("dd:normalized:DSA-PAGE-TITLE-02");
//					System.out.println("Choose Card Title "+driver.getTitle());
//					wait.until(ExpectedConditions.titleContains(expectedTitle));
					commutil.pageTitle();
				//}

			} catch (Exception e) {
				log.info("Page validation failed.");
				e.printStackTrace();
			}

//			validateText(By.xpath(cardSelectorPageHeader), getInputText("dd:normalized:DSA-IBM-ECOMM-CARD-SELECT-06"));
			waitForVisible(omxProdDiv);
			waitForVisible(omzProdDiv);
			waitForVisible(omxProdImg);
			waitForVisible(omzProdImg);
			waitForVisible(omxApplyNowBtn);
			waitForVisible(omzApplyNowBtn);
			if(TestLanguage.getLanguage().equals(Language.English)) {
//			validateText(omxProdName, "Triangle® Mastercard®");
//			validateText(omzProdName, "Triangle® World Elite® Mastercard®");
			}
			else {
//				validateText(omxProdName, "MastercardMD TriangleMD");
//				validateText(omzProdName, "World EliteMD MastercardMD TriangleMD");
			}
			if(cardType.equalsIgnoreCase("OMX"))
			{
				clickElement(omxApplyNowBtn);
				driverWait.getDriverWait().until(ExpectedConditions.invisibilityOf(omxApplyNowBtn));
			} else {
				clickElement(omzApplyNowBtn);
				driverWait.getDriverWait().until(ExpectedConditions.invisibilityOf(omzApplyNowBtn));
			}

		} catch (Exception e) {
			log.info("Caught exception attempting to choose card type");
			e.printStackTrace();
			throw e;
		}
	}
	
}
