package com.nosuchelements.steps.dsa;

import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.dsa.dataobjects.DSA_DM;
import com.nosuchelements.pages.BasePage;
import com.nosuchelements.pages.dsa.DSAECommSimulator;
import com.nosuchelements.session.SessionContext;
import com.nosuchelements.utils.dsa.CustomerEmails;

import io.cucumber.java.en.And;

public class DSACustomerInfo extends BasePage {
	
	
	@Autowired
	private DSAECommSimulator dsaSimulator;
	
	private DSA_DM dsa;
	String applicantEmail;
	
	public DSACustomerInfo(SessionContext context)
	{
		this.context = context;
	}
	
	
	@And("Fill and Complete the New Simulator for {string}")
	public void fillAndCompleteNewSimulator(String type)
	{
		try
		{
//			dsa = dsaSimulator.testDataProvider(type);
//			System.out.println("DSA Details "+dsa);
//			GenerateCustomerName name = dsaSimulator.getCustomerName();
//			dsa.setFirstName(name.getFirstName());
//			dsa.setLastName(name.getLastName());
//			System.out.println("First Name "+name.getFirstName());
//			System.out.println("Last Name "+name.getLastName());
			if (dsa.getEmail().equals("")) {
				applicantEmail = CustomerEmails.getInstance().getRandomEmail();
				System.out.println("EMAIL ADD " + applicantEmail);
			} else {
				applicantEmail = dsa.getEmail();
			}
			dsa.setEmail(applicantEmail);
			context.setDsaDmData(dsa);
			dsaSimulator.completNewSimulator(dsa);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@And("Fill and Complete the New Simulator")
	public void fillAndCompleteNewSimulator()
	{
		try
		{
			dsa=context.getDsaDmData();
			System.out.println("DSA Details "+dsa);
			dsaSimulator.completNewSimulator(dsa);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@And("BeginApp from empty New Simulator")
	public void BeginAppNewSimulator()
	{
		try
		{
			dsa=context.getDsaDmData();
			dsaSimulator.BeginSimApp(dsa);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@And("BeginApp from empty Simulator for {string}")
	public void BeginAppSimulator(String type)
	{
		try
		{
//			dsa = dsaSimulator.testDataProvider(type);
			System.out.println("DSA Details "+dsa);
			context.setDsaDmData(dsa);
			dsaSimulator.BeginSimApp(dsa);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
