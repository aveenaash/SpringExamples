package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();

	void addCustomer(Customer customer);

	Customer get(long id);
	
	List<Customer> getCustomersByFirstName(String firstName);
	

}
