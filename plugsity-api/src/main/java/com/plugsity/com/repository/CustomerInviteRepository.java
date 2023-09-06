package com.plugsity.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plugsity.com.model.CustomerInvite;

@Repository
public interface CustomerInviteRepository extends JpaRepository<CustomerInvite, Long> {

	CustomerInvite findByEmailOrPhoneNumber(String email,String phoneNumber);
	
}
