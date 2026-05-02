package com.nosuchelements.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nosuchelements.config.singlemodulespringbddApplication;
import com.nosuchelements.constants.Constants.Platform;
import com.nosuchelements.driver.DriverManager;
import com.nosuchelements.driver.ThreadLocalDriver;
import com.nosuchelements.utils.ScreenshotHelper;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;

/**
 * Cucumber Test Hooks
 * Manages test lifecycle: setup, teardown, and screenshot + Selenoid metadata capture.
 */
@CucumberContextConfiguration
@SpringBootTest(classes = singlemodulespringbddApplication.class)
public class Hooks {

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Autowired
    private DriverManager driverManager;

    @Autowired
    private ScreenshotHelper screenshotHelper;

    /**
     * Before Hook - runs before each scenario
     */
    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("========================================");
        logger.info("Starting Scenario: {}", scenario.getName());
        logger.info("Tags: {}", scenario.getSourceTagNames());
        logger.info("========================================");
        System.setProperty("dataDictionary", Platform.DSA.toString());
        driverManager.initializeDriver(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        screenshotHelper.captureAndAttachScreenshot(scenario);
    }

    /**
     * After Hook - runs after each scenario
     */
    @After
    public void afterScenario(Scenario scenario) throws Throwable {
        try {
            garbageClear();
            cleanUp();

            logger.info("========================================");
            logger.info("Finished Scenario: {}", scenario.getName());
            logger.info("Status: {}", scenario.getStatus());

            // Log Selenoid metadata if present
            if (ThreadLocalDriver.getGridVideoUrl() != null) {
                logger.info("Selenoid Video URL: {}", ThreadLocalDriver.getGridVideoUrl());
            }
            if (ThreadLocalDriver.getGridVncUrl() != null) {
                logger.info("Selenoid VNC URL:   {}", ThreadLocalDriver.getGridVncUrl());
            }
            logger.info("========================================");

            System.out.println("######################################      FINISH SCENARIO:" + scenario.getName()
                    + "    ################################################");
            System.out.println("######################################      FINISH FEATURE FILE PATH:" + scenario.getUri()
                    + "    ################################################");
            System.out.println("######################################      FINISH Thread ID = "
                    + Thread.currentThread().getId() + " Thread NAME = " + Thread.currentThread().getName()
                    + "    ################################################");

            // Take screenshot if scenario failed
            if (scenario.isFailed()) {
                logger.error("Scenario FAILED: {}", scenario.getName());
                captureFailureScreenshot(scenario);
            }

            // Unified remote status update (Sauce Labs + Selenoid logging)
            driverManager.updateRemoteStatus(!scenario.isFailed());

        } catch (Exception e) {
            logger.error("Error in afterScenario hook", e);
        } finally {
            // NOTE: driverManager.quitDriver() is intentionally skipped for now
            System.out.println("Skipping driver close");
            // driverManager.quitDriver();
        }
    }

    /**
     * Capture screenshot on failure
     */
    private void captureFailureScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = screenshotHelper.captureScreenshotAsBytes();
            if (screenshot != null) {
                scenario.attach(screenshot, "image/png", scenario.getName());
                logger.info("Screenshot captured and attached to report");
            }
        } catch (Exception e) {
            logger.error("Failed to capture screenshot", e);
        }
    }

    public void garbageClear() throws Throwable {
        // Reserved for future SessionContext cleanup
    }

    public void cleanUp() throws Throwable {
        // Reserved for future resource cleanup
    }
}
