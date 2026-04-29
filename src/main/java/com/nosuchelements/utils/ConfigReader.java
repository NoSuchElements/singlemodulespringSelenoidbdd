package com.nosuchelements.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Configuration Reader
 * Reads values from application.properties using Spring @Value
 */
@Component
public class ConfigReader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

    // Browser Configuration
    @Value("${browser.type:chrome}")
    private String browserType;

    @Value("${browser.headless:false}")
    private boolean headless;

    @Value("${browser.timeout:30}")
    private int timeout;

    @Value("${browser.window.maximize:true}")
    private boolean maximizeWindow;

    @Value("${browser.version:}")
    private String browserVersion;

    // Mobile Configuration
    @Value("${mobile.platform:android}")
    private String mobilePlatform;

    @Value("${mobile.device:}")
    private String mobileDevice;

    @Value("${mobile.app:}")
    private String mobileApp;

    @Value("${mobile.browser:chrome}")
    private String mobileBrowser;

    // Cloud Configuration
    @Value("${cloud.enabled:false}")
    private boolean cloudEnabled;

    @Value("${cloud.provider:}")
    private String cloudProvider;

    @Value("${saucelabs.username:}")
    private String saucelabsUsername;

    @Value("${saucelabs.accesskey:}")
    private String saucelabsAccessKey;

    // API Configuration
    @Value("${api.base.url:https://reqres.in}")
    private String apiBaseUrl;

    @Value("${api.timeout:30}")
    private int apiTimeout;

    // Logging Configuration
    @Value("${logging.level:info}")
    private String loggingLevel;

    @Value("${logging.screenshot.enabled:true}")
    private boolean screenshotEnabled;

    // Getter methods
    public String getBrowserType() { return browserType; }
    public boolean isHeadless() { return headless; }
    public int getTimeout() { return timeout; }
    public boolean isMaximizeWindow() { return maximizeWindow; }
    public String getBrowserVersion() { return browserVersion; }
    public String getMobilePlatform() { return mobilePlatform; }
    public String getMobileDevice() { return mobileDevice; }
    public String getMobileApp() { return mobileApp; }
    public String getMobileBrowser() { return mobileBrowser; }
    public boolean isCloudEnabled() { return cloudEnabled; }
    public String getCloudProvider() { return cloudProvider; }
    public String getSaucelabsUsername() { return saucelabsUsername; }
    public String getSaucelabsAccessKey() { return saucelabsAccessKey; }
    public String getApiBaseUrl() { return apiBaseUrl; }
    public int getApiTimeout() { return apiTimeout; }
    public String getLoggingLevel() { return loggingLevel; }
    public boolean isScreenshotEnabled() { return screenshotEnabled; }

    /**
     * Log all configuration on startup
     */
    public void logConfiguration() {
        logger.info("========================================");
        logger.info("Framework Configuration");
        logger.info("========================================");
        logger.info("Browser: {} (headless: {})", browserType, headless);
        logger.info("Timeout: {}s", timeout);
        logger.info("Mobile Platform: {}", mobilePlatform);
        logger.info("Cloud Enabled: {}", cloudEnabled);
        if (cloudEnabled) {
            logger.info("Cloud Provider: {}", cloudProvider);
        }
        logger.info("API Base URL: {}", apiBaseUrl);
        logger.info("========================================");
    }
}