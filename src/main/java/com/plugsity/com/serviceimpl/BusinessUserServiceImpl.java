package com.plugsity.com.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.repository.BusinessUserRepository;
import com.plugsity.com.request.BusinessUserDTO;
import com.plugsity.com.response.BusinessUserResponseDTO;
import com.plugsity.com.service.BusinessUserService;

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
		Map<String,Object> responseMap = new HashMap<>();
		BusinessUserResponseDTO businessUserResponseDTO = new BusinessUserResponseDTO();
		List<BusinessUser> businessUsers = findByBusinessNameOrEmailOrPhoneNumber(businessUserDTO.getBusinessName(), businessUserDTO.getEmail(),businessUserDTO.getPhoneNumber());
		if(businessUsers.isEmpty())
		{
		BusinessUser businessUser =	populateBusinessUser(businessUserDTO);	
		this.businessUserRepository.save(businessUser);
		businessUserResponseDTO.setMessage("BusinessUser saved successfully");
		businessUserResponseDTO.setStatus(HttpStatus.OK.value());
		businessUserResponseDTO.setToken(businessUser.getToken());
		responseMap.put("Response", businessUserResponseDTO);
		}
		else {
			System.out.println("BusinessName and email already registered with us");
			businessUserResponseDTO.setMessage("BusinessName and email already registered with us");
			businessUserResponseDTO.setStatus(HttpStatus.FOUND.value());
			responseMap.put("Response", businessUserResponseDTO);
		}
		return responseMap;
		
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
		return businessUserRepository.findByBusinessNameOrEmail(name, brand);
	}

	@Override
	public List<BusinessUser> findByBusinessNameOrEmailOrPhoneNumber(String businessName, String email,
			String phoneNumber) {
		// TODO Auto-generated method stub
		return businessUserRepository.findByBusinessNameOrEmailOrPhoneNumber(businessName, email, phoneNumber);
	}

	private BusinessUser populateBusinessUser(BusinessUserDTO businessUserDTO)
	{
		BusinessUser businessUser = new BusinessUser();
		businessUser.setFirstName(businessUserDTO.getFirstName());
		businessUser.setLastName(businessUserDTO.getLastName());
		businessUser.setBusinessName(businessUserDTO.getBusinessName());
		businessUser.setEmail(businessUserDTO.getEmail());
		businessUser.setMessage(businessUserDTO.getMessage());
		businessUser.setPhoneNumber(businessUserDTO.getPhoneNumber());
		businessUser.setToken(UUID.randomUUID().toString());
		businessUser.setCountryCode(businessUserDTO.getCountryCode());
		businessUser.setCreatedBy("System"); 
		businessUser.setUpdatedBy("System");
		return businessUser;
	}
}
