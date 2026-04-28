package com.nosuchelements.config;

import org.openqa.selenium.MutableCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class MobileDriverConfig {
	@Autowired
	private PropertyConfig propertyConfig;

	/**
	 * o Get Android browser capabilities (Chrome)
	 */
	public MutableCapabilities getAndroidBrowserCapabilities(String testName) {
		MutableCapabilities capabilities = new MutableCapabilities();
		// Platform configuration
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("appium:platformVersion",
				getVersionOrDefault(propertyConfig.getMobileVersionAndroid(), "13.0"));
		capabilities.setCapability("appium:deviceName",
				getDeviceOrDefault(propertyConfig.getMobileDeviceAndroid(), "Android GoogleAPI Emulator"));
		// Appium settings
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:newCommandTimeout", 300);
		capabilities.setCapability("appium:autoGrantPermissions", true);
		// Chrome options for mobile
		Map<String, Object> chromeOptions = new HashMap<>();
		chromeOptions.put("w3c", true);
		capabilities.setCapability("goog:chromeOptions", chromeOptions);
		if (propertyConfig.isSauceLabs()) {
			addSauceLabsOptions(capabilities, testName);
		}
		return capabilities;
	}

	/**
	 * o Get Android app capabilities
	 */
	public MutableCapabilities getAndroidAppCapabilities(String testName) {
		MutableCapabilities capabilities = new MutableCapabilities();
		// Platform configuration
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appium:platformVersion",
				getVersionOrDefault(propertyConfig.getMobileVersionAndroid(), "13.0"));
		capabilities.setCapability("appium:deviceName",
				getDeviceOrDefault(propertyConfig.getMobileDeviceAndroid(), "Android GoogleAPI Emulator"));
		// App configuration
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:appPackage", propertyConfig.getMobileAppPackage());
		capabilities.setCapability("appium:appActivity", propertyConfig.getMobileAppActivity());
		capabilities.setCapability("appium:newCommandTimeout", 300);
		capabilities.setCapability("appium:autoGrantPermissions", true);
		// App path if provided
		String appPath = propertyConfig.getMobileAppPath();
		if (appPath != null && !appPath.isEmpty()) {
			capabilities.setCapability("appium:app", appPath);
		}
		if (propertyConfig.isSauceLabs()) {
			addSauceLabsOptions(capabilities, testName);
		}
		return capabilities;
	}

	/**
	 * o Get iOS browser capabilities (Safari)
	 */
	public MutableCapabilities getIOSBrowserCapabilities(String testName) {
		MutableCapabilities capabilities = new MutableCapabilities();
		// Platform configuration
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("browserName", "Safari");
		capabilities.setCapability("appium:platformVersion",
				getVersionOrDefault(propertyConfig.getMobileVersionIphone(), "17.5"));
		capabilities.setCapability("appium:deviceName",
				getDeviceOrDefault(propertyConfig.getMobileDeviceIphone(), "iPhone Simulator"));
		// Appium settings
		capabilities.setCapability("appium:automationName", "XCUITest");
		capabilities.setCapability("appium:newCommandTimeout", 300);
		capabilities.setCapability("appium:autoWebview", false);
	    capabilities.setCapability("appium:noReset", true);
		capabilities.setCapability("appium:autoAcceptAlerts", true);
		if (propertyConfig.isSauceLabs()) {
			addSauceLabsOptions(capabilities, testName);
		}
		return capabilities;
	}

	/**
	 * o Get iOS app capabilities
	 */
	public MutableCapabilities getIOSAppCapabilities(String testName) {
		MutableCapabilities capabilities = new MutableCapabilities();
		// Platform configuration
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("appium:platformVersion",
				getVersionOrDefault(propertyConfig.getMobileVersionIphone(), "17.0"));
		capabilities.setCapability("appium:deviceName",
				getDeviceOrDefault(propertyConfig.getMobileDeviceIphone(), "iPhone 15 Simulator"));
		// App configuration
		capabilities.setCapability("appium:automationName", "XCUITest");
		capabilities.setCapability("appium:newCommandTimeout", 300);
		capabilities.setCapability("appium:autoAcceptAlerts", true);
		// App path
		String appPath = propertyConfig.getMobileAppPath();
		if (appPath != null && !appPath.isEmpty()) {
			capabilities.setCapability("appium:app", appPath);
		}
		if (propertyConfig.isSauceLabs()) {
			addSauceLabsOptions(capabilities, testName);
		}
		return capabilities;
	}

	/**
	 * o Add Sauce Labs specific options
	 */
	private void addSauceLabsOptions(MutableCapabilities capabilities, String testName) {
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("name", testName);
		sauceOptions.put("build", propertyConfig.getSauceBuild());
		sauceOptions.put("username", propertyConfig.getSauceUsername());
		sauceOptions.put("accessKey", propertyConfig.getSauceAccessKey());
		sauceOptions.put("idleTimeout", 300);
		sauceOptions.put("maxDuration", 3600);
		capabilities.setCapability("sauce:options", sauceOptions);
	}

	/**
	 * o Get version with default fallback
	 */
	private String getVersionOrDefault(String version, String defaultVersion) {
		return (version == null || version.isEmpty()) ? defaultVersion : version;
	}

	/**
	 * o Get device with default fallback
	 */
	private String getDeviceOrDefault(String device, String defaultDevice) {
		return (device == null || device.isEmpty()) ? defaultDevice : device;
	}
}
