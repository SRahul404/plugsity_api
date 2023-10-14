package com.plugsity.com.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.plugsity.com.model.Customer;
import com.plugsity.com.repository.CustomerRepository;
import com.plugsity.com.request.CustomerRequestDTO;
import com.plugsity.com.response.CustomerResponseDTO;
import com.plugsity.com.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> saveCustomer(CustomerRequestDTO customerRequestDTO) {
		// TODO Auto-generated method stub
		Map<String,Object> responseMap = new HashMap<>();
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		List<Customer> customers = findByEmailOrPhoneNumber(customerRequestDTO.getEmail(), customerRequestDTO.getPhoneNumber());
		if(customers.isEmpty())
		{
		Customer customer =	populateCustomer(customerRequestDTO);	
		this.customerRepository.save(customer);
		customerResponseDTO.setMessage("Customer saved successfully");
		customerResponseDTO.setStatus(HttpStatus.OK.value());
		customerResponseDTO.setToken(customer.getCustomerToken());
		responseMap.put("Response", customerResponseDTO);
		}
		else {
			System.out.println("Customer email and phone number already registered with us");
			customerResponseDTO.setMessage("Customer email and phone number already registered with us");
			customerResponseDTO.setStatus(HttpStatus.FOUND.value());
			responseMap.put("Response", customerResponseDTO);
		}
		return responseMap;

	}

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomerById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> findByEmailOrPhoneNumber(String email, String phoneNumber) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmailOrPhoneNumber(email, phoneNumber);
	}

	private Customer populateCustomer(CustomerRequestDTO customerRequestDTO)
	{
		Customer customer = new Customer();
		customer.setFirstName(customerRequestDTO.getFirstName());
		customer.setLastName(customerRequestDTO.getLastName());
		customer.setEmail(customerRequestDTO.getEmail());
		customer.setMessage(customerRequestDTO.getMessage());
		customer.setPhoneNumber(customerRequestDTO.getPhoneNumber());
		customer.setCustomerToken(UUID.randomUUID().toString());
		customer.setCreatedBy("System"); 
		customer.setUpdatedBy("System");
		return customer;
	}
}
