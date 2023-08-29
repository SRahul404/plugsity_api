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
import com.plugsity.com.request.BusinessUserInviteDTO;
import com.plugsity.com.service.BusinessUserInviteService;
import com.plugsity.com.service.BusinessUserService;

@RestController
@RequestMapping("/plugisty/avi/v1/")
public class BusinessUserController {

	@Autowired
	private BusinessUserService businessUserService;
	@Autowired
	private BusinessUserInviteService businessUserInviteService;
	
	@PostMapping("/saveBusinessUser")
	public ResponseEntity<Map<String,Object>> saveBusinessUser(@Valid @RequestBody BusinessUserDTO businessUserDTO) {
		
		
		Map<String,Object> map = businessUserService.saveBusinessUser(businessUserDTO);
		 
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/inviteBusinessUser")
	public ResponseEntity<Map<String,Object>> inviteBusinessUser(@Valid @RequestBody BusinessUserInviteDTO businessUserInviteDTO) {
		
		
		Map<String,Object> map = businessUserInviteService.saveInviteBusinessUser(businessUserInviteDTO);
		 
		return ResponseEntity.ok(map);
	}
}
