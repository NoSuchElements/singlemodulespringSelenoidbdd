package com.nosuchelements.pages;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * • Google Search Page Object • Demonstrates @PageObject annotation and
 * PageFactory usage
 */
@PageObject
public class GooglePage extends BasePage_Old {
	// PageFactory FindBy annotations
	@FindBy(name = "q")
	private WebElement searchBox;
	@FindBy(id = "search")
	private WebElement searchResults;
	// Locators for dynamic elements
	private final By consentButton = By.xpath("//button[contains(., 'Accept all') or contains(., 'Reject all')]");
	private final By searchButton = By.name("btnK");

	/**
	 * o Open Google homepage
	 * @throws Exception 
	 */
	public void open() throws Exception {
		logger.info("Opening Google homepage");
		try {
			navigateTo("https://www.google.com");
			// Handle consent popup if present
//			WebElement element = driver.findElement(By.xpath(""));
//			element.click();
			handleConsentPopup();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	/**
	 * o Search for a term
	 */
	public void searchFor(String searchTerm) {
		logger.info("Searching for: {}", searchTerm);
		waitHelper.waitForElementVisible(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys(searchTerm);
		searchBox.sendKeys(Keys.ENTER);
	}

	/**
	 * o Check if search results are displayed
	 */
	public boolean areResultsDisplayed() {
		logger.info("Checking if search results are displayed");
		try {
			return waitHelper.waitForElementVisible(By.id("search")).isDisplayed();
		} catch (Exception e) {
			logger.error("Search results not found", e);
			return false;
		}
	}

	/**
	 * o Check if title contains expected text
	 */
	public boolean titleContains(String expectedText) {
		logger.info("Verifying title contains: {}", expectedText);
		return super.titleContains(expectedText);
	}

	/**
	 * o Get search results count (approximate)
	 */
	public String getResultsCount() {
		try {
			WebElement resultStats = waitHelper.waitForElementVisible(By.id("result-stats"));
			String statsText = resultStats.getText();
			logger.info("Search results stats: {}", statsText);
			return statsText;
		} catch (Exception e) {
			logger.warn("Could not retrieve results count", e);
			return "Unknown";
		}
	}

	/**
	 * o Handle Google consent popup
	 */
	private void handleConsentPopup() {
		try {
			WebElement consent = waitHelper.waitForElementClickable(consentButton);
			consent.click();
			logger.info("Consent popup handled");
		} catch (Exception e) {
			logger.debug("No consent popup found or already handled");
		}
	}
}
