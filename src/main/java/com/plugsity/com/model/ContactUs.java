package com.plugsity.com.model;

import com.plugsity.com.domain.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class ContactUs extends AbstractBaseEntity {

    @Column(name = "FirstName",nullable=false)
    private String firstName;

    @Column(name = "LastName",nullable=false)
    private String lastName;

    @Column(name = "Email",nullable=false)
    private String email;

    @Column(name = "Subject")
    private String subject;

    @Column(name = "Message",nullable=false)
    private String message;

    @Column(name = "status",nullable=false)
    private String status;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
