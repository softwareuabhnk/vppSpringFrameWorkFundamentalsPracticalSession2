package com.virtualpairprogrammers.client;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpairprogrammers.domain.Action;
import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.calls.CallHandlingService;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;
import com.virtualpairprogrammers.services.diary.DiaryManagementService;

public class SpringTestHarness {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext container = new
				ClassPathXmlApplicationContext("application.xml");
		
		
				CallHandlingService chs = 
						container.getBean("servicesCalls", CallHandlingService.class);
		

				CustomerManagementService cms = 
						container.getBean("servicesCustomer", CustomerManagementService.class);
				
				DiaryManagementService dms = 
						container.getBean("servicesDiary", DiaryManagementService.class);
				
				
				
				// Test services Calls
				Customer c5 = new Customer("c5", "Ericsson", "Important");
				cms.newCustomer(c5);
				
				Call newCall = new Call("John from Ericcson called");
				
				Date date = new Date();
				GregorianCalendar requiredBy = new GregorianCalendar();
				requiredBy.setTime(date);
				requiredBy.add(Calendar.DATE, 1);
							
				//Calendar requiredBy = Calendar.getInstance();
		
				//requiredBy.add(Calendar.DATE,20);
				System.out.println(requiredBy);
				Action a1 = new Action("Call Laura", requiredBy, "Jens Carlsson" );
				System.out.println(requiredBy);
				Action a2 = new Action("email Laura", requiredBy , "Jens Carlsson" );
				
				
				
				Collection<Action> collection = new ArrayList<Action>();
				collection.add(a1);
				collection.add(a2);
				
				try {
				chs.recordCall("c5", newCall, collection);
				}
				catch (CustomerNotFoundException e) {
					System.out.println(e);
				}
				
				System.out.println(newCall.getTimeAndDate());
				
				// Test services Customers
				Customer c6 = new Customer("c6", "Enea", "Important");
				cms.newCustomer(c6);
				
				List<Customer> allCustomers =  cms.getAllCustomers();
				
				for(Customer next: allCustomers) {
					System.out.println(next);
				}
				
				try {
				Customer findCustomer = cms.findCustomerById("c2");
				System.out.println(findCustomer);
				}
				catch (CustomerNotFoundException e) {
					System.out.println("The customer does not exist");
				}
				
				
				// Test services Diary
				Collection<Action> imcompleteActions = dms.getAllIncompleteActions("Jens Carlsson");
				
				for (Action next: imcompleteActions) {
					System.out.println(next);
				}
				
				
				container.close();

		}
}
