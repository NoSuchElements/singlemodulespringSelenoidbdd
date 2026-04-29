package com.nosuchelements.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.MutableCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nosuchelements.config.MobileDriverConfig;
import com.nosuchelements.config.PropertyConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;

/**
 * • Appium Driver Manager • Creates and manages AppiumDriver instances for
 * mobile testing • Features: o Android and iOS support o Real device and
 * emulator/simulator support o Lambda expression support o Local and Sauce Labs
 * execution
 */
@Component
public class AppiumDriverManager {
	private static final Logger logger = LoggerFactory.getLogger(AppiumDriverManager.class);
	@Autowired
	private PropertyConfig propertyConfig;
	@Autowired
	private MobileDriverConfig mobileDriverConfig;

	/**
	 * o Create Mobile Driver instance o Lambda expression ready for functional
	 * programming
	 */
	public AppiumDriver createMobileDriver(String testName) {
		String mobilePlatform = propertyConfig.getMobilePlatform();
		boolean isSauceLabs = propertyConfig.isSauceLabs();
		logger.info("Creating Mobile Driver - Platform: {}, SauceLabs: {}, Test: {}", mobilePlatform, isSauceLabs,
				testName);
		// Lambda supplier for driver creation
		Supplier<AppiumDriver> driverSupplier = () -> {
			if ("android".equalsIgnoreCase(mobilePlatform)) {
				return createAndroidDriver(testName);
			} else if ("ios".equalsIgnoreCase(mobilePlatform)) {
				return createIOSDriver(testName);
			} else {
				throw new IllegalArgumentException("Unsupported mobile platform: " + mobilePlatform);
			}
		};
		AppiumDriver driver = driverSupplier.get();
		// Store in ThreadLocal
		ThreadLocalDriver.setAppiumDriver(driver);
		ThreadLocalDriver.setTestName(testName);
		logger.info("Mobile Driver created successfully");
		return driver;
	}

	/**
	 * o Create Android driver (browser or app)
	 */
	private AppiumDriver createAndroidDriver(String testName) {
		try {
			URL appiumUrl = getAppiumUrl();
			MutableCapabilities capabilities;
			// Determine if app or browser testing
			String appPackage = propertyConfig.getMobileAppPackage();
			if (appPackage != null && !appPackage.isEmpty()) {
				logger.debug("Creating Android app driver");
				capabilities = mobileDriverConfig.getAndroidAppCapabilities(testName);
			} else {
				logger.debug("Creating Android browser driver");
				capabilities = mobileDriverConfig.getAndroidBrowserCapabilities(testName);
			}

			return new AndroidDriver(appiumUrl, capabilities);

		} catch (MalformedURLException e) {
			logger.error("Invalid Appium URL", e);
			throw new RuntimeException("Invalid Appium URL", e);
		}
	}

	/**
	 * o Create iOS driver (browser or app)
	 */
	private AppiumDriver createIOSDriver(String testName) {
		try {
			URL appiumUrl = getAppiumUrl();
			MutableCapabilities capabilities;
			// Determine if app or browser testing
			String appPath = propertyConfig.getMobileAppPath();
			if (appPath != null && !appPath.isEmpty()) {
				logger.debug("Creating iOS app driver");
				capabilities = mobileDriverConfig.getIOSAppCapabilities(testName);
			} else {
				logger.debug("Creating iOS browser driver");
				capabilities = mobileDriverConfig.getIOSBrowserCapabilities(testName);
			}

			return new IOSDriver(appiumUrl, capabilities);

		} catch (MalformedURLException e) {
			logger.error("Invalid Appium URL", e);
			throw new RuntimeException("Invalid Appium URL", e);
		}
	}

	/**
	 * o Get Appium server URL based on execution mode
	 */
	private URL getAppiumUrl() throws MalformedURLException {
		if (propertyConfig.isSauceLabs()) {
			logger.debug("Using Sauce Labs Appium URL");
			return new URL(propertyConfig.getSauceLabsUrl());
		} else {
			logger.debug("Using local Appium server URL");
			return new URL("http://127.0.0.1:4723");
		}
	}
}
