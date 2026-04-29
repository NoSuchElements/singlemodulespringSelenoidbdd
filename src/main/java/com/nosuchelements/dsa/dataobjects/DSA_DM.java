package com.nosuchelements.dsa.dataobjects;

import java.io.Serializable;

import lombok.Data;


@Data
public class DSA_DM implements Serializable{
	private String testID;
	private String firstName;
	private String lastName;
	private String initial;
	private String channel;
	public DSA_DM() {
		// TODO Auto-generated constructor stub
	}
	

	private String title;
	private String gender;
	
	
	private String cardType;
	private String language;
	private String preferLanguage;
	private String promoCode;
	private String email;
	private String phoneType;
	private String phoneNumber;
	private String dob;
	private String dob1;
	

	private String UnitNumber;
	private String addressLine1;
	private String addressLine2;
	private String cityString;
	private String cityLongName;
	private String province;
	private String postCode;	
	private String loyaltyProgram;
	private String loyaltyNumber;
	private String loyaltyGroup;
	private String sin;
	private String residenceType;
	private String monthlyRentString;
	private String yrAtAddress;
	private String monthatAddress;
	private String previousUnitNo;
	private String previousAdd1;
	private String previousAdd2;
	private String previousCityString;
	private String previousCityLong;
	private String previousPostCode;
	private String previousProvince;
	
	private String employementType;
	private String employementstatus;
	private String jobCategory;
	private String jobTitle;
	private String employerName;
	private String employerCity;
	private String employerProvince;
	private String employerPhone;
	private String monthOfEmployement;
	private String yrOfEmployement;
	private String jobTitleOther;
	private String personalIncFrequency;
	private String houseIncomeFrequency;
	private String personalincome;
	private String householdincome;
	private String grossPersonalIncome;
	private String grossHouseholdIncome;
	private String creditLimit;
	
	private String CPIEnroll;
	private String CPIType;
	
	
	private String trngleMemship;
	private String stmtMode;
	private String supplAccount;
	private String suppFirstName;
	private String suppLastName;
	private String suppInitial;
	private String suppDob;
	private String suppRelationship;
	private String suppPhoneNumberString;
	private String suppStreetNumber;
	private String suppStreetName;
	private String suppSuitNumber;
	private String suppCity;
	private String suppCityLong;
	private String suppProvince;
	private String suppPostCode;
	private String suppAddress2;
	private String suppAddress1;
	
	
	private String storeNum;
	private String associateId;

	
	private String skConsent;
	private String skFirstName;
	private String skLastName;
	private String skdob;
	private String skpostalCode;
	private String skIdDocNumber;
	private String skIdDocType;
	private String skIdExpiryDate;
	private String skIdIssuingAuthority;
	private String skIdIssueDate;
	private String skIdSource;
	private String skIdIssuingCountry;
	private String skScanResult;
	private String skSuspectedFlag;
	private String skRejectedFlag;
	
	//DASH Enroll
	private String dash_userName;
	private String dash_password;
	
}
