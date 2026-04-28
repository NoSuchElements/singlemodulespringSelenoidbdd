package com.nosuchelements.utils;

import io.cucumber.java.Scenario;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nosuchelements.driver.DriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class ScreenshotHelper {
	private static final Logger logger = LoggerFactory.getLogger(ScreenshotHelper.class);
	private static final String SCREENSHOT_DIR = "target/screenshots";

	@Autowired
	private DriverManager driverManager;

	/**
	 * Capture screenshot and return as byte array for Cucumber reports
	 */
	public byte[] captureScreenshotAsBytes() {
		try {
			WebDriver driver = driverManager.getDriver();
			if (driver instanceof TakesScreenshot) {
				return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			}
		} catch (Exception e) {
			logger.error("Failed to capture screenshot", e);
		}
		return new byte[0];
	}

	/**
	 * Capture screenshot and save to file
	 */

	public String captureAndAttachScreenshot(Scenario scenario) {
		try {
			WebDriver driver = driverManager.getDriver();
			if (!(driver instanceof TakesScreenshot)) {
				return null;
			}

			// Create directory
			Path screenshotPath = Paths.get(SCREENSHOT_DIR);
			if (!Files.exists(screenshotPath)) {
				Files.createDirectories(screenshotPath);
			}

			// File name
			String baseName = scenario.getName().replaceAll("\\s+", "_");
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String filename = String.format("%s/%s_%s.png", SCREENSHOT_DIR, baseName, timestamp);

			// 1) Save to disk
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(screenshotFile.toPath(), Paths.get(filename));

			// 2) Attach to Cucumber
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", baseName);

			logger.info("Screenshot saved and attached: {}", filename);
			return filename;
		} catch (Exception e) {
			logger.error("Failed to capture screenshot", e);
			return null;
		}
	}

	public String captureScreenshot(String screenshotName) {
		try {
			WebDriver driver = driverManager.getDriver();
			if (!(driver instanceof TakesScreenshot)) {
				return null;
			}

			Path screenshotPath = Paths.get(SCREENSHOT_DIR);
			if (!Files.exists(screenshotPath)) {
				Files.createDirectories(screenshotPath);
			}
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String fileName = screenshotName + "_" + timestamp + ".png";
			String path = SCREENSHOT_DIR + File.separator + fileName;

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));

			return path;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
