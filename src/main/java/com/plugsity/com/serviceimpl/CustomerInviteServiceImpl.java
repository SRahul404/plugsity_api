package com.plugsity.com.serviceimpl;

import java.util.*;

import com.plugsity.com.common.CommonUtils;
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
	public List<CustomerInviteResponseDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		List<CustomerInvite> customerInvites;
		customerInvites = customerInviteRepository.findAll();
		return populateCustomerInviteResponse(customerInvites);
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

		if(customerInviteRequestDTO.getEmail()=="" && customerInviteRequestDTO.getPhoneNumber()=="")
		{
			System.out.println("Both email and phone numbers can't be blank.");
			customerResponseDTO.setMessage("Both email and phone numbers can't be blank.");
			customerResponseDTO.setStatus(HttpStatus.FOUND.value());
			responseMap.put("Response", customerResponseDTO);
			return responseMap;
		}

		if(customerInviteRequestDTO.getEmail()!="")
		{
			if(CommonUtils.isValid(customerInviteRequestDTO.getEmail())){
				System.out.println("correct email format");
			}else {
				System.out.println("incorrect email format");
				customerResponseDTO.setMessage("incorrect email format");
				customerResponseDTO.setStatus(HttpStatus.FOUND.value());
				responseMap.put("Response", customerResponseDTO);
				return responseMap;
			}
		}

		if(customerInviteRequestDTO.getPhoneNumber()!="")
		{
			if(CommonUtils.isValidPhoneNumber(customerInviteRequestDTO.getPhoneNumber())){
				System.out.println("correct phone number");
			}else {
				System.out.println("incorrect phone number");
				customerResponseDTO.setMessage("incorrect phone number");
				customerResponseDTO.setStatus(HttpStatus.FOUND.value());
				responseMap.put("Response", customerResponseDTO);
				return responseMap;
			}
		}

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
		//List<Customer> customers = findByEmailOrPhoneNumber(customerInviteRequestDTO.getEmail(),customerInviteRequestDTO.getPhoneNumber());
		List<Customer> customers = checkDuplicateCustomer(customerInviteRequestDTO);
		//Check duplicate for invited customer
		//CustomerInvite customerInviteCheck = customerInviteRepository.findByEmailOrPhoneNumber(customerInviteRequestDTO.getEmail(), customerInviteRequestDTO.getPhoneNumber());
		CustomerInvite customerInviteCheck = checkDuplicateInviteCustomer(customerInviteRequestDTO);
		if(customers.isEmpty() && Objects.isNull(customerInviteCheck))
		{
		CustomerInvite customerInvite =	populateCustomerInvite(customerInviteRequestDTO);
		this.customerInviteRepository.save(customerInvite);
		customerResponseDTO.setMessage("Customer invited successfully");
		customerResponseDTO.setStatus(HttpStatus.OK.value());
		responseMap.put("Response", customerResponseDTO);
		}
		else {
			System.out.println("Invited Customer name and email are already registered with us");
			customerResponseDTO.setMessage("Invited Customer name and email are already registered with us");
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
		customerInvite.setCountryCode(customerInviteRequestDTO.getCountryCode());
		//customerInvite.setZipCode(customerInviteRequestDTO.getZipCode());
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
				customerInvite.setTocken(invite.getUserRefKey());
				inviteList.add(customerInvite);
			}
		}
		return inviteList;
	}

	private CustomerInvite checkDuplicateInviteCustomer(CustomerInviteRequestDTO customerInviteRequestDTO)
	{
		CustomerInvite customerInvite = null;

		if(customerInviteRequestDTO.getPhoneNumber()!="" && customerInviteRequestDTO.getEmail()!="")
		{
			customerInvite = customerInviteRepository.findByEmailOrPhoneNumber(customerInviteRequestDTO.getEmail(),customerInviteRequestDTO.getPhoneNumber());
		}
		else if (customerInviteRequestDTO.getPhoneNumber()!="")
		{
			customerInvite = customerInviteRepository.findByPhoneNumber(customerInviteRequestDTO.getPhoneNumber());
		}
		else if (customerInviteRequestDTO.getEmail()!="")
		{
			customerInvite = customerInviteRepository.findByEmail(customerInviteRequestDTO.getEmail());
		}
		else
		{
			return null;
		}
		return customerInvite;
	}

	private List<Customer> checkDuplicateCustomer(CustomerInviteRequestDTO customerInviteRequestDTO){


		List<Customer> customers = new ArrayList<>();

		if(customerInviteRequestDTO.getPhoneNumber()!="" && customerInviteRequestDTO.getEmail()!="")
		{
			customers = customerRepository.findByEmailOrPhoneNumber(customerInviteRequestDTO.getEmail(),customerInviteRequestDTO.getPhoneNumber());
		}
		else if (customerInviteRequestDTO.getPhoneNumber()!="")
		{
			customers = customerRepository.findByPhoneNumber(customerInviteRequestDTO.getPhoneNumber());
		}
		else if (customerInviteRequestDTO.getEmail()!="")
		{
			customers = customerRepository.findByEmail(customerInviteRequestDTO.getEmail());
		}
		else
		{
			return customers;
		}
		return customers;
	}
}
