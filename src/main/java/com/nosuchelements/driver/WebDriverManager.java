package com.nosuchelements.driver;

import com.nosuchelements.config.PropertyConfig;
import com.nosuchelements.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;

/**
 * WebDriver Manager - creates thread-safe WebDriver instances.
 *
 * Routing logic (controlled by execution.mode property):
 *   LOCAL     - local ChromeDriver / FirefoxDriver / EdgeDriver
 *   SELENOID  - RemoteWebDriver routed to Selenoid/Grid at grid.url
 *   SAUCELABS - RemoteWebDriver routed to Sauce Labs cloud
 *
 * After creation all instances are stored in ThreadLocalDriver so that
 * parallel scenarios each get a fully isolated driver and session context.
 */
@Component
public class WebDriverManager {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverManager.class);

    @Autowired
    private PropertyConfig propertyConfig;

    @Autowired
    private WebDriverConfig webDriverConfig;

    // ── Public factory method ─────────────────────────────────────────────────────
    public WebDriver createDriver(String testName) {
        String  browser     = propertyConfig.getBrowser();
        boolean isSauceLabs = propertyConfig.isSauceLabs();
        boolean isGrid      = propertyConfig.isGrid();

        logger.info("Creating WebDriver - Browser: {}, ExecutionMode: {}, Test: {}",
                browser, propertyConfig.getExecutionMode(), testName);

        Supplier<WebDriver> driverSupplier = () -> {
            if (isSauceLabs) return createSauceDriver(testName, browser);
            if (isGrid)      return createGridDriver(testName, browser);
            return createLocalDriver(browser);
        };

        WebDriver driver = driverSupplier.get();
        ThreadLocalDriver.setWebDriver(driver);
        ThreadLocalDriver.setTestName(testName);

        // Store remote session metadata for reporting / Selenoid UI deep-links
        if (driver instanceof RemoteWebDriver) {
            String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
            ThreadLocalDriver.setSessionId(sessionId);

            if (isGrid) {
                String videoUrl = propertyConfig.getGridVideoBaseUrl() + "/video/" + sessionId + ".mp4";
                String vncUrl   = propertyConfig.getGridVideoBaseUrl() + "/vnc/"   + sessionId;
                ThreadLocalDriver.setGridVideoUrl(videoUrl);
                ThreadLocalDriver.setGridVncUrl(vncUrl);
                logger.info("Selenoid session started - ID: {} | VNC: {} | Video: {}",
                        sessionId, vncUrl, videoUrl);
            }
        }

        logger.info("WebDriver created successfully for test: {}", testName);
        return driver;
    }

    // ── Private factory methods ────────────────────────────────────────────────────

    /** Local ChromeDriver / FirefoxDriver / EdgeDriver via bonigarcia WDM */
    private WebDriver createLocalDriver(String browser) {
        logger.debug("Creating local {} driver", browser);
        webDriverConfig.setupDriver(browser);
        switch (browser.toLowerCase()) {
            case "chrome":  return new ChromeDriver(webDriverConfig.getChromeOptions());
            case "firefox": return new FirefoxDriver(webDriverConfig.getFirefoxOptions());
            case "edge":    return new EdgeDriver(webDriverConfig.getEdgeOptions());
            default: throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    /** RemoteWebDriver pointed at Sauce Labs cloud */
    private WebDriver createSauceDriver(String testName, String browser) {
        logger.debug("Creating remote {} driver on Sauce Labs", browser);
        try {
            URL sauceUrl = new URL(propertyConfig.getSauceLabsUrl());
            return new RemoteWebDriver(sauceUrl,
                    webDriverConfig.getSauceLabsCapabilities(testName, browser));
        } catch (MalformedURLException e) {
            logger.error("Invalid Sauce Labs URL: {}", propertyConfig.getSauceLabsUrl(), e);
            throw new RuntimeException("Invalid Sauce Labs URL", e);
        }
    }

    /** RemoteWebDriver pointed at Selenoid / generic Selenium Grid */
    private WebDriver createGridDriver(String testName, String browser) {
        logger.debug("Creating remote {} driver on Selenoid/Grid at {}",
                browser, propertyConfig.getGridUrl());
        try {
            URL gridUrl = new URL(propertyConfig.getGridUrl());
            return new RemoteWebDriver(gridUrl,
                    webDriverConfig.getSelenoidCapabilities(testName, browser));
        } catch (MalformedURLException e) {
            logger.error("Invalid Grid/Selenoid URL: {}", propertyConfig.getGridUrl(), e);
            throw new RuntimeException("Invalid Grid/Selenoid URL", e);
        }
    }
}
