package com.plugsity.com.service;

import java.util.List;
import java.util.Map;

import com.plugsity.com.model.Customer;
import com.plugsity.com.model.CustomerInvite;
import com.plugsity.com.request.CustomerInviteRequestDTO;
import com.plugsity.com.response.CustomerInviteResponseDTO;

public interface CustomerInviteService {

	List<CustomerInviteResponseDTO> getAllCustomers();

	List<CustomerInviteResponseDTO> getAllCustomers(String token);
	Map<String,Object> saveCustomerInvite(CustomerInviteRequestDTO customerInviteRequestDTO);
	CustomerInvite getCustomerInviteById(long id);
    void deleteCustomerInviteById(long id);
    List<Customer> findByEmailOrPhoneNumber(String email,String phoneNumber);
}
