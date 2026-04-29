package com.nosuchelements.steps.dsa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.ResidentialInfoPage;
import com.nosuchelements.utils.dsa.CommonUtils;

import io.cucumber.java.en.And;

public class ResidentialInformationStepDef extends BasePage {
	
	@Autowired
	private ResidentialInfoPage RI;
	
	@Autowired
	private CommonUtils commutil;
	
	@And("User Enters Residential Information")
	public void enterResidentialIndo()
	{
		try
		{
			RI.residentialInformation(context.getDsaDmData());
		}catch(Exception e) {
			Assert.fail("Failed to Enter Residential Information");
			e.printStackTrace();
		}
	}
	
	@And("User is on Residential Information Page")
	public void verifyResidentialInfo() {
		try
		{
			waitForSeconds(5);
			commutil.validate(context.getDsaDmData().getCardType());
			RI.validate();
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to Validate Residential Information");
		}
	}
	
	@And("Verify the Address List should be {string}")
	public void verifyAddressList(String type) throws Exception
	{
		boolean status = false;
		try
		{
			
			if(type.equalsIgnoreCase("displayed"))
			{
				status = RI.verifyAddressList();
			}
			else {
				status = !(RI.verifyAddressList());
			}
			if(!status)
			{
				Assert.fail("Failed to verify the Address List");
			}
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify the Address List");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	@And("User on Residential Information Page Enters {string} Postal Code in AddressLookup field")
	public void selectMultipleAddress(String postalCode) throws Exception
	{
		try
		{
			inputText(RI.getAddressLookUpField(),postalCode );
			if(isElementVisible(getElementWhenVisible(By.xpath("//span[@class='pcadescription']//following-sibling::div")))) {
				clickElement(getElementWhenVisible(By.xpath("("+RI.getLookUpAddress()+")[1]")));
				clickElement(getElementWhenVisible(By.xpath("("+RI.getLookUpAddress()+")[1]")));
				
			}
			if(isElementVisible(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[1]"))))
			{
				DSA_DM dsaDMData = context.getDsaDmData();
				dsaDMData.setAddressLine1(getText(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[1]"))));
				String text = getText(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[3]")));
				String addr[] = text.split(",");
				dsaDMData.setCityString(addr[0]);
				dsaDMData.setProvince(addr[1].trim());
				dsaDMData.setPostCode(getText(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[4]"))));
				context.setDsaDmData(dsaDMData);
			}
			
			else
				System.out.println("Unable to select address from Lookup");
		}
		catch(Exception e)
		{
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Enter Residential Information");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	@And("User on Residential Information Page Enters {string} in AddressLookup field")
	public void enterAddress(String addressType) throws Exception
	{
		try
		{
			switch (addressType) {
			case "Valid Address":
				String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
				try {
					int alphaNum = 12;
					inputText(RI.getAddressLookUpField(), alphabet[alphaNum]);
					waitForSeconds(5);
					waitForSeconds(5);
					int num = 3;
					System.out.println("xpath:"+RI.getLookUpAddress());
					WebElement al = getElementWhenVisible(By.xpath("("+getXpath(RI.getLookUpAddress())+")["+num+"]"));
					clickElement(al);
					while (isElementVisible(By.xpath("//button[@id='poErrorOkBtn']"))) {
						clickElementJS(getElementWhenVisible(By.xpath("//button[@id='poErrorOkBtn']")));
						inputText(RI.getAddressLookUpField(), "a");
						 num = 3;
						clickElement(getElementWhenVisible(By.xpath("("+getXpath(RI.getLookUpAddress())+")["+num+"]")));
					} 
				}catch(Exception e) {
					throw(e);
				}
				break;
			
			case "Special Characters": 
				String[] special = {"è","é","à","É","À","È","ç","Ç","ü","ë","ï","â","ò","ù","ê","ô","î","û","œ","Œ","æ","Æ","€","Ü","Ï","Û","Ù","Î","ä","Ä"};
				inputText(RI.getAddressLookUpField(), "D");
				int number = 3;
				int specNum = 12;
				WebElement al = getElementWhenVisible(By.xpath("("+getXpath(RI.getLookUpAddress())+")["+number+"]"));
				clickElement(al);
				while (isElementVisible(By.xpath("//button[@id='poErrorOkBtn']"))) {
					clickElementJS(getElementWhenVisible(By.xpath("//button[@id='poErrorOkBtn']")));
					inputText(RI.getAddressLookUpField(), "a");
					 number = 3; 
					clickElement(getElementWhenVisible(By.xpath("("+RI.getLookUpAddress()+")["+number+"]")));
				}
//				inputText(By.xpath(addressLine2),special[specNum-1]);
				break;
			
			default:
				
				inputText(RI.getAddressLookUpField(), addressType);
				waitForSeconds(4);
				clickElement(getElementWhenVisible(By.xpath("("+getXpath(RI.getLookUpAddress())+")[1]")));
				break;
			}
			
			 if(isElementVisible(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[1]"))))
//			if(isElementVisible(getElementWhenVisible(By.xpath("//h2[text()='Your address']//following-sibling::p"))))
			{
				DSA_DM dsaDMData = context.getDsaDmData();
				dsaDMData.setAddressLine1(getText(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[1]"))));
				String text = getText(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[3]")));
				String addr[] = text.split(",");
				dsaDMData.setCityString(addr[0]);
				dsaDMData.setProvince(addr[1].trim());
				dsaDMData.setPostCode(getText(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[4]"))));
				context.setDsaDmData(dsaDMData);
				
//				String selectedAddress = getText(getElementWhenVisible(By.xpath("//h2[text()='Your address']//following-sibling::p")));
//				System.out.println("Selected Address: "+selectedAddress);
//				String addr[] = selectedAddress.split("\n");
//				dsaDMData.setAddressLine1(addr[0]);
//				String addr1[] = addr[1].split(",");
//				dsaDMData.setCityString(addr1[0]);
//				dsaDMData.setProvince(addr1[1].trim());
//				dsaDMData.setPostCode(addr[2]);
//				context.setDsaDmData(dsaDMData);
			}
			else
				System.out.println("Unable to select address from Lookup");
		}
		catch(Exception e)
		{
			log.error("An error occurred: {}", e.getMessage(), e);
			e.printStackTrace();
			Assert.fail("Failed to Enter Residential Information");
			
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Enters {string} in Previous AddressLookup field")
	public void enterPrevAddress(String addressType) throws Exception
	{
		try
		{
			switch (addressType) {
			case "Valid Address":
				String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
				//div[@id='address_list']//div[@role='option']
				int letterNum = 14;
				int num = 2;
				inputText(RI.getPrevAddressLookup(), alphabet[letterNum]);
				WebElement al = getElementWhenVisible(By.xpath("("+getXpath(RI.getPrevLookupAddress())+")["+num+"]"));
				clickElement(al);
				while (isElementVisible(By.xpath("//button[@id='poErrorOkBtn']"))) {
					clickElementJS(getElementWhenVisible(By.xpath("//button[@id='poErrorOkBtn']")));
					inputText(RI.getAddressLookUpField(), "a");
					 num = 3;
					clickElement(getElementWhenVisible(By.xpath("("+getXpath(RI.getPrevLookupAddress())+")["+num+"]")));
				}
				break;
			
			case "Special Characters": 
				String[] special = {"è","é","à","É","À","È","ç","ü","ë","ï","â","ò","ù","ê","ô","î","û","Ä","Ë","Ü","Æ","æ","Œ","œ","€"};
				inputText(RI.getPrevAddressLookup(), "R");
				int number = 2;
				int specNum = 11;
				
				clickElement(getElementWhenVisible(By.xpath("("+RI.getPrevLookupAddress()+")["+number+"]")));
				while (isElementVisible(getElementWhenVisible(By.xpath("//button[@id='poErrorOkBtn']")))) {
					clickElementJS(getElementWhenVisible(By.xpath("//button[@id='poErrorOkBtn']")));
					inputText(RI.getAddressLookUpField(), "a");
					 number = 2; 
					clickElement(getElementWhenVisible(By.xpath("("+RI.getPrevLookupAddress()+")["+number+"]")));
				}
				inputText(RI.getPrevAddressLine2(),special[specNum-1]);
				break;

			default:
				
				inputText(RI.getPrevAddressLookup(), addressType);;
			}
			if(isElementVisible(getElementWhenVisible(By.xpath("//*[@class='formatted-address']/div[1]"))))
			{
				DSA_DM dsaDMData = context.getDsaDmData();
				dsaDMData.setPreviousAdd1(getText(getElementWhenVisible(By.xpath("//*[contains(@data-ng-show,'PrevAddress')]//div[@class='formatted-address']/div[1]"))));
//				if(getText(By.xpath("//*[@class='formatted-address']/div[2]"))=="") 
//					dsaDMData.setAddressLine2("");
//				else
//					dsaDMData.setAddressLine2(getText(By.xpath("//*[@class='formatted-address']/div[2]")));
				String text = getText(getElementWhenVisible(By.xpath("//*[contains(@data-ng-show,'PrevAddress')]//div[@class='formatted-address']/div[3]")));
				String addr[] = text.split(",");
				dsaDMData.setPreviousCityString(addr[0]);
				dsaDMData.setPreviousProvince(addr[1].trim());
				dsaDMData.setPreviousPostCode(getText(getElementWhenVisible(By.xpath("//*[contains(@data-ng-show,'PrevAddress')]//div[@class='formatted-address']/div[4]"))));
				context.setDsaDmData(dsaDMData);
			}
			else
				System.out.println("Unable to select previous address from Lookup");
		}
		catch(Exception e)
		{
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Enter Previous Residential Information");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Enters {string} in {string} field")
	public void enterValue(String type, String fieldName) throws Exception {
		WebElement element = null;
//		String value=null;
		String text = getInputText(type);
		try {
			DSA_DM updatedDetails = context.getDsaDmData();
			switch (fieldName) {
			
			case "HousingPayment":
				element = RI.getAfHousePayment();
				if(type.equals("valid"))
					text=Integer.toString(1984);
				else
					text=type;
				System.out.println("Monthly Rent = "+text);
				updatedDetails.setMonthlyRentString(text);
				break;
			case "Year":
				element = RI.getAfYear();
				if(type.equals("valid"))
					text=Integer.toString(2016);
				else
					text=type;
				updatedDetails.setYrAtAddress(text);
				break;
			
			case "AddressLine1":
				element = RI.getAddressLine1();
				updatedDetails.setAddressLine1(text);
				break;
			case "City":
				element = RI.getCityField();
				updatedDetails.setCityString(text);
				break;
			
			case "PostalCode":
				element = RI.getPostalCodeField();
				updatedDetails.setPostCode(text.replaceAll(" ", ""));
				break;
			case "AddressLine2":
				element = RI.getAddressLine2();
				updatedDetails.setAddressLine2(text);
				break;
			case "PrevUnitNumber":
				element = RI.getPrevUnitNumberField();
				updatedDetails.setPreviousUnitNo(text);
				break;
			case "PrevAddressLine1":
				element = RI.getPrevAddressLine1();
				updatedDetails.setPreviousAdd1(text);
				break;
			case "PrevAddressLine2":
				element = RI.getPrevAddressLine2();
				updatedDetails.setPreviousAdd2(text);
				break;
			case "PrevCity":
				element = RI.getPrevCityField();
				updatedDetails.setPreviousCityString(text);
				break;
			
			case "PrevPostalCode":
				element = RI.getPrevPostalCodeField();
				updatedDetails.setPreviousPostCode(text);
				break;	
			case "Unit":
				element = RI.getUnitNumberField();
				updatedDetails.setUnitNumber(text);
				break;
			}
			element.clear();
			element.sendKeys(text);
			context.setDsaDmData(updatedDetails);

		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Enter " + type + " in " + fieldName + " Field");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Selects {string} in {string} dropdown")
	public void selectOpt(String opt, String dropdown) throws Exception {
		try {
			DSA_DM updatedDetails = context.getDsaDmData();
			switch (dropdown) {
			case "ResidentialStatus":
			switch(opt) {
			case "valid":
//				RI.getResidentStatus().click();
//				driverManager.getWebDriver().findElement(By.xpath("//li[@data-value='Own']")).click();
				RI.selectOwn();
				opt = getInputText("dd:DSA-ADDRESS-FORM-0020");
				break;
			case "Own":
				opt = getInputText("dd:DSA-ADDRESS-FORM-0020");
				RI.selectOwn();
				break;
			case "Rent":
				opt = getInputText("dd:DSA-ADDRESS-FORM-0021");
				RI.selectRent();
				break;
			case "LiveWithParents":
				opt = getInputText("dd:DSA-ADDRESS-FORM-0022");
				RI.selectLivewithParents();
				break;
			case "StudentHousing":
				opt = getInputText("dd:DSA-ADDRESS-FORM-0023");
				RI.selectStudentHousing();
				break;
			case "Other":
				opt = getInputText("dd:DSA-ADDRESS-FORM-0024");
				RI.selectOther();
				break;
			}
				System.out.println("Residence Type: "+opt);
				updatedDetails.setResidenceType(opt);
				break;
			case "Month":
				if(opt.equalsIgnoreCase("valid")) {
					opt=getInputText("dd:DSA-MONTH-JUNE");
//					RI.getAfCurAddressMonth().click();
//					driverManager.getWebDriver().findElement(By.xpath("//li[@data-value='June']")).click();
					selectFromDropdownByText(RI.getAfCurAddressMonth(), opt.toString());
				}
				
				else
				{
					opt=getInputText("dd:DSA-MONTH-"+opt.toUpperCase());
					selectFromDropdownByText(RI.getAfCurAddressMonth(), opt.toString());
				}
				updatedDetails.setMonthatAddress(opt);
				break;
			case "PrevProvince":
				if(opt.equalsIgnoreCase("valid")) {
					opt=getInputText("dd:DSA-PROVINCE-09");
					selectFromDropdownByText(RI.getPrevProvinceField(), opt.toString());
				}
				else
					selectFromDropdownByText(RI.getPrevProvinceField(), opt);
				
				updatedDetails.setPreviousProvince(opt);
				break;
			case "Province":
				switch (opt) {
				case "valid":
//					opt=getInputText("dd:DSA-FINANCIAL-INFO-0002");
					opt = RI.selectAlberta();
					break;
				case "ALBERTA":
					opt = RI.selectAlberta();
					break;
				case "BRITISHCOLUMBIA":
					opt = RI.selectBritishColumbia();
					break;
				case "MANITOBA":
					opt = RI.selectManitoba();
					break;
				case "NEWBRUNSWICK":
					opt = RI.selectNewBrunswick();
					break;
				case "NEWFOUNDLANDANDLABRADOR":
					opt = RI.selectNewFoundLandAndLabrador();
					break;
				case "NOVASCOTIA":
					opt = RI.selectNovascotia();
					break;
				case "NORTHWESTTERRITORIES":
					opt = RI.selectNorthWestTeerritories();
					break;
				case "NUNAVUT":
					opt = RI.selectNunavut();
					break;
				case "ONTARIO":
					opt = RI.selectOntario();
					break;
				case "PRINCEEDWARDISLAND":
					opt = RI.selectPrinceEdwardIsland();
					break;
				case "QUEBEC":
					opt = RI.selectQubec();
					break;
				case "SASKATCHEWAN":
					opt = RI.selectSaskatchewan();
					break;
				case "YUKON":
					opt = RI.selectYukon();
					break;
				}
				
				updatedDetails.setProvince(opt);
				break;
			}
			context.setDsaDmData(updatedDetails);
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to Select " + opt + " from " + dropdown + " Dropdown");
			e.printStackTrace();
			throw new Exception(e);
		}
		
		
	}

	
	
	@And("User on Residential Information Page Verifies manual entry fields")
	public void verifyManualFields(String fieldName)
	{
		WebElement element = null;
		try
		{
	switch(fieldName) {
		case "AddressLine1":
			element = RI.getAddressLabel();
			break;
		case "AddressLine2":
			element = RI.getAddress2Label();
			break;
		case "City":
			element = RI.getCityLabel();
			break;
		case "Province":
			element = RI.getProvinceLabel();
			break;
		case "PostalCode":
			element = RI.getPostalCodeLabel();
			break;
		}
		}
		catch(Exception e) {
			
		}
	}
	
	@And("User on Residential Information Page Verifies {string} label should be {string}")
	@And("User on Residential Information Page Verifies {string} text should be {string}")
	public void verifyMessage(String fieldName, String message) throws Exception {
		message = getInputText(message);
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "Header":
				element = RI.getHeader();
				break;
			case "Instruction":
				element = RI.getInstructionMsg();
				break;
			case "AddressLookup":
				element = RI.getAddressLookUpFieldLabel();
				break;
			case "UnitNumber":
				element = RI.getUnitNumberLabel();
				break;
			case "AddressLine1":
				element = RI.getAddressLabel();
				break;
			case "AddressLine2":
				element = RI.getAddress2Label();
				break;
			case "City":
				element = RI.getCityLabel();
				break;
			case "Province":
				element = RI.getProvinceLabel();
				break;
			case "PostalCode":
				element = RI.getPostalCodeLabel();
				break;
			case "ResidentialStatus":
				element = RI.getResidentStatusLabel();
				break;
			case "HousingPayment":
				element = RI.getAfHousePaymentLabel();
				break;
			case "Month":
				element = RI.getAfCurAddressMonthLabel();
				break;
			case "Year":
				element = RI.getAfYearLabel();
				break;
			case "SelectPrevAdd":
				element = RI.getPrevAddressLookupLabel();
				break;
			case "PrevUnitNumber":
				element = RI.getPrevUnitNumberLabel();
				break;
			case "PrevAddressLine1":
				element = RI.getPrevAddressLine1Label();
				break;
			case "PrevAddressLine2":
				element = RI.getPrevAddress2Label();
				break;
			case "PrevCity":
				element = RI.getPrevCityLabel();
				break;
			case "PrevProvince":
				element = RI.getPrevProvinceLabel();
				break;
			case "PrevPostalCode":
				element = RI.getPrevPostalCodeLabel();
				break;	
			case "Next_ReviewPage":
				element=RI.getNextReviewRIBtn();
				break;
			case "LegalFootnotes":
				element = RI.getLegalFooternotes();
				RI.getLegalFootNotesExpand().click();
				break;
			}
			validateText(element, message);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify " + fieldName + " text should be " + message);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Verifies Valid Address Displays as view-only")
	public void verifyLookedUpAddress() throws Exception
	{
		try
		{
			validateText(context.getDsaDmData().getAddressLine1(),getText(getElementWhenVisible(By.xpath("(//*[@class='formatted-address']/div)[1]"))));
			String text = getText(getElementWhenVisible(By.xpath("(//*[@class='formatted-address']/div)[3]")));
			String addr[] = text.split(",");
			validateText(context.getDsaDmData().getCityString(),addr[0]);
			validateText(context.getDsaDmData().getProvince().toString(),addr[1].trim());
			validateText(context.getDsaDmData().getPostCode(),getText(getElementWhenVisible(By.xpath("(//*[@class='formatted-address']/div)[4]"))).trim());
		}
		catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to validate Looked Up Address");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Clicks on {string} Button")
	@And("User on Residential Information Page Clicks on {string} Link")
	public void clickOnElement(String fieldName) throws Exception {
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "Next":
				element = RI.getNextBtn();
				break;
			case "AddressCorrection":
				element = RI.getAddressCorrectionButton();
				break;	
				
			case "Edit":
				element = RI.getEditAddressLink();
				break;
			case "EnterManualAddress":
				element = RI.getEnterManualAddressLink();
				break;
			case "PrevEnterManualAddress":
				element = RI.getPrevEnterManualAddressLink();
				break;
			case "BackToReview":
				element = RI.getBackToReviewRI();
				break;
			}
//			clickElement(element);
			clickElementJS(element);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to click on " + fieldName );
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Verifies Valid Address Populated in Address Fields")
	public void verifyAddressInField() throws Exception
	{
		try
		{
			if(getAttribute(RI.getUnitNumberField(), "value").isEmpty()||getAttribute(RI.getUnitNumberField(), "value").equalsIgnoreCase(""))
			{
			 validateText(context.getDsaDmData().getAddressLine1(),getAttribute(RI.getAddressLine1(), "value"));
			}else 
			{
				validateText(context.getDsaDmData().getAddressLine1(),getAttribute(RI.getUnitNumberField(), "value")+"-"+getAttribute(RI.getAddressLine1(), "value"));
			}
			validateText(context.getDsaDmData().getCityString(),getAttribute(RI.getCityField(), "value"));
			validateText(context.getDsaDmData().getProvince().toString(),retrieveValueFromSelect(RI.getProvinceField()));
			validateText(context.getDsaDmData().getPostCode(),getAttribute(RI.getPostalCodeField(), "value"));
		}
		catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to validate Address in fields");
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Verifies {string} Field")
	@And("User on Residential Information Page Verifies {string} Link")
	@And("User on Residential Information Page Verifies {string} Button")
	public void verifyElement(String fieldName) throws Exception
	{
		WebElement element = null;
		try
		{
			switch (fieldName) {
			case "AddressLookup":
				element = RI.getAddressLookUpField();
				break;
			case "Next":
				element = RI.getNextBtn();
				break;
			case "UnitNumber":
				element = RI.getUnitNumberField();
				break;
			case "AddressLine1":
				element = RI.getAddressLine1();
				break;
			case "AddressLine2":
				element = RI.getAddressLine2();
				break;
			case "City":
				element = RI.getCityField();
				break;
			case "Province":
				element = RI.getProvinceField();
				break;
			case "PostalCode":
				element = RI.getPostalCodeField();
				break;
			case "EnterManualAddress":
				element = RI.getEnterManualAddressLink();
				break;
			case "ResidentialStatus":
				element = RI.getAfResiStatus();
				break;
			case "HousingPayment":
				element = RI.getAfHousePayment();
				break;
			case "Month":
				element = RI.getAfCurAddressMonth();
				break;
			case "Year":
				element = RI.getAfYear();
				break;
			case "SelectPrevAdd":
				element = RI.getPrevAddressLookup();
				break;
			case "PrevEnterManualAddress":
				element = RI.getPrevEnterManualAddressLink();
				break;
			case "PrevUnitNumber":
				element = RI.getPrevUnitNumberField();
				break;
			case "PrevAddressLine1":
				element = RI.getPrevAddressLine1();
				break;
			case "PrevAddressLine2":
				element = RI.getPrevAddressLine2();
				break;
			case "PrevCity":
				element = RI.getPrevCityField();
				break;
			case "PrevProvince":
				element = RI.getPrevProvinceField();
				break;
			case "PrevPostalCode":
				element = RI.getPrevPostalCodeField();
				break;	
			
			}
			waitForVisible(element);
		}
		catch(Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify " + fieldName );
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	@And("User on Residential Information Page Enters {string}")
	public void enterManualAddress(String address) throws Exception
	{
		try
		{
			System.out.println("Length is "+address.split(",").length);
			for(String addr:address.split(","))
			{
				System.out.println("Address Line "+addr);
			}
			if(address.split(",").length == 4)
			{
				DSA_DM dsaDMData = context.getDsaDmData();
				
				inputText(RI.getAddressLine1(), address.split(",")[0]);
				inputText(RI.getCityField(), address.split(",")[1]);
				selectFromDropdownByText(RI.getProvinceField(), address.split(",")[2].trim());
				inputText(RI.getPostalCodeField(), address.split(",")[3].trim());
				
				dsaDMData.setAddressLine1(address.split(",")[0]);
				dsaDMData.setCityString(address.split(",")[1]);
				dsaDMData.setProvince(address.split(",")[2].trim());
				dsaDMData.setPostCode(address.split(",")[3].trim());
				context.setDsaDmData(dsaDMData);
			}
		}catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to enter "+address);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Verifies the Inline Error Message for {string} Field as {string} in {string} Colour")
	public void verifyerror(String fieldName ,String _text, String colour) throws Exception {
		try {
			String expText=getInputText(_text);
			WebElement element =null;
			switch(fieldName) {
			case "AddressLookup":
				element = RI.getAddressLookUpError();
				break;
			case "AddressLine1":
				element = RI.getAddressLine1Error();
				break;
			case "City":
				element = RI.getCityError();
				break;
			case "PostalCode":
				element = RI.getPostalCodeError();
				break;
			case "Province":
				element = RI.getProvinceError();
				break;
			case "ResidentialStatus":
				element = RI.getResidentialStatusError();
				break;
			case "HousingPayment":
				element = RI.getHousingPaymentError();
				break;
			case "Month":
				element = RI.getCurrAddrMonthError();
				break;
			case "Year":
				element = RI.getCurrAddrYearError();
				break;
			case "PrevAddressLookup":
				element = RI.getPrevAddressLookUpError();
				break;
			case "PrevAddressLine1":
				element = RI.getPrevAddressLine1Error();
				break;
			case "PrevCity":
				element = RI.getPrevCityError();
				break;
			case "PrevPostalCode":
				element = RI.getPrevPostalCodeError();
				break;
			case "PrevProvince":
				element = RI.getPrevProvinceError();
				break;
			}
			
			if(expText.equalsIgnoreCase("NoError"))
			{
				if(isElementVisible(element)) {
					Assert.fail("Failed to verify Inline Error Message for "+fieldName+" is not displayed");
				}
			}else {
				verifyErrorMessage(element, expText, colour);
			}
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Inline Error Message for "+fieldName);
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	@And("User on Residential Information Page Verifies the Inline Error Message for {string} Dropdown should not be displayed")
	@And("User on Residential Information Page Verifies the Inline Error Message for {string} Field should not be displayed")
	public void verifyErrorNotDisplayed(String fieldName) throws Exception {
		WebElement element =null;
		try {
			switch (fieldName) {
			case "AddressLookup":
				element = RI.getAddressLookUpError();
				break;
			case "AddressLine1":
				element = RI.getAddressLine1Error();
				break;
			case "City":
				element = RI.getCityError();
				break;
			case "PostalCode":
				element = RI.getPostalCodeError();
				break;
			case "Province":
				element = RI.getProvinceError();
				break;
			case "ResidentialStatus":
				element = RI.getResidentialStatusError();
				break;
			case "HousingPayment":
				element = RI.getHousingPaymentError();
				break;
			case "Month":
				element = RI.getCurrAddrMonthError();
				break;
			case "Year":
				element = RI.getCurrAddrYearError();
				break;
			case "PrevAddressLine1":
				element = RI.getPrevAddressLine1Error();
				break;
			case "PrevCity":
				element = RI.getPrevCityError();
				break;
			case "PrevPostalCode":
				element = RI.getPrevPostalCodeError();
				break;
			case "PrevProvince":
				element = RI.getPrevProvinceError();
				break;
				
			}
			if (isElementVisible(element)) {
				Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
			}
			;
		} catch (Exception e) {
			log.error("An error occurred: {}", e.getMessage(), e);
			Assert.fail("Failed to verify Inline Error Message for " + fieldName + " is not displayed");
			e.printStackTrace();
			throw new Exception(e);
		}
	}

}
