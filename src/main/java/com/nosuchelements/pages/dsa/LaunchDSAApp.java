package com.nosuchelements.pages.dsa;

import org.openqa.selenium.By;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;

@PageObject
public class LaunchDSAApp extends BasePage {	

    
    public void navigateToNewSimulator(String lang) throws InterruptedException {
    	String url = null;
    	if(lang.startsWith("E"))
    	{
    		url="https://www.saucedemo.com";
    	}else
    	{
    		url="https://www.saucedemo.com";
    	}
    	log.info("Navigating to : "+ driverManager.getDriver().getCurrentUrl() );
//    	System.out.println(driver.getCurrentUrl());
		driverHelper.navigateTo(url);
		driverHelper.clickElementJS(By.xpath("(//div[@class='MuiListItemText-root']//span[contains(text(),'DSA')])[2]"));
		Thread.sleep(5000);
		driverManager.getDriver().findElement(By.xpath("//a[@href='/BRBPrep']")).click();
    }
    
    public void navigateToDSA(String lang) {
    	String url = null;
    	if(lang.startsWith("E"))
    	{
    		url="https://www.saucedemo.com";
//    				+ "https://qa-mastercard.triangle.com/content/dsa/en.html?transactionId=vbd6lys65qxrttvko9ak904iidzi8zrlwecakdfsssbih&lang=en";
    	}else
    	{
    		url="https://www.saucedemo.com";
    	}
    	log.info("Navigating to : "+driverManager.getDriver().getCurrentUrl() );
    	System.out.println(driverManager.getDriver().getCurrentUrl());
    	driverHelper.navigateTo(url);
    }
    
    public void navigateToDSAPromoCode(String lang,String promo, String cardType) {
    	String url = null;
    	if(lang.startsWith("E") && promo.equals("D0575")) {
    		switch(cardType) {
    				
    			case "OMX":
    			url = "https://www.saucedemo.com";
    			break;
    			
    			case "OMZ":
        		url = "https://www.saucedemo.com";
        		break;
        			
    			case "OMR":
        		url = "https://www.saucedemo.com";
        		break;
        			
    			case "OMP":
        		url = "https://www.saucedemo.com";
        		break;
        		
        		default:
    				System.out.println( "\n Failed to navigate to expected URL ");
    				break;
    		}
    	}
    	
    	else if(lang.startsWith("E") && promo.equals("00D23")) {
    		switch(cardType) {
			
				case "OMX":
				url = "https://www.saucedemo.com";
				break;
			
				case "OMZ":
				url = "https://www.saucedemo.com";
				break;
    			
				case "OMR":
				url = "https://www.saucedemo.com";
				break;
    			
				case "OMP":
				url = "https://www.saucedemo.com";
				break;
    		
				default:
					System.out.println( "\n Failed to navigate to expected URL ");
					break;
    		}
    	}
    	else if(lang.startsWith("E") && promo.equals("D3000")) {
        		switch(cardType) {
    			
    				case "OMX":
    				url = "https://www.saucedemo.com";
    				break;
    			
    				case "OMZ":
    				url = "https://www.saucedemo.com";
    				break;
        			
    				case "OMR":
    				url = "https://www.saucedemo.com";
    				break;
        			
    				case "OMP":
    				url = "https://www.saucedemo.com";
    				break;
        		
    				default:
    					System.out.println( "\n Failed to navigate to expected URL ");
    					break;
        		}
    	}
    
    	else if(lang.startsWith("E") && promo.equals("L3450")) {
    		switch(cardType) {
			
				case "OMX":
				url = "https://www.saucedemo.com";
				break;
			
				case "OMZ":
				url = "https://www.saucedemo.com";
				break;
    			
				case "OMR":
				url = "https://www.saucedemo.com";
				break;
    			
				case "OMP":
				url = "https://www.saucedemo.com";
				break;
    		
				default:
					System.out.println( "\n Failed to navigate to expected URL ");
					break;
    		}
    	}
    	else if(lang.startsWith("F") && promo.equals("D0575")) {
    		switch(cardType) {
			
				case "OMX":
				url = "https://www.saucedemo.com";
				break;
			
				case "OMZ":
				url = "https://www.saucedemo.com";

				break;
    			
				case "OMR":
    		    url = "https://www.saucedemo.com";

    		    break;
    			
				case "OMP":
				url = "https://www.saucedemo.com";

				break;
    		
				default:
					System.out.println( "\n Failed to navigate to expected URL ");
					break;
    		}
    	}
    	
    	else if(lang.startsWith("F") && promo.equals("00D23")) {
    		switch(cardType) {
			
				case "OMX":
				url = "https://www.saucedemo.com";

				break;
		
				case "OMZ":
				url = "https://www.saucedemo.com";

				break;
			
				case "OMR":
				url = "https://www.saucedemo.com";

				break;
			
				case "OMP":
				url = "https://www.saucedemo.com";
				break;
		
				default:
				System.out.println( "\n Failed to navigate to expected URL ");
				break;
    		}
    	}
    	
    	else if(lang.startsWith("F") && promo.equals("D3000")) {
    		switch(cardType) {
			
				case "OMX":
				url = "https://www.saucedemo.com";
				break;
			
				case "OMZ":
				url = "https://www.saucedemo.com";
				break;
    			
				case "OMR":
				url = "https://www.saucedemo.com";
				break;
    			
				case "OMP":
				url = "https://www.saucedemo.com";
				break;
    		
				default:
					System.out.println( "\n Failed to navigate to expected URL ");
					break;
    		}
    	}
    	else if(lang.startsWith("F") && promo.equals("L3450")) {
        	switch(cardType) {
    			
    				case "OMX":
    				url = "https://www.saucedemo.com";
    				break;
    			
    				case "OMZ":
    				url = "https://www.saucedemo.com";

    				break;
        			
    				case "OMR":
        		    url = "https://www.saucedemo.com";

        		    break;
        			
    				case "OMP":
    				url = "https://www.saucedemo.com";

    				break;
        		
    				default:
    					System.out.println( "\n Failed to navigate to expected URL ");
    					break;
        	}
        }
	
    	log.info("Navigating to : "+driverManager.getDriver().getCurrentUrl().toString());
    	System.out.println("Navigating to : "+driverManager.getDriver().getCurrentUrl().toString());
    	driverManager.getDriver().get(url);
//    	driverHelper.navigateTo(url);
    }
    
