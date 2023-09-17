package com.plugsity.com.service;

import com.plugsity.com.model.ContactUs;
import com.plugsity.com.request.ContactUsRequestDTO;
import com.plugsity.com.request.CustomerRequestDTO;

import java.util.Map;

public interface ContactUsService {

    Map<String,Object> saveContact(ContactUsRequestDTO contactUsRequestDTO);
    ContactUs findByEmail(String email);
}
