package com.plugsity.com.serviceimpl;

import java.util.*;

import com.plugsity.com.response.CustomerInviteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.plugsity.com.model.Customer;
import com.plugsity.com.model.CustomerInvite;
import com.plugsity.com.repository.CustomerInviteRepository;
import com.plugsity.com.repository.CustomerRepository;
import com.plugsity.com.request.CustomerInviteRequestDTO;
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
	public List<CustomerInviteResponseDTO> getAllCustomers(String token) {

		List<CustomerInvite> customerInvites = new ArrayList<>();
		//Check the userRefKey exits or not
		Customer customer = customerRepository.findByCustomerToken(token);
		if(Objects.nonNull(customer))
		{
			customerInvites = customerInviteRepository.findByUserRefKey(token);
		}
		return populateCustomerInviteResponse(customerInvites);
	}

	@Override
	public Map<String, Object> saveCustomerInvite(CustomerInviteRequestDTO customerInviteRequestDTO) {
		// TODO Auto-generated method stub
		Map<String,Object> responseMap = new HashMap<>();
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		//Check the userRefKey exits or not
		Customer customer = customerRepository.findByCustomerToken(customerInviteRequestDTO.getUserRefKey());
		if(Objects.isNull(customer))
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

	private List<CustomerInviteResponseDTO> populateCustomerInviteResponse(List<CustomerInvite> customerInvites) {

		CustomerInviteResponseDTO customerInvite = null;
		List<CustomerInviteResponseDTO> inviteList = new ArrayList<>();

		if(!customerInvites.isEmpty()) {
			for (CustomerInvite invite : customerInvites) {

				customerInvite = new CustomerInviteResponseDTO();
				customerInvite.setFirstName(invite.getFirstName());
				customerInvite.setLastName(invite.getLastName());
				customerInvite.setEmail(invite.getEmail());
				customerInvite.setPhoneNumber(invite.getPhoneNumber());
				customerInvite.setRegisteredOn(invite.getCreatedTime());
				customerInvite.setZipCode(invite.getZipCode());
				inviteList.add(customerInvite);
			}
		}
		return inviteList;
	}
}
