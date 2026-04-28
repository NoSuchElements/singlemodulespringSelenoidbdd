package com.nosuchelements.accessibility;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.nosuchelements.driver.DriverManager;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

/**
 * • Axe Accessibility Helper • Provides methods for running WCAG and Section
 * 508 compliance scans
 */
@Component
public class AxeHelper {
	private static final Logger logger = LoggerFactory.getLogger(AxeHelper.class);
	@Autowired
	private DriverManager driverManager;

	/**
	 * o Run full accessibility scan on current page
	 */
	public Results runAccessibilityScan() {
		WebDriver driver = driverManager.getDriver();
		logger.info("Running Axe accessibility scan on current page");
		try {
			AxeBuilder axeBuilder = new AxeBuilder();
			Results results = axeBuilder.analyze(driver);
			logScanSummary(results);
			return results;

		} catch (Exception e) {
			logger.error("Failed to run accessibility scan", e);
			throw new RuntimeException("Accessibility scan failed", e);
		}
	}

	/**
	 * o Run accessibility scan with specific tags
	 */
	public Results runAccessibilityScanWithTags(List<String> tags) {
		WebDriver driver = driverManager.getDriver();
		logger.info("Running Axe accessibility scan with tags: {}", tags);
		try {
			AxeBuilder axeBuilder = new AxeBuilder().withTags(tags);
			Results results = axeBuilder.analyze(driver);
			logScanSummary(results);
			return results;

		} catch (Exception e) {
			logger.error("Failed to run tagged accessibility scan", e);
			throw new RuntimeException("Accessibility scan failed", e);
		}
	}

	/**
	 * o Run WCAG 2.1 Level A and AA compliance scan
	 */
	public Results runWCAG21Scan() {
		logger.info("Running WCAG 2.1 Level A & AA compliance scan");
		return runAccessibilityScanWithTags(Arrays.asList("wcag2a", "wcag2aa", "wcag21a", "wcag21aa"));
	}

	/**
	 * o Run WCAG 2.2 compliance scan
	 */
	public Results runWCAG22Scan() {
		logger.info("Running WCAG 2.2 compliance scan");
		return runAccessibilityScanWithTags(Arrays.asList("wcag2a", "wcag2aa", "wcag21a", "wcag21aa", "wcag22aa"));
	}

	/**
	 * o Run Section 508 compliance scan
	 */
	public Results runSection508Scan() {
		logger.info("Running Section 508 compliance scan");
		return runAccessibilityScanWithTags(Arrays.asList("section508"));
	}

	/**
	 * o Run scan for specific elements only
	 */
	public Results runScanOnElement(String cssSelector) {
		WebDriver driver = driverManager.getDriver();
		logger.info("Running accessibility scan on element: {}", cssSelector);
		try {
			AxeBuilder axeBuilder = new AxeBuilder().include(Arrays.asList(cssSelector));
			Results results = axeBuilder.analyze(driver);
			logScanSummary(results);
			return results;

		} catch (Exception e) {
			logger.error("Failed to run element-specific scan", e);
			throw new RuntimeException("Accessibility scan failed", e);
		}
	}

	/**
	 * o Check if scan has critical violations
	 */
//	public boolean hasCriticalViolations(Results results) {
//		return results.getViolations().stream().anyMatch(v -> "critical".equalsIgnoreCase(v.getImpact()));
//	}

	/**
	 * o Check if scan has violations of specific impact level
	 */
	public boolean hasViolationsOfImpact(Results results, String impact) {
		return results.getViolations().stream().anyMatch(v -> impact.equalsIgnoreCase(v.getImpact()));
	}

	/**
	 * o Get count of violations by impact level
	 */
	public int getViolationCountByImpact(Results results, String impact) {
		return (int) results.getViolations().stream().filter(v -> impact.equalsIgnoreCase(v.getImpact())).count();
	}

	/**
	 * o Get total violation count
	 */
	public int getTotalViolationCount(Results results) {
		return results.getViolations().size();
	}

	/**
	 * o Log scan summary
	 */
	private void logScanSummary(Results results) {
		logger.info("");
		logger.info("Accessibility Scan Summary");
		logger.info("");
		logger.info("Total violations: {}", results.getViolations().size());
		logger.info("Passes: {}", results.getPasses().size());
		logger.info("Incomplete: {}", results.getIncomplete().size());
		logger.info("Inapplicable: {}", results.getInapplicable().size());
		if (!results.getViolations().isEmpty()) {
			logger.warn("----------------------------------------");
			logger.warn("Violations by impact:");
			logger.warn(" Critical: {}", getViolationCountByImpact(results, "critical"));
			logger.warn(" Serious: {}", getViolationCountByImpact(results, "serious"));
			logger.warn(" Moderate: {}", getViolationCountByImpact(results, "moderate"));
			logger.warn(" Minor: {}", getViolationCountByImpact(results, "minor"));
			logger.warn("----------------------------------------");
		}
		logger.info("========================================");
	}
}
