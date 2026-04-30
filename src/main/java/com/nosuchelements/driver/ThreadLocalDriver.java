package com.nosuchelements.driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

/**
 * Thread-safe storage for all driver instances and session metadata.
 * Each thread (parallel Cucumber scenario) gets fully isolated state.
 *
 * Stored per thread:
 *   webDriver    - Selenium WebDriver for web channel
 *   appiumDriver - Appium driver for mobile channel
 *   sessionId    - Selenium / Appium session ID from RemoteWebDriver
 *   testName     - Scenario / test name for logging and reporting
 *   gridVideoUrl - Selenoid video recording URL  (set when execution.mode=SELENOID)
 *   gridVncUrl   - Selenoid VNC live-view URL     (set when execution.mode=SELENOID)
 *
 * IMPORTANT: Always call removeAll() in @After hook to prevent
 * memory leaks in long-running parallel suites.
 */
public class ThreadLocalDriver {

    private static final ThreadLocal<WebDriver>    webDriver    = new ThreadLocal<>();
    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    private static final ThreadLocal<String>       sessionId    = new ThreadLocal<>();
    private static final ThreadLocal<String>       testName     = new ThreadLocal<>();
    private static final ThreadLocal<String>       gridVideoUrl = new ThreadLocal<>();
    private static final ThreadLocal<String>       gridVncUrl   = new ThreadLocal<>();

    // ── WebDriver ────────────────────────────────────────────────────────────────
    public static void      setWebDriver(WebDriver driver) { webDriver.set(driver); }
    public static WebDriver getWebDriver()                 { return webDriver.get(); }
    public static void      removeWebDriver()              { webDriver.remove(); }

    // ── AppiumDriver ─────────────────────────────────────────────────────────────
    public static void         setAppiumDriver(AppiumDriver driver) { appiumDriver.set(driver); }
    public static AppiumDriver getAppiumDriver()                    { return appiumDriver.get(); }
    public static void         removeAppiumDriver()                 { appiumDriver.remove(); }

    // ── Session ID ───────────────────────────────────────────────────────────────
    public static void   setSessionId(String id) { sessionId.set(id); }
    public static String getSessionId()          { return sessionId.get(); }
    public static void   removeSessionId()       { sessionId.remove(); }

    // ── Test Name ────────────────────────────────────────────────────────────────
    public static void   setTestName(String name) { testName.set(name); }
    public static String getTestName()            { return testName.get(); }
    public static void   removeTestName()         { testName.remove(); }

    // ── Selenoid Video URL ───────────────────────────────────────────────────────
    public static void   setGridVideoUrl(String url) { gridVideoUrl.set(url); }
    public static String getGridVideoUrl()           { return gridVideoUrl.get(); }
    public static void   removeGridVideoUrl()        { gridVideoUrl.remove(); }

    // ── Selenoid VNC URL ─────────────────────────────────────────────────────────
    public static void   setGridVncUrl(String url) { gridVncUrl.set(url); }
    public static String getGridVncUrl()           { return gridVncUrl.get(); }
    public static void   removeGridVncUrl()        { gridVncUrl.remove(); }

    // ── Teardown - call in @After hook to prevent memory leaks ───────────────────
    public static void removeAll() {
        removeWebDriver();
        removeAppiumDriver();
        removeSessionId();
        removeTestName();
        removeGridVideoUrl();
        removeGridVncUrl();
    }
}
