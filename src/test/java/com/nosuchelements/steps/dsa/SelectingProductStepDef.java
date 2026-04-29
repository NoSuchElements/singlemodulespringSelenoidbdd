package com.nosuchelements.steps.dsa;

import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.constants.TestLanguage;
import com.nosuchelements.constants.Constants.Language;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.SelectCardPage;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.java.en.And;

public class SelectingProductStepDef extends BasePage {

	@Autowired
	private SelectCardPage selectCardPage;
	
	@Autowired
	private CommonUtils commutil;
	
	@And("User on Cards Page selects Product Type as {string}")
	public void chooseProd(String cardType)
	{
		try
		{
			
			DSA_DM dsaDM = context.getDsaDmData();
			dsaDM.setCardType(cardType);
			dsaDM.setChannel("WP");
			context.setLanguage(TestLanguage.getLanguage().toString());
			dsaDM.setLanguage(context.getLanguage().toString());
			context.setDsaDmData(dsaDM);
			System.out.println("DSA data in chooseProd:"+context.getDsaDmData());
			Thread.sleep(5000);
//			Assert.assertTrue(waitForNewWindow(driver,10), "");
			System.out.println("Language:"+TestLanguage.getLanguage());
			if(TestLanguage.getLanguage()==Language.French) {
				ArrayList<String> tabs = new ArrayList<String>(driverManager.getAppiumDriver().getWindowHandles());
				String activeWindow = tabs.get(1);
				driverManager.getAppiumDriver().switchTo().window(activeWindow);
				String currentUrl = driverManager.getAppiumDriver().getCurrentUrl();
				System.out.println("Current URL:  "+currentUrl);
				System.out.println("Navigating to French URL");
				currentUrl = currentUrl.replace("/en.html", "/fr.html");
				driverManager.getAppiumDriver().navigate().to(currentUrl.replace("lang=en", "lang=fr"));
				waitForSeconds(5);
				log.info("Successfully redirected to French website");
			}
			selectCardPage.chooseCard(context.getDsaDmData(), cardType);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Select Prod Type");
			
		}
	}
	
	@And("User on Cards Page selects Product Type as {string} in new URL")
	public void chooseProdinNewUrl(String cardType)
	{
		try
		{
			DSA_DM dsaDM = context.getDsaDmData();
			dsaDM.setCardType(cardType);
			dsaDM.setChannel("WP");
			context.setDsaDmData(dsaDM);
			String currentURL = "https://qa-mastercard.triangle.com/content/dsa";
			String newUrl = null;
			for (String window : driverManager.getAppiumDriver().getWindowHandles()) {
				driverManager.getAppiumDriver().switchTo().window(window);
				if (driverManager.getAppiumDriver().getCurrentUrl().contains(currentURL) && context.getLanguage()=="English") {
					log.info("Successfully redirected to Old DSA website");
					driverManager.getAppiumDriver().navigate().to(driverManager.getAppiumDriver().getCurrentUrl().replace("dsa", "dsa2"));
					if(driverManager.getAppiumDriver().getCurrentUrl().contains("dsa2"))
					log.info("Successfully redirected to new DSA website");
					else
						log.info("Not able to redirected to new DSA website");
				}
				else {
					log.info("Successfully redirected to Old DSA website");
					String newURL = driverManager.getAppiumDriver().getCurrentUrl().replace("dsa", "dsa2");
					driverManager.getAppiumDriver().navigate().to(newURL.replace("/en", "/fr").replace("=en", "=fr"));
					if(driverManager.getAppiumDriver().getCurrentUrl().contains("dsa2"))
					log.info("Successfully redirected to new DSA website");
					else
						log.info("Not able to redirected to new DSA website");
				}
					
			}
			commutil.pageTitle();
			if(cardType.equalsIgnoreCase("OMX"))
			{
				clickElement(selectCardPage.getOmxApplyNowBtn());
				driverWait.getDriverWait().until(ExpectedConditions
					.invisibilityOf(selectCardPage.getOmxApplyNowBtn()));
			} else {
				clickElement(selectCardPage.getOmzApplyNowBtn());
				driverWait.getDriverWait().until(ExpectedConditions
					.invisibilityOf(selectCardPage.getOmzApplyNowBtn()));
			}
//			chooseCard(context.getDsaDmData(), cardType);
		}catch(Exception e) {
			Assert.fail("Failed to Select Prod Type");
			e.printStackTrace();
		}
	}
}
