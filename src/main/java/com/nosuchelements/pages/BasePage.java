package com.nosuchelements.pages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.constants.Constants.Language;
import com.nosuchelements.driver.DriverManager;
import com.nosuchelements.session.SessionContext;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;
import com.nosuchelements.utils.DriverHelper;
import com.nosuchelements.utils.WaitHelper;
import com.nosuchelements.utils.dsa.CommonUtils;

import jakarta.annotation.PostConstruct;

/**
 * • Base Page Object - all page objects extend this class • Automatic
 * PageFactory initialization using Spring @PostConstruct • Features: o
 * Automatic PageFactory initialization o Common page operations o WaitHelper
 * integration o Logger support
 */
public abstract class BasePage {
	protected static final Logger log = LoggerFactory.getLogger(BasePage.class);
	
	@Autowired
	protected DriverManager driverManager;
	
	@Autowired
	protected DriverHelper driverHelper;
	    
	@Autowired
	protected SessionContext context;
	
	@Autowired
	protected WaitHelper driverWait;
	
	
	
	protected WebDriver driver;

	/**
	 * o Initialize PageFactory elements after Spring dependency injection o Called
	 * automatically by Spring after bean creation
	 */
	@PostConstruct
	public void init() {
		this.driver = driverManager.getDriver();
		if (this.driver != null) {
			PageFactory.initElements(driver, this);
			log.debug("PageFactory initialized for {}", this.getClass().getSimpleName());
		}
	}

	
	 protected String expectedTitle;
	    protected Actions actions;
//	    public abstract void validate() throws ValidationException, InterruptedException;

	 /*   protected AbstractPage(DriverManager driverManager) {
	    	System.out.println("Inside Abstract Page"+driverManager);
	    	System.out.println("Inside Abstract Page: Driver"+driverManager.getDriver());
	        PageFactory.initElements(driverManager.getDriver(), this);
	        this.actions = new Actions(driverManager.getDriver());
	    }*/
	    
	  /*  protected AbstractPage(ExternalDriverManager externalDriverManager) {
	    	System.out.println("Inside Abstract Page"+externalDriverManager);
	    	System.out.println("Inside Abstract Page: Driver"+externalDriverManager.getExternalWebDriver());
	        PageFactory.initElements(externalDriverManager.getExternalWebDriver(), this);
	    }  */

	    protected void openAt(String url) {
	        driverManager.getDriver().get(url);
	    }
	    
	    protected void navigateTo(String url) {
	    	driverHelper.navigateTo(url);
	    }
	    
	    protected String getLanguage() {
	    	return context.getLanguage();
	    }

//		public void validate() throws ValidationException {
//			// TODO Auto-generated method stub
//			
//		}
	    
	    public WebElement getElementWhenVisible(By xpath) {
	        return driverHelper.getElementWhenVisible(xpath);
	    }
	    
		protected String getText(WebElement element) {
	    	return driverHelper.getText(element);
	    }
		
		protected String getInputText(String key) {
	    	return driverHelper.getInputText(key);
	    }
		
		 protected String getInputText(String key, Language lang) {
		     return driverHelper.searchDataDictionary(key, lang);
		 }
		
		 public String getAttribute(WebElement element, String value) {
		        return driverHelper.getAttribute(element,value);
		    }
		
		protected void clickElement(WebElement element) throws InterruptedException {
	    	 driverHelper.clickElement(element);
	    }
		
		 protected void clickElementJS(WebElement element) throws InterruptedException {
		        driverHelper.clickElementJS(element);
		   }
		
		protected void validateText(WebElement element, String text) throws ValidationException {
	    	driverHelper.validateText(element,text);
	    }
		
		protected void validateText(String text1, String text2) throws ValidationException {
	    	driverHelper.validateText(text1,text2);
	    }
		
	    protected void validateText(String text1, String text2, boolean value) throws ValidationException {
	      	 driverHelper.validateText(text1, text2, value);
	    }
	    
	    public boolean verifyErrorMessage(WebElement element, String expText, String color) throws Exception {
	        return driverHelper.verifyErrorMessage(element, expText, color);
	    }
		
	    protected void selectFromDropdownByValue(WebElement element, String value) throws InterruptedException {
	     	 driverHelper.selectFromDropdownByValue(element, value);
	     }
		
		protected void selectFromDropdownByText(WebElement element, String value) throws InterruptedException {
	    	 driverHelper.selectFromDropdownByText(element, value);
	    }
		
		protected void selectFromDropdownByIndex(WebElement element, int value) throws InterruptedException {
	      	 driverHelper.selectFromDropdownByIndex(element, value);
	      }
		
		protected String retrieveValueFromSelect(WebElement element) throws InterruptedException {
	    	 return driverHelper.retrieveValueFromSelect(element);
	    }
		
		protected List<String> retrieveValuesFromSelect(WebElement element) throws InterruptedException {
		   	 return driverHelper.retrieveValuesFromSelect(element);
		}
		
		protected void inputText(WebElement element, String text) throws InterruptedException {
	     	 driverHelper.inputText(element, text);
	     }
		
		protected void waitForVisible(WebElement element) throws InterruptedException {
	    	 driverHelper.waitForVisible(element);
	    }
		
		protected void waitForSeconds(int time) {
	        driverHelper.waitForSeconds(time);;
	   }
		
		protected boolean waitForEmptyText(WebElement element) {
	        return driverHelper.waitForEmptyText(element);
	   }
		
		protected boolean isElementVisible(WebElement element) {
	        return driverHelper.isElementVisible(element);
	    }
		
		public boolean isElementVisible(By xpath) {
	        return driverHelper.isElementVisible(xpath);
	    }
		 
		protected String searchDataDictionary(String key) {
	    	return driverHelper.searchDataDictionary(key);
	    }
		
		protected void scrollIntoView(WebElement element) throws InterruptedException {
	   	 driverHelper.scrollIntoView(element);
	   }
		
		protected String getXpath(WebElement element) {
	    	return driverHelper.getXpath(element);
	    }
		
		protected String getFormattedDate(String type, String format) {
	        return driverHelper.getFormattedDate(type, format);
	    }
		
//		protected void waitForVisible(WebElement element) throws InterruptedException {
//	   	 driverHelper.waitForVisible(element);
	//   }
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
