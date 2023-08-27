package com.plugsity.com.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.request.BusinessUserDTO;

public interface BusinessUserService {
	
	List<BusinessUser> getAllBusinessUser();
	Map<String,Object> saveBusinessUser(BusinessUserDTO businessUserDTO);
    BusinessUser getBusinessUserById(long id);
    void deleteBusinessUserById(long id);
    List<BusinessUser> findByBusinessNameAndEmail(String businessName, String email);
    List<BusinessUser> findByBusinessNameOrEmailOrPhoneNumber(String businessName, String email,String phoneNumber);

}
