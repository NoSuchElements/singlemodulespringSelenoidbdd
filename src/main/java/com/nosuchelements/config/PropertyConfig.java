package com.nosuchelements.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Central configuration bean.
 * Reads application.properties and exposes all framework settings.
 *
 * Supported execution modes (execution.mode property):
 *   LOCAL     - local ChromeDriver / FirefoxDriver / EdgeDriver
 *   SELENOID  - RemoteWebDriver routed to Aerokube Selenoid (Docker/on-prem)
 *   SAUCELABS - RemoteWebDriver routed to Sauce Labs cloud
 */
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

    // ── Selenoid / Grid Configuration ──────────────────────────────────────────
    @Value("${grid.url:http://localhost:4444/wd/hub}")
    private String gridUrl;
    @Value("${grid.enableVNC:true}")
    private boolean gridEnableVNC;
    @Value("${grid.enableVideo:true}")
    private boolean gridEnableVideo;
    @Value("${grid.video.baseUrl:http://localhost:8080}")
    private String gridVideoBaseUrl;
    @Value("${grid.sessionTimeout:300}")
    private int gridSessionTimeout;
    @Value("${grid.screenResolution:1920x1080x24}")
    private String gridScreenResolution;
    // ───────────────────────────────────────────────────────────────────────────

    // ── Sauce Labs getters ──────────────────────────────────────────────────────
    public String getSauceUsername() {
        String env = System.getenv("SAUCE_USERNAME");
        return (env != null && !env.isEmpty()) ? env : sauceUsername;
    }
    public String getSauceAccessKey() {
        String env = System.getenv("SAUCE_ACCESS_KEY");
        return (env != null && !env.isEmpty()) ? env : sauceAccessKey;
    }
    public String getSauceRegion()  { return sauceRegion; }
    public String getSauceBuild()   { return sauceBuild; }
    public String getSauceUrl()     { return sauceUrl; }
    public String getSauceLabsUrl() {
        return String.format("https://%s:%s@%s", getSauceUsername(), getSauceAccessKey(), getSauceUrl());
    }

    // ── Browser / Platform getters ──────────────────────────────────────────────
    public String getBrowser()       { return System.getProperty("browser", browser); }
    public String getPlatform()      { return System.getProperty("platform", platform).toUpperCase(); }
    public String getExecutionMode() { return System.getProperty("execution.mode", executionMode).toUpperCase(); }
    public String getLanguage()      { return System.getProperty("appLang", appLanguage).toUpperCase(); }

    // ── Mobile getters ──────────────────────────────────────────────────────────
    public String getMobilePlatform()        { return System.getProperty("mobile.platform", mobilePlatform).toLowerCase(); }
    public String getMobileDeviceAndroid()   { return System.getProperty("mobile.device.android", mobileDeviceAndroid); }
    public String getMobileVersionAndroid()  { return System.getProperty("mobile.version.android", mobileVersionAndroid); }
    public String getMobileDeviceIphone()    { return System.getProperty("mobile.device.iphone", mobileDeviceIphone); }
    public String getMobileVersionIphone()   { return System.getProperty("mobile.version.iphone", mobileVersionIphone); }
    public String getMobileAppPackage()      { return System.getProperty("mobile.app.package", mobileAppPackage); }
    public String getMobileAppActivity()     { return System.getProperty("mobile.app.activity", mobileAppActivity); }
    public String getMobileAppPath()         { return System.getProperty("mobile.app.path", mobileAppPath); }

    // ── API getters ─────────────────────────────────────────────────────────────
    public String getApiBaseUrl() { return System.getProperty("api.base.url", apiBaseUrl); }

    // ── Timeout getters ─────────────────────────────────────────────────────────
    public int getImplicitWait()    { return implicitWait; }
    public int getExplicitWait()    { return explicitWait; }
    public int getPageLoadTimeout() { return pageLoadTimeout; }

    // ── Grid / Selenoid getters ─────────────────────────────────────────────────
    public String  getGridUrl()              { return System.getProperty("grid.url", gridUrl); }
    public boolean isGridEnableVNC()         { return gridEnableVNC; }
    public boolean isGridEnableVideo()       { return gridEnableVideo; }
    public String  getGridVideoBaseUrl()     { return gridVideoBaseUrl; }
    public int     getGridSessionTimeout()   { return gridSessionTimeout; }
    public String  getGridScreenResolution() { return gridScreenResolution; }

    // ── Execution mode helpers ───────────────────────────────────────────────────
    /** execution.mode=LOCAL  - local browser drivers via bonigarcia WebDriverManager */
    public boolean isLocal()     { return "LOCAL".equalsIgnoreCase(getExecutionMode()); }
    /** execution.mode=SAUCELABS - Sauce Labs cloud grid */
    public boolean isSauceLabs() { return "SAUCELABS".equalsIgnoreCase(getExecutionMode()); }
    /** execution.mode=SELENOID - Aerokube Selenoid Docker/on-prem grid */
    public boolean isSelenoid()  { return "SELENOID".equalsIgnoreCase(getExecutionMode()); }
    /** true for SELENOID or GRID - any RemoteWebDriver grid that is NOT Sauce Labs */
    public boolean isGrid()      { return isSelenoid() || "GRID".equalsIgnoreCase(getExecutionMode()); }

    // ── Platform helpers ─────────────────────────────────────────────────────────
    public boolean isWeb()    { return "WEB".equalsIgnoreCase(getPlatform()); }
    public boolean isMobile() { return "MOBILE".equalsIgnoreCase(getPlatform()); }
    public boolean isApi()    { return "API".equalsIgnoreCase(getPlatform()); }
}
