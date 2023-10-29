package com.plugsity.com.service;

import java.util.List;
import java.util.Map;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.request.BusinessUserInviteDTO;
import com.plugsity.com.response.BusinessUserInviteResponseDTO;

public interface BusinessUserInviteService {

	List<BusinessUserInviteResponseDTO> getAllBusinessUser();
    List<BusinessUserInviteResponseDTO> getAllBusinessUser(String token);
	Map<String,Object> saveInviteBusinessUser(BusinessUserInviteDTO businessUserInviteDTO);
    BusinessUser getInviteBusinessUserById(long id);
    void deleteInviteBusinessUserById(long id);
    List<BusinessUser> findByBusinessNameOrEmailOrPhoneNumber(String businessName, String email,String phoneNumber);
    List<BusinessUser> findByBusinessNameOrPhoneNumber(String businessName, String phoneNumber);
    List<BusinessUser> findByBusinessNameOrEmail(String businessName, String email);
}
