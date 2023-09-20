package com.plugsity.com.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.plugsity.com.request.GetInfoDTO;
import com.plugsity.com.response.CustomerInviteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.plugsity.com.request.CustomerInviteRequestDTO;
import com.plugsity.com.request.CustomerRequestDTO;
import com.plugsity.com.service.CustomerInviteService;
import com.plugsity.com.service.CustomerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/plugisty/avi/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerInviteService customerInviteService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Map<String,Object>> saveBusinessUser(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
		
		
		Map<String,Object> map = customerService.saveCustomer(customerRequestDTO);
		 
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/inviteCustomer")
	public ResponseEntity<Map<String,Object>> inviteCustomer(@Valid @RequestBody CustomerInviteRequestDTO customerInviteRequestDTO) {
		
		
		Map<String,Object> map = customerInviteService.saveCustomerInvite(customerInviteRequestDTO);
		 
		return ResponseEntity.ok(map);
	}

	@GetMapping("/getInvitedCustomers")
	public List<CustomerInviteResponseDTO> getInvitedCustomers(@Valid @RequestBody GetInfoDTO getInfoDTO) {


		List<CustomerInviteResponseDTO> allCustomers = customerInviteService.getAllCustomers(getInfoDTO.getToken());

		return allCustomers;
	}
}
