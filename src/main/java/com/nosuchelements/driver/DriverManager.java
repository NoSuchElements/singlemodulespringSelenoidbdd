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
 * Central Driver Manager - platform-aware orchestrator for Web, Mobile, and API channels.
 *
 * Delegates driver creation to:
 *   WebDriverManager    - web channel (LOCAL / SELENOID / SAUCELABS)
 *   AppiumDriverManager - mobile channel (Android / iOS)
 *
 * Responsibilities:
 *   - Platform routing (WEB / MOBILE / API)
 *   - Timeout configuration
 *   - Session info logging incl. Selenoid VNC and video URLs
 *   - Remote status reporting (Sauce Labs + Selenoid)
 *   - Thread-safe teardown via ThreadLocalDriver.removeAll()
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

    private static final ThreadLocal<Boolean> isMobileThread = new ThreadLocal<>();

    // ── Driver Initialization ────────────────────────────────────────────────────

    public void initializeDriver(String testName) {
        String platform = propertyConfig.getPlatform();
        logger.info("");
        logger.info("Initializing driver - platform: {} | mode: {} | test: {}",
                platform, propertyConfig.getExecutionMode(), testName);
        logger.info("");

        Supplier<WebDriver> driverSupplier = () -> {
            switch (platform) {
                case "WEB":
                    isMobileThread.set(false);
                    return webDriverManager.createDriver(testName);
                case "MOBILE":
                    isMobileThread.set(true);
                    return appiumDriverManager.createMobileDriver(testName);
                case "API":
                    logger.info("API testing - no WebDriver required");
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

    // ── Driver Configuration ──────────────────────────────────────────────────────

    private void configureDriver(WebDriver driver) {
        logger.debug("Configuring driver timeouts");
        Consumer<WebDriver> configureTimeouts = d -> {
            d.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertyConfig.getImplicitWait()));
            d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(propertyConfig.getPageLoadTimeout()));
            d.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        };
        configureTimeouts.accept(driver);
        logger.info("Driver timeouts set - implicit: {}s | pageLoad: {}s",
                propertyConfig.getImplicitWait(), propertyConfig.getPageLoadTimeout());
    }

    // ── Session Info Logging ──────────────────────────────────────────────────────

    /**
     * Logs session metadata after driver creation.
     * - Sauce Labs: prints app.saucelabs.com test dashboard URL
     * - Selenoid:   prints VNC live-view and video recording URLs
     */
    private void storeSessionInfo(WebDriver driver) {
        if (driver instanceof RemoteWebDriver) {
            String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
            ThreadLocalDriver.setSessionId(sessionId);
            logger.info("Remote session ID: {}", sessionId);

            if (propertyConfig.isSauceLabs()) {
                String sauceDashboard = String.format("https://app.saucelabs.com/tests/%s", sessionId);
                logger.info("Sauce Labs dashboard: {}", sauceDashboard);
            }

            if (propertyConfig.isGrid()) {
                String vncUrl   = ThreadLocalDriver.getGridVncUrl();
                String videoUrl = ThreadLocalDriver.getGridVideoUrl();
                if (vncUrl   != null) logger.info("Selenoid VNC:   {}", vncUrl);
                if (videoUrl != null) logger.info("Selenoid Video: {}", videoUrl);
            }
        }
    }

    // ── Driver Access ─────────────────────────────────────────────────────────────

    public WebDriver getDriver() {
        WebDriver driver = ThreadLocalDriver.getWebDriver();
        if (driver == null) {
            driver = ThreadLocalDriver.getAppiumDriver();
        }
        return driver;
    }

    public AppiumDriver getAppiumDriver() {
        return ThreadLocalDriver.getAppiumDriver();
    }

    public JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    public synchronized Boolean isMobile() {
        return isMobileThread.get();
    }

    // ── Teardown ──────────────────────────────────────────────────────────────────

    public void quitDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            try {
                logger.info("Quitting driver - session: {} | thread: {}",
                        ThreadLocalDriver.getSessionId(), Thread.currentThread().getName());
                driver.quit();
                logger.info("Driver quit successfully");
            } catch (Exception e) {
                logger.error("Error quitting driver", e);
            } finally {
                ThreadLocalDriver.removeAll();
                logger.debug("ThreadLocal variables cleared for thread: {}",
                        Thread.currentThread().getName());
            }
        } else {
            logger.debug("No active driver to quit");
        }
    }

    // ── Remote Status Reporting ───────────────────────────────────────────────────

    /**
     * Updates test result on remote providers after scenario completion.
     *   Sauce Labs - uses sauce:job-result JS command
     *   Selenoid   - no JS command needed; result captured in Allure/PDF/Extent reports
     */
    public void updateRemoteStatus(boolean passed) {
        WebDriver driver = getDriver();
        if (!(driver instanceof RemoteWebDriver)) return;

        if (propertyConfig.isSauceLabs()) {
            try {
                String status = passed ? "passed" : "failed";
                ((RemoteWebDriver) driver).executeScript("sauce:job-result=" + status);
                logger.info("Sauce Labs job status updated: {}", status.toUpperCase());
            } catch (Exception e) {
                logger.error("Failed to update Sauce Labs status", e);
            }
        }

        if (propertyConfig.isGrid()) {
            logger.info("Selenoid test '{}' completed - status: {} | Video: {}",
                    ThreadLocalDriver.getTestName(),
                    passed ? "PASSED" : "FAILED",
                    ThreadLocalDriver.getGridVideoUrl());
        }
    }

    /** @deprecated Use updateRemoteStatus(boolean) - supports Sauce Labs and Selenoid */
    @Deprecated
    public void updateSauceLabsStatus(boolean passed) {
        updateRemoteStatus(passed);
    }
}
