package com.packt.webstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

//	Customer getCustomerById(long key);
	
	@Query("SELECT c FROM CUSTOMER c")
	public List<Customer> getAllCustomers();
	
	List<Customer> getCustomersByFirstName(String firstName);	

}
