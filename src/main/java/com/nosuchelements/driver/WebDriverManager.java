package com.nosuchelements.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nosuchelements.config.PropertyConfig;
import com.nosuchelements.config.WebDriverConfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;

/**
 * • WebDriver Manager • Creates and manages WebDriver instances for web testing
 * • Features: o Local and remote driver support o Browser-specific
 * configurations o Lambda expression support o ThreadLocal storage
 */
@Component
public class WebDriverManager {
	private static final Logger logger = LoggerFactory.getLogger(WebDriverManager.class);
	@Autowired
	private PropertyConfig propertyConfig;
	@Autowired
	private WebDriverConfig webDriverConfig;

	/**
	 * o Create WebDriver instance based on configuration o Uses lambda expression
	 * for functional driver creation
	 */
	public WebDriver createDriver(String testName) {
		String browser = propertyConfig.getBrowser();
		boolean isSauceLabs = propertyConfig.isSauceLabs();
		logger.info("Creating WebDriver - Browser: {}, SauceLabs: {}, Test: {}", browser, isSauceLabs, testName);
		// Lambda supplier for driver creation
		Supplier<WebDriver> driverSupplier = () -> isSauceLabs ? createRemoteDriver(testName, browser)
				: createLocalDriver(browser);
		WebDriver driver = driverSupplier.get();
		// Store in ThreadLocal
		ThreadLocalDriver.setWebDriver(driver);
		ThreadLocalDriver.setTestName(testName);
		logger.info("WebDriver created successfully");
		return driver;
	}

	/**
	 * o Create local WebDriver instance
	 */
	private WebDriver createLocalDriver(String browser) {
		logger.debug("Creating local {} driver", browser);
		webDriverConfig.setupDriver(browser);
		switch (browser.toLowerCase()) {
		case "chrome":
			return new ChromeDriver(webDriverConfig.getChromeOptions());
		case "firefox":
			return new FirefoxDriver(webDriverConfig.getFirefoxOptions());
		case "edge":
			return new EdgeDriver(webDriverConfig.getEdgeOptions());
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
	}

	/**
	 * o Create remote WebDriver instance for Sauce Labs
	 */
	private WebDriver createRemoteDriver(String testName, String browser) {
		logger.debug("Creating remote {} driver on Sauce Labs", browser);
		try {
			URL sauceUrl = new URL(propertyConfig.getSauceLabsUrl());
			return new RemoteWebDriver(sauceUrl, webDriverConfig.getSauceLabsCapabilities(testName, browser));
		} catch (MalformedURLException e) {
			logger.error("Invalid Sauce Labs URL", e);
			throw new RuntimeException("Invalid Sauce Labs URL", e);
		}
	}
}
