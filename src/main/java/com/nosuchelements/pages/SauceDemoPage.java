package com.nosuchelements.pages;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * • SauceDemo Page Object • Demonstrates complete page object implementation
 */
@PageObject
public class SauceDemoPage extends BasePage {
	// Login page elements
	@FindBy(id = "user-name")
	private WebElement usernameField;
	@FindBy(id = "password")
	private WebElement passwordField;
	@FindBy(id = "login-button")
	private WebElement loginButton;
	@FindBy(css = "[data-test='error']")
	private WebElement errorMessage;
	// Inventory page elements
	@FindBy(className = "inventory_list")
	private WebElement inventoryList;
	@FindBy(className = "inventory_item")
	private List<WebElement> inventoryItems;
	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingCartLink;
	// Locators
	private final By inventoryItemName = By.className("inventory_item_name");
	private final By addToCartButton = By.cssSelector("button[id^='add-to-cart']");

	/**
	 * o Open SauceDemo login page
	 */
	public void open() {
		log.info("Opening SauceDemo login page");
		navigateTo("https://www.saucedemo.com");
	}

	/**
	 * o Enter username
	 */
	public void enterUsername(String username) {
		log.info("Entering username: {}", username);
		driverWait.waitForElementVisible(By.id("user-name"));
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	/**
	 * o Enter password
	 */
	public void enterPassword(String password) {
		log.info("Entering password");
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	/**
	 * o Click login button
	 */
	public void clickLoginButton() {
		log.info("Clicking login button");
		loginButton.click();
	}

	/**
	 * o Login with username and password
	 */
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	/**
	 * o Check if inventory page is displayed
	 */
	public boolean isInventoryPageDisplayed() {
		log.info("Verifying inventory page is displayed");
		try {
			return driverWait.waitForElementVisible(By.className("inventory_list")).isDisplayed();
		} catch (Exception e) {
			log.error("Inventory page not displayed", e);
			return false;
		}
	}

	/**
	 * o Check if error message is displayed
	 */
	public boolean isErrorMessageDisplayed() {
		log.info("Verifying error message is displayed");
		try {
			return driverWait.waitForElementVisible(By.cssSelector("[data-test='error']")).isDisplayed();
		} catch (Exception e) {
			log.error("Error message not displayed", e);
			return false;
		}
	}

	/**
	 * o Get error message text
	 */
	public String getErrorMessageText() {
		log.info("Getting error message text");
		return errorMessage.getText();
	}

	/**
	 * o Get inventory items count
	 */
	public int getInventoryItemsCount() {
		int count = inventoryItems.size();
		log.info("Inventory items count: {}", count);
		return count;
	}

	/**
	 * o Add first item to cart
	 */
	public void addFirstItemToCart() {
		log.info("Adding first item to cart");
		WebElement firstAddButton = driverWait.waitForElementClickable(addToCartButton);
		firstAddButton.click();
	}

	/**
	 * o Get shopping cart badge count
	 */
	public String getCartBadgeCount() {
		try {
			WebElement badge = driver.findElement(By.className("shopping_cart_badge"));
			String count = badge.getText();
			log.info("Cart badge count: {}", count);
			return count;
		} catch (Exception e) {
			log.debug("No items in cart");
			return "0";
		}
	}
}
