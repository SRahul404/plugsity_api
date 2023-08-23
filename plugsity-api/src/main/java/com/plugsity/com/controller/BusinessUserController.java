package com.plugsity.com.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.service.BusinessUserService;

@ResponseBody
@Controller
public class BusinessUserController {

	@Autowired
	private BusinessUserService businessUserService;
	
	 @PostMapping("/saveBusinessUser")
	    public String saveBusinessUser() {
	        // save businessUser to database
		 BusinessUser businessUser = new BusinessUser();
		 businessUser.setBusinessName("ABC GROUP");
		 businessUser.setEmail("test@gmail.com");
		 businessUser.setFristName("Test1");
		 businessUser.setLastName("test2");
		 businessUser.setPhoneNumber("1234567890");
		 businessUser.setMessage("testing");
		 businessUser.setToken(UUID.randomUUID().toString());
		 businessUser.setCreatedBy("System");
		 businessUser.setUpdatedBy("System");
		 businessUserService.saveBusinessUser(businessUser);
	     return "BusinessUser saved successfully";
	    }
}
