package com.plugsity.com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.MapsId;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.request.BusinessUserDTO;
import com.plugsity.com.service.BusinessUserService;

@RestController
@RequestMapping("/plugisty/avi/v1/")
public class BusinessUserController {

	@Autowired
	private BusinessUserService businessUserService;
	
	
	@PostMapping("/saveBusinessUser")
	public ResponseEntity<Map<String,Object>> saveBusinessUser(@Valid @RequestBody BusinessUserDTO businessUserDTO) {
		
		
		Map<String,Object> map = businessUserService.saveBusinessUser(businessUserDTO);
		 
		return ResponseEntity.ok(map);
	}
}
