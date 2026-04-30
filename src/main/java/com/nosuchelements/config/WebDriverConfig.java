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

/**
 * WebDriver Configuration - builds browser options and remote capabilities.
 *
 * Supports three execution targets:
 *   1. Local      - ChromeDriver / FirefoxDriver / EdgeDriver via bonigarcia WDM
 *   2. Sauce Labs - MutableCapabilities with sauce:options vendor extension
 *   3. Selenoid   - browser options merged with selenoid:options vendor extension
 *                   (VNC, video recording, sessionTimeout, screenResolution)
 */
@Component
public class WebDriverConfig {

    @Autowired
    private PropertyConfig propertyConfig;

    // ── Local Driver Setup ────────────────────────────────────────────────────────
    public void setupDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":  WebDriverManager.chromedriver().setup();  break;
            case "firefox": WebDriverManager.firefoxdriver().setup(); break;
            case "edge":    WebDriverManager.edgedriver().setup();    break;
            default: throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    // ── Browser Options ───────────────────────────────────────────────────────────
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        return options;
    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        return options;
    }

    public EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        return options;
    }

    // ── Sauce Labs Capabilities ──────────────────────────────────────────────────
    public MutableCapabilities getSauceLabsCapabilities(String testName, String browser) {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("platformName", "Windows 11");
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

    // ── Selenoid / Grid Capabilities ─────────────────────────────────────────────
    /**
     * Builds browser capabilities with Selenoid vendor options.
     * Uses the "selenoid:options" key as defined in the Aerokube Selenoid specification.
     *
     * Capabilities set:
     *   name             - test/scenario label shown in Selenoid UI
     *   enableVNC        - enables live VNC session viewer in Selenoid UI
     *   enableVideo      - records an MP4 video of the browser session
     *   screenResolution - WxHxDepth (e.g. 1920x1080x24)
     *   sessionTimeout   - idle timeout before Selenoid kills the session
     *
     * @param testName  scenario or test name used as Selenoid session label
     * @param browser   target browser: chrome | firefox | edge
     * @return MutableCapabilities ready for new RemoteWebDriver(url, caps)
     */
    public MutableCapabilities getSelenoidCapabilities(String testName, String browser) {
        MutableCapabilities browserCaps;
        switch (browser.toLowerCase()) {
            case "chrome":  browserCaps = getChromeOptions();  break;
            case "firefox": browserCaps = getFirefoxOptions(); break;
            case "edge":    browserCaps = getEdgeOptions();    break;
            default: throw new IllegalArgumentException("Unsupported browser for Selenoid: " + browser);
        }
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("name",             testName);
        selenoidOptions.put("enableVNC",        propertyConfig.isGridEnableVNC());
        selenoidOptions.put("enableVideo",      propertyConfig.isGridEnableVideo());
        selenoidOptions.put("screenResolution", propertyConfig.getGridScreenResolution());
        selenoidOptions.put("sessionTimeout",   propertyConfig.getGridSessionTimeout() + "s");
        browserCaps.setCapability("selenoid:options", selenoidOptions);
        return browserCaps;
    }
}
