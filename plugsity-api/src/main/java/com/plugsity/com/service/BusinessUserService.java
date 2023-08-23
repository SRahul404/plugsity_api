package com.plugsity.com.service;

import java.util.List;

import com.plugsity.com.model.BusinessUser;

public interface BusinessUserService {
	
	List<BusinessUser> getAllBusinessUser();
    void saveBusinessUser(BusinessUser businessUser);
    BusinessUser getBusinessUserById(long id);
    void deleteBusinessUserById(long id);

}
