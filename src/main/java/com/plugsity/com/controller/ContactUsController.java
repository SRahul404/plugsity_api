package com.plugsity.com.controller;

import com.plugsity.com.request.ContactUsRequestDTO;
import com.plugsity.com.request.CustomerRequestDTO;
import com.plugsity.com.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/plugisty/avi/v1")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("/saveContactUs")
    public ResponseEntity<Map<String,Object>> saveBusinessUser(@Valid @RequestBody ContactUsRequestDTO contactUsRequestDTO) {


        Map<String,Object> map = contactUsService.saveContact(contactUsRequestDTO);

        return ResponseEntity.ok(map);
    }
}
