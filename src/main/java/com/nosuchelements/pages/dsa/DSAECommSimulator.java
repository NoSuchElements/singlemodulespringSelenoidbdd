package com.nosuchelements.pages.dsa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.nosuchelements.annotations.PageObject;
import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.ui.utils.expectedConditions.ValidationException;

import lombok.Data;

@PageObject
@Data
public class DSAECommSimulator extends BasePage{


	@FindBy(how = How.XPATH, using = "//body[@onload='generateGUID()']")
    private WebElement base;
	
	@FindBy(how = How.XPATH, using = "//body[@onload='generateGUID()']/form")
    private WebElement tableForm;
	
	@FindBy(how = How.XPATH, using = "//table[@class='webGrid']/tbody")
    private WebElement table;
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-firstName']")
    private WebElement firstName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-lastName']")
    private WebElement lastName;
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-addressLine1']")
    private WebElement AddressLine1;
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-city']")
    private WebElement City;
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-postalCode']")
    private WebElement Postal;
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-phone']")
    private WebElement phone;
	
	@FindBy(how = How.XPATH, using = "//select[@id='outlined-select-province-native']")
    private WebElement province;
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-redirectUrl']")
    private WebElement redirectUrl;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'MuiButtonBase')]//span[contains(text(),'Credit')]")
    private WebElement beginBtn;
	
	
	/*public DSA_DM testDataProvider(String type) {
		RetrieveDsaData retriever = new RetrieveDsaData();
		DSA_DM dsa = retriever.setDSAData(type);
		return dsa;
	}
	
	public GenerateCustomerName getCustomerName() {
		GenerateCustomerName customerName = new GenerateCustomerName();
//		NameGenerator newName = new NameGenerator();
		customerName.setFirstName(MisfunctionsUtils.generateRandomFirstName());
		customerName.setLastName(MisfunctionsUtils.generateRandomLastName());
		return customerName;
	}  */
	
	
	public void completNewSimulator(DSA_DM dsa) throws InterruptedException
	{
		System.out.println("My name is " + dsa.getFirstName() + " " + dsa.getLastName());
		inputText(firstName, dsa.getFirstName());
		inputText(lastName, dsa.getLastName());
//		inputText(By.xpath(phone), dsa.getPhoneNumber());
		inputText(AddressLine1, dsa.getAddressLine1());
		inputText(City, dsa.getCityString());
		inputText(Postal, dsa.getPostCode());
		inputText(redirectUrl, "https://www.saucedemo.com");
		
		if(dsa.getProvince().contains("-"))
		selectFromDropdownByValue(province, dsa.getProvince().substring(0, 2));
		else
			selectFromDropdownByValue(province, dsa.getProvince());
		clickElement(beginBtn);
		log.info("Leaving EComm Simulator");
	}
	
	public void BeginSimApp(DSA_DM dsa) throws InterruptedException
	{
		inputText(redirectUrl, "https://www.saucedemo.com");
		clickElement(beginBtn);
		log.info("Leaving EComm Simulator empty and beginning application");
	}

}
