package com.plugsity.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plugsity.com.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByEmailOrPhoneNumber(String email,String phoneNumber);
	
	List<Customer> findByCustomerToken(String token);
}
