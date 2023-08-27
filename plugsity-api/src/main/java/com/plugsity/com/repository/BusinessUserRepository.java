package com.plugsity.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plugsity.com.model.BusinessUser;
import java.util.List;

@Repository
public interface BusinessUserRepository extends JpaRepository<BusinessUser, Long>{
	
	List<BusinessUser> findByBusinessNameOrEmail(String businessName, String email);

	List<BusinessUser> findByBusinessNameOrEmailOrPhoneNumber(String businessName, String email,String phoneNumber);
	
	List<BusinessUser> findByToken(String token);
}
