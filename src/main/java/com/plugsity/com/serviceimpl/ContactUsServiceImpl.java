package com.plugsity.com.serviceimpl;

import com.plugsity.com.model.ContactUs;
import com.plugsity.com.repository.ContactUsRepository;
import com.plugsity.com.request.ContactUsRequestDTO;
import com.plugsity.com.response.CustomerResponseDTO;
import com.plugsity.com.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public Map<String, Object> saveContact(ContactUsRequestDTO contactUsRequestDTO) {
        Map<String,Object> responseMap = new HashMap<>();
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        ContactUs contactUsDetails = findByEmail(contactUsRequestDTO.getEmail());

        if(!Calculate48Hours(contactUsDetails))
        {
            ContactUs contactUs =	populateContactUs(contactUsRequestDTO);
            this.contactUsRepository.save(contactUs);
            customerResponseDTO.setMessage("Details saved successfully");
            customerResponseDTO.setStatus(HttpStatus.OK.value());
            responseMap.put("Response", customerResponseDTO);
        }
        else {
            System.out.println("Only ContactUs after 48 hours");
            customerResponseDTO.setMessage("Only ContactUs after 48 hours");
            customerResponseDTO.setStatus(HttpStatus.FOUND.value());
            responseMap.put("Response", customerResponseDTO);
        }
        return responseMap;
    }

    @Override
    public ContactUs findByEmail(String email) {
        return contactUsRepository.findByEmail(email);
    }

    private ContactUs populateContactUs(ContactUsRequestDTO contactUsRequestDTO)
    {
        ContactUs contactUs = new ContactUs();
        contactUs.setFirstName(contactUsRequestDTO.getFirstName());
        contactUs.setLastName(contactUsRequestDTO.getLastName());
        contactUs.setEmail(contactUsRequestDTO.getEmail());
        contactUs.setSubject(contactUsRequestDTO.getSubject());
        contactUs.setMessage(contactUsRequestDTO.getMessage());
        contactUs.setCreatedBy("System");
        contactUs.setUpdatedBy("System");
        return contactUs;
    }

    private boolean Calculate48Hours(ContactUs contactUs)
    {
        if(contactUs!=null) {
            long millisIn48Hours = 1000 * 60 * 60 * 48;
            Date insertedTime = contactUs.getUpdatedTime();
            Date hours48ago = new Date(insertedTime.getTime() + millisIn48Hours);
            Date currentTime = new Date();
            if(currentTime.before(hours48ago)) {
                return true;
            }
        }
        return false;
    }
}
