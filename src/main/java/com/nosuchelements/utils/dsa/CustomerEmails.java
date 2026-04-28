package com.nosuchelements.utils.dsa;

import java.util.ArrayList;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerEmails {
//	Logger log = LogManager.getLogger(CustomerEmails.class);
	private final static Logger log = LoggerFactory.getLogger(CustomerEmails.class);

	public static void main(String[] args) {
		CustomerEmails.getInstance().getRandomEmail();
	}
	private static CustomerEmails uniqInstance = null;
	public ArrayList<String> list;

	public static CustomerEmails getInstance() {
	    if (uniqInstance == null) 
	         uniqInstance = new CustomerEmails();
	    return uniqInstance;
	}
	
	private CustomerEmails() {
		list = new ArrayList<String>();
	}
	
 	public ArrayList<String> getArrayList(){
	      return this.list;
	     }
 	
 	public void addToArray(String value) {
         list.add(value);
        }
 	
 	public String getRandomEmail() {	
 		getInstance().addToArray("tester8969@gmail.com");
 		getInstance().addToArray("test.e.r8.969@gmail.com");
 		getInstance().addToArray("te.s.te.r89.69@gmail.com");
 		getInstance().addToArray("t.e.s.te.r897.2@gmail.com");
 		getInstance().addToArray("test.er8.9.72@gmail.com");
 		getInstance().addToArray("tester.89.72@gmail.com");
 		getInstance().addToArray("te.s.t.e.r8.97.2@gmail.com");
 		getInstance().addToArray("t.es.t.er.8.97.2@gmail.com");
 		getInstance().addToArray("t.e.s.t.er8.9.72@gmail.com");
 		getInstance().addToArray("te.s.t.er8.972@gmail.com");
 		getArrayList();
 		
 		log.info("Getting Customer email address");
 		int randomIndex = generator.nextInt(CustomerEmails.getInstance().list.size());
		String email = CustomerEmails.getInstance().list.get(randomIndex);
		log.info("Applicants Email Address: " + email);
		System.out.println("Applicants Email Address: " + email);
 		return email;
 	}
 	
 	Random generator = new Random();
 	public String _RandomEmail() {
 		log.info("Getting Customer email address");
 		int randomIndex = generator.nextInt(CustomerEmails.getInstance().list.size());
		String email = CustomerEmails.getInstance().list.get(randomIndex);
		log.info("Applicants Email Address: " + email);
		System.out.println("Applicants Email Address: " + email);
 		return email;
 	}
 	

}
