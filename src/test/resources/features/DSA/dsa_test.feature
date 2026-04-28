Feature: TC-1



@Test_dsa 
Scenario Outline: Submit an application NonEcomm_OMP_Eng_CASL_Under18yrs

    Given Launch the Browser "chrome" and set the Language as "<Language>"
    And Launch DSA Application for "OMR"
    And User Starts Non Ecom Online Application
    Then User Agrees Cost of Credit Disclosure for Credit Card Application
    
    Then User is on Personal Information Page
    When User on Personal Information Page Enters "valid" in "FirstName" Field
    When User on Personal Information Page Enters "valid" in "LastName" Field
    And User on Personal Information Page Enters "valid" in "DOB" Field
    And User on Personal Information Page Enters "test@gmail.com" in "EmailAddress" Field
    And User on Personal Information Page Clicks on "PromoCheckbox" checkbox
    When User on Personal Information Page Selects "valid" in "PreferredLanguage" dropdown
    When User on Personal Information Page Selects "valid" in "PhoneType" dropdown
    When User on Personal Information Page Enters "99057353131" in "PhoneNumber" Field
    #And User on Personal Information Page Enters "3386598435" in "SIN" Field
    And User on Personal Information Page Clicks on "NextPI" button
    
    Then User is on Residential Information Page
    When User on Residential Information Page Enters "Valid Address" in AddressLookup field
    When User on Residential Information Page Selects "valid" in "ResidentialStatus" dropdown
    When User on Residential Information Page Enters "valid" in "HousingPayment" field
    When User on Residential Information Page Selects "valid" in "Month" dropdown
    When User on Residential Information Page Enters "2000" in "Year" field
    And User on Residential Information Page Clicks on "Next" Button
    
     Then User is on Financial Information Page
    When User on Financial Information Page Selects "Retired" in "EmploymentStatus" dropdown
    And User on Financial Information Page Enters "45000" in "AnlPersonalInc" Field
   	And User on Financial Information Page Enters "4000" in "AnlHousingInc" Field			 
    And User on Financial Information Page Clicks on "Next" Button
    
     And User is on My Preferences Page
    When User on My Preferences Page Clicks on "eStatements" button
    And User on My Preferences Page Clicks on "TermsAndConditions" checkbox
    And User on My Preferences Page Clicks on "Yes" for "Supplementarycard" Field
  	When User on My Preferences Page Enters "valid" for "SuppFirstName" Field
    When User on My Preferences Page Enters "valid" for "SuppLastName" Field
    When User on My Preferences Page Enters "valid" for "SuppDOB" Field
    And  User on My Preferences Page select "valid" in "SuppRelationship" dropdown
    When User on My Preferences Page Enters "valid" for "SuppPhoneNumber" Field
    And User on My Preferences Page Clicks on "SuppNewAddress" button
    And User on My Preferences Page Clicks on "SuppManualEntry" link
    When User on My Preferences Page Enters "1-709 RUE SAINT-ETIENNE" for "SuppAddressLine1" Field
    When User on My Preferences Page Enters "L'ASSOMTION" for "SuppCity" Field
    And User on My Preferences Page select "QUEBEC" in "SuppProvince" dropdown
    When User on My Preferences Page Enters "J5W1Y9" for "SuppPostal" Field
  	When User on My Preferences Page Clicks on "Next" button  
  	
    Then User is on Credit Protection Insurance Page
    When User on Credit Protection Insurance Page Clicks on "Yes" button
  	And User on CPI page Scrolls to the bottom of "Summary" Field
  	And User on Credit Protection Insurance Page Accepts popup with header "dd:DSA-IBM-CREDIT-PROTECTOR-022"
  	When User on Credit Protection Insurance Page Clicks on "TermsAndConditions" checkbox
  	When User on Credit Protection Insurance Page Clicks on "AssurantsPolicy" checkbox
  	When User on Credit Protection Insurance Page Clicks on "Next" button
  	
    Then User is on Review Page 
    And User on Review Page Clicks on "ExpandMyPref" Icon
  	Then User on Review Page Verifies Statements Mode
		And User on Review Page Verifies Supplementary Card Member Details
    When User on Review Page Scrolls to the bottom of "Authorization" Field
    And User on Review Page Clicks on "CollectionOfInfo" Checkbox
    And User on Review Page Clicks on "CreditReporting" Checkbox
    And User on Review Page Clicks on "Authorization" Checkbox
    And User on Review Page Clicks on "Submit" Button
    
    And User on Thank You Page Clicks "VerifyLater" button
    
    And Validate ICA screen for submitted application in TSYS ADM Screen ""
    And Validate various screens for submitted application in TSYS "RCRD,MCGI,MACD,MACR"
        
    And Launch ICV Application
    And Validate the ICV screen for application Submitted
    
    Examples:
    |Language|
    |E|
    #|E|
    #|E|
    #|E|
    #|E|
    
    
    