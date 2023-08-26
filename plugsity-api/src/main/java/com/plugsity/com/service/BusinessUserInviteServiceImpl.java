package com.plugsity.com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.request.BusinessUserDTO;
import com.plugsity.com.request.BusinessUserInviteDTO;
import com.plugsity.com.response.BusinessUserResponseDTO;
import com.plugsity.com.repository.BusinessUserInviteRepository;
import com.plugsity.com.model.BusinessUserInvite;

@Service
public class BusinessUserInviteServiceImpl implements BusinessUserInviteService{

	@Autowired
	private BusinessUserInviteRepository businessUserInviteRepository;
	
	@Override
	public List<BusinessUserInviteService> getAllBusinessUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> saveInviteBusinessUser(BusinessUserInviteDTO businessUserInviteDTO) {
		// TODO Auto-generated method stub
		Map<String,Object> responseMap = new HashMap<>();
		BusinessUserResponseDTO businessUserResponseDTO = new BusinessUserResponseDTO();
		//List<BusinessUser> businessUsers = findByBusinessNameAndEmail(businessUserDTO.getBusinessName(), businessUserDTO.getEmail());
		if(true)
		{
		BusinessUserInvite businessUserInvite = new BusinessUserInvite();
		businessUserInvite.setBusinessName(businessUserInviteDTO.getBusinessName());
		businessUserInvite.setWebsite(businessUserInviteDTO.getWebsite());
		businessUserInvite.setEmail(businessUserInviteDTO.getEmail());
		businessUserInvite.setPhoneNumber(businessUserInviteDTO.getPhoneNumber());
		businessUserInvite.setAddress(businessUserInviteDTO.getAddress());
		businessUserInvite.setSocialMedia(businessUserInviteDTO.getSocialMedia());
		businessUserInvite.setToken(UUID.randomUUID().toString());
		businessUserInvite.setUserRefKey(businessUserInviteDTO.getUserRefKey());
		businessUserInvite.setCreatedBy("System"); 
		businessUserInvite.setUpdatedBy("System");
		this.businessUserInviteRepository.save(businessUserInvite);
		businessUserResponseDTO.setMessage("BusinessUser saved successfully");
		businessUserResponseDTO.setStatus(HttpStatus.OK.value());
		//businessUserResponseDTO.setToken(businessUserInvite.getToken());
		responseMap.put("Response", businessUserResponseDTO);
		}
		else {
			System.out.println("BusinessName and Eamil already registered with us");
			businessUserResponseDTO.setMessage("BusinessName and Eamil already registered with us");
			businessUserResponseDTO.setStatus(HttpStatus.FOUND.value());
			responseMap.put("Response", businessUserResponseDTO);
		}
		return responseMap;
	}

	@Override
	public BusinessUser getInviteBusinessUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInviteBusinessUserById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BusinessUserInviteService> findByBusinessNameAndEmail(String name, String brand) {
		// TODO Auto-generated method stub
		return null;
	}

}
