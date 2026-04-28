package com.nosuchelements.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;


	@Component
	public class WebDriverConfig {
		@Autowired
		private PropertyConfig propertyConfig;

		/**
		 * o Setup WebDriver using WebDriverManager
		 */
		public void setupDriver(String browser) {
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
		}

		/**
		 * o Get Chrome options with optimizations
		 */
		public ChromeOptions getChromeOptions() {
			ChromeOptions options = new ChromeOptions();
			// Window management
			options.addArguments("--start-maximized");
			options.addArguments("--disable-blink-features=AutomationControlled");
			// Performance optimizations
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-gpu");
			// Disable password manager
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			// Remove automation flags
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.setExperimentalOption("useAutomationExtension", false);
			return options;
		}

		/**
		 * o Get Firefox options
		 */
		public FirefoxOptions getFirefoxOptions() {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--width=1920");
			options.addArguments("--height=1080");
			return options;
		}

		/**
		 * o Get Edge options
		 */
		public EdgeOptions getEdgeOptions() {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-blink-features=AutomationControlled");
			return options;
		}

		/**
		 * o Get Sauce Labs capabilities for web testing
		 */
		public MutableCapabilities getSauceLabsCapabilities(String testName, String browser) {
			MutableCapabilities capabilities = new MutableCapabilities();
			// Browser configuration
			capabilities.setCapability("browserName", browser);
			capabilities.setCapability("browserVersion", "latest");
			capabilities.setCapability("platformName", "Windows 11");
			// Sauce Labs options
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("name", testName);
			sauceOptions.put("build", propertyConfig.getSauceBuild());
			sauceOptions.put("username", propertyConfig.getSauceUsername());
			sauceOptions.put("accessKey", propertyConfig.getSauceAccessKey());
			sauceOptions.put("idleTimeout", 300);
			sauceOptions.put("maxDuration", 3600);
			sauceOptions.put("screenResolution", "1920x1080");
			capabilities.setCapability("sauce:options", sauceOptions);
			return capabilities;
		}
	}
