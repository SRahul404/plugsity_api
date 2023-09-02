package com.plugsity.com.service;

import java.util.List;
import java.util.Map;

import com.plugsity.com.model.Customer;
import com.plugsity.com.request.CustomerRequestDTO;

public interface CustomerService {
	
	List<Customer> getAllCustomer();
	Map<String,Object> saveCustomer(CustomerRequestDTO customerRequestDTO);
	Customer getCustomerById(long id);
    void deleteCustomerById(long id);
    List<Customer> findByEmailOrPhoneNumber(String email,String phoneNumber);

}
