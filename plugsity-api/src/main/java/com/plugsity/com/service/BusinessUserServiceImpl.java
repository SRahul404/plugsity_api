package com.plugsity.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plugsity.com.model.BusinessUser;
import com.plugsity.com.repository.BusinessUserRepository;

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
	public void saveBusinessUser(BusinessUser businessUser) {
		// TODO Auto-generated method stub
		this.businessUserRepository.save(businessUser);
		
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

}
