package com.nosuchelements.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.nosuchelements.annotations.PageObject;

import lombok.Data;

@PageObject
@Data
public class Logout extends BasePage {

	//@FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'LOGOUT')]")
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'dash-button--cancel')]")
	protected WebElement locBackToLogin;
	@FindBy(how = How.XPATH, using = "//button[@id='continue-changes-logout']")
	protected WebElement locContinoueBtn;
	
	@FindBy(how = How.XPATH, using = "//button[@id='success-error-banner']")
	protected WebElement locBannerCloseBtn;
	
	// public static String locYouveBeenLoggedOut = language == Language.English ?
	// "//h1[@id='logoutheader']/.//h1" : ""; //"//div[@id='moa-title']/h1";


	public void clickBackToLogin() throws InterruptedException {
//		clickElement(locBackToLogin);
		locBackToLogin.click();
	}

	
}
