package com.nosuchelements.utils;
import com.nosuchelements.config.PropertyConfig;
import com.nosuchelements.driver.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;
@Component
public class WaitHelper {
	
private static final Logger logger = LoggerFactory.getLogger(WaitHelper.class);

@Autowired
private DriverManager driverManager;

@Autowired
private PropertyConfig propertyConfig;

public Wait<WebDriver> getDriverWait() {
	 WebDriver driver = driverManager.getDriver();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
	 return wait;
}

public void waitForElementToLoad(WebElement element) throws NoSuchFieldException {
    waitForElementVisible(element);
    waitForElementClickable(element);
}

public void waitForElementToLoad(By locator) throws NoSuchFieldException {
    waitForElementVisible(locator);
    waitForElementClickable(locator);
}


/**
 * Wait for element to be visible - Lambda expression ready
 */
public WebElement waitForElementVisible(By locator) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
    logger.debug("Waiting for element to be visible: {}", locator);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public WebElement waitForElementVisible(WebElement element) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
//    logger.debug("Waiting for element to be visible: {}", locator);
    return wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * Wait for element to be clickable
 */
public WebElement waitForElementClickable(By locator) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
    logger.debug("Waiting for element to be clickable: {}", locator);
    return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public WebElement waitForElementClickable(WebElement element) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
//    logger.debug("Waiting for element to be clickable: {}", locator);
    return wait.until(ExpectedConditions.elementToBeClickable(element));
}

/**
 * Wait for element to be present
 */
public WebElement waitForElementPresent(By locator) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
    logger.debug("Waiting for element to be present: {}", locator);
    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
}

/**
 * Wait for all elements to be visible
 */
public List<WebElement> waitForAllElementsVisible(By locator) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
    logger.debug("Waiting for all elements to be visible: {}", locator);
    return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}

/**
 * Wait for element to be invisible
 */
public boolean waitForElementInvisible(By locator) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
    logger.debug("Waiting for element to be invisible: {}", locator);
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
}

/**
 * Wait for custom condition - Lambda expression support
 */
public <T> T waitForCondition(Function<WebDriver, T> condition) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
    logger.debug("Waiting for custom condition");
    return wait.until(condition);
}

/**
 * Wait for URL to contain text
 */
public boolean waitForUrlContains(String urlFragment) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
    logger.debug("Waiting for URL to contain: {}", urlFragment);
    return wait.until(ExpectedConditions.urlContains(urlFragment));
}

/**
 * Wait for title to contain text
 */
public boolean waitForTitleContains(String title) {
    WebDriver driver = driverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(propertyConfig.getExplicitWait()));
    
    logger.debug("Waiting for title to contain: {}", title);
    return wait.until(ExpectedConditions.titleContains(title));
}

}
