package com.plugsity.com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.repository.BusinessUserRepository;
import com.plugsity.com.request.BusinessUserDTO;

@Service
public class BusinessUserServiceImpl implements BusinessUserService{

	@Autowired
	private BusinessUserRepository businessUserRepository;
	
	@Override
	public List<BusinessUser> getAllBusinessUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,Object> saveBusinessUser(BusinessUserDTO businessUserDTO) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		List<BusinessUser> businessUsers = findByBusinessNameAndEmail(businessUserDTO.getBusinessName(), businessUserDTO.getEmail());
		if(businessUsers.isEmpty())
		{
		BusinessUser businessUser = new BusinessUser();
		businessUser.setFristName(businessUserDTO.getFristName());
		businessUser.setLastName(businessUserDTO.getLastName());
		businessUser.setBusinessName(businessUserDTO.getBusinessName());
		businessUser.setEmail(businessUserDTO.getEmail());
		businessUser.setMessage(businessUserDTO.getMessage());
		businessUser.setToken(UUID.randomUUID().toString());
		businessUser.setCreatedBy("System"); 
		businessUser.setUpdatedBy("System");
		this.businessUserRepository.save(businessUser);
		map.put("Message", "BusinessUser saved successfully");
		map.put("Status", "200");
		map.put("Token", businessUser.getToken());
		}
		else {
			System.out.println("BusinessName and Eamil already registered with us");
			map.put("Message", "BusinessName and Eamil already registered with us");
			map.put("Status", "200");
		}
		return map;
		
	}

	@Override
	public BusinessUser getBusinessUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBusinessUserById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BusinessUser> findByBusinessNameAndEmail(String name, String brand) {
		// TODO Auto-generated method stub
		return businessUserRepository.findByBusinessNameAndEmail(name, brand);
	}

}
