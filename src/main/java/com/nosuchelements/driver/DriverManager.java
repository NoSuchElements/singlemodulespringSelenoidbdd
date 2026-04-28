package com.nosuchelements.driver;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nosuchelements.config.PropertyConfig;

import io.appium.java_client.AppiumDriver;

/**
 * • Central Driver Manager • Coordinates between Web and Mobile drivers •
 * Lambda expression ready for functional programming • Features: o
 * Platform-agnostic driver initialization o Timeout configuration o Session
 * tracking o Sauce Labs integration o Thread-safe operations
 */
@Component
public class DriverManager {
	private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);
	@Autowired
	private PropertyConfig propertyConfig;
	@Autowired
	private WebDriverManager webDriverManager;
	@Autowired
	private AppiumDriverManager appiumDriverManager;
	
	private static final ThreadLocal<Boolean> isMobile = new ThreadLocal<>();

	/**
	 * o Initialize driver based on platform configuration o Lambda-friendly method
	 * using Supplier
	 */
	public void initializeDriver(String testName) {
		String platform = propertyConfig.getPlatform();
		logger.info("");
		logger.info("Initializing driver for platform: {}", platform);
		logger.info("Test name: {}", testName);
		logger.info("");
		// Lambda expression for driver initialization
		Supplier<WebDriver> driverSupplier = () -> {
			switch (platform) {
			case "WEB":
				isMobile.set(false);
				return webDriverManager.createDriver(testName);
			case "MOBILE":
				isMobile.set(true);
				return appiumDriverManager.createMobileDriver(testName);
			case "API":
				logger.info("API testing - no driver needed");
				return null;
			default:
				throw new IllegalArgumentException("Unsupported platform: " + platform);
			}
		};
		WebDriver driver = driverSupplier.get();
		if (driver != null) {
			configureDriver(driver);
			storeSessionInfo(driver);
		}
	}

	/**
	 * o Configure driver timeouts - Lambda expression ready
	 */
	private void configureDriver(WebDriver driver) {
		logger.debug("Configuring driver timeouts");
		// Using lambda for timeout configuration
		Consumer<WebDriver> configureTimeouts = d -> {
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertyConfig.getImplicitWait()));
			d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(propertyConfig.getPageLoadTimeout()));
			d.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		};
		configureTimeouts.accept(driver);
		logger.info("Driver timeouts configured - Implicit: {}s, PageLoad: {}s", propertyConfig.getImplicitWait(),
				propertyConfig.getPageLoadTimeout());
	}

	/**
	 * o Store session information for reporting
	 */
	private void storeSessionInfo(WebDriver driver) {
		if (driver instanceof RemoteWebDriver) {
			String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
			ThreadLocalDriver.setSessionId(sessionId);
			logger.info("Session ID: {}", sessionId);

			if (propertyConfig.isSauceLabs()) {
				String sauceUrl = String.format("https://app.saucelabs.com/tests/%s", sessionId);
				logger.info("Sauce Labs Test URL: {}", sauceUrl);
			}

		}
	}

	/**
	 * o Get current WebDriver instance o Returns WebDriver or AppiumDriver based on
	 * platform
	 */
	public WebDriver getDriver() {
		System.out.println("inside get driver method");
		WebDriver driver = ThreadLocalDriver.getWebDriver();
		if (driver == null) {
			driver = ThreadLocalDriver.getAppiumDriver();
		}
		return driver;
	}

	/**
	 * o Get AppiumDriver instance (mobile specific)
	 */
	public AppiumDriver getAppiumDriver() {
		return ThreadLocalDriver.getAppiumDriver();
	}

	/**
	 * o Quit driver and clean up resources
	 */
	public void quitDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			try {
				String sessionId = ThreadLocalDriver.getSessionId();
				logger.info("Quitting driver for session: {}", sessionId);
				driver.quit();
				logger.info("Driver quit successfully");
			} catch (Exception e) {
				logger.error("Error quitting driver", e);
			} finally {
				ThreadLocalDriver.removeAll();
				logger.debug("ThreadLocal variables cleared");
			}

		} else {
			logger.debug("No driver to quit");
		}
	}

	/**
	 * o Update Sauce Labs test status o Lambda expression for status update
	 */
	public void updateSauceLabsStatus(boolean passed) {
		if (!propertyConfig.isSauceLabs()) {
			logger.debug("Not running on Sauce Labs - skipping status update");
			return;
		}
		WebDriver driver = getDriver();
		if (driver instanceof RemoteWebDriver) {
			// Lambda expression for status update
			Runnable updateStatus = () -> {
				try {
					String status = passed ? "passed" : "failed";
					((RemoteWebDriver) driver).executeScript("sauce:job-result=" + status);
					logger.info("Updated Sauce Labs status: {}", status.toUpperCase());
				} catch (Exception e) {
					logger.error("Failed to update Sauce Labs status", e);
				}
			};
			updateStatus.run();

		}
	}
	
	public JavascriptExecutor getJSExecutor() {
		return (JavascriptExecutor) getDriver();
	}
	
	public synchronized Boolean isMobile() {
		return isMobile.get();
	}
}
