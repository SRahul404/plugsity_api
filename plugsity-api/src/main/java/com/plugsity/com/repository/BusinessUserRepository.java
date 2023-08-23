package com.plugsity.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plugsity.com.model.BusinessUser;

@Repository
public interface BusinessUserRepository extends JpaRepository<BusinessUser, Long>{

}
