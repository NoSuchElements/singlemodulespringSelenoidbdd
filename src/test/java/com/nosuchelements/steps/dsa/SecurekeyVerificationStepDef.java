package com.nosuchelements.steps.dsa;

import static org.apache.commons.io.IOUtils.toByteArray;

import java.io.FileInputStream;
import java.util.Base64;

import org.apache.logging.log4j.Level;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.SecureKeyVerificationPage;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.java.en.And;

public class SecurekeyVerificationStepDef extends BasePage {
	
	@Autowired
	private SecureKeyVerificationPage SKVP;
	
	@Autowired
	private CommonUtils commutil;
	
	@And("User is on SecureKey Verification Page")
	public void verifyThankyouPage() {
		try
		{
			driverWait.getDriverWait().until(ExpectedConditions.visibilityOf(SKVP.getDriversLicenseBtn()));
			commutil.validate(context.getDsaDmData().getCardType());
			waitForSeconds(5);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate SecureKey Verification page");
			
		}
	}
	
	@And("User on SecureKey Verification Page Clicks {string} button")
	public void clickElement(String fieldName) {
		try {
			WebElement element = null;
			waitForSeconds(3);
			switch(fieldName) {
			case "Continue":
				element = SKVP.getContinueBtn();
				break;
			case "Passport":
				element = SKVP.getPassportBtn();
				break;
			case "DriversLicense":
				element = SKVP.getDriversLicenseBtn();
				break;
			case "ProvincialPhotoIdCard":
				element = SKVP.getProvincionalCardBtn();
				break;
			case "PermanentResidentCard":
				element = SKVP.getPermanentResidentCardBtn();
				break;
			case "IndianStatusCard":
				element = SKVP.getIndianStatusCardBtn();
				break;
			case "SKTnCCheckbox":
				element = SKVP.getSKTnCCheckbox();
				break;
			case "TnCcontinueBtn":
				element = SKVP.getTnCcontinueBtn();
				break;
			}
			clickElement(element);
			context.getDsaDmData().setSkIdDocType(fieldName);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to click on "+fieldName+"button");
		}
	}
	
	@And("User on SecureKey Verification Page Verifies {string} text should be {string}")
	public void verifyText(String fieldName, String _text) throws Exception {
		try {
			String expText=getInputText(_text);
			WebElement element = null;
			switch (fieldName) {
			case "Passport":
				element = SKVP.getPassportLabel();
				break;
			case "DriversLicense":
				element = SKVP.getDriversLicenseLabel();
				break;
			case "ProvincialPhotoIdCard":
				element = SKVP.getProvincionalCardLabel();
				break;
			case "PermanentResidentCard":
				element = SKVP.getPermanentResidentCardLabel();
				break;
			case "IndianStatusCard":
				element = SKVP.getIndianStatusCardLabel();
				break;
			
			}
			System.out.println("expected text "+expText);
			validateText(element, expText);
			
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to verify text "+fieldName);
			throw new Exception(e);
		}
	}
	
	

	// Read the file from the classpath and transform it to a base64 string
	@And("User on SecureKey Verification Page upload image")
	public void uploadImage() throws Exception {
		try {
				FileInputStream in = new FileInputStream("/Users/enriquegonzalez/Desktop/Gorilla.png");
				String qrCodeImage = Base64.getEncoder().encodeToString(toByteArray(in));
				// Provide the transformed image to the device
				((JavascriptExecutor)driverManager.getDriver()).executeScript("sauce:inject-image=" + qrCodeImage);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to upload Image");
			throw new Exception(e);
		}
	}

}
