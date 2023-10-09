package com.plugsity.com.serviceimpl;

import java.util.*;

import com.plugsity.com.response.BusinessUserInviteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.request.BusinessUserInviteDTO;
import com.plugsity.com.response.BusinessUserResponseDTO;
import com.plugsity.com.service.BusinessUserInviteService;
import com.plugsity.com.repository.BusinessUserInviteRepository;
import com.plugsity.com.repository.BusinessUserRepository;
import com.plugsity.com.model.BusinessUserInvite;

@Service
public class BusinessUserInviteServiceImpl implements BusinessUserInviteService{

	@Autowired
	private BusinessUserInviteRepository businessUserInviteRepository;
	@Autowired
	private BusinessUserRepository businessUserRepository;
	
	@Override
	public List<BusinessUserInviteResponseDTO> getAllBusinessUser() {
		// TODO Auto-generated method stub
		List<BusinessUserInvite> businessUserInvites;
		businessUserInvites = businessUserInviteRepository.findAll();
		return populateBusinessUserInvite(businessUserInvites);
	}

	@Override
	public List<BusinessUserInviteResponseDTO> getAllBusinessUser(String token) {
		BusinessUser businessUser = businessUserRepository.findByToken(token);
		List<BusinessUserInvite> businessUserInvites = new ArrayList<>();
		if(Objects.nonNull(businessUser))
		{
			businessUserInvites = businessUserInviteRepository.findByUserRefKey(token);
		}
		return populateBusinessUserInvite(businessUserInvites);
	}

	@Override
	public Map<String, Object> saveInviteBusinessUser(BusinessUserInviteDTO businessUserInviteDTO) {
		// TODO Auto-generated method stub
		Map<String,Object> responseMap = new HashMap<>();
		BusinessUserResponseDTO businessUserResponseDTO = new BusinessUserResponseDTO();
		//Check the userRefKey exits or not
		BusinessUser businessUser = businessUserRepository.findByToken(businessUserInviteDTO.getUserRefKey());
		if(Objects.isNull(businessUser))
		{
			System.out.println("Invited BusinessName is not registered with us.");
			businessUserResponseDTO.setMessage("Invited BusinessName is not registered with us.");
			businessUserResponseDTO.setStatus(HttpStatus.FOUND.value());
			responseMap.put("Response", businessUserResponseDTO);
			return responseMap;
		}
		//Check the duplicate Business User
		List<BusinessUser> businessUsers = findByBusinessNameOrEmailOrPhoneNumber(businessUserInviteDTO.getBusinessName(), businessUserInviteDTO.getEmail(),businessUserInviteDTO.getPhoneNumber());
		// Check the duplicate Business User Invite
		BusinessUserInvite businessUserInviteRecord =  businessUserInviteRepository.findByBusinessNameOrEmailOrPhoneNumber(businessUserInviteDTO.getBusinessName(), businessUserInviteDTO.getEmail(),businessUserInviteDTO.getPhoneNumber());
		if(businessUsers.isEmpty() && Objects.isNull(businessUserInviteRecord))
		{
		BusinessUserInvite businessUserInvite =	populateBusinessUserInvite(businessUserInviteDTO);
		this.businessUserInviteRepository.save(businessUserInvite);
		businessUserResponseDTO.setMessage("BusinessUser invited successfully");
		businessUserResponseDTO.setStatus(HttpStatus.OK.value());
		responseMap.put("Response", businessUserResponseDTO);
		}
		else {
			System.out.println("Invited BusinessName and email already registered with us");
			businessUserResponseDTO.setMessage("Invited BusinessName and email already registered with us");
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
	public List<BusinessUser> findByBusinessNameOrEmailOrPhoneNumber(String businessName, String email,String phoneNumber) {
		// TODO Auto-generated method stub
		return businessUserRepository.findByBusinessNameOrEmailOrPhoneNumber(businessName, email, phoneNumber);
	}

	private BusinessUserInvite populateBusinessUserInvite(BusinessUserInviteDTO businessUserInviteDTO)
	{
		BusinessUserInvite businessUserInvite = new BusinessUserInvite();
		businessUserInvite.setBusinessName(businessUserInviteDTO.getBusinessName());
		businessUserInvite.setWebsite(businessUserInviteDTO.getWebsite());
		businessUserInvite.setEmail(businessUserInviteDTO.getEmail());
		businessUserInvite.setPhoneNumber(businessUserInviteDTO.getPhoneNumber());
		//businessUserInvite.setAddress(businessUserInviteDTO.getAddress());
		//businessUserInvite.setSocialMedia(businessUserInviteDTO.getSocialMedia());
		businessUserInvite.setToken(UUID.randomUUID().toString());
		businessUserInvite.setUserRefKey(businessUserInviteDTO.getUserRefKey());
		businessUserInvite.setCreatedBy("System"); 
		businessUserInvite.setUpdatedBy("System");
		return businessUserInvite;
	}

	private List<BusinessUserInviteResponseDTO> populateBusinessUserInvite(List<BusinessUserInvite> inviteList)
	{
		BusinessUserInviteResponseDTO businessUserInvite = null;
		List<BusinessUserInviteResponseDTO> responseDTOS = new ArrayList<>();
		if(!inviteList.isEmpty()) {
			for (BusinessUserInvite invite : inviteList) {
				businessUserInvite = new BusinessUserInviteResponseDTO();
				businessUserInvite.setBusinessName(invite.getBusinessName());
				businessUserInvite.setWebsite(invite.getWebsite());
				businessUserInvite.setEmail(invite.getEmail());
				businessUserInvite.setPhoneNumber(invite.getPhoneNumber());
				businessUserInvite.setAddress(invite.getAddress());
				businessUserInvite.setSocialMedia(invite.getSocialMedia());
				businessUserInvite.setRegisteredOn(invite.getCreatedTime());
				businessUserInvite.setToken(invite.getUserRefKey());
				responseDTOS.add(businessUserInvite);
			}
		}
		return responseDTOS;
	}
}
