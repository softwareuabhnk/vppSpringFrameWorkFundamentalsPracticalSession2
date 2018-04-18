package com.virtualpairprogrammers.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.virtualpairprogrammers.domain.Customer;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;
import com.virtualpairprogrammers.services.diary.DiaryManagementService;

public class SpringTestHarness {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext container = new
				ClassPathXmlApplicationContext("application.xml");

				CustomerManagementService cms = 
						container.getBean("servicesCustomer", CustomerManagementService.class);
				
				DiaryManagementService dms = 
						container.getBean("servicesDiary", DiaryManagementService.class);
				
				
				// Test services Customers
				Customer newCustomer = new Customer("c5", "Ericsson", "Important");
				cms.newCustomer(newCustomer);
				
				List<Customer> allCustomers =  cms.getAllCustomers();
				
				for(Customer next: allCustomers) {
					System.out.println(next);
				}
				
				try {
				Customer findCustomer = cms.findCustomerById("c2");
				System.out.println(findCustomer);
				}
				catch (CustomerNotFoundException e) {
					System.out.println(e);
				}
				
				
				// Test services Diary
				System.out.println(dms.getAllIncompleteActions("Mike Jones"));
				
				
				container.close();

		}
}
