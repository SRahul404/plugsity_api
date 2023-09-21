package com.plugsity.com.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.plugsity.com.request.GetInfoDTO;
import com.plugsity.com.response.BusinessUserInviteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.plugsity.com.request.BusinessUserDTO;
import com.plugsity.com.request.BusinessUserInviteDTO;
import com.plugsity.com.service.BusinessUserInviteService;
import com.plugsity.com.service.BusinessUserService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/plugisty/avi/v1")
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

	@GetMapping("/getInviteBusinessUsers")
	public List<BusinessUserInviteResponseDTO> getInvitedCustomers(@Valid @RequestBody GetInfoDTO getInfoDTO) {


		List<BusinessUserInviteResponseDTO> allBusinessUser = businessUserInviteService.getAllBusinessUser(getInfoDTO.getToken());

		return allBusinessUser;
	}

	@GetMapping("/allInviteBusinessUsers")
	public List<BusinessUserInviteResponseDTO> addInvitedCustomers() {


		List<BusinessUserInviteResponseDTO> allBusinessUser = businessUserInviteService.getAllBusinessUser();

		return allBusinessUser;
	}
}
