package com.plugsity.com.service;

import java.util.List;
import java.util.Map;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.model.BusinessUserInvite;
import com.plugsity.com.request.BusinessUserDTO;
import com.plugsity.com.request.BusinessUserInviteDTO;

public interface BusinessUserInviteService {

	List<BusinessUserInviteService> getAllBusinessUser();
	Map<String,Object> saveInviteBusinessUser(BusinessUserInviteDTO businessUserInviteDTO);
    BusinessUser getInviteBusinessUserById(long id);
    void deleteInviteBusinessUserById(long id);
    List<BusinessUser> findByBusinessNameOrEmailOrPhoneNumber(String businessName, String email,String phoneNumber);
}
