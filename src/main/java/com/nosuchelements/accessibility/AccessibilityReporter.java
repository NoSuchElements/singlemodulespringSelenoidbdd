package com.nosuchelements.accessibility;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * • Accessibility Reporter • Generates JSON and HTML reports for Axe scan
 * results
 */
@Component
public class AccessibilityReporter {
	private static final Logger logger = LoggerFactory.getLogger(AccessibilityReporter.class);
	private static final String REPORTS_DIR = "target/accessibility-reports";

	/**
	 * o Write Axe results to JSON file
	 */
	public void writeJsonReport(Results results, String testName) {
		try {
			createReportsDirectory();
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String filename = String.format("%s/%s_%s_axe-results.json", REPORTS_DIR, sanitizeFilename(testName),
					timestamp);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			try (FileWriter writer = new FileWriter(filename)) {
				gson.toJson(results, writer);
			}

			logger.info("Accessibility JSON report written to: {}", filename);

		} catch (IOException e) {
			logger.error("Failed to write JSON report", e);
		}
	}

	/**
	 * o Generate HTML summary report
	 */
	public void writeHtmlReport(Results results, String testName) {
		try {
			createReportsDirectory();
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String filename = String.format("%s/%s_%s_axe-report.html", REPORTS_DIR, sanitizeFilename(testName),
					timestamp);

			StringBuilder html = generateHtmlContent(results, testName);

			try (FileWriter writer = new FileWriter(filename)) {
				writer.write(html.toString());
			}

			logger.info("Accessibility HTML report written to: {}", filename);

		} catch (IOException e) {
			logger.error("Failed to write HTML report", e);
		}
	}

	/**
	 * o Log violations to console
	 */
	public void logViolations(Results results) {
		if (results.getViolations().isEmpty()) {
			logger.info("✓ No accessibility violations found");
			return;
		}
		logger.warn("");
		logger.warn("Found {} accessibility violations:", results.getViolations().size());
		logger.warn("");
		for (Rule violation : results.getViolations()) {
			logger.warn(" [{}] {} - {}",
					violation.getImpact() != null ? violation.getImpact().toUpperCase() : "UNKNOWN", violation.getId(),
					violation.getDescription());
			logger.warn(" Help: {}", violation.getHelp());
			logger.warn(" Affected elements: {}", violation.getNodes().size());
			logger.warn(" More info: {}", violation.getHelpUrl());
			logger.warn("----------------------------------------");
		}
	}

	/**
	 * o Create reports directory if it doesn't exist
	 */
	private void createReportsDirectory() throws IOException {
		Path reportsPath = Paths.get(REPORTS_DIR);
		if (!Files.exists(reportsPath)) {
			Files.createDirectories(reportsPath);
			logger.debug("Created reports directory: {}", REPORTS_DIR);
		}
	}

	/**
	 * o Sanitize filename by removing invalid characters
	 */
	private String sanitizeFilename(String filename) {
		return filename.replaceAll("[^a-zA-Z0-9-]", "");
	}

	/**
	 * o Generate HTML content for report
	 */
	private StringBuilder generateHtmlContent(Results results, String testName) {
		StringBuilder html = new StringBuilder();
		html.append("\n");
		html.append("<html lang='en'>\n");
		html.append("\n");
		html.append("\n");
		html.append("\n");
		html.append(getHtmlStyles());
		html.append("<body>\n");
		html.append("<div class='container'>\n");
		html.append("Accessibility Test Report\n");
		html.append("\n");
		html.append("Test: ").append(escapeHtml(testName)).append("\n");
		html.append("Generated: ").append(LocalDateTime.now()).append("\n");
		html.append("\n");
		html.append("\n");
		html.append("").append(results.getViolations().size()).append("\n");
		html.append("Violations\n");
		html.append("\n");
		html.append("\n");
		html.append("").append(results.getPasses().size()).append("\n");
		html.append("Passes\n");
		html.append("\n");
		html.append("\n");
		html.append("").append(results.getIncomplete().size()).append("\n");
		html.append("Incomplete\n");
		html.append("\n");
		html.append("\n");
		html.append("").append(results.getInapplicable().size()).append("\n");
		html.append("Inapplicable\n");
		html.append("\n");
		html.append("\n");
		html.append("\n");
		if (!results.getViolations().isEmpty()) {
			html.append("Violations Details\n");
			for (Rule violation : results.getViolations()) {
				html.append(generateViolationHtml(violation));
			}
		} else {
			html.append("\n");
			html.append("✓ No Violations Found\n");
			html.append("All accessibility checks passed successfully!\n");
			html.append("\n");
		}
		html.append("</div>\n");
		html.append("</body></html>");
		return html;
	}

	/**
	 * o Get HTML styles
	 */
	private String getHtmlStyles() {
		return "\n";
	}

	/**
	 * o Generate HTML for individual violation
	 */
	private String generateViolationHtml(Rule violation) {
		String impact = violation.getImpact() != null ? violation.getImpact() : "unknown";
		StringBuilder html = new StringBuilder();
		html.append("\n");
		html.append("").append(escapeHtml(violation.getDescription())).append("\n");
		html.append("Impact: ").append(impact.toUpperCase()).append("\n");
		html.append("Help: ").append(escapeHtml(violation.getHelp())).append("\n");
		html.append("Rule ID: ").append(escapeHtml(violation.getId())).append("\n");
		html.append("Affected nodes: ").append(violation.getNodes().size()).append("\n");
		html.append("View Documentation\n");
		html.append("\n");
		return html.toString();
	}

/**
o	Escape HTML special characters
*/
private String escapeHtml(String text) {
if (text == null) return "";
return text.replace("&", "&")
.replace("<", "<")
.replace(">", ">")
//.replace(""", """)
.replace("'", "'");
}
}
