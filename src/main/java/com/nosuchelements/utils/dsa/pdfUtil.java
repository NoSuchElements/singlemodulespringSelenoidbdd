package com.nosuchelements.utils.dsa;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.nosuchelements.driver.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.SupportsContextSwitching;

@Component
public class pdfUtil  {
	
	@Autowired
	DriverManager driverManager;
	
	public void clickBack() {
		((PressesKey)(driverManager.getDriver())).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void switchTab(WebDriver driver) {
		try {
		System.out.println("\n Switching tabs in Iphone \n");
//		SupportsContextSwitching contextSwitchingDriver = (SupportsContextSwitching) driver;
//		Set<String> contextView = ((AppiumDriver) driver).getContextHandles();
//		ArrayList<String> s = new ArrayList<String>(contextView);
//		System.out.println("Window size= "+contextView.size());
//		((AppiumDriver) driver).context(s.get(contextView.size()-1));
		

		SupportsContextSwitching ctxDriver = (SupportsContextSwitching) driver;

		Set<String> contexts = ctxDriver.getContextHandles();
		System.out.println("Contexts: " + contexts);

		if (contexts.isEmpty()) {
		    throw new IllegalStateException("No contexts available");
		}

		// Prefer a WEBVIEW context if present; otherwise stay in NATIVE_APP
		String target = contexts.stream().filter(c -> c.startsWith("WEBVIEW")).findFirst().orElse("NATIVE_APP");
		System.out.println("Switching to: " + target);
		ctxDriver.context(target);
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to switch tab in phone");
		}
	}
	
	public String openPdfandStripText(String url) throws Exception {
		String stripText = null;
		try {
		URL pdfURL = new URL(url);
        InputStream is=pdfURL.openStream();
        byte[] pdfBytes = is.readAllBytes();
//        BufferedInputStream bis=new BufferedInputStream(is);
        PDDocument doc= Loader.loadPDF(pdfBytes);

        int pages=doc.getNumberOfPages();
        System.out.println("\n The total number of pages "+pages);
        
        PDFTextStripper strip=new PDFTextStripper();
        strip.setStartPage(1);
        strip.setEndPage(3);
        stripText=strip.getText(doc);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to load pdf content");
		}
        return stripText;
	}
	
	public String openPdfandStripLastPage(String url) throws Exception {
		String stripText = null;
		try {
		URL pdfURL = new URL(url);
        InputStream is=pdfURL.openStream();
        byte[] pdfBytes = is.readAllBytes();
//        BufferedInputStream bis=new BufferedInputStream(is);
//        PDDocument doc=PDDocument.load(bis);
        PDDocument doc= Loader.loadPDF(pdfBytes);

//        int pages=doc.getNumberOfPages();
//        System.out.println("\n The total number of pages "+pages);
        
        PDFTextStripper strip=new PDFTextStripper();
//        strip.setStartPage(1);
        strip.setEndPage(40);
        stripText=strip.getText(doc);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to load pdf content");
		}
        return stripText;
	}

}
