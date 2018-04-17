package com.virtualpairprogrammers.services.customers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.domain.Customer;

public class CustomerManagementServiceMockImpl implements CustomerManagementService {
	
	
	private Map<String, Customer> testCustomers = new HashMap<String, Customer>();
	
	public CustomerManagementServiceMockImpl() {
		Customer c1 = new Customer("c1", "Cisco", "Important");
		Customer c2 = new Customer("c2", "Cisco", "Very Important");
		Customer c3 = new Customer("c3", "Cisco", "Important");
		Customer c4 = new Customer("c4", "Cisco", "Not Important");
	}
	

	@Override
	public void newCustomer(Customer newCustomer) {
		testCustomers.put(newCustomer.getCustomerId(), newCustomer);
	}

	@Override
	public void updateCustomer(Customer changedCustomer) {
		testCustomers.replace(changedCustomer.getCustomerId(), changedCustomer);
	}

	@Override
	public void deleteCustomer(Customer oldCustomer) {
		testCustomers.remove(oldCustomer.getCustomerId());

	}

	@Override
	public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
		return testCustomers.get(customerId);
	}

	@Override
	public List<Customer> findCustomersByName(String name) {
		ArrayList<Customer> arrayOfCustomer = new ArrayList<Customer>();
		
		for (Customer customer : testCustomers.values()) {
			if (customer.getCompanyName().equals(name)) {
				arrayOfCustomer.add(customer);
			}
		}
			
		return arrayOfCustomer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> listOfAllCustomers = new ArrayList(testCustomers.values());
		// TODO Auto-generated method stub
		return listOfAllCustomers;
	}

	@Override
	public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
		// TODO Auto-generated method stub

	}

}
