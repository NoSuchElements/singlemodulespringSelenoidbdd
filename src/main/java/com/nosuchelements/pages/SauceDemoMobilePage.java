package com.nosuchelements.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.nosuchelements.annotations.PageObject;

/**
 * • SauceDemo Mobile Page Object • Mobile browser testing example
 */
@PageObject
public class SauceDemoMobilePage extends MobileBasePage {
	@FindBy(id = "user-name")
	private WebElement usernameField;
	@FindBy(id = "password")
	private WebElement passwordField;
	@FindBy(id = "login-button")
	private WebElement loginButton;
	@FindBy(className = "inventory_list")
	private WebElement inventoryList;

	/**
	 * o Open SauceDemo mobile page
	 */
	public void open() {
		logger.info("Opening SauceDemo mobile page");
		navigateTo("https://www.saucedemo.com");
	}

	/**
	 * o Login with credentials
	 */
	public void login(String username, String password) {
		logger.info("Performing mobile login with username: {}", username);
		waitHelper.waitForElementVisible(By.id("user-name"));
		usernameField.clear();
		usernameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
		hideKeyboard();
		loginButton.click();
	}

	/**
	 * o Check if inventory is displayed
	 */
	public boolean isInventoryDisplayed() {
		logger.info("Verifying mobile inventory page is displayed");
		try {
			return waitHelper.waitForElementVisible(By.className("inventory_list")).isDisplayed();
		} catch (Exception e) {
			logger.error("Mobile inventory not displayed", e);
			return false;
		}
	}

	/**
	 * o Scroll to product
	 */
	public void scrollToProduct(String productName) {
		logger.info("Scrolling to product: {}", productName);
		scrollToElement(productName);
	}
}
