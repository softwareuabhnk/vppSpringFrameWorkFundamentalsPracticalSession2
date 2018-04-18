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
		Customer c2 = new Customer("c2", "Volvo", "Very Important");
		Customer c3 = new Customer("c3", "Redhat", "Important");
		Customer c4 = new Customer("c4", "Cisco", "Not Important");
		
		testCustomers.put("c1", c1);
		testCustomers.put("c2", c2);
		testCustomers.put("c3", c3);
		testCustomers.put("c4", c4);
		
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
		
		if (testCustomers.get(customerId) != null) {
		return testCustomers.get(customerId);
		}
		throw new CustomerNotFoundException();
	}

	@Override
	public List<Customer> findCustomersByName(String name) {
		List<Customer> arrayOfCustomer = new ArrayList<Customer>();
		
		for (Customer customer : testCustomers.values()) {
			if (customer.getCompanyName().equals(name)) {
				arrayOfCustomer.add(customer);
			}
		}
			
		return arrayOfCustomer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> arrayOfCustomers = new ArrayList<Customer>(testCustomers.values());
		return arrayOfCustomers;
	}

	@Override
	public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
		return this.findCustomerById(customerId);
	}

	@Override
	public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
		Customer  customer = this.getFullCustomerDetail(customerId);
		customer.addCall(callDetails);
		
	}

}
