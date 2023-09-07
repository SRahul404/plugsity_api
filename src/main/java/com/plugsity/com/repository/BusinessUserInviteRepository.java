package com.plugsity.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plugsity.com.model.BusinessUserInvite;

@Repository
public interface BusinessUserInviteRepository extends JpaRepository<BusinessUserInvite, Long> {

	BusinessUserInvite findByBusinessNameOrEmailOrPhoneNumber(String businessName, String email, String phoneNumber);
}
