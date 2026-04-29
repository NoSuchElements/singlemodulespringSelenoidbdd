package com.nosuchelements.session;

import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Component;

import com.nosuchelements.dsa.dataobjects.ADM_DTO;
import com.nosuchelements.dsa.dataobjects.DSA_DM;

import lombok.Data;

@Component
@Data
public class SessionContext {
	
	//DSA
	
	private DSA_DM dsaDmData;
	private ADM_DTO admDto;
	private String Language;
	private String apiResponse = null;
	
	//DASH

	private String customer;
	private Language language = null;
	private String parentWindowHandleIDs;
	private String otc;
//	public DashProfileDTO profileDetails;
//	public BankProfileDTO bankProfileDetails;
//	public String profileType;
//	private List<CardSelectorItemDTO> cardSelectorValues;
//	public BankAcquisition_DTO UpdatedContactDetails;
//	public BankAcquisition_DTO BankAcq;
//	public String CustEmailAddress;
//	private ContactInfoDTO currentContactDtls;
//	private ContactInfoDTO updatedContactDtls;
//	private OneTimePaymentDTO oneTimePaymentInfo;
//	private RecurringPaymentDTO recurringPaymentInfo;
//	private Old_RecurringPaymentDTO OldrecurringPaymentInfo;
//	private String Last4DigitOnEmail;
//	private BankCustomerDetails_DTO bankCustDetails;
//	private PayeeDTO payee_dto;
//	private MakeATransferAppInfo_DTO appInfo_dto;
//	private String interacPaymentAmount;
//	private RetailBankSummary_DTO summaryDTO;
//	public Map<String, CreditProductLabel_DTO> creditProductLabels;
//	private Map<String, BankProductLabelsDTO> bankProductLabels;
	public String SelectedCardTitle;
	public String InsuranceName;
//	private UpdatedOTP_Payment_DTO updatedOtpPayments;
//	private List<ScheduledOTPPaymentsDTO> scheduledOTPPaymentsList;
//	private ScheduledOTPPaymentsDTO scheduledOTPPayments;
//	private Migration_DTO migration_dto;
//	private OldOTP_Payment_DTO oldOtpPayments;
//	private MAAP_DTO maapDto;
//	private MOLP_DTO molpDto;
//	private MCFI_DTO mcfiDto;
//	private Activity_DTO activityDto;
//	private WAGN_DTO wagn_DTO;
//	private Address residenceAddressSuggession;
//	private Address mailingAddressSuggession;
//	private String onlineEnrolmentUserName;
//	private EmailChangeDTO emailChangeDto;
//	private OBP_DTO obpDetails;
//	private List<OBP_DTO> obpDetailsList;

	private String oldPin;
	private String newPin;
	private long TsysrespKey;
//	public DashProfileDTO profileDetails_copy;
//	public BankProfileDTO bankProfileDetails_copy;
//
//	private List<BalanceTransferDetail_DTO> btList;
//
//	private ScheduledPayeeDTO scheduledPayee;
//	private MissedPaymentsDeatilsDTO missedPaymentsDeatilsDTO;

//	public List<PayeeDTO> payeedtoList;
	public String dbOrginalEmail;
	public String cliAmount;

}
