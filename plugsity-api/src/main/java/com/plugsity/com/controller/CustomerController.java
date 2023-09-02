package com.plugsity.com.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plugsity.com.request.BusinessUserDTO;
import com.plugsity.com.request.CustomerRequestDTO;
import com.plugsity.com.service.CustomerService;

@RestController
@RequestMapping("/plugisty/avi/v1/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Map<String,Object>> saveBusinessUser(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
		
		
		Map<String,Object> map = customerService.saveCustomer(customerRequestDTO);
		 
		return ResponseEntity.ok(map);
	}
}
