package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	
	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public Customer get(long id) {
		return customerRepository.findOne(id);
	}


	@Override
	public List<Customer> getCustomersByFirstName(String firstName) {
		return customerRepository.getCustomersByFirstName(firstName);
	}

}
