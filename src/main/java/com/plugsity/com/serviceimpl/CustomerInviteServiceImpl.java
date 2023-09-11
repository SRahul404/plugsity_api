package com.plugsity.com.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.model.BusinessUserInvite;
import com.plugsity.com.model.Customer;
import com.plugsity.com.model.CustomerInvite;
import com.plugsity.com.repository.CustomerInviteRepository;
import com.plugsity.com.repository.CustomerRepository;
import com.plugsity.com.request.CustomerInviteRequestDTO;
import com.plugsity.com.response.BusinessUserResponseDTO;
import com.plugsity.com.response.CustomerResponseDTO;
import com.plugsity.com.service.CustomerInviteService;

@Service
public class CustomerInviteServiceImpl implements CustomerInviteService{

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerInviteRepository customerInviteRepository;
	
	@Override
	public List<CustomerInvite> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> saveCustomerInvite(CustomerInviteRequestDTO customerInviteRequestDTO) {
		// TODO Auto-generated method stub
		Map<String,Object> responseMap = new HashMap<>();
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		//Check the userRefKey exits or not
		List<Customer> customerRefKey = customerRepository.findByCustomerToken(customerInviteRequestDTO.getUserRefKey());
		if(customerRefKey.isEmpty())
		{
			System.out.println("Invited Customer is not registered with us.");
			customerResponseDTO.setMessage("Invited Customer is not registered with us.");
			customerResponseDTO.setStatus(HttpStatus.FOUND.value());
			responseMap.put("Response", customerResponseDTO);
			return responseMap;
		}
		//Check the duplicate Customer
		List<Customer> customers = findByEmailOrPhoneNumber(customerInviteRequestDTO.getEmail(),customerInviteRequestDTO.getPhoneNumber());
		//Check duplicate for invited customer
		CustomerInvite customerInviteCheck = customerInviteRepository.findByEmailOrPhoneNumber(customerInviteRequestDTO.getEmail(), customerInviteRequestDTO.getPhoneNumber());
		if(customers.isEmpty() && Objects.isNull(customerInviteCheck))
		{
		CustomerInvite customerInvite =	populateCustomerInvite(customerInviteRequestDTO);
		this.customerInviteRepository.save(customerInvite);
		customerResponseDTO.setMessage("Customer invited successfully");
		customerResponseDTO.setStatus(HttpStatus.OK.value());
		responseMap.put("Response", customerResponseDTO);
		}
		else {
			System.out.println("Invited Customer name and email already registered with us");
			customerResponseDTO.setMessage("Invited Customer name and email already registered with us");
			customerResponseDTO.setStatus(HttpStatus.FOUND.value());
			responseMap.put("Response", customerResponseDTO);
		}
		return responseMap;
	}

	@Override
	public CustomerInvite getCustomerInviteById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomerInviteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> findByEmailOrPhoneNumber(String email, String phoneNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmailOrPhoneNumber(email, phoneNumber);
	}

	private CustomerInvite populateCustomerInvite(CustomerInviteRequestDTO customerInviteRequestDTO) {
		
		CustomerInvite customerInvite = new CustomerInvite();
		customerInvite.setFirstName(customerInviteRequestDTO.getFirstName());
		customerInvite.setLastName(customerInviteRequestDTO.getLastName());
		customerInvite.setEmail(customerInviteRequestDTO.getEmail());
		customerInvite.setPhoneNumber(customerInviteRequestDTO.getPhoneNumber());
		customerInvite.setUserRefKey(customerInviteRequestDTO.getUserRefKey());
		customerInvite.setToken(UUID.randomUUID().toString());
		customerInvite.setZipCode(customerInviteRequestDTO.getZipCode());
		customerInvite.setCreatedBy("System"); 
		customerInvite.setUpdatedBy("System");
		return customerInvite;
	}
}
