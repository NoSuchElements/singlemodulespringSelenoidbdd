package com.nosuchelements.pages;

import com.nosuchelements.driver.DriverManager;
import com.nosuchelements.utils.WaitHelper;

import jakarta.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * • Base Page Object - all page objects extend this class • Automatic
 * PageFactory initialization using Spring @PostConstruct • Features: o
 * Automatic PageFactory initialization o Common page operations o WaitHelper
 * integration o Logger support
 */
public abstract class BasePage_Old {
	protected static final Logger logger = LoggerFactory.getLogger(BasePage_Old.class);
	@Autowired
	protected DriverManager driverManager;
	@Autowired
	protected WaitHelper waitHelper;
	protected WebDriver driver;

	/**
	 * o Initialize PageFactory elements after Spring dependency injection o Called
	 * automatically by Spring after bean creation
	 */
	@PostConstruct
	public void init() {
		this.driver = driverManager.getDriver();
		if (this.driver != null) {
			PageFactory.initElements(driver, this);
			logger.debug("PageFactory initialized for {}", this.getClass().getSimpleName());
		}
	}

	
	
	/**
	 * o Navigate to URL
	 */
	protected void navigateTo(String url) {
		logger.info("Navigating to: {}", url);
		driver.get(url);
	}

	/**
	 * o Get current URL
	 */
	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * o Get page title
	 */
	protected String getTitle() {
		return driver.getTitle();
	}

	/**
	 * o Check if URL contains text
	 */
	protected boolean urlContains(String text) {
		String currentUrl = getCurrentUrl();
		boolean contains = currentUrl.contains(text);
		logger.debug("URL contains '{}': {}", text, contains);
		return contains;
	}

	/**
	 * o Check if title contains text
	 */
	protected boolean titleContains(String text) {
		String title = getTitle();
		boolean contains = title.contains(text);
		logger.debug("Title contains '{}': {}", text, contains);
		return contains;
	}

	/**
	 * o Refresh current page
	 */
	protected void refresh() {
		logger.debug("Refreshing page");
		driver.navigate().refresh();
	}

	/**
	 * o Navigate back
	 */
	protected void navigateBack() {
		logger.debug("Navigating back");
		driver.navigate().back();
	}

	/**
	 * o Navigate forward
	 */
	protected void navigateForward() {
		logger.debug("Navigating forward");
		driver.navigate().forward();
	} 
}
