package com.plugsity.com.repository;

import com.plugsity.com.model.ContactUs;
import com.plugsity.com.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {

    ContactUs findByEmail(String email);
}
