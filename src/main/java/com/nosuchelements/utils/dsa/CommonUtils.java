package com.nosuchelements.utils.dsa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;

@Component
public class CommonUtils extends BasePage {
	
	public String pageTitle() {
		String actualTitle = driverManager.getDriver().getTitle();
		driverWait.getDriverWait().until(ExpectedConditions.titleIs(actualTitle));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("\n" + actualTitle + "\n" + expectedTitle + "\n");
		return actualTitle;
	}

	public String trimText(String text, boolean stripSpacesTabsNewLines) {
		if (stripSpacesTabsNewLines) {
			text = text.replaceAll("[\\n\\t\\r ]", "");
	    	
			text = text.replaceAll("[\\p{Cf}]", "");
	    	
			text = text.replaceAll("[\\p{Zp}]", "");
	    	
			text = text.replaceAll("[^\\x00-\\x7f]", "");
	    	
			text = text.replaceAll("[^a-zA-Z0-9\\s+]", "");
    	}
		return text;
	}


	public void validate(String cardType) throws ValidationException {
		try {
		WebElement header = driverManager.getDriver().findElement(By.xpath("(//span[@class='select-card ng-scope']/span[contains(@data-ng-show,'"+cardType+"')])[1]"));
//		DSA3:
//		WebElement header = driverManager.getWebDriver().findElement(By.xpath("//header[@id='header']//div[contains(@class,'Appbar_productName ')]"));
//		WebElement footerLegal = driverManager.getWebDriver().findElement(By.xpath("//p[@class='nosuchelements-footer__legalText ng-binding']"));
		WebElement footerLegal = driverManager.getDriver().findElement(By.xpath("//div[@id='sect1']"));
		String headerText = getText(header);
		String footerLegalText = getText(footerLegal);
		System.out.println("Header Notes: "+headerText);
		if(context.getLanguage().startsWith("E")) {
			switch(cardType) {
			case "OMX":
				headerText.contains("Triangle® Mastercard®");
				footerLegalText.contains("®/™ Mastercard, World Mastercard, World Elite and the circles are registered trademarks of Mastercard International Incorporated.");
				break;
			case "OMZ":
				headerText.contains("Triangle® World Elite® Mastercard®");
				footerLegalText.contains("®/™ Mastercard, World Mastercard, World Elite and the circles are registered trademarks of Mastercard International Incorporated.");
				break;
			case "OMP":
				headerText.contains("Gas Advantage® Mastercard®");
				footerLegalText.contains("®/™ Mastercard and the circles are registered trademarks of Mastercard International Incorporated.");
				break;
			case "OMR":
				headerText.contains("Cash Advantage® Mastercard®");
				footerLegalText.contains("®/™ Mastercard and the circles are registered trademarks of Mastercard International Incorporated.");
				break;
			}
		}
		else {
			switch(cardType) {
			case "OMX":
				headerText.contains("MastercardMD TriangleMD");
				footerLegalText.contains("MD/MC Mastercard, World Mastercard, World Elite et la conception de cercles sont des marques déposées de Mastercard International Incorporated.");
				break;
			case "OMZ":
				headerText.contains("World EliteMD MastercardMD TriangleMD");
				footerLegalText.contains("MD/MC Mastercard, World Mastercard, World Elite et la conception de cercles sont des marques déposées de Mastercard International Incorporated.");
				break;
			case "OMP":
				headerText.contains("MastercardMD Avantage EssenceMC");
				footerLegalText.contains("MD/MC Mastercard est une marque de commerce déposée de Mastercard International Incorporated, utilisée sous licence.");
				break;
			case "OMR":
				headerText.contains("MastercardMD Avantage RemiseMD");
				footerLegalText.contains("MD/MC Mastercard est une marque de commerce déposée de Mastercard International Incorporated, utilisée sous licence.");
				break;
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

	public static String returnProvince(String provinceSelected) {
		String province = "";
			switch(provinceSelected) {
			case "ALBERTA":
				province = "AB";
				break;
			case ("BRITISH COLUMBIA"):
			case ("COLOMBIE BRITANNIQUE"):
				province = "BC";
				break;
			case "MANITOBA":
				province = "MB";
				break;
			case ("NEW BRUNSWICK"):
			case ("NOUVEAU BRUNSWICK"):
				province = "NB";
				break;
			case "NEWFOUNDLAND AND LABRADOR":
				province = "NL";
				break;
			case ("NOVA SCOTIA"):
			case ("NOUVELLE-ÉCOSSE"):
				province = "NS";
				break;
			case ("NORTHWEST TERRITORIES"):
			case ("TERRITOIRES DU NORD-OUEST"):
				province = "NT";
				break;
			case "NUNAVUT":
				province = "NU";
				break;
			case "ONTARIO":
				province = "ON";
				break;
			case ("PRINCE EDWARD ISLAND"):
			case ("ÎLE-DU-PRINCE-ÉDOUARD"):
				province = "PE";
				break;
			case ("QUEBEC"):
			case ("QUÉBEC"):
				province = "QC";
				break;
			case "SASKATCHEWAN":
				province = "SK";
				break;
			case "YUKON":
				province = "YT";
				break;
					
			}
		return province;
			
	}
	
	private Connection conn = null;
	public String returnOccupationCatEng(String occupationCat, String language) {
		String occupationCatEng = "";
		String sqlQuery=null;
		
        try {
        		if(language.contains("F"))
        			sqlQuery = "select * from PDOWNER.JOB_DESCRIPTION where FRENCH_DESCRIPTION = ? ";
        		else
        			sqlQuery = "select * from PDOWNER.JOB_DESCRIPTION where ENGLISH_DESCRIPTION = ? ";
               PreparedStatement pstmt = null;
               System.out.println("Connecting to PDUSER DB");
               pstmt = conn.prepareStatement(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
               pstmt.setString(1, occupationCat);
               ResultSet rs = pstmt.executeQuery();
               rs.last();
               System.out.println("Result Set Size="+rs.getRow());
               rs.beforeFirst();
               if (rs.next() == false) {
                     Assert.fail("No Matching Stored Value found");
               }
               rs.beforeFirst();
               while (rs.next()) {
            	   occupationCatEng = rs.getString("STORED_VALUE");
                     System.out.println("Stored Job Desc="+occupationCatEng);
               }
               rs.close();
               pstmt.close();
        }
        catch (Exception e){
               e.printStackTrace();
               Assert.fail("Failed to get Stored Value for given Job Description");
        }
        
        return occupationCatEng;

	}
	
	public static void main(String args[]) {
//		CommonUtils comm = new CommonUtils();
//		String frc = comm.
//				String frc = returnOccupationCatEng("Professional/Exec","E");
//		System.out.println("frc value: "+frc);
		
	}

}
