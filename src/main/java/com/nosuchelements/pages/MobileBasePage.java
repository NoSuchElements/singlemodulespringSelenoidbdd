package com.nosuchelements.pages;

import com.nosuchelements.driver.DriverManager;
import com.nosuchelements.utils.WaitHelper;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import jakarta.annotation.PostConstruct;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * • Base Mobile Page Object • Provides mobile-specific helper methods
 */
public abstract class MobileBasePage {
	protected static final Logger logger = LoggerFactory.getLogger(MobileBasePage.class);
	@Autowired
	protected DriverManager driverManager;
	@Autowired
	protected WaitHelper waitHelper;
	protected AppiumDriver driver;

	/**
	 * o Initialize PageFactory elements after Spring dependency injection
	 */
	@PostConstruct
	public void init() {
		this.driver = driverManager.getAppiumDriver();
		if (this.driver != null) {
			PageFactory.initElements(driver, this);
			logger.debug("PageFactory initialized for {}", this.getClass().getSimpleName());
		}
	}

	/**
	 * o Navigate to URL (for mobile browser testing)
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
	 * o Scroll to element by text (Android)
	 */
	protected void scrollToElement(String text) {
		logger.info("Scrolling to element with text: {}", text);
		try {
//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains("" + text + ""))"));
		} catch (Exception e) {
			logger.warn("Could not scroll to element: {}", text, e);
		}
	}

	/**
	 * o Hide keyboard
	 */
	protected void hideKeyboard() {
		try {
			((HidesKeyboard) driver).hideKeyboard();
			logger.debug("Keyboard hidden");
		} catch (Exception e) {
			logger.debug("Keyboard not present or already hidden");
		}
	}

	/**
	 * o Swipe up
	 */
	protected void swipeUp() {
		logger.debug("Swiping up");
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		int startY = (int) (height * 0.8);
		int endY = (int) (height * 0.2);
		int startX = width / 2;
// TODO: Implement swipe using W3C actions
		logger.debug("Swipe coordinates: startY={}, endY={}, startX={}", startY, endY, startX);
	}

	/**
	 * o Tap on element by coordinates
	 */
	protected void tapByCoordinates(int x, int y) {
		logger.debug("Tapping at coordinates: ({}, {})", x, y);
// TODO: Implement tap using W3C actions
	}
}
