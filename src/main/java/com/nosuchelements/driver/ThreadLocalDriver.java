package com.nosuchelements.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

/**
 * • ThreadLocal storage for WebDriver instances • Ensures thread safety for
 * parallel test execution • Features: o Thread-isolated driver instances o
 * Separate storage for Web and Mobile drivers o Session ID tracking for
 * reporting o Test name storage for context
 */
public class ThreadLocalDriver {
	private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
	private static final ThreadLocal<String> sessionId = new ThreadLocal<>();
	private static final ThreadLocal<String> testName = new ThreadLocal<>();

	/**
	 * o Set WebDriver instance for current thread
	 */
	public static void setWebDriver(WebDriver driver) {
		webDriver.set(driver);
	}

	/**
	 * o Get WebDriver instance for current thread
	 */
	public static WebDriver getWebDriver() {
		return webDriver.get();
	}

	/**
	 * o Set AppiumDriver instance for current thread
	 */
	public static void setAppiumDriver(AppiumDriver driver) {
		appiumDriver.set(driver);
	}

	/**
	 * o Get AppiumDriver instance for current thread
	 */
	public static AppiumDriver getAppiumDriver() {
		return appiumDriver.get();
	}

	/**
	 * o Set session ID for current thread
	 */
	public static void setSessionId(String id) {
		sessionId.set(id);
	}

	/**
	 * o Get session ID for current thread
	 */
	public static String getSessionId() {
		return sessionId.get();
	}

	/**
	 * o Set test name for current thread
	 */
	public static void setTestName(String name) {
		testName.set(name);
	}

	/**
	 * o Get test name for current thread
	 */
	public static String getTestName() {
		return testName.get();
	}

	/**
	 * o Remove WebDriver from current thread
	 */
	public static void removeWebDriver() {
		webDriver.remove();
	}

	/**
	 * o Remove AppiumDriver from current thread
	 */
	public static void removeAppiumDriver() {
		appiumDriver.remove();
	}

	/**
	 * o Remove session ID from current thread
	 */
	public static void removeSessionId() {
		sessionId.remove();
	}

	/**
	 * o Remove test name from current thread
	 */
	public static void removeTestName() {
		testName.remove();
	}

	/**
	 * o Remove all thread-local variables for current thread o Call this in test
	 * teardown to prevent memory leaks
	 */
	public static void removeAll() {
		removeWebDriver();
		removeAppiumDriver();
		removeSessionId();
		removeTestName();
	}
}
