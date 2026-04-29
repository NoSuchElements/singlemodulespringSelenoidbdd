package com.nosuchelements.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertyConfig {
	// Sauce Labs Configuration
	@Value("${sauce.username:}")
	private String sauceUsername;
	@Value("${sauce.accesskey:}")
	private String sauceAccessKey;
	@Value("${sauce.region:us-west-1}")
	private String sauceRegion;
	@Value("${sauce.build:single-singlemodulespringbdd-1.0.0-LOCAL}")
	private String sauceBuild;
	@Value("${sauce.url:}")
	private String sauceUrl;
	// Browser Configuration
	@Value("${browser:chrome}")
	private String browser;
	// Platform Configuration
	@Value("${platform:WEB}")
	private String platform;
	@Value("${execution.mode:LOCAL}")
	private String executionMode;
	@Value("${appLang:ENGLISH}")
	private String appLanguage;
	// Mobile Configuration
	@Value("${mobile.platform:android}")
	private String mobilePlatform;
	@Value("${mobile.device.android:}")
	private String mobileDeviceAndroid;
	@Value("${mobile.version.android:}")
	private String mobileVersionAndroid;
	@Value("${mobile.device.iphone:}")
	private String mobileDeviceIphone;
	@Value("${mobile.version.iphone:}")
	private String mobileVersionIphone;
	@Value("${mobile.app.package:}")
	private String mobileAppPackage;
	@Value("${mobile.app.activity:}")
	private String mobileAppActivity;

	@Value("${mobile.app.path:}")
	private String mobileAppPath;
	// API Configuration
	@Value("${api.base.url:https://reqres.in}")
	private String apiBaseUrl;
	// Timeout Configuration
	@Value("${implicit.wait:10}")
	private int implicitWait;
	@Value("${explicit.wait:20}")
	private int explicitWait;
	@Value("${page.load.timeout:30}")
	private int pageLoadTimeout;
	
	public String getSauceUsername() {
		String envUsername = System.getenv("SAUCE_USERNAME");
		return envUsername != null && !envUsername.isEmpty() ? envUsername : sauceUsername;
	}

	public String getSauceAccessKey() {
		String envAccessKey = System.getenv("SAUCE_ACCESS_KEY");
		return envAccessKey != null && !envAccessKey.isEmpty() ? envAccessKey : sauceAccessKey;
	}

	public String getSauceRegion() {
		return sauceRegion;
	}

	public String getSauceBuild() {
		return sauceBuild;
	}
	
	public String getSauceUrl() {
		return sauceUrl;
	}

	public String getBrowser() {
		return System.getProperty("browser", browser);
	}

	/**
	 * a. Get platform with system property override
	 */
	public String getPlatform() {
		return System.getProperty("platform", platform).toUpperCase();
	}

	/**
	 * a. Get execution mode with system property override
	 */
	public String getExecutionMode() {
		return System.getProperty("execution.mode", executionMode).toUpperCase();
	}
	
	public String getLanguage() {
		return System.getProperty("appLang", appLanguage).toUpperCase();
	}

	public String getMobilePlatform() {
		return System.getProperty("mobile.platform", mobilePlatform).toLowerCase();
	}

	public String getMobileDeviceAndroid() {
		return System.getProperty("mobile.device.android", mobileDeviceAndroid);
	}

	public String getMobileVersionAndroid() {
		return System.getProperty("mobile.version.android", mobileVersionAndroid);
	}


	public String getMobileDeviceIphone() {
		return System.getProperty("mobile.device.iphone", mobileDeviceIphone);
	}

	public String getMobileVersionIphone() {
		return System.getProperty("mobile.version.iphone", mobileVersionIphone);
	}
	public String getMobileAppPackage() {
		return System.getProperty("mobile.app.package", mobileAppPackage);
	}

	public String getMobileAppActivity() {
		return System.getProperty("mobile.app.activity", mobileAppActivity);
	}

	public String getMobileAppPath() {
		return System.getProperty("mobile.app.path", mobileAppPath);
	}

	public String getApiBaseUrl() {
		return System.getProperty("api.base.url", apiBaseUrl);
	}

	public int getImplicitWait() {
		return implicitWait;
	}

	public int getExplicitWait() {
		return explicitWait;
	}

	public int getPageLoadTimeout() {
		return pageLoadTimeout;
	}

	// Helper methods for checking execution context
	/**
	 * a. Check if execution is on Sauce Labs
	 */
	public boolean isSauceLabs() {
		return "SAUCELABS".equalsIgnoreCase(getExecutionMode());
	}

	/**
	 * a. Check if platform is Web
	 */
	public boolean isWeb() {
		return "WEB".equalsIgnoreCase(getPlatform());
	}

	/**
	 * a. Check if platform is Mobile
	 */
	public boolean isMobile() {
		return "MOBILE".equalsIgnoreCase(getPlatform());
	}

	/**
	 * a. Check if platform is API
	 */
	public boolean isApi() {
		return "API".equalsIgnoreCase(getPlatform());
	}

	/**
	 * a. Get Sauce Labs URL with credentials
	 */
	public String getSauceLabsUrl() {
		return String.format("http://%s:%s@%s", getSauceUsername(), getSauceAccessKey(), getSauceUrl());
	}

}
