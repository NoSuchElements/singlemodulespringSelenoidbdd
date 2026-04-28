package com.nosuchelements.hooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nosuchelements.config.singlemodulespringbddApplication;
import com.nosuchelements.constants.Constants.Platform;
import com.nosuchelements.driver.DriverManager;
import com.nosuchelements.utils.ScreenshotHelper;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;

/**
 * Cucumber Test Hooks Manages test lifecycle: setup, teardown, and screenshot
 * capture
 */
@CucumberContextConfiguration
@SpringBootTest(classes = singlemodulespringbddApplication.class)
public class Hooks {

	private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

	@Autowired
	private DriverManager driverManager;

	@Autowired
	private ScreenshotHelper screenshotHelper;
	
//	@Autowired
//	private SessionContext context;

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
		driverManager.initializeDriver(scenario.getName().toString());
	}

	@AfterStep
	public void afterStep(Scenario scenario) {
		screenshotHelper.captureAndAttachScreenshot(scenario);
	}

	/**
	 * After Hook - runs after each scenario
	 * @throws Throwable 
	 */
	@After
	public void afterScenario(Scenario scenario) throws Throwable {
		try {
			garbageClear();
			cleanUp();
			logger.info("========================================");
			logger.info("Finished Scenario: {}", scenario.getName());
			logger.info("Status: {}", scenario.getStatus());
			logger.info("========================================");
			System.out.println("######################################      FINISH SCENARIO" + ":" + scenario.getName()
					+ "    ################################################");
			System.out.println("######################################      FINISH FEATURE FILE PATH:" + scenario.getUri()
					+ "    ################################################");
			System.out.println("######################################      FINISH Thread ID = "
					+ Thread.currentThread().getId() + "Thread NAME = " + Thread.currentThread().getName()
					+ "    ################################################");
			// Take screenshot if scenario failed
			if (scenario.isFailed()) {
				logger.error("Scenario FAILED: {}", scenario.getName());
				captureFailureScreenshot(scenario);
			}
			driverManager.updateSauceLabsStatus(scenario.isFailed()?false:true);
			}catch(Exception e) {
				e.printStackTrace();
			}
		finally {
			// Quit driver after scenario
			System.out.println("Skipping driver close");
//			driverManager.quitDriver();
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
//		context.setProfileDetails(null);
//		context.setBankProfileDetails(null);
//		context.setBankCustDetails(null);
//		context.setUpdatedContactDetails(null);
//		context.setBankProductLabels(null);
//		context.setSummaryDTO(null);
//		context.setBankAcq(null);
//		context.setCardSelectorValues(null);
////		context.setContractInfo(null);
//		context.setCreditProductLabels(null);
//		context.setUpdatedContactDtls(null);
//		context.setPayeedtoList(null);
//		context.setPayee_dto(null);
//		context.setUpdatedOtpPayments(null);
//		context.setBtList(null);
	}

	public void cleanUp() throws Throwable {
//		cleanProfiles();
	}

/*	public void cleanProfiles() throws Throwable {

		ProfilesToCleanup cleanup = ProfilesToCleanup.getInstance();
		DashProfileDTO profile = context.getProfileDetails();
		BankProfileDTO bankProfile = context.getBankProfileDetails();
//		ProfileManager pm = null;
		while ((profile = cleanup.getProfileToCleanup()) != null) {
//			if (pm == null) {
//				try {
//					pm = new ProfileManager();
//				} catch (Throwable e) {
//					e.printStackTrace();
//				}
//			}
			pm.removeLock(profile.getDashUid());
			System.out.println("Getting Credit User Id after Clean Up " + profile.getDashUid());
			if (String.valueOf(profile.getDashDBAccountId()) != null) {
				pm.removeLockWithDashAccountID(String.valueOf(profile.getDashDBAccountId()));
			}
		}
		while ((bankProfile = cleanup.getBankProfileToCleanup()) != null) {
//			BankProfileManager bpm=new BankProfileManager();
//				try {
//					pm = new ProfileManager();
//				} catch (Throwable e) {
//					e.printStackTrace();
//				}
			bpm.removeLock(bankProfile.getRbCustomerNum());
			System.out.println("Getting User Id after Clean Up " + bankProfile.getRbCustomerNum());
		}
	} */

}
