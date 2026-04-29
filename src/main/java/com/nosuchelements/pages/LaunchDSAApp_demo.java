package com.nosuchelements.pages;

import com.nosuchelements.annotations.PageObject;

@PageObject
public class LaunchDSAApp_demo extends BasePage {	
   
    public void navigateToDSA(String lang, String cardType) {
    	String url = null;
//    	log.info(" Language passed to LaunchDSApp: "+lang+"  Card Type: "+cardType);
    	if(lang.startsWith("E"))
    	{
    		url="https://qa-mastercard.triangle.com/content/dsa2/en.html?cardType="+cardType;
    	}else
    	{
    		url="https://qa-mastercard.triangle.com/content/dsa2/fr.html?cardType="+cardType;
    	}
//    	log.info("Navigating to : "+driverManager.getWebDriver().getCurrentUrl() );
//    	System.out.println(driverManager.getWebDriver().getCurrentUrl());
    	navigateTo(url);
    }

   
}