    public void navigateToDSA(String lang, String cardType) {
    	String url = null;
    	log.info(" Language passed to LaunchDSApp: "+lang+"  Card Type: "+cardType);
    	if(lang.startsWith("E"))
    	{
    		url="https://www.saucedemo.com?cardType="+cardType;
    	}else
    	{
    		url="https://www.saucedemo.com?cardType="+cardType;
    	}
    	log.info("Navigating to : "+driverManager.getDriver().getCurrentUrl() );
    	System.out.println(driverManager.getDriver().getCurrentUrl());
    	driverHelper.navigateTo(url);
    }

    public void navigateToDSAProd(String lang, String cardType) {
    	String url = null;
    	log.info(" Language passed to LaunchDSApp: "+lang+"  Card Type: "+cardType);
    	if(lang.startsWith("E"))
    	{
    		url="https://www.saucedemo.com?cardType="+cardType;
    	}else
    	{
    		url="https://www.saucedemo.com?cardType="+cardType;
    	}
    	log.info("Navigating to : "+driverManager.getDriver().getCurrentUrl() );
    	System.out.println(driverManager.getDriver().getCurrentUrl());
    	try {
			driverHelper.navigateTo(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void navigateToDSAwdc(String lang, String cardType) {
    	String url = null;
    	if(lang.startsWith("E"))
    	{
    		url="https://www.saucedemo.com/en.html?cardType="+cardType;
    	}else
    	{
    		url="https://www.saucedemo.com/fr.html?cardType="+cardType;
    	}
    	log.info("Navigating to : "+driverManager.getDriver().getCurrentUrl() );
    	System.out.println(driverManager.getDriver().getCurrentUrl());
    	try {
			driverHelper.navigateTo(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

//	@Override
	public void validate() throws ValidationException {
		// TODO Auto-generated method stub
		
	}
}
