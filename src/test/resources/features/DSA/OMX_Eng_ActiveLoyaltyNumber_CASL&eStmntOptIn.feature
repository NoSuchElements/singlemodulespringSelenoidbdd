Feature: TC-2914  TC-23321   TC-8251

@OMX_Eng_ActiveLoyaltyCASLestatment   @critical @QTEST_TC_8251
Scenario: Submit an application for Ecomm_OMX_Eng_CASLeStmnt_Optin

 Given Launch the Browser "chrome" and set the Language as "E"
  
    And Launch New Ecomm Simulator
    And BeginApp from empty New Simulator
    And User on Cards Page selects Product Type as "OMX"
    And User Starts Online Application
    Then User Agrees Cost of Credit Disclosure for Credit Card Application
 		And User on Personal Information Page Clicks on "Next" button
 		
    Then User is on Personal Information Page
    When User on Personal Information Page Enters "NCATGTQT" in "FirstName" Field
    When User on Personal Information Page Enters "AUTONNOPI" in "LastName" Field
    And User on Personal Information Page Enters "1983/05/05" in "DOB" Field
    And User on Personal Information Page Enters "test@gmail.com" in "EmailAddress" Field
    #And User on Personal Information Page Clicks on "PromoCheckbox" checkbox
    When User on Personal Information Page Selects "English" in "PreferredLanguage" dropdown
    When User on Personal Information Page Selects "Home Phone" in "PhoneType" dropdown
    When User on Personal Information Page Enters "99057349776" in "PhoneNumber" Field
    And User on Personal Information Page Enters "valid" in "SIN" Field
    And User on Personal Information Page Clicks on "NextPI" button
    
    Then User is on Residential Information Page
    And User on Residential Information Page Clicks on "EnterManualAddress" Button
    And User on Residential Information Page Enters "394 CLARE AVE" in "AddressLine1" field
    And User on Residential Information Page Enters "Welland" in "City" field
    And User on Residential Information Page Selects "ONTARIO" in "Province" dropdown
    And User on Residential Information Page Enters "L3C5R2" in "PostalCode" field
    When User on Residential Information Page Selects "valid" in "ResidentialStatus" dropdown
    When User on Residential Information Page Enters "valid" in "HousingPayment" field
    When User on Residential Information Page Selects "May" in "Month" dropdown
    When User on Residential Information Page Enters "2017" in "Year" field
    And User on Residential Information Page Clicks on "Next" Button
    
    Then User is on Financial Information Page
	  When User on Financial Information Page Selects "Full time" in "EmploymentStatus" dropdown
    And User on Financial Information Page Enters "valid" in "Employer" Field
    And User on Financial Information Page Enters "valid" in "City" Field
 	  When User on Financial Information Page Selects "valid" in "JobCategory" dropdown
    When User on Financial Information Page Enters "Branch Manager" in "JobDescription" Field
    And User on Financial Information Page Enters "valid" in "PhoneNumber" Field
    When User on Financial Information Page Selects "valid" in "Month" dropdown
    And User on Financial Information Page Enters "valid" in "Year" Field
 	  And User on Financial Information Page Enters "50000" in "AnlPersonalInc" Field	
 	  And User on Financial Information Page Enters "2000" in "AnlHousingInc" Field		 
    And User on Financial Information Page Clicks on "Next" Button
    
    And User is on My Preferences Page
    When User on My Preferences Page Clicks on "eStatements" button
    And User on My Preferences Page Clicks on "TermsAndConditions" checkbox
    And User on My Preferences Page Clicks on "Yes" for "TraingleMembership" Field
    When User on My Preferences Page Enters "New" for "TraingleCardNo" Field
    When User on My Preferences Page Clicks on "Next" button
    
    Then User is on Credit Protection Insurance Page
    When User on Credit Protection Insurance Page Clicks on "No" button
    When User on Credit Protection Insurance Page Clicks on "Next" button
    
    Then User is on Review Page
    When User on Review Page Scrolls to the bottom of "Authorization" Field
    And User on Review Page Clicks on "CollectionOfInfo" Checkbox
    And User on Review Page Clicks on "CreditReporting" Checkbox
    And User on Review Page Clicks on "Authorization" Checkbox
    And User on Review Page Clicks on "Submit" Button
    
    And User on Thank You Page Clicks "VerifyLater" button
    And User is on Thank You Page
    
	  
  #END